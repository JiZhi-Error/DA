package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ForceInvalidateImageView extends ImageView {
    public ForceInvalidateImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public ForceInvalidateImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @TargetApi(8)
    public void onVisibilityChanged(View view, int i2) {
        AppMethodBeat.i(33136);
        if (i2 == 0) {
            invalidate();
        }
        super.onVisibilityChanged(view, i2);
        AppMethodBeat.o(33136);
    }
}
