package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.h;
import com.tencent.mm.pluginsdk.i.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;

public final class j {
    private static final long[] JYr = {0, 259200000, 604800000};

    public static int h(Context context, String str, String str2, String str3) {
        AppMethodBeat.i(32725);
        int a2 = h.a(g.gp(context), str, str2, str3);
        AppMethodBeat.o(32725);
        return a2;
    }

    public static void aK(Context context, int i2) {
        AppMethodBeat.i(32726);
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
        intent.putExtra("intent_extra_is_silence_stat", false);
        intent.putExtra("intent_extra_opcode", i2);
        context.sendBroadcast(intent, WeChatPermissions.PERMISSION_MM_MESSAGE());
        AppMethodBeat.o(32726);
    }

    public static void aL(Context context, int i2) {
        AppMethodBeat.i(32727);
        l(context, i2, 0);
        AppMethodBeat.o(32727);
    }

    public static void l(Context context, int i2, int i3) {
        AppMethodBeat.i(32728);
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
        intent.putExtra("intent_extra_is_silence_stat", true);
        intent.putExtra("intent_extra_opcode", i2);
        if (i2 == 2) {
            intent.putExtra("intent_extra_install_dialog_times", i3);
        }
        context.sendBroadcast(intent, WeChatPermissions.PERMISSION_MM_MESSAGE());
        AppMethodBeat.o(32728);
    }

    public static String gnt() {
        AppMethodBeat.i(32729);
        String string = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aps()).getString("update_downloaded_pack_md5_key", null);
        AppMethodBeat.o(32729);
        return string;
    }

    public static String gwm() {
        AppMethodBeat.i(32730);
        String string = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aps()).getString("update_downloaded_pack_sig_key", null);
        AppMethodBeat.o(32730);
        return string;
    }

    public static String gwn() {
        AppMethodBeat.i(32731);
        String string = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aps()).getString("update_downloaded_pack_desc_key", null);
        AppMethodBeat.o(32731);
        return string;
    }

    public static int gwo() {
        AppMethodBeat.i(32732);
        int i2 = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aps()).getInt("update_downloaded_pack_download_mode", 0);
        AppMethodBeat.o(32732);
        return i2;
    }

    public static void a(String str, String str2, String str3, int i2, int i3, int i4, String str4) {
        AppMethodBeat.i(32733);
        MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aps()).edit().putString("update_downloaded_pack_md5_key", str).putString("update_downloaded_pack_sig_key", str2).putString("update_downloaded_pack_desc_key", str3).putInt("update_downloaded_pack_size_key", i2).putInt("update_downloaded_pack_download_mode", i3).putInt("update_downloaded_pack_update_type", i4).putString("update_download_not_auto_download_range", str4).commit();
        Log.i("MicroMsg.UpdateUtil", "summerupdate putDownloadedPackInfo md5: %s size: %s range: %s", str, Integer.valueOf(i2), str4);
        AppMethodBeat.o(32733);
    }

    public static int gwp() {
        AppMethodBeat.i(32734);
        int i2 = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aps()).getInt("update_downloaded_cancel_times", 0);
        Log.i("MicroMsg.UpdateUtil", "getIgnoreDownloadedPackTimes times %s", Integer.valueOf(i2));
        AppMethodBeat.o(32734);
        return i2;
    }

    public static void gwq() {
        AppMethodBeat.i(32735);
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aps());
        int i2 = sharedPreferences.getInt("update_downloaded_cancel_times", 0);
        Log.i("MicroMsg.UpdateUtil", "putIgnoreDownloadedPack times %s", Integer.valueOf(i2));
        if (i2 >= JYr.length - 1) {
            String gnt = gnt();
            StringBuffer stringBuffer = null;
            if (!Util.isNullOrNil(gnt)) {
                String[] gwr = gwr();
                stringBuffer = new StringBuffer();
                stringBuffer.append(gnt);
                if (gwr != null) {
                    for (String str : gwr) {
                        if (!Util.isNullOrNil(str)) {
                            stringBuffer.append(":");
                            stringBuffer.append(str);
                        }
                    }
                }
            }
            sharedPreferences.edit().clear().commit();
            if (stringBuffer != null) {
                sharedPreferences.edit().putString("update_downloaded_ignored_pack", stringBuffer.toString()).commit();
            }
            AppMethodBeat.o(32735);
            return;
        }
        sharedPreferences.edit().putLong("update_downloaded_cancel_ts", System.currentTimeMillis()).putInt("update_downloaded_cancel_times", i2 + 1).commit();
        AppMethodBeat.o(32735);
    }

    public static boolean bhM(String str) {
        AppMethodBeat.i(32736);
        String[] gwr = gwr();
        if (gwr != null) {
            for (String str2 : gwr) {
                if (str2.equals(str)) {
                    AppMethodBeat.o(32736);
                    return true;
                }
            }
        }
        AppMethodBeat.o(32736);
        return false;
    }

    private static String[] gwr() {
        AppMethodBeat.i(32737);
        String string = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aps()).getString("update_downloaded_ignored_pack", null);
        if (Util.isNullOrNil(string)) {
            AppMethodBeat.o(32737);
            return null;
        }
        String[] split = string.split(":");
        AppMethodBeat.o(32737);
        return split;
    }

    public static void gws() {
        AppMethodBeat.i(32738);
        MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aps()).edit().putLong("update_downloading_in_silence", System.currentTimeMillis()).putBoolean("update_download_start_one_immediate", false).commit();
        Log.i("MicroMsg.UpdateUtil", "putDowningInSilence");
        AppMethodBeat.o(32738);
    }

    public static void gwt() {
        AppMethodBeat.i(32739);
        MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aps()).edit().putBoolean("update_download_start_one_immediate", true).commit();
        Log.i("MicroMsg.UpdateUtil", "putOneDownloadTask");
        AppMethodBeat.o(32739);
    }

    public static void gwu() {
        AppMethodBeat.i(32740);
        MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aps()).edit().remove("update_downloading_in_silence").commit();
        Log.i("MicroMsg.UpdateUtil", "removeUnfinishDownloadingInSilence");
        AppMethodBeat.o(32740);
    }

    public static void gwv() {
        AppMethodBeat.i(32741);
        MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aps()).edit().clear().commit();
        Log.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
        AppMethodBeat.o(32741);
    }

    public static long L(String str, long j2, long j3) {
        AppMethodBeat.i(32742);
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_flowstat_prefs", com.tencent.mm.compatible.util.g.aps());
        long j4 = sharedPreferences.getLong(str, 0);
        Log.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flowUp %s, flowDown %s", str, Long.valueOf(j2), Long.valueOf(j3));
        Log.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flow %s", str, Long.valueOf(j4));
        long j5 = j4 + j2 + j3;
        sharedPreferences.edit().putLong(str, j5).commit();
        AppMethodBeat.o(32742);
        return j5;
    }

    public static long bhN(String str) {
        AppMethodBeat.i(32743);
        long j2 = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_flowstat_prefs", com.tencent.mm.compatible.util.g.aps()).getLong(str, 0);
        Log.i("MicroMsg.UpdateUtil", "getPackFlowStat pack %s, flow %s", str, Long.valueOf(j2));
        AppMethodBeat.o(32743);
        return j2;
    }
}
