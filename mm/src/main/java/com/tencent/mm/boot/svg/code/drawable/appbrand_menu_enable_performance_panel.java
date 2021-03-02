package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class appbrand_menu_enable_performance_panel extends c {
    private final int height = 25;
    private final int width = 28;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 28;
            case 1:
                return 25;
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
                canvas.saveLayerAlpha(null, 230, 31);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -298.0f, 0.0f, 1.0f, -619.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 296.0f, 0.0f, 1.0f, 616.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(24.095997f, 27.803995f);
                instancePath.lineTo(23.107147f, 26.54546f);
                instancePath.cubicTo(26.016209f, 24.37597f, 27.9f, 20.907978f, 27.9f, 17.0f);
                instancePath.cubicTo(27.9f, 10.427812f, 22.57219f, 5.1f, 16.0f, 5.1f);
                instancePath.cubicTo(9.427812f, 5.1f, 4.1f, 10.427812f, 4.1f, 17.0f);
                instancePath.cubicTo(4.1f, 20.907978f, 5.983792f, 24.37597f, 8.892853f, 26.54546f);
                instancePath.lineTo(7.904004f, 27.803995f);
                instancePath.cubicTo(4.6227207f, 25.341223f, 2.5f, 21.418505f, 2.5f, 17.0f);
                instancePath.cubicTo(2.5f, 9.544156f, 8.544156f, 3.5f, 16.0f, 3.5f);
                instancePath.cubicTo(23.455845f, 3.5f, 29.5f, 9.544156f, 29.5f, 17.0f);
                instancePath.cubicTo(29.5f, 21.418505f, 27.37728f, 25.341223f, 24.095997f, 27.803995f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint5.setStrokeWidth(1.6f);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 0.9838699f, -0.17888543f, 2.886728f, 0.17888543f, 0.9838699f, -3.0940008f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(16.585722f, 17.916044f);
                instancePath2.lineTo(20.614008f, 11.004251f);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(16.0f, 15.5f);
                instancePath3.cubicTo(17.10457f, 15.5f, 18.0f, 16.39543f, 18.0f, 17.5f);
                instancePath3.cubicTo(18.0f, 18.60457f, 17.10457f, 19.5f, 16.0f, 19.5f);
                instancePath3.cubicTo(14.895431f, 19.5f, 14.0f, 18.60457f, 14.0f, 17.5f);
                instancePath3.cubicTo(14.0f, 16.39543f, 14.895431f, 15.5f, 16.0f, 15.5f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
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
