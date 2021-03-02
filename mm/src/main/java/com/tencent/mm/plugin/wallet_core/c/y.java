package com.tencent.mm.plugin.wallet_core.c;

import android.text.TextUtils;
import android.util.SparseArray;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class y extends m {
    public List<ElementQuery> HQe;
    public ElementQuery HQf;
    private int HQg;
    private int HQh;
    private int HQi;
    public int HQj;
    public String[] HQk;
    public ArrayList<a> HQl;
    public String mBankType;
    public Profession[] mProfessions;
    public String mTimeStamp;
    public String pQH;

    public y(String str, String str2, PayInfo payInfo) {
        this(str, str2, payInfo, null, -1, -1, 0, (byte) 0);
    }

    public y(String str, String str2, PayInfo payInfo, int i2, int i3) {
        this(str, str2, payInfo, null, -1, i2, i3, (byte) 0);
    }

    public y(String str, String str2, PayInfo payInfo, String str3, int i2, int i3, int i4) {
        this(str, str2, payInfo, str3, i2, i3, i4, (byte) 0);
    }

    public y() {
        this(null, null, null, null, -1, -1, 0, (byte) 0);
    }

    private y(String str, String str2, PayInfo payInfo, String str3, int i2, int i3, int i4, byte b2) {
        AppMethodBeat.i(69943);
        this.HQe = null;
        this.HQf = null;
        this.mTimeStamp = null;
        this.pQH = null;
        this.mBankType = null;
        this.HQg = 3;
        this.mProfessions = null;
        this.HQk = null;
        this.pQH = str2;
        this.HQg = 3;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        setPayInfo(payInfo, hashMap, hashMap2);
        hashMap.put("req_key", str);
        hashMap.put("flag", "4");
        hashMap.put("card_id", str2);
        if (i3 > 0) {
            hashMap.put("realname_scene", String.valueOf(i3));
            Log.i(m.TAG, "realname_scene=%d", Integer.valueOf(i3));
        }
        if (i2 == 8) {
            hashMap.put("scene", "1003");
        }
        hashMap.put("bank_card_tag", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        hashMap.put("token", str3);
        hashMap.put("newrealname", String.valueOf(i4));
        setRequestData(hashMap);
        if (z.hhq()) {
            hashMap2.put("uuid_for_bindcard", z.getBindCardUuid());
            hashMap2.put("bindcard_scene", new StringBuilder().append(z.hhr()).toString());
        }
        setWXRequestData(hashMap2);
        AppMethodBeat.o(69943);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 73;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        String str2;
        AppMethodBeat.i(69944);
        this.HQe = new ArrayList();
        try {
            this.mTimeStamp = jSONObject.optString("time_stamp");
            String optString = jSONObject.optString("bank_type");
            if (!Util.isNullOrNil(this.mBankType)) {
                str2 = this.mBankType;
            } else {
                str2 = optString;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("Array");
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                ElementQuery elementQuery = new ElementQuery();
                elementQuery.dhz = jSONObject2;
                elementQuery.ynT = jSONObject2.optString("bank_name");
                elementQuery.dDj = jSONObject2.optString("bank_type");
                elementQuery.HXm = jSONObject2.optString("bankacc_type_name");
                elementQuery.HXo = jSONObject2.optString("bank_phone");
                elementQuery.HXr = jSONObject2.optString("forbid_word");
                elementQuery.HXq = jSONObject2.optString("bank_recommend_desc");
                elementQuery.HXp = jSONObject2.optString("bank_app_user_name");
                elementQuery.HXl = jSONObject2.optInt("bankacc_type", 1);
                elementQuery.HXd = f.q(jSONObject2, "canModifyName");
                elementQuery.HXe = f.q(jSONObject2, "canModifyCreID");
                elementQuery.HXj = AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(jSONObject2.optString("is_sure"));
                elementQuery.HXf = "1".equals(jSONObject2.optString("needCVV"));
                elementQuery.HXg = "1".equals(jSONObject2.optString("needValiDate"));
                elementQuery.HXc = jSONObject2.optString("time_stamp");
                elementQuery.HXi = jSONObject2.optString("uesr_name");
                elementQuery.HXn = jSONObject2.optString("bank_flag");
                elementQuery.HXs = f.q(jSONObject2, "needFirstName");
                elementQuery.HXt = f.q(jSONObject2, "needLastName");
                elementQuery.HXu = f.q(jSONObject2, "needCountry");
                elementQuery.HXv = f.q(jSONObject2, "needArea");
                elementQuery.HXw = f.q(jSONObject2, "needCity");
                elementQuery.HXx = f.q(jSONObject2, "needAddress");
                elementQuery.HXy = f.q(jSONObject2, "needZip");
                elementQuery.HXz = f.q(jSONObject2, "needPhone");
                elementQuery.HXA = f.q(jSONObject2, "needEmail");
                elementQuery.HXD = f.q(jSONObject2, "needShowProtocol");
                elementQuery.HXB = jSONObject2.optString("support_cre_type");
                elementQuery.HXh = jSONObject2.optString("cre_id");
                elementQuery.HQg = jSONObject2.optInt("bank_card_tag", 1);
                if (elementQuery.HQg == 1) {
                    if (!f.q(jSONObject2, "IsSaveYfq")) {
                        elementQuery.HXk = 0;
                    } else if (f.q(jSONObject2, "canReturnYfq")) {
                        elementQuery.HXk = 4;
                    } else {
                        elementQuery.HXk = 3;
                    }
                } else if (jSONObject2.optInt("auth_mode") == 1) {
                    elementQuery.HXk = 1;
                } else {
                    elementQuery.HXk = 2;
                }
                String optString2 = jSONObject2.optString("support_micropay");
                if (TextUtils.isEmpty(optString2)) {
                    elementQuery.HXH = true;
                } else if ("1".equals(optString2)) {
                    elementQuery.HXH = true;
                } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(optString2)) {
                    elementQuery.HXH = false;
                }
                elementQuery.HUU = jSONObject2.optString("arrive_type");
                elementQuery.HXE = jSONObject2.optString("pre_auth_word");
                elementQuery.HXF = jSONObject2.optInt("support_foreign_mobile", 0);
                elementQuery.HXG = ElementQuery.bG(jSONObject2);
                if (Bankcard.jT(this.HQg, elementQuery.HQg)) {
                    this.HQe.add(elementQuery);
                }
                if (str2 != null && str2.equals(elementQuery.dDj)) {
                    this.HQf = elementQuery;
                }
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            JSONArray jSONArray2 = jSONObject.getJSONArray("cre_type_map");
            int length2 = jSONArray2.length();
            for (int i4 = 0; i4 < length2; i4++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i4);
                int optInt = jSONObject3.optInt("key", 0);
                if (optInt > 0) {
                    sparseArray.put(optInt, jSONObject3.getString("val"));
                }
            }
            this.HQh = jSONObject.optInt("need_area");
            this.HQi = jSONObject.optInt("need_profession");
            if (!(this.HQf == null || this.HQf.HQg == 1)) {
                Log.i(m.TAG, "oversea card, no need area and profession");
                this.HQh = 0;
                this.HQi = 0;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("profession_array");
            if (optJSONArray != null) {
                this.mProfessions = new Profession[optJSONArray.length()];
                for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                    if (optJSONObject != null) {
                        String optString3 = optJSONObject.optString("profession_name");
                        int optInt2 = optJSONObject.optInt("profession_type");
                        if (!Util.isNullOrNil(optString3)) {
                            this.mProfessions[i5] = new Profession(optString3, optInt2);
                        } else {
                            Log.i(m.TAG, "empty profession_name!");
                        }
                    }
                }
            }
            this.HQj = jSONObject.optInt("need_nationality", 0);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("nationality_exclude_array");
            if (optJSONArray2 != null) {
                this.HQk = new String[optJSONArray2.length()];
                for (int i6 = 0; i6 < optJSONArray2.length(); i6++) {
                    this.HQk[i6] = optJSONArray2.optString(i6);
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("bank_card_info");
            if (optJSONArray3 != null) {
                this.HQl = new ArrayList<>();
                for (int i7 = 0; i7 < optJSONArray3.length(); i7++) {
                    JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i7);
                    if (optJSONObject2 != null) {
                        a aVar = new a();
                        aVar.dDj = optJSONObject2.optString("bank_type");
                        aVar.HTB = optJSONObject2.optString("mobile_hint");
                        aVar.HTC = optJSONObject2.optString("mobile_tips");
                        this.HQl.add(aVar);
                    }
                }
            }
            x fQQ = t.fQQ();
            List<ElementQuery> list = this.HQe;
            ArrayList<a> arrayList = this.HQl;
            fQQ.Ibf = sparseArray;
            fQQ.HQe = list;
            fQQ.Ibg = arrayList;
            AppMethodBeat.o(69944);
        } catch (JSONException e2) {
            Log.printErrStackTrace(m.TAG, e2, "", new Object[0]);
            AppMethodBeat.o(69944);
        }
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1505;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/elementquerynew";
    }

    public final boolean fPS() {
        return this.HQh == 1;
    }

    public final boolean fPT() {
        return this.HQi == 1;
    }
}
