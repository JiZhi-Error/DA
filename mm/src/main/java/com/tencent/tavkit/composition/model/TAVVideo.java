package com.tencent.tavkit.composition.model;

public interface TAVVideo extends TAVCompositionTimeRange, TAVVideoCompositionTrack {
    TAVVideoConfiguration getVideoConfiguration();
}
