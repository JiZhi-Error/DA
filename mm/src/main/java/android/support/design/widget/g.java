package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import java.lang.reflect.Method;

public final class g {
    private static Method qY;
    private static boolean qZ;

    static boolean a(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        if (!qZ) {
            try {
                Method declaredMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", DrawableContainer.DrawableContainerState.class);
                qY = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            qZ = true;
        }
        if (qY != null) {
            try {
                qY.invoke(drawableContainer, constantState);
                return true;
            } catch (Exception e3) {
            }
        }
        return false;
    }
}
