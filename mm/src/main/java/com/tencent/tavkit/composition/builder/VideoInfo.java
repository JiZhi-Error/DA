package com.tencent.tavkit.composition.builder;

import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;

/* access modifiers changed from: package-private */
public class VideoInfo {
    TAVTransitionableVideo clip;
    CompositionTrack compositionTrack;

    VideoInfo(CompositionTrack compositionTrack2, TAVTransitionableVideo tAVTransitionableVideo) {
        this.compositionTrack = compositionTrack2;
        this.clip = tAVTransitionableVideo;
    }
}
