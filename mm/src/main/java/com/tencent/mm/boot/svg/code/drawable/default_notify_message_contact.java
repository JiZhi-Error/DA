package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class default_notify_message_contact extends c {
    private final int height = 191;
    private final int width = 191;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 191;
            case 1:
                return 191;
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
                instancePaint4.setColor(-1);
                instancePaint5.setColor(-6842473);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(3.5f, 7.5f);
                instancePath.lineTo(178.5f, 7.5f);
                instancePath.lineTo(178.5f, 177.5f);
                instancePath.lineTo(3.5f, 177.5f);
                instancePath.lineTo(3.5f, 7.5f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-686547);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(191.0f, 0.0f);
                instancePath2.lineTo(191.0f, 191.0f);
                instancePath2.lineTo(0.0f, 191.0f);
                instancePath2.lineTo(0.0f, 0.0f);
                instancePath2.lineTo(191.0f, 0.0f);
                instancePath2.close();
                instancePath2.moveTo(143.50204f, 51.92406f);
                instancePath2.lineTo(55.177776f, 79.67322f);
                instancePath2.lineTo(55.177776f, 108.65085f);
                instancePath2.lineTo(71.7024f, 113.94841f);
                instancePath2.lineTo(70.50466f, 117.91833f);
                instancePath2.cubicTo(68.771225f, 123.66382f, 71.968994f, 129.74753f, 77.638115f, 131.50388f);
                instancePath2.lineTo(96.88131f, 137.46565f);
                instancePath2.cubicTo(102.55444f, 139.22325f, 108.55855f, 135.99077f, 110.29208f, 130.24493f);
                instancePath2.lineTo(111.371895f, 126.665886f);
                instancePath2.lineTo(143.50204f, 136.96637f);
                instancePath2.cubicTo(146.29303f, 137.86111f, 148.55556f, 136.22597f, 148.55556f, 133.26476f);
                instancePath2.lineTo(148.55556f, 55.65808f);
                instancePath2.cubicTo(148.55556f, 52.718987f, 146.2936f, 51.04703f, 143.50204f, 51.92406f);
                instancePath2.close();
                instancePath2.moveTo(77.58325f, 115.833725f);
                instancePath2.lineTo(105.589226f, 124.81204f);
                instancePath2.lineTo(104.67921f, 127.869804f);
                instancePath2.cubicTo(103.85574f, 130.63673f, 101.00234f, 132.19417f, 98.304535f, 131.34686f);
                instancePath2.lineTo(80.01574f, 125.60284f);
                instancePath2.cubicTo(77.32027f, 124.756256f, 75.80068f, 121.823364f, 76.6236f, 119.05828f);
                instancePath2.lineTo(77.58325f, 115.833725f);
                instancePath2.close();
                instancePath2.moveTo(42.444443f, 80.42022f);
                instancePath2.lineTo(42.444443f, 108.45738f);
                instancePath2.cubicTo(42.444443f, 111.37789f, 44.49037f, 112.57163f, 47.03692f, 111.11062f);
                instancePath2.lineTo(53.055557f, 107.65758f);
                instancePath2.lineTo(53.055557f, 81.22003f);
                instancePath2.lineTo(47.03692f, 77.76699f);
                instancePath2.cubicTo(44.500565f, 76.31182f, 42.444443f, 77.51847f, 42.444443f, 80.42022f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
