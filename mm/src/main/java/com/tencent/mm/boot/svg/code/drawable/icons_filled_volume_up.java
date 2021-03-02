package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_volume_up extends c {
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
                instancePaint3.setColor(-436207616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(11.3f, 4.7f);
                instancePath.cubicTo(11.7f, 4.3f, 12.3f, 4.3f, 12.7f, 4.7f);
                instancePath.cubicTo(12.9f, 4.9f, 13.0f, 5.1f, 13.0f, 5.4f);
                instancePath.lineTo(13.0f, 18.6f);
                instancePath.cubicTo(13.0f, 19.2f, 12.6f, 19.6f, 12.0f, 19.6f);
                instancePath.cubicTo(11.7f, 19.6f, 11.5f, 19.5f, 11.3f, 19.3f);
                instancePath.lineTo(7.5f, 15.5f);
                instancePath.lineTo(3.0f, 15.5f);
                instancePath.cubicTo(2.4f, 15.5f, 2.0f, 15.1f, 2.0f, 14.5f);
                instancePath.lineTo(2.0f, 9.5f);
                instancePath.cubicTo(2.0f, 8.9f, 2.4f, 8.5f, 3.0f, 8.5f);
                instancePath.lineTo(7.5f, 8.5f);
                instancePath.lineTo(11.3f, 4.7f);
                instancePath.close();
                instancePath.moveTo(18.2f, 17.9f);
                instancePath.lineTo(17.1f, 16.8f);
                instancePath.lineTo(17.2f, 16.7f);
                instancePath.cubicTo(18.5f, 15.4f, 19.1f, 13.8f, 19.1f, 12.0f);
                instancePath.cubicTo(19.1f, 10.2f, 18.4f, 8.6f, 17.2f, 7.3f);
                instancePath.lineTo(17.1f, 7.2f);
                instancePath.lineTo(18.2f, 6.1f);
                instancePath.lineTo(18.3f, 6.2f);
                instancePath.cubicTo(19.8f, 7.7f, 20.7f, 9.8f, 20.7f, 12.0f);
                instancePath.cubicTo(20.7f, 14.2f, 19.9f, 16.2f, 18.3f, 17.8f);
                instancePath.lineTo(18.2f, 17.9f);
                instancePath.close();
                instancePath.moveTo(16.2f, 15.9f);
                instancePath.lineTo(15.1f, 14.8f);
                instancePath.lineTo(15.2f, 14.7f);
                instancePath.cubicTo(15.9f, 14.0f, 16.3f, 13.0f, 16.3f, 12.0f);
                instancePath.cubicTo(16.3f, 11.0f, 15.9f, 10.0f, 15.2f, 9.3f);
                instancePath.lineTo(15.1f, 9.2f);
                instancePath.lineTo(16.2f, 8.1f);
                instancePath.lineTo(16.3f, 8.2f);
                instancePath.cubicTo(17.3f, 9.2f, 17.9f, 10.6f, 17.9f, 12.0f);
                instancePath.cubicTo(17.9f, 13.4f, 17.3f, 14.8f, 16.3f, 15.8f);
                instancePath.lineTo(16.2f, 15.9f);
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
