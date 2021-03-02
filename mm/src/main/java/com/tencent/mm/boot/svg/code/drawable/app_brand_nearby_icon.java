package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_nearby_icon extends c {
    private final int height = 57;
    private final int width = 45;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 45;
            case 1:
                return 57;
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
                instancePaint4.setColor(-11184811);
                instancePaint4.setStrokeWidth(3.0f);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -1450.0f, 0.0f, 1.0f, -602.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1470.9163f, 655.8485f);
                instancePath.cubicTo(1472.067f, 657.03674f, 1473.9164f, 657.02386f, 1475.0333f, 655.7881f);
                instancePath.cubicTo(1475.0333f, 655.7881f, 1492.0f, 638.46387f, 1492.0f, 624.0f);
                instancePath.cubicTo(1492.0f, 612.767f, 1483.2695f, 604.0f, 1473.0f, 604.0f);
                instancePath.cubicTo(1461.7305f, 604.0f, 1453.0f, 612.767f, 1453.0f, 624.0f);
                instancePath.cubicTo(1453.0f, 638.46387f, 1470.9163f, 655.8485f, 1470.9163f, 655.8485f);
                instancePath.close();
                instancePath.moveTo(1473.0f, 630.0f);
                instancePath.cubicTo(1476.0898f, 630.0f, 1479.0f, 627.08984f, 1479.0f, 624.0f);
                instancePath.cubicTo(1479.0f, 619.91016f, 1476.0898f, 617.0f, 1473.0f, 617.0f);
                instancePath.cubicTo(1468.9102f, 617.0f, 1466.0f, 619.91016f, 1466.0f, 624.0f);
                instancePath.cubicTo(1466.0f, 627.08984f, 1468.9102f, 630.0f, 1473.0f, 630.0f);
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
