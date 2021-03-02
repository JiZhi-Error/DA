package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static void report() {
        AppMethodBeat.i(25065);
        try {
            b.dOb().a(new b.a() {
                /* class com.tencent.mm.plugin.freewifi.ui.c.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.freewifi.ui.b.a
                public final void V(float f2, float f3) {
                    AppMethodBeat.i(25064);
                    try {
                        String valueOf = String.valueOf(f2);
                        String valueOf2 = String.valueOf(f3);
                        com.tencent.mm.plugin.freewifi.g.c aya = j.dNn().aya(d.dNf());
                        if (aya != null) {
                            h.INSTANCE.a(12073, aya.field_ssid, aya.field_mac, aya.field_url, aya.field_url, valueOf2, valueOf);
                            Log.i("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location. ssid=%s, mac=%s, mp_url=%s, qrcode=%s, longtitued=%s, latitude=%s", aya.field_ssid, aya.field_mac, aya.field_url, aya.field_url, valueOf, valueOf2);
                        }
                        AppMethodBeat.o(25064);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location exception. " + e2.getMessage() + m.m(e2));
                        AppMethodBeat.o(25064);
                    }
                }
            });
            AppMethodBeat.o(25065);
        } catch (Exception e2) {
            Log.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location error. " + e2.getMessage());
            AppMethodBeat.o(25065);
        }
    }
}
