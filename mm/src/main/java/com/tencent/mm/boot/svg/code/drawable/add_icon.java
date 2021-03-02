package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class add_icon extends c {
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-5066062);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -54.0f, 0.0f, 1.0f, -710.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 254.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 432.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(34.0f, 34.0f);
                instancePath.lineTo(26.004946f, 34.0f);
                instancePath.cubicTo(24.897026f, 34.0f, 24.0f, 34.89543f, 24.0f, 36.0f);
                instancePath.cubicTo(24.0f, 37.11227f, 24.897646f, 38.0f, 26.004946f, 38.0f);
                instancePath.lineTo(34.0f, 38.0f);
                instancePath.lineTo(34.0f, 45.995052f);
                instancePath.cubicTo(34.0f, 47.102974f, 34.89543f, 48.0f, 36.0f, 48.0f);
                instancePath.cubicTo(37.11227f, 48.0f, 38.0f, 47.102356f, 38.0f, 45.995052f);
                instancePath.lineTo(38.0f, 38.0f);
                instancePath.lineTo(45.995052f, 38.0f);
                instancePath.cubicTo(47.102974f, 38.0f, 48.0f, 37.10457f, 48.0f, 36.0f);
                instancePath.cubicTo(48.0f, 34.88773f, 47.102356f, 34.0f, 45.995052f, 34.0f);
                instancePath.lineTo(38.0f, 34.0f);
                instancePath.lineTo(38.0f, 26.004946f);
                instancePath.cubicTo(38.0f, 24.897026f, 37.10457f, 24.0f, 36.0f, 24.0f);
                instancePath.cubicTo(34.88773f, 24.0f, 34.0f, 24.897646f, 34.0f, 26.004946f);
                instancePath.lineTo(34.0f, 34.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
