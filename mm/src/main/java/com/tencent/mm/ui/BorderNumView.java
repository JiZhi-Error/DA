package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;

public class BorderNumView extends View {
    private static int Oyu = 22;
    private static int Oyv = 105;
    private static int Oyw = 100;
    private int Oyt = 100;
    private Context context = null;
    private Paint mPaint;

    public BorderNumView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(32961);
        this.context = context2;
        init();
        AppMethodBeat.o(32961);
    }

    public BorderNumView(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(32962);
        this.context = context2;
        init();
        AppMethodBeat.o(32962);
    }

    private void init() {
        AppMethodBeat.i(32963);
        this.mPaint = new Paint();
        AppMethodBeat.o(32963);
    }

    public void setPaintNum(int i2) {
        this.Oyt = i2;
    }

    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(32964);
        super.onDraw(canvas);
        if (this.Oyt < 100) {
            Oyu += 15;
        }
        if (this.Oyt >= 1000) {
            Oyw -= 20;
        }
        float fromDPToPix = (float) BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, (float) Oyu);
        float fromDPToPix2 = (float) BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, (float) Oyv);
        String sb = new StringBuilder().append(this.Oyt).toString();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextSize((float) Oyw);
        this.mPaint.setColor(-11491572);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(8.0f);
        canvas.drawText(sb, fromDPToPix, fromDPToPix2, this.mPaint);
        this.mPaint.setTextSize((float) Oyw);
        this.mPaint.setColor(-1770573);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(8.0f);
        canvas.drawText(sb, fromDPToPix, fromDPToPix2, this.mPaint);
        AppMethodBeat.o(32964);
    }
}
