package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.v4.widget.l;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class i {
    private final ImageView akG;
    private ax akH;
    private ax akI;
    private ax aki;

    public i(ImageView imageView) {
        this.akG = imageView;
    }

    public final void a(AttributeSet attributeSet, int i2) {
        int resourceId;
        az a2 = az.a(this.akG.getContext(), attributeSet, a.C0040a.AppCompatImageView, i2, 0);
        try {
            Drawable drawable = this.akG.getDrawable();
            if (!(drawable != null || (resourceId = a2.getResourceId(1, -1)) == -1 || (drawable = android.support.v7.c.a.a.l(this.akG.getContext(), resourceId)) == null)) {
                this.akG.setImageDrawable(drawable);
            }
            if (drawable != null) {
                x.s(drawable);
            }
            if (a2.hasValue(2)) {
                l.a(this.akG, a2.getColorStateList(2));
            }
            if (a2.hasValue(3)) {
                l.a(this.akG, x.a(a2.getInt(3, -1), null));
            }
        } finally {
            a2.ayy.recycle();
        }
    }

    public final void setImageResource(int i2) {
        if (i2 != 0) {
            Drawable l = android.support.v7.c.a.a.l(this.akG.getContext(), i2);
            if (l != null) {
                x.s(l);
            }
            this.akG.setImageDrawable(l);
        } else {
            this.akG.setImageDrawable(null);
        }
        jl();
    }

    /* access modifiers changed from: package-private */
    public final boolean hasOverlappingRendering() {
        Drawable background = this.akG.getBackground();
        if (Build.VERSION.SDK_INT < 21 || !(background instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.akI == null) {
            this.akI = new ax();
        }
        this.akI.Kr = colorStateList;
        this.akI.acT = true;
        jl();
    }

    /* access modifiers changed from: package-private */
    public final ColorStateList getSupportImageTintList() {
        if (this.akI != null) {
            return this.akI.Kr;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.akI == null) {
            this.akI = new ax();
        }
        this.akI.yl = mode;
        this.akI.acU = true;
        jl();
    }

    /* access modifiers changed from: package-private */
    public final PorterDuff.Mode getSupportImageTintMode() {
        if (this.akI != null) {
            return this.akI.yl;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void jl() {
        Drawable drawable = this.akG.getDrawable();
        if (drawable != null) {
            x.s(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (jh() && p(drawable)) {
            return;
        }
        if (this.akI != null) {
            g.a(drawable, this.akI, this.akG.getDrawableState());
        } else if (this.akH != null) {
            g.a(drawable, this.akH, this.akG.getDrawableState());
        }
    }

    private boolean jh() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.akH != null : i2 == 21;
    }

    private boolean p(Drawable drawable) {
        if (this.aki == null) {
            this.aki = new ax();
        }
        ax axVar = this.aki;
        axVar.clear();
        ColorStateList a2 = l.a(this.akG);
        if (a2 != null) {
            axVar.acT = true;
            axVar.Kr = a2;
        }
        PorterDuff.Mode b2 = l.b(this.akG);
        if (b2 != null) {
            axVar.acU = true;
            axVar.yl = b2;
        }
        if (!axVar.acT && !axVar.acU) {
            return false;
        }
        g.a(drawable, axVar, this.akG.getDrawableState());
        return true;
    }
}
