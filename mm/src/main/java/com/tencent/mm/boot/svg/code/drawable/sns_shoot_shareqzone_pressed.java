package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sns_shoot_shareqzone_pressed extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                instancePaint3.setColor(-16384);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(20.01f, 18.99f);
                instancePath.cubicTo(22.68f, 12.67f, 25.33f, 6.34f, 28.0f, 0.02f);
                instancePath.cubicTo(30.67f, 6.34f, 33.33f, 12.67f, 36.0f, 18.99f);
                instancePath.cubicTo(42.66f, 19.7f, 49.32f, 20.31f, 55.98f, 21.01f);
                instancePath.cubicTo(51.33f, 26.03f, 46.64f, 31.0f, 42.0f, 36.02f);
                instancePath.cubicTo(43.34f, 42.68f, 44.66f, 49.33f, 46.0f, 55.99f);
                instancePath.cubicTo(39.98f, 52.68f, 34.01f, 49.31f, 27.99f, 46.01f);
                instancePath.cubicTo(22.32f, 49.34f, 16.66f, 52.67f, 10.99f, 56.0f);
                instancePath.cubicTo(12.34f, 49.34f, 13.66f, 42.68f, 15.0f, 36.02f);
                instancePath.cubicTo(10.03f, 31.0f, 5.0f, 26.03f, 0.02f, 21.01f);
                instancePath.cubicTo(6.68f, 20.31f, 13.35f, 19.7f, 20.01f, 18.99f);
                instancePath.lineTo(20.01f, 18.99f);
                instancePath.close();
                instancePath.moveTo(14.0f, 22.0f);
                instancePath.lineTo(14.0f, 24.0f);
                instancePath.cubicTo(20.66f, 24.01f, 27.33f, 23.99f, 33.99f, 24.0f);
                instancePath.cubicTo(28.01f, 29.34f, 22.0f, 34.65f, 16.02f, 40.0f);
                instancePath.lineTo(40.0f, 40.0f);
                instancePath.lineTo(40.0f, 38.0f);
                instancePath.cubicTo(34.67f, 37.99f, 29.35f, 38.01f, 24.02f, 37.99f);
                instancePath.cubicTo(30.0f, 32.65f, 36.01f, 27.34f, 42.0f, 22.0f);
                instancePath.lineTo(14.0f, 22.0f);
                instancePath.lineTo(14.0f, 22.0f);
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
