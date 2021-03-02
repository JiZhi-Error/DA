package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class h implements b, l {
    private g kXT;

    @Override // com.tencent.mm.kernel.c.b
    public final void aBc() {
        AppMethodBeat.i(44754);
        this.kXT = n.buU();
        AppMethodBeat.o(44754);
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBd() {
        this.kXT = null;
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundfetch.l
    public final AppBrandBackgroundFetchDataTokenParcel Wy(String str) {
        AppMethodBeat.i(44755);
        if (this.kXT == null) {
            AppMethodBeat.o(44755);
            return null;
        }
        AppBrandBackgroundFetchDataTokenParcel Wy = this.kXT.Wy(str);
        if (Wy == null) {
            Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "get fail, app(%s)", str);
            AppMethodBeat.o(44755);
            return null;
        }
        Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "get success, app(%s)", str);
        AppMethodBeat.o(44755);
        return Wy;
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundfetch.l
    public final boolean cN(String str, String str2) {
        AppMethodBeat.i(44756);
        if (this.kXT == null) {
            AppMethodBeat.o(44756);
            return false;
        }
        boolean cN = this.kXT.cN(str, str2);
        if (cN) {
            Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "set success, app(%s)", str);
        } else {
            Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "set fail, app(%s)", str);
        }
        AppMethodBeat.o(44756);
        return cN;
    }
}
