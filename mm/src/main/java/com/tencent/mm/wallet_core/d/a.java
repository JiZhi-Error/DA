package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.tenpay.model.b;
import com.tencent.mm.wallet_core.tenpay.model.c;
import com.tencent.mm.wallet_core.tenpay.model.d;
import com.tencent.mm.wallet_core.tenpay.model.e;
import com.tencent.mm.wallet_core.tenpay.model.f;
import com.tencent.mm.wallet_core.tenpay.model.g;
import com.tencent.mm.wallet_core.tenpay.model.h;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.tenpay.model.k;
import com.tencent.mm.wallet_core.tenpay.model.l;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.Map;
import org.json.JSONObject;

public final class a implements i {
    private n Ruu;
    private g Ruv;
    int Ruw = 0;
    private i Rux;

    public a(i iVar) {
        this.Rux = iVar;
    }

    public final void a(n nVar) {
        AppMethodBeat.i(72828);
        Log.i("MicroMsg.DelayQueryOrderHelper", "startDelayScene");
        this.Ruw = 0;
        b(nVar);
        AppMethodBeat.o(72828);
    }

    private void b(n nVar) {
        AppMethodBeat.i(72829);
        this.Ruu = nVar;
        this.Ruu.setHasRetried(true);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(385, this);
        int fRO = t.fQI().fRO();
        this.Ruw++;
        this.Ruv = cm(this.Ruu.hhM());
        this.Ruv.RuM = true;
        int i2 = t.fQI().mRetryCount;
        this.Ruv.ag(this.Ruw >= i2, this.Ruw);
        Log.i("MicroMsg.DelayQueryOrderHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", Integer.valueOf(fRO), Integer.valueOf(i2));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(this.Ruv, fRO);
        AppMethodBeat.o(72829);
    }

    private static g cm(Map<String, String> map) {
        AppMethodBeat.i(72830);
        String str = map.get("req_key");
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.DelayQueryOrderHelper", "no reqKey");
            g gVar = new g(map);
            AppMethodBeat.o(72830);
            return gVar;
        }
        Log.i("MicroMsg.DelayQueryOrderHelper", "payorder reqKey: %s", str);
        Log.i("MicroMsg.DelayQueryOrderHelper", "delayquery go new split cgi");
        if (str.startsWith("sns_aa_")) {
            b bVar = new b(map);
            AppMethodBeat.o(72830);
            return bVar;
        } else if (str.startsWith("sns_tf_")) {
            k kVar = new k(map);
            AppMethodBeat.o(72830);
            return kVar;
        } else if (str.startsWith("sns_ff_")) {
            d dVar = new d(map);
            AppMethodBeat.o(72830);
            return dVar;
        } else if (str.startsWith("ts_")) {
            e eVar = new e(map);
            AppMethodBeat.o(72830);
            return eVar;
        } else if (str.startsWith("sns_")) {
            com.tencent.mm.wallet_core.tenpay.model.i iVar = new com.tencent.mm.wallet_core.tenpay.model.i(map);
            AppMethodBeat.o(72830);
            return iVar;
        } else if (str.startsWith("offline_")) {
            f fVar = new f(map);
            AppMethodBeat.o(72830);
            return fVar;
        } else if (str.startsWith("up_")) {
            l lVar = new l(map);
            AppMethodBeat.o(72830);
            return lVar;
        } else if (str.startsWith("seb_ff_")) {
            h hVar = new h(map);
            AppMethodBeat.o(72830);
            return hVar;
        } else if (str.startsWith("tax_")) {
            j jVar = new j(map);
            AppMethodBeat.o(72830);
            return jVar;
        } else if (str.startsWith("dc_")) {
            c cVar = new c(map);
            AppMethodBeat.o(72830);
            return cVar;
        } else {
            g gVar2 = new g(map);
            AppMethodBeat.o(72830);
            return gVar2;
        }
    }

    public final void destory() {
        AppMethodBeat.i(72831);
        this.Rux = null;
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(385, this);
        AppMethodBeat.o(72831);
    }

    private void a(int i2, int i3, String str, JSONObject jSONObject, g gVar) {
        AppMethodBeat.i(72832);
        Log.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback errCode = " + i3 + "errType = " + i2);
        if (this.Ruu != null && jSONObject != null && i2 == 0 && i3 == 0) {
            Log.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mScene !=null");
            this.Ruu.onGYNetEnd(i3, str, jSONObject);
            this.Rux.onSceneEnd(i2, i3, str, this.Ruu);
            if (this.Ruw == 1) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(965, 4, 1);
            } else if (this.Ruw == 2) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(965, 5, 1);
            } else if (this.Ruw == 3) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(965, 6, 1);
            }
        } else if (this.Rux != null) {
            Log.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mRealCallback !=null");
            this.Rux.onSceneEnd(i2, i3, str, this.Ruu);
            if (this.Ruw == 1) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(965, 7, 1);
            } else if (this.Ruw == 2) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(965, 8, 1);
            } else if (this.Ruw == 3) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(965, 9, 1);
            }
            if (!gVar.checkRecSrvResp()) {
                if (this.Ruw == 1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(965, 15, 1);
                } else if (this.Ruw == 2) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(965, 16, 1);
                } else if (this.Ruw == 3) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(965, 17, 1);
                }
            }
        }
        Log.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback reset");
        this.Ruw = 0;
        AppMethodBeat.o(72832);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        AppMethodBeat.i(72833);
        Log.d("MicroMsg.DelayQueryOrderHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar);
        if (!(qVar instanceof g) || !this.Ruv.equals(qVar)) {
            if ((qVar instanceof n) && this.Ruu.equals(qVar)) {
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAg().hqi.b(385, this);
                if (((n) qVar).ishasCGiRetried()) {
                    if (this.Ruu.checkPaySuccess()) {
                        Log.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess ok");
                        a(i2, i3, str, ((n) qVar).RuU, this.Ruv);
                        AppMethodBeat.o(72833);
                        return;
                    } else if (this.Ruu.hhN()) {
                        Log.i("MicroMsg.DelayQueryOrderHelper", "try isServerDelayQuery true");
                        b(this.Ruu);
                        AppMethodBeat.o(72833);
                        return;
                    } else {
                        String str2 = t.fQI().IbX;
                        Log.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", str2);
                        a(i2, i3, str2, ((n) qVar).RuU, this.Ruv);
                    }
                }
            }
            AppMethodBeat.o(72833);
            return;
        }
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(385, this);
        g gVar = (g) qVar;
        Log.d("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder errType: %d, errCode: %d, errMsg: %s scene %s  errmsgtype %s", Integer.valueOf(i2), Integer.valueOf(i3), str, gVar, Integer.valueOf(gVar.RuL));
        if (gVar.RuL == 1) {
            Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step A");
            a(i2, i3, str, gVar.hhL(), gVar);
            AppMethodBeat.o(72833);
        } else if (i2 == 0 && i3 == 0) {
            Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step B");
            if (gVar.RuL == 2) {
                a(this.Ruu.RuR, this.Ruu.RuS, this.Ruu.RuT, this.Ruu.RuU, gVar);
                AppMethodBeat.o(72833);
                return;
            }
            a(i2, i3, str, gVar.hhL(), gVar);
            AppMethodBeat.o(72833);
        } else if (gVar.checkRecSrvResp() || this.Ruw >= t.fQI().mRetryCount) {
            n nVar = this.Ruu;
            int i4 = t.fQI().mRetryCount;
            Log.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", Boolean.valueOf(nVar.hhN()), Integer.valueOf(this.Ruw));
            if (this.Ruw < i4) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D doLoopDelayScene");
                b(this.Ruu);
                AppMethodBeat.o(72833);
                return;
            }
            Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D fail, retmsg_type: %s", Integer.valueOf(gVar.RuL));
            if (gVar.RuL == 1) {
                a(i2, i3, str, gVar.hhL(), gVar);
                AppMethodBeat.o(72833);
            } else if (gVar.RuL == 2) {
                a(this.Ruu.RuR, this.Ruu.RuS, this.Ruu.RuT, this.Ruu.RuU, gVar);
                AppMethodBeat.o(72833);
            } else {
                String str3 = t.fQI().IbX;
                if (!Util.isNullOrNil(this.Ruu.RuT)) {
                    str3 = this.Ruu.RuT;
                }
                Log.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", str3);
                a(this.Ruu.RuR, this.Ruu.RuS, str3, this.Ruu.RuU, gVar);
                AppMethodBeat.o(72833);
            }
        } else {
            Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step C");
            Log.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", t.fQI().IbX);
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(965, 0, 1);
            b(this.Ruu);
            AppMethodBeat.o(72833);
        }
    }
}
