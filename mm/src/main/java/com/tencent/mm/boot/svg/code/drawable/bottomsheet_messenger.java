package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_messenger extends c {
    private final int height = 144;
    private final int width = 144;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                instancePaint3.setColor(-9276814);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(32.316944f, 114.45962f);
                instancePath.cubicTo(17.49707f, 103.41242f, 8.0f, 86.3897f, 8.0f, 67.29348f);
                instancePath.cubicTo(8.0f, 33.99431f, 36.877632f, 7.0f, 72.5f, 7.0f);
                instancePath.cubicTo(108.12237f, 7.0f, 137.0f, 33.99431f, 137.0f, 67.29348f);
                instancePath.cubicTo(137.0f, 100.59264f, 108.12237f, 127.58696f, 72.5f, 127.58696f);
                instancePath.cubicTo(66.06798f, 127.58696f, 59.85585f, 126.70688f, 53.993908f, 125.06851f);
                instancePath.lineTo(32.316944f, 136.89055f);
                instancePath.lineTo(32.316944f, 114.45962f);
                instancePath.close();
                instancePath.moveTo(30.467037f, 88.38713f);
                instancePath.lineTo(66.017456f, 50.875744f);
                instancePath.lineTo(82.72663f, 68.6543f);
                instancePath.lineTo(114.75198f, 50.19022f);
                instancePath.lineTo(79.51087f, 88.32609f);
                instancePath.lineTo(63.189262f, 70.64465f);
                instancePath.lineTo(30.467037f, 88.38713f);
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
