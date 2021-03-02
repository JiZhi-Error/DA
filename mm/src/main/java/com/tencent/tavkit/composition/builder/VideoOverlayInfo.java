package com.tencent.tavkit.composition.builder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tavkit.composition.model.TAVVideo;
import com.tencent.tavkit.composition.video.TAVVideoCompositionLayerInstruction;

/* access modifiers changed from: package-private */
public class VideoOverlayInfo {
    CompositionTrack track;
    TAVVideo video;

    VideoOverlayInfo(CompositionTrack compositionTrack, TAVVideo tAVVideo) {
        this.track = compositionTrack;
        this.video = tAVVideo;
    }

    /* access modifiers changed from: package-private */
    public TAVVideoCompositionLayerInstruction convertToLayerInstruction() {
        AppMethodBeat.i(197554);
        TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction = new TAVVideoCompositionLayerInstruction(this.track.getTrackID(), this.video.getVideoConfiguration(), this.video);
        tAVVideoCompositionLayerInstruction.setPreferredTransform(this.track.getPreferredTransform());
        tAVVideoCompositionLayerInstruction.setTimeRange(this.video.getTimeRange());
        AppMethodBeat.o(197554);
        return tAVVideoCompositionLayerInstruction;
    }
}
