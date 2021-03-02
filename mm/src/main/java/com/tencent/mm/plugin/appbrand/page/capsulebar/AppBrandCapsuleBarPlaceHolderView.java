package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bz;

public final class AppBrandCapsuleBarPlaceHolderView extends View implements bz {
    private int nvv = -1;

    public AppBrandCapsuleBarPlaceHolderView(Context context) {
        super(context);
    }

    public AppBrandCapsuleBarPlaceHolderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppBrandCapsuleBarPlaceHolderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @TargetApi(21)
    public AppBrandCapsuleBarPlaceHolderView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bz
    public final boolean c(Canvas canvas) {
        return true;
    }

    public final void setFixedWidth(int i2) {
        AppMethodBeat.i(219484);
        int max = Math.max(i2, 0);
        if (max != this.nvv) {
            this.nvv = max;
            if (this.nvv != getMeasuredWidth()) {
                requestLayout();
            }
        }
        AppMethodBeat.o(219484);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(219485);
        if (getVisibility() == 0) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.max(this.nvv, 0), 1073741824), i3);
            AppMethodBeat.o(219485);
            return;
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(219485);
    }

    public final void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(219486);
        boolean z = getLayoutParams() == null;
        super.setLayoutParams(layoutParams);
        if (z) {
            this.nvv = layoutParams.width;
            this.nvv = Math.max(0, this.nvv);
        }
        AppMethodBeat.o(219486);
    }
}
