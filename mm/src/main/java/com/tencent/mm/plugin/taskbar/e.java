package com.tencent.mm.plugin.taskbar;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e {
    private static boolean FRZ = false;
    public static c Vbm;
    public static c Vbn;

    static {
        AppMethodBeat.i(263663);
        c.a aVar = new c.a();
        aVar.hZA = 512;
        aVar.hZz = 512;
        aVar.jbi = 5;
        aVar.jbf = true;
        aVar.jbd = true;
        Vbm = aVar.bdv();
        c.a aVar2 = new c.a();
        aVar2.hZA = 512;
        aVar2.hZz = 512;
        aVar2.jbi = 1;
        aVar2.jbd = true;
        Vbn = aVar2.bdv();
        AppMethodBeat.o(263663);
    }

    public static boolean atB() {
        AppMethodBeat.i(238099);
        Log.d("MicroMsg.TaskBarConfig", "alvinluo isEnableNativeDynamicBackground %b, thread: %d", Boolean.valueOf(FRZ), Long.valueOf(Thread.currentThread().getId()));
        boolean z = FRZ;
        AppMethodBeat.o(238099);
        return z;
    }

    public static void wj(boolean z) {
        SharedPreferences defaultPreference;
        AppMethodBeat.i(238100);
        Log.i("MicroMsg.TaskBarConfig", "alvinluo setEnableNativeDynamicBackground enable: %b", Boolean.valueOf(z));
        if (!(FRZ == z || (defaultPreference = MMApplicationContext.getDefaultPreference()) == null)) {
            defaultPreference.edit().putBoolean("enable_dynamic_background", z).apply();
        }
        FRZ = z;
        AppMethodBeat.o(238100);
    }

    public static void fur() {
        boolean z;
        AppMethodBeat.i(238101);
        SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
        if (defaultPreference == null) {
            AppMethodBeat.o(238101);
            return;
        }
        boolean z2 = defaultPreference.getBoolean("enable_dynamic_background_for_test", false);
        if (z2) {
            Log.i("MicroMsg.TaskBarConfig", "alvinluo initEnableNativeDynamicBackground enableForTest: %b", Boolean.valueOf(z2));
            FRZ = true;
            wj(true);
            com.tencent.mm.plugin.taskbar.ui.a.c.fvc();
            AppMethodBeat.o(238101);
            return;
        }
        boolean z3 = defaultPreference.getBoolean("enable_dynamic_background", true);
        boolean z4 = ((b) g.af(b.class)).a(b.a.clicfg_multitask_taskbar_enable_dynamic_bg, 0) == 1;
        Log.i("MicroMsg.TaskBarConfig", "dynamicbg enable state: %b %b", Boolean.valueOf(z3), Boolean.valueOf(z4));
        if (!z3 || !z4) {
            z = false;
        } else {
            z = true;
        }
        FRZ = z;
        boolean fvb = com.tencent.mm.plugin.taskbar.ui.a.c.fvb();
        if (fvb) {
            int i2 = defaultPreference.getInt("dynamic_background_version", -1);
            Log.i("MicroMsg.TaskBarConfig", "alvinluo localVersion %d, currentVersion: %d", Integer.valueOf(i2), 1);
            if (i2 != 1) {
                Log.i("MicroMsg.TaskBarConfig", "alvinluo ignore crash because of new version", Integer.valueOf(i2), 1);
                defaultPreference.edit().putInt("dynamic_background_version", 1).apply();
                com.tencent.mm.plugin.taskbar.ui.a.c.fvc();
                wj(true);
                fvb = false;
            } else {
                Log.i("MicroMsg.TaskBarConfig", "alvinluo disable dynamicBackground because of crash");
                wj(false);
            }
        }
        Log.i("MicroMsg.TaskBarConfig", "alvinluo AppBrandDesktopConfig initEnableNativeDynamicBackground: %b, willCrash: %b", Boolean.valueOf(FRZ), Boolean.valueOf(fvb));
        AppMethodBeat.o(238101);
    }
}
