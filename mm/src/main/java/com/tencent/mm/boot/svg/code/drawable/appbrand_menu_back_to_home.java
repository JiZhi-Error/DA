package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class appbrand_menu_back_to_home extends c {
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
                instancePaint3.setColor(-15683841);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(37.97733f, 10.986356f);
                instancePath.lineTo(38.12132f, 11.121321f);
                instancePath.lineTo(63.878685f, 36.8787f);
                instancePath.cubicTo(64.44129f, 37.441307f, 64.75736f, 38.20437f, 64.75736f, 39.00002f);
                instancePath.cubicTo(64.75736f, 40.5977f, 63.508442f, 41.90368f, 61.933636f, 41.994926f);
                instancePath.lineTo(61.757362f, 42.00002f);
                instancePath.lineTo(53.999638f, 41.99964f);
                instancePath.lineTo(54.0f, 60.0f);
                instancePath.cubicTo(54.0f, 61.59768f, 52.75108f, 62.90366f, 51.176273f, 62.994907f);
                instancePath.lineTo(51.0f, 63.0f);
                instancePath.lineTo(40.5f, 63.0f);
                instancePath.lineTo(40.5f, 51.0f);
                instancePath.lineTo(31.5f, 51.0f);
                instancePath.lineTo(31.5f, 63.0f);
                instancePath.lineTo(21.0f, 63.0f);
                instancePath.cubicTo(19.402319f, 63.0f, 18.096338f, 61.75108f, 18.005093f, 60.176273f);
                instancePath.lineTo(18.0f, 60.0f);
                instancePath.lineTo(17.999638f, 41.99964f);
                instancePath.lineTo(10.242638f, 42.00002f);
                instancePath.cubicTo(9.513292f, 42.00002f, 8.811331f, 41.734432f, 8.266049f, 41.256817f);
                instancePath.lineTo(8.121318f, 41.121338f);
                instancePath.cubicTo(6.996608f, 39.99663f, 6.9516187f, 38.20107f, 7.9863515f, 37.02269f);
                instancePath.lineTo(8.121317f, 36.8787f);
                instancePath.lineTo(33.87868f, 11.121321f);
                instancePath.lineTo(34.02267f, 10.986354f);
                instancePath.cubicTo(35.15195f, 9.994735f, 36.848053f, 9.994735f, 37.97733f, 10.986356f);
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
