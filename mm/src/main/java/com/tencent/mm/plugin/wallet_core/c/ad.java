package com.tencent.mm.plugin.wallet_core.c;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ad extends m {
    public Map<String, String> AJV;
    public Map<String, String> HFF;
    public h HQo;
    public q HQp;
    public r HQq;
    public boolean HQr;
    public String egd;
    public String ege;
    public String egf;
    public String egg;
    public String egh;
    public String egi;
    public int egj;
    public String egk;
    public String egm;
    public String egn;
    public String ego;
    public LinkedList<String> egp;
    public ECardInfo egq;
    public int scene;
    public String subtitle;
    public String title;

    public ad() {
        this(null, 0);
    }

    public ad(String str, int i2) {
        AppMethodBeat.i(69952);
        this.egi = "";
        this.egj = 0;
        this.egk = "";
        this.egm = "";
        this.egn = "";
        this.ego = "";
        this.subtitle = "";
        this.title = "";
        this.egp = new LinkedList<>();
        this.scene = 0;
        this.HQr = false;
        Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "NetSceneTenpayQueryBoundBankcard scene:%s", Integer.valueOf(i2));
        this.AJV = new HashMap();
        this.scene = i2;
        this.AJV.put("req_key", str);
        this.AJV.put("bind_query_scene", String.valueOf(i2));
        a aVar = (a) g.af(a.class);
        this.AJV.put("is_root", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (aVar != null) {
            this.AJV.put("is_device_open_touch", "1");
            Map<String, String> dJY = aVar.dJY();
            if (dJY != null) {
                this.AJV.putAll(dJY);
            }
            Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is true");
        } else {
            this.AJV.put("is_device_open_touch", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is false");
        }
        setRequestData(this.AJV);
        this.HFF = new HashMap();
        g.aAi();
        g.aAi();
        this.HFF.put("bind_serial", (String) g.aAh().azQ().get(196612, (Object) null));
        this.HFF.put("last_bind_serial", (String) g.aAh().azQ().get(196613, (Object) null));
        setWXRequestData(this.HFF);
        AppMethodBeat.o(69952);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getTenpayCgicmd() {
        return 72;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        h hVar;
        JSONArray optJSONArray;
        q qVar = null;
        AppMethodBeat.i(69953);
        if (i2 != 0) {
            AppMethodBeat.o(69953);
            return;
        }
        if (jSONObject.has("real_name_info")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
            ECardInfo.bF(optJSONObject);
            Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "get real_name_info %s", optJSONObject.toString());
            this.egd = optJSONObject.optString("guide_flag");
            this.ege = optJSONObject.optString("guide_wording");
            this.egf = optJSONObject.optString("left_button_wording");
            this.egg = optJSONObject.optString("right_button_wording");
            this.egh = optJSONObject.optString("upload_credit_url");
            this.egi = optJSONObject.optString("done_button_wording");
            this.egj = optJSONObject.optInt("is_show_protocol", 0);
            this.egk = optJSONObject.optString("left_protocol_wording");
            this.egm = optJSONObject.optString("new_upload_credit_url");
            this.egn = optJSONObject.optString("protocol_url");
            this.ego = optJSONObject.optString("right_protocol_wording");
            this.subtitle = optJSONObject.optString(MessengerShareContentUtility.SUBTITLE);
            this.title = optJSONObject.optString("title");
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("upload_reasons");
            this.egp.clear();
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    this.egp.add(optJSONArray2.optString(i3));
                }
            }
            if (optJSONObject.has("ecard_info")) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("ecard_info");
                this.egq = new ECardInfo();
                this.egq.title = this.title;
                this.egq.HWW = new ArrayList<>(this.egp);
                this.egq.HWY = this.egn;
                this.egq.HWZ = this.egk;
                this.egq.HXa = this.ego;
                this.egq.HWX = this.egi;
                this.egq.pmM = optJSONObject2.optInt("ecard_open_scene", 0);
                this.egq.dGp = optJSONObject2.optString("ecard_type", "");
                this.egq.HWQ = optJSONObject2.optInt("show_check_box", 0);
                this.egq.HWR = optJSONObject2.optInt("check_box_selected", 0);
                this.egq.HWS = optJSONObject2.optString("check_box_left_wording", "");
                this.egq.HWT = optJSONObject2.optString("check_box_right_wording", "");
                this.egq.HWU = optJSONObject2.optString("check_box_url", "");
                this.egq.HWV = optJSONObject2.optInt("is_upload_credid", 0);
                this.egq.egh = optJSONObject2.optString("upload_credit_url", "");
            }
        } else {
            ECardInfo.bF(null);
        }
        if (jSONObject.has("paymenu_array") && this.scene == 1 && (optJSONArray = jSONObject.optJSONArray("paymenu_array")) != null) {
            ac.aev(optJSONArray.toString());
        }
        long optLong = jSONObject.optLong("time_stamp");
        if (optLong > 0) {
            y.setTimeStamp(String.valueOf(optLong));
        } else {
            Log.w("MicroMsg.NetSceneTenpayQueryBindBankcard", "no time_stamp in bindquerynew.");
        }
        ai.a(jSONObject, this.scene, true, this.HQr);
        if (ai.aeL(this.scene) || this.scene == 1) {
            JSONObject optJSONObject3 = jSONObject.optJSONObject("bind_card_menu");
            if (optJSONObject3 != null) {
                Log.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "bind card menu: %s", optJSONObject3.toString());
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_BIND_CARD_MENU_STRING_SYNC, optJSONObject3.toString());
            } else {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_BIND_CARD_MENU_STRING_SYNC, "");
            }
        }
        a aVar = (a) g.af(a.class);
        if (aVar != null) {
            Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is not null");
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
            Log.e("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is null");
        }
        if (this.scene == 10) {
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_entry");
            if (optJSONObject4 == null) {
                hVar = null;
            } else {
                hVar = new h();
                hVar.id = optJSONObject4.optString("id");
                hVar.dQx = optJSONObject4.optString("wording");
                hVar.ixw = optJSONObject4.optString("color");
                hVar.type = optJSONObject4.optInt("type");
                hVar.HWM = optJSONObject4.optString("native_url");
                hVar.qHg = optJSONObject4.optString(MessengerShareContentUtility.BUTTON_URL_TYPE);
                hVar.HWN = optJSONObject4.optString("tiny_app_username");
                hVar.HWO = optJSONObject4.optString("tiny_app_path");
                hVar.HuF = optJSONObject4.optInt("entrance_type");
            }
            this.HQo = hVar;
            AppMethodBeat.o(69953);
            return;
        }
        if (this.scene == 8) {
            if (jSONObject.has("block_layer")) {
                JSONObject optJSONObject5 = jSONObject.optJSONObject("block_layer");
                if (optJSONObject5 != null) {
                    qVar = new q();
                    qVar.HYq = optJSONObject5.optInt("view_id");
                    qVar.HYr = optJSONObject5.optInt("is_show_block_layer");
                    qVar.HYs = optJSONObject5.optInt("waiting_time");
                    qVar.HYt = optJSONObject5.optString("main_wording");
                    qVar.HYu = optJSONObject5.optString("reminder_content");
                    qVar.HYw = optJSONObject5.optString("repayment_tiny_app_path");
                    qVar.HYv = optJSONObject5.optString("repayment_tiny_app_username");
                }
                this.HQp = qVar;
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("disable_block_layer");
            if (optJSONObject6 != null) {
                this.HQq = r.bJ(optJSONObject6);
                ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.USERINFO_WALLET_OFFLINE_DISABLE_BLOCK_LAYER_STRING_SYNC, optJSONObject6.toString());
                AppMethodBeat.o(69953);
                return;
            }
            ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.USERINFO_WALLET_OFFLINE_DISABLE_BLOCK_LAYER_STRING_SYNC, "");
        }
        AppMethodBeat.o(69953);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getFuncId() {
        return 1501;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindquerynew";
    }
}
