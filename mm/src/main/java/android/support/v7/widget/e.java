package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.u;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;

/* access modifiers changed from: package-private */
public final class e {
    private final g ake;
    private int akf = -1;
    private ax akg;
    private ax akh;
    private ax aki;
    private final View mView;

    e(View view) {
        this.mView = view;
        this.ake = g.jk();
    }

    /* access modifiers changed from: package-private */
    public final void a(AttributeSet attributeSet, int i2) {
        az a2 = az.a(this.mView.getContext(), attributeSet, a.C0040a.ViewBackgroundHelper, i2, 0);
        try {
            if (a2.hasValue(0)) {
                this.akf = a2.getResourceId(0, -1);
                ColorStateList s = this.ake.s(this.mView.getContext(), this.akf);
                if (s != null) {
                    f(s);
                }
            }
            if (a2.hasValue(1)) {
                u.a(this.mView, a2.getColorStateList(1));
            }
            if (a2.hasValue(2)) {
                u.a(this.mView, x.a(a2.getInt(2, -1), null));
            }
        } finally {
            a2.ayy.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public final void bH(int i2) {
        this.akf = i2;
        f(this.ake != null ? this.ake.s(this.mView.getContext(), i2) : null);
        jg();
    }

    /* access modifiers changed from: package-private */
    public final void jf() {
        this.akf = -1;
        f(null);
        jg();
    }

    /* access modifiers changed from: package-private */
    public final void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.akh == null) {
            this.akh = new ax();
        }
        this.akh.Kr = colorStateList;
        this.akh.acT = true;
        jg();
    }

    /* access modifiers changed from: package-private */
    public final ColorStateList getSupportBackgroundTintList() {
        if (this.akh != null) {
            return this.akh.Kr;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.akh == null) {
            this.akh = new ax();
        }
        this.akh.yl = mode;
        this.akh.acU = true;
        jg();
    }

    /* access modifiers changed from: package-private */
    public final PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.akh != null) {
            return this.akh.yl;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void jg() {
        Drawable background = this.mView.getBackground();
        if (background == null) {
            return;
        }
        if (jh() && p(background)) {
            return;
        }
        if (this.akh != null) {
            g.a(background, this.akh, this.mView.getDrawableState());
        } else if (this.akg != null) {
            g.a(background, this.akg, this.mView.getDrawableState());
        }
    }

    private void f(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.akg == null) {
                this.akg = new ax();
            }
            this.akg.Kr = colorStateList;
            this.akg.acT = true;
        } else {
            this.akg = null;
        }
        jg();
    }

    private boolean jh() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.akg != null : i2 == 21;
    }

    private boolean p(Drawable drawable) {
        if (this.aki == null) {
            this.aki = new ax();
        }
        ax axVar = this.aki;
        axVar.clear();
        ColorStateList at = u.at(this.mView);
        if (at != null) {
            axVar.acT = true;
            axVar.Kr = at;
        }
        PorterDuff.Mode au = u.au(this.mView);
        if (au != null) {
            axVar.acU = true;
            axVar.yl = au;
        }
        if (!axVar.acT && !axVar.acU) {
            return false;
        }
        g.a(drawable, axVar, this.mView.getDrawableState());
        return true;
    }
}
