package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class note_loc_detail extends c {
    private final int height = 206;
    private final int width = 888;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 888;
            case 1:
                return 206;
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
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-855638017);
                instancePaint5.setColor(419430400);
                instancePaint5.setStrokeWidth(2.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(487.3696f, 158.0f);
                instancePath.lineTo(865.59595f, 158.0f);
                instancePath.cubicTo(873.5463f, 158.0f, 880.0f, 151.55057f, 880.0f, 143.5948f);
                instancePath.lineTo(880.0f, 14.405201f);
                instancePath.cubicTo(880.0f, 6.4388275f, 873.5511f, 0.0f, 865.59595f, 0.0f);
                instancePath.lineTo(14.404071f, 0.0f);
                instancePath.cubicTo(6.4536805f, 0.0f, 0.0f, 6.449428f, 0.0f, 14.405201f);
                instancePath.lineTo(0.0f, 143.5948f);
                instancePath.cubicTo(0.0f, 151.56117f, 6.448922f, 158.0f, 14.404071f, 158.0f);
                instancePath.lineTo(391.99994f, 158.0f);
                instancePath.cubicTo(401.8239f, 158.0f, 416.78622f, 166.02438f, 429.78192f, 186.76418f);
                instancePath.cubicTo(442.77762f, 207.50397f, 454.39465f, 186.99791f, 454.39465f, 186.99791f);
                instancePath.cubicTo(454.39465f, 186.99791f, 474.19223f, 158.00002f, 487.3696f, 158.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
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
