package com.tencent.mm.plugin.wallet.pay.a.c;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.pay.a.d;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class f extends m {
    public Orders CwO = null;
    public int HFS = 0;
    public d HFT = null;
    private int dVv = 0;
    public String egd;
    public String ege;
    public String egf;
    public String egg;
    public String egh;
    public String errMsg;
    private String mReqKey = null;
    private int scene = 0;

    public f(PayInfo payInfo, int i2) {
        AppMethodBeat.i(69281);
        if (payInfo == null) {
            Log.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "error payinfo is null %s", Util.getStack().toString());
            this.mReqKey = "";
        } else {
            this.mReqKey = payInfo.dDL;
        }
        this.scene = i2;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("support_cardtag3", "1");
        hashMap.put("req_key", this.mReqKey);
        hashMap.put("bind_query_scene", String.valueOf(i2));
        hashMap.put("is_merge", "1");
        a aVar = (a) g.af(a.class);
        hashMap.put("is_root", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (aVar == null || (!aVar.dJU() && !aVar.dKc())) {
            hashMap.put("is_device_open_touch", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            Log.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is false");
        } else {
            hashMap.put("is_device_open_touch", "1");
            Map<String, String> dJY = aVar.dJY();
            if (dJY != null) {
                hashMap.putAll(dJY);
            }
            Log.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is true");
        }
        if (payInfo != null) {
            this.dVv = payInfo.dVv;
        }
        setPayInfo(payInfo, hashMap, hashMap2);
        setRequestData(hashMap);
        setWXRequestData(hashMap2);
        AppMethodBeat.o(69281);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getTenpayCgicmd() {
        return 112;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public void onGYNetEnd2(e eVar, JSONObject jSONObject) {
        AppMethodBeat.i(69282);
        super.onGYNetEnd2(eVar, jSONObject);
        int i2 = this.dVv;
        String str = this.mReqKey;
        int i3 = eVar.errCode;
        Log.v("Micromsg.WalletPayLinkReport", "kvQrcode scene %s reqKey %s errcode %s", Integer.valueOf(i2), str, Integer.valueOf(i3));
        h.INSTANCE.a(15000, Integer.valueOf(i2), str, Integer.valueOf(i3));
        AppMethodBeat.o(69282);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        d dVar;
        AppMethodBeat.i(69283);
        try {
            this.errMsg = str;
            this.CwO = Orders.by(jSONObject);
            if (this.CwO != null) {
                this.CwO.dDL = this.mReqKey;
            }
            long optLong = jSONObject.optJSONObject("bindqueryresp").optLong("time_stamp");
            if (optLong > 0) {
                y.setTimeStamp(String.valueOf(optLong));
            } else {
                Log.w("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "no time_stamp in qrcodeusebindquery.");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("query_order_info");
            if (optJSONObject != null) {
                Log.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "get query_order_info");
                t.fQI().IbW = optJSONObject.optInt("query_order_time", 5) * 1000;
                t.fQI().mRetryCount = optJSONObject.optInt("query_order_count", 0);
                t.fQI().IbX = optJSONObject.optString("default_query_order_wording", "");
            }
            t.fQI().IbY = jSONObject.optString("pay_remind_wording");
            ai.a(jSONObject.optJSONObject("bindqueryresp"), this.dVv, false, false);
            a aVar = (a) g.af(a.class);
            if (aVar != null) {
                Log.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is not null");
                aVar.dJV();
                int fRq = t.fQI().fRq();
                if (fRq == 0) {
                    if (aVar.dJT()) {
                        aVar.pj(t.fQI().fRo());
                        aVar.pk(false);
                    } else if (aVar.dKb()) {
                        aVar.pk(t.fQI().fRo());
                        aVar.pj(false);
                    }
                } else if (fRq == 1 && aVar.dJT()) {
                    aVar.pj(t.fQI().fRo());
                    aVar.pk(false);
                } else if (fRq == 2 && aVar.dKb()) {
                    aVar.pk(t.fQI().fRo());
                    aVar.pj(false);
                }
            } else {
                Log.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is null");
            }
            if (jSONObject.has("real_name_info")) {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("real_name_info");
                this.egd = optJSONObject2.optString("guide_flag");
                this.ege = optJSONObject2.optString("guide_wording");
                this.egf = optJSONObject2.optString("left_button_wording");
                this.egg = optJSONObject2.optString("right_button_wording");
                this.egh = optJSONObject2.optString("upload_credit_url");
                this.HFS = optJSONObject2.optInt("guide_type", 0);
            }
            if (jSONObject.has("user_notify_info")) {
                JSONObject optJSONObject3 = jSONObject.optJSONObject("user_notify_info");
                if (optJSONObject3 == null) {
                    dVar = null;
                } else {
                    int optInt = optJSONObject3.optInt("notify_flag", 0);
                    String optString = optJSONObject3.optString("notify_wording", "");
                    String optString2 = optJSONObject3.optString("left_button_wording", "");
                    String optString3 = optJSONObject3.optString("right_button_wording", "");
                    String optString4 = optJSONObject3.optString("confirm_button_wording", "");
                    if (optInt == 0) {
                        dVar = null;
                    } else {
                        dVar = new d();
                        dVar.HFB = optInt;
                        dVar.HFC = optString;
                        dVar.lHA = optString2;
                        dVar.lHB = optString3;
                        dVar.HFD = optString4;
                    }
                }
                this.HFT = dVar;
            }
            AppMethodBeat.o(69283);
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "hy: " + e2.toString());
            AppMethodBeat.o(69283);
        }
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getFuncId() {
        return 1593;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/qrcodeusebindquery";
    }
}
