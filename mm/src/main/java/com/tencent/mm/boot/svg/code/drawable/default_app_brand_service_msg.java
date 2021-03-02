package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class default_app_brand_service_msg extends c {
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
                instancePaint3.setColor(-16268960);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(144.0f, 0.0f);
                instancePath.lineTo(144.0f, 144.0f);
                instancePath.lineTo(0.0f, 144.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 28.0f, 0.0f, 1.0f, 37.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(51.87223f, -4.2966084E-13f);
                instancePath2.cubicTo(53.655266f, -4.2998837E-13f, 54.301838f, 0.18565123f, 54.95369f, 0.5342654f);
                instancePath2.cubicTo(55.605545f, 0.8828796f, 56.11712f, 1.3944567f, 56.465736f, 2.0463085f);
                instancePath2.cubicTo(56.81435f, 2.6981604f, 57.0f, 3.344733f, 57.0f, 5.1277704f);
                instancePath2.lineTo(57.0f, 38.87223f);
                instancePath2.cubicTo(57.0f, 40.655266f, 56.81435f, 41.301838f, 56.465736f, 41.95369f);
                instancePath2.cubicTo(56.11712f, 42.605545f, 55.605545f, 43.11712f, 54.95369f, 43.465736f);
                instancePath2.cubicTo(54.301838f, 43.81435f, 53.655266f, 44.0f, 51.87223f, 44.0f);
                instancePath2.lineTo(23.799f, 44.0f);
                instancePath2.lineTo(14.804203f, 51.4965f);
                instancePath2.cubicTo(14.337499f, 51.885418f, 13.643877f, 51.82236f, 13.254956f, 51.355656f);
                instancePath2.cubicTo(13.090218f, 51.15797f, 13.0f, 50.908783f, 13.0f, 50.651455f);
                instancePath2.lineTo(12.999f, 44.0f);
                instancePath2.lineTo(5.1277704f, 44.0f);
                instancePath2.cubicTo(3.344733f, 44.0f, 2.6981604f, 43.81435f, 2.0463085f, 43.465736f);
                instancePath2.cubicTo(1.3944567f, 43.11712f, 0.8828796f, 42.605545f, 0.5342654f, 41.95369f);
                instancePath2.cubicTo(0.18565123f, 41.301838f, 8.7152676E-17f, 40.655266f, -1.3120644E-16f, 38.87223f);
                instancePath2.lineTo(1.4501764E-16f, 5.1277704f);
                instancePath2.cubicTo(-7.334147E-17f, 3.344733f, 0.18565123f, 2.6981604f, 0.5342654f, 2.0463085f);
                instancePath2.cubicTo(0.8828796f, 1.3944567f, 1.3944567f, 0.8828796f, 2.0463085f, 0.5342654f);
                instancePath2.cubicTo(2.6981604f, 0.18565123f, 3.344733f, -4.2974763E-13f, 5.1277704f, -4.3007516E-13f);
                instancePath2.lineTo(51.87223f, -4.2966084E-13f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(82.87223f, 20.9f);
                instancePath3.cubicTo(84.655266f, 20.9f, 85.30184f, 21.085651f, 85.95369f, 21.434265f);
                instancePath3.cubicTo(86.605545f, 21.782879f, 87.11712f, 22.294456f, 87.46574f, 22.946308f);
                instancePath3.cubicTo(87.81435f, 23.59816f, 88.0f, 24.244734f, 88.0f, 26.027771f);
                instancePath3.lineTo(88.0f, 26.027771f);
                instancePath3.lineTo(88.0f, 56.77223f);
                instancePath3.cubicTo(88.0f, 58.555267f, 87.81435f, 59.20184f, 87.46574f, 59.85369f);
                instancePath3.cubicTo(87.11712f, 60.505543f, 86.605545f, 61.01712f, 85.95369f, 61.365734f);
                instancePath3.cubicTo(85.30184f, 61.714348f, 84.655266f, 61.9f, 82.87223f, 61.9f);
                instancePath3.lineTo(82.87223f, 61.9f);
                instancePath3.lineTo(76.2f, 61.9f);
                instancePath3.lineTo(76.2f, 68.65145f);
                instancePath3.cubicTo(76.2f, 68.90878f, 76.10978f, 69.157974f, 75.945045f, 69.35566f);
                instancePath3.cubicTo(75.55612f, 69.822365f, 74.8625f, 69.88542f, 74.3958f, 69.4965f);
                instancePath3.lineTo(74.3958f, 69.4965f);
                instancePath3.lineTo(65.28f, 61.9f);
                instancePath3.lineTo(40.12777f, 61.9f);
                instancePath3.cubicTo(38.344734f, 61.9f, 37.698162f, 61.714348f, 37.04631f, 61.365734f);
                instancePath3.cubicTo(36.394455f, 61.01712f, 35.88288f, 60.505543f, 35.534264f, 59.85369f);
                instancePath3.cubicTo(35.18565f, 59.20184f, 35.0f, 58.555267f, 35.0f, 56.77223f);
                instancePath3.lineTo(35.0f, 56.77223f);
                instancePath3.lineTo(35.0f, 47.0f);
                instancePath3.lineTo(57.0f, 47.0f);
                instancePath3.cubicTo(58.59768f, 47.0f, 59.90366f, 45.75108f, 59.994907f, 44.176273f);
                instancePath3.lineTo(60.0f, 44.0f);
                instancePath3.lineTo(60.0f, 20.9f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
