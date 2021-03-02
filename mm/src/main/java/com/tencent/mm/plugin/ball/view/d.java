package com.tencent.mm.plugin.ball.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.u;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d extends as {
    private static TimeInterpolator amk;
    private ArrayList<RecyclerView.v> aml = new ArrayList<>();
    private ArrayList<RecyclerView.v> amm = new ArrayList<>();
    private ArrayList<c> amn = new ArrayList<>();
    private ArrayList<a> amo = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.v>> amp = new ArrayList<>();
    ArrayList<ArrayList<c>> amq = new ArrayList<>();
    ArrayList<ArrayList<a>> amr = new ArrayList<>();
    ArrayList<RecyclerView.v> ams = new ArrayList<>();
    ArrayList<RecyclerView.v> amt = new ArrayList<>();
    ArrayList<RecyclerView.v> amu = new ArrayList<>();
    ArrayList<RecyclerView.v> amv = new ArrayList<>();
    b oVt;

    public interface b {
        boolean a(RecyclerView.v vVar, Animator.AnimatorListener animatorListener);
    }

    public d() {
        AppMethodBeat.i(217137);
        AppMethodBeat.o(217137);
    }

    /* access modifiers changed from: package-private */
    public static class c {
        public int amK;
        public int amL;
        public int amM;
        public int amN;
        public RecyclerView.v amO;

        c(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
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

        private a(RecyclerView.v vVar, RecyclerView.v vVar2) {
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
            AppMethodBeat.i(217136);
            String str = "ChangeInfo{oldHolder=" + this.amI + ", newHolder=" + this.amJ + ", fromX=" + this.amK + ", fromY=" + this.amL + ", toX=" + this.amM + ", toY=" + this.amN + '}';
            AppMethodBeat.o(217136);
            return str;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final void jD() {
        boolean z;
        boolean z2;
        boolean z3;
        long j2;
        long j3;
        AppMethodBeat.i(217138);
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
                this.amu.add(next);
                final ViewPropertyAnimator animate = view.animate();
                AnonymousClass4 r11 = new Animator.AnimatorListener() {
                    /* class com.tencent.mm.plugin.ball.view.d.AnonymousClass4 */

                    public final void onAnimationStart(Animator animator) {
                        AppMethodBeat.i(217127);
                        d.this.C(next);
                        AppMethodBeat.o(217127);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(217128);
                        animate.setListener(null);
                        view.setAlpha(1.0f);
                        d.this.w(next);
                        d.this.amu.remove(next);
                        d.this.jE();
                        AppMethodBeat.o(217128);
                    }

                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                };
                if (this.oVt == null || !this.oVt.a(next, r11)) {
                    animate.setDuration(ly()).alpha(0.0f).setListener(r11).start();
                }
            }
            this.aml.clear();
            if (z) {
                final ArrayList<c> arrayList = new ArrayList<>();
                arrayList.addAll(this.amn);
                this.amq.add(arrayList);
                this.amn.clear();
                AnonymousClass1 r8 = new Runnable() {
                    /* class com.tencent.mm.plugin.ball.view.d.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(217124);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            c cVar = (c) it.next();
                            d dVar = d.this;
                            RecyclerView.v vVar = cVar.amO;
                            int i2 = cVar.amK;
                            int i3 = cVar.amL;
                            int i4 = cVar.amM;
                            int i5 = cVar.amN;
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
                            dVar.amt.add(vVar);
                            animate.setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(dVar.atp).setListener(new AnimatorListenerAdapter(vVar, i6, view, i7, animate) {
                                /* class com.tencent.mm.plugin.ball.view.d.AnonymousClass6 */
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
                                    AppMethodBeat.i(217131);
                                    d.this.E(this.amA);
                                    AppMethodBeat.o(217131);
                                }

                                public final void onAnimationCancel(Animator animator) {
                                    AppMethodBeat.i(217132);
                                    if (this.amC != 0) {
                                        this.val$view.setTranslationX(0.0f);
                                    }
                                    if (this.amD != 0) {
                                        this.val$view.setTranslationY(0.0f);
                                    }
                                    AppMethodBeat.o(217132);
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    AppMethodBeat.i(217133);
                                    this.amB.setListener(null);
                                    d.this.x(this.amA);
                                    d.this.amt.remove(this.amA);
                                    d.this.jE();
                                    AppMethodBeat.o(217133);
                                }
                            }).start();
                        }
                        arrayList.clear();
                        d.this.amq.remove(arrayList);
                        AppMethodBeat.o(217124);
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
                    /* class com.tencent.mm.plugin.ball.view.d.AnonymousClass2 */

                    public final void run() {
                        View view;
                        AppMethodBeat.i(217125);
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            d dVar = d.this;
                            RecyclerView.v vVar = aVar.amI;
                            View view2 = vVar == null ? null : vVar.aus;
                            RecyclerView.v vVar2 = aVar.amJ;
                            if (vVar2 != null) {
                                view = vVar2.aus;
                            } else {
                                view = null;
                            }
                            if (view2 != null) {
                                ViewPropertyAnimator duration = view2.animate().setDuration(dVar.atq);
                                dVar.amv.add(aVar.amI);
                                duration.translationX((float) (aVar.amM - aVar.amK));
                                duration.translationY((float) (aVar.amN - aVar.amL));
                                duration.alpha(0.0f).setListener(new AnimatorListenerAdapter(aVar, duration, view2) {
                                    /* class com.tencent.mm.plugin.ball.view.d.AnonymousClass7 */
                                    final /* synthetic */ ViewPropertyAnimator amF;
                                    final /* synthetic */ a pcP;
                                    final /* synthetic */ View val$view;

                                    {
                                        this.pcP = r2;
                                        this.amF = r3;
                                        this.val$view = r4;
                                    }

                                    public final void onAnimationStart(Animator animator) {
                                    }

                                    public final void onAnimationEnd(Animator animator) {
                                        AppMethodBeat.i(217134);
                                        this.amF.setListener(null);
                                        this.val$view.setAlpha(1.0f);
                                        this.val$view.setTranslationX(0.0f);
                                        this.val$view.setTranslationY(0.0f);
                                        d.this.n(this.pcP.amI);
                                        d.this.amv.remove(this.pcP.amI);
                                        d.this.jE();
                                        AppMethodBeat.o(217134);
                                    }
                                }).start();
                            }
                            if (view != null) {
                                ViewPropertyAnimator animate = view.animate();
                                dVar.amv.add(aVar.amJ);
                                animate.translationX(0.0f).translationY(0.0f).setDuration(dVar.atq).alpha(1.0f).setListener(new AnimatorListenerAdapter(aVar, animate, view) {
                                    /* class com.tencent.mm.plugin.ball.view.d.AnonymousClass8 */
                                    final /* synthetic */ ViewPropertyAnimator amG;
                                    final /* synthetic */ View amH;
                                    final /* synthetic */ a pcP;

                                    {
                                        this.pcP = r2;
                                        this.amG = r3;
                                        this.amH = r4;
                                    }

                                    public final void onAnimationStart(Animator animator) {
                                    }

                                    public final void onAnimationEnd(Animator animator) {
                                        AppMethodBeat.i(217135);
                                        this.amG.setListener(null);
                                        this.amH.setAlpha(1.0f);
                                        this.amH.setTranslationX(0.0f);
                                        this.amH.setTranslationY(0.0f);
                                        d.this.n(this.pcP.amJ);
                                        d.this.amv.remove(this.pcP.amJ);
                                        d.this.jE();
                                        AppMethodBeat.o(217135);
                                    }
                                }).start();
                            }
                        }
                        arrayList2.clear();
                        d.this.amr.remove(arrayList2);
                        AppMethodBeat.o(217125);
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
                    /* class com.tencent.mm.plugin.ball.view.d.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(217126);
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            RecyclerView.v vVar = (RecyclerView.v) it.next();
                            d dVar = d.this;
                            View view = vVar.aus;
                            ViewPropertyAnimator animate = view.animate();
                            dVar.ams.add(vVar);
                            animate.alpha(1.0f).setDuration(dVar.lx()).setListener(new AnimatorListenerAdapter(vVar, view, animate) {
                                /* class com.tencent.mm.plugin.ball.view.d.AnonymousClass5 */
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
                                    AppMethodBeat.i(217129);
                                    this.val$view.setAlpha(1.0f);
                                    AppMethodBeat.o(217129);
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    AppMethodBeat.i(217130);
                                    this.amB.setListener(null);
                                    d.this.n(this.amA);
                                    d.this.ams.remove(this.amA);
                                    d.this.jE();
                                    AppMethodBeat.o(217130);
                                }
                            }).start();
                        }
                        arrayList3.clear();
                        d.this.amp.remove(arrayList3);
                        AppMethodBeat.o(217126);
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
                    AppMethodBeat.o(217138);
                    return;
                }
                r12.run();
            }
            AppMethodBeat.o(217138);
            return;
        }
        AppMethodBeat.o(217138);
    }

    @Override // android.support.v7.widget.as
    public final boolean b(RecyclerView.v vVar) {
        AppMethodBeat.i(217139);
        e(vVar);
        this.aml.add(vVar);
        AppMethodBeat.o(217139);
        return true;
    }

    @Override // android.support.v7.widget.as
    public final boolean c(RecyclerView.v vVar) {
        AppMethodBeat.i(217140);
        e(vVar);
        vVar.aus.setAlpha(0.0f);
        this.amm.add(vVar);
        AppMethodBeat.o(217140);
        return true;
    }

    @Override // android.support.v7.widget.as
    public final boolean a(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(217141);
        View view = vVar.aus;
        int translationX = i2 + ((int) vVar.aus.getTranslationX());
        int translationY = i3 + ((int) vVar.aus.getTranslationY());
        e(vVar);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            x(vVar);
            AppMethodBeat.o(217141);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        this.amn.add(new c(vVar, translationX, translationY, i4, i5));
        AppMethodBeat.o(217141);
        return true;
    }

    @Override // android.support.v7.widget.as
    public final boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(217142);
        if (vVar == vVar2) {
            boolean a2 = a(vVar, i2, i3, i4, i5);
            AppMethodBeat.o(217142);
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
        AppMethodBeat.o(217142);
        return true;
    }

    private void a(List<a> list, RecyclerView.v vVar) {
        AppMethodBeat.i(217143);
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (a(aVar, vVar) && aVar.amI == null && aVar.amJ == null) {
                list.remove(aVar);
            }
        }
        AppMethodBeat.o(217143);
    }

    private void a(a aVar) {
        AppMethodBeat.i(217144);
        if (aVar.amI != null) {
            a(aVar, aVar.amI);
        }
        if (aVar.amJ != null) {
            a(aVar, aVar.amJ);
        }
        AppMethodBeat.o(217144);
    }

    private boolean a(a aVar, RecyclerView.v vVar) {
        AppMethodBeat.i(217145);
        if (aVar.amJ == vVar) {
            aVar.amJ = null;
        } else if (aVar.amI == vVar) {
            aVar.amI = null;
        } else {
            AppMethodBeat.o(217145);
            return false;
        }
        vVar.aus.setAlpha(1.0f);
        vVar.aus.setTranslationX(0.0f);
        vVar.aus.setTranslationY(0.0f);
        n(vVar);
        AppMethodBeat.o(217145);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final void d(RecyclerView.v vVar) {
        AppMethodBeat.i(217146);
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
            view.setTranslationX(0.0f);
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
            ArrayList<c> arrayList2 = this.amq.get(size3);
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
        AppMethodBeat.o(217146);
    }

    private void e(RecyclerView.v vVar) {
        AppMethodBeat.i(217147);
        if (amk == null) {
            amk = new ValueAnimator().getInterpolator();
        }
        vVar.aus.animate().setInterpolator(amk);
        d(vVar);
        AppMethodBeat.o(217147);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final boolean isRunning() {
        AppMethodBeat.i(217148);
        if (!this.amm.isEmpty() || !this.amo.isEmpty() || !this.amn.isEmpty() || !this.aml.isEmpty() || !this.amt.isEmpty() || !this.amu.isEmpty() || !this.ams.isEmpty() || !this.amv.isEmpty() || !this.amq.isEmpty() || !this.amp.isEmpty() || !this.amr.isEmpty()) {
            AppMethodBeat.o(217148);
            return true;
        }
        AppMethodBeat.o(217148);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void jE() {
        AppMethodBeat.i(217149);
        if (!isRunning()) {
            lC();
        }
        AppMethodBeat.o(217149);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final void jF() {
        AppMethodBeat.i(217150);
        for (int size = this.amn.size() - 1; size >= 0; size--) {
            c cVar = this.amn.get(size);
            View view = cVar.amO.aus;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            x(cVar.amO);
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
            AppMethodBeat.o(217150);
            return;
        }
        for (int size5 = this.amq.size() - 1; size5 >= 0; size5--) {
            ArrayList<c> arrayList = this.amq.get(size5);
            for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                c cVar2 = arrayList.get(size6);
                View view2 = cVar2.amO.aus;
                view2.setTranslationY(0.0f);
                view2.setTranslationX(0.0f);
                x(cVar2.amO);
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
        AppMethodBeat.o(217150);
    }

    private static void n(List<RecyclerView.v> list) {
        AppMethodBeat.i(217151);
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).aus.animate().cancel();
        }
        AppMethodBeat.o(217151);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final boolean a(RecyclerView.v vVar, List<Object> list) {
        AppMethodBeat.i(217152);
        if (!list.isEmpty() || super.a(vVar, list)) {
            AppMethodBeat.o(217152);
            return true;
        }
        AppMethodBeat.o(217152);
        return false;
    }
}
