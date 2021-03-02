package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_ban_comment extends c {
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(4.131603f, 6.2535715f);
                instancePath.lineTo(16.825377f, 18.946735f);
                instancePath.cubicTo(15.394642f, 19.61799f, 13.7498045f, 20.0f, 12.0f, 20.0f);
                instancePath.cubicTo(10.8710165f, 20.0f, 9.78573f, 19.840973f, 8.773454f, 19.547836f);
                instancePath.lineTo(8.773454f, 19.547836f);
                instancePath.lineTo(5.790501f, 20.978193f);
                instancePath.cubicTo(5.705353f, 21.019022f, 5.6103826f, 21.034904f, 5.516583f, 21.024002f);
                instancePath.cubicTo(5.2422876f, 20.992117f, 5.0457745f, 20.74391f, 5.077659f, 20.469614f);
                instancePath.lineTo(5.077659f, 20.469614f);
                instancePath.lineTo(5.3797565f, 17.870733f);
                instancePath.cubicTo(3.306998f, 16.313334f, 2.0f, 14.036405f, 2.0f, 11.5f);
                instancePath.cubicTo(2.0f, 9.520164f, 2.7963367f, 7.6984215f, 4.131603f, 6.2535715f);
                instancePath.close();
                instancePath.moveTo(3.0606601f, 3.0606601f);
                instancePath.lineTo(4.1213202f, 2.0f);
                instancePath.lineTo(6.513101f, 4.3926344f);
                instancePath.cubicTo(8.088355f, 3.5122216f, 9.9738035f, 3.0f, 12.0f, 3.0f);
                instancePath.cubicTo(17.522848f, 3.0f, 22.0f, 6.8055797f, 22.0f, 11.5f);
                instancePath.cubicTo(22.0f, 13.716352f, 21.002035f, 15.73458f, 19.367222f, 17.247734f);
                instancePath.lineTo(21.091883f, 18.970562f);
                instancePath.lineTo(20.031223f, 20.031223f);
                instancePath.lineTo(3.0606601f, 3.0606601f);
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
