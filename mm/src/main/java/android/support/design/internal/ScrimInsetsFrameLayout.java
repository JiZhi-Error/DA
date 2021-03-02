package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.a;
import android.support.v4.view.ac;
import android.support.v4.view.p;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.tencent.mm.R;

public class ScrimInsetsFrameLayout extends FrameLayout {
    Drawable lm;
    Rect ln;
    private Rect lo;

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.lo = new Rect();
        TypedArray a2 = f.a(context, attributeSet, a.C0008a.ScrimInsetsFrameLayout, i2, R.style.a3v, new int[0]);
        this.lm = a2.getDrawable(0);
        a2.recycle();
        setWillNotDraw(true);
        u.a(this, new p() {
            /* class android.support.design.internal.ScrimInsetsFrameLayout.AnonymousClass1 */

            @Override // android.support.v4.view.p
            public final ac a(View view, ac acVar) {
                boolean z;
                if (ScrimInsetsFrameLayout.this.ln == null) {
                    ScrimInsetsFrameLayout.this.ln = new Rect();
                }
                ScrimInsetsFrameLayout.this.ln.set(acVar.getSystemWindowInsetLeft(), acVar.getSystemWindowInsetTop(), acVar.getSystemWindowInsetRight(), acVar.getSystemWindowInsetBottom());
                ScrimInsetsFrameLayout.this.a(acVar);
                ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
                if (Build.VERSION.SDK_INT >= 20) {
                    z = ((WindowInsets) acVar.Rm).hasSystemWindowInsets();
                } else {
                    z = false;
                }
                scrimInsetsFrameLayout.setWillNotDraw(!z || ScrimInsetsFrameLayout.this.lm == null);
                u.X(ScrimInsetsFrameLayout.this);
                return acVar.fI();
            }
        });
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.ln != null && this.lm != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.lo.set(0, 0, width, this.ln.top);
            this.lm.setBounds(this.lo);
            this.lm.draw(canvas);
            this.lo.set(0, height - this.ln.bottom, width, height);
            this.lm.setBounds(this.lo);
            this.lm.draw(canvas);
            this.lo.set(0, this.ln.top, this.ln.left, height - this.ln.bottom);
            this.lm.setBounds(this.lo);
            this.lm.draw(canvas);
            this.lo.set(width - this.ln.right, this.ln.top, width, height - this.ln.bottom);
            this.lm.setBounds(this.lo);
            this.lm.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.lm != null) {
            this.lm.setCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.lm != null) {
            this.lm.setCallback(null);
        }
    }

    /* access modifiers changed from: protected */
    public void a(ac acVar) {
    }
}
