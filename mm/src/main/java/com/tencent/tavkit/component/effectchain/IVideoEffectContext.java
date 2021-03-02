package com.tencent.tavkit.component.effectchain;

import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;

public interface IVideoEffectContext {
    TAVVideoEffect getGlobalVideoEffect();

    TAVVideoEffect getSourceVideoEffect();

    TAVVideoMixEffect getVideoMixEffect();
}
