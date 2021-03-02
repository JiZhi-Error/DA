package com.tencent.mm.plugin.multitask.animation.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u0000 !2\u00020\u0001:\u0003!\"#B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0004J\u001a\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0004J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0004J*\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0004J(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J \u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u001f\u001a\u00020\u001b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J \u0010 \u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBViewAnimationHandler;", "", "targetView", "Landroid/view/View;", "(Landroid/view/View;)V", "hideAnimator", "Landroid/animation/Animator;", "isAnimating", "", "()Z", "isAnimatingHide", "isAnimatingShow", "showAnimator", "getTargetView", "()Landroid/view/View;", "setTargetView", "createHideAlphaAnimationSet", "width", "", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "createHideTransAnimationSet", "createShowAnimationSet", "createTranslateAnimationSet", "show", "isDockLeft", "playHideAnimation", "", "withTransAnimation", "withAlphaAnimation", "playHideTranslateAnimation", "playShowAnimation", "playShowTranslateAnimation", "Companion", "HideAnimatorListenerAdapter", "ShowAnimatorListenerAdapter", "plugin-multitask_release"})
public final class b {
    public static final a Aaf = new a((byte) 0);
    public Animator oWg;
    public Animator oWh;
    public View targetView;

    static {
        AppMethodBeat.i(200419);
        AppMethodBeat.o(200419);
    }

    public b(View view) {
        this.targetView = view;
    }

    public final boolean chI() {
        AppMethodBeat.i(200413);
        Animator animator = this.oWg;
        if (animator != null) {
            boolean isRunning = animator.isRunning();
            AppMethodBeat.o(200413);
            return isRunning;
        }
        AppMethodBeat.o(200413);
        return false;
    }

    public final boolean chJ() {
        AppMethodBeat.i(200414);
        Animator animator = this.oWh;
        if (animator != null) {
            boolean isRunning = animator.isRunning();
            AppMethodBeat.o(200414);
            return isRunning;
        }
        AppMethodBeat.o(200414);
        return false;
    }

    public final void a(int i2, boolean z, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(200415);
        if (this.targetView == null) {
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationCancel(null);
                AppMethodBeat.o(200415);
                return;
            }
            AppMethodBeat.o(200415);
        } else if (chI()) {
            Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingShow");
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationCancel(null);
                AppMethodBeat.o(200415);
                return;
            }
            AppMethodBeat.o(200415);
        } else {
            if (chJ()) {
                Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel hide animator");
                Animator animator = this.oWh;
                if (animator != null) {
                    animator.cancel();
                }
            }
            Log.v("MicroMsg.FloatBallViewAnimationHandler", "playShowTranslateAnimation, view:%s, width: %d, isDockLeft: %b", this.targetView, Integer.valueOf(i2), Boolean.valueOf(z));
            this.oWg = a(true, i2, z, (AnimatorListenerAdapter) new c(this.targetView, animatorListenerAdapter));
            Animator animator2 = this.oWg;
            if (animator2 != null) {
                animator2.start();
            }
            View view = this.targetView;
            if (view != null) {
                view.setAlpha(1.0f);
            }
            View view2 = this.targetView;
            if (view2 != null) {
                view2.setVisibility(0);
                AppMethodBeat.o(200415);
                return;
            }
            AppMethodBeat.o(200415);
        }
    }

    public final void a(int i2, boolean z, boolean z2, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(200416);
        if (this.targetView == null) {
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationCancel(null);
                AppMethodBeat.o(200416);
                return;
            }
            AppMethodBeat.o(200416);
        } else if (chJ()) {
            Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationCancel(null);
                AppMethodBeat.o(200416);
                return;
            }
            AppMethodBeat.o(200416);
        } else {
            if (chI()) {
                Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationCancel(null);
                }
                Animator animator = this.oWg;
                if (animator != null) {
                    animator.cancel();
                }
            }
            if (z) {
                this.oWh = a(i2, new C1505b(this.targetView, animatorListenerAdapter));
            } else if (z2) {
                AnimatorSet animatorSet = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.targetView, "alpha", 1.0f, 0.0f);
                p.g(ofFloat, "ObjectAnimator.ofFloat(t…iew, \"alpha\", 1.0f, 0.0f)");
                ObjectAnimator objectAnimator = ofFloat;
                objectAnimator.setDuration(500L);
                objectAnimator.setInterpolator(new AccelerateInterpolator());
                animatorSet.playTogether(objectAnimator);
                animatorSet.addListener(new C1505b(this.targetView, animatorListenerAdapter));
                this.oWh = animatorSet;
            } else {
                this.oWh = a(i2, new C1505b(this.targetView, animatorListenerAdapter));
            }
            Animator animator2 = this.oWh;
            if (animator2 != null) {
                animator2.start();
                AppMethodBeat.o(200416);
                return;
            }
            AppMethodBeat.o(200416);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBViewAnimationHandler$ShowAnimatorListenerAdapter;", "Landroid/animation/AnimatorListenerAdapter;", "targetView", "Landroid/view/View;", "otherAnimatorListenerAdapter", "(Landroid/view/View;Landroid/animation/AnimatorListenerAdapter;)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "onAnimationRepeat", "onAnimationResume", "onAnimationStart", "plugin-multitask_release"})
    public static final class c extends AnimatorListenerAdapter {
        private final AnimatorListenerAdapter oWj;
        private final View targetView;

        public c(View view, AnimatorListenerAdapter animatorListenerAdapter) {
            this.targetView = view;
            this.oWj = animatorListenerAdapter;
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(200407);
            p.h(animator, "animation");
            super.onAnimationCancel(animator);
            if (this.targetView != null) {
                this.targetView.setVisibility(0);
            }
            AnimatorListenerAdapter animatorListenerAdapter = this.oWj;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationCancel(animator);
                AppMethodBeat.o(200407);
                return;
            }
            AppMethodBeat.o(200407);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(200408);
            p.h(animator, "animation");
            super.onAnimationEnd(animator);
            if (this.targetView != null) {
                this.targetView.setVisibility(0);
            }
            AnimatorListenerAdapter animatorListenerAdapter = this.oWj;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd(animator);
                AppMethodBeat.o(200408);
                return;
            }
            AppMethodBeat.o(200408);
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(200409);
            p.h(animator, "animation");
            super.onAnimationRepeat(animator);
            AnimatorListenerAdapter animatorListenerAdapter = this.oWj;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationRepeat(animator);
                AppMethodBeat.o(200409);
                return;
            }
            AppMethodBeat.o(200409);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(200410);
            p.h(animator, "animation");
            super.onAnimationStart(animator);
            AnimatorListenerAdapter animatorListenerAdapter = this.oWj;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationStart(animator);
                AppMethodBeat.o(200410);
                return;
            }
            AppMethodBeat.o(200410);
        }

        public final void onAnimationPause(Animator animator) {
            AppMethodBeat.i(200411);
            p.h(animator, "animation");
            super.onAnimationPause(animator);
            AnimatorListenerAdapter animatorListenerAdapter = this.oWj;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationPause(animator);
                AppMethodBeat.o(200411);
                return;
            }
            AppMethodBeat.o(200411);
        }

        public final void onAnimationResume(Animator animator) {
            AppMethodBeat.i(200412);
            p.h(animator, "animation");
            super.onAnimationResume(animator);
            AnimatorListenerAdapter animatorListenerAdapter = this.oWj;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationResume(animator);
                AppMethodBeat.o(200412);
                return;
            }
            AppMethodBeat.o(200412);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBViewAnimationHandler$HideAnimatorListenerAdapter;", "Landroid/animation/AnimatorListenerAdapter;", "targetView", "Landroid/view/View;", "otherAnimatorListenerAdapter", "(Landroid/view/View;Landroid/animation/AnimatorListenerAdapter;)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "onAnimationRepeat", "onAnimationResume", "onAnimationStart", "plugin-multitask_release"})
    /* renamed from: com.tencent.mm.plugin.multitask.animation.b.b$b  reason: collision with other inner class name */
    public static final class C1505b extends AnimatorListenerAdapter {
        private final AnimatorListenerAdapter oWj;
        private final View targetView;

        public C1505b(View view, AnimatorListenerAdapter animatorListenerAdapter) {
            this.targetView = view;
            this.oWj = animatorListenerAdapter;
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(200401);
            p.h(animator, "animation");
            super.onAnimationCancel(animator);
            if (this.targetView != null) {
                this.targetView.setVisibility(8);
            }
            AnimatorListenerAdapter animatorListenerAdapter = this.oWj;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationCancel(animator);
                AppMethodBeat.o(200401);
                return;
            }
            AppMethodBeat.o(200401);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(200402);
            p.h(animator, "animation");
            super.onAnimationEnd(animator);
            if (this.targetView != null) {
                this.targetView.setVisibility(8);
            }
            AnimatorListenerAdapter animatorListenerAdapter = this.oWj;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd(animator);
                AppMethodBeat.o(200402);
                return;
            }
            AppMethodBeat.o(200402);
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(200403);
            p.h(animator, "animation");
            super.onAnimationRepeat(animator);
            AnimatorListenerAdapter animatorListenerAdapter = this.oWj;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationRepeat(animator);
                AppMethodBeat.o(200403);
                return;
            }
            AppMethodBeat.o(200403);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(200404);
            p.h(animator, "animation");
            super.onAnimationStart(animator);
            AnimatorListenerAdapter animatorListenerAdapter = this.oWj;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationStart(animator);
                AppMethodBeat.o(200404);
                return;
            }
            AppMethodBeat.o(200404);
        }

        public final void onAnimationPause(Animator animator) {
            AppMethodBeat.i(200405);
            p.h(animator, "animation");
            super.onAnimationPause(animator);
            AnimatorListenerAdapter animatorListenerAdapter = this.oWj;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationPause(animator);
                AppMethodBeat.o(200405);
                return;
            }
            AppMethodBeat.o(200405);
        }

        public final void onAnimationResume(Animator animator) {
            AppMethodBeat.i(200406);
            p.h(animator, "animation");
            super.onAnimationResume(animator);
            AnimatorListenerAdapter animatorListenerAdapter = this.oWj;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationResume(animator);
                AppMethodBeat.o(200406);
                return;
            }
            AppMethodBeat.o(200406);
        }
    }

    public final Animator a(boolean z, int i2, boolean z2, AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofFloat;
        ObjectAnimator objectAnimator;
        ObjectAnimator ofFloat2;
        AppMethodBeat.i(200417);
        AnimatorSet animatorSet = new AnimatorSet();
        if (z) {
            if (z2) {
                ofFloat2 = ObjectAnimator.ofFloat(this.targetView, "translationX", -((float) i2), 0.0f);
            } else {
                ofFloat2 = ObjectAnimator.ofFloat(this.targetView, "translationX", (float) i2, 0.0f);
            }
            objectAnimator = ofFloat2;
        } else {
            if (z2) {
                ofFloat = ObjectAnimator.ofFloat(this.targetView, "translationX", 0.0f, -((float) i2));
            } else {
                ofFloat = ObjectAnimator.ofFloat(this.targetView, "translationX", 0.0f, (float) i2);
            }
            objectAnimator = ofFloat;
        }
        p.g(objectAnimator, "translationAnimator");
        objectAnimator.setDuration(800L);
        animatorSet.playTogether(objectAnimator);
        animatorSet.addListener(animatorListenerAdapter);
        AnimatorSet animatorSet2 = animatorSet;
        AppMethodBeat.o(200417);
        return animatorSet2;
    }

    private Animator a(int i2, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(200418);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.targetView, "translationX", 0.0f, -((float) i2));
        p.g(ofFloat, "ObjectAnimator.ofFloat(t…, 0.0f, -width.toFloat())");
        ObjectAnimator objectAnimator = ofFloat;
        objectAnimator.setDuration(500L);
        objectAnimator.setInterpolator(new AccelerateInterpolator());
        animatorSet.playTogether(objectAnimator);
        animatorSet.addListener(animatorListenerAdapter);
        AnimatorSet animatorSet2 = animatorSet;
        AppMethodBeat.o(200418);
        return animatorSet2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBViewAnimationHandler$Companion;", "", "()V", "HIDE_ANIMATION_DURATION", "", "SHOW_ANIMATION_DURATION", "TAG", "", "TRANSLATE_ANIMATION_DURATION", "plugin-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
