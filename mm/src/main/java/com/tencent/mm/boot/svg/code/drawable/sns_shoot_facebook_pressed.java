package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sns_shoot_facebook_pressed extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 4.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-11962667);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.04f, 6.94f);
                instancePath.cubicTo(8.881784E-16f, 2.86f, 4.0f, -0.44f, 7.99f, 0.0f);
                instancePath.cubicTo(20.37f, 0.04f, 32.75f, -0.07f, 45.12f, 0.05f);
                instancePath.cubicTo(48.71f, 0.04f, 51.97f, 3.27f, 51.94f, 6.87f);
                instancePath.cubicTo(52.12f, 18.57f, 51.89f, 30.28f, 52.04f, 41.99f);
                instancePath.cubicTo(46.03f, 42.0f, 40.01f, 42.01f, 34.0f, 41.99f);
                instancePath.lineTo(34.0f, 36.0f);
                instancePath.cubicTo(36.66f, 36.01f, 39.33f, 35.99f, 42.0f, 36.0f);
                instancePath.lineTo(42.0f, 26.0f);
                instancePath.cubicTo(39.33f, 26.01f, 36.65f, 25.99f, 33.98f, 26.0f);
                instancePath.cubicTo(33.98f, 23.98f, 33.91f, 21.94f, 34.17f, 19.93f);
                instancePath.cubicTo(35.74f, 17.24f, 39.43f, 18.28f, 42.0f, 17.94f);
                instancePath.lineTo(42.0f, 8.01f);
                instancePath.cubicTo(36.9f, 8.27f, 30.84f, 6.82f, 26.7f, 10.63f);
                instancePath.cubicTo(22.53f, 14.63f, 24.4f, 20.89f, 24.01f, 26.0f);
                instancePath.lineTo(18.0f, 26.0f);
                instancePath.lineTo(18.0f, 36.0f);
                instancePath.lineTo(24.0f, 36.0f);
                instancePath.cubicTo(24.0f, 38.0f, 23.99f, 39.99f, 24.0f, 41.99f);
                instancePath.cubicTo(15.99f, 42.0f, 7.97f, 42.0f, -0.04f, 41.99f);
                instancePath.cubicTo(0.09f, 30.31f, -0.1f, 18.62f, 0.04f, 6.94f);
                instancePath.lineTo(0.04f, 6.94f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-9398565);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 42.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(-0.04f, -0.01f);
                instancePath2.cubicTo(7.97f, 0.0f, 15.99f, 0.0f, 24.0f, -0.01f);
                instancePath2.lineTo(24.0f, 10.0f);
                instancePath2.cubicTo(17.69f, 9.83f, 11.35f, 10.34f, 5.07f, 9.75f);
                instancePath2.cubicTo(0.85f, 8.58f, -0.57f, 3.92f, -0.04f, -0.01f);
                instancePath2.lineTo(-0.04f, -0.01f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(34.0f, -0.01f);
                instancePath3.cubicTo(40.01f, 0.01f, 46.03f, 0.0f, 52.04f, -0.01f);
                instancePath3.cubicTo(52.55f, 3.89f, 51.21f, 8.51f, 47.03f, 9.72f);
                instancePath3.cubicTo(42.72f, 10.34f, 38.34f, 9.85f, 34.0f, 10.0f);
                instancePath3.lineTo(34.0f, -0.01f);
                instancePath3.lineTo(34.0f, -0.01f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
