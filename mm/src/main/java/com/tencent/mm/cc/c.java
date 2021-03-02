package com.tencent.mm.cc;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;

public final class c {
    private static boolean vUN = false;

    public static void a(Configuration configuration, Resources resources) {
        AppMethodBeat.i(162180);
        boolean f2 = ao.f(resources);
        configuration.uiMode &= -49;
        configuration.uiMode = (f2 ? 32 : 16) | configuration.uiMode;
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(f2);
        objArr[1] = Integer.valueOf(configuration.uiMode);
        objArr[2] = Integer.valueOf(resources == null ? 0 : resources.getConfiguration().uiMode);
        Log.i("MicroMsg.MMUIModeManager", "updateNightMode, isDarkMode:%s, uiMode:%s, resourcesMode:%s", objArr);
        AppMethodBeat.o(162180);
    }

    public static void a(Configuration configuration, boolean z) {
        configuration.uiMode &= -49;
        configuration.uiMode = (z ? 32 : 16) | configuration.uiMode;
    }

    public static boolean h(Configuration configuration) {
        int i2;
        int i3;
        AppMethodBeat.i(162181);
        int i4 = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getInt("uimode_change", 0);
        int i5 = configuration.uiMode;
        if (i4 == 0) {
            MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt("uimode_change", i5);
        }
        Log.i("MicroMsg.MMUIModeManager", "dancy test uimode change, mUimode:%s,mCurrentUimode:%s", Integer.valueOf(i4), Integer.valueOf(i5));
        if (i4 == 0 || i4 == i5) {
            AppMethodBeat.o(162181);
            return false;
        }
        Log.i("MicroMsg.MMUIModeManager", "uiModeChange true !! reStart!!!");
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt("uimode_change", i5);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG || ao.awN()) {
            i2 = ao.awS() ? 1 : 2;
        } else {
            i2 = 0;
        }
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[5];
        objArr[0] = 2;
        if (ao.i(configuration)) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = 2;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(ao.awN() ? 1 : 0);
        hVar.a(18893, objArr);
        Log.i("MicroMsg.MMUIModeManager", "dark mode change kvReport logID:%s , action: %s, isDark:%s, mode:%s", 18893, 2, Boolean.valueOf(ao.i(configuration)), Integer.valueOf(i2));
        AppMethodBeat.o(162181);
        return true;
    }

    public static void gvC() {
        AppMethodBeat.i(162182);
        if (!vUN) {
            Log.i("MicroMsg.MMUIModeManager", "dark mode used: %s", Boolean.TRUE);
            MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_used", true);
            vUN = true;
        }
        AppMethodBeat.o(162182);
    }

    public static boolean gvD() {
        AppMethodBeat.i(205092);
        String str = Build.BRAND;
        if (!Util.isNullOrNil(str)) {
            String lowerCase = str.toLowerCase();
            if ((lowerCase.contains("meizu") || lowerCase.contains("smartisan")) && Build.VERSION.SDK_INT <= 25) {
                AppMethodBeat.o(205092);
                return true;
            } else if (ao.gJN() && ao.gJH()) {
                AppMethodBeat.o(205092);
                return true;
            }
        }
        AppMethodBeat.o(205092);
        return false;
    }

    public static boolean gvE() {
        return false;
    }
}
