package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_transfer2 extends c {
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
                instancePath.moveTo(39.0451f, 43.66102f);
                instancePath.lineTo(35.7026f, 50.79049f);
                instancePath.cubicTo(35.517517f, 51.185265f, 35.561123f, 51.649364f, 35.816505f, 52.002754f);
                instancePath.cubicTo(36.20469f, 52.53991f, 36.95483f, 52.660675f, 37.49199f, 52.27249f);
                instancePath.lineTo(51.892452f, 41.865765f);
                instancePath.cubicTo(52.28271f, 41.583736f, 52.513863f, 41.131504f, 52.513863f, 40.65f);
                instancePath.cubicTo(52.513863f, 39.821575f, 51.84229f, 39.15f, 51.013863f, 39.15f);
                instancePath.lineTo(41.16f, 39.15f);
                instancePath.lineTo(41.154835f, 39.16102f);
                instancePath.lineTo(21.0f, 39.16102f);
                instancePath.lineTo(21.0f, 43.66102f);
                instancePath.lineTo(39.0451f, 43.66102f);
                instancePath.close();
                instancePath.moveTo(33.628757f, 28.33895f);
                instancePath.lineTo(36.971264f, 21.209478f);
                instancePath.cubicTo(37.156345f, 20.814705f, 37.112736f, 20.350603f, 36.857357f, 19.997215f);
                instancePath.cubicTo(36.46917f, 19.460058f, 35.719032f, 19.339293f, 35.181873f, 19.727478f);
                instancePath.lineTo(20.781408f, 30.134205f);
                instancePath.cubicTo(20.391148f, 30.416233f, 20.16f, 30.868465f, 20.16f, 31.349968f);
                instancePath.cubicTo(20.16f, 32.178394f, 20.831572f, 32.849968f, 21.66f, 32.849968f);
                instancePath.lineTo(31.51386f, 32.849968f);
                instancePath.lineTo(31.519028f, 32.838947f);
                instancePath.lineTo(51.659996f, 32.838947f);
                instancePath.lineTo(51.659996f, 28.33895f);
                instancePath.lineTo(33.628757f, 28.33895f);
                instancePath.close();
                instancePath.moveTo(36.0f, 66.0f);
                instancePath.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                instancePath.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
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
