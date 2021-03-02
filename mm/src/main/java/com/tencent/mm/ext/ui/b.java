package com.tencent.mm.ext.ui;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class b {

    public interface a {
        void awJ();

        void onAnimationEnd();
    }

    @TargetApi(14)
    public static final void q(View view, float f2) {
        AppMethodBeat.i(197822);
        if (view == null || com.tencent.mm.ext.a.b.a.oE(14)) {
            AppMethodBeat.o(197822);
            return;
        }
        Animator animator = (Animator) view.getTag(R.id.glv);
        if (animator != null) {
            animator.cancel();
        }
        view.animate().cancel();
        view.setTranslationX(f2);
        view.setTranslationY(0.0f);
        AppMethodBeat.o(197822);
    }

    @TargetApi(14)
    public static final void a(View view, long j2, float f2, final a aVar) {
        AppMethodBeat.i(197823);
        if (view == null || com.tencent.mm.ext.a.b.a.oE(14)) {
            AppMethodBeat.o(197823);
            return;
        }
        Animator animator = (Animator) view.getTag(R.id.glv);
        if (animator != null) {
            animator.cancel();
        }
        com.tencent.liteapp.b.b.i("Changelcai", "[animTran] duration:%s x:%s", Long.valueOf(j2), Float.valueOf(f2));
        view.animate().cancel();
        view.animate().setListener(null);
        Interpolator loadInterpolator = AnimationUtils.loadInterpolator(view.getContext(), R.anim.co);
        if (aVar == null) {
            view.animate().setDuration(j2).translationX(f2).translationY(0.0f).setInterpolator(loadInterpolator);
            AppMethodBeat.o(197823);
            return;
        }
        view.animate().setDuration(j2).translationX(f2).translationY(0.0f).setInterpolator(loadInterpolator).setListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.ext.ui.b.AnonymousClass1 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(197820);
                aVar.onAnimationEnd();
                AppMethodBeat.o(197820);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(197821);
                aVar.awJ();
                AppMethodBeat.o(197821);
            }
        });
        AppMethodBeat.o(197823);
    }
}
