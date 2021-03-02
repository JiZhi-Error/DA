package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class kinda_finger_print_error extends c {
    private final int height = 192;
    private final int width = 192;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                instancePaint3.setColor(-372399);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(142.50526f, 36.56f);
                instancePath.cubicTo(141.71793f, 36.56f, 140.94272f, 36.359947f, 140.29865f, 35.991043f);
                instancePath.cubicTo(125.05224f, 28.129616f, 111.89752f, 24.8f, 96.10527f, 24.8f);
                instancePath.cubicTo(80.328896f, 24.8f, 65.43216f, 28.559177f, 51.926296f, 35.983433f);
                instancePath.cubicTo(49.62771f, 37.228504f, 46.752804f, 36.377766f, 45.401836f, 34.061028f);
                instancePath.cubicTo(44.149986f, 31.749918f, 45.01832f, 28.785608f, 47.323513f, 27.536963f);
                instancePath.cubicTo(62.36317f, 19.370268f, 78.820465f, 15.2f, 96.10527f, 15.2f);
                instancePath.cubicTo(113.26143f, 15.2f, 128.26701f, 18.984678f, 144.71436f, 27.450226f);
                instancePath.cubicTo(147.09697f, 28.689188f, 147.98918f, 31.573994f, 146.74081f, 33.87777f);
                instancePath.cubicTo(145.90292f, 35.553535f, 144.2873f, 36.56f, 142.50526f, 36.56f);
                instancePath.close();
                instancePath.moveTo(28.02527f, 78.56f);
                instancePath.cubicTo(27.05606f, 78.56f, 26.103327f, 78.26685f, 25.248419f, 77.696724f);
                instancePath.cubicTo(23.052362f, 76.16903f, 22.551409f, 73.19278f, 24.092085f, 70.9781f);
                instancePath.cubicTo(32.093185f, 59.663414f, 42.27532f, 50.781994f, 54.37847f, 44.569042f);
                instancePath.cubicTo(79.76219f, 31.472982f, 112.195045f, 31.427717f, 137.5906f, 44.488293f);
                instancePath.cubicTo(149.72163f, 50.71555f, 159.8939f, 59.52746f, 167.87225f, 70.72946f);
                instancePath.cubicTo(169.42644f, 72.86645f, 168.91571f, 75.93075f, 166.72212f, 77.456726f);
                instancePath.cubicTo(164.51248f, 78.99386f, 161.53624f, 78.492905f, 160.01428f, 76.30499f);
                instancePath.cubicTo(152.88078f, 66.3181f, 143.85522f, 58.487965f, 133.18057f, 53.032036f);
                instancePath.cubicTo(110.42836f, 41.378464f, 81.34131f, 41.40072f, 58.711384f, 53.11131f);
                instancePath.cubicTo(48.008747f, 58.620018f, 38.965668f, 66.50781f, 31.839865f, 76.47691f);
                instancePath.cubicTo(31.074944f, 77.81552f, 29.639168f, 78.56f, 28.02527f, 78.56f);
                instancePath.close();
                instancePath.moveTo(78.02527f, 175.12f);
                instancePath.cubicTo(76.72511f, 175.12f, 75.4833f, 174.60258f, 74.659584f, 173.68568f);
                instancePath.cubicTo(67.009094f, 166.0352f, 63.483208f, 161.48567f, 58.447556f, 152.3914f);
                instancePath.cubicTo(52.87295f, 142.45406f, 49.94527f, 130.32806f, 49.94527f, 117.28f);
                instancePath.cubicTo(49.94527f, 93.066f, 70.63531f, 73.36f, 96.02527f, 73.36f);
                instancePath.cubicTo(121.41524f, 73.36f, 142.10527f, 93.066f, 142.10527f, 117.28f);
                instancePath.cubicTo(142.10527f, 119.96183f, 139.98709f, 122.08f, 137.30527f, 122.08f);
                instancePath.cubicTo(134.62344f, 122.08f, 132.50526f, 119.96183f, 132.50526f, 117.28f);
                instancePath.cubicTo(132.50526f, 98.369804f, 116.15053f, 82.96f, 96.02527f, 82.96f);
                instancePath.cubicTo(75.90001f, 82.96f, 59.54527f, 98.369804f, 59.54527f, 117.28f);
                instancePath.cubicTo(59.54527f, 128.68294f, 62.079193f, 139.18352f, 66.88431f, 147.69096f);
                instancePath.cubicTo(71.440056f, 155.87708f, 74.36921f, 159.59927f, 81.56527f, 166.889f);
                instancePath.cubicTo(83.3786f, 168.79778f, 83.3786f, 171.76222f, 81.52341f, 173.71194f);
                instancePath.cubicTo(80.51424f, 174.62938f, 79.28769f, 175.12f, 78.02527f, 175.12f);
                instancePath.close();
                instancePath.moveTo(135.38527f, 160.32f);
                instancePath.cubicTo(125.69411f, 160.32f, 117.140305f, 157.86722f, 110.1364f, 153.0622f);
                instancePath.cubicTo(97.99498f, 144.83212f, 90.74527f, 131.46338f, 90.74527f, 117.28f);
                instancePath.cubicTo(90.74527f, 114.598175f, 92.86344f, 112.48f, 95.54527f, 112.48f);
                instancePath.cubicTo(98.2271f, 112.48f, 100.34527f, 114.598175f, 100.34527f, 117.28f);
                instancePath.cubicTo(100.34527f, 128.3165f, 105.99244f, 138.69795f, 115.51333f, 145.09724f);
                instancePath.cubicTo(121.03951f, 148.83325f, 127.51688f, 150.64f, 135.38527f, 150.64f);
                instancePath.cubicTo(137.52887f, 150.64f, 140.70056f, 150.35367f, 143.5596f, 149.85338f);
                instancePath.cubicTo(146.17024f, 149.36992f, 148.65736f, 151.11682f, 149.1319f, 153.77432f);
                instancePath.cubicTo(149.61534f, 156.38498f, 147.86844f, 158.87209f, 145.21686f, 159.3455f);
                instancePath.cubicTo(141.55893f, 160.05142f, 138.02611f, 160.32f, 135.38527f, 160.32f);
                instancePath.close();
                instancePath.moveTo(119.30527f, 176.8f);
                instancePath.cubicTo(118.94544f, 176.8f, 118.52947f, 176.73067f, 118.0519f, 176.61102f);
                instancePath.cubicTo(105.23481f, 173.06415f, 96.78523f, 168.28908f, 87.94161f, 159.60771f);
                instancePath.cubicTo(76.58554f, 148.33275f, 70.34527f, 133.32639f, 70.34527f, 117.28f);
                instancePath.cubicTo(70.34527f, 103.86222f, 81.75933f, 92.96f, 95.78527f, 92.96f);
                instancePath.cubicTo(109.81121f, 92.96f, 121.22527f, 103.86222f, 121.22527f, 117.28f);
                instancePath.cubicTo(121.22527f, 125.392586f, 128.30296f, 132.0f, 137.06528f, 132.0f);
                instancePath.cubicTo(145.82758f, 132.0f, 152.90527f, 125.392586f, 152.90527f, 117.28f);
                instancePath.cubicTo(152.90527f, 87.57765f, 127.27885f, 63.44f, 95.70527f, 63.44f);
                instancePath.cubicTo(73.26442f, 63.44f, 52.762203f, 75.92832f, 43.54607f, 95.22705f);
                instancePath.cubicTo(40.48127f, 101.59241f, 38.90527f, 109.07342f, 38.90527f, 117.28f);
                instancePath.cubicTo(38.90527f, 126.51887f, 40.248302f, 135.30301f, 44.21195f, 145.87282f);
                instancePath.cubicTo(45.17474f, 148.37608f, 43.913757f, 151.16824f, 41.432453f, 152.02667f);
                instancePath.cubicTo(38.960316f, 152.9775f, 36.154232f, 151.68007f, 35.27597f, 149.24026f);
                instancePath.cubicTo(31.32066f, 138.66586f, 29.385271f, 128.17087f, 29.385271f, 117.28f);
                instancePath.cubicTo(29.385271f, 107.58271f, 31.243193f, 98.74227f, 34.903126f, 91.015755f);
                instancePath.cubicTo(45.683605f, 68.40106f, 69.57526f, 53.76f, 95.70527f, 53.76f);
                instancePath.cubicTo(132.54276f, 53.76f, 162.50526f, 82.19305f, 162.50526f, 117.2f);
                instancePath.cubicTo(162.50526f, 130.61778f, 151.0912f, 141.52f, 137.06528f, 141.52f);
                instancePath.cubicTo(123.03933f, 141.52f, 111.62527f, 130.61778f, 111.62527f, 117.2f);
                instancePath.cubicTo(111.62527f, 109.08741f, 104.54758f, 102.48f, 95.78527f, 102.48f);
                instancePath.cubicTo(87.02296f, 102.48f, 79.94527f, 109.08741f, 79.94527f, 117.2f);
                instancePath.cubicTo(79.94527f, 130.69165f, 85.15763f, 143.2796f, 94.66795f, 152.71133f);
                instancePath.cubicTo(102.20712f, 160.17114f, 109.38374f, 164.24017f, 120.46604f, 167.3056f);
                instancePath.cubicTo(123.02773f, 167.96974f, 124.521454f, 170.62857f, 123.84701f, 173.12994f);
                instancePath.cubicTo(123.3802f, 175.27725f, 121.42648f, 176.8f, 119.30527f, 176.8f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
