package com.tencent.mm.plugin.luckymoney.model;

import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aq extends av {
    public String dUb;
    public String jTx;
    public int qww;
    public String yPA;
    public String yPB;
    public String yPK;
    public bg yVs;
    public String yXk;
    public boolean yXl;
    public int yXm;
    public String yXn;
    public bg yXo;
    public bg yXp;
    public bg yXq;
    public int yXr;
    public int yXs;
    public int yXt;
    public int yXu;
    public int yXv;
    public LinkedList<ab> yXw;

    public aq() {
        this.yXr = 0;
        this.yXs = 0;
        this.yXt = 0;
        this.yXu = 0;
        this.yXv = 0;
    }

    public aq(int i2, String str, int i3) {
        AppMethodBeat.i(258594);
        this.yXr = 0;
        this.yXs = 0;
        this.yXt = 0;
        this.yXu = 0;
        this.yXv = 0;
        HashMap hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i2));
        hashMap.put("ver", str);
        g.aAi();
        hashMap.put("walletType", String.valueOf(g.aAh().azQ().get(339975, (Object) null)));
        hashMap.put("hasSource", String.valueOf(i3));
        Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "NetSceneLuckyMoneyGetConfig request");
        setRequestData(hashMap);
        AppMethodBeat.o(258594);
    }

    public aq(String str, int i2) {
        this(0, str, i2);
        AppMethodBeat.i(65288);
        AppMethodBeat.o(65288);
    }

    @Override // com.tencent.mm.ak.q
    public int getType() {
        return 1554;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public String czD() {
        return "/cgi-bin/mmpay-bin/operationwxhb";
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(65290);
        Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "errCode: %s, errMsg: %s ，json：%s", Integer.valueOf(i2), str, jSONObject.toString());
        if (i2 == 0) {
            this.yXm = jSONObject.optInt("randomAmount");
            this.yXk = jSONObject.optString("randomWishing");
            this.jTx = jSONObject.optString("notice");
            this.yXn = jSONObject.optString("notice_url");
            this.yXl = jSONObject.optInt("hasCanShareHongBao") == 1;
            this.qww = jSONObject.optInt(FirebaseAnalytics.b.CURRENCY);
            this.yPA = jSONObject.optString("currencyUint");
            this.yPB = jSONObject.optString("currencyWording");
            this.dUb = jSONObject.optString("unique_id");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "currency=" + this.qww + ";currencyUint=" + this.yPA + ";currencyWording=" + this.yPB + ";uniqueId=" + this.dUb);
            o oVar = new o();
            oVar.yUR = jSONObject.optString("groupHint");
            oVar.yUS = jSONObject.optString("personalHint");
            oVar.yPy = ((double) jSONObject.optLong("totalAmount", 200000)) / 100.0d;
            oVar.yPv = jSONObject.optInt("totalNum", 100);
            oVar.yPw = ((double) jSONObject.optLong("perPersonMaxValue", 20000)) / 100.0d;
            oVar.yPz = ((double) jSONObject.optLong("perGroupMaxValue", 20000)) / 100.0d;
            oVar.yPx = ((double) jSONObject.optLong("perMinValue", 1)) / 100.0d;
            oVar.yUT = jSONObject.optInt("payShowBGFlag");
            oVar.yUY = jSONObject.optBoolean("enableExclusiveHb");
            oVar.qww = this.qww;
            oVar.yPA = this.yPA;
            oVar.yPB = this.yPB;
            oVar.yUU = jSONObject.optString("foreignFaqUrl");
            oVar.yUV = jSONObject.optString("foreignHongBaoName");
            oVar.yUW = jSONObject.optString("showSourceAndMac");
            oVar.yUX = jSONObject.optString("coverinfo");
            String optString = jSONObject.optString("cover_jumpaction");
            if (!Util.isNullOrNil(optString)) {
                Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "cover_jumpaction: %s", optString);
                try {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    l lVar = new l();
                    lVar.pTt = jSONObject2.optBoolean("is_show");
                    lVar.dQx = jSONObject2.optString("wording");
                    lVar.qGB = jSONObject2.optString("icon_url");
                    lVar.yUL = jSONObject2.optString("action_app_username");
                    lVar.pTI = jSONObject2.optInt(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, 0);
                    lVar.yUK = jSONObject2.optString("action_url");
                    oVar.yUZ = lVar;
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyGetConfig", e2, "", new Object[0]);
                }
            }
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "foreignFaqUrl: %s, foreignHongBaoName: %s, enableExclusiveHb: %s", oVar.yUU, oVar.yUV, Boolean.valueOf(oVar.yUY));
            a.eex();
            p eey = a.eey();
            eey.yPZ = oVar;
            eey.efd();
            Log.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + eey.yPZ.yPy + " maxTotalNum:" + eey.yPZ.yPv + " perGroupMaxValue:" + eey.yPZ.yPz + " perMinValue:" + eey.yPZ.yPx + " perPersonMaxValue:" + eey.yPZ.yPw);
            try {
                String str2 = new String(eey.yPZ.toByteArray(), KindaConfigCacheStg.SAVE_CHARSET);
                g.aAi();
                g.aAh().azQ().set(356355, str2);
                g.aAi();
                g.aAh().azQ().gBI();
            } catch (UnsupportedEncodingException e3) {
                Log.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e3.getLocalizedMessage());
            } catch (IOException e4) {
                Log.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e4.getLocalizedMessage());
            }
            this.yXo = ac.ba(jSONObject.optJSONObject("operationHeader"));
            this.yVs = ac.ba(jSONObject.optJSONObject("operationTail"));
            this.yXp = ac.ba(jSONObject.optJSONObject("operationNext"));
            this.yXq = ac.ba(jSONObject.optJSONObject("operationMiddle"));
            int optInt = jSONObject.optInt("sceneSwitch");
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_NEWYEAR_SWITCH_INT_SYNC, Integer.valueOf(optInt));
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "sceneSwitch:".concat(String.valueOf(optInt)));
            this.yXr = jSONObject.optInt("scenePicSwitch");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "scenePicSwitch:" + this.yXr);
            this.yXt = jSONObject.optInt("enableYearHbExpression");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableYearHbExpression:%s", Integer.valueOf(this.yXt));
            this.yXs = jSONObject.optInt("enableSelfie");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableSelfIe:" + this.yXs);
            this.yXu = jSONObject.optInt("enableNormalSelfie");
            this.yXv = jSONObject.optInt("enableNormalAllExpression");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableNormalSelfie:%s enableNormalAllExpression:%s", Integer.valueOf(this.yXu), Integer.valueOf(this.yXv));
            int optInt2 = jSONObject.optInt("enableWeishiHb");
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_WEISHI_SWITCH_INT_SYNC, Integer.valueOf(optInt2));
            int optInt3 = jSONObject.optInt("enableLiveHb");
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_LIVE_SWITCH_INT_SYNC, Integer.valueOf(optInt3));
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "weishiHbSwitch: %s, liveHbSwitch: %s", Integer.valueOf(optInt2), Integer.valueOf(optInt3));
            this.yPK = jSONObject.optString("wishing");
            Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "wishing: %s", this.yPK);
            JSONArray optJSONArray = jSONObject.optJSONArray("yearMess");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson is empty!");
            } else {
                Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson length:" + optJSONArray.length());
                this.yXw = new LinkedList<>();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    ab abVar = new ab();
                    abVar.yWB = optJSONObject.optInt("yearAmount", 0);
                    abVar.yWC = optJSONObject.optString("yearWish");
                    this.yXw.add(abVar);
                }
            }
            efk();
            AppMethodBeat.o(65290);
            return;
        }
        Log.e("MicroMsg.NetSceneLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + i2 + ", errMsg:" + str);
        AppMethodBeat.o(65290);
    }

    public final void efk() {
        AppMethodBeat.i(213320);
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_HONGBAO_LOCAL_SWITCH_INT, (Object) 0)).intValue();
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_hongbao_emoji_all_switch, 0);
        if (Util.isEqual(intValue, 1) || Util.isEqual(a2, 1)) {
            this.yXu = 1;
            this.yXv = 1;
            this.yXs = 1;
            this.yXt = 1;
        }
        Log.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "localSwitch() enableNormalSelfie:%s enableNormalAllExpression:%s enableSelfie:%s enableYearHbExpression:%s", Integer.valueOf(this.yXu), Integer.valueOf(this.yXv), Integer.valueOf(this.yXs), Integer.valueOf(this.yXt));
        AppMethodBeat.o(213320);
    }
}
