package com.tencent.mm.plugin.appbrand.widget.recent;

import android.os.Looper;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 )2\u00020\u00012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u0001)B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0002\u0010\u0006J)\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\r0\rH\u0001J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J)\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000f2\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0001J)\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00100\u00102\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0001J\u0019\u0010\u0011\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00120\u0012H\u0001J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\bH\u0001J\u0019\u0010\u0016\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00100\u0010H\u0001J1\u0010\u0016\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00100\u00102\u0006\u0010\f\u001a\u00020\u00172\u000e\u0010\u0018\u001a\n \u000b*\u0004\u0018\u00010\u00190\u0019H\u0001J\t\u0010\u001a\u001a\u00020\u0017H\u0001J\t\u0010\u001b\u001a\u00020\bH\u0001J\t\u0010\u001c\u001a\u00020\u0017H\u0001J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J?\u0010\u001d\u001a(\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00040\u0004\u0018\u0001 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u001f2\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u0017H\u0001J%\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\u0010!\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00190\"H\u0014¢\u0006\u0002\u0010#J\u0012\u0010$\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\u0019\u0010%\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00120\u0012H\u0001J!\u0010&\u001a\u00020'2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00100\u00102\u0006\u0010\f\u001a\u00020\u0017H\u0001J\t\u0010(\u001a\u00020\bH\u0001¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandUsageStorageWithCache;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AbsAppBrandDesktopViewStorageWithCache;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;)V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/threadpool/serial/Serial;", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "addStorageChangedListenerToDelegate", "createQueryCacheConfig", "Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;", "doNotify", "", "p2", "", "getCount", "lock", "lockCount", SearchIntents.EXTRA_QUERY, "count", "", "queryByDelegate", "args", "", "([Ljava/lang/Object;)Ljava/util/List;", "remove", "removeLoadedListener", "removeUsage", "", "unlock", "Companion", "plugin-appbrand-integration_release"})
public final class j extends a<List<? extends LocalUsageInfo>, ah> implements ah {
    public static final a oCV = new a((byte) 0);
    private final /* synthetic */ ah oCW;

    static {
        AppMethodBeat.i(229668);
        AppMethodBeat.o(229668);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void add(com.tencent.f.j.a aVar, MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(229670);
        this.oCW.add(aVar, iOnStorageChange);
        AppMethodBeat.o(229670);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void add(MStorage.IOnStorageChange iOnStorageChange, Looper looper) {
        AppMethodBeat.i(229669);
        this.oCW.add(iOnStorageChange, looper);
        AppMethodBeat.o(229669);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void add(String str, MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(229671);
        this.oCW.add(str, iOnStorageChange);
        AppMethodBeat.o(229671);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void addLoadedListener(MStorage.IOnStorageLoaded iOnStorageLoaded) {
        AppMethodBeat.i(229672);
        this.oCW.addLoadedListener(iOnStorageLoaded);
        AppMethodBeat.o(229672);
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ah
    public final boolean bi(String str, int i2) {
        AppMethodBeat.i(229680);
        boolean bi = this.oCW.bi(str, i2);
        AppMethodBeat.o(229680);
        return bi;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ah
    public final List<LocalUsageInfo> dP(int i2, int i3) {
        AppMethodBeat.i(229678);
        List<LocalUsageInfo> dP = this.oCW.dP(i2, i3);
        AppMethodBeat.o(229678);
        return dP;
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void doNotify() {
        AppMethodBeat.i(229673);
        this.oCW.doNotify();
        AppMethodBeat.o(229673);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void doNotify(String str) {
        AppMethodBeat.i(229674);
        this.oCW.doNotify(str);
        AppMethodBeat.o(229674);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void doNotify(String str, int i2, Object obj) {
        AppMethodBeat.i(229675);
        this.oCW.doNotify(str, i2, obj);
        AppMethodBeat.o(229675);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void lock() {
        AppMethodBeat.i(229676);
        this.oCW.lock();
        AppMethodBeat.o(229676);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final int lockCount() {
        AppMethodBeat.i(229677);
        int lockCount = this.oCW.lockCount();
        AppMethodBeat.o(229677);
        return lockCount;
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void removeLoadedListener(MStorage.IOnStorageLoaded iOnStorageLoaded) {
        AppMethodBeat.i(229679);
        this.oCW.removeLoadedListener(iOnStorageLoaded);
        AppMethodBeat.o(229679);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void unlock() {
        AppMethodBeat.i(229681);
        this.oCW.unlock();
        AppMethodBeat.o(229681);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.widget.recent.a
    public final /* synthetic */ List<? extends LocalUsageInfo> n(Object[] objArr) {
        AppMethodBeat.i(229663);
        p.h(objArr, "args");
        Iterator af = b.af(objArr);
        DELEGATE_INTERFACE delegate_interface = this.oBJ;
        Object next = af.next();
        if (next == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(229663);
            throw tVar;
        }
        List<LocalUsageInfo> vW = delegate_interface.vW(((Integer) next).intValue());
        if (vW == null) {
            vW = v.SXr;
        }
        p.g(vW, LocaleUtil.ITALIAN);
        int i2 = 0;
        for (T t : vW) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            T t2 = t;
            if (i2 < 8) {
                Log.i("MicroMsg.AppBrandUsageStorageWithCache.AppBrandUsageStorageWithCache", "ccf-log [queryByDelegate] name=%s iconUrl=%s", t2.nickname, t2.kVZ);
            }
            i2 = i3;
        }
        p.g(vW, "(delegate.query(iterator…;\n            }\n        }");
        AppMethodBeat.o(229663);
        return vW;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(ah ahVar) {
        super(ahVar);
        p.h(ahVar, "delegate");
        AppMethodBeat.i(229667);
        this.oCW = ahVar;
        AppMethodBeat.o(229667);
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ah
    public final List<LocalUsageInfo> vW(int i2) {
        AppMethodBeat.i(229662);
        List<LocalUsageInfo> list = (List) m(Integer.valueOf(i2));
        AppMethodBeat.o(229662);
        return list;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.m
    public final n ccO() {
        return i.oCT;
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void remove(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(229665);
        if (iOnStorageChange != null) {
            f(iOnStorageChange);
        }
        AppMethodBeat.o(229665);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void add(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(229666);
        if (iOnStorageChange != null) {
            e(iOnStorageChange);
        }
        AppMethodBeat.o(229666);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandUsageStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.recent.a
    public final void g(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(229664);
        p.h(iOnStorageChange, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.oBJ.add(iOnStorageChange);
        AppMethodBeat.o(229664);
    }
}
