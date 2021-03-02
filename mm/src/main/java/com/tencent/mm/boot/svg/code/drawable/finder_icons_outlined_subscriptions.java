package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_icons_outlined_subscriptions extends c {
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
                instancePath.moveTo(4.0f, 3.0f);
                instancePath.cubicTo(4.0f, 2.4477153f, 4.4477153f, 2.0f, 5.0f, 2.0f);
                instancePath.lineTo(19.0f, 2.0f);
                instancePath.cubicTo(19.552284f, 2.0f, 20.0f, 2.4477153f, 20.0f, 3.0f);
                instancePath.lineTo(20.0f, 21.0f);
                instancePath.cubicTo(20.0f, 21.552284f, 19.552284f, 22.0f, 19.0f, 22.0f);
                instancePath.lineTo(5.0f, 22.0f);
                instancePath.cubicTo(4.4477153f, 22.0f, 4.0f, 21.552284f, 4.0f, 21.0f);
                instancePath.lineTo(4.0f, 3.0f);
                instancePath.close();
                instancePath.moveTo(5.2f, 3.2f);
                instancePath.lineTo(5.2f, 20.8f);
                instancePath.lineTo(18.8f, 20.8f);
                instancePath.lineTo(18.8f, 3.2f);
                instancePath.lineTo(5.2f, 3.2f);
                instancePath.close();
                instancePath.moveTo(8.5f, 8.0f);
                instancePath.cubicTo(7.6715727f, 8.0f, 7.0f, 7.3284273f, 7.0f, 6.5f);
                instancePath.cubicTo(7.0f, 5.6715727f, 7.6715727f, 5.0f, 8.5f, 5.0f);
                instancePath.cubicTo(9.328427f, 5.0f, 10.0f, 5.6715727f, 10.0f, 6.5f);
                instancePath.cubicTo(10.0f, 7.3284273f, 9.328427f, 8.0f, 8.5f, 8.0f);
                instancePath.close();
                instancePath.moveTo(7.0f, 10.0f);
                instancePath.lineTo(14.5f, 10.0f);
                instancePath.lineTo(14.5f, 11.2f);
                instancePath.lineTo(7.0f, 11.2f);
                instancePath.lineTo(7.0f, 10.0f);
                instancePath.close();
                instancePath.moveTo(7.0f, 13.0f);
                instancePath.lineTo(11.0f, 13.0f);
                instancePath.lineTo(11.0f, 14.2f);
                instancePath.lineTo(7.0f, 14.2f);
                instancePath.lineTo(7.0f, 13.0f);
                instancePath.close();
                instancePath.moveTo(7.0f, 16.0f);
                instancePath.lineTo(11.0f, 16.0f);
                instancePath.lineTo(11.0f, 17.2f);
                instancePath.lineTo(7.0f, 17.2f);
                instancePath.lineTo(7.0f, 16.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
