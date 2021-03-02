package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class userguide_google_icon extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 13.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-2603989);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(5.3f, 1.27f);
                instancePath.cubicTo(23.86f, 0.64f, 42.5f, 1.17f, 61.09f, 1.0f);
                instancePath.cubicTo(64.55f, 0.58f, 68.06f, 3.32f, 67.96f, 6.91f);
                instancePath.cubicTo(68.02f, 25.29f, 68.04f, 43.68f, 67.95f, 62.05f);
                instancePath.cubicTo(68.09f, 65.66f, 64.55f, 68.44f, 61.08f, 68.0f);
                instancePath.cubicTo(43.04f, 67.97f, 25.0f, 68.06f, 6.96f, 67.96f);
                instancePath.cubicTo(3.79f, 68.07f, 0.96f, 65.23f, 1.04f, 62.07f);
                instancePath.cubicTo(0.94f, 44.03f, 1.03f, 25.99f, 0.99f, 7.95f);
                instancePath.cubicTo(0.72f, 5.07f, 2.4f, 2.01f, 5.3f, 1.27f);
                instancePath.lineTo(5.3f, 1.27f);
                instancePath.close();
                instancePath.moveTo(29.0f, 8.97f);
                instancePath.cubicTo(22.26f, 10.71f, 17.07f, 18.36f, 19.85f, 25.17f);
                instancePath.cubicTo(21.77f, 30.46f, 27.73f, 32.84f, 33.01f, 32.22f);
                instancePath.cubicTo(32.1f, 34.88f, 32.92f, 37.5f, 34.54f, 39.66f);
                instancePath.cubicTo(29.02f, 40.04f, 22.96f, 40.74f, 18.68f, 44.65f);
                instancePath.cubicTo(15.73f, 47.26f, 14.46f, 51.93f, 16.58f, 55.44f);
                instancePath.cubicTo(19.11f, 59.71f, 24.39f, 61.19f, 29.04f, 61.46f);
                instancePath.cubicTo(35.32f, 61.82f, 42.32f, 60.5f, 46.74f, 55.67f);
                instancePath.cubicTo(49.75f, 52.48f, 50.77f, 47.34f, 48.54f, 43.44f);
                instancePath.cubicTo(46.49f, 39.88f, 42.63f, 38.04f, 39.9f, 35.12f);
                instancePath.cubicTo(38.9f, 34.03f, 39.19f, 32.23f, 40.15f, 31.21f);
                instancePath.cubicTo(42.52f, 28.58f, 46.03f, 26.66f, 46.91f, 22.97f);
                instancePath.cubicTo(48.39f, 18.27f, 46.03f, 13.4f, 42.37f, 10.46f);
                instancePath.cubicTo(45.62f, 11.0f, 48.58f, 9.74f, 51.23f, 7.96f);
                instancePath.cubicTo(43.83f, 8.25f, 36.24f, 7.08f, 29.0f, 8.97f);
                instancePath.lineTo(29.0f, 8.97f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(30.39f, 10.46f);
                instancePath2.cubicTo(37.68f, 9.08f, 41.32f, 18.06f, 40.97f, 24.02f);
                instancePath2.cubicTo(41.1f, 28.74f, 35.38f, 31.73f, 31.38f, 29.6f);
                instancePath2.cubicTo(27.25f, 27.37f, 25.62f, 22.34f, 25.41f, 17.92f);
                instancePath2.cubicTo(25.14f, 14.69f, 27.06f, 11.17f, 30.39f, 10.46f);
                instancePath2.lineTo(30.39f, 10.46f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(28.36f, 42.65f);
                instancePath3.cubicTo(31.79f, 41.97f, 36.04f, 40.46f, 39.05f, 43.01f);
                instancePath3.cubicTo(41.67f, 45.0f, 45.06f, 47.3f, 44.93f, 51.0f);
                instancePath3.cubicTo(45.04f, 54.16f, 42.63f, 56.84f, 39.72f, 57.75f);
                instancePath3.cubicTo(35.53f, 59.02f, 30.82f, 58.82f, 26.8f, 57.05f);
                instancePath3.cubicTo(23.72f, 55.7f, 21.3f, 52.47f, 21.88f, 48.99f);
                instancePath3.cubicTo(22.26f, 45.66f, 25.35f, 43.49f, 28.36f, 42.65f);
                instancePath3.lineTo(28.36f, 42.65f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-1);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 7.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint7, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(14.0f, 1.97f);
                instancePath4.cubicTo(21.24f, 0.08f, 28.83f, 1.25f, 36.23f, 0.96f);
                instancePath4.cubicTo(33.58f, 2.74f, 30.62f, 4.0f, 27.37f, 3.46f);
                instancePath4.cubicTo(31.03f, 6.4f, 33.39f, 11.27f, 31.91f, 15.97f);
                instancePath4.cubicTo(31.03f, 19.66f, 27.52f, 21.58f, 25.15f, 24.21f);
                instancePath4.cubicTo(24.19f, 25.23f, 23.9f, 27.03f, 24.9f, 28.12f);
                instancePath4.cubicTo(27.63f, 31.04f, 31.49f, 32.88f, 33.54f, 36.44f);
                instancePath4.cubicTo(35.77f, 40.34f, 34.75f, 45.48f, 31.74f, 48.67f);
                instancePath4.cubicTo(27.32f, 53.5f, 20.32f, 54.82f, 14.04f, 54.46f);
                instancePath4.cubicTo(9.39f, 54.19f, 4.11f, 52.71f, 1.58f, 48.44f);
                instancePath4.cubicTo(-0.54f, 44.93f, 0.73f, 40.26f, 3.68f, 37.65f);
                instancePath4.cubicTo(7.96f, 33.74f, 14.02f, 33.04f, 19.54f, 32.66f);
                instancePath4.cubicTo(17.92f, 30.5f, 17.1f, 27.88f, 18.01f, 25.22f);
                instancePath4.cubicTo(12.73f, 25.84f, 6.77f, 23.46f, 4.85f, 18.17f);
                instancePath4.cubicTo(2.07f, 11.36f, 7.26f, 3.71f, 14.0f, 1.97f);
                instancePath4.lineTo(14.0f, 1.97f);
                instancePath4.close();
                instancePath4.moveTo(15.39f, 3.46f);
                instancePath4.cubicTo(12.06f, 4.17f, 10.14f, 7.69f, 10.41f, 10.92f);
                instancePath4.cubicTo(10.62f, 15.34f, 12.25f, 20.37f, 16.38f, 22.6f);
                instancePath4.cubicTo(20.38f, 24.73f, 26.1f, 21.74f, 25.97f, 17.02f);
                instancePath4.cubicTo(26.32f, 11.06f, 22.68f, 2.08f, 15.39f, 3.46f);
                instancePath4.lineTo(15.39f, 3.46f);
                instancePath4.close();
                instancePath4.moveTo(13.36f, 35.65f);
                instancePath4.cubicTo(10.35f, 36.49f, 7.26f, 38.66f, 6.88f, 41.99f);
                instancePath4.cubicTo(6.3f, 45.47f, 8.72f, 48.7f, 11.8f, 50.05f);
                instancePath4.cubicTo(15.82f, 51.82f, 20.53f, 52.02f, 24.72f, 50.75f);
                instancePath4.cubicTo(27.63f, 49.84f, 30.04f, 47.16f, 29.93f, 44.0f);
                instancePath4.cubicTo(30.06f, 40.3f, 26.67f, 38.0f, 24.05f, 36.01f);
                instancePath4.cubicTo(21.04f, 33.46f, 16.79f, 34.97f, 13.36f, 35.65f);
                instancePath4.lineTo(13.36f, 35.65f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint8);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}