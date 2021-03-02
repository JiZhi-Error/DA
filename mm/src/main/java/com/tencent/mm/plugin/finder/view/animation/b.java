package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/animation/FavAnimationHelper;", "", "()V", "animRunnable", "Ljava/lang/Runnable;", "animatorAlpha", "Landroid/animation/ValueAnimator;", "reset", "", "view", "Landroid/view/View;", "start", "plugin-finder_release"})
public final class b {
    private static final Runnable wrw = a.wrz;
    private static ValueAnimator wrx;
    public static final b wry = new b();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        public static final a wrz = new a();

        static {
            AppMethodBeat.i(255158);
            AppMethodBeat.o(255158);
        }

        a() {
        }

        public final void run() {
            AppMethodBeat.i(255157);
            b bVar = b.wry;
            ValueAnimator valueAnimator = b.wrx;
            if (valueAnimator != null) {
                valueAnimator.start();
                AppMethodBeat.o(255157);
                return;
            }
            AppMethodBeat.o(255157);
        }
    }

    static {
        AppMethodBeat.i(255163);
        AppMethodBeat.o(255163);
    }

    private b() {
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/view/animation/FavAnimationHelper$start$2$1"})
    /* renamed from: com.tencent.mm.plugin.finder.view.animation.b$b  reason: collision with other inner class name */
    public static final class C1331b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View tBN;

        C1331b(View view) {
            this.tBN = view;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(255159);
            Object animatedValue = valueAnimator.getAnimatedValue("alpha");
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(255159);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            Log.d("LikeIconAnimationHelper", "alpha=".concat(String.valueOf(floatValue)));
            this.tBN.setAlpha(floatValue);
            if (floatValue == 0.0f) {
                this.tBN.setVisibility(8);
                this.tBN.clearAnimation();
                this.tBN.setAlpha(1.0f);
            }
            AppMethodBeat.o(255159);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/view/animation/FavAnimationHelper$start$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ View hCI;

        c(View view) {
            this.hCI = view;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(255160);
            View view = this.hCI;
            b bVar = b.wry;
            view.postDelayed(b.wrw, 1000);
            AppMethodBeat.o(255160);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(255161);
            this.hCI.setVisibility(0);
            this.hCI.setAlpha(1.0f);
            AppMethodBeat.o(255161);
        }

        public final void onAnimationCancel(Animator animator) {
        }
    }

    public static void ei(View view) {
        AppMethodBeat.i(255162);
        p.h(view, "view");
        view.setVisibility(8);
        view.removeCallbacks(wrw);
        ValueAnimator valueAnimator = wrx;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", (float) com.tencent.mm.cb.a.fromDPToPix(view.getContext(), 32), 0.0f);
        p.g(ofFloat, "animatorY");
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(300L);
        if (wrx == null) {
            wrx = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f));
            x xVar = x.SXb;
        }
        ValueAnimator valueAnimator2 = wrx;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(300L).addUpdateListener(new C1331b(view));
        }
        ofFloat.addListener(new c(view));
        ofFloat.start();
        AppMethodBeat.o(255162);
    }
}
