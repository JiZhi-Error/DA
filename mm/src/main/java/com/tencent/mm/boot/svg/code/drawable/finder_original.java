package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_original extends c {
    private final int height = 56;
    private final int width = 56;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 56;
            case 1:
                return 56;
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(56.0f, 0.0f);
                instancePath.lineTo(56.0f, 56.0f);
                instancePath.lineTo(0.0f, 56.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(43.666668f, 34.333332f);
                instancePath2.cubicTo(49.189514f, 34.333332f, 53.666668f, 38.810486f, 53.666668f, 44.333332f);
                instancePath2.cubicTo(53.666668f, 49.856182f, 49.189514f, 54.333332f, 43.666668f, 54.333332f);
                instancePath2.cubicTo(38.143818f, 54.333332f, 33.666668f, 49.856182f, 33.666668f, 44.333332f);
                instancePath2.cubicTo(33.666668f, 38.810486f, 38.143818f, 34.333332f, 43.666668f, 34.333332f);
                instancePath2.close();
                instancePath2.moveTo(45.333332f, 5.0f);
                instancePath2.cubicTo(45.84617f, 5.0f, 46.26884f, 5.38604f, 46.326607f, 5.883379f);
                instancePath2.lineTo(46.333332f, 6.0f);
                instancePath2.lineTo(46.3335f, 32.630726f);
                instancePath2.cubicTo(45.47582f, 32.436096f, 44.583244f, 32.333332f, 43.666668f, 32.333332f);
                instancePath2.cubicTo(37.03925f, 32.333332f, 31.666666f, 37.705917f, 31.666666f, 44.333332f);
                instancePath2.cubicTo(31.666666f, 47.094948f, 32.599537f, 49.63868f, 34.167343f, 51.666595f);
                instancePath2.lineTo(10.0f, 51.666668f);
                instancePath2.cubicTo(9.4871645f, 51.666668f, 9.064493f, 51.28063f, 9.006728f, 50.783287f);
                instancePath2.lineTo(9.0f, 50.666668f);
                instancePath2.lineTo(9.0f, 6.0f);
                instancePath2.cubicTo(9.0f, 5.487164f, 9.38604f, 5.0644927f, 9.883379f, 5.0067277f);
                instancePath2.lineTo(10.0f, 5.0f);
                instancePath2.lineTo(45.333332f, 5.0f);
                instancePath2.close();
                instancePath2.moveTo(48.08942f, 40.873333f);
                instancePath2.lineTo(42.490105f, 46.47265f);
                instancePath2.lineTo(39.724205f, 43.70675f);
                instancePath2.lineTo(38.666668f, 44.764286f);
                instancePath2.lineTo(41.785477f, 47.885353f);
                instancePath2.lineTo(41.879665f, 47.968777f);
                instancePath2.cubicTo(42.23921f, 48.24846f, 42.7458f, 48.248558f, 43.105377f, 47.96895f);
                instancePath2.lineTo(43.19958f, 47.885754f);
                instancePath2.lineTo(49.151947f, 41.93586f);
                instancePath2.lineTo(48.08942f, 40.873333f);
                instancePath2.close();
                instancePath2.moveTo(25.333334f, 37.666668f);
                instancePath2.lineTo(16.0f, 37.666668f);
                instancePath2.lineTo(16.0f, 41.166668f);
                instancePath2.lineTo(25.333334f, 41.166668f);
                instancePath2.lineTo(25.333334f, 37.666668f);
                instancePath2.close();
                instancePath2.moveTo(25.333334f, 30.666666f);
                instancePath2.lineTo(16.0f, 30.666666f);
                instancePath2.lineTo(16.0f, 34.166668f);
                instancePath2.lineTo(25.333334f, 34.166668f);
                instancePath2.lineTo(25.333334f, 30.666666f);
                instancePath2.close();
                instancePath2.moveTo(33.5f, 23.666666f);
                instancePath2.lineTo(16.0f, 23.666666f);
                instancePath2.lineTo(16.0f, 27.166666f);
                instancePath2.lineTo(33.5f, 27.166666f);
                instancePath2.lineTo(33.5f, 23.666666f);
                instancePath2.close();
                instancePath2.moveTo(19.5f, 12.0f);
                instancePath2.cubicTo(17.567003f, 12.0f, 16.0f, 13.567003f, 16.0f, 15.5f);
                instancePath2.cubicTo(16.0f, 17.432997f, 17.567003f, 19.0f, 19.5f, 19.0f);
                instancePath2.cubicTo(21.432997f, 19.0f, 23.0f, 17.432997f, 23.0f, 15.5f);
                instancePath2.cubicTo(23.0f, 13.567003f, 21.432997f, 12.0f, 19.5f, 12.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
