package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_outlined_activity extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                instancePaint3.setColor(-12233353);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.89879405f, -0.43837115f, 6.8195014f, 0.43837115f, 0.89879405f, -3.3227634f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(9.847616f, 21.693064f);
                instancePath.lineTo(2.6535494f, 6.839658f);
                instancePath.cubicTo(2.5393233f, 6.593353f, 2.6374383f, 6.3007674f, 2.8771076f, 6.172993f);
                instancePath.cubicTo(2.9003537f, 6.1420093f, 2.9298322f, 6.116231f, 2.9636464f, 6.0973177f);
                instancePath.cubicTo(3.677708f, 5.588064f, 4.4673834f, 5.194074f, 5.303797f, 4.929754f);
                instancePath.cubicTo(6.1527753f, 4.6601005f, 7.0348554f, 4.508528f, 7.925198f, 4.4793043f);
                instancePath.lineTo(8.285776f, 4.4793043f);
                instancePath.cubicTo(9.293041f, 4.4812894f, 10.2944f, 4.6331024f, 11.256938f, 4.929754f);
                instancePath.cubicTo(12.380329f, 5.3256207f, 13.554348f, 5.559797f, 14.743726f, 5.625247f);
                instancePath.cubicTo(15.933633f, 5.625247f, 16.45647f, 5.171194f, 17.116327f, 4.5946193f);
                instancePath.lineTo(17.274982f, 4.457683f);
                instancePath.cubicTo(17.44026f, 4.3021975f, 17.657421f, 4.2135873f, 17.88436f, 4.209035f);
                instancePath.cubicTo(18.011015f, 4.2092595f, 18.13538f, 4.2428174f, 18.244938f, 4.306332f);
                instancePath.cubicTo(18.637966f, 4.5405655f, 18.62715f, 5.0270505f, 18.587486f, 5.3549776f);
                instancePath.cubicTo(18.523653f, 5.76955f, 18.413591f, 6.17568f, 18.25936f, 6.565785f);
                instancePath.cubicTo(17.820438f, 7.7411838f, 17.13995f, 8.811627f, 16.261759f, 9.7081175f);
                instancePath.cubicTo(15.7698345f, 10.205906f, 15.190481f, 10.609009f, 14.55262f, 10.897304f);
                instancePath.lineTo(14.430023f, 10.947754f);
                instancePath.cubicTo(13.888576f, 11.1687355f, 13.309346f, 11.282553f, 12.724489f, 11.282888f);
                instancePath.lineTo(12.345882f, 11.282888f);
                instancePath.cubicTo(11.963671f, 11.250456f, 11.599486f, 11.236041f, 11.26415f, 11.236041f);
                instancePath.cubicTo(8.379526f, 11.236041f, 7.716063f, 12.389192f, 7.1319265f, 13.398197f);
                instancePath.lineTo(7.1030803f, 13.452251f);
                instancePath.lineTo(10.889687f, 21.26784f);
                instancePath.cubicTo(10.944483f, 21.393044f, 10.944483f, 21.535427f, 10.889687f, 21.660631f);
                instancePath.cubicTo(10.833244f, 21.802078f, 10.721123f, 21.914133f, 10.579589f, 21.970541f);
                instancePath.cubicTo(10.512505f, 21.994614f, 10.441732f, 22.006666f, 10.370454f, 22.006666f);
                instancePath.cubicTo(10.150869f, 22.009314f, 9.948534f, 21.887985f, 9.847616f, 21.693064f);
                instancePath.close();
                instancePath.moveTo(6.52255f, 12.237841f);
                instancePath.cubicTo(6.8715715f, 11.704303f, 7.3361535f, 11.256013f, 7.8819284f, 10.926132f);
                instancePath.cubicTo(8.747315f, 10.410819f, 9.861502f, 10.16217f, 11.292995f, 10.16217f);
                instancePath.cubicTo(11.653573f, 10.16217f, 12.046603f, 10.16217f, 12.45045f, 10.212621f);
                instancePath.lineTo(12.728095f, 10.212621f);
                instancePath.cubicTo(13.744925f, 10.212621f, 14.704062f, 9.747758f, 15.573055f, 8.828841f);
                instancePath.cubicTo(16.208824f, 8.140287f, 16.717852f, 7.3448787f, 17.076664f, 6.4792986f);
                instancePath.cubicTo(17.16681f, 6.2666864f, 17.24253f, 6.064885f, 17.300222f, 5.870291f);
                instancePath.cubicTo(16.799906f, 6.2591095f, 16.209614f, 6.515656f, 15.583872f, 6.6162353f);
                instancePath.cubicTo(15.312087f, 6.6604385f, 15.037113f, 6.6821337f, 14.761755f, 6.6811f);
                instancePath.cubicTo(13.444422f, 6.6194677f, 12.142724f, 6.36948f, 10.896359f, 5.93876f);
                instancePath.cubicTo(10.04543f, 5.6725507f, 9.159386f, 5.535291f, 8.267747f, 5.5315537f);
                instancePath.cubicTo(7.4024897f, 5.533464f, 6.5426745f, 5.668374f, 5.7184615f, 5.9315524f);
                instancePath.cubicTo(5.0715413f, 6.1334987f, 4.4534416f, 6.4181366f, 3.8795142f, 6.7783966f);
                instancePath.lineTo(6.52255f, 12.237841f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
