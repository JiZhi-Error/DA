package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeScroll extends Transition {
    private static final String[] Aw = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.transition.Transition
    public final void a(v vVar) {
        c(vVar);
    }

    @Override // android.support.transition.Transition
    public final void b(v vVar) {
        c(vVar);
    }

    @Override // android.support.transition.Transition
    public final String[] getTransitionProperties() {
        return Aw;
    }

    private static void c(v vVar) {
        vVar.values.put("android:changeScroll:x", Integer.valueOf(vVar.view.getScrollX()));
        vVar.values.put("android:changeScroll:y", Integer.valueOf(vVar.view.getScrollY()));
    }

    @Override // android.support.transition.Transition
    public final Animator a(ViewGroup viewGroup, v vVar, v vVar2) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        if (vVar == null || vVar2 == null) {
            return null;
        }
        View view = vVar2.view;
        int intValue = ((Integer) vVar.values.get("android:changeScroll:x")).intValue();
        int intValue2 = ((Integer) vVar2.values.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) vVar.values.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) vVar2.values.get("android:changeScroll:y")).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            objectAnimator = ObjectAnimator.ofInt(view, "scrollX", intValue, intValue2);
        } else {
            objectAnimator = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            objectAnimator2 = ObjectAnimator.ofInt(view, "scrollY", intValue3, intValue4);
        } else {
            objectAnimator2 = null;
        }
        return u.a(objectAnimator, objectAnimator2);
    }
}
