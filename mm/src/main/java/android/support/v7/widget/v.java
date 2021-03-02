package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.u;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class v extends as {
    private static TimeInterpolator amk;
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
            return "ChangeInfo{oldHolder=" + this.amI + ", newHolder=" + this.amJ + ", fromX=" + this.amK + ", fromY=" + this.amL + ", toX=" + this.amM + ", toY=" + this.amN + '}';
        }
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public void jD() {
        boolean z;
        boolean z2;
        boolean z3;
        long j2;
        long j3;
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
                    /* class android.support.v7.widget.v.AnonymousClass4 */

                    public final void onAnimationStart(Animator animator) {
                        v.this.C(next);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        animate.setListener(null);
                        view.setAlpha(1.0f);
                        v.this.w(next);
                        v.this.amu.remove(next);
                        v.this.jE();
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
                    /* class android.support.v7.widget.v.AnonymousClass1 */

                    public final void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            v vVar = v.this;
                            RecyclerView.v vVar2 = bVar.amO;
                            int i2 = bVar.amK;
                            int i3 = bVar.amL;
                            int i4 = bVar.amM;
                            int i5 = bVar.amN;
                            View view = vVar2.aus;
                            int i6 = i4 - i2;
                            int i7 = i5 - i3;
                            if (i6 != 0) {
                                view.animate().translationX(0.0f);
                            }
                            if (i7 != 0) {
                                view.animate().translationY(0.0f);
                            }
                            ViewPropertyAnimator animate = view.animate();
                            vVar.amt.add(vVar2);
                            animate.setDuration(vVar.atp).setListener(new AnimatorListenerAdapter(vVar2, i6, view, i7, animate) {
                                /* class android.support.v7.widget.v.AnonymousClass6 */
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
                                    v.this.E(this.amA);
                                }

                                public final void onAnimationCancel(Animator animator) {
                                    if (this.amC != 0) {
                                        this.val$view.setTranslationX(0.0f);
                                    }
                                    if (this.amD != 0) {
                                        this.val$view.setTranslationY(0.0f);
                                    }
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    this.amB.setListener(null);
                                    v.this.x(this.amA);
                                    v.this.amt.remove(this.amA);
                                    v.this.jE();
                                }
                            }).start();
                        }
                        arrayList.clear();
                        v.this.amq.remove(arrayList);
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
                    /* class android.support.v7.widget.v.AnonymousClass2 */

                    public final void run() {
                        View view;
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            v vVar = v.this;
                            RecyclerView.v vVar2 = aVar.amI;
                            View view2 = vVar2 == null ? null : vVar2.aus;
                            RecyclerView.v vVar3 = aVar.amJ;
                            if (vVar3 != null) {
                                view = vVar3.aus;
                            } else {
                                view = null;
                            }
                            if (view2 != null) {
                                ViewPropertyAnimator duration = view2.animate().setDuration(vVar.atq);
                                vVar.amv.add(aVar.amI);
                                duration.translationX((float) (aVar.amM - aVar.amK));
                                duration.translationY((float) (aVar.amN - aVar.amL));
                                duration.alpha(0.0f).setListener(new AnimatorListenerAdapter(aVar, duration, view2) {
                                    /* class android.support.v7.widget.v.AnonymousClass7 */
                                    final /* synthetic */ a amE;
                                    final /* synthetic */ ViewPropertyAnimator amF;
                                    final /* synthetic */ View val$view;

                                    {
                                        this.amE = r2;
                                        this.amF = r3;
                                        this.val$view = r4;
                                    }

                                    public final void onAnimationStart(Animator animator) {
                                    }

                                    public final void onAnimationEnd(Animator animator) {
                                        this.amF.setListener(null);
                                        this.val$view.setAlpha(1.0f);
                                        this.val$view.setTranslationX(0.0f);
                                        this.val$view.setTranslationY(0.0f);
                                        v.this.n(this.amE.amI);
                                        v.this.amv.remove(this.amE.amI);
                                        v.this.jE();
                                    }
                                }).start();
                            }
                            if (view != null) {
                                ViewPropertyAnimator animate = view.animate();
                                vVar.amv.add(aVar.amJ);
                                animate.translationX(0.0f).translationY(0.0f).setDuration(vVar.atq).alpha(1.0f).setListener(new AnimatorListenerAdapter(aVar, animate, view) {
                                    /* class android.support.v7.widget.v.AnonymousClass8 */
                                    final /* synthetic */ a amE;
                                    final /* synthetic */ ViewPropertyAnimator amG;
                                    final /* synthetic */ View amH;

                                    {
                                        this.amE = r2;
                                        this.amG = r3;
                                        this.amH = r4;
                                    }

                                    public final void onAnimationStart(Animator animator) {
                                    }

                                    public final void onAnimationEnd(Animator animator) {
                                        this.amG.setListener(null);
                                        this.amH.setAlpha(1.0f);
                                        this.amH.setTranslationX(0.0f);
                                        this.amH.setTranslationY(0.0f);
                                        v.this.n(this.amE.amJ);
                                        v.this.amv.remove(this.amE.amJ);
                                        v.this.jE();
                                    }
                                }).start();
                            }
                        }
                        arrayList2.clear();
                        v.this.amr.remove(arrayList2);
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
                    /* class android.support.v7.widget.v.AnonymousClass3 */

                    public final void run() {
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            RecyclerView.v vVar = (RecyclerView.v) it.next();
                            v vVar2 = v.this;
                            View view = vVar.aus;
                            ViewPropertyAnimator animate = view.animate();
                            vVar2.ams.add(vVar);
                            animate.alpha(1.0f).setDuration(vVar2.lx()).setListener(new AnimatorListenerAdapter(vVar, view, animate) {
                                /* class android.support.v7.widget.v.AnonymousClass5 */
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
                                    this.val$view.setAlpha(1.0f);
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    this.amB.setListener(null);
                                    v.this.n(this.amA);
                                    v.this.ams.remove(this.amA);
                                    v.this.jE();
                                }
                            }).start();
                        }
                        arrayList3.clear();
                        v.this.amp.remove(arrayList3);
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
                    return;
                }
                r12.run();
            }
        }
    }

    @Override // android.support.v7.widget.as
    public boolean b(RecyclerView.v vVar) {
        e(vVar);
        this.aml.add(vVar);
        return true;
    }

    @Override // android.support.v7.widget.as
    public boolean c(RecyclerView.v vVar) {
        e(vVar);
        vVar.aus.setAlpha(0.0f);
        this.amm.add(vVar);
        return true;
    }

    @Override // android.support.v7.widget.as
    public boolean a(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
        View view = vVar.aus;
        int translationX = i2 + ((int) vVar.aus.getTranslationX());
        int translationY = i3 + ((int) vVar.aus.getTranslationY());
        e(vVar);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            x(vVar);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        this.amn.add(new b(vVar, translationX, translationY, i4, i5));
        return true;
    }

    @Override // android.support.v7.widget.as
    public boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5) {
        if (vVar == vVar2) {
            return a(vVar, i2, i3, i4, i5);
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
        return true;
    }

    private void a(List<a> list, RecyclerView.v vVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (a(aVar, vVar) && aVar.amI == null && aVar.amJ == null) {
                list.remove(aVar);
            }
        }
    }

    private void a(a aVar) {
        if (aVar.amI != null) {
            a(aVar, aVar.amI);
        }
        if (aVar.amJ != null) {
            a(aVar, aVar.amJ);
        }
    }

    private boolean a(a aVar, RecyclerView.v vVar) {
        if (aVar.amJ == vVar) {
            aVar.amJ = null;
        } else if (aVar.amI != vVar) {
            return false;
        } else {
            aVar.amI = null;
        }
        vVar.aus.setAlpha(1.0f);
        vVar.aus.setTranslationX(0.0f);
        vVar.aus.setTranslationY(0.0f);
        n(vVar);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public void d(RecyclerView.v vVar) {
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
    }

    private void e(RecyclerView.v vVar) {
        if (amk == null) {
            amk = new ValueAnimator().getInterpolator();
        }
        vVar.aus.animate().setInterpolator(amk);
        d(vVar);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public boolean isRunning() {
        return !this.amm.isEmpty() || !this.amo.isEmpty() || !this.amn.isEmpty() || !this.aml.isEmpty() || !this.amt.isEmpty() || !this.amu.isEmpty() || !this.ams.isEmpty() || !this.amv.isEmpty() || !this.amq.isEmpty() || !this.amp.isEmpty() || !this.amr.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final void jE() {
        if (!isRunning()) {
            lC();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final void jF() {
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
        if (isRunning()) {
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
        }
    }

    private static void n(List<RecyclerView.v> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).aus.animate().cancel();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public boolean a(RecyclerView.v vVar, List<Object> list) {
        return !list.isEmpty() || super.a(vVar, list);
    }
}
