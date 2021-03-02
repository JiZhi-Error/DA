package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class find_more_emji extends c {
    private final int height = 108;
    private final int width = 108;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                instancePaint3.setColor(-13824);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(21.0f, 54.0f);
                instancePath.cubicTo(21.0f, 72.226f, 35.773f, 87.0f, 53.999f, 87.0f);
                instancePath.cubicTo(72.225f, 87.0f, 87.0f, 72.226f, 87.0f, 54.0f);
                instancePath.cubicTo(87.0f, 35.774f, 72.225f, 21.0f, 53.999f, 21.0f);
                instancePath.cubicTo(35.773f, 21.0f, 21.0f, 35.774f, 21.0f, 54.0f);
                instancePath.close();
                instancePath.moveTo(68.0f, 37.0f);
                instancePath.cubicTo(70.762f, 37.0f, 73.0f, 39.462f, 73.0f, 42.5f);
                instancePath.cubicTo(73.0f, 45.538f, 70.762f, 48.0f, 68.0f, 48.0f);
                instancePath.cubicTo(65.238f, 48.0f, 63.0f, 45.538f, 63.0f, 42.5f);
                instancePath.cubicTo(63.0f, 39.462f, 65.238f, 37.0f, 68.0f, 37.0f);
                instancePath.lineTo(68.0f, 37.0f);
                instancePath.close();
                instancePath.moveTo(41.0f, 37.0f);
                instancePath.cubicTo(43.762f, 37.0f, 46.0f, 39.462f, 46.0f, 42.5f);
                instancePath.cubicTo(46.0f, 45.538f, 43.762f, 48.0f, 41.0f, 48.0f);
                instancePath.cubicTo(38.238f, 48.0f, 36.0f, 45.538f, 36.0f, 42.5f);
                instancePath.cubicTo(36.0f, 39.462f, 38.238f, 37.0f, 41.0f, 37.0f);
                instancePath.lineTo(41.0f, 37.0f);
                instancePath.close();
                instancePath.moveTo(54.0f, 77.0f);
                instancePath.cubicTo(34.667f, 77.0f, 32.0f, 59.0f, 32.0f, 59.0f);
                instancePath.cubicTo(32.0f, 59.0f, 46.361f, 57.0f, 54.0f, 57.0f);
                instancePath.cubicTo(61.639f, 57.0f, 76.0f, 59.0f, 76.0f, 59.0f);
                instancePath.cubicTo(76.0f, 59.0f, 73.333f, 77.0f, 54.0f, 77.0f);
                instancePath.lineTo(54.0f, 77.0f);
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
