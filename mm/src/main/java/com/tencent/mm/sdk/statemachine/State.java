package com.tencent.mm.sdk.statemachine;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class State implements IState {
    protected State() {
    }

    @Override // com.tencent.mm.sdk.statemachine.IState
    public void enter() {
    }

    @Override // com.tencent.mm.sdk.statemachine.IState
    public void exit() {
    }

    @Override // com.tencent.mm.sdk.statemachine.IState
    public boolean processMessage(Message message) {
        return false;
    }

    @Override // com.tencent.mm.sdk.statemachine.IState
    public String getName() {
        AppMethodBeat.i(158010);
        String name = getClass().getName();
        String substring = name.substring(name.lastIndexOf(36) + 1);
        AppMethodBeat.o(158010);
        return substring;
    }
}
