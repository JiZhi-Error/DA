package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class force_notify_banner_icon extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-9473160);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 39.0f, 0.0f, 1.0f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(-9473160);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(10.5f, 7.5f);
                instancePath.lineTo(10.5f, 10.5f);
                instancePath.lineTo(3.0f, 10.5f);
                instancePath.lineTo(3.0f, 67.5f);
                instancePath.lineTo(39.0f, 67.5f);
                instancePath.lineTo(39.0f, 42.5f);
                instancePath.lineTo(42.0f, 42.5f);
                instancePath.lineTo(42.0f, 67.5f);
                instancePath.cubicTo(42.0f, 69.15685f, 40.656853f, 70.5f, 39.0f, 70.5f);
                instancePath.lineTo(3.0f, 70.5f);
                instancePath.cubicTo(1.3431457f, 70.5f, 2.0290612E-16f, 69.15685f, 0.0f, 67.5f);
                instancePath.lineTo(4.440892E-16f, 10.5f);
                instancePath.cubicTo(2.4118308E-16f, 8.843145f, 1.3431457f, 7.5f, 3.0f, 7.5f);
                instancePath.lineTo(10.5f, 7.5f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(19.736181f, 0.0f);
                instancePath2.lineTo(22.228626f, 0.0f);
                instancePath2.cubicTo(22.580238f, 0.0f, 22.865276f, 0.28781694f, 22.865276f, 0.64285713f);
                instancePath2.cubicTo(22.865276f, 0.6517809f, 22.865093f, 0.66070366f, 22.864725f, 0.6696196f);
                instancePath2.lineTo(22.281128f, 14.812477f);
                instancePath2.cubicTo(22.26692f, 15.156808f, 21.986332f, 15.428572f, 21.64503f, 15.428572f);
                instancePath2.lineTo(20.319778f, 15.428572f);
                instancePath2.cubicTo(19.978476f, 15.428572f, 19.697887f, 15.156808f, 19.68368f, 14.812477f);
                instancePath2.lineTo(19.100082f, 0.6696196f);
                instancePath2.cubicTo(19.085445f, 0.31488723f, 19.35837f, 0.015337827f, 19.709679f, 5.573102E-4f);
                instancePath2.cubicTo(19.718508f, 1.8581032E-4f, 19.727345f, 0.0f, 19.736181f, 0.0f);
                instancePath2.close();
                instancePath2.moveTo(41.70983f, 8.148046f);
                instancePath2.lineTo(43.472256f, 9.92765f);
                instancePath2.cubicTo(43.720886f, 10.178701f, 43.720886f, 10.585736f, 43.472256f, 10.836787f);
                instancePath2.cubicTo(43.466007f, 10.843098f, 43.45963f, 10.849276f, 43.453125f, 10.855318f);
                instancePath2.lineTo(33.1365f, 20.43914f);
                instancePath2.cubicTo(32.885323f, 20.672474f, 32.49661f, 20.6643f, 32.255272f, 20.42061f);
                instancePath2.lineTo(31.318178f, 19.47438f);
                instancePath2.cubicTo(31.07684f, 19.23069f, 31.068745f, 18.838186f, 31.299826f, 18.584562f);
                instancePath2.lineTo(40.791122f, 8.167363f);
                instancePath2.cubicTo(41.029182f, 7.9060783f, 41.43194f, 7.8891335f, 41.6907f, 8.129516f);
                instancePath2.cubicTo(41.697205f, 8.135557f, 41.703583f, 8.141735f, 41.70983f, 8.148046f);
                instancePath2.close();
                instancePath2.moveTo(51.541637f, 29.598772f);
                instancePath2.lineTo(51.541637f, 32.115513f);
                instancePath2.cubicTo(51.541637f, 32.470554f, 51.2566f, 32.75837f, 50.904987f, 32.75837f);
                instancePath2.cubicTo(50.89615f, 32.75837f, 50.887314f, 32.758186f, 50.878483f, 32.757812f);
                instancePath2.lineTo(36.872166f, 32.16853f);
                instancePath2.cubicTo(36.53116f, 32.154182f, 36.26202f, 31.87086f, 36.26202f, 31.526228f);
                instancePath2.lineTo(36.26202f, 30.188057f);
                instancePath2.cubicTo(36.26202f, 29.843428f, 36.53116f, 29.560104f, 36.872166f, 29.545757f);
                instancePath2.lineTo(50.878483f, 28.956472f);
                instancePath2.cubicTo(51.22979f, 28.941692f, 51.526447f, 29.217278f, 51.541084f, 29.57201f);
                instancePath2.cubicTo(51.541454f, 29.580925f, 51.541637f, 29.589848f, 51.541637f, 29.598772f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
