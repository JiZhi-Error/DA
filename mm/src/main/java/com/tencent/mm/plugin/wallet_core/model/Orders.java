package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.codeless.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.m;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.protocal.protobuf.aoa;
import com.tencent.mm.protocal.protobuf.egf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import e.a.a.e;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Orders implements Parcelable {
    public static final Parcelable.Creator<Orders> CREATOR = new Parcelable.Creator<Orders>() {
        /* class com.tencent.mm.plugin.wallet_core.model.Orders.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Orders[] newArray(int i2) {
            return new Orders[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Orders createFromParcel(Parcel parcel) {
            AppMethodBeat.i(70312);
            Orders orders = new Orders(parcel);
            AppMethodBeat.o(70312);
            return orders;
        }
    };
    public static int HZC = 0;
    public static int HZD = 1;
    public String AAU;
    public String AOl;
    public double CoZ;
    public int HQg;
    public String HTZ;
    public String HXh;
    public long HYL;
    public double HYM = 0.0d;
    public int HYN;
    public int HYO;
    public String HYP;
    public String HYQ;
    public String HYR;
    public String HYS;
    public int HYT;
    public boolean HYU = false;
    public String HYV = "";
    public long HYW = 0;
    public String HYX = "";
    public String HYY;
    public Set<String> HYZ = new HashSet();
    public int HZA;
    public SimpleCashierInfo HZB;
    public int HZa = 0;
    public boolean HZb;
    public String HZc = "";
    public List<Commodity> HZd = new ArrayList();
    public h HZe = new h();
    public int HZf = 0;
    public String HZg = "";
    public String HZh = "";
    public DeductInfo HZi;
    public long HZj;
    public long HZk;
    public int HZl = 0;
    public int HZm = 0;
    public int HZn = 0;
    public String HZo = "";
    public int HZp = 0;
    public int HZq = 0;
    public ArrayList<ShowInfo> HZr = new ArrayList<>();
    public String HZs = "";
    public String HZt = "";
    public String HZu = "";
    public String HZv;
    public String HZw;
    public String HZx = "";
    public String HZy;
    public String HZz;
    public String dDL = "";
    public double dDO = 0.0d;
    public ArrayList<egf> field_infos = new ArrayList<>();
    public String nickname;
    public String num = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    public String rCq = "";
    public String token = "";
    public String username;
    public String wFE;

    public static class a {
        public String text = "";
        public String url = "";
    }

    public Orders() {
        AppMethodBeat.i(70352);
        AppMethodBeat.o(70352);
    }

    public static Orders by(JSONObject jSONObject) {
        JSONObject optJSONObject;
        AppMethodBeat.i(70353);
        Orders orders = null;
        if (jSONObject != null) {
            Orders orders2 = new Orders();
            try {
                orders2.HYL = Util.nowMilliSecond();
                orders2.dDO = f.a(jSONObject.optString("total_fee"), "100", 2, RoundingMode.HALF_UP);
                orders2.num = jSONObject.getString("num");
                orders2.HQg = jSONObject.optInt("bank_card_tag", 1);
                orders2.AOl = jSONObject.optString("fee_type", "");
                orders2.CoZ = f.a(jSONObject.optString("charge_fee"), "100", 2, RoundingMode.HALF_UP);
                orders2.HYM = f.a(jSONObject.optString("fetch_fee"), "100", 2, RoundingMode.HALF_UP);
                orders2.HYN = jSONObject.optInt("is_assign_userinfo_pay");
                orders2.HTZ = jSONObject.optString("true_name");
                orders2.HXh = jSONObject.optString("cre_id");
                orders2.HYO = jSONObject.optInt("ce_type");
                orders2.HYP = jSONObject.optString("assign_pay_info");
                JSONArray jSONArray = jSONObject.getJSONArray("Array");
                orders2.HZj = jSONObject.optLong("free_fee");
                orders2.HZk = jSONObject.optLong("remain_fee");
                orders2.HZl = jSONObject.optInt("not_support_bind_card", 0);
                orders2.HZm = jSONObject.optInt("not_support_retry", 0);
                boolean z = jSONObject.optInt("support_all_bank", 0) == 1;
                if (z) {
                    orders2.HYZ = new HashSet();
                }
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    Commodity commodity = new Commodity();
                    commodity.desc = jSONObject2.getString("desc");
                    commodity.qwJ = f.a(jSONObject2.optString("fee"), "100", 2, RoundingMode.HALF_UP);
                    commodity.AOc = new StringBuilder().append(jSONObject2.optInt("count", 1)).toString();
                    commodity.AOe = jSONObject2.getString("pay_status");
                    commodity.AOj = jSONObject2.optString("buy_bank_name");
                    commodity.AOf = jSONObject2.getString("pay_status_name");
                    commodity.ANZ = jSONObject2.optString("spid");
                    commodity.AOa = jSONObject2.optString("sp_name");
                    commodity.AOh = jSONObject2.optInt("modify_timestamp");
                    commodity.dDM = jSONObject2.getString(FirebaseAnalytics.b.TRANSACTION_ID);
                    commodity.AOl = jSONObject2.optString("fee_type");
                    if (Util.isNullOrNil(orders2.AOl)) {
                        orders2.AOl = commodity.AOl;
                    }
                    commodity.dCu = jSONObject2.optString("appusername");
                    commodity.ANP = jSONObject2.optString("app_telephone");
                    orders2.HZd.add(commodity);
                    if (!z) {
                        orders2.HYY = jSONObject2.optString("support_bank");
                        orders2.HYZ = aVg(orders2.HYY);
                    }
                }
                if (jSONObject.has("is_open_fee_protocal")) {
                    orders2.HYU = f.q(jSONObject, "is_open_fee_protocal");
                } else {
                    orders2.HYU = Bankcard.jT(orders2.HQg, 2);
                }
                orders2.HZe = bL(jSONObject);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("bindqueryresp");
                if (optJSONObject2 == null) {
                    Log.e("MicroMsg.Orders", "bindqueryresp is null ");
                } else {
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("user_info");
                    if (optJSONObject3 == null) {
                        Log.e("MicroMsg.Orders", "user_info is null ");
                    } else {
                        JSONObject optJSONObject4 = optJSONObject3.optJSONObject("touch_info");
                        if (optJSONObject4 == null) {
                            Log.e("MicroMsg.Orders", "touch_info is null ");
                        } else {
                            orders2.HZa = ((i) g.af(i.class)).dKr() || ((i) g.af(i.class)).dKs() ? optJSONObject4.optInt("use_touch_pay", 0) : 0;
                            orders2.HZc = optJSONObject4.optString("touch_forbidword");
                            String optString = optJSONObject4.optString("touch_challenge");
                            boolean z2 = 1 == optJSONObject4.optInt("need_change_auth_key");
                            orders2.wFE = optString;
                            orders2.HZb = z2;
                            p.IML.wFE = optString;
                            p.IML.wFM = z2;
                            Log.i("MicroMsg.Orders", "hy: use_touch_pay is %s, challenge is: %s, is need change: %b", Integer.valueOf(orders2.HZa), optString, Boolean.valueOf(z2));
                        }
                    }
                }
                orders2.HZf = jSONObject.optInt("needbindcardtoshowfavinfo");
                orders2.HZg = jSONObject.optString("discount_wording");
                orders2.HZh = jSONObject.optString("favor_rule_wording");
                a(orders2, jSONObject.optJSONObject("entrustpayinfo"));
                String optString2 = jSONObject.optString("field_area_info");
                if (!Util.isNullOrNil(optString2)) {
                    try {
                        orders2.field_infos.addAll(((aoa) new aoa().parseFrom(Base64.decode(optString2, 0))).field_info);
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.Orders", e2, "", new Object[0]);
                    }
                }
                orders2.HZu = jSONObject.optString("price_total_fee", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                orders2.HZv = jSONObject.optString("price_fee_type", "");
                orders2.HZw = jSONObject.optString("price_fee_symbol", "");
                orders2.HZx = jSONObject.optString("settlement_fee", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                orders2.HZy = jSONObject.optString("settlement_type", "");
                orders2.HZz = jSONObject.optString("settlement_symbol", "");
                orders2.HZA = jSONObject.optInt("is_open_field_area", 0);
                JSONObject optJSONObject5 = jSONObject.optJSONObject("bindqueryresp");
                if (!(optJSONObject5 == null || (optJSONObject = optJSONObject5.optJSONObject("simple_cashier_info")) == null)) {
                    orders2.HZB = new SimpleCashierInfo();
                    orders2.HZB.Iaw = optJSONObject.optInt("use_simple_cashier");
                    orders2.HZB.dDj = optJSONObject.optString("bank_type");
                    orders2.HZB.ANo = optJSONObject.optString("bind_serial");
                }
                orders = orders2;
            } catch (JSONException e3) {
                Log.printErrStackTrace("MicroMsg.Orders", e3, "", new Object[0]);
                orders = orders2;
            }
        }
        AppMethodBeat.o(70353);
        return orders;
    }

    private static h bL(JSONObject jSONObject) {
        AppMethodBeat.i(70354);
        h hVar = new h();
        JSONObject optJSONObject = jSONObject.optJSONObject("favinfo");
        if (optJSONObject == null) {
            Log.d("MicroMsg.Orders", "Parse getJsonObject(favinfo) null");
            AppMethodBeat.o(70354);
            return hVar;
        }
        hVar.HEq = ((double) optJSONObject.optLong("tradeAmount")) / 100.0d;
        hVar.HEr = ((double) optJSONObject.optLong("totalFavAmount")) / 100.0d;
        hVar.HEs = ((double) optJSONObject.optLong("afterFavorTradeAmount")) / 100.0d;
        hVar.HEt = optJSONObject.optString("favorComposeId");
        hVar.HEw = optJSONObject.optInt("useNaturalDefense");
        hVar.HEx = optJSONObject.optString("discountWording");
        hVar.HEy = optJSONObject.optString("favorRuleWording");
        hVar.HEz = optJSONObject.optDouble("showFavorAmount", 0.0d) / 100.0d;
        hVar.HEA = optJSONObject.optDouble("invariableFavorAmount", 0.0d) / 100.0d;
        hVar.HEB = optJSONObject.optInt("isVariableFavor");
        hVar.HEC = optJSONObject.optString("invariableFavorDesc");
        hVar.HED = optJSONObject.optString("variableFavorDesc");
        JSONArray optJSONArray = optJSONObject.optJSONArray("tradeFavList");
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
            t tVar = new t();
            tVar.HFi = jSONObject2.optInt("favType");
            tVar.HFj = jSONObject2.optInt("favSubType");
            tVar.HFk = jSONObject2.optLong("favProperty");
            tVar.HFl = jSONObject2.optString("favorTypeDesc");
            tVar.HEn = jSONObject2.optString("favId");
            tVar.HFm = jSONObject2.optString("favName");
            tVar.HFn = jSONObject2.optString("favDesc");
            tVar.HEo = jSONObject2.optString("favorUseManual");
            tVar.HEp = jSONObject2.optString("favorRemarks");
            tVar.HFo = ((double) jSONObject2.optLong("favPrice")) / 100.0d;
            tVar.HFp = ((double) jSONObject2.optLong("realFavFee")) / 100.0d;
            tVar.HFq = jSONObject2.optInt("needBankPay");
            tVar.HFr = jSONObject2.optString("bankNo");
            tVar.AOj = jSONObject2.optString("bankName");
            tVar.HFs = jSONObject2.optString("bankLogoUrl");
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("bind_serial_list");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    tVar.HFt.add(b.cD(optJSONArray2.optString(i3).getBytes()));
                }
            }
            hVar.HEu.add(tVar);
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("favorComposeList");
        if (optJSONObject2 != null) {
            hVar.HEv = new com.tencent.mm.plugin.wallet.a.i();
            JSONArray optJSONArray3 = optJSONObject2.optJSONArray("favorComposeInfo");
            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                JSONObject jSONObject3 = optJSONArray3.getJSONObject(i4);
                j jVar = new j();
                jVar.HEJ = jSONObject3.optString("faovrComposeId");
                jVar.HEK = ((double) jSONObject3.optLong("totalFavorAmount")) / 100.0d;
                jVar.HEs = ((double) jSONObject3.optLong("afterFavorTradeAmount")) / 100.0d;
                jVar.HEz = jSONObject3.optDouble("showFavorAmount", 0.0d) / 100.0d;
                jVar.HEA = jSONObject3.optDouble("invariableFavorAmount", 0.0d) / 100.0d;
                jVar.HEB = jSONObject3.optInt("isVariableFavor");
                jVar.HEC = jSONObject3.optString("invariableFavorDesc");
                jVar.HED = jSONObject3.optString("variableFavorDesc");
                JSONArray optJSONArray4 = jSONObject3.optJSONArray("composeArray");
                for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                    JSONObject jSONObject4 = optJSONArray4.getJSONObject(i5);
                    com.tencent.mm.plugin.wallet.a.f fVar = new com.tencent.mm.plugin.wallet.a.f();
                    fVar.HEn = jSONObject4.optString("favId");
                    fVar.HEo = jSONObject4.optString("favorUseManual");
                    fVar.HEp = jSONObject4.optString("favorRemarks");
                    jVar.HEL.add(fVar);
                }
                hVar.HEv.HEH.add(jVar);
            }
        }
        com.tencent.mm.plugin.wallet.a.a aVar = new com.tencent.mm.plugin.wallet.a.a();
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("bank_card_info");
        if (optJSONObject3 != null) {
            JSONArray optJSONArray5 = optJSONObject3.optJSONArray("bind_serial_favor_info_list");
            if (optJSONArray5 != null) {
                for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                    c cVar = new c();
                    JSONObject jSONObject5 = optJSONArray5.getJSONObject(i6);
                    cVar.ANo = jSONObject5.optString("bind_serial");
                    JSONArray optJSONArray6 = jSONObject5.optJSONArray("bind_serial_favor_list");
                    if (optJSONArray6 != null && optJSONArray6.length() > 0) {
                        for (int i7 = 0; i7 < optJSONArray6.length(); i7++) {
                            d dVar = new d();
                            JSONObject optJSONObject4 = optJSONArray6.optJSONObject(i7);
                            dVar.Coh = optJSONObject4.optString("favor_desc");
                            dVar.HEl = optJSONObject4.optInt("is_default_show", 0);
                            cVar.HEk.add(dVar);
                        }
                    }
                    aVar.HDZ.add(cVar);
                }
            }
            JSONArray optJSONArray7 = optJSONObject3.optJSONObject("new_bind_card_info").optJSONArray("new_bind_card_favor_list");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                aVar.HEa = new n();
                for (int i8 = 0; i8 < optJSONArray7.length(); i8++) {
                    o oVar = new o();
                    oVar.Coh = optJSONArray7.optJSONObject(i8).optString("favor_desc");
                    aVar.HEa.HEQ.add(oVar);
                }
            }
        }
        hVar.HEE = aVar;
        JSONArray optJSONArray8 = optJSONObject.optJSONArray("favcombid_forbindcard_list");
        if (optJSONArray8 != null) {
            int length = optJSONArray8.length();
            for (int i9 = 0; i9 < length; i9++) {
                JSONObject optJSONObject5 = optJSONArray8.optJSONObject(i9);
                if (optJSONObject5 != null) {
                    com.tencent.mm.plugin.wallet.a.g gVar = new com.tencent.mm.plugin.wallet.a.g();
                    gVar.HEd = optJSONObject5.optString("default_fav_comb_id");
                    JSONObject optJSONObject6 = optJSONObject5.optJSONObject("payment_channel");
                    if (optJSONObject6 != null) {
                        m mVar = new m();
                        mVar.ANo = optJSONObject6.optString("bind_serial");
                        mVar.selected = optJSONObject6.optInt("selected");
                        mVar.HEP = optJSONObject6.optString("bankCode");
                        gVar.HEb = mVar;
                    }
                    hVar.HEF.add(gVar);
                }
            }
        }
        com.tencent.mm.plugin.wallet.a.b bVar = new com.tencent.mm.plugin.wallet.a.b();
        JSONObject optJSONObject7 = optJSONObject.optJSONObject("bank_fav_guide");
        if (optJSONObject7 != null) {
            m mVar2 = new m();
            JSONObject optJSONObject8 = optJSONObject7.optJSONObject("payment_channel");
            if (optJSONObject8 != null) {
                mVar2.HEP = optJSONObject8.optString("bankCode");
                mVar2.selected = optJSONObject8.optInt("selected");
                mVar2.ANo = optJSONObject8.optString("bind_serial");
                bVar.HEb = mVar2;
            }
            bVar.HEc = optJSONObject7.optInt("is_show_guide");
            bVar.HEd = optJSONObject7.optString("default_fav_comb_id");
            bVar.HEe = optJSONObject7.optString("guide_content");
            bVar.HEf = optJSONObject7.optString("guide_content_color");
            bVar.HEg = optJSONObject7.optString("guide_btn_text");
            bVar.HEh = optJSONObject7.optString("guide_btn_text_color");
            bVar.HEi = optJSONObject7.optString("guide_btn_bg_color");
            bVar.HEj = optJSONObject7.optString("guide_logo");
            hVar.HEG = bVar;
        }
        AppMethodBeat.o(70354);
        return hVar;
    }

    public static Orders a(JSONObject jSONObject, Orders orders) {
        AppMethodBeat.i(70355);
        if (jSONObject == null || orders == null) {
            Log.w("MicroMsg.Orders", "oldOrders is null");
        } else {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("appservice");
                if (optJSONObject != null) {
                    orders.HYR = optJSONObject.optString("app_recommend_desc");
                    orders.HYS = optJSONObject.optString("app_telephone");
                    orders.HYT = optJSONObject.optInt("recommend_level", 2);
                    orders.rCq = optJSONObject.optString("share_to_friends_url");
                }
                int i2 = orders.HYT;
                List<Commodity> list = orders.HZd;
                orders.HYV = jSONObject.optString("pay_result_tips");
                JSONArray jSONArray = jSONObject.getJSONArray("payresult");
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    if (list != null && list.size() == 1) {
                        Commodity commodity = list.get(0);
                        commodity.HZN = new ArrayList();
                        commodity.HZH = new ArrayList();
                        commodity.dDM = jSONObject2.getString(FirebaseAnalytics.b.TRANSACTION_ID);
                        a(commodity, jSONObject2, i2);
                    } else if (list != null) {
                        String string = jSONObject2.getString(FirebaseAnalytics.b.TRANSACTION_ID);
                        Iterator<Commodity> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Commodity next = it.next();
                            if (string != null && string.equals(next.dDM)) {
                                a(next, jSONObject2, i2);
                                break;
                            }
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject(Constants.EXTINFO);
                if (optJSONObject2 != null) {
                    orders.HYW = optJSONObject2.optLong("fetch_pre_arrive_time") * 1000;
                    orders.HYX = optJSONObject2.optString("fetch_pre_arrive_time_wording");
                }
                orders.HZn = jSONObject.optInt("is_use_new_paid_succ_page", 0);
                orders.HZo = jSONObject.optString("pay_succ_btn_wording");
                orders.HZq = jSONObject.optInt("is_jsapi_close_page");
                orders.HZs = jSONObject.optString("jsapi_tinyapp_username");
                orders.HZt = jSONObject.optString("jsapi_tinyapp_path");
                b(orders, jSONObject);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.Orders", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(70355);
        return orders;
    }

    private static void a(Commodity commodity, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(70356);
        commodity.AOp = jSONObject.optString("discount");
        commodity.AOe = jSONObject.getString("pay_status");
        commodity.AOf = jSONObject.getString("pay_status_name");
        commodity.AOj = jSONObject.optString("buy_bank_name");
        commodity.AOh = jSONObject.optInt("pay_timestamp");
        commodity.HZG = jSONObject.optString("card_tail");
        commodity.HYT = i2;
        commodity.HZI = jSONObject.optString("rateinfo");
        commodity.HZJ = jSONObject.optString("discount_rateinfo");
        commodity.HZK = jSONObject.optString("original_feeinfo");
        if (jSONObject.has("total_fee")) {
            commodity.qwJ = jSONObject.optDouble("total_fee", 0.0d) / 100.0d;
        }
        commodity.HZE = jSONObject.optDouble("original_total_fee", -1.0d) / 100.0d;
        commodity.AOl = jSONObject.optString("fee_type", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("subscribe_biz_info");
        if (optJSONObject != null) {
            Promotions promotions = new Promotions();
            promotions.type = HZC;
            promotions.name = optJSONObject.optString("nickname");
            promotions.dCu = optJSONObject.optString(ch.COL_USERNAME);
            commodity.HZF = promotions.dCu;
            promotions.Bah = optJSONObject.optString("logo_round_url");
            promotions.url = optJSONObject.optString("subscribe_biz_url");
            if (!Util.isNullOrNil(promotions.name) && !Util.isNullOrNil(promotions.url)) {
                commodity.HZN.add(promotions);
                commodity.HZO = true;
            }
        }
        JSONArray jSONArray = jSONObject.getJSONArray("activity_info");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            Promotions promotions2 = new Promotions();
            promotions2.type = HZD;
            promotions2.Bah = jSONObject2.optString("icon");
            promotions2.name = jSONObject2.optString("wording");
            promotions2.url = jSONObject2.optString("url");
            promotions2.HYF = jSONObject2.optString("btn_text");
            promotions2.trD = jSONObject2.optInt("type");
            promotions2.title = jSONObject2.optString("title");
            promotions2.crw = jSONObject2.optLong("activity_id");
            promotions2.Vgg = jSONObject2.optInt("activity_type", 0);
            promotions2.Vgi = jSONObject2.optString("small_title");
            promotions2.Vgh = jSONObject2.optInt("award_id");
            promotions2.HYC = jSONObject2.optInt("send_record_id");
            promotions2.HYD = jSONObject2.optInt("user_record_id");
            promotions2.Vgj = jSONObject2.optString("activity_tinyapp_username");
            promotions2.Vgk = jSONObject2.optString("activity_tinyapp_path");
            promotions2.HYE = jSONObject2.optLong("activity_mch_id");
            promotions2.Vgl = jSONObject2.optInt("activity_tinyapp_version");
            promotions2.Vgm = jSONObject2.optString("get_award_params");
            promotions2.Vgn = jSONObject2.optString("query_award_status_params");
            a(promotions2, jSONObject2.optJSONObject("exposure_info"));
            commodity.HZN.add(promotions2);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("link_ativity_info");
        if (optJSONObject2 != null) {
            commodity.HZP.text = optJSONObject2.optString("text");
            commodity.HZP.url = optJSONObject2.optString("url");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("discount_array");
        if (optJSONArray != null) {
            int length2 = optJSONArray.length();
            for (int i4 = 0; i4 < length2; i4++) {
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i4);
                DiscountInfo discountInfo = new DiscountInfo();
                if (optJSONObject3 != null) {
                    discountInfo.HZY = optJSONObject3.optDouble("payment_amount");
                    discountInfo.Coh = optJSONObject3.optString("favor_desc");
                    commodity.HZH.add(discountInfo);
                }
            }
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("tinyapp_info");
        if (optJSONObject4 != null) {
            if (commodity.HZL == null) {
                commodity.HZL = new RecommendTinyAppInfo();
            }
            commodity.HZL.HLz = optJSONObject4.optString("tinyapp_name");
            commodity.HZL.HYH = optJSONObject4.optString("tinyapp_logo");
            commodity.HZL.HYI = optJSONObject4.optString("tinyapp_desc");
            commodity.HZL.Hwr = optJSONObject4.optString("tinyapp_username");
            commodity.HZL.Hws = optJSONObject4.optString("tinyapp_path");
            commodity.HZL.HYJ = optJSONObject4.optString("activity_tinyapp_btn_text");
            commodity.HZL.Iai = optJSONObject4.optLong("activity_id");
            commodity.HZL.Iaj = optJSONObject4.optLong("activity_type");
            commodity.HZL.Iak = optJSONObject4.optLong("award_id");
            commodity.HZL.Ial = optJSONObject4.optInt("send_record_id");
            commodity.HZL.Iam = optJSONObject4.optInt("user_record_id");
            commodity.HZL.Ian = optJSONObject4.optLong("activity_mch_id");
            commodity.HZL.HYK = optJSONObject4.optInt("tinyapp_version");
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("remarks_info");
        if (optJSONObject5 != null) {
            if (commodity.HZM == null) {
                commodity.HZM = new RemarksInfo();
            }
            commodity.HZM.Iao = optJSONObject5.optString("remark_title");
            commodity.HZM.Iap = optJSONObject5.optString("remark_desc");
        }
        AppMethodBeat.o(70356);
    }

    public static void a(Promotions promotions, JSONObject jSONObject) {
        AppMethodBeat.i(70357);
        Log.i("MicroMsg.Orders", "parseExposureInfo: %s", jSONObject);
        if (jSONObject == null) {
            promotions.Iah = null;
            AppMethodBeat.o(70357);
            return;
        }
        try {
            e.a.a.c cVar = new e.a.a.c();
            JSONArray optJSONArray = jSONObject.optJSONArray("single_exposure_info_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                cVar.Ltm = new LinkedList<>();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    e.a.a.i iVar = new e.a.a.i();
                    iVar.Bah = jSONObject2.optString("logo");
                    iVar.UbK = jSONObject2.optString("award_name");
                    iVar.UbL = jSONObject2.optString("award_description");
                    iVar.UbM = jSONObject2.optString("background_img");
                    iVar.UbO = jSONObject2.optString("award_description_color");
                    iVar.UbN = jSONObject2.optString("award_name_color");
                    cVar.Ltm.add(iVar);
                }
            }
            cVar.Ubh = jSONObject.optInt("is_query_others", 0);
            cVar.LrG = jSONObject.optString("draw_lottery_params");
            cVar.Ltn = jSONObject.optInt("is_show_btn");
            cVar.Ubl = jSONObject.optString("background_img_whole");
            JSONObject optJSONObject = jSONObject.optJSONObject("btn_info");
            if (optJSONObject != null) {
                cVar.Lto = new e.a.a.a();
                cVar.Lto.UaZ = optJSONObject.optString("btn_words");
                cVar.Lto.Uba = optJSONObject.optString("btn_color");
                cVar.Lto.Ubb = optJSONObject.optInt("btn_op_type");
                cVar.Lto.url = optJSONObject.optString("url");
                cVar.Lto.LXU = optJSONObject.optString("get_lottery_params");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("mini_app_info");
                if (optJSONObject2 != null) {
                    cVar.Lto.Ubc = new e.a.a.g();
                    cVar.Lto.Ubc.MFd = optJSONObject2.optString("activity_tinyapp_username");
                    cVar.Lto.Ubc.MFe = optJSONObject2.optString("activity_tinyapp_path");
                    cVar.Lto.Ubc.MFf = optJSONObject2.optInt("activity_tinyapp_version");
                }
            }
            cVar.Ltl = jSONObject.optString("exposure_info_modify_params");
            cVar.Ubi = jSONObject.optInt("user_opertaion_type");
            cVar.Ubj = jSONObject.optInt("is_show_layer");
            JSONObject optJSONObject3 = jSONObject.optJSONObject("layer_info");
            if (optJSONObject3 != null) {
                cVar.Ubk = new e.a.a.f();
                cVar.Ubk.Uby = optJSONObject3.optString("layer_title");
                cVar.Ubk.Ubz = optJSONObject3.optString("layer_logo");
                cVar.Ubk.UbA = optJSONObject3.optString("layer_type");
                cVar.Ubk.UbB = optJSONObject3.optString("layer_name");
                cVar.Ubk.UbC = optJSONObject3.optString("layer_description");
                cVar.Ubk.UbD = optJSONObject3.optInt("is_show_layer_btn");
                if (!Util.isNullOrNil(optJSONObject3.optString("voice_url"))) {
                    cVar.Ubk.UbF = new b(optJSONObject3.optString("voice_url").getBytes());
                }
                if (!Util.isNullOrNil(optJSONObject3.optString("voice_data"))) {
                    cVar.Ubk.LaX = new b(optJSONObject3.optString("voice_data").getBytes());
                }
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject("layer_btn_info");
                if (optJSONObject4 != null) {
                    cVar.Ubk.UbE = new e();
                    cVar.Ubk.UbE.UaZ = optJSONObject4.optString("btn_words");
                    cVar.Ubk.UbE.Uba = optJSONObject4.optString("btn_color");
                    cVar.Ubk.UbE.Ubb = optJSONObject4.optInt("btn_op_type");
                    cVar.Ubk.UbE.LXU = optJSONObject4.optString("get_lottery_params");
                    cVar.Ubk.UbE.url = optJSONObject4.optString("url");
                    JSONObject optJSONObject5 = optJSONObject4.optJSONObject("mini_app_info");
                    if (optJSONObject5 != null) {
                        cVar.Ubk.UbE.Ubc = new e.a.a.g();
                        cVar.Ubk.UbE.Ubc.MFd = optJSONObject5.optString("activity_tinyapp_username");
                        cVar.Ubk.UbE.Ubc.MFe = optJSONObject5.optString("activity_tinyapp_path");
                        cVar.Ubk.UbE.Ubc.MFf = optJSONObject5.optInt("activity_tinyapp_version");
                    }
                }
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("draw_lottery_info");
            if (optJSONObject6 != null) {
                cVar.Ubm = new e.a.a.b();
                cVar.Ubm.url = optJSONObject6.optString("url");
                cVar.Ubm.Ubd = optJSONObject6.optString("animation_wording");
                cVar.Ubm.Ube = optJSONObject6.optString("animation_wording_color");
                cVar.Ubm.Ubf = optJSONObject6.optString("after_animation_wording");
                cVar.Ubm.Ubg = optJSONObject6.optString("after_animation_wording_color");
                cVar.Ubm.NkQ = optJSONObject6.optInt("op_type");
                JSONObject optJSONObject7 = optJSONObject6.optJSONObject("mini_app_info");
                if (optJSONObject7 != null) {
                    cVar.Ubm.Ubc = new e.a.a.g();
                    cVar.Ubm.Ubc.MFd = optJSONObject7.optString("activity_tinyapp_username");
                    cVar.Ubm.Ubc.MFe = optJSONObject7.optString("activity_tinyapp_path");
                    cVar.Ubm.Ubc.MFf = optJSONObject7.optInt("activity_tinyapp_version");
                }
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("follow_cardbd_mch_info");
            if (optJSONObject8 != null) {
                cVar.Ubn = new e.a.a.d();
                cVar.Ubn.Ubo = optJSONObject8.optInt("is_followed_cardbd_mch", 0);
                cVar.Ubn.Ubq = optJSONObject8.optString("follow_logo", "");
                cVar.Ubn.Ubp = optJSONObject8.optString("follow_tips", "");
                cVar.Ubn.Ubr = optJSONObject8.optString("follow_tips_color", "");
                cVar.Ubn.Ubs = optJSONObject8.optLong("follow_tips_size", 0);
                cVar.Ubn.Ubv = optJSONObject8.optString("follow_logo_after", "");
                cVar.Ubn.Ubx = optJSONObject8.optString("follow_tips_after", "");
                cVar.Ubn.Ubw = optJSONObject8.optString("follow_tips_color_after", "");
                cVar.Ubn.LjW = optJSONObject8.optString("follow_param", "");
                cVar.Ubn.Ubt = optJSONObject8.optInt("is_show_pop_up", 0);
                JSONObject optJSONObject9 = optJSONObject8.optJSONObject("pop_up_window_info");
                if (optJSONObject9 != null) {
                    cVar.Ubn.Ubu = new e.a.a.h();
                    cVar.Ubn.Ubu.UbG = optJSONObject9.optString("pop_up_title");
                    cVar.Ubn.Ubu.UbH = optJSONObject9.optString("pop_up_text");
                    cVar.Ubn.Ubu.UbJ = optJSONObject9.optString("pop_up_button_text");
                    cVar.Ubn.Ubu.UbI = optJSONObject9.optString("pop_up_image_url");
                }
            }
            promotions.Iah = cVar;
            AppMethodBeat.o(70357);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Orders", e2, "parseExposureInfo error: %s", e2.getMessage());
            AppMethodBeat.o(70357);
        }
    }

    private static void a(Orders orders, JSONObject jSONObject) {
        AppMethodBeat.i(70358);
        if (jSONObject != null) {
            Log.i("MicroMsg.Orders", "parseDeductInfo json is not null");
            orders.HZi = new DeductInfo();
            orders.HZi.title = jSONObject.optString("contract_title");
            orders.HZi.desc = jSONObject.optString("contract_desc");
            orders.HZi.HHv = jSONObject.optInt("auto_deduct_flag", 0);
            orders.HZi.HZQ = jSONObject.optString("contract_url");
            orders.HZi.HZS = jSONObject.optInt("is_select_pay_way", 0);
            orders.HZi.HGJ = jSONObject.optInt("deduct_show_type", 0);
            orders.HZi.pTK = jSONObject.optString("button_wording", "");
            orders.HZi.HGK = jSONObject.optString("deduct_rule_wording", "");
            orders.HZi.HZT = jSONObject.optString("open_deduct_wording", "");
            orders.HZi.HZU = jSONObject.optString("open_deduct_wording_color", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("show_info");
            int length = optJSONArray.length();
            if (length > 0) {
                orders.HZi.HZR = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        DeductShowInfo deductShowInfo = new DeductShowInfo();
                        deductShowInfo.name = optJSONObject.optString("name");
                        deductShowInfo.value = optJSONObject.optString("value");
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("value_attr");
                        if (optJSONObject2 != null) {
                            deductShowInfo.gTx = optJSONObject2.optInt("link_type", 0);
                            deductShowInfo.HZV = optJSONObject2.optString("link_weapp");
                            deductShowInfo.HZW = optJSONObject2.optString("link_addr");
                            deductShowInfo.HZX = optJSONObject2.optString("link_url");
                        }
                        orders.HZi.HZR.add(deductShowInfo);
                    } else {
                        Log.e("MicroMsg.Orders", "parseDeductInfo's showInfo get a null value from json,index=".concat(String.valueOf(i2)));
                    }
                }
                AppMethodBeat.o(70358);
                return;
            }
            Log.e("MicroMsg.Orders", "parseDeductInfo's showInfo len is ".concat(String.valueOf(length)));
            AppMethodBeat.o(70358);
            return;
        }
        Log.i("MicroMsg.Orders", "parseDeductInfo json is null");
        AppMethodBeat.o(70358);
    }

    private static void b(Orders orders, JSONObject jSONObject) {
        AppMethodBeat.i(70359);
        if (jSONObject != null) {
            try {
                orders.HZp = jSONObject.optInt("is_use_show_info", 0);
                Log.i("MicroMsg.Orders", "is_use_show_info: %s", Integer.valueOf(orders.HZp));
                JSONArray optJSONArray = jSONObject.optJSONArray("show_info");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    Log.i("MicroMsg.Orders", "showInfo size: %s", Integer.valueOf(optJSONArray.length()));
                    orders.HZr = new ArrayList<>();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            ShowInfo showInfo = new ShowInfo();
                            showInfo.name = optJSONObject.optString("name");
                            showInfo.value = optJSONObject.optString("value");
                            showInfo.xEk = optJSONObject.optString("name_color");
                            showInfo.Iaq = optJSONObject.optString("value_color");
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("value_attr");
                            if (optJSONObject2 != null) {
                                showInfo.Iar = optJSONObject2.optInt("link_type");
                                showInfo.Ias = optJSONObject2.optString("link_weapp");
                                showInfo.Iat = optJSONObject2.optString("link_addr");
                                showInfo.Iau = optJSONObject2.optString("link_url");
                                showInfo.Iav = optJSONObject2.optInt("text_attr");
                            }
                            if (!Util.isNullOrNil(showInfo.name) || !Util.isNullOrNil(showInfo.value)) {
                                orders.HZr.add(showInfo);
                            }
                        }
                    }
                }
                AppMethodBeat.o(70359);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Orders", e2, "parseShowInfo error", new Object[0]);
            }
        }
        AppMethodBeat.o(70359);
    }

    public String toString() {
        AppMethodBeat.i(70360);
        StringBuilder sb = new StringBuilder();
        sb.append("reqKey:").append(this.dDL).append("\n");
        sb.append("token").append(this.token).append("\n");
        sb.append("num").append(this.num).append("\n");
        sb.append("totalFee").append(this.dDO).append("\n");
        String sb2 = sb.toString();
        AppMethodBeat.o(70360);
        return sb2;
    }

    public int describeContents() {
        return 0;
    }

    private static HashSet<String> aVg(String str) {
        AppMethodBeat.i(70361);
        HashSet<String> hashSet = new HashSet<>();
        if (!Util.isNullOrNil(str)) {
            for (String str2 : str.split("\\|")) {
                hashSet.add(str2);
            }
            if (hashSet.size() > 0) {
                hashSet.retainAll(hashSet);
            } else {
                hashSet.clear();
            }
        }
        AppMethodBeat.o(70361);
        return hashSet;
    }

    public Orders(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(70362);
        this.HYL = parcel.readLong();
        this.dDL = parcel.readString();
        this.token = parcel.readString();
        this.num = parcel.readString();
        this.dDO = parcel.readDouble();
        this.HQg = parcel.readInt();
        this.AOl = parcel.readString();
        this.CoZ = parcel.readDouble();
        this.HYM = parcel.readDouble();
        this.HYN = parcel.readInt();
        this.HTZ = parcel.readString();
        this.HXh = parcel.readString();
        this.HYO = parcel.readInt();
        this.HYP = parcel.readString();
        this.username = parcel.readString();
        this.nickname = parcel.readString();
        this.AAU = parcel.readString();
        this.HYQ = parcel.readString();
        this.HYR = parcel.readString();
        this.HYS = parcel.readString();
        this.HYT = parcel.readInt();
        this.HYU = parcel.readInt() == 1;
        this.HYV = parcel.readString();
        this.rCq = parcel.readString();
        this.HYW = parcel.readLong();
        this.HYX = parcel.readString();
        parcel.readTypedList(this.HZd, Commodity.CREATOR);
        this.HYY = parcel.readString();
        this.HYZ = aVg(this.HYY);
        this.HZa = parcel.readInt();
        this.HZc = parcel.readString();
        this.HZi = (DeductInfo) parcel.readParcelable(DeductInfo.class.getClassLoader());
        this.HZl = parcel.readInt();
        this.HZm = parcel.readInt();
        this.HZq = parcel.readInt();
        this.HZt = parcel.readString();
        this.HZs = parcel.readString();
        this.HZp = parcel.readInt();
        parcel.readTypedList(this.HZr, ShowInfo.CREATOR);
        this.HZB = (SimpleCashierInfo) parcel.readParcelable(SimpleCashierInfo.class.getClassLoader());
        this.wFE = parcel.readString();
        this.HZb = parcel.readInt() != 1 ? false : z;
        AppMethodBeat.o(70362);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3 = 1;
        AppMethodBeat.i(70363);
        parcel.writeLong(this.HYL);
        parcel.writeString(this.dDL);
        parcel.writeString(this.token);
        parcel.writeString(this.num);
        parcel.writeDouble(this.dDO);
        parcel.writeInt(this.HQg);
        parcel.writeString(this.AOl);
        parcel.writeDouble(this.CoZ);
        parcel.writeDouble(this.HYM);
        parcel.writeInt(this.HYN);
        parcel.writeString(this.HTZ);
        parcel.writeString(this.HXh);
        parcel.writeInt(this.HYO);
        parcel.writeString(this.HYP);
        parcel.writeString(this.username);
        parcel.writeString(this.nickname);
        parcel.writeString(this.AAU);
        parcel.writeString(this.HYQ);
        parcel.writeString(this.HYR);
        parcel.writeString(this.HYS);
        parcel.writeInt(this.HYT);
        parcel.writeInt(this.HYU ? 1 : 0);
        parcel.writeString(this.HYV);
        parcel.writeString(this.rCq);
        parcel.writeLong(this.HYW);
        parcel.writeString(this.HYX);
        parcel.writeTypedList(this.HZd);
        parcel.writeString(this.HYY);
        parcel.writeInt(this.HZa);
        parcel.writeString(this.HZc);
        parcel.writeParcelable(this.HZi, 1);
        parcel.writeInt(this.HZl);
        parcel.writeInt(this.HZm);
        parcel.writeInt(this.HZq);
        parcel.writeString(this.HZt);
        parcel.writeString(this.HZs);
        parcel.writeInt(this.HZp);
        parcel.writeTypedList(this.HZr);
        parcel.writeParcelable(this.HZB, 1);
        parcel.writeString(this.wFE);
        if (!this.HZb) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        AppMethodBeat.o(70363);
    }

    static {
        AppMethodBeat.i(70364);
        AppMethodBeat.o(70364);
    }

    public static class Promotions implements Parcelable {
        public static final Parcelable.Creator<Promotions> CREATOR = new Parcelable.Creator<Promotions>() {
            /* class com.tencent.mm.plugin.wallet_core.model.Orders.Promotions.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Promotions[] newArray(int i2) {
                return new Promotions[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Promotions createFromParcel(Parcel parcel) {
                AppMethodBeat.i(70331);
                Promotions promotions = new Promotions(parcel);
                AppMethodBeat.o(70331);
                return promotions;
            }
        };
        public String Bah;
        public int HYC;
        public int HYD;
        public long HYE;
        public String HYF;
        public e.a.a.c Iah;
        public int Vgg;
        public int Vgh;
        public String Vgi;
        public String Vgj;
        public String Vgk;
        public int Vgl;
        public String Vgm;
        public String Vgn;
        public long crw;
        public String dCu;
        public String name;
        public String title;
        public int trD;
        public int type;
        public String url;

        public Promotions() {
        }

        public Promotions(Parcel parcel) {
            AppMethodBeat.i(70332);
            this.type = parcel.readInt();
            this.Bah = parcel.readString();
            this.name = parcel.readString();
            this.HYF = parcel.readString();
            this.url = parcel.readString();
            this.dCu = parcel.readString();
            this.title = parcel.readString();
            this.trD = parcel.readInt();
            this.crw = parcel.readLong();
            this.Vgg = parcel.readInt();
            this.Vgh = parcel.readInt();
            this.HYC = parcel.readInt();
            this.HYD = parcel.readInt();
            this.Vgi = parcel.readString();
            this.Vgj = parcel.readString();
            this.Vgk = parcel.readString();
            this.HYE = parcel.readLong();
            this.Vgl = parcel.readInt();
            AppMethodBeat.o(70332);
        }

        static {
            AppMethodBeat.i(70334);
            AppMethodBeat.o(70334);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(70333);
            parcel.writeInt(this.type);
            parcel.writeString(this.Bah);
            parcel.writeString(this.name);
            parcel.writeString(this.HYF);
            parcel.writeString(this.url);
            parcel.writeString(this.dCu);
            parcel.writeString(this.title);
            parcel.writeInt(this.trD);
            parcel.writeLong(this.crw);
            parcel.writeInt(this.Vgg);
            parcel.writeInt(this.Vgh);
            parcel.writeInt(this.HYC);
            parcel.writeInt(this.HYD);
            parcel.writeString(this.Vgi);
            parcel.writeString(this.Vgj);
            parcel.writeString(this.Vgk);
            parcel.writeLong(this.HYE);
            parcel.writeInt(this.Vgl);
            AppMethodBeat.o(70333);
        }
    }

    public static class Commodity implements Parcelable {
        public static final Parcelable.Creator<Commodity> CREATOR = new Parcelable.Creator<Commodity>() {
            /* class com.tencent.mm.plugin.wallet_core.model.Orders.Commodity.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Commodity[] newArray(int i2) {
                return new Commodity[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Commodity createFromParcel(Parcel parcel) {
                AppMethodBeat.i(70313);
                Commodity commodity = new Commodity(parcel);
                AppMethodBeat.o(70313);
                return commodity;
            }
        };
        public String ANP;
        public String ANX;
        public String ANY;
        public String ANZ;
        public String AOa;
        public String AOc;
        public String AOe;
        public String AOf;
        public int AOh;
        public String AOj;
        public String AOl;
        public String AOp;
        public int HYT;
        public double HZE = 0.0d;
        public String HZF;
        public String HZG;
        public List<DiscountInfo> HZH = new ArrayList();
        public String HZI;
        public String HZJ;
        public String HZK;
        public RecommendTinyAppInfo HZL = null;
        public RemarksInfo HZM;
        public List<Promotions> HZN = new ArrayList();
        public boolean HZO = false;
        public a HZP = new a();
        public FinderInfo VfV = null;
        public String dCu;
        public String dDM;
        public String desc;
        public double qwJ = 0.0d;

        public int describeContents() {
            return 0;
        }

        public Commodity() {
            AppMethodBeat.i(70314);
            AppMethodBeat.o(70314);
        }

        public Commodity(Parcel parcel) {
            boolean z;
            AppMethodBeat.i(70315);
            this.ANX = parcel.readString();
            this.ANY = parcel.readString();
            this.ANZ = parcel.readString();
            this.AOa = parcel.readString();
            this.desc = parcel.readString();
            this.AOc = parcel.readString();
            this.qwJ = parcel.readDouble();
            this.AOe = parcel.readString();
            this.AOf = parcel.readString();
            this.AOh = parcel.readInt();
            this.dDM = parcel.readString();
            this.AOj = parcel.readString();
            this.AOl = parcel.readString();
            this.dCu = parcel.readString();
            this.ANP = parcel.readString();
            this.HZG = parcel.readString();
            this.AOp = parcel.readString();
            parcel.readTypedList(this.HZH, DiscountInfo.CREATOR);
            this.HZI = parcel.readString();
            this.HZK = parcel.readString();
            this.HZL = (RecommendTinyAppInfo) parcel.readParcelable(RecommendTinyAppInfo.class.getClassLoader());
            this.VfV = (FinderInfo) parcel.readParcelable(FinderInfo.class.getClassLoader());
            parcel.readTypedList(this.HZN, Promotions.CREATOR);
            this.HZM = (RemarksInfo) parcel.readParcelable(RemarksInfo.class.getClassLoader());
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.HZO = z;
            AppMethodBeat.o(70315);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            byte b2 = 0;
            AppMethodBeat.i(70316);
            parcel.writeString(this.ANX);
            parcel.writeString(this.ANY);
            parcel.writeString(this.ANZ);
            parcel.writeString(this.AOa);
            parcel.writeString(this.desc);
            parcel.writeString(this.AOc);
            parcel.writeDouble(this.qwJ);
            parcel.writeString(this.AOe);
            parcel.writeString(this.AOf);
            parcel.writeInt(this.AOh);
            parcel.writeString(this.dDM);
            parcel.writeString(this.AOj);
            parcel.writeString(this.AOl);
            parcel.writeString(this.dCu);
            parcel.writeString(this.ANP);
            parcel.writeString(this.HZG);
            parcel.writeString(this.AOp);
            parcel.writeTypedList(this.HZH);
            parcel.writeString(this.HZI);
            parcel.writeString(this.HZK);
            parcel.writeParcelable(this.HZL, 0);
            parcel.writeParcelable(this.VfV, 0);
            parcel.writeTypedList(this.HZN);
            parcel.writeParcelable(this.HZM, 0);
            if (this.HZO) {
                b2 = 1;
            }
            parcel.writeByte(b2);
            AppMethodBeat.o(70316);
        }

        static {
            AppMethodBeat.i(70317);
            AppMethodBeat.o(70317);
        }
    }

    public static class DiscountInfo implements Parcelable {
        public static final Parcelable.Creator<DiscountInfo> CREATOR = new Parcelable.Creator<DiscountInfo>() {
            /* class com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ DiscountInfo[] newArray(int i2) {
                return new DiscountInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DiscountInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(70327);
                DiscountInfo discountInfo = new DiscountInfo(parcel);
                AppMethodBeat.o(70327);
                return discountInfo;
            }
        };
        public String Coh;
        public double HZY;

        public DiscountInfo() {
        }

        public DiscountInfo(Parcel parcel) {
            AppMethodBeat.i(70328);
            this.HZY = parcel.readDouble();
            this.Coh = parcel.readString();
            AppMethodBeat.o(70328);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(70329);
            parcel.writeDouble(this.HZY);
            parcel.writeString(this.Coh);
            AppMethodBeat.o(70329);
        }

        static {
            AppMethodBeat.i(70330);
            AppMethodBeat.o(70330);
        }
    }

    public static class DeductInfo implements Parcelable {
        public static final Parcelable.Creator<DeductInfo> CREATOR = new Parcelable.Creator<DeductInfo>() {
            /* class com.tencent.mm.plugin.wallet_core.model.Orders.DeductInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ DeductInfo[] newArray(int i2) {
                return new DeductInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DeductInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(70318);
                DeductInfo deductInfo = new DeductInfo(parcel);
                AppMethodBeat.o(70318);
                return deductInfo;
            }
        };
        public int HGJ;
        public String HGK;
        public int HHv;
        public String HZQ;
        public List<DeductShowInfo> HZR = new ArrayList();
        public int HZS;
        public String HZT;
        public String HZU;
        public String desc;
        public String pTK;
        public String title;

        public DeductInfo() {
            AppMethodBeat.i(70319);
            AppMethodBeat.o(70319);
        }

        public DeductInfo(Parcel parcel) {
            AppMethodBeat.i(70320);
            this.title = parcel.readString();
            this.desc = parcel.readString();
            this.HHv = parcel.readInt();
            this.HZQ = parcel.readString();
            this.HZS = parcel.readInt();
            parcel.readTypedList(this.HZR, DeductShowInfo.CREATOR);
            this.HGJ = parcel.readInt();
            this.pTK = parcel.readString();
            this.HGK = parcel.readString();
            this.HZT = parcel.readString();
            this.HZU = parcel.readString();
            AppMethodBeat.o(70320);
        }

        static {
            AppMethodBeat.i(70322);
            AppMethodBeat.o(70322);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(70321);
            parcel.writeString(this.title);
            parcel.writeString(this.desc);
            parcel.writeInt(this.HHv);
            parcel.writeString(this.HZQ);
            parcel.writeInt(this.HZS);
            parcel.writeTypedList(this.HZR);
            parcel.writeInt(this.HGJ);
            parcel.writeString(this.pTK);
            parcel.writeString(this.HGK);
            parcel.writeString(this.HZT);
            parcel.writeString(this.HZU);
            AppMethodBeat.o(70321);
        }
    }

    public static class DeductShowInfo implements Parcelable {
        public static final Parcelable.Creator<DeductShowInfo> CREATOR = new Parcelable.Creator<DeductShowInfo>() {
            /* class com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ DeductShowInfo[] newArray(int i2) {
                return new DeductShowInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DeductShowInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(70323);
                DeductShowInfo deductShowInfo = new DeductShowInfo(parcel);
                AppMethodBeat.o(70323);
                return deductShowInfo;
            }
        };
        public String HZV;
        public String HZW;
        public String HZX;
        public int gTx;
        public String name;
        public String value;

        public DeductShowInfo() {
        }

        protected DeductShowInfo(Parcel parcel) {
            AppMethodBeat.i(70324);
            this.name = parcel.readString();
            this.value = parcel.readString();
            this.gTx = parcel.readInt();
            this.HZV = parcel.readString();
            this.HZW = parcel.readString();
            this.HZX = parcel.readString();
            AppMethodBeat.o(70324);
        }

        static {
            AppMethodBeat.i(70326);
            AppMethodBeat.o(70326);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(70325);
            parcel.writeString(this.name);
            parcel.writeString(this.value);
            parcel.writeInt(this.gTx);
            parcel.writeString(this.HZV);
            parcel.writeString(this.HZW);
            parcel.writeString(this.HZX);
            AppMethodBeat.o(70325);
        }
    }

    public static class RecommendTinyAppInfo implements Parcelable {
        public static final Parcelable.Creator<RecommendTinyAppInfo> CREATOR = new Parcelable.Creator<RecommendTinyAppInfo>() {
            /* class com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ RecommendTinyAppInfo[] newArray(int i2) {
                return new RecommendTinyAppInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RecommendTinyAppInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(70335);
                RecommendTinyAppInfo recommendTinyAppInfo = new RecommendTinyAppInfo(parcel);
                AppMethodBeat.o(70335);
                return recommendTinyAppInfo;
            }
        };
        public String HLz;
        public String HYH;
        public String HYI;
        public String HYJ;
        public int HYK;
        public String Hwr;
        public String Hws;
        public long Iai;
        public long Iaj;
        public long Iak;
        public int Ial;
        public int Iam;
        public long Ian;

        public RecommendTinyAppInfo() {
        }

        public RecommendTinyAppInfo(Parcel parcel) {
            AppMethodBeat.i(70336);
            this.HLz = parcel.readString();
            this.HYH = parcel.readString();
            this.HYI = parcel.readString();
            this.Hwr = parcel.readString();
            this.Hws = parcel.readString();
            this.HYK = parcel.readInt();
            AppMethodBeat.o(70336);
        }

        static {
            AppMethodBeat.i(70338);
            AppMethodBeat.o(70338);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(70337);
            parcel.writeString(this.HLz);
            parcel.writeString(this.HYH);
            parcel.writeString(this.HYI);
            parcel.writeString(this.Hwr);
            parcel.writeString(this.Hws);
            parcel.writeInt(this.HYK);
            AppMethodBeat.o(70337);
        }
    }

    public static class FinderInfo implements Parcelable {
        public static final Parcelable.Creator<FinderInfo> CREATOR = new Parcelable.Creator<FinderInfo>() {
            /* class com.tencent.mm.plugin.wallet_core.model.Orders.FinderInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ FinderInfo[] newArray(int i2) {
                return new FinderInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FinderInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(258735);
                FinderInfo finderInfo = new FinderInfo(parcel);
                AppMethodBeat.o(258735);
                return finderInfo;
            }
        };
        public String VfW;
        public String VfX;
        public String VfY;
        public String VfZ;
        public String Vga;
        public String Vgb;
        public int Vgc;
        public String Vgd;
        public String Vge;
        public String Vgf;
        public String path;
        public int type;
        public String url;
        public String username;
        public String version;

        public FinderInfo() {
        }

        public FinderInfo(Parcel parcel) {
            AppMethodBeat.i(258736);
            this.type = parcel.readInt();
            this.url = parcel.readString();
            this.username = parcel.readString();
            this.path = parcel.readString();
            this.version = parcel.readString();
            this.VfW = parcel.readString();
            this.VfX = parcel.readString();
            this.VfY = parcel.readString();
            this.VfZ = parcel.readString();
            this.Vga = parcel.readString();
            this.Vgb = parcel.readString();
            this.Vgd = parcel.readString();
            this.Vge = parcel.readString();
            this.Vgf = parcel.readString();
            this.Vgc = parcel.readInt();
            AppMethodBeat.o(258736);
        }

        static {
            AppMethodBeat.i(258738);
            AppMethodBeat.o(258738);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(258737);
            parcel.writeInt(this.type);
            parcel.writeString(this.url);
            parcel.writeString(this.username);
            parcel.writeString(this.path);
            parcel.writeString(this.version);
            parcel.writeString(this.VfW);
            parcel.writeString(this.VfX);
            parcel.writeString(this.VfY);
            parcel.writeString(this.VfZ);
            parcel.writeString(this.Vga);
            parcel.writeString(this.Vgb);
            parcel.writeString(this.Vgd);
            parcel.writeString(this.Vge);
            parcel.writeString(this.Vgf);
            parcel.writeInt(this.Vgc);
            AppMethodBeat.o(258737);
        }
    }

    public static class RemarksInfo implements Parcelable {
        public static final Parcelable.Creator<RemarksInfo> CREATOR = new Parcelable.Creator<RemarksInfo>() {
            /* class com.tencent.mm.plugin.wallet_core.model.Orders.RemarksInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ RemarksInfo[] newArray(int i2) {
                return new RemarksInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RemarksInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(70339);
                RemarksInfo remarksInfo = new RemarksInfo(parcel);
                AppMethodBeat.o(70339);
                return remarksInfo;
            }
        };
        public String Iao;
        public String Iap;

        public RemarksInfo() {
        }

        protected RemarksInfo(Parcel parcel) {
            AppMethodBeat.i(70340);
            this.Iao = parcel.readString();
            this.Iap = parcel.readString();
            AppMethodBeat.o(70340);
        }

        static {
            AppMethodBeat.i(70342);
            AppMethodBeat.o(70342);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(70341);
            parcel.writeString(this.Iao);
            parcel.writeString(this.Iap);
            AppMethodBeat.o(70341);
        }
    }

    public static class SimpleCashierInfo implements Parcelable {
        public static final Parcelable.Creator<SimpleCashierInfo> CREATOR = new Parcelable.Creator<SimpleCashierInfo>() {
            /* class com.tencent.mm.plugin.wallet_core.model.Orders.SimpleCashierInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SimpleCashierInfo[] newArray(int i2) {
                return new SimpleCashierInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SimpleCashierInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(70348);
                SimpleCashierInfo simpleCashierInfo = new SimpleCashierInfo(parcel);
                AppMethodBeat.o(70348);
                return simpleCashierInfo;
            }
        };
        public String ANo;
        public int Iaw;
        public String dDj;

        public SimpleCashierInfo() {
        }

        protected SimpleCashierInfo(Parcel parcel) {
            AppMethodBeat.i(70349);
            this.Iaw = parcel.readInt();
            this.dDj = parcel.readString();
            this.ANo = parcel.readString();
            AppMethodBeat.o(70349);
        }

        static {
            AppMethodBeat.i(70351);
            AppMethodBeat.o(70351);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(70350);
            parcel.writeInt(this.Iaw);
            parcel.writeString(this.dDj);
            parcel.writeString(this.ANo);
            AppMethodBeat.o(70350);
        }
    }

    public static class ShowInfo implements Parcelable {
        public static final Parcelable.Creator<ShowInfo> CREATOR = new Parcelable.Creator<ShowInfo>() {
            /* class com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ShowInfo[] newArray(int i2) {
                return new ShowInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ShowInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(70343);
                ShowInfo showInfo = new ShowInfo(parcel);
                AppMethodBeat.o(70343);
                return showInfo;
            }
        };
        public String Iaq;
        public int Iar;
        public String Ias;
        public String Iat;
        public String Iau;
        public int Iav;
        public String name;
        public String value;
        public String xEk;

        public ShowInfo() {
        }

        protected ShowInfo(Parcel parcel) {
            AppMethodBeat.i(70344);
            this.name = parcel.readString();
            this.value = parcel.readString();
            this.xEk = parcel.readString();
            this.Iaq = parcel.readString();
            this.Iar = parcel.readInt();
            this.Ias = parcel.readString();
            this.Iat = parcel.readString();
            this.Iau = parcel.readString();
            this.Iav = parcel.readInt();
            AppMethodBeat.o(70344);
        }

        public String toString() {
            AppMethodBeat.i(70345);
            String format = String.format("ShowInfo name:%s, value:%s, nameColor:%s, valueColor:%s, linkType:%s, linkWeApp:%s, linkAddr:%s, linkUrl:%s, textAttr:%s", this.name, this.value, this.xEk, this.Iaq, Integer.valueOf(this.Iar), this.Ias, this.Iat, this.Iau, Integer.valueOf(this.Iav));
            AppMethodBeat.o(70345);
            return format;
        }

        static {
            AppMethodBeat.i(70347);
            AppMethodBeat.o(70347);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(70346);
            parcel.writeString(this.name);
            parcel.writeString(this.value);
            parcel.writeString(this.xEk);
            parcel.writeString(this.Iaq);
            parcel.writeInt(this.Iar);
            parcel.writeString(this.Ias);
            parcel.writeString(this.Iat);
            parcel.writeString(this.Iau);
            parcel.writeInt(this.Iav);
            AppMethodBeat.o(70346);
        }
    }
}
