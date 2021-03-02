package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class voice extends c {
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
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(46.0f, 73.0f);
                instancePath.lineTo(46.0f, 69.99739f);
                instancePath.cubicTo(46.0f, 69.96348f, 46.00085f, 69.929756f, 46.002525f, 69.896255f);
                instancePath.cubicTo(36.447983f, 68.898026f, 29.0f, 60.818798f, 29.0f, 51.0f);
                instancePath.cubicTo(29.0f, 49.89543f, 29.89543f, 49.0f, 31.0f, 49.0f);
                instancePath.cubicTo(32.10457f, 49.0f, 33.0f, 49.89543f, 33.0f, 51.0f);
                instancePath.cubicTo(33.0f, 59.28427f, 39.71573f, 66.0f, 48.0f, 66.0f);
                instancePath.cubicTo(56.28427f, 66.0f, 63.0f, 59.28427f, 63.0f, 51.0f);
                instancePath.cubicTo(63.0f, 49.89543f, 63.89543f, 49.0f, 65.0f, 49.0f);
                instancePath.cubicTo(66.10457f, 49.0f, 67.0f, 49.89543f, 67.0f, 51.0f);
                instancePath.cubicTo(67.0f, 60.818787f, 59.552032f, 68.89801f, 49.9975f, 69.896255f);
                instancePath.lineTo(49.9975f, 69.896255f);
                instancePath.cubicTo(49.99916f, 69.929756f, 50.0f, 69.96348f, 50.0f, 69.99739f);
                instancePath.lineTo(50.0f, 73.0f);
                instancePath.lineTo(57.008846f, 73.0f);
                instancePath.cubicTo(58.110325f, 73.0f, 59.0f, 73.89543f, 59.0f, 75.0f);
                instancePath.cubicTo(59.0f, 76.112274f, 58.10853f, 77.0f, 57.008846f, 77.0f);
                instancePath.lineTo(38.991154f, 77.0f);
                instancePath.cubicTo(37.889675f, 77.0f, 37.0f, 76.10457f, 37.0f, 75.0f);
                instancePath.cubicTo(37.0f, 73.887726f, 37.89147f, 73.0f, 38.991154f, 73.0f);
                instancePath.lineTo(46.0f, 73.0f);
                instancePath.close();
                instancePath.moveTo(48.0f, 20.0f);
                instancePath.cubicTo(41.92487f, 20.0f, 37.0f, 24.920769f, 37.0f, 31.007566f);
                instancePath.lineTo(37.0f, 50.992435f);
                instancePath.cubicTo(37.0f, 57.071747f, 41.92353f, 62.0f, 48.0f, 62.0f);
                instancePath.cubicTo(54.07513f, 62.0f, 59.0f, 57.07923f, 59.0f, 50.992435f);
                instancePath.lineTo(59.0f, 31.007566f);
                instancePath.cubicTo(59.0f, 24.928255f, 54.07647f, 20.0f, 48.0f, 20.0f);
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
