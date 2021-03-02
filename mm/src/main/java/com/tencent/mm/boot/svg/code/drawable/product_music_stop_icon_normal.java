package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class product_music_stop_icon_normal extends c {
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
                instancePaint3.setColor(-6710887);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(34.0f, 0.0f);
                instancePath.lineTo(37.77f, 0.0f);
                instancePath.cubicTo(46.83f, 0.56f, 55.72f, 4.44f, 61.96f, 11.09f);
                instancePath.cubicTo(67.89f, 17.18f, 71.41f, 25.42f, 72.0f, 33.88f);
                instancePath.lineTo(72.0f, 37.76f);
                instancePath.cubicTo(71.52f, 46.61f, 67.74f, 55.23f, 61.42f, 61.47f);
                instancePath.cubicTo(55.3f, 67.71f, 46.82f, 71.34f, 38.15f, 72.0f);
                instancePath.lineTo(34.35f, 72.0f);
                instancePath.cubicTo(25.49f, 71.52f, 16.81f, 67.81f, 10.58f, 61.46f);
                instancePath.cubicTo(4.3f, 55.27f, 0.55f, 46.73f, 0.0f, 37.95f);
                instancePath.lineTo(0.0f, 34.45f);
                instancePath.cubicTo(0.43f, 24.82f, 4.87f, 15.48f, 12.1f, 9.1f);
                instancePath.cubicTo(18.08f, 3.66f, 25.97f, 0.6f, 34.0f, 0.0f);
                instancePath.lineTo(34.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(29.41f, 3.66f);
                instancePath.cubicTo(18.26f, 5.87f, 8.62f, 14.23f, 4.9f, 24.97f);
                instancePath.cubicTo(0.62f, 36.67f, 3.76f, 50.63f, 12.68f, 59.33f);
                instancePath.cubicTo(22.99f, 69.98f, 40.66f, 72.12f, 53.18f, 64.16f);
                instancePath.cubicTo(66.79f, 56.23f, 72.81f, 37.9f, 66.52f, 23.45f);
                instancePath.cubicTo(60.91f, 9.13f, 44.44f, 0.29f, 29.41f, 3.66f);
                instancePath.lineTo(29.41f, 3.66f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(24.0f, 24.0f);
                instancePath2.lineTo(48.0f, 24.0f);
                instancePath2.lineTo(48.0f, 48.0f);
                instancePath2.lineTo(24.0f, 48.0f);
                instancePath2.lineTo(24.0f, 24.0f);
                instancePath2.lineTo(24.0f, 24.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
