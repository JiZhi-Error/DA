package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bank_remit_transfer extends c {
    private final int height = 69;
    private final int width = 69;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 69;
            case 1:
                return 69;
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
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(41.076107f, 39.0f);
                instancePath.lineTo(41.075874f, 39.00171f);
                instancePath.lineTo(26.999348f, 38.992485f);
                instancePath.cubicTo(26.693531f, 38.992287f, 26.404617f, 38.85216f, 26.21512f, 38.612133f);
                instancePath.cubicTo(25.8729f, 38.178654f, 25.94688f, 37.549824f, 26.380358f, 37.207603f);
                instancePath.lineTo(41.176712f, 25.526272f);
                instancePath.cubicTo(41.389874f, 25.357986f, 41.66231f, 25.283638f, 41.931408f, 25.320316f);
                instancePath.cubicTo(42.478634f, 25.394903f, 42.861782f, 25.898981f, 42.787193f, 26.446207f);
                instancePath.lineTo(41.62131f, 35.0f);
                instancePath.lineTo(59.995052f, 35.0f);
                instancePath.cubicTo(61.102356f, 35.0f, 62.0f, 35.88773f, 62.0f, 37.0f);
                instancePath.cubicTo(62.0f, 38.10457f, 61.102974f, 39.0f, 59.995052f, 39.0f);
                instancePath.lineTo(41.076107f, 39.0f);
                instancePath.close();
                instancePath.moveTo(48.25757f, 43.016853f);
                instancePath.lineTo(58.78785f, 43.02375f);
                instancePath.cubicTo(59.093666f, 43.023952f, 59.382576f, 43.164078f, 59.572075f, 43.404106f);
                instancePath.cubicTo(59.914295f, 43.837585f, 59.840317f, 44.466415f, 59.406837f, 44.808636f);
                instancePath.lineTo(44.61048f, 56.489967f);
                instancePath.cubicTo(44.39732f, 56.658253f, 44.12488f, 56.7326f, 43.855785f, 56.695923f);
                instancePath.cubicTo(43.308563f, 56.621334f, 42.92541f, 56.117256f, 43.0f, 55.57003f);
                instancePath.lineTo(44.1681f, 47.0f);
                instancePath.lineTo(28.004946f, 47.0f);
                instancePath.cubicTo(26.897646f, 47.0f, 26.0f, 46.11227f, 26.0f, 45.0f);
                instancePath.cubicTo(26.0f, 43.89543f, 26.897026f, 43.0f, 28.004946f, 43.0f);
                instancePath.lineTo(47.995052f, 43.0f);
                instancePath.cubicTo(48.08403f, 43.0f, 48.171654f, 43.005733f, 48.25757f, 43.016853f);
                instancePath.close();
                instancePath.moveTo(57.0f, 31.0f);
                instancePath.lineTo(53.0f, 31.0f);
                instancePath.lineTo(53.0f, 18.0f);
                instancePath.lineTo(13.0f, 18.0f);
                instancePath.lineTo(13.0f, 50.0f);
                instancePath.lineTo(37.96f, 50.0f);
                instancePath.lineTo(37.32f, 54.0f);
                instancePath.lineTo(12.0f, 54.0f);
                instancePath.cubicTo(10.343145f, 54.0f, 9.0f, 52.656853f, 9.0f, 51.0f);
                instancePath.lineTo(9.0f, 17.0f);
                instancePath.lineTo(9.0f, 17.0f);
                instancePath.cubicTo(9.0f, 15.343145f, 10.343145f, 14.0f, 12.0f, 14.0f);
                instancePath.lineTo(12.0f, 14.0f);
                instancePath.lineTo(54.0f, 14.0f);
                instancePath.cubicTo(55.656853f, 14.0f, 57.0f, 15.343145f, 57.0f, 17.0f);
                instancePath.lineTo(57.0f, 31.0f);
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
