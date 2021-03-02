package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_radar extends c {
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
                instancePath.moveTo(53.417892f, 16.160769f);
                instancePath.cubicTo(48.769585f, 12.076537f, 42.674004f, 9.6f, 36.0f, 9.6f);
                instancePath.cubicTo(21.419683f, 9.6f, 9.6f, 21.419683f, 9.6f, 36.0f);
                instancePath.cubicTo(9.6f, 50.58032f, 21.419683f, 62.4f, 36.0f, 62.4f);
                instancePath.cubicTo(50.58032f, 62.4f, 62.4f, 50.58032f, 62.4f, 36.0f);
                instancePath.cubicTo(62.4f, 29.38931f, 59.97023f, 23.346127f, 55.955036f, 18.714792f);
                instancePath.lineTo(49.993065f, 24.676765f);
                instancePath.cubicTo(52.49883f, 27.76951f, 54.0f, 31.709446f, 54.0f, 36.0f);
                instancePath.cubicTo(54.0f, 45.941124f, 45.941124f, 54.0f, 36.0f, 54.0f);
                instancePath.cubicTo(26.058874f, 54.0f, 18.0f, 45.941124f, 18.0f, 36.0f);
                instancePath.cubicTo(18.0f, 26.058874f, 26.058874f, 18.0f, 36.0f, 18.0f);
                instancePath.cubicTo(40.354008f, 18.0f, 44.34695f, 19.5459f, 47.459892f, 22.118767f);
                instancePath.lineTo(53.417892f, 16.160769f);
                instancePath.close();
                instancePath.moveTo(44.89987f, 24.678791f);
                instancePath.cubicTo(42.450245f, 22.750416f, 39.35947f, 21.6f, 36.0f, 21.6f);
                instancePath.cubicTo(28.0471f, 21.6f, 21.6f, 28.0471f, 21.6f, 36.0f);
                instancePath.cubicTo(21.6f, 43.9529f, 28.0471f, 50.4f, 36.0f, 50.4f);
                instancePath.cubicTo(43.9529f, 50.4f, 50.4f, 43.9529f, 50.4f, 36.0f);
                instancePath.cubicTo(50.4f, 32.70413f, 49.29273f, 29.666874f, 47.42989f, 27.239939f);
                instancePath.lineTo(40.224293f, 34.445538f);
                instancePath.cubicTo(40.40263f, 34.93001f, 40.5f, 35.453636f, 40.5f, 36.0f);
                instancePath.cubicTo(40.5f, 38.485283f, 38.485283f, 40.5f, 36.0f, 40.5f);
                instancePath.cubicTo(33.514717f, 40.5f, 31.5f, 38.485283f, 31.5f, 36.0f);
                instancePath.cubicTo(31.5f, 33.514717f, 33.514717f, 31.5f, 36.0f, 31.5f);
                instancePath.cubicTo(36.614132f, 31.5f, 37.199528f, 31.623022f, 37.73289f, 31.845768f);
                instancePath.lineTo(44.89987f, 24.678791f);
                instancePath.close();
                instancePath.moveTo(36.0f, 66.0f);
                instancePath.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                instancePath.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
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
