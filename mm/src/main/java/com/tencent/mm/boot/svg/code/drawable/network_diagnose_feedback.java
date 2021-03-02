package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.a;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class network_diagnose_feedback extends c {
    private final int height = a.C0691a.CTRL_INDEX;
    private final int width = 152;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 152;
            case 1:
                return a.C0691a.CTRL_INDEX;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.333333f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint4.setStrokeWidth(4.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(2.0f, 16.0f);
                instancePath.cubicTo(2.0f, 8.268013f, 8.268013f, 2.0f, 16.0f, 2.0f);
                instancePath.lineTo(133.33333f, 2.0f);
                instancePath.cubicTo(141.0653f, 2.0f, 147.33333f, 8.268013f, 147.33333f, 16.0f);
                instancePath.lineTo(147.33333f, 250.66666f);
                instancePath.cubicTo(147.33333f, 258.39865f, 141.0653f, 264.66666f, 133.33333f, 264.66666f);
                instancePath.lineTo(16.0f, 264.66666f);
                instancePath.cubicTo(8.268013f, 264.66666f, 2.0f, 258.39865f, 2.0f, 250.66666f);
                instancePath.lineTo(2.0f, 16.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint5.setStrokeWidth(2.0f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(11.666667f, 29.0f);
                instancePath2.lineTo(11.666667f, 232.33333f);
                instancePath2.lineTo(137.66667f, 232.33333f);
                instancePath2.lineTo(137.66667f, 29.0f);
                instancePath2.lineTo(11.666667f, 29.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(65.333336f, 13.333333f);
                instancePath3.lineTo(85.333336f, 13.333333f);
                instancePath3.lineTo(85.333336f, 17.333332f);
                instancePath3.lineTo(65.333336f, 17.333332f);
                instancePath3.lineTo(65.333336f, 13.333333f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 42.666668f, 0.0f, 1.0f, 91.333336f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                instancePaint7.setColor(-15028967);
                instancePaint7.setStrokeWidth(3.0f);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(66.666664f, 33.744858f);
                instancePath4.cubicTo(66.666664f, 14.923457f, 51.74321f, 0.0f, 32.92181f, 0.0f);
                instancePath4.cubicTo(14.923457f, 0.0f, 0.0f, 14.923457f, 0.0f, 33.744858f);
                instancePath4.cubicTo(0.0f, 51.74321f, 14.923457f, 66.666664f, 32.92181f, 66.666664f);
                instancePath4.cubicTo(51.74321f, 66.666664f, 66.666664f, 51.74321f, 66.666664f, 33.744858f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-15028967);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(16.874653f, 34.66012f);
                instancePath5.lineTo(18.06757f, 33.036938f);
                instancePath5.lineTo(18.06757f, 33.036938f);
                instancePath5.cubicTo(18.28561f, 32.740253f, 18.702879f, 32.676502f, 18.999563f, 32.894543f);
                instancePath5.cubicTo(19.003172f, 32.897194f, 19.006756f, 32.899883f, 19.010311f, 32.90261f);
                instancePath5.lineTo(27.124714f, 39.121834f);
                instancePath5.lineTo(27.124714f, 39.121834f);
                instancePath5.cubicTo(27.619293f, 39.5009f, 28.310467f, 39.48685f, 28.789234f, 39.088f);
                instancePath5.lineTo(49.794125f, 21.589226f);
                instancePath5.lineTo(49.794125f, 21.589226f);
                instancePath5.cubicTo(50.05779f, 21.369574f, 50.445126f, 21.385962f, 50.689293f, 21.6271f);
                instancePath5.lineTo(51.706726f, 22.631914f);
                instancePath5.lineTo(51.706726f, 22.631914f);
                instancePath5.cubicTo(51.968697f, 22.890633f, 51.97133f, 23.312735f, 51.71261f, 23.574705f);
                instancePath5.cubicTo(51.71039f, 23.576954f, 51.70815f, 23.579187f, 51.7059f, 23.581406f);
                instancePath5.lineTo(28.928864f, 45.99741f);
                instancePath5.lineTo(28.928864f, 45.99741f);
                instancePath5.cubicTo(28.404022f, 46.51393f, 27.559828f, 46.507187f, 27.043306f, 45.982346f);
                instancePath5.cubicTo(27.040442f, 45.979435f, 27.037592f, 45.976513f, 27.034756f, 45.973576f);
                instancePath5.lineTo(16.932417f, 35.518158f);
                instancePath5.lineTo(16.932417f, 35.518158f);
                instancePath5.cubicTo(16.706604f, 35.284454f, 16.682201f, 34.92198f, 16.874653f, 34.66012f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 2);
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
