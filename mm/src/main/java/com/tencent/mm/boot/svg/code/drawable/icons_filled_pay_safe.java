package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_pay_safe extends c {
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
                instancePath.moveTo(36.0f, 7.5f);
                instancePath.lineTo(60.0f, 16.5f);
                instancePath.lineTo(60.00072f, 27.148378f);
                instancePath.cubicTo(51.397877f, 30.727888f, 34.20503f, 37.89166f, 34.20503f, 37.89166f);
                instancePath.cubicTo(33.90008f, 37.996475f, 33.571373f, 38.055946f, 33.228405f, 38.055946f);
                instancePath.cubicTo(32.65178f, 38.055946f, 32.113964f, 37.89389f, 31.666443f, 37.61884f);
                instancePath.lineTo(31.666443f, 37.61884f);
                instancePath.lineTo(25.523943f, 33.514637f);
                instancePath.cubicTo(25.363945f, 33.403133f, 25.168303f, 33.33697f, 24.95286f, 33.33697f);
                instancePath.cubicTo(24.426926f, 33.33697f, 24.0f, 33.736908f, 24.0f, 34.230515f);
                instancePath.cubicTo(24.0f, 34.35912f, 24.034851f, 34.49144f, 24.091087f, 34.60815f);
                instancePath.lineTo(24.091087f, 34.60815f);
                instancePath.lineTo(29.297363f, 45.329178f);
                instancePath.lineTo(29.421717f, 45.5849f);
                instancePath.cubicTo(29.74805f, 46.13054f, 30.369825f, 46.5f, 31.085064f, 46.5f);
                instancePath.cubicTo(31.393179f, 46.5f, 31.683868f, 46.428635f, 31.942083f, 46.307465f);
                instancePath.lineTo(31.942083f, 46.307465f);
                instancePath.lineTo(32.15119f, 46.193726f);
                instancePath.cubicTo(32.15119f, 46.193726f, 48.522564f, 37.33158f, 60.001244f, 31.117949f);
                instancePath.lineTo(60.0f, 33.761368f);
                instancePath.cubicTo(60.0f, 48.30043f, 50.104965f, 60.97376f, 36.0f, 64.5f);
                instancePath.cubicTo(21.895035f, 60.97376f, 12.0f, 48.30043f, 12.0f, 33.761368f);
                instancePath.lineTo(12.0f, 16.5f);
                instancePath.lineTo(36.0f, 7.5f);
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
