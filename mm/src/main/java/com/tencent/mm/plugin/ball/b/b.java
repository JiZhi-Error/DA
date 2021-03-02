package com.tencent.mm.plugin.ball.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Vector;

public final class b {
    private Animator oWg;
    private Animator oWh;
    public Vector<Runnable> oWi = new Vector<>();
    protected View targetView;

    public b(View view) {
        AppMethodBeat.i(106042);
        this.targetView = view;
        AppMethodBeat.o(106042);
    }

    public final boolean chI() {
        AppMethodBeat.i(106043);
        if (this.oWg == null || !this.oWg.isRunning()) {
            AppMethodBeat.o(106043);
            return false;
        }
        AppMethodBeat.o(106043);
        return true;
    }

    public final boolean chJ() {
        AppMethodBeat.i(106044);
        if (this.oWh == null || !this.oWh.isRunning()) {
            AppMethodBeat.o(106044);
            return false;
        }
        AppMethodBeat.o(106044);
        return true;
    }

    public final void chK() {
        AppMethodBeat.i(106045);
        if (!this.oWi.isEmpty()) {
            Log.i("MicroMsg.FloatBallViewAnimationHandler", "firePendingTasks, size:%s", Integer.valueOf(this.oWi.size()));
            Iterator<Runnable> it = this.oWi.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            this.oWi.clear();
        }
        AppMethodBeat.o(106045);
    }

    public final void a(AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(184558);
        if (this.targetView == null) {
            AppMethodBeat.o(184558);
        } else if (chI()) {
            Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingShow");
            AppMethodBeat.o(184558);
        } else {
            if (chJ()) {
                Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel hide animator");
                this.oWh.cancel();
            }
            C0851b bVar = new C0851b(this.targetView, animatorListenerAdapter);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.targetView, "alpha", 0.0f, 1.0f);
            ofFloat.setDuration(200L);
            animatorSet.playTogether(ofFloat);
            animatorSet.addListener(bVar);
            this.oWg = animatorSet;
            this.oWg.start();
            this.targetView.setVisibility(0);
            AppMethodBeat.o(184558);
        }
    }

    public final void a(int i2, boolean z, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(216967);
        if (this.targetView == null) {
            AppMethodBeat.o(216967);
        } else if (chI()) {
            Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingShow");
            AppMethodBeat.o(216967);
        } else {
            if (chJ()) {
                Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel hide animator");
                this.oWh.cancel();
            }
            Log.v("MicroMsg.FloatBallViewAnimationHandler", "playShowTranslateAnimation, view:%s, width: %d, isDockLeft: %b", this.targetView, Integer.valueOf(i2), Boolean.valueOf(z));
            this.oWg = a(true, i2, z, new C0851b(this.targetView, animatorListenerAdapter));
            this.oWg.start();
            this.targetView.setAlpha(1.0f);
            this.targetView.setVisibility(0);
            AppMethodBeat.o(216967);
        }
    }

    public final void b(AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(184559);
        if (this.targetView == null) {
            AppMethodBeat.o(184559);
        } else if (chJ()) {
            Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
            AppMethodBeat.o(184559);
        } else {
            if (chI()) {
                Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
                this.oWg.cancel();
            }
            a aVar = new a(this.targetView, animatorListenerAdapter);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.targetView, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(100L);
            animatorSet.playTogether(ofFloat);
            animatorSet.addListener(aVar);
            this.oWh = animatorSet;
            this.oWh.start();
            AppMethodBeat.o(184559);
        }
    }

    public final void b(int i2, boolean z, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(216968);
        if (this.targetView == null) {
            AppMethodBeat.o(216968);
        } else if (chJ()) {
            Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
            AppMethodBeat.o(216968);
        } else {
            if (chI()) {
                Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
                this.oWg.cancel();
            }
            Log.v("MicroMsg.FloatBallViewAnimationHandler", "playHideTranslateAnimation, view:%s, width: %d, isDockLeft: %b", this.targetView, Integer.valueOf(i2), Boolean.valueOf(z));
            this.oWh = a(false, i2, z, new a(this.targetView, animatorListenerAdapter));
            this.oWh.start();
            AppMethodBeat.o(216968);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ball.b.b$b  reason: collision with other inner class name */
    public class C0851b extends AnimatorListenerAdapter {
        private AnimatorListenerAdapter oWj;
        private View targetView;

        public C0851b(View view, AnimatorListenerAdapter animatorListenerAdapter) {
            this.targetView = view;
            this.oWj = animatorListenerAdapter;
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(106036);
            super.onAnimationCancel(animator);
            if (this.targetView != null) {
                this.targetView.setVisibility(0);
            }
            if (this.oWj != null) {
                this.oWj.onAnimationCancel(animator);
            }
            b.this.chK();
            AppMethodBeat.o(106036);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(106037);
            super.onAnimationEnd(animator);
            if (this.targetView != null) {
                this.targetView.setVisibility(0);
            }
            if (this.oWj != null) {
                this.oWj.onAnimationEnd(animator);
            }
            b.this.chK();
            AppMethodBeat.o(106037);
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(106038);
            super.onAnimationRepeat(animator);
            if (this.oWj != null) {
                this.oWj.onAnimationRepeat(animator);
            }
            AppMethodBeat.o(106038);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(106039);
            super.onAnimationStart(animator);
            if (this.oWj != null) {
                this.oWj.onAnimationStart(animator);
            }
            AppMethodBeat.o(106039);
        }

        public final void onAnimationPause(Animator animator) {
            AppMethodBeat.i(106040);
            super.onAnimationPause(animator);
            if (this.oWj != null) {
                this.oWj.onAnimationPause(animator);
            }
            AppMethodBeat.o(106040);
        }

        public final void onAnimationResume(Animator animator) {
            AppMethodBeat.i(106041);
            super.onAnimationResume(animator);
            if (this.oWj != null) {
                this.oWj.onAnimationResume(animator);
            }
            AppMethodBeat.o(106041);
        }
    }

    public class a extends AnimatorListenerAdapter {
        private AnimatorListenerAdapter oWj;
        private View targetView;

        public a(View view, AnimatorListenerAdapter animatorListenerAdapter) {
            this.targetView = view;
            this.oWj = animatorListenerAdapter;
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(106030);
            super.onAnimationCancel(animator);
            if (this.targetView != null) {
                this.targetView.setVisibility(8);
            }
            if (this.oWj != null) {
                this.oWj.onAnimationCancel(animator);
            }
            b.this.chK();
            AppMethodBeat.o(106030);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(106031);
            super.onAnimationEnd(animator);
            if (this.targetView != null) {
                this.targetView.setVisibility(8);
            }
            if (this.oWj != null) {
                this.oWj.onAnimationEnd(animator);
            }
            b.this.chK();
            AppMethodBeat.o(106031);
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(106032);
            super.onAnimationRepeat(animator);
            if (this.oWj != null) {
                this.oWj.onAnimationRepeat(animator);
            }
            AppMethodBeat.o(106032);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(106033);
            super.onAnimationStart(animator);
            if (this.oWj != null) {
                this.oWj.onAnimationStart(animator);
            }
            AppMethodBeat.o(106033);
        }

        public final void onAnimationPause(Animator animator) {
            AppMethodBeat.i(106034);
            super.onAnimationPause(animator);
            if (this.oWj != null) {
                this.oWj.onAnimationPause(animator);
            }
            AppMethodBeat.o(106034);
        }

        public final void onAnimationResume(Animator animator) {
            AppMethodBeat.i(106035);
            super.onAnimationResume(animator);
            if (this.oWj != null) {
                this.oWj.onAnimationResume(animator);
            }
            AppMethodBeat.o(106035);
        }
    }

    private Animator a(boolean z, int i2, boolean z2, AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofFloat;
        AppMethodBeat.i(216969);
        AnimatorSet animatorSet = new AnimatorSet();
        if (z) {
            if (z2) {
                ofFloat = ObjectAnimator.ofFloat(this.targetView, "translationX", (float) (-i2), 0.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(this.targetView, "translationX", (float) i2, 0.0f);
            }
        } else if (z2) {
            ofFloat = ObjectAnimator.ofFloat(this.targetView, "translationX", 0.0f, (float) (-i2));
        } else {
            ofFloat = ObjectAnimator.ofFloat(this.targetView, "translationX", 0.0f, (float) i2);
        }
        ofFloat.setDuration(300L);
        animatorSet.playTogether(ofFloat);
        animatorSet.addListener(animatorListenerAdapter);
        AppMethodBeat.o(216969);
        return animatorSet;
    }
}
