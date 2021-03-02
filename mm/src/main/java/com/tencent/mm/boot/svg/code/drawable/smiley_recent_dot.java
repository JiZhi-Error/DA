package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class smiley_recent_dot extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-2697514);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.0f, 0.0f);
                instancePath.cubicTo(5.3716516f, 0.0f, 0.0f, 5.3716516f, 0.0f, 12.0f);
                instancePath.cubicTo(0.0f, 18.628347f, 5.3716516f, 24.0f, 12.0f, 24.0f);
                instancePath.cubicTo(18.628347f, 24.0f, 24.0f, 18.628347f, 24.0f, 12.0f);
                instancePath.cubicTo(24.0f, 5.3716516f, 18.628347f, 0.0f, 12.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(12.148247f, 12.97082f);
                instancePath.lineTo(18.91682f, 15.12273f);
                instancePath.lineTo(18.506933f, 16.406258f);
                instancePath.lineTo(10.797303f, 13.955056f);
                instancePath.lineTo(10.797303f, 3.1551237f);
                instancePath.lineTo(12.145618f, 3.1551237f);
                instancePath.lineTo(12.145618f, 12.97082f);
                instancePath.lineTo(12.148247f, 12.97082f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
