package android.support.v4.view;

import android.os.Build;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

public final class f {
    private static Field PT;
    private static boolean PU;

    private static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!PU) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                PT = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                new StringBuilder("forceSetFactory2 Could not find field 'mFactory2' on class ").append(LayoutInflater.class.getName()).append("; inflation may have unexpected results.");
            }
            PU = true;
        }
        if (PT != null) {
            try {
                PT.set(layoutInflater, factory2);
            } catch (IllegalAccessException e3) {
                new StringBuilder("forceSetFactory2 could not set the Factory2 on LayoutInflater ").append(layoutInflater).append("; inflation may have unexpected results.");
            }
        }
    }

    public static void b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                a(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                a(layoutInflater, factory2);
            }
        }
    }
}
