package com.tencent.mm.plugin.luckymoney.model;

import android.util.Base64;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.protocal.protobuf.dlr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.io.IOException;

public final class p {
    o yPZ;
    private h yVa;

    public p() {
        AppMethodBeat.i(65179);
        init();
        AppMethodBeat.o(65179);
    }

    private void init() {
        AppMethodBeat.i(65180);
        this.yPZ = new o();
        g.aAi();
        String str = (String) g.aAh().azQ().get(356355, (Object) null);
        if (Util.isNullOrNil(str)) {
            this.yPZ.yPy = 2000.0d;
            this.yPZ.yPv = 100;
            this.yPZ.yPz = 200.0d;
            this.yPZ.yPx = 0.01d;
            this.yPZ.yPw = 200.0d;
        } else {
            try {
                this.yPZ.parseFrom(str.getBytes(KindaConfigCacheStg.SAVE_CHARSET));
                efd();
            } catch (Exception e2) {
                Log.w("MicroMsg.LuckyMoneyConfigManager", "parseConfig exp, " + e2.getLocalizedMessage());
                this.yPZ.yPy = 2000.0d;
                this.yPZ.yPv = 100;
                this.yPZ.yPz = 200.0d;
                this.yPZ.yPx = 0.01d;
                this.yPZ.yPw = 200.0d;
            }
        }
        Log.i("MicroMsg.LuckyMoneyConfigManager", "LuckyMoneyConfig init maxTotalAmount:" + this.yPZ.yPy + " maxTotalNum:" + this.yPZ.yPv + " perGroupMaxValue:" + this.yPZ.yPz + " perMinValue:" + this.yPZ.yPx + " perPersonMaxValue:" + this.yPZ.yPw);
        AppMethodBeat.o(65180);
    }

    /* access modifiers changed from: package-private */
    public final void efd() {
        AppMethodBeat.i(65181);
        if (this.yPZ != null) {
            this.yVa = h.aDt(this.yPZ.yUW);
            if (!(this.yVa == null || this.yVa.yUC == null)) {
                ((a) g.af(a.class)).a(this.yVa.yUC);
                g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, (Object) 1);
                if (!Util.isNullOrNil(this.yPZ.yUX)) {
                    Log.d("MicroMsg.LuckyMoneyConfigManager", "parse cover info");
                    try {
                        this.yVa.yUC.iwy = ((dlr) new dlr().parseFrom(Base64.decode(this.yPZ.yUX, 0))).iwy;
                        AppMethodBeat.o(65181);
                        return;
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.LuckyMoneyConfigManager", e2, "", new Object[0]);
                    }
                }
            }
        }
        AppMethodBeat.o(65181);
    }

    public final o efe() {
        AppMethodBeat.i(65182);
        if (this.yPZ == null) {
            init();
        }
        o oVar = this.yPZ;
        AppMethodBeat.o(65182);
        return oVar;
    }

    public final h eff() {
        AppMethodBeat.i(65183);
        if (this.yVa == null) {
            init();
        }
        h hVar = this.yVa;
        AppMethodBeat.o(65183);
        return hVar;
    }
}
