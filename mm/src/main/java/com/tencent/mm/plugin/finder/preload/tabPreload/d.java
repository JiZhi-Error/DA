package com.tencent.mm.plugin.finder.preload.tabPreload;

import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.preload.tabPreload.a;
import com.tencent.mm.plugin.finder.preload.tabPreload.f;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J=\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00120\u001eH\u0016¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/tabPreload/HotTabPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "getOutTimeOutPreloadSource", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "getOuterTime", "", "isAcceptCgiBack", "", "source", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "isValid", "log", "", "performChangeEnterTargetTab", "", "lastTab", "", "targetTab", "performServerConfigChanged", "fromTabType", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "preload", "intent", "Landroid/content/Intent;", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "Lkotlin/ParameterName;", "name", "ret", "plugin-finder_release"})
public final class d extends f {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(FinderStreamTabPreloadCore finderStreamTabPreloadCore) {
        super(4, finderStreamTabPreloadCore);
        p.h(finderStreamTabPreloadCore, "core");
        AppMethodBeat.i(249587);
        AppMethodBeat.o(249587);
    }

    @Override // com.tencent.mm.plugin.finder.preload.tabPreload.f
    public final f.c dlJ() {
        return f.c.OutSideJumpHot;
    }

    @Override // com.tencent.mm.plugin.finder.preload.tabPreload.f
    public final void gc(int i2, int i3) {
        AppMethodBeat.i(249582);
        super.gc(i2, i3);
        boolean isInFinder = ((PluginFinder) g.ah(PluginFinder.class)).isInFinder();
        Log.i(this.TAG, "[performChangeEnterTargetTab] isInFinder=".concat(String.valueOf(isInFinder)));
        if (i3 != this.dLS) {
            this.uVb.aut("performChangeEnterTargetTab");
            AppMethodBeat.o(249582);
            return;
        }
        if (!isInFinder) {
            Log.i(this.TAG, "[performChangeEnterTargetTab] clearCache lastTab=" + i2 + " targetTab=" + i3);
            nM(true);
            this.uVb.a(this.uVf, dlK(), "performChangeEnterTargetTab");
        }
        AppMethodBeat.o(249582);
    }

    @Override // com.tencent.mm.plugin.finder.preload.tabPreload.f
    public final void a(int i2, bcy bcy) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(249583);
        p.h(bcy, "serverConfig");
        super.a(i2, bcy);
        c cVar = c.vCb;
        int intValue = c.duu().value().intValue();
        boolean z3 = bcy.LMv;
        if (intValue >= 0) {
            if (intValue == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        if (i2 == this.dLS || !z3 || !this.uVa) {
            Log.i(this.TAG, "[performConfigChange] not need to check hot preload. debugValue=" + intValue + " fromTabType=" + i2);
            AppMethodBeat.o(249583);
            return;
        }
        boolean JN = this.uVh.JN(this.dLS);
        if (this.uVg.uVi != null) {
            z = true;
        } else {
            z = false;
        }
        long JO = FinderStreamTabPreloadCore.JO(this.dLS);
        if (cl.aWA() - this.uVg.hwQ < FinderStreamTabPreloadCore.JO(this.dLS)) {
            z2 = false;
        }
        Log.i(this.TAG, "[performConfigChange] isAutoRefresh=" + JN + " isLoading=" + this.isLoading + " isOverTime=" + z2 + " expired=" + JO + " debugValue=" + intValue + " hasCache=" + z);
        if (!JN || this.isLoading || !z2) {
            Log.i(this.TAG, "[performConfigChange] not need to preload. debugValue=".concat(String.valueOf(intValue)));
            AppMethodBeat.o(249583);
            return;
        }
        this.uVb.aut("performServerConfigChanged");
        this.uVb.a(new a(this), 0, "performConfigChange");
        AppMethodBeat.o(249583);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/preload/tabPreload/HotTabPreloadWorker$performServerConfigChanged$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "run", "", "plugin-finder_release"})
    public static final class a extends a.AbstractRunnableC1255a {
        final /* synthetic */ d uUX;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.preload.tabPreload.d$a$a  reason: collision with other inner class name */
        static final class C1256a extends q implements b<f.d, x> {
            public static final C1256a uUY = new C1256a();

            static {
                AppMethodBeat.i(249579);
                AppMethodBeat.o(249579);
            }

            C1256a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(f.d dVar) {
                AppMethodBeat.i(249578);
                p.h(dVar, LocaleUtil.ITALIAN);
                x xVar = x.SXb;
                AppMethodBeat.o(249578);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(d dVar) {
            this.uUX = dVar;
        }

        public final void run() {
            AppMethodBeat.i(249580);
            this.uUX.a(f.c.InsideConfigNotify, null, C1256a.uUY);
            AppMethodBeat.o(249580);
        }
    }

    @Override // com.tencent.mm.plugin.finder.preload.tabPreload.f
    public final boolean a(f.c cVar, aa.f fVar) {
        boolean z = true;
        AppMethodBeat.i(249584);
        p.h(cVar, "source");
        p.h(fVar, "resp");
        if (cVar == f.c.EnterLoad) {
            Log.i(this.TAG, "[isAcceptCgiBack] is finder enter load.");
            AppMethodBeat.o(249584);
            return true;
        }
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        if (((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).wtW == 4) {
            Log.i(this.TAG, "[isAcceptCgiBack] is In hot tab.");
            AppMethodBeat.o(249584);
            return false;
        }
        if (cVar == f.c.OutSideJumpHot) {
            if (cl.aWA() - this.uVg.hwQ < FinderStreamTabPreloadCore.al(this.dLS, false)) {
                z = false;
            }
        } else if (cl.aWA() - this.uVg.hwQ < FinderStreamTabPreloadCore.JO(this.dLS)) {
            z = false;
        }
        if (!z) {
            Log.i(this.TAG, "[isAcceptCgiBack] is not over time. lastTime=" + this.uVg.hwQ);
            AppMethodBeat.o(249584);
            return false;
        } else if (cVar != f.c.OutSideJumpHot || !this.uVa) {
            boolean a2 = super.a(cVar, fVar);
            AppMethodBeat.o(249584);
            return a2;
        } else {
            Log.i(this.TAG, "[isAcceptCgiBack] is form outside but now is in finder.");
            AppMethodBeat.o(249584);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.finder.preload.tabPreload.f
    public final void a(f.c cVar, Intent intent, b<? super f.d, x> bVar) {
        AppMethodBeat.i(249585);
        p.h(cVar, "source");
        p.h(bVar, "call");
        if (FinderStreamTabPreloadCore.a(cVar) && a((f) cVar, (f.c) "") && cVar != f.c.EnterLoad) {
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            boolean j2 = p.j(aAh.azQ().get(ar.a.USERINFO_MY_FINDER_FIRST_HOT_TAB_PRELOAD_INT_SYNC, (Object) 0), 0);
            c cVar2 = c.vCb;
            int intValue = c.duH().value().intValue();
            if (intValue <= 0 || !j2 || SystemClock.uptimeMillis() % ((long) intValue) == 0) {
                e aAh2 = g.aAh();
                p.g(aAh2, "MMKernel.storage()");
                aAh2.azQ().set(ar.a.USERINFO_MY_FINDER_FIRST_HOT_TAB_PRELOAD_INT_SYNC, (Object) 1);
            } else {
                Log.i(this.TAG, "[isValid] isFirst but not hit, random=".concat(String.valueOf(intValue)));
                bVar.invoke(f.d.INVALID);
                AppMethodBeat.o(249585);
                return;
            }
        }
        super.a(cVar, intent, bVar);
        AppMethodBeat.o(249585);
    }

    @Override // com.tencent.mm.plugin.finder.preload.tabPreload.f
    public final long dlK() {
        AppMethodBeat.i(249581);
        long al = FinderStreamTabPreloadCore.al(this.dLS, false);
        AppMethodBeat.o(249581);
        return al;
    }

    @Override // com.tencent.mm.plugin.finder.preload.tabPreload.f
    public final boolean a(f.c cVar, String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(249586);
        p.h(cVar, "source");
        p.h(str, "log");
        if (this.uVh.dlH().dHR() == 4) {
            z = true;
        } else {
            z = false;
        }
        boolean JN = this.uVh.JN(this.dLS);
        if (((cVar == f.c.OutSideTimeout || cVar == f.c.OutSideJumpHot || cVar == f.c.EnterLoad) && z && JN) || (cVar == f.c.InsideConfigNotify && this.uVa)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!super.a(cVar, ", ret=" + z2 + " targetEnterHot=" + z + " isAutoRefresh=" + JN) || !z2) {
            AppMethodBeat.o(249586);
            return false;
        }
        AppMethodBeat.o(249586);
        return true;
    }
}
