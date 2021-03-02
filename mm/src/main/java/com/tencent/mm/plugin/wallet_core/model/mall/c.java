package com.tencent.mm.plugin.wallet_core.model.mall;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class c {
    private static c Icu = null;
    public Map<String, MallNews> Icv = new HashMap();

    public static c fSg() {
        AppMethodBeat.i(70553);
        if (Icu == null) {
            Icu = new c();
        }
        c cVar = Icu;
        AppMethodBeat.o(70553);
        return cVar;
    }

    private c() {
        AppMethodBeat.i(70554);
        amZ();
        AppMethodBeat.o(70554);
    }

    public final void amZ() {
        AppMethodBeat.i(70555);
        this.Icv.clear();
        g.aAi();
        String str = (String) g.aAh().azQ().get(270339, "");
        Log.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(str)));
        for (String str2 : Util.stringsToList(str.split(";"))) {
            MallNews aVw = aVw(str2);
            if (aVw != null) {
                this.Icv.put(aVw.iLU, aVw);
            }
        }
        AppMethodBeat.o(70555);
    }

    public final List<String> fSh() {
        AppMethodBeat.i(70556);
        ArrayList arrayList = new ArrayList();
        for (MallNews mallNews : this.Icv.values()) {
            if (!Util.isNullOrNil(mallNews.dHx)) {
                arrayList.add(mallNews.dHx);
            }
        }
        Log.d("MicroMsg.MallNewsManager", "tickets.size : " + arrayList.size());
        AppMethodBeat.o(70556);
        return arrayList;
    }

    public static boolean a(MallNews mallNews) {
        AppMethodBeat.i(70557);
        g.aAi();
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_MALL_NEWS_MARKED_STRING_SYNC, "");
        ArrayList<String> stringsToList = Util.stringsToList(str.split(","));
        Log.i("MicroMsg.MallNewsManager", "tryCheckOutOfDateRedDot markedString %s", str);
        if (mallNews == null) {
            AppMethodBeat.o(70557);
            return false;
        } else if (Util.isNullOrNil(mallNews.FJm)) {
            AppMethodBeat.o(70557);
            return false;
        } else if (stringsToList.contains(mallNews.FJm)) {
            AppMethodBeat.o(70557);
            return true;
        } else {
            AppMethodBeat.o(70557);
            return false;
        }
    }

    public static void i(MallFunction mallFunction) {
        AppMethodBeat.i(70558);
        try {
            if (!Util.isNullOrNil(mallFunction.Icf.FJm)) {
                g.aAi();
                ArrayList<String> stringsToList = Util.stringsToList(((String) g.aAh().azQ().get(ar.a.USERINFO_MALL_NEWS_MARKED_STRING_SYNC, "")).split(","));
                while (stringsToList.size() > 20) {
                    stringsToList.remove(0);
                }
                if (stringsToList.contains(mallFunction.Icf.FJm)) {
                    AppMethodBeat.o(70558);
                    return;
                }
                stringsToList.add(mallFunction.Icf.FJm);
                String listToString = Util.listToString(stringsToList, ",");
                Log.i("MicroMsg.MallNewsManager", "doSelectFunction %s, markedString %s", mallFunction.Icf.FJm, listToString);
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_MALL_NEWS_MARKED_STRING_SYNC, listToString);
            }
            AppMethodBeat.o(70558);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MallNewsManager", e2, "error in markedFunction", new Object[0]);
            AppMethodBeat.o(70558);
        }
    }

    public static void aVt(String str) {
        Map<String, String> parseXml;
        AppMethodBeat.i(70559);
        if (!Util.isNullOrNil(str) && (parseXml = XmlParser.parseXml(str, "sysmsg", null)) != null) {
            int i2 = Util.getInt(parseXml.get(".sysmsg.paymsg.PayMsgType"), -1);
            if (i2 == 31) {
                String str2 = parseXml.get(".sysmsg.paymsg.WalletRedDotWording");
                int i3 = Util.getInt(parseXml.get(".sysmsg.paymsg.WalletRedDot"), -1);
                int i4 = Util.getInt(parseXml.get(".sysmsg.paymsg.BalanceRedDot"), -1);
                int i5 = Util.getInt(parseXml.get(".sysmsg.paymsg.LQTRedDot"), -1);
                Log.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, balanceRedDot: %s, lqtRedDot: %s", str2, Integer.valueOf(i4), Integer.valueOf(i5));
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, str2);
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_LQT_WALLET_RED_DOT_INT, Integer.valueOf(i3));
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_LQT_BALANCE_RED_DOT_INT, Integer.valueOf(i4));
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_LQT_LINK_RED_DOT_INT, Integer.valueOf(i5));
                fSj();
                AppMethodBeat.o(70559);
                return;
            } else if (i2 == 34) {
                Set<String> keySet = parseXml.keySet();
                Log.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", str, keySet.toString());
                if (keySet.size() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    for (String str3 : keySet) {
                        if (str3.startsWith(".sysmsg.paymsg.reddot.item")) {
                            String str4 = parseXml.get(str3);
                            String str5 = str3 + ".$expire_time";
                            String str6 = parseXml.get(str3 + ".$wording");
                            long j2 = Util.getLong(parseXml.get(str5), 0) * 1000;
                            if (!Util.isNullOrNil(str4)) {
                                Log.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s, expireTime: %s", str4, str6, Long.valueOf(j2));
                                if ("mainentry_me".equals(str4)) {
                                    g.aAi();
                                    g.aAh().azQ().set(ar.a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_BOOLEAN_SYNC, Boolean.TRUE);
                                    if (j2 > 0) {
                                        g.aAi();
                                        g.aAh().azQ().set(ar.a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(j2));
                                    }
                                } else if ("entry_wxpay_wallet".equals(str4)) {
                                    g.aAi();
                                    g.aAh().azQ().set(ar.a.USERINFO_WALLET_MY_ENTRY_REDDOT_BOOLEAN_SYNC, Boolean.TRUE);
                                    if (!Util.isNullOrNil(str6)) {
                                        g.aAi();
                                        g.aAh().azQ().set(ar.a.USERINFO_WALLET_ENTRY_WORDING_STRING_SYNC, str6);
                                    } else {
                                        g.aAi();
                                        g.aAh().azQ().set(ar.a.USERINFO_WALLET_ENTRY_WORDING_STRING_SYNC, "");
                                    }
                                    if (j2 > 0) {
                                        g.aAi();
                                        g.aAh().azQ().set(ar.a.USERINFO_WALLET_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(j2));
                                    }
                                } else if ("entry_wxpay_paycenter".equals(str4)) {
                                    g.aAi();
                                    g.aAh().azQ().set(ar.a.USERINFO_WALLET_MALL_MENU_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.TRUE);
                                    if (j2 > 0) {
                                        g.aAi();
                                        g.aAh().azQ().set(ar.a.USERINFO_WALLET_MALL_MENU_UI_REDDOT_CONFIG_EXPIRETIME_LONG_SYNC, Long.valueOf(j2));
                                    }
                                } else {
                                    try {
                                        jSONObject.put(str4, 1);
                                        if (j2 > 0) {
                                            jSONObject.put(String.format("%s_expiretime", str4), j2);
                                        }
                                    } catch (Exception e2) {
                                        Log.printErrStackTrace("MicroMsg.MallNewsManager", e2, "put redDotConfig json failed: %s", e2.getMessage());
                                    }
                                }
                            }
                        }
                    }
                    Log.i("MicroMsg.MallNewsManager", "redDotConfig: %s", jSONObject.toString());
                    if (jSONObject.length() > 0) {
                        g.aAi();
                        g.aAh().azQ().set(ar.a.USERINFO_WALLET_MENU_UI_REDDOT_CONFIG_STRING_SYNC, jSONObject.toString());
                        g.aAi();
                        g.aAh().azQ().set(ar.a.USERINFO_WALLET_MALL_MENU_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.TRUE);
                    }
                }
                AppMethodBeat.o(70559);
                return;
            } else if (i2 == 36) {
                String str7 = parseXml.get(".sysmsg.paymsg.WalletRedDotWording");
                int i6 = Util.getInt(parseXml.get(".sysmsg.paymsg.WalletRedDot"), -1);
                int i7 = Util.getInt(parseXml.get(".sysmsg.paymsg.LQBRedDot"), -1);
                Log.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, walletRedDot: %s, lqbRedDot: %s", str7, Integer.valueOf(i6), Integer.valueOf(i7));
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, str7);
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_LQT_WALLET_RED_DOT_INT, Integer.valueOf(i6));
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_LQB_MALL_ENTRY_RED_DOT_INT, Integer.valueOf(i7));
                fSj();
                AppMethodBeat.o(70559);
                return;
            } else if (i2 == 38) {
                Set<String> keySet2 = parseXml.keySet();
                Log.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", str, keySet2.toString());
                if (keySet2.size() > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    boolean z = false;
                    boolean z2 = false;
                    for (String str8 : keySet2) {
                        if (str8.startsWith(".sysmsg.paymsg.reddot.item")) {
                            String str9 = parseXml.get(str8);
                            String str10 = str8 + ".$expire_time";
                            String str11 = parseXml.get(str8 + ".$wording");
                            long j3 = Util.getLong(parseXml.get(str10), 0) * 1000;
                            if (!Util.isNullOrNil(str9)) {
                                Log.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s, expireTime: %s", str9, str11, Long.valueOf(j3));
                                if ("mainentry_me".equals(str9)) {
                                    com.tencent.mm.y.c.axV().b(ar.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, true);
                                    g.aAi();
                                    g.aAh().azQ().set(ar.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(j3));
                                    z2 = true;
                                } else if ("entry_wxpay_pay".equals(str9)) {
                                    com.tencent.mm.y.c.axV().b(ar.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, true);
                                    if (!Util.isNullOrNil(str11)) {
                                        g.aAi();
                                        g.aAh().azQ().set(ar.a.USERINFO_WALLET_New_MY_ENTRY_WORDING_STRING_SYNC, str11);
                                    } else {
                                        g.aAi();
                                        g.aAh().azQ().set(ar.a.USERINFO_WALLET_New_MY_ENTRY_WORDING_STRING_SYNC, "");
                                    }
                                    g.aAi();
                                    g.aAh().azQ().set(ar.a.USERINFO_WALLET_New_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(j3));
                                    z = true;
                                } else if ("entry_wxpay_pay_wallet".equals(str9)) {
                                    g.aAi();
                                    g.aAh().azQ().set(ar.a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.TRUE);
                                    g.aAi();
                                    g.aAh().azQ().set(ar.a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_EXPIRETIME_LONG_SYNC, Long.valueOf(j3));
                                } else if (str9.startsWith("bind_serial_")) {
                                    String substring = str9.substring(12);
                                    g.aAi();
                                    String str12 = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, "");
                                    Log.d("MicroMsg.MallNewsManager", "bind serial: %s", substring);
                                    String str13 = !Util.isNullOrNil(str12) ? str12 + "," + substring : substring;
                                    g.aAi();
                                    g.aAh().azQ().set(ar.a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, str13);
                                } else {
                                    try {
                                        jSONObject2.put(str9, 1);
                                        jSONObject2.put(String.format("%s_expiretime", str9), j3);
                                    } catch (Exception e3) {
                                        Log.printErrStackTrace("MicroMsg.MallNewsManager", e3, "put redDotConfig json failed: %s", e3.getMessage());
                                    }
                                }
                            }
                        }
                    }
                    if (!z2) {
                        com.tencent.mm.y.c.axV().c(ar.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, ar.a.USERINFO_NEW_BANDAGE_WATCHER_ME_TAB_STRING_SYNC);
                    }
                    if (!z) {
                        com.tencent.mm.y.c.axV().c(ar.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, ar.a.USERINFO_NEW_BANDAGE_WATCHER_PAY_ENTRANCE_STRING_SYNC);
                    }
                    Log.i("MicroMsg.MallNewsManager", "redDotConfig: %s", jSONObject2.toString());
                    if (jSONObject2.length() > 0) {
                        g.aAi();
                        g.aAh().azQ().set(ar.a.USERINFO_WALLET_New_MALL_UI_ITEM_REDDOT_CONFIG_STRING_SYNC, jSONObject2.toString());
                        g.aAi();
                        g.aAh().azQ().set(ar.a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.TRUE);
                    }
                }
            }
        }
        AppMethodBeat.o(70559);
    }

    public static void fSi() {
        AppMethodBeat.i(70560);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, "");
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_LQT_WALLET_RED_DOT_INT, (Object) -1);
        AppMethodBeat.o(70560);
    }

    public static void fSj() {
        AppMethodBeat.i(70561);
        Log.d("MicroMsg.MallNewsManager", "clearMallNew ");
        com.tencent.mm.y.c.axV().cQ(262156, 266248);
        AppMethodBeat.o(70561);
    }

    public final boolean eDw() {
        AppMethodBeat.i(70562);
        Log.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.Icv.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.Icv.keySet()) {
            if (!Util.isNullOrNil(str)) {
                MallNews mallNews = this.Icv.get(str);
                stringBuffer.append(mallNews.Ics.replace("</mallactivity></sysmsg>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<showflag>" + mallNews.Icl + "</showflag><newsTipFlag>" + mallNews.Icm + "</newsTipFlag></mallactivity></sysmsg>;");
            }
        }
        Log.d("MicroMsg.MallNewsManager", "save data  : " + stringBuffer.toString());
        g.aAi();
        g.aAh().azQ().set(270339, stringBuffer.toString());
        AppMethodBeat.o(70562);
        return true;
    }

    public final String aVu(String str) {
        AppMethodBeat.i(70563);
        MallNews mallNews = this.Icv.get(str);
        if (mallNews == null || Util.isNullOrNil(mallNews.dHx)) {
            AppMethodBeat.o(70563);
            return null;
        }
        String str2 = mallNews.dHx;
        AppMethodBeat.o(70563);
        return str2;
    }

    public final MallNews aVv(String str) {
        AppMethodBeat.i(70564);
        Log.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(str)));
        if (Util.isNullOrNil(str) || !this.Icv.containsKey(str)) {
            AppMethodBeat.o(70564);
            return null;
        }
        MallNews mallNews = this.Icv.get(str);
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(mallNews.Icl)) {
            mallNews.Icl = "1";
            eDw();
        }
        AppMethodBeat.o(70564);
        return mallNews;
    }

    public static MallNews aVw(String str) {
        AppMethodBeat.i(70565);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(70565);
            return null;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
        if (parseXml == null) {
            AppMethodBeat.o(70565);
            return null;
        }
        try {
            MallNews mallNews = new MallNews(parseXml.get(".sysmsg.mallactivity.functionid"));
            mallNews.FJm = parseXml.get(".sysmsg.mallactivity.activityid");
            mallNews.dHx = parseXml.get(".sysmsg.mallactivity.ticket");
            mallNews.type = parseXml.get(".sysmsg.mallactivity.type");
            mallNews.dDG = Util.getInt(parseXml.get(".sysmsg.mallactivity.showtype"), 0);
            if (parseXml.containsKey(".sysmsg.mallactivity.showflag")) {
                mallNews.Icl = parseXml.get(".sysmsg.mallactivity.showflag");
            } else {
                mallNews.Icl = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            if (parseXml.containsKey(".sysmsg.mallactivity.newsTipFlag")) {
                mallNews.Icm = parseXml.get(".sysmsg.mallactivity.newsTipFlag");
            } else {
                mallNews.Icm = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            mallNews.Ics = str;
            if (Util.isNullOrNil(mallNews.iLU)) {
                AppMethodBeat.o(70565);
                return null;
            }
            AppMethodBeat.o(70565);
            return mallNews;
        } catch (Exception e2) {
            Log.e("MicroMsg.MallNewsManager", "cmdid error");
            AppMethodBeat.o(70565);
            return null;
        }
    }

    public final void aW(ArrayList<MallFunction> arrayList) {
        AppMethodBeat.i(70566);
        if (arrayList != null) {
            HashSet<String> hashSet = new HashSet(this.Icv.keySet());
            Iterator<MallFunction> it = arrayList.iterator();
            while (it.hasNext()) {
                hashSet.remove(it.next().kHR);
            }
            for (String str : hashSet) {
                this.Icv.remove(str);
            }
            eDw();
        }
        AppMethodBeat.o(70566);
    }

    public final void aX(ArrayList<bfv> arrayList) {
        AppMethodBeat.i(214214);
        if (arrayList != null) {
            HashSet<String> hashSet = new HashSet(this.Icv.keySet());
            Iterator<bfv> it = arrayList.iterator();
            while (it.hasNext()) {
                hashSet.remove(new StringBuilder().append(it.next().LPr.Nuz).toString());
            }
            for (String str : hashSet) {
                this.Icv.remove(str);
            }
            eDw();
        }
        AppMethodBeat.o(214214);
    }
}
