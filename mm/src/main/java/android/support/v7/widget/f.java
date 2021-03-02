package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.widget.e;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* access modifiers changed from: package-private */
public final class f {
    private final CompoundButton akk;
    ColorStateList akl = null;
    PorterDuff.Mode akm = null;
    private boolean akn = false;
    private boolean ako = false;
    private boolean akp;

    f(CompoundButton compoundButton) {
        this.akk = compoundButton;
    }

    /* access modifiers changed from: package-private */
    public final void a(AttributeSet attributeSet, int i2) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.akk.getContext().obtainStyledAttributes(attributeSet, a.C0040a.CompoundButton, i2, 0);
        try {
            if (obtainStyledAttributes.hasValue(0) && (resourceId = obtainStyledAttributes.getResourceId(0, 0)) != 0) {
                this.akk.setButtonDrawable(android.support.v7.c.a.a.l(this.akk.getContext(), resourceId));
            }
            if (obtainStyledAttributes.hasValue(1)) {
                e.a(this.akk, obtainStyledAttributes.getColorStateList(1));
            }
            if (obtainStyledAttributes.hasValue(2)) {
                e.a(this.akk, x.a(obtainStyledAttributes.getInt(2, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public final void setSupportButtonTintList(ColorStateList colorStateList) {
        this.akl = colorStateList;
        this.akn = true;
        jj();
    }

    /* access modifiers changed from: package-private */
    public final void setSupportButtonTintMode(PorterDuff.Mode mode) {
        this.akm = mode;
        this.ako = true;
        jj();
    }

    /* access modifiers changed from: package-private */
    public final void ji() {
        if (this.akp) {
            this.akp = false;
            return;
        }
        this.akp = true;
        jj();
    }

    private void jj() {
        Drawable a2 = e.a(this.akk);
        if (a2 == null) {
            return;
        }
        if (this.akn || this.ako) {
            Drawable mutate = android.support.v4.graphics.drawable.a.i(a2).mutate();
            if (this.akn) {
                android.support.v4.graphics.drawable.a.a(mutate, this.akl);
            }
            if (this.ako) {
                android.support.v4.graphics.drawable.a.a(mutate, this.akm);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.akk.getDrawableState());
            }
            this.akk.setButtonDrawable(mutate);
        }
    }

    /* access modifiers changed from: package-private */
    public final int bI(int i2) {
        Drawable a2;
        if (Build.VERSION.SDK_INT >= 17 || (a2 = e.a(this.akk)) == null) {
            return i2;
        }
        return i2 + a2.getIntrinsicWidth();
    }
}
