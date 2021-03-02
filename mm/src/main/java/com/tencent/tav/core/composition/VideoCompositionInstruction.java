package com.tencent.tav.core.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.compositing.IVideoCompositionInstruction;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.List;

public class VideoCompositionInstruction implements IVideoCompositionInstruction {
    protected int backgroundColor;
    protected boolean enablePostProcessing;
    protected List<VideoCompositionLayerInstruction> layerInstructions = new ArrayList();
    protected int passthroughTrackID = -1;
    protected List<Integer> requiredSourceTrackIDs = new ArrayList();
    protected CMTimeRange timeRange;

    public VideoCompositionInstruction() {
        AppMethodBeat.i(218049);
        AppMethodBeat.o(218049);
    }

    @Override // com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    @Override // com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public List<? extends VideoCompositionLayerInstruction> getLayerInstructions() {
        return this.layerInstructions;
    }

    @Override // com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public boolean isEnablePostProcessing() {
        return this.enablePostProcessing;
    }

    @Override // com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public List<Integer> getRequiredSourceTrackIDs() {
        return this.requiredSourceTrackIDs;
    }

    @Override // com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public int getPassthroughTrackID() {
        return this.passthroughTrackID;
    }
}
