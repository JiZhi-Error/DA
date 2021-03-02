package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fts_setmode_voice_pressed extends c {
    private final int height = 144;
    private final int width = 144;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                instancePaint3.setColor(-15028967);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(41.62317f, 65.78919f);
                instancePath.lineTo(41.9778f, 65.99241f);
                instancePath.cubicTo(51.303997f, 69.16349f, 62.08437f, 65.1643f, 67.361f, 56.093422f);
                instancePath.lineTo(68.91121f, 53.428516f);
                instancePath.lineTo(65.56606f, 51.511677f);
                instancePath.lineTo(64.015854f, 54.176582f);
                instancePath.cubicTo(59.03817f, 62.73355f, 48.512413f, 65.72372f, 40.710613f, 61.253113f);
                instancePath.cubicTo(32.254654f, 56.407665f, 29.600893f, 45.86535f, 34.57858f, 37.30838f);
                instancePath.lineTo(36.128788f, 34.643475f);
                instancePath.lineTo(36.274845f, 34.194435f);
                instancePath.lineTo(32.78364f, 32.726635f);
                instancePath.lineTo(31.233435f, 35.39154f);
                instancePath.cubicTo(26.03302f, 44.331394f, 27.804018f, 55.403114f, 34.96902f, 61.87707f);
                instancePath.lineTo(29.981249f, 70.51614f);
                instancePath.lineTo(30.39813f, 75.44433f);
                instancePath.cubicTo(30.483181f, 76.449745f, 31.284433f, 76.90377f, 32.189484f, 76.47857f);
                instancePath.lineTo(36.66586f, 74.3755f);
                instancePath.lineTo(41.62317f, 65.78919f);
                instancePath.close();
                instancePath.moveTo(96.0f, 48.0f);
                instancePath.cubicTo(96.0f, 74.51105f, 74.50971f, 96.0f, 48.0f, 96.0f);
                instancePath.cubicTo(21.490286f, 96.0f, 0.0f, 74.51105f, 0.0f, 48.0f);
                instancePath.cubicTo(0.0f, 21.488955f, 21.490286f, 0.0f, 48.0f, 0.0f);
                instancePath.cubicTo(74.50971f, 0.0f, 96.0f, 21.488955f, 96.0f, 48.0f);
                instancePath.close();
                instancePath.moveTo(63.940453f, 21.10892f);
                instancePath.cubicTo(58.015858f, 17.731424f, 50.43693f, 19.741205f, 47.023098f, 25.57968f);
                instancePath.lineTo(38.81864f, 39.61127f);
                instancePath.cubicTo(35.400043f, 45.457897f, 37.430252f, 52.934784f, 43.35615f, 56.31302f);
                instancePath.cubicTo(49.280746f, 59.690514f, 56.859673f, 57.680733f, 60.273506f, 51.84226f);
                instancePath.lineTo(68.47796f, 37.81067f);
                instancePath.cubicTo(71.89656f, 31.96404f, 69.866356f, 24.487156f, 63.940453f, 21.10892f);
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
