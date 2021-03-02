package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import com.tencent.mm.R;

final class x {
    static Animator a(View view, v vVar, int i2, int i3, float f2, float f3, float f4, float f5, TimeInterpolator timeInterpolator) {
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) vVar.view.getTag(R.id.iv4);
        if (iArr != null) {
            f2 = ((float) (iArr[0] - i2)) + translationX;
            f3 = ((float) (iArr[1] - i3)) + translationY;
        }
        int round = i2 + Math.round(f2 - translationX);
        int round2 = i3 + Math.round(f3 - translationY);
        view.setTranslationX(f2);
        view.setTranslationY(f3);
        if (f2 == f4 && f3 == f5) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f2, f4), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f3, f5));
        a aVar = new a(view, vVar.view, round, round2, translationX, translationY);
        ofPropertyValuesHolder.addListener(aVar);
        a.a(ofPropertyValuesHolder, aVar);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }

    static class a extends AnimatorListenerAdapter {
        private final View Dk;
        private final View Dl;
        private final int Dm;
        private final int Dn;
        private int[] Do = ((int[]) this.Dk.getTag(R.id.iv4));
        private float Dp;
        private float Dq;
        private final float Dr;
        private final float Ds;

        a(View view, View view2, int i2, int i3, float f2, float f3) {
            this.Dl = view;
            this.Dk = view2;
            this.Dm = i2 - Math.round(this.Dl.getTranslationX());
            this.Dn = i3 - Math.round(this.Dl.getTranslationY());
            this.Dr = f2;
            this.Ds = f3;
            if (this.Do != null) {
                this.Dk.setTag(R.id.iv4, null);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            if (this.Do == null) {
                this.Do = new int[2];
            }
            this.Do[0] = Math.round(((float) this.Dm) + this.Dl.getTranslationX());
            this.Do[1] = Math.round(((float) this.Dn) + this.Dl.getTranslationY());
            this.Dk.setTag(R.id.iv4, this.Do);
        }

        public final void onAnimationEnd(Animator animator) {
            this.Dl.setTranslationX(this.Dr);
            this.Dl.setTranslationY(this.Ds);
        }

        public final void onAnimationPause(Animator animator) {
            this.Dp = this.Dl.getTranslationX();
            this.Dq = this.Dl.getTranslationY();
            this.Dl.setTranslationX(this.Dr);
            this.Dl.setTranslationY(this.Ds);
        }

        public final void onAnimationResume(Animator animator) {
            this.Dl.setTranslationX(this.Dp);
            this.Dl.setTranslationY(this.Dq);
        }
    }
}
