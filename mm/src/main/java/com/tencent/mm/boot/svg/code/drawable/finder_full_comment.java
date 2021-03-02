package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_full_comment extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(34.5f, 54.0f);
                instancePath.lineTo(27.62132f, 60.87f);
                instancePath.cubicTo(26.449747f, 62.041573f, 24.550253f, 62.041573f, 23.37868f, 60.87f);
                instancePath.cubicTo(22.81607f, 60.307392f, 22.5f, 59.56565f, 22.5f, 58.77f);
                instancePath.lineTo(22.5f, 54.0f);
                instancePath.lineTo(15.0f, 54.0f);
                instancePath.cubicTo(10.857864f, 54.0f, 7.5f, 50.642136f, 7.5f, 46.5f);
                instancePath.lineTo(7.5f, 21.0f);
                instancePath.cubicTo(7.5f, 16.857864f, 10.857864f, 13.5f, 15.0f, 13.5f);
                instancePath.lineTo(57.0f, 13.5f);
                instancePath.cubicTo(61.142136f, 13.5f, 64.5f, 16.857864f, 64.5f, 21.0f);
                instancePath.lineTo(64.5f, 46.5f);
                instancePath.cubicTo(64.5f, 50.642136f, 61.142136f, 54.0f, 57.0f, 54.0f);
                instancePath.lineTo(34.5f, 54.0f);
                instancePath.lineTo(34.5f, 54.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
