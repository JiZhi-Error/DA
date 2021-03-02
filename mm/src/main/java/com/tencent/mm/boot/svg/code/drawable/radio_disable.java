package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class radio_disable extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                instancePaint3.setColor(-2565928);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(60.0f, 0.0f);
                instancePath.lineTo(60.0f, 60.0f);
                instancePath.lineTo(0.0f, 60.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.drawPath(instancePath, c.instancePaint(instancePaint3, looper));
                canvas.restore();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(6.0f, 30.0f);
                instancePath2.cubicTo(6.0f, 43.2f, 16.8f, 54.0f, 30.0f, 54.0f);
                instancePath2.cubicTo(43.2f, 54.0f, 54.0f, 43.2f, 54.0f, 30.0f);
                instancePath2.cubicTo(54.0f, 16.8f, 43.2f, 6.0f, 30.0f, 6.0f);
                instancePath2.cubicTo(16.8f, 6.0f, 6.0f, 16.8f, 6.0f, 30.0f);
                instancePath2.close();
                instancePath2.moveTo(10.0f, 30.0f);
                instancePath2.cubicTo(10.0f, 19.0f, 19.0f, 10.0f, 30.0f, 10.0f);
                instancePath2.cubicTo(41.0f, 10.0f, 50.0f, 19.0f, 50.0f, 30.0f);
                instancePath2.cubicTo(50.0f, 41.0f, 41.0f, 50.0f, 30.0f, 50.0f);
                instancePath2.cubicTo(19.0f, 50.0f, 10.0f, 41.0f, 10.0f, 30.0f);
                instancePath2.close();
                canvas.saveLayerAlpha(null, 25, 31);
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
