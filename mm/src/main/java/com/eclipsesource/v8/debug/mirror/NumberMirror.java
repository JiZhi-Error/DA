package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NumberMirror extends ValueMirror {
    NumberMirror(V8Object v8Object) {
        super(v8Object);
    }

    @Override // com.eclipsesource.v8.debug.mirror.Mirror
    public boolean isNumber() {
        return true;
    }

    @Override // com.eclipsesource.v8.debug.mirror.Mirror
    public String toString() {
        AppMethodBeat.i(61509);
        String executeStringFunction = this.v8Object.executeStringFunction("toText", null);
        AppMethodBeat.o(61509);
        return executeStringFunction;
    }
}
