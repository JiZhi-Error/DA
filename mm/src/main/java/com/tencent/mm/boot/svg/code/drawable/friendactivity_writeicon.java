package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class friendactivity_writeicon extends c {
    private final int height = 36;
    private final int width = 40;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 40;
            case 1:
                return 36;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix instanceMatrix = c.instanceMatrix(looper);
                float[] instanceMatrixArray = c.instanceMatrixArray(looper);
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
                instancePaint3.setColor(-11048043);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(2.95f, 1.02f);
                instancePath.cubicTo(12.96f, 0.94f, 22.98f, 1.06f, 32.99f, 0.97f);
                instancePath.cubicTo(34.31f, 1.13f, 36.14f, 0.52f, 36.9f, 2.0f);
                instancePath.cubicTo(37.18f, 8.98f, 36.88f, 15.98f, 37.03f, 22.97f);
                instancePath.cubicTo(36.86f, 24.28f, 37.48f, 26.12f, 36.02f, 26.9f);
                instancePath.cubicTo(28.94f, 27.17f, 21.85f, 26.9f, 14.76f, 27.0f);
                instancePath.cubicTo(12.19f, 28.76f, 9.6f, 30.48f, 7.0f, 32.2f);
                instancePath.cubicTo(7.0f, 30.47f, 6.99f, 28.75f, 7.0f, 27.02f);
                instancePath.cubicTo(5.09f, 26.72f, 2.45f, 27.83f, 1.1f, 26.03f);
                instancePath.cubicTo(0.84f, 18.67f, 1.09f, 11.3f, 0.98f, 3.93f);
                instancePath.cubicTo(0.79f, 2.67f, 1.23f, 0.69f, 2.95f, 1.02f);
                instancePath.close();
                instancePath.moveTo(5.0f, 5.0f);
                instancePath.lineTo(5.0f, 23.0f);
                instancePath.lineTo(9.99f, 23.0f);
                instancePath.cubicTo(9.99f, 23.67f, 10.0f, 25.03f, 10.0f, 25.7f);
                instancePath.cubicTo(10.93f, 24.8f, 11.84f, 23.9f, 12.75f, 22.99f);
                instancePath.cubicTo(19.5f, 23.01f, 26.25f, 23.0f, 33.0f, 23.0f);
                instancePath.lineTo(33.0f, 5.0f);
                instancePath.lineTo(5.0f, 5.0f);
                instancePath.lineTo(5.0f, 5.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
