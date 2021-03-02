package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.ExportRuntimeException;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class EncoderWriter {
    public static final int OUTPUT_AUDIO_AAC_PROFILE = 2;
    public static final int OUTPUT_AUDIO_BIT_RATE = 128000;
    public static final int OUTPUT_AUDIO_CHANNEL_COUNT = 1;
    public static final String OUTPUT_AUDIO_MIME_TYPE = "audio/mp4a-latm";
    public static final int OUTPUT_AUDIO_SAMPLE_RATE_HZ = 44100;
    public static final int OUTPUT_VIDEO_BIT_RATE = 8000000;
    public static final int OUTPUT_VIDEO_COLOR_FORMAT = 2130708361;
    public static final int OUTPUT_VIDEO_FRAME_RATE = 30;
    public static final int OUTPUT_VIDEO_IFRAME_INTERVAL = 1;
    public static final String OUTPUT_VIDEO_MIME_TYPE = "video/avc";
    private static final String TAG = "EncoderWriter";
    private static final long WAIT_TRANSIENT_MS = 20;
    public static final long WRITER_FINISH = -1;
    private Surface _inputSurface;
    private volatile MediaCodec.BufferInfo audioBufferInfo;
    private volatile MediaFormat audioEncodeFormat;
    private MediaCodec audioEncoder;
    private Lock audioEncoderLock;
    private boolean audioEncoderStarted;
    private long audioPresentationTimeUs;
    private boolean enOfAudioInputStream;
    private boolean enOfVideoInputStream;
    private ExportConfig encodeOption;
    private boolean hasAudioTrack;
    private boolean hasVideoTrack;
    private ReadWriteLock lock;
    private IMediaMuxer muxer;
    private volatile boolean muxerStarted;
    private volatile int outputAudioTrack;
    private volatile int outputVideoTrack;
    private boolean released;
    private volatile MediaCodec.BufferInfo videoBufferInfo;
    private volatile MediaFormat videoEncodeFormat;
    private AssetWriterVideoEncoder videoEncoder;
    private Lock videoEncoderLock;
    private boolean videoEncoderStarted;

    @Deprecated
    public static final class OutputConfig {
        public int AUDIO_AAC_PROFILE = 2;
        public int AUDIO_BIT_RATE = EncoderWriter.OUTPUT_AUDIO_BIT_RATE;
        public int AUDIO_CHANNEL_COUNT = 1;
        public String AUDIO_MIME_TYPE = EncoderWriter.OUTPUT_AUDIO_MIME_TYPE;
        public int AUDIO_SAMPLE_RATE_HZ = 44100;
        public boolean HIGH_PROFILE = false;
        public int VIDEO_BIT_RATE = 8000000;
        public int VIDEO_FRAME_RATE = 30;
        public int VIDEO_IFRAME_INTERVAL = 1;
        public int VIDEO_TARGET_HEIGHT = 0;
        public int VIDEO_TARGET_WIDTH = 0;
    }

    public EncoderWriter(String str, AssetWriterVideoEncoder assetWriterVideoEncoder) {
        AppMethodBeat.i(218162);
        this.hasVideoTrack = false;
        this.hasAudioTrack = false;
        this.enOfVideoInputStream = false;
        this.enOfAudioInputStream = false;
        this.videoEncoderLock = new ReentrantLock();
        this.audioEncoderLock = new ReentrantLock();
        this.lock = new ReentrantReadWriteLock();
        this._inputSurface = null;
        this.videoBufferInfo = new MediaCodec.BufferInfo();
        this.audioBufferInfo = new MediaCodec.BufferInfo();
        this.videoEncodeFormat = null;
        this.audioEncodeFormat = null;
        this.outputVideoTrack = -1;
        this.outputAudioTrack = -1;
        this.muxerStarted = false;
        this.videoEncoderStarted = false;
        this.audioEncoderStarted = false;
        this.released = false;
        this.muxer = MediaMuxerFactory.createMediaMuxer(str, 0);
        this.videoEncoder = assetWriterVideoEncoder == null ? new MediaCodecAssetWriterVideoEncoder() : assetWriterVideoEncoder;
        this.videoEncoder.setMediaMuxer(this.muxer);
        AppMethodBeat.o(218162);
    }

    public EncoderWriter(String str) {
        this(str, null);
    }

    public synchronized Surface createInputSurface() {
        Surface surface;
        AppMethodBeat.i(218163);
        if (this._inputSurface == null && this.hasVideoTrack) {
            this._inputSurface = this.videoEncoder.createInputSurface();
        }
        surface = this._inputSurface;
        AppMethodBeat.o(218163);
        return surface;
    }

    public int getOutWidth() {
        AppMethodBeat.i(218164);
        int i2 = (int) this.videoEncoder.getEncodeSize().width;
        AppMethodBeat.o(218164);
        return i2;
    }

    public int getOutHeight() {
        AppMethodBeat.i(218165);
        int i2 = (int) this.videoEncoder.getEncodeSize().height;
        AppMethodBeat.o(218165);
        return i2;
    }

    public long getAudioPresentationTimeUs() {
        return this.audioPresentationTimeUs;
    }

    public long getVideoPresentationTimeUs() {
        AppMethodBeat.i(218166);
        long encodePresentationTimeUs = this.videoEncoder.getEncodePresentationTimeUs();
        AppMethodBeat.o(218166);
        return encodePresentationTimeUs;
    }

    public void setEncodeOption(ExportConfig exportConfig) {
        AppMethodBeat.i(218167);
        if (exportConfig.getOutputWidth() <= 0 || exportConfig.getOutputHeight() <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("width and height must > 0");
            AppMethodBeat.o(218167);
            throw illegalArgumentException;
        }
        this.encodeOption = exportConfig.clone();
        this.muxer.setExportConfig(exportConfig);
        AppMethodBeat.o(218167);
    }

    public synchronized void startVideoEncoder() {
        AppMethodBeat.i(218168);
        try {
            this.videoEncoderLock.lock();
            Logger.d(TAG, "AssetWriter startVideoEncoder ".concat(String.valueOf(this)));
            prepareVideoEncoder(this.encodeOption);
            this.hasVideoTrack = true;
            createInputSurface();
            this.videoEncoder.start();
            this.videoEncoderStarted = true;
        } finally {
            this.videoEncoderLock.unlock();
            AppMethodBeat.o(218168);
        }
    }

    public synchronized void startAudioEncoder() {
        AppMethodBeat.i(218169);
        try {
            this.audioEncoderLock.lock();
            Logger.d(TAG, "AssetWriter startAudioEncoder ".concat(String.valueOf(this)));
            prepareAudioEncoder(this.encodeOption);
            this.hasAudioTrack = true;
            this.audioEncoder.start();
            this.audioEncoderStarted = true;
        } finally {
            this.audioEncoderLock.unlock();
            AppMethodBeat.o(218169);
        }
    }

    public boolean isVideoEncodeNeedVideoRenderOutputTexture() {
        AppMethodBeat.i(218170);
        boolean isNeedVideoOutputTexture = this.videoEncoder.isNeedVideoOutputTexture();
        AppMethodBeat.o(218170);
        return isNeedVideoOutputTexture;
    }

    public void inputVideoSampleTexture(TextureInfo textureInfo) {
        AppMethodBeat.i(218171);
        this.videoEncoder.inputVideoTexture(textureInfo);
        AppMethodBeat.o(218171);
    }

    private void prepareVideoEncoder(ExportConfig exportConfig) {
        AppMethodBeat.i(218172);
        MediaFormat videoFormat = exportConfig.getVideoFormat();
        fixVideoFormat(videoFormat);
        this.videoEncoder.prepare(exportConfig, videoFormat);
        AppMethodBeat.o(218172);
    }

    private void prepareAudioEncoder(ExportConfig exportConfig) {
        AppMethodBeat.i(218173);
        Logger.d(TAG, "AssetWriter prepareAudioEncoder ".concat(String.valueOf(this)));
        MediaFormat audioFormat = exportConfig.getAudioFormat();
        fixAudioFormat(audioFormat);
        Logger.i(TAG, "prepareAudioEncoder, input mediaFormat:" + audioFormat + ", isAudioEncodeNeedCodecSpecificData:" + exportConfig.isAudioEncodeNeedCodecSpecificData());
        if (exportConfig.isAudioEncodeNeedCodecSpecificData()) {
            int integer = audioFormat.getInteger("aac-profile");
            int integer2 = audioFormat.getInteger("sample-rate");
            int integer3 = audioFormat.getInteger("channel-count");
            Logger.i(TAG, "try set adts csd-0 data, profile:" + integer + ", sampleRate:" + integer2 + ", " + integer3);
            audioFormat.setByteBuffer("csd-0", ADTSUtils.getADTSCodecSpecificData(integer, integer2, integer3));
        }
        try {
            Logger.i(TAG, "prepareAudioEncoder: format = ".concat(String.valueOf(audioFormat)));
            this.audioEncoder = MediaCodec.createEncoderByType(OUTPUT_AUDIO_MIME_TYPE);
            this.audioEncoder.configure(audioFormat, (Surface) null, (MediaCrypto) null, 1);
            AppMethodBeat.o(218173);
        } catch (Exception e2) {
            ExportRuntimeException exportRuntimeException = new ExportRuntimeException(new ExportErrorStatus(-104, e2, audioFormat.toString()));
            AppMethodBeat.o(218173);
            throw exportRuntimeException;
        }
    }

    private void fixVideoFormat(MediaFormat mediaFormat) {
        AppMethodBeat.i(218174);
        mediaFormat.setInteger("color-format", OUTPUT_VIDEO_COLOR_FORMAT);
        fixStringKey(mediaFormat, "mime", "video/avc");
        fixIntegerKey(mediaFormat, FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, 8000000);
        fixIntegerKey(mediaFormat, "frame-rate", 30);
        fixIntegerKey(mediaFormat, "i-frame-interval", 1);
        Logger.d(TAG, "fixVideoFormat() called with: format = [" + mediaFormat + "]");
        AppMethodBeat.o(218174);
    }

    private void fixAudioFormat(MediaFormat mediaFormat) {
        AppMethodBeat.i(218175);
        fixStringKey(mediaFormat, "mime", OUTPUT_AUDIO_MIME_TYPE);
        fixIntegerKey(mediaFormat, "sample-rate", 44100);
        fixIntegerKey(mediaFormat, "channel-count", 1);
        fixIntegerKey(mediaFormat, FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, OUTPUT_AUDIO_BIT_RATE);
        fixIntegerKey(mediaFormat, "aac-profile", 2);
        Logger.d(TAG, "fixAudioFormat() called with: format = [" + mediaFormat + "]");
        AppMethodBeat.o(218175);
    }

    private void fixIntegerKey(MediaFormat mediaFormat, String str, int i2) {
        AppMethodBeat.i(218176);
        if (!mediaFormat.containsKey(str) || mediaFormat.getInteger(str) <= 0) {
            Logger.w(TAG, "fixIntegerKey: 缺少关键配置：" + str + ", 使用默认值：" + i2);
            mediaFormat.setInteger(str, i2);
        }
        AppMethodBeat.o(218176);
    }

    private void fixStringKey(MediaFormat mediaFormat, String str, String str2) {
        AppMethodBeat.i(218177);
        if (!mediaFormat.containsKey(str) || TextUtils.isEmpty(mediaFormat.getString(str))) {
            Logger.w(TAG, "fixStringKey: 缺少关键配置：" + str + ", 使用默认值：" + str2);
            mediaFormat.setString(str, str2);
        }
        AppMethodBeat.o(218177);
    }

    public boolean videoTrackWritable() {
        boolean z = true;
        if (!this.hasVideoTrack || (!this.muxerStarted && this.videoEncodeFormat != null)) {
            synchronized (this) {
                if (!this.hasVideoTrack || (!this.muxerStarted && this.videoEncodeFormat != null)) {
                    z = false;
                }
            }
        }
        return z;
    }

    public void writeVideoSample(CMSampleBuffer cMSampleBuffer) {
        AppMethodBeat.i(218178);
        Logger.i(TAG, "writeVideoSample");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.lock.readLock().lock();
            if (this._inputSurface != null) {
                drainEncoder(false, cMSampleBuffer);
                if (!cMSampleBuffer.getState().isInvalid()) {
                    this.muxer.writeSampleDataTime(true, cMSampleBuffer.getTime());
                }
                this.lock.readLock().unlock();
                Logger.i(TAG, "writeVideoSample finish cost " + (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(218178);
            }
        } finally {
            this.lock.readLock().unlock();
            Logger.i(TAG, "writeVideoSample finish cost " + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(218178);
        }
    }

    public void setVideoSampleRenderContext(RenderContext renderContext) {
        AppMethodBeat.i(218179);
        this.videoEncoder.setVideoSampleRenderContext(renderContext);
        AppMethodBeat.o(218179);
    }

    public void endWriteVideoSample(CMSampleBuffer cMSampleBuffer) {
        AppMethodBeat.i(218180);
        Logger.d(TAG, "endWriteVideoSample: ");
        try {
            this.lock.readLock().lock();
            if (!this.released) {
                if (this._inputSurface == null || this.enOfVideoInputStream) {
                    this.lock.readLock().unlock();
                    AppMethodBeat.o(218180);
                    return;
                }
                try {
                    this.videoEncoder.signalEndOfInputStream();
                    this.enOfVideoInputStream = true;
                } catch (Throwable th) {
                    Logger.e(TAG, "endWriteVideoSample failed", th);
                }
                drainEncoder(false, cMSampleBuffer);
                this.lock.readLock().unlock();
                AppMethodBeat.o(218180);
            }
        } finally {
            this.lock.readLock().unlock();
            AppMethodBeat.o(218180);
        }
    }

    private void signalEndOfVideoStream() {
        AppMethodBeat.i(218181);
        Logger.d(TAG, "signalEndOfVideoStream: ");
        if (this._inputSurface == null || this.enOfVideoInputStream) {
            AppMethodBeat.o(218181);
            return;
        }
        try {
            this.videoEncoder.signalEndOfInputStream();
            this.enOfVideoInputStream = true;
            AppMethodBeat.o(218181);
        } catch (Throwable th) {
            Logger.e(TAG, "signalEndOfVideoStream failed", th);
            AppMethodBeat.o(218181);
        }
    }

    public void endWriteAudioSample() {
        AppMethodBeat.i(218182);
        Logger.d(TAG, "endWriteAudioSample:".concat(String.valueOf(this)));
        try {
            this.lock.readLock().lock();
            if (!this.released && !this.enOfAudioInputStream) {
                Logger.d(TAG, "endWriteAudioSample: ");
                try {
                    int dequeueInputBuffer = dequeueInputBuffer(this.audioEncoder);
                    if (dequeueInputBuffer >= 0) {
                        queueInputBuffer(this.audioEncoder, dequeueInputBuffer, 0, 0, 0, 4);
                        this.enOfAudioInputStream = true;
                    }
                } catch (Throwable th) {
                    Logger.e(TAG, "endWriteAudioSample failed", th);
                }
                drainEncoder(false, null);
                this.lock.readLock().unlock();
                AppMethodBeat.o(218182);
            }
        } finally {
            this.lock.readLock().unlock();
            AppMethodBeat.o(218182);
        }
    }

    private void signalEndOfAudioStream() {
        AppMethodBeat.i(218183);
        try {
            if (this.enOfAudioInputStream) {
                AppMethodBeat.o(218183);
                return;
            }
            Logger.d(TAG, "signalEndOfAudioStream: ");
            int dequeueInputBuffer = dequeueInputBuffer(this.audioEncoder);
            if (dequeueInputBuffer >= 0) {
                queueInputBuffer(this.audioEncoder, dequeueInputBuffer, 0, 0, 0, 4);
                this.enOfAudioInputStream = true;
            }
            AppMethodBeat.o(218183);
        } catch (Throwable th) {
            Logger.e(TAG, "signalEndOfAudioStream failed", th);
            AppMethodBeat.o(218183);
        }
    }

    public boolean audioTrackWritable() {
        boolean z = true;
        if (!this.hasAudioTrack || (!this.muxerStarted && this.audioEncodeFormat != null)) {
            synchronized (this) {
                if (!this.hasAudioTrack || (!this.muxerStarted && this.audioEncodeFormat != null)) {
                    z = false;
                }
            }
        }
        return z;
    }

    public void writeAudioSample(long j2, ByteBuffer byteBuffer) {
        long j3;
        int i2;
        AppMethodBeat.i(218184);
        Logger.e(TAG, "writeAudioSample: " + j2 + "  " + byteBuffer.limit());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.lock.readLock().lock();
            Logger.v(TAG, "writeAudioSample: " + j2 + "  " + (byteBuffer != null ? Integer.valueOf(byteBuffer.limit()) : BuildConfig.COMMAND));
            if (byteBuffer == null || this.released) {
                this.lock.readLock().unlock();
                Logger.e(TAG, "writeAudioSample finish cost " + (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(218184);
                return;
            }
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            long j4 = 0;
            while (position < limit && !this.released) {
                try {
                    this.audioEncoderLock.lock();
                    int dequeueInputBuffer = dequeueInputBuffer(this.audioEncoder);
                    if (dequeueInputBuffer >= 0) {
                        ByteBuffer inputBuffer = getInputBuffer(this.audioEncoder, dequeueInputBuffer);
                        int min = Math.min(limit - position, inputBuffer.capacity());
                        byteBuffer.limit(position + min);
                        byteBuffer.position(position);
                        inputBuffer.put(byteBuffer);
                        queueInputBuffer(this.audioEncoder, dequeueInputBuffer, 0, min, j2 + j4, 0);
                        i2 = position + min;
                        j3 = DecoderUtils.getAudioDuration((long) min, this.encodeOption.getAudioChannelCount(), this.encodeOption.getAudioSampleRateHz()) + j4;
                    } else {
                        j3 = j4;
                        i2 = position;
                    }
                    this.audioEncoderLock.unlock();
                    drainEncoder(false, null);
                    j4 = j3;
                    position = i2;
                } catch (Throwable th) {
                    this.audioEncoderLock.unlock();
                    AppMethodBeat.o(218184);
                    throw th;
                }
            }
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            this.lock.readLock().unlock();
            Logger.e(TAG, "writeAudioSample finish cost " + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(218184);
        } catch (Throwable th2) {
            this.lock.readLock().unlock();
            Logger.e(TAG, "writeAudioSample finish cost " + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(218184);
            throw th2;
        }
    }

    private void drainEncoder(boolean z, CMSampleBuffer cMSampleBuffer) {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(218185);
        boolean z4 = false;
        boolean z5 = false;
        if (z) {
            if (this.hasVideoTrack) {
                if (this._inputSurface == null) {
                    z4 = true;
                } else {
                    signalEndOfVideoStream();
                }
            }
            z5 = this.hasAudioTrack;
        }
        boolean z6 = !this.hasVideoTrack;
        boolean z7 = !this.hasAudioTrack;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z8 = z6;
        boolean z9 = z4;
        while (true) {
            if ((z8 || !this.hasVideoTrack) && (z7 || !this.hasAudioTrack)) {
                AppMethodBeat.o(218185);
            } else {
                if (z9) {
                    signalEndOfVideoStream();
                    z9 = false;
                }
                if (!z8) {
                    boolean writeVideoFrame = writeVideoFrame(cMSampleBuffer, z);
                    if (System.currentTimeMillis() - currentTimeMillis > 2000) {
                        this.hasVideoTrack = !z;
                        Logger.e(TAG, "drainEncoder: 视频写入处理时间超时，提前结束写入");
                        z8 = true;
                    } else {
                        z8 = writeVideoFrame;
                    }
                }
                if (z5) {
                    signalEndOfAudioStream();
                    z2 = false;
                } else {
                    z2 = z5;
                }
                if (!z7) {
                    z3 = writeAudioFrame(z);
                    if (System.currentTimeMillis() - currentTimeMillis > 2000) {
                        this.hasAudioTrack = !z;
                        Logger.e(TAG, "drainEncoder: 音频写入处理时间超时，提前结束写入");
                        z3 = true;
                    }
                } else {
                    z3 = z7;
                }
                if (unStarted()) {
                    synchronized (this) {
                        try {
                            if (unStarted()) {
                                if (this.hasVideoTrack) {
                                    this.outputVideoTrack = this.muxer.addTrack(this.videoEncodeFormat);
                                }
                                if (this.hasAudioTrack) {
                                    this.outputAudioTrack = this.muxer.addTrack(this.audioEncodeFormat);
                                }
                                this.muxer.start();
                                this.muxerStarted = true;
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(218185);
                            throw th;
                        }
                    }
                    z7 = z3;
                    z5 = z2;
                } else {
                    z7 = z3;
                    z5 = z2;
                }
            }
        }
        AppMethodBeat.o(218185);
    }

    private boolean unStarted() {
        return !this.muxerStarted && (!this.hasVideoTrack || this.videoEncodeFormat != null) && (!this.hasAudioTrack || this.audioEncodeFormat != null);
    }

    private boolean writeVideoFrame(CMSampleBuffer cMSampleBuffer, boolean z) {
        AppMethodBeat.i(218186);
        try {
            this.videoEncoderLock.lock();
            boolean writeVideoSample = this.videoEncoder.writeVideoSample(cMSampleBuffer, z);
            this.videoEncodeFormat = this.videoEncoder.getEncodeFormat();
            if (this.videoEncoder.isEncodeToEndOfStream()) {
                this.hasVideoTrack = false;
            }
            this.videoEncoderLock.unlock();
            AppMethodBeat.o(218186);
            return writeVideoSample;
        } catch (Throwable th) {
            this.videoEncoderLock.unlock();
            AppMethodBeat.o(218186);
            throw th;
        }
    }

    private int dequeueOutputBuffer(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(218187);
        while (true) {
            try {
                int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 1000);
                AppMethodBeat.o(218187);
                return dequeueOutputBuffer;
            } catch (Exception e2) {
                Logger.e(TAG, "dequeueOutputBuffer e = ", e2);
                if (Build.VERSION.SDK_INT < 21 || !(e2 instanceof MediaCodec.CodecException)) {
                    break;
                }
                if (23 <= Build.VERSION.SDK_INT) {
                    Logger.e(TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e2).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e2).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e2).getErrorCode());
                }
                if (!((MediaCodec.CodecException) e2).isTransient()) {
                    break;
                }
                waitTime(WAIT_TRANSIENT_MS);
                AppMethodBeat.o(218187);
                throw e2;
            }
        }
        AppMethodBeat.o(218187);
        throw e2;
    }

    private int dequeueInputBuffer(MediaCodec mediaCodec) {
        AppMethodBeat.i(218188);
        while (true) {
            try {
                int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(1000);
                AppMethodBeat.o(218188);
                return dequeueInputBuffer;
            } catch (Error | Exception e2) {
                Logger.e(TAG, "dequeueInputBuffer e = ", e2);
                if (21 > Build.VERSION.SDK_INT || !(e2 instanceof MediaCodec.CodecException)) {
                    break;
                }
                if (23 <= Build.VERSION.SDK_INT) {
                    Logger.e(TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e2).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e2).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e2).getErrorCode());
                }
                if (!((MediaCodec.CodecException) e2).isTransient()) {
                    break;
                }
                waitTime(WAIT_TRANSIENT_MS);
                AppMethodBeat.o(218188);
                throw e2;
            }
        }
        AppMethodBeat.o(218188);
        throw e2;
    }

    private ByteBuffer getInputBuffer(MediaCodec mediaCodec, int i2) {
        AppMethodBeat.i(218189);
        while (true) {
            try {
                ByteBuffer inputBuffer = DecoderUtils.getInputBuffer(mediaCodec, i2);
                AppMethodBeat.o(218189);
                return inputBuffer;
            } catch (Error | Exception e2) {
                Logger.e(TAG, "getInputBuffer", e2);
                if (Build.VERSION.SDK_INT < 21 || !(e2 instanceof MediaCodec.CodecException)) {
                    break;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    Logger.e(TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e2).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e2).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e2).getErrorCode());
                }
                if (!((MediaCodec.CodecException) e2).isTransient()) {
                    break;
                }
                waitTime(WAIT_TRANSIENT_MS);
                AppMethodBeat.o(218189);
                throw e2;
            }
        }
        AppMethodBeat.o(218189);
        throw e2;
    }

    private ByteBuffer getOutputBuffer(MediaCodec mediaCodec, int i2) {
        AppMethodBeat.i(218190);
        while (true) {
            try {
                ByteBuffer outputBuffer = DecoderUtils.getOutputBuffer(mediaCodec, i2);
                AppMethodBeat.o(218190);
                return outputBuffer;
            } catch (Error | Exception e2) {
                Logger.e(TAG, "getOutputBuffer", e2);
                if (Build.VERSION.SDK_INT < 21 || !(e2 instanceof MediaCodec.CodecException)) {
                    break;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    Logger.e(TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e2).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e2).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e2).getErrorCode());
                }
                if (!((MediaCodec.CodecException) e2).isTransient()) {
                    break;
                }
                waitTime(WAIT_TRANSIENT_MS);
                AppMethodBeat.o(218190);
                throw e2;
            }
        }
        AppMethodBeat.o(218190);
        throw e2;
    }

    private void releaseOutputBuffer(MediaCodec mediaCodec, int i2, boolean z) {
        AppMethodBeat.i(218191);
        try {
            mediaCodec.releaseOutputBuffer(i2, z);
            AppMethodBeat.o(218191);
        } catch (Error | Exception e2) {
            Logger.e(TAG, "releaseOutputBuffer", e2);
            if (Build.VERSION.SDK_INT >= 21 && (e2 instanceof MediaCodec.CodecException)) {
                if (Build.VERSION.SDK_INT >= 23) {
                    Logger.e(TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e2).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e2).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e2).getErrorCode());
                }
                if (((MediaCodec.CodecException) e2).isTransient()) {
                    waitTime(WAIT_TRANSIENT_MS);
                    releaseOutputBuffer(mediaCodec, i2, z);
                }
            }
            AppMethodBeat.o(218191);
            throw e2;
        }
    }

    private void queueInputBuffer(MediaCodec mediaCodec, int i2, int i3, int i4, long j2, int i5) {
        AppMethodBeat.i(218192);
        try {
            mediaCodec.queueInputBuffer(i2, i3, i4, j2, i5);
            AppMethodBeat.o(218192);
        } catch (Error | Exception e2) {
            Logger.e(TAG, "queueInputBuffer", e2);
            if (Build.VERSION.SDK_INT >= 21 && (e2 instanceof MediaCodec.CodecException)) {
                if (Build.VERSION.SDK_INT >= 23) {
                    Logger.e(TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e2).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e2).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e2).getErrorCode());
                }
                if (((MediaCodec.CodecException) e2).isTransient()) {
                    waitTime(WAIT_TRANSIENT_MS);
                    queueInputBuffer(mediaCodec, i2, i3, i4, j2, i5);
                }
            }
            AppMethodBeat.o(218192);
            throw e2;
        }
    }

    private void waitTime(long j2) {
        AppMethodBeat.i(218193);
        try {
            wait(j2);
            AppMethodBeat.o(218193);
        } catch (InterruptedException e2) {
            AppMethodBeat.o(218193);
        }
    }

    private boolean validAndCorrectBufferInfo(MediaCodec.BufferInfo bufferInfo) {
        return bufferInfo.size > 0 && (bufferInfo.flags & 4) == 0;
    }

    private boolean writeAudioFrame(boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(218194);
        try {
            this.audioEncoderLock.lock();
            if (this.muxerStarted || this.audioEncodeFormat == null) {
                int dequeueOutputBuffer = dequeueOutputBuffer(this.audioEncoder, this.audioBufferInfo);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        z2 = true;
                    }
                } else if (dequeueOutputBuffer == -2) {
                    this.audioEncodeFormat = this.audioEncoder.getOutputFormat();
                } else if (dequeueOutputBuffer >= 0) {
                    ByteBuffer outputBuffer = getOutputBuffer(this.audioEncoder, dequeueOutputBuffer);
                    if ((this.audioBufferInfo.flags & 2) != 0) {
                        this.audioBufferInfo.size = 0;
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        outputBuffer.position(this.audioBufferInfo.offset);
                        outputBuffer.limit(this.audioBufferInfo.offset + this.audioBufferInfo.size);
                    }
                    if (validAndCorrectBufferInfo(this.audioBufferInfo) && this.muxerStarted) {
                        try {
                            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                            bufferInfo.set(this.audioBufferInfo.offset, this.audioBufferInfo.size, this.audioBufferInfo.presentationTimeUs, this.audioBufferInfo.flags);
                            if (this.audioBufferInfo.presentationTimeUs >= 0) {
                                this.muxer.writeSampleDataTime(false, CMTime.fromSeconds((float) this.audioBufferInfo.presentationTimeUs));
                            }
                            this.muxer.writeSampleData(this.outputAudioTrack, outputBuffer, bufferInfo);
                            Logger.v(TAG, "writeAudioFrame:  " + this.audioBufferInfo.presentationTimeUs);
                            this.audioPresentationTimeUs = this.audioBufferInfo.presentationTimeUs;
                        } catch (Exception e2) {
                            Logger.e(TAG, "writeAudioFrame: ", e2);
                        }
                    }
                    releaseOutputBuffer(this.audioEncoder, dequeueOutputBuffer, false);
                    if ((this.audioBufferInfo.flags & 4) != 0) {
                        Logger.i(TAG, "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM");
                        this.audioPresentationTimeUs = -1;
                        this.hasAudioTrack = false;
                        z2 = true;
                    }
                }
            } else if (!z) {
                z2 = true;
            }
            return z2;
        } finally {
            this.audioEncoderLock.unlock();
            AppMethodBeat.o(218194);
        }
    }

    public void stop() {
        AppMethodBeat.i(218195);
        Logger.i(TAG, "AssetWriter stop ".concat(String.valueOf(this)));
        if (this.released) {
            AppMethodBeat.o(218195);
        } else if (this.videoEncoderStarted || this.audioEncoderStarted) {
            this.videoEncoderStarted = false;
            this.audioEncoderStarted = false;
            drainEncoder(true, null);
            release();
            AppMethodBeat.o(218195);
        } else {
            AppMethodBeat.o(218195);
        }
    }

    private void release() {
        AppMethodBeat.i(218196);
        this.released = true;
        Logger.i(TAG, "AssetWriter release: ".concat(String.valueOf(this)));
        try {
            this.lock.writeLock().lock();
            Logger.d(TAG, "AssetWriter release ".concat(String.valueOf(this)));
            if (this.videoEncoder != null) {
                try {
                    this.videoEncoder.stop();
                } catch (Exception e2) {
                    Logger.e(TAG, "release: videoEncoder.stop()", e2);
                }
                try {
                    this.videoEncoder.release();
                } catch (Exception e3) {
                    Logger.e(TAG, "release: videoEncoder.release()", e3);
                }
                this.videoEncoder = null;
            }
            if (this.audioEncoder != null) {
                try {
                    this.audioEncoder.stop();
                } catch (Exception e4) {
                    Logger.e(TAG, "release: audioEncoder.stop()", e4);
                }
                try {
                    this.audioEncoder.release();
                } catch (Exception e5) {
                    Logger.e(TAG, "release: audioEncoder.release()", e5);
                }
                this.audioEncoder = null;
            }
            if (this.muxer != null) {
                if (this.muxerStarted) {
                    this.muxerStarted = false;
                    try {
                        this.muxer.stop();
                    } catch (Exception e6) {
                        Logger.e(TAG, "release: muxer.stop()", e6);
                    }
                }
                try {
                    this.muxer.release();
                } catch (Exception e7) {
                    Logger.e(TAG, "release: muxer.release()", e7);
                }
                this.muxer = null;
            }
        } finally {
            this.lock.writeLock().unlock();
            AppMethodBeat.o(218196);
        }
    }
}
