package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.utils.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class g extends n {
    public Orders HFH = null;
    protected v HFW;
    private int mPayScene = -1;

    public g(v vVar, Orders orders) {
        String str = null;
        AppMethodBeat.i(69294);
        this.HFH = orders;
        this.HFW = vVar;
        List<Orders.Commodity> list = orders.HZd;
        str = list.size() > 0 ? list.get(0).dDM : str;
        if (vVar.BDB == null) {
            Log.e("MicroMsg.NetSceneTenpayPayVertify", "empty payInfo");
            AppMethodBeat.o(69294);
            return;
        }
        this.mPayScene = vVar.BDB.dVv;
        b(orders.dDL, str, vVar.BDB.dVv, vVar.BDB.channel, vVar.dDj, vVar.ANo);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("flag", vVar.flag);
        hashMap.put("passwd", vVar.kdF);
        boolean z = !Util.isNullOrNil(vVar.kdF);
        Log.i("MicroMsg.NetSceneTenpayPayVertify", "hy: has pwd: %b", Boolean.valueOf(z));
        setPayInfo(vVar.BDB, hashMap, hashMap2, z);
        hashMap.put("verify_type", new StringBuilder().append(vVar.dUT).toString());
        if (vVar.dUT == 0) {
            hashMap.put("verify_code", vVar.IaW);
        } else {
            hashMap.put("cre_tail", vVar.IaY);
            hashMap.put("cre_type", vVar.IaZ);
        }
        hashMap.put("token", vVar.token);
        hashMap.put("bank_type", vVar.dDj);
        hashMap.put("bind_serial", vVar.ANo);
        hashMap.put("arrive_type", vVar.HUU);
        hashMap.put("default_favorcomposedid", vVar.HUX);
        hashMap.put("favorcomposedid", vVar.HUY);
        aX(hashMap);
        if (z.hhq()) {
            hashMap2.put("uuid_for_bindcard", z.getBindCardUuid());
            hashMap2.put("bindcard_scene", new StringBuilder().append(z.hhr()).toString());
        }
        setRequestData(hashMap);
        setWXRequestData(hashMap2);
        AppMethodBeat.o(69294);
    }

    /* access modifiers changed from: protected */
    public void aX(Map<String, String> map) {
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getTenpayCgicmd() {
        return 1;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.p, com.tencent.mm.wallet_core.c.s, com.tencent.mm.wallet_core.tenpay.model.n
    public void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69295);
        super.onGYNetEnd(i2, str, jSONObject);
        if (i2 != 0) {
            AppMethodBeat.o(69295);
            return;
        }
        Log.d("MicroMsg.NetSceneTenpayPayVertify", "Pay Success! saving bind_serial:".concat(String.valueOf(jSONObject.optString("bind_serial"))));
        if ("1".equals(jSONObject.optString("pay_flag"))) {
            setPaySuccess(true);
            this.HFH = Orders.a(jSONObject, this.HFH);
        } else {
            setPaySuccess(false);
        }
        Log.i("MicroMsg.NetSceneTenpayPayVertify", "mPayScene:" + this.mPayScene);
        if (this.mPayScene == 39) {
            Log.i("MicroMsg.NetSceneTenpayPayVertify", "it's the sns scene, parse the sns pay data");
            e.bW(jSONObject);
        } else {
            Log.i("MicroMsg.NetSceneTenpayPayVertify", "it's not the sns scene");
        }
        for (d dVar : a.bpk("PayProcess")) {
            dVar.dQL.putInt("key_is_clear_failure", this.RuW);
        }
        AppMethodBeat.o(69295);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public String getUri() {
        if (this.mPayScene == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveverify";
        }
        if (this.mPayScene == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchverify";
        }
        return "/cgi-bin/mmpay-bin/tenpay/verify";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getFuncId() {
        if (this.mPayScene == 11) {
            return 1607;
        }
        if (this.mPayScene == 21) {
            return 1606;
        }
        return 462;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.n
    public final boolean fOn() {
        if (this.mPayScene == 11 || this.mPayScene == 21) {
            return true;
        }
        return false;
    }
}
