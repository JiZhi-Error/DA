package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.v4.graphics.drawable.g;
import java.lang.reflect.Method;

/* access modifiers changed from: package-private */
public final class h extends g {
    private static Method KH;

    h(Drawable drawable) {
        super(drawable);
        eI();
    }

    h(g.a aVar, Resources resources) {
        super(aVar, resources);
        eI();
    }

    public final void setHotspot(float f2, float f3) {
        this.mDrawable.setHotspot(f2, f3);
    }

    public final void setHotspotBounds(int i2, int i3, int i4, int i5) {
        this.mDrawable.setHotspotBounds(i2, i3, i4, i5);
    }

    public final void getOutline(Outline outline) {
        this.mDrawable.getOutline(outline);
    }

    public final Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }

    @Override // android.support.v4.graphics.drawable.e, android.support.v4.graphics.drawable.g
    public final void setTintList(ColorStateList colorStateList) {
        if (eH()) {
            super.setTintList(colorStateList);
        } else {
            this.mDrawable.setTintList(colorStateList);
        }
    }

    @Override // android.support.v4.graphics.drawable.e, android.support.v4.graphics.drawable.g
    public final void setTint(int i2) {
        if (eH()) {
            super.setTint(i2);
        } else {
            this.mDrawable.setTint(i2);
        }
    }

    @Override // android.support.v4.graphics.drawable.e, android.support.v4.graphics.drawable.g
    public final void setTintMode(PorterDuff.Mode mode) {
        if (eH()) {
            super.setTintMode(mode);
        } else {
            this.mDrawable.setTintMode(mode);
        }
    }

    @Override // android.support.v4.graphics.drawable.g
    public final boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.graphics.drawable.g
    public final boolean eH() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.mDrawable;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }

    public final boolean isProjected() {
        if (!(this.mDrawable == null || KH == null)) {
            try {
                return ((Boolean) KH.invoke(this.mDrawable, new Object[0])).booleanValue();
            } catch (Exception e2) {
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.v4.graphics.drawable.g
    public final g.a eG() {
        return new a(this.KF);
    }

    static class a extends g.a {
        a(g.a aVar) {
            super(aVar);
        }

        @Override // android.support.v4.graphics.drawable.g.a
        public final Drawable newDrawable(Resources resources) {
            return new h(this, resources);
        }
    }

    private static void eI() {
        if (KH == null) {
            try {
                KH = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e2) {
            }
        }
    }
}
