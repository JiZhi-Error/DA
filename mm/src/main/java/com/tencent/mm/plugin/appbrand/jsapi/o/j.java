package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class j implements d.b {
    @Override // com.tencent.luggage.sdk.b.a.a.d.b
    public final boolean Ob() {
        AppMethodBeat.i(226913);
        if (((b) g.af(b.class)).a(b.a.clicfg_android_appbrand_wcwss_binding_close_when_suspend, 1) > 0) {
            AppMethodBeat.o(226913);
            return true;
        }
        AppMethodBeat.o(226913);
        return false;
    }

    @Override // com.tencent.luggage.sdk.b.a.a.d.b
    public final boolean isOpen() {
        Boolean bool;
        AppMethodBeat.i(174843);
        String string = MMApplicationContext.getToolsProcesstPreference().getString("appbrandgame_open_nativewss", "");
        if (string == null || !string.equalsIgnoreCase("close")) {
            bool = Boolean.FALSE;
        } else {
            bool = Boolean.TRUE;
        }
        if (bool.booleanValue()) {
            Log.i("MicroMsg.AppBrand.WcWssNativeSwitchDelegateImpl", "createWcWssBinding Command close");
            AppMethodBeat.o(174843);
            return false;
        }
        String b2 = com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_appbrand_native_socket_default_wcwss", "1", true, true);
        Log.i("MicroMsg.AppBrand.WcWssNativeSwitchDelegateImpl", "createWcWssBinding xSwitch xSwitchStr:%s", b2);
        if (!TextUtils.equals(b2, "1")) {
            Log.i("MicroMsg.AppBrand.WcWssNativeSwitchDelegateImpl", "createWcWssBinding xSwitch false");
            AppMethodBeat.o(174843);
            return false;
        }
        AppMethodBeat.o(174843);
        return true;
    }
}
