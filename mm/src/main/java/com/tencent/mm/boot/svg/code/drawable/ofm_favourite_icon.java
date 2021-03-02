package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ofm_favourite_icon extends c {
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
                instancePath.moveTo(44.10407f, 48.572086f);
                instancePath.lineTo(20.999926f, 35.23115f);
                instancePath.cubicTo(19.958965f, 34.62973f, 19.004f, 35.25858f, 19.0f, 36.462433f);
                instancePath.lineTo(19.004f, 62.93198f);
                instancePath.cubicTo(19.0f, 64.13482f, 19.846968f, 65.615f, 20.88693f, 66.21947f);
                instancePath.lineTo(44.10907f, 79.74022f);
                instancePath.cubicTo(45.149033f, 80.345695f, 46.0f, 79.85603f, 46.0f, 78.65319f);
                instancePath.lineTo(46.0f, 51.85246f);
                instancePath.cubicTo(45.999f, 50.648605f, 45.14603f, 49.17249f, 44.10407f, 48.572086f);
                instancePath.close();
                instancePath.moveTo(73.216934f, 29.458399f);
                instancePath.lineTo(50.073246f, 16.4451f);
                instancePath.cubicTo(49.02697f, 15.856779f, 47.311195f, 15.850846f, 46.259857f, 16.432247f);
                instancePath.lineTo(22.789015f, 29.413904f);
                instancePath.cubicTo(21.738686f, 29.994316f, 21.73666f, 30.948486f, 22.784964f, 31.533842f);
                instancePath.lineTo(46.14338f, 44.56098f);
                instancePath.cubicTo(47.19168f, 45.14634f, 48.90745f, 45.14634f, 49.956768f, 44.56098f);
                instancePath.lineTo(73.21288f, 31.591192f);
                instancePath.cubicTo(74.261185f, 31.006824f, 74.2622f, 30.046722f, 73.216934f, 29.458399f);
                instancePath.close();
                instancePath.moveTo(76.997f, 36.350918f);
                instancePath.cubicTo(77.001f, 35.14774f, 76.151f, 34.6553f, 75.11f, 35.256382f);
                instancePath.lineTo(51.895f, 48.66497f);
                instancePath.cubicTo(50.853f, 49.267067f, 50.0f, 50.74337f, 50.0f, 51.94655f);
                instancePath.lineTo(50.0f, 78.64493f);
                instancePath.cubicTo(50.0f, 79.84912f, 50.854f, 80.34461f, 51.898f, 79.74556f);
                instancePath.lineTo(74.994f, 66.51567f);
                instancePath.cubicTo(76.037f, 65.91763f, 76.996f, 64.287f, 77.0f, 63.082806f);
                instancePath.lineTo(76.997f, 36.350918f);
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
