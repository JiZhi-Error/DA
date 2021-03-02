package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class panel_icon_camera extends c {
    private final int height = 192;
    private final int width = 192;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                instancePaint3.setColor(-13421773);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 48.0f, 0.0f, 1.0f, 48.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 18.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(52.114727f, 1.7835636f);
                instancePath.lineTo(58.5f, 12.0f);
                instancePath.lineTo(73.50182f, 12.0f);
                instancePath.cubicTo(75.9866f, 12.0f, 78.0f, 14.012099f, 78.0f, 16.49415f);
                instancePath.lineTo(78.0f, 55.505848f);
                instancePath.cubicTo(78.0f, 57.98341f, 75.98428f, 60.0f, 73.49778f, 60.0f);
                instancePath.lineTo(4.502223f, 60.0f);
                instancePath.cubicTo(2.0064843f, 60.0f, 0.0f, 57.9879f, 0.0f, 55.505848f);
                instancePath.lineTo(0.0f, 16.49415f);
                instancePath.cubicTo(0.0f, 14.016589f, 2.0139031f, 12.0f, 4.4981785f, 12.0f);
                instancePath.lineTo(19.5f, 12.0f);
                instancePath.lineTo(25.885273f, 1.7835636f);
                instancePath.cubicTo(26.502096f, 0.79664683f, 27.944145f, 0.0f, 29.108805f, 0.0f);
                instancePath.lineTo(48.891193f, 0.0f);
                instancePath.cubicTo(50.05917f, 0.0f, 51.49908f, 0.7985287f, 52.114727f, 1.7835636f);
                instancePath.close();
                instancePath.moveTo(39.0f, 51.0f);
                instancePath.cubicTo(48.941124f, 51.0f, 57.0f, 42.941124f, 57.0f, 33.0f);
                instancePath.cubicTo(57.0f, 23.058874f, 48.941124f, 15.0f, 39.0f, 15.0f);
                instancePath.cubicTo(29.058874f, 15.0f, 21.0f, 23.058874f, 21.0f, 33.0f);
                instancePath.cubicTo(21.0f, 42.941124f, 29.058874f, 51.0f, 39.0f, 51.0f);
                instancePath.close();
                instancePath.moveTo(39.0f, 45.0f);
                instancePath.cubicTo(32.37258f, 45.0f, 27.0f, 39.62742f, 27.0f, 33.0f);
                instancePath.cubicTo(27.0f, 26.372583f, 32.37258f, 21.0f, 39.0f, 21.0f);
                instancePath.cubicTo(45.62742f, 21.0f, 51.0f, 26.372583f, 51.0f, 33.0f);
                instancePath.cubicTo(51.0f, 39.62742f, 45.62742f, 45.0f, 39.0f, 45.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
