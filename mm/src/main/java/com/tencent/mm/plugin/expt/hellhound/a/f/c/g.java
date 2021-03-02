package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class g {
    public static void aqK(String str) {
        String str2;
        AppMethodBeat.i(122157);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(122157);
            return;
        }
        String cQv = cQv();
        if (cQv == null || cQv.isEmpty()) {
            aqL(System.currentTimeMillis() + "@" + str);
            AppMethodBeat.o(122157);
        } else if ("-1".equals(cQv)) {
            Log.e("HABBYGE-MALI.HellSessionReportCache", "storeFlow not login");
            AppMethodBeat.o(122157);
        } else {
            if (cQv.split("@").length <= 1) {
                str2 = cQv + "@" + str;
            } else {
                str2 = cQv + "|" + str;
            }
            aqL(str2);
            AppMethodBeat.o(122157);
        }
    }

    public static void aqL(String str) {
        AppMethodBeat.i(122158);
        int uin = b.getUin();
        if (uin == 0) {
            AppMethodBeat.o(122158);
            return;
        }
        if (str == null) {
            str = "";
        }
        try {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.putString("mmkv_key_hellSenubARptChe_".concat(String.valueOf(uin)), str);
            AppMethodBeat.o(122158);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionReportCache", e2, "writeBackOfSessionUBA.writeBackOfFlow", new Object[0]);
            AppMethodBeat.o(122158);
        }
    }

    public static String cQv() {
        AppMethodBeat.i(122159);
        int uin = b.getUin();
        if (uin == 0) {
            AppMethodBeat.o(122159);
            return "-1";
        }
        String string = com.tencent.mm.plugin.expt.hellhound.core.a.b.getString("mmkv_key_hellSenubARptChe_".concat(String.valueOf(uin)));
        if (string == null || string.isEmpty()) {
            AppMethodBeat.o(122159);
            return null;
        }
        AppMethodBeat.o(122159);
        return string;
    }

    public static void Dw(long j2) {
        AppMethodBeat.i(184376);
        String valueOf = String.valueOf(j2);
        int uin = b.getUin();
        if (uin != 0) {
            if (valueOf == null) {
                valueOf = "";
            }
            try {
                com.tencent.mm.plugin.expt.hellhound.core.a.b.putString("mmkv_key_hellSenPageMegRptChe_".concat(String.valueOf(uin)), valueOf);
                AppMethodBeat.o(184376);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.HellSessionReportCache", e2, "HellSessionReportCache.writeBackOfMerge", new Object[0]);
            }
        }
        AppMethodBeat.o(184376);
    }

    public static void aqM(String str) {
        AppMethodBeat.i(122163);
        int uin = b.getUin();
        if (uin == 0) {
            AppMethodBeat.o(122163);
            return;
        }
        if (str == null) {
            str = "";
        }
        try {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.putString("mmkv_key_hellsess_dtail_RptChe_".concat(String.valueOf(uin)), str);
            AppMethodBeat.o(122163);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionReportCache", e2, "HellSessionReportCache.writeBackOfFlow", new Object[0]);
            AppMethodBeat.o(122163);
        }
    }

    public static String cQx() {
        AppMethodBeat.i(122164);
        int uin = b.getUin();
        if (uin == 0) {
            AppMethodBeat.o(122164);
            return "-1";
        }
        String string = com.tencent.mm.plugin.expt.hellhound.core.a.b.getString("mmkv_key_hellsess_dtail_RptChe_".concat(String.valueOf(uin)));
        if (string == null || string.isEmpty()) {
            AppMethodBeat.o(122164);
            return null;
        }
        AppMethodBeat.o(122164);
        return string;
    }

    public static void aqN(String str) {
        AppMethodBeat.i(122165);
        int uin = b.getUin();
        if (uin == 0) {
            AppMethodBeat.o(122165);
            return;
        }
        if (str == null) {
            str = "";
        }
        try {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.putString("mmkv_key_hellsess_merge_RptChe_".concat(String.valueOf(uin)), str);
            AppMethodBeat.o(122165);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionReportCache", e2, "HellSessionReportCache.writeBackOfFlow", new Object[0]);
            AppMethodBeat.o(122165);
        }
    }

    public static String cQy() {
        AppMethodBeat.i(122166);
        int uin = b.getUin();
        if (uin == 0) {
            AppMethodBeat.o(122166);
            return "-1";
        }
        String string = com.tencent.mm.plugin.expt.hellhound.core.a.b.getString("mmkv_key_hellsess_merge_RptChe_".concat(String.valueOf(uin)));
        if (string == null || string.isEmpty()) {
            AppMethodBeat.o(122166);
            return null;
        }
        AppMethodBeat.o(122166);
        return string;
    }

    public static String cQw() {
        String string;
        AppMethodBeat.i(122162);
        int uin = b.getUin();
        if (uin == 0) {
            string = "-1";
        } else {
            string = com.tencent.mm.plugin.expt.hellhound.core.a.b.getString("mmkv_key_hellSenPageMegRptChe_".concat(String.valueOf(uin)));
            if (string == null || string.isEmpty()) {
                string = null;
            }
        }
        String aqJ = d.aqJ(string);
        AppMethodBeat.o(122162);
        return aqJ;
    }
}
