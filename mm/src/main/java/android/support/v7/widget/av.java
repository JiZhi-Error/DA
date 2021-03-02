package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.graphics.b;
import android.util.AttributeSet;
import android.util.TypedValue;

/* access modifiers changed from: package-private */
public final class av {
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] FOCUSED_STATE_SET = {16842908};
    static final int[] PRESSED_STATE_SET = {16842919};
    static final int[] SELECTED_STATE_SET = {16842913};
    private static final ThreadLocal<TypedValue> aaT = new ThreadLocal<>();
    static final int[] ayt = {16843518};
    static final int[] ayu = {-16842919, -16842908};
    private static final int[] ayv = new int[1];
    static final int[] jV = {16842912};
    static final int[] kh = {-16842910};

    public static int v(Context context, int i2) {
        ayv[0] = i2;
        az a2 = az.a(context, (AttributeSet) null, ayv);
        try {
            return a2.getColor(0, 0);
        } finally {
            a2.ayy.recycle();
        }
    }

    public static ColorStateList w(Context context, int i2) {
        ayv[0] = i2;
        az a2 = az.a(context, (AttributeSet) null, ayv);
        try {
            return a2.getColorStateList(0);
        } finally {
            a2.ayy.recycle();
        }
    }

    public static int x(Context context, int i2) {
        ColorStateList w = w(context, i2);
        if (w != null && w.isStateful()) {
            return w.getColorForState(kh, w.getDefaultColor());
        }
        TypedValue typedValue = aaT.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            aaT.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        float f2 = typedValue.getFloat();
        int v = v(context, i2);
        return b.x(v, Math.round(f2 * ((float) Color.alpha(v))));
    }
}
