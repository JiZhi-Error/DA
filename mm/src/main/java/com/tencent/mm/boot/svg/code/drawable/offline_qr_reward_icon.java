package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class offline_qr_reward_icon extends c {
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
                instancePath.moveTo(16.394772f, 3.1285794f);
                instancePath.cubicTo(17.075039f, 4.1235495f, 17.257702f, 5.1732597f, 17.257702f, 7.380046f);
                instancePath.cubicTo(17.257702f, 7.9821787f, 17.600342f, 8.3498535f, 18.06876f, 8.63501f);
                instancePath.cubicTo(18.537178f, 8.920166f, 19.731812f, 8.920166f, 20.582224f, 10.546875f);
                instancePath.cubicTo(20.768192f, 10.902606f, 20.89736f, 11.486276f, 20.958921f, 12.203045f);
                instancePath.cubicTo(20.961582f, 12.205812f, 20.963276f, 12.209186f, 20.964931f, 12.212606f);
                instancePath.cubicTo(21.009464f, 12.304601f, 21.00794f, 12.398245f, 20.980711f, 12.485025f);
                instancePath.cubicTo(21.131207f, 15.064939f, 20.464447f, 19.082254f, 18.537178f, 20.657434f);
                instancePath.cubicTo(17.769659f, 21.284983f, 16.227789f, 21.859854f, 15.036398f, 21.956717f);
                instancePath.cubicTo(14.718385f, 21.98251f, 14.023379f, 21.995777f, 12.798568f, 21.999134f);
                instancePath.lineTo(11.391493f, 21.999285f);
                instancePath.cubicTo(9.796496f, 21.996326f, 7.620755f, 21.98433f, 4.7114534f, 21.965908f);
                instancePath.cubicTo(3.7658367f, 21.960314f, 3.0f, 21.206362f, 3.0f, 20.272781f);
                instancePath.lineTo(3.0f, 12.240013f);
                instancePath.cubicTo(3.0f, 11.302401f, 3.774393f, 10.546875f, 4.724333f, 10.546875f);
                instancePath.lineTo(6.8075356f, 10.546875f);
                instancePath.cubicTo(7.326406f, 10.546875f, 7.8116508f, 10.498538f, 8.390563f, 10.372045f);
                instancePath.cubicTo(8.799025f, 10.282749f, 9.138386f, 10.122258f, 9.761922f, 9.759254f);
                instancePath.cubicTo(10.46075f, 9.352451f, 10.872559f, 8.890753f, 11.181692f, 8.079155f);
                instancePath.cubicTo(11.356481f, 7.619554f, 11.415833f, 7.168682f, 11.479389f, 5.8346047f);
                instancePath.cubicTo(11.485712f, 5.702118f, 11.488478f, 5.63773f, 11.495508f, 5.4446464f);
                instancePath.lineTo(11.50425f, 5.201375f);
                instancePath.lineTo(11.50425f, 5.201375f);
                instancePath.cubicTo(11.569209f, 3.3827739f, 11.763427f, 2.7348166f, 12.777836f, 2.267099f);
                instancePath.cubicTo(14.133574f, 1.6419218f, 15.753089f, 2.1898446f, 16.394772f, 3.1285794f);
                instancePath.close();
                instancePath.moveTo(13.280289f, 3.3568425f);
                instancePath.cubicTo(12.826633f, 3.5660112f, 12.757394f, 3.7349942f, 12.7034855f, 5.244211f);
                instancePath.cubicTo(12.68864f, 5.6598115f, 12.686555f, 5.7130694f, 12.67803f, 5.8917084f);
                instancePath.cubicTo(12.608539f, 7.3503747f, 12.536832f, 7.891698f, 12.3031f, 8.506293f);
                instancePath.cubicTo(11.902504f, 9.558014f, 11.31728f, 10.242358f, 10.365666f, 10.796314f);
                instancePath.cubicTo(9.6159115f, 11.232799f, 9.188725f, 11.425896f, 8.646721f, 11.544386f);
                instancePath.cubicTo(8.001813f, 11.6853f, 7.4311414f, 11.746875f, 6.8075356f, 11.746875f);
                instancePath.lineTo(4.724333f, 11.746875f);
                instancePath.cubicTo(4.4300494f, 11.746875f, 4.2f, 11.972315f, 4.2f, 12.240013f);
                instancePath.lineTo(4.2f, 20.272781f);
                instancePath.cubicTo(4.2f, 20.540194f, 4.4267745f, 20.764204f, 4.719051f, 20.765932f);
                instancePath.cubicTo(7.7034917f, 20.784828f, 9.847221f, 20.795992f, 11.382798f, 20.799109f);
                instancePath.lineTo(11.977653f, 20.799934f);
                instancePath.cubicTo(12.102566f, 20.800018f, 12.222714f, 20.800034f, 12.338274f, 20.799984f);
                instancePath.lineTo(12.827905f, 20.799301f);
                instancePath.cubicTo(14.054125f, 20.796272f, 14.657234f, 20.78353f, 14.939156f, 20.760664f);
                instancePath.cubicTo(15.894987f, 20.682951f, 17.20621f, 20.195623f, 17.777777f, 19.728289f);
                instancePath.cubicTo(19.026552f, 18.707651f, 19.79639f, 15.594138f, 19.843119f, 13.304035f);
                instancePath.cubicTo(19.160755f, 13.672963f, 18.393515f, 14.088286f, 17.606236f, 14.514455f);
                instancePath.lineTo(16.874205f, 14.910717f);
                instancePath.cubicTo(14.101559f, 16.411606f, 11.328912f, 17.912493f, 11.328912f, 17.912493f);
                instancePath.lineTo(11.269167f, 17.94499f);
                instancePath.cubicTo(11.195391f, 17.97961f, 11.112337f, 18.0f, 11.024304f, 18.0f);
                instancePath.cubicTo(10.81995f, 18.0f, 10.6423f, 17.89444f, 10.549062f, 17.738543f);
                instancePath.lineTo(10.513533f, 17.66548f);
                instancePath.lineTo(9.026025f, 14.602328f);
                instancePath.cubicTo(9.009957f, 14.568983f, 9.0f, 14.531177f, 9.0f, 14.494432f);
                instancePath.cubicTo(9.0f, 14.353402f, 9.121979f, 14.239135f, 9.272245f, 14.239135f);
                instancePath.cubicTo(9.333801f, 14.239135f, 9.389698f, 14.258038f, 9.435412f, 14.289897f);
                instancePath.lineTo(11.1904125f, 15.462525f);
                instancePath.cubicTo(11.318275f, 15.541111f, 11.471936f, 15.587414f, 11.636687f, 15.587414f);
                instancePath.cubicTo(11.734677f, 15.587414f, 11.828594f, 15.570422f, 11.915722f, 15.540474f);
                instancePath.cubicTo(11.915722f, 15.540474f, 13.727299f, 14.785642f, 15.7006645f, 13.963719f);
                instancePath.lineTo(16.19642f, 13.757239f);
                instancePath.cubicTo(17.569614f, 13.18533f, 18.954395f, 12.608761f, 19.807758f, 12.253891f);
                instancePath.cubicTo(19.757805f, 11.777024f, 19.663137f, 11.378967f, 19.518776f, 11.102825f);
                instancePath.cubicTo(19.340113f, 10.761068f, 19.146963f, 10.522478f, 18.935493f, 10.351251f);
                instancePath.cubicTo(18.694187f, 10.155866f, 18.838766f, 10.217297f, 17.909906f, 9.876473f);
                instancePath.cubicTo(17.73128f, 9.810931f, 17.588898f, 9.747756f, 17.444773f, 9.660017f);
                instancePath.cubicTo(16.578629f, 9.13274f, 16.057701f, 8.400072f, 16.057701f, 7.380046f);
                instancePath.cubicTo(16.057701f, 5.331805f, 15.899672f, 4.5305886f, 15.40417f, 3.8058593f);
                instancePath.cubicTo(15.047837f, 3.2845705f, 14.030695f, 3.0108044f, 13.280289f, 3.3568425f);
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
