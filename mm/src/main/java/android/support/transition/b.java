package android.support.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public final class b extends am {
    private float AP = 3.0f;

    @Override // android.support.transition.t
    public final long a(ViewGroup viewGroup, Transition transition, v vVar, v vVar2) {
        int i2;
        int round;
        int i3;
        if (vVar == null && vVar2 == null) {
            return 0;
        }
        if (vVar2 == null || e(vVar) == 0) {
            i2 = -1;
            vVar2 = vVar;
        } else {
            i2 = 1;
        }
        int a2 = am.a(vVar2, 0);
        int a3 = am.a(vVar2, 1);
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            i3 = epicenter.centerX();
            round = epicenter.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int round2 = Math.round(((float) (iArr[0] + (viewGroup.getWidth() / 2))) + viewGroup.getTranslationX());
            round = Math.round(((float) (iArr[1] + (viewGroup.getHeight() / 2))) + viewGroup.getTranslationY());
            i3 = round2;
        }
        float e2 = e((float) a2, (float) a3, (float) i3, (float) round) / e(0.0f, 0.0f, (float) viewGroup.getWidth(), (float) viewGroup.getHeight());
        long j2 = transition.mDuration;
        if (j2 < 0) {
            j2 = 300;
        }
        return (long) Math.round((((float) (j2 * ((long) i2))) / this.AP) * e2);
    }

    private static float e(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        return (float) Math.sqrt((double) ((f6 * f6) + (f7 * f7)));
    }
}
