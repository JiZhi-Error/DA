package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class face_id_icon extends c {
    private final int height = 70;
    private final int width = 70;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 70;
            case 1:
                return 70;
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
                canvas.saveLayerAlpha(null, 172, 31);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -145.0f, 0.0f, 1.0f, -231.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 144.0f, 0.0f, 1.0f, 230.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-5526613);
                instancePaint4.setStrokeWidth(3.6f);
                instancePaint4.setStrokeCap(Paint.Cap.ROUND);
                instancePaint4.setStrokeJoin(Paint.Join.MITER);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(33.0f, 27.0f);
                instancePath.lineTo(33.0f, 36.0f);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(-5526613);
                instancePaint5.setStrokeWidth(3.0f);
                instancePaint5.setStrokeCap(Paint.Cap.ROUND);
                instancePaint5.setStrokeJoin(Paint.Join.MITER);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(24.0f, 42.0f);
                instancePath2.cubicTo(26.185297f, 43.986816f, 29.185297f, 44.980225f, 33.0f, 44.980225f);
                instancePath2.cubicTo(36.8147f, 44.980225f, 39.8147f, 43.986816f, 42.0f, 42.0f);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-5526613);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(21.0f, 21.0f);
                instancePath3.cubicTo(22.656855f, 21.0f, 24.0f, 22.343145f, 24.0f, 24.0f);
                instancePath3.cubicTo(24.0f, 25.656855f, 22.656855f, 27.0f, 21.0f, 27.0f);
                instancePath3.cubicTo(19.343145f, 27.0f, 18.0f, 25.656855f, 18.0f, 24.0f);
                instancePath3.cubicTo(18.0f, 22.343145f, 19.343145f, 21.0f, 21.0f, 21.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-5526613);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(45.0f, 21.0f);
                instancePath4.cubicTo(46.656853f, 21.0f, 48.0f, 22.343145f, 48.0f, 24.0f);
                instancePath4.cubicTo(48.0f, 25.656855f, 46.656853f, 27.0f, 45.0f, 27.0f);
                instancePath4.cubicTo(43.343147f, 27.0f, 42.0f, 25.656855f, 42.0f, 24.0f);
                instancePath4.cubicTo(42.0f, 22.343145f, 43.343147f, 21.0f, 45.0f, 21.0f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                instancePaint8.setColor(-5526613);
                instancePaint8.setStrokeWidth(3.6f);
                instancePaint8.setStrokeCap(Paint.Cap.ROUND);
                instancePaint8.setStrokeJoin(Paint.Join.MITER);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(0.0f, 18.0f);
                instancePath5.lineTo(0.0f, 9.0f);
                instancePath5.cubicTo(-6.661338E-16f, 4.029437f, 4.029437f, 6.661338E-16f, 9.0f, 0.0f);
                instancePath5.cubicTo(13.0476885f, 0.0f, 15.976155f, 0.0f, 18.0f, 0.0f);
                instancePath5.moveTo(48.0f, 0.0f);
                instancePath5.cubicTo(49.891644f, 0.0f, 52.935345f, 0.0f, 57.0f, 0.0f);
                instancePath5.cubicTo(61.970562f, -9.992007E-16f, 66.0f, 4.029437f, 66.0f, 9.0f);
                instancePath5.cubicTo(66.0f, 13.024577f, 66.0f, 15.987712f, 66.0f, 18.0f);
                instancePath5.moveTo(66.0f, 48.0f);
                instancePath5.cubicTo(66.0f, 49.88775f, 66.0f, 52.944878f, 66.0f, 57.0f);
                instancePath5.cubicTo(66.0f, 61.970562f, 61.970562f, 66.0f, 57.0f, 66.0f);
                instancePath5.cubicTo(52.98454f, 66.0f, 50.007732f, 66.0f, 48.0f, 66.0f);
                instancePath5.moveTo(18.0f, 66.0f);
                instancePath5.cubicTo(16.081131f, 66.0f, 13.127518f, 66.0f, 9.0f, 66.0f);
                instancePath5.cubicTo(4.029437f, 66.0f, 6.661338E-16f, 61.970562f, 0.0f, 57.0f);
                instancePath5.lineTo(0.0f, 48.0f);
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
