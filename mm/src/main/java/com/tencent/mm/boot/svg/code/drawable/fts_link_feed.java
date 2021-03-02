package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fts_link_feed extends c {
    private final int height = 40;
    private final int width = 40;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                instancePaint3.setColor(-6710887);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, -6.123234E-17f, -1.0f, 40.000004f, -1.0f, 6.123234E-17f, 40.02865f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(35.94087f, 3.8626087f);
                instancePath.cubicTo(31.874783f, -0.20347826f, 25.26261f, -0.21565217f, 21.191305f, 3.853913f);
                instancePath.lineTo(17.493914f, 7.5513043f);
                instancePath.lineTo(19.953043f, 10.010435f);
                instancePath.lineTo(23.634783f, 6.330435f);
                instancePath.cubicTo(26.356522f, 3.6086957f, 30.770435f, 3.6104348f, 33.48f, 6.321739f);
                instancePath.cubicTo(36.19652f, 9.03826f, 36.193043f, 13.446957f, 33.471306f, 16.166956f);
                instancePath.lineTo(27.33913f, 22.29913f);
                instancePath.cubicTo(24.617392f, 25.02087f, 20.203478f, 25.01913f, 17.493914f, 22.307827f);
                instancePath.lineTo(15.034782f, 24.766956f);
                instancePath.cubicTo(19.10087f, 28.833044f, 25.713043f, 28.845217f, 29.784348f, 24.775652f);
                instancePath.lineTo(35.949566f, 18.610435f);
                instancePath.cubicTo(40.00522f, 14.553043f, 40.01565f, 7.9373913f, 35.94087f, 3.8626087f);
                instancePath.lineTo(35.94087f, 3.8626087f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(23.732174f, 16.017391f);
                instancePath2.cubicTo(19.666086f, 11.951304f, 13.050435f, 11.942609f, 8.975652f, 16.017391f);
                instancePath2.lineTo(3.692174f, 21.354782f);
                instancePath2.cubicTo(-0.38434783f, 25.431305f, -0.37391305f, 32.027824f, 3.7008696f, 36.102608f);
                instancePath2.cubicTo(7.7669563f, 40.168697f, 14.37913f, 40.18261f, 18.448696f, 36.111305f);
                instancePath2.lineTo(21.184347f, 33.375652f);
                instancePath2.lineTo(18.725218f, 30.916521f);
                instancePath2.lineTo(15.876522f, 33.765217f);
                instancePath2.cubicTo(13.165217f, 36.47652f, 8.76f, 36.466087f, 6.0486956f, 33.754784f);
                instancePath2.cubicTo(3.3321738f, 31.038261f, 3.3304348f, 26.634783f, 6.038261f, 23.926956f);
                instancePath2.lineTo(11.50087f, 18.495653f);
                instancePath2.cubicTo(14.213913f, 15.782609f, 18.622608f, 15.789565f, 21.333914f, 18.50087f);
                instancePath2.cubicTo(21.44174f, 18.608696f, 21.546087f, 18.72f, 21.645218f, 18.833044f);
                instancePath2.lineTo(24.088696f, 16.389565f);
                instancePath2.cubicTo(23.972174f, 16.264347f, 23.853912f, 16.14087f, 23.732174f, 16.017391f);
                instancePath2.lineTo(23.732174f, 16.017391f);
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
