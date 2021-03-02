package com.tencent.tavkit.composition.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tav.core.composition.VideoCompositionInstruction;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.List;

public class TAVVideoCompositionInstruction extends VideoCompositionInstruction {
    private static final String TAG = "TAVVideoCompositionInst";
    private List<List<TAVVideoCompositionLayerInstruction>> channelLayers = new ArrayList();
    private TAVVideoEffect globalVideoEffect;
    private List<TAVVideoCompositionLayerInstruction> overlayLayers = new ArrayList();
    private TAVVideoEffect sourceVideoEffect;
    private final CMTimeRange timeRange;
    private TAVVideoMixEffect videoMixEffect;

    public TAVVideoCompositionInstruction(List<Integer> list, CMTimeRange cMTimeRange) {
        AppMethodBeat.i(197629);
        this.requiredSourceTrackIDs = list;
        this.timeRange = cMTimeRange;
        this.enablePostProcessing = false;
        this.backgroundColor = WebView.NIGHT_MODE_COLOR;
        AppMethodBeat.o(197629);
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionInstruction, com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionInstruction, com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionInstruction, com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public List<TAVVideoCompositionLayerInstruction> getLayerInstructions() {
        AppMethodBeat.i(197630);
        ArrayList arrayList = new ArrayList();
        for (List<TAVVideoCompositionLayerInstruction> list : this.channelLayers) {
            arrayList.addAll(list);
        }
        arrayList.addAll(this.overlayLayers);
        AppMethodBeat.o(197630);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<TAVVideoCompositionLayerInstruction> getOverlayLayers() {
        return this.overlayLayers;
    }

    public void setOverlayLayers(List<TAVVideoCompositionLayerInstruction> list) {
        AppMethodBeat.i(197631);
        if (list == null) {
            AppMethodBeat.o(197631);
            return;
        }
        this.overlayLayers = list;
        this.requiredSourceTrackIDs.clear();
        for (TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction : list) {
            this.requiredSourceTrackIDs.add(Integer.valueOf(tAVVideoCompositionLayerInstruction.getTrackID()));
        }
        AppMethodBeat.o(197631);
    }

    /* access modifiers changed from: package-private */
    public List<List<TAVVideoCompositionLayerInstruction>> getChannelLayers() {
        return this.channelLayers;
    }

    public void setChannelLayers(List<List<TAVVideoCompositionLayerInstruction>> list) {
        if (list != null) {
            this.channelLayers = list;
        }
    }

    public void setBackgroundColor(int i2) {
        this.backgroundColor = i2;
    }

    public void setEnablePostProcessing(boolean z) {
        this.enablePostProcessing = z;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionInstruction, com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public int getPassthroughTrackID() {
        return -1;
    }

    /* access modifiers changed from: package-private */
    public TAVVideoEffect getSourceVideoEffect() {
        return this.sourceVideoEffect;
    }

    public void setSourceVideoEffect(TAVVideoEffect tAVVideoEffect) {
        this.sourceVideoEffect = tAVVideoEffect;
    }

    /* access modifiers changed from: package-private */
    public TAVVideoMixEffect getVideoMixEffect() {
        return this.videoMixEffect;
    }

    public void setVideoMixEffect(TAVVideoMixEffect tAVVideoMixEffect) {
        this.videoMixEffect = tAVVideoMixEffect;
    }

    /* access modifiers changed from: package-private */
    public TAVVideoEffect getGlobalVideoEffect() {
        return this.globalVideoEffect;
    }

    public void setGlobalVideoEffect(TAVVideoEffect tAVVideoEffect) {
        this.globalVideoEffect = tAVVideoEffect;
    }

    public String toString() {
        AppMethodBeat.i(197632);
        String str = "TAVVideoCompositionInstruction{timeRange=" + this.timeRange.toSimpleString() + ", backgroundColor=" + this.backgroundColor + ", overlayLayers=" + this.overlayLayers + '}';
        AppMethodBeat.o(197632);
        return str;
    }
}
