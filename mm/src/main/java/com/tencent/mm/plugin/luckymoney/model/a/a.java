package com.tencent.mm.plugin.luckymoney.model.a;

import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.model.ab;
import com.tencent.mm.plugin.luckymoney.model.ac;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.bk;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends aq {
    public a(String str, int i2) {
        super(23, str, i2);
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.aq, com.tencent.mm.ak.q
    public final int getType() {
        return 4878;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.aq, com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public final String czD() {
        return "/cgi-bin/mmpay-bin/ftfhb/channelliveoperationwxhb";
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.aq, com.tencent.mm.plugin.luckymoney.model.ah
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(258595);
        Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "errCode: %s, errMsg: %s ，json：%s", Integer.valueOf(i2), str, jSONObject.toString());
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
            Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "currency=" + this.qww + ";currencyUint=" + this.yPA + ";currencyWording=" + this.yPB + ";uniqueId=" + this.dUb);
            o oVar = new o();
            oVar.yUR = jSONObject.optString("groupHint");
            oVar.yUS = jSONObject.optString("personalHint");
            oVar.yPv = jSONObject.optInt("totalNum", 100);
            oVar.yPy = f.a(jSONObject.optString("totalAmount", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", 2, RoundingMode.HALF_UP);
            oVar.yPw = f.a(jSONObject.optString("perPersonMaxValue", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", 2, RoundingMode.HALF_UP);
            oVar.yPz = f.a(jSONObject.optString("perGroupMaxValue", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", 2, RoundingMode.HALF_UP);
            oVar.yPx = f.a(jSONObject.optString("perMinValue", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", 2, RoundingMode.HALF_UP);
            Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "config.maxTotalAmount: %s, config.perPersonMaxValue: %s，config.perGroupMaxValue：%s , config.perMinValue:%s", Double.valueOf(oVar.yPy), Double.valueOf(oVar.yPw), Double.valueOf(oVar.yPz), Double.valueOf(oVar.yPx));
            oVar.yUT = jSONObject.optInt("payShowBGFlag");
            oVar.qww = this.qww;
            oVar.yPA = this.yPA;
            oVar.yPB = this.yPB;
            oVar.yUU = jSONObject.optString("foreignFaqUrl");
            oVar.yUV = jSONObject.optString("foreignHongBaoName");
            oVar.yUW = jSONObject.optString("showSourceAndMac");
            oVar.yUX = jSONObject.optString("coverinfo");
            Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "foreignFaqUrl: %s, foreignHongBaoName: %s", oVar.yUU, oVar.yUV);
            com.tencent.mm.plugin.luckymoney.b.a.eex();
            bk hWa = com.tencent.mm.plugin.luckymoney.b.a.hWa();
            hWa.yPZ = oVar;
            hWa.efd();
            Log.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + hWa.yPZ.yPy + " maxTotalNum:" + hWa.yPZ.yPv + " perGroupMaxValue:" + hWa.yPZ.yPz + " perMinValue:" + hWa.yPZ.yPx + " perPersonMaxValue:" + hWa.yPZ.yPw);
            try {
                String str2 = new String(hWa.yPZ.toByteArray(), KindaConfigCacheStg.SAVE_CHARSET);
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_LIVECONFIG_STRING_SYNC, str2);
            } catch (UnsupportedEncodingException e2) {
                Log.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e2.getLocalizedMessage());
            } catch (IOException e3) {
                Log.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e3.getLocalizedMessage());
            }
            this.yXo = ac.ba(jSONObject.optJSONObject("operationHeader"));
            this.yVs = ac.ba(jSONObject.optJSONObject("operationTail"));
            this.yXp = ac.ba(jSONObject.optJSONObject("operationNext"));
            this.yXq = ac.ba(jSONObject.optJSONObject("operationMiddle"));
            int optInt = jSONObject.optInt("sceneSwitch");
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_NEWYEAR_SWITCH_INT_SYNC, Integer.valueOf(optInt));
            Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "sceneSwitch:".concat(String.valueOf(optInt)));
            this.yXr = jSONObject.optInt("scenePicSwitch");
            Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "scenePicSwitch:" + this.yXr);
            this.yXt = jSONObject.optInt("enableYearHbExpression");
            Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "enableYearHbExpression:%s", Integer.valueOf(this.yXt));
            this.yXs = jSONObject.optInt("enableSelfie");
            Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "enableSelfIe:" + this.yXs);
            this.yXu = jSONObject.optInt("enableNormalSelfie");
            this.yXv = jSONObject.optInt("enableNormalAllExpression");
            Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "enableNormalSelfie:%s enableNormalAllExpression:%s", Integer.valueOf(this.yXu), Integer.valueOf(this.yXv));
            int optInt2 = jSONObject.optInt("enableWeishiHb");
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_WEISHI_SWITCH_INT_SYNC, Integer.valueOf(optInt2));
            Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "weishiHbSwitch:".concat(String.valueOf(optInt2)));
            this.yPK = jSONObject.optString("wishing");
            Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "wishing: %s", this.yPK);
            JSONArray optJSONArray = jSONObject.optJSONArray("yearMess");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "yearMessJson is empty!");
            } else {
                Log.i("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "yearMessJson length:" + optJSONArray.length());
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
            AppMethodBeat.o(258595);
            return;
        }
        Log.e("MicroMsg.NetSceneLiveLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + i2 + ", errMsg:" + str);
        AppMethodBeat.o(258595);
    }
}
