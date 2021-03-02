package android.support.v7.d.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.a;

public class c extends Drawable implements Drawable.Callback {
    public Drawable mDrawable;

    public c(Drawable drawable) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.mDrawable.setBounds(rect);
    }

    public void setChangingConfigurations(int i2) {
        this.mDrawable.setChangingConfigurations(i2);
    }

    public int getChangingConfigurations() {
        return this.mDrawable.getChangingConfigurations();
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
        return this.mDrawable.isStateful();
    }

    public boolean setState(int[] iArr) {
        return this.mDrawable.setState(iArr);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
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

    public void setAutoMirrored(boolean z) {
        a.a(this.mDrawable, z);
    }

    public boolean isAutoMirrored() {
        return a.e(this.mDrawable);
    }

    public void setTint(int i2) {
        a.a(this.mDrawable, i2);
    }

    public void setTintList(ColorStateList colorStateList) {
        a.a(this.mDrawable, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        a.a(this.mDrawable, mode);
    }

    public void setHotspot(float f2, float f3) {
        a.a(this.mDrawable, f2, f3);
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        a.a(this.mDrawable, i2, i3, i4, i5);
    }
}
