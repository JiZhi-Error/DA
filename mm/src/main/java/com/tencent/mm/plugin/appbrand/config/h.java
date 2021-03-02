package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.Log;
import org.apache.commons.b.a;

public final class h extends b {
    private final String[] ldL = {"wx308bd2aeb83d3345"};

    @Override // com.tencent.luggage.sdk.config.b
    public final /* synthetic */ AppBrandInitConfigLU a(WxaAttributes wxaAttributes) {
        AppMethodBeat.i(44832);
        AppBrandInitConfigWC c2 = c(wxaAttributes);
        AppMethodBeat.o(44832);
        return c2;
    }

    @Override // com.tencent.luggage.sdk.config.b
    public final /* synthetic */ AppBrandInitConfigLU dA(String str) {
        AppMethodBeat.i(44831);
        AppBrandInitConfigWC Xa = Xa(str);
        AppMethodBeat.o(44831);
        return Xa;
    }

    private h() {
        AppMethodBeat.i(44827);
        AppMethodBeat.o(44827);
    }

    public static void init() {
        AppMethodBeat.i(44828);
        synchronized (b.class) {
            try {
                cyi = new h();
            } finally {
                AppMethodBeat.o(44828);
            }
        }
    }

    public static h bzT() {
        h hVar;
        synchronized (b.class) {
            hVar = (h) cyi;
        }
        return hVar;
    }

    public final AppBrandInitConfigWC Xa(String str) {
        AppMethodBeat.i(44829);
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.dA(str);
        AppMethodBeat.o(44829);
        return appBrandInitConfigWC;
    }

    public final AppBrandInitConfigWC c(WxaAttributes wxaAttributes) {
        AppMethodBeat.i(44830);
        AppBrandInitConfigLU a2 = super.a(wxaAttributes);
        AppBrandInitConfigWC appBrandInitConfigWC = null;
        if (a2 != null) {
            AppBrandInitConfigWC appBrandInitConfigWC2 = new AppBrandInitConfigWC(a2.bzR());
            appBrandInitConfigWC2.ldN = wxaAttributes.bAn().bAt() && (i.brb() || !a.contains(this.ldL, appBrandInitConfigWC2.appId));
            appBrandInitConfigWC = appBrandInitConfigWC2;
        }
        if (appBrandInitConfigWC != null) {
            appBrandInitConfigWC.ldY = wxaAttributes.bAo().lgD.lgJ;
        }
        if (appBrandInitConfigWC != null && !TextUtils.isEmpty(appBrandInitConfigWC.appId)) {
            String str = appBrandInitConfigWC.appId;
            Log.i("Luggage.WXA.AppBrandInitConfigHelper", "clearByAppId %s", str);
            synchronized (this.cyj) {
                try {
                    this.cyj.remove(str);
                } finally {
                    AppMethodBeat.o(44830);
                }
            }
        }
        return appBrandInitConfigWC;
    }
}
