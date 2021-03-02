package com.tencent.mm.wallet_core.ui.noscale;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NoScaleRelativeLayout extends RelativeLayout {
    public NoScaleRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NoScaleRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(214348);
        super.onFinishInflate();
        a.hL(this);
        AppMethodBeat.o(214348);
    }
}
