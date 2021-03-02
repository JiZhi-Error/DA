package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_ban_comment_on extends c {
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
                instancePath.moveTo(10.0f, 16.666666f);
                instancePath.cubicTo(14.602373f, 16.666666f, 18.333334f, 13.49535f, 18.333334f, 9.583333f);
                instancePath.cubicTo(18.333334f, 5.671316f, 14.602373f, 2.5f, 10.0f, 2.5f);
                instancePath.cubicTo(5.397627f, 2.5f, 1.6666666f, 5.671316f, 1.6666666f, 9.583333f);
                instancePath.cubicTo(1.6666666f, 11.697003f, 2.7558317f, 13.594444f, 4.4831305f, 14.892278f);
                instancePath.lineTo(4.2313824f, 17.058012f);
                instancePath.cubicTo(4.204812f, 17.28659f, 4.3685727f, 17.493431f, 4.5971527f, 17.52f);
                instancePath.cubicTo(4.675319f, 17.529087f, 4.754461f, 17.515852f, 4.8254175f, 17.481827f);
                instancePath.lineTo(7.3112116f, 16.289864f);
                instancePath.cubicTo(8.154776f, 16.534145f, 9.05918f, 16.666666f, 10.0f, 16.666666f);
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
