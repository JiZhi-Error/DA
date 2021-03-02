package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_service_msg_white extends c {
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -1250.0f, 0.0f, 1.0f, -215.0f, 0.0f, 0.0f, 1.0f);
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
                instancePath.moveTo(34.0f, 51.0f);
                instancePath.lineTo(34.0f, 64.0f);
                instancePath.cubicTo(34.0f, 65.044205f, 35.50389f, 66.62656f, 37.0f, 66.0f);
                instancePath.lineTo(61.0f, 66.0f);
                instancePath.lineTo(72.0f, 76.0f);
                instancePath.cubicTo(72.0921f, 76.41986f, 72.86207f, 76.09059f, 73.0f, 74.0f);
                instancePath.lineTo(73.0f, 66.0f);
                instancePath.lineTo(80.0f, 66.0f);
                instancePath.cubicTo(81.48861f, 66.62656f, 83.0f, 65.03394f, 83.0f, 64.0f);
                instancePath.lineTo(83.0f, 29.0f);
                instancePath.cubicTo(83.0f, 27.582346f, 81.4798f, 26.0f, 80.0f, 26.0f);
                instancePath.lineTo(59.0f, 26.0f);
                instancePath.lineTo(59.0f, 46.0f);
                instancePath.cubicTo(57.655174f, 48.362537f, 55.381588f, 50.729206f, 53.0f, 51.0f);
                instancePath.lineTo(34.0f, 51.0f);
                instancePath.close();
                instancePath.moveTo(52.02346f, 4.0f);
                instancePath.cubicTo(53.66736f, 4.0f, 55.0f, 5.334057f, 55.0f, 6.97253f);
                instancePath.lineTo(55.0f, 44.02747f);
                instancePath.cubicTo(55.0f, 45.66915f, 53.66797f, 47.0f, 52.027588f, 47.0f);
                instancePath.lineTo(24.0f, 47.0f);
                instancePath.lineTo(13.643388f, 55.630512f);
                instancePath.cubicTo(12.735769f, 56.38686f, 12.0f, 56.041157f, 12.0f, 54.854748f);
                instancePath.lineTo(12.0f, 47.0f);
                instancePath.lineTo(2.9662929f, 47.0f);
                instancePath.cubicTo(1.3280545f, 47.0f, 0.0f, 45.665943f, 0.0f, 44.02747f);
                instancePath.lineTo(0.0f, 6.97253f);
                instancePath.cubicTo(0.0f, 5.330847f, 1.332306f, 4.0f, 2.97654f, 4.0f);
                instancePath.lineTo(52.02346f, 4.0f);
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
