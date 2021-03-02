package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.u;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e extends as {
    private static TimeInterpolator amk;
    RecyclerView.a adj = null;
    private ArrayList<RecyclerView.v> aml = new ArrayList<>();
    private ArrayList<RecyclerView.v> amm = new ArrayList<>();
    private ArrayList<b> amn = new ArrayList<>();
    private ArrayList<a> amo = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.v>> amp = new ArrayList<>();
    ArrayList<ArrayList<b>> amq = new ArrayList<>();
    ArrayList<ArrayList<a>> amr = new ArrayList<>();
    ArrayList<RecyclerView.v> ams = new ArrayList<>();
    ArrayList<RecyclerView.v> amt = new ArrayList<>();
    ArrayList<RecyclerView.v> amu = new ArrayList<>();
    ArrayList<RecyclerView.v> amv = new ArrayList<>();
    private boolean opc = false;

    /* access modifiers changed from: package-private */
    public static class b {
        public int amK;
        public int amL;
        public int amM;
        public int amN;
        public RecyclerView.v amO;

        b(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
            this.amO = vVar;
            this.amK = i2;
            this.amL = i3;
            this.amM = i4;
            this.amN = i5;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public RecyclerView.v amI;
        public RecyclerView.v amJ;
        public int amK;
        public int amL;
        public int amM;
        public int amN;
        public boolean opf;

        private a(RecyclerView.v vVar, RecyclerView.v vVar2) {
            this.opf = false;
            this.amI = vVar;
            this.amJ = vVar2;
        }

        a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5) {
            this(vVar, vVar2);
            this.amK = i2;
            this.amL = i3;
            this.amM = i4;
            this.amN = i5;
        }

        public final String toString() {
            AppMethodBeat.i(49661);
            String str = "ChangeInfo{oldHolder=" + this.amI + ", newHolder=" + this.amJ + ", fromX=" + this.amK + ", fromY=" + this.amL + ", toX=" + this.amM + ", toY=" + this.amN + '}';
            AppMethodBeat.o(49661);
            return str;
        }
    }

    e() {
        AppMethodBeat.i(49662);
        this.atn = 200;
        this.atq = 200;
        this.atp = 200;
        this.ato = 200;
        AppMethodBeat.o(49662);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final void jD() {
        boolean z;
        boolean z2;
        boolean z3;
        long j2;
        long j3;
        AppMethodBeat.i(49663);
        boolean z4 = !this.aml.isEmpty();
        if (!this.amn.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (!this.amo.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!this.amm.isEmpty()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z4 || z || z3 || z2) {
            Iterator<RecyclerView.v> it = this.aml.iterator();
            while (it.hasNext()) {
                final RecyclerView.v next = it.next();
                final View view = next.aus;
                final ViewPropertyAnimator animate = view.animate();
                this.amu.add(next);
                animate.setDuration(ly()).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                    /* class com.tencent.mm.plugin.appbrand.widget.desktop.e.AnonymousClass4 */

                    public final void onAnimationStart(Animator animator) {
                        AppMethodBeat.i(49652);
                        e.this.C(next);
                        AppMethodBeat.o(49652);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(49653);
                        animate.setListener(null);
                        view.setAlpha(1.0f);
                        e.this.w(next);
                        e.this.amu.remove(next);
                        e.this.jE();
                        AppMethodBeat.o(49653);
                    }
                }).start();
            }
            this.aml.clear();
            if (z) {
                final ArrayList<b> arrayList = new ArrayList<>();
                arrayList.addAll(this.amn);
                this.amq.add(arrayList);
                this.amn.clear();
                AnonymousClass1 r8 = new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.widget.desktop.e.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(49649);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            e eVar = e.this;
                            RecyclerView.v vVar = bVar.amO;
                            int i2 = bVar.amK;
                            int i3 = bVar.amL;
                            int i4 = bVar.amM;
                            int i5 = bVar.amN;
                            View view = vVar.aus;
                            int i6 = i4 - i2;
                            int i7 = i5 - i3;
                            if (i6 != 0) {
                                view.animate().translationX(0.0f);
                            }
                            if (i7 != 0) {
                                view.animate().translationY(0.0f);
                            }
                            ViewPropertyAnimator animate = view.animate();
                            eVar.amt.add(vVar);
                            animate.setDuration(eVar.atp).setListener(new AnimatorListenerAdapter(vVar, i6, view, i7, animate) {
                                /* class com.tencent.mm.plugin.appbrand.widget.desktop.e.AnonymousClass6 */
                                final /* synthetic */ RecyclerView.v amA;
                                final /* synthetic */ ViewPropertyAnimator amB;
                                final /* synthetic */ int amC;
                                final /* synthetic */ int amD;
                                final /* synthetic */ View val$view;

                                {
                                    this.amA = r2;
                                    this.amC = r3;
                                    this.val$view = r4;
                                    this.amD = r5;
                                    this.amB = r6;
                                }

                                public final void onAnimationStart(Animator animator) {
                                    AppMethodBeat.i(49656);
                                    e.this.E(this.amA);
                                    AppMethodBeat.o(49656);
                                }

                                public final void onAnimationCancel(Animator animator) {
                                    AppMethodBeat.i(49657);
                                    if (this.amC != 0) {
                                        this.val$view.setTranslationX(0.0f);
                                    }
                                    if (this.amD != 0) {
                                        this.val$view.setTranslationY(0.0f);
                                    }
                                    AppMethodBeat.o(49657);
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    AppMethodBeat.i(49658);
                                    this.amB.setListener(null);
                                    e.this.x(this.amA);
                                    e.this.amt.remove(this.amA);
                                    e.this.jE();
                                    AppMethodBeat.o(49658);
                                }
                            }).start();
                        }
                        arrayList.clear();
                        e.this.amq.remove(arrayList);
                        AppMethodBeat.o(49649);
                    }
                };
                if (z4) {
                    u.a(arrayList.get(0).amO.aus, r8, ly());
                } else {
                    r8.run();
                }
            }
            if (z2) {
                final ArrayList<a> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.amo);
                this.amr.add(arrayList2);
                this.amo.clear();
                AnonymousClass2 r82 = new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.widget.desktop.e.AnonymousClass2 */

                    public final void run() {
                        View view;
                        AppMethodBeat.i(49650);
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            e eVar = e.this;
                            RecyclerView.v vVar = aVar.amI;
                            View view2 = vVar == null ? null : vVar.aus;
                            RecyclerView.v vVar2 = aVar.amJ;
                            if (vVar2 != null) {
                                view = vVar2.aus;
                            } else {
                                view = null;
                            }
                            if (view2 != null) {
                                ViewPropertyAnimator duration = view2.animate().setDuration(eVar.atq);
                                eVar.amv.add(aVar.amI);
                                duration.translationX((float) (aVar.amM - aVar.amK));
                                duration.translationY((float) (aVar.amN - aVar.amL));
                                duration.alpha(0.0f).setListener(new AnimatorListenerAdapter(aVar, duration, view2) {
                                    /* class com.tencent.mm.plugin.appbrand.widget.desktop.e.AnonymousClass7 */
                                    final /* synthetic */ ViewPropertyAnimator amF;
                                    final /* synthetic */ a ope;
                                    final /* synthetic */ View val$view;

                                    {
                                        this.ope = r2;
                                        this.amF = r3;
                                        this.val$view = r4;
                                    }

                                    public final void onAnimationStart(Animator animator) {
                                    }

                                    public final void onAnimationEnd(Animator animator) {
                                        AppMethodBeat.i(49659);
                                        this.amF.setListener(null);
                                        this.val$view.setAlpha(1.0f);
                                        this.val$view.setTranslationX(0.0f);
                                        this.val$view.setTranslationY(0.0f);
                                        this.val$view.setScaleX(1.0f);
                                        this.val$view.setScaleY(1.0f);
                                        e.this.n(this.ope.amI);
                                        e.this.amv.remove(this.ope.amI);
                                        e.this.jE();
                                        AppMethodBeat.o(49659);
                                    }
                                }).start();
                            }
                            if (view != null) {
                                ViewPropertyAnimator animate = view.animate();
                                eVar.amv.add(aVar.amJ);
                                animate.translationX(0.0f).translationY(0.0f).setDuration(eVar.atq).alpha(1.0f).setListener(new AnimatorListenerAdapter(aVar, animate, view) {
                                    /* class com.tencent.mm.plugin.appbrand.widget.desktop.e.AnonymousClass8 */
                                    final /* synthetic */ ViewPropertyAnimator amG;
                                    final /* synthetic */ View amH;
                                    final /* synthetic */ a ope;

                                    {
                                        this.ope = r2;
                                        this.amG = r3;
                                        this.amH = r4;
                                    }

                                    public final void onAnimationStart(Animator animator) {
                                    }

                                    public final void onAnimationEnd(Animator animator) {
                                        AppMethodBeat.i(49660);
                                        this.amG.setListener(null);
                                        this.amH.setAlpha(1.0f);
                                        this.amH.setTranslationX(0.0f);
                                        this.amH.setTranslationY(0.0f);
                                        e.this.n(this.ope.amJ);
                                        e.this.amv.remove(this.ope.amJ);
                                        e.this.jE();
                                        AppMethodBeat.o(49660);
                                    }
                                }).start();
                            }
                        }
                        arrayList2.clear();
                        e.this.amr.remove(arrayList2);
                        AppMethodBeat.o(49650);
                    }
                };
                if (z4) {
                    u.a(arrayList2.get(0).amI.aus, r82, ly());
                } else {
                    r82.run();
                }
            }
            if (z3) {
                final ArrayList<RecyclerView.v> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.amm);
                this.amp.add(arrayList3);
                this.amm.clear();
                AnonymousClass3 r12 = new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.widget.desktop.e.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(49651);
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            RecyclerView.v vVar = (RecyclerView.v) it.next();
                            e eVar = e.this;
                            View view = vVar.aus;
                            ViewPropertyAnimator animate = view.animate();
                            eVar.ams.add(vVar);
                            view.setAlpha(1.0f);
                            animate.scaleX(1.0f).scaleY(1.0f).setDuration(eVar.lx()).setListener(new AnimatorListenerAdapter(vVar, view, animate) {
                                /* class com.tencent.mm.plugin.appbrand.widget.desktop.e.AnonymousClass5 */
                                final /* synthetic */ RecyclerView.v amA;
                                final /* synthetic */ ViewPropertyAnimator amB;
                                final /* synthetic */ View val$view;

                                {
                                    this.amA = r2;
                                    this.val$view = r3;
                                    this.amB = r4;
                                }

                                public final void onAnimationStart(Animator animator) {
                                }

                                public final void onAnimationCancel(Animator animator) {
                                    AppMethodBeat.i(49654);
                                    this.val$view.setScaleX(1.0f);
                                    this.val$view.setScaleY(1.0f);
                                    AppMethodBeat.o(49654);
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    AppMethodBeat.i(49655);
                                    this.amB.setListener(null);
                                    e.this.n(this.amA);
                                    e.this.ams.remove(this.amA);
                                    e.this.jE();
                                    AppMethodBeat.o(49655);
                                }
                            }).start();
                        }
                        arrayList3.clear();
                        e.this.amp.remove(arrayList3);
                        AppMethodBeat.o(49651);
                    }
                };
                if (z4 || z || z2) {
                    long ly = z4 ? ly() : 0;
                    if (z) {
                        j2 = this.atp;
                    } else {
                        j2 = 0;
                    }
                    if (z2) {
                        j3 = this.atq;
                    } else {
                        j3 = 0;
                    }
                    u.a(arrayList3.get(0).aus, r12, ly + Math.max(j2, j3));
                    AppMethodBeat.o(49663);
                    return;
                }
                r12.run();
            }
            AppMethodBeat.o(49663);
            return;
        }
        AppMethodBeat.o(49663);
    }

    @Override // android.support.v7.widget.as
    public final boolean b(RecyclerView.v vVar) {
        AppMethodBeat.i(49664);
        Log.i("MicroMsg.RecentAppBrandItemAnimator", "alvinluo animateRemove %d", Integer.valueOf(vVar.lR()));
        e(vVar);
        this.aml.add(vVar);
        AppMethodBeat.o(49664);
        return true;
    }

    @Override // android.support.v7.widget.as
    public final boolean c(RecyclerView.v vVar) {
        AppMethodBeat.i(49665);
        e(vVar);
        vVar.aus.setAlpha(0.0f);
        vVar.aus.setScaleX(0.75f);
        vVar.aus.setScaleY(0.75f);
        this.amm.add(vVar);
        AppMethodBeat.o(49665);
        return true;
    }

    @Override // android.support.v7.widget.as
    public final boolean a(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(49666);
        View view = vVar.aus;
        int translationX = i2 + ((int) vVar.aus.getTranslationX());
        int translationY = i3 + ((int) vVar.aus.getTranslationY());
        e(vVar);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            x(vVar);
            AppMethodBeat.o(49666);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        this.amn.add(new b(vVar, translationX, translationY, i4, i5));
        AppMethodBeat.o(49666);
        return true;
    }

    @Override // android.support.v7.widget.as
    public final boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(49667);
        Log.i("MicroMsg.RecentAppBrandItemAnimator", "alvinluo animateChange lastPos: %d", Integer.valueOf(vVar.lR()));
        if (vVar == vVar2) {
            boolean a2 = a(vVar, i2, i3, i4, i5);
            AppMethodBeat.o(49667);
            return a2;
        }
        float translationX = vVar.aus.getTranslationX();
        float translationY = vVar.aus.getTranslationY();
        float alpha = vVar.aus.getAlpha();
        e(vVar);
        int i6 = (int) (((float) (i4 - i2)) - translationX);
        int i7 = (int) (((float) (i5 - i3)) - translationY);
        vVar.aus.setTranslationX(translationX);
        vVar.aus.setTranslationY(translationY);
        vVar.aus.setAlpha(alpha);
        if (vVar2 != null) {
            e(vVar2);
            vVar2.aus.setTranslationX((float) (-i6));
            vVar2.aus.setTranslationY((float) (-i7));
            vVar2.aus.setAlpha(0.0f);
        }
        this.amo.add(new a(vVar, vVar2, i2, i3, i4, i5));
        AppMethodBeat.o(49667);
        return true;
    }

    private void a(List<a> list, RecyclerView.v vVar) {
        AppMethodBeat.i(49668);
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (a(aVar, vVar) && aVar.amI == null && aVar.amJ == null) {
                list.remove(aVar);
            }
        }
        AppMethodBeat.o(49668);
    }

    private void a(a aVar) {
        AppMethodBeat.i(49669);
        if (aVar.amI != null) {
            a(aVar, aVar.amI);
        }
        if (aVar.amJ != null) {
            a(aVar, aVar.amJ);
        }
        AppMethodBeat.o(49669);
    }

    private boolean a(a aVar, RecyclerView.v vVar) {
        AppMethodBeat.i(49670);
        if (aVar.amJ == vVar) {
            aVar.amJ = null;
        } else if (aVar.amI == vVar) {
            aVar.amI = null;
        } else {
            AppMethodBeat.o(49670);
            return false;
        }
        vVar.aus.setAlpha(1.0f);
        vVar.aus.setTranslationX(0.0f);
        vVar.aus.setTranslationY(0.0f);
        n(vVar);
        AppMethodBeat.o(49670);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final void d(RecyclerView.v vVar) {
        AppMethodBeat.i(49671);
        View view = vVar.aus;
        view.animate().cancel();
        for (int size = this.amn.size() - 1; size >= 0; size--) {
            if (this.amn.get(size).amO == vVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                x(vVar);
                this.amn.remove(size);
            }
        }
        a(this.amo, vVar);
        if (this.aml.remove(vVar)) {
            view.setAlpha(1.0f);
            w(vVar);
        }
        if (this.amm.remove(vVar)) {
            view.setAlpha(1.0f);
            n(vVar);
        }
        for (int size2 = this.amr.size() - 1; size2 >= 0; size2--) {
            ArrayList<a> arrayList = this.amr.get(size2);
            a(arrayList, vVar);
            if (arrayList.isEmpty()) {
                this.amr.remove(size2);
            }
        }
        for (int size3 = this.amq.size() - 1; size3 >= 0; size3--) {
            ArrayList<b> arrayList2 = this.amq.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).amO == vVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    x(vVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.amq.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.amp.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.v> arrayList3 = this.amp.get(size5);
            if (arrayList3.remove(vVar)) {
                view.setAlpha(1.0f);
                n(vVar);
                if (arrayList3.isEmpty()) {
                    this.amp.remove(size5);
                }
            }
        }
        this.amu.remove(vVar);
        this.ams.remove(vVar);
        this.amv.remove(vVar);
        this.amt.remove(vVar);
        jE();
        AppMethodBeat.o(49671);
    }

    private void e(RecyclerView.v vVar) {
        AppMethodBeat.i(49672);
        if (amk == null) {
            amk = new ValueAnimator().getInterpolator();
        }
        vVar.aus.animate().setInterpolator(amk);
        d(vVar);
        AppMethodBeat.o(49672);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final boolean isRunning() {
        AppMethodBeat.i(49673);
        if (!this.amm.isEmpty() || !this.amo.isEmpty() || !this.amn.isEmpty() || !this.aml.isEmpty() || !this.amt.isEmpty() || !this.amu.isEmpty() || !this.ams.isEmpty() || !this.amv.isEmpty() || !this.amq.isEmpty() || !this.amp.isEmpty() || !this.amr.isEmpty()) {
            AppMethodBeat.o(49673);
            return true;
        }
        AppMethodBeat.o(49673);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void jE() {
        AppMethodBeat.i(49674);
        if (!isRunning()) {
            lC();
        }
        AppMethodBeat.o(49674);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final void jF() {
        AppMethodBeat.i(49675);
        for (int size = this.amn.size() - 1; size >= 0; size--) {
            b bVar = this.amn.get(size);
            View view = bVar.amO.aus;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            x(bVar.amO);
            this.amn.remove(size);
        }
        for (int size2 = this.aml.size() - 1; size2 >= 0; size2--) {
            w(this.aml.get(size2));
            this.aml.remove(size2);
        }
        for (int size3 = this.amm.size() - 1; size3 >= 0; size3--) {
            RecyclerView.v vVar = this.amm.get(size3);
            vVar.aus.setAlpha(1.0f);
            n(vVar);
            this.amm.remove(size3);
        }
        for (int size4 = this.amo.size() - 1; size4 >= 0; size4--) {
            a(this.amo.get(size4));
        }
        this.amo.clear();
        if (!isRunning()) {
            AppMethodBeat.o(49675);
            return;
        }
        for (int size5 = this.amq.size() - 1; size5 >= 0; size5--) {
            ArrayList<b> arrayList = this.amq.get(size5);
            for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                b bVar2 = arrayList.get(size6);
                View view2 = bVar2.amO.aus;
                view2.setTranslationY(0.0f);
                view2.setTranslationX(0.0f);
                x(bVar2.amO);
                arrayList.remove(size6);
                if (arrayList.isEmpty()) {
                    this.amq.remove(arrayList);
                }
            }
        }
        for (int size7 = this.amp.size() - 1; size7 >= 0; size7--) {
            ArrayList<RecyclerView.v> arrayList2 = this.amp.get(size7);
            for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                RecyclerView.v vVar2 = arrayList2.get(size8);
                vVar2.aus.setAlpha(1.0f);
                n(vVar2);
                arrayList2.remove(size8);
                if (arrayList2.isEmpty()) {
                    this.amp.remove(arrayList2);
                }
            }
        }
        for (int size9 = this.amr.size() - 1; size9 >= 0; size9--) {
            ArrayList<a> arrayList3 = this.amr.get(size9);
            for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                a(arrayList3.get(size10));
                if (arrayList3.isEmpty()) {
                    this.amr.remove(arrayList3);
                }
            }
        }
        n(this.amu);
        n(this.amt);
        n(this.ams);
        n(this.amv);
        lC();
        AppMethodBeat.o(49675);
    }

    private static void n(List<RecyclerView.v> list) {
        AppMethodBeat.i(49676);
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).aus.animate().cancel();
        }
        AppMethodBeat.o(49676);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final boolean a(RecyclerView.v vVar, List<Object> list) {
        AppMethodBeat.i(49677);
        if (!list.isEmpty() || super.a(vVar, list)) {
            AppMethodBeat.o(49677);
            return true;
        }
        AppMethodBeat.o(49677);
        return false;
    }
}
