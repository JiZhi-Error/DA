package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_music_off extends c {
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
                instancePath.moveTo(27.992208f, 18.628246f);
                instancePath.lineTo(52.969006f, 43.605045f);
                instancePath.cubicTo(53.607788f, 43.046383f, 54.0f, 42.22757f, 54.0f, 41.334625f);
                instancePath.lineTo(54.0f, 12.926538f);
                instancePath.lineTo(27.992208f, 18.628246f);
                instancePath.close();
                instancePath.moveTo(58.5f, 49.13604f);
                instancePath.lineTo(66.27565f, 56.91169f);
                instancePath.lineTo(63.09367f, 60.09367f);
                instancePath.lineTo(12.18198f, 9.18198f);
                instancePath.lineTo(15.363961f, 6.0f);
                instancePath.lineTo(23.873346f, 14.509386f);
                instancePath.lineTo(56.679108f, 7.3249645f);
                instancePath.cubicTo(57.488354f, 7.1477404f, 58.288048f, 7.660097f, 58.465275f, 8.469345f);
                instancePath.cubicTo(58.488358f, 8.574749f, 58.5f, 8.682337f, 58.5f, 8.790238f);
                instancePath.lineTo(58.5f, 49.13604f);
                instancePath.close();
                instancePath.moveTo(24.0f, 27.36396f);
                instancePath.lineTo(24.0f, 57.603806f);
                instancePath.cubicTo(24.0f, 60.412968f, 22.11874f, 63.15209f, 19.588413f, 64.3322f);
                instancePath.cubicTo(19.118036f, 64.551575f, 16.14658f, 65.21572f, 15.758582f, 65.29378f);
                instancePath.cubicTo(12.030496f, 66.043785f, 9.166035f, 62.850475f, 9.008285f, 59.62134f);
                instancePath.cubicTo(8.850535f, 56.39221f, 10.96819f, 53.699585f, 13.425209f, 53.205288f);
                instancePath.lineTo(17.218742f, 52.253464f);
                instancePath.cubicTo(18.559702f, 51.917004f, 19.5f, 50.711636f, 19.5f, 49.32911f);
                instancePath.lineTo(19.5f, 22.86396f);
                instancePath.lineTo(24.0f, 27.36396f);
                instancePath.close();
                instancePath.moveTo(53.232395f, 56.596355f);
                instancePath.cubicTo(52.16537f, 56.877518f, 50.474274f, 57.250546f, 50.187023f, 57.30784f);
                instancePath.cubicTo(46.426563f, 58.057846f, 43.53723f, 54.864536f, 43.37811f, 51.635403f);
                instancePath.cubicTo(43.306374f, 50.179596f, 43.701134f, 48.83284f, 44.383442f, 47.747402f);
                instancePath.lineTo(53.232395f, 56.596355f);
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
