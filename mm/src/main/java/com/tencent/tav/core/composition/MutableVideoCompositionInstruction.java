package com.tencent.tav.core.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.List;

public class MutableVideoCompositionInstruction extends VideoCompositionInstruction {
    public void setTimeRange(CMTimeRange cMTimeRange) {
        this.timeRange = cMTimeRange;
    }

    public void setBackgroundColor(int i2) {
        this.backgroundColor = i2;
    }

    public void setLayerInstructions(List<VideoCompositionLayerInstruction> list) {
        AppMethodBeat.i(218028);
        this.layerInstructions.clear();
        this.layerInstructions.addAll(list);
        this.requiredSourceTrackIDs.clear();
        for (VideoCompositionLayerInstruction videoCompositionLayerInstruction : list) {
            this.requiredSourceTrackIDs.add(Integer.valueOf(videoCompositionLayerInstruction.getTrackID()));
        }
        AppMethodBeat.o(218028);
    }

    public void setEnablePostProcessing(boolean z) {
        this.enablePostProcessing = z;
    }
}
