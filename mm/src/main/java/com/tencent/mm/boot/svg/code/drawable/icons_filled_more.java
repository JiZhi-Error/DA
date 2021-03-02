package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_more extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(21.0f, 36.0f);
                instancePath.cubicTo(21.0f, 39.3132f, 18.3132f, 42.0f, 15.0f, 42.0f);
                instancePath.cubicTo(11.6868f, 42.0f, 9.0f, 39.3132f, 9.0f, 36.0f);
                instancePath.cubicTo(9.0f, 32.6856f, 11.6868f, 30.0f, 15.0f, 30.0f);
                instancePath.cubicTo(18.3132f, 30.0f, 21.0f, 32.6856f, 21.0f, 36.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 30.0f);
                instancePath.cubicTo(39.3132f, 30.0f, 42.0f, 32.6856f, 42.0f, 36.0f);
                instancePath.cubicTo(42.0f, 39.3132f, 39.3132f, 42.0f, 36.0f, 42.0f);
                instancePath.cubicTo(32.6868f, 42.0f, 30.0f, 39.3132f, 30.0f, 36.0f);
                instancePath.cubicTo(30.0f, 32.6856f, 32.6868f, 30.0f, 36.0f, 30.0f);
                instancePath.close();
                instancePath.moveTo(57.0f, 30.0f);
                instancePath.cubicTo(60.3132f, 30.0f, 63.0f, 32.6856f, 63.0f, 36.0f);
                instancePath.cubicTo(63.0f, 39.3132f, 60.3132f, 42.0f, 57.0f, 42.0f);
                instancePath.cubicTo(53.6868f, 42.0f, 51.0f, 39.3132f, 51.0f, 36.0f);
                instancePath.cubicTo(51.0f, 32.6856f, 53.6868f, 30.0f, 57.0f, 30.0f);
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