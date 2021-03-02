package com.tencent.mm.plugin.expt.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class d {
    private static String TAG = "MicroMsg.ExptManager";
    private static d sLo;
    private static final f<Integer, Long> sLp = new h(50);
    private String name = null;
    private f<Integer, c> sJZ = new h(50);

    static {
        AppMethodBeat.i(215270);
        AppMethodBeat.o(215270);
    }

    public static d cRY() {
        AppMethodBeat.i(156048);
        if (sLo == null) {
            sLo = new d();
        }
        d dVar = sLo;
        AppMethodBeat.o(156048);
        return dVar;
    }

    protected d() {
        AppMethodBeat.i(156049);
        AppMethodBeat.o(156049);
    }

    public static boolean HB(int i2) {
        AppMethodBeat.i(182039);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("WxExptConfig");
        if (mmkv != null) {
            boolean commit = mmkv.putInt("expt_uin", i2).commit();
            AppMethodBeat.o(182039);
            return commit;
        }
        AppMethodBeat.o(182039);
        return false;
    }

    public final MultiProcessMMKV aTI() {
        AppMethodBeat.i(156050);
        int uin = getUin();
        if (uin == 0) {
            AppMethodBeat.o(156050);
            return null;
        }
        String str = uin + "_WxExptmmkv";
        if (!Util.isEqual(this.name, str)) {
            Log.i(TAG, "%s get mmkv change uin old[%s] new[%s]", info(), this.name, str);
            this.name = str;
        }
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(this.name);
        AppMethodBeat.o(156050);
        return mmkv;
    }

    private int ari(String str) {
        AppMethodBeat.i(156051);
        MultiProcessMMKV aTI = aTI();
        if (aTI == null) {
            AppMethodBeat.o(156051);
            return -1;
        }
        int i2 = aTI.getInt(str, -1);
        AppMethodBeat.o(156051);
        return i2;
    }

    private c HC(int i2) {
        AppMethodBeat.i(156052);
        if (i2 <= 0) {
            AppMethodBeat.o(156052);
            return null;
        }
        MultiProcessMMKV aTI = aTI();
        if (aTI == null) {
            AppMethodBeat.o(156052);
            return null;
        }
        String string = aTI.getString(String.valueOf(i2), "");
        if (Util.isNullOrNil(string)) {
            AppMethodBeat.o(156052);
            return null;
        }
        c cVar = this.sJZ.get(Integer.valueOf(i2));
        if (cVar != null) {
            if (Util.isEqual(string, cVar.field_exptContent)) {
                AppMethodBeat.o(156052);
                return cVar;
            }
            this.sJZ.remove(Integer.valueOf(i2));
        }
        c cVar2 = new c();
        if (cVar2.TN(string)) {
            this.sJZ.put(Integer.valueOf(i2), cVar2);
        } else {
            cVar2 = null;
        }
        AppMethodBeat.o(156052);
        return cVar2;
    }

    public final String gA(String str, String str2) {
        AppMethodBeat.i(156053);
        String b2 = b(str, str2, false, true);
        AppMethodBeat.o(156053);
        return b2;
    }

    public final String b(String str, String str2, boolean z, boolean z2) {
        String str3;
        c HC;
        HashMap<String, String> cRH;
        AppMethodBeat.i(156054);
        PString pString = new PString();
        if (b.cRI().a(str, str2, pString) > 0) {
            String str4 = pString.value;
            AppMethodBeat.o(156054);
            return str4;
        }
        long currentTicks = Util.currentTicks();
        int ari = ari(str);
        if (ari <= 0 || (HC = HC(ari)) == null || !HC.isReady() || (cRH = HC.cRH()) == null || cRH.isEmpty()) {
            str3 = str2;
        } else {
            str3 = cRH.get(str);
            if (z || HC.cRU()) {
                a(HC, str, str3);
            }
        }
        if (str3 == null) {
            str3 = str2;
        }
        if (z2) {
            Log.i(TAG, "%s get mulit expt result[%s] key[%s] def[%s] cost[%d]", info(), str3, str, str2, Long.valueOf(Util.ticksToNow(currentTicks)));
        }
        AppMethodBeat.o(156054);
        return str3;
    }

    private static boolean a(c cVar, String str, String str2) {
        long j2;
        AppMethodBeat.i(215269);
        String format = String.format("%d,%d,%d,%d,%d,%s,%s", Integer.valueOf(cVar.field_exptId), Integer.valueOf(cVar.field_groupId), Integer.valueOf(cVar.field_exptSeq), Long.valueOf(cVar.field_startTime), Long.valueOf(cVar.field_endTime), str, str2);
        int hashCode = format.hashCode();
        Long l = sLp.get(Integer.valueOf(hashCode));
        if (l != null) {
            j2 = l.longValue();
        } else {
            j2 = 0;
        }
        if (Util.milliSecondsToNow(j2) < 300000) {
            Log.v(TAG, "clock report [%s] less than 5 min, don't report", format);
            AppMethodBeat.o(215269);
            return false;
        }
        sLp.put(Integer.valueOf(hashCode), Long.valueOf(Util.nowMilliSecond()));
        e.INSTANCE.a(15452, Integer.valueOf(cVar.field_exptId), Integer.valueOf(cVar.field_groupId), Integer.valueOf(cVar.field_exptSeq), Long.valueOf(cVar.field_startTime), Long.valueOf(cVar.field_endTime), str, str2);
        AppMethodBeat.o(215269);
        return true;
    }

    private String info() {
        AppMethodBeat.i(156056);
        String sb = new StringBuilder().append(hashCode()).toString();
        AppMethodBeat.o(156056);
        return sb;
    }

    public static int getUin() {
        AppMethodBeat.i(182040);
        int i2 = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", g.aps()).getInt("default_uin", 0);
        if (i2 != 0) {
            AppMethodBeat.o(182040);
            return i2;
        }
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("WxExptConfig");
        if (mmkv != null) {
            int i3 = mmkv.getInt("expt_uin", 0);
            AppMethodBeat.o(182040);
            return i3;
        }
        AppMethodBeat.o(182040);
        return 0;
    }
}
