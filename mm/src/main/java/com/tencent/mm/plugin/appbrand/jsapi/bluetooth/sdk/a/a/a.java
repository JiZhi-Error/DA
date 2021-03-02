package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;

@TargetApi(18)
public final class a extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a {
    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final void bFt() {
        AppMethodBeat.i(144570);
        if (this.lNb.lMG == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "connection is not open.", new Object[0]);
            a(j.lNC);
            done();
            AppMethodBeat.o(144570);
            return;
        }
        this.lNb.hq(true);
        a(j.lNu);
        done();
        AppMethodBeat.o(144570);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final String getName() {
        return "CloseAction";
    }
}
