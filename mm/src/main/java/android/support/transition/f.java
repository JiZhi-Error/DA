package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class f implements g {
    static Class<?> Bn;
    private static boolean Bo;
    private static Method Bp;
    private static boolean Bq;
    static Method Br;
    static boolean Bs;
    private final View Bt;

    private f(View view) {
        this.Bt = view;
    }

    @Override // android.support.transition.g
    public final void setVisibility(int i2) {
        this.Bt.setVisibility(i2);
    }

    @Override // android.support.transition.g
    public final void a(ViewGroup viewGroup, View view) {
    }

    static void dL() {
        if (!Bo) {
            try {
                Bn = Class.forName("android.view.GhostView");
            } catch (ClassNotFoundException e2) {
            }
            Bo = true;
        }
    }

    static g a(View view, ViewGroup viewGroup, Matrix matrix) {
        if (!Bq) {
            try {
                dL();
                Method declaredMethod = Bn.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
                Bp = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            Bq = true;
        }
        if (Bp != null) {
            try {
                return new f((View) Bp.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException e3) {
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4.getCause());
            }
        }
        return null;
    }
}
