package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import org.json.JSONObject;

public class b extends g {
    private boolean HFU = false;
    private boolean HFV;

    @Override // com.tencent.mm.plugin.wallet.pay.a.d.g, com.tencent.mm.wallet_core.tenpay.model.m
    public int getTenpayCgicmd() {
        return 121;
    }

    public b(v vVar, Orders orders) {
        super(vVar, orders);
        AppMethodBeat.i(69284);
        fOo();
        AppMethodBeat.o(69284);
    }

    private void fOo() {
        AppMethodBeat.i(69285);
        this.HFU = false;
        s.fOg();
        if (!(s.fOh().IbQ == null || this.HFW.BDB == null)) {
            String str = this.HFW.dDj;
            s.fOg();
            if (str.equals(s.fOh().IbQ.field_bankcardType)) {
                if (this.HFW.BDB.dVv == 31 || this.HFW.BDB.dVv == 32 || this.HFW.BDB.dVv == 33 || this.HFW.BDB.dVv == 42 || this.HFW.BDB.dVv == 37 || this.HFW.BDB.dVv == 56) {
                    this.HFU = true;
                } else {
                    this.HFV = true;
                }
            }
        }
        Log.i("MicroMsg.NetSceneTenpayPayVertify", "isLqtSns: %s, isLqtTs: %s", Boolean.valueOf(this.HFU), Boolean.valueOf(this.HFV));
        AppMethodBeat.o(69285);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wallet.pay.a.d.g
    public void aX(Map<String, String> map) {
        AppMethodBeat.i(69286);
        fOo();
        if (this.HFU || this.HFV) {
            map.put("busi_scene", this.HFW.dDj);
        }
        AppMethodBeat.o(69286);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.d.g, com.tencent.mm.wallet_core.tenpay.model.m
    public int getFuncId() {
        AppMethodBeat.i(69287);
        fOo();
        if (this.HFU) {
            AppMethodBeat.o(69287);
            return 1281;
        } else if (this.HFV) {
            AppMethodBeat.o(69287);
            return 1305;
        } else {
            AppMethodBeat.o(69287);
            return 1601;
        }
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.d.g, com.tencent.mm.wallet_core.tenpay.model.m
    public String getUri() {
        AppMethodBeat.i(69288);
        fOo();
        if (this.HFU) {
            AppMethodBeat.o(69288);
            return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
        } else if (this.HFV) {
            AppMethodBeat.o(69288);
            return "/cgi-bin/mmpay-bin/tenpay/lqtpaybindverify";
        } else {
            AppMethodBeat.o(69288);
            return "/cgi-bin/mmpay-bin/tenpay/banpaybindverify";
        }
    }

    @Override // com.tencent.mm.ak.q, com.tencent.mm.wallet_core.tenpay.model.m
    public int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69289);
        if (this.HFU) {
            h.INSTANCE.idkeyStat(663, 26, 1, false);
        } else if (this.HFV) {
            h.INSTANCE.idkeyStat(663, 22, 1, false);
        }
        int doScene = super.doScene(gVar, iVar);
        AppMethodBeat.o(69289);
        return doScene;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.p, com.tencent.mm.wallet_core.c.s, com.tencent.mm.plugin.wallet.pay.a.d.g, com.tencent.mm.wallet_core.tenpay.model.n
    public void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69290);
        super.onGYNetEnd(i2, str, jSONObject);
        if (i2 != 0) {
            if (this.HFU) {
                h.INSTANCE.idkeyStat(663, 27, 1, false);
                AppMethodBeat.o(69290);
                return;
            } else if (this.HFV) {
                h.INSTANCE.idkeyStat(663, 23, 1, false);
            }
        }
        AppMethodBeat.o(69290);
    }
}
