package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class g implements DebuggerShell.a {
    @Override // com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a
    public final String name() {
        return "LaunchApp";
    }

    @Override // com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a
    public final void A(Intent intent) {
        AppMethodBeat.i(44950);
        String stringExtra = intent.getStringExtra(ch.COL_USERNAME);
        String stringExtra2 = intent.getStringExtra("appId");
        String stringExtra3 = intent.getStringExtra("path");
        int i2 = Util.getInt(intent.getStringExtra("versionType"), 0);
        int i3 = Util.getInt(intent.getStringExtra("scene"), 1030);
        String stringExtra4 = intent.getStringExtra("sceneNote");
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = i3;
        appBrandStatObject.dCw = stringExtra4;
        ((r) com.tencent.mm.kernel.g.af(r.class)).a(MMApplicationContext.getContext(), stringExtra, stringExtra2, i2, 0, stringExtra3, appBrandStatObject);
        AppMethodBeat.o(44950);
    }
}
