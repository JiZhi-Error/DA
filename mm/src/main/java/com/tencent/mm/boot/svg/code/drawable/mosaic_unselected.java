package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class mosaic_unselected extends c {
    private final int height = 63;
    private final int width = 63;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(16777215);
                instancePaint5.setColor(-1);
                instancePaint5.setStrokeWidth(2.0f);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 1.5f);
                instancePath.cubicTo(0.0f, 0.6715728f, 0.6715728f, 0.0f, 1.5f, 0.0f);
                instancePath.lineTo(37.5f, 0.0f);
                instancePath.cubicTo(38.328426f, 0.0f, 39.0f, 0.6715728f, 39.0f, 1.5f);
                instancePath.lineTo(39.0f, 37.5f);
                instancePath.cubicTo(39.0f, 38.328426f, 38.328426f, 39.0f, 37.5f, 39.0f);
                instancePath.lineTo(1.5f, 39.0f);
                instancePath.cubicTo(0.6715728f, 39.0f, 0.0f, 38.328426f, 0.0f, 37.5f);
                instancePath.lineTo(0.0f, 1.5f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.0f, 0.0f);
                instancePath2.lineTo(20.0f, 0.0f);
                instancePath2.lineTo(20.0f, 20.0f);
                instancePath2.lineTo(0.0f, 20.0f);
                instancePath2.lineTo(0.0f, 0.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(20.0f, 20.0f);
                instancePath3.lineTo(39.5f, 20.0f);
                instancePath3.lineTo(39.5f, 39.5f);
                instancePath3.lineTo(20.0f, 39.5f);
                instancePath3.lineTo(20.0f, 20.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint9);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
