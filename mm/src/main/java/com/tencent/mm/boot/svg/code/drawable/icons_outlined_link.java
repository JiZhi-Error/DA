package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_link extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 9.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(43.970562f, 27.0f);
                instancePath.lineTo(41.42498f, 24.454416f);
                instancePath.lineTo(47.78894f, 18.090454f);
                instancePath.cubicTo(51.069344f, 14.810051f, 51.069344f, 9.491465f, 47.78894f, 6.2110605f);
                instancePath.cubicTo(44.508533f, 2.9306567f, 39.18995f, 2.9306567f, 35.909546f, 6.2110605f);
                instancePath.lineTo(24.242283f, 17.878323f);
                instancePath.cubicTo(20.96188f, 21.158726f, 20.96188f, 26.477312f, 24.242283f, 29.757717f);
                instancePath.lineTo(21.6967f, 32.303303f);
                instancePath.cubicTo(17.010408f, 27.61701f, 17.010408f, 20.01903f, 21.6967f, 15.332738f);
                instancePath.lineTo(33.36396f, 3.6654763f);
                instancePath.cubicTo(38.05025f, -1.0208153f, 45.64823f, -1.0208153f, 50.334522f, 3.6654763f);
                instancePath.cubicTo(55.020817f, 8.351768f, 55.020817f, 15.949747f, 50.334522f, 20.63604f);
                instancePath.lineTo(43.970562f, 27.0f);
                instancePath.close();
                instancePath.moveTo(10.029437f, 27.0f);
                instancePath.lineTo(12.575022f, 29.545584f);
                instancePath.lineTo(6.2110605f, 35.909546f);
                instancePath.cubicTo(2.9306567f, 39.18995f, 2.9306567f, 44.508533f, 6.2110605f, 47.78894f);
                instancePath.cubicTo(9.491465f, 51.069344f, 14.810051f, 51.069344f, 18.090454f, 47.78894f);
                instancePath.lineTo(29.757717f, 36.121677f);
                instancePath.cubicTo(33.03812f, 32.841274f, 33.03812f, 27.522688f, 29.757717f, 24.242283f);
                instancePath.lineTo(32.303303f, 21.6967f);
                instancePath.cubicTo(36.989594f, 26.38299f, 36.989594f, 33.980972f, 32.303303f, 38.667263f);
                instancePath.lineTo(20.63604f, 50.334522f);
                instancePath.cubicTo(15.949747f, 55.020817f, 8.351768f, 55.020817f, 3.6654763f, 50.334522f);
                instancePath.cubicTo(-1.0208153f, 45.64823f, -1.0208153f, 38.05025f, 3.6654763f, 33.36396f);
                instancePath.lineTo(10.029437f, 27.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
