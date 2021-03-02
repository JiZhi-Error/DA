package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class album_ad_finder_link_dark_icon extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(1291845631);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(39.8201f, 7.55408f);
                instancePath.cubicTo(40.8623f, 8.04519f, 41.6457f, 9.00361f, 42.1539f, 10.2758f);
                instancePath.cubicTo(42.8445f, 12.0043f, 42.9244f, 14.7808f, 42.6595f, 17.835f);
                instancePath.cubicTo(42.3907f, 20.9334f, 41.7521f, 24.4636f, 40.8954f, 27.7926f);
                instancePath.cubicTo(40.0398f, 31.117f, 38.9574f, 34.2774f, 37.7874f, 36.6241f);
                instancePath.cubicTo(37.2042f, 37.794f, 36.581f, 38.799f, 35.9278f, 39.5237f);
                instancePath.cubicTo(35.2952f, 40.2254f, 34.5106f, 40.8002f, 33.6011f, 40.8002f);
                instancePath.cubicTo(32.6375f, 40.8002f, 31.74f, 40.3972f, 30.8951f, 39.7572f);
                instancePath.cubicTo(30.0533f, 39.1196f, 29.2115f, 38.2078f, 28.3409f, 37.0927f);
                instancePath.cubicTo(27.5501f, 36.0796f, 26.7316f, 34.8812f, 25.8967f, 33.5406f);
                instancePath.cubicTo(25.248f, 32.4989f, 24.6112f, 31.4073f, 23.9994f, 30.3037f);
                instancePath.cubicTo(23.3875f, 31.4075f, 22.7508f, 32.4992f, 22.1022f, 33.5406f);
                instancePath.cubicTo(21.2673f, 34.8812f, 20.4488f, 36.0796f, 19.658f, 37.0927f);
                instancePath.cubicTo(18.7874f, 38.2078f, 17.9456f, 39.1196f, 17.1038f, 39.7572f);
                instancePath.cubicTo(16.2588f, 40.3972f, 15.3614f, 40.8002f, 14.3978f, 40.8002f);
                instancePath.cubicTo(13.4883f, 40.8002f, 12.7037f, 40.2254f, 12.0711f, 39.5237f);
                instancePath.cubicTo(11.4179f, 38.799f, 10.7947f, 37.794f, 10.2115f, 36.6241f);
                instancePath.cubicTo(9.04152f, 34.2774f, 7.95908f, 31.1171f, 7.10352f, 27.7927f);
                instancePath.cubicTo(6.24677f, 24.4636f, 5.60813f, 20.9334f, 5.3394f, 17.8351f);
                instancePath.cubicTo(5.0745f, 14.7809f, 5.15435f, 12.0044f, 5.84497f, 10.2759f);
                instancePath.lineTo(5.95028f, 10.0257f);
                instancePath.cubicTo(6.4588f, 8.87797f, 7.20606f, 8.01247f, 8.17881f, 7.55409f);
                instancePath.cubicTo(9.2309f, 7.05833f, 10.4193f, 7.09884f, 11.6043f, 7.5782f);
                instancePath.cubicTo(13.2792f, 8.25572f, 15.0242f, 9.82118f, 16.8736f, 11.994f);
                instancePath.cubicTo(17.987f, 13.302f, 19.1449f, 14.8428f, 20.3302f, 16.5645f);
                instancePath.cubicTo(21.5954f, 18.4023f, 22.8339f, 20.3599f, 23.9994f, 22.3185f);
                instancePath.cubicTo(24.9232f, 20.7662f, 25.8926f, 19.2148f, 26.8848f, 17.7233f);
                instancePath.lineTo(26.8882f, 17.718f);
                instancePath.lineTo(27.6687f, 16.5645f);
                instancePath.cubicTo(28.854f, 14.8427f, 30.0119f, 13.302f, 31.1252f, 11.994f);
                instancePath.cubicTo(32.9747f, 9.82118f, 34.7197f, 8.25572f, 36.3946f, 7.5782f);
                instancePath.cubicTo(37.5796f, 7.09884f, 38.768f, 7.05833f, 39.8201f, 7.55408f);
                instancePath.close();
                instancePath.moveTo(38.2055f, 11.0321f);
                instancePath.cubicTo(38.1736f, 11.0297f, 38.0736f, 11.0363f, 37.8453f, 11.1287f);
                instancePath.cubicTo(36.9789f, 11.4791f, 35.675f, 12.5788f, 34.0642f, 14.4712f);
                instancePath.cubicTo(33.0504f, 15.6623f, 31.9701f, 17.0981f, 30.8461f, 18.7307f);
                instancePath.cubicTo(29.8415f, 20.1899f, 28.8486f, 21.7372f, 27.8953f, 23.3044f);
                instancePath.cubicTo(27.8947f, 23.3053f, 27.8942f, 23.3063f, 27.8936f, 23.3073f);
                instancePath.lineTo(26.8879f, 24.9925f);
                instancePath.lineTo(26.1792f, 26.2238f);
                instancePath.lineTo(26.2946f, 26.447f);
                instancePath.lineTo(26.2976f, 26.4528f);
                instancePath.lineTo(26.7254f, 27.2641f);
                instancePath.cubicTo(26.7257f, 27.2647f, 26.726f, 27.2653f, 26.7263f, 27.2659f);
                instancePath.cubicTo(27.5039f, 28.7217f, 28.331f, 30.1735f, 29.1706f, 31.5216f);
                instancePath.cubicTo(29.9471f, 32.7686f, 30.6904f, 33.8548f, 31.3826f, 34.7414f);
                instancePath.cubicTo(32.0025f, 35.5356f, 32.5572f, 36.1281f, 32.9983f, 36.5132f);
                instancePath.cubicTo(33.182f, 36.6736f, 33.3355f, 36.7887f, 33.4567f, 36.866f);
                instancePath.cubicTo(33.5227f, 36.7753f, 33.6019f, 36.6551f, 33.6933f, 36.5014f);
                instancePath.cubicTo(33.9942f, 35.9951f, 34.3637f, 35.2337f, 34.7675f, 34.2595f);
                instancePath.cubicTo(35.5721f, 32.3184f, 36.4801f, 29.6122f, 37.2261f, 26.5949f);
                instancePath.lineTo(37.5318f, 25.3092f);
                instancePath.cubicTo(38.2341f, 22.2321f, 38.6951f, 19.2922f, 38.8743f, 16.8657f);
                instancePath.cubicTo(38.964f, 15.6517f, 38.9822f, 14.5781f, 38.928f, 13.6867f);
                instancePath.cubicTo(38.873f, 12.7831f, 38.7461f, 12.118f, 38.5758f, 11.6918f);
                instancePath.cubicTo(38.4717f, 11.4311f, 38.3825f, 11.261f, 38.3081f, 11.152f);
                instancePath.cubicTo(38.2539f, 11.0727f, 38.2183f, 11.0418f, 38.2055f, 11.0321f);
                instancePath.close();
                instancePath.moveTo(13.9344f, 14.4712f);
                instancePath.cubicTo(12.3236f, 12.5788f, 11.0197f, 11.4791f, 10.1534f, 11.1287f);
                instancePath.cubicTo(9.92501f, 11.0363f, 9.82504f, 11.0297f, 9.79313f, 11.0321f);
                instancePath.cubicTo(9.78032f, 11.0418f, 9.74477f, 11.0727f, 9.69053f, 11.152f);
                instancePath.cubicTo(9.61608f, 11.261f, 9.52687f, 11.4312f, 9.42271f, 11.692f);
                instancePath.cubicTo(9.35292f, 11.8666f, 9.29192f, 12.0762f, 9.24036f, 12.3191f);
                instancePath.lineTo(9.20422f, 12.5041f);
                instancePath.cubicTo(9.03966f, 13.4156f, 8.99331f, 14.7269f, 9.09134f, 16.3723f);
                instancePath.cubicTo(9.22178f, 18.5615f, 9.5985f, 21.2199f, 10.1902f, 24.0451f);
                instancePath.lineTo(10.4676f, 25.3127f);
                instancePath.lineTo(10.7725f, 26.5949f);
                instancePath.cubicTo(11.5185f, 29.6122f, 12.4265f, 32.3183f, 13.2311f, 34.2595f);
                instancePath.cubicTo(13.6349f, 35.2337f, 14.0044f, 35.9951f, 14.3053f, 36.5014f);
                instancePath.cubicTo(14.3967f, 36.6551f, 14.4759f, 36.7753f, 14.5419f, 36.866f);
                instancePath.cubicTo(14.6631f, 36.7887f, 14.8166f, 36.6736f, 15.0003f, 36.5133f);
                instancePath.cubicTo(15.4414f, 36.1281f, 15.9961f, 35.5356f, 16.6161f, 34.7414f);
                instancePath.cubicTo(17.3082f, 33.8548f, 18.0515f, 32.7686f, 18.8281f, 31.5216f);
                instancePath.cubicTo(19.4572f, 30.5113f, 20.0796f, 29.4425f, 20.6795f, 28.3571f);
                instancePath.lineTo(21.4072f, 27.0123f);
                instancePath.lineTo(21.8178f, 26.2214f);
                instancePath.lineTo(21.3935f, 25.4784f);
                instancePath.lineTo(20.8122f, 24.4855f);
                instancePath.cubicTo(20.8118f, 24.4849f, 20.8115f, 24.4844f, 20.8111f, 24.4838f);
                instancePath.cubicTo(19.6466f, 22.5177f, 18.4087f, 20.5554f, 17.1525f, 18.7307f);
                instancePath.cubicTo(16.7779f, 18.1865f, 16.4081f, 17.6641f, 16.0439f, 17.1654f);
                instancePath.lineTo(15.8632f, 16.9211f);
                instancePath.lineTo(15.6818f, 16.6747f);
                instancePath.cubicTo(15.0814f, 15.8701f, 14.4976f, 15.1329f, 13.9344f, 14.4712f);
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
