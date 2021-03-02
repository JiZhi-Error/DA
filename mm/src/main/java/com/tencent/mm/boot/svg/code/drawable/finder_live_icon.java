package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_live_icon extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.instanceMatrix(looper);
                c.instanceMatrixArray(looper);
                Paint instancePaint = c.instancePaint(looper);
                instancePaint.setFlags(385);
                instancePaint.setStyle(Paint.Style.FILL);
                Paint instancePaint2 = c.instancePaint(looper);
                instancePaint2.setFlags(385);
                instancePaint2.setStyle(Paint.Style.STROKE);
                instancePaint.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint2.setStrokeWidth(1.0f);
                instancePaint2.setStrokeCap(Paint.Cap.BUTT);
                instancePaint2.setStrokeJoin(Paint.Join.MITER);
                instancePaint2.setStrokeMiter(4.0f);
                instancePaint2.setPathEffect(null);
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(24.0f, 0.0f);
                instancePath.lineTo(24.0f, 24.0f);
                instancePath.lineTo(0.0f, 24.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-40634);
                instancePaint4.setStrokeWidth(1.5f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(12.0f, 2.75f);
                instancePath2.cubicTo(17.108635f, 2.75f, 21.25f, 6.891366f, 21.25f, 12.0f);
                instancePath2.cubicTo(21.25f, 17.108635f, 17.108635f, 21.25f, 12.0f, 21.25f);
                instancePath2.cubicTo(6.891366f, 21.25f, 2.75f, 17.108635f, 2.75f, 12.0f);
                instancePath2.cubicTo(2.75f, 6.891366f, 6.891366f, 2.75f, 12.0f, 2.75f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-40634);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(12.0f, 6.5f);
                instancePath3.cubicTo(15.037566f, 6.5f, 17.5f, 8.962434f, 17.5f, 12.0f);
                instancePath3.cubicTo(17.5f, 15.037566f, 15.037566f, 17.5f, 12.0f, 17.5f);
                instancePath3.cubicTo(8.962434f, 17.5f, 6.5f, 15.037566f, 6.5f, 12.0f);
                instancePath3.cubicTo(6.5f, 8.962434f, 8.962434f, 6.5f, 12.0f, 6.5f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
