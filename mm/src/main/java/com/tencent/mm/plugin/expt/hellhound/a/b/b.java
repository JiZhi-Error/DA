package com.tencent.mm.plugin.expt.hellhound.a.b;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.plugin.expt.hellhound.core.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J(\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\u000e\u0010!\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\"\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010#\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010$\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0007J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u001cH\u0002J\u0010\u0010)\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u001cH\u0002J\u0016\u0010*\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010+\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010,\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u001aJ$\u0010.\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000101J\u0006\u00103\u001a\u00020\rR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderHomeMonitor;", "", "()V", "curFragmentRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v4/app/Fragment;", "mCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "statyTimeStatic", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "statyTimeStaticHome", "statyTimeStaticLbsList", "callbackOnFragmentPause", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v4/app/FragmentActivity;", "fragment", AppMeasurement.Param.TIMESTAMP, "", "fragmentEventId", "", "callbackOnFragmentResume", "getCurFragment", "Landroid/app/Activity;", "getCurFragmentOfFinderHomeUI", "isFeedFlowTypeFragment", "", "fragmentName", "", "isStatyTimeStaticInit", "isStatyTimeStaticLbsListInit", "isWaterfullFlowTypeFragment", "isstatyTimeStaticHomeInit", "onFinderHomeUIPause", "onFinderHomeUIResume", "onFinderLbsStreamListUIPause", "onFinderLbsStreamListUIResume", "registerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "startFragmentRecord", "pageName", "stopFragmentRecord", "switch2Back", "switch2Front", "switch2Page", "isResume", "switchFragment", "Lcom/tencent/mm/ui/MMActivity;", "lastFrag", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "curFrag", "unregisterListener", "Companion", "plugin-expt_release"})
public final class b {
    public static final a sCG = new a((byte) 0);
    public WeakReference<Fragment> sCC;
    private com.tencent.mm.plugin.expt.hellhound.a.b.c.b sCD;
    public com.tencent.mm.plugin.expt.hellhound.a.b.c.b sCE;
    public com.tencent.mm.plugin.expt.hellhound.a.b.c.b sCF;
    public d szZ;

    static {
        AppMethodBeat.i(220818);
        AppMethodBeat.o(220818);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderHomeMonitor$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final boolean cOD() {
        return this.sCD != null;
    }

    public final void a(FragmentActivity fragmentActivity, long j2, boolean z) {
        Class<?> cls;
        AppMethodBeat.i(220811);
        p.h(fragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        Fragment ae = ae(fragmentActivity);
        Log.d("HABBYGE-MALI.FinderHomeMonitor", "switch2Page: " + (z ? "onResumed" : "onPaused") + ", " + ((ae == null || (cls = ae.getClass()) == null) ? null : cls.getName()));
        if (ae == null) {
            AppMethodBeat.o(220811);
        } else if (z) {
            a(fragmentActivity, ae, j2, 0);
            AppMethodBeat.o(220811);
        } else {
            b(fragmentActivity, ae, j2, 1);
            AppMethodBeat.o(220811);
        }
    }

    public static Fragment ae(Activity activity) {
        AppMethodBeat.i(220812);
        Fragment cOk = h.cOk();
        if (cOk == null) {
            cOk = h.ab(activity);
        }
        AppMethodBeat.o(220812);
        return cOk;
    }

    public final void a(FragmentActivity fragmentActivity, Fragment fragment, long j2, int i2) {
        AppMethodBeat.i(220813);
        this.sCC = new WeakReference<>(fragment);
        String name = fragment.getClass().getName();
        p.g(name, "fragment.javaClass.name");
        Log.d("HABBYGE-MALI.FinderHomeMonitor", "callbackOnFragmentResume: ".concat(String.valueOf(name)));
        apo(name);
        if (apn(name)) {
            k kVar = k.sFY;
            k.a(fragmentActivity, fragment, i2);
        } else if (p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", name)) {
            k.a(fragmentActivity, fragment, j2, i2);
        }
        d dVar = this.szZ;
        if (dVar != null) {
            dVar.a(fragmentActivity, fragment, name, fragment.hashCode(), j2, true);
            AppMethodBeat.o(220813);
            return;
        }
        AppMethodBeat.o(220813);
    }

    public final void b(FragmentActivity fragmentActivity, Fragment fragment, long j2, int i2) {
        AppMethodBeat.i(220814);
        String name = fragment.getClass().getName();
        p.g(name, "fragment.javaClass.name");
        Log.d("HABBYGE-MALI.FinderHomeMonitor", "callbackOnFragmentPause: ".concat(String.valueOf(name)));
        app(name);
        if (apn(name)) {
            k kVar = k.sFY;
            k.b(fragmentActivity, fragment, i2);
        } else if (p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", name)) {
            k.b(fragmentActivity, fragment, j2, i2);
        }
        d dVar = this.szZ;
        if (dVar != null) {
            dVar.a(fragmentActivity, name, fragment.hashCode(), j2, true);
            AppMethodBeat.o(220814);
            return;
        }
        AppMethodBeat.o(220814);
    }

    private static boolean apn(String str) {
        AppMethodBeat.i(220815);
        if (p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", str) || p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", str) || p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", str)) {
            AppMethodBeat.o(220815);
            return true;
        }
        AppMethodBeat.o(220815);
        return false;
    }

    private final void apo(String str) {
        AppMethodBeat.i(220816);
        this.sCD = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
        com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar = this.sCD;
        if (bVar == null) {
            p.btv("statyTimeStatic");
        }
        bVar.sessionId = c.cPU().cMD();
        com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar2 = this.sCD;
        if (bVar2 == null) {
            p.btv("statyTimeStatic");
        }
        bVar2.dMl = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str);
        com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar3 = this.sCD;
        if (bVar3 == null) {
            p.btv("statyTimeStatic");
        }
        bVar3.sGC = System.currentTimeMillis();
        com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar4 = this.sCD;
        if (bVar4 == null) {
            p.btv("statyTimeStatic");
        }
        bVar4.sGF = "143";
        com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar5 = this.sCD;
        if (bVar5 == null) {
            p.btv("statyTimeStatic");
        }
        bVar5.dYn = c.b.EXPOSURE.value;
        AppMethodBeat.o(220816);
    }

    private final void app(String str) {
        AppMethodBeat.i(220817);
        String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str);
        if (cOD()) {
            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar = this.sCD;
            if (bVar == null) {
                p.btv("statyTimeStatic");
            }
            if (p.j(bVar.dMl, aoE)) {
                com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar2 = this.sCD;
                if (bVar2 == null) {
                    p.btv("statyTimeStatic");
                }
                bVar2.sGD = System.currentTimeMillis();
                com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar3 = this.sCD;
                if (bVar3 == null) {
                    p.btv("statyTimeStatic");
                }
                com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar4 = this.sCD;
                if (bVar4 == null) {
                    p.btv("statyTimeStatic");
                }
                long j2 = bVar4.sGD;
                com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar5 = this.sCD;
                if (bVar5 == null) {
                    p.btv("statyTimeStatic");
                }
                bVar3.sGB = j2 - bVar5.sGC;
                com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar6 = this.sCD;
                if (bVar6 == null) {
                    p.btv("statyTimeStatic");
                }
                bVar6.sGE = com.tencent.mm.plugin.expt.hellhound.core.b.cNC();
                com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar7 = this.sCD;
                if (bVar7 == null) {
                    p.btv("statyTimeStatic");
                }
                bVar7.sGF = "143";
                a.C1016a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
                com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar8 = this.sCD;
                if (bVar8 == null) {
                    p.btv("statyTimeStatic");
                }
                a.C1016a.a(bVar8);
            }
        }
        AppMethodBeat.o(220817);
    }
}
