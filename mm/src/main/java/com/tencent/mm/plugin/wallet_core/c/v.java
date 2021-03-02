package com.tencent.mm.plugin.wallet_core.c;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.y.e;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class v extends m {
    public BindCardOrder HPA;
    public String action;

    public v(com.tencent.mm.plugin.wallet_core.model.v vVar) {
        this(vVar, -1, "");
    }

    public v(com.tencent.mm.plugin.wallet_core.model.v vVar, int i2, String str) {
        AppMethodBeat.i(69935);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        setPayInfo(vVar.BDB, hashMap, hashMap2);
        hashMap.put("flag", vVar.flag);
        if ("2".equals(vVar.flag)) {
            hashMap.put("passwd", vVar.kdF);
        }
        hashMap.put("verify_code", vVar.IaW);
        hashMap.put("token", vVar.token);
        if (vVar.BDB != null && !Util.isNullOrNil(vVar.BDB.dDL)) {
            hashMap.put("req_key", vVar.BDB.dDL);
        }
        if (i2 >= 0) {
            hashMap.put("realname_scene", String.valueOf(i2));
            Log.i(m.TAG, "realname_scene=%d", Integer.valueOf(i2));
        }
        if (!Util.isNullOrNil(vVar.dDj)) {
            hashMap.put("bank_type", vVar.dDj);
        }
        if (vVar.flag == "2" && vVar.HVe == 1 && !Util.isNullOrNil(vVar.HQm)) {
            hashMap.put("verify_user_token", "1");
            hashMap.put("usertoken", vVar.HQm);
        }
        hashMap.put("session_id", str);
        if (z.hhq()) {
            hashMap2.put("uuid_for_bindcard", z.getBindCardUuid());
            hashMap2.put("bindcard_scene", new StringBuilder().append(z.hhr()).toString());
        }
        setRequestData(hashMap);
        setWXRequestData(hashMap2);
        AppMethodBeat.o(69935);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 13;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69936);
        this.HPA = new BindCardOrder();
        this.HPA.bB(jSONObject);
        this.action = jSONObject.optString(NativeProtocol.WEB_DIALOG_ACTION);
        AppMethodBeat.o(69936);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindverify";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return e.CTRL_INDEX;
    }
}
