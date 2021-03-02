package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class count_down_5 extends c {
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
                instancePath.moveTo(24.744f, 14.0f);
                instancePath.lineTo(55.704f, 14.0f);
                instancePath.lineTo(55.704f, 20.912f);
                instancePath.lineTo(31.08f, 20.912f);
                instancePath.lineTo(29.568f, 35.744f);
                instancePath.lineTo(29.784f, 35.744f);
                instancePath.cubicTo(31.368f, 34.088f, 33.168f, 32.936f, 35.256f, 32.216f);
                instancePath.cubicTo(37.128f, 31.424f, 39.288f, 31.064f, 41.592f, 31.064f);
                instancePath.cubicTo(46.416f, 31.064f, 50.376f, 32.648f, 53.4f, 35.816f);
                instancePath.cubicTo(56.424f, 38.984f, 58.008f, 43.304f, 58.008f, 48.848f);
                instancePath.cubicTo(58.008f, 54.176f, 55.992f, 58.496f, 52.104f, 61.88f);
                instancePath.cubicTo(48.432f, 64.904f, 44.04f, 66.416f, 38.928f, 66.416f);
                instancePath.cubicTo(34.32f, 66.416f, 30.36f, 65.12f, 27.048f, 62.6f);
                instancePath.cubicTo(23.376f, 59.864f, 21.36f, 56.048f, 21.0f, 51.296f);
                instancePath.lineTo(28.704f, 51.296f);
                instancePath.cubicTo(28.992f, 54.176f, 30.144f, 56.408f, 32.088f, 57.848f);
                instancePath.cubicTo(33.816f, 59.144f, 36.12f, 59.792f, 39.0f, 59.792f);
                instancePath.cubicTo(42.168f, 59.792f, 44.832f, 58.784f, 46.992f, 56.84f);
                instancePath.cubicTo(49.152f, 54.824f, 50.232f, 52.232f, 50.232f, 48.92f);
                instancePath.cubicTo(50.232f, 45.32f, 49.296f, 42.512f, 47.424f, 40.496f);
                instancePath.cubicTo(45.552f, 38.48f, 42.96f, 37.472f, 39.504f, 37.472f);
                instancePath.cubicTo(37.2f, 37.472f, 35.256f, 37.832f, 33.528f, 38.696f);
                instancePath.cubicTo(31.656f, 39.56f, 30.288f, 40.928f, 29.28f, 42.8f);
                instancePath.lineTo(21.936f, 42.8f);
                instancePath.lineTo(24.744f, 14.0f);
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
