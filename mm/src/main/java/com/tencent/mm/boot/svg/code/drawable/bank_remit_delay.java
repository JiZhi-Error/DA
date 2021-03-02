package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bank_remit_delay extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                instancePaint3.setColor(-16896);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(115.8f, 60.68889f);
                instancePath.cubicTo(115.8f, 29.181868f, 90.81813f, 4.2f, 59.31111f, 4.2f);
                instancePath.cubicTo(29.181868f, 4.2f, 4.2f, 29.181868f, 4.2f, 60.68889f);
                instancePath.cubicTo(4.2f, 90.81813f, 29.181868f, 115.8f, 59.31111f, 115.8f);
                instancePath.cubicTo(90.81813f, 115.8f, 115.8f, 90.81813f, 115.8f, 60.68889f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(57.790684f, 34.2f);
                instancePath2.lineTo(62.209316f, 34.2f);
                instancePath2.cubicTo(63.301052f, 34.2f, 64.16696f, 35.09441f, 64.12621f, 36.197716f);
                instancePath2.lineTo(62.836727f, 71.10812f);
                instancePath2.cubicTo(62.816696f, 71.650375f, 62.35176f, 72.10244f, 61.798832f, 72.10244f);
                instancePath2.lineTo(58.201168f, 72.10244f);
                instancePath2.cubicTo(57.639423f, 72.10244f, 57.183556f, 71.65727f, 57.163273f, 71.10812f);
                instancePath2.lineTo(55.87379f, 36.197716f);
                instancePath2.cubicTo(55.833225f, 35.099537f, 56.691257f, 34.2f, 57.790684f, 34.2f);
                instancePath2.close();
                instancePath2.moveTo(60.0f, 85.8f);
                instancePath2.cubicTo(57.680405f, 85.8f, 55.8f, 83.91959f, 55.8f, 81.6f);
                instancePath2.cubicTo(55.8f, 79.2804f, 57.680405f, 77.4f, 60.0f, 77.4f);
                instancePath2.cubicTo(62.319595f, 77.4f, 64.2f, 79.2804f, 64.2f, 81.6f);
                instancePath2.cubicTo(64.2f, 83.91959f, 62.319595f, 85.8f, 60.0f, 85.8f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
