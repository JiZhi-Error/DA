package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class e implements b, k {
    private d kXS;

    @Override // com.tencent.mm.kernel.c.b
    public final void aBc() {
        AppMethodBeat.i(44731);
        this.kXS = n.buT();
        AppMethodBeat.o(44731);
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBd() {
        this.kXS = null;
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundfetch.k
    public final boolean a(String str, int i2, String str2, String str3, String str4, int i3, long j2) {
        AppMethodBeat.i(44732);
        if (this.kXS == null) {
            AppMethodBeat.o(44732);
            return false;
        }
        boolean a2 = this.kXS.a(str, i2, str2, str3, str4, i3, j2);
        if (a2) {
            Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy set success(time:%s), app(%s_%d)", Long.valueOf(j2), str, Integer.valueOf(i2));
        } else {
            Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy set fail, app(%s_%d)", str, Integer.valueOf(i2));
        }
        AppMethodBeat.o(44732);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundfetch.k
    public final long bu(String str, int i2) {
        AppMethodBeat.i(44733);
        if (this.kXS == null) {
            AppMethodBeat.o(44733);
            return 0;
        }
        long bu = this.kXS.bu(str, i2);
        if (bu > 0) {
            Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getUpdateTime success(time:%s), app(%s_%d)", Long.valueOf(bu), str, Integer.valueOf(i2));
        } else {
            Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getUpdateTime fail, app(%s_%d)", str, Integer.valueOf(i2));
        }
        AppMethodBeat.o(44733);
        return bu;
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundfetch.k
    public final AppBrandBackgroundFetchDataParcel bv(String str, int i2) {
        AppMethodBeat.i(44734);
        if (this.kXS == null) {
            AppMethodBeat.o(44734);
            return null;
        }
        AppBrandBackgroundFetchDataParcel bv = this.kXS.bv(str, i2);
        if (bv == null) {
            Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getByAppId fail, app(%s_%d)", str, Integer.valueOf(i2));
        } else {
            Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getByAppId success, app(%s_%d)", str, Integer.valueOf(i2));
        }
        AppMethodBeat.o(44734);
        return bv;
    }
}
