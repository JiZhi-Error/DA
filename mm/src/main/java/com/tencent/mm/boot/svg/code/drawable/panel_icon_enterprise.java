package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class panel_icon_enterprise extends c {
    private final int height = 168;
    private final int width = 168;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-8617594);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 49.0f, 0.0f, 1.0f, 46.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.9448406f, 3.0f);
                instancePath.cubicTo(0.42301953f, 3.0f, 0.0f, 3.4298856f, 0.0f, 3.9448407f);
                instancePath.lineTo(0.0f, 36.05516f);
                instancePath.cubicTo(0.0f, 36.57698f, 0.42988563f, 37.0f, 0.9448406f, 37.0f);
                instancePath.lineTo(33.05516f, 37.0f);
                instancePath.cubicTo(33.57698f, 37.0f, 34.0f, 36.570114f, 34.0f, 36.05516f);
                instancePath.lineTo(34.0f, 3.9448407f);
                instancePath.cubicTo(34.0f, 3.4230196f, 33.570114f, 3.0f, 33.05516f, 3.0f);
                instancePath.lineTo(0.9448406f, 3.0f);
                instancePath.lineTo(0.9448406f, 3.0f);
                instancePath.close();
                instancePath.moveTo(0.0f, 42.94484f);
                instancePath.lineTo(0.0f, 75.05516f);
                instancePath.cubicTo(0.0f, 75.57698f, 0.42988563f, 76.0f, 0.9448406f, 76.0f);
                instancePath.lineTo(33.05516f, 76.0f);
                instancePath.cubicTo(33.57698f, 76.0f, 34.0f, 75.570114f, 34.0f, 75.05516f);
                instancePath.lineTo(34.0f, 42.94484f);
                instancePath.cubicTo(34.0f, 42.42302f, 33.570114f, 42.0f, 33.05516f, 42.0f);
                instancePath.lineTo(0.9448406f, 42.0f);
                instancePath.cubicTo(0.42301953f, 42.0f, 0.0f, 42.429886f, 0.0f, 42.94484f);
                instancePath.close();
                instancePath.moveTo(39.94484f, 42.0f);
                instancePath.cubicTo(39.42302f, 42.0f, 39.0f, 42.429886f, 39.0f, 42.94484f);
                instancePath.lineTo(39.0f, 75.05516f);
                instancePath.cubicTo(39.0f, 75.57698f, 39.429886f, 76.0f, 39.94484f, 76.0f);
                instancePath.lineTo(72.05516f, 76.0f);
                instancePath.cubicTo(72.57698f, 76.0f, 73.0f, 75.570114f, 73.0f, 75.05516f);
                instancePath.lineTo(73.0f, 42.94484f);
                instancePath.cubicTo(73.0f, 42.42302f, 72.570114f, 42.0f, 72.05516f, 42.0f);
                instancePath.lineTo(39.94484f, 42.0f);
                instancePath.lineTo(39.94484f, 42.0f);
                instancePath.close();
                instancePath.moveTo(39.461056f, 36.24942f);
                instancePath.cubicTo(39.497868f, 34.750427f, 41.87496f, 16.05255f, 53.198692f, 10.63516f);
                instancePath.cubicTo(64.52242f, 5.217771f, 71.405556f, 7.708689f, 76.82161f, 1.0075728f);
                instancePath.cubicTo(78.15621f, -0.6436917f, 79.45604f, 12.767504f, 74.10915f, 24.23966f);
                instancePath.cubicTo(68.76226f, 35.711815f, 57.2631f, 32.031345f, 51.075695f, 31.984705f);
                instancePath.cubicTo(44.88829f, 31.938068f, 39.42424f, 37.74841f, 39.461056f, 36.24942f);
                instancePath.lineTo(39.461056f, 36.24942f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
