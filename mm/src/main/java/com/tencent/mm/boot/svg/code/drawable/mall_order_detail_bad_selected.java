package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class mall_order_detail_bad_selected extends c {
    private final int height = 132;
    private final int width = 132;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 132;
            case 1:
                return 132;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-7822636);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(63.08f, 0.0f);
                instancePath.lineTo(68.64f, 0.0f);
                instancePath.cubicTo(86.01f, 0.73f, 102.96f, 8.52f, 114.65f, 21.42f);
                instancePath.cubicTo(125.1f, 32.69f, 131.2f, 47.7f, 132.0f, 63.02f);
                instancePath.lineTo(132.0f, 68.71f);
                instancePath.cubicTo(131.26f, 85.08f, 124.34f, 101.1f, 112.68f, 112.64f);
                instancePath.cubicTo(101.21f, 124.27f, 85.29f, 131.18f, 69.0f, 132.0f);
                instancePath.lineTo(63.29f, 132.0f);
                instancePath.cubicTo(45.93f, 131.25f, 29.0f, 123.46f, 17.34f, 110.56f);
                instancePath.cubicTo(6.91f, 99.32f, 0.82f, 84.33f, 0.0f, 69.05f);
                instancePath.lineTo(0.0f, 63.01f);
                instancePath.cubicTo(0.8f, 47.69f, 6.91f, 32.67f, 17.37f, 21.41f);
                instancePath.cubicTo(28.99f, 8.57f, 45.82f, 0.84f, 63.08f, 0.0f);
                instancePath.lineTo(63.08f, 0.0f);
                instancePath.close();
                instancePath.moveTo(43.12f, 44.22f);
                instancePath.cubicTo(39.58f, 45.31f, 38.89f, 49.56f, 40.43f, 52.55f);
                instancePath.cubicTo(39.08f, 53.81f, 37.32f, 55.04f, 37.23f, 57.08f);
                instancePath.cubicTo(36.88f, 58.97f, 38.19f, 60.52f, 38.97f, 62.1f);
                instancePath.cubicTo(37.38f, 63.66f, 35.52f, 65.5f, 36.06f, 67.97f);
                instancePath.cubicTo(36.21f, 70.17f, 38.12f, 71.4f, 39.79f, 72.48f);
                instancePath.cubicTo(38.62f, 73.82f, 37.05f, 75.11f, 37.02f, 77.05f);
                instancePath.cubicTo(36.65f, 80.31f, 39.66f, 83.26f, 42.9f, 82.97f);
                instancePath.cubicTo(49.86f, 83.07f, 56.81f, 82.96f, 63.77f, 82.99f);
                instancePath.cubicTo(62.15f, 89.22f, 62.4f, 95.81f, 64.01f, 102.01f);
                instancePath.cubicTo(64.64f, 105.52f, 68.51f, 108.13f, 71.97f, 107.48f);
                instancePath.cubicTo(73.7f, 106.68f, 73.45f, 104.59f, 73.46f, 103.04f);
                instancePath.cubicTo(73.1f, 97.44f, 73.59f, 91.53f, 76.6f, 86.65f);
                instancePath.cubicTo(79.18f, 82.72f, 83.06f, 78.77f, 88.1f, 78.81f);
                instancePath.cubicTo(89.99f, 78.29f, 92.79f, 78.99f, 93.82f, 76.88f);
                instancePath.cubicTo(94.27f, 70.61f, 93.86f, 64.31f, 94.0f, 58.03f);
                instancePath.cubicTo(93.87f, 54.64f, 94.55f, 51.09f, 93.2f, 47.87f);
                instancePath.cubicTo(84.14f, 49.17f, 76.71f, 42.55f, 67.96f, 41.85f);
                instancePath.cubicTo(59.66f, 40.97f, 51.07f, 41.6f, 43.12f, 44.22f);
                instancePath.lineTo(43.12f, 44.22f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 35.0f, 0.0f, 1.0f, 41.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(8.12f, 3.22f);
                instancePath2.cubicTo(16.07f, 0.6f, 24.66f, -0.03f, 32.96f, 0.85f);
                instancePath2.cubicTo(41.71f, 1.55f, 49.14f, 8.17f, 58.2f, 6.87f);
                instancePath2.cubicTo(59.55f, 10.09f, 58.87f, 13.64f, 59.0f, 17.03f);
                instancePath2.cubicTo(58.86f, 23.31f, 59.27f, 29.61f, 58.82f, 35.88f);
                instancePath2.cubicTo(57.79f, 37.99f, 54.99f, 37.29f, 53.1f, 37.81f);
                instancePath2.cubicTo(48.06f, 37.77f, 44.18f, 41.72f, 41.6f, 45.65f);
                instancePath2.cubicTo(38.59f, 50.53f, 38.1f, 56.44f, 38.46f, 62.04f);
                instancePath2.cubicTo(38.45f, 63.59f, 38.7f, 65.68f, 36.97f, 66.48f);
                instancePath2.cubicTo(33.51f, 67.13f, 29.64f, 64.52f, 29.01f, 61.01f);
                instancePath2.cubicTo(27.4f, 54.81f, 27.15f, 48.22f, 28.77f, 41.99f);
                instancePath2.cubicTo(21.81f, 41.96f, 14.86f, 42.07f, 7.9f, 41.97f);
                instancePath2.cubicTo(4.66f, 42.26f, 1.65f, 39.31f, 2.02f, 36.05f);
                instancePath2.cubicTo(2.05f, 34.11f, 3.62f, 32.82f, 4.79f, 31.48f);
                instancePath2.cubicTo(3.12f, 30.4f, 1.21f, 29.17f, 1.06f, 26.97f);
                instancePath2.cubicTo(0.52f, 24.5f, 2.38f, 22.66f, 3.97f, 21.1f);
                instancePath2.cubicTo(3.19f, 19.52f, 1.88f, 17.97f, 2.23f, 16.08f);
                instancePath2.cubicTo(2.32f, 14.04f, 4.08f, 12.81f, 5.43f, 11.55f);
                instancePath2.cubicTo(3.89f, 8.56f, 4.58f, 4.31f, 8.12f, 3.22f);
                instancePath2.lineTo(8.12f, 3.22f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
