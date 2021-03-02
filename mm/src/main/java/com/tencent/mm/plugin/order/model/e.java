package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends m {
    public List<i> AOO = null;
    public List<d> AOP = null;
    public String AOQ;
    public int qwe;
    private int yWN;

    public e(int i2, String str) {
        AppMethodBeat.i(66681);
        HashMap hashMap = new HashMap();
        hashMap.put("Limit", PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT);
        hashMap.put("Offset", String.valueOf(i2));
        hashMap.put("Extbuf", str);
        setRequestData(hashMap);
        AppMethodBeat.o(66681);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 105;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(66682);
        Log.d("MicroMsg.NetScenePatchQueryUserRoll", "errCode " + i2 + " errMsg: " + str);
        this.AOO = new LinkedList();
        try {
            this.qwe = jSONObject.getInt("TotalNum");
            this.yWN = jSONObject.getInt("RecNum");
            this.AOQ = jSONObject.optString("Extbuf");
            JSONArray jSONArray = jSONObject.getJSONArray("UserRollList");
            if (jSONArray != null) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    i iVar = new i();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    iVar.APa = jSONObject2.optInt("PayType");
                    iVar.AOT = jSONObject2.optString("Transid");
                    iVar.AOU = jSONObject2.optDouble("TotalFee");
                    iVar.AOV = jSONObject2.optString("GoodsName");
                    iVar.CreateTime = jSONObject2.optInt("CreateTime");
                    iVar.AOX = jSONObject2.optInt("ModifyTime");
                    iVar.AOY = jSONObject2.optString("FeeType");
                    iVar.APd = jSONObject2.optString("AppThumbUrl");
                    iVar.AOW = jSONObject2.optString("TradeStateName");
                    iVar.APi = jSONObject2.optString("StatusColor");
                    iVar.APj = jSONObject2.optString("FeeColor");
                    iVar.APk = jSONObject2.optDouble("ActualPayFee");
                    iVar.APl = jSONObject2.optString("BillId");
                    this.AOO.add(iVar);
                }
            }
            this.AOP = new LinkedList();
            JSONArray optJSONArray = jSONObject.optJSONArray("month_info");
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i4);
                    d dVar = new d();
                    dVar.year = jSONObject3.optInt("year");
                    dVar.month = jSONObject3.optInt("month");
                    dVar.AON = jSONObject3.optString("feetext");
                    this.AOP.add(dVar);
                }
            }
            AppMethodBeat.o(66682);
        } catch (JSONException e2) {
            Log.e("MicroMsg.NetScenePatchQueryUserRoll", "Parse Json exp:" + e2.getLocalizedMessage());
            AppMethodBeat.o(66682);
        }
    }
}
