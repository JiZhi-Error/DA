package com.tencent.mm.view;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class ExpandTextView extends FrameLayout implements View.OnClickListener {
    private TextView RiJ;
    private MMNeat7extView RiK;
    private String RiL;
    private int RiM;
    private a RiN = null;
    private boolean yPa = false;

    public interface a {
    }

    public MMNeat7extView getTextView() {
        return this.RiK;
    }

    public TextView getExpandTextView() {
        return this.RiJ;
    }

    public void setOnExpandListener(a aVar) {
        this.RiN = aVar;
    }

    public ExpandTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExpandTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(164241);
        super.onFinishInflate();
        this.RiK = new MMNeat7extView(getContext());
        addView(this.RiK, new FrameLayout.LayoutParams(-1, -1));
        this.RiJ = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        addView(this.RiJ, layoutParams);
        this.RiJ.setOnClickListener(this);
        AppMethodBeat.o(164241);
    }

    public void setExpandIconText(String str) {
        this.RiL = str;
    }

    public void setExpandTextColor(int i2) {
        AppMethodBeat.i(164242);
        this.RiJ.setTextColor(i2);
        AppMethodBeat.o(164242);
    }

    public void setTextColor(int i2) {
        AppMethodBeat.i(164243);
        this.RiK.setTextColor(i2);
        AppMethodBeat.o(164243);
    }

    public void setExpandTextSize(float f2) {
        AppMethodBeat.i(164244);
        this.RiJ.setTextSize(0, f2);
        AppMethodBeat.o(164244);
    }

    public void setLineSpacingExtra(int i2) {
        AppMethodBeat.i(164245);
        this.RiK.setSpacingAdd(i2);
        AppMethodBeat.o(164245);
    }

    public void setTextSize(float f2) {
        AppMethodBeat.i(164246);
        this.RiK.setTextSize(0, f2);
        AppMethodBeat.o(164246);
    }

    public void setMaxLines(int i2) {
        AppMethodBeat.i(164247);
        this.RiK.setMaxLines(i2);
        AppMethodBeat.o(164247);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(164248);
        super.onMeasure(i2, i3);
        if (!this.yPa) {
            com.tencent.neattextview.textview.layout.a mq = this.RiK.mq(getMeasuredWidth(), getMeasuredHeight());
            if (mq == null) {
                Log.e("MicroMsg.ExpandTextView", "layout is null!");
                this.RiJ.setVisibility(8);
            } else if (mq.hiG() > this.RiM) {
                this.RiJ.setVisibility(0);
                AppMethodBeat.o(164248);
                return;
            } else {
                this.RiJ.setVisibility(8);
                AppMethodBeat.o(164248);
                return;
            }
        }
        AppMethodBeat.o(164248);
    }

    public void onClick(View view) {
        AppMethodBeat.i(164249);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/ExpandTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (!this.yPa) {
            this.yPa = true;
            this.RiK.setMaxLines(Integer.MAX_VALUE);
            this.RiJ.animate().alpha(0.0f).setDuration(300).setListener(new Animator.AnimatorListener() {
                /* class com.tencent.mm.view.ExpandTextView.AnonymousClass1 */

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(164240);
                    ExpandTextView.this.RiJ.setAlpha(1.0f);
                    ExpandTextView.this.RiJ.setVisibility(8);
                    AppMethodBeat.o(164240);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/ExpandTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164249);
    }
}
