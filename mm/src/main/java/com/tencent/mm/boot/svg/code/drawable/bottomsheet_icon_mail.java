package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_mail extends c {
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
                instancePaint3.setColor(-8617851);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(87.0f, 26.0f);
                instancePath.lineTo(81.0f, 32.0f);
                instancePath.cubicTo(80.87885f, 32.277943f, 80.9f, 32.483356f, 81.0f, 33.0f);
                instancePath.lineTo(81.0f, 65.0f);
                instancePath.cubicTo(80.9f, 67.14137f, 79.08695f, 68.94447f, 77.0f, 69.0f);
                instancePath.lineTo(20.0f, 69.0f);
                instancePath.cubicTo(17.91305f, 68.94447f, 16.1f, 67.14137f, 16.0f, 65.0f);
                instancePath.lineTo(16.0f, 33.0f);
                instancePath.cubicTo(16.1f, 32.483356f, 16.12115f, 32.277943f, 16.0f, 32.0f);
                instancePath.lineTo(10.0f, 26.0f);
                instancePath.cubicTo(8.75645f, 27.917215f, 8.0f, 30.216175f, 8.0f, 33.0f);
                instancePath.lineTo(8.0f, 65.0f);
                instancePath.cubicTo(8.0f, 71.59026f, 13.4396f, 77.0f, 20.0f, 77.0f);
                instancePath.lineTo(77.0f, 77.0f);
                instancePath.cubicTo(83.5604f, 77.0f, 89.0f, 71.59026f, 89.0f, 65.0f);
                instancePath.lineTo(89.0f, 33.0f);
                instancePath.cubicTo(89.0f, 30.216175f, 88.24355f, 27.917215f, 87.0f, 26.0f);
                instancePath.moveTo(17.0f, 22.0f);
                instancePath.lineTo(24.0f, 29.0f);
                instancePath.lineTo(24.0f, 29.0f);
                instancePath.lineTo(49.0f, 53.0f);
                instancePath.lineTo(73.0f, 29.0f);
                instancePath.lineTo(73.0f, 29.0f);
                instancePath.lineTo(80.0f, 22.0f);
                instancePath.cubicTo(80.48633f, 21.519585f, 80.48227f, 21.517807f, 80.0f, 22.0f);
                instancePath.lineTo(81.0f, 21.0f);
                instancePath.lineTo(77.0f, 21.0f);
                instancePath.cubicTo(77.00033f, 21.002222f, 76.96873f, 21.0f, 77.0f, 21.0f);
                instancePath.lineTo(20.0f, 21.0f);
                instancePath.cubicTo(20.031721f, 21.0f, 20.000126f, 21.002222f, 20.0f, 21.0f);
                instancePath.lineTo(16.0f, 21.0f);
                instancePath.lineTo(17.0f, 22.0f);
                instancePath.cubicTo(16.517733f, 21.517807f, 16.514122f, 21.519585f, 17.0f, 22.0f);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
