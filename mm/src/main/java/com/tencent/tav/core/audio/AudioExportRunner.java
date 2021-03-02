package com.tencent.tav.core.audio;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public class AudioExportRunner implements Runnable {
    static final int EDGE_DURATION_MS = 200;
    private static final int MAX_INPUT_SIZE = 8192;
    private static String MIME = EncoderWriter.OUTPUT_AUDIO_MIME_TYPE;
    static final int PACKET_FPS = 44;
    public static final String TAG = "AudioEncoder";
    private static final long WAIT_TRANSIENT_MS = 20;
    private boolean enOfAudioInputStream = false;
    IAudioSource<? extends IDecoderTrack> mAudioAsset;
    IDecoderTrack mAudioDecoder;
    private MediaCodec mAudioEncoder;
    private ExportCallback mCallback;
    private boolean mCancel = false;
    private int mChannelCount = 1;
    private FileOutputStream mFos;
    private String mMime = MIME;
    private int mRate = EncoderWriter.OUTPUT_AUDIO_BIT_RATE;
    private int mSampleRate = 44100;
    private String mSavePath;
    CMTimeRange mSelectedTimeRange;
    private int mStatus = 0;
    private AtomicBoolean mStop = new AtomicBoolean(false);
    private Thread mThread;

    AudioExportRunner(IAudioSource<? extends IDecoderTrack> iAudioSource, CMTimeRange cMTimeRange) {
        AppMethodBeat.i(217961);
        this.mAudioAsset = iAudioSource;
        if (cMTimeRange == null) {
            this.mSelectedTimeRange = new CMTimeRange(CMTime.CMTimeZero, iAudioSource.getDuration());
            AppMethodBeat.o(217961);
            return;
        }
        this.mSelectedTimeRange = cMTimeRange;
        AppMethodBeat.o(217961);
    }

    public void setMime(String str) {
        this.mMime = str;
    }

    public void setRate(int i2) {
        this.mRate = i2;
    }

    public int getRate() {
        return this.mRate;
    }

    public void setSampleRate(int i2) {
        this.mSampleRate = i2;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public void setSavePath(String str) {
        this.mSavePath = str;
    }

    public String getSavePath() {
        return this.mSavePath;
    }

    public void setCallback(ExportCallback exportCallback) {
        this.mCallback = exportCallback;
    }

    public void setAsset(IAudioSource<? extends IDecoderTrack> iAudioSource) {
        this.mAudioAsset = iAudioSource;
    }

    public void setSelectedTimeRange(CMTimeRange cMTimeRange) {
        this.mSelectedTimeRange = cMTimeRange;
    }

    public CMTimeRange getSelectedTimeRange() {
        return this.mSelectedTimeRange;
    }

    public void prepare() {
        AppMethodBeat.i(217962);
        initAudioDecoder();
        initAudioEncoder();
        AppMethodBeat.o(217962);
    }

    private void initAudioDecoder() {
        AppMethodBeat.i(217963);
        try {
            this.mAudioDecoder = this.mAudioAsset.getSourceAudioDecoder(this.mSelectedTimeRange);
            this.mAudioDecoder.start();
            CMTime start = this.mSelectedTimeRange.getStart();
            this.mAudioDecoder.seekTo(start.bigThan(CMTime.CMTimeZero) ? start.sub(CMTime.fromMs(200)) : CMTime.CMTimeZero, false, false);
            AppMethodBeat.o(217963);
        } catch (Throwable th) {
            AppMethodBeat.o(217963);
        }
    }

    private void initAudioEncoder() {
        AppMethodBeat.i(217964);
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(MIME, this.mSampleRate, this.mChannelCount);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.mRate);
        createAudioFormat.setInteger("max-input-size", 8192);
        this.mAudioEncoder = MediaCodec.createEncoderByType(this.mMime);
        this.mAudioEncoder.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        AppMethodBeat.o(217964);
    }

    public synchronized void start() {
        AppMethodBeat.i(217965);
        if (this.mThread == null) {
            this.mAudioEncoder.start();
            this.mThread = new Thread(this);
            this.mThread.start();
            this.mStop.set(false);
            this.mCancel = false;
            this.enOfAudioInputStream = false;
            this.mStatus = 1;
        }
        AppMethodBeat.o(217965);
    }

    private ByteBuffer getInputBuffer(int i2) {
        AppMethodBeat.i(217966);
        if (Build.VERSION.SDK_INT >= 21) {
            ByteBuffer inputBuffer = this.mAudioEncoder.getInputBuffer(i2);
            AppMethodBeat.o(217966);
            return inputBuffer;
        }
        ByteBuffer byteBuffer = this.mAudioEncoder.getInputBuffers()[i2];
        AppMethodBeat.o(217966);
        return byteBuffer;
    }

    private ByteBuffer getOutputBuffer(int i2) {
        AppMethodBeat.i(217967);
        if (Build.VERSION.SDK_INT >= 21) {
            ByteBuffer outputBuffer = this.mAudioEncoder.getOutputBuffer(i2);
            AppMethodBeat.o(217967);
            return outputBuffer;
        }
        ByteBuffer byteBuffer = this.mAudioEncoder.getOutputBuffers()[i2];
        AppMethodBeat.o(217967);
        return byteBuffer;
    }

    private int dequeueInputBuffer(MediaCodec mediaCodec) {
        AppMethodBeat.i(217968);
        do {
            try {
                int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(1000);
                AppMethodBeat.o(217968);
                return dequeueInputBuffer;
            } catch (Error | Exception e2) {
                Logger.e(TAG, "dequeueInputBuffer e = ", e2);
                if (21 > Build.VERSION.SDK_INT || !(e2 instanceof MediaCodec.CodecException)) {
                    AppMethodBeat.o(217968);
                    throw e2;
                }
                if (23 <= Build.VERSION.SDK_INT) {
                    Logger.e(TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e2).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e2).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e2).getErrorCode());
                }
                if (!((MediaCodec.CodecException) e2).isTransient()) {
                    AppMethodBeat.o(217968);
                    throw e2;
                }
            }
        } while (!((MediaCodec.CodecException) e2).isTransient());
        AppMethodBeat.o(217968);
        throw e2;
    }

    private void waitTime(long j2) {
        AppMethodBeat.i(217969);
        try {
            wait(j2);
            AppMethodBeat.o(217969);
        } catch (InterruptedException e2) {
            AppMethodBeat.o(217969);
        }
    }

    private void queueInputBuffer(MediaCodec mediaCodec, int i2, int i3, int i4, long j2, int i5) {
        AppMethodBeat.i(217970);
        try {
            mediaCodec.queueInputBuffer(i2, i3, i4, j2, i5);
            AppMethodBeat.o(217970);
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
            AppMethodBeat.o(217970);
            throw e2;
        }
    }

    private void signalEndOfAudioStream() {
        AppMethodBeat.i(217971);
        try {
            Logger.d(TAG, "signalEndOfAudioStream: ");
            int dequeueInputBuffer = dequeueInputBuffer(this.mAudioEncoder);
            if (dequeueInputBuffer >= 0) {
                queueInputBuffer(this.mAudioEncoder, dequeueInputBuffer, 0, 0, 0, 4);
            }
            AppMethodBeat.o(217971);
        } catch (Throwable th) {
            Logger.e(TAG, "signalEndOfAudioStream failed", th);
            AppMethodBeat.o(217971);
        }
    }

    private void readNextSample() {
        AppMethodBeat.i(217972);
        CMSampleBuffer readSample = this.mAudioDecoder.readSample();
        CMTime time = readSample.getTime();
        if (time.value <= 0 || time.getTimeUs() > this.mSelectedTimeRange.getEndUs()) {
            long stateCode = readSample.getState().getStateCode();
            if (stateCode >= -1 && !this.enOfAudioInputStream) {
                signalEndOfAudioStream();
                this.enOfAudioInputStream = true;
            }
            this.mStatus = stateCode < -1 ? 255 : this.mStatus;
            AppMethodBeat.o(217972);
            return;
        }
        ByteBuffer sampleByteBuffer = readSample.getSampleByteBuffer();
        int limit = sampleByteBuffer.limit() - sampleByteBuffer.position();
        byte[] bArr = new byte[limit];
        sampleByteBuffer.get(bArr);
        writeAudioSample(time, limit, bArr);
        AppMethodBeat.o(217972);
    }

    private void writeAudioSample(CMTime cMTime, int i2, byte[] bArr) {
        AppMethodBeat.i(217973);
        int i3 = 0;
        while (i2 - i3 > 0) {
            int dequeueInputBuffer = this.mAudioEncoder.dequeueInputBuffer(-1);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer inputBuffer = getInputBuffer(dequeueInputBuffer);
                inputBuffer.clear();
                int min = Math.min(inputBuffer.capacity(), i2);
                inputBuffer.put(bArr, i3, min);
                this.mAudioEncoder.queueInputBuffer(dequeueInputBuffer, 0, min, cMTime.getTimeUs(), 1);
                i3 += min;
            }
        }
        AppMethodBeat.o(217973);
    }

    private void writeAudioSample() {
        int dequeueOutputBuffer;
        AppMethodBeat.i(217974);
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        do {
            dequeueOutputBuffer = this.mAudioEncoder.dequeueOutputBuffer(bufferInfo, 0);
            if (dequeueOutputBuffer >= 0 && isValidBuffer(bufferInfo) && this.mStatus != 2) {
                if ((bufferInfo.flags & 4) != 0) {
                    Logger.d(TAG, "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM ");
                    this.mStatus = 2;
                }
                ByteBuffer outputBuffer = getOutputBuffer(dequeueOutputBuffer);
                outputBuffer.position(bufferInfo.offset);
                byte[] bArr = new byte[(bufferInfo.size + 7)];
                outputBuffer.get(bArr, 7, bufferInfo.size);
                EncoderUtils.addADTStoPacket(bArr, this.mChannelCount);
                Logger.v(TAG, "dequeue finish - " + bufferInfo.presentationTimeUs + "--" + bufferInfo.flags + " -- " + bufferInfo.size + "  -  " + dequeueOutputBuffer + " endUs = " + this.mSelectedTimeRange.getEndUs());
                write(bArr);
                this.mAudioEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (this.mStatus != 2) {
                    notifyProgressUpdate(bufferInfo.presentationTimeUs);
                    continue;
                } else {
                    notifyProgressUpdate(this.mSelectedTimeRange.getEndUs());
                    continue;
                }
            } else if (isFinish(bufferInfo)) {
                this.mStatus = 2;
                continue;
            } else if (!(dequeueOutputBuffer == -1 || dequeueOutputBuffer == -2)) {
                if ((bufferInfo.flags & 4) != 0) {
                    Logger.d(TAG, "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM " + bufferInfo.size + FilePathGenerator.ANDROID_DIR_SEP + bufferInfo.presentationTimeUs);
                    this.mStatus = 2;
                }
                this.mAudioEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                continue;
            }
        } while (dequeueOutputBuffer >= 0);
        AppMethodBeat.o(217974);
    }

    private void write(byte[] bArr) {
        AppMethodBeat.i(217975);
        if (this.mFos == null) {
            this.mFos = new FileOutputStream(this.mSavePath);
        }
        this.mFos.write(bArr);
        AppMethodBeat.o(217975);
    }

    private boolean isFinish(MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(217976);
        if (bufferInfo.presentationTimeUs >= this.mSelectedTimeRange.getEndUs()) {
            AppMethodBeat.o(217976);
            return true;
        }
        AppMethodBeat.o(217976);
        return false;
    }

    private boolean isValidBuffer(MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(217977);
        if (bufferInfo.size <= 0 || bufferInfo.presentationTimeUs < this.mSelectedTimeRange.getStartUs() || bufferInfo.presentationTimeUs > this.mSelectedTimeRange.getEndUs() || (bufferInfo.flags & 2) != 0) {
            AppMethodBeat.o(217977);
            return false;
        }
        AppMethodBeat.o(217977);
        return true;
    }

    private void notifyProgressUpdate(long j2) {
        AppMethodBeat.i(217978);
        if (!(this.mCallback == null || this.mSelectedTimeRange == null)) {
            this.mCallback.onProgress(this.mStatus, (((float) (j2 - this.mSelectedTimeRange.getStartUs())) * 1.0f) / ((float) this.mSelectedTimeRange.getDurationUs()));
        }
        AppMethodBeat.o(217978);
    }

    private synchronized void stop() {
        AppMethodBeat.i(217979);
        if (!this.mStop.get()) {
            this.mStop.set(true);
            try {
                this.mAudioDecoder.release();
                this.mAudioEncoder.stop();
                this.mAudioEncoder.release();
                this.mFos.flush();
                this.mFos.close();
            } catch (Exception e2) {
            }
        }
        notifyProgressUpdate(this.mSelectedTimeRange.getEndUs());
        this.mCancel = false;
        AppMethodBeat.o(217979);
    }

    public void run() {
        AppMethodBeat.i(217980);
        Logger.d(TAG, "encoder start - ".concat(String.valueOf(this)));
        while (this.mStatus <= 1 && !this.mCancel) {
            try {
                readNextSample();
                writeAudioSample();
            } catch (Throwable th) {
                this.mStatus = 255;
            }
        }
        if (this.mCancel) {
            this.mStatus = 4;
        }
        Logger.d(TAG, "encoder finish - " + this + "  mStatus = " + this.mStatus);
        stop();
        AppMethodBeat.o(217980);
    }

    public synchronized void cancel() {
        this.mCancel = true;
    }
}
