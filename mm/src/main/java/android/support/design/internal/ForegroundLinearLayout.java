package android.support.design.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;

public class ForegroundLinearLayout extends LinearLayoutCompat {
    private int foregroundGravity;
    private Drawable kL;
    private final Rect kM;
    private final Rect kN;
    protected boolean kO;
    boolean kP;

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.kM = new Rect();
        this.kN = new Rect();
        this.foregroundGravity = 119;
        this.kO = true;
        this.kP = false;
        TypedArray a2 = f.a(context, attributeSet, a.C0008a.ForegroundLinearLayout, i2, 0, new int[0]);
        this.foregroundGravity = a2.getInt(1, this.foregroundGravity);
        Drawable drawable = a2.getDrawable(0);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.kO = a2.getBoolean(2, true);
        a2.recycle();
    }

    public int getForegroundGravity() {
        return this.foregroundGravity;
    }

    public void setForegroundGravity(int i2) {
        int i3;
        if (this.foregroundGravity != i2) {
            if ((8388615 & i2) == 0) {
                i3 = 8388611 | i2;
            } else {
                i3 = i2;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            this.foregroundGravity = i3;
            if (this.foregroundGravity == 119 && this.kL != null) {
                this.kL.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.kL;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.kL != null) {
            this.kL.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.kL != null && this.kL.isStateful()) {
            this.kL.setState(getDrawableState());
        }
    }

    public void setForeground(Drawable drawable) {
        if (this.kL != drawable) {
            if (this.kL != null) {
                this.kL.setCallback(null);
                unscheduleDrawable(this.kL);
            }
            this.kL = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.foregroundGravity == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public Drawable getForeground() {
        return this.kL;
    }

    @Override // android.support.v7.widget.LinearLayoutCompat
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.kP |= z;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.kP = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.kL != null) {
            Drawable drawable = this.kL;
            if (this.kP) {
                this.kP = false;
                Rect rect = this.kM;
                Rect rect2 = this.kN;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.kO) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.foregroundGravity, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @TargetApi(21)
    public void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        if (this.kL != null) {
            this.kL.setHotspot(f2, f3);
        }
    }
}
