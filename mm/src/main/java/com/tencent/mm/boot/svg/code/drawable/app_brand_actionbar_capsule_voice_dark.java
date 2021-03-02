package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_actionbar_capsule_voice_dark extends c {
    private final int height = 96;
    private final int width = 130;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 130;
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -238.0f, 0.0f, 1.0f, -292.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 238.0f, 0.0f, 1.0f, 292.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(61.0f, 44.0f);
                instancePath.lineTo(61.0f, 50.0f);
                instancePath.cubicTo(61.0f, 58.22929f, 67.93958f, 65.0f, 77.0f, 65.0f);
                instancePath.cubicTo(85.06042f, 65.0f, 92.0f, 58.22929f, 92.0f, 50.0f);
                instancePath.lineTo(92.0f, 44.0f);
                instancePath.lineTo(94.99676f, 44.0f);
                instancePath.cubicTo(95.56201f, 44.0f, 96.0f, 44.45037f, 96.0f, 45.005928f);
                instancePath.lineTo(96.0f, 50.25f);
                instancePath.cubicTo(96.0f, 60.017532f, 88.3659f, 67.91314f, 79.0f, 68.89677f);
                instancePath.lineTo(79.0f, 72.0f);
                instancePath.lineTo(91.003685f, 72.0f);
                instancePath.cubicTo(91.561775f, 72.0f, 92.0f, 72.45191f, 92.0f, 73.00937f);
                instancePath.lineTo(92.0f, 74.99063f);
                instancePath.cubicTo(92.0f, 75.55665f, 91.55393f, 76.0f, 91.003685f, 76.0f);
                instancePath.lineTo(61.996315f, 76.0f);
                instancePath.cubicTo(61.438225f, 76.0f, 61.0f, 75.54809f, 61.0f, 74.99063f);
                instancePath.lineTo(61.0f, 73.00937f);
                instancePath.cubicTo(61.0f, 72.44335f, 61.446064f, 72.0f, 61.996315f, 72.0f);
                instancePath.lineTo(74.0f, 72.0f);
                instancePath.lineTo(74.0f, 68.796776f);
                instancePath.cubicTo(64.20818f, 67.464806f, 57.0f, 59.741146f, 57.0f, 50.25f);
                instancePath.lineTo(57.0f, 44.997505f);
                instancePath.cubicTo(57.0f, 44.447468f, 57.449165f, 44.0f, 58.003242f, 44.0f);
                instancePath.lineTo(61.0f, 44.0f);
                instancePath.close();
                instancePath.moveTo(76.5f, 21.0f);
                instancePath.cubicTo(82.30026f, 21.0f, 87.0f, 25.705276f, 87.0f, 31.50953f);
                instancePath.lineTo(87.0f, 50.49047f);
                instancePath.cubicTo(87.0f, 56.29387f, 82.29899f, 61.0f, 76.5f, 61.0f);
                instancePath.cubicTo(70.69974f, 61.0f, 66.0f, 56.294724f, 66.0f, 50.49047f);
                instancePath.lineTo(66.0f, 31.50953f);
                instancePath.cubicTo(66.0f, 25.706133f, 70.70101f, 21.0f, 76.5f, 21.0f);
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
