package com.tencent.mm.plugin.appbrand.ui.recents;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.view.aa;
import android.support.v4.view.u;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.v;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class n extends v {
    boolean odN = false;
    boolean odO = true;
    private final RecyclerView.f.a odP = new RecyclerView.f.a() {
        /* class com.tencent.mm.plugin.appbrand.ui.recents.n.AnonymousClass1 */

        @Override // android.support.v7.widget.RecyclerView.f.a
        public final void lD() {
            AppMethodBeat.i(49231);
            synchronized (n.this.odQ) {
                try {
                    Iterator it = new HashSet(n.this.odQ).iterator();
                    while (it.hasNext()) {
                        ((RecyclerView.f.a) it.next()).lD();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(49231);
                    throw th;
                }
            }
            n.this.oeg = false;
            AppMethodBeat.o(49231);
        }
    };
    final Set<RecyclerView.f.a> odQ = new HashSet();
    private final Interpolator odR = new AccelerateDecelerateInterpolator();
    private final ArrayList<b> odS = new ArrayList<>();
    final ArrayList<RecyclerView.v> odT = new ArrayList<>();
    private final ArrayList<d> odU = new ArrayList<>();
    final ArrayList<RecyclerView.v> odV = new ArrayList<>();
    private final ArrayList<AppBrandLauncherRecentsList.e> odW = new ArrayList<>();
    final ArrayList<AppBrandLauncherRecentsList.e> odX = new ArrayList<>();
    private final ArrayList<AppBrandLauncherRecentsList.e> odY = new ArrayList<>();
    final ArrayList<AppBrandLauncherRecentsList.e> odZ = new ArrayList<>();
    private final ArrayList<f> oea = new ArrayList<>();
    final ArrayList<AppBrandLauncherRecentsList.e> oeb = new ArrayList<>();
    private final ArrayList<RecyclerView.v> oec = new ArrayList<>();
    private final ArrayList<AppBrandLauncherRecentsList.e> oed = new ArrayList<>();
    final ArrayList<AppBrandLauncherRecentsList.e> oee = new ArrayList<>();
    final ArrayList<AppBrandLauncherRecentsList.e> oef = new ArrayList<>();
    boolean oeg = false;

    /* access modifiers changed from: package-private */
    public static final class b extends g {
    }

    /* access modifiers changed from: package-private */
    public static final class d extends g {
    }

    static class g {
        int amL;
        AppBrandLauncherRecentsList.e oek;
    }

    n() {
        AppMethodBeat.i(49247);
        AppMethodBeat.o(49247);
    }

    /* access modifiers changed from: package-private */
    public final void b(RecyclerView.f.a aVar) {
        AppMethodBeat.i(49248);
        if (aVar != null) {
            synchronized (this.odQ) {
                try {
                    this.odQ.add(aVar);
                } finally {
                    AppMethodBeat.o(49248);
                }
            }
            return;
        }
        AppMethodBeat.o(49248);
    }

    /* access modifiers changed from: package-private */
    public final void c(RecyclerView.f.a aVar) {
        AppMethodBeat.i(49249);
        if (aVar != null) {
            synchronized (this.odQ) {
                try {
                    this.odQ.remove(aVar);
                } finally {
                    AppMethodBeat.o(49249);
                }
            }
            return;
        }
        AppMethodBeat.o(49249);
    }

    private void e(RecyclerView.v vVar) {
        AppMethodBeat.i(49250);
        vVar.aus.animate().setInterpolator(new ValueAnimator().getInterpolator());
        d(vVar);
        u.f(vVar.aus, 0.0f);
        u.g(vVar.aus, 1.0f);
        AppMethodBeat.o(49250);
    }

    @Override // android.support.v7.widget.RecyclerView.f, android.support.v7.widget.v
    public final boolean isRunning() {
        AppMethodBeat.i(49251);
        if (!this.odS.isEmpty() || !this.odT.isEmpty() || !this.odU.isEmpty() || !this.odV.isEmpty() || !this.odW.isEmpty() || !this.odX.isEmpty() || !this.odY.isEmpty() || !this.odZ.isEmpty() || !this.oea.isEmpty() || !this.oeb.isEmpty() || !this.oed.isEmpty() || !this.oee.isEmpty() || !this.oef.isEmpty() || super.isRunning()) {
            AppMethodBeat.o(49251);
            return true;
        }
        AppMethodBeat.o(49251);
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.f, android.support.v7.widget.v
    public final void jD() {
        AppMethodBeat.i(49252);
        a(this.odP);
        if (!this.odS.isEmpty()) {
            Iterator<b> it = this.odS.iterator();
            while (it.hasNext()) {
                b next = it.next();
                this.odT.add(next.oek);
                final AppBrandLauncherRecentsList.e eVar = next.oek;
                View view = next.oek.aus;
                next.oek.odd.setVisibility(0);
                u.f(view, 0.0f);
                final y ah = u.ah(view);
                ah.j(Math.max(this.atp, Math.min(Math.round((((double) next.amL) / ((double) next.oek.aus.getHeight())) * ((double) this.atp)) + this.atp, 400L)));
                ah.a(this.odR);
                ah.a(new aa() {
                    /* class com.tencent.mm.plugin.appbrand.ui.recents.n.AnonymousClass2 */

                    @Override // android.support.v4.view.aa, android.support.v4.view.z
                    public final void aI(View view) {
                        AppMethodBeat.i(49232);
                        ((RecentsRecyclerView) view.getParent()).cJ(view);
                        n.this.C(eVar);
                        AppMethodBeat.o(49232);
                    }

                    @Override // android.support.v4.view.aa, android.support.v4.view.z
                    public final void aJ(View view) {
                        AppMethodBeat.i(49233);
                        if (view == null) {
                            AppMethodBeat.o(49233);
                            return;
                        }
                        ((RecentsRecyclerView) view.getParent()).cK(view);
                        ah.a((z) null);
                        u.f(view, 0.0f);
                        n.this.w(eVar);
                        n.this.odT.remove(eVar);
                        n.a(n.this);
                        AppMethodBeat.o(49233);
                    }

                    @Override // android.support.v4.view.aa, android.support.v4.view.z
                    public final void aK(View view) {
                        AppMethodBeat.i(49234);
                        if (view == null) {
                            AppMethodBeat.o(49234);
                            return;
                        }
                        u.f(view, 0.0f);
                        u.g(view, 1.0f);
                        AppMethodBeat.o(49234);
                    }
                });
                ah.z((float) ((-next.amL) - view.getHeight())).start();
            }
            this.odS.clear();
        }
        if (!this.odU.isEmpty()) {
            Iterator<d> it2 = this.odU.iterator();
            while (it2.hasNext()) {
                d next2 = it2.next();
                this.odV.add(next2.oek);
                final AppBrandLauncherRecentsList.e eVar2 = next2.oek;
                View view2 = next2.oek.aus;
                next2.oek.odd.setVisibility(8);
                u.f(view2, 0.0f);
                final y ah2 = u.ah(view2);
                ah2.j(this.atp);
                ah2.a(new aa() {
                    /* class com.tencent.mm.plugin.appbrand.ui.recents.n.AnonymousClass3 */

                    @Override // android.support.v4.view.aa, android.support.v4.view.z
                    public final void aI(View view) {
                        AppMethodBeat.i(49235);
                        ((RecentsRecyclerView) view.getParent()).cJ(view);
                        n.this.C(eVar2);
                        AppMethodBeat.o(49235);
                    }

                    @Override // android.support.v4.view.aa, android.support.v4.view.z
                    public final void aJ(View view) {
                        AppMethodBeat.i(49236);
                        if (view == null) {
                            AppMethodBeat.o(49236);
                            return;
                        }
                        ((RecentsRecyclerView) view.getParent()).cK(view);
                        ah2.a((z) null);
                        u.f(view, 0.0f);
                        n.this.w(eVar2);
                        n.this.odV.remove(eVar2);
                        n.a(n.this);
                        AppMethodBeat.o(49236);
                    }

                    @Override // android.support.v4.view.aa, android.support.v4.view.z
                    public final void aK(View view) {
                        AppMethodBeat.i(49237);
                        if (view == null) {
                            AppMethodBeat.o(49237);
                            return;
                        }
                        u.f(view, 0.0f);
                        u.g(view, 1.0f);
                        AppMethodBeat.o(49237);
                    }
                });
                ah2.z((float) (((RecentsRecyclerView) view2.getParent()).getHeight() - next2.amL)).start();
            }
            this.odU.clear();
        }
        if (!this.odW.isEmpty()) {
            Iterator<AppBrandLauncherRecentsList.e> it3 = this.odW.iterator();
            while (it3.hasNext()) {
                final AppBrandLauncherRecentsList.e next3 = it3.next();
                this.odX.add(next3);
                u.h(next3.odd, 0.1f);
                u.i(next3.odd, 0.1f);
                u.g(next3.odd, 0.0f);
                next3.odd.setVisibility(0);
                final y ah3 = u.ah(next3.odd);
                ah3.j(this.atq);
                ah3.a(new aa() {
                    /* class com.tencent.mm.plugin.appbrand.ui.recents.n.AnonymousClass4 */

                    @Override // android.support.v4.view.aa, android.support.v4.view.z
                    public final void aI(View view) {
                    }

                    @Override // android.support.v4.view.aa, android.support.v4.view.z
                    public final void aJ(View view) {
                        AppMethodBeat.i(49238);
                        ah3.a((z) null);
                        n.this.n(next3);
                        n.this.odX.remove(next3);
                        n.a(n.this);
                        AppMethodBeat.o(49238);
                    }

                    @Override // android.support.v4.view.aa, android.support.v4.view.z
                    public final void aK(View view) {
                        AppMethodBeat.i(49239);
                        if (view == null) {
                            AppMethodBeat.o(49239);
                            return;
                        }
                        u.f(view, 0.0f);
                        u.g(view, 1.0f);
                        AppMethodBeat.o(49239);
                    }
                });
                ah3.y(1.0f).A(1.0f).B(1.0f).start();
            }
            this.odW.clear();
        }
        if (!this.odY.isEmpty()) {
            Iterator<AppBrandLauncherRecentsList.e> it4 = this.odY.iterator();
            while (it4.hasNext()) {
                final AppBrandLauncherRecentsList.e next4 = it4.next();
                this.odZ.add(next4);
                u.h(next4.odd, 1.0f);
                u.i(next4.odd, 1.0f);
                u.g(next4.odd, 1.0f);
                next4.odd.setVisibility(0);
                y ah4 = u.ah(next4.odd);
                ah4.j(this.atq);
                ah4.a(new aa() {
                    /* class com.tencent.mm.plugin.appbrand.ui.recents.n.AnonymousClass5 */

                    @Override // android.support.v4.view.aa, android.support.v4.view.z
                    public final void aI(View view) {
                    }

                    @Override // android.support.v4.view.aa, android.support.v4.view.z
                    public final void aJ(View view) {
                        AppMethodBeat.i(49240);
                        u.h(next4.odd, 1.0f);
                        u.i(next4.odd, 1.0f);
                        u.g(next4.odd, 1.0f);
                        next4.odd.setVisibility(8);
                        n.this.n(next4);
                        n.this.odZ.remove(next4);
                        n.a(n.this);
                        AppMethodBeat.o(49240);
                    }
                });
                ah4.y(0.0f).A(0.1f).B(0.1f).start();
            }
            this.odY.clear();
        }
        if (!this.oea.isEmpty()) {
            Iterator<f> it5 = this.oea.iterator();
            while (it5.hasNext()) {
                f next5 = it5.next();
                this.oeb.add(next5.oek);
                View view3 = next5.oek.aus;
                u.f(view3, 0.0f);
                u.g(view3, 1.0f);
                final AppBrandLauncherRecentsList.e eVar3 = next5.oek;
                y ah5 = u.ah(view3);
                ah5.j(this.atp);
                ah5.a(new aa() {
                    /* class com.tencent.mm.plugin.appbrand.ui.recents.n.AnonymousClass6 */

                    @Override // android.support.v4.view.aa, android.support.v4.view.z
                    public final void aI(View view) {
                        AppMethodBeat.i(49241);
                        n.this.C(eVar3);
                        AppMethodBeat.o(49241);
                    }

                    @Override // android.support.v4.view.aa, android.support.v4.view.z
                    public final void aJ(View view) {
                        AppMethodBeat.i(49242);
                        u.f(view, 0.0f);
                        u.g(view, 1.0f);
                        n.this.w(eVar3);
                        n.this.oeb.remove(eVar3);
                        n.a(n.this);
                        AppMethodBeat.o(49242);
                    }
                });
                ah5.y(0.0f).z((float) (-view3.getHeight())).start();
            }
            this.oea.clear();
        }
        super.jD();
        if (!this.oed.isEmpty()) {
            this.oee.addAll(this.oed);
            AnonymousClass7 r1 = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.recents.n.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(49243);
                    Iterator<AppBrandLauncherRecentsList.e> it = n.this.oee.iterator();
                    while (it.hasNext()) {
                        AppBrandLauncherRecentsList.e next = it.next();
                        n nVar = n.this;
                        y ah = u.ah(next.aus);
                        nVar.oef.add(next);
                        ah.z(0.0f).j(nVar.atp).a(new aa(next, ah) {
                            /* class com.tencent.mm.plugin.appbrand.ui.recents.n.AnonymousClass8 */
                            final /* synthetic */ y oei;
                            final /* synthetic */ AppBrandLauncherRecentsList.e oej;

                            {
                                this.oej = r2;
                                this.oei = r3;
                            }

                            @Override // android.support.v4.view.aa, android.support.v4.view.z
                            public final void aI(View view) {
                            }

                            @Override // android.support.v4.view.aa, android.support.v4.view.z
                            public final void aK(View view) {
                                AppMethodBeat.i(49244);
                                if (view == null) {
                                    AppMethodBeat.o(49244);
                                    return;
                                }
                                u.f(view, 0.0f);
                                u.g(view, 1.0f);
                                AppMethodBeat.o(49244);
                            }

                            @Override // android.support.v4.view.aa, android.support.v4.view.z
                            public final void aJ(View view) {
                                AppMethodBeat.i(49245);
                                this.oei.a((z) null);
                                n.this.n(this.oej);
                                n.this.oef.remove(this.oej);
                                n.a(n.this);
                                AppMethodBeat.o(49245);
                            }
                        }).start();
                    }
                    n.this.oee.clear();
                    AppMethodBeat.o(49243);
                }
            };
            this.oed.clear();
            if (this.oeg) {
                u.a(this.oee.get(0).aus, r1, ly());
                AppMethodBeat.o(49252);
                return;
            }
            r1.run();
        }
        AppMethodBeat.o(49252);
    }

    @Override // android.support.v7.widget.as
    public final void C(RecyclerView.v vVar) {
        AppMethodBeat.i(49253);
        super.C(vVar);
        if (!this.oeb.contains(vVar)) {
            this.oeg = true;
        }
        AppMethodBeat.o(49253);
    }

    @Override // android.support.v7.widget.v, android.support.v7.widget.as
    public final boolean a(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(49254);
        if (!this.odO) {
            e(vVar);
            x(vVar);
            AppMethodBeat.o(49254);
            return false;
        }
        boolean a2 = super.a(vVar, i2, i3, i4, i5);
        AppMethodBeat.o(49254);
        return a2;
    }

    @Override // android.support.v7.widget.v, android.support.v7.widget.as
    public final boolean c(RecyclerView.v vVar) {
        AppMethodBeat.i(49255);
        e(vVar);
        n(vVar);
        AppMethodBeat.o(49255);
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.f, android.support.v7.widget.v
    public final void d(RecyclerView.v vVar) {
        AppMethodBeat.i(49256);
        if ((vVar instanceof AppBrandLauncherRecentsList.e) && this.oed.remove(vVar)) {
            u.f(vVar.aus, 0.0f);
            n(vVar);
        }
        super.d(vVar);
        AppMethodBeat.o(49256);
    }

    @Override // android.support.v7.widget.RecyclerView.f, android.support.v7.widget.as
    public final boolean e(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        AppMethodBeat.i(49257);
        if (!this.odO) {
            boolean c2 = c(vVar);
            AppMethodBeat.o(49257);
            return c2;
        } else if (cVar == null || (cVar.left == cVar2.left && cVar.top == cVar2.top)) {
            if (this.odN && (vVar.aus.getParent() instanceof RecyclerView) && (vVar instanceof AppBrandLauncherRecentsList.e)) {
                RecyclerView recyclerView = (RecyclerView) vVar.aus.getParent();
                if (recyclerView.getHeight() > 0) {
                    if (cVar2.bottom >= recyclerView.getHeight()) {
                        AppBrandLauncherRecentsList.e eVar = (AppBrandLauncherRecentsList.e) vVar;
                        u.f(eVar.aus, (float) eVar.aus.getHeight());
                        this.oed.add(eVar);
                        AppMethodBeat.o(49257);
                        return true;
                    } else if (cVar2.top <= 0) {
                        AppBrandLauncherRecentsList.e eVar2 = (AppBrandLauncherRecentsList.e) vVar;
                        u.f(eVar2.aus, (float) (-eVar2.aus.getHeight()));
                        this.oed.add(eVar2);
                        AppMethodBeat.o(49257);
                        return true;
                    }
                }
            }
            boolean c3 = c(vVar);
            AppMethodBeat.o(49257);
            return c3;
        } else {
            boolean a2 = super.a(vVar, cVar.left, cVar.top, cVar2.left, cVar2.top);
            AppMethodBeat.o(49257);
            return a2;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.f, android.support.v7.widget.as
    public final boolean d(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        boolean z;
        AppMethodBeat.i(49258);
        if (!this.odO) {
            e(vVar);
            w(vVar);
            AppMethodBeat.o(49258);
            return false;
        } else if (cVar instanceof c) {
            e(vVar);
            AppMethodBeat.o(49258);
            return true;
        } else if (cVar instanceof e) {
            e(vVar);
            AppMethodBeat.o(49258);
            return true;
        } else {
            if ((cVar.atr & 2048) > 0 && (vVar instanceof AppBrandLauncherRecentsList.e) && cVar2 == null) {
                try {
                    z = ((AppBrandLauncherRecentsList.e) vVar).bYC().kVp;
                } catch (Exception e2) {
                    z = false;
                }
                if (!z) {
                    e(vVar);
                    this.oea.add(new f((AppBrandLauncherRecentsList.e) vVar, cVar.left, cVar.top, (byte) 0));
                    AppMethodBeat.o(49258);
                    return true;
                }
            }
            boolean d2 = super.d(vVar, cVar, cVar2);
            AppMethodBeat.o(49258);
            return d2;
        }
    }

    @Override // android.support.v7.widget.v, android.support.v7.widget.as
    public final boolean b(RecyclerView.v vVar) {
        AppMethodBeat.i(49259);
        if (!this.odO) {
            e(vVar);
            w(vVar);
            AppMethodBeat.o(49259);
            return false;
        }
        boolean b2 = super.b(vVar);
        AppMethodBeat.o(49259);
        return b2;
    }

    @Override // android.support.v7.widget.v, android.support.v7.widget.as
    public final boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(49260);
        if (u.ah(vVar.aus) == null) {
            u.g(vVar.aus, 1.0f);
            u.f(vVar.aus, 0.0f);
        }
        if (u.ah(vVar2.aus) == null) {
            u.g(vVar2.aus, 1.0f);
            u.f(vVar2.aus, 0.0f);
        }
        n(vVar);
        n(vVar2);
        AppMethodBeat.o(49260);
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.f, android.support.v7.widget.as
    public final boolean f(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        AppMethodBeat.i(49261);
        if (!this.odO) {
            e(vVar);
            x(vVar);
            AppMethodBeat.o(49261);
            return false;
        }
        boolean f2 = super.f(vVar, cVar, cVar2);
        AppMethodBeat.o(49261);
        return f2;
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final void o(RecyclerView.v vVar) {
        AppMethodBeat.i(49262);
        super.o(vVar);
        ViewParent parent = vVar.aus.getParent();
        if (parent instanceof RecentsRecyclerView) {
            ((RecentsRecyclerView) parent).cK(vVar.aus);
        }
        AppMethodBeat.o(49262);
    }

    @Override // android.support.v7.widget.as
    public final void E(RecyclerView.v vVar) {
        AppMethodBeat.i(49263);
        super.E(vVar);
        if (this.oec.contains(vVar)) {
            ((RecentsRecyclerView) vVar.aus.getParent()).cJ(vVar.aus);
        }
        AppMethodBeat.o(49263);
    }

    @Override // android.support.v7.widget.as
    public final void F(RecyclerView.v vVar) {
        AppMethodBeat.i(49264);
        super.F(vVar);
        if (this.oec.contains(vVar)) {
            this.oec.remove(vVar);
            ((RecentsRecyclerView) vVar.aus.getParent()).cK(vVar.aus);
        }
        AppMethodBeat.o(49264);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final RecyclerView.f.c a(RecyclerView.s sVar, RecyclerView.v vVar, int i2, List<Object> list) {
        AppMethodBeat.i(49265);
        if ((i2 & 2) > 0) {
            for (Object obj : list) {
                if (obj instanceof Bundle) {
                    Boolean bool = (Boolean) ((Bundle) obj).get("star");
                    if (bool != null && bool.booleanValue()) {
                        RecyclerView.f.c c2 = new c((byte) 0).c(vVar, i2);
                        AppMethodBeat.o(49265);
                        return c2;
                    } else if (bool != null && !bool.booleanValue()) {
                        RecyclerView.f.c c3 = new e((byte) 0).c(vVar, i2);
                        AppMethodBeat.o(49265);
                        return c3;
                    }
                }
            }
        }
        RecyclerView.f.c a2 = super.a(sVar, vVar, i2, list);
        a2.atr = i2;
        AppMethodBeat.o(49265);
        return a2;
    }

    @Override // android.support.v7.widget.RecyclerView.f, android.support.v7.widget.as
    public final boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        AppMethodBeat.i(49266);
        if (!this.odO) {
            n(vVar);
            n(vVar2);
            AppMethodBeat.o(49266);
            return false;
        }
        boolean a2 = super.a(vVar, vVar2, cVar, cVar2);
        AppMethodBeat.o(49266);
        return a2;
    }

    @Override // android.support.v7.widget.RecyclerView.f, android.support.v7.widget.v
    public final boolean a(RecyclerView.v vVar, List<Object> list) {
        AppMethodBeat.i(49267);
        boolean a2 = super.a(vVar, list);
        if ((vVar instanceof AppBrandLauncherRecentsList.e) || a2) {
            AppMethodBeat.o(49267);
            return true;
        }
        AppMethodBeat.o(49267);
        return false;
    }

    /* access modifiers changed from: package-private */
    public static class f {
        int amK;
        int amL;
        AppBrandLauncherRecentsList.e oek;

        /* synthetic */ f(AppBrandLauncherRecentsList.e eVar, int i2, int i3, byte b2) {
            this(eVar, i2, i3);
        }

        private f(AppBrandLauncherRecentsList.e eVar, int i2, int i3) {
            this.oek = eVar;
            this.amK = i2;
            this.amL = i3;
        }
    }

    static class a extends RecyclerView.f.c {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // android.support.v7.widget.RecyclerView.f.c
        public final RecyclerView.f.c c(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(49246);
            super.c(vVar, i2);
            this.atr = i2;
            AppMethodBeat.o(49246);
            return this;
        }
    }

    static final class c extends a {
        private c() {
            super((byte) 0);
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    static final class e extends a {
        private e() {
            super((byte) 0);
        }

        /* synthetic */ e(byte b2) {
            this();
        }
    }

    static /* synthetic */ void a(n nVar) {
        AppMethodBeat.i(49268);
        if (!nVar.isRunning()) {
            nVar.lC();
        }
        AppMethodBeat.o(49268);
    }
}
