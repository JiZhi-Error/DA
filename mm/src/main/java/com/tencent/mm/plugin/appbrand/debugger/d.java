package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class d implements be.c, DebuggerShell.a {
    @Override // com.tencent.mm.plugin.appbrand.appcache.be.c
    public final void l(String str, Map<String, String> map) {
        AppMethodBeat.i(226506);
        if (DebuggerShell.bAx()) {
            String str2 = map.get(".sysmsg.AppBrandForceKill.AppId");
            int i2 = Util.getInt(map.get(".sysmsg.AppBrandForceKill.VersionType"), 0);
            if (Util.isNullOrNil(str2)) {
                AppMethodBeat.o(226506);
                return;
            }
            h.bWb().cl(str2, i2);
        }
        AppMethodBeat.o(226506);
    }

    @Override // com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a
    public final String name() {
        return "ForceKillAppNotify";
    }

    @Override // com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a
    public final void A(Intent intent) {
        AppMethodBeat.i(44946);
        h.bWb().cl(intent.getStringExtra("appId"), intent.getIntExtra("versionType", 0));
        AppMethodBeat.o(44946);
    }
}
