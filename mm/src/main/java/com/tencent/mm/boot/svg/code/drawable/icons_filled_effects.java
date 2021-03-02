package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_effects extends c {
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
                instancePath.moveTo(12.0f, 2.0f);
                instancePath.cubicTo(17.522848f, 2.0f, 22.0f, 6.4771523f, 22.0f, 12.0f);
                instancePath.cubicTo(22.0f, 17.522848f, 17.522848f, 22.0f, 12.0f, 22.0f);
                instancePath.cubicTo(6.4771523f, 22.0f, 2.0f, 17.522848f, 2.0f, 12.0f);
                instancePath.cubicTo(2.0f, 6.4771523f, 6.4771523f, 2.0f, 12.0f, 2.0f);
                instancePath.close();
                instancePath.moveTo(12.0f, 13.0f);
                instancePath.cubicTo(10.438151f, 13.0f, 8.95667f, 13.126555f, 7.5555553f, 13.379665f);
                instancePath.cubicTo(7.5555553f, 15.834265f, 9.545402f, 17.82411f, 12.0f, 17.82411f);
                instancePath.cubicTo(14.454598f, 17.82411f, 16.444445f, 15.834265f, 16.444445f, 13.379665f);
                instancePath.cubicTo(15.04333f, 13.126555f, 13.561849f, 13.0f, 12.0f, 13.0f);
                instancePath.close();
                instancePath.moveTo(20.053873f, 7.3000984f);
                instancePath.cubicTo(17.981472f, 6.782615f, 15.611561f, 6.878015f, 12.944138f, 7.586297f);
                instancePath.cubicTo(12.75793f, 7.6162815f, 12.443216f, 7.6327014f, 12.0f, 7.635557f);
                instancePath.lineTo(12.0f, 7.635557f);
                instancePath.lineTo(11.817918f, 7.633503f);
                instancePath.cubicTo(11.469488f, 7.627733f, 11.215469f, 7.611998f, 11.055862f, 7.586297f);
                instancePath.cubicTo(8.388439f, 6.878015f, 6.018527f, 6.782615f, 3.9455726f, 7.3002367f);
                instancePath.cubicTo(3.4098244f, 7.434339f, 3.0842261f, 7.9773607f, 3.2183285f, 8.513109f);
                instancePath.lineTo(3.2183285f, 8.513109f);
                instancePath.lineTo(3.2966852f, 8.81923f);
                instancePath.cubicTo(3.7413049f, 10.516429f, 4.194755f, 11.576686f, 4.657037f, 12.0f);
                instancePath.cubicTo(5.5404186f, 12.808919f, 6.4147406f, 13.103516f, 8.34413f, 12.551758f);
                instancePath.cubicTo(9.630389f, 12.183919f, 10.5343f, 11.311744f, 11.055862f, 9.93523f);
                instancePath.lineTo(11.055862f, 9.93523f);
                instancePath.lineTo(12.944138f, 9.93523f);
                instancePath.lineTo(13.040147f, 10.172909f);
                instancePath.cubicTo(13.573365f, 11.412607f, 14.445273f, 12.205557f, 15.65587f, 12.551758f);
                instancePath.cubicTo(17.585258f, 13.103516f, 18.459581f, 12.808919f, 19.342964f, 12.0f);
                instancePath.cubicTo(19.805244f, 11.576686f, 20.258696f, 10.516429f, 20.703314f, 8.81923f);
                instancePath.lineTo(20.703314f, 8.81923f);
                instancePath.lineTo(20.781672f, 8.513109f);
                instancePath.lineTo(20.803463f, 8.398346f);
                instancePath.cubicTo(20.868187f, 7.901872f, 20.551888f, 7.4247556f, 20.05415f, 7.3001676f);
                instancePath.lineTo(20.05415f, 7.3001676f);
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
