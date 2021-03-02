package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class navbar_discovery_icon_focus extends c {
    private final int height = 84;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 84;
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
                instancePaint3.setColor(-12206054);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 8.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(31.552f, 0.089f);
                instancePath.cubicTo(36.477f, -0.264f, 41.481f, 0.453f, 46.096f, 2.217f);
                instancePath.cubicTo(52.452f, 4.625f, 58.037f, 9.004f, 61.913f, 14.586f);
                instancePath.cubicTo(63.992f, 17.566f, 65.588f, 20.883f, 66.615f, 24.369f);
                instancePath.cubicTo(68.773f, 31.659f, 68.4f, 39.674f, 65.539f, 46.72f);
                instancePath.cubicTo(63.273f, 52.354f, 59.455f, 57.347f, 54.627f, 61.029f);
                instancePath.cubicTo(49.385f, 65.052f, 42.943f, 67.485f, 36.348f, 67.918f);
                instancePath.cubicTo(31.984f, 68.218f, 27.561f, 67.681f, 23.404f, 66.314f);
                instancePath.cubicTo(17.003f, 64.229f, 11.27f, 60.173f, 7.147f, 54.854f);
                instancePath.cubicTo(4.738f, 51.759f, 2.868f, 48.244f, 1.658f, 44.512f);
                instancePath.cubicTo(0.025f, 39.504f, -0.4f, 34.114f, 0.381f, 28.907f);
                instancePath.cubicTo(1.448f, 21.662f, 4.972f, 14.819f, 10.213f, 9.709f);
                instancePath.cubicTo(15.02f, 4.983f, 21.263f, 1.734f, 27.902f, 0.548f);
                instancePath.cubicTo(29.109f, 0.329f, 30.328f, 0.176f, 31.552f, 0.089f);
                instancePath.lineTo(31.552f, 0.089f);
                instancePath.close();
                instancePath.moveTo(30.439f, 26.843f);
                instancePath.cubicTo(28.893f, 27.609f, 27.609f, 28.891f, 26.842f, 30.437f);
                instancePath.cubicTo(23.199f, 37.657f, 19.553f, 44.875f, 15.911f, 52.096f);
                instancePath.cubicTo(23.174f, 48.431f, 30.436f, 44.765f, 37.699f, 41.1f);
                instancePath.cubicTo(39.147f, 40.347f, 40.354f, 39.139f, 41.103f, 37.688f);
                instancePath.cubicTo(44.772f, 30.427f, 48.437f, 23.165f, 52.104f, 15.904f);
                instancePath.cubicTo(44.882f, 19.55f, 37.66f, 23.195f, 30.439f, 26.843f);
                instancePath.lineTo(30.439f, 26.843f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(33.346f, 31.079f);
                instancePath2.cubicTo(34.928f, 30.679f, 36.668f, 31.815f, 36.943f, 33.421f);
                instancePath2.cubicTo(37.306f, 35.014f, 36.122f, 36.729f, 34.507f, 36.961f);
                instancePath2.cubicTo(32.928f, 37.277f, 31.267f, 36.087f, 31.044f, 34.497f);
                instancePath2.cubicTo(30.753f, 32.98f, 31.835f, 31.384f, 33.346f, 31.079f);
                instancePath2.lineTo(33.346f, 31.079f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
