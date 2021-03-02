package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class media_download_in_gallery_noraml extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(Integer.MIN_VALUE);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 9.6f);
                instancePath.cubicTo(0.0f, 4.298066f, 4.298066f, 0.0f, 9.6f, 0.0f);
                instancePath.lineTo(86.4f, 0.0f);
                instancePath.cubicTo(91.701935f, 0.0f, 96.0f, 4.298066f, 96.0f, 9.6f);
                instancePath.lineTo(96.0f, 86.4f);
                instancePath.cubicTo(96.0f, 91.701935f, 91.701935f, 96.0f, 86.4f, 96.0f);
                instancePath.lineTo(9.6f, 96.0f);
                instancePath.cubicTo(4.298066f, 96.0f, 0.0f, 91.701935f, 0.0f, 86.4f);
                instancePath.lineTo(0.0f, 9.6f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 75.94388f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(50.0103f, 25.920588f);
                instancePath2.lineTo(50.0103f, 54.991493f);
                instancePath2.lineTo(46.988003f, 54.989735f);
                instancePath2.lineTo(46.988003f, 25.92229f);
                instancePath2.lineTo(41.28f, 31.652632f);
                instancePath2.lineTo(39.0f, 29.363708f);
                instancePath2.lineTo(46.587086f, 21.74693f);
                instancePath2.cubicTo(47.639442f, 20.690456f, 49.348984f, 20.687119f, 50.405457f, 21.739473f);
                instancePath2.cubicTo(50.407948f, 21.741953f, 50.41043f, 21.744438f, 50.412914f, 21.74693f);
                instancePath2.lineTo(50.78f, 22.115454f);
                instancePath2.lineTo(58.0f, 29.363708f);
                instancePath2.lineTo(55.72f, 31.652632f);
                instancePath2.lineTo(50.0103f, 25.920588f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(66.997154f, 35.043194f);
                instancePath3.lineTo(59.003365f, 35.039516f);
                instancePath3.lineTo(59.003365f, 32.0f);
                instancePath3.lineTo(67.31531f, 32.0f);
                instancePath3.cubicTo(68.79296f, 32.0f, 70.0f, 33.218624f, 70.0f, 34.721878f);
                instancePath3.lineTo(70.0f, 68.27812f);
                instancePath3.cubicTo(70.0f, 69.77295f, 68.80181f, 71.0f, 67.32376f, 71.0f);
                instancePath3.lineTo(29.676235f, 71.0f);
                instancePath3.cubicTo(28.206472f, 71.0f, 27.0f, 69.78137f, 27.0f, 68.27812f);
                instancePath3.lineTo(27.0f, 34.721878f);
                instancePath3.cubicTo(27.0f, 33.227047f, 28.201979f, 32.0f, 29.684696f, 32.0f);
                instancePath3.lineTo(37.994774f, 32.0f);
                instancePath3.lineTo(37.994774f, 35.045048f);
                instancePath3.lineTo(29.99933f, 35.045048f);
                instancePath3.lineTo(29.99933f, 67.92924f);
                instancePath3.lineTo(66.997154f, 67.932915f);
                instancePath3.lineTo(66.997154f, 35.043194f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
