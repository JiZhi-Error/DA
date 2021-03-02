package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.decodecache.CachedVideoDecoderTrack;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AssetReaderVideoCompositionOutput extends AssetReaderOutput {
    private AssetExtension assetExtension;
    private AssetReader assetReader;
    private IContextCreate contextCreate;
    private VideoCompositing customVideoCompositor = new VideoCompositor();
    private boolean decoderStarted = false;
    private int frameRate = -1;
    private boolean readFirstFrame = false;
    private boolean revertMode = false;
    private VideoCompositing videoCompositing;
    private VideoComposition videoComposition;
    private IDecoderTrack videoDecoderTrack;
    private Map<String, Object> videoSettings;
    private List<AssetTrack> videoTracks;

    public List<AssetTrack> getVideoTracks() {
        return this.videoTracks;
    }

    public Map<String, Object> getVideoSettings() {
        return this.videoSettings;
    }

    public VideoComposition getVideoComposition() {
        return this.videoComposition;
    }

    public void setVideoComposition(VideoComposition videoComposition2) {
        this.videoComposition = videoComposition2;
    }

    public void setVideoCompositing(VideoCompositing videoCompositing2) {
        this.videoCompositing = videoCompositing2;
    }

    public AssetReaderVideoCompositionOutput(List<AssetTrack> list, Map<String, Object> map, AssetExtension assetExtension2) {
        AppMethodBeat.i(217783);
        this.videoTracks = list;
        this.videoSettings = map;
        this.assetExtension = assetExtension2;
        this.mediaType = 1;
        if (map != null && map.containsKey("frame-rate")) {
            this.frameRate = ((Integer) map.get("frame-rate")).intValue();
        }
        AppMethodBeat.o(217783);
    }

    private void tryStartDecoder() {
        AppMethodBeat.i(217784);
        if (!this.decoderStarted) {
            this.decoderStarted = true;
            this.videoDecoderTrack.setFrameRate(this.frameRate);
            this.videoDecoderTrack.start(this.contextCreate == null ? null : this.contextCreate.renderContext());
            this.videoDecoderTrack.seekTo(this.assetReader.getTimeRange().getStart(), false, true);
        }
        AppMethodBeat.o(217784);
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public synchronized CMSampleBuffer nextSampleBuffer() {
        CMSampleBuffer cMSampleBuffer;
        AppMethodBeat.i(217785);
        if (this.videoDecoderTrack != null) {
            tryStartDecoder();
            if (this.videoDecoderTrack == null) {
                cMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-100));
            } else if (this.readFirstFrame) {
                cMSampleBuffer = this.videoDecoderTrack.readSample();
            } else {
                cMSampleBuffer = this.videoDecoderTrack.readSample(this.assetReader.getTimeRange().getStart());
                this.readFirstFrame = true;
            }
            if (cMSampleBuffer.getTime().smallThan(this.assetReader.getTimeRange().getStart())) {
                AppMethodBeat.o(217785);
            } else if (cMSampleBuffer.getTime().smallThan(this.assetReader.getTimeRange().getEnd())) {
                this.videoDecoderTrack.asyncReadNextSample(cMSampleBuffer.getTime());
                CMSampleBuffer cMSampleBuffer2 = new CMSampleBuffer(cMSampleBuffer.getTime().sub(this.assetReader.getTimeRange().getStart()), cMSampleBuffer.getTextureInfo(), cMSampleBuffer.isNewFrame());
                AppMethodBeat.o(217785);
                cMSampleBuffer = cMSampleBuffer2;
            } else {
                cMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-1));
                AppMethodBeat.o(217785);
            }
        } else {
            cMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-100));
            AppMethodBeat.o(217785);
        }
        return cMSampleBuffer;
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void resetForReadingTimeRanges(List<CMTimeRange> list) {
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void markConfigurationAsFinal() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.tav.core.AssetReaderOutput
    public void start(IContextCreate iContextCreate, AssetReader assetReader2) {
        int i2;
        AppMethodBeat.i(217786);
        this.assetReader = assetReader2;
        VideoCompositionDecoderTrack videoCompositionDecoderTrack = new VideoCompositionDecoderTrack(assetReader2.getAsset(), this.assetExtension, 1);
        int i3 = this.frameRate;
        Iterator<AssetTrack> it = this.videoTracks.iterator();
        while (true) {
            i2 = i3;
            if (!it.hasNext()) {
                break;
            }
            AssetTrack next = it.next();
            if (next != null && next.isEnabled()) {
                videoCompositionDecoderTrack.addTrack(next);
                if (next.getNominalFrameRate() > 0.0f && this.frameRate < 0) {
                    i2 = (int) Math.min(next.getNominalFrameRate(), (float) i2);
                }
            }
            i3 = i2;
        }
        if (i2 <= 0) {
            i2 = 30;
        }
        videoCompositionDecoderTrack.setVideoComposition(this.videoComposition);
        videoCompositionDecoderTrack.setVideoCompositing(this.videoCompositing);
        videoCompositionDecoderTrack.setFrameRate(i2);
        videoCompositionDecoderTrack.setFrameDuration(new CMTime(1, i2));
        this.contextCreate = iContextCreate;
        if (this.revertMode) {
            this.videoDecoderTrack = new CachedVideoDecoderTrack(videoCompositionDecoderTrack, true);
            AppMethodBeat.o(217786);
            return;
        }
        this.videoDecoderTrack = videoCompositionDecoderTrack;
        AppMethodBeat.o(217786);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.tav.core.AssetReaderOutput
    public synchronized void release() {
        AppMethodBeat.i(217787);
        if (this.videoDecoderTrack != null) {
            this.videoDecoderTrack.release();
        }
        AppMethodBeat.o(217787);
    }

    public void setVideoRevertMode(boolean z) {
        this.revertMode = z;
    }
}
