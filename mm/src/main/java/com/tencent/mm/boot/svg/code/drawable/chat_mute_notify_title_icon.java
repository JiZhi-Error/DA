package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chat_mute_notify_title_icon extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                canvas.saveLayerAlpha(null, 76, 31);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(37.233665f, 33.873493f);
                instancePath.lineTo(44.40146f, 41.041286f);
                instancePath.lineTo(42.72137f, 42.72137f);
                instancePath.lineTo(9.600087f, 9.600086f);
                instancePath.lineTo(11.280172f, 7.92f);
                instancePath.lineTo(15.06498f, 11.704807f);
                instancePath.cubicTo(16.369446f, 10.304305f, 18.008224f, 9.2193365f, 19.854246f, 8.57697f);
                instancePath.cubicTo(19.818567f, 8.363288f, 19.8f, 8.143812f, 19.8f, 7.92f);
                instancePath.cubicTo(19.8f, 5.7329526f, 21.572952f, 3.96f, 23.76f, 3.96f);
                instancePath.cubicTo(25.947048f, 3.96f, 27.72f, 5.7329526f, 27.72f, 7.92f);
                instancePath.cubicTo(27.72f, 8.143812f, 27.701433f, 8.363288f, 27.665754f, 8.57697f);
                instancePath.cubicTo(32.30823f, 10.192428f, 35.64f, 14.607125f, 35.64f, 19.8f);
                instancePath.lineTo(35.64f, 27.72f);
                instancePath.cubicTo(35.64f, 29.771164f, 36.171223f, 31.822327f, 37.233665f, 33.873493f);
                instancePath.close();
                instancePath.moveTo(36.239826f, 39.6f);
                instancePath.lineTo(5.94f, 39.6f);
                instancePath.cubicTo(9.9f, 35.64f, 11.88f, 31.68f, 11.88f, 27.72f);
                instancePath.lineTo(11.88f, 19.8f);
                instancePath.cubicTo(11.88f, 18.432533f, 12.111043f, 17.11903f, 12.536222f, 15.896395f);
                instancePath.lineTo(36.239826f, 39.6f);
                instancePath.close();
                instancePath.moveTo(21.78f, 41.58f);
                instancePath.lineTo(25.74f, 41.58f);
                instancePath.lineTo(25.74f, 41.976f);
                instancePath.cubicTo(25.74f, 43.069523f, 24.853523f, 43.956f, 23.76f, 43.956f);
                instancePath.cubicTo(22.666475f, 43.956f, 21.78f, 43.069523f, 21.78f, 41.976f);
                instancePath.lineTo(21.78f, 41.58f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
