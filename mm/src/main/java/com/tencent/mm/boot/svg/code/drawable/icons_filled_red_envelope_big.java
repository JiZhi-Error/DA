package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_red_envelope_big extends c {
    private final int height = 50;
    private final int width = 40;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 40;
            case 1:
                return 50;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -133.0f, 0.0f, 1.0f, -587.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 123.0f, 0.0f, 1.0f, 582.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(60.0f, 0.0f);
                instancePath.lineTo(60.0f, 60.0f);
                instancePath.lineTo(0.0f, 60.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.drawPath(instancePath, c.instancePaint(instancePaint3, looper));
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-372399);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(50.0f, 32.684f);
                instancePath2.lineTo(44.65864f, 32.684f);
                instancePath2.cubicTo(45.036823f, 31.943644f, 45.25f, 31.106264f, 45.25f, 30.218826f);
                instancePath2.cubicTo(45.25f, 27.193747f, 42.77113f, 24.75f, 39.72394f, 24.75f);
                instancePath2.cubicTo(38.214706f, 24.75f, 36.79735f, 25.354279f, 35.763958f, 26.404575f);
                instancePath2.cubicTo(32.63958f, 29.485071f, 31.235376f, 30.869555f, 29.999891f, 32.08771f);
                instancePath2.lineTo(24.111284f, 26.281933f);
                instancePath2.cubicTo(23.06764f, 25.296791f, 21.712925f, 24.75f, 20.276669f, 24.75f);
                instancePath2.cubicTo(17.229433f, 24.75f, 14.75f, 27.19379f, 14.75f, 30.218826f);
                instancePath2.cubicTo(14.75f, 31.106258f, 14.963227f, 31.94364f, 15.341485f, 32.684f);
                instancePath2.lineTo(10.0f, 32.684f);
                instancePath2.lineTo(10.0f, 12.022304f);
                instancePath2.cubicTo(10.0f, 10.638088f, 10.9805155f, 9.010373f, 12.234455f, 8.397089f);
                instancePath2.cubicTo(12.234455f, 8.397089f, 11.723122f, 8.606557f, 12.674759f, 8.199476f);
                instancePath2.cubicTo(17.338657f, 6.2044063f, 23.388803f, 5.0f, 30.0f, 5.0f);
                instancePath2.cubicTo(36.602695f, 5.0f, 42.645782f, 6.201311f, 47.307243f, 8.191784f);
                instancePath2.cubicTo(48.26561f, 8.601013f, 47.75061f, 8.390479f, 47.75061f, 8.390479f);
                instancePath2.cubicTo(48.992912f, 9.012065f, 50.0f, 10.638559f, 50.0f, 12.022304f);
                instancePath2.lineTo(50.0f, 32.684f);
                instancePath2.close();
                instancePath2.moveTo(50.0f, 35.684f);
                instancePath2.lineTo(50.0f, 52.423656f);
                instancePath2.cubicTo(50.0f, 53.807873f, 48.888424f, 54.93f, 47.49782f, 54.93f);
                instancePath2.lineTo(12.502179f, 54.93f);
                instancePath2.cubicTo(11.120264f, 54.93f, 10.0f, 53.8074f, 10.0f, 52.423656f);
                instancePath2.lineTo(10.0f, 35.684f);
                instancePath2.lineTo(20.041737f, 35.684f);
                instancePath2.cubicTo(20.119646f, 35.68723f, 20.197968f, 35.688858f, 20.276669f, 35.688858f);
                instancePath2.lineTo(26.347048f, 35.688858f);
                instancePath2.cubicTo(24.230742f, 37.75707f, 20.974974f, 40.46769f, 16.591118f, 43.806713f);
                instancePath2.lineTo(18.408882f, 46.193287f);
                instancePath2.cubicTo(22.969538f, 42.719604f, 26.353868f, 39.895702f, 28.57391f, 37.706745f);
                instancePath2.lineTo(29.999949f, 36.300674f);
                instancePath2.cubicTo(30.42258f, 36.717365f, 30.897173f, 37.18528f, 31.457039f, 37.737274f);
                instancePath2.cubicTo(33.67051f, 39.91961f, 37.04468f, 42.733448f, 41.591618f, 46.19367f);
                instancePath2.lineTo(43.408382f, 43.80633f);
                instancePath2.cubicTo(39.017014f, 40.4645f, 35.76127f, 37.75392f, 33.65271f, 35.688858f);
                instancePath2.lineTo(39.72394f, 35.688858f);
                instancePath2.cubicTo(39.802643f, 35.688858f, 39.880962f, 35.68723f, 39.95887f, 35.684f);
                instancePath2.lineTo(50.0f, 35.684f);
                instancePath2.close();
                instancePath2.moveTo(39.88387f, 32.684f);
                instancePath2.lineTo(33.667984f, 32.684f);
                instancePath2.lineTo(37.886345f, 28.524708f);
                instancePath2.cubicTo(38.376534f, 28.026745f, 39.02565f, 27.75f, 39.72394f, 27.75f);
                instancePath2.cubicTo(41.123783f, 27.75f, 42.25f, 28.860258f, 42.25f, 30.218826f);
                instancePath2.cubicTo(42.25f, 31.526302f, 41.20868f, 32.60326f, 39.88387f, 32.684f);
                instancePath2.lineTo(39.88387f, 32.684f);
                instancePath2.close();
                instancePath2.moveTo(20.116732f, 32.684f);
                instancePath2.cubicTo(18.79172f, 32.603256f, 17.75f, 31.526127f, 17.75f, 30.218826f);
                instancePath2.cubicTo(17.75f, 28.860445f, 18.87664f, 27.75f, 20.276669f, 27.75f);
                instancePath2.cubicTo(20.941519f, 27.75f, 21.561464f, 28.000223f, 22.028793f, 28.441132f);
                instancePath2.cubicTo(24.024054f, 30.408504f, 25.327253f, 31.693487f, 26.33182f, 32.684f);
                instancePath2.lineTo(20.116732f, 32.684f);
                instancePath2.lineTo(20.116732f, 32.684f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
