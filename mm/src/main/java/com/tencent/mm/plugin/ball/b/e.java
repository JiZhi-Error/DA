package com.tencent.mm.plugin.ball.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e extends AnimatorListenerAdapter {
    private AnimatorListenerAdapter oWj = null;
    private View targetView;

    public e(View view, AnimatorListenerAdapter animatorListenerAdapter) {
        this.targetView = view;
    }

    public final void onAnimationCancel(Animator animator) {
        AppMethodBeat.i(106054);
        super.onAnimationCancel(animator);
        if (this.targetView != null) {
            this.targetView.setVisibility(0);
        }
        if (this.oWj != null) {
            this.oWj.onAnimationCancel(animator);
        }
        AppMethodBeat.o(106054);
    }

    public final void onAnimationEnd(Animator animator) {
        AppMethodBeat.i(106055);
        super.onAnimationEnd(animator);
        if (this.targetView != null) {
            this.targetView.setVisibility(0);
        }
        if (this.oWj != null) {
            this.oWj.onAnimationEnd(animator);
        }
        AppMethodBeat.o(106055);
    }

    public final void onAnimationRepeat(Animator animator) {
        AppMethodBeat.i(106056);
        super.onAnimationRepeat(animator);
        if (this.oWj != null) {
            this.oWj.onAnimationRepeat(animator);
        }
        AppMethodBeat.o(106056);
    }

    public final void onAnimationStart(Animator animator) {
        AppMethodBeat.i(106057);
        super.onAnimationStart(animator);
        if (this.oWj != null) {
            this.oWj.onAnimationStart(animator);
        }
        AppMethodBeat.o(106057);
    }

    public final void onAnimationPause(Animator animator) {
        AppMethodBeat.i(106058);
        super.onAnimationPause(animator);
        if (this.oWj != null) {
            this.oWj.onAnimationPause(animator);
        }
        AppMethodBeat.o(106058);
    }

    public final void onAnimationResume(Animator animator) {
        AppMethodBeat.i(106059);
        super.onAnimationResume(animator);
        if (this.oWj != null) {
            this.oWj.onAnimationResume(animator);
        }
        AppMethodBeat.o(106059);
    }
}
