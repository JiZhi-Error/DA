package com.tencent.tavkit.component.effectchain;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;

public class TAVVideoEffectContext implements IVideoEffectContext {
    protected final VideoEffectProxy globalVideoEffectProxy = new VideoEffectProxy();
    protected final VideoEffectProxy sourceVideoEffectProxy = new VideoEffectProxy();
    protected final VideoMixEffectProxy videoMixEffectProxy = new VideoMixEffectProxy();

    public TAVVideoEffectContext() {
        AppMethodBeat.i(197436);
        AppMethodBeat.o(197436);
    }

    @Override // com.tencent.tavkit.component.effectchain.IVideoEffectContext
    public TAVVideoEffect getSourceVideoEffect() {
        return this.sourceVideoEffectProxy;
    }

    @Override // com.tencent.tavkit.component.effectchain.IVideoEffectContext
    public TAVVideoMixEffect getVideoMixEffect() {
        return this.videoMixEffectProxy;
    }

    @Override // com.tencent.tavkit.component.effectchain.IVideoEffectContext
    public TAVVideoEffect getGlobalVideoEffect() {
        return this.globalVideoEffectProxy;
    }

    public void addSourceFilter(TAVVideoEffect tAVVideoEffect) {
        AppMethodBeat.i(197437);
        this.sourceVideoEffectProxy.getEffects().remove(tAVVideoEffect);
        AppMethodBeat.o(197437);
    }

    public void addVideoMixFilter(TAVVideoMixEffect tAVVideoMixEffect) {
        AppMethodBeat.i(197438);
        this.videoMixEffectProxy.getEffects().remove(tAVVideoMixEffect);
        AppMethodBeat.o(197438);
    }

    public void addGlobalFilter(TAVVideoEffect tAVVideoEffect) {
        AppMethodBeat.i(197439);
        this.globalVideoEffectProxy.getEffects().remove(tAVVideoEffect);
        AppMethodBeat.o(197439);
    }

    public void removeSourceFilter(TAVVideoEffect tAVVideoEffect) {
        AppMethodBeat.i(197440);
        this.sourceVideoEffectProxy.getEffects().remove(tAVVideoEffect);
        this.sourceVideoEffectProxy.notifyOnEffectRemove();
        AppMethodBeat.o(197440);
    }

    public void removeVideoMixFilter(TAVVideoMixEffect tAVVideoMixEffect) {
        AppMethodBeat.i(197441);
        this.videoMixEffectProxy.getEffects().remove(tAVVideoMixEffect);
        this.videoMixEffectProxy.notifyOnEffectRemove();
        AppMethodBeat.o(197441);
    }

    public void removeGlobalFilter(TAVVideoEffect tAVVideoEffect) {
        AppMethodBeat.i(197442);
        this.globalVideoEffectProxy.getEffects().remove(tAVVideoEffect);
        this.globalVideoEffectProxy.notifyOnEffectRemove();
        AppMethodBeat.o(197442);
    }
}
