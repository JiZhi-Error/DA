package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_wechat_out extends c {
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
                instancePath.moveTo(35.820152f, 21.805954f);
                instancePath.cubicTo(35.368004f, 17.79695f, 36.550266f, 13.941129f, 39.27993f, 11.16775f);
                instancePath.cubicTo(44.537865f, 5.8083363f, 53.62144f, 6.355517f, 59.609756f, 12.229036f);
                instancePath.cubicTo(65.546165f, 18.103611f, 66.243286f, 27.169064f, 61.001232f, 32.512226f);
                instancePath.cubicTo(58.24681f, 35.359013f, 54.288517f, 36.622124f, 50.19502f, 36.15083f);
                instancePath.cubicTo(49.889423f, 36.6213f, 49.537136f, 37.055885f, 49.12692f, 37.465485f);
                instancePath.cubicTo(45.51696f, 41.1292f, 39.294346f, 40.75426f, 35.31318f, 36.77882f);
                instancePath.cubicTo(31.25489f, 32.839188f, 30.772078f, 26.62562f, 34.40147f, 22.942354f);
                instancePath.cubicTo(34.836002f, 22.508474f, 35.30956f, 22.129234f, 35.820152f, 21.805954f);
                instancePath.close();
                instancePath.moveTo(47.972206f, 31.962624f);
                instancePath.cubicTo(48.197887f, 30.030882f, 47.419476f, 27.84523f, 45.74796f, 26.205503f);
                instancePath.cubicTo(44.094612f, 24.5836f, 41.95556f, 23.838194f, 40.01201f, 24.042467f);
                instancePath.cubicTo(40.658344f, 25.815674f, 41.73674f, 27.491978f, 43.186256f, 28.939444f);
                instancePath.cubicTo(44.593365f, 30.313217f, 46.24962f, 31.348162f, 47.972206f, 31.962624f);
                instancePath.close();
                instancePath.moveTo(50.72886f, 45.75217f);
                instancePath.lineTo(61.51254f, 49.80211f);
                instancePath.cubicTo(63.480694f, 50.63354f, 64.761246f, 52.51024f, 64.90459f, 54.661503f);
                instancePath.cubicTo(64.92097f, 54.857704f, 64.92087f, 55.053158f, 64.90701f, 55.248974f);
                instancePath.cubicTo(64.87849f, 55.651924f, 64.79563f, 56.034782f, 64.675026f, 56.421837f);
                instancePath.cubicTo(64.61388f, 56.61808f, 64.54307f, 56.811737f, 64.50051f, 56.92317f);
                instancePath.cubicTo(62.46777f, 62.448444f, 57.243507f, 66.18793f, 51.28856f, 66.18793f);
                instancePath.cubicTo(49.920162f, 66.18793f, 48.49217f, 65.95028f, 47.670025f, 65.71261f);
                instancePath.cubicTo(37.57302f, 63.408188f, 28.384508f, 58.274864f, 21.06704f, 50.968384f);
                instancePath.cubicTo(13.749243f, 43.661575f, 8.607737f, 34.48603f, 6.267779f, 24.231745f);
                instancePath.cubicTo(6.270988f, 24.254175f, 6.136847f, 23.626104f, 6.0721655f, 23.275263f);
                instancePath.cubicTo(5.914704f, 22.421171f, 5.823305f, 21.608055f, 5.823305f, 20.787783f);
                instancePath.cubicTo(5.823305f, 14.838872f, 9.569203f, 9.621347f, 15.161819f, 7.5710254f);
                instancePath.cubicTo(15.315471f, 7.517915f, 15.49734f, 7.459445f, 15.715516f, 7.4001756f);
                instancePath.cubicTo(16.043274f, 7.311137f, 16.368963f, 7.244495f, 16.699514f, 7.2089505f);
                instancePath.cubicTo(16.863703f, 7.1912956f, 17.0265f, 7.18178f, 17.258839f, 7.182942f);
                instancePath.cubicTo(19.468855f, 7.2564983f, 21.383158f, 8.537786f, 22.258429f, 10.607925f);
                instancePath.lineTo(26.26432f, 21.243252f);
                instancePath.cubicTo(26.674992f, 22.370901f, 26.52397f, 23.225407f, 25.925602f, 24.319908f);
                instancePath.cubicTo(24.850695f, 26.19817f, 22.63567f, 30.28131f, 21.48311f, 32.539143f);
                instancePath.cubicTo(21.311522f, 32.857327f, 21.217373f, 33.220825f, 21.217373f, 33.561794f);
                instancePath.cubicTo(21.217373f, 33.893486f, 21.327755f, 34.266994f, 21.537537f, 34.608128f);
                instancePath.cubicTo(23.616108f, 38.131565f, 25.873028f, 41.14371f, 28.374208f, 43.641243f);
                instancePath.cubicTo(30.84383f, 46.14895f, 33.840275f, 48.39845f, 37.431187f, 50.51092f);
                instancePath.cubicTo(37.758274f, 50.711906f, 38.087967f, 50.810665f, 38.448303f, 50.810665f);
                instancePath.cubicTo(38.817825f, 50.810665f, 39.13733f, 50.72671f, 39.504196f, 50.52973f);
                instancePath.cubicTo(41.58053f, 49.453255f, 45.48824f, 47.339756f, 47.744305f, 46.08834f);
                instancePath.cubicTo(48.798836f, 45.514008f, 49.58466f, 45.37134f, 50.72886f, 45.75217f);
                instancePath.close();
                instancePath.moveTo(41.181084f, 53.71522f);
                instancePath.cubicTo(40.32879f, 54.173462f, 39.42606f, 54.410664f, 38.448303f, 54.410664f);
                instancePath.cubicTo(37.40218f, 54.410664f, 36.424953f, 54.117935f, 35.571323f, 53.593086f);
                instancePath.cubicTo(31.7605f, 51.351727f, 28.516785f, 48.91659f, 25.818104f, 46.176216f);
                instancePath.cubicTo(23.09831f, 43.460506f, 20.661366f, 40.208096f, 18.451855f, 36.462143f);
                instancePath.cubicTo(17.920092f, 35.599327f, 17.617373f, 34.57499f, 17.617373f, 33.561794f);
                instancePath.cubicTo(17.617373f, 32.6165f, 17.86328f, 31.667091f, 18.298601f, 30.860672f);
                instancePath.cubicTo(19.455837f, 28.59247f, 21.698269f, 24.458813f, 22.786577f, 22.557726f);
                instancePath.cubicTo(22.813852f, 22.507795f, 21.522354f, 18.966343f, 18.912085f, 11.933369f);
                instancePath.cubicTo(18.622013f, 11.248772f, 17.964088f, 10.808409f, 17.188984f, 10.781779f);
                instancePath.cubicTo(16.964445f, 10.801216f, 16.81752f, 10.83128f, 16.659285f, 10.874266f);
                instancePath.cubicTo(16.534603f, 10.908136f, 16.437805f, 10.939256f, 16.341541f, 10.971815f);
                instancePath.cubicTo(12.20942f, 12.487458f, 9.4233055f, 16.368135f, 9.4233055f, 20.787783f);
                instancePath.cubicTo(9.4233055f, 21.359446f, 9.4915285f, 21.966389f, 9.612502f, 22.622562f);
                instancePath.cubicTo(9.6574545f, 22.866392f, 9.813884f, 23.598818f, 9.808788f, 23.599607f);
                instancePath.cubicTo(11.964259f, 33.015633f, 16.768066f, 41.58852f, 23.61071f, 48.420887f);
                instancePath.cubicTo(30.453588f, 55.25349f, 39.03996f, 60.050415f, 48.548798f, 62.222805f);
                instancePath.cubicTo(49.18194f, 62.40343f, 50.29056f, 62.587925f, 51.28856f, 62.587925f);
                instancePath.cubicTo(55.716927f, 62.587925f, 59.604233f, 59.805424f, 61.10685f, 55.72311f);
                instancePath.cubicTo(61.176903f, 55.531948f, 61.20863f, 55.44517f, 61.238026f, 55.350834f);
                instancePath.cubicTo(61.282673f, 55.20756f, 61.30981f, 55.08216f, 61.315994f, 54.994804f);
                instancePath.cubicTo(61.258045f, 54.080116f, 60.8003f, 53.409275f, 60.167988f, 53.140827f);
                instancePath.lineTo(49.59261f, 49.16933f);
                instancePath.cubicTo(47.20743f, 50.502876f, 43.271847f, 52.63145f, 41.181084f, 53.71522f);
                instancePath.close();
                instancePath.moveTo(48.26899f, 23.635597f);
                instancePath.cubicTo(50.793613f, 26.112207f, 51.970867f, 29.519043f, 51.513943f, 32.641685f);
                instancePath.cubicTo(54.193916f, 32.728634f, 56.670456f, 31.811007f, 58.42273f, 30.000025f);
                instancePath.cubicTo(62.201443f, 26.148378f, 61.67792f, 19.340382f, 57.083233f, 14.793527f);
                instancePath.cubicTo(52.446167f, 10.245373f, 45.630814f, 9.8348255f, 41.847694f, 13.69096f);
                instancePath.cubicTo(40.111706f, 15.454752f, 39.247128f, 17.871756f, 39.33164f, 20.498877f);
                instancePath.cubicTo(42.434425f, 20.0714f, 45.772194f, 21.18629f, 48.26899f, 23.635597f);
                instancePath.close();
                instancePath.moveTo(40.65698f, 31.50115f);
                instancePath.cubicTo(38.93371f, 29.780466f, 37.618736f, 27.79349f, 36.77918f, 25.668589f);
                instancePath.cubicTo(34.839188f, 27.869429f, 35.202587f, 31.654177f, 37.838783f, 34.21354f);
                instancePath.cubicTo(40.3847f, 36.75563f, 44.114563f, 37.077385f, 46.30344f, 35.18112f);
                instancePath.cubicTo(44.256634f, 34.37767f, 42.31971f, 33.124603f, 40.65698f, 31.50115f);
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
