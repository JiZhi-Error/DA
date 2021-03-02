package android.support.v7.c.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.b;
import android.support.v7.widget.g;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

public final class a {
    private static final ThreadLocal<TypedValue> aaT = new ThreadLocal<>();
    private static final WeakHashMap<Context, SparseArray<C0043a>> aaU = new WeakHashMap<>(0);
    private static final Object aaV = new Object();

    public static ColorStateList m(Context context, @android.support.annotation.a int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        ColorStateList q = q(context, i2);
        if (q != null) {
            return q;
        }
        ColorStateList p = p(context, i2);
        if (p == null) {
            return b.m(context, i2);
        }
        synchronized (aaV) {
            SparseArray<C0043a> sparseArray = aaU.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                aaU.put(context, sparseArray);
            }
            sparseArray.append(i2, new C0043a(p, context.getResources().getConfiguration()));
        }
        return p;
    }

    public static Drawable l(Context context, int i2) {
        return g.jk().l(context, i2);
    }

    private static ColorStateList p(Context context, int i2) {
        boolean z;
        Resources resources = context.getResources();
        TypedValue typedValue = aaT.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            aaT.set(typedValue);
        }
        resources.getValue(i2, typedValue, true);
        if (typedValue.type < 28 || typedValue.type > 31) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return null;
        }
        Resources resources2 = context.getResources();
        try {
            return android.support.v4.content.a.a.createFromXml(resources2, resources2.getXml(i2), context.getTheme());
        } catch (Exception e2) {
            return null;
        }
    }

    private static ColorStateList q(Context context, @android.support.annotation.a int i2) {
        C0043a aVar;
        synchronized (aaV) {
            SparseArray<C0043a> sparseArray = aaU.get(context);
            if (!(sparseArray == null || sparseArray.size() <= 0 || (aVar = sparseArray.get(i2)) == null)) {
                if (aVar.aaX.equals(context.getResources().getConfiguration())) {
                    return aVar.aaW;
                }
                sparseArray.remove(i2);
            }
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: android.support.v7.c.a.a$a  reason: collision with other inner class name */
    public static class C0043a {
        final ColorStateList aaW;
        final Configuration aaX;

        C0043a(ColorStateList colorStateList, Configuration configuration) {
            this.aaW = colorStateList;
            this.aaX = configuration;
        }
    }
}
