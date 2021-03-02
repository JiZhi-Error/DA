package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_live_logo extends c {
    private final int height = 64;
    private final int width = 64;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 64;
            case 1:
                return 64;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.saveLayerAlpha(null, 128, 31);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-2565928);
                instancePaint5.setColor(-6842473);
                instancePaint5.setStrokeWidth(3.2f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.6f, 1.6f);
                instancePath.lineTo(62.399998f, 1.6f);
                instancePath.lineTo(62.399998f, 62.399998f);
                instancePath.lineTo(1.6f, 62.399998f);
                instancePath.lineTo(1.6f, 1.6f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(45.74446f, 12.0f);
                instancePath2.cubicTo(49.310535f, 12.0f, 50.60368f, 12.371303f, 51.907383f, 13.068531f);
                instancePath2.cubicTo(53.211086f, 13.765759f, 54.23424f, 14.788914f, 54.93147f, 16.092617f);
                instancePath2.cubicTo(55.628696f, 17.39632f, 56.0f, 18.689466f, 56.0f, 22.25554f);
                instancePath2.lineTo(56.0f, 41.74446f);
                instancePath2.cubicTo(56.0f, 45.310535f, 55.628696f, 46.60368f, 54.93147f, 47.907383f);
                instancePath2.cubicTo(54.23424f, 49.211086f, 53.211086f, 50.23424f, 51.907383f, 50.93147f);
                instancePath2.cubicTo(50.60368f, 51.628696f, 49.310535f, 52.0f, 45.74446f, 52.0f);
                instancePath2.lineTo(18.25554f, 52.0f);
                instancePath2.cubicTo(14.6894655f, 52.0f, 13.396321f, 51.628696f, 12.092617f, 50.93147f);
                instancePath2.cubicTo(10.788914f, 50.23424f, 9.765759f, 49.211086f, 9.068531f, 47.907383f);
                instancePath2.cubicTo(8.371303f, 46.60368f, 8.0f, 45.310535f, 8.0f, 41.74446f);
                instancePath2.lineTo(8.0f, 22.25554f);
                instancePath2.cubicTo(8.0f, 18.689466f, 8.371303f, 17.39632f, 9.068531f, 16.092617f);
                instancePath2.cubicTo(9.765759f, 14.788914f, 10.788914f, 13.765759f, 12.092617f, 13.068531f);
                instancePath2.cubicTo(13.396321f, 12.371303f, 14.6894655f, 12.0f, 18.25554f, 12.0f);
                instancePath2.lineTo(45.74446f, 12.0f);
                instancePath2.close();
                instancePath2.moveTo(28.810667f, 21.12f);
                instancePath2.cubicTo(27.927011f, 21.12f, 27.210667f, 21.836344f, 27.210667f, 22.72f);
                instancePath2.lineTo(27.210667f, 22.72f);
                instancePath2.lineTo(27.210667f, 41.28f);
                instancePath2.cubicTo(27.210667f, 42.163654f, 27.927011f, 42.88f, 28.810667f, 42.88f);
                instancePath2.cubicTo(29.694323f, 42.88f, 30.410667f, 42.163654f, 30.410667f, 41.28f);
                instancePath2.lineTo(30.410667f, 41.28f);
                instancePath2.lineTo(30.410667f, 22.72f);
                instancePath2.cubicTo(30.410667f, 21.836344f, 29.694323f, 21.12f, 28.810667f, 21.12f);
                instancePath2.close();
                instancePath2.moveTo(41.61067f, 25.6f);
                instancePath2.cubicTo(40.727013f, 25.6f, 40.010666f, 26.316345f, 40.010666f, 27.2f);
                instancePath2.lineTo(40.010666f, 27.2f);
                instancePath2.lineTo(40.010666f, 36.8f);
                instancePath2.cubicTo(40.010666f, 37.683655f, 40.727013f, 38.4f, 41.61067f, 38.4f);
                instancePath2.cubicTo(42.494324f, 38.4f, 43.210667f, 37.683655f, 43.210667f, 36.8f);
                instancePath2.lineTo(43.210667f, 36.8f);
                instancePath2.lineTo(43.210667f, 27.2f);
                instancePath2.cubicTo(43.210667f, 26.316345f, 42.494324f, 25.6f, 41.61067f, 25.6f);
                instancePath2.close();
                instancePath2.moveTo(22.410667f, 25.6f);
                instancePath2.cubicTo(21.527012f, 25.6f, 20.810667f, 26.316345f, 20.810667f, 27.2f);
                instancePath2.lineTo(20.810667f, 27.2f);
                instancePath2.lineTo(20.810667f, 36.8f);
                instancePath2.cubicTo(20.810667f, 37.683655f, 21.527012f, 38.4f, 22.410667f, 38.4f);
                instancePath2.cubicTo(23.294323f, 38.4f, 24.010666f, 37.683655f, 24.010666f, 36.8f);
                instancePath2.lineTo(24.010666f, 36.8f);
                instancePath2.lineTo(24.010666f, 27.2f);
                instancePath2.cubicTo(24.010666f, 26.316345f, 23.294323f, 25.6f, 22.410667f, 25.6f);
                instancePath2.close();
                instancePath2.moveTo(35.210667f, 27.2f);
                instancePath2.cubicTo(34.32701f, 27.2f, 33.61067f, 27.916344f, 33.61067f, 28.8f);
                instancePath2.lineTo(33.61067f, 28.8f);
                instancePath2.lineTo(33.61067f, 35.2f);
                instancePath2.cubicTo(33.61067f, 36.083656f, 34.32701f, 36.8f, 35.210667f, 36.8f);
                instancePath2.cubicTo(36.094322f, 36.8f, 36.810665f, 36.083656f, 36.810665f, 35.2f);
                instancePath2.lineTo(36.810665f, 35.2f);
                instancePath2.lineTo(36.810665f, 28.8f);
                instancePath2.cubicTo(36.810665f, 27.916344f, 36.094322f, 27.2f, 35.210667f, 27.2f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint8);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
