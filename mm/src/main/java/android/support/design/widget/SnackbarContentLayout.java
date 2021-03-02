package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a;
import android.support.design.g.a;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class SnackbarContentLayout extends LinearLayout implements a {
    private int maxWidth;
    private TextView tF;
    private Button tG;
    private int tH;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0008a.SnackbarLayout);
        this.maxWidth = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.tH = obtainStyledAttributes.getDimensionPixelSize(2, -1);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.tF = (TextView) findViewById(R.id.htv);
        this.tG = (Button) findViewById(R.id.htu);
    }

    public TextView getMessageView() {
        return this.tF;
    }

    public Button getActionView() {
        return this.tG;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z;
        super.onMeasure(i2, i3);
        if (this.maxWidth > 0 && getMeasuredWidth() > this.maxWidth) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
            super.onMeasure(i2, i3);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.zt);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.zs);
        boolean z2 = this.tF.getLayout().getLineCount() > 1;
        if (!z2 || this.tH <= 0 || this.tG.getMeasuredWidth() <= this.tH) {
            if (!z2) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (f(0, dimensionPixelSize, dimensionPixelSize)) {
                z = true;
            }
            z = false;
        } else {
            if (f(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                z = true;
            }
            z = false;
        }
        if (z) {
            super.onMeasure(i2, i3);
        }
    }

    private boolean f(int i2, int i3, int i4) {
        boolean z = false;
        if (i2 != getOrientation()) {
            setOrientation(i2);
            z = true;
        }
        if (this.tF.getPaddingTop() == i3 && this.tF.getPaddingBottom() == i4) {
            return z;
        }
        e(this.tF, i3, i4);
        return true;
    }

    private static void e(View view, int i2, int i3) {
        if (u.as(view)) {
            u.d(view, u.ac(view), i2, u.ad(view), i3);
        } else {
            view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
        }
    }

    @Override // android.support.design.g.a
    public final void bL() {
        this.tF.setAlpha(0.0f);
        this.tF.animate().alpha(1.0f).setDuration(180).setStartDelay(70).start();
        if (this.tG.getVisibility() == 0) {
            this.tG.setAlpha(0.0f);
            this.tG.animate().alpha(1.0f).setDuration(180).setStartDelay(70).start();
        }
    }

    @Override // android.support.design.g.a
    public final void bM() {
        this.tF.setAlpha(1.0f);
        this.tF.animate().alpha(0.0f).setDuration(180).setStartDelay(0).start();
        if (this.tG.getVisibility() == 0) {
            this.tG.setAlpha(1.0f);
            this.tG.animate().alpha(0.0f).setDuration(180).setStartDelay(0).start();
        }
    }
}
