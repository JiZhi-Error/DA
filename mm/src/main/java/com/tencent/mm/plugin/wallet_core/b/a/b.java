package com.tencent.mm.plugin.wallet_core.b.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends m implements j {
    public BindCardOrder HPA;
    public int HPB;
    public String desc;
    public String jmT;
    public String title;

    public b(v vVar) {
        this(vVar, -1, "", null);
    }

    public b(v vVar, int i2, String str, RealNameBundle realNameBundle) {
        AppMethodBeat.i(174437);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("flag", vVar.flag);
        hashMap.put("passwd", vVar.kdF);
        hashMap.put("verify_code", vVar.IaW);
        hashMap.put("token", vVar.token);
        hashMap.put("bind_flag", vVar.IaX ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (i2 > 0) {
            hashMap.put("realname_scene", String.valueOf(i2));
            Log.i(m.TAG, "realname_scene=%d", Integer.valueOf(i2));
        }
        if (realNameBundle != null) {
            realNameBundle.aY(hashMap);
        }
        if (!Util.isNullOrNil(vVar.dDj)) {
            hashMap.put("bank_type", vVar.dDj);
        }
        hashMap.put("session_id", str);
        if (z.hhq()) {
            hashMap2.put("uuid_for_bindcard", z.getBindCardUuid());
            hashMap2.put("bindcard_scene", new StringBuilder().append(z.hhr()).toString());
        }
        setPayInfo(vVar.BDB, hashMap, hashMap2);
        setRequestData(hashMap);
        setWXRequestData(hashMap2);
        AppMethodBeat.o(174437);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 17;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69886);
        this.HPA = new BindCardOrder();
        this.HPA.bB(jSONObject);
        this.title = jSONObject.optString("title");
        this.desc = jSONObject.optString("desc");
        this.jmT = jSONObject.optString("page");
        this.HPB = jSONObject.optInt("err_jump_page");
        AppMethodBeat.o(69886);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindverifyreg";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return JsApiCancelDownloadTask.CTRL_INDEX;
    }
}
