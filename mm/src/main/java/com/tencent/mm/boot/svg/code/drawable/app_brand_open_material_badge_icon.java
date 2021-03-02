package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_open_material_badge_icon extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePath.moveTo(61.0f, 21.0f);
                instancePath.cubicTo(57.693f, 21.0f, 54.614f, 21.879f, 52.0f, 23.374f);
                instancePath.cubicTo(47.205f, 26.118f, 44.0f, 30.968f, 44.0f, 36.5f);
                instancePath.lineTo(44.0f, 59.5f);
                instancePath.cubicTo(44.0f, 63.642f, 39.97f, 67.0f, 35.0f, 67.0f);
                instancePath.cubicTo(30.029f, 67.0f, 26.0f, 63.642f, 26.0f, 59.5f);
                instancePath.cubicTo(26.0f, 56.552f, 28.046f, 54.009f, 31.015f, 52.783f);
                instancePath.cubicTo(31.229f, 52.695f, 31.446f, 52.611f, 31.669f, 52.537f);
                instancePath.cubicTo(33.538f, 51.787f, 35.141f, 50.379f, 35.736f, 48.744f);
                instancePath.cubicTo(36.615f, 46.33f, 34.979f, 44.374f, 32.083f, 44.374f);
                instancePath.cubicTo(31.361f, 44.374f, 30.629f, 44.496f, 29.923f, 44.716f);
                instancePath.cubicTo(29.92f, 44.717f, 29.917f, 44.718f, 29.913f, 44.719f);
                instancePath.cubicTo(25.726f, 45.921f, 22.231f, 48.557f, 20.133f, 52.0f);
                instancePath.cubicTo(18.778f, 54.225f, 18.0f, 56.78f, 18.0f, 59.5f);
                instancePath.cubicTo(18.0f, 68.047f, 25.626f, 75.0f, 35.0f, 75.0f);
                instancePath.cubicTo(38.307f, 75.0f, 41.386f, 74.121f, 44.0f, 72.626f);
                instancePath.cubicTo(48.795f, 69.882f, 52.0f, 65.032f, 52.0f, 59.5f);
                instancePath.lineTo(52.0f, 36.5f);
                instancePath.cubicTo(52.0f, 32.358f, 56.029f, 29.0f, 61.0f, 29.0f);
                instancePath.cubicTo(65.97f, 29.0f, 70.0f, 32.358f, 70.0f, 36.5f);
                instancePath.cubicTo(70.0f, 39.574f, 67.781f, 42.216f, 64.604f, 43.374f);
                instancePath.cubicTo(62.555f, 44.061f, 60.876f, 45.544f, 60.236f, 47.301f);
                instancePath.cubicTo(59.362f, 49.703f, 60.99f, 51.651f, 63.873f, 51.651f);
                instancePath.cubicTo(64.526f, 51.651f, 65.186f, 51.539f, 65.829f, 51.357f);
                instancePath.cubicTo(65.934f, 51.328f, 66.038f, 51.296f, 66.142f, 51.265f);
                instancePath.cubicTo(70.304f, 50.056f, 73.778f, 47.428f, 75.866f, 44.0f);
                instancePath.cubicTo(77.222f, 41.776f, 78.0f, 39.22f, 78.0f, 36.5f);
                instancePath.cubicTo(78.0f, 27.953f, 70.374f, 21.0f, 61.0f, 21.0f);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
