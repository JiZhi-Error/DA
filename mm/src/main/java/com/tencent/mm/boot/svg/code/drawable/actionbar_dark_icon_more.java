package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class actionbar_dark_icon_more extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-8617594);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(48.0f, 30.0f);
                instancePath.cubicTo(45.238575f, 30.0f, 43.0f, 27.761423f, 43.0f, 25.0f);
                instancePath.cubicTo(43.0f, 22.238577f, 45.238575f, 20.0f, 48.0f, 20.0f);
                instancePath.cubicTo(50.761425f, 20.0f, 53.0f, 22.238577f, 53.0f, 25.0f);
                instancePath.cubicTo(53.0f, 27.761423f, 50.761425f, 30.0f, 48.0f, 30.0f);
                instancePath.close();
                instancePath.moveTo(48.0f, 53.0f);
                instancePath.cubicTo(45.238575f, 53.0f, 43.0f, 50.761425f, 43.0f, 48.0f);
                instancePath.cubicTo(43.0f, 45.238575f, 45.238575f, 43.0f, 48.0f, 43.0f);
                instancePath.cubicTo(50.761425f, 43.0f, 53.0f, 45.238575f, 53.0f, 48.0f);
                instancePath.cubicTo(53.0f, 50.761425f, 50.761425f, 53.0f, 48.0f, 53.0f);
                instancePath.close();
                instancePath.moveTo(48.0f, 76.0f);
                instancePath.cubicTo(45.238575f, 76.0f, 43.0f, 73.76142f, 43.0f, 71.0f);
                instancePath.cubicTo(43.0f, 68.23858f, 45.238575f, 66.0f, 48.0f, 66.0f);
                instancePath.cubicTo(50.761425f, 66.0f, 53.0f, 68.23858f, 53.0f, 71.0f);
                instancePath.cubicTo(53.0f, 73.76142f, 50.761425f, 76.0f, 48.0f, 76.0f);
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
