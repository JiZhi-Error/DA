package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class popvideo_post_selected extends c {
    private final int height = 36;
    private final int width = 36;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 36;
            case 1:
                return 36;
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
                instancePaint3.setColor(-15819547);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(18.0f, 36.0f);
                instancePath.cubicTo(8.058874f, 36.0f, 0.0f, 27.941126f, 0.0f, 18.0f);
                instancePath.cubicTo(0.0f, 8.058874f, 8.058874f, 0.0f, 18.0f, 0.0f);
                instancePath.cubicTo(27.941126f, 0.0f, 36.0f, 8.058874f, 36.0f, 18.0f);
                instancePath.cubicTo(36.0f, 27.941126f, 27.941126f, 36.0f, 18.0f, 36.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(15.882187f, 21.850769f);
                instancePath2.lineTo(25.960957f, 11.772f);
                instancePath2.lineTo(27.873507f, 13.684549f);
                instancePath2.lineTo(17.159441f, 24.394556f);
                instancePath2.cubicTo(16.45635f, 25.097353f, 15.316654f, 25.097116f, 14.613856f, 24.394026f);
                instancePath2.cubicTo(14.613791f, 24.39396f, 14.613726f, 24.393896f, 14.613661f, 24.393831f);
                instancePath2.lineTo(9.0f, 18.775719f);
                instancePath2.lineTo(10.903567f, 16.87215f);
                instancePath2.lineTo(15.882187f, 21.850769f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
