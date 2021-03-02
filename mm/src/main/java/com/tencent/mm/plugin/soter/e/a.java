package com.tencent.mm.plugin.soter.e;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.h;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.j.c;
import com.tencent.soter.a.b.d;
import com.tencent.soter.a.g.e;
import com.tencent.soter.a.g.f;

public final class a implements com.tencent.mm.vending.c.a<c<Boolean, Boolean>, c<Boolean, Boolean>> {
    private int Fie = -1;
    private b jSi = null;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.vending.c.a
    public final /* synthetic */ c<Boolean, Boolean> call(c<Boolean, Boolean> cVar) {
        AppMethodBeat.i(130865);
        c<Boolean, Boolean> cVar2 = cVar;
        Log.v("MicroMsg.SoterInitFunc", "alvinluo SoterInitFunc call");
        e.a aVar = new e.a();
        aVar.RRf.RRa = m.flQ();
        aVar.RRf.RRd = "WechatASK";
        e.a U = aVar.U(1, 2, 3);
        U.RRf.RQZ = null;
        U.RRf.RRc = new h();
        f fVar = new f(MMApplicationContext.getContext(), U.RRf);
        this.jSi = g.hdx();
        this.jSi.hdw();
        fVar.RQW = new com.tencent.soter.a.b.b<d>() {
            /* class com.tencent.mm.plugin.soter.e.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.soter.a.b.e] */
            @Override // com.tencent.soter.a.b.b
            public final /* synthetic */ void a(d dVar) {
                AppMethodBeat.i(130864);
                d dVar2 = dVar;
                Log.i("MicroMsg.SoterInitFunc", "alvinluo SoterInitFunc onResult errCode: %d, errMsg: %s", Integer.valueOf(dVar2.errCode), dVar2.errMsg);
                if (dVar2.isSuccess()) {
                    Log.v("MicroMsg.SoterInitFunc", "alvinluo resume %d", Long.valueOf(System.currentTimeMillis()));
                    b.Fig = true;
                    a.a(a.this);
                    a.this.jSi.resume();
                    AppMethodBeat.o(130864);
                    return;
                }
                com.tencent.mm.plugin.soter.d.a.n(0, dVar2.errCode, 0);
                a.c(a.this);
                if (a.this.Fie == 2 && dVar2.errCode == 2) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1104, 3);
                }
                b.Fig = false;
                b.Fih = dVar2.errCode;
                a.this.jSi.ej(g.P(Integer.valueOf(dVar2.errCode), dVar2.errMsg));
                AppMethodBeat.o(130864);
            }
        };
        if (!f.hlO().a(fVar, new d())) {
            Log.e("MicroMsg.SoterInitFunc", "alvinluo: add soterTaskInitForWX failed.");
        } else {
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1104, 1);
        }
        Log.v("MicroMsg.SoterInitFunc", "alvinluo pending %d", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(130865);
        return cVar2;
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(130866);
        SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
        if (defaultPreference != null) {
            aVar.Fie = 1;
            defaultPreference.edit().putBoolean("init_success", true).commit();
        }
        AppMethodBeat.o(130866);
    }

    static /* synthetic */ void c(a aVar) {
        SharedPreferences defaultPreference;
        int i2;
        AppMethodBeat.i(130867);
        if (aVar.Fie <= 0 && (defaultPreference = MMApplicationContext.getDefaultPreference()) != null) {
            if (defaultPreference.getBoolean("init_success", false)) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            aVar.Fie = i2;
        }
        AppMethodBeat.o(130867);
    }
}
