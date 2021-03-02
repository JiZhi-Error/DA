package com.tencent.mm.sdcard_migrate;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.io.File;

public final class b {
    private static final Boolean[] NHz = {null};

    public static boolean bhQ(String str) {
        AppMethodBeat.i(176862);
        boolean z = MultiProcessMMKV.getMMKV("extmig_status_memo_storage").getBoolean("key_is_migrated_" + Wr(str), false);
        AppMethodBeat.o(176862);
        return z;
    }

    static void bhR(String str) {
        AppMethodBeat.i(176863);
        MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_is_migrated_" + Wr(str), true);
        AppMethodBeat.o(176863);
    }

    public static boolean gwY() {
        AppMethodBeat.i(176864);
        boolean z = MultiProcessMMKV.getMMKV("extmig_status_memo_storage").getBoolean("key_is_olddata_ignored_v2", false);
        AppMethodBeat.o(176864);
        return z;
    }

    static void ju(Context context) {
        AppMethodBeat.i(176865);
        if (jv(context)) {
            ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateStatus", "[+] Mark newly installed in process: %s", d.cQi);
            MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_is_olddata_ignored_v2", true);
        }
        AppMethodBeat.o(176865);
    }

    public static boolean gwZ() {
        AppMethodBeat.i(197161);
        boolean z = MultiProcessMMKV.getMMKV("extmig_status_memo_storage").getBoolean("key_indicate_goon_by_migrate_routine", false);
        AppMethodBeat.o(197161);
        return z;
    }

    static void gxa() {
        AppMethodBeat.i(197162);
        MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_goon_by_migrate_routine", true);
        AppMethodBeat.o(197162);
    }

    static void gxb() {
        AppMethodBeat.i(197163);
        MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_goon_by_migrate_routine", false);
        AppMethodBeat.o(197163);
    }

    static void gxc() {
        AppMethodBeat.i(197164);
        MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_migrating_by_migrate_routine", true);
        AppMethodBeat.o(197164);
    }

    static void gxd() {
        AppMethodBeat.i(197165);
        MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_migrating_by_migrate_routine", false);
        AppMethodBeat.o(197165);
    }

    public static boolean gxe() {
        AppMethodBeat.i(197166);
        boolean z = MultiProcessMMKV.getMMKV("extmig_status_memo_storage").getBoolean("key_indicate_rescan_needed_by_migrate_routine", false);
        AppMethodBeat.o(197166);
        return z;
    }

    static void gxf() {
        AppMethodBeat.i(197167);
        MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_rescan_needed_by_migrate_routine", true);
        AppMethodBeat.o(197167);
    }

    static void gxg() {
        AppMethodBeat.i(197168);
        MultiProcessMMKV.getMMKV("extmig_status_memo_storage").encode("key_indicate_rescan_needed_by_migrate_routine", false);
        AppMethodBeat.o(197168);
    }

    private static boolean jv(Context context) {
        AppMethodBeat.i(176866);
        if (new File(com.tencent.mm.loader.j.b.aKB(), "version_history.cfg").exists()) {
            AppMethodBeat.o(176866);
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo.firstInstallTime == packageInfo.lastUpdateTime) {
                AppMethodBeat.o(176866);
                return true;
            }
            AppMethodBeat.o(176866);
            return false;
        } catch (Throwable th) {
            AppMethodBeat.o(176866);
            return true;
        }
    }

    public static void gxh() {
        AppMethodBeat.i(176868);
        AppMethodBeat.o(176868);
    }

    private static String Wr(String str) {
        AppMethodBeat.i(176869);
        File file = new File(str);
        try {
            String canonicalPath = file.getCanonicalPath();
            AppMethodBeat.o(176869);
            return canonicalPath;
        } catch (Throwable th) {
            ExtStorageMigrateMonitor.gwK().printErrStackTrace("MicroMsg.ExtStorageMigrateStatus", th, "[-] Fail to get canonical path for: %s", str);
            String absolutePath = file.getAbsolutePath();
            AppMethodBeat.o(176869);
            return absolutePath;
        }
    }
}
