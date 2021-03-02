package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.a;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class PagerTabStrip extends PagerTitleStrip {
    private int Qc = this.QD;
    private int Qd;
    private int Qe;
    private int Qf;
    private int Qg;
    private int Qh;
    private final Paint Qi = new Paint();
    private int Qj = 255;
    private boolean Qk = false;
    private boolean Ql = false;
    private int Qm;
    private boolean Qn;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private final Rect mTempRect = new Rect();
    private int mTouchSlop;

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Qi.setColor(this.Qc);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.Qd = (int) ((3.0f * f2) + 0.5f);
        this.Qe = (int) ((6.0f * f2) + 0.5f);
        this.Qf = (int) (64.0f * f2);
        this.Qh = (int) ((16.0f * f2) + 0.5f);
        this.Qm = (int) ((1.0f * f2) + 0.5f);
        this.Qg = (int) ((f2 * 32.0f) + 0.5f);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.Qq.setFocusable(true);
        this.Qq.setOnClickListener(new View.OnClickListener() {
            /* class android.support.v4.view.PagerTabStrip.AnonymousClass1 */

            public final void onClick(View view) {
                PagerTabStrip.this.Qp.setCurrentItem(PagerTabStrip.this.Qp.getCurrentItem() - 1);
            }
        });
        this.Qs.setFocusable(true);
        this.Qs.setOnClickListener(new View.OnClickListener() {
            /* class android.support.v4.view.PagerTabStrip.AnonymousClass2 */

            public final void onClick(View view) {
                PagerTabStrip.this.Qp.setCurrentItem(PagerTabStrip.this.Qp.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.Qk = true;
        }
    }

    public void setTabIndicatorColor(int i2) {
        this.Qc = i2;
        this.Qi.setColor(this.Qc);
        invalidate();
    }

    public void setTabIndicatorColorResource(@a int i2) {
        setTabIndicatorColor(b.n(getContext(), i2));
    }

    public int getTabIndicatorColor() {
        return this.Qc;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        if (i5 < this.Qe) {
            i5 = this.Qe;
        }
        super.setPadding(i2, i3, i4, i5);
    }

    @Override // android.support.v4.view.PagerTitleStrip
    public void setTextSpacing(int i2) {
        if (i2 < this.Qf) {
            i2 = this.Qf;
        }
        super.setTextSpacing(i2);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.Ql) {
            this.Qk = drawable == null;
        }
    }

    public void setBackgroundColor(int i2) {
        super.setBackgroundColor(i2);
        if (!this.Ql) {
            this.Qk = (-16777216 & i2) == 0;
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        if (!this.Ql) {
            this.Qk = i2 == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.Qk = z;
        this.Ql = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.Qk;
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.v4.view.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.Qg);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.Qn) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                this.Qn = false;
                break;
            case 1:
                if (x >= ((float) (this.Qr.getLeft() - this.Qh))) {
                    if (x > ((float) (this.Qr.getRight() + this.Qh))) {
                        this.Qp.setCurrentItem(this.Qp.getCurrentItem() + 1);
                        break;
                    }
                } else {
                    this.Qp.setCurrentItem(this.Qp.getCurrentItem() - 1);
                    break;
                }
                break;
            case 2:
                if (Math.abs(x - this.mInitialMotionX) > ((float) this.mTouchSlop) || Math.abs(y - this.mInitialMotionY) > ((float) this.mTouchSlop)) {
                    this.Qn = true;
                    break;
                }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.Qr.getLeft() - this.Qh;
        int right = this.Qr.getRight() + this.Qh;
        int i2 = height - this.Qd;
        this.Qi.setColor((this.Qj << 24) | (this.Qc & 16777215));
        canvas.drawRect((float) left, (float) i2, (float) right, (float) height, this.Qi);
        if (this.Qk) {
            this.Qi.setColor(-16777216 | (this.Qc & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.Qm), (float) (getWidth() - getPaddingRight()), (float) height, this.Qi);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.v4.view.PagerTitleStrip
    public final void a(int i2, float f2, boolean z) {
        Rect rect = this.mTempRect;
        int height = getHeight();
        int left = this.Qr.getLeft() - this.Qh;
        int right = this.Qr.getRight() + this.Qh;
        int i3 = height - this.Qd;
        rect.set(left, i3, right, height);
        super.a(i2, f2, z);
        this.Qj = (int) (Math.abs(f2 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.Qr.getLeft() - this.Qh, i3, this.Qr.getRight() + this.Qh, height);
        invalidate(rect);
    }
}
