package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class float_indicator_icon extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(24.0f, 41.6f);
                instancePath.cubicTo(33.72021f, 41.6f, 41.6f, 33.72021f, 41.6f, 24.0f);
                instancePath.cubicTo(41.6f, 14.279788f, 33.72021f, 6.4f, 24.0f, 6.4f);
                instancePath.cubicTo(14.279788f, 6.4f, 6.4f, 14.279788f, 6.4f, 24.0f);
                instancePath.cubicTo(6.4f, 33.72021f, 14.279788f, 41.6f, 24.0f, 41.6f);
                instancePath.close();
                instancePath.moveTo(24.0f, 44.0f);
                instancePath.cubicTo(12.954305f, 44.0f, 4.0f, 35.045696f, 4.0f, 24.0f);
                instancePath.cubicTo(4.0f, 12.954305f, 12.954305f, 4.0f, 24.0f, 4.0f);
                instancePath.cubicTo(35.045696f, 4.0f, 44.0f, 12.954305f, 44.0f, 24.0f);
                instancePath.cubicTo(44.0f, 35.045696f, 35.045696f, 44.0f, 24.0f, 44.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(24.0f, 35.6f);
                instancePath2.cubicTo(30.406504f, 35.6f, 35.6f, 30.406504f, 35.6f, 24.0f);
                instancePath2.cubicTo(35.6f, 17.593496f, 30.406504f, 12.4f, 24.0f, 12.4f);
                instancePath2.cubicTo(17.593496f, 12.4f, 12.4f, 17.593496f, 12.4f, 24.0f);
                instancePath2.cubicTo(12.4f, 30.406504f, 17.593496f, 35.6f, 24.0f, 35.6f);
                instancePath2.close();
                instancePath2.moveTo(24.0f, 38.0f);
                instancePath2.cubicTo(16.268013f, 38.0f, 10.0f, 31.731987f, 10.0f, 24.0f);
                instancePath2.cubicTo(10.0f, 16.268013f, 16.268013f, 10.0f, 24.0f, 10.0f);
                instancePath2.cubicTo(31.731987f, 10.0f, 38.0f, 16.268013f, 38.0f, 24.0f);
                instancePath2.cubicTo(38.0f, 31.731987f, 31.731987f, 38.0f, 24.0f, 38.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
