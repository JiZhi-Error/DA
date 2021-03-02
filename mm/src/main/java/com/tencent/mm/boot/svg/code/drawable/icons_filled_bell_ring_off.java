package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_bell_ring_off extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(55.3593f, 48.99534f);
                instancePath.lineTo(66.27565f, 59.91169f);
                instancePath.lineTo(63.09367f, 63.09367f);
                instancePath.lineTo(12.18198f, 12.18198f);
                instancePath.lineTo(15.363961f, 9.0f);
                instancePath.lineTo(23.45535f, 17.09139f);
                instancePath.cubicTo(25.319427f, 15.279549f, 27.57462f, 13.867977f, 30.08219f, 12.995409f);
                instancePath.cubicTo(30.028131f, 12.671648f, 30.0f, 12.339109f, 30.0f, 12.0f);
                instancePath.cubicTo(30.0f, 8.686292f, 32.68629f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(39.31371f, 6.0f, 42.0f, 8.686292f, 42.0f, 12.0f);
                instancePath.cubicTo(42.0f, 12.339109f, 41.971867f, 12.671648f, 41.91781f, 12.995409f);
                instancePath.cubicTo(48.951862f, 15.443072f, 54.0f, 22.132008f, 54.0f, 30.0f);
                instancePath.lineTo(54.0f, 42.0f);
                instancePath.cubicTo(54.0f, 44.33178f, 54.4531f, 46.66356f, 55.3593f, 48.99534f);
                instancePath.close();
                instancePath.moveTo(53.636112f, 60.000072f);
                instancePath.lineTo(39.0f, 60.00001f);
                instancePath.lineTo(39.0f, 60.6f);
                instancePath.cubicTo(39.0f, 62.256855f, 37.656853f, 63.6f, 36.0f, 63.6f);
                instancePath.cubicTo(34.343147f, 63.6f, 33.0f, 62.256855f, 33.0f, 60.6f);
                instancePath.lineTo(33.0f, 60.0f);
                instancePath.lineTo(15.560121f, 60.0f);
                instancePath.cubicTo(14.921177f, 60.0f, 14.2989235f, 59.795994f, 13.784002f, 59.4177f);
                instancePath.cubicTo(12.448801f, 58.43678f, 12.161601f, 56.55919f, 13.142524f, 55.223988f);
                instancePath.cubicTo(16.380814f, 50.815952f, 18.0f, 46.407974f, 18.0f, 42.0f);
                instancePath.lineTo(18.0f, 30.0f);
                instancePath.cubicTo(18.0f, 28.284155f, 18.240082f, 26.624384f, 18.688486f, 25.052446f);
                instancePath.lineTo(53.636112f, 60.000072f);
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
