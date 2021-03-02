package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_note extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(24.6f, 9.6f);
                instancePath.lineTo(24.6f, 53.42788f);
                instancePath.lineTo(54.0f, 53.42788f);
                instancePath.cubicTo(55.325485f, 53.42788f, 56.4f, 52.353363f, 56.4f, 51.027878f);
                instancePath.lineTo(56.4f, 45.600037f);
                instancePath.lineTo(56.4f, 12.0f);
                instancePath.cubicTo(56.4f, 10.674517f, 55.325485f, 9.6f, 54.0f, 9.6f);
                instancePath.lineTo(24.6f, 9.6f);
                instancePath.close();
                instancePath.moveTo(21.0f, 9.6f);
                instancePath.lineTo(15.6f, 9.6f);
                instancePath.lineTo(15.6f, 53.42788f);
                instancePath.lineTo(21.0f, 53.42788f);
                instancePath.lineTo(21.0f, 9.6f);
                instancePath.close();
                instancePath.moveTo(56.4f, 56.528625f);
                instancePath.cubicTo(55.665047f, 56.84974f, 54.853325f, 57.027878f, 54.0f, 57.027878f);
                instancePath.lineTo(15.6f, 57.027878f);
                instancePath.lineTo(15.6f, 62.4f);
                instancePath.lineTo(54.0f, 62.4f);
                instancePath.cubicTo(55.325485f, 62.4f, 56.4f, 61.325485f, 56.4f, 60.0f);
                instancePath.lineTo(56.4f, 56.528625f);
                instancePath.close();
                instancePath.moveTo(12.0f, 6.0f);
                instancePath.lineTo(54.0f, 6.0f);
                instancePath.cubicTo(57.31371f, 6.0f, 60.0f, 8.686292f, 60.0f, 12.0f);
                instancePath.lineTo(60.0f, 60.0f);
                instancePath.cubicTo(60.0f, 63.31371f, 57.31371f, 66.0f, 54.0f, 66.0f);
                instancePath.lineTo(12.0f, 66.0f);
                instancePath.lineTo(12.0f, 6.0f);
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
