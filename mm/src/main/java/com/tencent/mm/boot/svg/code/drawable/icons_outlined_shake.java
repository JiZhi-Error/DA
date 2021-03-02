package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_shake extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(19.63084f, 21.080963f);
                instancePath.lineTo(18.14217f, 15.525174f);
                instancePath.cubicTo(17.716177f, 13.935343f, 18.659878f, 12.301132f, 20.255802f, 11.873506f);
                instancePath.lineTo(46.36143f, 4.878524f);
                instancePath.cubicTo(47.95475f, 4.451595f, 49.591873f, 5.394856f, 50.017723f, 6.984146f);
                instancePath.lineTo(52.352222f, 15.69661f);
                instancePath.lineTo(53.80111f, 15.308382f);
                instancePath.cubicTo(56.201706f, 14.665144f, 58.669224f, 16.089766f, 59.31246f, 18.490362f);
                instancePath.lineTo(64.74766f, 38.774803f);
                instancePath.cubicTo(65.3909f, 41.175404f, 63.966278f, 43.642918f, 61.56568f, 44.286156f);
                instancePath.lineTo(60.11679f, 44.674385f);
                instancePath.lineTo(62.45129f, 53.38685f);
                instancePath.cubicTo(62.877285f, 54.97668f, 61.933582f, 56.610893f, 60.337658f, 57.038517f);
                instancePath.lineTo(34.23203f, 64.0335f);
                instancePath.cubicTo(32.63871f, 64.46043f, 31.001587f, 63.51717f, 30.575737f, 61.92788f);
                instancePath.lineTo(30.073505f, 60.05352f);
                instancePath.lineTo(23.190367f, 64.38765f);
                instancePath.cubicTo(21.851406f, 65.23076f, 20.087831f, 64.889f, 19.160738f, 63.606762f);
                instancePath.lineTo(8.842778f, 49.33626f);
                instancePath.cubicTo(8.787135f, 49.2593f, 8.735177f, 49.179745f, 8.687081f, 49.09786f);
                instancePath.cubicTo(7.847965f, 47.669205f, 8.325879f, 45.830814f, 9.754532f, 44.9917f);
                instancePath.lineTo(15.436389f, 41.654472f);
                instancePath.cubicTo(13.322199f, 36.050327f, 12.747536f, 31.40597f, 13.7123995f, 27.721401f);
                instancePath.cubicTo(14.569988f, 24.446487f, 17.129726f, 22.111666f, 19.63084f, 21.080963f);
                instancePath.close();
                instancePath.moveTo(23.22541f, 20.586756f);
                instancePath.cubicTo(26.56504f, 21.41937f, 36.099846f, 29.058357f, 37.88442f, 29.561274f);
                instancePath.cubicTo(39.725742f, 30.080183f, 40.07945f, 36.12351f, 36.584797f, 38.572872f);
                instancePath.cubicTo(35.233646f, 39.51988f, 33.721745f, 40.024612f, 32.049084f, 40.08707f);
                instancePath.cubicTo(30.933979f, 40.128708f, 29.68132f, 39.930367f, 28.291107f, 39.49205f);
                instancePath.lineTo(28.307127f, 39.551975f);
                instancePath.lineTo(33.892654f, 60.39744f);
                instancePath.lineTo(58.813538f, 53.71991f);
                instancePath.lineTo(56.639458f, 45.606133f);
                instancePath.lineTo(54.045914f, 46.30107f);
                instancePath.cubicTo(52.557175f, 46.699978f, 51.00838f, 45.905895f, 50.463318f, 44.464237f);
                instancePath.lineTo(42.519604f, 23.453556f);
                instancePath.cubicTo(41.64069f, 21.128878f, 42.812714f, 18.531853f, 45.137394f, 17.652939f);
                instancePath.cubicTo(45.277264f, 17.600056f, 45.419685f, 17.554178f, 45.56412f, 17.515476f);
                instancePath.lineTo(48.87489f, 16.628359f);
                instancePath.lineTo(46.70081f, 8.514582f);
                instancePath.lineTo(21.77992f, 15.192114f);
                instancePath.lineTo(23.22541f, 20.586756f);
                instancePath.close();
                instancePath.moveTo(60.63393f, 40.808823f);
                instancePath.cubicTo(61.11405f, 40.680176f, 61.398975f, 40.186672f, 61.27033f, 39.706554f);
                instancePath.lineTo(55.83513f, 19.422112f);
                instancePath.cubicTo(55.706482f, 18.941992f, 55.21298f, 18.657066f, 54.732857f, 18.785715f);
                instancePath.lineTo(46.495872f, 20.99281f);
                instancePath.cubicTo(46.466984f, 21.00055f, 46.4385f, 21.009726f, 46.410526f, 21.020302f);
                instancePath.cubicTo(45.94559f, 21.196083f, 45.711185f, 21.715488f, 45.886967f, 22.180426f);
                instancePath.lineTo(53.638653f, 42.683205f);
                instancePath.lineTo(60.63393f, 40.808823f);
                instancePath.close();
                instancePath.moveTo(38.38346f, 50.497814f);
                instancePath.lineTo(49.97457f, 47.391987f);
                instancePath.lineTo(50.90632f, 50.86932f);
                instancePath.lineTo(39.31521f, 53.975147f);
                instancePath.lineTo(38.38346f, 50.497814f);
                instancePath.close();
                instancePath.moveTo(33.1506f, 30.949982f);
                instancePath.cubicTo(32.328472f, 30.397846f, 29.081652f, 28.152082f, 28.722095f, 27.906218f);
                instancePath.cubicTo(28.403164f, 27.688133f, 28.103218f, 27.484318f, 27.815187f, 27.290106f);
                instancePath.cubicTo(24.936466f, 25.349058f, 22.818832f, 24.145329f, 22.456547f, 24.097673f);
                instancePath.cubicTo(20.850422f, 23.88641f, 17.89158f, 25.9732f, 17.194971f, 28.63337f);
                instancePath.cubicTo(16.445839f, 31.494116f, 16.93138f, 35.418182f, 18.80467f, 40.38377f);
                instancePath.lineTo(19.875486f, 43.22221f);
                instancePath.lineTo(12.14673f, 47.76168f);
                instancePath.lineTo(21.748344f, 61.041424f);
                instancePath.lineTo(29.100416f, 56.4219f);
                instancePath.lineTo(23.130272f, 34.14102f);
                instancePath.lineTo(29.206959f, 36.081844f);
                instancePath.cubicTo(31.48609f, 36.77342f, 33.14846f, 36.585167f, 34.518574f, 35.62487f);
                instancePath.cubicTo(35.1246f, 35.20011f, 35.571976f, 34.242756f, 35.642685f, 33.117405f);
                instancePath.cubicTo(35.65678f, 32.89303f, 35.65332f, 32.683052f, 35.63792f, 32.502304f);
                instancePath.cubicTo(34.992462f, 32.16271f, 34.222847f, 31.670094f, 33.1506f, 30.949982f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
