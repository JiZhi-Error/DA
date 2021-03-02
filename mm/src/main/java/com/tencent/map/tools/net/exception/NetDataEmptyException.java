package com.tencent.map.tools.net.exception;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class NetDataEmptyException extends Exception {
    private static final long serialVersionUID = -5614711401833110994L;

    public NetDataEmptyException() {
    }

    public NetDataEmptyException(String str) {
        super(str);
    }

    public NetDataEmptyException(String str, Throwable th) {
        super(str);
        AppMethodBeat.i(180939);
        initCause(th);
        AppMethodBeat.o(180939);
    }
}
