package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bank_remit_waiting extends c {
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
                instancePaint3.setColor(-15683841);
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
                instancePath2.moveTo(62.12374f, 65.15995f);
                instancePath2.lineTo(60.59251f, 27.389608f);
                instancePath2.cubicTo(60.57021f, 26.839443f, 60.108807f, 26.4f, 59.561615f, 26.4f);
                instancePath2.lineTo(55.54317f, 26.4f);
                instancePath2.cubicTo(55.00337f, 26.4f, 54.53443f, 26.843063f, 54.51227f, 27.389608f);
                instancePath2.lineTo(52.833233f, 68.80597f);
                instancePath2.cubicTo(52.807594f, 69.43838f, 53.077152f, 69.998924f, 53.51898f, 70.363365f);
                instancePath2.cubicTo(53.700817f, 70.78672f, 54.031994f, 71.146774f, 54.481876f, 71.3614f);
                instancePath2.lineTo(81.584015f, 84.290726f);
                instancePath2.cubicTo(82.09355f, 84.5338f, 82.71503f, 84.33845f, 82.98967f, 83.862755f);
                instancePath2.lineTo(84.3951f, 81.42847f);
                instancePath2.cubicTo(84.6709f, 80.95077f, 84.51857f, 80.31419f, 84.05744f, 80.00215f);
                instancePath2.lineTo(62.12374f, 65.15995f);
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
