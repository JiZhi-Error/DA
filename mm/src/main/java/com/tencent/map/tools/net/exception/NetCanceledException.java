package com.tencent.map.tools.net.exception;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public class NetCanceledException extends IOException {
    private static final long serialVersionUID = -7835439581999472741L;

    public NetCanceledException() {
    }

    public NetCanceledException(String str) {
        super(str);
    }

    public NetCanceledException(String str, Throwable th) {
        super(str);
        AppMethodBeat.i(180938);
        initCause(th);
        AppMethodBeat.o(180938);
    }
}
