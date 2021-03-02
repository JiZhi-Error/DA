package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_desktop_search_icon extends c {
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
                instancePaint3.setColor(-2130706433);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(51.487274f, 48.305294f);
                instancePath.lineTo(62.849243f, 59.667263f);
                instancePath.lineTo(59.667263f, 62.849243f);
                instancePath.lineTo(48.305294f, 51.487274f);
                instancePath.cubicTo(44.15103f, 54.930374f, 38.817215f, 57.0f, 33.0f, 57.0f);
                instancePath.cubicTo(19.745142f, 57.0f, 9.0f, 46.254856f, 9.0f, 33.0f);
                instancePath.cubicTo(9.0f, 19.745142f, 19.745142f, 9.0f, 33.0f, 9.0f);
                instancePath.cubicTo(46.254856f, 9.0f, 57.0f, 19.745142f, 57.0f, 33.0f);
                instancePath.cubicTo(57.0f, 38.817215f, 54.930374f, 44.15103f, 51.487274f, 48.305294f);
                instancePath.close();
                instancePath.moveTo(52.54228f, 33.006664f);
                instancePath.cubicTo(52.54228f, 22.237095f, 43.81185f, 13.506665f, 33.04228f, 13.506665f);
                instancePath.cubicTo(22.272707f, 13.506665f, 13.542279f, 22.237095f, 13.542279f, 33.006664f);
                instancePath.cubicTo(13.542279f, 43.776237f, 22.272707f, 52.506664f, 33.04228f, 52.506664f);
                instancePath.cubicTo(43.81185f, 52.506664f, 52.54228f, 43.776237f, 52.54228f, 33.006664f);
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
