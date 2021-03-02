package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_copy extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(40.8f, 9.896984f);
                instancePath.lineTo(40.8f, 24.0f);
                instancePath.cubicTo(40.8f, 24.662743f, 41.337257f, 25.2f, 42.0f, 25.2f);
                instancePath.lineTo(56.10836f, 25.2f);
                instancePath.lineTo(40.8f, 9.896984f);
                instancePath.close();
                instancePath.moveTo(17.987425f, 6.0f);
                instancePath.lineTo(41.993713f, 6.0f);
                instancePath.lineTo(60.0f, 24.0f);
                instancePath.lineTo(60.0f, 63.004063f);
                instancePath.cubicTo(60.0f, 64.66269f, 58.662483f, 66.0f, 57.012573f, 66.0f);
                instancePath.lineTo(17.987425f, 66.0f);
                instancePath.cubicTo(16.34676f, 66.0f, 15.0f, 64.658676f, 15.0f, 63.004063f);
                instancePath.lineTo(15.0f, 8.995937f);
                instancePath.cubicTo(15.0f, 7.33731f, 16.337517f, 6.0f, 17.987425f, 6.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
