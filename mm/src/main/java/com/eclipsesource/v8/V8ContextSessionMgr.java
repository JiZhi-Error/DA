package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class V8ContextSessionMgr {
    private V8ContextWrapper currentContext;
    private final V8 v8;

    V8ContextSessionMgr(V8 v82) {
        this.v8 = v82;
    }

    public final void enterContext(V8ContextWrapper v8ContextWrapper) {
        AppMethodBeat.i(62073);
        if (v8ContextWrapper == null) {
            AppMethodBeat.o(62073);
        } else if (v8ContextWrapper.equals(this.currentContext)) {
            AppMethodBeat.o(62073);
        } else {
            this.v8.switchV8Context(v8ContextWrapper.getPtr());
            this.currentContext = v8ContextWrapper;
            AppMethodBeat.o(62073);
        }
    }

    public final void releaseContext(V8ContextWrapper v8ContextWrapper) {
        AppMethodBeat.i(62074);
        if (v8ContextWrapper == null) {
            AppMethodBeat.o(62074);
            return;
        }
        this.v8.releaseV8Context(v8ContextWrapper.getPtr());
        AppMethodBeat.o(62074);
    }
}
