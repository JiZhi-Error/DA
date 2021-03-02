package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class AudioDecoder implements IDecoder {
    private static final int MAX_RETRY_COUNT = 10;
    private static final int MAX_WAIT_TIME = 1000;
    private static final long WAIT_TRANSIENT_MS = 2;
    private static final ArrayList<String> nameList = new ArrayList<>();
    private final String TAG = ("AudioDecoder@" + Integer.toHexString(hashCode()));
    private MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    private CMSampleState currentSampleState = new CMSampleState(CMTime.CMTimeZero);
    private CMTime currentStartTime = CMTime.CMTimeInvalid;
    private AudioInfo decodeAudioInfo = new AudioInfo();
    private ByteBuffer decodeBuffer = null;
    private MediaCodec decoder;
    private final Object decoderCreateLock = new Object();
    private CMTime duration = CMTime.CMTimeZero;
    private AssetExtractor extractor = new AssetExtractor();
    private boolean extractorDone = false;
    private boolean isReleased = false;
    private int lastOutputBufferIndex = -1;
    private long mLastVideoQueueTime = 0;
    private long mTimeOffset = 0;
    private MediaFormat mediaFormat;
    private AudioInfo outputAudioInfo = null;
    private ByteBuffer outputBuffer = null;
    private CMTime pFrameTime = new CMTime(20, 600);
    private ArrayList<PendingFrame> pendingFrames = new ArrayList<>();
    private boolean started = false;
    private CMTimeRange timeRange;
    public int trackIndex = -1;

    /* access modifiers changed from: package-private */
    public static class PendingFrame {
        public CMTime frameTime = CMTime.CMTimeZero;
        public boolean isFirst = false;
        public CMTime seekStartTime = CMTime.CMTimeZero;
        public long timeOffset = 0;
    }

    static /* synthetic */ void access$000(AudioDecoder audioDecoder) {
        AppMethodBeat.i(218079);
        audioDecoder.releaseOutputBuffer();
        AppMethodBeat.o(218079);
    }

    static {
        AppMethodBeat.i(218080);
        AppMethodBeat.o(218080);
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public String getSourcePath() {
        AppMethodBeat.i(218052);
        if (this.extractor == null) {
            AppMethodBeat.o(218052);
            return null;
        }
        String sourcePath = this.extractor.getSourcePath();
        AppMethodBeat.o(218052);
        return sourcePath;
    }

    public boolean isStarted() {
        return this.started;
    }

    public AudioDecoder(String str) {
        AppMethodBeat.i(218053);
        this.extractor.setDataSource(str);
        while (this.extractor.getSampleTrackIndex() != -1) {
            this.extractor.unselectTrack(this.extractor.getSampleTrackIndex());
        }
        this.trackIndex = DecoderUtils.getFirstTrackIndex(this.extractor, "audio/");
        if (this.trackIndex == -1) {
            this.decodeBuffer = null;
            AppMethodBeat.o(218053);
            return;
        }
        this.extractor.selectTrack(this.trackIndex);
        this.mediaFormat = this.extractor.getTrackFormat(this.trackIndex);
        this.duration = new CMTime((((float) this.extractor.getAudioDuration()) * 1.0f) / ((float) TimeUnit.SECONDS.toMicros(1)));
        if (this.mediaFormat.containsKey("frame-rate")) {
            this.pFrameTime = new CMTime((long) (600 / this.mediaFormat.getInteger("frame-rate")), 600);
        }
        String string = this.mediaFormat.getString("mime");
        synchronized (this.decoderCreateLock) {
            try {
                this.decoder = MediaCodec.createDecoderByType(string);
                nameList.add(this.decoder.toString());
                if (decoderConfigure(this.mediaFormat)) {
                    start();
                } else {
                    IllegalStateException illegalStateException = new IllegalStateException("decoderConfigure failed!");
                    AppMethodBeat.o(218053);
                    throw illegalStateException;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(218053);
                throw th;
            }
        }
        this.decodeAudioInfo.sampleRate = this.mediaFormat.getInteger("sample-rate");
        this.decodeAudioInfo.channelCount = this.mediaFormat.getInteger("channel-count");
        AudioInfo audioInfo = new AudioInfo();
        audioInfo.channelCount = 1;
        audioInfo.sampleRate = 44100;
        audioInfo.pcmEncoding = 2;
        AppMethodBeat.o(218053);
    }

    public AudioInfo getAudioInfo() {
        if (this.outputAudioInfo != null) {
            return this.outputAudioInfo;
        }
        return this.decodeAudioInfo;
    }

    private synchronized void reset() {
        AppMethodBeat.i(218054);
        if (this.isReleased) {
            AppMethodBeat.o(218054);
        } else {
            Logger.d(this.TAG, "reset() called");
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.decoder.reset();
                    decoderConfigure(this.mediaFormat);
                    start();
                    AppMethodBeat.o(218054);
                } else {
                    try {
                        this.decoder.stop();
                    } catch (Exception e2) {
                    }
                    this.decoder.release();
                    nameList.remove(this.decoder.toString());
                    this.decoder = MediaCodec.createDecoderByType(this.mediaFormat.getString("mime"));
                    nameList.add(this.decoder.toString());
                    decoderConfigure(this.mediaFormat);
                    start();
                    AppMethodBeat.o(218054);
                }
            } catch (Exception e3) {
                Logger.e(this.TAG, "reset: ", e3);
                AppMethodBeat.o(218054);
            }
        }
    }

    private synchronized boolean decoderConfigure(MediaFormat mediaFormat2) {
        boolean z;
        AppMethodBeat.i(218055);
        if (Build.VERSION.SDK_INT < 21) {
            this.decoder.configure(mediaFormat2, (Surface) null, (MediaCrypto) null, 0);
            AppMethodBeat.o(218055);
            z = true;
        } else {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                try {
                    Logger.d(this.TAG, "createdDecoder---time---".concat(String.valueOf(i3)));
                    if (i3 > 10) {
                        AppMethodBeat.o(218055);
                        z = false;
                    } else {
                        this.decoder.configure(mediaFormat2, (Surface) null, (MediaCrypto) null, 0);
                        AppMethodBeat.o(218055);
                        z = true;
                    }
                } catch (Exception e2) {
                    Logger.e(this.TAG, "decoderConfigure", e2);
                    if (!(e2 instanceof MediaCodec.CodecException) || (!((MediaCodec.CodecException) e2).isTransient() && !((MediaCodec.CodecException) e2).isRecoverable())) {
                        this.decoder.release();
                        AppMethodBeat.o(218055);
                        throw e2;
                    }
                    i2 = i3;
                }
            }
            this.decoder.release();
            AppMethodBeat.o(218055);
            throw e2;
        }
        return z;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized boolean hasTrack() {
        return this.trackIndex != -1;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized void start(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(218056);
        start(cMTimeRange, CMTime.CMTimeZero);
        AppMethodBeat.o(218056);
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized void start(CMTimeRange cMTimeRange, CMTime cMTime) {
        AppMethodBeat.i(218057);
        Logger.d(this.TAG, "start:" + getSourcePath() + " [timeRange " + cMTimeRange + "] [start " + cMTime + "]");
        if (this.trackIndex == -1) {
            Logger.e(this.TAG, "start: trackIndex == -1");
            AppMethodBeat.o(218057);
        } else {
            clearDecoder();
            if (cMTimeRange == null) {
                this.timeRange = new CMTimeRange(CMTime.CMTimeZero, this.duration);
            } else {
                this.timeRange = new CMTimeRange(cMTimeRange.getStart(), cMTimeRange.getDuration());
            }
            this.extractorDone = false;
            this.started = true;
            if (cMTime.getTimeUs() >= 0) {
                seekTo(cMTime);
            }
            AppMethodBeat.o(218057);
        }
    }

    private void clearDecoder() {
        AppMethodBeat.i(218058);
        Logger.v(this.TAG, "clearDecoder " + getSourcePath());
        releaseOutputBuffer();
        if (this.pendingFrames.size() != 0 || this.extractorDone) {
            try {
                this.decoder.flush();
            } catch (Exception e2) {
                Logger.e(this.TAG, "clearDecoder", e2);
            }
            this.pendingFrames.clear();
        }
        this.currentSampleState = new CMSampleState();
        AppMethodBeat.o(218058);
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized void seekTo(CMTime cMTime) {
        AppMethodBeat.i(218059);
        Logger.v(this.TAG, "seekTo: " + cMTime + "  - " + this + "  " + this.currentStartTime + "  " + this.currentSampleState);
        if (!this.started || this.trackIndex == -1) {
            Logger.e(this.TAG, "seekTo:failed [started " + this.started + "] [trackIndex " + this.trackIndex + "]");
            AppMethodBeat.o(218059);
        } else {
            if (cMTime.getTimeUs() < 0) {
                cMTime = CMTime.CMTimeZero;
            }
            this.currentStartTime = this.timeRange.getStart().add(cMTime);
            this.extractorDone = false;
            seekExtractorTo(this.currentStartTime.getTimeUs());
            Logger.v(this.TAG, "seekTo: finish - " + this.currentStartTime + "  " + this.extractor.getSampleTime());
            AppMethodBeat.o(218059);
        }
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized ByteBuffer outputBuffer() {
        ByteBuffer byteBuffer;
        if (this.decodeBuffer == null) {
            byteBuffer = null;
        } else if (this.outputBuffer == null) {
            byteBuffer = this.decodeBuffer;
        } else {
            byteBuffer = this.outputBuffer;
        }
        return byteBuffer;
    }

    public CMTime nextFrameTime() {
        AppMethodBeat.i(218060);
        CMTime cMTime = this.pendingFrames.size() > 0 ? this.pendingFrames.get(0).frameTime : CMTime.CMTimeInvalid;
        Iterator<PendingFrame> it = this.pendingFrames.iterator();
        while (it.hasNext()) {
            cMTime = CMTime.min(it.next().frameTime, cMTime);
        }
        AppMethodBeat.o(218060);
        return cMTime;
    }

    private synchronized void releaseOutputBuffer() {
        AppMethodBeat.i(218061);
        if (this.lastOutputBufferIndex != -1) {
            try {
                releaseOutputBuffer(this.lastOutputBufferIndex, false);
            } catch (Exception e2) {
                Logger.e(this.TAG, "releaseOutputBuffer", e2);
            }
            this.lastOutputBufferIndex = -1;
        }
        this.decodeBuffer = null;
        AppMethodBeat.o(218061);
    }

    private synchronized void seekExtractorTo(long j2) {
        AppMethodBeat.i(218062);
        this.extractor.seekTo(j2, 2);
        if (this.extractor.getSampleTime() > j2) {
            this.extractor.seekTo(j2, 0);
        }
        clearDecoder();
        this.mTimeOffset = this.mLastVideoQueueTime + 10000000;
        AppMethodBeat.o(218062);
    }

    private synchronized void waitTime(long j2) {
        AppMethodBeat.i(218063);
        try {
            wait(j2);
            AppMethodBeat.o(218063);
        } catch (InterruptedException e2) {
            Logger.e(this.TAG, "waitTime", e2);
            AppMethodBeat.o(218063);
        }
    }

    private synchronized void start() {
        AppMethodBeat.i(218064);
        try {
            this.decoder.start();
            AppMethodBeat.o(218064);
        } catch (Exception e2) {
            Logger.e(this.TAG, "start", e2);
            if (Build.VERSION.SDK_INT >= 21 && (e2 instanceof MediaCodec.CodecException)) {
                if (Build.VERSION.SDK_INT >= 23) {
                    Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e2).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e2).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e2).getErrorCode());
                }
                if (((MediaCodec.CodecException) e2).isTransient()) {
                    waitTime(2);
                    start();
                    AppMethodBeat.o(218064);
                } else if (((MediaCodec.CodecException) e2).isRecoverable()) {
                    reset();
                    AppMethodBeat.o(218064);
                }
            }
            release();
            AppMethodBeat.o(218064);
            throw e2;
        }
    }

    private synchronized int dequeueOutputBuffer() {
        int dequeueOutputBuffer;
        AppMethodBeat.i(218065);
        try {
            dequeueOutputBuffer = this.decoder.dequeueOutputBuffer(this.bufferInfo, 1000);
            AppMethodBeat.o(218065);
        } catch (Exception e2) {
            Logger.e(this.TAG, "dequeueOutputBuffer", e2);
            if (Build.VERSION.SDK_INT >= 21 && (e2 instanceof MediaCodec.CodecException)) {
                if (Build.VERSION.SDK_INT >= 23) {
                    Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e2).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e2).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e2).getErrorCode());
                }
                if (((MediaCodec.CodecException) e2).isTransient()) {
                    waitTime(2);
                    dequeueOutputBuffer = dequeueOutputBuffer();
                    AppMethodBeat.o(218065);
                }
            }
            AppMethodBeat.o(218065);
            throw e2;
        }
        return dequeueOutputBuffer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized int dequeueInputBuffer() {
        /*
        // Method dump skipped, instructions count: 156
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.decoder.AudioDecoder.dequeueInputBuffer():int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.nio.ByteBuffer getInputBuffer(int r7) {
        /*
        // Method dump skipped, instructions count: 154
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.decoder.AudioDecoder.getInputBuffer(int):java.nio.ByteBuffer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.nio.ByteBuffer getOutputBuffer(int r7) {
        /*
        // Method dump skipped, instructions count: 154
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.decoder.AudioDecoder.getOutputBuffer(int):java.nio.ByteBuffer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void releaseOutputBuffer(int r7, boolean r8) {
        /*
        // Method dump skipped, instructions count: 144
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.decoder.AudioDecoder.releaseOutputBuffer(int, boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void queueInputBuffer(int r11, int r12, int r13, long r14, int r16) {
        /*
        // Method dump skipped, instructions count: 150
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.decoder.AudioDecoder.queueInputBuffer(int, int, int, long, int):void");
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized CMSampleState readSample() {
        CMSampleState readSample;
        AppMethodBeat.i(218071);
        readSample = readSample(CMTime.CMTimeInvalid);
        AppMethodBeat.o(218071);
        return readSample;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized CMSampleState readSample(CMTime cMTime) {
        CMSampleState cMSampleState;
        AppMethodBeat.i(218072);
        Logger.v(this.TAG, "readSample: " + cMTime + "  -  " + this.extractor.getSampleTime());
        this.currentSampleState = doReadSample(cMTime, false);
        cMSampleState = this.currentSampleState;
        if (this.currentSampleState.stateMatchingTo(-1, -4) || !this.currentSampleState.getTime().smallThan(this.duration)) {
            clearDecoder();
        }
        Logger.v(this.TAG, "readSample: finish " + cMTime + "  -  " + this.currentSampleState);
        AppMethodBeat.o(218072);
        return cMSampleState;
    }

    private synchronized CMSampleState doReadSample(CMTime cMTime, boolean z) {
        CMSampleState fromError;
        long j2 = -2;
        boolean z2 = false;
        synchronized (this) {
            AppMethodBeat.i(218073);
            Logger.v(this.TAG, "doReadSample - " + this.extractor.getSourcePath());
            fromError = CMSampleState.fromError(-2);
            if (!this.started || this.trackIndex == -1) {
                String str = this.TAG;
                StringBuilder append = new StringBuilder("doReadSample:[failed] !started || trackIndex == -1 ").append(!this.started).append(" - ");
                if (this.trackIndex == -1) {
                    z2 = true;
                }
                Logger.e(str, append.append(z2).toString());
                fromError = CMSampleState.fromError(-100);
                AppMethodBeat.o(218073);
            } else {
                releaseOutputBuffer();
                int i2 = 0;
                while (true) {
                    if (this.pendingFrames.size() <= 0 && this.extractorDone) {
                        break;
                    }
                    try {
                        if (!this.extractorDone) {
                            readFromExtractor();
                        }
                        int dequeueOutputBuffer = dequeueOutputBuffer();
                        if (dequeueOutputBuffer == -2) {
                            MediaFormat outputFormat = this.decoder.getOutputFormat();
                            if (outputFormat.containsKey("pcm-encoding")) {
                                this.decodeAudioInfo.pcmEncoding = outputFormat.getInteger("pcm-encoding");
                            } else {
                                this.decodeAudioInfo.pcmEncoding = 2;
                            }
                            if (outputFormat.containsKey("sample-rate")) {
                                this.decodeAudioInfo.sampleRate = outputFormat.getInteger("sample-rate");
                            }
                        } else if (dequeueOutputBuffer < 0 || this.pendingFrames.size() <= 0) {
                            if (dequeueOutputBuffer >= 0) {
                                if (this.bufferInfo.flags == 4) {
                                    Logger.i(this.TAG, "doReadSample:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM 2");
                                    fromError = CMSampleState.fromError(-1);
                                    AppMethodBeat.o(218073);
                                    break;
                                }
                                releaseOutputBuffer(dequeueOutputBuffer, false);
                                fromError = CMSampleState.fromError(-2);
                            }
                            int i3 = i2 + 1;
                            if (i3 > 1000) {
                                fromError = CMSampleState.fromError(-4);
                                Logger.e(this.TAG, "doReadSample: [timeout] ");
                                break;
                            }
                            i2 = i3;
                        } else if (this.bufferInfo.flags == 4) {
                            if (this.bufferInfo.size > 0) {
                                this.pendingFrames.remove(0);
                                this.lastOutputBufferIndex = dequeueOutputBuffer;
                                ByteBuffer outputBuffer2 = getOutputBuffer(dequeueOutputBuffer);
                                if (outputBuffer2 != null) {
                                    outputBuffer2.position(this.bufferInfo.offset);
                                    outputBuffer2.limit(this.bufferInfo.offset + this.bufferInfo.size);
                                    this.decodeBuffer = outputBuffer2;
                                } else {
                                    releaseOutputBuffer(dequeueOutputBuffer, false);
                                    this.decodeBuffer = null;
                                }
                            }
                            Logger.i(this.TAG, "doReadSample:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM");
                            fromError = CMSampleState.fromError(-1);
                            AppMethodBeat.o(218073);
                        } else {
                            PendingFrame remove = this.pendingFrames.remove(0);
                            j2 = this.bufferInfo.presentationTimeUs - remove.timeOffset;
                            CMSampleState cMSampleState = new CMSampleState(new CMTime(j2, 1000000));
                            if (this.pendingFrames.size() == 0 && this.extractorDone && remove.seekStartTime.getTimeUs() + 1000 >= this.duration.getTimeUs()) {
                                fromError = new CMSampleState(this.duration);
                            } else if (remove.seekStartTime.getTimeUs() > j2) {
                                releaseOutputBuffer(dequeueOutputBuffer, false);
                                fromError = CMSampleState.fromError(-2);
                            } else {
                                fromError = cMSampleState;
                            }
                            if (this.bufferInfo.size > 0) {
                                this.lastOutputBufferIndex = dequeueOutputBuffer;
                                ByteBuffer outputBuffer3 = getOutputBuffer(dequeueOutputBuffer);
                                if (outputBuffer3 != null) {
                                    outputBuffer3.position(this.bufferInfo.offset);
                                    outputBuffer3.limit(this.bufferInfo.offset + this.bufferInfo.size);
                                    this.decodeBuffer = outputBuffer3;
                                } else {
                                    releaseOutputBuffer(dequeueOutputBuffer, false);
                                    Logger.e(this.TAG, "doReadSample:[error] " + this.bufferInfo.size + " byteBuffer==null");
                                    fromError = CMSampleState.fromError(-3);
                                    AppMethodBeat.o(218073);
                                }
                            } else {
                                releaseOutputBuffer(dequeueOutputBuffer, false);
                                fromError = CMSampleState.fromError(-2);
                            }
                        }
                    } catch (Exception e2) {
                        Logger.e(this.TAG, "doReadSample: error", e2);
                        if (Build.VERSION.SDK_INT < 21 || !(e2 instanceof MediaCodec.CodecException) || !retryOnReadSampleError((MediaCodec.CodecException) e2)) {
                            fromError = CMSampleState.fromError(-3, "catch exception", e2);
                            AppMethodBeat.o(218073);
                        } else {
                            fromError = CMSampleState.fromError(-3, "catch exception, retry", e2);
                            AppMethodBeat.o(218073);
                        }
                    }
                }
                Logger.v(this.TAG, "doReadSample:[success] " + this.extractorDone + " " + j2 + "  " + fromError);
                if (!this.extractorDone || j2 >= 0) {
                    AppMethodBeat.o(218073);
                } else {
                    fromError = CMSampleState.fromError(-1);
                    AppMethodBeat.o(218073);
                }
            }
        }
        return fromError;
    }

    private boolean retryOnReadSampleError(MediaCodec.CodecException codecException) {
        AppMethodBeat.i(218074);
        if (codecException.isRecoverable()) {
            releaseOutputBuffer();
            reset();
            this.lastOutputBufferIndex = -1;
            this.pendingFrames.clear();
            this.extractor.seekTo(this.currentStartTime.getTimeUs() - this.timeRange.getStartUs(), 0);
            this.extractorDone = false;
        } else if (!codecException.isTransient()) {
            Logger.e(this.TAG, "doReadSample:[error] retry failed");
            AppMethodBeat.o(218074);
            return true;
        }
        AppMethodBeat.o(218074);
        return false;
    }

    private synchronized void readFromExtractor() {
        AppMethodBeat.i(218075);
        long sampleTime = this.extractor.getSampleTime();
        if (sampleTime >= this.timeRange.getEndUs() || this.extractor.getSampleTrackIndex() == -1 || sampleTime == -1) {
            int dequeueInputBuffer = dequeueInputBuffer();
            if (dequeueInputBuffer >= 0) {
                queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
                this.extractorDone = true;
            }
            AppMethodBeat.o(218075);
        } else {
            int dequeueInputBuffer2 = dequeueInputBuffer();
            if (dequeueInputBuffer2 >= 0) {
                int readSampleData = this.extractor.readSampleData(getInputBuffer(dequeueInputBuffer2), 0);
                if (readSampleData >= 0) {
                    this.mLastVideoQueueTime = (sampleTime - this.timeRange.getStartUs()) + this.mTimeOffset;
                    queueInputBuffer(dequeueInputBuffer2, 0, readSampleData, this.mLastVideoQueueTime, 0);
                    PendingFrame pendingFrame = new PendingFrame();
                    pendingFrame.timeOffset = this.mTimeOffset;
                    pendingFrame.frameTime = new CMTime((((float) sampleTime) * 1.0f) / ((float) TimeUnit.SECONDS.toMicros(1)));
                    pendingFrame.seekStartTime = this.currentStartTime.sub(this.timeRange.getStart());
                    if (this.pendingFrames.size() == 0) {
                        pendingFrame.isFirst = true;
                    }
                    this.pendingFrames.add(pendingFrame);
                }
                this.extractor.advance();
            }
            AppMethodBeat.o(218075);
        }
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized void release() {
        AppMethodBeat.i(218076);
        release(true);
        AppMethodBeat.o(218076);
    }

    public synchronized void release(boolean z) {
        AppMethodBeat.i(218077);
        if (this.isReleased) {
            AppMethodBeat.o(218077);
        } else {
            Logger.d(this.TAG, "release:start ".concat(String.valueOf(z)));
            if (z) {
                this.extractor.dispose();
                this.extractor = null;
            }
            this.started = false;
            this.isReleased = true;
            synchronized (this.decoderCreateLock) {
                try {
                    if (this.decoder != null) {
                        new Thread() {
                            /* class com.tencent.tav.decoder.AudioDecoder.AnonymousClass1 */

                            public void run() {
                                AppMethodBeat.i(218051);
                                AudioDecoder.access$000(AudioDecoder.this);
                                synchronized (AudioDecoder.this.decoderCreateLock) {
                                    try {
                                        AudioDecoder.this.decoder.stop();
                                    } catch (Exception e2) {
                                        Logger.e(AudioDecoder.this.TAG, "decoder.stop", e2);
                                    }
                                    try {
                                        AudioDecoder.this.decoder.release();
                                        AudioDecoder.nameList.remove(AudioDecoder.this.decoder.toString());
                                        try {
                                            AudioDecoder.this.decoder = null;
                                            AudioDecoder.this.decoder = null;
                                        } catch (Throwable th) {
                                            AppMethodBeat.o(218051);
                                            throw th;
                                        }
                                    } catch (Exception e3) {
                                        AudioDecoder.this.decoder = null;
                                    } catch (Throwable th2) {
                                        AudioDecoder.this.decoder = null;
                                        AppMethodBeat.o(218051);
                                        throw th2;
                                    }
                                }
                                AppMethodBeat.o(218051);
                            }
                        }.start();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(218077);
                    throw th;
                }
            }
            Logger.d(this.TAG, "release:end ".concat(String.valueOf(z)));
            AppMethodBeat.o(218077);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(218078);
        super.finalize();
        release(false);
        AppMethodBeat.o(218078);
    }
}
