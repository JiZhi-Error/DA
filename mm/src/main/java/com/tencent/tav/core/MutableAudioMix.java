package com.tencent.tav.core;

import java.util.List;

public class MutableAudioMix extends AudioMix {
    public MutableAudioMix(List<? extends AudioMixInputParameters> list) {
        super(list);
    }

    public void setInputParameters(List<AudioMixInputParameters> list) {
        this.inputParameters = list;
    }
}
