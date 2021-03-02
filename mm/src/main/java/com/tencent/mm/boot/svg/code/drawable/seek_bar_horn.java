package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class seek_bar_horn extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                instancePath.lineTo(72.0f, 0.0f);
                instancePath.lineTo(72.0f, 72.0f);
                instancePath.lineTo(0.0f, 72.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                instancePaint4.setStrokeWidth(3.6f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(50.391575f, 17.210928f);
                instancePath2.lineTo(37.490154f, 24.8f);
                instancePath2.lineTo(21.0f, 24.8f);
                instancePath2.cubicTo(20.337257f, 24.8f, 19.8f, 25.337257f, 19.8f, 26.0f);
                instancePath2.lineTo(19.8f, 46.0f);
                instancePath2.cubicTo(19.8f, 46.662743f, 20.337257f, 47.2f, 21.0f, 47.2f);
                instancePath2.lineTo(37.490154f, 47.2f);
                instancePath2.lineTo(50.391575f, 54.78907f);
                instancePath2.cubicTo(50.57599f, 54.89755f, 50.78605f, 54.95475f, 51.0f, 54.95475f);
                instancePath2.cubicTo(51.662743f, 54.95475f, 52.2f, 54.417492f, 52.2f, 53.75475f);
                instancePath2.lineTo(52.2f, 18.24525f);
                instancePath2.cubicTo(52.2f, 18.031298f, 52.1428f, 17.821238f, 52.03432f, 17.636826f);
                instancePath2.cubicTo(51.6983f, 17.065586f, 50.962814f, 16.874905f, 50.391575f, 17.210928f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
