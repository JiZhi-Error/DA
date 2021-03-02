package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wu extends c {
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
                canvas.saveLayerAlpha(null, 204, 31);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.0f, 16.0f);
                instancePath.cubicTo(47.045696f, 16.0f, 56.0f, 24.954306f, 56.0f, 36.0f);
                instancePath.cubicTo(56.0f, 47.045696f, 47.045696f, 56.0f, 36.0f, 56.0f);
                instancePath.cubicTo(24.954306f, 56.0f, 16.0f, 47.045696f, 16.0f, 36.0f);
                instancePath.cubicTo(16.0f, 24.954306f, 24.954306f, 16.0f, 36.0f, 16.0f);
                instancePath.close();
                instancePath.moveTo(23.48019f, 26.306059f);
                instancePath.cubicTo(21.4031f, 28.98474f, 20.166666f, 32.347977f, 20.166666f, 36.0f);
                instancePath.cubicTo(20.166666f, 44.744507f, 27.255491f, 51.833332f, 36.0f, 51.833332f);
                instancePath.cubicTo(39.652023f, 51.833332f, 43.01526f, 50.5969f, 45.693943f, 48.51981f);
                instancePath.close();
                instancePath.moveTo(36.0f, 20.166666f);
                instancePath.cubicTo(32.347977f, 20.166666f, 28.98474f, 21.4031f, 26.306059f, 23.48019f);
                instancePath.lineTo(48.51981f, 45.693943f);
                instancePath.cubicTo(50.5969f, 43.01526f, 51.833332f, 39.652023f, 51.833332f, 36.0f);
                instancePath.cubicTo(51.833332f, 27.255491f, 44.744507f, 20.166666f, 36.0f, 20.166666f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
