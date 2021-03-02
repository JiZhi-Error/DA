package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.recovery.wx.util.WXUtil;

public final class af {
    private static boolean hasInit = false;
    private static af jFH;
    private static boolean jFP = false;
    private static a jFQ = null;
    private v glb;
    private MMHandler handler;
    private ag jFI;
    private ah jFJ;
    private Context jFK;
    private b jFL;
    private ae jFM;
    private ad jFN;
    private ab jFO;

    public interface a {
        void F(int i2, long j2);

        void K(String str, long j2);
    }

    public interface b {
        void df(boolean z);
    }

    private af() {
    }

    private static af bkc() {
        AppMethodBeat.i(132907);
        if (jFH == null) {
            jFH = new af();
        }
        af afVar = jFH;
        AppMethodBeat.o(132907);
        return afVar;
    }

    private static SharedPreferences bkd() {
        AppMethodBeat.i(132908);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("notify_key_pref_no_account", g.aps());
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("notify_key_pref_no_account");
        MultiProcessMMKV.transport2MMKV(sharedPreferences, mmkv);
        AppMethodBeat.o(132908);
        return mmkv;
    }

    public static SharedPreferences bke() {
        AppMethodBeat.i(132909);
        String string = bkd().getString(WXUtil.LAST_LOGIN_WEXIN_USERNAME, "");
        if (Util.isNullOrNil(string)) {
            string = bf.iDu.aA(WXUtil.LAST_LOGIN_WEXIN_USERNAME, "");
            if (!Util.isNullOrNil(string)) {
                bkd().edit().putString(WXUtil.LAST_LOGIN_WEXIN_USERNAME, string).commit();
            }
        }
        if (string != null) {
            string = string.replace("[\\/\\\\]", "#").trim();
        }
        String concat = "notify_key_pref".concat(String.valueOf(string));
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(concat);
        MultiProcessMMKV.transport2MMKV(MMApplicationContext.getContext().getSharedPreferences(concat, g.aps()), mmkv);
        AppMethodBeat.o(132909);
        return mmkv;
    }

    public static void bkf() {
        AppMethodBeat.i(132910);
        if (!hasInit) {
            SharedPreferences bke = bke();
            long j2 = bke.getLong("wakeup_alarm_last_tick", 0);
            int i2 = bke.getInt("wakeup_alarm_last_cnt", 0);
            if (j2 == 0 || j2 > Util.nowMilliSecond()) {
                Log.i("MicroMsg.MMPushCore", "dealWithOnCreate, invalid time, thisCnt:%d", Integer.valueOf(i2));
                bke.edit().putLong("wakeup_alarm_last_tick", Util.nowMilliSecond()).commit();
                bke.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
                AppMethodBeat.o(132910);
                return;
            } else if (Util.milliSecondsToNow(j2) > Util.MILLSECONDS_OF_DAY) {
                bke.edit().putInt("wakeup_alarm_launch_cnt", i2).commit();
                bke.edit().putLong("wakeup_alarm_last_tick", Util.nowMilliSecond()).commit();
                bke.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
                Log.i("MicroMsg.MMPushCore", "dealWithOnCreate, statistics cycle expire, thisCnt:%d", Integer.valueOf(i2));
            } else {
                bke.edit().putInt("wakeup_alarm_last_cnt", i2 + 1).commit();
                Log.i("MicroMsg.MMPushCore", "dealWithOnCreate, add up launch count to:%d", Integer.valueOf(i2 + 1));
            }
        }
        hasInit = true;
        AppMethodBeat.o(132910);
    }

    public static boolean bkg() {
        AppMethodBeat.i(132911);
        String aA = bf.iDu.aA(WXUtil.LAST_LOGIN_USERNAME, "");
        if (aA != null) {
            aA = aA.replaceAll("[/\\\\]", "#").trim();
        }
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("notify_key_pref".concat(String.valueOf(aA)), g.aps());
        int i2 = sharedPreferences.getInt("wakeup_alarm_launch_cnt", 0);
        int i3 = sharedPreferences.getInt("wakeup_alarm_last_cnt", 0);
        Log.i("MicroMsg.MMPushCore", "isFrequentlyLaunch cnt:%d, thisCnt:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        boolean z = (i3 > 10) | (i2 > 10);
        AppMethodBeat.o(132911);
        return z;
    }

    public static ag bkh() {
        AppMethodBeat.i(132912);
        ag agVar = bkc().jFI;
        AppMethodBeat.o(132912);
        return agVar;
    }

    public static void a(ag agVar) {
        AppMethodBeat.i(132913);
        bkc().jFI = agVar;
        AppMethodBeat.o(132913);
    }

    public static ah bki() {
        AppMethodBeat.i(132914);
        ah ahVar = bkc().jFJ;
        AppMethodBeat.o(132914);
        return ahVar;
    }

    public static void a(ah ahVar) {
        AppMethodBeat.i(132915);
        bkc().jFJ = ahVar;
        AppMethodBeat.o(132915);
    }

    public static Context getContext() {
        AppMethodBeat.i(132916);
        Context context = bkc().jFK;
        AppMethodBeat.o(132916);
        return context;
    }

    public static void setContext(Context context) {
        AppMethodBeat.i(132917);
        bkc().jFK = context;
        AppMethodBeat.o(132917);
    }

    public static MMHandler bkj() {
        AppMethodBeat.i(132918);
        MMHandler mMHandler = bkc().handler;
        AppMethodBeat.o(132918);
        return mMHandler;
    }

    public static void a(MMHandler mMHandler) {
        AppMethodBeat.i(132919);
        bkc().handler = mMHandler;
        AppMethodBeat.o(132919);
    }

    public static b bkk() {
        AppMethodBeat.i(132920);
        b bVar = bkc().jFL;
        AppMethodBeat.o(132920);
        return bVar;
    }

    public static void a(b bVar) {
        AppMethodBeat.i(132921);
        bkc().jFL = bVar;
        AppMethodBeat.o(132921);
    }

    public static v bkl() {
        AppMethodBeat.i(132922);
        v vVar = bkc().glb;
        AppMethodBeat.o(132922);
        return vVar;
    }

    public static void g(v vVar) {
        AppMethodBeat.i(132923);
        bkc().glb = vVar;
        AppMethodBeat.o(132923);
    }

    public static ae bkm() {
        AppMethodBeat.i(132924);
        ae aeVar = bkc().jFM;
        AppMethodBeat.o(132924);
        return aeVar;
    }

    public static void a(ae aeVar) {
        AppMethodBeat.i(132925);
        bkc().jFM = aeVar;
        AppMethodBeat.o(132925);
    }

    public static ad bkn() {
        AppMethodBeat.i(132926);
        ad adVar = bkc().jFN;
        AppMethodBeat.o(132926);
        return adVar;
    }

    public static void a(ad adVar) {
        AppMethodBeat.i(132927);
        bkc().jFN = adVar;
        AppMethodBeat.o(132927);
    }

    public static ab bko() {
        AppMethodBeat.i(132929);
        ab abVar = bkc().jFO;
        AppMethodBeat.o(132929);
        return abVar;
    }

    public static void a(ab abVar) {
        AppMethodBeat.i(132930);
        bkc().jFO = abVar;
        AppMethodBeat.o(132930);
    }

    public static void a(a aVar) {
        jFQ = aVar;
    }

    public static a bkp() {
        return jFQ;
    }
}
