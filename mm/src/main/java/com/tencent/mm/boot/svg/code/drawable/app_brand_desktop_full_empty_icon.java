package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_desktop_full_empty_icon extends c {
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
                canvas.saveLayerAlpha(null, 230, 31);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(49.0f, 9.0f);
                instancePath.cubicTo(45.693f, 9.0f, 42.614f, 9.879f, 40.0f, 11.374f);
                instancePath.cubicTo(35.205f, 14.118f, 32.0f, 18.968f, 32.0f, 24.5f);
                instancePath.lineTo(32.0f, 47.5f);
                instancePath.cubicTo(32.0f, 51.642f, 27.97f, 55.0f, 23.0f, 55.0f);
                instancePath.cubicTo(18.029f, 55.0f, 14.0f, 51.642f, 14.0f, 47.5f);
                instancePath.cubicTo(14.0f, 44.552f, 16.046f, 42.009f, 19.015f, 40.783f);
                instancePath.cubicTo(19.229f, 40.695f, 19.446f, 40.611f, 19.669f, 40.537f);
                instancePath.cubicTo(21.538f, 39.787f, 23.141f, 38.379f, 23.736f, 36.744f);
                instancePath.cubicTo(24.615f, 34.33f, 22.979f, 32.374f, 20.083f, 32.374f);
                instancePath.cubicTo(19.361f, 32.374f, 18.629f, 32.496f, 17.923f, 32.716f);
                instancePath.cubicTo(17.92f, 32.717f, 17.917f, 32.718f, 17.913f, 32.719f);
                instancePath.cubicTo(13.726f, 33.921f, 10.231f, 36.557f, 8.133f, 40.0f);
                instancePath.cubicTo(6.778f, 42.225f, 6.0f, 44.78f, 6.0f, 47.5f);
                instancePath.cubicTo(6.0f, 56.047f, 13.626f, 63.0f, 23.0f, 63.0f);
                instancePath.cubicTo(26.307f, 63.0f, 29.386f, 62.121f, 32.0f, 60.626f);
                instancePath.cubicTo(36.795f, 57.882f, 40.0f, 53.032f, 40.0f, 47.5f);
                instancePath.lineTo(40.0f, 24.5f);
                instancePath.cubicTo(40.0f, 20.358f, 44.029f, 17.0f, 49.0f, 17.0f);
                instancePath.cubicTo(53.97f, 17.0f, 58.0f, 20.358f, 58.0f, 24.5f);
                instancePath.cubicTo(58.0f, 27.574f, 55.781f, 30.216f, 52.604f, 31.374f);
                instancePath.cubicTo(50.555f, 32.061f, 48.876f, 33.544f, 48.236f, 35.301f);
                instancePath.cubicTo(47.362f, 37.703f, 48.99f, 39.651f, 51.873f, 39.651f);
                instancePath.cubicTo(52.526f, 39.651f, 53.186f, 39.539f, 53.829f, 39.357f);
                instancePath.cubicTo(53.934f, 39.328f, 54.038f, 39.296f, 54.142f, 39.265f);
                instancePath.cubicTo(58.304f, 38.056f, 61.778f, 35.428f, 63.866f, 32.0f);
                instancePath.cubicTo(65.222f, 29.776f, 66.0f, 27.22f, 66.0f, 24.5f);
                instancePath.cubicTo(66.0f, 15.953f, 58.374f, 9.0f, 49.0f, 9.0f);
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
