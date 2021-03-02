package com.tencent.magicbrush.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class V8Benchmark {
    public static native String execute(String str);

    static {
        AppMethodBeat.i(140075);
        System.loadLibrary("mmv8");
        System.loadLibrary("magicbrush");
        AppMethodBeat.o(140075);
    }
}
