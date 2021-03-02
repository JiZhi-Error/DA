package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_twitter extends c {
    private final int height = 144;
    private final int width = 144;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                instancePaint3.setColor(-9276814);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(136.0f, 32.3276f);
                instancePath.cubicTo(131.26967f, 34.436882f, 126.21149f, 35.84307f, 120.919136f, 36.452423f);
                instancePath.cubicTo(126.352f, 33.218185f, 130.52031f, 28.062155f, 132.48738f, 21.921793f);
                instancePath.cubicTo(127.4292f, 24.921665f, 121.809f, 27.124695f, 115.814125f, 28.29652f);
                instancePath.cubicTo(111.03696f, 23.187365f, 104.19905f, 20.0f, 96.658615f, 20.0f);
                instancePath.cubicTo(82.13977f, 20.0f, 70.38419f, 31.765121f, 70.38419f, 46.29575f);
                instancePath.cubicTo(70.38419f, 48.358162f, 70.61837f, 50.3737f, 71.086716f, 52.295494f);
                instancePath.cubicTo(49.261616f, 51.217415f, 29.91877f, 40.717865f, 16.94548f, 24.827919f);
                instancePath.cubicTo(14.697402f, 28.718376f, 13.386023f, 33.218185f, 13.386023f, 38.046104f);
                instancePath.cubicTo(13.386023f, 47.186337f, 18.022686f, 55.20162f, 25.094769f, 59.93579f);
                instancePath.cubicTo(20.78595f, 59.795174f, 16.75814f, 58.62335f, 13.198683f, 56.654682f);
                instancePath.lineTo(13.198683f, 56.98279f);
                instancePath.cubicTo(13.198683f, 69.73225f, 22.237833f, 80.32555f, 34.274426f, 82.76294f);
                instancePath.cubicTo(32.07318f, 83.37229f, 29.73143f, 83.7004f, 27.342846f, 83.7004f);
                instancePath.cubicTo(25.656788f, 83.7004f, 24.017563f, 83.51291f, 22.378338f, 83.231674f);
                instancePath.cubicTo(25.703623f, 93.68435f, 35.445297f, 101.27777f, 46.91987f, 101.51214f);
                instancePath.cubicTo(37.92755f, 108.54309f, 26.593487f, 112.76166f, 14.2758875f, 112.76166f);
                instancePath.cubicTo(12.168313f, 112.76166f, 10.0607395f, 112.62104f, 8.0f, 112.38667f);
                instancePath.cubicTo(19.615074f, 119.83948f, 33.431393f, 124.19867f, 48.278084f, 124.19867f);
                instancePath.cubicTo(96.61178f, 124.19867f, 123.02671f, 84.12226f, 123.02671f, 49.389366f);
                instancePath.cubicTo(123.02671f, 48.264416f, 122.97987f, 47.09259f, 122.933044f, 45.96764f);
                instancePath.cubicTo(128.03806f, 42.26467f, 132.48738f, 37.624245f, 136.0f, 32.3276f);
                instancePath.lineTo(136.0f, 32.3276f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
