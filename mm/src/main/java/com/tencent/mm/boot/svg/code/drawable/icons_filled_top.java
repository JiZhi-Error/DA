package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_top extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.778174f, 7.2928934f);
                instancePath.lineTo(18.849243f, 13.363961f);
                instancePath.cubicTo(19.239767f, 13.754485f, 19.239767f, 14.3876505f, 18.849243f, 14.778174f);
                instancePath.cubicTo(18.661707f, 14.965711f, 18.407352f, 15.071068f, 18.142136f, 15.071068f);
                instancePath.lineTo(16.071f, 15.071f);
                instancePath.lineTo(16.071068f, 21.0f);
                instancePath.cubicTo(16.071068f, 21.552284f, 15.623353f, 22.0f, 15.071068f, 22.0f);
                instancePath.lineTo(9.071068f, 22.0f);
                instancePath.cubicTo(8.518783f, 22.0f, 8.071068f, 21.552284f, 8.071068f, 21.0f);
                instancePath.lineTo(8.071f, 15.071f);
                instancePath.lineTo(6.0f, 15.071068f);
                instancePath.cubicTo(5.4477153f, 15.071068f, 5.0f, 14.623353f, 5.0f, 14.071068f);
                instancePath.cubicTo(5.0f, 13.805851f, 5.1053567f, 13.551497f, 5.2928934f, 13.363961f);
                instancePath.lineTo(11.363961f, 7.2928934f);
                instancePath.cubicTo(11.754485f, 6.902369f, 12.3876505f, 6.902369f, 12.778174f, 7.2928934f);
                instancePath.close();
                instancePath.moveTo(20.0f, 3.0f);
                instancePath.lineTo(20.0f, 5.0f);
                instancePath.lineTo(4.0f, 5.0f);
                instancePath.lineTo(4.0f, 3.0f);
                instancePath.lineTo(20.0f, 3.0f);
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
