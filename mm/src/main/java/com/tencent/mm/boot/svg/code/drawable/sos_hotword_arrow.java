package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sos_hotword_arrow extends c {
    private final int height = 24;
    private final int width = 14;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 14;
            case 1:
                return 24;
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
                instancePaint3.setStrokeCap(Paint.Cap.SQUARE);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-7039852);
                instancePaint4.setStrokeWidth(1.3333334f);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -297.0f, 0.0f, 1.0f, -1097.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(309.1949f, 1109.0f);
                instancePath.lineTo(309.33334f, 1108.8616f);
                instancePath.lineTo(309.09744f, 1108.6256f);
                instancePath.lineTo(298.70767f, 1098.2358f);
                instancePath.lineTo(298.47177f, 1098.0f);
                instancePath.lineTo(298.0f, 1098.4718f);
                instancePath.lineTo(298.2359f, 1098.7076f);
                instancePath.lineTo(308.52823f, 1109.0f);
                instancePath.lineTo(298.2359f, 1119.2924f);
                instancePath.lineTo(298.0f, 1119.5282f);
                instancePath.lineTo(298.47177f, 1120.0f);
                instancePath.lineTo(298.70767f, 1119.7642f);
                instancePath.lineTo(309.09744f, 1109.3744f);
                instancePath.lineTo(309.33334f, 1109.1384f);
                instancePath.lineTo(309.1949f, 1109.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
