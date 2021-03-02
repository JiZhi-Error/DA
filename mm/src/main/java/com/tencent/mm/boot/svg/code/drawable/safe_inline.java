package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class safe_inline extends c {
    private final int height = 192;
    private final int width = 192;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                instancePaint3.setColor(-16268960);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(96.0f, 20.0f);
                instancePath.lineTo(160.0f, 44.0f);
                instancePath.lineTo(160.0f, 90.03031f);
                instancePath.cubicTo(160.0f, 128.80115f, 133.61324f, 162.5967f, 96.0f, 172.0f);
                instancePath.cubicTo(58.38676f, 162.5967f, 32.0f, 128.80115f, 32.0f, 90.03031f);
                instancePath.lineTo(32.0f, 44.0f);
                instancePath.lineTo(96.0f, 20.0f);
                instancePath.close();
                instancePath.moveTo(96.0f, 29.895454f);
                instancePath.lineTo(41.6f, 51.495453f);
                instancePath.lineTo(41.6f, 90.03031f);
                instancePath.cubicTo(41.6f, 123.590324f, 63.904877f, 152.94469f, 96.0f, 162.06497f);
                instancePath.cubicTo(128.09512f, 152.94469f, 150.4f, 123.590324f, 150.4f, 90.03031f);
                instancePath.lineTo(150.40198f, 82.61466f);
                instancePath.cubicTo(124.16823f, 96.81519f, 82.631294f, 119.29995f, 82.631294f, 119.29995f);
                instancePath.lineTo(82.153336f, 119.55992f);
                instancePath.cubicTo(81.563126f, 119.83688f, 80.8987f, 120.0f, 80.194435f, 120.0f);
                instancePath.cubicTo(78.5596f, 120.0f, 77.1384f, 119.15552f, 76.392494f, 117.90834f);
                instancePath.lineTo(76.10826f, 117.32383f);
                instancePath.lineTo(64.2082f, 92.81863f);
                instancePath.cubicTo(64.07966f, 92.551865f, 64.0f, 92.24941f, 64.0f, 91.95546f);
                instancePath.cubicTo(64.0f, 90.82722f, 64.97583f, 89.91308f, 66.17796f, 89.91308f);
                instancePath.cubicTo(66.67041f, 89.91308f, 67.117584f, 90.0643f, 67.4833f, 90.319176f);
                instancePath.lineTo(81.5233f, 99.7002f);
                instancePath.cubicTo(82.5462f, 100.32889f, 83.77549f, 100.69931f, 85.0935f, 100.69931f);
                instancePath.cubicTo(85.87742f, 100.69931f, 86.62875f, 100.56338f, 87.325775f, 100.32379f);
                instancePath.cubicTo(87.325775f, 100.32379f, 132.81949f, 81.36785f, 150.40198f, 74.056114f);
                instancePath.lineTo(150.4f, 51.495453f);
                instancePath.lineTo(96.0f, 29.895454f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
