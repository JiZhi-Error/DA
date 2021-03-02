package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class count_down_2 extends c {
    private final int height = 80;
    private final int width = 80;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(40.504f, 14.0f);
                instancePath.cubicTo(45.4f, 14.0f, 49.504f, 15.368f, 52.672f, 18.248f);
                instancePath.cubicTo(55.768f, 21.128f, 57.352f, 24.8f, 57.352f, 29.336f);
                instancePath.cubicTo(57.352f, 33.8f, 55.624f, 37.832f, 52.312f, 41.504f);
                instancePath.cubicTo(50.296f, 43.592f, 46.768f, 46.328f, 41.656f, 49.784f);
                instancePath.cubicTo(36.112f, 53.456f, 32.8f, 56.696f, 31.72f, 59.504f);
                instancePath.lineTo(57.424f, 59.504f);
                instancePath.lineTo(57.424f, 66.416f);
                instancePath.lineTo(22.0f, 66.416f);
                instancePath.cubicTo(22.0f, 61.304f, 23.656f, 56.84f, 27.112f, 52.952f);
                instancePath.cubicTo(28.984f, 50.72f, 32.872f, 47.624f, 38.704f, 43.592f);
                instancePath.cubicTo(42.16f, 41.144f, 44.608f, 39.2f, 46.048f, 37.688f);
                instancePath.cubicTo(48.352f, 35.096f, 49.576f, 32.288f, 49.576f, 29.264f);
                instancePath.cubicTo(49.576f, 26.384f, 48.784f, 24.224f, 47.2f, 22.784f);
                instancePath.cubicTo(45.616f, 21.344f, 43.24f, 20.624f, 40.216f, 20.624f);
                instancePath.cubicTo(36.976f, 20.624f, 34.528f, 21.704f, 32.872f, 23.936f);
                instancePath.cubicTo(31.144f, 26.096f, 30.28f, 29.192f, 30.136f, 33.368f);
                instancePath.lineTo(22.288f, 33.368f);
                instancePath.cubicTo(22.36f, 27.608f, 24.016f, 23.0f, 27.256f, 19.544f);
                instancePath.cubicTo(30.568f, 15.8f, 35.032f, 14.0f, 40.504f, 14.0f);
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
