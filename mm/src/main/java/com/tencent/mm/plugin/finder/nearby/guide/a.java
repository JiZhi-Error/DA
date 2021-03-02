package com.tencent.mm.plugin.finder.nearby.guide;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001c\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/guide/TabLayoutScrollGuideHelper;", "Landroid/animation/Animator$AnimatorListener;", "()V", "animationSet", "Landroid/animation/AnimatorSet;", "first", "Landroid/animation/ValueAnimator;", "lastActionX", "", "lastActionY", "repeatCount", "second", "targetView", "Landroid/view/View;", "targetViewPos", "", "cancel", "", "createTouchEvent", "Landroid/view/MotionEvent;", "x", "", "y", "actionType", "onAnimationCancel", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "onMoveAction", "", "setTargetView", "start", "delayMs", "", "Companion", "plugin-finder_release"})
public final class a implements Animator.AnimatorListener {
    public static final C1236a uQB = new C1236a((byte) 0);
    private final int repeatCount = 1;
    public View targetView;
    public ValueAnimator uQA;
    public int[] uQv = new int[2];
    private int uQw;
    private int uQx;
    public AnimatorSet uQy;
    public ValueAnimator uQz;

    static {
        AppMethodBeat.i(249024);
        AppMethodBeat.o(249024);
    }

    public a() {
        AppMethodBeat.i(249023);
        AppMethodBeat.o(249023);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/guide/TabLayoutScrollGuideHelper$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.nearby.guide.a$a  reason: collision with other inner class name */
    public static final class C1236a {
        private C1236a() {
        }

        public /* synthetic */ C1236a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "onAnimationUpdate"})
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ a uQC;

        public b(a aVar) {
            this.uQC = aVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(249016);
            if (valueAnimator != null) {
                a aVar = this.uQC;
                Object animatedValue = valueAnimator.getAnimatedValue();
                p.g(animatedValue, "it.animatedValue");
                a.a(aVar, animatedValue, Float.valueOf(0.0f));
                AppMethodBeat.o(249016);
                return;
            }
            AppMethodBeat.o(249016);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "onAnimationUpdate"})
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ a uQC;

        public c(a aVar) {
            this.uQC = aVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(249017);
            if (valueAnimator != null) {
                a aVar = this.uQC;
                Object animatedValue = valueAnimator.getAnimatedValue();
                p.g(animatedValue, "it.animatedValue");
                a.a(aVar, animatedValue, Float.valueOf(0.0f));
                AppMethodBeat.o(249017);
                return;
            }
            AppMethodBeat.o(249017);
        }
    }

    public final void onAnimationStart(Animator animator) {
        AppMethodBeat.i(249018);
        Log.i("TabLayoutScrollGuideHelper", "onAnimationStart");
        this.uQw = this.uQv[0];
        this.uQx = this.uQv[1];
        View view = this.targetView;
        if (view != null) {
            view.onTouchEvent(d((float) this.uQw, (float) this.uQx, 0));
            AppMethodBeat.o(249018);
            return;
        }
        AppMethodBeat.o(249018);
    }

    public final void onAnimationEnd(Animator animator) {
        AppMethodBeat.i(249019);
        View view = this.targetView;
        if (view != null) {
            view.onTouchEvent(d((float) this.uQw, (float) this.uQx, 1));
        }
        Log.i("TabLayoutScrollGuideHelper", "onAnimationEnd");
        AppMethodBeat.o(249019);
    }

    public final void onAnimationCancel(Animator animator) {
        AppMethodBeat.i(249020);
        View view = this.targetView;
        if (view != null) {
            view.onTouchEvent(d((float) this.uQw, (float) this.uQx, 1));
        }
        Log.i("TabLayoutScrollGuideHelper", "onAnimationCancel");
        AppMethodBeat.o(249020);
    }

    public final void onAnimationRepeat(Animator animator) {
        AppMethodBeat.i(249021);
        Log.i("TabLayoutScrollGuideHelper", "onAnimationRepeat");
        AppMethodBeat.o(249021);
    }

    private static MotionEvent d(float f2, float f3, int i2) {
        AppMethodBeat.i(249022);
        MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), i2, f2, f3, 0);
        p.g(obtain, "MotionEvent.obtain(Syste…     actionType, x, y, 0)");
        AppMethodBeat.o(249022);
        return obtain;
    }

    public static final /* synthetic */ void a(a aVar, Object obj, Object obj2) {
        AppMethodBeat.i(249025);
        if (obj == null) {
            try {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(249025);
                throw tVar;
            } catch (Throwable th) {
                Log.e("TabLayoutScrollGuideHelper", "setViewScrollBy " + th.getMessage());
                AppMethodBeat.o(249025);
            }
        } else {
            aVar.uQw = ((int) ((Float) obj).floatValue()) + aVar.uQv[0];
            if (obj2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(249025);
                throw tVar2;
            }
            aVar.uQx = (int) ((Float) obj2).floatValue();
            View view = aVar.targetView;
            if (view != null) {
                view.onTouchEvent(d((float) aVar.uQw, (float) aVar.uQx, 2));
            }
            Log.d("TabLayoutScrollGuideHelper", "setViewScrollBy x:" + aVar.uQw + " y:" + aVar.uQx);
            AppMethodBeat.o(249025);
        }
    }
}
