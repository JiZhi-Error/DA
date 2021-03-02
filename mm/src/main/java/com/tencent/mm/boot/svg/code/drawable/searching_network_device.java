package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class searching_network_device extends c {
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
                instancePaint3.setColor(-14187817);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 37.0f, 0.0f, 1.0f, 39.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(72.0767f, 82.22588f);
                instancePath.cubicTo(83.53856f, 73.9851f, 91.0f, 60.553818f, 91.0f, 45.38426f);
                instancePath.cubicTo(91.0f, 20.319225f, 70.62896f, -3.5527137E-14f, 45.5f, -3.5527137E-14f);
                instancePath.cubicTo(20.371044f, -3.5527137E-14f, -2.1316282E-14f, 20.319225f, -2.1316282E-14f, 45.38426f);
                instancePath.cubicTo(-2.1316282E-14f, 61.038643f, 7.9460006f, 74.84186f, 20.034418f, 83.0f);
                instancePath.lineTo(22.1966f, 79.985435f);
                instancePath.cubicTo(11.048177f, 72.50055f, 3.7142856f, 59.796688f, 3.7142856f, 45.38426f);
                instancePath.cubicTo(3.7142856f, 22.36535f, 22.422388f, 3.7048376f, 45.5f, 3.7048376f);
                instancePath.cubicTo(68.577614f, 3.7048376f, 87.28571f, 22.36535f, 87.28571f, 45.38426f);
                instancePath.cubicTo(87.28571f, 59.35643f, 80.393036f, 71.722824f, 69.81427f, 79.285f);
                instancePath.lineTo(72.0767f, 82.22588f);
                instancePath.close();
                instancePath.moveTo(66.62715f, 75.14214f);
                instancePath.cubicTo(75.9622f, 68.53627f, 82.054f, 57.669865f, 82.054f, 45.38426f);
                instancePath.cubicTo(82.054f, 25.247396f, 65.68822f, 8.923243f, 45.5f, 8.923243f);
                instancePath.cubicTo(25.311783f, 8.923243f, 8.945999f, 25.247396f, 8.945999f, 45.38426f);
                instancePath.cubicTo(8.945999f, 58.04734f, 15.417901f, 69.202675f, 25.242413f, 75.7389f);
                instancePath.lineTo(27.490881f, 72.604034f);
                instancePath.cubicTo(18.643457f, 66.76842f, 12.807601f, 56.756123f, 12.807601f, 45.38426f);
                instancePath.cubicTo(12.807601f, 27.374676f, 27.444487f, 12.7750225f, 45.5f, 12.7750225f);
                instancePath.cubicTo(63.55551f, 12.7750225f, 78.1924f, 27.374676f, 78.1924f, 45.38426f);
                instancePath.cubicTo(78.1924f, 56.424984f, 72.69147f, 66.184166f, 64.27428f, 72.083694f);
                instancePath.lineTo(66.62715f, 75.14214f);
                instancePath.close();
                instancePath.moveTo(60.846767f, 67.62836f);
                instancePath.cubicTo(67.92764f, 62.75864f, 72.5687f, 54.61206f, 72.5687f, 45.38426f);
                instancePath.cubicTo(72.5687f, 30.472656f, 60.44963f, 18.384415f, 45.5f, 18.384415f);
                instancePath.cubicTo(30.55037f, 18.384415f, 18.4313f, 30.472656f, 18.4313f, 45.38426f);
                instancePath.cubicTo(18.4313f, 54.875706f, 23.341345f, 63.22327f, 30.766079f, 68.03768f);
                instancePath.lineTo(33.130417f, 64.741264f);
                instancePath.cubicTo(26.732042f, 60.664852f, 22.489536f, 53.51874f, 22.489536f, 45.38426f);
                instancePath.cubicTo(22.489536f, 32.70826f, 32.79167f, 22.43233f, 45.5f, 22.43233f);
                instancePath.cubicTo(58.20833f, 22.43233f, 68.51047f, 32.70826f, 68.51047f, 45.38426f);
                instancePath.cubicTo(68.51047f, 53.303806f, 64.48919f, 60.286526f, 58.372215f, 64.41174f);
                instancePath.lineTo(60.846767f, 67.62836f);
                instancePath.close();
                instancePath.moveTo(54.48061f, 59.353138f);
                instancePath.cubicTo(59.084618f, 56.40215f, 62.134594f, 51.248478f, 62.134594f, 45.38426f);
                instancePath.cubicTo(62.134594f, 36.220596f, 54.68703f, 28.79198f, 45.5f, 28.79198f);
                instancePath.cubicTo(36.31297f, 28.79198f, 28.865408f, 36.220596f, 28.865408f, 45.38426f);
                instancePath.cubicTo(28.865408f, 51.386845f, 32.06101f, 56.644955f, 36.847862f, 59.558327f);
                instancePath.lineTo(38.943947f, 56.635918f);
                instancePath.cubicTo(35.06329f, 54.381386f, 32.454987f, 50.18665f, 32.454987f, 45.38426f);
                instancePath.cubicTo(32.454987f, 38.198025f, 38.295437f, 32.37243f, 45.5f, 32.37243f);
                instancePath.cubicTo(52.704563f, 32.37243f, 58.545013f, 38.198025f, 58.545013f, 45.38426f);
                instancePath.cubicTo(58.545013f, 50.091446f, 56.0391f, 54.214832f, 52.285336f, 56.499557f);
                instancePath.lineTo(54.48061f, 59.353138f);
                instancePath.close();
                instancePath.moveTo(49.096928f, 52.35502f);
                instancePath.cubicTo(51.627728f, 51.053127f, 53.35822f, 48.42027f, 53.35822f, 45.38426f);
                instancePath.cubicTo(53.35822f, 41.055325f, 49.839973f, 37.54603f, 45.5f, 37.54603f);
                instancePath.cubicTo(41.160027f, 37.54603f, 37.64178f, 41.055325f, 37.64178f, 45.38426f);
                instancePath.cubicTo(37.64178f, 48.452805f, 39.40956f, 51.10951f, 41.984715f, 52.39641f);
                instancePath.lineTo(44.138638f, 49.39336f);
                instancePath.cubicTo(42.463356f, 48.82757f, 41.257534f, 47.246376f, 41.257534f, 45.38426f);
                instancePath.cubicTo(41.257534f, 43.047173f, 43.15695f, 41.152588f, 45.5f, 41.152588f);
                instancePath.cubicTo(47.84305f, 41.152588f, 49.742466f, 43.047173f, 49.742466f, 45.38426f);
                instancePath.cubicTo(49.742466f, 47.258987f, 48.520252f, 48.848984f, 46.82725f, 49.40472f);
                instancePath.lineTo(49.096928f, 52.35502f);
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
