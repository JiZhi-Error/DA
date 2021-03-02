package com.eclipsesource.v8.debug;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum StepAction {
    STEP_OUT(0),
    STEP_NEXT(1),
    STEP_IN(2),
    STEP_FRAME(3);
    
    int index;

    public static StepAction valueOf(String str) {
        AppMethodBeat.i(61542);
        StepAction stepAction = (StepAction) Enum.valueOf(StepAction.class, str);
        AppMethodBeat.o(61542);
        return stepAction;
    }

    static {
        AppMethodBeat.i(61543);
        AppMethodBeat.o(61543);
    }

    private StepAction(int i2) {
        this.index = i2;
    }
}
