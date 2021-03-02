package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_search_nearby_icon extends c {
    private final int height = 75;
    private final int width = 57;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 57;
            case 1:
                return 75;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -1448.0f, 0.0f, 1.0f, -685.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1474.4348f, 755.2621f);
                instancePath.cubicTo(1475.5754f, 756.4586f, 1477.4377f, 756.46204f, 1478.5652f, 755.2621f);
                instancePath.cubicTo(1478.5652f, 755.2621f, 1502.0f, 731.94885f, 1502.0f, 712.67706f);
                instancePath.cubicTo(1502.0f, 698.43427f, 1490.5833f, 687.0f, 1476.8696f, 687.0f);
                instancePath.cubicTo(1462.4167f, 687.0f, 1451.0f, 698.43427f, 1451.0f, 712.67706f);
                instancePath.cubicTo(1451.0f, 731.94885f, 1474.4348f, 755.2621f, 1474.4348f, 755.2621f);
                instancePath.close();
                instancePath.moveTo(1476.5f, 721.0f);
                instancePath.cubicTo(1481.1945f, 721.0f, 1485.0f, 717.1944f, 1485.0f, 712.5f);
                instancePath.cubicTo(1485.0f, 707.8056f, 1481.1945f, 704.0f, 1476.5f, 704.0f);
                instancePath.cubicTo(1471.8055f, 704.0f, 1468.0f, 707.8056f, 1468.0f, 712.5f);
                instancePath.cubicTo(1468.0f, 717.1944f, 1471.8055f, 721.0f, 1476.5f, 721.0f);
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
