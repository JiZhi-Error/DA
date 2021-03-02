package com.tencent.mm.kernel;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class l {
    public static void s(Context context, boolean z) {
        AppMethodBeat.i(132152);
        if (context == null) {
            Log.e("MicroMsg.WeChatAppStatus", "editFullExitStatus context == null");
            AppMethodBeat.o(132152);
            return;
        }
        MultiProcessMMKV.getMMKV("system_config_prefs").edit().putBoolean("settings_fully_exit", z);
        Log.i("MicroMsg.WeChatAppStatus", "editFullExitStatus to ".concat(String.valueOf(z)));
        AppMethodBeat.o(132152);
    }

    public static boolean cK(Context context) {
        AppMethodBeat.i(132153);
        if (context == null) {
            Log.e("MicroMsg.WeChatAppStatus", "getFullExitStatus context == null");
            AppMethodBeat.o(132153);
            return false;
        }
        boolean z = MultiProcessMMKV.getMMKV("system_config_prefs").getBoolean("settings_fully_exit", true);
        AppMethodBeat.o(132153);
        return z;
    }

    public static void t(Context context, boolean z) {
        AppMethodBeat.i(132154);
        if (context == null) {
            Log.e("MicroMsg.WeChatAppStatus", "editShutDownWxStatus context == null");
            AppMethodBeat.o(132154);
            return;
        }
        context.getSharedPreferences("system_config_prefs_showdown", g.aps()).edit().putBoolean("shut_down_weixin", z).commit();
        Log.i("MicroMsg.WeChatAppStatus", "editShutDownWxStatus to ".concat(String.valueOf(z)));
        AppMethodBeat.o(132154);
    }

    public static boolean cL(Context context) {
        AppMethodBeat.i(132155);
        if (context == null) {
            Log.e("MicroMsg.WeChatAppStatus", "getShutDownWxStatus context == null");
            AppMethodBeat.o(132155);
            return false;
        }
        boolean z = context.getSharedPreferences("system_config_prefs_showdown", g.aps()).getBoolean("shut_down_weixin", false);
        AppMethodBeat.o(132155);
        return z;
    }
}
