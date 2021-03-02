package com.danikula.videocache;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ProxyCacheException extends Exception {
    private static final String LIBRARY_VERSION = ". Version: ";

    public ProxyCacheException(String str) {
        super(str + LIBRARY_VERSION);
        AppMethodBeat.i(183611);
        AppMethodBeat.o(183611);
    }

    public ProxyCacheException(String str, Throwable th) {
        super(str + LIBRARY_VERSION, th);
        AppMethodBeat.i(183612);
        AppMethodBeat.o(183612);
    }

    public ProxyCacheException(Throwable th) {
        super("No explanation error. Version: ", th);
    }
}
