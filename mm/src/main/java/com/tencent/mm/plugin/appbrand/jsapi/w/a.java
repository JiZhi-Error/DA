package com.tencent.mm.plugin.appbrand.jsapi.w;

import android.support.v4.e.l;
import android.util.SparseArray;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.permission.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.model.i;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ2\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fJ\f\u0010\u0017\u001a\u00020\r*\u00020\u0005H\u0002J\u001a\u0010\u0018\u001a\u00020\t\"\u0004\b\u0000\u0010\u0019*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00190\u0004H\u0002J/\u0010\u001a\u001a\u00020\t\"\u0004\b\u0000\u0010\u0019*\b\u0012\u0004\u0012\u0002H\u00190\u00042\u0006\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u0001H\u0019H\u0002¢\u0006\u0002\u0010\u001dJ)\u0010\u001e\u001a\u0004\u0018\u0001H\u0019\"\u0004\b\u0000\u0010\u0019*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00190\u00042\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u001fR\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/report/AppBrandJsApiReporter;", "", "()V", "mInfoMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiInfo;", "mObjectPool", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/AppBrandJsApiReporter$JsApiInfoPool;", "doCleanupJobOnRuntimeDestroyed", "", "doCleanupJobOnRuntimeSuspended", "report", "callbackId", "", "ret", "", "setJsApiInfo", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", ProviderConstants.API_PATH, "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandBaseJsApi;", "data", "path", "getPermissionValue", "safeClear", "T", "safePut", "key", "value", "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "safeRemoveReturnOld", "(Landroid/util/SparseArray;I)Ljava/lang/Object;", "JsApiInfoPool", "plugin-appbrand-integration_release"})
public final class a {
    public final SparseArray<b> moY = new SparseArray<>();
    public final C0720a moZ = new C0720a();

    public a() {
        AppMethodBeat.i(50666);
        AppMethodBeat.o(50666);
    }

    public final void ao(int i2, String str) {
        int i3;
        d OI;
        AppMethodBeat.i(50664);
        p.h(str, "ret");
        b bVar = (b) b(this.moY, i2);
        if (bVar == null) {
            AppMethodBeat.o(50664);
            return;
        }
        long currentTicks = Util.currentTicks() - bVar.startTime;
        k kVar = bVar.mpb;
        p.g(kVar, "info.component");
        String appId = kVar.getAppId();
        String str2 = bVar.path;
        e eVar = bVar.mpc;
        p.g(eVar, "info.api");
        String name = eVar.getName();
        String str3 = bVar.data;
        k kVar2 = bVar.mpb;
        p.g(kVar2, "this.component");
        AppBrandRuntime runtime = kVar2.getRuntime();
        if (!(runtime instanceof q)) {
            runtime = null;
        }
        q qVar = (q) runtime;
        if (qVar == null || (OI = qVar.OI()) == null) {
            i3 = -1;
        } else {
            i3 = OI.a(bVar.mpb, bVar.mpc, bVar.data, false);
        }
        i.a(appId, str2, name, str3, i3, currentTicks, str);
        this.moZ.a(bVar);
        AppMethodBeat.o(50664);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/report/AppBrandJsApiReporter$JsApiInfoPool;", "Landroid/support/v4/util/Pools$Pool;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiInfo;", "()V", "mQueue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "acquire", "clear", "", "release", "", "jsApiInfo", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.w.a$a  reason: collision with other inner class name */
    public static final class C0720a implements l.a<b> {
        public final ConcurrentLinkedDeque<b> mpa = new ConcurrentLinkedDeque<>();

        public C0720a() {
            AppMethodBeat.i(50663);
            AppMethodBeat.o(50663);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.support.v4.e.l.a
        public final /* synthetic */ b acquire() {
            AppMethodBeat.i(50660);
            b bIz = bIz();
            AppMethodBeat.o(50660);
            return bIz;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.v4.e.l.a
        public final /* synthetic */ boolean release(b bVar) {
            AppMethodBeat.i(50662);
            boolean a2 = a(bVar);
            AppMethodBeat.o(50662);
            return a2;
        }

        public final b bIz() {
            AppMethodBeat.i(50659);
            b poll = this.mpa.poll();
            if (poll == null) {
                poll = new b();
            }
            AppMethodBeat.o(50659);
            return poll;
        }

        public final boolean a(b bVar) {
            AppMethodBeat.i(50661);
            p.h(bVar, "jsApiInfo");
            boolean offer = this.mpa.offer(bVar);
            AppMethodBeat.o(50661);
            return offer;
        }
    }

    private static <T> T b(SparseArray<T> sparseArray, int i2) {
        T t;
        AppMethodBeat.i(50665);
        synchronized (sparseArray) {
            try {
                t = sparseArray.get(i2, null);
                if (t != null) {
                    sparseArray.remove(i2);
                }
            } finally {
                AppMethodBeat.o(50665);
            }
        }
        return t;
    }
}
