package com.tencent.mm.wallet_core.ui.noscale;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NoScaleImageView extends AppCompatImageView {
    public NoScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NoScaleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(214346);
        super.onFinishInflate();
        a.hL(this);
        AppMethodBeat.o(214346);
    }
}
