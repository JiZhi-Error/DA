package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_attach_file_icon_rar extends c {
    private final int height = 90;
    private final int width = 90;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-7645398);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(46.0f, 0.0f);
                instancePath.lineTo(68.0f, 22.0f);
                instancePath.lineTo(68.0f, 87.0f);
                instancePath.cubicTo(68.0f, 88.65685f, 66.65685f, 90.0f, 65.0f, 90.0f);
                instancePath.lineTo(3.0f, 90.0f);
                instancePath.cubicTo(1.3431457f, 90.0f, 2.0290612E-16f, 88.65685f, 0.0f, 87.0f);
                instancePath.lineTo(0.0f, 3.0f);
                instancePath.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                instancePath.lineTo(46.0f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-9485023);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(68.0f, 22.0f);
                instancePath2.lineTo(49.0f, 22.0f);
                instancePath2.cubicTo(47.343147f, 22.0f, 46.0f, 20.656855f, 46.0f, 19.0f);
                instancePath2.lineTo(46.0f, 0.0f);
                instancePath2.lineTo(68.0f, 22.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(32.714287f, 22.67442f);
                instancePath3.lineTo(32.714287f, 15.116279f);
                instancePath3.lineTo(29.5f, 15.116279f);
                instancePath3.cubicTo(28.671574f, 15.116279f, 28.0f, 14.444706f, 28.0f, 13.616279f);
                instancePath3.lineTo(28.0f, 9.05814f);
                instancePath3.cubicTo(28.0f, 8.2297125f, 28.671574f, 7.5581393f, 29.5f, 7.5581393f);
                instancePath3.lineTo(32.714287f, 7.5581393f);
                instancePath3.lineTo(32.714287f, 0.0f);
                instancePath3.lineTo(37.5f, 2.220446E-16f);
                instancePath3.cubicTo(38.328426f, -6.659261E-16f, 39.0f, 0.67157286f, 39.0f, 1.5f);
                instancePath3.lineTo(39.0f, 6.0581393f);
                instancePath3.cubicTo(39.0f, 6.8865666f, 38.328426f, 7.5581393f, 37.5f, 7.5581393f);
                instancePath3.lineTo(34.285713f, 7.5581393f);
                instancePath3.lineTo(34.285713f, 15.116279f);
                instancePath3.lineTo(37.5f, 15.116279f);
                instancePath3.cubicTo(38.328426f, 15.116279f, 39.0f, 15.787852f, 39.0f, 16.61628f);
                instancePath3.lineTo(39.0f, 21.17442f);
                instancePath3.cubicTo(39.0f, 22.002846f, 38.328426f, 22.67442f, 37.5f, 22.67442f);
                instancePath3.lineTo(34.285713f, 22.67442f);
                instancePath3.lineTo(34.285713f, 30.232557f);
                instancePath3.lineTo(37.5f, 30.232557f);
                instancePath3.cubicTo(38.328426f, 30.232557f, 39.0f, 30.90413f, 39.0f, 31.732557f);
                instancePath3.lineTo(39.0f, 36.2907f);
                instancePath3.cubicTo(39.0f, 37.119125f, 38.328426f, 37.7907f, 37.5f, 37.7907f);
                instancePath3.lineTo(32.714287f, 37.7907f);
                instancePath3.lineTo(32.714287f, 30.232557f);
                instancePath3.lineTo(29.5f, 30.232557f);
                instancePath3.cubicTo(28.671574f, 30.232557f, 28.0f, 29.560986f, 28.0f, 28.732557f);
                instancePath3.lineTo(28.0f, 24.17442f);
                instancePath3.cubicTo(28.0f, 23.345991f, 28.671574f, 22.67442f, 29.5f, 22.67442f);
                instancePath3.lineTo(32.714287f, 22.67442f);
                instancePath3.close();
                instancePath3.moveTo(29.5f, 42.32558f);
                instancePath3.lineTo(37.5f, 42.32558f);
                instancePath3.cubicTo(38.328426f, 42.32558f, 39.0f, 42.997154f, 39.0f, 43.82558f);
                instancePath3.lineTo(39.0f, 63.5f);
                instancePath3.cubicTo(39.0f, 64.32843f, 38.328426f, 65.0f, 37.5f, 65.0f);
                instancePath3.lineTo(29.5f, 65.0f);
                instancePath3.cubicTo(28.671574f, 65.0f, 28.0f, 64.32843f, 28.0f, 63.5f);
                instancePath3.lineTo(28.0f, 43.82558f);
                instancePath3.cubicTo(28.0f, 42.997154f, 28.671574f, 42.32558f, 29.5f, 42.32558f);
                instancePath3.close();
                instancePath3.moveTo(30.357143f, 54.418606f);
                instancePath3.lineTo(30.357143f, 62.73256f);
                instancePath3.lineTo(36.642857f, 62.73256f);
                instancePath3.lineTo(36.642857f, 54.418606f);
                instancePath3.lineTo(30.357143f, 54.418606f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
