package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import android.os.Build;

final class u {
    private static final boolean Da;
    private static final boolean Db;
    private static final boolean Dc;

    static {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (Build.VERSION.SDK_INT >= 19) {
            z = true;
        } else {
            z = false;
        }
        Da = z;
        if (Build.VERSION.SDK_INT >= 18) {
            z2 = true;
        } else {
            z2 = false;
        }
        Db = z2;
        if (Build.VERSION.SDK_INT < 28) {
            z3 = false;
        }
        Dc = z3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.view.View a(android.view.ViewGroup r16, android.view.View r17, android.view.View r18) {
        /*
        // Method dump skipped, instructions count: 301
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.u.a(android.view.ViewGroup, android.view.View, android.view.View):android.view.View");
    }

    static Animator a(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }

    static class a implements TypeEvaluator<Matrix> {
        final Matrix AB = new Matrix();
        final float[] Dd = new float[9];
        final float[] De = new float[9];

        a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
        @Override // android.animation.TypeEvaluator
        public final /* synthetic */ Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.Dd);
            matrix2.getValues(this.De);
            for (int i2 = 0; i2 < 9; i2++) {
                this.De[i2] = ((this.De[i2] - this.Dd[i2]) * f2) + this.Dd[i2];
            }
            this.AB.setValues(this.De);
            return this.AB;
        }
    }
}
