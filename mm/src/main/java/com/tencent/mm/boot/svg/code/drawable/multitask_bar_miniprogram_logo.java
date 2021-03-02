package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class multitask_bar_miniprogram_logo extends c {
    private final int height = 54;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 54;
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
                instancePaint3.setColor(-8421505);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(43.0f, 0.0f);
                instancePath.cubicTo(39.693f, 0.0f, 36.614f, 0.879f, 34.0f, 2.374f);
                instancePath.cubicTo(29.205f, 5.118f, 26.0f, 9.968f, 26.0f, 15.5f);
                instancePath.lineTo(26.0f, 38.5f);
                instancePath.cubicTo(26.0f, 42.642f, 21.97f, 46.0f, 17.0f, 46.0f);
                instancePath.cubicTo(12.029f, 46.0f, 8.0f, 42.642f, 8.0f, 38.5f);
                instancePath.cubicTo(8.0f, 35.552f, 10.046f, 33.009f, 13.015f, 31.783f);
                instancePath.cubicTo(13.229f, 31.695f, 13.446f, 31.611f, 13.669f, 31.537f);
                instancePath.cubicTo(15.538f, 30.787f, 17.141f, 29.379f, 17.736f, 27.744f);
                instancePath.cubicTo(18.615f, 25.33f, 16.979f, 23.374f, 14.083f, 23.374f);
                instancePath.cubicTo(13.361f, 23.374f, 12.629f, 23.496f, 11.923f, 23.716f);
                instancePath.cubicTo(11.92f, 23.717f, 11.917f, 23.718f, 11.913f, 23.719f);
                instancePath.cubicTo(7.726f, 24.921f, 4.231f, 27.557f, 2.133f, 31.0f);
                instancePath.cubicTo(0.778f, 33.225f, 0.0f, 35.78f, 0.0f, 38.5f);
                instancePath.cubicTo(0.0f, 47.047f, 7.626f, 54.0f, 17.0f, 54.0f);
                instancePath.cubicTo(20.307f, 54.0f, 23.386f, 53.121f, 26.0f, 51.626f);
                instancePath.cubicTo(30.795f, 48.882f, 34.0f, 44.032f, 34.0f, 38.5f);
                instancePath.lineTo(34.0f, 15.5f);
                instancePath.cubicTo(34.0f, 11.358f, 38.029f, 8.0f, 43.0f, 8.0f);
                instancePath.cubicTo(47.97f, 8.0f, 52.0f, 11.358f, 52.0f, 15.5f);
                instancePath.cubicTo(52.0f, 18.574f, 49.781f, 21.216f, 46.604f, 22.374f);
                instancePath.cubicTo(44.555f, 23.061f, 42.876f, 24.544f, 42.236f, 26.301f);
                instancePath.cubicTo(41.362f, 28.703f, 42.99f, 30.651f, 45.873f, 30.651f);
                instancePath.cubicTo(46.526f, 30.651f, 47.186f, 30.539f, 47.829f, 30.357f);
                instancePath.cubicTo(47.934f, 30.328f, 48.038f, 30.296f, 48.142f, 30.265f);
                instancePath.cubicTo(52.304f, 29.056f, 55.778f, 26.428f, 57.866f, 23.0f);
                instancePath.cubicTo(59.222f, 20.776f, 60.0f, 18.22f, 60.0f, 15.5f);
                instancePath.cubicTo(60.0f, 6.953f, 52.374f, 0.0f, 43.0f, 0.0f);
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
