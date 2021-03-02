package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class profile_social_linkedin extends c {
    private final int height = 76;
    private final int width = 76;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 76;
            case 1:
                return 76;
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
                instancePaint3.setColor(-789517);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 4.0f);
                instancePath.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                instancePath.lineTo(72.0f, 0.0f);
                instancePath.cubicTo(74.20914f, 0.0f, 76.0f, 1.7908609f, 76.0f, 4.0f);
                instancePath.lineTo(76.0f, 72.0f);
                instancePath.cubicTo(76.0f, 74.20914f, 74.20914f, 76.0f, 72.0f, 76.0f);
                instancePath.lineTo(4.0f, 76.0f);
                instancePath.cubicTo(1.7908609f, 76.0f, 0.0f, 74.20914f, 0.0f, 72.0f);
                instancePath.lineTo(0.0f, 4.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-5658199);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 14.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(3.077093f, 0.40822864f);
                instancePath2.cubicTo(6.376807f, -1.1489923f, 10.591013f, 1.994287f, 9.93107f, 5.6854773f);
                instancePath2.cubicTo(9.553961f, 9.520855f, 4.528967f, 11.36645f, 1.7572072f, 8.838369f);
                instancePath2.cubicTo(-1.1371136f, 6.6563373f, -0.28861567f, 1.590563f, 3.077093f, 0.40822864f);
                instancePath2.lineTo(3.077093f, 0.40822864f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(23.623188f, 16.071012f);
                instancePath3.cubicTo(26.064592f, 14.068773f, 28.851942f, 12.245839f, 32.093967f, 12.086457f);
                instancePath3.cubicTo(38.943733f, 11.219816f, 45.90223f, 16.98746f, 45.93188f, 24.050083f);
                instancePath3.cubicTo(46.07026f, 31.361742f, 45.95165f, 38.6734f, 45.971416f, 45.985058f);
                instancePath3.cubicTo(42.976498f, 46.004982f, 39.971695f, 46.004982f, 36.976776f, 45.985058f);
                instancePath3.cubicTo(36.8977f, 39.330853f, 37.075615f, 32.676643f, 36.927353f, 26.022438f);
                instancePath3.cubicTo(37.085503f, 22.396492f, 33.73475f, 19.238733f, 30.196198f, 19.418037f);
                instancePath3.cubicTo(26.677414f, 19.28854f, 23.465042f, 22.436338f, 23.553999f, 25.992554f);
                instancePath3.cubicTo(23.326662f, 32.656723f, 23.563883f, 39.32089f, 23.455156f, 45.995018f);
                instancePath3.lineTo(16.04199f, 45.995018f);
                instancePath3.cubicTo(16.170485f, 35.127148f, 15.755347f, 24.249311f, 16.249557f, 13.391398f);
                instancePath3.cubicTo(18.52293f, 13.431244f, 20.7963f, 13.441206f, 23.079557f, 13.431244f);
                instancePath3.cubicTo(23.208052f, 14.088696f, 23.48481f, 15.403599f, 23.623188f, 16.071012f);
                instancePath3.lineTo(23.623188f, 16.071012f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint4, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(1.0f, 13.019893f);
                instancePath4.cubicTo(3.6736567f, 12.989608f, 6.336828f, 12.989608f, 9.0f, 13.050178f);
                instancePath4.cubicTo(8.968545f, 24.023357f, 9.010485f, 34.996536f, 8.979031f, 45.97981f);
                instancePath4.cubicTo(6.3263435f, 45.989906f, 3.6841416f, 46.0f, 1.0314548f, 46.0f);
                instancePath4.cubicTo(1.0f, 35.00663f, 1.0524247f, 24.013262f, 1.0f, 13.019893f);
                instancePath4.lineTo(1.0f, 13.019893f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
