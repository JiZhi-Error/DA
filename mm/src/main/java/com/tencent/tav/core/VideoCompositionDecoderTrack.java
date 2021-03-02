package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.compositing.VideoCompositionRenderContext;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.VideoDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.List;

public class VideoCompositionDecoderTrack implements IDecoderTrack {
    private static final String TAG = "VideoComDecoderTrack";
    private static final int WAIT_TIME = 200;
    private Asset asset;
    private AssetExtension assetExtension;
    private List<AssetTrack> assetTrackList = new ArrayList();
    private boolean asynced = true;
    private List<IDecoderTrack> decoderTrackList = new ArrayList();
    private CMTime frameDuration = new CMTime(1, 30);
    private int frameRate = 30;
    private CMSampleState lastSampleState = new CMSampleState();
    private VideoCompositionRenderContext renderContext;
    private int trackId;
    private VideoCompositing videoCompositing;
    private VideoComposition videoComposition;

    public Asset getAsset() {
        return this.asset;
    }

    public VideoComposition getVideoComposition() {
        return this.videoComposition;
    }

    public void setVideoComposition(VideoComposition videoComposition2) {
        this.videoComposition = videoComposition2;
    }

    public VideoCompositing getVideoCompositing() {
        return this.videoCompositing;
    }

    public void setVideoCompositing(VideoCompositing videoCompositing2) {
        this.videoCompositing = videoCompositing2;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getFrameRate() {
        return this.frameRate;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getFrameDuration() {
        return this.frameDuration;
    }

    public void setFrameDuration(CMTime cMTime) {
        this.frameDuration = cMTime;
    }

    public VideoCompositionRenderContext getRenderContext() {
        return this.renderContext;
    }

    public void setRenderContext(VideoCompositionRenderContext videoCompositionRenderContext) {
        this.renderContext = videoCompositionRenderContext;
    }

    public VideoCompositionDecoderTrack(Asset asset2, AssetExtension assetExtension2, int i2) {
        AppMethodBeat.i(217932);
        this.asset = asset2;
        this.assetExtension = assetExtension2;
        this.trackId = i2;
        AppMethodBeat.o(217932);
    }

    public synchronized void addTrack(AssetTrack assetTrack) {
        AppMethodBeat.i(217933);
        this.assetTrackList.add(assetTrack);
        AppMethodBeat.o(217933);
    }

    public synchronized void removeTrack(AssetTrack assetTrack) {
        AppMethodBeat.i(217934);
        this.assetTrackList.remove(assetTrack);
        AppMethodBeat.o(217934);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start() {
        AppMethodBeat.i(217935);
        start(null);
        AppMethodBeat.o(217935);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator) {
        AppMethodBeat.i(217936);
        start(surfaceCreator, null);
        AppMethodBeat.o(217936);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator, CMTimeRange cMTimeRange) {
        CMTimeRange cMTimeRange2;
        AppMethodBeat.i(217937);
        Logger.d(TAG, "start:[start] " + cMTimeRange + " size - " + this.assetTrackList.size());
        this.renderContext = new VideoCompositionRenderContext((RenderContext) surfaceCreator);
        this.renderContext.setVideoComposition(this.videoComposition);
        for (AssetTrack assetTrack : this.assetTrackList) {
            if (assetTrack.getMediaType() == 1) {
                VideoDecoderTrack videoDecoderTrack = new VideoDecoderTrack(assetTrack);
                this.decoderTrackList.add(videoDecoderTrack);
                if (cMTimeRange != null) {
                    cMTimeRange2 = cMTimeRange;
                } else {
                    CMTimeRange timeRange = assetTrack.getTimeRange();
                    cMTimeRange2 = timeRange == null ? null : new CMTimeRange(timeRange.getStart(), timeRange.getDuration());
                }
                videoDecoderTrack.start(surfaceCreator, cMTimeRange2);
            }
        }
        AppMethodBeat.o(217937);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setFrameRate(int i2) {
        AppMethodBeat.i(217938);
        this.frameRate = i2;
        for (IDecoderTrack iDecoderTrack : this.decoderTrackList) {
            iDecoderTrack.setFrameRate(i2);
        }
        AppMethodBeat.o(217938);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setVolume(float f2) {
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getTrackId() {
        return this.trackId;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setDecodeType(IDecoder.DecodeType decodeType) {
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setTrackSegments(List<DecoderTrackSegment> list) {
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void clipRangeAndClearRange(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(217939);
        for (IDecoderTrack iDecoderTrack : this.decoderTrackList) {
            iDecoderTrack.clipRangeAndClearRange(cMTimeRange);
        }
        AppMethodBeat.o(217939);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer seekTo(CMTime cMTime, boolean z, boolean z2) {
        AppMethodBeat.i(217940);
        Logger.d(TAG, "seekTo:[timeUs " + cMTime + "] [needRead " + z + "] [quickSeek " + z2 + "]");
        if (!cMTime.equals(this.lastSampleState.getTime())) {
            for (IDecoderTrack iDecoderTrack : this.decoderTrackList) {
                iDecoderTrack.seekTo(cMTime, false, z2);
            }
        }
        if (cMTime.bigThan(this.frameDuration)) {
            this.lastSampleState = new CMSampleState(cMTime.sub(this.frameDuration));
        } else {
            this.lastSampleState = new CMSampleState(cMTime);
        }
        if (z) {
            CMSampleBuffer readSample = readSample();
            AppMethodBeat.o(217940);
            return readSample;
        }
        AppMethodBeat.o(217940);
        return null;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample() {
        AppMethodBeat.i(217941);
        if (this.lastSampleState.stateMatchingTo(-100) || this.lastSampleState.isInvalid()) {
            CMSampleBuffer readSample = readSample(CMTime.CMTimeZero);
            AppMethodBeat.o(217941);
            return readSample;
        }
        CMSampleBuffer readSample2 = readSample(this.lastSampleState.getTime().add(this.frameDuration));
        AppMethodBeat.o(217941);
        return readSample2;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample(CMTime cMTime) {
        AppMethodBeat.i(217942);
        Logger.v(TAG, "readSample:[targetTime " + cMTime + "]" + this.videoCompositing);
        if (this.videoCompositing == null) {
            this.lastSampleState = CMSampleState.fromError(-3);
            Logger.v(TAG, "readSample: failed 2 " + this.lastSampleState);
            CMSampleBuffer cMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-3));
            AppMethodBeat.o(217942);
            return cMSampleBuffer;
        }
        if (cMTime.getValue() < 0) {
            cMTime = this.lastSampleState.getTime().add(this.frameDuration);
        }
        AsynchronousVideoCompositionRequest createVideoCompositionRequest = createVideoCompositionRequest(cMTime);
        CMSampleBuffer readSampleToRequest = readSampleToRequest(cMTime, createVideoCompositionRequest);
        if (readSampleToRequest != null) {
            AppMethodBeat.o(217942);
            return readSampleToRequest;
        } else if (createVideoCompositionRequest.getSourceTrackIDs().size() == 0) {
            Logger.v(TAG, "readSample: finish 2");
            CMSampleBuffer cMSampleBuffer2 = new CMSampleBuffer(CMSampleState.fromError(-1));
            AppMethodBeat.o(217942);
            return cMSampleBuffer2;
        } else {
            Logger.v(TAG, "readSample: startVideoCompositionRequest ");
            this.videoCompositing.startVideoCompositionRequest(createVideoCompositionRequest);
            Logger.v(TAG, "readSample: startVideoCompositionRequest finish ");
            CMSampleBuffer sampleFromRequest = getSampleFromRequest(createVideoCompositionRequest);
            AppMethodBeat.o(217942);
            return sampleFromRequest;
        }
    }

    private AsynchronousVideoCompositionRequest createVideoCompositionRequest(CMTime cMTime) {
        AppMethodBeat.i(217943);
        AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest = new AsynchronousVideoCompositionRequest(this, this.assetExtension);
        asynchronousVideoCompositionRequest.setRenderContext(this.renderContext);
        asynchronousVideoCompositionRequest.setCompositionTime(cMTime);
        if (this.videoComposition != null) {
            asynchronousVideoCompositionRequest.setVideoCompositionInstruction(VideoComposition.findInstruction(this.videoComposition, cMTime));
        }
        AppMethodBeat.o(217943);
        return asynchronousVideoCompositionRequest;
    }

    private CMSampleBuffer readSampleToRequest(CMTime cMTime, AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest) {
        AppMethodBeat.i(217944);
        for (IDecoderTrack iDecoderTrack : this.decoderTrackList) {
            CMSampleBuffer readSample = iDecoderTrack.readSample(cMTime);
            if (readSample.getState().stateMatchingTo(-3, -2, -100)) {
                this.lastSampleState = new CMSampleState(readSample.getTime());
                Logger.e(TAG, "readSample: failed 0 " + readSample.getTime());
                CMSampleBuffer cMSampleBuffer = new CMSampleBuffer(readSample.getState(), (TextureInfo) null);
                AppMethodBeat.o(217944);
                return cMSampleBuffer;
            }
            if (!readSample.getState().stateMatchingTo(-1)) {
                asynchronousVideoCompositionRequest.appendCMSampleBuffer(readSample, iDecoderTrack.getTrackId());
            } else if (this.decoderTrackList.size() <= 1) {
                Logger.d(TAG, "readSample: finish 1");
                AppMethodBeat.o(217944);
                return readSample;
            }
        }
        AppMethodBeat.o(217944);
        return null;
    }

    private CMSampleBuffer getSampleFromRequest(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest) {
        AppMethodBeat.i(217945);
        synchronized (this) {
            try {
                if (asynchronousVideoCompositionRequest.getStatus() == Integer.MIN_VALUE) {
                    waitForRequestFinish(200);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(217945);
                throw th;
            }
        }
        switch (asynchronousVideoCompositionRequest.getStatus()) {
            case 0:
                this.lastSampleState = asynchronousVideoCompositionRequest.getComposedSampleBuffer().getState();
                CMSampleBuffer composedSampleBuffer = asynchronousVideoCompositionRequest.getComposedSampleBuffer();
                AppMethodBeat.o(217945);
                return composedSampleBuffer;
            default:
                this.lastSampleState = CMSampleState.fromError(-3);
                Logger.e(TAG, "readSample: failed 1 " + this.lastSampleState);
                CMSampleBuffer cMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-3));
                AppMethodBeat.o(217945);
                return cMSampleBuffer;
        }
    }

    private void waitForRequestFinish(int i2) {
        AppMethodBeat.i(217946);
        synchronized (this) {
            try {
                wait((long) i2);
            } catch (Exception e2) {
            }
            try {
            } catch (Throwable th) {
                AppMethodBeat.o(217946);
                throw th;
            }
        }
        AppMethodBeat.o(217946);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void asyncReadNextSample(CMTime cMTime) {
        AppMethodBeat.i(217947);
        if (!this.asynced) {
            AppMethodBeat.o(217947);
            return;
        }
        for (IDecoderTrack iDecoderTrack : this.decoderTrackList) {
            iDecoderTrack.asyncReadNextSample(cMTime);
        }
        AppMethodBeat.o(217947);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getDuration() {
        AppMethodBeat.i(217948);
        CMTime cMTime = CMTime.CMTimeZero;
        for (IDecoderTrack iDecoderTrack : this.decoderTrackList) {
            cMTime = iDecoderTrack.getDuration();
            if (!cMTime.bigThan(cMTime)) {
                cMTime = cMTime;
            }
        }
        AppMethodBeat.o(217948);
        return cMTime;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getCurrentSampleTime() {
        AppMethodBeat.i(217949);
        CMTime time = this.lastSampleState.getTime();
        AppMethodBeat.o(217949);
        return time;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void release() {
        AppMethodBeat.i(217950);
        Logger.d(TAG, "release:start ".concat(String.valueOf(this)));
        for (IDecoderTrack iDecoderTrack : this.decoderTrackList) {
            iDecoderTrack.release();
        }
        this.decoderTrackList.clear();
        this.assetTrackList.clear();
        this.videoComposition = null;
        this.videoCompositing = null;
        this.renderContext = null;
        Logger.d(TAG, "release:finish ".concat(String.valueOf(this)));
        AppMethodBeat.o(217950);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public long getLaggingTime() {
        AppMethodBeat.i(217951);
        long j2 = 0;
        for (IDecoderTrack iDecoderTrack : this.decoderTrackList) {
            j2 = iDecoderTrack.getLaggingTime() + j2;
        }
        AppMethodBeat.o(217951);
        return j2;
    }
}
