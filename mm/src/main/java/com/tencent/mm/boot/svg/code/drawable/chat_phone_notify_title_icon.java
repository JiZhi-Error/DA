package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chat_phone_notify_title_icon extends c {
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                canvas.saveLayerAlpha(null, 76, 31);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(21.964338f, 20.013182f);
                instancePath.cubicTo(22.212938f, 25.142698f, 27.100338f, 24.293186f, 30.98196f, 28.36161f);
                instancePath.cubicTo(33.576435f, 31.080942f, 33.458485f, 36.539135f, 32.543255f, 38.91053f);
                instancePath.cubicTo(30.983482f, 42.951958f, 26.839252f, 43.55849f, 25.701117f, 43.56f);
                instancePath.cubicTo(22.412323f, 43.56436f, 19.888964f, 42.783474f, 18.553532f, 39.851376f);
                instancePath.cubicTo(17.218098f, 36.919273f, 18.215815f, 32.360634f, 15.758889f, 29.729475f);
                instancePath.cubicTo(13.237251f, 27.029016f, 8.037645f, 21.490482f, 10.584166f, 13.047938f);
                instancePath.cubicTo(11.66031f, 9.480171f, 15.53567f, 3.96f, 25.701117f, 3.96f);
                instancePath.cubicTo(34.384438f, 3.96f, 39.990982f, 9.797077f, 38.33459f, 16.339989f);
                instancePath.cubicTo(36.44469f, 23.802822f, 28.639595f, 22.510462f, 28.639595f, 22.510462f);
                instancePath.lineTo(29.06654f, 19.93197f);
                instancePath.cubicTo(29.071892f, 19.932856f, 29.132612f, 19.940847f, 29.24069f, 19.950937f);
                instancePath.cubicTo(30.31777f, 20.051474f, 31.586508f, 19.943724f, 32.71822f, 19.48973f);
                instancePath.cubicTo(34.239017f, 18.879654f, 35.284702f, 17.737019f, 35.800922f, 15.698569f);
                instancePath.cubicTo(37.019463f, 10.88521f, 32.70242f, 6.5736f, 25.701117f, 6.5736f);
                instancePath.cubicTo(18.357351f, 6.5736f, 14.33335f, 9.668696f, 13.086415f, 13.8026905f);
                instancePath.cubicTo(11.744799f, 18.250586f, 12.775491f, 21.91427f, 15.531816f, 25.489357f);
                instancePath.cubicTo(16.142097f, 26.280924f, 16.645678f, 26.84966f, 17.66915f, 27.945711f);
                instancePath.cubicTo(19.303974f, 29.69647f, 19.86245f, 31.586874f, 20.228584f, 34.85312f);
                instancePath.cubicTo(20.24756f, 35.022392f, 20.262926f, 35.16381f, 20.29538f, 35.46539f);
                instancePath.cubicTo(20.49886f, 37.35431f, 20.640348f, 38.1276f, 20.93205f, 38.76807f);
                instancePath.cubicTo(21.661112f, 40.368813f, 22.913269f, 40.950096f, 25.697649f, 40.946404f);
                instancePath.cubicTo(27.312399f, 40.94426f, 29.329237f, 39.97938f, 30.10495f, 37.96948f);
                instancePath.cubicTo(30.934326f, 35.820534f, 30.563622f, 31.709312f, 29.090963f, 30.165781f);
                instancePath.cubicTo(28.590775f, 29.641521f, 28.041868f, 29.193403f, 27.410362f, 28.779465f);
                instancePath.cubicTo(26.99209f, 28.505295f, 26.542843f, 28.248503f, 25.990253f, 27.961823f);
                instancePath.cubicTo(25.672832f, 27.797148f, 24.573006f, 27.250767f, 24.447107f, 27.186813f);
                instancePath.cubicTo(21.124224f, 25.49888f, 19.526281f, 23.698557f, 19.353756f, 20.138744f);
                instancePath.cubicTo(19.178171f, 16.488176f, 21.279713f, 14.188888f, 24.426254f, 13.365055f);
                instancePath.cubicTo(25.706848f, 13.029768f, 26.988028f, 12.96564f, 28.147823f, 13.047379f);
                instancePath.cubicTo(28.317234f, 13.059318f, 28.449696f, 13.072415f, 28.54019f, 13.08362f);
                instancePath.lineTo(28.219015f, 15.677411f);
                instancePath.cubicTo(28.219015f, 15.677411f, 21.717073f, 14.8723135f, 21.964338f, 20.013182f);
                instancePath.close();
                instancePath.moveTo(21.964338f, 20.013182f);
                instancePath.cubicTo(22.212938f, 25.142698f, 27.100338f, 24.293186f, 30.98196f, 28.36161f);
                instancePath.cubicTo(33.576435f, 31.080942f, 33.458485f, 36.539135f, 32.543255f, 38.91053f);
                instancePath.cubicTo(30.983482f, 42.951958f, 26.839252f, 43.55849f, 25.701117f, 43.56f);
                instancePath.cubicTo(22.412323f, 43.56436f, 19.888964f, 42.783474f, 18.553532f, 39.851376f);
                instancePath.cubicTo(17.218098f, 36.919273f, 18.215815f, 32.360634f, 15.758889f, 29.729475f);
                instancePath.cubicTo(13.237251f, 27.029016f, 8.037645f, 21.490482f, 10.584166f, 13.047938f);
                instancePath.cubicTo(11.66031f, 9.480171f, 15.53567f, 3.96f, 25.701117f, 3.96f);
                instancePath.cubicTo(34.384438f, 3.96f, 39.990982f, 9.797077f, 38.33459f, 16.339989f);
                instancePath.cubicTo(36.44469f, 23.802822f, 28.639595f, 22.510462f, 28.639595f, 22.510462f);
                instancePath.lineTo(29.06654f, 19.93197f);
                instancePath.cubicTo(29.071892f, 19.932856f, 29.132612f, 19.940847f, 29.24069f, 19.950937f);
                instancePath.cubicTo(30.31777f, 20.051474f, 31.586508f, 19.943724f, 32.71822f, 19.48973f);
                instancePath.cubicTo(34.239017f, 18.879654f, 35.284702f, 17.737019f, 35.800922f, 15.698569f);
                instancePath.cubicTo(37.019463f, 10.88521f, 32.70242f, 6.5736f, 25.701117f, 6.5736f);
                instancePath.cubicTo(18.357351f, 6.5736f, 14.33335f, 9.668696f, 13.086415f, 13.8026905f);
                instancePath.cubicTo(11.744799f, 18.250586f, 12.775491f, 21.91427f, 15.531816f, 25.489357f);
                instancePath.cubicTo(16.142097f, 26.280924f, 16.645678f, 26.84966f, 17.66915f, 27.945711f);
                instancePath.cubicTo(19.303974f, 29.69647f, 19.86245f, 31.586874f, 20.228584f, 34.85312f);
                instancePath.cubicTo(20.24756f, 35.022392f, 20.262926f, 35.16381f, 20.29538f, 35.46539f);
                instancePath.cubicTo(20.49886f, 37.35431f, 20.640348f, 38.1276f, 20.93205f, 38.76807f);
                instancePath.cubicTo(21.661112f, 40.368813f, 22.913269f, 40.950096f, 25.697649f, 40.946404f);
                instancePath.cubicTo(27.312399f, 40.94426f, 29.329237f, 39.97938f, 30.10495f, 37.96948f);
                instancePath.cubicTo(30.934326f, 35.820534f, 30.563622f, 31.709312f, 29.090963f, 30.165781f);
                instancePath.cubicTo(28.590775f, 29.641521f, 28.041868f, 29.193403f, 27.410362f, 28.779465f);
                instancePath.cubicTo(26.99209f, 28.505295f, 26.542843f, 28.248503f, 25.990253f, 27.961823f);
                instancePath.cubicTo(25.672832f, 27.797148f, 24.573006f, 27.250767f, 24.447107f, 27.186813f);
                instancePath.cubicTo(21.124224f, 25.49888f, 19.526281f, 23.698557f, 19.353756f, 20.138744f);
                instancePath.cubicTo(19.178171f, 16.488176f, 21.279713f, 14.188888f, 24.426254f, 13.365055f);
                instancePath.cubicTo(25.706848f, 13.029768f, 26.988028f, 12.96564f, 28.147823f, 13.047379f);
                instancePath.cubicTo(28.317234f, 13.059318f, 28.449696f, 13.072415f, 28.54019f, 13.08362f);
                instancePath.lineTo(28.219015f, 15.677411f);
                instancePath.cubicTo(28.219015f, 15.677411f, 21.717073f, 14.8723135f, 21.964338f, 20.013182f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
