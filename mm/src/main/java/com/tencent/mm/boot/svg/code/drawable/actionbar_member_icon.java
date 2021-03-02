package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class actionbar_member_icon extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 23.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(2.11f, 1.14f);
                instancePath.cubicTo(21.75f, 0.82f, 41.42f, 1.08f, 61.06f, 1.0f);
                instancePath.cubicTo(62.34f, 0.79f, 64.15f, 1.37f, 63.95f, 2.98f);
                instancePath.cubicTo(64.04f, 17.98f, 64.03f, 33.0f, 63.95f, 48.01f);
                instancePath.cubicTo(64.14f, 49.6f, 62.39f, 50.21f, 61.11f, 49.99f);
                instancePath.cubicTo(41.73f, 49.98f, 22.35f, 50.07f, 2.97f, 49.95f);
                instancePath.cubicTo(1.37f, 50.15f, 0.79f, 48.35f, 1.0f, 47.09f);
                instancePath.cubicTo(0.98f, 33.07f, 1.02f, 19.04f, 0.99f, 5.01f);
                instancePath.cubicTo(1.1f, 3.66f, 0.63f, 1.9f, 2.11f, 1.14f);
                instancePath.lineTo(2.11f, 1.14f);
                instancePath.close();
                instancePath.moveTo(40.12f, 8.16f);
                instancePath.cubicTo(39.87f, 8.41f, 39.38f, 8.92f, 39.13f, 9.18f);
                instancePath.cubicTo(38.91f, 14.42f, 38.89f, 19.7f, 39.14f, 24.95f);
                instancePath.cubicTo(39.4f, 25.18f, 39.93f, 25.63f, 40.2f, 25.86f);
                instancePath.cubicTo(45.41f, 26.11f, 50.67f, 26.09f, 55.88f, 25.87f);
                instancePath.cubicTo(56.13f, 25.62f, 56.61f, 25.12f, 56.85f, 24.87f);
                instancePath.cubicTo(57.11f, 19.64f, 57.11f, 14.35f, 56.85f, 9.12f);
                instancePath.cubicTo(56.61f, 8.87f, 56.13f, 8.39f, 55.89f, 8.15f);
                instancePath.cubicTo(50.65f, 7.9f, 45.36f, 7.88f, 40.12f, 8.16f);
                instancePath.lineTo(40.12f, 8.16f);
                instancePath.close();
                instancePath.moveTo(7.15f, 27.14f);
                instancePath.cubicTo(7.13f, 27.81f, 7.1f, 29.15f, 7.08f, 29.82f);
                instancePath.cubicTo(16.02f, 30.11f, 24.98f, 30.13f, 33.91f, 29.81f);
                instancePath.cubicTo(33.89f, 29.14f, 33.86f, 27.82f, 33.84f, 27.15f);
                instancePath.cubicTo(24.95f, 26.9f, 16.04f, 26.91f, 7.15f, 27.14f);
                instancePath.lineTo(7.15f, 27.14f);
                instancePath.close();
                instancePath.moveTo(7.1f, 37.16f);
                instancePath.cubicTo(7.12f, 37.84f, 7.14f, 39.19f, 7.15f, 39.87f);
                instancePath.cubicTo(16.06f, 40.06f, 24.99f, 40.14f, 33.9f, 39.82f);
                instancePath.cubicTo(33.88f, 39.15f, 33.84f, 37.79f, 33.82f, 37.12f);
                instancePath.cubicTo(24.92f, 36.94f, 16.0f, 36.88f, 7.1f, 37.16f);
                instancePath.lineTo(7.1f, 37.16f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(42.3f, 11.32f);
                instancePath2.cubicTo(46.01f, 10.77f, 49.94f, 10.79f, 53.66f, 11.31f);
                instancePath2.cubicTo(54.26f, 15.03f, 54.2f, 18.98f, 53.69f, 22.72f);
                instancePath2.cubicTo(49.93f, 23.17f, 46.01f, 23.26f, 42.28f, 22.68f);
                instancePath2.cubicTo(41.82f, 18.94f, 41.77f, 15.04f, 42.3f, 11.32f);
                instancePath2.lineTo(42.3f, 11.32f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
