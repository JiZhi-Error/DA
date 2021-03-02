package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_coin_dollar extends c {
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
                instancePath.moveTo(36.0f, 6.0f);
                instancePath.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                instancePath.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                instancePath.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 9.6f);
                instancePath.cubicTo(21.419683f, 9.6f, 9.6f, 21.419683f, 9.6f, 36.0f);
                instancePath.cubicTo(9.6f, 50.58032f, 21.419683f, 62.4f, 36.0f, 62.4f);
                instancePath.cubicTo(50.58032f, 62.4f, 62.4f, 50.58032f, 62.4f, 36.0f);
                instancePath.cubicTo(62.4f, 21.419683f, 50.58032f, 9.6f, 36.0f, 9.6f);
                instancePath.close();
                instancePath.moveTo(37.8f, 18.6f);
                instancePath.lineTo(37.799545f, 22.305813f);
                instancePath.cubicTo(42.828465f, 22.903303f, 46.8f, 25.972006f, 46.8f, 30.0f);
                instancePath.lineTo(46.799f, 30.0f);
                instancePath.lineTo(43.2f, 30.000994f);
                instancePath.cubicTo(43.2f, 30.000664f, 43.2f, 30.000332f, 43.2f, 30.0f);
                instancePath.cubicTo(43.2f, 28.196058f, 40.97054f, 26.434132f, 37.79976f, 25.937841f);
                instancePath.lineTo(37.799545f, 34.305813f);
                instancePath.cubicTo(42.828465f, 34.9033f, 46.8f, 37.972008f, 46.8f, 42.0f);
                instancePath.cubicTo(46.8f, 46.027992f, 42.828465f, 49.0967f, 37.799545f, 49.694187f);
                instancePath.lineTo(37.8f, 53.4f);
                instancePath.lineTo(34.2f, 53.4f);
                instancePath.lineTo(34.19958f, 49.694084f);
                instancePath.cubicTo(29.171492f, 49.096394f, 25.200659f, 46.02827f, 25.2f, 42.001003f);
                instancePath.lineTo(28.799f, 42.0f);
                instancePath.lineTo(28.804789f, 42.14506f);
                instancePath.cubicTo(28.920277f, 43.897335f, 31.113955f, 45.57875f, 34.199047f, 46.061974f);
                instancePath.lineTo(34.19945f, 37.69407f);
                instancePath.cubicTo(29.171005f, 37.09629f, 25.2f, 34.027725f, 25.2f, 30.0f);
                instancePath.cubicTo(25.2f, 25.972275f, 29.171005f, 22.903711f, 34.19945f, 22.305933f);
                instancePath.lineTo(34.2f, 18.6f);
                instancePath.lineTo(37.8f, 18.6f);
                instancePath.close();
                instancePath.moveTo(37.79976f, 37.93784f);
                instancePath.lineTo(37.79976f, 46.06216f);
                instancePath.cubicTo(40.97054f, 45.56587f, 43.2f, 43.80394f, 43.2f, 42.0f);
                instancePath.cubicTo(43.2f, 40.19606f, 40.97054f, 38.43413f, 37.79976f, 37.93784f);
                instancePath.close();
                instancePath.moveTo(28.8f, 30.0f);
                instancePath.cubicTo(28.8f, 31.803753f, 31.028994f, 33.5655f, 34.199245f, 34.062004f);
                instancePath.lineTo(34.199245f, 25.937998f);
                instancePath.cubicTo(31.028994f, 26.4345f, 28.8f, 28.196247f, 28.8f, 30.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
