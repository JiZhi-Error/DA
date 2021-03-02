package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class find_more_friend_shake extends c {
    private final int height = 108;
    private final int width = 108;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 21.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-7874817);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(63.68386f, 53.50257f);
                instancePath.lineTo(50.176884f, 3.746619f);
                instancePath.cubicTo(49.518417f, 1.3210886f, 46.993534f, -0.11665575f, 44.53772f, 0.53176844f);
                instancePath.lineTo(17.850698f, 7.591714f);
                instancePath.cubicTo(16.622791f, 7.915926f, 15.689582f, 8.623435f, 15.054139f, 9.708182f);
                instancePath.cubicTo(14.418697f, 10.795959f, 14.265209f, 11.944337f, 14.593675f, 13.156344f);
                instancePath.lineTo(28.10065f, 62.910778f);
                instancePath.cubicTo(28.429117f, 64.124306f, 29.144373f, 65.043915f, 30.244884f, 65.67113f);
                instancePath.cubicTo(31.34693f, 66.29834f, 32.511906f, 66.451355f, 33.738277f, 66.12563f);
                instancePath.lineTo(60.4253f, 59.0672f);
                instancePath.cubicTo(62.884186f, 58.42029f, 64.34232f, 55.9281f, 63.68386f, 53.50257f);
                instancePath.lineTo(63.68386f, 53.50257f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(22.172491f, 12.951446f);
                instancePath2.lineTo(43.58719f, 7.288339f);
                instancePath2.cubicTo(45.04226f, 6.9035263f, 46.531094f, 7.7276917f, 46.911747f, 9.129076f);
                instancePath2.lineTo(57.451794f, 47.95726f);
                instancePath2.cubicTo(57.832443f, 49.358646f, 56.96063f, 50.806995f, 55.504025f, 51.191807f);
                instancePath2.lineTo(34.08933f, 56.85491f);
                instancePath2.cubicTo(32.63426f, 57.239727f, 31.14542f, 56.417076f, 30.76477f, 55.01569f);
                instancePath2.lineTo(20.224724f, 16.185991f);
                instancePath2.cubicTo(19.845608f, 14.786122f, 20.71742f, 13.337773f, 22.172491f, 12.951446f);
                instancePath2.lineTo(22.172491f, 12.951446f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-15683841);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(63.166603f, 21.791391f);
                instancePath3.cubicTo(62.634f, 19.685528f, 60.635582f, 18.423525f, 58.700092f, 18.978018f);
                instancePath3.lineTo(46.817024f, 22.362549f);
                instancePath3.cubicTo(44.881535f, 22.915527f, 43.744186f, 25.071386f, 44.275257f, 27.178766f);
                instancePath3.cubicTo(44.80786f, 29.286144f, 46.80628f, 30.545116f, 48.7433f, 29.993654f);
                instancePath3.lineTo(60.624836f, 26.606092f);
                instancePath3.cubicTo(62.560326f, 26.054628f, 63.697674f, 23.89877f, 63.166603f, 21.791391f);
                instancePath3.lineTo(63.166603f, 21.791391f);
                instancePath3.close();
                instancePath3.moveTo(66.23791f, 39.901817f);
                instancePath3.cubicTo(65.708374f, 37.83989f, 63.71763f, 36.60364f, 61.792885f, 37.146015f);
                instancePath3.lineTo(54.477627f, 39.19734f);
                instancePath3.cubicTo(52.55135f, 39.736683f, 51.418606f, 41.848606f, 51.94814f, 43.90902f);
                instancePath3.cubicTo(52.477673f, 45.973976f, 54.46842f, 47.20871f, 56.3947f, 46.66785f);
                instancePath3.lineTo(63.709953f, 44.616528f);
                instancePath3.cubicTo(65.6347f, 44.0787f, 66.76744f, 41.96526f, 66.23791f, 39.901817f);
                instancePath3.lineTo(66.23791f, 39.901817f);
                instancePath3.close();
                instancePath3.moveTo(53.225163f, 37.603546f);
                instancePath3.lineTo(62.236465f, 35.147717f);
                instancePath3.cubicTo(64.12284f, 34.632614f, 65.23409f, 32.62068f, 64.7153f, 30.655712f);
                instancePath3.cubicTo(64.19651f, 28.68923f, 62.245674f, 27.513582f, 60.35777f, 28.028687f);
                instancePath3.lineTo(51.348f, 30.486032f);
                instancePath3.cubicTo(49.460094f, 31.00265f, 48.350372f, 33.011555f, 48.869164f, 34.978035f);
                instancePath3.cubicTo(49.386417f, 36.94149f, 51.337257f, 38.118652f, 53.225163f, 37.603546f);
                instancePath3.lineTo(53.225163f, 37.603546f);
                instancePath3.close();
                instancePath3.moveTo(13.574512f, 17.063046f);
                instancePath3.cubicTo(11.709628f, 18.961353f, 11.511628f, 22.38376f, 11.511628f, 25.998573f);
                instancePath3.cubicTo(11.511628f, 29.598236f, 14.388f, 34.94016f, 14.142419f, 38.04593f);
                instancePath3.cubicTo(13.968977f, 40.239666f, 6.351349f, 46.299706f, 1.6975814f, 49.71908f);
                instancePath3.cubicTo(-0.765907f, 51.52952f, 0.06753489f, 53.300564f, 2.112f, 55.051914f);
                instancePath3.cubicTo(5.8801394f, 58.281918f, 10.420325f, 61.675537f, 13.163163f, 64.1753f);
                instancePath3.cubicTo(17.818464f, 68.418846f, 28.39535f, 53.26875f, 28.39535f, 53.26875f);
                instancePath3.lineTo(20.72093f, 24.485079f);
                instancePath3.cubicTo(20.72093f, 24.485079f, 27.667814f, 26.948484f, 31.61093f, 26.007664f);
                instancePath3.cubicTo(35.554047f, 25.071386f, 36.069767f, 20.717249f, 36.069767f, 20.717249f);
                instancePath3.cubicTo(36.069767f, 20.717249f, 23.216652f, 13.307336f, 21.161442f, 12.837684f);
                instancePath3.cubicTo(19.106232f, 12.363485f, 15.439395f, 15.163223f, 13.574512f, 17.063046f);
                instancePath3.lineTo(13.574512f, 17.063046f);
                instancePath3.close();
                instancePath3.moveTo(48.62051f, 20.93844f);
                instancePath3.lineTo(57.631813f, 18.482609f);
                instancePath3.cubicTo(59.519722f, 17.967506f, 60.62944f, 15.955573f, 60.110653f, 13.990605f);
                instancePath3.cubicTo(59.59186f, 12.024123f, 57.64102f, 10.848475f, 55.753117f, 11.363579f);
                instancePath3.lineTo(46.743347f, 13.82244f);
                instancePath3.cubicTo(44.855442f, 14.334513f, 43.74572f, 16.346445f, 44.26451f, 18.31293f);
                instancePath3.cubicTo(44.78177f, 20.277897f, 46.732605f, 21.453545f, 48.62051f, 20.93844f);
                instancePath3.lineTo(48.62051f, 20.93844f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
