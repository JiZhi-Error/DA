package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fix_tools_progress_green extends c {
    private final int height = 6;
    private final int width = 14;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 14;
            case 1:
                return 6;
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
                instancePaint3.setColor(-12666825);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(2.0f, 1.0f);
                instancePath.lineTo(12.0f, 1.0f);
                instancePath.cubicTo(12.552284f, 1.0f, 13.0f, 1.4477153f, 13.0f, 2.0f);
                instancePath.lineTo(13.0f, 4.0f);
                instancePath.cubicTo(13.0f, 4.5522847f, 12.552284f, 5.0f, 12.0f, 5.0f);
                instancePath.lineTo(2.0f, 5.0f);
                instancePath.cubicTo(1.4477153f, 5.0f, 1.0f, 4.5522847f, 1.0f, 4.0f);
                instancePath.lineTo(1.0f, 2.0f);
                instancePath.cubicTo(1.0f, 1.4477153f, 1.4477153f, 1.0f, 2.0f, 1.0f);
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
