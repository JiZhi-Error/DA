package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatting_status_gray_tick extends c {
    private final int height = 21;
    private final int width = 28;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 28;
            case 1:
                return 21;
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
                instancePaint3.setColor(-2763307);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(9.740437f, 16.82034f);
                instancePath.cubicTo(15.206292f, 11.2271185f, 20.54201f, 5.501695f, 26.097961f, 0.0f);
                instancePath.cubicTo(26.568466f, 0.4881356f, 27.519485f, 1.4745762f, 28.0f, 1.9728813f);
                instancePath.cubicTo(22.303898f, 8.583051f, 15.887022f, 14.532204f, 10.040758f, 21.0f);
                instancePath.cubicTo(6.677154f, 18.21356f, 3.283518f, 15.488135f, 0.0f, 12.620339f);
                instancePath.lineTo(0.0f, 10.932203f);
                instancePath.cubicTo(0.41043976f, 10.718644f, 1.2313193f, 10.291526f, 1.641759f, 10.088136f);
                instancePath.cubicTo(4.3346443f, 12.335593f, 7.0275297f, 14.593221f, 9.740437f, 16.82034f);
                instancePath.lineTo(9.740437f, 16.82034f);
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
