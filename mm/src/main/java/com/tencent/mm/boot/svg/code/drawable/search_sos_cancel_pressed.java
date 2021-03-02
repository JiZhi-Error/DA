package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class search_sos_cancel_pressed extends c {
    private final int height = 144;
    private final int width = 144;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                instancePaint3.setColor(-1710619);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(144.0f, 0.0f);
                instancePath.lineTo(144.0f, 146.0f);
                instancePath.lineTo(0.0f, 146.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(67.462845f, 72.00018f);
                instancePath2.lineTo(49.3112f, 53.848534f);
                instancePath2.cubicTo(48.899487f, 53.43682f, 48.89414f, 52.760975f, 49.30799f, 52.347126f);
                instancePath2.lineTo(52.346096f, 49.30795f);
                instancePath2.cubicTo(52.7546f, 48.899445f, 53.432587f, 48.896236f, 53.848576f, 49.312225f);
                instancePath2.lineTo(72.00022f, 67.46281f);
                instancePath2.lineTo(90.1508f, 49.312225f);
                instancePath2.cubicTo(90.56358f, 48.899445f, 91.239426f, 48.89517f, 91.65435f, 49.30795f);
                instancePath2.lineTo(94.69138f, 52.347126f);
                instancePath2.cubicTo(95.09989f, 52.75456f, 95.104164f, 53.433613f, 94.68818f, 53.848534f);
                instancePath2.lineTo(76.53653f, 72.00018f);
                instancePath2.lineTo(94.68818f, 90.151825f);
                instancePath2.cubicTo(95.09989f, 90.56354f, 95.10523f, 91.23939f, 94.69138f, 91.654305f);
                instancePath2.lineTo(91.65435f, 94.69241f);
                instancePath2.cubicTo(91.244774f, 95.100914f, 90.56679f, 95.104126f, 90.1508f, 94.68921f);
                instancePath2.lineTo(72.00022f, 76.53649f);
                instancePath2.lineTo(53.848576f, 94.68921f);
                instancePath2.cubicTo(53.436863f, 95.100914f, 52.759945f, 95.105194f, 52.346096f, 94.69241f);
                instancePath2.lineTo(49.30799f, 91.654305f);
                instancePath2.cubicTo(48.899487f, 91.244736f, 48.89628f, 90.56675f, 49.3112f, 90.151825f);
                instancePath2.lineTo(67.462845f, 72.00018f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
