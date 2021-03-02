package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_live_screen extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                instancePath.moveTo(9.400753f, 4.5f);
                instancePath.lineTo(9.400753f, 3.0f);
                instancePath.cubicTo(9.400753f, 2.4477153f, 9.764522f, 2.0f, 10.213253f, 2.0f);
                instancePath.lineTo(18.4939f, 2.0f);
                instancePath.cubicTo(18.942633f, 2.0f, 19.3064f, 2.4477153f, 19.3064f, 3.0f);
                instancePath.lineTo(19.3064f, 17.001755f);
                instancePath.cubicTo(19.3064f, 17.554039f, 18.942633f, 18.001755f, 18.4939f, 18.001755f);
                instancePath.lineTo(17.27515f, 18.001755f);
                instancePath.lineTo(17.27515f, 6.0f);
                instancePath.cubicTo(17.27515f, 5.1715727f, 16.729498f, 4.5f, 16.0564f, 4.5f);
                instancePath.lineTo(9.400753f, 4.5f);
                instancePath.close();
                instancePath.moveTo(15.211858f, 6.0f);
                instancePath.cubicTo(15.660589f, 6.0f, 16.024357f, 6.596954f, 16.024357f, 7.3333335f);
                instancePath.lineTo(16.024357f, 20.666666f);
                instancePath.cubicTo(16.024357f, 21.403046f, 15.660589f, 22.0f, 15.211858f, 22.0f);
                instancePath.lineTo(5.8125f, 22.0f);
                instancePath.cubicTo(5.3637686f, 22.0f, 5.0f, 21.403046f, 5.0f, 20.666666f);
                instancePath.lineTo(5.0f, 7.3333335f);
                instancePath.cubicTo(5.0f, 6.596954f, 5.3637686f, 6.0f, 5.8125f, 6.0f);
                instancePath.lineTo(15.211858f, 6.0f);
                instancePath.close();
                instancePath.moveTo(10.5f, 18.5f);
                instancePath.cubicTo(9.947715f, 18.5f, 9.5f, 18.947716f, 9.5f, 19.5f);
                instancePath.cubicTo(9.5f, 20.052284f, 9.947715f, 20.5f, 10.5f, 20.5f);
                instancePath.cubicTo(11.052284f, 20.5f, 11.5f, 20.052284f, 11.5f, 19.5f);
                instancePath.cubicTo(11.5f, 18.947716f, 11.052284f, 18.5f, 10.5f, 18.5f);
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
