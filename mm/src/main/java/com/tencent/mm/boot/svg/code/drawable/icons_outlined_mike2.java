package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_mike2 extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.0f, 62.4f);
                instancePath.cubicTo(50.58032f, 62.4f, 62.4f, 50.58032f, 62.4f, 36.0f);
                instancePath.cubicTo(62.4f, 21.419683f, 50.58032f, 9.6f, 36.0f, 9.6f);
                instancePath.cubicTo(21.419683f, 9.6f, 9.6f, 21.419683f, 9.6f, 36.0f);
                instancePath.cubicTo(9.6f, 50.58032f, 21.419683f, 62.4f, 36.0f, 62.4f);
                instancePath.close();
                instancePath.moveTo(36.0f, 66.0f);
                instancePath.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                instancePath.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 23.1f);
                instancePath.cubicTo(33.84609f, 23.1f, 32.1f, 24.84609f, 32.1f, 27.0f);
                instancePath.lineTo(32.1f, 37.5f);
                instancePath.cubicTo(32.1f, 39.65391f, 33.84609f, 41.4f, 36.0f, 41.4f);
                instancePath.cubicTo(38.15391f, 41.4f, 39.9f, 39.65391f, 39.9f, 37.5f);
                instancePath.lineTo(39.9f, 27.0f);
                instancePath.cubicTo(39.9f, 24.84609f, 38.15391f, 23.1f, 36.0f, 23.1f);
                instancePath.close();
                instancePath.moveTo(37.80007f, 50.881016f);
                instancePath.lineTo(37.80007f, 55.5f);
                instancePath.lineTo(34.200073f, 55.5f);
                instancePath.lineTo(34.200073f, 50.88102f);
                instancePath.cubicTo(27.59519f, 50.00077f, 22.5f, 44.343365f, 22.5f, 37.492504f);
                instancePath.lineTo(22.5f, 33.0f);
                instancePath.lineTo(26.1f, 33.0f);
                instancePath.lineTo(26.1f, 37.492504f);
                instancePath.cubicTo(26.1f, 42.96571f, 30.5322f, 47.4f, 36.0f, 47.4f);
                instancePath.cubicTo(41.468178f, 47.4f, 45.9f, 42.965343f, 45.9f, 37.492504f);
                instancePath.lineTo(45.9f, 33.0f);
                instancePath.lineTo(49.5f, 33.0f);
                instancePath.lineTo(49.5f, 37.492504f);
                instancePath.cubicTo(49.5f, 44.341934f, 44.406094f, 50.000637f, 37.80007f, 50.881016f);
                instancePath.close();
                instancePath.moveTo(36.0f, 19.5f);
                instancePath.cubicTo(40.142136f, 19.5f, 43.5f, 22.857864f, 43.5f, 27.0f);
                instancePath.lineTo(43.5f, 37.5f);
                instancePath.cubicTo(43.5f, 41.642136f, 40.142136f, 45.0f, 36.0f, 45.0f);
                instancePath.cubicTo(31.857864f, 45.0f, 28.5f, 41.642136f, 28.5f, 37.5f);
                instancePath.lineTo(28.5f, 27.0f);
                instancePath.cubicTo(28.5f, 22.857864f, 31.857864f, 19.5f, 36.0f, 19.5f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
