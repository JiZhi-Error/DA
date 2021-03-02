package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RelativePopupWindow extends PopupWindow {
    private FrameLayout ARF;
    private boolean QEP;

    public RelativePopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public RelativePopupWindow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(205439);
        this.QEP = false;
        this.ARF = new FrameLayout(context);
        super.setContentView(this.ARF);
        AppMethodBeat.o(205439);
    }

    public void setContentView(View view) {
        AppMethodBeat.i(205440);
        this.ARF.removeAllViews();
        this.ARF.addView(view);
        AppMethodBeat.o(205440);
    }

    public View getContentView() {
        AppMethodBeat.i(205441);
        View childAt = this.ARF.getChildAt(0);
        AppMethodBeat.o(205441);
        return childAt;
    }
}
