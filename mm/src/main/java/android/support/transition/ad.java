package android.support.transition;

import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* access modifiers changed from: package-private */
public final class ad {
    private static boolean DA;
    private static Method Dz;

    static void c(ViewGroup viewGroup, boolean z) {
        dT();
        if (Dz != null) {
            try {
                Dz.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException | InvocationTargetException e2) {
            }
        }
    }

    private static void dT() {
        if (!DA) {
            try {
                Method declaredMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", Boolean.TYPE);
                Dz = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            DA = true;
        }
    }
}
