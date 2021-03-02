package com.google.firebase.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

public final class b {
    private static final AtomicReference<b> bKx = new AtomicReference<>();

    static {
        AppMethodBeat.i(4103);
        AppMethodBeat.o(4103);
    }

    private b() {
    }

    public static b yx() {
        AppMethodBeat.i(4102);
        bKx.compareAndSet(null, new b());
        b bVar = bKx.get();
        AppMethodBeat.o(4102);
        return bVar;
    }

    public static void yy() {
    }
}
