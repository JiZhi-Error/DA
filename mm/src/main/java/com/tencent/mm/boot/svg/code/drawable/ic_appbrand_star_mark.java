package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ic_appbrand_star_mark extends c {
    private final int height = 18;
    private final int width = 19;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 19;
            case 1:
                return 18;
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
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-15616);
                instancePaint5.setColor(-15616);
                instancePaint5.setStrokeWidth(1.2f);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -321.0f, 0.0f, 1.0f, -308.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 227.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 49.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 16.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray5 = c.setMatrixFloatArray(matrixFloatArray4, 1.0f, 0.0f, 60.0f, 0.0f, 1.0f, 13.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray5);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(245.3613f, 20.165895f);
                instancePath.lineTo(250.31267f, 17.562805f);
                instancePath.lineTo(255.26404f, 20.165895f);
                instancePath.cubicTo(255.34189f, 20.206831f, 255.43108f, 20.220957f, 255.51779f, 20.206087f);
                instancePath.cubicTo(255.73552f, 20.168741f, 255.88176f, 19.96196f, 255.8444f, 19.744225f);
                instancePath.lineTo(254.89879f, 14.230793f);
                instancePath.lineTo(258.90454f, 10.326159f);
                instancePath.cubicTo(258.96753f, 10.264755f, 259.0085f, 10.1842985f, 259.02118f, 10.097244f);
                instancePath.cubicTo(259.05292f, 9.878626f, 258.90146f, 9.675649f, 258.68283f, 9.643882f);
                instancePath.lineTo(253.14703f, 8.839482f);
                instancePath.lineTo(250.67136f, 3.8231966f);
                instancePath.cubicTo(250.63242f, 3.7443118f, 250.56857f, 3.6804607f, 250.48969f, 3.6415286f);
                instancePath.cubicTo(250.29158f, 3.5437596f, 250.05174f, 3.6250954f, 249.95396f, 3.8231966f);
                instancePath.lineTo(247.47829f, 8.839482f);
                instancePath.lineTo(241.94247f, 9.643882f);
                instancePath.cubicTo(241.85542f, 9.656531f, 241.77496f, 9.697526f, 241.71356f, 9.76052f);
                instancePath.cubicTo(241.55937f, 9.918714f, 241.5626f, 10.171959f, 241.7208f, 10.326159f);
                instancePath.lineTo(245.72653f, 14.230793f);
                instancePath.lineTo(244.78091f, 19.744225f);
                instancePath.cubicTo(244.76604f, 19.830929f, 244.78017f, 19.920115f, 244.8211f, 19.99798f);
                instancePath.cubicTo(244.9239f, 20.193518f, 245.16576f, 20.268696f, 245.3613f, 20.165895f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
