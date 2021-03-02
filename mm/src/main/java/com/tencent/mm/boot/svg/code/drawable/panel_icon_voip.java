package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class panel_icon_voip extends c {
    private final int height = 192;
    private final int width = 192;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 48.0f, 0.0f, 1.0f, 48.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-13421773);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(3.0f, 0.0f);
                instancePath.lineTo(57.0f, 0.0f);
                instancePath.cubicTo(58.656853f, -3.043592E-16f, 60.0f, 1.3431457f, 60.0f, 3.0f);
                instancePath.lineTo(60.0f, 45.0f);
                instancePath.cubicTo(60.0f, 46.656853f, 58.656853f, 48.0f, 57.0f, 48.0f);
                instancePath.lineTo(3.0f, 48.0f);
                instancePath.cubicTo(1.3431457f, 48.0f, 2.0290612E-16f, 46.656853f, 0.0f, 45.0f);
                instancePath.lineTo(0.0f, 3.0f);
                instancePath.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(87.0f, 6.1723914f);
                instancePath2.lineTo(87.0f, 41.82761f);
                instancePath2.cubicTo(87.0f, 43.484463f, 85.65685f, 44.82761f, 84.0f, 44.82761f);
                instancePath2.cubicTo(83.327805f, 44.82761f, 82.675095f, 44.601856f, 82.14654f, 44.186565f);
                instancePath2.lineTo(66.0f, 31.5f);
                instancePath2.lineTo(66.0f, 24.0f);
                instancePath2.lineTo(66.0f, 16.5f);
                instancePath2.lineTo(82.14654f, 3.8134365f);
                instancePath2.cubicTo(83.44935f, 2.7897964f, 85.33531f, 3.016112f, 86.358955f, 4.318927f);
                instancePath2.cubicTo(86.77425f, 4.8474836f, 87.0f, 5.5002f, 87.0f, 6.1723914f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
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
