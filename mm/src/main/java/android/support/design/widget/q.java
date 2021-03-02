package android.support.design.widget;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.internal.f;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.mm.R;

final class q {
    private static final int[] wI = {16843848};

    static void B(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        TypedArray a2 = f.a(context, attributeSet, wI, 0, R.style.a3p, new int[0]);
        try {
            if (a2.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, a2.getResourceId(0, 0)));
            }
        } finally {
            a2.recycle();
        }
    }

    static void c(View view, float f2) {
        int integer = view.getResources().getInteger(R.integer.f3100d);
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(new int[]{16842766, R.attr.a02, -2130969567}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration((long) integer));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, "elevation", f2).setDuration((long) integer));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }
}
