package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class lucky_money_group_icon_new extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -301.0f, 0.0f, 1.0f, -363.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 301.0f, 0.0f, 1.0f, 363.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-3232652);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 5.3333335f);
                instancePath.cubicTo(0.0f, 2.3878145f, 2.3878145f, 0.0f, 5.3333335f, 0.0f);
                instancePath.lineTo(42.666668f, 0.0f);
                instancePath.cubicTo(45.612186f, 0.0f, 48.0f, 2.3878145f, 48.0f, 5.3333335f);
                instancePath.lineTo(48.0f, 42.666668f);
                instancePath.cubicTo(48.0f, 45.612186f, 45.612186f, 48.0f, 42.666668f, 48.0f);
                instancePath.lineTo(5.3333335f, 48.0f);
                instancePath.cubicTo(2.3878145f, 48.0f, 0.0f, 45.612186f, 0.0f, 42.666668f);
                instancePath.lineTo(0.0f, 5.3333335f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(21.169895f, 37.390083f);
                instancePath2.cubicTo(23.281897f, 36.21675f, 24.80723f, 34.54475f, 25.745895f, 32.374084f);
                instancePath2.cubicTo(26.332563f, 30.907415f, 26.772562f, 29.147415f, 27.036562f, 27.064749f);
                instancePath2.lineTo(31.641895f, 27.064749f);
                instancePath2.lineTo(31.641895f, 37.126083f);
                instancePath2.lineTo(34.34056f, 37.126083f);
                instancePath2.lineTo(34.34056f, 27.064749f);
                instancePath2.lineTo(38.065895f, 27.064749f);
                instancePath2.lineTo(38.065895f, 24.454082f);
                instancePath2.lineTo(34.34056f, 24.454082f);
                instancePath2.lineTo(34.34056f, 18.147415f);
                instancePath2.lineTo(37.47923f, 18.147415f);
                instancePath2.lineTo(37.47923f, 15.536749f);
                instancePath2.lineTo(33.900562f, 15.536749f);
                instancePath2.cubicTo(34.66323f, 14.158083f, 35.36723f, 12.603416f, 36.01256f, 10.872749f);
                instancePath2.lineTo(33.401897f, 9.934083f);
                instancePath2.cubicTo(32.697895f, 11.928749f, 31.905895f, 13.806083f, 30.996563f, 15.536749f);
                instancePath2.lineTo(26.156563f, 15.536749f);
                instancePath2.lineTo(28.004562f, 14.627416f);
                instancePath2.cubicTo(27.036562f, 12.984749f, 26.039228f, 11.459416f, 25.041895f, 10.051416f);
                instancePath2.lineTo(22.724562f, 11.136749f);
                instancePath2.cubicTo(23.721895f, 12.427416f, 24.660563f, 13.894083f, 25.540562f, 15.536749f);
                instancePath2.lineTo(21.375229f, 15.536749f);
                instancePath2.lineTo(21.375229f, 18.147415f);
                instancePath2.lineTo(24.63123f, 18.147415f);
                instancePath2.lineTo(24.63123f, 23.046083f);
                instancePath2.cubicTo(24.63123f, 23.515415f, 24.601896f, 23.984749f, 24.572563f, 24.454082f);
                instancePath2.lineTo(20.847229f, 24.454082f);
                instancePath2.lineTo(20.847229f, 27.064749f);
                instancePath2.lineTo(24.337896f, 27.064749f);
                instancePath2.cubicTo(24.161896f, 28.355415f, 23.897896f, 29.499416f, 23.545897f, 30.526083f);
                instancePath2.cubicTo(22.841896f, 32.315414f, 21.55123f, 33.811417f, 19.644562f, 34.98475f);
                instancePath2.lineTo(21.169895f, 37.390083f);
                instancePath2.close();
                instancePath2.moveTo(14.775229f, 37.038082f);
                instancePath2.cubicTo(16.681896f, 37.038082f, 17.649897f, 36.070084f, 17.649897f, 34.163418f);
                instancePath2.lineTo(17.649897f, 25.803415f);
                instancePath2.cubicTo(18.559229f, 25.363417f, 19.468563f, 24.894083f, 20.348562f, 24.395416f);
                instancePath2.lineTo(20.348562f, 21.550083f);
                instancePath2.cubicTo(19.468563f, 22.078083f, 18.559229f, 22.547417f, 17.649897f, 23.016748f);
                instancePath2.lineTo(17.649897f, 18.030083f);
                instancePath2.lineTo(20.407228f, 18.030083f);
                instancePath2.lineTo(20.407228f, 15.360749f);
                instancePath2.lineTo(17.649897f, 15.360749f);
                instancePath2.lineTo(17.649897f, 10.286082f);
                instancePath2.lineTo(14.833896f, 10.286082f);
                instancePath2.lineTo(14.833896f, 15.360749f);
                instancePath2.lineTo(11.343229f, 15.360749f);
                instancePath2.lineTo(11.343229f, 18.030083f);
                instancePath2.lineTo(14.833896f, 18.030083f);
                instancePath2.lineTo(14.833896f, 24.248749f);
                instancePath2.cubicTo(13.543229f, 24.718082f, 12.2525625f, 25.12875f, 10.932563f, 25.451416f);
                instancePath2.lineTo(11.636562f, 28.267416f);
                instancePath2.cubicTo(12.692562f, 27.886084f, 13.777896f, 27.475416f, 14.833896f, 27.064749f);
                instancePath2.lineTo(14.833896f, 33.459415f);
                instancePath2.cubicTo(14.833896f, 34.134083f, 14.481895f, 34.486084f, 13.807229f, 34.486084f);
                instancePath2.cubicTo(13.161896f, 34.486084f, 12.457896f, 34.427418f, 11.724563f, 34.339417f);
                instancePath2.lineTo(12.340563f, 37.038082f);
                instancePath2.lineTo(14.775229f, 37.038082f);
                instancePath2.close();
                instancePath2.moveTo(31.641895f, 24.454082f);
                instancePath2.lineTo(27.271229f, 24.454082f);
                instancePath2.lineTo(27.329895f, 23.046083f);
                instancePath2.lineTo(27.329895f, 18.147415f);
                instancePath2.lineTo(31.641895f, 18.147415f);
                instancePath2.lineTo(31.641895f, 24.454082f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
