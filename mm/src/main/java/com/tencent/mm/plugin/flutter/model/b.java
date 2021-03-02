package com.tencent.mm.plugin.flutter.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.engine.plugins.a;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;

public final class b implements a, k.c {
    private k wJr;

    @Override // io.flutter.plugin.a.k.c
    public final void a(j jVar, k.d dVar) {
        AppMethodBeat.i(148872);
        String str = jVar.method;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1397185985:
                if (str.equals("android_idkey_report")) {
                    c2 = 1;
                    break;
                }
                break;
            case -756508488:
                if (str.equals("android_kv_report")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                e.INSTANCE.kvStat(((Integer) jVar.btq("id")).intValue(), (String) jVar.btq("value"));
                AppMethodBeat.o(148872);
                return;
            case 1:
                e.INSTANCE.idkeyStat((long) ((Integer) jVar.btq("id")).intValue(), (long) ((Integer) jVar.btq("key")).intValue(), (long) ((Integer) jVar.btq("value")).intValue(), false);
                break;
        }
        AppMethodBeat.o(148872);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void a(a.b bVar) {
        AppMethodBeat.i(240944);
        Log.i("MicroMsg.Flutter.FlutterDataReportPlugin", "onAttachedToEngine FlutterDataReportPlugin CHANNEL%s", "com.tencent.mm.flutter.datareport");
        this.wJr = new k(bVar.SOH, "com.tencent.mm.flutter.datareport");
        this.wJr.a(this);
        AppMethodBeat.o(240944);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void b(a.b bVar) {
        AppMethodBeat.i(240945);
        if (this.wJr != null) {
            this.wJr.a(null);
        }
        AppMethodBeat.o(240945);
    }
}
