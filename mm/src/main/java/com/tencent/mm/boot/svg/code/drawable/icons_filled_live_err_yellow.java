package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_live_err_yellow extends c {
    private final int height = 64;
    private final int width = 64;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 64;
            case 1:
                return 64;
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
                instancePaint3.setColor(-15616);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(32.0f, 5.3333335f);
                instancePath.cubicTo(46.727592f, 5.3333335f, 58.666668f, 17.272408f, 58.666668f, 32.0f);
                instancePath.cubicTo(58.666668f, 46.727592f, 46.727592f, 58.666668f, 32.0f, 58.666668f);
                instancePath.cubicTo(17.272408f, 58.666668f, 5.3333335f, 46.727592f, 5.3333335f, 32.0f);
                instancePath.cubicTo(5.3333335f, 17.272408f, 17.272408f, 5.3333335f, 32.0f, 5.3333335f);
                instancePath.close();
                instancePath.moveTo(31.988022f, 40.903645f);
                instancePath.cubicTo(30.657293f, 40.903645f, 29.6f, 41.92448f, 29.6f, 43.255207f);
                instancePath.cubicTo(29.6f, 44.585938f, 30.657293f, 45.60677f, 31.988022f, 45.60677f);
                instancePath.cubicTo(33.35521f, 45.60677f, 34.39427f, 44.585938f, 34.39427f, 43.255207f);
                instancePath.cubicTo(34.39427f, 41.92448f, 33.35521f, 40.903645f, 31.988022f, 40.903645f);
                instancePath.close();
                instancePath.moveTo(34.02969f, 16.361979f);
                instancePath.lineTo(29.964584f, 16.361979f);
                instancePath.lineTo(30.25625f, 36.619793f);
                instancePath.lineTo(33.73802f, 36.619793f);
                instancePath.lineTo(34.02969f, 16.361979f);
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
