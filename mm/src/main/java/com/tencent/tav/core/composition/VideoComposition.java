package com.tencent.tav.core.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.Composition;
import com.tencent.tav.core.VideoCompositor;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VideoComposition {
    private static final String TAG = "VideoComposition";
    private Asset asset;
    private Class<? extends VideoCompositing> customVideoCompositorClass;
    private CMTime frameDuration;
    private List<? extends VideoCompositionInstruction> instructions;
    private RenderLayoutMode renderLayoutMode;
    private float renderScale;
    private CGSize renderSize;
    private int sourceTrackIDForFrameTiming;

    public enum RenderLayoutMode {
        aspectFit,
        aspectFill;

        public static RenderLayoutMode valueOf(String str) {
            AppMethodBeat.i(218042);
            RenderLayoutMode renderLayoutMode = (RenderLayoutMode) Enum.valueOf(RenderLayoutMode.class, str);
            AppMethodBeat.o(218042);
            return renderLayoutMode;
        }

        static {
            AppMethodBeat.i(218043);
            AppMethodBeat.o(218043);
        }
    }

    public VideoComposition(Asset asset2) {
        AppMethodBeat.i(218044);
        this.asset = asset2;
        this.instructions = new ArrayList();
        fillSourceProperty();
        AppMethodBeat.o(218044);
    }

    private void fillSourceProperty() {
        CMTime cMTime;
        AppMethodBeat.i(218045);
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
        this.instructions = new ArrayList();
        if (tracksWithMediaType != null && !(this.asset instanceof Composition)) {
            for (AssetTrack assetTrack3 : tracksWithMediaType) {
                VideoCompositionInstruction videoCompositionInstruction = new VideoCompositionInstruction();
                videoCompositionInstruction.backgroundColor = WebView.NIGHT_MODE_COLOR;
                videoCompositionInstruction.enablePostProcessing = true;
                videoCompositionInstruction.passthroughTrackID = assetTrack3.getTrackID();
                videoCompositionInstruction.timeRange = new CMTimeRange(CMTime.CMTimeZero, assetTrack3.getDuration());
                videoCompositionInstruction.requiredSourceTrackIDs = Arrays.asList(Integer.valueOf(assetTrack3.getTrackID()));
                MutableVideoCompositionLayerInstruction mutableVideoCompositionLayerInstruction = new MutableVideoCompositionLayerInstruction();
                mutableVideoCompositionLayerInstruction.setTrackID(assetTrack3.getTrackID());
                mutableVideoCompositionLayerInstruction.setTransformRampFromStartTransform(null, null, videoCompositionInstruction.timeRange);
                mutableVideoCompositionLayerInstruction.setCropRectangleRampFromStartCropRectangle(null, null, videoCompositionInstruction.timeRange);
                mutableVideoCompositionLayerInstruction.setOpacityRampFromStartOpacity(1.0f, 1.0f, videoCompositionInstruction.timeRange);
                videoCompositionInstruction.layerInstructions.add(mutableVideoCompositionLayerInstruction);
            }
        }
        this.renderScale = 1.0f;
        AppMethodBeat.o(218045);
    }

    public VideoComposition() {
    }

    public VideoCompositing getCustomVideoCompositor() {
        VideoCompositing videoCompositor;
        AppMethodBeat.i(218046);
        if (this.customVideoCompositorClass != null) {
            try {
                videoCompositor = (VideoCompositing) this.customVideoCompositorClass.newInstance();
            } catch (InstantiationException e2) {
                videoCompositor = new VideoCompositor();
            } catch (IllegalAccessException e3) {
                videoCompositor = new VideoCompositor();
            }
            AppMethodBeat.o(218046);
            return videoCompositor;
        }
        VideoCompositor videoCompositor2 = new VideoCompositor();
        AppMethodBeat.o(218046);
        return videoCompositor2;
    }

    public Class<? extends VideoCompositing> getCustomVideoCompositorClass() {
        return this.customVideoCompositorClass;
    }

    public CMTime getFrameDuration() {
        return this.frameDuration;
    }

    public int getSourceTrackIDForFrameTiming() {
        return this.sourceTrackIDForFrameTiming;
    }

    public CGSize getRenderSize() {
        return this.renderSize;
    }

    public RenderLayoutMode getRenderLayoutMode() {
        return this.renderLayoutMode;
    }

    public float getRenderScale() {
        return this.renderScale;
    }

    public <T extends VideoCompositionInstruction> List<T> getInstructions() {
        return (List<T>) this.instructions;
    }

    public static VideoCompositionInstruction findInstruction(VideoComposition videoComposition, CMTime cMTime) {
        VideoCompositionInstruction videoCompositionInstruction = null;
        AppMethodBeat.i(218047);
        if (videoComposition.getInstructions() == null) {
            AppMethodBeat.o(218047);
            return null;
        }
        for (VideoCompositionInstruction videoCompositionInstruction2 : videoComposition.getInstructions()) {
            if (videoCompositionInstruction2.getTimeRange() != null && (videoCompositionInstruction == null || videoCompositionInstruction.getTimeRange().getEnd().smallThan(videoCompositionInstruction2.getTimeRange().getEnd()))) {
                videoCompositionInstruction = videoCompositionInstruction2;
            }
            CMTimeRange timeRange = videoCompositionInstruction2.getTimeRange();
            if (timeRange != null && timeRange.getStartUs() <= cMTime.getTimeUs() && timeRange.getEndUs() > cMTime.getTimeUs()) {
                AppMethodBeat.o(218047);
                return videoCompositionInstruction2;
            }
        }
        AppMethodBeat.o(218047);
        return videoCompositionInstruction;
    }

    public String toString() {
        AppMethodBeat.i(218048);
        String str = "MutableVideoComposition{, frameDuration=" + this.frameDuration + ", renderSize=" + this.renderSize + ", renderLayoutMode=" + this.renderLayoutMode + ", instructions=" + this.instructions + '}';
        AppMethodBeat.o(218048);
        return str;
    }
}
