package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class e {
    private static Field Tf;
    private static boolean Tg;

    public static void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintList(colorStateList);
        } else if (compoundButton instanceof r) {
            ((r) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    public static void a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintMode(mode);
        } else if (compoundButton instanceof r) {
            ((r) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    public static Drawable a(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!Tg) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                Tf = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            Tg = true;
        }
        if (Tf != null) {
            try {
                return (Drawable) Tf.get(compoundButton);
            } catch (IllegalAccessException e3) {
                Tf = null;
            }
        }
        return null;
    }
}
