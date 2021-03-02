package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class receipt_payment_icon extends c {
    private final int height = 88;
    private final int width = 88;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 88;
            case 1:
                return 88;
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
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(20.0f, 53.0f);
                instancePath.lineTo(20.0f, 62.0f);
                instancePath.lineTo(32.0f, 62.0f);
                instancePath.lineTo(32.0f, 68.0f);
                instancePath.lineTo(17.0f, 68.0f);
                instancePath.cubicTo(15.343145f, 68.0f, 14.0f, 66.65685f, 14.0f, 65.0f);
                instancePath.lineTo(14.0f, 65.0f);
                instancePath.lineTo(14.0f, 53.0f);
                instancePath.lineTo(20.0f, 53.0f);
                instancePath.close();
                instancePath.moveTo(74.0f, 53.0f);
                instancePath.lineTo(74.0f, 65.0f);
                instancePath.cubicTo(74.0f, 66.65685f, 72.65685f, 68.0f, 71.0f, 68.0f);
                instancePath.lineTo(56.0f, 68.0f);
                instancePath.lineTo(56.0f, 62.0f);
                instancePath.lineTo(68.0f, 62.0f);
                instancePath.lineTo(68.0f, 53.0f);
                instancePath.lineTo(74.0f, 53.0f);
                instancePath.close();
                instancePath.moveTo(56.72792f, 32.514717f);
                instancePath.lineTo(60.970562f, 36.75736f);
                instancePath.lineTo(41.87868f, 55.849243f);
                instancePath.cubicTo(41.363186f, 56.364735f, 40.706768f, 56.65341f, 40.03344f, 56.71527f);
                instancePath.lineTo(39.84948f, 56.726517f);
                instancePath.lineTo(39.84948f, 56.726517f);
                instancePath.lineTo(39.665237f, 56.726517f);
                instancePath.cubicTo(38.928463f, 56.70402f, 38.198395f, 56.4116f, 37.63604f, 55.849243f);
                instancePath.lineTo(27.029438f, 45.24264f);
                instancePath.lineTo(31.272078f, 41.0f);
                instancePath.lineTo(39.757f, 49.485f);
                instancePath.lineTo(56.72792f, 32.514717f);
                instancePath.close();
                instancePath.moveTo(32.0f, 20.0f);
                instancePath.lineTo(32.0f, 26.0f);
                instancePath.lineTo(20.0f, 26.0f);
                instancePath.lineTo(20.0f, 35.0f);
                instancePath.lineTo(14.0f, 35.0f);
                instancePath.lineTo(14.0f, 23.0f);
                instancePath.cubicTo(14.0f, 21.343145f, 15.343145f, 20.0f, 17.0f, 20.0f);
                instancePath.lineTo(32.0f, 20.0f);
                instancePath.close();
                instancePath.moveTo(71.0f, 20.0f);
                instancePath.cubicTo(72.65685f, 20.0f, 74.0f, 21.343145f, 74.0f, 23.0f);
                instancePath.lineTo(74.0f, 23.0f);
                instancePath.lineTo(74.0f, 35.0f);
                instancePath.lineTo(68.0f, 35.0f);
                instancePath.lineTo(68.0f, 26.0f);
                instancePath.lineTo(56.0f, 26.0f);
                instancePath.lineTo(56.0f, 20.0f);
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
