package com.tencent.mm.plugin.wallet_core.c.c;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class a extends m {
    private int HQK;
    public Orders HQL;

    public a(String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7) {
        AppMethodBeat.i(69979);
        Log.i("MicroMsg.NetSceneGetPaidOrderDetail", "do NetSceneGetPaidOrderDetail");
        this.HQK = i2;
        HashMap hashMap = new HashMap();
        hashMap.put("appId", !Util.isNullOrNil(str) ? q.encode(str) : str);
        hashMap.put("timeStamp", !Util.isNullOrNil(str2) ? q.encode(str2) : str2);
        hashMap.put("nonceStr", !Util.isNullOrNil(str3) ? q.encode(str3) : str3);
        hashMap.put("package", !Util.isNullOrNil(str4) ? q.encode(str4) : str4);
        hashMap.put("reqKey", !Util.isNullOrNil(str5) ? q.encode(str5) : str5);
        hashMap.put("payScene", q.encode(String.valueOf(i2)));
        hashMap.put("signType", !Util.isNullOrNil(str6) ? q.encode(str6) : str6);
        hashMap.put("paySign", !Util.isNullOrNil(str7) ? q.encode(str7) : str7);
        setRequestData(hashMap);
        AppMethodBeat.o(69979);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        if (this.HQK == 2) {
            return "/cgi-bin/mmpay-bin/tenpay/offlinegetpaidorderdetail";
        }
        return "/cgi-bin/mmpay-bin/tenpay/getpaidorderdetail";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        if (this.HQK == 2) {
            return 2516;
        }
        return 2570;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        if (this.HQK == 2) {
            return 2516;
        }
        return 2570;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69980);
        Log.i("MicroMsg.NetSceneGetPaidOrderDetail", "errCode: " + i2 + " errMsg: " + str);
        if (jSONObject != null && isPayEnd()) {
            this.HQL = by(jSONObject);
            this.HQL = Orders.a(jSONObject, this.HQL);
        }
        AppMethodBeat.o(69980);
    }

    private Orders by(JSONObject jSONObject) {
        AppMethodBeat.i(69981);
        if (this.HQL == null) {
            this.HQL = new Orders();
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("payresult");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                Orders.Commodity commodity = new Orders.Commodity();
                commodity.dDM = jSONObject2.getString(FirebaseAnalytics.b.TRANSACTION_ID);
                commodity.AOa = jSONObject2.optString("sp_name");
                if (Util.isNullOrNil(this.HQL.AOl)) {
                    this.HQL.AOl = jSONObject2.optString("fee_type");
                }
                this.HQL.HZd.add(commodity);
            }
        } catch (JSONException e2) {
        }
        Orders orders = this.HQL;
        AppMethodBeat.o(69981);
        return orders;
    }
}
