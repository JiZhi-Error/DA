package com.tencent.mm.plugin.taskbar.ui.a;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c {
    private static boolean FVb = false;
    private static boolean FVc = false;
    private static boolean FVd = true;
    private static SharedPreferences sp = MMApplicationContext.getDefaultPreference();

    static {
        AppMethodBeat.i(238312);
        AppMethodBeat.o(238312);
    }

    public static boolean atJ() {
        return FVd;
    }

    public static boolean fvb() {
        AppMethodBeat.i(238304);
        if (sp != null) {
            int i2 = sp.getInt("dynamic_bg_init_start_point_count", 0);
            int i3 = sp.getInt("dynamic_bg_draw_start_point_count", 0);
            boolean z = sp.getBoolean("dynamic_bg_init_crash", false);
            FVc = z;
            if (z || i2 >= 2 || i3 >= 2) {
                FVb = true;
                sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
                AppMethodBeat.o(238304);
                return true;
            }
            FVb = false;
            AppMethodBeat.o(238304);
            return false;
        }
        AppMethodBeat.o(238304);
        return false;
    }

    public static void fvc() {
        SharedPreferences.Editor edit;
        AppMethodBeat.i(238305);
        if (!(sp == null || (edit = sp.edit()) == null)) {
            edit.putInt("dynamic_bg_init_start_point_count", 0);
            edit.putInt("dynamic_bg_draw_start_point_count", 0);
            edit.putBoolean("dynamic_bg_init_crash", false);
            edit.putBoolean("dynamic_bg_will_crash", false);
            edit.apply();
        }
        FVc = false;
        FVb = false;
        AppMethodBeat.o(238305);
    }

    public static void fvd() {
        AppMethodBeat.i(238306);
        Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitCrash");
        e.wj(false);
        if (sp == null) {
            sp = MMApplicationContext.getDefaultPreference();
        }
        if (sp != null) {
            sp.edit().putBoolean("dynamic_bg_init_crash", true).apply();
        }
        FVc = true;
        AppMethodBeat.o(238306);
    }

    public static void atF() {
        AppMethodBeat.i(238307);
        Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markWillCrash");
        if (sp == null) {
            sp = MMApplicationContext.getDefaultPreference();
        }
        if (sp != null) {
            e.wj(false);
            sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
        }
        FVb = true;
        AppMethodBeat.o(238307);
    }

    public static boolean atI() {
        return FVc;
    }

    public static void fve() {
        AppMethodBeat.i(238308);
        if (sp == null) {
            sp = MMApplicationContext.getDefaultPreference();
        }
        if (sp != null) {
            int i2 = sp.getInt("dynamic_bg_init_start_point_count", 0);
            Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitStartPoint current: %d", Integer.valueOf(i2));
            if (i2 > 2) {
                e.wj(false);
                sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
            }
            sp.edit().putInt("dynamic_bg_init_start_point_count", i2 + 1).apply();
        }
        AppMethodBeat.o(238308);
    }

    public static void fvf() {
        AppMethodBeat.i(238309);
        Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitEndPoint");
        sp.edit().putInt("dynamic_bg_init_start_point_count", 0).apply();
        sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
        sp.edit().putBoolean("dynamic_bg_init_crash", false).apply();
        FVb = false;
        FVc = false;
        e.wj(true);
        AppMethodBeat.o(238309);
    }

    public static void atK() {
        AppMethodBeat.i(238310);
        if (sp == null) {
            sp = MMApplicationContext.getDefaultPreference();
        }
        if (sp != null) {
            int i2 = sp.getInt("dynamic_bg_draw_start_point_count", 0);
            Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawStartPoint current: %d", Integer.valueOf(i2));
            if (i2 > 2) {
                e.wj(false);
                sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
            }
            sp.edit().putInt("dynamic_bg_draw_start_point_count", i2 + 1).apply();
        }
        AppMethodBeat.o(238310);
    }

    public static void atL() {
        AppMethodBeat.i(238311);
        Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawEndPoint");
        sp.edit().putInt("dynamic_bg_draw_start_point_count", 0).apply();
        sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
        e.wj(true);
        FVd = false;
        AppMethodBeat.o(238311);
    }

    public static boolean fvg() {
        return FVb;
    }
}
