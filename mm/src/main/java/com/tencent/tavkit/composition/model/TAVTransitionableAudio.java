package com.tencent.tavkit.composition.model;

import com.tencent.tavkit.composition.audio.TAVAudioTransition;

public interface TAVTransitionableAudio extends TAVAudio {
    TAVAudioTransition getAudioTransition();
}
