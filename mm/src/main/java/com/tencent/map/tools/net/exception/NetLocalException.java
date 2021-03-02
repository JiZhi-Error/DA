package com.tencent.map.tools.net.exception;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public class NetLocalException extends IOException {
    private static final long serialVersionUID = -7835439581999472641L;

    public NetLocalException() {
    }

    public NetLocalException(String str) {
        super(str);
    }

    public NetLocalException(String str, Throwable th) {
        super(str);
        AppMethodBeat.i(180941);
        initCause(th);
        AppMethodBeat.o(180941);
    }
}
