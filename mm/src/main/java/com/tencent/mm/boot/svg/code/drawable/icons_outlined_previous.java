package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_previous extends c {
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(31.322699f, 25.5f);
                instancePath.lineTo(38.61396f, 32.791264f);
                instancePath.lineTo(35.43198f, 35.973244f);
                instancePath.lineTo(25.88604f, 26.427301f);
                instancePath.lineTo(23.764719f, 24.305983f);
                instancePath.cubicTo(23.178932f, 23.720196f, 23.178932f, 22.770449f, 23.764719f, 22.184662f);
                instancePath.lineTo(35.43198f, 10.5174f);
                instancePath.lineTo(38.61396f, 13.69938f);
                instancePath.lineTo(31.313341f, 21.0f);
                instancePath.lineTo(45.0f, 21.0f);
                instancePath.cubicTo(54.941124f, 21.0f, 63.0f, 29.058874f, 63.0f, 39.0f);
                instancePath.cubicTo(63.0f, 48.941124f, 54.941124f, 57.0f, 45.0f, 57.0f);
                instancePath.lineTo(12.0f, 57.0f);
                instancePath.lineTo(12.0f, 52.5f);
                instancePath.lineTo(45.0f, 52.5f);
                instancePath.cubicTo(52.455845f, 52.5f, 58.5f, 46.455845f, 58.5f, 39.0f);
                instancePath.cubicTo(58.5f, 31.544155f, 52.455845f, 25.5f, 45.0f, 25.5f);
                instancePath.lineTo(31.322699f, 25.5f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
