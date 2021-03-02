package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class device_profile_the_end extends c {
    private final int height = 8;
    private final int width = 242;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 242;
            case 1:
                return 8;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1498304079);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(119.5f, 0.0f);
                instancePath.cubicTo(121.433f, 0.0f, 123.0f, 1.5670033f, 123.0f, 3.5f);
                instancePath.cubicTo(123.0f, 5.4329967f, 121.433f, 7.0f, 119.5f, 7.0f);
                instancePath.cubicTo(117.567f, 7.0f, 116.0f, 5.4329967f, 116.0f, 3.5f);
                instancePath.cubicTo(116.0f, 1.5670033f, 117.567f, 0.0f, 119.5f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(-1716407887);
                instancePaint5.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(130.5f, 3.5f);
                instancePath2.lineTo(238.51852f, 3.5f);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(-1716407887);
                instancePaint6.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(0.5f, 3.5f);
                instancePath3.lineTo(108.51852f, 3.5f);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
