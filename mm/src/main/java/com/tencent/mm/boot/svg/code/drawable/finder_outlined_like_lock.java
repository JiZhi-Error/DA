package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_outlined_like_lock extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                instancePaint3.setColor(-436207616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(22.13f, 15.5f);
                instancePath.cubicTo(24.186853f, 15.5f, 25.33f, 17.132689f, 25.33f, 18.9f);
                instancePath.lineTo(25.33f, 19.2f);
                instancePath.lineTo(26.134602f, 19.2f);
                instancePath.cubicTo(26.684345f, 19.2f, 27.13f, 19.646698f, 27.13f, 20.195942f);
                instancePath.lineTo(27.13f, 25.704058f);
                instancePath.cubicTo(27.13f, 26.2541f, 26.674335f, 26.7f, 26.134602f, 26.7f);
                instancePath.lineTo(18.125397f, 26.7f);
                instancePath.cubicTo(17.575655f, 26.7f, 17.13f, 26.253302f, 17.13f, 25.704058f);
                instancePath.lineTo(17.13f, 20.195942f);
                instancePath.cubicTo(17.13f, 19.645899f, 17.585665f, 19.2f, 18.125397f, 19.2f);
                instancePath.lineTo(18.93f, 19.2f);
                instancePath.lineTo(18.93f, 18.9f);
                instancePath.cubicTo(18.93f, 17.132689f, 20.073147f, 15.5f, 22.13f, 15.5f);
                instancePath.close();
                instancePath.moveTo(25.229786f, 8.417326f);
                instancePath.cubicTo(23.25113f, 6.438669f, 20.043095f, 6.438669f, 18.064438f, 8.417326f);
                instancePath.cubicTo(17.808084f, 8.673678f, 17.482922f, 8.987333f, 17.087465f, 9.359927f);
                instancePath.lineTo(15.990258f, 10.393701f);
                instancePath.lineTo(14.893051f, 9.359927f);
                instancePath.cubicTo(14.497594f, 8.987333f, 14.172431f, 8.673678f, 13.916078f, 8.417326f);
                instancePath.cubicTo(11.937422f, 6.438669f, 8.729385f, 6.438669f, 6.750729f, 8.417326f);
                instancePath.cubicTo(4.792696f, 10.375359f, 4.7700906f, 13.542494f, 6.678211f, 15.510157f);
                instancePath.lineTo(15.990201f, 24.822243f);
                instancePath.lineTo(15.999667f, 24.811333f);
                instancePath.lineTo(16.000315f, 26.532671f);
                instancePath.cubicTo(15.655747f, 26.535267f, 15.310365f, 26.405123f, 15.047449f, 26.142235f);
                instancePath.lineTo(5.5468345f, 16.641521f);
                instancePath.cubicTo(3.0160885f, 14.032161f, 3.0400808f, 9.865232f, 5.6193585f, 7.285955f);
                instancePath.cubicTo(8.222854f, 4.6824594f, 12.4439535f, 4.6824594f, 15.047449f, 7.285955f);
                instancePath.cubicTo(15.291191f, 7.529697f, 15.605461f, 7.8328433f, 15.990258f, 8.1953945f);
                instancePath.cubicTo(16.375055f, 7.8328433f, 16.689325f, 7.529697f, 16.933067f, 7.285955f);
                instancePath.cubicTo(19.536562f, 4.6824594f, 23.757662f, 4.6824594f, 26.361156f, 7.285955f);
                instancePath.cubicTo(28.940435f, 9.865232f, 28.964428f, 14.032161f, 26.433134f, 16.640974f);
                instancePath.lineTo(26.236086f, 16.838179f);
                instancePath.cubicTo(25.996979f, 16.32339f, 25.695147f, 15.859748f, 25.343662f, 15.463596f);
                instancePath.lineTo(25.284832f, 15.5267935f);
                instancePath.cubicTo(27.210321f, 13.5423355f, 27.187843f, 10.375382f, 25.229786f, 8.417326f);
                instancePath.close();
                instancePath.moveTo(25.63f, 20.7f);
                instancePath.lineTo(18.63f, 20.7f);
                instancePath.lineTo(18.63f, 25.2f);
                instancePath.lineTo(25.63f, 25.2f);
                instancePath.lineTo(25.63f, 20.7f);
                instancePath.close();
                instancePath.moveTo(22.13f, 17.0f);
                instancePath.cubicTo(20.91f, 17.0f, 20.53f, 18.178738f, 20.53f, 18.9f);
                instancePath.lineTo(20.53f, 19.2f);
                instancePath.lineTo(23.63f, 19.2f);
                instancePath.lineTo(23.63f, 18.9f);
                instancePath.cubicTo(23.63f, 18.178738f, 23.35f, 17.0f, 22.13f, 17.0f);
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
