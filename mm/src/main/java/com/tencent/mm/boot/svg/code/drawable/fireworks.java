package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fireworks extends c {
    private final int height = 22;
    private final int width = 22;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 22;
            case 1:
                return 22;
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
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-8058);
                instancePaint4.setStrokeWidth(2.0f);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -24.0f, 0.0f, 1.0f, -95.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 24.51317f, 0.0f, 1.0f, 95.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(10.486831f, 0.0f);
                instancePath.lineTo(10.486831f, 7.0f);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(10.486831f, 15.0f);
                instancePath2.lineTo(10.486831f, 22.0f);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint4, looper);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 0.5f, -0.8660254f, 15.307152f, 0.8660254f, 0.5f, -11.542917f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(17.712133f, 3.792134f);
                instancePath3.lineTo(17.587938f, 11.177714f);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint4, looper);
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 0.5f, -0.8660254f, 15.035036f, 0.8660254f, 0.5f, 4.6390305f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(3.562098f, 11.647449f);
                instancePath4.lineTo(3.437902f, 19.03303f);
                canvas.drawPath(instancePath4, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint4, looper);
                float[] matrixFloatArray5 = c.setMatrixFloatArray(matrixFloatArray4, -0.5f, -0.8660254f, 39.844887f, 0.8660254f, -0.5f, 7.8718505f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray5);
                canvas.concat(instanceMatrix);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(17.587938f, 11.745362f);
                instancePath5.lineTo(17.712133f, 19.130943f);
                canvas.drawPath(instancePath5, instancePaint9);
                canvas.restore();
                canvas.save();
                Paint instancePaint10 = c.instancePaint(instancePaint4, looper);
                float[] matrixFloatArray6 = c.setMatrixFloatArray(matrixFloatArray5, -0.5f, -0.8660254f, 11.816931f, 0.8660254f, -0.5f, 8.343168f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray6);
                canvas.concat(instanceMatrix);
                Path instancePath6 = c.instancePath(looper);
                instancePath6.moveTo(3.437902f, 3.8900478f);
                instancePath6.lineTo(3.562098f, 11.275628f);
                canvas.drawPath(instancePath6, instancePaint10);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
