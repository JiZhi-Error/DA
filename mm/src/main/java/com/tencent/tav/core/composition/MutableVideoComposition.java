package com.tencent.tav.core.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.Composition;
import com.tencent.tav.core.VideoCompositor;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import java.util.ArrayList;
import java.util.List;

public class MutableVideoComposition extends VideoComposition {
    private static final String TAG = "VideoComposition";
    private Asset asset;
    private Class<? extends VideoCompositing> customVideoCompositorClass;
    private CMTime frameDuration;
    private List<? extends VideoCompositionInstruction> instructions;
    private VideoComposition.RenderLayoutMode renderLayoutMode;
    private float renderScale;
    private CGSize renderSize;
    private int sourceTrackIDForFrameTiming;

    public MutableVideoComposition(Asset asset2) {
        AppMethodBeat.i(218024);
        this.asset = asset2;
        this.instructions = new ArrayList();
        fillSourceProperty();
        AppMethodBeat.o(218024);
    }

    private void fillSourceProperty() {
        CMTime cMTime;
        AppMethodBeat.i(218025);
        List<AssetTrack> tracksWithMediaType = this.asset.tracksWithMediaType(1);
        this.frameDuration = null;
        this.renderSize = null;
        if (tracksWithMediaType != null) {
            for (AssetTrack assetTrack : tracksWithMediaType) {
                if (this.frameDuration == null) {
                    cMTime = new CMTime(1, (int) assetTrack.getNominalFrameRate());
                } else {
                    cMTime = ((float) this.frameDuration.timeScale) > assetTrack.getNominalFrameRate() ? this.frameDuration : new CMTime(1, (int) assetTrack.getNominalFrameRate());
                }
                this.frameDuration = cMTime;
            }
        }
        if (this.frameDuration == null || this.frameDuration.timeScale == 0) {
            this.frameDuration = new CMTime(1, 30);
        }
        if (this.asset instanceof Composition) {
            this.renderSize = this.asset.getNaturalSize();
        } else if (tracksWithMediaType != null) {
            for (AssetTrack assetTrack2 : tracksWithMediaType) {
                if (this.renderSize == null) {
                    this.renderSize = assetTrack2.getNaturalSize();
                } else if (assetTrack2.getNaturalSize() != null) {
                    this.renderSize = new CGSize(Math.max(this.renderSize.width, assetTrack2.getNaturalSize().width), Math.max(this.renderSize.height, assetTrack2.getNaturalSize().height));
                }
            }
        }
        this.renderScale = 1.0f;
        AppMethodBeat.o(218025);
    }

    public MutableVideoComposition() {
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    public Class<? extends VideoCompositing> getCustomVideoCompositorClass() {
        return this.customVideoCompositorClass;
    }

    public void setCustomVideoCompositorClass(Class<? extends VideoCompositing> cls) {
        this.customVideoCompositorClass = cls;
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    public CMTime getFrameDuration() {
        return this.frameDuration;
    }

    public void setFrameDuration(CMTime cMTime) {
        this.frameDuration = cMTime;
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    public int getSourceTrackIDForFrameTiming() {
        return this.sourceTrackIDForFrameTiming;
    }

    public void setSourceTrackIDForFrameTiming(int i2) {
        this.sourceTrackIDForFrameTiming = i2;
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    public CGSize getRenderSize() {
        return this.renderSize;
    }

    public void setRenderSize(CGSize cGSize) {
        this.renderSize = cGSize;
    }

    public void setRenderLayoutMode(VideoComposition.RenderLayoutMode renderLayoutMode2) {
        this.renderLayoutMode = renderLayoutMode2;
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    public VideoComposition.RenderLayoutMode getRenderLayoutMode() {
        return this.renderLayoutMode;
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    public float getRenderScale() {
        return this.renderScale;
    }

    public void setRenderScale(float f2) {
        this.renderScale = f2;
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    public List<? extends VideoCompositionInstruction> getInstructions() {
        return this.instructions;
    }

    public void setInstructions(List<? extends VideoCompositionInstruction> list) {
        this.instructions = list;
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    public VideoCompositing getCustomVideoCompositor() {
        VideoCompositing videoCompositor;
        AppMethodBeat.i(218026);
        if (this.customVideoCompositorClass != null) {
            try {
                videoCompositor = (VideoCompositing) this.customVideoCompositorClass.newInstance();
            } catch (IllegalAccessException | InstantiationException e2) {
                videoCompositor = new VideoCompositor();
            }
            AppMethodBeat.o(218026);
            return videoCompositor;
        }
        VideoCompositor videoCompositor2 = new VideoCompositor();
        AppMethodBeat.o(218026);
        return videoCompositor2;
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    public String toString() {
        AppMethodBeat.i(218027);
        String str = "MutableVideoComposition{, frameDuration=" + this.frameDuration + ", renderSize=" + this.renderSize + ", renderLayoutMode=" + this.renderLayoutMode + ", instructions=" + this.instructions + '}';
        AppMethodBeat.o(218027);
        return str;
    }
}
