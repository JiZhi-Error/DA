package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class find_more_friend_qq_icon extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
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
                instancePaint3.setColor(-11615450);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 18.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(41.933807f, 49.914906f);
                instancePath.cubicTo(41.570644f, 50.311275f, 41.22761f, 50.729294f, 40.83845f, 51.09736f);
                instancePath.cubicTo(40.487732f, 51.429058f, 40.524216f, 51.570423f, 40.97572f, 51.73429f);
                instancePath.cubicTo(42.136913f, 52.15585f, 43.28329f, 52.60486f, 44.197063f, 53.508537f);
                instancePath.cubicTo(45.815495f, 55.10901f, 45.704506f, 56.79198f, 43.832924f, 58.101368f);
                instancePath.cubicTo(42.38126f, 59.11684f, 40.70859f, 59.570095f, 38.99329f, 59.777122f);
                instancePath.cubicTo(36.10156f, 60.126083f, 33.230656f, 59.966743f, 30.45271f, 58.99401f);
                instancePath.cubicTo(29.06227f, 58.507076f, 27.749409f, 57.874245f, 26.70116f, 56.759575f);
                instancePath.cubicTo(26.34373f, 56.379482f, 25.728397f, 56.389385f, 25.382849f, 56.742737f);
                instancePath.cubicTo(23.635817f, 58.52901f, 21.405548f, 59.240093f, 19.074354f, 59.64821f);
                instancePath.cubicTo(16.275162f, 60.138256f, 13.4713545f, 60.07783f, 10.716473f, 59.26118f);
                instancePath.cubicTo(9.564925f, 58.919716f, 8.479774f, 58.441273f, 7.6105914f, 57.57849f);
                instancePath.cubicTo(6.4260535f, 56.402687f, 6.4203224f, 55.089905f, 7.5331507f, 53.832027f);
                instancePath.cubicTo(8.453495f, 52.791653f, 9.666688f, 52.2658f, 10.912312f, 51.78637f);
                instancePath.cubicTo(11.107172f, 51.71137f, 11.305247f, 51.64514f, 11.596419f, 51.54099f);
                instancePath.cubicTo(9.618183f, 49.404907f, 7.894914f, 47.14684f, 7.0346775f, 44.239952f);
                instancePath.cubicTo(6.1903763f, 45.195282f, 5.3947206f, 46.07349f, 4.440828f, 46.78033f);
                instancePath.cubicTo(3.7795055f, 47.27038f, 3.0847743f, 47.680897f, 2.2712257f, 47.87179f);
                instancePath.cubicTo(1.7350107f, 47.997593f, 1.3624839f, 47.824245f, 1.0970323f, 47.363632f);
                instancePath.cubicTo(0.3825914f, 46.12415f, 0.23735484f, 44.738632f, 0.15488172f, 43.353256f);
                instancePath.cubicTo(-0.12245161f, 38.69363f, 1.3227849f, 34.51486f, 3.5798924f, 30.527548f);
                instancePath.cubicTo(4.8622794f, 28.262264f, 5.9653225f, 25.893255f, 6.504473f, 23.300518f);
                instancePath.cubicTo(6.751054f, 22.114952f, 6.7516127f, 20.91283f, 6.81871f, 19.717075f);
                instancePath.cubicTo(7.093387f, 14.825802f, 8.74914f, 10.514717f, 11.910377f, 6.779717f);
                instancePath.cubicTo(14.765344f, 3.406415f, 18.378225f, 1.3006132f, 22.616924f, 0.4546698f);
                instancePath.cubicTo(27.057194f, -0.43160376f, 31.315882f, 0.33721697f, 35.24943f, 2.6958961f);
                instancePath.cubicTo(40.823635f, 6.038349f, 43.90184f, 11.066604f, 45.01858f, 17.439623f);
                instancePath.cubicTo(45.276203f, 18.910048f, 45.219173f, 20.39632f, 45.35099f, 21.871557f);
                instancePath.cubicTo(45.56612f, 24.281038f, 46.48017f, 26.463255f, 47.490536f, 28.621273f);
                instancePath.cubicTo(48.358044f, 30.473915f, 49.474365f, 32.196083f, 50.252827f, 34.092735f);
                instancePath.cubicTo(51.86371f, 38.0175f, 52.443676f, 42.047688f, 51.44254f, 46.23538f);
                instancePath.cubicTo(51.40983f, 46.372074f, 51.36859f, 46.5075f, 51.321342f, 46.63967f);
                instancePath.cubicTo(50.854042f, 47.947216f, 50.269463f, 48.209152f, 49.03027f, 47.634197f);
                instancePath.cubicTo(47.603622f, 46.972218f, 46.486183f, 45.91118f, 45.462257f, 44.736794f);
                instancePath.cubicTo(45.341763f, 44.598537f, 45.231194f, 44.451225f, 45.04598f, 44.22099f);
                instancePath.cubicTo(44.43204f, 46.28703f, 43.34829f, 48.0f, 42.15844f, 49.652973f);
                instancePath.cubicTo(42.153828f, 49.801414f, 42.032215f, 49.847973f, 41.933807f, 49.914906f);
                instancePath.lineTo(41.933807f, 49.914906f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
