package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class net_warn_icon extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-16896);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(5.2080674f, 81.84925f);
                instancePath.cubicTo(3.9541583f, 83.99987f, 4.9507284f, 85.7433f, 7.4474754f, 85.7433f);
                instancePath.lineTo(88.74638f, 85.7433f);
                instancePath.cubicTo(91.23708f, 85.7433f, 92.23893f, 83.99854f, 90.985794f, 81.84925f);
                instancePath.lineTo(50.367332f, 12.183118f);
                instancePath.cubicTo(49.113426f, 10.032495f, 47.07966f, 10.033827f, 45.826527f, 12.183118f);
                instancePath.lineTo(5.2080674f, 81.84925f);
                instancePath.close();
                instancePath.moveTo(45.896564f, 36.946117f);
                instancePath.cubicTo(45.070587f, 36.946117f, 44.432064f, 37.61737f, 44.470753f, 38.453403f);
                instancePath.lineTo(45.63274f, 63.56276f);
                instancePath.lineTo(50.5597f, 63.56276f);
                instancePath.lineTo(51.721687f, 38.453403f);
                instancePath.cubicTo(51.760212f, 37.620953f, 51.122555f, 36.946117f, 50.295876f, 36.946117f);
                instancePath.lineTo(45.896564f, 36.946117f);
                instancePath.close();
                instancePath.moveTo(48.096222f, 75.39238f);
                instancePath.cubicTo(50.137035f, 75.39238f, 51.791443f, 73.73729f, 51.791443f, 71.695625f);
                instancePath.cubicTo(51.791443f, 69.65396f, 50.137035f, 67.99887f, 48.096222f, 67.99887f);
                instancePath.cubicTo(46.055405f, 67.99887f, 44.401f, 69.65396f, 44.401f, 71.695625f);
                instancePath.cubicTo(44.401f, 73.73729f, 46.055405f, 75.39238f, 48.096222f, 75.39238f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
