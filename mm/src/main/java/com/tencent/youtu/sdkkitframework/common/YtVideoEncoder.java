package com.tencent.youtu.sdkkitframework.common;

import android.graphics.Bitmap;
import android.graphics.YuvImage;
import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

public class YtVideoEncoder {
    private static final int AUDIO_CHANNEL_NUM = 1;
    private static final int BIT_RATE = 16000000;
    private static final int FRAME_RATE = 30;
    private static final int I_FRAME_INTERVAL = 1;
    private static final String MIME_TYPE = "video/avc";
    private static final String TAG = YtVideoEncoder.class.getSimpleName();
    private static int mHeight;
    private static int mWidth;
    private int addedTrackCount = 0;
    private boolean audioEncodeFinished = false;
    private ConcurrentLinkedQueue<byte[]> audioEncodeQueue = new ConcurrentLinkedQueue<>();
    private Thread audioEncodeThread;
    private MediaCodec audioEncoder;
    private int audioGenerateIndex = 0;
    private AudioRecord audioRecord = null;
    private int audioSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_8000;
    private int audioTrackIndex;
    private int colorFormat = 21;
    private boolean isEncodingStarted = false;
    private boolean isMediaMuxerStarted = false;
    private boolean mAbort = false;
    private IYUVToVideoEncoderCallback mCallback;
    private final Object mFrameSync = new Object();
    private boolean mNeedWork = false;
    private CountDownLatch mNewFrameLatch;
    private boolean mNoMoreFrames = false;
    private File mOutputFile;
    private ConcurrentLinkedQueue<MediaData> mediaDataQueue = new ConcurrentLinkedQueue<>();
    private MediaMuxer mediaMuxer;
    private final Object mediaMuxerSync = new Object();
    private int minAudioBufferSize = 0;
    private boolean needAudio = false;
    private int realColorFormat = 0;
    private MediaCodec videoEncoder;
    private int videoGenerateIndex = 0;
    private int videoTrackIndex;
    private ConcurrentLinkedQueue<YuvImage> vidoeEncodeQueue = new ConcurrentLinkedQueue<>();
    private byte[] yuvnv12;

    public interface IYUVToVideoEncoderCallback {
        void onEncodingComplete(File file);
    }

    static /* synthetic */ void access$000(YtVideoEncoder ytVideoEncoder) {
        AppMethodBeat.i(192627);
        ytVideoEncoder.onAudioStart();
        AppMethodBeat.o(192627);
    }

    static {
        AppMethodBeat.i(192628);
        AppMethodBeat.o(192628);
    }

    /* access modifiers changed from: package-private */
    public enum MediaType {
        VideoType,
        AudioType;

        public static MediaType valueOf(String str) {
            AppMethodBeat.i(192603);
            MediaType mediaType = (MediaType) Enum.valueOf(MediaType.class, str);
            AppMethodBeat.o(192603);
            return mediaType;
        }

        static {
            AppMethodBeat.i(192604);
            AppMethodBeat.o(192604);
        }
    }

    class MediaData {
        MediaCodec.BufferInfo bufferInfo;
        ByteBuffer byteBuffer;
        int index = 0;
        int trackIndex;

        public MediaData(int i2, int i3, ByteBuffer byteBuffer2, MediaCodec.BufferInfo bufferInfo2) {
            this.index = i2;
            this.trackIndex = i3;
            this.byteBuffer = byteBuffer2;
            this.bufferInfo = bufferInfo2;
        }
    }

    public YtVideoEncoder(IYUVToVideoEncoderCallback iYUVToVideoEncoderCallback, boolean z) {
        AppMethodBeat.i(192605);
        this.mCallback = iYUVToVideoEncoderCallback;
        this.mNeedWork = z;
        AppMethodBeat.o(192605);
    }

    public boolean isEncodingStarted() {
        return this.isEncodingStarted;
    }

    public int getYUVImageSize() {
        AppMethodBeat.i(192606);
        int size = this.vidoeEncodeQueue.size();
        AppMethodBeat.o(192606);
        return size;
    }

    public int getColorFormat() {
        return this.realColorFormat;
    }

    private void startAudioEncoding(int i2, int i3) {
        AppMethodBeat.i(192607);
        if (!this.mNeedWork) {
            AppMethodBeat.o(192607);
            return;
        }
        this.needAudio = true;
        try {
            this.audioEncoder = MediaCodec.createEncoderByType(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE);
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE, i3, 1);
            createAudioFormat.setInteger("aac-profile", 2);
            createAudioFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i2);
            createAudioFormat.setInteger("max-input-size", 16384);
            this.audioSampleRate = i3;
            this.audioEncoder.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            this.isEncodingStarted = true;
            startAudioRecord();
            this.audioEncodeThread = new Thread(new Runnable() {
                /* class com.tencent.youtu.sdkkitframework.common.YtVideoEncoder.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(192600);
                    YtVideoEncoder.access$000(YtVideoEncoder.this);
                    AppMethodBeat.o(192600);
                }
            });
            this.audioEncodeThread.start();
            AppMethodBeat.o(192607);
        } catch (IOException e2) {
            AppMethodBeat.o(192607);
        }
    }

    private void startAudioRecord() {
        AppMethodBeat.i(192608);
        new Thread(new Runnable() {
            /* class com.tencent.youtu.sdkkitframework.common.YtVideoEncoder.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(192601);
                YtVideoEncoder.this.minAudioBufferSize = AudioRecord.getMinBufferSize(YtVideoEncoder.this.audioSampleRate, 16, 2);
                int min = Math.min(16384, YtVideoEncoder.this.minAudioBufferSize * 2);
                YtVideoEncoder.this.audioRecord = new AudioRecord(1, YtVideoEncoder.this.audioSampleRate, 16, 2, min);
                YtLogger.i(YtVideoEncoder.TAG, "Audio recorder init :" + YtVideoEncoder.this.audioRecord.getState());
                byte[] bArr = new byte[2048];
                YtVideoEncoder.this.audioRecord.startRecording();
                while (!YtVideoEncoder.this.audioEncodeFinished) {
                    if (YtVideoEncoder.this.audioRecord.read(bArr, 0, 2048) > 0) {
                        YtVideoEncoder.this.encodeAudioData(bArr);
                    }
                }
                YtLogger.d(YtVideoEncoder.TAG, "Audio push last buffer");
                YtVideoEncoder.this.audioRecord.stop();
                YtVideoEncoder.this.audioRecord.release();
                YtVideoEncoder.this.audioRecord = null;
                AppMethodBeat.o(192601);
            }
        }).start();
        AppMethodBeat.o(192608);
    }

    private void onAudioStart() {
        ByteBuffer outputBuffer;
        AppMethodBeat.i(192609);
        this.audioEncoder.start();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        long j2 = 0;
        long j3 = 0;
        this.audioEncodeFinished = false;
        while (true) {
            long j4 = j2;
            while (!this.audioEncodeFinished) {
                byte[] poll = this.audioEncodeQueue.poll();
                if (poll == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e2) {
                        YtLogger.e(TAG, e2.getLocalizedMessage());
                    }
                } else {
                    int dequeueInputBuffer = this.audioEncoder.dequeueInputBuffer(10000);
                    if (dequeueInputBuffer >= 0) {
                        ByteBuffer inputBuffer = getInputBuffer(MediaType.AudioType, dequeueInputBuffer);
                        inputBuffer.clear();
                        inputBuffer.limit(poll.length);
                        inputBuffer.put(poll);
                        long length = ((long) poll.length) + j4;
                        if (this.isEncodingStarted) {
                            this.audioEncoder.queueInputBuffer(dequeueInputBuffer, 0, poll.length, j3, 0);
                        } else {
                            YtLogger.d(TAG, "End of audio stream");
                            this.audioEncodeFinished = true;
                            this.audioEncoder.queueInputBuffer(dequeueInputBuffer, 0, poll.length, j3, 4);
                        }
                        j3 = ((TimeUtil.SECOND_TO_US * (length / 1)) / ((long) this.audioSampleRate)) / 2;
                        this.audioGenerateIndex++;
                        j2 = length;
                    } else {
                        j2 = j4;
                    }
                    int dequeueOutputBuffer = this.audioEncoder.dequeueOutputBuffer(bufferInfo, 10000);
                    if (dequeueOutputBuffer == -2) {
                        startMediaMuxer(MediaType.AudioType, this.audioEncoder.getOutputFormat());
                        j4 = j2;
                    } else if (dequeueOutputBuffer != -1 && dequeueOutputBuffer >= 0 && bufferInfo.size != 0 && (outputBuffer = getOutputBuffer(MediaType.AudioType, dequeueOutputBuffer)) != null) {
                        outputBuffer.position(bufferInfo.offset);
                        outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                        YtLogger.d(TAG, "media muxer write audio data outputindex " + this.audioGenerateIndex + " buff size:" + bufferInfo.size);
                        synchronized (this.mediaMuxer) {
                            try {
                                this.mediaMuxer.writeSampleData(this.audioTrackIndex, outputBuffer, bufferInfo);
                            } catch (Throwable th) {
                                AppMethodBeat.o(192609);
                                throw th;
                            }
                        }
                        this.audioEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                        j4 = j2;
                    }
                }
            }
            YtLogger.d(TAG, "Audio encoder stop");
            AppMethodBeat.o(192609);
            return;
        }
    }

    public void encodeAudioData(byte[] bArr) {
        AppMethodBeat.i(192610);
        this.audioEncodeQueue.add(bArr);
        AppMethodBeat.o(192610);
    }

    public void startAudioVideoEncoding(int i2, int i3, File file, int i4, int i5, int i6, int i7, int i8) {
        AppMethodBeat.i(192611);
        try {
            file.delete();
            String canonicalPath = file.getCanonicalPath();
            if (this.mediaMuxer == null) {
                this.mediaMuxer = new MediaMuxer(canonicalPath, 0);
            }
            startAudioEncoding(i8, i7);
            startEncoding(i2, i3, file, i4, i5, i6);
            try {
                Thread.sleep(300);
                AppMethodBeat.o(192611);
            } catch (InterruptedException e2) {
                AppMethodBeat.o(192611);
            }
        } catch (IOException e3) {
            YtLogger.e(TAG, "Unable to get path for ".concat(String.valueOf(file)));
            AppMethodBeat.o(192611);
        }
    }

    public void startEncoding(int i2, int i3, File file, int i4, int i5, int i6) {
        AppMethodBeat.i(192612);
        if (!this.mNeedWork) {
            AppMethodBeat.o(192612);
            return;
        }
        mWidth = i2;
        mHeight = i3;
        this.mOutputFile = file;
        try {
            String canonicalPath = file.getCanonicalPath();
            if (this.mediaMuxer == null) {
                this.mediaMuxer = new MediaMuxer(canonicalPath, 0);
            }
            MediaCodecInfo selectCodec = selectCodec("video/avc");
            if (selectCodec == null) {
                YtLogger.e(TAG, "Unable to find an appropriate codec for video/avc");
                AppMethodBeat.o(192612);
                return;
            }
            YtLogger.i(TAG, "found codec: " + selectCodec.getName());
            this.colorFormat = 21;
            try {
                int selectColorFormat = selectColorFormat(selectCodec, "video/avc");
                this.colorFormat = selectColorFormat;
                this.realColorFormat = selectColorFormat;
            } catch (Exception e2) {
                this.colorFormat = 21;
            }
            try {
                this.videoEncoder = MediaCodec.createByCodecName(selectCodec.getName());
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", mWidth, mHeight);
                createVideoFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i4);
                createVideoFormat.setInteger("frame-rate", i5);
                createVideoFormat.setInteger("color-format", this.colorFormat);
                createVideoFormat.setInteger("i-frame-interval", i6);
                this.videoEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.videoEncoder.start();
                YtLogger.i(TAG, "Initialization complete. Starting encoder...");
                this.isEncodingStarted = true;
                AppMethodBeat.o(192612);
            } catch (Exception e3) {
                YtLogger.e(TAG, "Unable to create MediaCodec " + e3.getMessage());
                AppMethodBeat.o(192612);
            }
        } catch (IOException e4) {
            YtLogger.e(TAG, "Unable to get path for ".concat(String.valueOf(file)));
            AppMethodBeat.o(192612);
        }
    }

    public void stopEncoding() {
        AppMethodBeat.i(192613);
        this.isEncodingStarted = false;
        if (!this.mNeedWork) {
            AppMethodBeat.o(192613);
        } else if (this.videoEncoder == null || this.mediaMuxer == null) {
            AppMethodBeat.o(192613);
        } else {
            YtLogger.i(TAG, "Stopping encoding");
            this.mNoMoreFrames = true;
            synchronized (this.mFrameSync) {
                try {
                    if (this.mNewFrameLatch != null && this.mNewFrameLatch.getCount() > 0) {
                        this.mNewFrameLatch.countDown();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(192613);
                    throw th;
                }
            }
            release();
            AppMethodBeat.o(192613);
        }
    }

    public void abortEncoding() {
        AppMethodBeat.i(192614);
        this.isEncodingStarted = false;
        if (this.mOutputFile != null) {
            YtLogger.d(TAG, "Clean up record file");
            this.mOutputFile.delete();
            this.mOutputFile = null;
        }
        if (!this.mNeedWork) {
            AppMethodBeat.o(192614);
        } else if (this.videoEncoder == null || this.mediaMuxer == null) {
            YtLogger.i(TAG, "Failed to abort encoding since it never started");
            AppMethodBeat.o(192614);
        } else {
            YtLogger.i(TAG, "Aborting encoding");
            this.mNoMoreFrames = true;
            this.mAbort = true;
            this.vidoeEncodeQueue = new ConcurrentLinkedQueue<>();
            this.audioEncodeQueue = new ConcurrentLinkedQueue<>();
            synchronized (this.mFrameSync) {
                try {
                    if (this.mNewFrameLatch != null && this.mNewFrameLatch.getCount() > 0) {
                        this.mNewFrameLatch.countDown();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(192614);
                    throw th;
                }
            }
            release();
            AppMethodBeat.o(192614);
        }
    }

    public void queueFrame(YuvImage yuvImage) {
        AppMethodBeat.i(192615);
        if (!this.mNeedWork) {
            AppMethodBeat.o(192615);
        } else if (this.videoEncoder == null || this.mediaMuxer == null) {
            AppMethodBeat.o(192615);
        } else {
            YtLogger.d(TAG, "Queueing frame");
            this.vidoeEncodeQueue.add(yuvImage);
            synchronized (this.mFrameSync) {
                try {
                    if (this.mNewFrameLatch != null && this.mNewFrameLatch.getCount() > 0) {
                        this.mNewFrameLatch.countDown();
                    }
                } finally {
                    AppMethodBeat.o(192615);
                }
            }
        }
    }

    public void encode() {
        AppMethodBeat.i(192616);
        if (!this.mNeedWork) {
            AppMethodBeat.o(192616);
        } else if (!this.isEncodingStarted) {
            AppMethodBeat.o(192616);
        } else {
            YtLogger.d(TAG, "Encoder started");
            if (!this.mNoMoreFrames || this.vidoeEncodeQueue.size() != 0) {
                YuvImage poll = this.vidoeEncodeQueue.poll();
                if (poll == null) {
                    synchronized (this.mFrameSync) {
                        try {
                            this.mNewFrameLatch = new CountDownLatch(1);
                        } catch (Throwable th) {
                            AppMethodBeat.o(192616);
                            throw th;
                        }
                    }
                    try {
                        this.mNewFrameLatch.await();
                    } catch (InterruptedException e2) {
                    }
                    poll = this.vidoeEncodeQueue.poll();
                }
                if (poll == null) {
                    AppMethodBeat.o(192616);
                    return;
                }
                byte[] convertYUV = convertYUV(mWidth, mHeight, poll);
                int dequeueInputBuffer = this.videoEncoder.dequeueInputBuffer(200000);
                long computePresentationTime = computePresentationTime((long) this.videoGenerateIndex, 30);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer inputBuffer = getInputBuffer(MediaType.VideoType, dequeueInputBuffer);
                    inputBuffer.clear();
                    inputBuffer.put(convertYUV);
                    this.videoEncoder.queueInputBuffer(dequeueInputBuffer, 0, convertYUV.length, computePresentationTime, 0);
                    this.videoGenerateIndex++;
                }
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int dequeueOutputBuffer = this.videoEncoder.dequeueOutputBuffer(bufferInfo, 200000);
                if (dequeueOutputBuffer == -1) {
                    YtLogger.e(TAG, "No output from encoder available");
                    AppMethodBeat.o(192616);
                } else if (dequeueOutputBuffer == -2) {
                    startMediaMuxer(MediaType.VideoType, this.videoEncoder.getOutputFormat());
                    AppMethodBeat.o(192616);
                } else if (dequeueOutputBuffer < 0) {
                    YtLogger.e(TAG, "unexpected result from encoder.dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)));
                    AppMethodBeat.o(192616);
                } else {
                    if (bufferInfo.size != 0) {
                        ByteBuffer outputBuffer = getOutputBuffer(MediaType.VideoType, dequeueOutputBuffer);
                        if (outputBuffer == null) {
                            YtLogger.e(TAG, "encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                            AppMethodBeat.o(192616);
                            return;
                        }
                        outputBuffer.position(bufferInfo.offset);
                        outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                        YtLogger.d(TAG, "media muxer write video data outputindex " + this.videoGenerateIndex);
                        synchronized (this.mediaMuxer) {
                            try {
                                this.mediaMuxer.writeSampleData(this.videoTrackIndex, outputBuffer, bufferInfo);
                            } finally {
                                AppMethodBeat.o(192616);
                            }
                        }
                        this.videoEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    }
                }
            } else {
                AppMethodBeat.o(192616);
            }
        }
    }

    private ByteBuffer getInputBuffer(MediaType mediaType, int i2) {
        AppMethodBeat.i(192617);
        if (Build.VERSION.SDK_INT >= 21) {
            if (mediaType == MediaType.VideoType) {
                ByteBuffer inputBuffer = this.videoEncoder.getInputBuffer(i2);
                AppMethodBeat.o(192617);
                return inputBuffer;
            }
            ByteBuffer inputBuffer2 = this.audioEncoder.getInputBuffer(i2);
            AppMethodBeat.o(192617);
            return inputBuffer2;
        } else if (mediaType == MediaType.VideoType) {
            ByteBuffer byteBuffer = this.videoEncoder.getInputBuffers()[i2];
            AppMethodBeat.o(192617);
            return byteBuffer;
        } else {
            ByteBuffer byteBuffer2 = this.audioEncoder.getInputBuffers()[i2];
            AppMethodBeat.o(192617);
            return byteBuffer2;
        }
    }

    private ByteBuffer getOutputBuffer(MediaType mediaType, int i2) {
        AppMethodBeat.i(192618);
        if (Build.VERSION.SDK_INT >= 21) {
            if (mediaType == MediaType.VideoType) {
                ByteBuffer outputBuffer = this.videoEncoder.getOutputBuffer(i2);
                AppMethodBeat.o(192618);
                return outputBuffer;
            }
            ByteBuffer outputBuffer2 = this.audioEncoder.getOutputBuffer(i2);
            AppMethodBeat.o(192618);
            return outputBuffer2;
        } else if (mediaType == MediaType.VideoType) {
            ByteBuffer byteBuffer = this.videoEncoder.getOutputBuffers()[i2];
            AppMethodBeat.o(192618);
            return byteBuffer;
        } else {
            ByteBuffer byteBuffer2 = this.audioEncoder.getOutputBuffers()[i2];
            AppMethodBeat.o(192618);
            return byteBuffer2;
        }
    }

    private void release() {
        AppMethodBeat.i(192619);
        synchronized (this.mediaMuxerSync) {
            try {
                if (this.videoEncoder != null) {
                    this.videoEncoder.stop();
                    this.videoEncoder.release();
                    this.videoEncoder = null;
                    YtLogger.d(TAG, "RELEASE Video CODEC");
                }
                if (this.audioEncoder != null) {
                    try {
                        this.audioEncodeThread.join();
                    } catch (InterruptedException e2) {
                        YtLogger.e(TAG, e2.getLocalizedMessage());
                    }
                    this.audioEncoder.stop();
                    this.audioEncoder.release();
                    this.audioEncoder = null;
                    YtLogger.d(TAG, "RELEASE Audio CODEC");
                }
                if (this.mediaMuxer != null) {
                    try {
                        this.mediaMuxer.stop();
                    } catch (Exception e3) {
                        YtLogger.e(TAG, "media muxer stop failed:" + e3.getLocalizedMessage());
                    }
                    this.mediaMuxer.release();
                    this.mediaMuxer = null;
                    this.isMediaMuxerStarted = false;
                    YtLogger.d(TAG, "RELEASE MUXER");
                }
            } finally {
                AppMethodBeat.o(192619);
            }
        }
    }

    private static MediaCodecInfo selectCodec(String str) {
        String[] supportedTypes;
        AppMethodBeat.i(192620);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        AppMethodBeat.o(192620);
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(192620);
        return null;
    }

    private static int selectColorFormat(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.i(192621);
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        for (int i2 = 0; i2 < capabilitiesForType.colorFormats.length; i2++) {
            int i3 = capabilitiesForType.colorFormats[i2];
            YtLogger.d(TAG, "found colorformat: ".concat(String.valueOf(i3)));
            if (isRecognizedFormat(i3)) {
                AppMethodBeat.o(192621);
                return i3;
            }
        }
        AppMethodBeat.o(192621);
        return 0;
    }

    private static boolean isRecognizedFormat(int i2) {
        switch (i2) {
            case 19:
            case 20:
            case 21:
            case 39:
            case 2130706688:
                return true;
            default:
                return false;
        }
    }

    private byte[] convertYUV(int i2, int i3, YuvImage yuvImage) {
        AppMethodBeat.i(192622);
        if (this.colorFormat == 21) {
            byte[] NV12ToNV21 = NV12ToNV21(i2, i3, yuvImage);
            AppMethodBeat.o(192622);
            return NV12ToNV21;
        }
        byte[] I420ToNV21 = I420ToNV21(i2, i3, yuvImage);
        AppMethodBeat.o(192622);
        return I420ToNV21;
    }

    private byte[] NV12ToNV21(int i2, int i3, YuvImage yuvImage) {
        AppMethodBeat.i(192623);
        if (this.yuvnv12 == null) {
            this.yuvnv12 = new byte[(((i2 * i3) * 3) / 2)];
        }
        byte[] yuvData = yuvImage.getYuvData();
        int i4 = i2 * i3;
        if (i4 >= 0) {
            System.arraycopy(yuvData, 0, this.yuvnv12, 0, i4);
        }
        for (int i5 = i4; i5 < (i4 * 3) / 2; i5++) {
            if ((i5 + 1) % 2 == 0) {
                this.yuvnv12[i5] = yuvData[i5 - 1];
                this.yuvnv12[i5 - 1] = yuvData[i5];
            }
        }
        byte[] bArr = this.yuvnv12;
        AppMethodBeat.o(192623);
        return bArr;
    }

    private byte[] I420ToNV21(int i2, int i3, YuvImage yuvImage) {
        AppMethodBeat.i(192624);
        if (this.yuvnv12 == null) {
            this.yuvnv12 = new byte[(((i2 * i3) * 3) / 2)];
        }
        byte[] yuvData = yuvImage.getYuvData();
        int i4 = i2 * i3;
        if (i4 >= 0) {
            System.arraycopy(yuvData, 0, this.yuvnv12, 0, i4);
        }
        int i5 = i4 + (i4 / 4);
        int i6 = i4;
        for (int i7 = i4; i7 < (i4 * 3) / 2; i7 += 2) {
            this.yuvnv12[i5] = yuvData[i7];
            this.yuvnv12[i6] = yuvData[i7 + 1];
            i5++;
            i6++;
        }
        byte[] bArr = this.yuvnv12;
        AppMethodBeat.o(192624);
        return bArr;
    }

    private byte[] getNV21(int i2, int i3, Bitmap bitmap) {
        AppMethodBeat.i(192625);
        int[] iArr = new int[(i2 * i3)];
        bitmap.getPixels(iArr, 0, i2, 0, 0, i2, i3);
        byte[] bArr = new byte[(((i2 * i3) * 3) / 2)];
        encodeYUV420SP(bArr, iArr, i2, i3);
        bitmap.recycle();
        AppMethodBeat.o(192625);
        return bArr;
    }

    private void encodeYUV420SP(byte[] bArr, int[] iArr, int i2, int i3) {
        int i4;
        int i5;
        int i6 = i2 * i3;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i9 < i3) {
            int i10 = 0;
            int i11 = i8;
            int i12 = i7;
            while (i10 < i2) {
                int i13 = (iArr[i11] & 16711680) >> 16;
                int i14 = (iArr[i11] & 65280) >> 8;
                int i15 = iArr[i11] & 255;
                int i16 = (((((i13 * 66) + (i14 * 129)) + (i15 * 25)) + 128) >> 8) + 16;
                int i17 = (((((i13 * -38) - (i14 * 74)) + (i15 * 112)) + 128) >> 8) + 128;
                int i18 = (((((i13 * 112) - (i14 * 94)) - (i15 * 18)) + 128) >> 8) + 128;
                int i19 = i12 + 1;
                if (i16 < 0) {
                    i16 = 0;
                } else if (i16 > 255) {
                    i16 = 255;
                }
                bArr[i12] = (byte) i16;
                if (i9 % 2 == 0 && i11 % 2 == 0) {
                    int i20 = i6 + 1;
                    bArr[i6] = (byte) (i17 < 0 ? 0 : i17 > 255 ? 255 : i17);
                    int i21 = i20 + 1;
                    if (i18 < 0) {
                        i5 = 0;
                    } else {
                        i5 = i18 > 255 ? 255 : i18;
                    }
                    bArr[i20] = (byte) i5;
                    i4 = i21;
                } else {
                    i4 = i6;
                }
                i10++;
                i11++;
                i12 = i19;
                i6 = i4;
            }
            i9++;
            i8 = i11;
            i7 = i12;
        }
    }

    private long computePresentationTime(long j2, int i2) {
        return 132 + ((TimeUtil.SECOND_TO_US * j2) / ((long) i2));
    }

    private void startMediaMuxer(MediaType mediaType, MediaFormat mediaFormat) {
        AppMethodBeat.i(192626);
        synchronized (this.mediaMuxerSync) {
            try {
                if (!this.isMediaMuxerStarted) {
                    if (mediaType == MediaType.VideoType) {
                        this.videoTrackIndex = this.mediaMuxer.addTrack(mediaFormat);
                        this.addedTrackCount++;
                    }
                    if (mediaType == MediaType.AudioType) {
                        this.audioTrackIndex = this.mediaMuxer.addTrack(mediaFormat);
                        this.addedTrackCount++;
                    }
                    if ((this.needAudio && this.addedTrackCount >= 2) || (!this.needAudio && this.addedTrackCount > 0)) {
                        YtLogger.d(TAG, "Media muxer is starting...");
                        this.mediaMuxer.start();
                        this.isMediaMuxerStarted = true;
                        this.mediaMuxerSync.notifyAll();
                    } else if (this.needAudio) {
                        try {
                            this.mediaMuxerSync.wait();
                        } catch (InterruptedException e2) {
                        }
                    }
                    AppMethodBeat.o(192626);
                }
            } finally {
                AppMethodBeat.o(192626);
            }
        }
    }
}
