package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class backup_move_banner extends c {
    private final int height = 100;
    private final int width = 100;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 100;
            case 1:
                return 100;
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
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-9473160);
                instancePaint4.setStrokeWidth(6.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 59.0f, 0.0f, 1.0f, 38.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 1.9734219f);
                instancePath.cubicTo(0.0f, 0.8835311f, 0.8835311f, 0.0f, 1.9734219f, 0.0f);
                instancePath.lineTo(28.026579f, 0.0f);
                instancePath.cubicTo(29.11647f, 0.0f, 30.0f, 0.8835311f, 30.0f, 1.9734219f);
                instancePath.lineTo(30.0f, 46.026577f);
                instancePath.cubicTo(30.0f, 47.116467f, 29.11647f, 48.0f, 28.026579f, 48.0f);
                instancePath.lineTo(1.9734219f, 48.0f);
                instancePath.cubicTo(0.8835311f, 48.0f, 0.0f, 47.116467f, 0.0f, 46.026577f);
                instancePath.lineTo(0.0f, 1.9734219f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(69.0f, 35.0f);
                instancePath2.lineTo(69.0f, 15.980916f);
                instancePath2.cubicTo(69.0f, 14.886887f, 68.12216f, 14.0f, 67.02344f, 14.0f);
                instancePath2.lineTo(24.976562f, 14.0f);
                instancePath2.cubicTo(23.884937f, 14.0f, 23.0f, 14.88437f, 23.0f, 15.981961f);
                instancePath2.lineTo(23.0f, 84.018036f);
                instancePath2.cubicTo(23.0f, 85.11265f, 23.873781f, 86.0f, 24.969942f, 86.0f);
                instancePath2.lineTo(56.0f, 86.0f);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
