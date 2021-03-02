package android.support.v4.widget;

import android.os.Build;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class n {
    private static Method Va;
    private static boolean Vb;
    private static Field Vc;
    private static boolean Vd;

    public static void a(PopupWindow popupWindow, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setOverlapAnchor(z);
        } else if (Build.VERSION.SDK_INT >= 21) {
            if (!Vd) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    Vc = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                }
                Vd = true;
            }
            if (Vc != null) {
                try {
                    Vc.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e3) {
                }
            }
        }
    }

    public static void a(PopupWindow popupWindow, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i2);
            return;
        }
        if (!Vb) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                Va = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception e2) {
            }
            Vb = true;
        }
        if (Va != null) {
            try {
                Va.invoke(popupWindow, Integer.valueOf(i2));
            } catch (Exception e3) {
            }
        }
    }
}
