package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class search_article_btn_press extends c {
    private final int height = 78;
    private final int width = 78;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 78;
            case 1:
                return 78;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -223.0f, 0.0f, 1.0f, -362.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 98.0f, 0.0f, 1.0f, 362.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 125.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-11184811);
                instancePaint4.setStrokeWidth(3.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(2.9959373f, 0.0f);
                instancePath.cubicTo(1.3413268f, 0.0f, 0.0f, 1.3424077f, 0.0f, 3.002084f);
                instancePath.lineTo(0.0f, 68.99792f);
                instancePath.cubicTo(0.0f, 70.65592f, 1.3373097f, 72.0f, 2.9959373f, 72.0f);
                instancePath.lineTo(57.004063f, 72.0f);
                instancePath.cubicTo(58.658672f, 72.0f, 60.0f, 70.65759f, 60.0f, 68.99792f);
                instancePath.lineTo(60.0f, 3.002084f);
                instancePath.cubicTo(60.0f, 1.3440788f, 58.66269f, 0.0f, 57.004063f, 0.0f);
                instancePath.lineTo(2.9959373f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-11184811);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(8.0f, 27.0f);
                instancePath2.lineTo(40.0f, 27.0f);
                instancePath2.lineTo(40.0f, 30.0f);
                instancePath2.lineTo(8.0f, 30.0f);
                instancePath2.lineTo(8.0f, 27.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-11184811);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(8.0f, 36.0f);
                instancePath3.lineTo(25.0f, 36.0f);
                instancePath3.lineTo(25.0f, 39.0f);
                instancePath3.lineTo(8.0f, 39.0f);
                instancePath3.lineTo(8.0f, 36.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-11184811);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(8.0f, 45.0f);
                instancePath4.lineTo(28.0f, 45.0f);
                instancePath4.lineTo(28.0f, 48.0f);
                instancePath4.lineTo(8.0f, 48.0f);
                instancePath4.lineTo(8.0f, 45.0f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                instancePaint8.setColor(-11184811);
                instancePaint8.setStrokeWidth(3.0f);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(14.0f, 8.0f);
                instancePath5.cubicTo(17.31371f, 8.0f, 20.0f, 10.686291f, 20.0f, 14.0f);
                instancePath5.cubicTo(20.0f, 17.31371f, 17.31371f, 20.0f, 14.0f, 20.0f);
                instancePath5.cubicTo(10.686291f, 20.0f, 8.0f, 17.31371f, 8.0f, 14.0f);
                instancePath5.cubicTo(8.0f, 10.686291f, 10.686291f, 8.0f, 14.0f, 8.0f);
                instancePath5.close();
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
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
