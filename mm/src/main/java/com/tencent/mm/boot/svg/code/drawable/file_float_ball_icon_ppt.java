package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class file_float_ball_icon_ppt extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                instancePaint3.setColor(-892609);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(48.0f, 0.0f);
                instancePath.lineTo(48.0f, 48.0f);
                instancePath.lineTo(0.0f, 48.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(19.751953f, 16.089844f);
                instancePath2.lineTo(26.326172f, 16.089844f);
                instancePath2.cubicTo(29.689453f, 16.089844f, 32.021484f, 18.375f, 32.021484f, 21.75f);
                instancePath2.cubicTo(32.021484f, 25.125f, 29.61914f, 27.410156f, 26.197266f, 27.410156f);
                instancePath2.lineTo(22.77539f, 27.410156f);
                instancePath2.lineTo(22.77539f, 33.0f);
                instancePath2.lineTo(19.751953f, 33.0f);
                instancePath2.lineTo(19.751953f, 16.089844f);
                instancePath2.close();
                instancePath2.moveTo(22.77539f, 18.5625f);
                instancePath2.lineTo(22.77539f, 24.972656f);
                instancePath2.lineTo(25.517578f, 24.972656f);
                instancePath2.cubicTo(27.685547f, 24.972656f, 28.951172f, 23.800781f, 28.951172f, 21.75f);
                instancePath2.cubicTo(28.951172f, 19.722656f, 27.697266f, 18.5625f, 25.529297f, 18.5625f);
                instancePath2.lineTo(22.77539f, 18.5625f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
