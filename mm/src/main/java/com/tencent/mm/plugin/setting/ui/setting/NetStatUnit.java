package com.tencent.mm.plugin.setting.ui.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

class NetStatUnit extends View {
    protected static long max;
    private long CZg;
    private long total;

    public NetStatUnit(Context context) {
        this(context, null);
    }

    public NetStatUnit(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetStatUnit(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public final void al(long j2, long j3) {
        AppMethodBeat.i(173792);
        this.CZg = j2;
        this.total = j3;
        if (j2 > 94371840) {
            this.CZg = 94371840;
        }
        if (j3 > 94371840) {
            this.total = 94371840;
        }
        if (j2 <= j3) {
            j2 = j3;
        }
        IJ(j2);
        AppMethodBeat.o(173792);
    }

    private static void IJ(long j2) {
        long j3 = ((j2 / 1572864) + 1) * 1572864;
        if (94371840 <= j3) {
            j3 = 94371840;
        }
        if (3145728 >= j3) {
            j3 = 3145728;
        }
        if (j3 > max) {
            max = j3;
        }
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(73901);
        super.onDraw(canvas);
        Paint paint = new Paint();
        Rect rect = new Rect();
        getDrawingRect(rect);
        Rect rect2 = new Rect(rect.left, (int) (((float) rect.bottom) - ((((float) rect.height()) * ((float) this.total)) / ((float) max))), (int) ((((float) rect.width()) * 0.6f) + ((float) rect.left)), rect.bottom);
        paint.setColor(-7829368);
        canvas.drawRect(rect2, paint);
        Rect rect3 = new Rect(rect.left, (int) (((float) rect.bottom) - ((((float) rect.height()) * ((float) this.CZg)) / ((float) max))), (int) ((((float) rect.width()) * 0.6f) + ((float) rect.left)), rect.bottom);
        paint.setColor(-16711936);
        canvas.drawRect(rect3, paint);
        AppMethodBeat.o(73901);
    }
}
