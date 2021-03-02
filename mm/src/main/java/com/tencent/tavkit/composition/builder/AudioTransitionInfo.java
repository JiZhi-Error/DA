package com.tencent.tavkit.composition.builder;

import com.tencent.tavkit.composition.audio.TAVAudioTransition;

/* access modifiers changed from: package-private */
public class AudioTransitionInfo {
    TAVAudioTransition next;
    TAVAudioTransition prev;

    AudioTransitionInfo(TAVAudioTransition tAVAudioTransition, TAVAudioTransition tAVAudioTransition2) {
        this.prev = tAVAudioTransition;
        this.next = tAVAudioTransition2;
    }
}
