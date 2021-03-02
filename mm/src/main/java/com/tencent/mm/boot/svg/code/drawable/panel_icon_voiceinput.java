package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class panel_icon_voiceinput extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 36.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 0.8660254f, -0.5f, 48.0f, 0.5f, 0.8660254f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(33.0f, 18.0f);
                instancePath.cubicTo(33.0f, 9.715729f, 39.71573f, 3.0f, 48.0f, 3.0f);
                instancePath.lineTo(48.0f, 3.0f);
                instancePath.cubicTo(56.28427f, 3.0f, 63.0f, 9.715729f, 63.0f, 18.0f);
                instancePath.lineTo(63.0f, 42.0f);
                instancePath.cubicTo(63.0f, 50.28427f, 56.28427f, 57.0f, 48.0f, 57.0f);
                instancePath.lineTo(48.0f, 57.0f);
                instancePath.cubicTo(39.71573f, 57.0f, 33.0f, 50.28427f, 33.0f, 42.0f);
                instancePath.lineTo(33.0f, 18.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(27.0f, 33.0f);
                instancePath2.lineTo(27.0f, 42.0f);
                instancePath2.cubicTo(27.0f, 53.59798f, 36.40202f, 63.0f, 48.0f, 63.0f);
                instancePath2.cubicTo(59.59798f, 63.0f, 69.0f, 53.59798f, 69.0f, 42.0f);
                instancePath2.lineTo(69.0f, 33.0f);
                instancePath2.lineTo(75.0f, 33.0f);
                instancePath2.lineTo(75.0f, 42.0f);
                instancePath2.cubicTo(75.0f, 56.91169f, 62.91169f, 69.0f, 48.0f, 69.0f);
                instancePath2.cubicTo(33.08831f, 69.0f, 21.0f, 56.91169f, 21.0f, 42.0f);
                instancePath2.lineTo(21.0f, 33.0f);
                instancePath2.lineTo(27.0f, 33.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(45.0f, 66.0f);
                instancePath3.lineTo(51.0f, 66.0f);
                instancePath3.lineTo(51.0f, 75.0f);
                instancePath3.lineTo(45.0f, 75.0f);
                instancePath3.lineTo(45.0f, 66.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(45.0f, 78.0f);
                instancePath4.lineTo(51.0f, 78.0f);
                instancePath4.lineTo(48.55106f, 83.68582f);
                instancePath4.cubicTo(48.419975f, 83.990166f, 48.066994f, 84.130615f, 47.762653f, 83.999535f);
                instancePath4.cubicTo(47.62184f, 83.93888f, 47.50959f, 83.82663f, 47.44894f, 83.68582f);
                instancePath4.lineTo(45.0f, 78.0f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
