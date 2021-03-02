package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_service_msg_black extends c {
    private final int height = 80;
    private final int width = 84;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 84;
            case 1:
                return 80;
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
                instancePaint3.setColor(-13882324);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -1347.0f, 0.0f, 1.0f, -215.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 1250.0f, 0.0f, 1.0f, 215.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(131.0f, 51.0f);
                instancePath.lineTo(131.0f, 64.0f);
                instancePath.cubicTo(131.0f, 65.044205f, 132.50389f, 66.62656f, 134.0f, 66.0f);
                instancePath.lineTo(158.0f, 66.0f);
                instancePath.lineTo(169.0f, 76.0f);
                instancePath.cubicTo(169.0921f, 76.41986f, 169.86208f, 76.09059f, 170.0f, 74.0f);
                instancePath.lineTo(170.0f, 66.0f);
                instancePath.lineTo(177.0f, 66.0f);
                instancePath.cubicTo(178.48862f, 66.62656f, 180.0f, 65.03394f, 180.0f, 64.0f);
                instancePath.lineTo(180.0f, 29.0f);
                instancePath.cubicTo(180.0f, 27.582346f, 178.4798f, 26.0f, 177.0f, 26.0f);
                instancePath.lineTo(156.0f, 26.0f);
                instancePath.lineTo(156.0f, 46.0f);
                instancePath.cubicTo(154.65517f, 48.362537f, 152.38159f, 50.729206f, 150.0f, 51.0f);
                instancePath.lineTo(131.0f, 51.0f);
                instancePath.close();
                instancePath.moveTo(149.02345f, 4.0f);
                instancePath.cubicTo(150.66736f, 4.0f, 152.0f, 5.334057f, 152.0f, 6.97253f);
                instancePath.lineTo(152.0f, 44.02747f);
                instancePath.cubicTo(152.0f, 45.66915f, 150.66797f, 47.0f, 149.02759f, 47.0f);
                instancePath.lineTo(121.0f, 47.0f);
                instancePath.lineTo(110.64339f, 55.630512f);
                instancePath.cubicTo(109.73577f, 56.38686f, 109.0f, 56.041157f, 109.0f, 54.854748f);
                instancePath.lineTo(109.0f, 47.0f);
                instancePath.lineTo(99.96629f, 47.0f);
                instancePath.cubicTo(98.32806f, 47.0f, 97.0f, 45.665943f, 97.0f, 44.02747f);
                instancePath.lineTo(97.0f, 6.97253f);
                instancePath.cubicTo(97.0f, 5.330847f, 98.332306f, 4.0f, 99.97654f, 4.0f);
                instancePath.lineTo(149.02345f, 4.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
