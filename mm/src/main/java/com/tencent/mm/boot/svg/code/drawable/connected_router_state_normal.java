package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class connected_router_state_normal extends c {
    private final int height = 240;
    private final int width = 240;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 240;
            case 1:
                return 240;
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
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(114.11689f, 70.98039f);
                instancePath.cubicTo(111.951485f, 70.98039f, 110.27686f, 72.72528f, 110.37761f, 74.90139f);
                instancePath.lineTo(113.37151f, 139.56976f);
                instancePath.cubicTo(113.42262f, 140.6737f, 114.36253f, 141.56863f, 115.46362f, 141.56863f);
                instancePath.lineTo(124.53638f, 141.56863f);
                instancePath.cubicTo(125.64071f, 141.56863f, 126.57727f, 140.67613f, 126.62849f, 139.56976f);
                instancePath.lineTo(129.62239f, 74.90139f);
                instancePath.cubicTo(129.72266f, 72.73588f, 128.0466f, 70.98039f, 125.88311f, 70.98039f);
                instancePath.lineTo(114.11689f, 70.98039f);
                instancePath.close();
                instancePath.moveTo(120.0f, 172.94118f);
                instancePath.cubicTo(125.41456f, 172.94118f, 129.80392f, 168.5518f, 129.80392f, 163.13725f);
                instancePath.cubicTo(129.80392f, 157.7227f, 125.41456f, 153.33333f, 120.0f, 153.33333f);
                instancePath.cubicTo(114.58544f, 153.33333f, 110.196075f, 157.7227f, 110.196075f, 163.13725f);
                instancePath.cubicTo(110.196075f, 168.5518f, 114.58544f, 172.94118f, 120.0f, 172.94118f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 58.0f, 0.0f, 1.0f, 75.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-16139513);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(88.503105f, 63.260868f);
                instancePath2.cubicTo(81.83925f, 55.480328f, 72.46273f, 51.086956f, 62.509315f, 51.086956f);
                instancePath2.cubicTo(51.689445f, 51.086956f, 42.312923f, 55.480328f, 35.649067f, 63.260868f);
                instancePath2.lineTo(42.580746f, 70.21739f);
                instancePath2.cubicTo(47.99571f, 65.064156f, 54.781292f, 61.847816f, 62.509315f, 62.391304f);
                instancePath2.cubicTo(69.71429f, 61.847816f, 76.405556f, 64.96478f, 81.57143f, 70.21739f);
                instancePath2.lineTo(88.503105f, 63.260868f);
                instancePath2.close();
                instancePath2.moveTo(61.642857f, 25.869566f);
                instancePath2.cubicTo(44.52152f, 25.869566f, 28.799698f, 32.994526f, 17.453417f, 45.0f);
                instancePath2.lineTo(25.251553f, 52.826088f);
                instancePath2.cubicTo(35.159626f, 43.23779f, 48.249474f, 37.29962f, 62.509315f, 37.173912f);
                instancePath2.cubicTo(76.95079f, 37.29962f, 89.85206f, 43.048466f, 98.90062f, 51.95652f);
                instancePath2.lineTo(106.69876f, 45.0f);
                instancePath2.cubicTo(95.32615f, 33.14707f, 79.4547f, 25.869566f, 61.642857f, 25.869566f);
                instancePath2.close();
                instancePath2.moveTo(124.02795f, 26.73913f);
                instancePath2.cubicTo(108.21251f, 10.5176935f, 86.30065f, 0.65217394f, 62.509315f, 0.65217394f);
                instancePath2.cubicTo(37.861656f, 0.65217394f, 15.941242f, 10.526303f, 0.124223605f, 26.73913f);
                instancePath2.lineTo(7.9223604f, 34.565216f);
                instancePath2.cubicTo(22.125067f, 20.522926f, 41.417408f, 11.826344f, 62.509315f, 11.956522f);
                instancePath2.cubicTo(83.71855f, 11.826344f, 102.73295f, 20.24566f, 116.22981f, 33.695652f);
                instancePath2.lineTo(124.02795f, 26.73913f);
                instancePath2.close();
                instancePath2.moveTo(71.17391f, 80.652176f);
                instancePath2.cubicTo(68.97959f, 77.84855f, 65.76467f, 76.304344f, 62.509315f, 76.304344f);
                instancePath2.cubicTo(58.48254f, 76.304344f, 55.174686f, 77.95143f, 52.97826f, 80.652176f);
                instancePath2.lineTo(61.642857f, 89.347824f);
                instancePath2.lineTo(71.17391f, 80.652176f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.095238f, 0.0f, 1.0f, 0.652174f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
