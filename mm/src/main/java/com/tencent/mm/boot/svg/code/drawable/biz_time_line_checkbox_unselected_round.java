package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class biz_time_line_checkbox_unselected_round extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
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
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(16777215);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(10.0f, 0.0f);
                instancePath.cubicTo(15.522848f, 0.0f, 20.0f, 4.4771523f, 20.0f, 10.0f);
                instancePath.cubicTo(20.0f, 15.522848f, 15.522848f, 20.0f, 10.0f, 20.0f);
                instancePath.cubicTo(4.4771523f, 20.0f, 0.0f, 15.522848f, 0.0f, 10.0f);
                instancePath.cubicTo(0.0f, 4.4771523f, 4.4771523f, 0.0f, 10.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint5.setStrokeWidth(1.2f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(10.0f, 19.4f);
                instancePath2.cubicTo(15.191477f, 19.4f, 19.4f, 15.191477f, 19.4f, 10.0f);
                instancePath2.cubicTo(19.4f, 4.808523f, 15.191477f, 0.6f, 10.0f, 0.6f);
                instancePath2.cubicTo(4.808523f, 0.6f, 0.6f, 4.808523f, 0.6f, 10.0f);
                instancePath2.cubicTo(0.6f, 15.191477f, 4.808523f, 19.4f, 10.0f, 19.4f);
                instancePath2.close();
                canvas.saveLayerAlpha(null, 76, 31);
                canvas.drawPath(instancePath2, c.instancePaint(instancePaint5, looper));
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
