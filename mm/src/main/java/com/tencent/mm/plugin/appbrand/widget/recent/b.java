package com.tencent.mm.plugin.appbrand.widget.recent;

import android.os.Looper;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.sdk.storage.MStorage;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\n\u0018\u0000 12\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0004:\u00011B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J)\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\r0\rH\u0001J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J)\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000f2\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0001J)\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00100\u00102\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0001J!\u0010\u0011\u001a\u00020\u00122\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00100\u00102\u0006\u0010\f\u001a\u00020\u0012H\u0001J\u0019\u0010\u0013\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00140\u0014H\u0001J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\bH\u0001J\u0019\u0010\u0018\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00100\u0010H\u0001J1\u0010\u0018\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00100\u00102\u0006\u0010\f\u001a\u00020\u00122\u000e\u0010\u0019\u001a\n \u000b*\u0004\u0018\u00010\u001a0\u001aH\u0001J\t\u0010\u001b\u001a\u00020\u0012H\u0001J\t\u0010\u001c\u001a\u00020\u0012H\u0001J!\u0010\u001d\u001a\u00020\u001e2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00100\u00102\u0006\u0010\f\u001a\u00020\u0012H\u0001J\t\u0010\u001f\u001a\u00020\bH\u0001J\t\u0010 \u001a\u00020\u0012H\u0001JO\u0010!\u001a(\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00030\u0003\u0018\u0001 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\"2\u0006\u0010\t\u001a\u00020\u00122\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010#0#2\u0006\u0010\u0019\u001a\u00020\u0012H\u0001J \u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010$\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010#H\u0016J%\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0010\u0010'\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001a0(H\u0014¢\u0006\u0002\u0010)J\t\u0010*\u001a\u00020\bH\u0001J\t\u0010+\u001a\u00020\bH\u0001J\u0012\u0010,\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J!\u0010-\u001a\u00020\u001e2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00100\u00102\u0006\u0010\f\u001a\u00020\u0012H\u0001J\u0019\u0010.\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00140\u0014H\u0001J=\u0010/\u001a\u00020\u001e2*\u0010\t\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00030\u0003 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\"2\u0006\u0010\f\u001a\u00020\u0012H\u0001J\t\u00100\u001a\u00020\bH\u0001¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandCollectionStorageWithCache;", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AbsAppBrandDesktopViewStorageWithCache;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;)V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/threadpool/serial/Serial;", "", "addCollection", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "addStorageChangedListenerToDelegate", "createQueryCacheConfig", "Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;", "doNotify", "p2", "", "getCount", "getCountLimit", "isCollection", "", "lock", "lockCount", SearchIntents.EXTRA_QUERY, "", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "count", "order", "queryByDelegate", "args", "", "([Ljava/lang/Object;)Ljava/util/List;", "refreshOnPullDownOpen", "refreshOnPullDownOpenAnimationEnd", "remove", "removeCollection", "removeLoadedListener", "reorder", "unlock", "Companion", "plugin-appbrand-integration_release"})
public final class b extends a<List<? extends LocalUsageInfo>, ag> implements ag {
    public static final a oBP = new a((byte) 0);
    private final /* synthetic */ ag oBQ;

    static {
        AppMethodBeat.i(229634);
        AppMethodBeat.o(229634);
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final List<LocalUsageInfo> a(int i2, ag.a aVar, int i3) {
        AppMethodBeat.i(229648);
        List<LocalUsageInfo> a2 = this.oBQ.a(i2, aVar, i3);
        AppMethodBeat.o(229648);
        return a2;
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void add(com.tencent.f.j.a aVar, MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(229636);
        this.oBQ.add(aVar, iOnStorageChange);
        AppMethodBeat.o(229636);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void add(MStorage.IOnStorageChange iOnStorageChange, Looper looper) {
        AppMethodBeat.i(229635);
        this.oBQ.add(iOnStorageChange, looper);
        AppMethodBeat.o(229635);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void add(String str, MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(229637);
        this.oBQ.add(str, iOnStorageChange);
        AppMethodBeat.o(229637);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void addLoadedListener(MStorage.IOnStorageLoaded iOnStorageLoaded) {
        AppMethodBeat.i(229639);
        this.oBQ.addLoadedListener(iOnStorageLoaded);
        AppMethodBeat.o(229639);
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final boolean bf(String str, int i2) {
        AppMethodBeat.i(229645);
        boolean bf = this.oBQ.bf(str, i2);
        AppMethodBeat.o(229645);
        return bf;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final int bg(String str, int i2) {
        AppMethodBeat.i(229638);
        int bg = this.oBQ.bg(str, i2);
        AppMethodBeat.o(229638);
        return bg;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final boolean bh(String str, int i2) {
        AppMethodBeat.i(229650);
        boolean bh = this.oBQ.bh(str, i2);
        AppMethodBeat.o(229650);
        return bh;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final void bxG() {
        AppMethodBeat.i(229649);
        this.oBQ.bxG();
        AppMethodBeat.o(229649);
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final int bxH() {
        AppMethodBeat.i(229644);
        int bxH = this.oBQ.bxH();
        AppMethodBeat.o(229644);
        return bxH;
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void doNotify() {
        AppMethodBeat.i(229640);
        this.oBQ.doNotify();
        AppMethodBeat.o(229640);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void doNotify(String str) {
        AppMethodBeat.i(229641);
        this.oBQ.doNotify(str);
        AppMethodBeat.o(229641);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void doNotify(String str, int i2, Object obj) {
        AppMethodBeat.i(229642);
        this.oBQ.doNotify(str, i2, obj);
        AppMethodBeat.o(229642);
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final boolean g(List<LocalUsageInfo> list, int i2) {
        AppMethodBeat.i(229652);
        boolean g2 = this.oBQ.g(list, i2);
        AppMethodBeat.o(229652);
        return g2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final int getCount() {
        AppMethodBeat.i(229643);
        int count = this.oBQ.getCount();
        AppMethodBeat.o(229643);
        return count;
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void lock() {
        AppMethodBeat.i(229646);
        this.oBQ.lock();
        AppMethodBeat.o(229646);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final int lockCount() {
        AppMethodBeat.i(229647);
        int lockCount = this.oBQ.lockCount();
        AppMethodBeat.o(229647);
        return lockCount;
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void removeLoadedListener(MStorage.IOnStorageLoaded iOnStorageLoaded) {
        AppMethodBeat.i(229651);
        this.oBQ.removeLoadedListener(iOnStorageLoaded);
        AppMethodBeat.o(229651);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void unlock() {
        AppMethodBeat.i(229653);
        this.oBQ.unlock();
        AppMethodBeat.o(229653);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.widget.recent.a
    public final /* synthetic */ List<? extends LocalUsageInfo> n(Object[] objArr) {
        AppMethodBeat.i(229629);
        p.h(objArr, "args");
        Iterator af = kotlin.g.b.b.af(objArr);
        DELEGATE_INTERFACE delegate_interface = this.oBJ;
        Object next = af.next();
        if (next == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(229629);
            throw tVar;
        }
        v a2 = delegate_interface.a(((Integer) next).intValue(), (ag.a) af.next());
        if (a2 == null) {
            a2 = v.SXr;
        }
        AppMethodBeat.o(229629);
        return a2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ag agVar) {
        super(agVar);
        p.h(agVar, "delegate");
        AppMethodBeat.i(229633);
        this.oBQ = agVar;
        AppMethodBeat.o(229633);
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final List<LocalUsageInfo> a(int i2, ag.a aVar) {
        AppMethodBeat.i(229628);
        List<LocalUsageInfo> list = (List) m(Integer.valueOf(i2), aVar);
        AppMethodBeat.o(229628);
        return list;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.m
    public final n ccO() {
        return i.oCS;
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void remove(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(229631);
        if (iOnStorageChange != null) {
            f(iOnStorageChange);
        }
        AppMethodBeat.o(229631);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public final void add(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(229632);
        if (iOnStorageChange != null) {
            e(iOnStorageChange);
        }
        AppMethodBeat.o(229632);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandCollectionStorageWithCache$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
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
        AppMethodBeat.i(229630);
        p.h(iOnStorageChange, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.oBJ.add(iOnStorageChange);
        AppMethodBeat.o(229630);
    }
}
