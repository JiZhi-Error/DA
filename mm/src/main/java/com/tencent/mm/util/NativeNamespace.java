package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class NativeNamespace {
    private static native int nativeResetNamespace();

    static {
        AppMethodBeat.i(4355);
        System.loadLibrary("wechatnativeutils");
        AppMethodBeat.o(4355);
    }

    private NativeNamespace() {
        AppMethodBeat.i(4354);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(4354);
        throw unsupportedOperationException;
    }
}
