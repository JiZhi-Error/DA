package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class honey_pay_mother_card_input_icon extends c {
    private final int height = 120;
    private final int width = 140;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 140;
            case 1:
                return 120;
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
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-25290);
                instancePaint4.setStrokeWidth(2.0f);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(24.0f, 42.220886f);
                instancePath.cubicTo(37.25718f, 26.622805f, 49.25718f, 25.956137f, 60.0f, 40.220886f);
                instancePath.cubicTo(70.74282f, 54.485634f, 82.74282f, 55.152298f, 96.0f, 42.220886f);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(24.0f, 62.220886f);
                instancePath2.cubicTo(37.25718f, 46.622803f, 49.25718f, 45.95614f, 60.0f, 60.220886f);
                instancePath2.cubicTo(70.74282f, 74.485634f, 82.74282f, 75.1523f, 96.0f, 62.220886f);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint4, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(24.0f, 82.22089f);
                instancePath3.cubicTo(37.25718f, 66.6228f, 49.25718f, 65.95614f, 60.0f, 80.22089f);
                instancePath3.cubicTo(70.74282f, 94.485634f, 82.74282f, 95.1523f, 96.0f, 82.22089f);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
