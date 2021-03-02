package android.support.design.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

public final class a {
    public static ColorStateList b(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        ColorStateList m;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (m = android.support.v7.c.a.a.m(context, resourceId)) == null) ? typedArray.getColorStateList(i2) : m;
    }

    public static Drawable c(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        Drawable l;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (l = android.support.v7.c.a.a.l(context, resourceId)) == null) ? typedArray.getDrawable(i2) : l;
    }
}
