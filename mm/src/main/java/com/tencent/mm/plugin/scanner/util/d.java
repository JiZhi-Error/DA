package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/scanner/util/ScanDebugUtil;", "", "()V", "TAG", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "showDebugView", "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "scan-sdk_release"})
public final class d {
    private static boolean CTE;
    public static final d CTF = new d();
    private static MultiProcessMMKV cQe;

    static {
        AppMethodBeat.i(194776);
        AppMethodBeat.o(194776);
    }

    private d() {
    }

    public static final void init() {
        boolean z;
        AppMethodBeat.i(194775);
        if (!(BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED)) {
            AppMethodBeat.o(194775);
            return;
        }
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("ScanDebug");
        cQe = mmkv;
        if (mmkv != null) {
            z = mmkv.getBoolean("scan_debug_show_debug_view", false);
        } else {
            z = false;
        }
        CTE = z;
        Log.i("MicroMsg.ScanDebugUtil", "alvinluo ScanDebugUtil init showDebugView %b", Boolean.valueOf(CTE));
        AppMethodBeat.o(194775);
    }

    public static final boolean eRT() {
        return CTE;
    }
}
