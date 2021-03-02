package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class navbar_chat_icon_focus extends c {
    private final int height = 84;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 84;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix instanceMatrix = c.instanceMatrix(looper);
                float[] instanceMatrixArray = c.instanceMatrixArray(looper);
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
                instancePaint3.setColor(-12206054);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 11.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(14.949f, 5.8425765f);
                instancePath.cubicTo(21.649f, 1.6792915f, 29.638f, -0.2605797f, 37.503f, 0.0289533f);
                instancePath.cubicTo(45.468f, 0.29652175f, 53.408f, 2.8893397f, 59.778f, 7.714557f);
                instancePath.cubicTo(62.781f, 9.984896f, 65.423f, 12.749436f, 67.47f, 15.911337f);
                instancePath.cubicTo(69.411f, 18.899517f, 70.805f, 22.249115f, 71.491f, 25.74747f);
                instancePath.cubicTo(72.316f, 29.922737f, 72.131f, 34.29269f, 70.953f, 38.38309f);
                instancePath.cubicTo(69.294f, 44.209694f, 65.656f, 49.37037f, 61.004f, 53.215168f);
                instancePath.cubicTo(55.825f, 57.515232f, 49.43f, 60.2638f, 42.799f, 61.347054f);
                instancePath.cubicTo(33.676f, 62.845634f, 24.002f, 61.304123f, 15.968f, 56.670597f);
                instancePath.cubicTo(10.646f, 58.412785f, 5.323f, 60.15697f, 0.0f, 61.90016f);
                instancePath.cubicTo(2.104f, 57.420387f, 4.21f, 52.942608f, 6.312f, 48.461834f);
                instancePath.cubicTo(3.922f, 45.468662f, 2.079f, 42.02522f, 1.034f, 38.337166f);
                instancePath.cubicTo(-0.644f, 32.51755f, -0.26f, 26.141836f, 2.082f, 20.557842f);
                instancePath.cubicTo(4.618f, 14.419743f, 9.327f, 9.31897f, 14.949f, 5.8425765f);
                instancePath.lineTo(14.949f, 5.8425765f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
