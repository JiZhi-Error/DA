package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_desktop extends c {
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
                instancePath.moveTo(77.0f, 40.0f);
                instancePath.lineTo(77.0f, 48.0f);
                instancePath.cubicTo(79.00536f, 48.166668f, 80.833336f, 49.995094f, 81.0f, 52.0f);
                instancePath.lineTo(81.0f, 77.0f);
                instancePath.cubicTo(80.833336f, 79.00536f, 79.00536f, 80.833336f, 77.0f, 81.0f);
                instancePath.lineTo(52.0f, 81.0f);
                instancePath.cubicTo(49.99464f, 80.833336f, 48.166668f, 79.00536f, 48.0f, 77.0f);
                instancePath.lineTo(40.0f, 77.0f);
                instancePath.cubicTo(40.0f, 83.51563f, 45.48437f, 89.0f, 52.0f, 89.0f);
                instancePath.lineTo(77.0f, 89.0f);
                instancePath.cubicTo(83.51563f, 89.0f, 89.0f, 83.51563f, 89.0f, 77.0f);
                instancePath.lineTo(89.0f, 52.0f);
                instancePath.cubicTo(89.0f, 45.48437f, 83.51563f, 40.0f, 77.0f, 40.0f);
                instancePath.moveTo(16.0f, 57.0f);
                instancePath.lineTo(16.0f, 20.0f);
                instancePath.cubicTo(16.0f, 17.831364f, 17.831364f, 16.0f, 20.0f, 16.0f);
                instancePath.lineTo(57.0f, 16.0f);
                instancePath.cubicTo(59.168636f, 16.0f, 61.0f, 17.831364f, 61.0f, 20.0f);
                instancePath.lineTo(61.0f, 57.0f);
                instancePath.cubicTo(61.0f, 59.168636f, 59.168636f, 61.0f, 57.0f, 61.0f);
                instancePath.lineTo(20.0f, 61.0f);
                instancePath.cubicTo(17.831364f, 61.0f, 16.0f, 59.168636f, 16.0f, 57.0f);
                instancePath.moveTo(69.0f, 57.0f);
                instancePath.lineTo(69.0f, 20.0f);
                instancePath.cubicTo(69.0f, 13.462437f, 63.538013f, 8.0f, 57.0f, 8.0f);
                instancePath.lineTo(20.0f, 8.0f);
                instancePath.cubicTo(13.461986f, 8.0f, 8.0f, 13.462437f, 8.0f, 20.0f);
                instancePath.lineTo(8.0f, 57.0f);
                instancePath.cubicTo(8.0f, 63.538013f, 13.461986f, 69.0f, 20.0f, 69.0f);
                instancePath.lineTo(57.0f, 69.0f);
                instancePath.cubicTo(63.538013f, 69.0f, 69.0f, 63.538013f, 69.0f, 57.0f);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
