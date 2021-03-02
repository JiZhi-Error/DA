package com.tencent.soter.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.b;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.g.f;
import com.tencent.soter.a.g.h;
import com.tencent.soter.a.g.i;
import com.tencent.soter.a.g.k;
import com.tencent.soter.a.g.l;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;

public final class a {
    public static void a(b<c> bVar, boolean z, e eVar) {
        AppMethodBeat.i(2);
        d.i("Soter.SoterWrapperApi", "soter: starting prepare ask key. ", new Object[0]);
        k kVar = new k(eVar, z);
        kVar.RQW = bVar;
        if (!f.hlO().a(kVar, new c())) {
            d.d("Soter.SoterWrapperApi", "soter: add prepareAppSecureKey task failed.", new Object[0]);
        }
        AppMethodBeat.o(2);
    }

    public static void a(b<c> bVar, boolean z, int i2, e eVar, e eVar2) {
        AppMethodBeat.i(3);
        d.i("Soter.SoterWrapperApi", "soter: starting prepare auth key: %d", Integer.valueOf(i2));
        l lVar = new l(i2, eVar, eVar2, z);
        lVar.RQW = bVar;
        if (!f.hlO().a(lVar, new c())) {
            d.d("Soter.SoterWrapperApi", "soter: add prepareAuthKey task failed.", new Object[0]);
        }
        AppMethodBeat.o(3);
    }

    public static void a(b<com.tencent.soter.a.b.a> bVar, com.tencent.soter.a.g.b bVar2) {
        AppMethodBeat.i(4);
        d.i("Soter.SoterWrapperApi", "soter: request authorize provide challenge. scene: %d", Integer.valueOf(bVar2.mScene));
        if (bVar2.RQR == 1 || bVar2.RQR == 2) {
            i iVar = new i(bVar2);
            iVar.RQW = bVar;
            if (!f.hlO().a(iVar, new com.tencent.soter.a.b.a())) {
                d.d("Soter.SoterWrapperApi", "soter: add 2.0 requestAuthorizeAndSign task failed.", new Object[0]);
            }
            AppMethodBeat.o(4);
            return;
        }
        h hVar = new h(bVar2);
        hVar.RQW = bVar;
        if (!f.hlO().a(hVar, new com.tencent.soter.a.b.a())) {
            d.d("Soter.SoterWrapperApi", "soter: add 1.0 requestAuthorizeAndSign task failed.", new Object[0]);
        }
        AppMethodBeat.o(4);
    }

    public static boolean hlC() {
        AppMethodBeat.i(5);
        if (!com.tencent.soter.a.c.b.hlG().isInit() || !com.tencent.soter.a.c.b.hlG().hlC()) {
            AppMethodBeat.o(5);
            return false;
        }
        AppMethodBeat.o(5);
        return true;
    }

    public static boolean aqK(int i2) {
        AppMethodBeat.i(6);
        boolean isInit = com.tencent.soter.a.c.b.hlG().isInit();
        String str = com.tencent.soter.a.c.b.hlG().hlI().get(i2);
        if (!isInit || g.isNullOrNil(str)) {
            if (!isInit) {
                d.w("Soter.SoterWrapperApi", "soter: not initialized yet", new Object[0]);
                AppMethodBeat.o(6);
                return false;
            }
            d.w("Soter.SoterWrapperApi", "soter: scene not registered in init. please make sure", new Object[0]);
            AppMethodBeat.o(6);
            return false;
        } else if (com.tencent.soter.core.a.dE(str, false).errCode == 0) {
            AppMethodBeat.o(6);
            return true;
        } else {
            AppMethodBeat.o(6);
            return false;
        }
    }

    public static void hlE() {
        AppMethodBeat.i(7);
        SparseArray<String> hlI = com.tencent.soter.a.c.b.hlG().hlI();
        int size = hlI.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.tencent.soter.core.a.dE(hlI.valueAt(i2), false);
        }
        com.tencent.soter.core.a.hll();
        AppMethodBeat.o(7);
    }

    public static void hlD() {
        AppMethodBeat.i(175401);
        if (com.tencent.soter.a.c.b.hlG().isInit() && !com.tencent.soter.core.a.hlh()) {
            com.tencent.soter.core.a.hli();
        }
        AppMethodBeat.o(175401);
    }
}
