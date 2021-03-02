package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public class ActionBarContainer extends FrameLayout {
    Drawable afZ;
    private boolean ahA;
    private View ahB;
    private View ahC;
    private View ahD;
    Drawable ahE;
    Drawable ahF;
    boolean ahG;
    boolean ahH;
    private int mHeight;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z = true;
        u.a(this, new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0040a.ActionBar);
        this.afZ = obtainStyledAttributes.getDrawable(0);
        this.ahE = obtainStyledAttributes.getDrawable(2);
        this.mHeight = obtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.i3r) {
            this.ahG = true;
            this.ahF = obtainStyledAttributes.getDrawable(1);
        }
        obtainStyledAttributes.recycle();
        if (this.ahG) {
            if (this.ahF != null) {
                z = false;
            }
        } else if (!(this.afZ == null && this.ahE == null)) {
            z = false;
        }
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.ahC = findViewById(R.id.c7);
        this.ahD = findViewById(R.id.cn);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.afZ != null) {
            this.afZ.setCallback(null);
            unscheduleDrawable(this.afZ);
        }
        this.afZ = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.ahC != null) {
                this.afZ.setBounds(this.ahC.getLeft(), this.ahC.getTop(), this.ahC.getRight(), this.ahC.getBottom());
            }
        }
        if (this.ahG) {
            if (this.ahF != null) {
                z = false;
            }
        } else if (!(this.afZ == null && this.ahE == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.ahE != null) {
            this.ahE.setCallback(null);
            unscheduleDrawable(this.ahE);
        }
        this.ahE = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.ahH && this.ahE != null) {
                this.ahE.setBounds(this.ahB.getLeft(), this.ahB.getTop(), this.ahB.getRight(), this.ahB.getBottom());
            }
        }
        if (this.ahG) {
            if (this.ahF != null) {
                z = false;
            }
        } else if (!(this.afZ == null && this.ahE == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.ahF != null) {
            this.ahF.setCallback(null);
            unscheduleDrawable(this.ahF);
        }
        this.ahF = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.ahG && this.ahF != null) {
                this.ahF.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.ahG) {
            if (this.ahF != null) {
                z = false;
            }
        } else if (!(this.afZ == null && this.ahE == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i2) {
        boolean z;
        super.setVisibility(i2);
        if (i2 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.afZ != null) {
            this.afZ.setVisible(z, false);
        }
        if (this.ahE != null) {
            this.ahE.setVisible(z, false);
        }
        if (this.ahF != null) {
            this.ahF.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.afZ && !this.ahG) || (drawable == this.ahE && this.ahH) || ((drawable == this.ahF && this.ahG) || super.verifyDrawable(drawable));
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.afZ != null && this.afZ.isStateful()) {
            this.afZ.setState(getDrawableState());
        }
        if (this.ahE != null && this.ahE.isStateful()) {
            this.ahE.setState(getDrawableState());
        }
        if (this.ahF != null && this.ahF.isStateful()) {
            this.ahF.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.afZ != null) {
            this.afZ.jumpToCurrentState();
        }
        if (this.ahE != null) {
            this.ahE.jumpToCurrentState();
        }
        if (this.ahF != null) {
            this.ahF.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean z) {
        this.ahA = z;
        setDescendantFocusability(z ? 393216 : TPMediaCodecProfileLevel.HEVCMainTierLevel52);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.ahA || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ar arVar) {
        if (this.ahB != null) {
            removeView(this.ahB);
        }
        this.ahB = arVar;
        if (arVar != null) {
            addView(arVar);
            ViewGroup.LayoutParams layoutParams = arVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            arVar.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.ahB;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    private static boolean bd(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private static int be(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + view.getMeasuredHeight() + layoutParams.topMargin;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        if (this.ahC == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && this.mHeight >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(this.mHeight, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.ahC != null) {
            int mode = View.MeasureSpec.getMode(i3);
            if (this.ahB != null && this.ahB.getVisibility() != 8 && mode != 1073741824) {
                if (!bd(this.ahC)) {
                    i4 = be(this.ahC);
                } else if (!bd(this.ahD)) {
                    i4 = be(this.ahD);
                } else {
                    i4 = 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i4 + be(this.ahB), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        boolean z3 = true;
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.ahB;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i2, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i4, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.ahG) {
            if (this.afZ != null) {
                if (this.ahC.getVisibility() == 0) {
                    this.afZ.setBounds(this.ahC.getLeft(), this.ahC.getTop(), this.ahC.getRight(), this.ahC.getBottom());
                } else if (this.ahD == null || this.ahD.getVisibility() != 0) {
                    this.afZ.setBounds(0, 0, 0, 0);
                } else {
                    this.afZ.setBounds(this.ahD.getLeft(), this.ahD.getTop(), this.ahD.getRight(), this.ahD.getBottom());
                }
                z2 = true;
            } else {
                z2 = false;
            }
            this.ahH = z4;
            if (!z4 || this.ahE == null) {
                z3 = z2;
            } else {
                this.ahE.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.ahF != null) {
            this.ahF.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            z3 = false;
        }
        if (z3) {
            invalidate();
        }
    }
}
