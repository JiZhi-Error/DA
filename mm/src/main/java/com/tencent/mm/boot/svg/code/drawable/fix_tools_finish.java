package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fix_tools_finish extends c {
    private final int height = 100;
    private final int width = 100;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 100;
            case 1:
                return 100;
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
                instancePaint3.setColor(-16139513);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(100.0f, 50.346603f);
                instancePath.cubicTo(100.0f, 22.265478f, 77.614815f, 0.0f, 49.382717f, 0.0f);
                instancePath.cubicTo(22.385185f, 0.0f, 0.0f, 22.265478f, 0.0f, 50.346603f);
                instancePath.cubicTo(0.0f, 77.19976f, 22.385185f, 99.46524f, 49.382717f, 99.46524f);
                instancePath.cubicTo(77.614815f, 99.46524f, 100.0f, 77.19976f, 100.0f, 50.346603f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(26.066193f, 52.06067f);
                instancePath2.cubicTo(25.683428f, 51.666645f, 25.640087f, 50.985928f, 25.972504f, 50.536034f);
                instancePath2.lineTo(27.666462f, 48.243423f);
                instancePath2.cubicTo(27.997484f, 47.795414f, 28.617992f, 47.700703f, 29.062307f, 48.03942f);
                instancePath2.lineTo(41.715767f, 57.68571f);
                instancePath2.cubicTo(42.155647f, 58.021053f, 42.853935f, 58.00976f, 43.289238f, 57.64906f);
                instancePath2.lineTo(75.15912f, 31.240854f);
                instancePath2.cubicTo(75.58824f, 30.885271f, 76.25674f, 30.911966f, 76.65116f, 31.299417f);
                instancePath2.lineTo(78.11376f, 32.736153f);
                instancePath2.cubicTo(78.508675f, 33.12408f, 78.51484f, 33.745895f, 78.11964f, 34.132755f);
                instancePath2.lineTo(43.220352f, 68.2952f);
                instancePath2.cubicTo(42.828686f, 68.6786f, 42.199085f, 68.66812f, 41.81812f, 68.275955f);
                instancePath2.lineTo(26.066193f, 52.06067f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
