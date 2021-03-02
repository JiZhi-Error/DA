package com.tencent.mm.plugin.appbrand.a;

import com.tencent.mm.sdk.statemachine.State;

public abstract class g extends State {
    private final h kRF;

    public g(h hVar) {
        this.kRF = hVar;
    }

    @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
    public void enter() {
        super.enter();
        this.kRF.a(this);
    }
}
