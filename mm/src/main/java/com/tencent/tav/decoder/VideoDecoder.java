package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VideoDecoder implements IVideoDecoder {
    private static final int MAX_WAIT_TIME = 1000;
    public final String TAG;
    private List<Long> allFrameTime;
    private MediaCodec.BufferInfo bufferInfo;
    private CMSampleState currentDecoderState;
    private CMSampleState currentStartState;
    private CMTime duration;
    private AssetExtractor extractor;
    private boolean extractorDone;
    private long frameDurationUs;
    boolean isReleased;
    boolean lastFrameValid;
    private int lastOutputBufferIndex;
    private long mLastVideoQueueTime;
    private long mTimeOffset;
    private final MediaCodecWrapper mediaCodecWrapper;
    private MediaFormat mediaFormat;
    private AssetExtractor mirrorExtractor;
    private ByteBuffer outputBuffer;
    private Surface outputSurface;
    private CMTime pFrameTime;
    private ArrayList<PendingFrame> pendingFrames;
    private long preReadCost;
    private CMTime preReadTime;
    private boolean readSampleFinish;
    private boolean started;
    private CMTimeRange timeRange;
    private int trackIndex;

    public VideoDecoder(String str) {
        this(str, null);
    }

    public VideoDecoder(String str, Surface surface) {
        AppMethodBeat.i(218295);
        this.TAG = "VideoDecoder@" + Integer.toHexString(hashCode());
        this.frameDurationUs = 33333;
        this.duration = CMTime.CMTimeZero;
        this.pFrameTime = new CMTime(20, 600);
        this.trackIndex = -1;
        this.mediaCodecWrapper = new MediaCodecWrapper(this);
        this.bufferInfo = new MediaCodec.BufferInfo();
        this.outputBuffer = null;
        this.currentDecoderState = new CMSampleState();
        this.preReadTime = CMTime.CMTimeInvalid;
        this.pendingFrames = new ArrayList<>();
        this.allFrameTime = new ArrayList();
        this.isReleased = false;
        this.started = false;
        this.lastFrameValid = false;
        this.lastOutputBufferIndex = -1;
        this.preReadCost = 0;
        this.mTimeOffset = 10000000;
        this.mLastVideoQueueTime = 0;
        this.currentStartState = new CMSampleState();
        this.extractorDone = false;
        this.readSampleFinish = false;
        Logger.d(this.TAG, "create VideoDecoder start");
        if (surface != null) {
            this.outputSurface = surface;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!initExtractor(str)) {
            AppMethodBeat.o(218295);
            return;
        }
        createMirrorExtractor();
        this.mediaFormat = this.extractor.getTrackFormat(this.trackIndex);
        this.duration = new CMTime((((float) this.extractor.getDuration()) * 1.0f) / ((float) TimeUnit.SECONDS.toMicros(1)));
        if (this.mediaFormat.containsKey("frame-rate")) {
            int integer = this.mediaFormat.getInteger("frame-rate");
            this.pFrameTime = new CMTime((long) (600 / integer), 600);
            this.frameDurationUs = (long) (1000000 / integer);
        }
        if (this.mediaCodecWrapper.decoderConfigure(this.mediaFormat, surface)) {
            this.mediaCodecWrapper.startDecoder(surface, this.mediaFormat);
            Logger.d(this.TAG, "create VideoDecoder end " + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(218295);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("decoderConfigure failed!");
        AppMethodBeat.o(218295);
        throw illegalStateException;
    }

    private boolean initExtractor(String str) {
        AppMethodBeat.i(218296);
        this.extractor = new AssetExtractor();
        this.extractor.setDataSource(str);
        while (this.extractor.getSampleTrackIndex() != -1) {
            this.extractor.unselectTrack(this.extractor.getSampleTrackIndex());
        }
        this.trackIndex = DecoderUtils.getFirstTrackIndex(this.extractor, "video/");
        if (this.trackIndex == -1) {
            this.outputSurface = null;
            this.outputBuffer = null;
            AppMethodBeat.o(218296);
            return false;
        }
        this.extractor.selectTrack(this.trackIndex);
        AppMethodBeat.o(218296);
        return true;
    }

    private void createMirrorExtractor() {
        AppMethodBeat.i(218297);
        new Thread() {
            /* class com.tencent.tav.decoder.VideoDecoder.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(218291);
                try {
                    long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
                    AssetExtractor assetExtractor = new AssetExtractor();
                    assetExtractor.setDataSource(VideoDecoder.this.extractor.getSourcePath());
                    while (assetExtractor.getSampleTrackIndex() != -1) {
                        assetExtractor.unselectTrack(assetExtractor.getSampleTrackIndex());
                    }
                    assetExtractor.selectTrack(DecoderUtils.getFirstTrackIndex(assetExtractor, "video/"));
                    assetExtractor.seekTo(VideoDecoder.this.timeRange == null ? 0 : VideoDecoder.this.timeRange.getStartUs(), 0);
                    ArrayList arrayList = new ArrayList();
                    while (assetExtractor.getSampleTime() != -1) {
                        arrayList.add(Long.valueOf(assetExtractor.getSampleTime()));
                        assetExtractor.advance();
                    }
                    VideoDecoder.this.allFrameTime.addAll(arrayList);
                    VideoDecoder.this.mirrorExtractor = assetExtractor;
                    Logger.d(VideoDecoder.this.TAG, "Decoder: MirrorExtractor Init " + (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
                    AppMethodBeat.o(218291);
                } catch (Exception e2) {
                    Logger.e(VideoDecoder.this.TAG, "createMirrorExtractor", e2);
                    AppMethodBeat.o(218291);
                }
            }
        }.start();
        AppMethodBeat.o(218297);
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public void init(String str, CGSize cGSize, IDecoderTrack.SurfaceCreator surfaceCreator) {
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized void start(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(218298);
        start(cMTimeRange, CMTime.CMTimeZero);
        AppMethodBeat.o(218298);
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized void start(CMTimeRange cMTimeRange, CMTime cMTime) {
        AppMethodBeat.i(218299);
        Logger.d(this.TAG, "start:" + getSourcePath() + " [timeRange " + cMTimeRange + "] [start " + cMTime + "]");
        if (this.trackIndex == -1) {
            Logger.e(this.TAG, "start: trackIndex == -1");
            AppMethodBeat.o(218299);
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
                long currentTimeMillis = System.currentTimeMillis();
                seekTo(cMTime, false);
                preReadSample();
                this.preReadCost = System.currentTimeMillis() - currentTimeMillis;
            }
            AppMethodBeat.o(218299);
        }
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized void seekTo(CMTime cMTime) {
        AppMethodBeat.i(218300);
        seekTo(cMTime, true);
        AppMethodBeat.o(218300);
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public synchronized void seekTo(CMTime cMTime, boolean z) {
        AppMethodBeat.i(218301);
        Logger.v(this.TAG, "seekTo: " + cMTime + "  - " + this + "  " + this.currentStartState + "  " + this.currentDecoderState);
        if (!this.started || this.trackIndex == -1) {
            Logger.e(this.TAG, "seekTo: [failed] !started || trackIndex == -1 ");
            AppMethodBeat.o(218301);
        } else {
            if (cMTime.smallThan(CMTime.CMTimeZero)) {
                cMTime = CMTime.CMTimeZero;
            }
            CMTime add = this.timeRange.getStart().add(cMTime);
            if ((!z || !moreCloseCurrentThenSeek(cMTime)) && !cMTime.equalsTo(this.currentDecoderState.getTime()) && !hasPreReadAndFirstFrameSeek(cMTime)) {
                this.currentStartState = new CMSampleState(cMTime);
                seekExtractorTo(add.getTimeUs());
                this.extractorDone = false;
                Logger.v(this.TAG, "seekTo: finish - " + this.currentStartState + "  " + this.extractor.getSampleTime());
                AppMethodBeat.o(218301);
            } else {
                AppMethodBeat.o(218301);
            }
        }
    }

    private boolean moreCloseCurrentThenSeek(CMTime cMTime) {
        AppMethodBeat.i(218302);
        if (this.mirrorExtractor != null) {
            long timeUs = this.currentDecoderState.getTime().getTimeUs();
            this.mirrorExtractor.seekTo(cMTime.getTimeUs(), 2);
            if (this.mirrorExtractor.getSampleTime() > cMTime.getTimeUs()) {
                this.mirrorExtractor.seekTo(cMTime.getTimeUs(), 0);
            }
            long sampleTime = this.mirrorExtractor.getSampleTime();
            if (sampleTime > timeUs || this.currentDecoderState.getTime().getTimeUs() < sampleTime || this.currentDecoderState.getTime().getTimeUs() >= cMTime.getTimeUs() + this.pFrameTime.getTimeUs() || timeUs > cMTime.getTimeUs()) {
                AppMethodBeat.o(218302);
                return false;
            }
            AppMethodBeat.o(218302);
            return true;
        }
        AppMethodBeat.o(218302);
        return false;
    }

    private boolean hasPreReadAndFirstFrameSeek(CMTime cMTime) {
        AppMethodBeat.i(218303);
        if (cMTime != CMTime.CMTimeZero || this.preReadTime == CMTime.CMTimeInvalid || this.lastOutputBufferIndex == -1 || this.currentDecoderState.isInvalid()) {
            AppMethodBeat.o(218303);
            return false;
        }
        AppMethodBeat.o(218303);
        return true;
    }

    private synchronized void seekExtractorTo(long j2) {
        AppMethodBeat.i(218304);
        this.extractor.seekTo(j2, 2);
        if (this.extractor.getSampleTime() > j2) {
            this.extractor.seekTo(j2, 0);
        }
        clearDecoder();
        this.mTimeOffset = this.mLastVideoQueueTime + 10000000;
        AppMethodBeat.o(218304);
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized CMSampleState readSample() {
        CMSampleState readSample;
        AppMethodBeat.i(218305);
        readSample = readSample(CMTime.CMTimeInvalid);
        AppMethodBeat.o(218305);
        return readSample;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized CMSampleState readSample(CMTime cMTime) {
        CMSampleState doReadSample;
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(218306);
            Logger.v(this.TAG, "readSample: " + cMTime + ", currentDecoderTime = " + this.currentDecoderState + ",  extractor.getSampleTime() = " + this.extractor.getSampleTime() + ", lastOutputBufferIndex = " + this.lastOutputBufferIndex);
            this.lastFrameValid = false;
            boolean z2 = (outputSurface() == null || this.lastOutputBufferIndex == -1) ? false : true;
            if (!this.currentDecoderState.getTime().smallThan(cMTime) || (this.extractorDone && this.pendingFrames.isEmpty())) {
                z = true;
            }
            if (!z2 || !z) {
                doReadSample = doReadSample(cMTime, false);
                if (this.currentDecoderState.isInvalid() || !doReadSample.getTime().bigThan(this.timeRange.getDuration())) {
                    this.currentDecoderState = doReadSample;
                    if (this.currentDecoderState.stateMatchingTo(-1, -4) || !this.currentDecoderState.getTime().smallThan(this.duration)) {
                        clearDecoder();
                    }
                    Logger.v(this.TAG, "readSample: finish flag = " + this.lastFrameValid + " - " + this.extractorDone + ", time = " + cMTime + "  -  " + this.currentDecoderState);
                    AppMethodBeat.o(218306);
                } else {
                    this.currentDecoderState = CMSampleState.fromError(-1);
                    this.pendingFrames.clear();
                    this.extractorDone = true;
                    Logger.v(this.TAG, "readSample: finish " + cMTime + "  -  " + this.currentDecoderState);
                    this.readSampleFinish = true;
                    doReadSample = this.currentDecoderState;
                    AppMethodBeat.o(218306);
                }
            } else {
                doReadSample = renderCacheBuffer();
                AppMethodBeat.o(218306);
            }
        }
        return doReadSample;
    }

    private CMSampleState renderCacheBuffer() {
        AppMethodBeat.i(218307);
        Logger.v(this.TAG, "renderCacheBuffer: cache hit - " + this.currentDecoderState);
        try {
            this.mediaCodecWrapper.releaseOutputBuffer(this.lastOutputBufferIndex, true);
            this.lastOutputBufferIndex = -1;
            if (this.currentDecoderState.getTime().bigThan(this.timeRange.getEnd())) {
                this.currentDecoderState = CMSampleState.fromError(-1);
                this.pendingFrames.clear();
                this.extractorDone = true;
            }
            CMSampleState cMSampleState = this.currentDecoderState;
            AppMethodBeat.o(218307);
            return cMSampleState;
        } catch (Exception e2) {
            Logger.e(this.TAG, "renderCacheBuffer: ", e2);
            CMSampleState fromError = CMSampleState.fromError(-2);
            AppMethodBeat.o(218307);
            return fromError;
        }
    }

    private synchronized void preReadSample() {
        AppMethodBeat.i(218308);
        this.lastFrameValid = false;
        this.currentDecoderState = doReadSample(CMTime.CMTimeInvalid, true);
        if (!this.currentDecoderState.getTime().smallThan(CMTime.CMTimeZero)) {
            this.currentDecoderState = this.currentStartState;
        }
        this.preReadTime = this.currentDecoderState.getTime();
        Logger.i(this.TAG, "preReadSample: " + getSourcePath() + " preReadTime = " + this.preReadTime + ", lastOutputBufferIndex = " + this.lastOutputBufferIndex);
        AppMethodBeat.o(218308);
    }

    private synchronized CMSampleState doReadSample(CMTime cMTime, boolean z) {
        CMSampleState fromError;
        boolean z2 = true;
        synchronized (this) {
            AppMethodBeat.i(218309);
            if (!cMTime.bigThan(this.timeRange.getDuration()) || z) {
                if (this.extractorDone && this.pendingFrames.size() == 0 && this.timeRange.containsTime(cMTime) && !this.readSampleFinish) {
                    Logger.w(this.TAG, "error state , and will go correct it ! ");
                }
                this.preReadTime = CMTime.CMTimeInvalid;
                if (!this.started || this.trackIndex == -1) {
                    String str = this.TAG;
                    StringBuilder append = new StringBuilder("doReadSample:[unStart]  !started || trackIndex == -1 ").append(!this.started).append(" - ");
                    if (this.trackIndex != -1) {
                        z2 = false;
                    }
                    Logger.e(str, append.append(z2).toString());
                    fromError = CMSampleState.fromError(-100);
                    AppMethodBeat.o(218309);
                } else {
                    releaseOutputBuffer();
                    SampleTime sampleTime = new SampleTime();
                    sampleTime.sampleState = CMSampleState.fromError(-2);
                    sampleTime.timeUs = -2;
                    try {
                        doReadFrames(sampleTime, cMTime, z);
                        Logger.v(this.TAG, "doReadSample:[success] " + this.extractorDone + " " + sampleTime.timeUs + "  " + sampleTime.sampleState);
                        fromError = sampleTime.sampleState;
                        AppMethodBeat.o(218309);
                    } catch (Exception e2) {
                        fromError = onReadFramesException(e2);
                        AppMethodBeat.o(218309);
                    }
                }
            } else {
                Logger.i(this.TAG, "doReadSample:[finish] targetTime.bigThan(timeRange.getDuration()) is" + cMTime.bigThan(this.timeRange.getDuration()) + "&& !justCache istrue");
                fromError = CMSampleState.fromError(-1);
                AppMethodBeat.o(218309);
            }
        }
        return fromError;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0235, code lost:
        if (r2 == null) goto L_0x0259;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0237, code lost:
        r2.position(r16.bufferInfo.offset);
        r2.limit(r16.bufferInfo.offset + r16.bufferInfo.size);
        r16.outputBuffer = r2;
        com.tencent.tav.decoder.VideoDecoder.SampleTime.access$900(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0259, code lost:
        r16.mediaCodecWrapper.releaseOutputBuffer(r6, false);
        com.tencent.tav.decoder.logger.Logger.e(r16.TAG, "doReadFrames:[error] " + r16.bufferInfo.size + " byteBuffer==null");
        r17.sampleState = com.tencent.tav.coremedia.CMSampleState.fromError(-3);
        com.tencent.matrix.trace.core.AppMethodBeat.o(218310);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void doReadFrames(com.tencent.tav.decoder.VideoDecoder.SampleTime r17, com.tencent.tav.coremedia.CMTime r18, boolean r19) {
        /*
        // Method dump skipped, instructions count: 877
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.decoder.VideoDecoder.doReadFrames(com.tencent.tav.decoder.VideoDecoder$SampleTime, com.tencent.tav.coremedia.CMTime, boolean):void");
    }

    private CMSampleState onReadFramesException(Exception exc) {
        AppMethodBeat.i(218311);
        Logger.e(this.TAG, "onReadFramesException: ", exc);
        if (Build.VERSION.SDK_INT < 21) {
            CMSampleState fromError = CMSampleState.fromError(-3);
            AppMethodBeat.o(218311);
            return fromError;
        } else if (!(exc instanceof MediaCodec.CodecException)) {
            CMSampleState fromError2 = CMSampleState.fromError(-3);
            AppMethodBeat.o(218311);
            return fromError2;
        } else if (((MediaCodec.CodecException) exc).isRecoverable()) {
            releaseOutputBuffer();
            this.mediaCodecWrapper.reset(this.outputSurface, this.mediaFormat);
            this.lastOutputBufferIndex = -1;
            this.pendingFrames.clear();
            this.extractor.seekTo(this.currentStartState.getTime().getTimeUs() - this.timeRange.getStartUs(), 0);
            this.extractorDone = false;
            CMSampleState fromError3 = CMSampleState.fromError(-3);
            AppMethodBeat.o(218311);
            return fromError3;
        } else {
            if (((MediaCodec.CodecException) exc).isTransient()) {
                Logger.e(this.TAG, "doReadSample:[error] isTransient() is true");
            }
            Logger.e(this.TAG, "doReadSample:[error] retry failed");
            CMSampleState fromError4 = CMSampleState.fromError(-3);
            AppMethodBeat.o(218311);
            return fromError4;
        }
    }

    private synchronized void readFromExtractor() {
        AppMethodBeat.i(218312);
        long sampleTime = this.extractor.getSampleTime();
        if (sampleTime >= this.timeRange.getEndUs() || this.extractor.getSampleTrackIndex() == -1 || sampleTime == -1) {
            if (sampleTime >= this.timeRange.getEndUs()) {
                readSampleData();
            }
            int dequeueInputBuffer = this.mediaCodecWrapper.dequeueInputBuffer();
            if (dequeueInputBuffer >= 0) {
                this.mediaCodecWrapper.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
                this.extractorDone = true;
            }
            AppMethodBeat.o(218312);
        } else {
            readSampleData();
            AppMethodBeat.o(218312);
        }
    }

    private void readSampleData() {
        AppMethodBeat.i(218313);
        long sampleTime = this.extractor.getSampleTime();
        int dequeueInputBuffer = this.mediaCodecWrapper.dequeueInputBuffer();
        if (dequeueInputBuffer >= 0) {
            int readSampleData = this.extractor.readSampleData(this.mediaCodecWrapper.getInputBuffer(dequeueInputBuffer), 0);
            if (readSampleData >= 0) {
                this.mLastVideoQueueTime = (sampleTime - this.timeRange.getStartUs()) + this.mTimeOffset;
                this.mediaCodecWrapper.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.mLastVideoQueueTime, 0);
                PendingFrame pendingFrame = new PendingFrame();
                pendingFrame.timeOffset = this.mTimeOffset;
                pendingFrame.seekStartTime = this.currentStartState.getTime();
                this.pendingFrames.add(pendingFrame);
            }
            this.extractor.advance();
        }
        AppMethodBeat.o(218313);
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized ByteBuffer outputBuffer() {
        return this.outputBuffer;
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public CMTime nextFrameTime(CMTime cMTime) {
        AppMethodBeat.i(218314);
        long timeUs = cMTime.getTimeUs();
        for (Long l : this.allFrameTime) {
            long longValue = l.longValue();
            if (timeUs < longValue) {
                CMTime cMTime2 = new CMTime((((float) longValue) / 1000.0f) / 1000.0f);
                AppMethodBeat.o(218314);
                return cMTime2;
            }
        }
        CMTime add = this.currentDecoderState.getTime().add(this.pFrameTime);
        AppMethodBeat.o(218314);
        return add;
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public synchronized Surface outputSurface() {
        return this.outputSurface;
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public TextureInfo getTextureInfo() {
        return null;
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public long getPreReadCost() {
        return this.preReadCost;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized boolean hasTrack() {
        return this.trackIndex != -1;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public String getSourcePath() {
        AppMethodBeat.i(218315);
        if (this.extractor == null) {
            AppMethodBeat.o(218315);
            return null;
        }
        String sourcePath = this.extractor.getSourcePath();
        AppMethodBeat.o(218315);
        return sourcePath;
    }

    public boolean isStarted() {
        return this.started;
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public boolean isLastFrameValid() {
        return this.lastFrameValid;
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public void switchFrame() {
    }

    private void clearDecoder() {
        AppMethodBeat.i(218316);
        Logger.d(this.TAG, "clearDecoder " + getSourcePath());
        releaseOutputBuffer();
        if (this.pendingFrames.size() != 0 || this.extractorDone) {
            try {
                this.mediaCodecWrapper.flushDecoder();
            } catch (Exception e2) {
                Logger.e(this.TAG, "flushDecoder", e2);
            }
            this.pendingFrames.clear();
        }
        this.currentDecoderState = new CMSampleState();
        AppMethodBeat.o(218316);
    }

    /* access modifiers changed from: package-private */
    public void releaseOutputBuffer() {
        AppMethodBeat.i(218317);
        if (this.lastOutputBufferIndex != -1) {
            try {
                this.mediaCodecWrapper.releaseOutputBuffer(this.lastOutputBufferIndex, false);
            } catch (Exception e2) {
                Logger.e(this.TAG, "releaseOutputBuffer", e2);
            }
            this.lastOutputBufferIndex = -1;
        }
        this.outputBuffer = null;
        AppMethodBeat.o(218317);
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public void release() {
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public synchronized void release(boolean z) {
        AppMethodBeat.i(218318);
        if (this.isReleased) {
            AppMethodBeat.o(218318);
        } else {
            Logger.i(this.TAG, "release:start ".concat(String.valueOf(z)));
            if (z) {
                this.extractor.dispose();
                this.extractor = null;
            }
            if (this.mirrorExtractor != null) {
                this.mirrorExtractor.dispose();
                this.mirrorExtractor = null;
            }
            this.started = false;
            this.isReleased = true;
            this.mediaCodecWrapper.release();
            Logger.i(this.TAG, "release:end ".concat(String.valueOf(z)));
            AppMethodBeat.o(218318);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(218319);
        super.finalize();
        release(false);
        AppMethodBeat.o(218319);
    }

    /* access modifiers changed from: package-private */
    public static class PendingFrame {
        private CMTime seekStartTime;
        private long timeOffset;

        private PendingFrame() {
            this.timeOffset = 0;
            this.seekStartTime = CMTime.CMTimeZero;
        }
    }

    /* access modifiers changed from: package-private */
    public class SampleTime {
        private CMSampleState sampleState;
        private long timeUs;

        private SampleTime() {
        }

        static /* synthetic */ void access$900(SampleTime sampleTime) {
            AppMethodBeat.i(218294);
            sampleTime.fixCMTime();
            AppMethodBeat.o(218294);
        }

        private void fixCMTime() {
            AppMethodBeat.i(218292);
            if (!this.sampleState.getTime().smallThan(CMTime.CMTimeZero)) {
                AppMethodBeat.o(218292);
                return;
            }
            this.sampleState = new CMSampleState(CMTime.fromUs(VideoDecoder.this.frameDurationUs));
            AppMethodBeat.o(218292);
        }

        public String toString() {
            AppMethodBeat.i(218293);
            String str = "SampleTime{sampleState=" + this.sampleState + ", timeUs=" + this.timeUs + '}';
            AppMethodBeat.o(218293);
            return str;
        }
    }
}
