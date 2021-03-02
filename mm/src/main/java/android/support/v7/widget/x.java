package android.support.v7.widget;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.support.v4.graphics.drawable.a;
import android.support.v4.graphics.drawable.f;
import android.support.v7.d.a.c;
import java.lang.reflect.Field;

public final class x {
    public static final Rect amQ = new Rect();
    private static Class<?> amR;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                amR = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e2) {
            }
        }
    }

    public static Rect r(Drawable drawable) {
        if (amR != null) {
            try {
                Drawable j2 = a.j(drawable);
                Object invoke = j2.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(j2, new Object[0]);
                if (invoke != null) {
                    Rect rect = new Rect();
                    Field[] fields = amR.getFields();
                    for (Field field : fields) {
                        String name = field.getName();
                        char c2 = 65535;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                                rect.left = field.getInt(invoke);
                                break;
                            case 1:
                                rect.top = field.getInt(invoke);
                                break;
                            case 2:
                                rect.right = field.getInt(invoke);
                                break;
                            case 3:
                                rect.bottom = field.getInt(invoke);
                                break;
                        }
                    }
                    return rect;
                }
            } catch (Exception e2) {
            }
        }
        return amQ;
    }

    static void s(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            int[] state = drawable.getState();
            if (state == null || state.length == 0) {
                drawable.setState(av.jV);
            } else {
                drawable.setState(av.EMPTY_STATE_SET);
            }
            drawable.setState(state);
        }
    }

    public static boolean t(Drawable drawable) {
        Drawable drawable2 = drawable;
        while (true) {
            if (Build.VERSION.SDK_INT < 15 && (drawable2 instanceof InsetDrawable)) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 15 && (drawable2 instanceof GradientDrawable)) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 17 && (drawable2 instanceof LayerDrawable)) {
                return false;
            }
            if (drawable2 instanceof DrawableContainer) {
                Drawable.ConstantState constantState = drawable2.getConstantState();
                if (constantState instanceof DrawableContainer.DrawableContainerState) {
                    Drawable[] children = ((DrawableContainer.DrawableContainerState) constantState).getChildren();
                    for (Drawable drawable3 : children) {
                        if (!t(drawable3)) {
                            return false;
                        }
                    }
                }
            } else if (drawable2 instanceof f) {
                drawable2 = ((f) drawable2).eF();
            } else if (!(drawable2 instanceof c)) {
                if (!(drawable2 instanceof ScaleDrawable)) {
                    break;
                }
                drawable2 = ((ScaleDrawable) drawable2).getDrawable();
            } else {
                drawable2 = ((c) drawable2).mDrawable;
            }
        }
        return true;
    }

    public static PorterDuff.Mode a(int i2, PorterDuff.Mode mode) {
        switch (i2) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 4:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
                return mode;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
        }
    }
}
