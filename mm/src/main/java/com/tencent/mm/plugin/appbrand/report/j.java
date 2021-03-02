package com.tencent.mm.plugin.appbrand.report;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001c\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/AppBrandServiceTypeCache;", "", "()V", "TAG", "", "serviceTypeMap", "Landroid/util/SparseIntArray;", "addServiceTypeMap", "", "appId", "serviceType", "", "getServiceTypeMap", BuildConfig.KINDA_DEFAULT, "plugin-appbrand-integration_release"})
public final class j {
    private static final SparseIntArray nHo = new SparseIntArray();
    public static final j nHp = new j();

    static {
        AppMethodBeat.i(51006);
        AppMethodBeat.o(51006);
    }

    private j() {
    }

    public static final void cg(String str, int i2) {
        AppMethodBeat.i(51004);
        if (str != null) {
            Log.d("MicroMsg.AppBrandServiceTypeCache", "addServiceTypeMap appId: " + str + ", serviceType: " + i2);
            nHo.put(str.hashCode(), i2);
        }
        AppMethodBeat.o(51004);
    }

    public static final int aeJ(String str) {
        AppMethodBeat.i(51005);
        if (str != null) {
            int i2 = nHo.get(str.hashCode(), -1);
            Log.d("MicroMsg.AppBrandServiceTypeCache", "getServiceTypeMap appId: " + str + ", ret " + i2);
            AppMethodBeat.o(51005);
            return i2;
        }
        AppMethodBeat.o(51005);
        return -1;
    }
}
