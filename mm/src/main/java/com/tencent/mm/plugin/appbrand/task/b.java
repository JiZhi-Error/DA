package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\tH\u0007J\b\u0010\u000b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/task/AppBrandForcePreloadConfig;", "", "()V", "FORCE_PRELOAD_TAG", "", "TAG", "sShouldForcePreload", "", "disableForcePreload", "", "enableForcePreload", "shouldForcePreload", "plugin-appbrand-integration_release"})
public final class b {
    private static boolean nOn = true;
    public static final b nOo = new b();

    static {
        AppMethodBeat.i(51065);
        long currentTicks = Util.currentTicks();
        int decodeInt = MultiProcessMMKV.getMMKV("appbrand_process_force_preload").decodeInt("appbrand_process_force_preload", 0);
        if (decodeInt == 1) {
            Log.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] == 1, accepted (mmkv cost [%d]ms)", Integer.valueOf(decodeInt), Long.valueOf(Util.ticksToNow(currentTicks)));
            AppMethodBeat.o(51065);
            return;
        }
        Log.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] != 1, buildConfig = [%b] reject (mmkv cost [%d]ms)", Integer.valueOf(decodeInt), Boolean.FALSE, Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(51065);
    }

    private b() {
    }

    public static final boolean bVE() {
        AppMethodBeat.i(51062);
        Log.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] forcePreload = [%b]", Boolean.valueOf(nOn));
        boolean z = nOn;
        AppMethodBeat.o(51062);
        return z;
    }

    public static final void bVF() {
        AppMethodBeat.i(51063);
        Log.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] enableForcePreload");
        nOn = true;
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("appbrand_process_force_preload");
        mmkv.encode("appbrand_process_force_preload", 1);
        mmkv.apply();
        AppMethodBeat.o(51063);
    }

    public static final void bVG() {
        AppMethodBeat.i(51064);
        Log.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] disableForcePreload");
        nOn = false;
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("appbrand_process_force_preload");
        mmkv.encode("appbrand_process_force_preload", -1);
        mmkv.apply();
        AppMethodBeat.o(51064);
    }
}
