package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;

public class PatPopupWindow extends PopupWindow {
    private FrameLayout ARF;
    private int maxHeight;
    private int maxWidth;
    private int x;
    private int y;

    private PatPopupWindow(Context context) {
        this(context, null);
    }

    public PatPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public PatPopupWindow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(207004);
        this.ARF = new FrameLayout(context);
        super.setContentView(this.ARF);
        AppMethodBeat.o(207004);
    }

    public PatPopupWindow(View view) {
        this(view.getContext());
        AppMethodBeat.i(207005);
        this.ARF = new FrameLayout(view.getContext());
        super.setContentView(this.ARF);
        setContentView(view);
        AppMethodBeat.o(207005);
    }

    public void setContentView(View view) {
        AppMethodBeat.i(207006);
        this.ARF.removeAllViews();
        this.ARF.addView(view);
        AppMethodBeat.o(207006);
    }

    public View getContentView() {
        AppMethodBeat.i(207007);
        View childAt = this.ARF.getChildAt(0);
        AppMethodBeat.o(207007);
        return childAt;
    }

    public final void a(View view, FrameLayout.LayoutParams layoutParams) {
        AppMethodBeat.i(207008);
        if (getBackground() == null) {
            setBackgroundDrawable(new ColorDrawable(0));
        }
        View contentView = getContentView();
        if (contentView == null) {
            AppMethodBeat.o(207008);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = layoutParams.leftMargin;
        layoutParams2.rightMargin = layoutParams.rightMargin;
        layoutParams2.topMargin = layoutParams.topMargin;
        layoutParams2.bottomMargin = layoutParams.bottomMargin;
        contentView.setLayoutParams(layoutParams2);
        eG(view);
        Log.d("MicroMsg.PatPopupWindow", "show contentView size (%d,%d)", Integer.valueOf(this.ARF.getMeasuredWidth()), Integer.valueOf(this.ARF.getMeasuredHeight()));
        eH(view);
        Log.d("MicroMsg.PatPopupWindow", "show at fix location (%d,%d)", Integer.valueOf(this.x), Integer.valueOf(this.y));
        if (isShowing()) {
            update(view, this.x, this.y, getWidth(), getHeight());
            AppMethodBeat.o(207008);
            return;
        }
        showAsDropDown(view, this.x, this.y);
        AppMethodBeat.o(207008);
    }

    private void eG(View view) {
        AppMethodBeat.i(207009);
        int i2 = ao.gJO().widthPixels;
        int i3 = ao.gJO().heightPixels;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        setWidth(-2);
        setHeight(-2);
        this.maxWidth = i2;
        this.maxHeight = iArr[1];
        this.ARF.measure(View.MeasureSpec.makeMeasureSpec(this.maxWidth, View.MeasureSpec.getMode(Integer.MIN_VALUE)), View.MeasureSpec.makeMeasureSpec(this.maxHeight, View.MeasureSpec.getMode(Integer.MIN_VALUE)));
        setWidth(Math.min(this.ARF.getMeasuredWidth(), this.maxWidth));
        setHeight(Math.min(this.ARF.getMeasuredHeight(), this.maxHeight));
        AppMethodBeat.o(207009);
    }

    private void eH(View view) {
        AppMethodBeat.i(207010);
        view.getLocationInWindow(new int[2]);
        this.x = 0;
        this.y = 0;
        this.x = (-(this.ARF.getMeasuredWidth() - view.getWidth())) / 2;
        this.y = (-this.ARF.getMeasuredHeight()) - view.getHeight();
        AppMethodBeat.o(207010);
    }
}
