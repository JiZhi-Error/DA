package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;

public final class d implements b.AbstractC1929b {
    private static d IwN = null;

    public static d fVq() {
        AppMethodBeat.i(129896);
        if (IwN == null) {
            IwN = new d();
        }
        d dVar = IwN;
        AppMethodBeat.o(129896);
        return dVar;
    }

    private d() {
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b.AbstractC1929b
    public final boolean aR(Activity activity) {
        String str;
        AppMethodBeat.i(129895);
        ComponentName componentName = ((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningTasks(1).get(0).topActivity;
        if (componentName != null) {
            str = componentName.getClassName();
        } else {
            str = "";
        }
        Log.d("MicroMsg.WalletGuardFilter", "coveredPage: ".concat(String.valueOf(str)));
        if (str == null || str.equals(activity.getClass().getName()) || !str.contains(MMApplicationContext.getSourcePackageName()) || (!str.contains("plugin.mall") && !str.contains("plugin.card") && !str.contains("plugin.wallet") && !str.contains("plugin.wallet_index") && !str.contains("plugin.webview") && !str.contains("plugin.offline") && !str.contains("plugin.recharge"))) {
            AppMethodBeat.o(129895);
            return true;
        }
        AppMethodBeat.o(129895);
        return false;
    }
}
