package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BooleanMirror extends ValueMirror {
    BooleanMirror(V8Object v8Object) {
        super(v8Object);
    }

    @Override // com.eclipsesource.v8.debug.mirror.Mirror
    public boolean isBoolean() {
        return true;
    }

    @Override // com.eclipsesource.v8.debug.mirror.Mirror
    public String toString() {
        AppMethodBeat.i(61480);
        String executeStringFunction = this.v8Object.executeStringFunction("toText", null);
        AppMethodBeat.o(61480);
        return executeStringFunction;
    }
}
