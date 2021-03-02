package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.statemachine.State;

public abstract class q extends State {
    @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
    public void enter() {
        super.enter();
        Log.i("MicroMsg.LoggerState", getName() + " [ENTERING]");
    }

    @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
    public void exit() {
        super.exit();
        Log.i("MicroMsg.LoggerState", getName() + " [EXITING]");
    }
}
