package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatting_status_green_tick extends c {
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
                instancePaint3.setColor(-15679443);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(9.74392f, 16.81017f);
                instancePath.cubicTo(15.2217455f, 11.2271185f, 20.549356f, 5.4915257f, 26.107296f, 0.0f);
                instancePath.cubicTo(26.587982f, 0.4881356f, 27.529327f, 1.4745762f, 28.0f, 1.9728813f);
                instancePath.cubicTo(22.341917f, 8.60339f, 15.872675f, 14.481356f, 10.084406f, 21.0f);
                instancePath.cubicTo(6.679542f, 18.254238f, 3.304721f, 15.477966f, 0.0f, 12.620339f);
                instancePath.lineTo(0.0f, 10.901695f);
                instancePath.cubicTo(0.41058657f, 10.698305f, 1.241774f, 10.301695f, 1.6623749f, 10.098305f);
                instancePath.cubicTo(4.346209f, 12.345762f, 7.030043f, 14.60339f, 9.74392f, 16.81017f);
                instancePath.lineTo(9.74392f, 16.81017f);
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
