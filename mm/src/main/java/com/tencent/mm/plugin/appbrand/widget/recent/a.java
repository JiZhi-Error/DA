package com.tencent.mm.plugin.appbrand.widget.recent;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 '*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001'B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014H$J\r\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nJ%\u0010\u001b\u001a\u00028\u00002\u0016\u0010\u001c\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001e0\u001d\"\u0004\u0018\u00010\u001eH\u0004¢\u0006\u0002\u0010\u001fJ\u001f\u0010 \u001a\u00028\u00002\u0010\u0010\u001c\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001e0\u001dH$¢\u0006\u0002\u0010\u001fJ\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014J\u001a\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u00028\u0001X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0005R\u001b\u0010\r\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/recent/AbsAppBrandDesktopViewStorageWithCache;", "DATA", "DELEGATE_INTERFACE", "Lcom/tencent/mm/plugin/appbrand/widget/recent/IQueryCache;", "delegate", "(Ljava/lang/Object;)V", "cache", "", "Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;", "getDelegate", "()Ljava/lang/Object;", "setDelegate", "Ljava/lang/Object;", "queryCacheConfig", "getQueryCacheConfig", "()Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;", "queryCacheConfig$delegate", "Lkotlin/Lazy;", "storageChangeListenerSet", "", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "storageChangedListener", "addChangedListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addStorageChangedListenerToDelegate", "queryAndCache", "queryByCache", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "queryByDelegate", "removeChangedListener", "updateCache", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "event", "", "Companion", "plugin-appbrand-integration_release"})
public abstract class a<DATA, DELEGATE_INTERFACE> implements m<DATA> {
    public static final C0824a oBK = new C0824a((byte) 0);
    private final Map<n, DATA> aNT = new LinkedHashMap();
    private final Set<MStorage.IOnStorageChange> oBG = new LinkedHashSet();
    private final MStorage.IOnStorageChange oBH = new c(this);
    private final f oBI;
    DELEGATE_INTERFACE oBJ;

    private final n ccM() {
        return (n) this.oBI.getValue();
    }

    /* access modifiers changed from: protected */
    public abstract void g(MStorage.IOnStorageChange iOnStorageChange);

    /* access modifiers changed from: protected */
    public abstract DATA n(Object[] objArr);

    public a(DELEGATE_INTERFACE delegate_interface) {
        this.oBJ = delegate_interface;
        g(this.oBH);
        this.oBI = g.ah(new b(this));
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "DATA", "DELEGATE_INTERFACE", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class c implements MStorage.IOnStorageChange {
        final /* synthetic */ a oBL;

        c(a aVar) {
            this.oBL = aVar;
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(229625);
            Log.i("MicroMsg.AbsAppBrandStorageWithCache", "storage change eventId=" + mStorageEventData.eventId);
            a aVar = this.oBL;
            p.g(mStorageEventData, "eventData");
            a.a(aVar, mStorageEventData, str);
            AppMethodBeat.o(229625);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "DATA", "DELEGATE_INTERFACE", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ a oBL;
        final /* synthetic */ String oBM;
        final /* synthetic */ MStorageEventData oBN;

        d(a aVar, String str, MStorageEventData mStorageEventData) {
            this.oBL = aVar;
            this.oBM = str;
            this.oBN = mStorageEventData;
        }

        public final void run() {
            AppMethodBeat.i(229627);
            this.oBL.ccN();
            h.RTc.aV(new Runnable(this) {
                /* class com.tencent.mm.plugin.appbrand.widget.recent.a.d.AnonymousClass1 */
                final /* synthetic */ d oBO;

                {
                    this.oBO = r1;
                }

                public final void run() {
                    AppMethodBeat.i(229626);
                    Log.i("MicroMsg.AbsAppBrandStorageWithCache", "notify cache update");
                    Set<MStorage.IOnStorageChange> set = this.oBO.oBL.oBG;
                    synchronized (set) {
                        try {
                            for (MStorage.IOnStorageChange iOnStorageChange : set) {
                                iOnStorageChange.onNotifyChange(this.oBO.oBM, this.oBO.oBN);
                            }
                            x xVar = x.SXb;
                        } finally {
                            AppMethodBeat.o(229626);
                        }
                    }
                }
            });
            AppMethodBeat.o(229627);
        }
    }

    public final void e(MStorage.IOnStorageChange iOnStorageChange) {
        p.h(iOnStorageChange, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this.oBG) {
            this.oBG.add(iOnStorageChange);
        }
    }

    public final void f(MStorage.IOnStorageChange iOnStorageChange) {
        p.h(iOnStorageChange, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this.oBG) {
            this.oBG.remove(iOnStorageChange);
            Log.i("MicroMsg.AbsAppBrandStorageWithCache", "removed: " + this.oBG.size());
            x xVar = x.SXb;
        }
    }

    public final DATA ccN() {
        DATA n = n(ccM().args);
        synchronized (this.aNT) {
            Log.i("MicroMsg.AbsAppBrandStorageWithCache", "queryAndCache for config: [" + ccM() + ']');
            this.aNT.put(ccM(), n);
            x xVar = x.SXb;
        }
        return n;
    }

    /* access modifiers changed from: protected */
    public final DATA m(Object... objArr) {
        DATA data;
        p.h(objArr, "args");
        n nVar = new n(Arrays.copyOf(objArr, objArr.length));
        synchronized (this.aNT) {
            data = this.aNT.get(nVar);
        }
        if (data != null) {
            Log.i("MicroMsg.AbsAppBrandStorageWithCache", "cache hit, return cache for config: [" + nVar + ']');
            if (data != null) {
                return data;
            }
        }
        DATA ccN = ccN();
        Log.i("MicroMsg.AbsAppBrandStorageWithCache", "no cache for config: [" + nVar + "], do query through delegate");
        return ccN;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/recent/AbsAppBrandDesktopViewStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recent.a$a  reason: collision with other inner class name */
    public static final class C0824a {
        private C0824a() {
        }

        public /* synthetic */ C0824a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;", "DATA", "DELEGATE_INTERFACE", "invoke"})
    static final class b extends q implements kotlin.g.a.a<n> {
        final /* synthetic */ a oBL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(0);
            this.oBL = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ n invoke() {
            AppMethodBeat.i(229624);
            n ccO = this.oBL.ccO();
            AppMethodBeat.o(229624);
            return ccO;
        }
    }

    public static final /* synthetic */ void a(a aVar, MStorageEventData mStorageEventData, String str) {
        if (mStorageEventData.eventId != -1) {
            h.RTc.aY(new d(aVar, str, mStorageEventData));
        }
    }
}
