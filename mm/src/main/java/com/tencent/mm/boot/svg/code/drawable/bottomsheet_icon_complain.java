package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_complain extends c {
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
                instancePath.moveTo(88.0f, 74.0f);
                instancePath.lineTo(88.0f, 74.0f);
                instancePath.lineTo(56.0f, 15.0f);
                instancePath.lineTo(56.0f, 15.0f);
                instancePath.cubicTo(54.97f, 11.577649f, 51.78977f, 9.0f, 48.0f, 9.0f);
                instancePath.cubicTo(44.21023f, 9.0f, 41.029545f, 11.577649f, 40.0f, 15.0f);
                instancePath.lineTo(40.0f, 15.0f);
                instancePath.lineTo(8.0f, 74.0f);
                instancePath.lineTo(8.0f, 74.0f);
                instancePath.cubicTo(7.5070333f, 75.54358f, 7.0f, 77.10677f, 7.0f, 79.0f);
                instancePath.cubicTo(7.0f, 83.32397f, 10.671322f, 87.0f, 15.0f, 87.0f);
                instancePath.cubicTo(15.497933f, 87.0f, 15.791311f, 86.98221f, 16.0f, 87.0f);
                instancePath.lineTo(16.0f, 87.0f);
                instancePath.lineTo(48.0f, 87.0f);
                instancePath.lineTo(48.0f, 79.0f);
                instancePath.lineTo(44.0f, 79.0f);
                instancePath.lineTo(44.0f, 71.0f);
                instancePath.lineTo(48.0f, 71.0f);
                instancePath.lineTo(48.0f, 62.0f);
                instancePath.lineTo(44.0f, 62.0f);
                instancePath.lineTo(42.0f, 34.0f);
                instancePath.lineTo(48.0f, 34.0f);
                instancePath.lineTo(48.0f, 25.0f);
                instancePath.lineTo(48.0f, 25.0f);
                instancePath.lineTo(48.0f, 25.0f);
                instancePath.lineTo(48.0f, 34.0f);
                instancePath.lineTo(54.0f, 34.0f);
                instancePath.lineTo(52.0f, 62.0f);
                instancePath.lineTo(48.0f, 62.0f);
                instancePath.lineTo(48.0f, 71.0f);
                instancePath.lineTo(52.0f, 71.0f);
                instancePath.lineTo(52.0f, 79.0f);
                instancePath.lineTo(48.0f, 79.0f);
                instancePath.lineTo(48.0f, 87.0f);
                instancePath.lineTo(80.0f, 87.0f);
                instancePath.lineTo(80.0f, 87.0f);
                instancePath.cubicTo(80.20824f, 86.98221f, 80.50207f, 87.0f, 81.0f, 87.0f);
                instancePath.cubicTo(85.328674f, 87.0f, 89.0f, 83.32397f, 89.0f, 79.0f);
                instancePath.cubicTo(89.0f, 77.10677f, 88.49251f, 75.54358f, 88.0f, 74.0f);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
