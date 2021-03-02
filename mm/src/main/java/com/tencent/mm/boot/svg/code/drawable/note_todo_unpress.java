package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class note_todo_unpress extends c {
    private final int height = 144;
    private final int width = 144;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-855638017);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 28.8f);
                instancePath.cubicTo(0.0f, 12.894198f, 12.894198f, 0.0f, 28.8f, 0.0f);
                instancePath.lineTo(115.2f, 0.0f);
                instancePath.cubicTo(131.1058f, 0.0f, 144.0f, 12.894198f, 144.0f, 28.8f);
                instancePath.lineTo(144.0f, 115.2f);
                instancePath.cubicTo(144.0f, 131.1058f, 131.1058f, 144.0f, 115.2f, 144.0f);
                instancePath.lineTo(28.8f, 144.0f);
                instancePath.cubicTo(12.894198f, 144.0f, 0.0f, 131.1058f, 0.0f, 115.2f);
                instancePath.lineTo(0.0f, 28.8f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-14477034);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(94.2f, 67.7346f);
                instancePath2.lineTo(94.2f, 89.8806f);
                instancePath2.cubicTo(94.2f, 92.2656f, 92.265f, 94.2006f, 89.88f, 94.2006f);
                instancePath2.lineTo(55.32f, 94.2006f);
                instancePath2.cubicTo(52.935f, 94.2006f, 51.0f, 92.2656f, 51.0f, 89.8806f);
                instancePath2.lineTo(51.0f, 55.3206f);
                instancePath2.cubicTo(51.0f, 52.9326f, 52.935f, 51.0006f, 55.32f, 51.0006f);
                instancePath2.lineTo(89.88f, 51.0006f);
                instancePath2.cubicTo(90.219f, 51.0006f, 90.552f, 51.0396f, 90.867f, 51.1146f);
                instancePath2.lineTo(87.6f, 54.6006f);
                instancePath2.lineTo(55.32f, 54.6006f);
                instancePath2.cubicTo(54.921f, 54.6006f, 54.6f, 54.9216f, 54.6f, 55.3206f);
                instancePath2.lineTo(54.6f, 89.8806f);
                instancePath2.cubicTo(54.6f, 90.2766f, 54.921f, 90.6006f, 55.32f, 90.6006f);
                instancePath2.lineTo(89.88f, 90.6006f);
                instancePath2.cubicTo(90.279f, 90.6006f, 90.6f, 90.2766f, 90.6f, 89.8806f);
                instancePath2.lineTo(90.6f, 71.5746f);
                instancePath2.lineTo(94.2f, 67.7346f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                instancePaint7.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint7.setStrokeWidth(3.6f);
                instancePaint7.setStrokeCap(Paint.Cap.SQUARE);
                instancePaint7.setStrokeJoin(Paint.Join.MITER);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(63.648f, 67.40708f);
                instancePath3.lineTo(73.50063f, 78.48f);
                instancePath3.lineTo(96.0f, 54.48867f);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
