package android.support.d.a;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.a;
import android.support.v4.graphics.drawable.e;

abstract class h extends Drawable implements e {
    Drawable xk;

    h() {
    }

    public void setColorFilter(int i2, PorterDuff.Mode mode) {
        if (this.xk != null) {
            this.xk.setColorFilter(i2, mode);
        } else {
            super.setColorFilter(i2, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.xk == null) {
            return null;
        }
        Drawable drawable = this.xk;
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        if (this.xk != null) {
            return this.xk.setLevel(i2);
        }
        return super.onLevelChange(i2);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.xk != null) {
            this.xk.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f2, float f3) {
        if (this.xk != null) {
            a.a(this.xk, f2, f3);
        }
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        if (this.xk != null) {
            a.a(this.xk, i2, i3, i4, i5);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.xk != null) {
            this.xk.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.xk != null) {
            this.xk.jumpToCurrentState();
        }
    }

    public void applyTheme(Resources.Theme theme) {
        if (this.xk != null) {
            a.a(this.xk, theme);
        }
    }

    public void clearColorFilter() {
        if (this.xk != null) {
            this.xk.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.xk != null) {
            return this.xk.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.xk != null) {
            return this.xk.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.xk != null) {
            return this.xk.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.xk != null) {
            return this.xk.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.xk != null) {
            return this.xk.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.xk != null) {
            return this.xk.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i2) {
        if (this.xk != null) {
            this.xk.setChangingConfigurations(i2);
        } else {
            super.setChangingConfigurations(i2);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.xk != null) {
            return this.xk.setState(iArr);
        }
        return super.setState(iArr);
    }
}
