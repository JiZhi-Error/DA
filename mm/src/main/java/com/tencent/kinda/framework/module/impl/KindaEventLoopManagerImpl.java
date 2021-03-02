package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.EventLoopManager;
import com.tencent.kinda.gen.KEventLoop;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KindaEventLoopManagerImpl implements EventLoopManager {
    private KEventLoop bgLoop;
    private KEventLoop makeSureUILoop;
    private KEventLoop uiLoop;

    @Override // com.tencent.kinda.gen.EventLoopManager
    public KEventLoop getUIEventLoop() {
        AppMethodBeat.i(18635);
        if (this.uiLoop == null) {
            this.uiLoop = new KindaUIEventLoop();
        }
        KEventLoop kEventLoop = this.uiLoop;
        AppMethodBeat.o(18635);
        return kEventLoop;
    }

    @Override // com.tencent.kinda.gen.EventLoopManager
    public KEventLoop getBackGroundEventLoop() {
        AppMethodBeat.i(18636);
        if (this.bgLoop == null) {
            this.bgLoop = new KindaUIEventLoop();
        }
        KEventLoop kEventLoop = this.bgLoop;
        AppMethodBeat.o(18636);
        return kEventLoop;
    }

    @Override // com.tencent.kinda.gen.EventLoopManager
    public KEventLoop getMakeSureUIEventLoop() {
        AppMethodBeat.i(18637);
        if (this.makeSureUILoop == null) {
            this.makeSureUILoop = new KindaUIEventLoop();
        }
        KEventLoop kEventLoop = this.makeSureUILoop;
        AppMethodBeat.o(18637);
        return kEventLoop;
    }
}
