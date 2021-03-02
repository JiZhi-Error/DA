package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_jd_cart extends c {
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
                instancePath.moveTo(79.0f, 54.0f);
                instancePath.cubicTo(78.25857f, 56.12818f, 77.36423f, 57.0f, 75.0f, 57.0f);
                instancePath.lineTo(41.0f, 57.0f);
                instancePath.cubicTo(38.447094f, 57.0f, 36.622643f, 55.168636f, 37.0f, 53.0f);
                instancePath.lineTo(33.0f, 32.0f);
                instancePath.lineTo(81.0f, 39.0f);
                instancePath.cubicTo(81.0f, 38.81818f, 79.41102f, 50.549545f, 79.0f, 54.0f);
                instancePath.lineTo(79.0f, 54.0f);
                instancePath.close();
                instancePath.moveTo(31.0f, 24.0f);
                instancePath.lineTo(30.0f, 14.0f);
                instancePath.lineTo(30.0f, 14.0f);
                instancePath.cubicTo(29.09645f, 10.765857f, 26.07245f, 8.0f, 22.0f, 8.0f);
                instancePath.lineTo(8.0f, 8.0f);
                instancePath.lineTo(8.0f, 16.0f);
                instancePath.lineTo(12.0f, 16.0f);
                instancePath.lineTo(15.0f, 16.0f);
                instancePath.lineTo(20.0f, 16.0f);
                instancePath.cubicTo(20.94245f, 16.142857f, 21.95f, 17.155739f, 22.0f, 18.0f);
                instancePath.lineTo(22.0f, 18.0f);
                instancePath.lineTo(29.0f, 56.0f);
                instancePath.lineTo(29.0f, 56.0f);
                instancePath.cubicTo(30.31235f, 61.371452f, 34.9343f, 65.0f, 40.0f, 65.0f);
                instancePath.lineTo(77.0f, 65.0f);
                instancePath.cubicTo(82.3562f, 65.0f, 84.95f, 60.92857f, 85.0f, 57.0f);
                instancePath.cubicTo(85.6574f, 54.530094f, 89.0f, 32.42857f, 89.0f, 32.0f);
                instancePath.lineTo(31.0f, 24.0f);
                instancePath.close();
                instancePath.moveTo(77.0f, 73.0f);
                instancePath.cubicTo(72.58178f, 73.0f, 69.0f, 76.58178f, 69.0f, 81.0f);
                instancePath.cubicTo(69.0f, 85.41822f, 72.58178f, 89.0f, 77.0f, 89.0f);
                instancePath.cubicTo(81.41822f, 89.0f, 85.0f, 85.41822f, 85.0f, 81.0f);
                instancePath.cubicTo(85.0f, 76.58178f, 81.41822f, 73.0f, 77.0f, 73.0f);
                instancePath.lineTo(77.0f, 73.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 73.0f);
                instancePath.cubicTo(31.581778f, 73.0f, 28.0f, 76.58178f, 28.0f, 81.0f);
                instancePath.cubicTo(28.0f, 85.41822f, 31.581778f, 89.0f, 36.0f, 89.0f);
                instancePath.cubicTo(40.41822f, 89.0f, 44.0f, 85.41822f, 44.0f, 81.0f);
                instancePath.cubicTo(44.0f, 76.58178f, 40.41822f, 73.0f, 36.0f, 73.0f);
                instancePath.lineTo(36.0f, 73.0f);
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
