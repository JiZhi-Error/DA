package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_sperated extends c {
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
                instancePaint3.setColor(-436207616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(57.055973f, 12.0f);
                instancePath.cubicTo(58.696636f, 12.0f, 60.0434f, 13.337516f, 60.0434f, 14.987426f);
                instancePath.lineTo(60.0434f, 57.012573f);
                instancePath.cubicTo(60.0434f, 58.65324f, 58.705883f, 60.0f, 57.055973f, 60.0f);
                instancePath.lineTo(39.030823f, 60.0f);
                instancePath.cubicTo(37.39016f, 60.0f, 36.0434f, 58.658257f, 36.0434f, 57.00313f);
                instancePath.lineTo(36.0434f, 48.0f);
                instancePath.lineTo(39.6434f, 48.0f);
                instancePath.lineTo(39.6434f, 56.4f);
                instancePath.lineTo(56.443398f, 56.4f);
                instancePath.lineTo(56.443398f, 15.6f);
                instancePath.lineTo(39.6434f, 15.6f);
                instancePath.lineTo(39.6434f, 24.0f);
                instancePath.lineTo(36.0434f, 24.0f);
                instancePath.lineTo(36.0434f, 14.99687f);
                instancePath.cubicTo(36.0434f, 13.347391f, 37.380913f, 12.0f, 39.030823f, 12.0f);
                instancePath.lineTo(57.055973f, 12.0f);
                instancePath.close();
                instancePath.moveTo(30.012575f, 12.0f);
                instancePath.cubicTo(31.65324f, 12.0f, 33.0f, 13.341744f, 33.0f, 14.99687f);
                instancePath.lineTo(33.0f, 24.0f);
                instancePath.lineTo(29.4f, 24.0f);
                instancePath.lineTo(29.4f, 15.6f);
                instancePath.lineTo(12.6f, 15.6f);
                instancePath.lineTo(12.6f, 56.4f);
                instancePath.lineTo(29.4f, 56.4f);
                instancePath.lineTo(29.4f, 48.0f);
                instancePath.lineTo(33.0f, 48.0f);
                instancePath.lineTo(33.0f, 57.00313f);
                instancePath.cubicTo(33.0f, 58.65261f, 31.662483f, 60.0f, 30.012575f, 60.0f);
                instancePath.lineTo(11.987426f, 60.0f);
                instancePath.cubicTo(10.346761f, 60.0f, 9.0f, 58.662483f, 9.0f, 57.012573f);
                instancePath.lineTo(9.0f, 14.987426f);
                instancePath.cubicTo(9.0f, 13.346761f, 10.337516f, 12.0f, 11.987426f, 12.0f);
                instancePath.lineTo(30.012575f, 12.0f);
                instancePath.close();
                instancePath.moveTo(44.036037f, 25.393398f);
                instancePath.lineTo(52.52132f, 33.87868f);
                instancePath.cubicTo(53.692894f, 35.05025f, 53.692894f, 36.94975f, 52.52132f, 38.12132f);
                instancePath.lineTo(44.036037f, 46.6066f);
                instancePath.lineTo(41.490456f, 44.061016f);
                instancePath.lineTo(47.751453f, 37.80002f);
                instancePath.lineTo(18.9f, 37.80002f);
                instancePath.lineTo(18.9f, 34.20002f);
                instancePath.lineTo(47.75149f, 34.20002f);
                instancePath.lineTo(41.490456f, 27.938982f);
                instancePath.lineTo(44.036037f, 25.393398f);
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
