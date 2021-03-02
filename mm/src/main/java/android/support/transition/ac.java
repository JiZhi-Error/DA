package android.support.transition;

import android.animation.LayoutTransition;
import android.view.ViewGroup;
import com.tencent.mm.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* access modifiers changed from: package-private */
public final class ac {
    private static LayoutTransition Du;
    private static Field Dv;
    private static boolean Dw;
    private static Method Dx;
    private static boolean Dy;

    static void c(ViewGroup viewGroup, boolean z) {
        boolean z2 = false;
        if (Du == null) {
            AnonymousClass1 r1 = new LayoutTransition() {
                /* class android.support.transition.ac.AnonymousClass1 */

                public final boolean isChangingLayout() {
                    return true;
                }
            };
            Du = r1;
            r1.setAnimator(2, null);
            Du.setAnimator(0, null);
            Du.setAnimator(1, null);
            Du.setAnimator(3, null);
            Du.setAnimator(4, null);
        }
        if (z) {
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    a(layoutTransition);
                }
                if (layoutTransition != Du) {
                    viewGroup.setTag(R.id.iv2, layoutTransition);
                }
            }
            viewGroup.setLayoutTransition(Du);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!Dw) {
            try {
                Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                Dv = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            Dw = true;
        }
        if (Dv != null) {
            try {
                z2 = Dv.getBoolean(viewGroup);
                if (z2) {
                    Dv.setBoolean(viewGroup, false);
                }
            } catch (IllegalAccessException e3) {
            }
        }
        if (z2) {
            viewGroup.requestLayout();
        }
        LayoutTransition layoutTransition2 = (LayoutTransition) viewGroup.getTag(R.id.iv2);
        if (layoutTransition2 != null) {
            viewGroup.setTag(R.id.iv2, null);
            viewGroup.setLayoutTransition(layoutTransition2);
        }
    }

    private static void a(LayoutTransition layoutTransition) {
        if (!Dy) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                Dx = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            Dy = true;
        }
        if (Dx != null) {
            try {
                Dx.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException e3) {
            }
        }
    }
}
