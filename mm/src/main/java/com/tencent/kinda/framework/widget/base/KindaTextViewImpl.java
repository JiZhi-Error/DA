package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class KindaTextViewImpl extends TextView {
    private static final String TAG = "KindaButtonImpl";
    private boolean hasLastPressed = false;
    private KindaButtonImpl mKindaButton;

    public KindaTextViewImpl(Context context) {
        super(context);
    }

    public KindaTextViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KindaTextViewImpl(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        AppMethodBeat.i(18972);
        if (this.mKindaButton.isEnabled() || this.mKindaButton.isKindaPressed() || this.hasLastPressed) {
            super.drawableStateChanged();
            this.hasLastPressed = this.mKindaButton.isKindaPressed();
        }
        AppMethodBeat.o(18972);
    }

    public void setKindaButton(KindaButtonImpl kindaButtonImpl) {
        this.mKindaButton = kindaButtonImpl;
    }
}
