package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class ChattingContent extends FrameLayout {
    private int KmP = -1;
    private int KmQ = 0;

    public ChattingContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChattingContent(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(31729);
        Log.d("MicroMsg.ChattingContent", "jacks onMeasure  width:%d, height:%d", Integer.valueOf(View.MeasureSpec.getSize(i2)), Integer.valueOf(View.MeasureSpec.getSize(i3)));
        super.onMeasure(i2, i3);
        AppMethodBeat.o(31729);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(31730);
        Log.d("MicroMsg.ChattingContent", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(31730);
    }
}
