package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_reply extends c {
    private final int height = 20;
    private final int width = 20;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 20;
            case 1:
                return 20;
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
                instancePath.moveTo(10.0f, 2.5f);
                instancePath.cubicTo(14.602373f, 2.5f, 18.333334f, 5.671316f, 18.333334f, 9.583333f);
                instancePath.cubicTo(18.333334f, 11.697003f, 17.24417f, 13.594444f, 15.51687f, 14.892278f);
                instancePath.lineTo(15.768618f, 17.058012f);
                instancePath.cubicTo(15.795188f, 17.28659f, 15.631427f, 17.493431f, 15.402847f, 17.52f);
                instancePath.cubicTo(15.324681f, 17.529087f, 15.24554f, 17.515852f, 15.1745825f, 17.481827f);
                instancePath.lineTo(12.688788f, 16.289864f);
                instancePath.cubicTo(11.845224f, 16.534145f, 10.94082f, 16.666666f, 10.0f, 16.666666f);
                instancePath.cubicTo(5.397627f, 16.666666f, 1.6666666f, 13.49535f, 1.6666666f, 9.583333f);
                instancePath.cubicTo(1.6666666f, 5.671316f, 5.397627f, 2.5f, 10.0f, 2.5f);
                instancePath.close();
                instancePath.moveTo(6.5f, 8.0f);
                instancePath.cubicTo(5.9477153f, 8.0f, 5.5f, 8.447715f, 5.5f, 9.0f);
                instancePath.cubicTo(5.5f, 9.552285f, 5.9477153f, 10.0f, 6.5f, 10.0f);
                instancePath.cubicTo(7.0522847f, 10.0f, 7.5f, 9.552285f, 7.5f, 9.0f);
                instancePath.cubicTo(7.5f, 8.447715f, 7.0522847f, 8.0f, 6.5f, 8.0f);
                instancePath.close();
                instancePath.moveTo(10.0f, 8.0f);
                instancePath.cubicTo(9.447715f, 8.0f, 9.0f, 8.447715f, 9.0f, 9.0f);
                instancePath.cubicTo(9.0f, 9.552285f, 9.447715f, 10.0f, 10.0f, 10.0f);
                instancePath.cubicTo(10.552284f, 10.0f, 11.0f, 9.552285f, 11.0f, 9.0f);
                instancePath.cubicTo(11.0f, 8.447715f, 10.552284f, 8.0f, 10.0f, 8.0f);
                instancePath.close();
                instancePath.moveTo(13.5f, 8.0f);
                instancePath.cubicTo(12.947716f, 8.0f, 12.5f, 8.447715f, 12.5f, 9.0f);
                instancePath.cubicTo(12.5f, 9.552285f, 12.947716f, 10.0f, 13.5f, 10.0f);
                instancePath.cubicTo(14.052284f, 10.0f, 14.5f, 9.552285f, 14.5f, 9.0f);
                instancePath.cubicTo(14.5f, 8.447715f, 14.052284f, 8.0f, 13.5f, 8.0f);
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
