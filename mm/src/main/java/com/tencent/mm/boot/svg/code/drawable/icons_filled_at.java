package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_at extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(34.39453f, 27.433594f);
                instancePath.cubicTo(30.667969f, 27.433594f, 28.453125f, 30.492188f, 28.453125f, 35.625f);
                instancePath.cubicTo(28.453125f, 40.722656f, 30.667969f, 43.816406f, 34.359375f, 43.816406f);
                instancePath.cubicTo(38.15625f, 43.816406f, 40.51172f, 40.6875f, 40.51172f, 35.625f);
                instancePath.cubicTo(40.51172f, 30.5625f, 38.15625f, 27.433594f, 34.39453f, 27.433594f);
                instancePath.close();
                instancePath.moveTo(35.554688f, 6.0585938f);
                instancePath.cubicTo(52.21875f, 6.0585938f, 63.92578f, 16.535156f, 63.92578f, 32.179688f);
                instancePath.cubicTo(63.92578f, 43.253906f, 58.6875f, 50.390625f, 50.109375f, 50.390625f);
                instancePath.cubicTo(45.75f, 50.390625f, 42.410156f, 48.28125f, 41.63672f, 44.871094f);
                instancePath.lineTo(41.14453f, 44.871094f);
                instancePath.cubicTo(39.703125f, 48.38672f, 36.75f, 50.285156f, 32.671875f, 50.285156f);
                instancePath.cubicTo(25.359375f, 50.285156f, 20.472656f, 44.34375f, 20.472656f, 35.414062f);
                instancePath.cubicTo(20.472656f, 26.871094f, 25.289062f, 21.035156f, 32.320312f, 21.035156f);
                instancePath.cubicTo(36.117188f, 21.035156f, 39.28125f, 22.933594f, 40.652344f, 26.027344f);
                instancePath.lineTo(41.14453f, 26.027344f);
                instancePath.lineTo(41.14453f, 21.808594f);
                instancePath.lineTo(48.28125f, 21.808594f);
                instancePath.lineTo(48.28125f, 40.617188f);
                instancePath.cubicTo(48.28125f, 43.04297f, 49.40625f, 44.589844f, 51.621094f, 44.589844f);
                instancePath.cubicTo(55.066406f, 44.589844f, 57.45703f, 40.195312f, 57.45703f, 32.70703f);
                instancePath.cubicTo(57.45703f, 19.910156f, 48.632812f, 11.6484375f, 35.308594f, 11.6484375f);
                instancePath.cubicTo(21.773438f, 11.6484375f, 12.28125f, 21.421875f, 12.28125f, 35.554688f);
                instancePath.cubicTo(12.28125f, 50.35547f, 22.160156f, 59.003906f, 36.64453f, 59.003906f);
                instancePath.cubicTo(40.40625f, 59.003906f, 44.23828f, 58.51172f, 46.242188f, 57.773438f);
                instancePath.lineTo(46.242188f, 63.398438f);
                instancePath.cubicTo(43.5f, 64.20703f, 39.914062f, 64.69922f, 36.117188f, 64.69922f);
                instancePath.cubicTo(18.328125f, 64.69922f, 5.8125f, 53.554688f, 5.8125f, 35.378906f);
                instancePath.cubicTo(5.8125f, 17.941406f, 18.011719f, 6.0585938f, 35.554688f, 6.0585938f);
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
