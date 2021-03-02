package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class profile_social_weishop extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 13.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(25.5f, 0.0f);
                instancePath2.cubicTo(27.985281f, 0.0f, 30.0f, 2.0147185f, 30.0f, 4.5f);
                instancePath2.cubicTo(30.0f, 6.9852815f, 27.985281f, 9.0f, 25.5f, 9.0f);
                instancePath2.cubicTo(23.014719f, 9.0f, 21.0f, 6.9852815f, 21.0f, 4.5f);
                instancePath2.cubicTo(21.0f, 2.0147185f, 23.014719f, 0.0f, 25.5f, 0.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(4.140231f, 10.026411f);
                instancePath3.cubicTo(17.423513f, 9.986368f, 30.706797f, 9.996379f, 44.0f, 10.026411f);
                instancePath3.cubicTo(43.94048f, 11.688178f, 43.910717f, 13.349946f, 43.890877f, 15.011714f);
                instancePath3.lineTo(10.786833f, 15.011714f);
                instancePath3.cubicTo(10.608268f, 23.610863f, 11.35229f, 32.33014f, 9.645998f, 40.80916f);
                instancePath3.cubicTo(8.71349f, 45.4541f, 5.162022f, 48.867733f, 1.1542207f, 51.0f);
                instancePath3.cubicTo(0.1919515f, 46.2049f, 4.0509486f, 42.450905f, 3.9616659f, 37.765923f);
                instancePath3.cubicTo(4.358478f, 28.52609f, 4.021188f, 19.27625f, 4.140231f, 10.026411f);
                instancePath3.lineTo(4.140231f, 10.026411f);
                instancePath3.lineTo(4.140231f, 10.026411f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint4, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(22.522583f, 17.0f);
                instancePath4.cubicTo(24.810589f, 17.040438f, 27.108543f, 17.050549f, 29.396551f, 17.060658f);
                instancePath4.cubicTo(29.476133f, 18.395117f, 29.545769f, 19.729574f, 29.615402f, 21.074142f);
                instancePath4.cubicTo(34.41027f, 21.084253f, 39.205135f, 21.074142f, 44.0f, 21.084253f);
                instancePath4.cubicTo(44.0f, 22.529917f, 44.0f, 23.98569f, 43.99005f, 25.431355f);
                instancePath4.cubicTo(39.145447f, 25.441463f, 34.31079f, 25.431355f, 29.476133f, 25.441463f);
                instancePath4.cubicTo(29.505978f, 27.463371f, 29.515924f, 29.48528f, 29.496029f, 31.507185f);
                instancePath4.cubicTo(33.654232f, 31.486967f, 37.802486f, 31.517296f, 41.95074f, 31.517296f);
                instancePath4.cubicTo(41.851265f, 36.046368f, 42.13975f, 40.59566f, 41.851265f, 45.124733f);
                instancePath4.cubicTo(41.9209f, 47.55102f, 39.46378f, 49.158436f, 37.255356f, 48.946136f);
                instancePath4.cubicTo(29.177698f, 49.02701f, 21.090092f, 49.02701f, 13.002487f, 48.87537f);
                instancePath4.cubicTo(13.002487f, 43.102825f, 12.992539f, 37.33028f, 13.012435f, 31.557734f);
                instancePath4.cubicTo(16.175852f, 31.547625f, 19.33927f, 31.466747f, 22.502687f, 31.466747f);
                instancePath4.cubicTo(22.522583f, 26.644499f, 22.522583f, 21.822248f, 22.522583f, 17.0f);
                instancePath4.lineTo(22.522583f, 17.0f);
                instancePath4.lineTo(22.522583f, 17.0f);
                instancePath4.close();
                instancePath4.moveTo(20.007324f, 36.01719f);
                instancePath4.cubicTo(19.997559f, 39.00472f, 19.997559f, 41.981876f, 20.007324f, 44.959034f);
                instancePath4.cubicTo(24.939476f, 44.979782f, 29.861862f, 45.10426f, 34.784245f, 44.782684f);
                instancePath4.cubicTo(34.960045f, 41.857395f, 35.02841f, 38.932106f, 34.989346f, 36.006813f);
                instancePath4.cubicTo(29.998594f, 35.99644f, 24.998075f, 35.99644f, 20.007324f, 36.01719f);
                instancePath4.lineTo(20.007324f, 36.01719f);
                instancePath4.lineTo(20.007324f, 36.01719f);
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
