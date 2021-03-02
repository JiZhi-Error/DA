package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMFrameLayout extends FrameLayout {
    private boolean OQl = false;

    public MMFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(141956);
        int childCount = getChildCount();
        int i6 = 0;
        while (!this.OQl && i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.gravity == -1) {
                    layoutParams.gravity = 51;
                    childAt.setLayoutParams(layoutParams);
                }
            }
            i6++;
        }
        this.OQl = true;
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(141956);
    }
}
