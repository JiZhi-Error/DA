package com.tencent.mm.plugin.luckymoney.model;

import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ar extends aq {
    public ar(String str, int i2) {
        AppMethodBeat.i(213321);
        HashMap hashMap = new HashMap();
        hashMap.put("ver", str);
        g.aAi();
        hashMap.put("walletType", String.valueOf(g.aAh().azQ().get(339975, (Object) null)));
        hashMap.put("hasSource", String.valueOf(i2));
        hashMap.put("scene", "20");
        hashMap.put("union_source", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "NetSceneLuckyMoneyGetConfigUnion request");
        setRequestData(hashMap);
        AppMethodBeat.o(213321);
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.aq, com.tencent.mm.ak.q
    public final int getType() {
        return 4605;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.aq, com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public final String czD() {
        return "/cgi-bin/mmpay-bin/unionhb/operationunionhb";
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.aq, com.tencent.mm.plugin.luckymoney.model.ah
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(213322);
        Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "errCode: %s, errMsg: %s ，json：%s", Integer.valueOf(i2), str, jSONObject.toString());
        if (i2 == 0) {
            this.yXm = jSONObject.optInt("randomAmount");
            this.yXk = jSONObject.optString("randomWishing");
            this.jTx = jSONObject.optString("notice");
            this.yXn = jSONObject.optString("notice_url");
            this.yXl = jSONObject.optInt("hasCanShareHongBao") == 1;
            this.qww = jSONObject.optInt(FirebaseAnalytics.b.CURRENCY);
            this.qww = 1;
            this.yPA = jSONObject.optString("currencyUint");
            this.yPB = jSONObject.optString("currencyWording");
            this.dUb = jSONObject.optString("unique_id");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "currency=" + this.qww + ";currencyUint=" + this.yPA + ";currencyWording=" + this.yPB + ";uniqueId=" + this.dUb);
            o oVar = new o();
            oVar.yUR = jSONObject.optString("groupHint");
            oVar.yUS = jSONObject.optString("personalHint");
            oVar.yPv = jSONObject.optInt("totalNum", 100);
            oVar.yPy = f.a(jSONObject.optString("totalAmount", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", 2, RoundingMode.HALF_UP);
            oVar.yPw = f.a(jSONObject.optString("perPersonMaxValue", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", 2, RoundingMode.HALF_UP);
            oVar.yPz = f.a(jSONObject.optString("perGroupMaxValue", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", 2, RoundingMode.HALF_UP);
            oVar.yPx = f.a(jSONObject.optString("perMinValue", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", 2, RoundingMode.HALF_UP);
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "config.maxTotalAmount: %s, config.perPersonMaxValue: %s，config.perGroupMaxValue：%s , config.perMinValue:%s", Double.valueOf(oVar.yPy), Double.valueOf(oVar.yPw), Double.valueOf(oVar.yPz), Double.valueOf(oVar.yPx));
            oVar.yUT = jSONObject.optInt("payShowBGFlag");
            oVar.qww = this.qww;
            oVar.yPA = this.yPA;
            oVar.yPB = this.yPB;
            oVar.yUU = jSONObject.optString("foreignFaqUrl");
            oVar.yUV = jSONObject.optString("foreignHongBaoName");
            oVar.yUW = jSONObject.optString("showSourceAndMac");
            oVar.yUX = jSONObject.optString("coverinfo");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "foreignFaqUrl: %s, foreignHongBaoName: %s", oVar.yUU, oVar.yUV);
            a.eex();
            ae eez = a.eez();
            eez.yPZ = oVar;
            eez.efd();
            Log.i("MicroMsg.LuckyMoneyUnionConfigManager", "setConfig maxTotalAmount:" + eez.yPZ.yPy + " maxTotalNum:" + eez.yPZ.yPv + " perGroupMaxValue:" + eez.yPZ.yPz + " perMinValue:" + eez.yPZ.yPx + " perPersonMaxValue:" + eez.yPZ.yPw);
            try {
                String str2 = new String(eez.yPZ.toByteArray(), KindaConfigCacheStg.SAVE_CHARSET);
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_UNION_CONFIG_STRING_SYNC, str2);
                g.aAi();
                g.aAh().azQ().gBI();
            } catch (UnsupportedEncodingException e2) {
                Log.w("MicroMsg.LuckyMoneyUnionConfigManager", "save config exp, " + e2.getLocalizedMessage());
            } catch (IOException e3) {
                Log.w("MicroMsg.LuckyMoneyUnionConfigManager", "save config exp, " + e3.getLocalizedMessage());
            }
            this.yXo = ac.ba(jSONObject.optJSONObject("operationHeader"));
            this.yVs = ac.ba(jSONObject.optJSONObject("operationTail"));
            this.yXp = ac.ba(jSONObject.optJSONObject("operationNext"));
            this.yXq = ac.ba(jSONObject.optJSONObject("operationMiddle"));
            int optInt = jSONObject.optInt("sceneSwitch");
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_NEWYEAR_UNION_SWITCH_INT_SYNC, Integer.valueOf(optInt));
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "sceneSwitch:".concat(String.valueOf(optInt)));
            this.yXr = jSONObject.optInt("scenePicSwitch");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "scenePicSwitch:" + this.yXr);
            this.yXt = jSONObject.optInt("enableYearHbExpression");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "enableYearHbExpression:%s", Integer.valueOf(this.yXt));
            this.yXs = jSONObject.optInt("enableSelfie");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "enableSelfIe:" + this.yXs);
            this.yXu = jSONObject.optInt("enableNormalSelfie");
            this.yXv = jSONObject.optInt("enableNormalAllExpression");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "enableNormalSelfie:%s enableNormalAllExpression:%s", Integer.valueOf(this.yXu), Integer.valueOf(this.yXv));
            int optInt2 = jSONObject.optInt("enableWeishiHb");
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_WEISHI_UNION_SWITCH_INT_SYNC, Integer.valueOf(optInt2));
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "weishiHbSwitch:".concat(String.valueOf(optInt2)));
            this.yPK = jSONObject.optString("wishing");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "wishing: %s", this.yPK);
            JSONArray optJSONArray = jSONObject.optJSONArray("yearMess");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "yearMessJson is empty!");
            } else {
                Log.i("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "yearMessJson length:" + optJSONArray.length());
                this.yXw = new LinkedList();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    ab abVar = new ab();
                    abVar.yWB = optJSONObject.optInt("yearAmount", 0);
                    abVar.yWC = optJSONObject.optString("yearWish");
                    this.yXw.add(abVar);
                }
            }
            efk();
            AppMethodBeat.o(213322);
            return;
        }
        Log.e("MicroMsg.NetSceneLuckyMoneyGetConfigUnion", "hongbao operation fail, errCode:" + i2 + ", errMsg:" + str);
        AppMethodBeat.o(213322);
    }
}
