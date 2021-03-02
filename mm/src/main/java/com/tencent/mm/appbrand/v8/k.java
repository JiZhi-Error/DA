package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/* access modifiers changed from: package-private */
public final class k {
    public final BlockingDeque<String> dpM = new LinkedBlockingDeque();
    public volatile boolean enable = false;

    k() {
        AppMethodBeat.i(185102);
        AppMethodBeat.o(185102);
    }
}
