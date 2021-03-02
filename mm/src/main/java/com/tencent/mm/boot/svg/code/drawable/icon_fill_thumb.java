package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_fill_thumb extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                instancePath.moveTo(30.978317f, 6.924232f);
                instancePath.cubicTo(32.202652f, 8.727818f, 32.531406f, 10.6306305f, 32.531406f, 14.630878f);
                instancePath.cubicTo(32.531406f, 15.722366f, 32.239555f, 15.994292f, 32.62976f, 16.68274f);
                instancePath.cubicTo(33.4496f, 16.696165f, 37.600334f, 16.97483f, 38.73455f, 17.384256f);
                instancePath.cubicTo(40.143074f, 17.892702f, 41.223366f, 18.710272f, 41.77255f, 19.934034f);
                instancePath.cubicTo(43.73279f, 24.30208f, 41.271797f, 36.09096f, 36.667828f, 39.880844f);
                instancePath.cubicTo(35.286457f, 41.018406f, 32.486027f, 40.87847f, 30.341778f, 41.054058f);
                instancePath.cubicTo(29.332201f, 41.136524f, 25.178223f, 41.148354f, 17.932774f, 41.11556f);
                instancePath.lineTo(17.932419f, 19.555609f);
                instancePath.cubicTo(18.24993f, 19.397259f, 18.60711f, 19.197855f, 19.040604f, 18.943678f);
                instancePath.cubicTo(20.298344f, 18.206264f, 21.039513f, 17.369343f, 21.595888f, 15.898155f);
                instancePath.cubicTo(21.91047f, 15.065036f, 22.017292f, 14.247739f, 22.13168f, 11.8294525f);
                instancePath.cubicTo(22.14685f, 11.50924f, 22.150642f, 11.4084835f, 22.176422f, 10.681596f);
                instancePath.cubicTo(22.293335f, 7.385011f, 22.642885f, 6.2104573f, 24.468605f, 5.3626237f);
                instancePath.cubicTo(26.908642f, 4.229363f, 29.823425f, 5.2225847f, 30.978317f, 6.924232f);
                instancePath.close();
                instancePath.moveTo(15.531559f, 20.245354f);
                instancePath.lineTo(15.532822f, 41.1037f);
                instancePath.cubicTo(13.817529f, 41.09459f, 11.956687f, 41.083508f, 9.950839f, 41.070717f);
                instancePath.cubicTo(8.248931f, 41.060577f, 6.8705883f, 39.693882f, 6.8705883f, 38.00158f);
                instancePath.lineTo(6.8705883f, 23.440556f);
                instancePath.cubicTo(6.8705883f, 21.740942f, 8.264331f, 20.371399f, 9.974019f, 20.371399f);
                instancePath.lineTo(13.723339f, 20.371399f);
                instancePath.cubicTo(14.33067f, 20.371399f, 14.912404f, 20.334341f, 15.531559f, 20.245354f);
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
