package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a.f;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.util.TypedValue;

public final class az {
    private TypedValue akD;
    public final TypedArray ayy;
    private final Context mContext;

    public static az a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new az(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static az a(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3) {
        return new az(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i3));
    }

    public static az a(Context context, int i2, int[] iArr) {
        return new az(context, context.obtainStyledAttributes(i2, iArr));
    }

    private az(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.ayy = typedArray;
    }

    public final Drawable getDrawable(int i2) {
        int resourceId;
        if (!this.ayy.hasValue(i2) || (resourceId = this.ayy.getResourceId(i2, 0)) == 0) {
            return this.ayy.getDrawable(i2);
        }
        return a.l(this.mContext, resourceId);
    }

    public final Drawable cU(int i2) {
        int resourceId;
        if (!this.ayy.hasValue(i2) || (resourceId = this.ayy.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return g.jk().b(this.mContext, resourceId, true);
    }

    public final Typeface a(int i2, int i3, f.a aVar) {
        int resourceId = this.ayy.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.akD == null) {
            this.akD = new TypedValue();
        }
        return f.a(this.mContext, resourceId, this.akD, i3, aVar);
    }

    public final CharSequence getText(int i2) {
        return this.ayy.getText(i2);
    }

    public final String getString(int i2) {
        return this.ayy.getString(i2);
    }

    public final boolean getBoolean(int i2, boolean z) {
        return this.ayy.getBoolean(i2, z);
    }

    public final int getInt(int i2, int i3) {
        return this.ayy.getInt(i2, i3);
    }

    public final float getFloat(int i2, float f2) {
        return this.ayy.getFloat(i2, f2);
    }

    public final int getColor(int i2, int i3) {
        return this.ayy.getColor(i2, i3);
    }

    public final ColorStateList getColorStateList(int i2) {
        int resourceId;
        ColorStateList m;
        return (!this.ayy.hasValue(i2) || (resourceId = this.ayy.getResourceId(i2, 0)) == 0 || (m = a.m(this.mContext, resourceId)) == null) ? this.ayy.getColorStateList(i2) : m;
    }

    public final int getInteger(int i2, int i3) {
        return this.ayy.getInteger(i2, i3);
    }

    public final float cV(int i2) {
        return this.ayy.getDimension(i2, 0.0f);
    }

    public final int getDimensionPixelOffset(int i2, int i3) {
        return this.ayy.getDimensionPixelOffset(i2, i3);
    }

    public final int getDimensionPixelSize(int i2, int i3) {
        return this.ayy.getDimensionPixelSize(i2, i3);
    }

    public final int getLayoutDimension(int i2, int i3) {
        return this.ayy.getLayoutDimension(i2, i3);
    }

    public final int getResourceId(int i2, int i3) {
        return this.ayy.getResourceId(i2, i3);
    }

    public final boolean hasValue(int i2) {
        return this.ayy.hasValue(i2);
    }
}
