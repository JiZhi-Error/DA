package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_share extends c {
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
                instancePath.moveTo(56.4f, 24.6f);
                instancePath.lineTo(48.0f, 24.6f);
                instancePath.lineTo(48.0f, 21.0f);
                instancePath.lineTo(57.00313f, 21.0f);
                instancePath.cubicTo(58.65261f, 21.0f, 60.0f, 22.337517f, 60.0f, 23.987425f);
                instancePath.lineTo(60.0f, 63.012573f);
                instancePath.cubicTo(60.0f, 64.65324f, 58.662483f, 66.0f, 57.012573f, 66.0f);
                instancePath.lineTo(14.987426f, 66.0f);
                instancePath.cubicTo(13.346761f, 66.0f, 12.0f, 64.66248f, 12.0f, 63.012573f);
                instancePath.lineTo(12.0f, 23.987425f);
                instancePath.cubicTo(12.0f, 22.34676f, 13.341744f, 21.0f, 14.99687f, 21.0f);
                instancePath.lineTo(24.0f, 21.0f);
                instancePath.lineTo(24.0f, 24.6f);
                instancePath.lineTo(15.6f, 24.6f);
                instancePath.lineTo(15.6f, 62.4f);
                instancePath.lineTo(56.4f, 62.4f);
                instancePath.lineTo(56.4f, 24.6f);
                instancePath.close();
                instancePath.moveTo(37.79998f, 12.784549f);
                instancePath.lineTo(37.79998f, 40.5f);
                instancePath.lineTo(34.19998f, 40.5f);
                instancePath.lineTo(34.19998f, 12.784586f);
                instancePath.lineTo(27.938982f, 19.045584f);
                instancePath.lineTo(25.393398f, 16.5f);
                instancePath.lineTo(33.87868f, 8.014719f);
                instancePath.cubicTo(35.05025f, 6.843146f, 36.94975f, 6.843146f, 38.12132f, 8.014719f);
                instancePath.lineTo(46.6066f, 16.5f);
                instancePath.lineTo(44.061016f, 19.045584f);
                instancePath.lineTo(37.79998f, 12.784549f);
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
