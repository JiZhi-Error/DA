package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* access modifiers changed from: package-private */
public class g extends Drawable implements Drawable.Callback, e, f {
    static final PorterDuff.Mode xl = PorterDuff.Mode.SRC_IN;
    private int KC;
    private PorterDuff.Mode KD;
    private boolean KE;
    a KF;
    Drawable mDrawable;
    private boolean xp;

    g(a aVar, Resources resources) {
        this.KF = aVar;
        if (this.KF != null && this.KF.KG != null) {
            l(this.KF.KG.newDrawable(resources));
        }
    }

    g(Drawable drawable) {
        this.KF = eG();
        l(drawable);
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.mDrawable != null) {
            this.mDrawable.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i2) {
        this.mDrawable.setChangingConfigurations(i2);
    }

    public int getChangingConfigurations() {
        return (this.KF != null ? this.KF.getChangingConfigurations() : 0) | super.getChangingConfigurations() | this.mDrawable.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.mDrawable.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.mDrawable.setFilterBitmap(z);
    }

    public void setAlpha(int i2) {
        this.mDrawable.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawable.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!eH() || this.KF == null) ? null : this.KF.yk;
        return (colorStateList != null && colorStateList.isStateful()) || this.mDrawable.isStateful();
    }

    public boolean setState(int[] iArr) {
        return f(iArr) || this.mDrawable.setState(iArr);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.mDrawable.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.mDrawable.getPadding(rect);
    }

    public void setAutoMirrored(boolean z) {
        this.mDrawable.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.mDrawable.isAutoMirrored();
    }

    public Drawable.ConstantState getConstantState() {
        boolean z;
        if (this.KF != null) {
            if (this.KF.KG != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.KF.mChangingConfigurations = getChangingConfigurations();
                return this.KF;
            }
        }
        return null;
    }

    public Drawable mutate() {
        if (!this.xp && super.mutate() == this) {
            this.KF = eG();
            if (this.mDrawable != null) {
                this.mDrawable.mutate();
            }
            if (this.KF != null) {
                this.KF.KG = this.mDrawable != null ? this.mDrawable.getConstantState() : null;
            }
            this.xp = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public a eG() {
        return new b(this.KF);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        return this.mDrawable.setLevel(i2);
    }

    @Override // android.support.v4.graphics.drawable.e
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.support.v4.graphics.drawable.e
    public void setTintList(ColorStateList colorStateList) {
        this.KF.yk = colorStateList;
        f(getState());
    }

    @Override // android.support.v4.graphics.drawable.e
    public void setTintMode(PorterDuff.Mode mode) {
        this.KF.yl = mode;
        f(getState());
    }

    private boolean f(int[] iArr) {
        if (!eH()) {
            return false;
        }
        ColorStateList colorStateList = this.KF.yk;
        PorterDuff.Mode mode = this.KF.yl;
        if (colorStateList == null || mode == null) {
            this.KE = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.KE && colorForState == this.KC && mode == this.KD) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.KC = colorForState;
        this.KD = mode;
        this.KE = true;
        return true;
    }

    @Override // android.support.v4.graphics.drawable.f
    public final Drawable eF() {
        return this.mDrawable;
    }

    @Override // android.support.v4.graphics.drawable.f
    public final void l(Drawable drawable) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            if (this.KF != null) {
                this.KF.KG = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public boolean eH() {
        return true;
    }

    /* access modifiers changed from: protected */
    public static abstract class a extends Drawable.ConstantState {
        Drawable.ConstantState KG;
        int mChangingConfigurations;
        ColorStateList yk = null;
        PorterDuff.Mode yl = g.xl;

        public abstract Drawable newDrawable(Resources resources);

        a(a aVar) {
            if (aVar != null) {
                this.mChangingConfigurations = aVar.mChangingConfigurations;
                this.KG = aVar.KG;
                this.yk = aVar.yk;
                this.yl = aVar.yl;
            }
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public int getChangingConfigurations() {
            return (this.KG != null ? this.KG.getChangingConfigurations() : 0) | this.mChangingConfigurations;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b extends a {
        b(a aVar) {
            super(aVar);
        }

        @Override // android.support.v4.graphics.drawable.g.a
        public final Drawable newDrawable(Resources resources) {
            return new g(this, resources);
        }
    }
}
