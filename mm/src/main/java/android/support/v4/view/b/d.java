package android.support.v4.view.b;

import android.view.animation.Interpolator;

/* access modifiers changed from: package-private */
public abstract class d implements Interpolator {
    private final float[] AI;
    private final float Sd = (1.0f / ((float) (this.AI.length - 1)));

    protected d(float[] fArr) {
        this.AI = fArr;
    }

    public float getInterpolation(float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.AI.length - 1)) * f2), this.AI.length - 2);
        float f3 = (f2 - (((float) min) * this.Sd)) / this.Sd;
        return ((this.AI[min + 1] - this.AI[min]) * f3) + this.AI[min];
    }
}
