package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class MaskTextView extends SnsTextView {
    public MaskTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.SnsTextView
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(97974);
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(97974);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.SnsTextView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(97975);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(97975);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.SnsTextView
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(97976);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(97976);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.MaskTextView", th, "", new Object[0]);
            AppMethodBeat.o(97976);
        }
    }
}
