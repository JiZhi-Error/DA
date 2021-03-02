package com.tencent.mm.plugin.ball.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends AnimatorListenerAdapter {
    private AnimatorListenerAdapter oWj;
    private View targetView;

    public d(View view, AnimatorListenerAdapter animatorListenerAdapter) {
        this.targetView = view;
        this.oWj = animatorListenerAdapter;
    }

    public final void onAnimationCancel(Animator animator) {
        AppMethodBeat.i(106048);
        super.onAnimationCancel(animator);
        if (this.targetView != null) {
            this.targetView.setVisibility(8);
        }
        if (this.oWj != null) {
            this.oWj.onAnimationCancel(animator);
        }
        AppMethodBeat.o(106048);
    }

    public final void onAnimationEnd(Animator animator) {
        AppMethodBeat.i(106049);
        super.onAnimationEnd(animator);
        if (this.targetView != null) {
            this.targetView.setVisibility(8);
        }
        if (this.oWj != null) {
            this.oWj.onAnimationEnd(animator);
        }
        AppMethodBeat.o(106049);
    }

    public final void onAnimationRepeat(Animator animator) {
        AppMethodBeat.i(106050);
        super.onAnimationRepeat(animator);
        if (this.oWj != null) {
            this.oWj.onAnimationRepeat(animator);
        }
        AppMethodBeat.o(106050);
    }

    public final void onAnimationStart(Animator animator) {
        AppMethodBeat.i(106051);
        super.onAnimationStart(animator);
        if (this.oWj != null) {
            this.oWj.onAnimationStart(animator);
        }
        AppMethodBeat.o(106051);
    }

    public final void onAnimationPause(Animator animator) {
        AppMethodBeat.i(106052);
        super.onAnimationPause(animator);
        if (this.oWj != null) {
            this.oWj.onAnimationPause(animator);
        }
        AppMethodBeat.o(106052);
    }

    public final void onAnimationResume(Animator animator) {
        AppMethodBeat.i(106053);
        super.onAnimationResume(animator);
        if (this.oWj != null) {
            this.oWj.onAnimationResume(animator);
        }
        AppMethodBeat.o(106053);
    }
}
