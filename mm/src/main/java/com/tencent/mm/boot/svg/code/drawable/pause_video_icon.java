package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class pause_video_icon extends c {
    private final int height = 10;
    private final int width = 9;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 9;
            case 1:
                return 10;
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -162.0f, 0.0f, 1.0f, -172.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 162.0f, 0.0f, 1.0f, 172.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 1.0f);
                instancePath.cubicTo(0.0f, 0.44771522f, 0.44771522f, 0.0f, 1.0f, 0.0f);
                instancePath.lineTo(2.0f, 0.0f);
                instancePath.cubicTo(2.5522847f, 0.0f, 3.0f, 0.44771522f, 3.0f, 1.0f);
                instancePath.lineTo(3.0f, 9.0f);
                instancePath.cubicTo(3.0f, 9.552285f, 2.5522847f, 10.0f, 2.0f, 10.0f);
                instancePath.lineTo(1.0f, 10.0f);
                instancePath.cubicTo(0.44771522f, 10.0f, 0.0f, 9.552285f, 0.0f, 9.0f);
                instancePath.lineTo(0.0f, 1.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(6.0f, 1.0f);
                instancePath2.cubicTo(6.0f, 0.44771522f, 6.4477153f, 0.0f, 7.0f, 0.0f);
                instancePath2.lineTo(8.0f, 0.0f);
                instancePath2.cubicTo(8.552285f, 0.0f, 9.0f, 0.44771522f, 9.0f, 1.0f);
                instancePath2.lineTo(9.0f, 9.0f);
                instancePath2.cubicTo(9.0f, 9.552285f, 8.552285f, 10.0f, 8.0f, 10.0f);
                instancePath2.lineTo(7.0f, 10.0f);
                instancePath2.cubicTo(6.4477153f, 10.0f, 6.0f, 9.552285f, 6.0f, 9.0f);
                instancePath2.lineTo(6.0f, 1.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
