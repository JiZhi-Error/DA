package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* access modifiers changed from: package-private */
public final class k extends j {
    final SeekBar akP;
    Drawable akQ;
    private ColorStateList akR = null;
    private PorterDuff.Mode akS = null;
    private boolean akT = false;
    private boolean akU = false;

    k(SeekBar seekBar) {
        super(seekBar);
        this.akP = seekBar;
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.v7.widget.j
    public final void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        az a2 = az.a(this.akP.getContext(), attributeSet, a.C0040a.AppCompatSeekBar, i2, 0);
        Drawable cU = a2.cU(0);
        if (cU != null) {
            this.akP.setThumb(cU);
        }
        Drawable drawable = a2.getDrawable(1);
        if (this.akQ != null) {
            this.akQ.setCallback(null);
        }
        this.akQ = drawable;
        if (drawable != null) {
            drawable.setCallback(this.akP);
            android.support.v4.graphics.drawable.a.b(drawable, u.Z(this.akP));
            if (drawable.isStateful()) {
                drawable.setState(this.akP.getDrawableState());
            }
            jm();
        }
        this.akP.invalidate();
        if (a2.hasValue(3)) {
            this.akS = x.a(a2.getInt(3, -1), this.akS);
            this.akU = true;
        }
        if (a2.hasValue(2)) {
            this.akR = a2.getColorStateList(2);
            this.akT = true;
        }
        a2.ayy.recycle();
        jm();
    }

    private void jm() {
        if (this.akQ == null) {
            return;
        }
        if (this.akT || this.akU) {
            this.akQ = android.support.v4.graphics.drawable.a.i(this.akQ.mutate());
            if (this.akT) {
                android.support.v4.graphics.drawable.a.a(this.akQ, this.akR);
            }
            if (this.akU) {
                android.support.v4.graphics.drawable.a.a(this.akQ, this.akS);
            }
            if (this.akQ.isStateful()) {
                this.akQ.setState(this.akP.getDrawableState());
            }
        }
    }
}
