package com.tencent.mm.plugin.wallet.pwd.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.protocal.protobuf.ehc;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.protocal.protobuf.ehu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m extends com.tencent.mm.wallet_core.tenpay.model.m {
    public int HIp;
    public String HIq;
    public int HIr;
    public String HIs;
    public String HIt;
    public String HIu;

    public m() {
        AppMethodBeat.i(69559);
        HashMap hashMap = new HashMap();
        hashMap.put("deviceid", q.dr(false));
        setRequestData(hashMap);
        AppMethodBeat.o(69559);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69560);
        Log.i("MicroMsg.NetSceneTenpayPayManager", "errCode:" + i2 + ";errMsg:" + str);
        Log.d("MicroMsg.NetSceneTenpayPayManager", "json: %s", jSONObject.toString());
        if (i2 == 0) {
            String optString = jSONObject.optString("is_show_deduct", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            if (!isNumeric(optString)) {
                optString = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            this.HIp = Util.getInt(optString, 0);
            this.HIq = jSONObject.optString("deduct_show_url", "");
            String optString2 = jSONObject.optString("deduct_cache_time", "");
            if (!isNumeric(optString2)) {
                optString2 = "84600";
            }
            this.HIr = Util.getInt(optString2, 0);
            this.HIs = jSONObject.optString("deduct_title", "");
            this.HIt = jSONObject.optString("realname_url", "");
            this.HIu = jSONObject.optString("forget_pwd_url", "");
            String optString3 = jSONObject.optString("payway_select_wording", "");
            String optString4 = jSONObject.optString("payway_change_wording", "");
            ag agVar = new ag();
            agVar.field_is_show = this.HIp;
            agVar.field_pref_key = "wallet_open_auto_pay";
            agVar.field_pref_title = this.HIs;
            agVar.field_pref_url = this.HIq;
            agVar.field_jump_type = 1;
            t.fQH().aVE("wallet_open_auto_pay");
            Log.i("MicroMsg.NetSceneTenpayPayManager", "deductCacheTime %s forget_pwd_url %s", Integer.valueOf(this.HIr), this.HIu);
            t.fQH().insert(agVar);
            JSONObject optJSONObject = jSONObject.optJSONObject("switch_wallet");
            if (optJSONObject != null) {
                ag n = n(optJSONObject, "wallet_switch_currency");
                t.fQH().aVE("wallet_switch_currency");
                t.fQH().insert(n);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("im_mch");
            if (optJSONObject2 != null) {
                ag n2 = n(optJSONObject2, "wallet_im_mch");
                t.fQH().aVE("wallet_im_mch");
                t.fQH().insert(n2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("deduct_manage");
            if (optJSONObject3 != null) {
                ag n3 = n(optJSONObject3, "wallet_open_auto_pay");
                t.fQH().aVE("wallet_open_auto_pay");
                t.fQH().insert(n3);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("extra_sections");
            if (optJSONArray != null) {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_PAY_MANAGE_EXTRA_SECTION_DATA_STRING_SYNC, optJSONArray.toString());
            } else {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_PAY_MANAGE_EXTRA_SECTION_DATA_STRING_SYNC, " ");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("unreg_info");
            if (optJSONObject4 != null) {
                String optString5 = optJSONObject4.optString("unreg_title", "");
                String optString6 = optJSONObject4.optString("unreg_url", "");
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_USERINFO_UNREGTITLE_TYPE_STRING_SYNC, optString5);
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_USERINFO_UNREGURL_TYPE_STRING_SYNC, optString6);
            } else {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_USERINFO_UNREGTITLE_TYPE_STRING_SYNC, "");
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_USERINFO_UNREGURL_TYPE_STRING_SYNC, "");
            }
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_PREF_INFO_CACHE_TIME_LONG_SYNC, Long.valueOf(new Date().getTime() / 1000));
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_PREF_INFO_EXPIRES_INT_SYNC, Integer.valueOf(this.HIr));
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_REALNAME_URL_STRING_SYNC, this.HIt);
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_DEDUCT_FORGET_URL_STRING, this.HIu);
            if (!Util.isNullOrNil(optString3)) {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_DEDUCT_SELECT_WORDING_STRING, optString3);
            }
            if (!Util.isNullOrNil(optString4)) {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_DEDUCT_CHANGE_WORDING_STRING, optString4);
            }
            g.aAi();
            g.aAh().azQ().gBI();
        }
        AppMethodBeat.o(69560);
    }

    private static ag n(JSONObject jSONObject, String str) {
        AppMethodBeat.i(69561);
        ag agVar = new ag();
        agVar.field_is_show = jSONObject.optInt("show_label", 0);
        agVar.field_pref_key = str;
        agVar.field_pref_title = jSONObject.optString("title");
        agVar.field_pref_desc = jSONObject.optString("desc");
        agVar.field_logo_url = jSONObject.optString("logo_url");
        agVar.field_jump_type = jSONObject.optInt("jump_type");
        agVar.field_pref_url = jSONObject.optString("jump_h5_url");
        agVar.field_tinyapp_username = jSONObject.optString("tinyapp_username");
        agVar.field_tinyapp_path = jSONObject.optString("tinyapp_path");
        AppMethodBeat.o(69561);
        return agVar;
    }

    private static boolean isNumeric(String str) {
        char charAt;
        AppMethodBeat.i(69562);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(69562);
            return false;
        }
        int length = str.length();
        do {
            length--;
            if (length >= 0) {
                charAt = str.charAt(length);
                if (charAt < '0') {
                    break;
                }
            } else {
                AppMethodBeat.o(69562);
                return true;
            }
        } while (charAt <= '9');
        AppMethodBeat.o(69562);
        return false;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1654;
    }

    @Override // com.tencent.mm.wallet_core.c.s, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getPayCgicmd() {
        return 100000;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/paymanage";
    }

    public static class a {
        public LinkedList<ag> HIv = new LinkedList<>();
        public ehf HIw;
        public ehf HIx;

        public a() {
            AppMethodBeat.i(214059);
            AppMethodBeat.o(214059);
        }

        public static a bt(JSONObject jSONObject) {
            AppMethodBeat.i(214060);
            a aVar = new a();
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("extra_labels");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        LinkedList<ag> linkedList = aVar.HIv;
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        ag agVar = new ag();
                        if (jSONObject2 != null) {
                            agVar.field_is_show = jSONObject2.optInt("show_label", 0);
                            agVar.field_pref_title = jSONObject2.optString("title");
                            agVar.field_pref_key = agVar.field_pref_title;
                            agVar.field_pref_desc = jSONObject2.optString("desc");
                            agVar.field_logo_url = jSONObject2.optString("logo_url");
                            agVar.field_jump_type = jSONObject2.optInt("jump_type");
                            agVar.field_pref_url = jSONObject2.optString("jump_h5_url");
                            agVar.field_tinyapp_username = jSONObject2.optString("tinyapp_username");
                            agVar.field_tinyapp_path = jSONObject2.optString("tinyapp_path");
                            t.fQH().aVE(agVar.field_pref_key);
                            t.fQH().insert(agVar);
                        }
                        linkedList.add(agVar);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
                if (optJSONObject != null) {
                    aVar.HIw = bu(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("footer");
                if (optJSONObject2 != null) {
                    aVar.HIx = bu(optJSONObject2);
                }
            } catch (JSONException e2) {
                Log.e("MicroMsg.NetSceneTenpayPayManager", " PayManageExtraSectionsData dcreateFromJSONObject Exception:%s", e2.getMessage());
            }
            AppMethodBeat.o(214060);
            return aVar;
        }

        private static ehf bu(JSONObject jSONObject) {
            AppMethodBeat.i(214061);
            ehf ehf = new ehf();
            if (jSONObject != null) {
                ehf.KNW = jSONObject.optString("view_id");
                JSONArray optJSONArray = jSONObject.optJSONArray("text");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        try {
                            LinkedList<ehc> linkedList = ehf.NgT;
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                            ehc ehc = new ehc();
                            if (jSONObject2 != null) {
                                ehc.NgL = jSONObject2.optLong("color");
                                ehc.CeI = jSONObject2.optString("font");
                                ehc.text = jSONObject2.optString("text");
                                ehc.size = (float) jSONObject2.optLong("size");
                                ehc.NgM = jSONObject2.optInt("text_attr");
                                ehc.KNW = jSONObject2.optString("view_id");
                                dqe dqe = new dqe();
                                JSONObject optJSONObject = jSONObject2.optJSONObject("route_info");
                                if (optJSONObject != null) {
                                    dqe.type = optJSONObject.optInt("type");
                                    dqe.url = optJSONObject.optString("url");
                                    ehu ehu = new ehu();
                                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("tiny_app_uri");
                                    if (optJSONObject2 != null) {
                                        ehu.username = optJSONObject2.optString(ch.COL_USERNAME);
                                        ehu.path = optJSONObject2.optString("path");
                                        ehu.version = optJSONObject2.optInt("version");
                                        dqe.MTh = ehu;
                                    }
                                }
                                ehc.KEP = dqe;
                                aib aib = new aib();
                                JSONObject optJSONObject3 = jSONObject2.optJSONObject("dynamic_color");
                                if (optJSONObject3 != null) {
                                    aib.LrI = optJSONObject3.optLong("normal_color");
                                    aib.LrJ = optJSONObject3.optLong("dark_mode_color");
                                    ehc.NgN = aib;
                                }
                            }
                            linkedList.add(ehc);
                        } catch (JSONException e2) {
                            Log.e("MicroMsg.NetSceneTenpayPayManager", "parseTextViewData Exception:%s", e2.getMessage());
                        }
                    }
                }
            }
            AppMethodBeat.o(214061);
            return ehf;
        }
    }
}
