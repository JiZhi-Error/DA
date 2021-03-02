package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007J\b\u0010\f\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper;", "", "()V", "ACTION_RELOAD_CONFIG", "", "TAG", "receiver", "com/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper$receiver$1", "Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper$receiver$1;", "beforeKillProcess", "", "notifyReloadConfigs", "setup", "plugin-appbrand-integration_release"})
public final class b {
    private static final DebuggerShellClientProcessHelper$receiver$1 lhD = new DebuggerShellClientProcessHelper$receiver$1();
    public static final b lhE = new b();

    static {
        AppMethodBeat.i(228193);
        AppMethodBeat.o(228193);
    }

    private b() {
    }

    public static final void setup() {
        AppMethodBeat.i(228190);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mm.appbrand.debugger.appbrand_process_reload_configs");
            MMApplicationContext.getContext().registerReceiver(lhD, intentFilter);
            AppMethodBeat.o(228190);
        } catch (Throwable th) {
            Log.e("MicroMsg.AppBrand.DebuggerShellClientProcessHelper", "setup get exception ".concat(String.valueOf(th)));
            AppMethodBeat.o(228190);
        }
    }

    public static final void bAD() {
        AppMethodBeat.i(228191);
        MMApplicationContext.getContext().unregisterReceiver(lhD);
        AppMethodBeat.o(228191);
    }

    public static final void bAE() {
        AppMethodBeat.i(228192);
        MMApplicationContext.getContext().sendBroadcast(new Intent().setAction("com.tencent.mm.appbrand.debugger.appbrand_process_reload_configs"));
        AppMethodBeat.o(228192);
    }
}
