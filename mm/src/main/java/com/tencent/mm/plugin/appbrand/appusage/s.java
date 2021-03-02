package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import java.util.Locale;

public final class s extends as {
    @Override // com.tencent.mm.model.as
    public final void transfer(int i2) {
        AppMethodBeat.i(44547);
        try {
            String format = String.format(Locale.US, "where %s like '%%$%s' or %s like '%%$%s'", "appId", "__WITHOUT_CODELIB__", "appId", "__CODELIB__");
            n.buz().buA().execSQL("AppBrandWxaPkgManifestRecord", String.format(Locale.US, "delete from %s %s", "AppBrandWxaPkgManifestRecord", format));
            g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_PLUGINCODE_CLEAR_TABLE_DONE_BOOLEAN, Boolean.TRUE);
            AppMethodBeat.o(44547);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandPluginCodeTransfer", e2, "transfer failed", new Object[0]);
            AppMethodBeat.o(44547);
        }
    }

    @Override // com.tencent.mm.model.as
    public final boolean rT(int i2) {
        AppMethodBeat.i(44548);
        boolean z = g.aAh().azQ().getBoolean(ar.a.USERINFO_APP_BRAND_PLUGINCODE_CLEAR_TABLE_DONE_BOOLEAN, false);
        Log.d("MicroMsg.AppBrandPluginCodeTransfer", "needTransfer doneIssue %b", Boolean.valueOf(z));
        if (!z) {
            AppMethodBeat.o(44548);
            return true;
        }
        AppMethodBeat.o(44548);
        return false;
    }

    @Override // com.tencent.mm.model.as
    public final String getTag() {
        return "MicroMsg.AppBrandPluginCodeTransfer";
    }
}
