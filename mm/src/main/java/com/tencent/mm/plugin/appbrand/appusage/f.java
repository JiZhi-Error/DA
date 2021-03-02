package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import android.support.v7.h.c;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.aa;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.c;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.storage.MStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002+,B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\u001a\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J$\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J,\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\u0012\u0010 \u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010!\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J \u0010\"\u001a\u00020\u00152\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010$\u001a\u00020\u000eH\u0016J\"\u0010%\u001a\u00020\u00152\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(J\u000e\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "mCalculatingDiff", "Ljava/util/concurrent/atomic/AtomicBoolean;", "add", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "looper", "Landroid/os/Looper;", "addCollection", "", ch.COL_USERNAME, "", "versionType", "getCount", "getCountLimit", "isCollection", "", "onRegister", "onUnregister", SearchIntents.EXTRA_QUERY, "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "refreshOnPullDownOpen", "refreshOnPullDownOpenAnimationEnd", "remove", "removeCollection", "reorder", "reorderList", "reason", "reorderWithCallback", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "restoreNotfityMsgRefuseStatus", "info", "Companion", "ReorderCallback", "plugin-appbrand-integration_release"})
public final class f extends MStorage implements com.tencent.mm.kernel.c.b, ag {
    private static f kUm;
    public static final a kUn = new a((byte) 0);
    private final AtomicBoolean kUl = new AtomicBoolean(false);

    static {
        AppMethodBeat.i(50264);
        AppMethodBeat.o(50264);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$Companion;", "", "()V", "STORAGE", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "getSTORAGE", "()Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "setSTORAGE", "(Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;)V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public f() {
        AppMethodBeat.i(50263);
        AppMethodBeat.o(50263);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "()V", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onMoved", "prev", "next", "onRemoved", "onReorderEnd", "plugin-appbrand-integration_release"})
    public static class b implements c.b {
        @Override // com.tencent.mm.plugin.appbrand.appusage.c.b
        public void b(LocalUsageInfo localUsageInfo) {
            AppMethodBeat.i(50243);
            p.h(localUsageInfo, "info");
            AppMethodBeat.o(50243);
        }

        @Override // com.tencent.mm.plugin.appbrand.appusage.c.b
        public final void c(LocalUsageInfo localUsageInfo) {
            AppMethodBeat.i(50244);
            p.h(localUsageInfo, "info");
            AppMethodBeat.o(50244);
        }

        @Override // com.tencent.mm.plugin.appbrand.appusage.c.b
        public void d(LocalUsageInfo localUsageInfo) {
            AppMethodBeat.i(50245);
            p.h(localUsageInfo, "info");
            AppMethodBeat.o(50245);
        }

        public void bxJ() {
        }
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBc() {
        kUm = this;
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBd() {
        kUm = null;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final void bxG() {
        AppMethodBeat.i(50249);
        if (this.kUl.get()) {
            Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "refreshOnPullDownOpen, skip fetch when calculating diff");
            AppMethodBeat.o(50249);
            return;
        }
        Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "refreshOnPullDownOpen, fetch");
        j.bxQ().a(Util.nowMilliSecond(), true, null, 6, 0);
        h.bWb().a(g.WASERVICE, z.MAIN_PULLDOWN);
        h.bWb().a(g.WAGAME, z.MAIN_PULLDOWN);
        AppMethodBeat.o(50249);
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final boolean bf(String str, int i2) {
        boolean z;
        AppMethodBeat.i(50250);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(50250);
            return false;
        }
        u uVar = (u) n.W(u.class);
        if (str == null) {
            p.hyc();
        }
        boolean bj = uVar.bj(str, i2);
        AppMethodBeat.o(50250);
        return bj;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final int bg(String str, int i2) {
        AppMethodBeat.i(50251);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(50251);
            return -1;
        }
        u uVar = (u) n.W(u.class);
        if (str == null) {
            p.hyc();
        }
        int bk = uVar.bk(str, i2);
        AppMethodBeat.o(50251);
        return bk;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final boolean bh(String str, int i2) {
        boolean z;
        AppMethodBeat.i(50252);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(50252);
            return false;
        }
        u uVar = (u) n.W(u.class);
        if (str == null) {
            p.hyc();
        }
        boolean bl = uVar.bl(str, i2);
        AppMethodBeat.o(50252);
        return bl;
    }

    public final boolean a(List<? extends LocalUsageInfo> list, b bVar) {
        AppMethodBeat.i(50253);
        if (list == null) {
            if (WeChatEnvironment.hasDebugger()) {
                Assert.assertTrue("reorderList is NULL", false);
            } else {
                AppMethodBeat.o(50253);
                return false;
            }
        }
        this.kUl.set(true);
        e eVar = new e(this, list, bVar);
        if (MMHandlerThread.isMainThread()) {
            m.bZn().postToWorker(eVar);
        } else {
            eVar.run();
        }
        AppMethodBeat.o(50253);
        return true;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ f kUo;
        final /* synthetic */ List kUp;
        final /* synthetic */ b kUq;

        e(f fVar, List list, b bVar) {
            this.kUo = fVar;
            this.kUp = list;
            this.kUq = bVar;
        }

        public final void run() {
            AppMethodBeat.i(50248);
            List a2 = f.a(this.kUo);
            if (a2 == null) {
                a2 = v.SXr;
            }
            StringBuilder append = new StringBuilder("[collection] reorderWithCallback, before calculateDiff oldList.size=").append(a2.size()).append(" reorderList.size= ");
            List list = this.kUp;
            if (list == null) {
                p.hyc();
            }
            Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", append.append(list.size()).append(' ').toString());
            c.b a3 = android.support.v7.h.c.a(new ac(a2, this.kUp), true);
            StringBuilder append2 = new StringBuilder("[collection] reorderWithCallback, after calculateDiff oldList.size=").append(a2.size()).append(" reorderList.size= ");
            List list2 = this.kUp;
            if (list2 == null) {
                p.hyc();
            }
            Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", append2.append(list2.size()).append(' ').toString());
            c cVar = (c) com.tencent.mm.kernel.g.af(c.class);
            p.g(a3, "diff");
            List<? extends LocalUsageInfo> p = j.p(a2);
            List list3 = this.kUp;
            if (list3 == null) {
                p.hyc();
            }
            boolean a4 = cVar.a(a3, p, j.p(list3), this.kUq);
            Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, changed = ".concat(String.valueOf(a4)));
            if (a4) {
                ((u) n.W(u.class)).a(LocalUsageInfo.class, this.kUp, null);
            }
            this.kUo.kUl.set(false);
            Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, before run callback");
            b bVar = this.kUq;
            if (bVar != null) {
                bVar.bxJ();
                AppMethodBeat.o(50248);
                return;
            }
            AppMethodBeat.o(50248);
        }
    }

    public static void e(LocalUsageInfo localUsageInfo) {
        AppMethodBeat.i(228126);
        p.h(localUsageInfo, "info");
        String str = n.NL().get(q.a.Xj(localUsageInfo.appId), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        if (str == null) {
            p.hyc();
        }
        if (!Boolean.parseBoolean(str)) {
            n.NL().gC(q.a.Xj(localUsageInfo.appId));
        }
        AppMethodBeat.o(228126);
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final boolean g(List<LocalUsageInfo> list, int i2) {
        d dVar;
        AppMethodBeat.i(50255);
        Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "reorder reason = ".concat(String.valueOf(i2)));
        switch (i2) {
            case 0:
                dVar = new d(this);
                break;
            case 1:
                dVar = new c(this);
                break;
            default:
                dVar = null;
                break;
        }
        boolean a2 = a(list, dVar);
        AppMethodBeat.o(50255);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$reorder$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onReorderEnd", "plugin-appbrand-integration_release"})
    public static final class c extends b {
        final /* synthetic */ f kUo;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(f fVar) {
            this.kUo = fVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.appusage.f.b
        public final void bxJ() {
            AppMethodBeat.i(50246);
            ((c) com.tencent.mm.kernel.g.af(c.class)).a(aa.b.ClosePullDown);
            AppMethodBeat.o(50246);
        }

        @Override // com.tencent.mm.plugin.appbrand.appusage.f.b, com.tencent.mm.plugin.appbrand.appusage.c.b
        public final void b(LocalUsageInfo localUsageInfo) {
            AppMethodBeat.i(228124);
            p.h(localUsageInfo, "info");
            super.b(localUsageInfo);
            f.e(localUsageInfo);
            AppMethodBeat.o(228124);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$reorder$callback$2", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onReorderEnd", "plugin-appbrand-integration_release"})
    public static final class d extends b {
        final /* synthetic */ f kUo;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(f fVar) {
            this.kUo = fVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.appusage.f.b
        public final void bxJ() {
            AppMethodBeat.i(50247);
            ((c) com.tencent.mm.kernel.g.af(c.class)).a(aa.b.Timeout);
            AppMethodBeat.o(50247);
        }

        @Override // com.tencent.mm.plugin.appbrand.appusage.f.b, com.tencent.mm.plugin.appbrand.appusage.c.b
        public final void b(LocalUsageInfo localUsageInfo) {
            AppMethodBeat.i(228125);
            p.h(localUsageInfo, "info");
            super.b(localUsageInfo);
            f.e(localUsageInfo);
            AppMethodBeat.o(228125);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final List<? extends LocalUsageInfo> a(int i2, ag.a aVar) {
        AppMethodBeat.i(50256);
        if (i2 <= 0) {
            AppMethodBeat.o(50256);
            return null;
        }
        u uVar = (u) n.W(u.class);
        ArrayList<AppBrandRecentTaskInfo> b2 = uVar != null ? uVar.b(i2, aVar) : null;
        AppMethodBeat.o(50256);
        return b2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final List<? extends LocalUsageInfo> a(int i2, ag.a aVar, int i3) {
        AppMethodBeat.i(50257);
        if (i2 <= 0) {
            AppMethodBeat.o(50257);
            return null;
        }
        u uVar = (u) n.W(u.class);
        ArrayList<AppBrandRecentTaskInfo> b2 = uVar != null ? uVar.b(i2, aVar, i3) : null;
        AppMethodBeat.o(50257);
        return b2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final int getCount() {
        AppMethodBeat.i(50258);
        u uVar = (u) n.W(u.class);
        if (uVar != null) {
            int byk = uVar.byk();
            AppMethodBeat.o(50258);
            return byk;
        }
        AppMethodBeat.o(50258);
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final int bxH() {
        AppMethodBeat.i(50259);
        int byo = v.byo();
        AppMethodBeat.o(50259);
        return byo;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage, com.tencent.mm.sdk.storage.IStorage
    public final void add(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(50260);
        add(iOnStorageChange, Looper.getMainLooper());
        AppMethodBeat.o(50260);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage, com.tencent.mm.sdk.storage.IStorage
    public final void add(MStorage.IOnStorageChange iOnStorageChange, Looper looper) {
        AppMethodBeat.i(50261);
        u uVar = (u) n.W(u.class);
        if (uVar != null) {
            uVar.add(iOnStorageChange, looper);
        }
        com.tencent.mm.plugin.appbrand.config.z buC = n.buC();
        if (buC != null) {
            buC.add(iOnStorageChange, looper);
            AppMethodBeat.o(50261);
            return;
        }
        AppMethodBeat.o(50261);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage, com.tencent.mm.sdk.storage.IStorage
    public final void remove(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(50262);
        u uVar = (u) n.W(u.class);
        if (uVar != null) {
            uVar.remove(iOnStorageChange);
        }
        com.tencent.mm.plugin.appbrand.config.z buC = n.buC();
        if (buC != null) {
            buC.remove(iOnStorageChange);
            AppMethodBeat.o(50262);
            return;
        }
        AppMethodBeat.o(50262);
    }

    public static final /* synthetic */ List a(f fVar) {
        AppMethodBeat.i(50265);
        List<? extends LocalUsageInfo> a2 = fVar.a(Integer.MAX_VALUE, ag.a.DESC);
        AppMethodBeat.o(50265);
        return a2;
    }
}
