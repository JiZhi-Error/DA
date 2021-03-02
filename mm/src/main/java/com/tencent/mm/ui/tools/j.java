package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class j {

    public interface a {
        void awJ();

        void onAnimationEnd();
    }

    @TargetApi(11)
    public static final void D(View view, float f2) {
        AppMethodBeat.i(143107);
        if (view == null || d.oE(11)) {
            AppMethodBeat.o(143107);
            return;
        }
        Animator animator = (Animator) view.getTag(R.id.glv);
        if (animator != null) {
            animator.cancel();
        }
        view.setScaleX(f2);
        view.setScaleY(f2);
        AppMethodBeat.o(143107);
    }

    @TargetApi(14)
    public static final void q(View view, float f2) {
        AppMethodBeat.i(143108);
        if (view == null || d.oE(14)) {
            AppMethodBeat.o(143108);
            return;
        }
        Animator animator = (Animator) view.getTag(R.id.glv);
        if (animator != null) {
            animator.cancel();
        }
        view.animate().cancel();
        view.setTranslationX(f2);
        view.setTranslationY(0.0f);
        AppMethodBeat.o(143108);
    }

    @TargetApi(14)
    public static final void a(View view, long j2, float f2, final a aVar) {
        AppMethodBeat.i(143109);
        if (view == null || d.oE(14)) {
            AppMethodBeat.o(143109);
            return;
        }
        Animator animator = (Animator) view.getTag(R.id.glv);
        if (animator != null) {
            animator.cancel();
        }
        Log.i("Changelcai", "[animTran] duration:%s x:%s", Long.valueOf(j2), Float.valueOf(f2));
        view.animate().cancel();
        view.animate().setListener(null);
        Interpolator loadInterpolator = AnimationUtils.loadInterpolator(view.getContext(), R.anim.co);
        if (aVar == null) {
            view.animate().setDuration(j2).translationX(f2).translationY(0.0f).setInterpolator(loadInterpolator);
            AppMethodBeat.o(143109);
            return;
        }
        view.animate().setDuration(j2).translationX(f2).translationY(0.0f).setInterpolator(loadInterpolator).setListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.ui.tools.j.AnonymousClass1 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(143105);
                aVar.onAnimationEnd();
                AppMethodBeat.o(143105);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(143106);
                aVar.awJ();
                AppMethodBeat.o(143106);
            }
        });
        AppMethodBeat.o(143109);
    }

    @TargetApi(11)
    public static void a(View view, Animator.AnimatorListener animatorListener) {
        AppMethodBeat.i(143110);
        if (view == null || d.oE(11)) {
            AppMethodBeat.o(143110);
            return;
        }
        Animator animator = (Animator) view.getTag(R.id.glv);
        if (animator != null) {
            animator.cancel();
        }
        Animator loadAnimator = AnimatorInflater.loadAnimator(view.getContext(), R.animator.f3011f);
        loadAnimator.setTarget(view);
        if (animatorListener != null) {
            loadAnimator.addListener(animatorListener);
        }
        loadAnimator.start();
        view.setTag(R.id.glv, loadAnimator);
        AppMethodBeat.o(143110);
    }
}
