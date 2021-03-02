package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a;
import android.support.v7.widget.az;
import android.util.AttributeSet;
import com.tencent.mm.R;

public final class f {
    private static final int[] ls = {R.attr.g6};
    private static final int[] lt = {R.attr.g9};

    public static TypedArray a(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        a(context, attributeSet, i2, i3);
        c(context, attributeSet, iArr, i2, i3, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
    }

    public static az b(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        a(context, attributeSet, i2, i3);
        c(context, attributeSet, iArr, i2, i3, iArr2);
        return az.a(context, attributeSet, iArr, i2, i3);
    }

    private static void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0008a.ThemeEnforcement, i2, i3);
        boolean z = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
        if (z) {
            H(context);
        }
        G(context);
    }

    private static void c(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        boolean z = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0008a.ThemeEnforcement, i2, i3);
        if (!obtainStyledAttributes.getBoolean(2, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 != null && iArr2.length != 0) {
            z = d(context, attributeSet, iArr, i2, i3, iArr2);
        } else if (obtainStyledAttributes.getResourceId(0, -1) != -1) {
            z = true;
        }
        obtainStyledAttributes.recycle();
        if (!z) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static boolean d(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        for (int i4 : iArr2) {
            if (obtainStyledAttributes.getResourceId(i4, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    private static void G(Context context) {
        a(context, ls, "Theme.AppCompat");
    }

    private static void H(Context context) {
        a(context, lt, "Theme.MaterialComponents");
    }

    private static boolean a(Context context, int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        boolean hasValue = obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        return hasValue;
    }

    private static void a(Context context, int[] iArr, String str) {
        if (!a(context, iArr)) {
            throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
        }
    }
}
