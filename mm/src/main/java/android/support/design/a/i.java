package android.support.design.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public final class i {
    public long duration = 300;
    public long gY = 0;
    private TimeInterpolator gZ = null;
    private int repeatCount = 0;
    private int repeatMode = 1;

    public i(long j2) {
        this.gY = j2;
        this.duration = 150;
    }

    private i(long j2, long j3, TimeInterpolator timeInterpolator) {
        this.gY = j2;
        this.duration = j3;
        this.gZ = timeInterpolator;
    }

    public final TimeInterpolator getInterpolator() {
        return this.gZ != null ? this.gZ : a.gL;
    }

    static i a(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), b(valueAnimator));
        iVar.repeatCount = valueAnimator.getRepeatCount();
        iVar.repeatMode = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator b(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return a.gL;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return a.gM;
        }
        if (interpolator instanceof DecelerateInterpolator) {
            return a.gN;
        }
        return interpolator;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.gY == iVar.gY && this.duration == iVar.duration && this.repeatCount == iVar.repeatCount && this.repeatMode == iVar.repeatMode) {
            return getInterpolator().getClass().equals(iVar.getInterpolator().getClass());
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((int) (this.gY ^ (this.gY >>> 32))) * 31) + ((int) (this.duration ^ (this.duration >>> 32)))) * 31) + getInterpolator().getClass().hashCode()) * 31) + this.repeatCount) * 31) + this.repeatMode;
    }

    public final String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + this.gY + " duration: " + this.duration + " interpolator: " + getInterpolator().getClass() + " repeatCount: " + this.repeatCount + " repeatMode: " + this.repeatMode + "}\n";
    }

    public final void a(Animator animator) {
        animator.setStartDelay(this.gY);
        animator.setDuration(this.duration);
        animator.setInterpolator(getInterpolator());
        if (animator instanceof ValueAnimator) {
            ((ValueAnimator) animator).setRepeatCount(this.repeatCount);
            ((ValueAnimator) animator).setRepeatMode(this.repeatMode);
        }
    }
}
