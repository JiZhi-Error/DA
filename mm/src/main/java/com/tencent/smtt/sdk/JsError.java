package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;

public class JsError {

    /* renamed from: a  reason: collision with root package name */
    private final IX5JsError f1690a;

    protected JsError(IX5JsError iX5JsError) {
        this.f1690a = iX5JsError;
    }

    public String getMessage() {
        AppMethodBeat.i(54872);
        String message = this.f1690a.getMessage();
        AppMethodBeat.o(54872);
        return message;
    }

    public String getStack() {
        AppMethodBeat.i(54873);
        String stack = this.f1690a.getStack();
        AppMethodBeat.o(54873);
        return stack;
    }
}
