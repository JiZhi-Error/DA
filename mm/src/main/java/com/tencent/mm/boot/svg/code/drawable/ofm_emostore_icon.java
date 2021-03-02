package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ofm_emostore_icon extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 16.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(24.45f, 1.72f);
                instancePath.cubicTo(40.07f, -2.09f, 57.26f, 8.51f, 60.97f, 24.12f);
                instancePath.cubicTo(65.19f, 38.86f, 56.54f, 55.72f, 42.15f, 60.92f);
                instancePath.cubicTo(28.52f, 66.5f, 11.52f, 60.56f, 4.31f, 47.73f);
                instancePath.cubicTo(-2.87f, 36.0f, -0.8f, 19.65f, 9.09f, 10.08f);
                instancePath.cubicTo(13.27f, 5.9f, 18.67f, 2.96f, 24.45f, 1.72f);
                instancePath.lineTo(24.45f, 1.72f);
                instancePath.close();
                instancePath.moveTo(17.17f, 17.07f);
                instancePath.cubicTo(13.49f, 18.92f, 13.95f, 25.17f, 17.95f, 26.36f);
                instancePath.cubicTo(21.46f, 27.53f, 24.61f, 23.5f, 23.56f, 20.23f);
                instancePath.cubicTo(23.05f, 17.48f, 19.71f, 15.55f, 17.17f, 17.07f);
                instancePath.lineTo(17.17f, 17.07f);
                instancePath.close();
                instancePath.moveTo(41.36f, 17.28f);
                instancePath.cubicTo(38.2f, 19.32f, 38.58f, 24.76f, 42.09f, 26.21f);
                instancePath.cubicTo(45.34f, 27.7f, 48.8f, 24.25f, 48.24f, 20.98f);
                instancePath.cubicTo(48.14f, 17.74f, 44.14f, 15.22f, 41.36f, 17.28f);
                instancePath.lineTo(41.36f, 17.28f);
                instancePath.close();
                instancePath.moveTo(10.9f, 36.58f);
                instancePath.cubicTo(12.04f, 40.99f, 14.08f, 45.33f, 17.62f, 48.33f);
                instancePath.cubicTo(23.73f, 53.55f, 32.94f, 54.15f, 40.17f, 51.04f);
                instancePath.cubicTo(46.02f, 48.47f, 49.67f, 42.62f, 51.09f, 36.57f);
                instancePath.cubicTo(44.43f, 35.73f, 37.76f, 34.82f, 31.03f, 34.74f);
                instancePath.cubicTo(24.29f, 34.82f, 17.59f, 35.73f, 10.9f, 36.58f);
                instancePath.lineTo(10.9f, 36.58f);
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
