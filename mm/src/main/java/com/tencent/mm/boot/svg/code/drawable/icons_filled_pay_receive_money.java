package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_pay_receive_money extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.0f, 19.5f);
                instancePath.cubicTo(45.25799f, 19.5f, 53.36367f, 26.097805f, 57.83126f, 34.052135f);
                instancePath.cubicTo(48.80696f, 37.80745f, 34.20503f, 43.89166f, 34.20503f, 43.89166f);
                instancePath.cubicTo(33.90008f, 43.996475f, 33.571373f, 44.055946f, 33.228405f, 44.055946f);
                instancePath.cubicTo(32.65178f, 44.055946f, 32.113964f, 43.89389f, 31.666443f, 43.61884f);
                instancePath.lineTo(31.666443f, 43.61884f);
                instancePath.lineTo(25.523943f, 39.514637f);
                instancePath.cubicTo(25.363945f, 39.403133f, 25.168303f, 39.33697f, 24.95286f, 39.33697f);
                instancePath.cubicTo(24.426926f, 39.33697f, 24.0f, 39.736908f, 24.0f, 40.230515f);
                instancePath.cubicTo(24.0f, 40.35912f, 24.034851f, 40.49144f, 24.091087f, 40.60815f);
                instancePath.lineTo(24.091087f, 40.60815f);
                instancePath.lineTo(29.297363f, 51.329178f);
                instancePath.lineTo(29.421717f, 51.5849f);
                instancePath.cubicTo(29.74805f, 52.13054f, 30.369825f, 52.5f, 31.085064f, 52.5f);
                instancePath.cubicTo(31.393179f, 52.5f, 31.683868f, 52.428635f, 31.942083f, 52.307465f);
                instancePath.lineTo(31.942083f, 52.307465f);
                instancePath.lineTo(32.15119f, 52.193726f);
                instancePath.cubicTo(32.15119f, 52.193726f, 48.021008f, 43.603085f, 59.466225f, 37.407566f);
                instancePath.cubicTo(60.77533f, 40.56137f, 61.5f, 43.808155f, 61.5f, 46.85294f);
                instancePath.cubicTo(61.5f, 58.938232f, 50.08326f, 66.0f, 36.0f, 66.0f);
                instancePath.cubicTo(21.916739f, 66.0f, 10.5f, 58.938232f, 10.5f, 46.85294f);
                instancePath.cubicTo(10.5f, 34.76765f, 21.916739f, 19.5f, 36.0f, 19.5f);
                instancePath.close();
                instancePath.moveTo(33.291172f, 7.344808f);
                instancePath.cubicTo(34.05595f, 7.7077637f, 34.51491f, 7.9220834f, 34.99791f, 8.138975f);
                instancePath.cubicTo(37.293617f, 9.169874f, 38.90189f, 9.653906f, 40.273438f, 9.653906f);
                instancePath.cubicTo(41.783073f, 9.653906f, 43.063473f, 9.488051f, 44.70194f, 9.143051f);
                instancePath.cubicTo(49.609493f, 8.109704f, 50.80466f, 8.202975f, 52.67065f, 11.1570835f);
                instancePath.cubicTo(54.380756f, 13.864397f, 53.16061f, 16.982483f, 49.438065f, 20.64482f);
                instancePath.cubicTo(45.36388f, 18.054356f, 40.756786f, 16.5f, 36.0f, 16.5f);
                instancePath.cubicTo(31.537867f, 16.5f, 27.207455f, 17.867756f, 23.325562f, 20.175764f);
                instancePath.cubicTo(18.31149f, 14.415737f, 17.180632f, 9.767063f, 20.667408f, 6.4453998f);
                instancePath.cubicTo(23.741673f, 3.5167143f, 26.464617f, 4.1050024f, 33.291172f, 7.344808f);
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
