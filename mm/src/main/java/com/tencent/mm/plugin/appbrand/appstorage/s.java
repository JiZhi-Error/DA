package com.tencent.mm.plugin.appbrand.appstorage;

import com.facebook.internal.NativeProtocol;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.w.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"KV_STORAGE_ACTION_GET", "", "KV_STORAGE_ACTION_INFO", "KV_STORAGE_ACTION_SET", "KV_STORAGE_SCHEME_DB", "KV_STORAGE_SCHEME_MMKV", "TAG", "", "report", "", "scheme", NativeProtocol.WEB_DIALOG_ACTION, "dataSize", "count", "cost", "", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "luggage-wechat-full-sdk_release"})
public final class s {
    public static final void a(int i2, int i3, int i4, int i5, long j2, k kVar) {
        AppMethodBeat.i(147887);
        p.h(kVar, "service");
        AppBrandRuntime runtime = kVar.getRuntime();
        com.tencent.mm.plugin.appbrand.config.l OT = runtime != null ? runtime.OT() : null;
        if (OT == null) {
            Log.i("KVStoragePerformanceReport", "sysConfig is null");
            AppMethodBeat.o(147887);
        } else if (!OT.leG) {
            Log.i("KVStoragePerformanceReport", "performance report off");
            AppMethodBeat.o(147887);
        } else {
            Log.i("KVStoragePerformanceReport", "report scheme=" + i2 + "  action=" + i3 + "  dataSize=" + i4 + "  count=" + i5 + "  cost=" + j2);
            ((b) e.N(b.class)).a(16336, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j2));
            AppMethodBeat.o(147887);
        }
    }
}
