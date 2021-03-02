package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sos_wiki_icon extends c {
    private final int height = 40;
    private final int width = 40;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                instancePaint3.setStrokeCap(Paint.Cap.ROUND);
                instancePaint3.setStrokeJoin(Paint.Join.MITER);
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-4210753);
                instancePaint4.setStrokeWidth(2.0266666f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 0.9790959f, 0.20339915f, -3.6043708f, -0.20339915f, 0.9790959f, 1.939332f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(3.9045625f, 0.86031014f);
                instancePath.lineTo(11.360975f, 0.86031014f);
                instancePath.lineTo(11.360975f, 36.14994f);
                instancePath.lineTo(3.9045625f, 36.14994f);
                instancePath.lineTo(3.9045625f, 0.86031014f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(7.6153846f, 29.170536f);
                instancePath2.lineTo(12.770414f, 27.98492f);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint4, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(2.5524092f, 8.875595f);
                instancePath3.lineTo(7.6153846f, 7.8294644f);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint4, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(0.30461538f, 0.70153844f);
                instancePath4.lineTo(7.6153846f, 0.70153844f);
                instancePath4.lineTo(7.6153846f, 35.357536f);
                instancePath4.lineTo(0.30461538f, 35.357536f);
                instancePath4.lineTo(0.30461538f, 0.70153844f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint4, looper);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(0.30461538f, 28.662857f);
                instancePath5.lineTo(7.6153846f, 28.662857f);
                canvas.drawPath(instancePath5, instancePaint9);
                canvas.restore();
                canvas.save();
                Paint instancePaint10 = c.instancePaint(instancePaint4, looper);
                Path instancePath6 = c.instancePath(looper);
                instancePath6.moveTo(0.30461538f, 7.817143f);
                instancePath6.lineTo(7.6153846f, 7.817143f);
                canvas.drawPath(instancePath6, instancePaint10);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint11 = c.instancePaint(instancePaint4, looper);
                Path instancePath7 = c.instancePath(looper);
                instancePath7.moveTo(0.42307693f, 0.557529f);
                instancePath7.lineTo(7.023077f, 0.557529f);
                instancePath7.lineTo(7.023077f, 37.91197f);
                instancePath7.lineTo(0.42307693f, 37.91197f);
                instancePath7.lineTo(0.42307693f, 0.557529f);
                instancePath7.close();
                canvas.drawPath(instancePath7, instancePaint11);
                canvas.restore();
                canvas.save();
                Paint instancePaint12 = c.instancePaint(instancePaint4, looper);
                Path instancePath8 = c.instancePath(looper);
                instancePath8.moveTo(0.42307693f, 30.803474f);
                instancePath8.lineTo(7.023077f, 30.803474f);
                canvas.drawPath(instancePath8, instancePaint12);
                canvas.restore();
                canvas.save();
                Paint instancePaint13 = c.instancePaint(instancePaint4, looper);
                Path instancePath9 = c.instancePath(looper);
                instancePath9.moveTo(0.42307693f, 7.6660233f);
                instancePath9.lineTo(7.023077f, 7.6660233f);
                canvas.drawPath(instancePath9, instancePaint13);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
