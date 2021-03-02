package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class profile_social_facebook extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 23.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(11.048801f, 4.034698f);
                instancePath2.cubicTo(16.060522f, -0.743125f, 23.669407f, 1.7006466f, 29.878258f, 1.1320957f);
                instancePath2.cubicTo(29.898548f, 4.1444182f, 29.898548f, 7.146766f, 29.878258f, 10.159089f);
                instancePath2.cubicTo(26.469477f, 10.288758f, 22.959244f, 9.760106f, 19.631624f, 10.607945f);
                instancePath2.cubicTo(16.557634f, 12.134055f, 17.521427f, 15.994218f, 17.318523f, 18.737226f);
                instancePath2.cubicTo(21.549065f, 18.737226f, 25.769459f, 18.737226f, 30.0f, 18.757175f);
                instancePath2.cubicTo(29.513031f, 21.789448f, 29.005772f, 24.811745f, 28.468079f, 27.834042f);
                instancePath2.cubicTo(24.765087f, 27.844017f, 21.07224f, 27.85399f, 17.379395f, 27.863966f);
                instancePath2.cubicTo(17.328669f, 35.56434f, 17.38954f, 43.27469f, 17.348959f, 50.98504f);
                instancePath2.cubicTo(14.234388f, 51.004986f, 11.109673f, 51.004986f, 7.9951024f, 50.98504f);
                instancePath2.cubicTo(7.9545217f, 43.27469f, 8.015392f, 35.574314f, 7.964667f, 27.863966f);
                instancePath2.cubicTo(5.6515656f, 27.863966f, 3.3384643f, 27.844017f, 1.0152178f, 27.844017f);
                instancePath2.cubicTo(0.9949274f, 24.811745f, 0.9949274f, 21.779472f, 1.0152178f, 18.747202f);
                instancePath2.cubicTo(3.3384643f, 18.747202f, 5.6617107f, 18.737226f, 7.984957f, 18.727251f);
                instancePath2.cubicTo(8.14728f, 13.779861f, 6.8892775f, 7.8050885f, 11.048801f, 4.034698f);
                instancePath2.lineTo(11.048801f, 4.034698f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
