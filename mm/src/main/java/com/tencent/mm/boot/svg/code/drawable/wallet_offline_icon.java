package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wallet_offline_icon extends c {
    private final int height = 114;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 114;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(31.3f, 6.11f);
                instancePath.cubicTo(44.62f, 0.43f, 59.82f, -1.95f, 73.98f, 1.96f);
                instancePath.cubicTo(85.05f, 4.16f, 95.23f, 9.86f, 103.34f, 17.64f);
                instancePath.cubicTo(105.35f, 19.71f, 107.31f, 21.96f, 108.27f, 24.73f);
                instancePath.cubicTo(111.19f, 26.97f, 112.68f, 30.47f, 114.14f, 33.73f);
                instancePath.cubicTo(116.27f, 39.25f, 117.71f, 45.09f, 117.98f, 51.01f);
                instancePath.cubicTo(118.1f, 66.31f, 110.63f, 81.33f, 98.54f, 90.67f);
                instancePath.cubicTo(82.94f, 102.73f, 61.47f, 107.08f, 42.46f, 101.71f);
                instancePath.cubicTo(37.89f, 104.36f, 33.57f, 107.93f, 28.21f, 108.79f);
                instancePath.cubicTo(23.18f, 109.03f, 17.53f, 106.08f, 16.44f, 100.83f);
                instancePath.cubicTo(14.89f, 96.95f, 16.66f, 92.98f, 17.63f, 89.2f);
                instancePath.cubicTo(6.39f, 79.52f, -0.43f, 64.82f, 0.06f, 49.94f);
                instancePath.cubicTo(0.93f, 40.35f, 3.95f, 30.68f, 10.07f, 23.11f);
                instancePath.cubicTo(15.38f, 15.59f, 23.16f, 10.19f, 31.3f, 6.11f);
                instancePath.lineTo(31.3f, 6.11f);
                instancePath.close();
                instancePath.moveTo(23.8f, 22.8f);
                instancePath.cubicTo(15.5f, 30.11f, 9.91f, 40.79f, 10.01f, 51.99f);
                instancePath.cubicTo(9.91f, 63.91f, 16.18f, 75.3f, 25.44f, 82.59f);
                instancePath.cubicTo(26.71f, 83.71f, 28.7f, 84.87f, 28.23f, 86.89f);
                instancePath.cubicTo(27.62f, 90.62f, 26.08f, 94.16f, 25.66f, 97.93f);
                instancePath.cubicTo(26.02f, 98.22f, 26.73f, 98.79f, 27.09f, 99.08f);
                instancePath.cubicTo(31.69f, 97.16f, 35.6f, 93.86f, 40.14f, 91.8f);
                instancePath.cubicTo(41.61f, 91.15f, 43.19f, 91.92f, 44.66f, 92.18f);
                instancePath.cubicTo(59.35f, 96.1f, 75.76f, 93.85f, 88.57f, 85.54f);
                instancePath.cubicTo(97.91f, 79.53f, 105.25f, 69.96f, 107.33f, 58.92f);
                instancePath.cubicTo(109.16f, 49.91f, 107.17f, 40.38f, 102.45f, 32.55f);
                instancePath.cubicTo(83.81f, 43.6f, 65.19f, 54.69f, 46.55f, 65.76f);
                instancePath.cubicTo(44.97f, 67.15f, 42.13f, 66.9f, 41.31f, 64.79f);
                instancePath.cubicTo(38.22f, 58.02f, 35.2f, 51.2f, 32.26f, 44.37f);
                instancePath.cubicTo(31.62f, 43.17f, 32.58f, 41.75f, 33.95f, 41.89f);
                instancePath.cubicTo(38.05f, 44.43f, 41.65f, 47.71f, 45.75f, 50.26f);
                instancePath.cubicTo(47.37f, 51.29f, 49.33f, 50.62f, 50.91f, 49.86f);
                instancePath.cubicTo(66.94f, 42.47f, 83.01f, 35.17f, 99.04f, 27.78f);
                instancePath.cubicTo(80.89f, 6.03f, 44.78f, 4.14f, 23.8f, 22.8f);
                instancePath.lineTo(23.8f, 22.8f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-16598272);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 10.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(13.8f, 12.8f);
                instancePath2.cubicTo(34.78f, -5.86f, 70.89f, -3.97f, 89.04f, 17.78f);
                instancePath2.cubicTo(73.01f, 25.17f, 56.94f, 32.47f, 40.91f, 39.86f);
                instancePath2.cubicTo(39.33f, 40.62f, 37.37f, 41.29f, 35.75f, 40.26f);
                instancePath2.cubicTo(31.65f, 37.71f, 28.05f, 34.43f, 23.95f, 31.89f);
                instancePath2.cubicTo(22.58f, 31.75f, 21.62f, 33.17f, 22.26f, 34.37f);
                instancePath2.cubicTo(25.2f, 41.2f, 28.22f, 48.02f, 31.31f, 54.79f);
                instancePath2.cubicTo(32.13f, 56.9f, 34.97f, 57.15f, 36.55f, 55.76f);
                instancePath2.cubicTo(55.19f, 44.69f, 73.81f, 33.6f, 92.45f, 22.55f);
                instancePath2.cubicTo(97.17f, 30.38f, 99.16f, 39.91f, 97.33f, 48.92f);
                instancePath2.cubicTo(95.25f, 59.96f, 87.91f, 69.53f, 78.57f, 75.54f);
                instancePath2.cubicTo(65.76f, 83.85f, 49.35f, 86.1f, 34.66f, 82.18f);
                instancePath2.cubicTo(33.19f, 81.92f, 31.61f, 81.15f, 30.14f, 81.8f);
                instancePath2.cubicTo(25.6f, 83.86f, 21.69f, 87.16f, 17.09f, 89.08f);
                instancePath2.cubicTo(16.73f, 88.79f, 16.02f, 88.22f, 15.66f, 87.93f);
                instancePath2.cubicTo(16.08f, 84.16f, 17.62f, 80.62f, 18.23f, 76.89f);
                instancePath2.cubicTo(18.7f, 74.87f, 16.71f, 73.71f, 15.44f, 72.59f);
                instancePath2.cubicTo(6.18f, 65.3f, -0.09f, 53.91f, 0.01f, 41.99f);
                instancePath2.cubicTo(-0.09f, 30.79f, 5.5f, 20.11f, 13.8f, 12.8f);
                instancePath2.lineTo(13.8f, 12.8f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
