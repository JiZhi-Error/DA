package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_icons_filled_link_mic extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(5.538269f, 3.0f);
                instancePath.cubicTo(6.0009494f, 3.0154243f, 6.3865166f, 3.2776349f, 6.556166f, 3.6786633f);
                instancePath.lineTo(6.556166f, 3.6786633f);
                instancePath.lineTo(7.867094f, 7.1645246f);
                instancePath.cubicTo(7.928785f, 7.3341904f, 7.8979397f, 7.4267354f, 7.8054037f, 7.596401f);
                instancePath.cubicTo(7.4969497f, 8.136247f, 6.756661f, 9.493573f, 6.3402486f, 10.311054f);
                instancePath.cubicTo(6.23229f, 10.511568f, 6.170599f, 10.74293f, 6.170599f, 10.974293f);
                instancePath.cubicTo(6.170599f, 11.22108f, 6.2477126f, 11.467866f, 6.3710938f, 11.668381f);
                instancePath.cubicTo(7.0342693f, 12.794345f, 7.8054037f, 13.858612f, 8.715342f, 14.768638f);
                instancePath.cubicTo(9.62528f, 15.694087f, 10.6894455f, 16.465296f, 11.815302f, 17.128534f);
                instancePath.cubicTo(12.015797f, 17.251928f, 12.247137f, 17.329048f, 12.509322f, 17.329048f);
                instancePath.cubicTo(12.756085f, 17.329048f, 12.972003f, 17.267353f, 13.172498f, 17.159384f);
                instancePath.cubicTo(13.974478f, 16.742931f, 15.331674f, 16.002571f, 15.88689f, 15.694087f);
                instancePath.cubicTo(16.05654f, 15.601542f, 16.133654f, 15.570694f, 16.318726f, 15.632391f);
                instancePath.lineTo(16.318726f, 15.632391f);
                instancePath.lineTo(19.804253f, 16.943445f);
                instancePath.cubicTo(20.205242f, 17.11311f, 20.467428f, 17.498714f, 20.498274f, 17.96144f);
                instancePath.cubicTo(20.513695f, 18.14653f, 20.42116f, 18.362469f, 20.405737f, 18.408741f);
                instancePath.cubicTo(19.850521f, 19.92031f, 18.41621f, 21.0f, 16.719715f, 21.0f);
                instancePath.cubicTo(16.241611f, 21.0f, 15.794354f, 20.89203f, 15.686396f, 20.861183f);
                instancePath.cubicTo(12.447632f, 20.120823f, 9.56359f, 18.470436f, 7.296455f, 16.203085f);
                instancePath.cubicTo(5.0293202f, 13.935733f, 3.379093f, 11.051414f, 2.6388042f, 7.8123393f);
                instancePath.cubicTo(2.6233814f, 7.70437f, 2.5f, 7.2570696f, 2.5f, 6.77892f);
                instancePath.cubicTo(2.5f, 5.082262f, 3.579588f, 3.647815f, 5.091011f, 3.092545f);
                instancePath.cubicTo(5.137279f, 3.0771208f, 5.3531966f, 3.0f, 5.538269f, 3.0f);
                instancePath.close();
                instancePath.moveTo(18.166666f, 4.5f);
                instancePath.cubicTo(18.429659f, 4.5f, 18.642857f, 4.706638f, 18.642857f, 4.9615383f);
                instancePath.lineTo(18.642857f, 10.038462f);
                instancePath.cubicTo(18.642857f, 10.293363f, 18.429659f, 10.5f, 18.166666f, 10.5f);
                instancePath.lineTo(11.976191f, 10.5f);
                instancePath.cubicTo(11.713198f, 10.5f, 11.5f, 10.293363f, 11.5f, 10.038462f);
                instancePath.lineTo(11.5f, 4.9615383f);
                instancePath.cubicTo(11.5f, 4.706638f, 11.713198f, 4.5f, 11.976191f, 4.5f);
                instancePath.lineTo(18.166666f, 4.5f);
                instancePath.close();
                instancePath.moveTo(21.39565f, 5.4027367f);
                instancePath.cubicTo(21.4632f, 5.484574f, 21.5f, 5.5862556f, 21.5f, 5.6910577f);
                instancePath.lineTo(21.5f, 9.308943f);
                instancePath.cubicTo(21.5f, 9.563843f, 21.286802f, 9.770481f, 21.02381f, 9.770481f);
                instancePath.cubicTo(20.91568f, 9.770481f, 20.81077f, 9.734813f, 20.726336f, 9.669343f);
                instancePath.lineTo(19.119047f, 8.423077f);
                instancePath.lineTo(19.119047f, 6.576923f);
                instancePath.lineTo(20.726336f, 5.3306565f);
                instancePath.cubicTo(20.931698f, 5.1714215f, 21.231361f, 5.203693f, 21.39565f, 5.4027367f);
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
