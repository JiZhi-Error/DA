package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class i implements b {
    @Override // com.tencent.luggage.sdk.b.a.a.b
    public final boolean Oa() {
        Boolean bool;
        AppMethodBeat.i(226912);
        String string = MMApplicationContext.getToolsProcesstPreference().getString("appbrandgame_open_nativelibuv", "");
        if (string == null || !string.equalsIgnoreCase("close")) {
            bool = Boolean.FALSE;
        } else {
            bool = Boolean.TRUE;
        }
        if (bool.booleanValue()) {
            Log.i("MicroMsg.AppBrand.NativeInstallHelperSwitchDelegateImpl", "use libuv Command close");
            AppMethodBeat.o(226912);
            return false;
        }
        String b2 = d.cRY().b("clicfg_appbrand_native_install_default_libuv", "1", true, true);
        Log.i("MicroMsg.AppBrand.NativeInstallHelperSwitchDelegateImpl", "use libuv xSwitch xSwitchStr:%s", b2);
        if (!TextUtils.equals(b2, "1")) {
            Log.i("MicroMsg.AppBrand.NativeInstallHelperSwitchDelegateImpl", "use libuv xSwitch false");
            AppMethodBeat.o(226912);
            return false;
        }
        AppMethodBeat.o(226912);
        return true;
    }
}
