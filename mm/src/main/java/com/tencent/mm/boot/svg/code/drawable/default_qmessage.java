package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class default_qmessage extends c {
    private final int height = 192;
    private final int width = 192;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                instancePaint3.setColor(-15158035);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(192.0f, 0.0f);
                instancePath.lineTo(192.0f, 192.0f);
                instancePath.lineTo(0.0f, 192.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(142.54546f, 100.831314f);
                instancePath2.cubicTo(139.21634f, 92.18106f, 135.36592f, 85.41221f, 136.1254f, 75.06431f);
                instancePath2.cubicTo(134.93721f, 54.305878f, 117.50597f, 36.5975f, 97.60502f, 36.41379f);
                instancePath2.cubicTo(74.49456f, 36.5975f, 57.06332f, 54.305878f, 55.874607f, 75.06431f);
                instancePath2.cubicTo(56.631752f, 85.41221f, 52.78132f, 92.18106f, 49.454544f, 100.831314f);
                instancePath2.cubicTo(40.531776f, 114.37079f, 42.792137f, 131.66068f, 46.244514f, 133.04007f);
                instancePath2.cubicTo(48.937344f, 131.66068f, 53.50395f, 128.93271f, 59.08464f, 123.37745f);
                instancePath2.cubicTo(59.046963f, 129.886f, 62.21491f, 134.8965f, 65.5047f, 139.48183f);
                instancePath2.cubicTo(60.41336f, 140.68864f, 56.32277f, 143.90248f, 55.874607f, 145.92358f);
                instancePath2.cubicTo(56.75219f, 152.38712f, 65.80511f, 156.04285f, 75.134796f, 155.58621f);
                instancePath2.cubicTo(85.191315f, 155.14914f, 92.27135f, 152.36159f, 94.39498f, 149.14445f);
                instancePath2.cubicTo(95.27298f, 148.79735f, 95.62354f, 148.81863f, 97.60502f, 149.14445f);
                instancePath2.cubicTo(96.38775f, 148.81863f, 96.74691f, 148.79735f, 97.60502f, 149.14445f);
                instancePath2.cubicTo(99.75284f, 152.36159f, 106.82212f, 155.14914f, 116.865204f, 155.58621f);
                instancePath2.cubicTo(126.196144f, 156.04285f, 135.2462f, 152.38712f, 136.1254f, 145.92358f);
                instancePath2.cubicTo(135.67705f, 143.90106f, 131.58717f, 140.68864f, 126.4953f, 139.48183f);
                instancePath2.cubicTo(129.78922f, 134.8965f, 132.94926f, 129.89098f, 132.91536f, 123.37745f);
                instancePath2.cubicTo(138.50232f, 128.93483f, 143.06104f, 131.66068f, 145.7555f, 133.04007f);
                instancePath2.cubicTo(149.20982f, 131.66068f, 151.46875f, 114.37079f, 142.54546f, 100.831314f);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
