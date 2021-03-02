package android.support.design.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.design.a;
import android.support.design.internal.f;
import android.support.design.internal.g;
import android.support.v4.view.u;
import android.support.v4.widget.q;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import com.tencent.mm.R;

public class MaterialButton extends AppCompatButton {
    private PorterDuff.Mode hA;
    private ColorStateList hB;
    private int hC;
    private int hD;
    private int hE;
    private final b hy;
    private int hz;
    private Drawable icon;

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.uk);
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Drawable a2;
        TypedArray a3 = f.a(context, attributeSet, a.C0008a.MaterialButton, i2, R.style.a44, new int[0]);
        this.hz = a3.getDimensionPixelSize(9, 0);
        this.hA = g.a(a3.getInt(12, -1), PorterDuff.Mode.SRC_IN);
        this.hB = android.support.design.d.a.b(getContext(), a3, 11);
        this.icon = android.support.design.d.a.c(getContext(), a3, 7);
        this.hE = a3.getInteger(8, 1);
        this.hC = a3.getDimensionPixelSize(10, 0);
        this.hy = new b(this);
        b bVar = this.hy;
        bVar.insetLeft = a3.getDimensionPixelOffset(0, 0);
        bVar.insetRight = a3.getDimensionPixelOffset(1, 0);
        bVar.insetTop = a3.getDimensionPixelOffset(2, 0);
        bVar.insetBottom = a3.getDimensionPixelOffset(3, 0);
        bVar.hH = a3.getDimensionPixelSize(6, 0);
        bVar.strokeWidth = a3.getDimensionPixelSize(15, 0);
        bVar.hI = g.a(a3.getInt(5, -1), PorterDuff.Mode.SRC_IN);
        bVar.hJ = android.support.design.d.a.b(bVar.hG.getContext(), a3, 4);
        bVar.hK = android.support.design.d.a.b(bVar.hG.getContext(), a3, 14);
        bVar.hL = android.support.design.d.a.b(bVar.hG.getContext(), a3, 13);
        bVar.hM.setStyle(Paint.Style.STROKE);
        bVar.hM.setStrokeWidth((float) bVar.strokeWidth);
        bVar.hM.setColor(bVar.hK != null ? bVar.hK.getColorForState(bVar.hG.getDrawableState(), 0) : 0);
        int ac = u.ac(bVar.hG);
        int paddingTop = bVar.hG.getPaddingTop();
        int ad = u.ad(bVar.hG);
        int paddingBottom = bVar.hG.getPaddingBottom();
        MaterialButton materialButton = bVar.hG;
        if (b.hF) {
            a2 = bVar.ba();
        } else {
            bVar.hP = new GradientDrawable();
            bVar.hP.setCornerRadius(((float) bVar.hH) + 1.0E-5f);
            bVar.hP.setColor(-1);
            bVar.hQ = android.support.v4.graphics.drawable.a.i(bVar.hP);
            android.support.v4.graphics.drawable.a.a(bVar.hQ, bVar.hJ);
            if (bVar.hI != null) {
                android.support.v4.graphics.drawable.a.a(bVar.hQ, bVar.hI);
            }
            bVar.hR = new GradientDrawable();
            bVar.hR.setCornerRadius(((float) bVar.hH) + 1.0E-5f);
            bVar.hR.setColor(-1);
            bVar.hS = android.support.v4.graphics.drawable.a.i(bVar.hR);
            android.support.v4.graphics.drawable.a.a(bVar.hS, bVar.hL);
            a2 = bVar.a(new LayerDrawable(new Drawable[]{bVar.hQ, bVar.hS}));
        }
        materialButton.setInternalBackground(a2);
        u.d(bVar.hG, ac + bVar.insetLeft, paddingTop + bVar.insetTop, ad + bVar.insetRight, bVar.insetBottom + paddingBottom);
        a3.recycle();
        setCompoundDrawablePadding(this.hz);
        aX();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT < 21 && aY()) {
            b bVar = this.hy;
            if (canvas != null && bVar.hK != null && bVar.strokeWidth > 0) {
                bVar.hN.set(bVar.hG.getBackground().getBounds());
                bVar.hO.set(((float) bVar.hN.left) + (((float) bVar.strokeWidth) / 2.0f) + ((float) bVar.insetLeft), ((float) bVar.hN.top) + (((float) bVar.strokeWidth) / 2.0f) + ((float) bVar.insetTop), (((float) bVar.hN.right) - (((float) bVar.strokeWidth) / 2.0f)) - ((float) bVar.insetRight), (((float) bVar.hN.bottom) - (((float) bVar.strokeWidth) / 2.0f)) - ((float) bVar.insetBottom));
                float f2 = ((float) bVar.hH) - (((float) bVar.strokeWidth) / 2.0f);
                canvas.drawRoundRect(bVar.hO, f2, f2, bVar.hM);
            }
        }
    }

    @Override // android.support.v7.widget.AppCompatButton, android.support.v4.view.s
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (aY()) {
            b bVar = this.hy;
            if (bVar.hJ != colorStateList) {
                bVar.hJ = colorStateList;
                if (b.hF) {
                    bVar.aZ();
                } else if (bVar.hQ != null) {
                    android.support.v4.graphics.drawable.a.a(bVar.hQ, bVar.hJ);
                }
            }
        } else if (this.hy != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // android.support.v7.widget.AppCompatButton, android.support.v4.view.s
    public ColorStateList getSupportBackgroundTintList() {
        if (aY()) {
            return this.hy.hJ;
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // android.support.v7.widget.AppCompatButton, android.support.v4.view.s
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (aY()) {
            b bVar = this.hy;
            if (bVar.hI != mode) {
                bVar.hI = mode;
                if (b.hF) {
                    bVar.aZ();
                } else if (bVar.hQ != null && bVar.hI != null) {
                    android.support.v4.graphics.drawable.a.a(bVar.hQ, bVar.hI);
                }
            }
        } else if (this.hy != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.support.v7.widget.AppCompatButton, android.support.v4.view.s
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (aY()) {
            return this.hy.hI;
        }
        return super.getSupportBackgroundTintMode();
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public void setBackgroundColor(int i2) {
        if (aY()) {
            b bVar = this.hy;
            if (b.hF && bVar.hT != null) {
                bVar.hT.setColor(i2);
            } else if (!b.hF && bVar.hP != null) {
                bVar.hP.setColor(i2);
            }
        } else {
            super.setBackgroundColor(i2);
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.support.v7.widget.AppCompatButton
    public void setBackgroundResource(int i2) {
        Drawable drawable = null;
        if (i2 != 0) {
            drawable = android.support.v7.c.a.a.l(getContext(), i2);
        }
        setBackgroundDrawable(drawable);
    }

    @Override // android.support.v7.widget.AppCompatButton
    public void setBackgroundDrawable(Drawable drawable) {
        if (aY()) {
            if (drawable != getBackground()) {
                b bVar = this.hy;
                bVar.hW = true;
                bVar.hG.setSupportBackgroundTintList(bVar.hJ);
                bVar.hG.setSupportBackgroundTintMode(bVar.hI);
            } else {
                getBackground().setState(drawable.getState());
                return;
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.support.v7.widget.AppCompatButton
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT == 21 && this.hy != null) {
            b bVar = this.hy;
            int i6 = i5 - i3;
            int i7 = i4 - i2;
            if (bVar.hV != null) {
                bVar.hV.setBounds(bVar.insetLeft, bVar.insetTop, i7 - bVar.insetRight, i6 - bVar.insetBottom);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z = true;
        super.onMeasure(i2, i3);
        if (this.icon != null && this.hE == 2) {
            int measuredWidth = (((((getMeasuredWidth() - ((int) getPaint().measureText(getText().toString()))) - u.ad(this)) - (this.hC == 0 ? this.icon.getIntrinsicWidth() : this.hC)) - this.hz) - u.ac(this)) / 2;
            if (u.Z(this) != 1) {
                z = false;
            }
            if (z) {
                measuredWidth = -measuredWidth;
            }
            if (this.hD != measuredWidth) {
                this.hD = measuredWidth;
                aX();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setIconPadding(int i2) {
        if (this.hz != i2) {
            this.hz = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public int getIconPadding() {
        return this.hz;
    }

    public void setIconSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.hC != i2) {
            this.hC = i2;
            aX();
        }
    }

    public int getIconSize() {
        return this.hC;
    }

    public void setIcon(Drawable drawable) {
        if (this.icon != drawable) {
            this.icon = drawable;
            aX();
        }
    }

    public void setIconResource(int i2) {
        Drawable drawable = null;
        if (i2 != 0) {
            drawable = android.support.v7.c.a.a.l(getContext(), i2);
        }
        setIcon(drawable);
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.hB != colorStateList) {
            this.hB = colorStateList;
            aX();
        }
    }

    public void setIconTintResource(@android.support.annotation.a int i2) {
        setIconTint(android.support.v7.c.a.a.m(getContext(), i2));
    }

    public ColorStateList getIconTint() {
        return this.hB;
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.hA != mode) {
            this.hA = mode;
            aX();
        }
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.hA;
    }

    private void aX() {
        if (this.icon != null) {
            this.icon = this.icon.mutate();
            android.support.v4.graphics.drawable.a.a(this.icon, this.hB);
            if (this.hA != null) {
                android.support.v4.graphics.drawable.a.a(this.icon, this.hA);
            }
            this.icon.setBounds(this.hD, 0, (this.hC != 0 ? this.hC : this.icon.getIntrinsicWidth()) + this.hD, this.hC != 0 ? this.hC : this.icon.getIntrinsicHeight());
        }
        q.a(this, this.icon, null, null, null);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (aY()) {
            b bVar = this.hy;
            if (bVar.hL != colorStateList) {
                bVar.hL = colorStateList;
                if (b.hF && (bVar.hG.getBackground() instanceof RippleDrawable)) {
                    ((RippleDrawable) bVar.hG.getBackground()).setColor(colorStateList);
                } else if (!b.hF && bVar.hS != null) {
                    android.support.v4.graphics.drawable.a.a(bVar.hS, colorStateList);
                }
            }
        }
    }

    public void setRippleColorResource(@android.support.annotation.a int i2) {
        if (aY()) {
            setRippleColor(android.support.v7.c.a.a.m(getContext(), i2));
        }
    }

    public ColorStateList getRippleColor() {
        if (aY()) {
            return this.hy.hL;
        }
        return null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        int i2 = 0;
        if (aY()) {
            b bVar = this.hy;
            if (bVar.hK != colorStateList) {
                bVar.hK = colorStateList;
                Paint paint = bVar.hM;
                if (colorStateList != null) {
                    i2 = colorStateList.getColorForState(bVar.hG.getDrawableState(), 0);
                }
                paint.setColor(i2);
                bVar.bb();
            }
        }
    }

    public void setStrokeColorResource(@android.support.annotation.a int i2) {
        if (aY()) {
            setStrokeColor(android.support.v7.c.a.a.m(getContext(), i2));
        }
    }

    public ColorStateList getStrokeColor() {
        if (aY()) {
            return this.hy.hK;
        }
        return null;
    }

    public void setStrokeWidth(int i2) {
        if (aY()) {
            b bVar = this.hy;
            if (bVar.strokeWidth != i2) {
                bVar.strokeWidth = i2;
                bVar.hM.setStrokeWidth((float) i2);
                bVar.bb();
            }
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (aY()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    public int getStrokeWidth() {
        if (aY()) {
            return this.hy.strokeWidth;
        }
        return 0;
    }

    public void setCornerRadius(int i2) {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        if (aY()) {
            b bVar = this.hy;
            if (bVar.hH != i2) {
                bVar.hH = i2;
                if (b.hF && bVar.hT != null && bVar.hU != null && bVar.hV != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        if (!b.hF || bVar.hG.getBackground() == null) {
                            gradientDrawable = null;
                        } else {
                            gradientDrawable = (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) bVar.hG.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
                        }
                        gradientDrawable.setCornerRadius(((float) i2) + 1.0E-5f);
                        if (!b.hF || bVar.hG.getBackground() == null) {
                            gradientDrawable2 = null;
                        } else {
                            gradientDrawable2 = (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) bVar.hG.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
                        }
                        gradientDrawable2.setCornerRadius(((float) i2) + 1.0E-5f);
                    }
                    bVar.hT.setCornerRadius(((float) i2) + 1.0E-5f);
                    bVar.hU.setCornerRadius(((float) i2) + 1.0E-5f);
                    bVar.hV.setCornerRadius(((float) i2) + 1.0E-5f);
                } else if (!b.hF && bVar.hP != null && bVar.hR != null) {
                    bVar.hP.setCornerRadius(((float) i2) + 1.0E-5f);
                    bVar.hR.setCornerRadius(((float) i2) + 1.0E-5f);
                    bVar.hG.invalidate();
                }
            }
        }
    }

    public void setCornerRadiusResource(int i2) {
        if (aY()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    public int getCornerRadius() {
        if (aY()) {
            return this.hy.hH;
        }
        return 0;
    }

    public int getIconGravity() {
        return this.hE;
    }

    public void setIconGravity(int i2) {
        this.hE = i2;
    }

    private boolean aY() {
        return this.hy != null && !this.hy.hW;
    }
}
