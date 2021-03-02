package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_video_call extends c {
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
                instancePath.moveTo(9.0f, 16.5f);
                instancePath.lineTo(48.0f, 16.5f);
                instancePath.cubicTo(49.656853f, 16.5f, 51.0f, 17.843145f, 51.0f, 19.5f);
                instancePath.lineTo(51.0f, 52.5f);
                instancePath.cubicTo(51.0f, 54.156853f, 49.656853f, 55.5f, 48.0f, 55.5f);
                instancePath.lineTo(9.0f, 55.5f);
                instancePath.cubicTo(7.343146f, 55.5f, 6.0f, 54.156853f, 6.0f, 52.5f);
                instancePath.lineTo(6.0f, 19.5f);
                instancePath.cubicTo(6.0f, 17.843145f, 7.343146f, 16.5f, 9.0f, 16.5f);
                instancePath.close();
                instancePath.moveTo(54.0f, 30.0f);
                instancePath.lineTo(64.125916f, 21.899267f);
                instancePath.cubicTo(65.4197f, 20.864239f, 67.30758f, 21.074003f, 68.342606f, 22.36779f);
                instancePath.cubicTo(68.76816f, 22.899729f, 69.0f, 23.56066f, 69.0f, 24.241875f);
                instancePath.lineTo(69.0f, 47.758125f);
                instancePath.cubicTo(69.0f, 49.414978f, 67.65685f, 50.758125f, 66.0f, 50.758125f);
                instancePath.cubicTo(65.31879f, 50.758125f, 64.65785f, 50.526283f, 64.125916f, 50.10073f);
                instancePath.lineTo(54.0f, 42.0f);
                instancePath.lineTo(54.0f, 30.0f);
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
