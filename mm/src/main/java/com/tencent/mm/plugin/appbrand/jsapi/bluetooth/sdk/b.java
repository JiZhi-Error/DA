package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a;

public final class b {
    public final c lMr;
    public final a lMs;

    public b(Context context) {
        AppMethodBeat.i(144531);
        this.lMr = new c(context);
        this.lMs = new a(context);
        AppMethodBeat.o(144531);
    }
}
