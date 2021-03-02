package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class biz_time_line_item_video_play_icon extends c {
    private final int height = 44;
    private final int width = 44;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 44;
            case 1:
                return 44;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(1711276032);
                instancePaint5.setColor(-855638017);
                instancePaint5.setStrokeWidth(1.0232558f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(21.488373f, 43.488373f);
                instancePath.cubicTo(33.710506f, 43.488373f, 43.488373f, 34.01968f, 43.488373f, 22.511627f);
                instancePath.cubicTo(43.488373f, 10.132299f, 33.8677f, 0.5116279f, 21.488373f, 0.5116279f);
                instancePath.cubicTo(9.980321f, 0.5116279f, 0.5116279f, 10.289494f, 0.5116279f, 22.511627f);
                instancePath.cubicTo(0.5116279f, 33.8677f, 10.132299f, 43.488373f, 21.488373f, 43.488373f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-419430401);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(19.648998f, 14.164668f);
                instancePath2.cubicTo(19.477705f, 14.057058f, 19.279774f, 14.0f, 19.077778f, 14.0f);
                instancePath2.cubicTo(18.482538f, 14.0f, 18.0f, 14.485024f, 18.0f, 15.083333f);
                instancePath2.lineTo(18.0f, 28.931593f);
                instancePath2.cubicTo(18.0f, 29.134632f, 18.056767f, 29.333584f, 18.163824f, 29.505758f);
                instancePath2.cubicTo(18.479301f, 30.013124f, 19.144236f, 30.16736f, 19.648998f, 29.850258f);
                instancePath2.lineTo(30.670794f, 22.926128f);
                instancePath2.cubicTo(30.809578f, 22.838942f, 30.926786f, 22.721128f, 31.013527f, 22.581629f);
                instancePath2.cubicTo(31.329002f, 22.074265f, 31.175556f, 21.405901f, 30.670794f, 21.088799f);
                instancePath2.lineTo(19.648998f, 14.164668f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
