package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_feed_retransmission extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                instancePath.moveTo(4.8440943f, 7.672352f);
                instancePath.lineTo(6.25884f, 9.086903f);
                instancePath.cubicTo(5.48387f, 9.816408f, 5.0f, 10.851697f, 5.0f, 12.0f);
                instancePath.cubicTo(5.0f, 14.209139f, 6.790861f, 16.0f, 9.0f, 16.0f);
                instancePath.lineTo(13.447f, 15.998f);
                instancePath.lineTo(11.642458f, 14.333333f);
                instancePath.lineTo(13.0876665f, 13.0f);
                instancePath.lineTo(16.700687f, 16.333334f);
                instancePath.cubicTo(17.099771f, 16.701523f, 17.099771f, 17.298477f, 16.700687f, 17.666666f);
                instancePath.lineTo(13.0876665f, 21.0f);
                instancePath.lineTo(11.642458f, 19.666666f);
                instancePath.lineTo(13.447f, 18.0f);
                instancePath.lineTo(9.0f, 18.0f);
                instancePath.cubicTo(5.6862917f, 18.0f, 3.0f, 15.313708f, 3.0f, 12.0f);
                instancePath.cubicTo(3.0f, 10.299465f, 3.70745f, 8.764164f, 4.8440943f, 7.672352f);
                instancePath.close();
                instancePath.moveTo(12.357542f, 9.666667f);
                instancePath.lineTo(10.9123335f, 11.0f);
                instancePath.lineTo(7.2993126f, 7.6666665f);
                instancePath.cubicTo(6.900229f, 7.2984767f, 6.900229f, 6.7015233f, 7.2993126f, 6.3333335f);
                instancePath.lineTo(10.9123335f, 3.0f);
                instancePath.lineTo(12.357542f, 4.3333335f);
                instancePath.lineTo(10.551f, 6.0f);
                instancePath.lineTo(15.0f, 6.0f);
                instancePath.cubicTo(18.31371f, 6.0f, 21.0f, 8.686292f, 21.0f, 12.0f);
                instancePath.cubicTo(21.0f, 13.700535f, 20.292551f, 15.235836f, 19.155907f, 16.327648f);
                instancePath.lineTo(17.74116f, 14.913096f);
                instancePath.cubicTo(18.51613f, 14.183592f, 19.0f, 13.148303f, 19.0f, 12.0f);
                instancePath.cubicTo(19.0f, 9.790861f, 17.209139f, 8.0f, 15.0f, 8.0f);
                instancePath.lineTo(10.552f, 8.0f);
                instancePath.lineTo(12.357542f, 9.666667f);
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
