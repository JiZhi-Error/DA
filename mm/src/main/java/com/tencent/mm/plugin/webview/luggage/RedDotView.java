package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RedDotView extends View {
    private Paint mPaint = new Paint();

    public RedDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(182687);
        AppMethodBeat.o(182687);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(182688);
        super.onDraw(canvas);
        this.mPaint.setColor(-65536);
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, (float) (getWidth() / 2), this.mPaint);
        AppMethodBeat.o(182688);
    }
}
