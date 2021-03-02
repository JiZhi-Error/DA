package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PropertyMirror extends Mirror {
    PropertyMirror(V8Object v8Object) {
        super(v8Object);
    }

    public String getName() {
        AppMethodBeat.i(61520);
        String executeStringFunction = this.v8Object.executeStringFunction("name", null);
        AppMethodBeat.o(61520);
        return executeStringFunction;
    }

    public Mirror getValue() {
        AppMethodBeat.i(61521);
        V8Object executeObjectFunction = this.v8Object.executeObjectFunction("value", null);
        try {
            return createMirror(executeObjectFunction);
        } finally {
            executeObjectFunction.release();
            AppMethodBeat.o(61521);
        }
    }

    @Override // com.eclipsesource.v8.debug.mirror.Mirror
    public boolean isProperty() {
        return true;
    }
}
