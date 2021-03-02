package com.tencent.mm.plugin.finder.view.animation;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a extends as {
    private static TimeInterpolator amk;
    protected ArrayList<RecyclerView.v> aml = new ArrayList<>();
    protected ArrayList<RecyclerView.v> amm = new ArrayList<>();
    private ArrayList<b> amn = new ArrayList<>();
    private ArrayList<C1330a> amo = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.v>> amp = new ArrayList<>();
    ArrayList<ArrayList<b>> amq = new ArrayList<>();
    ArrayList<ArrayList<C1330a>> amr = new ArrayList<>();
    ArrayList<RecyclerView.v> ams = new ArrayList<>();
    ArrayList<RecyclerView.v> amt = new ArrayList<>();
    ArrayList<RecyclerView.v> amu = new ArrayList<>();
    protected ArrayList<RecyclerView.v> amv = new ArrayList<>();

    public a() {
        AppMethodBeat.i(168662);
        AppMethodBeat.o(168662);
    }

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

    /* access modifiers changed from: protected */
    /* renamed from: com.tencent.mm.plugin.finder.view.animation.a$a  reason: collision with other inner class name */
    public static class C1330a {
        public RecyclerView.v amI;
        public RecyclerView.v amJ;
        public int amK;
        public int amL;
        public int amM;
        public int amN;

        private C1330a(RecyclerView.v vVar, RecyclerView.v vVar2) {
            this.amI = vVar;
            this.amJ = vVar2;
        }

        C1330a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5) {
            this(vVar, vVar2);
            this.amK = i2;
            this.amL = i3;
            this.amM = i4;
            this.amN = i5;
        }

        public final String toString() {
            AppMethodBeat.i(168661);
            String str = "ChangeInfo{oldHolder=" + this.amI + ", newHolder=" + this.amJ + ", fromX=" + this.amK + ", fromY=" + this.amL + ", toX=" + this.amM + ", toY=" + this.amN + '}';
            AppMethodBeat.o(168661);
            return str;
        }
    }

    /* access modifiers changed from: protected */
    public long dHo() {
        AppMethodBeat.i(168663);
        long ly = ly();
        AppMethodBeat.o(168663);
        return ly;
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final void jD() {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(168664);
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
                aa(it.next());
            }
            this.aml.clear();
            if (z) {
                final ArrayList<b> arrayList = new ArrayList<>();
                arrayList.addAll(this.amn);
                this.amq.add(arrayList);
                this.amn.clear();
                AnonymousClass1 r6 = new Runnable() {
                    /* class com.tencent.mm.plugin.finder.view.animation.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(168649);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            a aVar = a.this;
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
                            aVar.amt.add(vVar);
                            animate.setDuration(aVar.atp).setListener(new AnimatorListenerAdapter(vVar, i6, view, i7, animate) {
                                /* class com.tencent.mm.plugin.finder.view.animation.a.AnonymousClass6 */
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
                                    AppMethodBeat.i(168656);
                                    a.this.E(this.amA);
                                    AppMethodBeat.o(168656);
                                }

                                public final void onAnimationCancel(Animator animator) {
                                    AppMethodBeat.i(168657);
                                    if (this.amC != 0) {
                                        this.val$view.setTranslationX(0.0f);
                                    }
                                    if (this.amD != 0) {
                                        this.val$view.setTranslationY(0.0f);
                                    }
                                    AppMethodBeat.o(168657);
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    AppMethodBeat.i(168658);
                                    this.amB.setListener(null);
                                    a.this.x(this.amA);
                                    a.this.amt.remove(this.amA);
                                    a.this.jE();
                                    AppMethodBeat.o(168658);
                                }
                            }).start();
                        }
                        arrayList.clear();
                        a.this.amq.remove(arrayList);
                        AppMethodBeat.o(168649);
                    }
                };
                if (z4) {
                    u.a(arrayList.get(0).amO.aus, r6, ly());
                } else {
                    r6.run();
                }
            }
            if (z2) {
                final ArrayList<C1330a> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.amo);
                this.amr.add(arrayList2);
                this.amo.clear();
                AnonymousClass2 r62 = new Runnable() {
                    /* class com.tencent.mm.plugin.finder.view.animation.a.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(168650);
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            a.this.a((C1330a) it.next());
                        }
                        arrayList2.clear();
                        a.this.amr.remove(arrayList2);
                        AppMethodBeat.o(168650);
                    }
                };
                if (z4) {
                    u.a(arrayList2.get(0).amI.aus, r62, ly());
                } else {
                    r62.run();
                }
            }
            if (z3) {
                final ArrayList<RecyclerView.v> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.amm);
                this.amp.add(arrayList3);
                this.amm.clear();
                AnonymousClass3 r5 = new Runnable() {
                    /* class com.tencent.mm.plugin.finder.view.animation.a.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(168651);
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            a.this.ab((RecyclerView.v) it.next());
                        }
                        arrayList3.clear();
                        a.this.amp.remove(arrayList3);
                        AppMethodBeat.o(168651);
                    }
                };
                if (z4 || z || z2) {
                    u.a(arrayList3.get(0).aus, r5, dHo());
                    AppMethodBeat.o(168664);
                    return;
                }
                r5.run();
            }
            AppMethodBeat.o(168664);
            return;
        }
        AppMethodBeat.o(168664);
    }

    @Override // android.support.v7.widget.as
    public boolean b(RecyclerView.v vVar) {
        AppMethodBeat.i(168665);
        e(vVar);
        this.aml.add(vVar);
        AppMethodBeat.o(168665);
        return true;
    }

    /* access modifiers changed from: protected */
    public void aa(final RecyclerView.v vVar) {
        AppMethodBeat.i(168666);
        final View view = vVar.aus;
        final ViewPropertyAnimator animate = view.animate();
        this.amu.add(vVar);
        animate.setDuration(ly()).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.finder.view.animation.a.AnonymousClass4 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(168652);
                a.this.C(vVar);
                AppMethodBeat.o(168652);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(168653);
                animate.setListener(null);
                view.setAlpha(1.0f);
                a.this.w(vVar);
                a.this.amu.remove(vVar);
                a.this.jE();
                AppMethodBeat.o(168653);
            }
        }).start();
        AppMethodBeat.o(168666);
    }

    @Override // android.support.v7.widget.as
    public boolean c(RecyclerView.v vVar) {
        AppMethodBeat.i(168667);
        e(vVar);
        vVar.aus.setAlpha(0.0f);
        this.amm.add(vVar);
        AppMethodBeat.o(168667);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void ab(final RecyclerView.v vVar) {
        AppMethodBeat.i(168668);
        final View view = vVar.aus;
        final ViewPropertyAnimator animate = view.animate();
        this.ams.add(vVar);
        animate.alpha(1.0f).setDuration(lx()).setListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.finder.view.animation.a.AnonymousClass5 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(168654);
                view.setAlpha(1.0f);
                AppMethodBeat.o(168654);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(168655);
                animate.setListener(null);
                a.this.n(vVar);
                a.this.ams.remove(vVar);
                a.this.jE();
                AppMethodBeat.o(168655);
            }
        }).start();
        AppMethodBeat.o(168668);
    }

    @Override // android.support.v7.widget.as
    public final boolean a(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(168669);
        View view = vVar.aus;
        int translationX = i2 + ((int) vVar.aus.getTranslationX());
        int translationY = i3 + ((int) vVar.aus.getTranslationY());
        e(vVar);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            x(vVar);
            AppMethodBeat.o(168669);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        this.amn.add(new b(vVar, translationX, translationY, i4, i5));
        AppMethodBeat.o(168669);
        return true;
    }

    @Override // android.support.v7.widget.as
    public final boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(168670);
        if (vVar == vVar2) {
            boolean a2 = a(vVar, i2, i3, i4, i5);
            AppMethodBeat.o(168670);
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
        this.amo.add(new C1330a(vVar, vVar2, i2, i3, i4, i5));
        AppMethodBeat.o(168670);
        return true;
    }

    /* access modifiers changed from: protected */
    public final void a(final C1330a aVar) {
        final View view = null;
        AppMethodBeat.i(168671);
        RecyclerView.v vVar = aVar.amI;
        final View view2 = vVar == null ? null : vVar.aus;
        RecyclerView.v vVar2 = aVar.amJ;
        if (vVar2 != null) {
            view = vVar2.aus;
        }
        if (view2 != null) {
            final ViewPropertyAnimator duration = view2.animate().setDuration(this.atq);
            this.amv.add(aVar.amI);
            duration.translationX((float) (aVar.amM - aVar.amK));
            duration.translationY((float) (aVar.amN - aVar.amL));
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.finder.view.animation.a.AnonymousClass7 */

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(168659);
                    duration.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    a.this.n(aVar.amI);
                    a.this.amv.remove(aVar.amI);
                    a.this.jE();
                    AppMethodBeat.o(168659);
                }
            }).start();
        }
        if (view != null) {
            final ViewPropertyAnimator animate = view.animate();
            this.amv.add(aVar.amJ);
            animate.translationX(0.0f).translationY(0.0f).setDuration(this.atq).alpha(1.0f).setListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.finder.view.animation.a.AnonymousClass8 */

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(168660);
                    animate.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    a.this.n(aVar.amJ);
                    a.this.amv.remove(aVar.amJ);
                    a.this.jE();
                    AppMethodBeat.o(168660);
                }
            }).start();
        }
        AppMethodBeat.o(168671);
    }

    private void a(List<C1330a> list, RecyclerView.v vVar) {
        AppMethodBeat.i(168672);
        for (int size = list.size() - 1; size >= 0; size--) {
            C1330a aVar = list.get(size);
            if (a(aVar, vVar) && aVar.amI == null && aVar.amJ == null) {
                list.remove(aVar);
            }
        }
        AppMethodBeat.o(168672);
    }

    private void b(C1330a aVar) {
        AppMethodBeat.i(168673);
        if (aVar.amI != null) {
            a(aVar, aVar.amI);
        }
        if (aVar.amJ != null) {
            a(aVar, aVar.amJ);
        }
        AppMethodBeat.o(168673);
    }

    private boolean a(C1330a aVar, RecyclerView.v vVar) {
        AppMethodBeat.i(168674);
        if (aVar.amJ == vVar) {
            aVar.amJ = null;
        } else if (aVar.amI == vVar) {
            aVar.amI = null;
        } else {
            AppMethodBeat.o(168674);
            return false;
        }
        vVar.aus.setAlpha(1.0f);
        vVar.aus.setTranslationX(0.0f);
        vVar.aus.setTranslationY(0.0f);
        n(vVar);
        AppMethodBeat.o(168674);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final void d(RecyclerView.v vVar) {
        AppMethodBeat.i(168675);
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
            ArrayList<C1330a> arrayList = this.amr.get(size2);
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
        AppMethodBeat.o(168675);
    }

    /* access modifiers changed from: protected */
    public final void e(RecyclerView.v vVar) {
        AppMethodBeat.i(168676);
        if (amk == null) {
            amk = new ValueAnimator().getInterpolator();
        }
        vVar.aus.animate().setInterpolator(amk);
        d(vVar);
        AppMethodBeat.o(168676);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final boolean isRunning() {
        AppMethodBeat.i(168677);
        if (!this.amm.isEmpty() || !this.amo.isEmpty() || !this.amn.isEmpty() || !this.aml.isEmpty() || !this.amt.isEmpty() || !this.amu.isEmpty() || !this.ams.isEmpty() || !this.amv.isEmpty() || !this.amq.isEmpty() || !this.amp.isEmpty() || !this.amr.isEmpty()) {
            AppMethodBeat.o(168677);
            return true;
        }
        AppMethodBeat.o(168677);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void jE() {
        AppMethodBeat.i(168678);
        if (!isRunning()) {
            lC();
        }
        AppMethodBeat.o(168678);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final void jF() {
        AppMethodBeat.i(168679);
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
            b(this.amo.get(size4));
        }
        this.amo.clear();
        if (!isRunning()) {
            AppMethodBeat.o(168679);
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
            ArrayList<C1330a> arrayList3 = this.amr.get(size9);
            for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                b(arrayList3.get(size10));
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
        AppMethodBeat.o(168679);
    }

    private static void n(List<RecyclerView.v> list) {
        AppMethodBeat.i(168680);
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).aus.animate().cancel();
        }
        AppMethodBeat.o(168680);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final boolean a(RecyclerView.v vVar, List<Object> list) {
        AppMethodBeat.i(168681);
        if (!list.isEmpty() || super.a(vVar, list)) {
            AppMethodBeat.o(168681);
            return true;
        }
        AppMethodBeat.o(168681);
        return false;
    }
}
