package com.tencent.mm.appbrand.v8;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;

/* access modifiers changed from: package-private */
public final class b extends y {
    private b(IJSRuntime.Config config) {
        super(config);
    }

    static y a(IJSRuntime.Config config) {
        AppMethodBeat.i(143992);
        b bVar = new b(config);
        AppMethodBeat.o(143992);
        return bVar;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.appbrand.v8.y, com.tencent.mm.appbrand.v8.a
    public final c Xt() {
        AppMethodBeat.i(143993);
        Looper.prepare();
        g gVar = new g(Looper.myLooper());
        AppMethodBeat.o(143993);
        return gVar;
    }
}
