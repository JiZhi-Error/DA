package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class menu_logout_multi extends c {
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
                instancePaint3.setColor(-8617851);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(58.944443f, 58.17809f);
                instancePath.lineTo(58.944443f, 57.333332f);
                instancePath.cubicTo(58.944443f, 56.21663f, 57.851852f, 55.137257f, 57.923233f, 55.137257f);
                instancePath.cubicTo(54.02851f, 51.314743f, 51.494057f, 45.915337f, 51.494057f, 37.300488f);
                instancePath.cubicTo(51.48578f, 27.372776f, 56.851036f, 20.0f, 65.5f, 20.0f);
                instancePath.cubicTo(74.148964f, 20.0f, 79.52899f, 27.370667f, 79.53726f, 37.300488f);
                instancePath.cubicTo(79.54445f, 45.9168f, 76.98692f, 51.330833f, 73.14815f, 55.137257f);
                instancePath.cubicTo(73.14815f, 55.137257f, 72.05556f, 56.21663f, 72.05556f, 57.333332f);
                instancePath.lineTo(72.05556f, 58.431374f);
                instancePath.cubicTo(72.05556f, 59.335876f, 72.7224f, 59.935307f, 73.88674f, 60.627453f);
                instancePath.cubicTo(75.05109f, 61.319595f, 85.62963f, 66.500496f, 85.62963f, 66.500496f);
                instancePath.cubicTo(88.17391f, 67.40601f, 90.0f, 69.83854f, 90.0f, 72.70588f);
                instancePath.lineTo(90.0f, 76.0f);
                instancePath.lineTo(62.587566f, 76.0f);
                instancePath.cubicTo(62.587566f, 76.78842f, 62.587566f, 75.32884f, 62.587566f, 72.70669f);
                instancePath.cubicTo(62.587566f, 69.52989f, 61.461308f, 66.85559f, 59.701096f, 64.777214f);
                instancePath.cubicTo(59.696297f, 64.76989f, 59.691f, 64.76228f, 59.68521f, 64.75441f);
                instancePath.cubicTo(59.225693f, 64.12954f, 58.979626f, 63.455254f, 58.947006f, 62.731556f);
                instancePath.lineTo(58.947006f, 58.176933f);
                instancePath.lineTo(58.944443f, 58.17809f);
                instancePath.close();
                instancePath.moveTo(38.88674f, 60.627453f);
                instancePath.cubicTo(40.051086f, 61.319595f, 47.968254f, 65.0638f, 50.62963f, 66.500496f);
                instancePath.cubicTo(53.291004f, 67.937195f, 55.0f, 69.83854f, 55.0f, 72.70588f);
                instancePath.lineTo(55.0f, 76.0f);
                instancePath.lineTo(6.0f, 76.0f);
                instancePath.lineTo(6.0f, 72.70588f);
                instancePath.cubicTo(6.0f, 69.83854f, 8.610812f, 67.51598f, 10.370371f, 66.48366f);
                instancePath.cubicTo(12.129929f, 65.45134f, 16.263937f, 63.62631f, 22.113258f, 60.627453f);
                instancePath.cubicTo(22.749458f, 60.29427f, 23.944445f, 59.65627f, 23.944445f, 58.431374f);
                instancePath.lineTo(23.944445f, 57.333332f);
                instancePath.cubicTo(23.944445f, 56.21663f, 22.851852f, 55.137257f, 22.923235f, 55.137257f);
                instancePath.cubicTo(19.02851f, 51.314743f, 16.494055f, 45.915337f, 16.494055f, 37.300488f);
                instancePath.cubicTo(16.485779f, 27.372776f, 21.851036f, 20.0f, 30.5f, 20.0f);
                instancePath.cubicTo(39.148964f, 20.0f, 44.528988f, 27.370667f, 44.537266f, 37.300488f);
                instancePath.cubicTo(44.54445f, 45.9168f, 41.986927f, 51.330833f, 38.148148f, 55.137257f);
                instancePath.cubicTo(38.148148f, 55.137257f, 37.055557f, 56.21663f, 37.055557f, 57.333332f);
                instancePath.lineTo(37.055557f, 58.431374f);
                instancePath.cubicTo(37.055557f, 59.625034f, 37.722397f, 59.935307f, 38.88674f, 60.627453f);
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
