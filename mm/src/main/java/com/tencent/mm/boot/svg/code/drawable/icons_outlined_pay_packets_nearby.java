package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_pay_packets_nearby extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.instanceMatrix(looper);
                c.instanceMatrixArray(looper);
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(50.99258f, 9.6f);
                instancePath.cubicTo(52.653534f, 9.6f, 54.0f, 10.950161f, 54.0f, 12.598743f);
                instancePath.lineTo(54.0f, 30.186f);
                instancePath.lineTo(60.877968f, 34.02864f);
                instancePath.cubicTo(61.39983f, 34.32022f, 61.739708f, 34.849636f, 61.79273f, 35.438164f);
                instancePath.lineTo(61.8f, 35.6f);
                instancePath.lineTo(61.8f, 60.6f);
                instancePath.cubicTo(61.8f, 61.594112f, 60.994114f, 62.4f, 60.0f, 62.4f);
                instancePath.lineTo(60.0f, 62.4f);
                instancePath.lineTo(54.886364f, 62.4f);
                instancePath.cubicTo(52.32554f, 62.4f, 50.071156f, 59.758247f, 48.62588f, 56.401203f);
                instancePath.lineTo(23.373686f, 56.402203f);
                instancePath.cubicTo(21.928396f, 59.75877f, 19.674206f, 62.4f, 17.113636f, 62.4f);
                instancePath.lineTo(12.0f, 62.4f);
                instancePath.cubicTo(11.005887f, 62.4f, 10.2f, 61.594112f, 10.2f, 60.6f);
                instancePath.lineTo(10.2f, 35.6f);
                instancePath.cubicTo(10.2f, 34.94786f, 10.55273f, 34.346725f, 11.122033f, 34.02864f);
                instancePath.lineTo(18.0f, 30.185f);
                instancePath.lineTo(18.000038f, 24.565464f);
                instancePath.cubicTo(17.999376f, 24.565168f, 17.998713f, 24.564873f, 17.99805f, 24.564577f);
                instancePath.lineTo(17.998558f, 21.599384f);
                instancePath.lineTo(18.0f, 21.6f);
                instancePath.lineTo(18.0f, 12.598743f);
                instancePath.cubicTo(18.0f, 10.942583f, 19.34554f, 9.6f, 21.00742f, 9.6f);
                instancePath.lineTo(50.99258f, 9.6f);
                instancePath.close();
                instancePath.moveTo(17.345175f, 34.675396f);
                instancePath.lineTo(13.8f, 36.656193f);
                instancePath.lineTo(13.8f, 58.8f);
                instancePath.lineTo(17.113636f, 58.8f);
                instancePath.cubicTo(18.767881f, 58.8f, 21.473185f, 52.682735f, 21.45003f, 48.610233f);
                instancePath.cubicTo(21.44583f, 47.871643f, 21.893257f, 47.20545f, 22.578545f, 46.929924f);
                instancePath.cubicTo(22.606636f, 46.918633f, 23.278717f, 46.687675f, 23.598373f, 46.56531f);
                instancePath.cubicTo(24.181757f, 46.341995f, 24.740587f, 46.091393f, 25.253809f, 45.809593f);
                instancePath.cubicTo(26.021929f, 45.38784f, 26.60472f, 44.93803f, 27.127216f, 44.291847f);
                instancePath.cubicTo(27.93486f, 43.528492f, 28.413317f, 42.09576f, 28.560265f, 40.59805f);
                instancePath.cubicTo(28.541952f, 40.59503f, 28.523335f, 40.592033f, 28.50442f, 40.589054f);
                instancePath.cubicTo(27.723038f, 40.466034f, 26.597982f, 40.398083f, 25.183475f, 40.377266f);
                instancePath.cubicTo(24.30732f, 40.364372f, 23.47289f, 40.368793f, 22.212122f, 40.3865f);
                instancePath.cubicTo(21.68587f, 40.3941f, 21.68587f, 40.3941f, 21.182892f, 40.399868f);
                instancePath.cubicTo(18.363535f, 40.36595f, 17.463614f, 38.17416f, 17.345175f, 34.675396f);
                instancePath.close();
                instancePath.moveTo(54.654827f, 34.675396f);
                instancePath.cubicTo(54.536385f, 38.17416f, 53.636463f, 40.36595f, 50.81711f, 40.399868f);
                instancePath.cubicTo(50.314133f, 40.3941f, 50.314133f, 40.3941f, 49.78788f, 40.3865f);
                instancePath.cubicTo(48.527107f, 40.368793f, 47.69268f, 40.364372f, 46.816525f, 40.377266f);
                instancePath.cubicTo(45.402016f, 40.398083f, 44.276962f, 40.466034f, 43.495583f, 40.589054f);
                instancePath.cubicTo(43.476665f, 40.592033f, 43.45805f, 40.59503f, 43.439735f, 40.59805f);
                instancePath.cubicTo(43.58668f, 42.09576f, 44.06514f, 43.528492f, 44.872784f, 44.291847f);
                instancePath.cubicTo(45.39528f, 44.93803f, 45.97807f, 45.38784f, 46.74619f, 45.809593f);
                instancePath.cubicTo(47.25941f, 46.091393f, 47.81824f, 46.341995f, 48.401627f, 46.56531f);
                instancePath.cubicTo(48.721283f, 46.687675f, 49.393364f, 46.918633f, 49.421455f, 46.929924f);
                instancePath.cubicTo(50.106743f, 47.20545f, 50.55417f, 47.871643f, 50.549973f, 48.610233f);
                instancePath.cubicTo(50.526814f, 52.682735f, 53.232117f, 58.8f, 54.886364f, 58.8f);
                instancePath.lineTo(54.886364f, 58.8f);
                instancePath.lineTo(58.2f, 58.8f);
                instancePath.lineTo(58.2f, 36.656193f);
                instancePath.close();
                instancePath.moveTo(35.498802f, 28.301212f);
                instancePath.cubicTo(30.491661f, 28.301212f, 25.766533f, 27.398115f, 21.598701f, 25.976725f);
                instancePath.lineTo(21.599167f, 36.794827f);
                instancePath.cubicTo(21.735456f, 36.793007f, 21.865477f, 36.79113f, 22.161568f, 36.786854f);
                instancePath.cubicTo(23.454443f, 36.768696f, 24.31712f, 36.764126f, 25.236452f, 36.777657f);
                instancePath.cubicTo(30.496305f, 36.85507f, 32.20909f, 37.12473f, 32.20909f, 39.6f);
                instancePath.cubicTo(32.20909f, 42.33047f, 31.494013f, 45.118053f, 29.794847f, 46.69162f);
                instancePath.cubicTo(29.11481f, 47.583206f, 28.156849f, 48.322582f, 26.986475f, 48.965202f);
                instancePath.cubicTo(26.350914f, 49.314175f, 25.68697f, 49.615368f, 25.002779f, 49.88205f);
                instancePath.cubicTo(24.930141f, 50.83369f, 24.775513f, 51.819298f, 24.548897f, 52.800533f);
                instancePath.lineTo(47.450874f, 52.799534f);
                instancePath.cubicTo(47.22438f, 51.81863f, 47.06983f, 50.833366f, 46.997223f, 49.88205f);
                instancePath.cubicTo(46.31303f, 49.615368f, 45.649086f, 49.314175f, 45.013523f, 48.965202f);
                instancePath.cubicTo(43.84315f, 48.322582f, 42.88519f, 47.583206f, 42.205154f, 46.69162f);
                instancePath.cubicTo(40.50599f, 45.118053f, 39.79091f, 42.33047f, 39.79091f, 39.6f);
                instancePath.cubicTo(39.79091f, 37.12473f, 41.503696f, 36.85507f, 46.763546f, 36.777657f);
                instancePath.cubicTo(47.68288f, 36.764126f, 48.54556f, 36.768696f, 49.838432f, 36.786854f);
                instancePath.cubicTo(50.13452f, 36.79113f, 50.26454f, 36.793007f, 50.400833f, 36.794827f);
                instancePath.lineTo(50.400635f, 25.621305f);
                instancePath.cubicTo(45.99474f, 27.245876f, 40.91155f, 28.301212f, 35.498802f, 28.301212f);
                instancePath.close();
                instancePath.moveTo(50.4f, 13.2f);
                instancePath.lineTo(21.599998f, 13.2f);
                instancePath.lineTo(21.598938f, 22.938759f);
                instancePath.cubicTo(25.71817f, 24.260946f, 30.456846f, 25.10225f, 35.498802f, 25.10225f);
                instancePath.cubicTo(40.955147f, 25.10225f, 46.05631f, 24.116974f, 50.401592f, 22.60321f);
                instancePath.lineTo(50.4f, 13.2f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
