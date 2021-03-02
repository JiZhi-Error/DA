package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_display_lock extends c {
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
                instancePath.moveTo(66.0f, 45.0f);
                instancePath.lineTo(69.01381f, 45.0f);
                instancePath.cubicTo(70.66303f, 45.0f, 72.0f, 46.340096f, 72.0f, 47.987827f);
                instancePath.lineTo(72.0f, 64.51218f);
                instancePath.cubicTo(72.0f, 66.16231f, 70.633f, 67.5f, 69.01381f, 67.5f);
                instancePath.lineTo(44.98619f, 67.5f);
                instancePath.cubicTo(43.336964f, 67.5f, 42.0f, 66.159904f, 42.0f, 64.51218f);
                instancePath.lineTo(42.0f, 64.5f);
                instancePath.lineTo(24.0f, 64.5f);
                instancePath.lineTo(24.0f, 62.699997f);
                instancePath.cubicTo(24.0f, 61.705887f, 24.798523f, 60.899998f, 25.8039f, 60.899998f);
                instancePath.lineTo(42.0f, 60.899998f);
                instancePath.lineTo(42.0f, 57.0f);
                instancePath.lineTo(9.0f, 57.0f);
                instancePath.cubicTo(7.343146f, 57.0f, 6.0f, 55.656853f, 6.0f, 54.0f);
                instancePath.lineTo(6.0f, 15.0f);
                instancePath.cubicTo(6.0f, 13.343145f, 7.343146f, 12.0f, 9.0f, 12.0f);
                instancePath.lineTo(63.0f, 12.0f);
                instancePath.cubicTo(64.65685f, 12.0f, 66.0f, 13.343145f, 66.0f, 15.0f);
                instancePath.lineTo(66.0f, 45.0f);
                instancePath.close();
                instancePath.moveTo(62.4f, 36.419296f);
                instancePath.lineTo(62.4f, 15.6f);
                instancePath.lineTo(9.6f, 15.6f);
                instancePath.lineTo(9.6f, 53.4f);
                instancePath.lineTo(42.0f, 53.4f);
                instancePath.lineTo(42.0f, 47.987827f);
                instancePath.cubicTo(42.0f, 46.337696f, 43.366993f, 45.0f, 44.98619f, 45.0f);
                instancePath.lineTo(48.0f, 45.0f);
                instancePath.lineTo(48.0f, 44.1f);
                instancePath.cubicTo(48.0f, 38.798065f, 52.029438f, 34.5f, 57.0f, 34.5f);
                instancePath.cubicTo(59.026093f, 34.5f, 60.89581f, 35.214134f, 62.4f, 36.419296f);
                instancePath.close();
                instancePath.moveTo(51.6f, 45.0f);
                instancePath.lineTo(62.4f, 45.0f);
                instancePath.lineTo(62.4f, 44.1f);
                instancePath.cubicTo(62.4f, 40.736214f, 59.92855f, 38.1f, 57.0f, 38.1f);
                instancePath.cubicTo(54.07145f, 38.1f, 51.6f, 40.736214f, 51.6f, 44.1f);
                instancePath.lineTo(51.6f, 45.0f);
                instancePath.close();
                instancePath.moveTo(45.6f, 63.9f);
                instancePath.lineTo(68.4f, 63.9f);
                instancePath.lineTo(68.4f, 48.6f);
                instancePath.lineTo(45.6f, 48.6f);
                instancePath.lineTo(45.6f, 63.9f);
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
