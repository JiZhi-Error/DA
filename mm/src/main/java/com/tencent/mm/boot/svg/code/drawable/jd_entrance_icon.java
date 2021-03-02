package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class jd_entrance_icon extends c {
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
                instancePaint3.setColor(-499359);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(79.03704f, 25.0f);
                instancePath.lineTo(29.962963f, 25.0f);
                instancePath.cubicTo(28.879408f, 25.0f, 28.0f, 25.881067f, 28.0f, 26.966667f);
                instancePath.lineTo(28.0f, 82.03333f);
                instancePath.cubicTo(28.0f, 83.118935f, 28.879408f, 84.0f, 29.962963f, 84.0f);
                instancePath.lineTo(79.03704f, 84.0f);
                instancePath.cubicTo(80.12059f, 84.0f, 81.0f, 83.118935f, 81.0f, 82.03333f);
                instancePath.lineTo(81.0f, 26.966667f);
                instancePath.cubicTo(81.0f, 25.880083f, 80.12059f, 25.0f, 79.03704f, 25.0f);
                instancePath.lineTo(79.03704f, 25.0f);
                instancePath.close();
                instancePath.moveTo(69.22222f, 40.388184f);
                instancePath.lineTo(69.22222f, 52.533333f);
                instancePath.cubicTo(69.22222f, 60.679268f, 62.630592f, 67.28333f, 54.5f, 67.28333f);
                instancePath.cubicTo(46.369408f, 67.28333f, 39.77778f, 60.679268f, 39.77778f, 52.533333f);
                instancePath.lineTo(39.77778f, 40.388184f);
                instancePath.cubicTo(38.61963f, 39.83555f, 37.814816f, 38.66145f, 37.814816f, 37.291668f);
                instancePath.cubicTo(37.814816f, 35.3899f, 39.352795f, 33.85f, 41.25f, 33.85f);
                instancePath.cubicTo(43.147205f, 33.85f, 44.685184f, 35.3899f, 44.685184f, 37.291668f);
                instancePath.cubicTo(44.685184f, 38.662434f, 43.88037f, 39.83555f, 42.72222f, 40.388184f);
                instancePath.lineTo(42.72222f, 52.533333f);
                instancePath.cubicTo(42.72222f, 59.049885f, 47.99474f, 64.333336f, 54.5f, 64.333336f);
                instancePath.cubicTo(61.004276f, 64.333336f, 66.27778f, 59.049885f, 66.27778f, 52.533333f);
                instancePath.lineTo(66.27778f, 40.388184f);
                instancePath.cubicTo(65.11963f, 39.83555f, 64.31481f, 38.66145f, 64.31481f, 37.291668f);
                instancePath.cubicTo(64.31481f, 35.3899f, 65.8528f, 33.85f, 67.75f, 33.85f);
                instancePath.cubicTo(69.6472f, 33.85f, 71.18519f, 35.3899f, 71.18519f, 37.291668f);
                instancePath.cubicTo(71.18519f, 38.66145f, 70.37939f, 39.83555f, 69.22222f, 40.388184f);
                instancePath.lineTo(69.22222f, 40.388184f);
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
