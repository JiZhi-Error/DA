package com.tencent.mm.plugin.offline.c;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bu;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.d;
import com.tencent.mm.plugin.offline.h;
import com.tencent.mm.plugin.offline.j;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import e.a.a.c;
import e.a.a.e;
import e.a.a.g;
import e.a.a.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static String AMZ = "";
    public static String ANa = "";
    public static int ANb = 1;
    public static String ANc = "";
    public static String ANd = "";
    public static String ANe = "";
    public static int ANf = 1;
    public static int ANg = 0;
    public static long ANh = 0;
    public static boolean ANi = false;
    public static String ANj = "";
    public static String ANk = "";
    private static Comparator<Bankcard> ANl = new Comparator<Bankcard>() {
        /* class com.tencent.mm.plugin.offline.c.a.AnonymousClass5 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Bankcard bankcard, Bankcard bankcard2) {
            AppMethodBeat.i(66556);
            int compareToIgnoreCase = bankcard.field_bindSerial.compareToIgnoreCase(bankcard2.field_bindSerial);
            AppMethodBeat.o(66556);
            return compareToIgnoreCase;
        }
    };
    private static Comparator<C1566a> ANm = new Comparator<C1566a>() {
        /* class com.tencent.mm.plugin.offline.c.a.AnonymousClass6 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(C1566a aVar, C1566a aVar2) {
            AppMethodBeat.i(66557);
            int compareToIgnoreCase = aVar.ANo.compareToIgnoreCase(aVar2.ANo);
            AppMethodBeat.o(66557);
            return compareToIgnoreCase;
        }
    };
    public static String pQH = "";

    /* renamed from: com.tencent.mm.plugin.offline.c.a$a  reason: collision with other inner class name */
    public static class C1566a {
        public int ANn;
        public String ANo;
        public String ANp;
        public String dDj;
    }

    public static class b {
        public String dDj;
        public String qGB;
    }

    static {
        AppMethodBeat.i(66629);
        AppMethodBeat.o(66629);
    }

    public static boolean eAj() {
        AppMethodBeat.i(66558);
        k.ezn();
        String TX = k.TX(196630);
        if (TX == null || !TX.equals("1")) {
            AppMethodBeat.o(66558);
            return false;
        }
        AppMethodBeat.o(66558);
        return true;
    }

    public static boolean eAk() {
        AppMethodBeat.i(66559);
        k.ezn();
        String TX = k.TX(196641);
        if (TX == null || !TX.equals("1")) {
            AppMethodBeat.o(66559);
            return false;
        }
        AppMethodBeat.o(66559);
        return true;
    }

    @Deprecated
    public static Bankcard eAl() {
        AppMethodBeat.i(66560);
        Bankcard yi = af.yi(true);
        AppMethodBeat.o(66560);
        return yi;
    }

    @Deprecated
    public static Bankcard eAm() {
        AppMethodBeat.i(213693);
        Bankcard yi = af.yi(false);
        AppMethodBeat.o(213693);
        return yi;
    }

    public static Bankcard eAn() {
        AppMethodBeat.i(66561);
        Bankcard sA = sA(true);
        AppMethodBeat.o(66561);
        return sA;
    }

    public static Bankcard eAo() {
        AppMethodBeat.i(66562);
        t.fQI();
        Bankcard fRX = an.fRX();
        AppMethodBeat.o(66562);
        return fRX;
    }

    public static int eAp() {
        AppMethodBeat.i(66563);
        int size = t.fQI().yj(true).size();
        AppMethodBeat.o(66563);
        return size;
    }

    public static List<Bankcard> sB(boolean z) {
        AppMethodBeat.i(66564);
        ArrayList arrayList = new ArrayList();
        ArrayList<Bankcard> yk = t.fQI().yk(true);
        int i2 = 0;
        while (yk != null && i2 < yk.size()) {
            Bankcard bankcard = yk.get(i2);
            if (z) {
                arrayList.add(bankcard);
            } else {
                arrayList.add(bankcard);
            }
            i2++;
        }
        Log.i("MicroMsg.WalletOfflineUtil", "getBindBankCardList() list size is " + arrayList.size());
        AppMethodBeat.o(66564);
        return arrayList;
    }

    public static List<Bankcard> eAq() {
        AppMethodBeat.i(66565);
        ArrayList arrayList = new ArrayList();
        ArrayList<Bankcard> fRI = t.fQI().fRI();
        for (int i2 = 0; i2 < fRI.size(); i2++) {
            arrayList.add(fRI.get(i2));
        }
        Log.i("MicroMsg.WalletOfflineUtil", "getOfflineBindBankCardList() list size is " + arrayList.size());
        AppMethodBeat.o(66565);
        return arrayList;
    }

    public static int eAr() {
        AppMethodBeat.i(66566);
        k.ezn();
        String TX = k.TX(196629);
        if (TextUtils.isEmpty(TX) || !isNumeric(TX)) {
            AppMethodBeat.o(66566);
            return 0;
        }
        int i2 = Util.getInt(TX, 0);
        AppMethodBeat.o(66566);
        return i2;
    }

    public static void Ud(int i2) {
        AppMethodBeat.i(66568);
        k.ezn();
        k.bN(196640, String.valueOf(i2));
        AppMethodBeat.o(66568);
    }

    public static void Ue(int i2) {
        AppMethodBeat.i(66569);
        k.ezn();
        k.bN(196642, String.valueOf(i2));
        AppMethodBeat.o(66569);
    }

    public static String eAt() {
        AppMethodBeat.i(66570);
        k.ezn();
        String TX = k.TX(196632);
        AppMethodBeat.o(66570);
        return TX;
    }

    public static String eAu() {
        AppMethodBeat.i(66571);
        k.ezn();
        String TX = k.TX(196631);
        AppMethodBeat.o(66571);
        return TX;
    }

    public static void aJj(String str) {
        AppMethodBeat.i(66572);
        k.ezn();
        k.bN(196631, str);
        AppMethodBeat.o(66572);
    }

    public static void gK(Context context) {
        String string;
        AppMethodBeat.i(66573);
        String applicationLanguage = LocaleUtil.getApplicationLanguage();
        if (LocaleUtil.CHINA.equals(applicationLanguage)) {
            string = context.getString(R.string.htz);
        } else if (LocaleUtil.TAIWAN.equals(applicationLanguage)) {
            string = context.getString(R.string.hu2);
        } else if (LocaleUtil.HONGKONG.equals(applicationLanguage)) {
            string = context.getString(R.string.hu1);
        } else {
            string = context.getResources().getString(R.string.hu0);
        }
        f.bn(context, string);
        AppMethodBeat.o(66573);
    }

    public static boolean isNumeric(String str) {
        AppMethodBeat.i(66575);
        if (str == null) {
            AppMethodBeat.o(66575);
            return false;
        }
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.o(66575);
        return matches;
    }

    public static String eAv() {
        AppMethodBeat.i(66576);
        t.fQI();
        String fRR = an.fRR();
        AppMethodBeat.o(66576);
        return fRR;
    }

    public static void aJk(String str) {
        AppMethodBeat.i(66577);
        t.fQI();
        an.aVq(str);
        AppMethodBeat.o(66577);
    }

    public static void eAw() {
        AppMethodBeat.i(66578);
        Log.i("MicroMsg.WalletOfflineUtil", "clear offline data");
        k.ezn();
        k.bN(196630, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        k.ezn();
        k.bN(196626, "");
        k.ezn();
        k.bN(196627, "");
        k.ezn();
        k.bN(196628, "");
        k.ezn();
        k.bN(196617, "");
        k.ezn();
        k.bN(196632, "");
        k.ezn();
        k.bN(196641, "");
        k.ezn();
        k.bN(196647, "");
        k.ezn();
        k.bN(196649, "");
        w("", "", "", "");
        Uh(0);
        k.ezn();
        k.bN(196629, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        aJj("");
        k.ezn();
        k.ezo().AKa = null;
        k.ezn();
        k.ezq();
        k.ezn();
        String TX = k.TX(196617);
        com.tencent.mm.wallet_core.c.b.hhj();
        com.tencent.mm.wallet_core.c.b.clearToken(TX);
        aJo("");
        aJl("");
        AppMethodBeat.o(66578);
    }

    public static void a(Activity activity, s.f fVar) {
        AppMethodBeat.i(66579);
        Log.i("MicroMsg.WalletOfflineUtil", "hy: whole pay msg coming. direct parse");
        if (fVar == null || fVar.AKp == null) {
            Log.e("MicroMsg.WalletOfflineUtil", "order == null");
            AppMethodBeat.o(66579);
        } else if (!eAk()) {
            AppMethodBeat.o(66579);
        } else {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_orders", fVar.AKp);
            bundle.putInt("key_pay_type", 2);
            if (fVar.egD != null) {
                RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
                realnameGuideHelper.b(fVar.egD.egd, fVar.egD.ege, fVar.egD.egf, fVar.egD.egg, fVar.egD.egh, 8);
                bundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
            }
            if (activity instanceof WalletOfflineCoinPurseUI) {
                Intent intent = activity.getIntent();
                bundle.putString("key_appid", intent.getStringExtra("key_appid"));
                bundle.putInt("key_from_scene", intent.getIntExtra("key_from_scene", 0));
            }
            com.tencent.mm.wallet_core.a.a(activity, j.class, bundle);
            AppMethodBeat.o(66579);
        }
    }

    public static Orders az(Map<String, String> map) {
        String valueOf;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        AppMethodBeat.i(66580);
        Orders orders = new Orders();
        Orders.Commodity commodity = new Orders.Commodity();
        commodity.ANX = map.get(".sysmsg.paymsg.user_roll.buy_uin");
        commodity.ANY = map.get(".sysmsg.paymsg.user_roll.buy_name");
        commodity.ANZ = map.get(".sysmsg.paymsg.user_roll.sale_uin");
        commodity.AOa = map.get(".sysmsg.paymsg.user_roll.sale_name");
        commodity.dDM = map.get(".sysmsg.paymsg.user_roll.trans_id");
        commodity.desc = map.get(".sysmsg.paymsg.user_roll.goods_name");
        commodity.qwJ = ((double) Util.getInt(map.get(".sysmsg.paymsg.user_roll.pay_num"), -1)) / 100.0d;
        commodity.AOe = map.get(".sysmsg.paymsg.user_roll.trade_state");
        commodity.AOf = map.get(".sysmsg.paymsg.user_roll.trade_state_name");
        commodity.AOj = map.get(".sysmsg.paymsg.user_roll.buy_bank_name");
        commodity.AOp = map.get(".sysmsg.paymsg.user_roll.discount");
        commodity.AOh = Util.getInt(map.get(".sysmsg.paymsg.user_roll.modify_timestamp"), 0);
        commodity.AOl = map.get(".sysmsg.paymsg.user_roll.fee_type");
        commodity.dCu = map.get(".sysmsg.paymsg.user_roll.appusername");
        commodity.ANP = map.get(".sysmsg.paymsg.user_roll.app_telephone");
        commodity.HZE = ((double) Util.getInt(map.get(".sysmsg.paymsg.user_roll.buy_bank_name"), -1)) / 100.0d;
        Orders.Promotions promotions = new Orders.Promotions();
        promotions.name = map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.nickname");
        promotions.dCu = map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.username");
        promotions.type = Orders.HZC;
        commodity.HZF = promotions.dCu;
        promotions.Bah = map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.logo_round_url");
        promotions.url = map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.subscribe_biz_url");
        int i2 = Util.getInt(map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.recommend_level"), 1);
        commodity.HYT = i2;
        commodity.HZI = map.get(".sysmsg.paymsg.user_roll.rateinfo");
        commodity.HZJ = map.get(".sysmsg.paymsg.user_roll.discount_rateinfo");
        commodity.HZK = map.get(".sysmsg.paymsg.user_roll.original_feeinfo");
        if (!Util.isNullOrNil(promotions.name)) {
            commodity.HZO = true;
            commodity.HZN.add(promotions);
        }
        int i3 = 0;
        while (true) {
            if (i3 >= 255) {
                break;
            }
            Orders.Promotions promotions2 = new Orders.Promotions();
            if (i3 == 0) {
                str3 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.icon");
                str4 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.wording");
                str5 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.url");
                str6 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.btn_text");
                str7 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.type");
                str8 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.title");
                str9 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_type");
                str10 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_id");
                str11 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.send_record_id");
                str12 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.award_id");
                str13 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.user_record_id");
                str14 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.small_title");
                str15 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_tinyapp_username");
                str16 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_tinyapp_path");
                str17 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_mch_id");
                str18 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_tinyapp_version");
                str19 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.get_award_params");
                str20 = map.get(".sysmsg.paymsg.user_roll.activity_info.record.query_award_status_params");
            } else {
                str3 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".icon");
                str4 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".wording");
                str5 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".url");
                str6 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".btn_text");
                str7 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".type");
                str8 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".title");
                str9 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_type");
                str10 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_id");
                str11 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".send_record_id");
                str12 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".award_id");
                str13 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".user_record_id");
                str14 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".small_title");
                str15 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_tinyapp_username");
                str16 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_tinyapp_path");
                str17 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_mch_id");
                str18 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_tinyapp_version");
                str19 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".get_award_params");
                str20 = map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".query_award_status_params");
            }
            if (Util.isNullOrNil(str4)) {
                Log.i("MicroMsg.WalletOfflineUtil", "hy: activity end. total size: %d", Integer.valueOf(i3 + 1));
                break;
            }
            promotions2.Bah = str3;
            promotions2.name = str4;
            promotions2.url = str5;
            promotions2.HYF = str6;
            promotions2.type = Orders.HZD;
            promotions2.trD = Util.getInt(str7, 0);
            promotions2.title = str8;
            promotions2.Vgg = Util.getInt(str9, 0);
            promotions2.crw = Util.getLong(str10, 0);
            promotions2.HYC = Util.getInt(str11, 0);
            promotions2.Vgh = Util.getInt(str12, 0);
            promotions2.HYD = Util.getInt(str13, 0);
            promotions2.Vgi = str14;
            promotions2.Vgj = str15;
            promotions2.Vgk = str16;
            promotions2.HYE = Util.getLong(str17, 0);
            promotions2.Vgl = Util.getInt(str18, 0);
            promotions2.Vgm = str19;
            promotions2.Vgn = str20;
            c f2 = f(map, i3);
            if (f2 != null) {
                promotions2.Iah = f2;
            }
            commodity.HZN.add(promotions2);
            i3++;
        }
        commodity.HZP.text = map.get(".sysmsg.paymsg.user_roll.link_ativity_info.text");
        commodity.HZP.url = map.get(".sysmsg.paymsg.user_roll.link_ativity_info.url");
        String str21 = map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_name");
        String str22 = map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_logo");
        String str23 = map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_desc");
        String str24 = map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_username");
        String str25 = map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_path");
        if (!Util.isNullOrNil(str21) && !Util.isNullOrNil(str22) && !Util.isNullOrNil(str23) && !Util.isNullOrNil(str24)) {
            commodity.HZL = new Orders.RecommendTinyAppInfo();
            commodity.HZL.HLz = str21;
            commodity.HZL.HYH = str22;
            commodity.HZL.HYI = str23;
            commodity.HZL.Hwr = str24;
            commodity.HZL.Hws = str25;
            commodity.HZL.HYJ = map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_tinyapp_btn_text");
            commodity.HZL.Iai = Util.getLong(map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_id"), 0);
            commodity.HZL.Iaj = Util.getLong(map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_type"), 0);
            commodity.HZL.Ial = Util.getInt(map.get(".sysmsg.paymsg.user_roll.tinyapp_info.send_record_id"), 0);
            commodity.HZL.Iam = Util.getInt(map.get(".sysmsg.paymsg.user_roll.tinyapp_info.user_record_id"), 0);
            commodity.HZL.Ian = (long) Util.getInt(map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_mch_id"), 0);
            commodity.HZL.Iak = (long) Util.getInt(map.get(".sysmsg.paymsg.user_roll.tinyapp_info.award_id"), 0);
            commodity.HZL.HYK = Util.getInt(map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_version"), 0);
        }
        commodity.VfV = new Orders.FinderInfo();
        int i4 = Util.getInt(map.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.type"), 0);
        String str26 = map.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.url");
        String str27 = map.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.tiny_app_uri.username");
        String str28 = map.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.tiny_app_uri.path");
        String str29 = map.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.tiny_app_uri.version");
        String str30 = map.get(".sysmsg.paymsg.user_roll.finder_info_view.logo.url");
        String str31 = map.get(".sysmsg.paymsg.user_roll.finder_info_view.title");
        String str32 = map.get(".sysmsg.paymsg.user_roll.finder_info_view.desc");
        int i5 = Util.getInt(map.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.finder_uri.type"), -1);
        String str33 = map.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.finder_uri.username");
        String str34 = map.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.finder_uri.feedid");
        String str35 = map.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.finder_uri.nonceid");
        Log.i("MicroMsg.WalletOfflineUtil", "finder jump type：%s", Integer.valueOf(i4));
        Log.i("MicroMsg.WalletOfflineUtil", "finder h5 url：%s", str26);
        Log.i("MicroMsg.WalletOfflineUtil", "finder tinyapp username：%s ，path：%s，version：%s", str27, str28, str29);
        Log.i("MicroMsg.WalletOfflineUtil", "finder finder_logo_normal：%s，finder_title：%s，finder_desc:%s，finder_uri_type：%s，finder_uri_username：%s，finder_uri_feedid：%s,finder_uri_nonceid：%s", str30, str31, str32, Integer.valueOf(i5), str33, str34, str35);
        commodity.VfV.type = i4;
        commodity.VfV.url = str26;
        commodity.VfV.username = str27;
        commodity.VfV.path = str28;
        commodity.VfV.version = str29;
        commodity.VfV.VfW = str30;
        commodity.VfV.VfX = map.get(".sysmsg.paymsg.user_roll.finder_info_view.logo.dark_mode_url");
        commodity.VfV.VfY = map.get(".sysmsg.paymsg.user_roll.finder_info_view.sub_logo.url");
        commodity.VfV.VfZ = map.get(".sysmsg.paymsg.user_roll.finder_info_view.sub_logo.dark_mode_url");
        commodity.VfV.Vga = str31;
        commodity.VfV.Vgb = str32;
        commodity.VfV.Vgc = i5;
        commodity.VfV.Vgd = str33;
        commodity.VfV.Vge = str34;
        commodity.VfV.Vgf = str35;
        orders.HZd = new ArrayList();
        orders.HZd.add(commodity);
        orders.HZn = Util.getInt(map.get(".sysmsg.paymsg.user_roll.is_use_new_paid_succ_page"), 0);
        orders.HZo = map.get(".sysmsg.paymsg.user_roll.pay_succ_btn_wording");
        orders.HYV = map.get(".sysmsg.paymsg.user_roll.trade_state_name");
        orders.HYT = i2;
        orders.dDL = map.get(".sysmsg.req_key");
        a(orders, map);
        commodity.HZE = Util.getDouble(map.get(".sysmsg.paymsg.user_roll.original_total_fee"), -1.0d) / 100.0d;
        if (!TextUtils.isEmpty(map.get(".sysmsg.paymsg.user_roll.discount_array.record.favor_desc"))) {
            int i6 = 0;
            while (true) {
                if (i6 == 0) {
                    valueOf = "";
                } else {
                    valueOf = String.valueOf(i6);
                }
                str = ".sysmsg.paymsg.user_roll.discount_array.record" + valueOf + ".favor_desc";
                str2 = ".sysmsg.paymsg.user_roll.discount_array.record" + valueOf + ".payment_amount";
                if (TextUtils.isEmpty(map.get(str)) || TextUtils.isEmpty(map.get(str2))) {
                    Log.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str + ", payment_amount_key is " + str2 + ", break");
                } else {
                    Orders.DiscountInfo discountInfo = new Orders.DiscountInfo();
                    discountInfo.Coh = map.get(str);
                    discountInfo.HZY = Util.getDouble(map.get(str2), 0.0d);
                    commodity.HZH.add(discountInfo);
                    i6++;
                }
            }
            Log.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str + ", payment_amount_key is " + str2 + ", break");
        } else {
            Log.e("MicroMsg.WalletOfflineUtil", ".sysmsg.paymsg.user_roll.discount_array.record.favor_desc value is empty");
        }
        AppMethodBeat.o(66580);
        return orders;
    }

    private static c f(Map<String, String> map, int i2) {
        AppMethodBeat.i(66581);
        String str = i2 == 0 ? ".sysmsg.paymsg.user_roll.activity_info.record.exposure_info." : ".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".exposure_info.";
        if (map != null) {
            c cVar = new c();
            cVar.Ubh = Util.getInt(map.get(str + "is_query_others"), 0);
            cVar.LrG = map.get(str + "draw_lottery_params");
            cVar.Ltn = Util.getInt(map.get(str + "is_show_btn"), 0);
            cVar.Ltl = Util.nullAsNil(map.get(str + "exposure_info_modify_params"));
            e.a.a.a aVar = new e.a.a.a();
            String str2 = str + "btn_info.";
            aVar.UaZ = map.get(str2 + "btn_words");
            aVar.Uba = map.get(str2 + "btn_color");
            aVar.Ubb = Util.getInt(map.get(str2 + "btn_op_type"), 0);
            aVar.url = map.get(str2 + "url");
            aVar.LXU = map.get(str2 + "get_lottery_params");
            String str3 = str2 + "mini_app_info.";
            aVar.Ubc = new g();
            aVar.Ubc.MFd = map.get(str3 + "activity_tinyapp_username");
            aVar.Ubc.MFe = map.get(str3 + "activity_tinyapp_path");
            aVar.Ubc.MFf = Util.getInt(map.get(str3 + "activity_tinyapp_version"), 0);
            if (!Util.isNullOrNil(aVar.UaZ) || !Util.isNullOrNil(aVar.url) || !Util.isNullOrNil(aVar.LXU) || !Util.isNullOrNil(aVar.Ubc.MFd) || !Util.isNullOrNil(aVar.Ubc.MFe)) {
                cVar.Lto = aVar;
            }
            cVar.Ubi = Util.getInt(map.get(str + "user_opertaion_type"), 0);
            cVar.Ubj = Util.getInt(map.get(str + "is_show_layer"), 0);
            cVar.Ubl = map.get(str + "background_img_whole");
            cVar.Ltm = new LinkedList<>();
            for (int i3 = 0; i3 < 255; i3++) {
                String str4 = i3 == 0 ? str + "single_exposure_info_list.record." : str + "single_exposure_info_list.record" + i3 + ".";
                i iVar = new i();
                iVar.Bah = map.get(str4 + "logo");
                iVar.UbK = map.get(str4 + "award_name");
                iVar.UbL = map.get(str4 + "award_description");
                iVar.UbM = map.get(str4 + "background_img");
                iVar.UbN = map.get(str4 + "award_name_color");
                iVar.UbO = map.get(str4 + "award_description_color");
                if (!Util.isNullOrNil(iVar.Bah) || !Util.isNullOrNil(iVar.UbK) || !Util.isNullOrNil(iVar.UbL) || !Util.isNullOrNil(iVar.UbM) || !Util.isNullOrNil(iVar.UbN) || !Util.isNullOrNil(iVar.UbO)) {
                    cVar.Ltm.add(iVar);
                }
                if (Util.isNullOrNil(iVar.UbK) || Util.isNullOrNil(iVar.UbL)) {
                    break;
                }
            }
            cVar.Ubk = new e.a.a.f();
            String str5 = str + "layer_info.";
            cVar.Ubk.Uby = map.get(str5 + "layer_title");
            cVar.Ubk.Ubz = map.get(str5 + "layer_logo");
            cVar.Ubk.UbA = map.get(str5 + "layer_type");
            cVar.Ubk.UbB = map.get(str5 + "layer_name");
            cVar.Ubk.UbC = map.get(str5 + "layer_description");
            cVar.Ubk.UbD = Util.getInt(map.get(str5 + "is_show_layer_btn"), 0);
            cVar.Ubk.UbE = new e();
            String str6 = str5 + "layer_btn_info.";
            cVar.Ubk.UbE.UaZ = map.get(str6 + "btn_words");
            cVar.Ubk.UbE.Uba = map.get(str6 + "btn_color");
            cVar.Ubk.UbE.Ubb = Util.getInt(map.get(str6 + "btn_op_type"), 0);
            cVar.Ubk.UbE.LXU = map.get(str6 + "get_lottery_params");
            cVar.Ubk.UbE.url = map.get(str6 + "url");
            String str7 = str6 + "mini_app_info.";
            cVar.Ubk.UbE.Ubc = new g();
            cVar.Ubk.UbE.Ubc.MFd = map.get(str7 + "activity_tinyapp_username");
            cVar.Ubk.UbE.Ubc.MFe = map.get(str7 + "activity_tinyapp_path");
            cVar.Ubk.UbE.Ubc.MFf = Util.getInt(map.get(str7 + "activity_tinyapp_version"), 0);
            if (!Util.isNullOrNil(map.get(str5 + "voice_url"))) {
                cVar.Ubk.UbF = new com.tencent.mm.bw.b(map.get(str5 + "voice_url").getBytes());
            }
            if (!Util.isNullOrNil(map.get(str5 + "voice_data"))) {
                cVar.Ubk.LaX = new com.tencent.mm.bw.b(map.get(str5 + "voice_data").getBytes());
            }
            e.a.a.b bVar = new e.a.a.b();
            String str8 = str + "draw_lottery_info.";
            bVar.url = map.get(str8 + "url");
            bVar.Ubd = map.get(str8 + "animation_wording");
            bVar.Ube = map.get(str8 + "animation_wording_color");
            bVar.NkQ = Util.getInt(map.get(str8 + "op_type"), 0);
            bVar.Ubf = map.get(str8 + "after_animation_wording");
            bVar.Ubg = map.get(str8 + "after_animation_wording_color");
            String str9 = str8 + "mini_app_info.";
            bVar.Ubc = new g();
            bVar.Ubc.MFd = map.get(str9 + "activity_tinyapp_username");
            bVar.Ubc.MFe = map.get(str9 + "activity_tinyapp_path");
            bVar.Ubc.MFf = Util.getInt(map.get(str9 + "activity_tinyapp_version"), 0);
            if (!Util.isNullOrNil(bVar.url) || !Util.isNullOrNil(bVar.Ubd) || !Util.isNullOrNil(bVar.Ube) || !Util.isNullOrNil(bVar.Ubc.MFd) || !Util.isNullOrNil(bVar.Ubc.MFe)) {
                cVar.Ubm = bVar;
            }
            AppMethodBeat.o(66581);
            return cVar;
        }
        AppMethodBeat.o(66581);
        return null;
    }

    private static void a(Orders orders, Map<String, String> map) {
        AppMethodBeat.i(66582);
        if (map != null) {
            orders.HZp = Util.getInt(map.get(".sysmsg.paymsg.user_roll.is_use_show_info"), 0);
            orders.HZr = new ArrayList<>();
            for (int i2 = 0; i2 < 255; i2++) {
                String str = i2 == 0 ? ".sysmsg.paymsg.user_roll.show_info.record" + "." : ".sysmsg.paymsg.user_roll.show_info.record" + i2 + ".";
                Orders.ShowInfo showInfo = new Orders.ShowInfo();
                showInfo.name = map.get(str + "name");
                showInfo.value = map.get(str + "value");
                showInfo.xEk = map.get(str + "name_color");
                showInfo.Iaq = map.get(str + "value_color");
                String str2 = str + "value_attr.";
                showInfo.Iar = Util.getInt(map.get(str2 + "link_type"), 0);
                showInfo.Ias = map.get(str2 + "link_weapp");
                showInfo.Iat = map.get(str2 + "link_addr");
                showInfo.Iau = map.get(str2 + "link_url");
                showInfo.Iav = Util.getInt(map.get(str2 + "text_attr"), 0);
                if (!Util.isNullOrNil(showInfo.name) || !Util.isNullOrNil(showInfo.value)) {
                    orders.HZr.add(showInfo);
                }
            }
        }
        AppMethodBeat.o(66582);
    }

    public static void a(Activity activity, String str, q qVar) {
        RealnameGuideHelper realnameGuideHelper;
        AppMethodBeat.i(66583);
        Log.i("MicroMsg.WalletOfflineUtil", "hy: only transid coming. do old way");
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.WalletOfflineUtil", "transid == null");
            AppMethodBeat.o(66583);
        } else if (!eAk()) {
            AppMethodBeat.o(66583);
        } else {
            Bundle bundle = new Bundle();
            if ((qVar instanceof com.tencent.mm.plugin.offline.a.e) && (realnameGuideHelper = ((com.tencent.mm.plugin.offline.a.e) qVar).AJr) != null) {
                bundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
            }
            bundle.putString("key_trans_id", str);
            bundle.putInt("key_pay_type", 2);
            if (activity instanceof WalletOfflineCoinPurseUI) {
                Intent intent = activity.getIntent();
                bundle.putString("key_appid", intent.getStringExtra("key_appid"));
                bundle.putInt("key_from_scene", intent.getIntExtra("key_from_scene", 0));
            }
            com.tencent.mm.wallet_core.a.a(activity, j.class, bundle);
            AppMethodBeat.o(66583);
        }
    }

    public static void i(Activity activity, int i2) {
        AppMethodBeat.i(66584);
        a(activity, i2, -1);
        AppMethodBeat.o(66584);
    }

    public static void a(Activity activity, int i2, int i3) {
        AppMethodBeat.i(66585);
        PayInfo payInfo = new PayInfo();
        payInfo.dVw = 5;
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_pay_info", payInfo);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 5);
        bundle.putInt("key_offline_add_fee", i2);
        if (i3 >= 0) {
            bundle.putInt("key_entry_scene", i3);
        }
        if (!t.fQI().fRk()) {
            if (t.fQI().fRm()) {
                bundle.putBoolean("key_is_bind_bankcard", true);
                com.tencent.mm.wallet_core.a.a(activity, d.class, bundle);
                AppMethodBeat.o(66585);
                return;
            } else if (t.fQI().fRl()) {
                bundle.putBoolean("key_is_bind_bankcard", true);
                com.tencent.mm.wallet_core.a.a(activity, d.class, bundle);
                AppMethodBeat.o(66585);
                return;
            }
        }
        com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.offline.c.class, bundle);
        AppMethodBeat.o(66585);
    }

    public static void a(Activity activity, int i2, int i3, Bundle bundle) {
        AppMethodBeat.i(66586);
        PayInfo payInfo = new PayInfo();
        payInfo.dVw = 5;
        bundle.putParcelable("key_pay_info", payInfo);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 5);
        bundle.putInt("key_offline_add_fee", i2);
        if (i3 >= 0) {
            bundle.putInt("key_entry_scene", i3);
        }
        if (bundle != null) {
            ab.mg(6, bundle.getInt("key_bind_scene"));
            z.aqh(bundle.getInt("key_bind_scene"));
        } else {
            ab.mg(6, 0);
            z.aqh(0);
        }
        ((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(activity, bundle);
        AppMethodBeat.o(66586);
    }

    public static void j(Activity activity, int i2) {
        AppMethodBeat.i(66587);
        a(activity, "create", activity.getString(R.string.iv2), 0, i2);
        AppMethodBeat.o(66587);
    }

    private static void a(Activity activity, String str, String str2, int i2, int i3) {
        AppMethodBeat.i(66588);
        Bundle bundle = new Bundle();
        bundle.putString("oper", str);
        bundle.putInt("offline_chg_fee", i2);
        bundle.putString("pwd_tips", str2);
        if (i3 >= 0) {
            bundle.putInt("offline_from_scene", i3);
        }
        com.tencent.mm.wallet_core.a.a(activity, h.class, bundle);
        AppMethodBeat.o(66588);
    }

    public static void ay(Activity activity) {
        AppMethodBeat.i(66589);
        a(activity, "freeze", activity.getString(R.string.iv5), 0, -1);
        AppMethodBeat.o(66589);
    }

    public static void az(Activity activity) {
        AppMethodBeat.i(66590);
        k(activity, -1);
        AppMethodBeat.o(66590);
    }

    public static void k(Activity activity, int i2) {
        AppMethodBeat.i(66591);
        a(activity, "create", "", eAs(), i2);
        AppMethodBeat.o(66591);
    }

    public static void j(final Activity activity, String str) {
        AppMethodBeat.i(66592);
        com.tencent.mm.ui.base.h.a((Context) activity, false, str, "", activity.getString(R.string.ivl), activity.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.offline.c.a.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(66552);
                a.eAw();
                a.az(activity);
                activity.finish();
                AppMethodBeat.o(66552);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.offline.c.a.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(66553);
                activity.finish();
                AppMethodBeat.o(66553);
            }
        });
        AppMethodBeat.o(66592);
    }

    public static void eAx() {
        AppMethodBeat.i(66593);
        k.ezn();
        k.bN(196643, "1");
        AppMethodBeat.o(66593);
    }

    public static void Uf(int i2) {
        AppMethodBeat.i(66594);
        k.ezn();
        k.bN(196644, String.valueOf(i2));
        AppMethodBeat.o(66594);
    }

    public static int eAy() {
        AppMethodBeat.i(66595);
        k.ezn();
        String TX = k.TX(196644);
        if (TextUtils.isEmpty(TX) || !isNumeric(TX)) {
            AppMethodBeat.o(66595);
            return 0;
        }
        int i2 = Util.getInt(TX, 0);
        AppMethodBeat.o(66595);
        return i2;
    }

    public static String getToken() {
        AppMethodBeat.i(66596);
        if (!TextUtils.isEmpty(AMZ)) {
            String str = AMZ;
            AppMethodBeat.o(66596);
            return str;
        }
        eAB();
        if (TextUtils.isEmpty(AMZ)) {
            Log.e("MicroMsg.WalletOfflineUtil", "token is null");
        }
        String str2 = AMZ;
        AppMethodBeat.o(66596);
        return str2;
    }

    public static void w(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(66597);
        AMZ = str;
        ANa = str2;
        ANc = str3;
        ANd = str4;
        aJl(ANc);
        com.tencent.mm.kernel.g.aAg().hqi.a(new bu(new bu.a() {
            /* class com.tencent.mm.plugin.offline.c.a.AnonymousClass3 */

            @Override // com.tencent.mm.model.bu.a
            public final void a(com.tencent.mm.network.g gVar) {
                AppMethodBeat.i(66554);
                if (gVar == null || gVar.aZh() == null) {
                    AppMethodBeat.o(66554);
                    return;
                }
                if (a.AMZ != null) {
                    gVar.aZh().i("offline_token", a.AMZ.getBytes());
                }
                if (a.ANa != null) {
                    gVar.aZh().i("offline_token_V2", a.ANa.getBytes());
                }
                if (a.ANd != null) {
                    gVar.aZh().i("offline_key_list", a.ANd.getBytes());
                }
                AppMethodBeat.o(66554);
            }
        }), 0);
        AppMethodBeat.o(66597);
    }

    public static String eAz() {
        AppMethodBeat.i(66598);
        if (!TextUtils.isEmpty(ANa)) {
            String str = ANa;
            AppMethodBeat.o(66598);
            return str;
        }
        eAB();
        if (TextUtils.isEmpty(ANa)) {
            Log.e("MicroMsg.WalletOfflineUtil", "offline_token_v2 is null");
        }
        String str2 = ANa;
        AppMethodBeat.o(66598);
        return str2;
    }

    public static String eAA() {
        AppMethodBeat.i(66599);
        if (!TextUtils.isEmpty(ANc)) {
            String str = ANc;
            AppMethodBeat.o(66599);
            return str;
        } else if (TextUtils.isEmpty(ANc)) {
            k.ezn();
            String TX = k.TX(196656);
            ANc = TX;
            AppMethodBeat.o(66599);
            return TX;
        } else {
            if (TextUtils.isEmpty(ANc)) {
                Log.e("MicroMsg.WalletOfflineUtil", "offline_card_list is null");
            }
            String str2 = ANc;
            AppMethodBeat.o(66599);
            return str2;
        }
    }

    public static void aJl(String str) {
        AppMethodBeat.i(66600);
        k.ezn();
        k.bN(196656, str);
        ANc = str;
        AppMethodBeat.o(66600);
    }

    private static void eAB() {
        AppMethodBeat.i(66601);
        com.tencent.mm.kernel.g.aAg().hqi.a(new bu(new bu.a() {
            /* class com.tencent.mm.plugin.offline.c.a.AnonymousClass4 */

            @Override // com.tencent.mm.model.bu.a
            public final void a(com.tencent.mm.network.g gVar) {
                AppMethodBeat.i(66555);
                if (gVar == null || gVar.aZh() == null) {
                    Log.e("MicroMsg.WalletOfflineUtil", "doLocalProxyScene dispatcher == null || dispatcher.getAccInfo() == null");
                    AppMethodBeat.o(66555);
                    return;
                }
                byte[] MC = gVar.aZh().MC("offline_token");
                if (MC != null) {
                    String unused = a.AMZ = new String(MC);
                }
                byte[] MC2 = gVar.aZh().MC("offline_token_V2");
                if (MC2 != null) {
                    a.ANa = new String(MC2);
                }
                byte[] MC3 = gVar.aZh().MC("offline_key_list");
                if (MC3 != null) {
                    a.ANd = new String(MC3);
                }
                AppMethodBeat.o(66555);
            }
        }), 0);
        AppMethodBeat.o(66601);
    }

    public static LinkedList<C1566a> aJm(String str) {
        LinkedList<C1566a> linkedList = null;
        AppMethodBeat.i(66602);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(66602);
        } else {
            try {
                linkedList = B(new JSONArray(str));
                AppMethodBeat.o(66602);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.WalletOfflineUtil", e2, "", new Object[0]);
                AppMethodBeat.o(66602);
            }
        }
        return linkedList;
    }

    private static LinkedList<C1566a> B(JSONArray jSONArray) {
        AppMethodBeat.i(66603);
        if (jSONArray.length() == 0) {
            AppMethodBeat.o(66603);
            return null;
        }
        LinkedList<C1566a> linkedList = new LinkedList<>();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            if (jSONObject != null) {
                C1566a aVar = new C1566a();
                aVar.ANn = jSONObject.optInt("card_id");
                aVar.dDj = jSONObject.optString("bank_type");
                aVar.ANo = jSONObject.optString("bind_serial");
                aVar.ANp = jSONObject.optString("forbid_word");
                linkedList.add(aVar);
            }
        }
        AppMethodBeat.o(66603);
        return linkedList;
    }

    public static String getTokenPin() {
        AppMethodBeat.i(66604);
        k.ezn();
        String TX = k.TX(196647);
        AppMethodBeat.o(66604);
        return TX;
    }

    private static String eAC() {
        AppMethodBeat.i(66605);
        k.ezn();
        String TX = k.TX(196616);
        AppMethodBeat.o(66605);
        return TX;
    }

    public static void aJn(String str) {
        AppMethodBeat.i(66606);
        k.ezn();
        k.bN(196616, str);
        AppMethodBeat.o(66606);
    }

    public static void aA(Activity activity) {
        AppMethodBeat.i(66607);
        com.tencent.mm.ui.base.h.cD(activity, activity.getResources().getString(R.string.iv3));
        if (!TextUtils.isEmpty(eAC())) {
            f.bn(activity, eAC());
        }
        AppMethodBeat.o(66607);
    }

    public static boolean eAD() {
        AppMethodBeat.i(66608);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_offlinepay_monitor_kinda_bindcard, 0) == 0) {
            Log.i("MicroMsg.WalletOfflineUtil", "pass same md5 case");
            AppMethodBeat.o(66608);
            return true;
        }
        ArrayList<Bankcard> yj = t.fQI().yj(true);
        LinkedList<C1566a> aJm = aJm(eAA());
        if (aJm == null || yj.size() != aJm.size()) {
            AppMethodBeat.o(66608);
            return false;
        }
        Collections.sort(aJm, ANm);
        Collections.sort(yj, ANl);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < aJm.size(); i2++) {
            sb.append(aJm.get(i2).ANo);
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i3 = 0; i3 < yj.size(); i3++) {
            sb2.append(yj.get(i3).field_bindSerial);
        }
        boolean equals = MD5Util.getMD5String(sb.toString()).equals(MD5Util.getMD5String(sb2.toString()));
        AppMethodBeat.o(66608);
        return equals;
    }

    private static String eAE() {
        AppMethodBeat.i(66609);
        if (TextUtils.isEmpty(ANe)) {
            k.ezn();
            String TX = k.TX(196615);
            ANe = TX;
            AppMethodBeat.o(66609);
            return TX;
        }
        String str = ANe;
        AppMethodBeat.o(66609);
        return str;
    }

    public static void aJo(String str) {
        AppMethodBeat.i(66610);
        k.ezn();
        k.bN(196615, str);
        ANe = str;
        AppMethodBeat.o(66610);
    }

    private static LinkedList<b> aJp(String str) {
        LinkedList<b> linkedList = null;
        AppMethodBeat.i(66611);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(66611);
        } else {
            try {
                linkedList = C(new JSONArray(str));
                AppMethodBeat.o(66611);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.WalletOfflineUtil", e2, "", new Object[0]);
                AppMethodBeat.o(66611);
            }
        }
        return linkedList;
    }

    private static LinkedList<b> C(JSONArray jSONArray) {
        AppMethodBeat.i(66612);
        if (jSONArray.length() == 0) {
            AppMethodBeat.o(66612);
            return null;
        }
        LinkedList<b> linkedList = new LinkedList<>();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            if (jSONObject != null) {
                b bVar = new b();
                bVar.dDj = jSONObject.optString("bank_type");
                bVar.qGB = jSONObject.optString("icon_url");
                linkedList.add(bVar);
            }
        }
        AppMethodBeat.o(66612);
        return linkedList;
    }

    public static int eAF() {
        AppMethodBeat.i(66613);
        k.ezn();
        String TX = k.TX(196649);
        if (TextUtils.isEmpty(TX) || !isNumeric(TX)) {
            AppMethodBeat.o(66613);
            return 0;
        }
        int i2 = Util.getInt(TX, 0);
        AppMethodBeat.o(66613);
        return i2;
    }

    public static boolean eAG() {
        AppMethodBeat.i(66614);
        String eAt = eAt();
        if (TextUtils.isEmpty(eAt)) {
            AppMethodBeat.o(66614);
            return false;
        }
        if ((System.currentTimeMillis() / 1000) - Long.valueOf(eAt).longValue() >= ((long) eAF())) {
            AppMethodBeat.o(66614);
            return true;
        }
        AppMethodBeat.o(66614);
        return false;
    }

    public static String aJq(String str) {
        String str2;
        AppMethodBeat.i(66615);
        LinkedList<b> aJp = aJp(eAE());
        if (aJp == null) {
            AppMethodBeat.o(66615);
            return "";
        }
        int i2 = 0;
        while (true) {
            if (i2 >= aJp.size()) {
                str2 = "";
                break;
            }
            b bVar = aJp.get(i2);
            if (bVar != null && str.equals(bVar.dDj)) {
                str2 = bVar.qGB;
                break;
            }
            i2++;
        }
        AppMethodBeat.o(66615);
        return str2;
    }

    public static String aJr(String str) {
        String str2;
        String str3;
        int i2 = 0;
        AppMethodBeat.i(66616);
        LinkedList<C1566a> aJm = aJm(eAA());
        LinkedList<b> aJp = aJp(eAE());
        if (aJm == null || aJp == null || aJm.size() == 0 || aJp.size() == 0) {
            Log.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() cardList == null || cardLogoList == null || cardList.size() == 0 || cardLogoList.size() == 0");
            AppMethodBeat.o(66616);
            return "";
        }
        int i3 = 0;
        while (true) {
            if (i3 >= aJm.size()) {
                str2 = "";
                break;
            }
            C1566a aVar = aJm.get(i3);
            if (aVar != null && str.equals(aVar.ANo)) {
                str2 = aVar.dDj;
                break;
            }
            i3++;
        }
        if (TextUtils.isEmpty(str2)) {
            Log.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() bank_type == null, can not find this bank_type");
            AppMethodBeat.o(66616);
            return "";
        }
        while (true) {
            if (i2 >= aJp.size()) {
                str3 = "";
                break;
            }
            b bVar = aJp.get(i2);
            if (bVar != null && str2.equals(bVar.dDj)) {
                str3 = bVar.qGB;
                break;
            }
            i2++;
        }
        AppMethodBeat.o(66616);
        return str3;
    }

    public static boolean isAppOnForeground(Context context) {
        AppMethodBeat.i(66617);
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningTasks(1);
        if (runningTasks != null && !runningTasks.isEmpty()) {
            ComponentName componentName = runningTasks.get(0).topActivity;
            Log.d("MicroMsg.WalletOfflineUtil", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                Log.i("MicroMsg.WalletOfflineUtil", "is in backGround.");
                AppMethodBeat.o(66617);
                return false;
            }
        }
        if (((KeyguardManager) MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            AppMethodBeat.o(66617);
            return false;
        }
        Log.i("MicroMsg.WalletOfflineUtil", "is in foreGround.");
        AppMethodBeat.o(66617);
        return true;
    }

    public static void aJs(String str) {
        AppMethodBeat.i(66618);
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.BUSINESS_OFFLINE_GETMSG_ACK_KEY_STRING, str);
        AppMethodBeat.o(66618);
    }

    public static String eAH() {
        AppMethodBeat.i(66619);
        Object obj = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.BUSINESS_OFFLINE_GETMSG_ACK_KEY_STRING, "");
        if (obj != null) {
            String str = (String) obj;
            AppMethodBeat.o(66619);
            return str;
        }
        AppMethodBeat.o(66619);
        return null;
    }

    public static void aJt(String str) {
        AppMethodBeat.i(66620);
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.BUSINESS_OFFLINE_GETMSG_REQ_KEY_STRING, str);
        AppMethodBeat.o(66620);
    }

    public static String eAI() {
        AppMethodBeat.i(66621);
        Object obj = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.BUSINESS_OFFLINE_GETMSG_REQ_KEY_STRING, "");
        if (obj != null) {
            String str = (String) obj;
            AppMethodBeat.o(66621);
            return str;
        }
        AppMethodBeat.o(66621);
        return null;
    }

    public static void Ug(int i2) {
        AppMethodBeat.i(66622);
        if (i2 < 0) {
            i2 = 0;
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.BUSINESS_OFFLINE_GETMSG_PAYMSG_TYPE_INT, Integer.valueOf(i2));
        AppMethodBeat.o(66622);
    }

    public static int eAJ() {
        int i2;
        AppMethodBeat.i(66623);
        Object obj = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.BUSINESS_OFFLINE_GETMSG_PAYMSG_TYPE_INT, (Object) null);
        if (obj != null) {
            i2 = ((Integer) obj).intValue();
        } else {
            i2 = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        AppMethodBeat.o(66623);
        return i2;
    }

    public static void aJu(String str) {
        AppMethodBeat.i(66624);
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.BUSINESS_OFFLINE_GETMSG_TRANS_ID_STRING, str);
        AppMethodBeat.o(66624);
    }

    public static String eAK() {
        AppMethodBeat.i(66625);
        Object obj = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.BUSINESS_OFFLINE_GETMSG_TRANS_ID_STRING, "");
        if (obj != null) {
            String str = (String) obj;
            AppMethodBeat.o(66625);
            return str;
        }
        AppMethodBeat.o(66625);
        return null;
    }

    public static int getNetworkType(Context context) {
        int i2;
        AppMethodBeat.i(66626);
        if (!NetStatusUtil.isConnected(context)) {
            i2 = -1;
        } else if (NetStatusUtil.isWifi(context)) {
            i2 = 1;
        } else if (NetStatusUtil.is2G(context)) {
            i2 = 2;
        } else if (NetStatusUtil.is3G(context)) {
            i2 = 3;
        } else if (NetStatusUtil.is4G(context)) {
            i2 = 4;
        } else {
            i2 = 0;
        }
        AppMethodBeat.o(66626);
        return i2;
    }

    public static boolean eAL() {
        AppMethodBeat.i(66627);
        boolean z = false;
        com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100232");
        if (Fu.isValid()) {
            Map<String, String> gzz = Fu.gzz();
            if (gzz.containsKey(WeChatBrands.Business.GROUP_OPEN) && "1".equals(gzz.get(WeChatBrands.Business.GROUP_OPEN))) {
                Log.e("MicroMsg.WalletOfflineUtil", "deprecated abtest 100232 enabled.");
            }
        }
        com.tencent.mm.storage.c Fu2 = com.tencent.mm.model.c.d.aXu().Fu("100261");
        if (Fu2.isValid()) {
            Map<String, String> gzz2 = Fu2.gzz();
            if (gzz2.containsKey(WeChatBrands.Business.GROUP_OPEN) && "1".equals(gzz2.get(WeChatBrands.Business.GROUP_OPEN))) {
                z = true;
            }
        }
        Log.i("MicroMsg.WalletOfflineUtil", "isPosEnabled: ".concat(String.valueOf(z)));
        AppMethodBeat.o(66627);
        return z;
    }

    public static void aJv(String str) {
        AppMethodBeat.i(66628);
        Log.i("MicroMsg.WalletOfflineUtil", "launch 3rd app: %s", str);
        com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(str, true, false);
        if (o == null) {
            Log.w("MicroMsg.WalletOfflineUtil", "can not find app info");
            AppMethodBeat.o(66628);
            return;
        }
        Bundle bundle = new Bundle();
        JumpToOfflinePay.Resp resp = new JumpToOfflinePay.Resp();
        resp.errCode = 0;
        resp.toBundle(bundle);
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.targetPkgName = o.field_packageName;
        args.bundle = bundle;
        com.tencent.mm.pluginsdk.model.app.q.bo(bundle);
        com.tencent.mm.pluginsdk.model.app.q.bp(bundle);
        MMessageActV2.send(MMApplicationContext.getContext(), args);
        AppMethodBeat.o(66628);
    }

    public static int eAM() {
        return k.AIY;
    }

    public static void Uh(int i2) {
        AppMethodBeat.i(182496);
        if (i2 > 0) {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.BUSINESS_OFFLINE_REGET_TOKEN_NUM_SYNC_INT, Integer.valueOf(i2));
            k.AIY = i2;
            Log.i("MicroMsg.WalletOfflineUtil", "set token num: %s", Integer.valueOf(i2));
        }
        AppMethodBeat.o(182496);
    }

    public static Bankcard sA(boolean z) {
        AppMethodBeat.i(213694);
        Bankcard yi = af.yi(z);
        if (yi == null || !yi.field_support_micropay || !Util.isNullOrNil(yi.field_forbidWord)) {
            ArrayList<Bankcard> yj = t.fQI().yj(true);
            for (int i2 = 0; i2 < yj.size(); i2++) {
                Bankcard bankcard = yj.get(i2);
                if (bankcard != null && bankcard.field_support_micropay) {
                    AppMethodBeat.o(213694);
                    return bankcard;
                }
            }
            AppMethodBeat.o(213694);
            return null;
        }
        AppMethodBeat.o(213694);
        return yi;
    }

    private static int eAs() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(66567);
        k.ezn();
        String TX = k.TX(196640);
        if (!TextUtils.isEmpty(TX) && isNumeric(TX)) {
            i3 = Util.getInt(TX, 0);
        }
        if (i3 > 0) {
            i2 = i3 * 100;
        } else {
            i2 = com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT;
        }
        AppMethodBeat.o(66567);
        return i2;
    }
}
