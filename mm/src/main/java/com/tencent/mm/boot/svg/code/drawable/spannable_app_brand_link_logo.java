package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class spannable_app_brand_link_logo extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -415.0f, 0.0f, 1.0f, -651.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 415.0f, 0.0f, 1.0f, 651.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-723724);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 30.0f);
                instancePath.cubicTo(0.0f, 13.4314575f, 13.4314575f, 0.0f, 30.0f, 0.0f);
                instancePath.lineTo(30.0f, 0.0f);
                instancePath.cubicTo(46.568542f, 0.0f, 60.0f, 13.4314575f, 60.0f, 30.0f);
                instancePath.lineTo(60.0f, 30.0f);
                instancePath.cubicTo(60.0f, 46.568542f, 46.568542f, 60.0f, 30.0f, 60.0f);
                instancePath.lineTo(30.0f, 60.0f);
                instancePath.cubicTo(13.4314575f, 60.0f, 0.0f, 46.568542f, 0.0f, 30.0f);
                instancePath.lineTo(0.0f, 30.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-9074981);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(39.0f, 12.0f);
                instancePath2.cubicTo(36.80045f, 12.0f, 34.7991f, 12.586f, 33.0f, 14.0f);
                instancePath2.cubicTo(29.98325f, 15.412f, 27.9f, 18.645334f, 28.0f, 22.0f);
                instancePath2.lineTo(28.0f, 38.0f);
                instancePath2.cubicTo(27.9f, 40.428f, 25.2805f, 42.666668f, 22.0f, 43.0f);
                instancePath2.cubicTo(18.81885f, 42.666668f, 16.2f, 40.428f, 16.0f, 38.0f);
                instancePath2.cubicTo(16.2f, 35.701332f, 17.5299f, 34.006f, 19.0f, 33.0f);
                instancePath2.cubicTo(19.59885f, 33.13f, 19.7399f, 33.074f, 20.0f, 33.0f);
                instancePath2.cubicTo(21.0997f, 32.524666f, 22.14165f, 31.586f, 23.0f, 30.0f);
                instancePath2.cubicTo(23.09975f, 28.886667f, 22.03635f, 27.582666f, 20.0f, 28.0f);
                instancePath2.cubicTo(19.68465f, 27.582666f, 19.20885f, 27.664f, 19.0f, 28.0f);
                instancePath2.cubicTo(18.748f, 27.811333f, 18.74605f, 27.812f, 19.0f, 28.0f);
                instancePath2.cubicTo(16.0219f, 28.614f, 13.75015f, 30.371334f, 12.0f, 33.0f);
                instancePath2.cubicTo(11.5057f, 34.15f, 11.0f, 35.853333f, 11.0f, 38.0f);
                instancePath2.cubicTo(11.0f, 43.364666f, 15.9569f, 48.0f, 22.0f, 48.0f);
                instancePath2.cubicTo(24.19955f, 48.0f, 26.2009f, 47.414f, 28.0f, 46.0f);
                instancePath2.cubicTo(31.01675f, 44.588f, 33.1f, 41.354668f, 33.0f, 38.0f);
                instancePath2.lineTo(33.0f, 22.0f);
                instancePath2.cubicTo(33.1f, 19.572f, 35.71885f, 17.333334f, 39.0f, 17.0f);
                instancePath2.cubicTo(42.1805f, 17.333334f, 44.8f, 19.572f, 45.0f, 22.0f);
                instancePath2.cubicTo(44.8f, 24.382668f, 43.35765f, 26.144f, 41.0f, 27.0f);
                instancePath2.cubicTo(39.96075f, 27.374f, 38.8694f, 28.362667f, 38.0f, 30.0f);
                instancePath2.cubicTo(37.8853f, 31.135334f, 38.9435f, 32.434f, 41.0f, 32.0f);
                instancePath2.cubicTo(41.2419f, 32.434f, 41.6709f, 32.359333f, 42.0f, 32.0f);
                instancePath2.cubicTo(42.1571f, 32.218666f, 42.2247f, 32.197334f, 42.0f, 32.0f);
                instancePath2.cubicTo(44.9976f, 31.370667f, 47.2557f, 29.618668f, 49.0f, 27.0f);
                instancePath2.cubicTo(49.4943f, 25.850666f, 50.0f, 24.146667f, 50.0f, 22.0f);
                instancePath2.cubicTo(50.0f, 16.635334f, 45.0431f, 12.0f, 39.0f, 12.0f);
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
