package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class tips_background extends c {
    private final int height = 101;
    private final int width = 200;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 200;
            case 1:
                return 101;
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
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                instancePaint5.setColor(436207616);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -192.0f, 0.0f, 1.0f, -236.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(192.5f, 244.5f);
                instancePath.cubicTo(192.5f, 240.08173f, 196.08173f, 236.5f, 200.5f, 236.5f);
                instancePath.lineTo(383.5f, 236.5f);
                instancePath.cubicTo(387.91827f, 236.5f, 391.5f, 240.08173f, 391.5f, 244.5f);
                instancePath.lineTo(391.5f, 328.5f);
                instancePath.cubicTo(391.5f, 332.91827f, 387.91827f, 336.5f, 383.5f, 336.5f);
                instancePath.lineTo(200.5f, 336.5f);
                instancePath.cubicTo(196.08173f, 336.5f, 192.5f, 332.91827f, 192.5f, 328.5f);
                instancePath.lineTo(192.5f, 244.5f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
