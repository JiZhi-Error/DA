package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class offline_entrance_f2f_collect_hk extends c {
    private final int height = 88;
    private final int width = 88;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 88;
            case 1:
                return 88;
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
                instancePath.moveTo(44.0f, 27.95153f);
                instancePath.cubicTo(53.25799f, 27.95153f, 61.36367f, 34.549335f, 65.83126f, 42.503666f);
                instancePath.cubicTo(56.80696f, 46.25898f, 42.20503f, 52.34319f, 42.20503f, 52.34319f);
                instancePath.cubicTo(41.90008f, 52.448006f, 41.571373f, 52.507477f, 41.228405f, 52.507477f);
                instancePath.cubicTo(40.65178f, 52.507477f, 40.113964f, 52.34542f, 39.666443f, 52.07037f);
                instancePath.lineTo(39.666443f, 52.07037f);
                instancePath.lineTo(33.52394f, 47.966167f);
                instancePath.cubicTo(33.363945f, 47.85466f, 33.168304f, 47.7885f, 32.95286f, 47.7885f);
                instancePath.cubicTo(32.426926f, 47.7885f, 32.0f, 48.18844f, 32.0f, 48.682045f);
                instancePath.cubicTo(32.0f, 48.81065f, 32.03485f, 48.94297f, 32.091087f, 49.05968f);
                instancePath.lineTo(32.091087f, 49.05968f);
                instancePath.lineTo(37.297363f, 59.78071f);
                instancePath.lineTo(37.42172f, 60.03643f);
                instancePath.cubicTo(37.74805f, 60.58207f, 38.369823f, 60.95153f, 39.085064f, 60.95153f);
                instancePath.cubicTo(39.39318f, 60.95153f, 39.68387f, 60.880165f, 39.942085f, 60.758995f);
                instancePath.lineTo(39.942085f, 60.758995f);
                instancePath.lineTo(40.15119f, 60.645256f);
                instancePath.cubicTo(40.15119f, 60.645256f, 56.021008f, 52.054615f, 67.466225f, 45.859097f);
                instancePath.cubicTo(68.77533f, 49.0129f, 69.5f, 52.259686f, 69.5f, 55.30447f);
                instancePath.cubicTo(69.5f, 67.38976f, 58.08326f, 74.45153f, 44.0f, 74.45153f);
                instancePath.cubicTo(29.916739f, 74.45153f, 18.5f, 67.38976f, 18.5f, 55.30447f);
                instancePath.cubicTo(18.5f, 43.21918f, 29.916739f, 27.95153f, 44.0f, 27.95153f);
                instancePath.close();
                instancePath.moveTo(41.291172f, 15.796338f);
                instancePath.cubicTo(42.05595f, 16.159294f, 42.51491f, 16.373613f, 42.99791f, 16.590506f);
                instancePath.cubicTo(45.293617f, 17.621405f, 46.90189f, 18.105436f, 48.273438f, 18.105436f);
                instancePath.cubicTo(49.783073f, 18.105436f, 51.063473f, 17.939583f, 52.70194f, 17.594582f);
                instancePath.cubicTo(57.609493f, 16.561234f, 58.80466f, 16.654505f, 60.67065f, 19.608614f);
                instancePath.cubicTo(62.380756f, 22.315928f, 61.16061f, 25.434011f, 57.438065f, 29.09635f);
                instancePath.cubicTo(53.36388f, 26.505886f, 48.756786f, 24.95153f, 44.0f, 24.95153f);
                instancePath.cubicTo(39.53787f, 24.95153f, 35.207455f, 26.319284f, 31.325562f, 28.627295f);
                instancePath.cubicTo(26.31149f, 22.867268f, 25.180632f, 18.218594f, 28.667408f, 14.89693f);
                instancePath.cubicTo(31.741673f, 11.968245f, 34.464615f, 12.556533f, 41.291172f, 15.796338f);
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
