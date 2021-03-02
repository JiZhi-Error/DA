package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sight_box_delete extends c {
    private final int height = 90;
    private final int width = 90;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(26.43f, 1.68f);
                instancePath.cubicTo(41.46f, -1.69f, 57.9f, 7.14f, 63.51f, 21.45f);
                instancePath.cubicTo(69.44f, 35.22f, 64.39f, 52.55f, 51.99f, 60.97f);
                instancePath.cubicTo(39.83f, 69.86f, 21.65f, 68.7f, 10.73f, 58.32f);
                instancePath.cubicTo(-0.37f, 48.51f, -3.25f, 30.94f, 4.11f, 18.1f);
                instancePath.cubicTo(8.68f, 9.71f, 17.05f, 3.53f, 26.43f, 1.68f);
                instancePath.lineTo(26.43f, 1.68f);
                instancePath.close();
                instancePath.moveTo(20.27f, 23.38f);
                instancePath.cubicTo(23.8f, 26.93f, 27.34f, 30.45f, 30.87f, 34.0f);
                instancePath.cubicTo(27.35f, 37.54f, 23.8f, 41.06f, 20.28f, 44.61f);
                instancePath.cubicTo(20.8f, 45.14f, 21.86f, 46.2f, 22.38f, 46.73f);
                instancePath.cubicTo(25.94f, 43.21f, 29.45f, 39.65f, 33.0f, 36.13f);
                instancePath.cubicTo(36.55f, 39.66f, 40.07f, 43.21f, 43.62f, 46.73f);
                instancePath.cubicTo(44.14f, 46.2f, 45.2f, 45.14f, 45.72f, 44.61f);
                instancePath.cubicTo(42.2f, 41.06f, 38.65f, 37.54f, 35.13f, 34.0f);
                instancePath.cubicTo(38.65f, 30.46f, 42.2f, 26.93f, 45.73f, 23.39f);
                instancePath.cubicTo(45.2f, 22.86f, 44.14f, 21.8f, 43.61f, 21.28f);
                instancePath.cubicTo(40.06f, 24.79f, 36.55f, 28.35f, 33.0f, 31.87f);
                instancePath.cubicTo(29.46f, 28.34f, 25.93f, 24.8f, 22.39f, 21.27f);
                instancePath.cubicTo(21.86f, 21.8f, 20.8f, 22.86f, 20.27f, 23.38f);
                instancePath.lineTo(20.27f, 23.38f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 21.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.27f, 2.38f);
                instancePath2.cubicTo(0.8f, 1.86f, 1.86f, 0.8f, 2.39f, 0.27f);
                instancePath2.cubicTo(5.93f, 3.8f, 9.46f, 7.34f, 13.0f, 10.87f);
                instancePath2.cubicTo(16.55f, 7.35f, 20.06f, 3.79f, 23.61f, 0.28f);
                instancePath2.cubicTo(24.14f, 0.8f, 25.2f, 1.86f, 25.73f, 2.39f);
                instancePath2.cubicTo(22.2f, 5.93f, 18.65f, 9.46f, 15.13f, 13.0f);
                instancePath2.cubicTo(18.65f, 16.54f, 22.2f, 20.06f, 25.72f, 23.61f);
                instancePath2.cubicTo(25.2f, 24.14f, 24.14f, 25.2f, 23.62f, 25.73f);
                instancePath2.cubicTo(20.07f, 22.21f, 16.55f, 18.66f, 13.0f, 15.13f);
                instancePath2.cubicTo(9.45f, 18.65f, 5.94f, 22.21f, 2.38f, 25.73f);
                instancePath2.cubicTo(1.86f, 25.2f, 0.8f, 24.14f, 0.28f, 23.61f);
                instancePath2.cubicTo(3.8f, 20.06f, 7.35f, 16.54f, 10.87f, 13.0f);
                instancePath2.cubicTo(7.34f, 9.45f, 3.8f, 5.93f, 0.27f, 2.38f);
                instancePath2.lineTo(0.27f, 2.38f);
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
