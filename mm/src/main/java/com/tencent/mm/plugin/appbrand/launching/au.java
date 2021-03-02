package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

/* access modifiers changed from: package-private */
public final class au {
    final String appId;

    au(String str) {
        this.appId = str;
    }

    /* access modifiers changed from: package-private */
    public final boolean bNK() {
        AppMethodBeat.i(47307);
        if (h.aqJ().getInt("WeAppForbiddenSwitch", 0) == 1) {
            Log.i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", this.appId);
            Intent putExtra = new Intent().putExtra("rawUrl", w.Up(this.appId)).putExtra("forceHideShare", true);
            Context context = MMApplicationContext.getContext();
            if (!(context instanceof Activity)) {
                putExtra.addFlags(268435456);
            }
            c.b(context, "webview", ".ui.tools.WebViewUI", putExtra);
            AppMethodBeat.o(47307);
            return true;
        }
        AppMethodBeat.o(47307);
        return false;
    }
}
