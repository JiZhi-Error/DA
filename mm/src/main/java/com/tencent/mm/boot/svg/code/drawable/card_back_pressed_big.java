package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class card_back_pressed_big extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-3289392);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(17.0f, 48.02f);
                instancePath.cubicTo(27.66f, 37.34f, 38.34f, 26.66f, 49.02f, 16.0f);
                instancePath.cubicTo(50.92f, 17.88f, 52.82f, 19.78f, 54.7f, 21.68f);
                instancePath.cubicTo(47.27f, 29.13f, 39.82f, 36.56f, 32.39f, 44.01f);
                instancePath.cubicTo(48.6f, 44.03f, 64.81f, 44.01f, 81.02f, 44.02f);
                instancePath.cubicTo(81.02f, 46.71f, 81.02f, 49.39f, 81.01f, 52.08f);
                instancePath.cubicTo(64.83f, 52.1f, 48.64f, 52.07f, 32.45f, 52.09f);
                instancePath.cubicTo(39.86f, 59.52f, 47.29f, 66.93f, 54.7f, 74.36f);
                instancePath.cubicTo(52.82f, 76.26f, 50.92f, 78.16f, 49.02f, 80.04f);
                instancePath.cubicTo(38.34f, 69.38f, 27.66f, 58.7f, 17.0f, 48.02f);
                instancePath.lineTo(17.0f, 48.02f);
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
