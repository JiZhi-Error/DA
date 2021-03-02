package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class multitalk_pickup_press extends c {
    private final int height = 210;
    private final int width = 210;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 210;
            case 1:
                return 210;
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
                instancePaint3.setColor(-13327053);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(105.0f, 0.0f);
                instancePath.cubicTo(162.9899f, 0.0f, 210.0f, 47.010098f, 210.0f, 105.0f);
                instancePath.cubicTo(210.0f, 162.9899f, 162.9899f, 210.0f, 105.0f, 210.0f);
                instancePath.cubicTo(47.010098f, 210.0f, 0.0f, 162.9899f, 0.0f, 105.0f);
                instancePath.cubicTo(0.0f, 47.010098f, 47.010098f, 0.0f, 105.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(1275068416);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(105.0f, 0.0f);
                instancePath2.cubicTo(162.9899f, 0.0f, 210.0f, 47.010098f, 210.0f, 105.0f);
                instancePath2.cubicTo(210.0f, 162.9899f, 162.9899f, 210.0f, 105.0f, 210.0f);
                instancePath2.cubicTo(47.010098f, 210.0f, 0.0f, 162.9899f, 0.0f, 105.0f);
                instancePath2.cubicTo(0.0f, 47.010098f, 47.010098f, 0.0f, 105.0f, 0.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(96.494316f, 113.505684f);
                instancePath3.cubicTo(104.60257f, 121.61394f, 112.285225f, 125.41699f, 115.126305f, 125.19428f);
                instancePath3.cubicTo(117.967384f, 124.97158f, 125.04247f, 120.106026f, 128.38249f, 120.17079f);
                instancePath3.cubicTo(129.98773f, 120.20192f, 140.47748f, 127.296135f, 141.74727f, 128.11635f);
                instancePath3.cubicTo(143.01704f, 128.93655f, 144.19443f, 129.89465f, 143.97304f, 131.10704f);
                instancePath3.cubicTo(143.75165f, 132.31943f, 139.14153f, 145.67386f, 127.37189f, 143.82458f);
                instancePath3.cubicTo(115.60224f, 141.9753f, 99.19372f, 129.28743f, 89.84374f, 120.15626f);
                instancePath3.lineTo(96.494316f, 113.505684f);
                instancePath3.lineTo(96.494316f, 113.505684f);
                instancePath3.close();
                instancePath3.moveTo(96.494316f, 113.505684f);
                instancePath3.cubicTo(88.38606f, 105.39743f, 84.58301f, 97.714775f, 84.80572f, 94.873695f);
                instancePath3.cubicTo(85.02842f, 92.03261f, 89.893974f, 84.95753f, 89.82921f, 81.617516f);
                instancePath3.cubicTo(89.79808f, 80.01227f, 82.703865f, 69.52252f, 81.88366f, 68.25274f);
                instancePath3.cubicTo(81.063446f, 66.98295f, 80.10535f, 65.80558f, 78.89296f, 66.02696f);
                instancePath3.cubicTo(77.680565f, 66.24835f, 64.32614f, 70.858475f, 66.17542f, 82.62811f);
                instancePath3.cubicTo(68.024704f, 94.39776f, 80.71257f, 110.80628f, 89.84374f, 120.15626f);
                instancePath3.lineTo(96.494316f, 113.505684f);
                instancePath3.lineTo(96.494316f, 113.505684f);
                instancePath3.close();
                canvas.saveLayerAlpha(null, 179, 31);
                Paint instancePaint8 = c.instancePaint(instancePaint7, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint8);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
