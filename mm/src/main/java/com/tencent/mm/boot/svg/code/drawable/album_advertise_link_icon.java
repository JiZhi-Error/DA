package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class album_advertise_link_icon extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(1275068416);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(32.4853f, 21.1716f);
                instancePath.lineTo(35.3137f, 24.0f);
                instancePath.lineTo(39.5564f, 19.7574f);
                instancePath.cubicTo(42.6806f, 16.6332f, 42.6806f, 11.5678f, 39.5564f, 8.44365f);
                instancePath.cubicTo(36.4322f, 5.31945f, 31.3668f, 5.31945f, 28.2427f, 8.44365f);
                instancePath.lineTo(19.7574f, 16.9289f);
                instancePath.cubicTo(16.6332f, 20.0531f, 16.6332f, 25.1184f, 19.7574f, 28.2426f);
                instancePath.lineTo(22.5858f, 25.4142f);
                instancePath.cubicTo(21.0237f, 23.8521f, 21.0237f, 21.3195f, 22.5858f, 19.7574f);
                instancePath.lineTo(31.0711f, 11.2721f);
                instancePath.cubicTo(32.6332f, 9.70998f, 35.1658f, 9.70998f, 36.7279f, 11.2721f);
                instancePath.cubicTo(38.29f, 12.8342f, 38.29f, 15.3668f, 36.7279f, 16.9289f);
                instancePath.lineTo(32.4853f, 21.1716f);
                instancePath.close();
                instancePath.moveTo(15.5147f, 26.8284f);
                instancePath.lineTo(12.6863f, 24.0f);
                instancePath.lineTo(8.44367f, 28.2426f);
                instancePath.cubicTo(5.31948f, 31.3668f, 5.31948f, 36.4322f, 8.44367f, 39.5564f);
                instancePath.cubicTo(11.5679f, 42.6805f, 16.6332f, 42.6805f, 19.7574f, 39.5564f);
                instancePath.lineTo(28.2427f, 31.0711f);
                instancePath.cubicTo(31.3669f, 27.9469f, 31.3669f, 22.8816f, 28.2427f, 19.7574f);
                instancePath.lineTo(25.4142f, 22.5858f);
                instancePath.cubicTo(26.9763f, 24.1479f, 26.9763f, 26.6805f, 25.4142f, 28.2426f);
                instancePath.lineTo(16.929f, 36.7279f);
                instancePath.cubicTo(15.3669f, 38.29f, 12.8342f, 38.29f, 11.2721f, 36.7279f);
                instancePath.cubicTo(9.71f, 35.1658f, 9.71f, 32.6332f, 11.2721f, 31.0711f);
                instancePath.lineTo(15.5147f, 26.8284f);
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
