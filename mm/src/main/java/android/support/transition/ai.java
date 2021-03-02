package android.support.transition;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ai extends al {
    private static Method DN;
    private static boolean DO;
    private static Method DP;
    private static boolean DQ;

    ai() {
    }

    @Override // android.support.transition.al
    public final void Q(View view) {
    }

    @Override // android.support.transition.al
    public final void R(View view) {
    }

    @Override // android.support.transition.al
    public final void d(View view, float f2) {
        if (!DO) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
                DN = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            DO = true;
        }
        if (DN != null) {
            try {
                DN.invoke(view, Float.valueOf(f2));
            } catch (IllegalAccessException e3) {
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4.getCause());
            }
        } else {
            view.setAlpha(f2);
        }
    }

    @Override // android.support.transition.al
    public final float P(View view) {
        if (!DQ) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
                DP = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            DQ = true;
        }
        if (DP != null) {
            try {
                return ((Float) DP.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException e3) {
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4.getCause());
            }
        }
        return super.P(view);
    }
}
