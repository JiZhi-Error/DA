package com.tencent.tavkit.composition.builder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;

class AudioInfo {
    TAVTransitionableAudio audio;
    CompositionTrack compositionTrack;

    AudioInfo(CompositionTrack compositionTrack2, TAVTransitionableAudio tAVTransitionableAudio) {
        this.compositionTrack = compositionTrack2;
        this.audio = tAVTransitionableAudio;
    }

    /* access modifiers changed from: package-private */
    public CompositionTrackSegment getCurrentSegmentBy() {
        AppMethodBeat.i(197505);
        for (int i2 = 0; i2 < this.compositionTrack.getSegments().size(); i2++) {
            CompositionTrackSegment compositionTrackSegment = this.compositionTrack.getSegments().get(i2);
            if (compositionTrackSegment.getTimeMapping().getTarget().equals(this.audio.getTimeRange())) {
                AppMethodBeat.o(197505);
                return compositionTrackSegment;
            }
        }
        AppMethodBeat.o(197505);
        return null;
    }
}
