package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_pay_reward_code extends c {
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
                instancePath.moveTo(49.184315f, 9.385738f);
                instancePath.cubicTo(51.225117f, 12.370648f, 51.773106f, 15.519779f, 51.773106f, 22.140137f);
                instancePath.cubicTo(51.773106f, 23.946535f, 52.801025f, 25.04956f, 54.20628f, 25.90503f);
                instancePath.cubicTo(55.611534f, 26.760498f, 59.19543f, 26.760498f, 61.74667f, 31.640625f);
                instancePath.cubicTo(62.30402f, 32.706753f, 62.691303f, 34.455326f, 62.876213f, 36.60268f);
                instancePath.cubicTo(62.88293f, 36.613827f, 62.88894f, 36.625725f, 62.894794f, 36.63782f);
                instancePath.cubicTo(63.029655f, 36.916416f, 63.023724f, 37.200054f, 62.939796f, 37.462463f);
                instancePath.cubicTo(63.391655f, 45.20664f, 61.390503f, 57.249084f, 55.611534f, 61.9723f);
                instancePath.cubicTo(53.308975f, 63.85495f, 48.683365f, 65.57956f, 45.109196f, 65.870155f);
                instancePath.cubicTo(42.883102f, 66.0507f, 34.499474f, 66.026665f, 14.13436f, 65.89773f);
                instancePath.cubicTo(11.29751f, 65.88094f, 9.0f, 63.619083f, 9.0f, 60.818344f);
                instancePath.lineTo(9.0f, 36.72004f);
                instancePath.cubicTo(9.0f, 33.9072f, 11.323179f, 31.640625f, 14.172998f, 31.640625f);
                instancePath.lineTo(20.422607f, 31.640625f);
                instancePath.cubicTo(21.97922f, 31.640625f, 23.434954f, 31.495615f, 25.171688f, 31.116135f);
                instancePath.cubicTo(26.397072f, 30.848248f, 27.415157f, 30.366774f, 29.285767f, 29.277763f);
                instancePath.cubicTo(31.382248f, 28.057354f, 32.617676f, 26.672258f, 33.54508f, 24.237465f);
                instancePath.cubicTo(34.069443f, 22.858662f, 34.2475f, 21.506046f, 34.438168f, 17.503815f);
                instancePath.cubicTo(34.46346f, 16.973867f, 34.46978f, 16.807116f, 34.51275f, 15.604125f);
                instancePath.cubicTo(34.707626f, 10.148322f, 35.29028f, 8.20445f, 38.333508f, 6.8012967f);
                instancePath.cubicTo(42.40072f, 4.925765f, 47.259266f, 6.569534f, 49.184315f, 9.385738f);
                instancePath.close();
                instancePath.moveTo(39.840866f, 10.070528f);
                instancePath.cubicTo(38.4799f, 10.698033f, 38.27218f, 11.204983f, 38.110455f, 15.732634f);
                instancePath.cubicTo(38.06592f, 16.979435f, 38.059666f, 17.139208f, 38.034092f, 17.675125f);
                instancePath.cubicTo(37.825615f, 22.051125f, 37.610497f, 23.675095f, 36.909298f, 25.518879f);
                instancePath.cubicTo(35.70751f, 28.674042f, 33.95184f, 30.727074f, 31.097f, 32.388943f);
                instancePath.cubicTo(28.847733f, 33.698395f, 27.566175f, 34.277687f, 25.940165f, 34.633156f);
                instancePath.cubicTo(24.005438f, 35.055897f, 22.293425f, 35.240623f, 20.422607f, 35.240623f);
                instancePath.lineTo(14.172998f, 35.240623f);
                instancePath.cubicTo(13.290148f, 35.240623f, 12.6f, 35.916946f, 12.6f, 36.72004f);
                instancePath.lineTo(12.6f, 60.818344f);
                instancePath.cubicTo(12.6f, 61.620583f, 13.280324f, 62.29261f, 14.157153f, 62.2978f);
                instancePath.cubicTo(36.133488f, 62.43694f, 42.914497f, 62.43633f, 44.817467f, 62.28199f);
                instancePath.cubicTo(47.68496f, 62.048855f, 51.618626f, 60.58687f, 53.333332f, 59.184868f);
                instancePath.cubicTo(57.079796f, 56.122837f, 59.389347f, 46.781715f, 59.529373f, 39.91133f);
                instancePath.cubicTo(49.699345f, 45.231937f, 33.986736f, 53.73748f, 33.986736f, 53.73748f);
                instancePath.lineTo(33.8075f, 53.83497f);
                instancePath.cubicTo(33.586174f, 53.93883f, 33.33701f, 54.0f, 33.07291f, 54.0f);
                instancePath.cubicTo(32.45985f, 54.0f, 31.9269f, 53.68332f, 31.647186f, 53.21563f);
                instancePath.lineTo(31.540596f, 52.996437f);
                instancePath.lineTo(27.078075f, 43.806988f);
                instancePath.cubicTo(27.029873f, 43.706947f, 27.0f, 43.59353f, 27.0f, 43.483295f);
                instancePath.cubicTo(27.0f, 43.060207f, 27.365936f, 42.717403f, 27.816736f, 42.717403f);
                instancePath.cubicTo(28.001402f, 42.717403f, 28.169094f, 42.774113f, 28.306236f, 42.86969f);
                instancePath.lineTo(33.571236f, 46.387577f);
                instancePath.cubicTo(33.954826f, 46.623333f, 34.41581f, 46.76224f, 34.91006f, 46.76224f);
                instancePath.cubicTo(35.204033f, 46.76224f, 35.485783f, 46.711266f, 35.747166f, 46.62142f);
                instancePath.cubicTo(35.747166f, 46.62142f, 52.839283f, 39.499622f, 59.419243f, 36.76335f);
                instancePath.cubicTo(59.273693f, 35.332253f, 58.989628f, 34.13731f, 58.556328f, 33.308475f);
                instancePath.cubicTo(58.020336f, 32.283203f, 57.44089f, 31.567434f, 56.806477f, 31.053751f);
                instancePath.cubicTo(56.082565f, 30.467596f, 56.5163f, 30.651892f, 53.729717f, 29.629421f);
                instancePath.cubicTo(53.19384f, 29.432793f, 52.766697f, 29.243267f, 52.334316f, 28.980051f);
                instancePath.cubicTo(49.735886f, 27.398218f, 48.173107f, 25.200218f, 48.173107f, 22.140137f);
                instancePath.cubicTo(48.173107f, 15.995415f, 47.699017f, 13.591766f, 46.21251f, 11.417578f);
                instancePath.cubicTo(45.143513f, 9.853711f, 42.092087f, 9.032413f, 39.840866f, 10.070528f);
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
