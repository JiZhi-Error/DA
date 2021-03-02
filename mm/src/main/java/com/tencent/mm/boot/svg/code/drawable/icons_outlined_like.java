package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_like extends c {
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
                instancePath.moveTo(57.853916f, 37.935287f);
                instancePath.cubicTo(62.186268f, 33.470257f, 62.135693f, 26.344612f, 57.730064f, 21.938982f);
                instancePath.cubicTo(53.278088f, 17.487005f, 46.06001f, 17.487005f, 41.60803f, 21.938982f);
                instancePath.cubicTo(41.031235f, 22.515778f, 40.299618f, 23.221498f, 39.40984f, 24.059835f);
                instancePath.lineTo(36.941124f, 26.385826f);
                instancePath.lineTo(34.47241f, 24.059835f);
                instancePath.cubicTo(33.582634f, 23.221498f, 32.851017f, 22.515778f, 32.27422f, 21.938982f);
                instancePath.cubicTo(27.822245f, 17.487005f, 20.604162f, 17.487005f, 16.152185f, 21.938982f);
                instancePath.cubicTo(11.746612f, 26.344557f, 11.695749f, 33.47061f, 15.989021f, 37.897854f);
                instancePath.lineTo(36.940998f, 58.850048f);
                instancePath.lineTo(57.853916f, 37.935287f);
                instancePath.close();
                instancePath.moveTo(13.606602f, 19.393398f);
                instancePath.cubicTo(19.464466f, 13.535534f, 28.96194f, 13.535534f, 34.819805f, 19.393398f);
                instancePath.cubicTo(35.368225f, 19.941818f, 36.075333f, 20.623898f, 36.941124f, 21.439636f);
                instancePath.cubicTo(37.80692f, 20.623898f, 38.514027f, 19.941818f, 39.062447f, 19.393398f);
                instancePath.cubicTo(44.92031f, 13.535534f, 54.417786f, 13.535534f, 60.27565f, 19.393398f);
                instancePath.cubicTo(66.079025f, 25.196774f, 66.133f, 34.57236f, 60.4376f, 40.442192f);
                instancePath.lineTo(39.062447f, 61.819805f);
                instancePath.cubicTo(37.890934f, 62.99144f, 35.99144f, 62.99154f, 34.819805f, 61.820026f);
                instancePath.lineTo(13.443423f, 40.443424f);
                instancePath.cubicTo(7.749244f, 34.57236f, 7.803227f, 25.196774f, 13.606602f, 19.393398f);
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
