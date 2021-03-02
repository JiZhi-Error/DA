package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class safe extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-16268960);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(160.0f, 72.39648f);
                instancePath.cubicTo(137.05844f, 81.9421f, 91.2134f, 101.044426f, 91.2134f, 101.044426f);
                instancePath.cubicTo(90.400215f, 101.32394f, 89.52366f, 101.48253f, 88.60908f, 101.48253f);
                instancePath.cubicTo(87.07141f, 101.48253f, 85.63724f, 101.05037f, 84.44385f, 100.3169f);
                instancePath.lineTo(68.06384f, 89.37237f);
                instancePath.cubicTo(67.637184f, 89.07502f, 67.11547f, 88.89859f, 66.54096f, 88.89859f);
                instancePath.cubicTo(65.138466f, 88.89859f, 64.0f, 89.96509f, 64.0f, 91.28137f);
                instancePath.cubicTo(64.0f, 91.62431f, 64.09293f, 91.97717f, 64.242905f, 92.2884f);
                instancePath.lineTo(78.1263f, 120.87781f);
                instancePath.lineTo(78.45792f, 121.55973f);
                instancePath.cubicTo(79.32813f, 123.01477f, 80.9862f, 124.0f, 82.8935f, 124.0f);
                instancePath.cubicTo(83.71514f, 124.0f, 84.49032f, 123.80969f, 85.17889f, 123.48657f);
                instancePath.lineTo(85.7365f, 123.18327f);
                instancePath.lineTo(160.0f, 82.98299f);
                instancePath.lineTo(160.0f, 90.03031f);
                instancePath.cubicTo(160.0f, 128.80115f, 133.61324f, 162.5967f, 96.0f, 172.0f);
                instancePath.cubicTo(58.38676f, 162.5967f, 32.0f, 128.80115f, 32.0f, 90.03031f);
                instancePath.lineTo(32.0f, 44.0f);
                instancePath.lineTo(96.0f, 20.0f);
                instancePath.lineTo(160.0f, 44.0f);
                instancePath.lineTo(160.0f, 72.39648f);
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
