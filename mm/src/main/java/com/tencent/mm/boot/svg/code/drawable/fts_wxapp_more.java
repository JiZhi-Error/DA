package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fts_wxapp_more extends c {
    private final int height = 14;
    private final int width = 57;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 57;
            case 1:
                return 14;
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
                instancePaint3.setColor(-3684404);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -799.0f, 0.0f, 1.0f, -836.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 203.0f, 0.0f, 1.0f, 793.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 596.4823f, 0.0f, 1.0f, 43.304348f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(6.4615383f, 0.0f);
                instancePath.cubicTo(10.030148f, 0.0f, 12.923077f, 2.9101489f, 12.923077f, 6.5f);
                instancePath.cubicTo(12.923077f, 10.089851f, 10.030148f, 13.0f, 6.4615383f, 13.0f);
                instancePath.cubicTo(2.892929f, 13.0f, 0.0f, 10.089851f, 0.0f, 6.5f);
                instancePath.cubicTo(0.0f, 2.9101489f, 2.892929f, 0.0f, 6.4615383f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(28.0f, 0.0f);
                instancePath2.cubicTo(31.56861f, 0.0f, 34.46154f, 2.9101489f, 34.46154f, 6.5f);
                instancePath2.cubicTo(34.46154f, 10.089851f, 31.56861f, 13.0f, 28.0f, 13.0f);
                instancePath2.cubicTo(24.43139f, 13.0f, 21.538462f, 10.089851f, 21.538462f, 6.5f);
                instancePath2.cubicTo(21.538462f, 2.9101489f, 24.43139f, 0.0f, 28.0f, 0.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(49.53846f, 0.0f);
                instancePath3.cubicTo(53.10707f, 0.0f, 56.0f, 2.9101489f, 56.0f, 6.5f);
                instancePath3.cubicTo(56.0f, 10.089851f, 53.10707f, 13.0f, 49.53846f, 13.0f);
                instancePath3.cubicTo(45.96985f, 13.0f, 43.07692f, 10.089851f, 43.07692f, 6.5f);
                instancePath3.cubicTo(43.07692f, 2.9101489f, 45.96985f, 0.0f, 49.53846f, 0.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
