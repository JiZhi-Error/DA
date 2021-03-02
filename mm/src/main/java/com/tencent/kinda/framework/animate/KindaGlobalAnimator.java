package com.tencent.kinda.framework.animate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class KindaGlobalAnimator {
    private static List<Animator> animList = new ArrayList();
    private static AnimatorSet animSet = null;
    private static long animateDuration;
    private static boolean isAnimated;
    private static Runnable onComplete = null;

    static /* synthetic */ void access$000(long j2, Runnable runnable) {
        AppMethodBeat.i(18334);
        setupAnimate(j2, runnable);
        AppMethodBeat.o(18334);
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.i(18335);
        startAnimInternal();
        AppMethodBeat.o(18335);
    }

    static {
        AppMethodBeat.i(18336);
        AppMethodBeat.o(18336);
    }

    private static void setupAnimate(long j2, Runnable runnable) {
        isAnimated = true;
        animateDuration = j2;
        onComplete = runnable;
    }

    public static boolean hasAnimate() {
        return isAnimated && animateDuration > 0;
    }

    public static long animateDuration() {
        return animateDuration;
    }

    private static void startAnimInternal() {
        AppMethodBeat.i(18330);
        isAnimated = false;
        animateDuration = 0;
        if (animList.size() > 0) {
            AnimatorSet animatorSet = new AnimatorSet();
            animSet = animatorSet;
            animatorSet.playTogether(animList);
            if (onComplete != null) {
                final Runnable runnable = onComplete;
                animSet.addListener(new AnimatorListenerAdapter() {
                    /* class com.tencent.kinda.framework.animate.KindaGlobalAnimator.AnonymousClass1 */

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(18327);
                        runnable.run();
                        AppMethodBeat.o(18327);
                    }
                });
            }
            animSet.start();
            animSet = null;
            animList.clear();
            onComplete = null;
        }
        AppMethodBeat.o(18330);
    }

    public static void startAnimate(final long j2, final Runnable runnable) {
        AppMethodBeat.i(18331);
        KindaAnimatorWatch.post(new Runnable() {
            /* class com.tencent.kinda.framework.animate.KindaGlobalAnimator.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(18328);
                if (j2 > 0 && runnable != null) {
                    KindaGlobalAnimator.access$000(j2, null);
                    runnable.run();
                    KindaGlobalAnimator.access$100();
                }
                AppMethodBeat.o(18328);
            }
        });
        AppMethodBeat.o(18331);
    }

    public static void startAnimate(final long j2, final Runnable runnable, final Runnable runnable2) {
        AppMethodBeat.i(18332);
        KindaAnimatorWatch.post(new Runnable() {
            /* class com.tencent.kinda.framework.animate.KindaGlobalAnimator.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(18329);
                if (j2 > 0 && runnable != null) {
                    KindaGlobalAnimator.access$000(j2, runnable2);
                    runnable.run();
                    KindaGlobalAnimator.access$100();
                    if (KindaGlobalAnimator.onComplete != null) {
                        KindaGlobalAnimator.onComplete.run();
                        Runnable unused = KindaGlobalAnimator.onComplete = null;
                    }
                }
                AppMethodBeat.o(18329);
            }
        });
        AppMethodBeat.o(18332);
    }

    public static void addAnimator(Animator animator) {
        AppMethodBeat.i(18333);
        animList.add(animator);
        AppMethodBeat.o(18333);
    }
}
