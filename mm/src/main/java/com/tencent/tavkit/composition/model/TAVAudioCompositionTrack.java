package com.tencent.tavkit.composition.model;

import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.asset.MutableComposition;

public interface TAVAudioCompositionTrack {
    CompositionTrack audioCompositionTrackForComposition(MutableComposition mutableComposition, int i2, boolean z);

    int numberOfAudioTracks();
}
