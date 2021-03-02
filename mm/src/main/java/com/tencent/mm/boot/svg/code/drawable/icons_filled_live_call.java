package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_live_call extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.0f, 3.0f);
                instancePath.cubicTo(16.970562f, 3.0f, 21.0f, 7.029437f, 21.0f, 12.0f);
                instancePath.lineTo(21.0f, 18.0f);
                instancePath.lineTo(21.0f, 19.0f);
                instancePath.cubicTo(21.0f, 20.10457f, 20.10457f, 21.0f, 19.0f, 21.0f);
                instancePath.lineTo(17.0f, 21.0f);
                instancePath.cubicTo(16.447716f, 21.0f, 16.0f, 20.552284f, 16.0f, 20.0f);
                instancePath.lineTo(16.0f, 15.0f);
                instancePath.cubicTo(16.0f, 14.447716f, 16.447716f, 14.0f, 17.0f, 14.0f);
                instancePath.lineTo(19.0f, 14.0f);
                instancePath.lineTo(19.0f, 12.0f);
                instancePath.cubicTo(19.0f, 8.1340065f, 15.8659935f, 5.0f, 12.0f, 5.0f);
                instancePath.cubicTo(8.1340065f, 5.0f, 5.0f, 8.1340065f, 5.0f, 12.0f);
                instancePath.lineTo(5.0f, 14.0f);
                instancePath.lineTo(7.0f, 14.0f);
                instancePath.cubicTo(7.5522847f, 14.0f, 8.0f, 14.447716f, 8.0f, 15.0f);
                instancePath.lineTo(8.0f, 20.0f);
                instancePath.cubicTo(8.0f, 20.552284f, 7.5522847f, 21.0f, 7.0f, 21.0f);
                instancePath.lineTo(5.0f, 21.0f);
                instancePath.cubicTo(3.8954306f, 21.0f, 3.0f, 20.10457f, 3.0f, 19.0f);
                instancePath.lineTo(3.0f, 12.0f);
                instancePath.cubicTo(3.0f, 7.029437f, 7.029437f, 3.0f, 12.0f, 3.0f);
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
