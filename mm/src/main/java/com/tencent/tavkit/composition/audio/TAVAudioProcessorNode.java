package com.tencent.tavkit.composition.audio;

import com.tencent.tav.core.AudioTapProcessor;

public interface TAVAudioProcessorNode {

    public interface TAVAudioProcessorEffect extends AudioTapProcessor {
    }

    TAVAudioProcessorEffect createAudioProcessor();

    String getIdentifier();
}
