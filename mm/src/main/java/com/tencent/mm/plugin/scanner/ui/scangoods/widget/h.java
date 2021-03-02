package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.support.a.e;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.view.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationHelper;", "", "()V", "TAG", "", "animateCustomSuccessView", "", "successView", "Landroid/view/View;", "animateDefaultSuccessView", "successMarkView", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "animateScanTipsImage", "Landroid/support/animation/SpringAnimation;", "view", "doSpringAnimation", "plugin-scan_release"})
public final class h {
    public static final h CPK = new h();

    static {
        AppMethodBeat.i(240596);
        AppMethodBeat.o(240596);
    }

    private h() {
    }

    public static final void a(View view, d dVar) {
        AppMethodBeat.i(240593);
        p.h(view, "successMarkView");
        view.setAlpha(0.0f);
        view.setScaleX(0.0f);
        view.setScaleY(0.0f);
        view.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(300).setListener(new b(dVar)).setInterpolator(new LinearInterpolator()).start();
        AppMethodBeat.o(240593);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationHelper$animateDefaultSuccessView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-scan_release"})
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ d CPM;

        b(d dVar) {
            this.CPM = dVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(240592);
            d dVar = this.CPM;
            if (dVar != null) {
                dVar.eQG();
                AppMethodBeat.o(240592);
                return;
            }
            AppMethodBeat.o(240592);
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    public static final void eS(View view) {
        AppMethodBeat.i(240594);
        p.h(view, "successView");
        view.setAlpha(1.0f);
        android.support.a.d dVar = new android.support.a.d(view, android.support.a.d.fN, (byte) 0);
        e aJ = dVar.aJ();
        p.g(aJ, "animationX.spring");
        aJ.g(200.0f);
        e aJ2 = dVar.aJ();
        p.g(aJ2, "animationX.spring");
        aJ2.h(0.5f);
        dVar.e(0.0f);
        android.support.a.d dVar2 = new android.support.a.d(view, android.support.a.d.fO, (byte) 0);
        e aJ3 = dVar2.aJ();
        p.g(aJ3, "animationY.spring");
        aJ3.g(200.0f);
        e aJ4 = dVar2.aJ();
        p.g(aJ4, "animationY.spring");
        aJ4.h(0.5f);
        dVar2.e(0.0f);
        dVar.start();
        dVar2.start();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(15.0f, 0.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new a(view));
        ofFloat.start();
        AppMethodBeat.o(240594);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationHelper$animateCustomSuccessView$1$1"})
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View CPL;

        a(View view) {
            this.CPL = view;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(240591);
            p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(240591);
                throw tVar;
            }
            this.CPL.setRotation(360.0f - Math.abs(((Float) animatedValue).floatValue()));
            AppMethodBeat.o(240591);
        }
    }

    public static final android.support.a.d eT(View view) {
        AppMethodBeat.i(240595);
        p.h(view, "view");
        android.support.a.d dVar = new android.support.a.d(view, android.support.a.d.fK);
        dVar.aH();
        e eVar = new e(0.0f);
        eVar.g(3000.0f);
        eVar.h(0.05f);
        dVar.a(eVar);
        dVar.e(-10.0f);
        dVar.start();
        AppMethodBeat.o(240595);
        return dVar;
    }
}
