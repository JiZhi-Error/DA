package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class detail_circle extends c {
    private final int height = 100;
    private final int width = 100;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 100;
            case 1:
                return 100;
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
                instancePaint3.setColor(-10329502);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(50.0f, 98.0f);
                instancePath.cubicTo(76.50967f, 98.0f, 98.0f, 76.50967f, 98.0f, 50.0f);
                instancePath.cubicTo(98.0f, 23.490332f, 76.50967f, 2.0f, 50.0f, 2.0f);
                instancePath.cubicTo(23.490332f, 2.0f, 2.0f, 23.490332f, 2.0f, 50.0f);
                instancePath.cubicTo(2.0f, 76.50967f, 23.490332f, 98.0f, 50.0f, 98.0f);
                instancePath.close();
                instancePath.moveTo(50.0f, 94.0f);
                instancePath.cubicTo(74.30053f, 94.0f, 94.0f, 74.30053f, 94.0f, 50.0f);
                instancePath.cubicTo(94.0f, 25.69947f, 74.30053f, 6.0f, 50.0f, 6.0f);
                instancePath.cubicTo(25.69947f, 6.0f, 6.0f, 25.69947f, 6.0f, 50.0f);
                instancePath.cubicTo(6.0f, 74.30053f, 25.69947f, 94.0f, 50.0f, 94.0f);
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
