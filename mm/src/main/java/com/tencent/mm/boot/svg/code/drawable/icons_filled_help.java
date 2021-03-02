package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_help extends c {
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
                instancePath.moveTo(36.0f, 66.0f);
                instancePath.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                instancePath.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                instancePath.close();
                instancePath.moveTo(27.0f, 29.34668f);
                instancePath.lineTo(31.819336f, 29.34668f);
                instancePath.cubicTo(31.983398f, 26.80371f, 33.685547f, 25.183594f, 36.331055f, 25.183594f);
                instancePath.cubicTo(38.91504f, 25.183594f, 40.637695f, 26.762695f, 40.637695f, 28.936523f);
                instancePath.cubicTo(40.637695f, 30.966797f, 39.776367f, 32.07422f, 37.2334f, 33.612305f);
                instancePath.cubicTo(34.40332f, 35.273438f, 33.213867f, 37.11914f, 33.398438f, 40.154297f);
                instancePath.lineTo(33.418945f, 41.61035f);
                instancePath.lineTo(38.176758f, 41.61035f);
                instancePath.lineTo(38.176758f, 40.4209f);
                instancePath.cubicTo(38.176758f, 38.370117f, 38.935547f, 37.30371f, 41.62207f, 35.745117f);
                instancePath.cubicTo(44.411133f, 34.083984f, 45.969727f, 31.889648f, 45.969727f, 28.751953f);
                instancePath.cubicTo(45.969727f, 24.240234f, 42.216797f, 21.0f, 36.597656f, 21.0f);
                instancePath.cubicTo(30.506836f, 21.0f, 27.164062f, 24.527344f, 27.0f, 29.34668f);
                instancePath.close();
                instancePath.moveTo(35.859375f, 51.249023f);
                instancePath.cubicTo(37.520508f, 51.249023f, 38.833008f, 49.95703f, 38.833008f, 48.336914f);
                instancePath.cubicTo(38.833008f, 46.716797f, 37.520508f, 45.445312f, 35.859375f, 45.445312f);
                instancePath.cubicTo(34.198242f, 45.445312f, 32.865234f, 46.716797f, 32.865234f, 48.336914f);
                instancePath.cubicTo(32.865234f, 49.95703f, 34.198242f, 51.249023f, 35.859375f, 51.249023f);
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
