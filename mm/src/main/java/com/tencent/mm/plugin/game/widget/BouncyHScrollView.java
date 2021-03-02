package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BouncyHScrollView extends HorizontalScrollView {
    private Context mContext;
    private int xZG;

    public BouncyHScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public BouncyHScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42590);
        super.onFinishInflate();
        this.xZG = (int) (this.mContext.getResources().getDisplayMetrics().density * 300.0f);
        setOverScrollMode(0);
        setSmoothScrollingEnabled(true);
        setHorizontalFadingEdgeEnabled(false);
        AppMethodBeat.o(42590);
    }

    /* access modifiers changed from: protected */
    public boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        AppMethodBeat.i(42591);
        boolean overScrollBy = super.overScrollBy(i2, i3, i4, i5, i6, i7, this.xZG, i9, z);
        AppMethodBeat.o(42591);
        return overScrollBy;
    }
}
