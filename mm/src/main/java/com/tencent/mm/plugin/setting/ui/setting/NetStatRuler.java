package com.tencent.mm.plugin.setting.ui.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;

class NetStatRuler extends View {
    public NetStatRuler(Context context) {
        this(context, null);
    }

    public NetStatRuler(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetStatRuler(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(73898);
        super.onDraw(canvas);
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize((float) getContext().getResources().getDimensionPixelSize(R.dimen.kk));
        Rect rect = new Rect();
        getDrawingRect(rect);
        float height = (float) rect.height();
        float paddingLeft = (float) (rect.left + getPaddingLeft());
        float f2 = ((float) rect.top) + (height / 3.0f);
        float f3 = ((float) rect.top) + ((2.0f * height) / 3.0f);
        float f4 = ((float) rect.top) + height;
        textPaint.setColor(-7829368);
        canvas.drawText(Util.getSizeMB((NetStatUnit.max * 2) / 3), paddingLeft, f2, textPaint);
        canvas.drawText(Util.getSizeMB(NetStatUnit.max / 3), paddingLeft, f3, textPaint);
        canvas.drawText(Util.getSizeMB(0), paddingLeft, f4, textPaint);
        AppMethodBeat.o(73898);
    }
}
