package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.d;
import com.tencent.mm.plugin.wallet.pay.a.a.e;
import com.tencent.mm.plugin.wallet.pay.a.a.g;
import com.tencent.mm.plugin.wallet.pay.a.a.h;
import com.tencent.mm.plugin.wallet.pay.a.a.i;
import com.tencent.mm.plugin.wallet.pay.a.a.j;
import com.tencent.mm.plugin.wallet.pay.a.a.l;
import com.tencent.mm.plugin.wallet.pay.a.a.m;
import com.tencent.mm.plugin.wallet.pay.a.a.n;
import com.tencent.mm.plugin.wallet.pay.a.d.c;
import com.tencent.mm.plugin.wallet.pay.a.d.f;
import com.tencent.mm.plugin.wallet.pay.a.d.k;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    public static b a(Authen authen, Orders orders, boolean z) {
        AppMethodBeat.i(69249);
        if (authen == null || orders == null) {
            Log.i("MicroMsg.CgiManager", "empty authen or orders");
            AppMethodBeat.o(69249);
            return null;
        }
        PayInfo payInfo = authen.BDB;
        String str = "";
        if (payInfo != null) {
            Log.i("MicroMsg.CgiManager", "get reqKey from payInfo");
            str = payInfo.dDL;
        }
        if (Util.isNullOrNil(str) && orders != null) {
            Log.i("MicroMsg.CgiManager", "get reqKey from orders");
            str = orders.dDL;
        }
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.CgiManager", "empty reqKey!");
            b bVar = new b(authen, orders, z);
            AppMethodBeat.o(69249);
            return bVar;
        }
        Log.i("MicroMsg.CgiManager", "authen reqKey: %s", str);
        if (!(payInfo == null || orders == null)) {
            Log.d("MicroMsg.CgiManager", "reqKey: %s, %s", payInfo.dDL, orders.dDL);
        }
        Log.i("MicroMsg.CgiManager", "authen go new split cgi");
        if (str.startsWith("sns_aa_")) {
            com.tencent.mm.plugin.wallet.pay.a.a.a aVar = new com.tencent.mm.plugin.wallet.pay.a.a.a(authen, orders, z);
            AppMethodBeat.o(69249);
            return aVar;
        } else if (str.startsWith("sns_tf_")) {
            m mVar = new m(authen, orders, z);
            AppMethodBeat.o(69249);
            return mVar;
        } else if (str.startsWith("sns_ff_")) {
            e eVar = new e(authen, orders, z);
            AppMethodBeat.o(69249);
            return eVar;
        } else if (str.startsWith("ts_")) {
            g gVar = new g(authen, orders, z);
            AppMethodBeat.o(69249);
            return gVar;
        } else if (str.startsWith("sns_")) {
            j jVar = new j(authen, orders, z);
            AppMethodBeat.o(69249);
            return jVar;
        } else if (str.startsWith("offline_")) {
            h hVar = new h(authen, orders, z);
            AppMethodBeat.o(69249);
            return hVar;
        } else if (str.startsWith("up_")) {
            n nVar = new n(authen, orders, z);
            AppMethodBeat.o(69249);
            return nVar;
        } else if (str.startsWith("seb_ff_")) {
            i iVar = new i(authen, orders, z);
            AppMethodBeat.o(69249);
            return iVar;
        } else if (str.startsWith("tax_")) {
            l lVar = new l(authen, orders, z);
            AppMethodBeat.o(69249);
            return lVar;
        } else if (str.startsWith("dc_")) {
            d dVar = new d(authen, orders, z);
            AppMethodBeat.o(69249);
            return dVar;
        } else {
            b bVar2 = new b(authen, orders, z);
            AppMethodBeat.o(69249);
            return bVar2;
        }
    }

    public static com.tencent.mm.plugin.wallet.pay.a.d.g a(v vVar, Orders orders) {
        AppMethodBeat.i(69250);
        if (vVar == null || orders == null) {
            Log.e("MicroMsg.CgiManager", "empty verify or orders");
            AppMethodBeat.o(69250);
            return null;
        }
        PayInfo payInfo = vVar.BDB;
        String str = "";
        if (payInfo != null) {
            Log.i("MicroMsg.CgiManager", "get reqKey from payInfo");
            str = payInfo.dDL;
        }
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.CgiManager", "get reqKey from orders");
            str = orders.dDL;
        }
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.CgiManager", "empty reqKey!");
            com.tencent.mm.plugin.wallet.pay.a.d.g gVar = new com.tencent.mm.plugin.wallet.pay.a.d.g(vVar, orders);
            AppMethodBeat.o(69250);
            return gVar;
        }
        if (payInfo != null) {
            Log.d("MicroMsg.CgiManager", "reqKey: %s, %s", payInfo.dDL, orders.dDL);
        }
        Log.i("MicroMsg.CgiManager", "verify reqKey: %s", str);
        Log.i("MicroMsg.CgiManager", "verify go new split cgi");
        if (str.startsWith("sns_aa_")) {
            com.tencent.mm.plugin.wallet.pay.a.d.a aVar = new com.tencent.mm.plugin.wallet.pay.a.d.a(vVar, orders);
            AppMethodBeat.o(69250);
            return aVar;
        } else if (str.startsWith("sns_tf_")) {
            com.tencent.mm.plugin.wallet.pay.a.d.l lVar = new com.tencent.mm.plugin.wallet.pay.a.d.l(vVar, orders);
            AppMethodBeat.o(69250);
            return lVar;
        } else if (str.startsWith("sns_ff_")) {
            com.tencent.mm.plugin.wallet.pay.a.d.d dVar = new com.tencent.mm.plugin.wallet.pay.a.d.d(vVar, orders);
            AppMethodBeat.o(69250);
            return dVar;
        } else if (str.startsWith("ts_")) {
            f fVar = new f(vVar, orders);
            AppMethodBeat.o(69250);
            return fVar;
        } else if (str.startsWith("sns_")) {
            com.tencent.mm.plugin.wallet.pay.a.d.j jVar = new com.tencent.mm.plugin.wallet.pay.a.d.j(vVar, orders);
            AppMethodBeat.o(69250);
            return jVar;
        } else if (str.startsWith("up_")) {
            com.tencent.mm.plugin.wallet.pay.a.d.m mVar = new com.tencent.mm.plugin.wallet.pay.a.d.m(vVar, orders);
            AppMethodBeat.o(69250);
            return mVar;
        } else if (str.startsWith("seb_ff_")) {
            com.tencent.mm.plugin.wallet.pay.a.d.h hVar = new com.tencent.mm.plugin.wallet.pay.a.d.h(vVar, orders);
            AppMethodBeat.o(69250);
            return hVar;
        } else if (str.startsWith("tax_")) {
            k kVar = new k(vVar, orders);
            AppMethodBeat.o(69250);
            return kVar;
        } else if (str.startsWith("dc_")) {
            c cVar = new c(vVar, orders);
            AppMethodBeat.o(69250);
            return cVar;
        } else {
            com.tencent.mm.plugin.wallet.pay.a.d.g gVar2 = new com.tencent.mm.plugin.wallet.pay.a.d.g(vVar, orders);
            AppMethodBeat.o(69250);
            return gVar2;
        }
    }

    public static com.tencent.mm.plugin.wallet.pay.a.a.c b(Authen authen, Orders orders, boolean z) {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(69251);
        s.fOg();
        if (s.fOh().IbQ == null || authen.BDB == null || z) {
            z2 = false;
            z3 = false;
        } else if (authen.BDB.dVv == 31 || authen.BDB.dVv == 32 || authen.BDB.dVv == 33 || authen.BDB.dVv == 42 || authen.BDB.dVv == 37 || authen.BDB.dVv == 56) {
            z2 = false;
            z3 = true;
        } else {
            z2 = true;
            z3 = false;
        }
        Log.i("MicroMsg.CgiManager", "isLqtSns: %s, isLqtTs: %s, isBalance: %s", Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z));
        if (z3) {
            com.tencent.mm.plugin.wallet.pay.a.a.k kVar = new com.tencent.mm.plugin.wallet.pay.a.a.k(authen, orders, z);
            AppMethodBeat.o(69251);
            return kVar;
        } else if (z2) {
            com.tencent.mm.plugin.wallet.pay.a.a.f fVar = new com.tencent.mm.plugin.wallet.pay.a.a.f(authen, orders, z);
            AppMethodBeat.o(69251);
            return fVar;
        } else {
            com.tencent.mm.plugin.wallet.pay.a.a.c cVar = new com.tencent.mm.plugin.wallet.pay.a.a.c(authen, orders, z);
            AppMethodBeat.o(69251);
            return cVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.plugin.wallet.pay.a.d.b b(com.tencent.mm.plugin.wallet_core.model.v r9, com.tencent.mm.plugin.wallet_core.model.Orders r10) {
        /*
        // Method dump skipped, instructions count: 153
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.pay.a.a.b(com.tencent.mm.plugin.wallet_core.model.v, com.tencent.mm.plugin.wallet_core.model.Orders):com.tencent.mm.plugin.wallet.pay.a.d.b");
    }
}
