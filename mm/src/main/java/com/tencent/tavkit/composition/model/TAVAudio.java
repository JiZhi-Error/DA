package com.tencent.tavkit.composition.model;

public interface TAVAudio extends TAVAudioCompositionTrack, TAVCompositionTimeRange {
    TAVAudioConfiguration getAudioConfiguration();
}
