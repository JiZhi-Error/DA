package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class menu_exit_icon extends c {
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
                instancePaint3.setColor(-6710887);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(32.15f, 1.21f);
                instancePath.cubicTo(35.31f, 0.04f, 39.4f, 2.29f, 38.97f, 5.93f);
                instancePath.cubicTo(38.98f, 15.62f, 39.11f, 25.32f, 38.91f, 35.01f);
                instancePath.cubicTo(38.66f, 40.35f, 29.36f, 40.37f, 29.1f, 35.03f);
                instancePath.cubicTo(28.84f, 25.66f, 29.08f, 16.28f, 28.99f, 6.91f);
                instancePath.cubicTo(28.75f, 4.59f, 29.67f, 1.89f, 32.15f, 1.21f);
                instancePath.lineTo(32.15f, 1.21f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(10.5f, 14.5f);
                instancePath2.cubicTo(13.31f, 12.04f, 18.2f, 14.27f, 18.4f, 17.95f);
                instancePath2.cubicTo(18.76f, 20.52f, 16.55f, 22.3f, 15.2f, 24.19f);
                instancePath2.cubicTo(10.43f, 29.93f, 8.89f, 38.04f, 10.82f, 45.2f);
                instancePath2.cubicTo(12.8f, 52.84f, 18.84f, 59.26f, 26.33f, 61.74f);
                instancePath2.cubicTo(34.52f, 64.55f, 44.17f, 62.52f, 50.42f, 56.49f);
                instancePath2.cubicTo(56.65f, 50.76f, 59.37f, 41.62f, 57.34f, 33.41f);
                instancePath2.cubicTo(56.41f, 29.04f, 53.92f, 25.26f, 50.99f, 21.97f);
                instancePath2.cubicTo(49.54f, 20.48f, 48.99f, 18.13f, 50.02f, 16.26f);
                instancePath2.cubicTo(51.35f, 13.27f, 55.79f, 12.49f, 57.98f, 14.96f);
                instancePath2.cubicTo(66.34f, 23.07f, 69.85f, 35.71f, 67.04f, 47.0f);
                instancePath2.cubicTo(63.74f, 61.51f, 49.98f, 72.8f, 35.06f, 72.95f);
                instancePath2.cubicTo(20.81f, 73.68f, 6.93f, 64.23f, 2.13f, 50.83f);
                instancePath2.cubicTo(-2.61f, 38.49f, 0.77f, 23.49f, 10.5f, 14.5f);
                instancePath2.lineTo(10.5f, 14.5f);
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
