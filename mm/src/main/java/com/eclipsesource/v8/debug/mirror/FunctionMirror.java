package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FunctionMirror extends ObjectMirror {
    private static final String NAME = "name";
    private static final String SCRIPT = "script";

    FunctionMirror(V8Object v8Object) {
        super(v8Object);
    }

    public String getName() {
        AppMethodBeat.i(61491);
        String executeStringFunction = this.v8Object.executeStringFunction("name", null);
        AppMethodBeat.o(61491);
        return executeStringFunction;
    }

    public String getScriptName() {
        AppMethodBeat.i(61492);
        V8Object executeObjectFunction = this.v8Object.executeObjectFunction(SCRIPT, null);
        try {
            return executeObjectFunction.executeStringFunction("name", null);
        } finally {
            executeObjectFunction.release();
            AppMethodBeat.o(61492);
        }
    }

    @Override // com.eclipsesource.v8.debug.mirror.Mirror
    public boolean isFunction() {
        return true;
    }
}
