package com.tencent.mm.pluginsdk.i;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.List;

public final class g {
    private static final long[] JYr = {0, 259200000, 604800000};
    private static String ynA = "tinker-boots-install-info";
    private static String ynB = "tinker-boots-last-show";
    private static String ynC = "tinker-boots-show-time";
    private static String ynD = "";

    public static String gnt() {
        AppMethodBeat.i(31139);
        String string = MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.aps()).getString("update_downloaded_pack_md5_key", null);
        AppMethodBeat.o(31139);
        return string;
    }

    public static int gnu() {
        AppMethodBeat.i(31140);
        int i2 = MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.aps()).getInt("update_downloaded_pack_update_type", 3);
        AppMethodBeat.o(31140);
        return i2;
    }

    public static boolean gnv() {
        AppMethodBeat.i(31141);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.aps());
        long j2 = sharedPreferences.getLong("update_downloaded_cancel_ts", 0);
        int i2 = sharedPreferences.getInt("update_downloaded_cancel_times", 0);
        Log.i("MicroMsg.UpdateUtil", "checkIgnoreDownloadedPack last: %s times: %s", Long.valueOf(j2), Integer.valueOf(i2));
        if (i2 > JYr.length - 1) {
            AppMethodBeat.o(31141);
            return true;
        }
        if (System.currentTimeMillis() - j2 > JYr[i2]) {
            AppMethodBeat.o(31141);
            return false;
        } else if (System.currentTimeMillis() - j2 < 0) {
            Log.e("MicroMsg.UpdateUtil", "user modify mobile time. we just remove the config.");
            MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.aps()).edit().clear().commit();
            Log.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
            AppMethodBeat.o(31141);
            return true;
        } else {
            AppMethodBeat.o(31141);
            return true;
        }
    }

    public static boolean gnw() {
        AppMethodBeat.i(31142);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.aps());
        long j2 = sharedPreferences.getLong("update_downloading_in_silence", 0);
        boolean z = sharedPreferences.getBoolean("update_download_start_one_immediate", false);
        Log.i("MicroMsg.UpdateUtil", "hasUnfinishDownloadingInSilence unfinish %s", Long.valueOf(j2));
        if (z || (j2 != 0 && System.currentTimeMillis() - j2 > Util.MILLSECONDS_OF_HOUR)) {
            AppMethodBeat.o(31142);
            return true;
        }
        AppMethodBeat.o(31142);
        return false;
    }

    public static String iw(Context context) {
        AppMethodBeat.i(31143);
        String gp = gp(context);
        if (gp == null || !new o(gp).exists()) {
            AppMethodBeat.o(31143);
            return null;
        }
        a fO = a.fO(gp);
        if (fO == null || fO.djf == null) {
            String bhK = s.bhK(gp);
            AppMethodBeat.o(31143);
            return bhK;
        }
        String str = fO.djf.apkMd5;
        AppMethodBeat.o(31143);
        return str;
    }

    public static String gp(Context context) {
        AppMethodBeat.i(31144);
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
            AppMethodBeat.o(31144);
            return str;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.UpdateUtil", e2, "", new Object[0]);
            AppMethodBeat.o(31144);
            return null;
        }
    }

    public static void aZ(Context context, String str) {
        AppMethodBeat.i(31145);
        r.b(context, str, null, false);
        AppMethodBeat.o(31145);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.protocal.protobuf.eht gnx() {
        /*
            r1 = 0
            r5 = 0
            r6 = 31146(0x79aa, float:4.3645E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            android.content.Context r0 = com.tencent.mm.sdk.platformtools.MMApplicationContext.getContext()
            java.lang.String r2 = "tinker_patch_share_config"
            int r3 = com.tencent.mm.compatible.util.g.aps()
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r2, r3)
            java.lang.String r2 = com.tencent.mm.pluginsdk.i.g.ynA
            java.lang.String r3 = ""
            java.lang.String r0 = r0.getString(r2, r3)
            boolean r2 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0)
            if (r2 != 0) goto L_0x005a
            com.tencent.mm.protocal.protobuf.eht r2 = new com.tencent.mm.protocal.protobuf.eht     // Catch:{ Exception -> 0x003b }
            r2.<init>()     // Catch:{ Exception -> 0x003b }
            r3 = 0
            byte[] r0 = android.util.Base64.decode(r0, r3)     // Catch:{ Exception -> 0x0058 }
            com.tencent.mm.bw.a r0 = r2.parseFrom(r0)     // Catch:{ Exception -> 0x0058 }
            com.tencent.mm.protocal.protobuf.eht r0 = (com.tencent.mm.protocal.protobuf.eht) r0     // Catch:{ Exception -> 0x0058 }
        L_0x0035:
            if (r0 == 0) goto L_0x004a
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
        L_0x003a:
            return r0
        L_0x003b:
            r0 = move-exception
            r2 = r1
        L_0x003d:
            java.lang.String r3 = "MicroMsg.UpdateUtil"
            java.lang.String r4 = "parse tinker install failed."
            java.lang.Object[] r5 = new java.lang.Object[r5]
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(r3, r0, r4, r5)
            r0 = r2
            goto L_0x0035
        L_0x004a:
            java.lang.String r0 = "MicroMsg.UpdateUtil"
            java.lang.String r2 = "update info is null."
            com.tencent.mm.sdk.platformtools.Log.i(r0, r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            r0 = r1
            goto L_0x003a
        L_0x0058:
            r0 = move-exception
            goto L_0x003d
        L_0x005a:
            r0 = r1
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.i.g.gnx():com.tencent.mm.protocal.protobuf.eht");
    }

    public static boolean gny() {
        AppMethodBeat.i(31147);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", com.tencent.mm.compatible.util.g.aps());
        long j2 = sharedPreferences.getLong(ynB, 0);
        int i2 = sharedPreferences.getInt(ynC, 0);
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("MicroMsg.UpdateUtil", "isNeedShowTinkerDialog now:%d last:%d time:%d", Long.valueOf(currentTimeMillis), Long.valueOf(j2), Integer.valueOf(i2));
        if (currentTimeMillis - j2 <= 21600000 || i2 >= 3) {
            AppMethodBeat.o(31147);
            return false;
        }
        AppMethodBeat.o(31147);
        return true;
    }

    public static void gnz() {
        AppMethodBeat.i(31148);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", com.tencent.mm.compatible.util.g.aps());
        sharedPreferences.edit().putLong(ynB, System.currentTimeMillis()).apply();
        sharedPreferences.edit().putInt(ynC, sharedPreferences.getInt(ynC, 0) + 1).apply();
        AppMethodBeat.o(31148);
    }

    public static String[] getShortIps() {
        AppMethodBeat.i(31149);
        if (ac.jOk == null || ac.jOk.length() <= 0) {
            String string = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
            if (string == null || string.length() <= 0) {
                string = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
            }
            List<com.tencent.mm.protocal.o> bgd = com.tencent.mm.protocal.o.bgd(string);
            String[] strArr = new String[bgd.size()];
            for (int i2 = 0; i2 < bgd.size(); i2++) {
                strArr[i2] = bgd.get(i2).yFq;
            }
            AppMethodBeat.o(31149);
            return strArr;
        }
        String[] strArr2 = {ac.jOk};
        AppMethodBeat.o(31149);
        return strArr2;
    }
}
