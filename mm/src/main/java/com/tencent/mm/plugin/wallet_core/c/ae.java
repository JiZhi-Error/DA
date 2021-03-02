package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ae extends m {
    public Orders HQs;

    public ae(String str) {
        AppMethodBeat.i(69954);
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str);
        setRequestData(hashMap);
        AppMethodBeat.o(69954);
    }

    public ae(String str, int i2) {
        AppMethodBeat.i(69955);
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("pay_type", String.valueOf(i2));
        setRequestData(hashMap);
        AppMethodBeat.o(69955);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 3;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69956);
        if (jSONObject != null) {
            try {
                this.HQs = new Orders();
                Orders.Commodity commodity = new Orders.Commodity();
                commodity.ANX = jSONObject.getString("buy_uin");
                commodity.ANY = jSONObject.getString("buy_name");
                commodity.ANZ = jSONObject.optString("sale_uin");
                commodity.AOa = jSONObject.optString("sale_name");
                commodity.dDM = jSONObject.getString("trans_id");
                commodity.desc = jSONObject.optString("goods_name");
                commodity.qwJ = jSONObject.optDouble("pay_num") / 100.0d;
                commodity.AOe = jSONObject.getString("trade_state");
                commodity.AOf = jSONObject.getString("trade_state_name");
                commodity.AOj = jSONObject.getString("buy_bank_name");
                commodity.AOp = jSONObject.optString("discount", "");
                commodity.AOh = jSONObject.optInt("modify_timestamp");
                commodity.AOl = jSONObject.optString("fee_type");
                commodity.dCu = jSONObject.optString("appusername");
                commodity.ANP = jSONObject.optString("app_telephone");
                commodity.HZE = jSONObject.optDouble("original_total_fee", -1.0d) / 100.0d;
                commodity.AOl = jSONObject.optString("fee_type", "");
                int i3 = 1;
                JSONObject optJSONObject = jSONObject.optJSONObject("subscribe_biz_info");
                if (optJSONObject != null) {
                    Orders.Promotions promotions = new Orders.Promotions();
                    promotions.type = Orders.HZC;
                    promotions.name = optJSONObject.optString("nickname");
                    promotions.dCu = optJSONObject.optString(ch.COL_USERNAME);
                    commodity.HZF = promotions.dCu;
                    promotions.Bah = optJSONObject.optString("logo_round_url");
                    promotions.url = optJSONObject.optString("subscribe_biz_url");
                    i3 = optJSONObject.optInt("recommend_level");
                    commodity.HYT = i3;
                    if (!Util.isNullOrNil(promotions.name)) {
                        commodity.HZN.add(promotions);
                    }
                }
                JSONArray jSONArray = jSONObject.getJSONArray("activity_info");
                int length = jSONArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                    Orders.Promotions promotions2 = new Orders.Promotions();
                    promotions2.type = Orders.HZD;
                    promotions2.Bah = jSONObject2.optString("icon");
                    promotions2.name = jSONObject2.optString("wording");
                    promotions2.url = jSONObject2.optString("url");
                    promotions2.HYF = jSONObject2.optString("btn_text");
                    promotions2.trD = jSONObject2.optInt("type");
                    promotions2.title = jSONObject2.optString("title");
                    promotions2.crw = jSONObject2.optLong("activity_id");
                    promotions2.Vgg = jSONObject2.optInt("activity_type", 0);
                    promotions2.Vgh = jSONObject2.optInt("award_id");
                    promotions2.HYC = jSONObject2.optInt("send_record_id");
                    promotions2.HYD = jSONObject2.optInt("user_record_id");
                    promotions2.Vgj = jSONObject2.optString("activity_tinyapp_username");
                    promotions2.Vgk = jSONObject2.optString("activity_tinyapp_path");
                    promotions2.HYE = jSONObject2.optLong("activity_mch_id");
                    promotions2.Vgl = jSONObject2.optInt("activity_tinyapp_version");
                    promotions2.Vgm = jSONObject2.optString("get_award_params");
                    promotions2.Vgn = jSONObject2.optString("query_award_status_params");
                    Orders.a(promotions2, jSONObject2.optJSONObject("exposure_info"));
                    commodity.HZN.add(promotions2);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("discount_array");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length2 = optJSONArray.length();
                    commodity.HZH = new ArrayList();
                    for (int i5 = 0; i5 < length2; i5++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i5);
                        Orders.DiscountInfo discountInfo = new Orders.DiscountInfo();
                        discountInfo.HZY = optJSONObject2.optDouble("payment_amount");
                        discountInfo.Coh = optJSONObject2.optString("favor_desc");
                        commodity.HZH.add(discountInfo);
                    }
                }
                commodity.HZI = jSONObject.optString("rateinfo");
                commodity.HZJ = jSONObject.optString("discount_rateinfo");
                commodity.HZK = jSONObject.optString("original_feeinfo");
                this.HQs.HZd = new ArrayList();
                this.HQs.HZd.add(commodity);
                this.HQs.HYV = jSONObject.optString("trade_state_name");
                this.HQs.HYT = i3;
                AppMethodBeat.o(69956);
                return;
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", e2, "", new Object[0]);
                AppMethodBeat.o(69956);
                return;
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", e3, "", new Object[0]);
            }
        }
        AppMethodBeat.o(69956);
    }
}
