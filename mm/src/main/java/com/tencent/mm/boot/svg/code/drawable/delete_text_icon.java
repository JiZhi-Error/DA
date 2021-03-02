package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class delete_text_icon extends c {
    private final int height = 36;
    private final int width = 36;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 36;
            case 1:
                return 36;
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
                instancePaint3.setColor(-855310);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(14.81802f, 18.0f);
                instancePath.lineTo(8.454059f, 24.36396f);
                instancePath.lineTo(11.636039f, 27.545942f);
                instancePath.lineTo(18.0f, 21.18198f);
                instancePath.lineTo(24.36396f, 27.545942f);
                instancePath.lineTo(27.545942f, 24.36396f);
                instancePath.lineTo(21.18198f, 18.0f);
                instancePath.lineTo(27.545942f, 11.636039f);
                instancePath.lineTo(24.36396f, 8.454059f);
                instancePath.lineTo(18.0f, 14.81802f);
                instancePath.lineTo(11.636039f, 8.454059f);
                instancePath.lineTo(8.454059f, 11.636039f);
                instancePath.lineTo(14.81802f, 18.0f);
                instancePath.close();
                instancePath.moveTo(18.0f, 36.0f);
                instancePath.cubicTo(8.058874f, 36.0f, 0.0f, 27.941126f, 0.0f, 18.0f);
                instancePath.cubicTo(0.0f, 8.058874f, 8.058874f, 0.0f, 18.0f, 0.0f);
                instancePath.cubicTo(27.941126f, 0.0f, 36.0f, 8.058874f, 36.0f, 18.0f);
                instancePath.cubicTo(36.0f, 27.941126f, 27.941126f, 36.0f, 18.0f, 36.0f);
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
