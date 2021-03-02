package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wxpay_mini_program_icon extends c {
    private final int height = 35;
    private final int width = 38;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 38;
            case 1:
                return 35;
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
                instancePaint3.setColor(-9074725);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(25.499968f, 4.0f);
                instancePath.cubicTo(23.846365f, 4.0f, 22.306759f, 4.4393754f, 21.000032f, 5.1871934f);
                instancePath.cubicTo(18.602196f, 6.559061f, 17.000055f, 8.984258f, 17.000055f, 11.750141f);
                instancePath.lineTo(17.000055f, 23.25012f);
                instancePath.cubicTo(17.000055f, 25.32095f, 14.985246f, 26.999956f, 12.500119f, 26.999956f);
                instancePath.cubicTo(10.0146675f, 26.999956f, 7.999859f, 25.32095f, 7.999859f, 23.25012f);
                instancePath.cubicTo(7.999859f, 21.77598f, 9.022897f, 20.504429f, 10.507459f, 19.891453f);
                instancePath.cubicTo(10.61429f, 19.847158f, 10.723075f, 19.805468f, 10.834792f, 19.768337f);
                instancePath.cubicTo(11.768912f, 19.393778f, 12.570472f, 18.689604f, 12.868166f, 17.87176f);
                instancePath.cubicTo(13.307216f, 16.665024f, 12.489371f, 15.686933f, 11.041288f, 15.686933f);
                instancePath.cubicTo(10.680408f, 15.686933f, 10.314642f, 15.74784f, 9.961577f, 15.857927f);
                instancePath.cubicTo(9.9599495f, 15.8582535f, 9.958321f, 15.858905f, 9.956367f, 15.85923f);
                instancePath.cubicTo(7.863063f, 16.460482f, 6.115658f, 17.778608f, 5.066563f, 19.499956f);
                instancePath.cubicTo(4.388772f, 20.612238f, 3.9998806f, 21.889977f, 3.9998806f, 23.25012f);
                instancePath.cubicTo(3.9998806f, 27.523363f, 7.8129044f, 30.999935f, 12.500119f, 30.999935f);
                instancePath.cubicTo(14.153396f, 30.999935f, 15.693002f, 30.56056f, 17.000055f, 29.812742f);
                instancePath.cubicTo(19.397566f, 28.440874f, 21.000032f, 26.015676f, 21.000032f, 23.25012f);
                instancePath.lineTo(21.000032f, 11.750141f);
                instancePath.cubicTo(21.000032f, 9.678986f, 23.014515f, 7.999978f, 25.499968f, 7.999978f);
                instancePath.cubicTo(27.985094f, 7.999978f, 29.999903f, 9.678986f, 29.999903f, 11.750141f);
                instancePath.cubicTo(29.999903f, 13.287141f, 28.890226f, 14.607873f, 27.302092f, 15.186976f);
                instancePath.cubicTo(26.277424f, 15.530269f, 25.437757f, 16.271898f, 25.118242f, 17.150324f);
                instancePath.cubicTo(24.68082f, 18.351849f, 25.49508f, 19.325378f, 26.936651f, 19.325378f);
                instancePath.cubicTo(27.263006f, 19.325378f, 27.592945f, 19.269684f, 27.914415f, 19.17816f);
                instancePath.cubicTo(27.96718f, 19.16383f, 28.018967f, 19.14787f, 28.07108f, 19.132563f);
                instancePath.cubicTo(30.152006f, 18.527729f, 31.888988f, 17.213837f, 32.933197f, 15.499978f);
                instancePath.cubicTo(33.61099f, 14.387697f, 33.99988f, 13.109958f, 33.99988f, 11.750141f);
                instancePath.cubicTo(33.99988f, 7.476571f, 30.186857f, 4.0f, 25.499968f, 4.0f);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
