package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.transition.Transition;
import android.support.transition.v;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

public final class e extends Transition {
    @Override // android.support.transition.Transition
    public final void a(v vVar) {
        c(vVar);
    }

    @Override // android.support.transition.Transition
    public final void b(v vVar) {
        c(vVar);
    }

    private static void c(v vVar) {
        if (vVar.view instanceof TextView) {
            vVar.values.put("android:textscale:scale", Float.valueOf(((TextView) vVar.view).getScaleX()));
        }
    }

    @Override // android.support.transition.Transition
    public final Animator a(ViewGroup viewGroup, v vVar, v vVar2) {
        float f2;
        float f3 = 1.0f;
        if (vVar == null || vVar2 == null || !(vVar.view instanceof TextView) || !(vVar2.view instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) vVar2.view;
        Map<String, Object> map = vVar.values;
        Map<String, Object> map2 = vVar2.values;
        if (map.get("android:textscale:scale") != null) {
            f2 = ((Float) map.get("android:textscale:scale")).floatValue();
        } else {
            f2 = 1.0f;
        }
        if (map2.get("android:textscale:scale") != null) {
            f3 = ((Float) map2.get("android:textscale:scale")).floatValue();
        }
        if (f2 == f3) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f3);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class android.support.design.internal.e.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }
}
