package com.tencent.mm.plugin.wallet.pay.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.utils.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class j extends n {
    public Orders HFH = null;
    private int mPayScene = -1;

    public j(v vVar, Orders orders) {
        String str = null;
        int i2 = -1;
        AppMethodBeat.i(69299);
        this.HFH = orders;
        if (vVar.BDB != null) {
            this.mPayScene = vVar.BDB.dVv;
            i2 = vVar.BDB.channel;
        }
        List<Orders.Commodity> list = orders.HZd;
        b(orders.dDL, list.size() > 0 ? list.get(0).dDM : str, this.mPayScene, i2, vVar.dDj, vVar.ANo);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        boolean z = !Util.isNullOrNil(vVar.kdF);
        Log.i("MicroMsg.NetSceneTenpayVertifyReg", "hy: has pwd: %b", Boolean.valueOf(z));
        setPayInfo(vVar.BDB, hashMap, hashMap2, z);
        hashMap.put("flag", vVar.flag);
        hashMap.put("passwd", vVar.kdF);
        hashMap.put("verify_code", vVar.IaW);
        hashMap.put("token", vVar.token);
        hashMap.put("favorcomposedid", vVar.HUY);
        hashMap.put("default_favorcomposedid", vVar.HUX);
        setRequestData(hashMap);
        setWXRequestData(hashMap2);
        AppMethodBeat.o(69299);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getTenpayCgicmd() {
        return 16;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.p, com.tencent.mm.wallet_core.c.s, com.tencent.mm.wallet_core.tenpay.model.n
    public void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69300);
        super.onGYNetEnd(i2, str, jSONObject);
        if (i2 != 0) {
            AppMethodBeat.o(69300);
            return;
        }
        Log.d("MicroMsg.NetSceneTenpayVertifyReg", "Pay Success! saving bind_serial:".concat(String.valueOf(jSONObject.optString("bind_serial"))));
        if ("1".equals(jSONObject.optString("pay_flag"))) {
            setPaySuccess(true);
            this.HFH = Orders.a(jSONObject, this.HFH);
        } else {
            setPaySuccess(false);
        }
        Log.i("MicroMsg.NetSceneTenpayVertifyReg", "mPayScene:" + this.mPayScene);
        if (this.mPayScene == 39) {
            Log.i("MicroMsg.NetSceneTenpayVertifyReg", "it's the sns scene, parse the sns pay data");
            e.bW(jSONObject);
        } else {
            Log.i("MicroMsg.NetSceneTenpayVertifyReg", "it's not the sns scene");
        }
        for (d dVar : a.bpk("PayProcess")) {
            dVar.dQL.putInt("key_is_clear_failure", this.RuW);
        }
        AppMethodBeat.o(69300);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public String getUri() {
        if (this.mPayScene == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveverifyreg";
        }
        if (this.mPayScene == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchverifyreg";
        }
        return "/cgi-bin/mmpay-bin/tenpay/verifyreg";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getFuncId() {
        if (this.mPayScene == 11) {
            return 1684;
        }
        if (this.mPayScene == 21) {
            return 1608;
        }
        return JsApiAddDownloadTask.CTRL_INDEX;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.n
    public final boolean fOn() {
        if (this.mPayScene == 11 || this.mPayScene == 21) {
            return true;
        }
        return false;
    }
}
