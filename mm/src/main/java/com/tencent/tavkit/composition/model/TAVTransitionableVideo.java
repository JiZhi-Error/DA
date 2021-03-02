package com.tencent.tavkit.composition.model;

import com.tencent.tavkit.composition.video.TAVVideoTransition;

public interface TAVTransitionableVideo extends TAVVideo {
    TAVVideoTransition getVideoTransition();
}
