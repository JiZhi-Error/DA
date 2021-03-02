package com.tencent.map.tools.net.exception;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class NetUnavailableException extends NetErrorException {
    private static final long serialVersionUID = 2783283891376573878L;

    public NetUnavailableException() {
    }

    public NetUnavailableException(String str) {
        super(str);
    }

    public NetUnavailableException(String str, Throwable th) {
        super(str);
        AppMethodBeat.i(172937);
        initCause(th);
        AppMethodBeat.o(172937);
    }
}
