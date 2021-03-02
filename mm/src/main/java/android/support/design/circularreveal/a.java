package android.support.design.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.support.design.circularreveal.c;
import android.view.View;
import android.view.ViewAnimationUtils;

public final class a {
    public static Animator a(c cVar, float f2, float f3, float f4) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(cVar, c.b.jQ, c.a.jP, new c.d(f2, f3, f4));
        if (Build.VERSION.SDK_INT < 21) {
            return ofObject;
        }
        c.d revealInfo = cVar.getRevealInfo();
        if (revealInfo == null) {
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) cVar, (int) f2, (int) f3, revealInfo.radius, f4);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofObject, createCircularReveal);
        return animatorSet;
    }
}
