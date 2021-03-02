package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.b.a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.R;

public class CardView extends FrameLayout {
    private static final int[] alJ = {16842801};
    private static final r alK;
    private boolean alL;
    private boolean alM;
    int alN;
    int alO;
    final Rect alP;
    final Rect alQ;
    private final q alR;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            alK = new o();
        } else if (Build.VERSION.SDK_INT >= 17) {
            alK = new n();
        } else {
            alK = new p();
        }
        alK.initStatic();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dx);
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int color;
        ColorStateList valueOf;
        this.alP = new Rect();
        this.alQ = new Rect();
        this.alR = new q() {
            /* class android.support.v7.widget.CardView.AnonymousClass1 */
            private Drawable alS;

            @Override // android.support.v7.widget.q
            public final void q(Drawable drawable) {
                this.alS = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            @Override // android.support.v7.widget.q
            public final boolean getUseCompatPadding() {
                return CardView.this.getUseCompatPadding();
            }

            @Override // android.support.v7.widget.q
            public final boolean getPreventCornerOverlap() {
                return CardView.this.getPreventCornerOverlap();
            }

            @Override // android.support.v7.widget.q
            public final void e(int i2, int i3, int i4, int i5) {
                CardView.this.alQ.set(i2, i3, i4, i5);
                CardView cardView = CardView.this;
                CardView.super.setPadding(cardView.alP.left + i2, CardView.this.alP.top + i3, CardView.this.alP.right + i4, CardView.this.alP.bottom + i5);
            }

            @Override // android.support.v7.widget.q
            public final void R(int i2, int i3) {
                if (i2 > CardView.this.alN) {
                    CardView.super.setMinimumWidth(i2);
                }
                if (i3 > CardView.this.alO) {
                    CardView.super.setMinimumHeight(i3);
                }
            }

            @Override // android.support.v7.widget.q
            public final Drawable jy() {
                return this.alS;
            }

            @Override // android.support.v7.widget.q
            public final View jz() {
                return CardView.this;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0042a.CardView, i2, R.style.g8);
        if (obtainStyledAttributes.hasValue(2)) {
            valueOf = obtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(alJ);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(R.color.ij);
            } else {
                color = getResources().getColor(R.color.ii);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(5, 0.0f);
        this.alL = obtainStyledAttributes.getBoolean(7, false);
        this.alM = obtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.alP.left = obtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        this.alP.top = obtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        this.alP.right = obtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        this.alP.bottom = obtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.alN = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.alO = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        alK.a(this.alR, context, valueOf, dimension, dimension2, dimension3);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public boolean getUseCompatPadding() {
        return this.alL;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.alL != z) {
            this.alL = z;
            alK.g(this.alR);
        }
    }

    public final void setContentPadding(int i2, int i3, int i4, int i5) {
        this.alP.set(i2, i3, i4, i5);
        alK.f(this.alR);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (!(alK instanceof o)) {
            int mode = View.MeasureSpec.getMode(i2);
            switch (mode) {
                case Integer.MIN_VALUE:
                case 1073741824:
                    i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) alK.b(this.alR)), View.MeasureSpec.getSize(i2)), mode);
                    break;
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            switch (mode2) {
                case Integer.MIN_VALUE:
                case 1073741824:
                    i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) alK.c(this.alR)), View.MeasureSpec.getSize(i3)), mode2);
                    break;
            }
            super.onMeasure(i2, i3);
            return;
        }
        super.onMeasure(i2, i3);
    }

    public void setMinimumWidth(int i2) {
        this.alN = i2;
        super.setMinimumWidth(i2);
    }

    public void setMinimumHeight(int i2) {
        this.alO = i2;
        super.setMinimumHeight(i2);
    }

    public void setCardBackgroundColor(int i2) {
        alK.a(this.alR, ColorStateList.valueOf(i2));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        alK.a(this.alR, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return alK.i(this.alR);
    }

    public int getContentPaddingLeft() {
        return this.alP.left;
    }

    public int getContentPaddingRight() {
        return this.alP.right;
    }

    public int getContentPaddingTop() {
        return this.alP.top;
    }

    public int getContentPaddingBottom() {
        return this.alP.bottom;
    }

    public void setRadius(float f2) {
        alK.a(this.alR, f2);
    }

    public float getRadius() {
        return alK.d(this.alR);
    }

    public void setCardElevation(float f2) {
        alK.c(this.alR, f2);
    }

    public float getCardElevation() {
        return alK.e(this.alR);
    }

    public void setMaxCardElevation(float f2) {
        alK.b(this.alR, f2);
    }

    public float getMaxCardElevation() {
        return alK.a(this.alR);
    }

    public boolean getPreventCornerOverlap() {
        return this.alM;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.alM) {
            this.alM = z;
            alK.h(this.alR);
        }
    }
}
