package com.tencent.mm.sdk.statemachine;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Serializable;

public class LogStateTransitionState extends State implements Serializable {
    public static final String TAG = "LogStateTransitionState";
    public final String name = getClass().getSimpleName();

    public LogStateTransitionState() {
        AppMethodBeat.i(158007);
        AppMethodBeat.o(158007);
    }

    @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
    public void enter() {
        AppMethodBeat.i(158008);
        super.enter();
        Log.i(TAG, "entering " + this.name);
        AppMethodBeat.o(158008);
    }

    @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
    public void exit() {
        AppMethodBeat.i(158009);
        super.exit();
        Log.i(TAG, "exiting " + this.name);
        AppMethodBeat.o(158009);
    }
}
