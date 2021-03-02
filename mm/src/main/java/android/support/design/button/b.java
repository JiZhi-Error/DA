package android.support.design.button;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.v4.graphics.drawable.a;

final class b {
    static final boolean hF = (Build.VERSION.SDK_INT >= 21);
    final MaterialButton hG;
    int hH;
    PorterDuff.Mode hI;
    ColorStateList hJ;
    ColorStateList hK;
    ColorStateList hL;
    final Paint hM = new Paint(1);
    final Rect hN = new Rect();
    final RectF hO = new RectF();
    GradientDrawable hP;
    Drawable hQ;
    GradientDrawable hR;
    Drawable hS;
    GradientDrawable hT;
    GradientDrawable hU;
    GradientDrawable hV;
    boolean hW = false;
    int insetBottom;
    int insetLeft;
    int insetRight;
    int insetTop;
    int strokeWidth;

    public b(MaterialButton materialButton) {
        this.hG = materialButton;
    }

    /* access modifiers changed from: package-private */
    public final InsetDrawable a(Drawable drawable) {
        return new InsetDrawable(drawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
    }

    /* access modifiers changed from: package-private */
    public final void aZ() {
        if (this.hT != null) {
            a.a(this.hT, this.hJ);
            if (this.hI != null) {
                a.a(this.hT, this.hI);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(21)
    public final Drawable ba() {
        this.hT = new GradientDrawable();
        this.hT.setCornerRadius(((float) this.hH) + 1.0E-5f);
        this.hT.setColor(-1);
        aZ();
        this.hU = new GradientDrawable();
        this.hU.setCornerRadius(((float) this.hH) + 1.0E-5f);
        this.hU.setColor(0);
        this.hU.setStroke(this.strokeWidth, this.hK);
        InsetDrawable a2 = a(new LayerDrawable(new Drawable[]{this.hT, this.hU}));
        this.hV = new GradientDrawable();
        this.hV.setCornerRadius(((float) this.hH) + 1.0E-5f);
        this.hV.setColor(-1);
        return new a(android.support.design.e.a.b(this.hL), a2, this.hV);
    }

    /* access modifiers changed from: package-private */
    public final void bb() {
        if (hF && this.hU != null) {
            this.hG.setInternalBackground(ba());
        } else if (!hF) {
            this.hG.invalidate();
        }
    }
}
