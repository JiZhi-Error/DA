package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class music_play extends c {
    private final int height = 107;
    private final int width = 107;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 107;
            case 1:
                return 107;
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
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(29.0f, 22.005177f);
                instancePath.cubicTo(29.0f, 20.897749f, 29.90195f, 20.0f, 31.00853f, 20.0f);
                instancePath.lineTo(38.99147f, 20.0f);
                instancePath.cubicTo(40.10075f, 20.0f, 41.0f, 20.89647f, 41.0f, 22.005177f);
                instancePath.lineTo(41.0f, 84.99482f);
                instancePath.cubicTo(41.0f, 86.10225f, 40.09805f, 87.0f, 38.99147f, 87.0f);
                instancePath.lineTo(31.00853f, 87.0f);
                instancePath.cubicTo(29.89925f, 87.0f, 29.0f, 86.10353f, 29.0f, 84.99482f);
                instancePath.lineTo(29.0f, 22.005177f);
                instancePath.close();
                instancePath.moveTo(66.0f, 22.005177f);
                instancePath.cubicTo(66.0f, 20.897749f, 66.90195f, 20.0f, 68.00853f, 20.0f);
                instancePath.lineTo(75.99147f, 20.0f);
                instancePath.cubicTo(77.10075f, 20.0f, 78.0f, 20.89647f, 78.0f, 22.005177f);
                instancePath.lineTo(78.0f, 84.99482f);
                instancePath.cubicTo(78.0f, 86.10225f, 77.09805f, 87.0f, 75.99147f, 87.0f);
                instancePath.lineTo(68.00853f, 87.0f);
                instancePath.cubicTo(66.89925f, 87.0f, 66.0f, 86.10353f, 66.0f, 84.99482f);
                instancePath.lineTo(66.0f, 22.005177f);
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
