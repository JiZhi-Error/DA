package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class actionbar_icon_light_more extends c {
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
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(18.0f, 37.5f);
                instancePath.cubicTo(18.0f, 39.9849f, 15.9849f, 42.0f, 13.5f, 42.0f);
                instancePath.cubicTo(11.0151f, 42.0f, 9.0f, 39.9849f, 9.0f, 37.5f);
                instancePath.cubicTo(9.0f, 35.0142f, 11.0151f, 33.0f, 13.5f, 33.0f);
                instancePath.cubicTo(15.9849f, 33.0f, 18.0f, 35.0142f, 18.0f, 37.5f);
                instancePath.close();
                instancePath.moveTo(34.5f, 33.0f);
                instancePath.cubicTo(36.9849f, 33.0f, 39.0f, 35.0142f, 39.0f, 37.5f);
                instancePath.cubicTo(39.0f, 39.9849f, 36.9849f, 42.0f, 34.5f, 42.0f);
                instancePath.cubicTo(32.0151f, 42.0f, 30.0f, 39.9849f, 30.0f, 37.5f);
                instancePath.cubicTo(30.0f, 35.0142f, 32.0151f, 33.0f, 34.5f, 33.0f);
                instancePath.close();
                instancePath.moveTo(55.5f, 33.0f);
                instancePath.cubicTo(57.9849f, 33.0f, 60.0f, 35.0142f, 60.0f, 37.5f);
                instancePath.cubicTo(60.0f, 39.9849f, 57.9849f, 42.0f, 55.5f, 42.0f);
                instancePath.cubicTo(53.0151f, 42.0f, 51.0f, 39.9849f, 51.0f, 37.5f);
                instancePath.cubicTo(51.0f, 35.0142f, 53.0151f, 33.0f, 55.5f, 33.0f);
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
