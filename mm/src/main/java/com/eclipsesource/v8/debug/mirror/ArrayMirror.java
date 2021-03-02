package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ArrayMirror extends ObjectMirror {
    private static final String LENGTH = "length";

    ArrayMirror(V8Object v8Object) {
        super(v8Object);
    }

    @Override // com.eclipsesource.v8.debug.mirror.Mirror
    public boolean isArray() {
        return true;
    }

    public int length() {
        AppMethodBeat.i(61479);
        int executeIntegerFunction = this.v8Object.executeIntegerFunction(LENGTH, null);
        AppMethodBeat.o(61479);
        return executeIntegerFunction;
    }
}
