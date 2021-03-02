package com.tencent.tav.decoder.decodecache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CachedVideoDecoderTrack implements IDecoderTrack {
    private static final String TAG = "CachedVideoTrack";
    private CacheSegment currentFrameSegment;
    private CMSampleState lastSampleState = new CMSampleState();
    final Object nextFrameDecoderLock = new Object();
    private CacheSegment nextFrameSegment;
    RenderContext renderContext;
    boolean revert;
    private SegmentDecoderThread segmentDecoder;
    private int segmentSize = 60;
    CMTimeRange validTimeRange;

    public CachedVideoDecoderTrack(IDecoderTrack iDecoderTrack, boolean z) {
        AppMethodBeat.i(218400);
        this.revert = z;
        this.segmentDecoder = new SegmentDecoderThread(this, iDecoderTrack);
        AppMethodBeat.o(218400);
    }

    public void setRevert(boolean z) {
        this.revert = z;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start() {
        AppMethodBeat.i(218401);
        start(null);
        AppMethodBeat.o(218401);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator) {
        AppMethodBeat.i(218402);
        start(surfaceCreator, null);
        AppMethodBeat.o(218402);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator, CMTimeRange cMTimeRange) {
        AppMethodBeat.i(218403);
        this.validTimeRange = cMTimeRange;
        this.renderContext = (RenderContext) surfaceCreator;
        this.segmentDecoder.startForReady();
        AppMethodBeat.o(218403);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setFrameRate(int i2) {
        AppMethodBeat.i(218404);
        this.segmentDecoder.decoderTrack.setFrameRate(i2);
        AppMethodBeat.o(218404);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getFrameRate() {
        AppMethodBeat.i(218405);
        int frameRate = this.segmentDecoder.decoderTrack.getFrameRate();
        AppMethodBeat.o(218405);
        return frameRate;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getFrameDuration() {
        AppMethodBeat.i(218406);
        CMTime frameDuration = this.segmentDecoder.decoderTrack.getFrameDuration();
        AppMethodBeat.o(218406);
        return frameDuration;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setVolume(float f2) {
        AppMethodBeat.i(218407);
        this.segmentDecoder.decoderTrack.setVolume(f2);
        AppMethodBeat.o(218407);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getTrackId() {
        AppMethodBeat.i(218408);
        int trackId = this.segmentDecoder.decoderTrack.getTrackId();
        AppMethodBeat.o(218408);
        return trackId;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setDecodeType(IDecoder.DecodeType decodeType) {
        AppMethodBeat.i(218409);
        this.segmentDecoder.decoderTrack.setDecodeType(decodeType);
        AppMethodBeat.o(218409);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setTrackSegments(List<DecoderTrackSegment> list) {
        AppMethodBeat.i(218410);
        this.segmentDecoder.decoderTrack.setTrackSegments(list);
        AppMethodBeat.o(218410);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void clipRangeAndClearRange(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(218411);
        this.segmentDecoder.decoderTrack.clipRangeAndClearRange(cMTimeRange);
        AppMethodBeat.o(218411);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer seekTo(CMTime cMTime, boolean z, boolean z2) {
        AppMethodBeat.i(218412);
        Logger.v(TAG, "seekTo: PlayerThreadMain ".concat(String.valueOf(cMTime)));
        if (cMTime.bigThan(getFrameDuration())) {
            this.lastSampleState = new CMSampleState(cMTime.sub(getFrameDuration()));
        } else {
            this.lastSampleState = new CMSampleState(cMTime);
        }
        if (this.currentFrameSegment != null) {
            this.currentFrameSegment.clear();
            this.currentFrameSegment = null;
        }
        if (this.nextFrameSegment != null) {
            this.nextFrameSegment.clear();
            this.nextFrameSegment = null;
        }
        if (z) {
            CMSampleBuffer decoderFrame = decoderFrame(new CMTime(((float) (((cMTime.getTimeUs() / getFrameDuration().getTimeUs()) + ((long) (cMTime.getTimeUs() % getFrameDuration().getTimeUs() > 0 ? 1 : 0))) * getFrameDuration().getTimeUs())) / 1000000.0f));
            this.lastSampleState = decoderFrame == null ? CMSampleState.fromError(-1) : decoderFrame.getState();
            AppMethodBeat.o(218412);
            return decoderFrame;
        }
        AppMethodBeat.o(218412);
        return null;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample() {
        AppMethodBeat.i(218413);
        if (this.lastSampleState.isInvalid()) {
            CMSampleBuffer readSample = readSample(CMTime.CMTimeZero);
            AppMethodBeat.o(218413);
            return readSample;
        } else if (this.lastSampleState.getTime().smallThan(CMTime.CMTimeZero)) {
            CMSampleBuffer cMSampleBuffer = new CMSampleBuffer(this.lastSampleState);
            AppMethodBeat.o(218413);
            return cMSampleBuffer;
        } else {
            CMSampleBuffer readSample2 = readSample(this.lastSampleState.getTime().add(getFrameDuration()));
            AppMethodBeat.o(218413);
            return readSample2;
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample(CMTime cMTime) {
        CacheFrame popFrame;
        AppMethodBeat.i(218414);
        if (cMTime.smallThan(CMTime.CMTimeZero)) {
            CMSampleBuffer readSample = readSample();
            AppMethodBeat.o(218414);
            return readSample;
        }
        Logger.v(TAG, "readSample: targetTime = ".concat(String.valueOf(cMTime)));
        if (this.currentFrameSegment != null && (popFrame = this.currentFrameSegment.popFrame(cMTime)) != null) {
            this.lastSampleState = new CMSampleState(popFrame.frameTime);
            Logger.v(TAG, "readSample: hint currentSegment " + ((popFrame.sampleBuffer == null || popFrame.sampleBuffer.getTextureInfo() == null) ? false : true) + "  " + (popFrame.sampleBuffer != null ? Boolean.valueOf(popFrame.sampleBuffer.isNewFrame()) : BuildConfig.COMMAND) + " time = " + popFrame.realFrameTime + "  " + popFrame.frameTime);
            CMSampleBuffer cMSampleBuffer = popFrame.sampleBuffer;
            AppMethodBeat.o(218414);
            return cMSampleBuffer;
        } else if (!cMTime.smallThan(getDuration())) {
            this.lastSampleState = CMSampleState.fromError(-1);
            CMSampleBuffer cMSampleBuffer2 = new CMSampleBuffer(CMSampleState.fromError(-1));
            AppMethodBeat.o(218414);
            return cMSampleBuffer2;
        } else {
            CMSampleBuffer decoderSegment = decoderSegment(cMTime);
            if (decoderSegment != null) {
                Logger.v(TAG, "readSample: hint currentSegment - " + decoderSegment.getTime());
                AppMethodBeat.o(218414);
                return decoderSegment;
            } else if (cMTime.bigThan(getDuration())) {
                this.lastSampleState = CMSampleState.fromError(-1);
                CMSampleBuffer cMSampleBuffer3 = new CMSampleBuffer(CMSampleState.fromError(-1));
                AppMethodBeat.o(218414);
                return cMSampleBuffer3;
            } else {
                this.lastSampleState = CMSampleState.fromError(-3);
                CMSampleBuffer cMSampleBuffer4 = new CMSampleBuffer(CMSampleState.fromError(-3));
                AppMethodBeat.o(218414);
                return cMSampleBuffer4;
            }
        }
    }

    private CMSampleBuffer decoderFrame(CMTime cMTime) {
        AppMethodBeat.i(218415);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.segmentDecoder.decoderSegment(cMTime, countDownLatch);
        try {
            countDownLatch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
        }
        CMSampleBuffer cMSampleBuffer = this.segmentDecoder.seekSampleBuffer;
        AppMethodBeat.o(218415);
        return cMSampleBuffer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x011e, code lost:
        r9.segmentDecoder.cancel = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.tav.coremedia.CMSampleBuffer decoderSegment(com.tencent.tav.coremedia.CMTime r10) {
        /*
        // Method dump skipped, instructions count: 566
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.decoder.decodecache.CachedVideoDecoderTrack.decoderSegment(com.tencent.tav.coremedia.CMTime):com.tencent.tav.coremedia.CMSampleBuffer");
    }

    private void clearCurrentFrameSegment() {
        AppMethodBeat.i(218417);
        if (this.currentFrameSegment != null) {
            this.currentFrameSegment.clear();
            this.currentFrameSegment = null;
        }
        AppMethodBeat.o(218417);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void asyncReadNextSample(CMTime cMTime) {
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getDuration() {
        AppMethodBeat.i(218418);
        CMTime duration = this.segmentDecoder.decoderTrack.getDuration();
        AppMethodBeat.o(218418);
        return duration;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getCurrentSampleTime() {
        AppMethodBeat.i(218419);
        CMTime time = this.lastSampleState.getTime();
        AppMethodBeat.o(218419);
        return time;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void release() {
        AppMethodBeat.i(218420);
        if (this.currentFrameSegment != null) {
            this.currentFrameSegment.clear();
        }
        if (this.nextFrameSegment != null) {
            this.nextFrameSegment.clear();
        }
        synchronized (this.nextFrameDecoderLock) {
            try {
                if (this.segmentDecoder != null) {
                    this.segmentDecoder.release();
                    this.segmentDecoder = null;
                }
            } finally {
                AppMethodBeat.o(218420);
            }
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public long getLaggingTime() {
        return 0;
    }

    public void setMaxFrameCacheSize(int i2) {
        AppMethodBeat.i(218421);
        if (i2 > 0) {
            this.segmentSize = i2;
            if (this.segmentDecoder != null) {
                this.segmentDecoder.texturePool.setMaxCacheLength(i2);
            }
        }
        AppMethodBeat.o(218421);
    }
}
