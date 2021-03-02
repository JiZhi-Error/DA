package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wallet_security_safety_insurance extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.666667f, 0.0f, 1.0f, 0.666667f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-352965);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(10.133333f, 25.066668f);
                instancePath.cubicTo(11.458817f, 25.066668f, 12.533333f, 23.99215f, 12.533333f, 22.666666f);
                instancePath.lineTo(12.533f, 18.666f);
                instancePath.lineTo(1.3333334f, 18.666666f);
                instancePath.cubicTo(0.5969537f, 18.666666f, 0.0f, 18.069714f, 0.0f, 17.333334f);
                instancePath.lineTo(0.0f, 14.666667f);
                instancePath.cubicTo(0.0f, 7.5714493f, 5.542025f, 1.7706409f, 12.533382f, 1.3569347f);
                instancePath.lineTo(12.533333f, 0.0f);
                instancePath.lineTo(14.133333f, 0.0f);
                instancePath.lineTo(14.133875f, 1.3569697f);
                instancePath.cubicTo(21.124954f, 1.7709676f, 26.666666f, 7.571649f, 26.666666f, 14.666667f);
                instancePath.lineTo(26.666666f, 17.333334f);
                instancePath.cubicTo(26.666666f, 18.069714f, 26.069714f, 18.666666f, 25.333334f, 18.666666f);
                instancePath.lineTo(14.133f, 18.666f);
                instancePath.lineTo(14.133333f, 22.666666f);
                instancePath.cubicTo(14.133333f, 24.808863f, 12.449365f, 26.557745f, 10.3329735f, 26.661772f);
                instancePath.lineTo(10.133333f, 26.666666f);
                instancePath.lineTo(10.133333f, 26.666666f);
                instancePath.cubicTo(7.9241943f, 26.666666f, 6.133333f, 24.875805f, 6.133333f, 22.666666f);
                instancePath.lineTo(7.733333f, 22.666666f);
                instancePath.cubicTo(7.733333f, 23.99215f, 8.80785f, 25.066668f, 10.133333f, 25.066668f);
                instancePath.close();
                instancePath.moveTo(13.333333f, 2.9333334f);
                instancePath.cubicTo(6.8531923f, 2.9333334f, 1.6f, 8.186525f, 1.6f, 14.666667f);
                instancePath.lineTo(1.6f, 17.066668f);
                instancePath.lineTo(25.066668f, 17.066668f);
                instancePath.lineTo(25.066668f, 14.666667f);
                instancePath.cubicTo(25.066668f, 8.186525f, 19.813475f, 2.9333334f, 13.333333f, 2.9333334f);
                instancePath.close();
                instancePath.moveTo(18.666666f, 7.0666666f);
                instancePath.lineTo(19.756598f, 8.238011f);
                instancePath.lineTo(12.591957f, 14.904678f);
                instancePath.cubicTo(12.284842f, 15.190449f, 11.809142f, 15.190449f, 11.502026f, 14.904678f);
                instancePath.lineTo(8.0f, 11.646059f);
                instancePath.lineTo(9.0899315f, 10.474713f);
                instancePath.lineTo(12.046991f, 13.226245f);
                instancePath.lineTo(18.666666f, 7.0666666f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.0f, 0.0f);
                instancePath2.lineTo(32.0f, 0.0f);
                instancePath2.lineTo(32.0f, 32.0f);
                instancePath2.lineTo(0.0f, 32.0f);
                instancePath2.lineTo(0.0f, 0.0f);
                instancePath2.close();
                c.done(looper);
                break;
        }
        return 0;
    }
}
