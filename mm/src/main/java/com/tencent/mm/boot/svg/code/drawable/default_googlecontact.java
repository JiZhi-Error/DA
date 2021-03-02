package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class default_googlecontact extends c {
    private final int height = 192;
    private final int width = 192;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                instancePaint5.setColor(-789517);
                instancePaint5.setStrokeWidth(3.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(192.0f, 0.0f);
                instancePath.lineTo(192.0f, 192.0f);
                instancePath.lineTo(0.0f, 192.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-2274503);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(140.0f, 87.0f);
                instancePath2.lineTo(122.0f, 87.0f);
                instancePath2.lineTo(122.0f, 95.0f);
                instancePath2.lineTo(140.0f, 95.0f);
                instancePath2.lineTo(140.0f, 113.0f);
                instancePath2.lineTo(148.0f, 113.0f);
                instancePath2.lineTo(148.0f, 95.0f);
                instancePath2.lineTo(166.0f, 95.0f);
                instancePath2.lineTo(166.0f, 87.0f);
                instancePath2.lineTo(148.0f, 87.0f);
                instancePath2.lineTo(148.0f, 69.0f);
                instancePath2.lineTo(140.0f, 69.0f);
                instancePath2.lineTo(140.0f, 87.0f);
                instancePath2.close();
                instancePath2.moveTo(96.31254f, 40.209396f);
                instancePath2.cubicTo(101.09022f, 43.690666f, 104.68676f, 48.525387f, 106.36096f, 54.364017f);
                instancePath2.cubicTo(107.8931f, 59.70722f, 107.61439f, 65.19055f, 105.86462f, 70.28578f);
                instancePath2.lineTo(105.86462f, 70.28578f);
                instancePath2.cubicTo(104.484924f, 75.030106f, 101.48369f, 81.01255f, 95.0f, 86.0f);
                instancePath2.cubicTo(82.0f, 96.0f, 99.0f, 106.0f, 99.0f, 106.0f);
                instancePath2.cubicTo(118.0f, 124.0f, 112.0f, 135.0f, 112.0f, 135.0f);
                instancePath2.cubicTo(112.0f, 150.0f, 90.0f, 163.0f, 72.5f, 162.0f);
                instancePath2.cubicTo(48.0f, 162.0f, 34.0f, 156.52707f, 34.0f, 136.52707f);
                instancePath2.cubicTo(34.0f, 122.71995f, 51.237038f, 111.0f, 72.5f, 111.0f);
                instancePath2.cubicTo(74.54437f, 111.0f, 76.560776f, 111.0832f, 78.53569f, 111.246925f);
                instancePath2.cubicTo(76.75574f, 109.66964f, 74.56886f, 106.982025f, 74.0f, 103.0f);
                instancePath2.cubicTo(73.25283f, 97.76979f, 74.73872f, 94.214386f, 75.537834f, 92.7509f);
                instancePath2.cubicTo(60.421795f, 94.132095f, 46.47764f, 86.022766f, 42.63904f, 72.63599f);
                instancePath2.cubicTo(38.214382f, 57.20536f, 48.892124f, 40.606052f, 66.48845f, 35.56039f);
                instancePath2.cubicTo(70.87893f, 34.301437f, 75.2853f, 33.880722f, 79.49503f, 34.198013f);
                instancePath2.lineTo(79.0f, 34.0f);
                instancePath2.lineTo(116.0f, 34.0f);
                instancePath2.cubicTo(116.0f, 34.0f, 111.0f, 39.0f, 107.0f, 40.0f);
                instancePath2.cubicTo(104.282f, 40.6795f, 99.2554f, 40.43556f, 96.31254f, 40.209396f);
                instancePath2.lineTo(96.31254f, 40.209396f);
                instancePath2.close();
                instancePath2.moveTo(100.48076f, 130.73825f);
                instancePath2.cubicTo(100.82511f, 132.25267f, 101.0f, 133.84477f, 101.0f, 135.5f);
                instancePath2.cubicTo(101.0f, 147.37411f, 92.0f, 157.0f, 75.0f, 155.0f);
                instancePath2.cubicTo(58.0f, 153.0f, 49.0f, 146.87411f, 49.0f, 135.0f);
                instancePath2.cubicTo(49.0f, 123.12588f, 60.0f, 115.0f, 76.0f, 115.0f);
                instancePath2.cubicTo(79.35174f, 115.0f, 82.39629f, 115.37853f, 85.11528f, 116.08617f);
                instancePath2.cubicTo(89.293495f, 119.02377f, 96.63141f, 124.699265f, 100.48076f, 130.73825f);
                instancePath2.lineTo(100.48076f, 130.73825f);
                instancePath2.close();
                instancePath2.moveTo(82.16609f, 87.41669f);
                instancePath2.cubicTo(91.32285f, 84.61718f, 95.541954f, 71.86817f, 91.589714f, 58.94097f);
                instancePath2.cubicTo(87.637474f, 46.01377f, 77.01052f, 37.80365f, 67.85375f, 40.603157f);
                instancePath2.cubicTo(58.696987f, 43.40266f, 54.477886f, 56.151672f, 58.43013f, 69.07887f);
                instancePath2.cubicTo(62.38237f, 82.00607f, 73.00932f, 90.216194f, 82.16609f, 87.41669f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
