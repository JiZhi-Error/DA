package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_mike2 extends c {
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
                instancePath.moveTo(37.80007f, 49.381016f);
                instancePath.cubicTo(44.406094f, 48.500637f, 49.5f, 42.841934f, 49.5f, 35.992504f);
                instancePath.lineTo(49.5f, 31.5f);
                instancePath.lineTo(45.9f, 31.5f);
                instancePath.lineTo(45.9f, 35.992504f);
                instancePath.cubicTo(45.9f, 41.465343f, 41.468178f, 45.9f, 36.0f, 45.9f);
                instancePath.cubicTo(30.5322f, 45.9f, 26.1f, 41.46571f, 26.1f, 35.992504f);
                instancePath.lineTo(26.1f, 31.5f);
                instancePath.lineTo(22.5f, 31.5f);
                instancePath.lineTo(22.5f, 35.992504f);
                instancePath.cubicTo(22.5f, 42.843365f, 27.59519f, 48.50077f, 34.200073f, 49.38102f);
                instancePath.lineTo(34.200073f, 54.0f);
                instancePath.lineTo(37.80007f, 54.0f);
                instancePath.lineTo(37.80007f, 49.381016f);
                instancePath.close();
                instancePath.moveTo(36.0f, 66.0f);
                instancePath.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                instancePath.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 19.5f);
                instancePath.cubicTo(32.68629f, 19.5f, 30.0f, 22.18629f, 30.0f, 25.5f);
                instancePath.lineTo(30.0f, 36.0f);
                instancePath.cubicTo(30.0f, 39.31371f, 32.68629f, 42.0f, 36.0f, 42.0f);
                instancePath.cubicTo(39.31371f, 42.0f, 42.0f, 39.31371f, 42.0f, 36.0f);
                instancePath.lineTo(42.0f, 25.5f);
                instancePath.cubicTo(42.0f, 22.18629f, 39.31371f, 19.5f, 36.0f, 19.5f);
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
