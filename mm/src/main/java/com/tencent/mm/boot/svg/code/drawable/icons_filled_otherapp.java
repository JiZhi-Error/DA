package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_otherapp extends c {
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
                instancePath.moveTo(59.15417f, 39.0f);
                instancePath.cubicTo(60.49145f, 39.0f, 60.97638f, 39.13924f, 61.465267f, 39.4007f);
                instancePath.cubicTo(61.95416f, 39.66216f, 62.33784f, 40.04584f, 62.5993f, 40.534733f);
                instancePath.cubicTo(62.86076f, 41.02362f, 63.0f, 41.50855f, 63.0f, 42.84583f);
                instancePath.lineTo(63.0f, 59.15417f);
                instancePath.cubicTo(63.0f, 60.49145f, 62.86076f, 60.97638f, 62.5993f, 61.465267f);
                instancePath.cubicTo(62.33784f, 61.95416f, 61.95416f, 62.33784f, 61.465267f, 62.5993f);
                instancePath.cubicTo(60.97638f, 62.86076f, 60.49145f, 63.0f, 59.15417f, 63.0f);
                instancePath.lineTo(42.84583f, 63.0f);
                instancePath.cubicTo(41.50855f, 63.0f, 41.02362f, 62.86076f, 40.534733f, 62.5993f);
                instancePath.cubicTo(40.04584f, 62.33784f, 39.66216f, 61.95416f, 39.4007f, 61.465267f);
                instancePath.cubicTo(39.13924f, 60.97638f, 39.0f, 60.49145f, 39.0f, 59.15417f);
                instancePath.lineTo(39.0f, 42.84583f);
                instancePath.cubicTo(39.0f, 41.50855f, 39.13924f, 41.02362f, 39.4007f, 40.534733f);
                instancePath.cubicTo(39.66216f, 40.04584f, 40.04584f, 39.66216f, 40.534733f, 39.4007f);
                instancePath.cubicTo(41.02362f, 39.13924f, 41.50855f, 39.0f, 42.84583f, 39.0f);
                instancePath.lineTo(59.15417f, 39.0f);
                instancePath.close();
                instancePath.moveTo(29.154173f, 39.0f);
                instancePath.cubicTo(30.49145f, 39.0f, 30.97638f, 39.13924f, 31.46527f, 39.4007f);
                instancePath.cubicTo(31.954157f, 39.66216f, 32.33784f, 40.04584f, 32.5993f, 40.534733f);
                instancePath.cubicTo(32.86076f, 41.02362f, 33.0f, 41.50855f, 33.0f, 42.84583f);
                instancePath.lineTo(33.0f, 59.15417f);
                instancePath.cubicTo(33.0f, 60.49145f, 32.86076f, 60.97638f, 32.5993f, 61.465267f);
                instancePath.cubicTo(32.33784f, 61.95416f, 31.954157f, 62.33784f, 31.46527f, 62.5993f);
                instancePath.cubicTo(30.97638f, 62.86076f, 30.49145f, 63.0f, 29.154173f, 63.0f);
                instancePath.lineTo(12.845828f, 63.0f);
                instancePath.cubicTo(11.50855f, 63.0f, 11.023621f, 62.86076f, 10.534732f, 62.5993f);
                instancePath.cubicTo(10.045842f, 62.33784f, 9.66216f, 61.95416f, 9.400699f, 61.465267f);
                instancePath.cubicTo(9.139238f, 60.97638f, 9.0f, 60.49145f, 9.0f, 59.15417f);
                instancePath.lineTo(9.0f, 42.84583f);
                instancePath.cubicTo(9.0f, 41.50855f, 9.139238f, 41.02362f, 9.400699f, 40.534733f);
                instancePath.cubicTo(9.66216f, 40.04584f, 10.045842f, 39.66216f, 10.534732f, 39.4007f);
                instancePath.cubicTo(11.023621f, 39.13924f, 11.50855f, 39.0f, 12.845828f, 39.0f);
                instancePath.lineTo(29.154173f, 39.0f);
                instancePath.close();
                instancePath.moveTo(59.15417f, 9.0f);
                instancePath.cubicTo(60.49145f, 9.0f, 60.97638f, 9.139238f, 61.465267f, 9.400699f);
                instancePath.cubicTo(61.95416f, 9.66216f, 62.33784f, 10.045842f, 62.5993f, 10.534732f);
                instancePath.cubicTo(62.86076f, 11.023621f, 63.0f, 11.50855f, 63.0f, 12.845828f);
                instancePath.lineTo(63.0f, 29.154173f);
                instancePath.cubicTo(63.0f, 30.49145f, 62.86076f, 30.97638f, 62.5993f, 31.46527f);
                instancePath.cubicTo(62.33784f, 31.954157f, 61.95416f, 32.33784f, 61.465267f, 32.5993f);
                instancePath.cubicTo(60.97638f, 32.86076f, 60.49145f, 33.0f, 59.15417f, 33.0f);
                instancePath.lineTo(42.84583f, 33.0f);
                instancePath.cubicTo(41.50855f, 33.0f, 41.02362f, 32.86076f, 40.534733f, 32.5993f);
                instancePath.cubicTo(40.04584f, 32.33784f, 39.66216f, 31.954157f, 39.4007f, 31.46527f);
                instancePath.cubicTo(39.13924f, 30.97638f, 39.0f, 30.49145f, 39.0f, 29.154173f);
                instancePath.lineTo(39.0f, 12.845828f);
                instancePath.cubicTo(39.0f, 11.50855f, 39.13924f, 11.023621f, 39.4007f, 10.534732f);
                instancePath.cubicTo(39.66216f, 10.045842f, 40.04584f, 9.66216f, 40.534733f, 9.400699f);
                instancePath.cubicTo(41.02362f, 9.139238f, 41.50855f, 9.0f, 42.84583f, 9.0f);
                instancePath.lineTo(59.15417f, 9.0f);
                instancePath.close();
                instancePath.moveTo(21.0f, 9.0f);
                instancePath.cubicTo(27.627417f, 9.0f, 33.0f, 14.372583f, 33.0f, 21.0f);
                instancePath.cubicTo(33.0f, 27.627417f, 27.627417f, 33.0f, 21.0f, 33.0f);
                instancePath.cubicTo(14.372583f, 33.0f, 9.0f, 27.627417f, 9.0f, 21.0f);
                instancePath.cubicTo(9.0f, 14.372583f, 14.372583f, 9.0f, 21.0f, 9.0f);
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
