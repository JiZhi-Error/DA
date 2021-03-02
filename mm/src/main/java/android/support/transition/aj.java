package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class aj extends ai {
    private static Method DR;
    private static boolean DS;
    private static Method DT;
    private static boolean DU;
    private static Method DV;
    private static boolean DW;

    aj() {
    }

    @Override // android.support.transition.al
    public final void a(View view, Matrix matrix) {
        if (!DS) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
                DR = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            DS = true;
        }
        if (DR != null) {
            try {
                DR.invoke(view, matrix);
            } catch (IllegalAccessException e3) {
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4.getCause());
            }
        }
    }

    @Override // android.support.transition.al
    public final void b(View view, Matrix matrix) {
        if (!DU) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
                DT = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            DU = true;
        }
        if (DT != null) {
            try {
                DT.invoke(view, matrix);
            } catch (IllegalAccessException e3) {
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4.getCause());
            }
        }
    }

    @Override // android.support.transition.al
    public final void c(View view, Matrix matrix) {
        if (!DW) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("setAnimationMatrix", Matrix.class);
                DV = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            DW = true;
        }
        if (DV != null) {
            try {
                DV.invoke(view, matrix);
            } catch (InvocationTargetException e3) {
            } catch (IllegalAccessException e4) {
                throw new RuntimeException(e4.getCause());
            }
        }
    }
}
