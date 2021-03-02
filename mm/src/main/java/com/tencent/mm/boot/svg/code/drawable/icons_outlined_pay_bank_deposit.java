package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_pay_bank_deposit extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(15.6f, 30.0f);
                instancePath.lineTo(15.6f, 33.599f);
                instancePath.lineTo(15.6f, 33.6f);
                instancePath.lineTo(15.6f, 56.4f);
                instancePath.lineTo(56.4f, 56.4f);
                instancePath.lineTo(56.4f, 30.0f);
                instancePath.lineTo(60.0f, 30.0f);
                instancePath.lineTo(60.0f, 56.4f);
                instancePath.lineTo(63.0f, 56.4f);
                instancePath.lineTo(63.0f, 60.0f);
                instancePath.lineTo(9.0f, 60.0f);
                instancePath.lineTo(9.0f, 56.4f);
                instancePath.lineTo(12.0f, 56.4f);
                instancePath.lineTo(12.0f, 30.0f);
                instancePath.lineTo(15.6f, 30.0f);
                instancePath.close();
                instancePath.moveTo(30.857143f, 31.5f);
                instancePath.lineTo(34.97f, 39.405f);
                instancePath.lineTo(37.029f, 39.405f);
                instancePath.lineTo(41.142857f, 31.5f);
                instancePath.lineTo(45.0f, 31.5f);
                instancePath.lineTo(40.886f, 39.405f);
                instancePath.lineTo(45.0f, 39.405914f);
                instancePath.lineTo(45.0f, 42.370617f);
                instancePath.lineTo(37.542f, 42.37f);
                instancePath.lineTo(37.542f, 45.088f);
                instancePath.lineTo(45.0f, 45.088234f);
                instancePath.lineTo(45.0f, 48.05294f);
                instancePath.lineTo(37.542f, 48.052f);
                instancePath.lineTo(37.54292f, 52.5f);
                instancePath.lineTo(34.457207f, 52.5f);
                instancePath.lineTo(34.457f, 48.052f);
                instancePath.lineTo(27.0f, 48.05294f);
                instancePath.lineTo(27.0f, 45.088234f);
                instancePath.lineTo(34.457f, 45.088f);
                instancePath.lineTo(34.457f, 42.37f);
                instancePath.lineTo(27.0f, 42.370617f);
                instancePath.lineTo(27.0f, 39.405914f);
                instancePath.lineTo(31.113f, 39.405f);
                instancePath.lineTo(27.0f, 31.5f);
                instancePath.lineTo(30.857143f, 31.5f);
                instancePath.close();
                instancePath.moveTo(37.218414f, 9.541518f);
                instancePath.lineTo(61.218414f, 20.208185f);
                instancePath.cubicTo(62.3018f, 20.689688f, 63.0f, 21.764053f, 63.0f, 22.94962f);
                instancePath.lineTo(63.0f, 27.0f);
                instancePath.lineTo(9.0f, 27.0f);
                instancePath.lineTo(9.0f, 22.94962f);
                instancePath.cubicTo(9.0f, 21.764053f, 9.6982f, 20.689688f, 10.781585f, 20.208185f);
                instancePath.lineTo(34.781586f, 9.541518f);
                instancePath.cubicTo(35.55728f, 9.196764f, 36.44272f, 9.196764f, 37.218414f, 9.541518f);
                instancePath.close();
                instancePath.moveTo(36.07369f, 12.906794f);
                instancePath.lineTo(12.6f, 23.339542f);
                instancePath.lineTo(12.6f, 23.4f);
                instancePath.lineTo(59.3067f, 23.4f);
                instancePath.lineTo(36.07369f, 12.906794f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
