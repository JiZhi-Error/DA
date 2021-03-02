package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.u;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class bh {
    private static Method aAd;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                aAd = declaredMethod;
                if (!declaredMethod.isAccessible()) {
                    aAd.setAccessible(true);
                }
            } catch (NoSuchMethodException e2) {
            }
        }
    }

    public static boolean d(View view) {
        return u.Z(view) == 1;
    }

    public static void a(View view, Rect rect, Rect rect2) {
        if (aAd != null) {
            try {
                aAd.invoke(view, rect, rect2);
            } catch (Exception e2) {
            }
        }
    }

    public static void bS(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            }
        }
    }
}
