package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.Huawei;

public final class c {
    public static void nP(int i2) {
        AppMethodBeat.i(131862);
        akz().edit().putInt("huawei_switch", i2).commit();
        Log.i("MicroMsg.CoreServiceUtil", "setTarget26StartServiceHuawei() enable: %s", Integer.valueOf(i2));
        AppMethodBeat.o(131862);
    }

    public static void aky() {
        AppMethodBeat.i(131865);
        Context context = MMApplicationContext.getContext();
        Intent className = new Intent().setClassName(context, "com.tencent.mm.pluginsdk.permission.PermissionActivity");
        className.setFlags(268435456);
        className.putExtra("scene", 4);
        a bl = new a().bl(className);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/booter/CoreServiceUtil", "ignoreBatteryOptimizations", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/booter/CoreServiceUtil", "ignoreBatteryOptimizations", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        Log.i("MicroMsg.CoreServiceUtil", "ignoreBatteryOptimizations()");
        AppMethodBeat.o(131865);
    }

    public static boolean cf(Context context) {
        AppMethodBeat.i(131866);
        if (BuildInfo.IS_UAT) {
            Log.i("MicroMsg.CoreServiceUtil", "ignorePermissionActivity for uat wechat pay.");
            AppMethodBeat.o(131866);
            return true;
        } else if (Build.VERSION.SDK_INT >= 23) {
            boolean isIgnoringBatteryOptimizations = ((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName());
            Log.i("MicroMsg.CoreServiceUtil", "ifIgnoreBatteryOptimizations() result=%s", Boolean.valueOf(isIgnoringBatteryOptimizations));
            AppMethodBeat.o(131866);
            return isIgnoringBatteryOptimizations;
        } else {
            AppMethodBeat.o(131866);
            return true;
        }
    }

    private static SharedPreferences akz() {
        AppMethodBeat.i(131867);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("service_launch_way", g.aps());
        AppMethodBeat.o(131867);
        return sharedPreferences;
    }

    public static boolean akA() {
        AppMethodBeat.i(131868);
        if (d.oD(26)) {
            int i2 = akz().getInt("huawei_switch", 0);
            boolean isNotBelowEMUI10 = Huawei.isNotBelowEMUI10();
            Log.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() huaweiEnable:%s isNotBelowEmui10:%s", Integer.valueOf(i2), Boolean.valueOf(isNotBelowEMUI10));
            if (isNotBelowEMUI10) {
                AppMethodBeat.o(131868);
                return false;
            } else if (Util.isEqual(i2, 0)) {
                Log.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() true (huawei)");
                AppMethodBeat.o(131868);
                return true;
            }
        }
        if (!d.oD(26) || akx()) {
            Log.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() false");
            AppMethodBeat.o(131868);
            return false;
        }
        Log.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() true");
        AppMethodBeat.o(131868);
        return true;
    }

    private static boolean akx() {
        AppMethodBeat.i(131863);
        boolean z = MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("target26_start_service", false);
        Log.i("MicroMsg.CoreServiceUtil", "ifTarget26StartService() result:%s", Boolean.valueOf(z));
        AppMethodBeat.o(131863);
        return z;
    }

    public static void dg(boolean z) {
        AppMethodBeat.i(131864);
        MultiProcessMMKV.getMMKV("service_launch_way").edit().putBoolean("target26_start_service", z).commit();
        Log.i("MicroMsg.CoreServiceUtil", "setTarget26StartService() enable: %s", Boolean.valueOf(z));
        AppMethodBeat.o(131864);
    }
}
