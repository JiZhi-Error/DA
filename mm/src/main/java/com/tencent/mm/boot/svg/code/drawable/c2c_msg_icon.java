package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class c2c_msg_icon extends c {
    private final int height = 50;
    private final int width = 47;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 47;
            case 1:
                return 50;
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
                instancePaint3.setColor(-3355444);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(25.0f, 0.0f);
                instancePath.cubicTo(32.22f, 3.53f, 39.56f, 5.91f, 47.0f, 8.0f);
                instancePath.lineTo(47.0f, 17.0f);
                instancePath.cubicTo(45.57f, 25.23f, 44.335155f, 42.1625f, 23.5f, 50.0f);
                instancePath.cubicTo(2.3484375f, 42.671486f, 1.27f, 23.62f, 0.0f, 16.0f);
                instancePath.lineTo(0.0f, 8.0f);
                instancePath.cubicTo(7.48f, 5.95f, 14.89f, 3.62f, 22.0f, 0.0f);
                instancePath.lineTo(25.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(13.723477f, 35.03351f);
                instancePath.cubicTo(15.033922f, 34.624176f, 18.0f, 33.0f, 18.0f, 33.0f);
                instancePath.cubicTo(18.0f, 33.0f, 21.632812f, 34.032497f, 24.0f, 33.91982f);
                instancePath.cubicTo(29.694897f, 34.032497f, 37.07939f, 29.353098f, 37.03392f, 22.234169f);
                instancePath.cubicTo(37.001835f, 17.474546f, 31.714815f, 12.0f, 24.0f, 12.0f);
                instancePath.cubicTo(17.745829f, 12.0f, 11.291461f, 15.644713f, 11.042147f, 22.234169f);
                instancePath.cubicTo(11.042147f, 26.79235f, 12.733758f, 29.797903f, 14.712788f, 31.306128f);
                instancePath.cubicTo(14.712788f, 31.306128f, 14.148407f, 33.51768f, 13.723477f, 35.03351f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(20.0f, 23.0f);
                instancePath2.cubicTo(21.10457f, 23.0f, 22.0f, 22.10457f, 22.0f, 21.0f);
                instancePath2.cubicTo(22.0f, 19.89543f, 21.10457f, 19.0f, 20.0f, 19.0f);
                instancePath2.cubicTo(18.89543f, 19.0f, 18.0f, 19.89543f, 18.0f, 21.0f);
                instancePath2.cubicTo(18.0f, 22.10457f, 18.89543f, 23.0f, 20.0f, 23.0f);
                instancePath2.lineTo(20.0f, 23.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(29.0f, 23.0f);
                instancePath3.cubicTo(30.10457f, 23.0f, 31.0f, 22.10457f, 31.0f, 21.0f);
                instancePath3.cubicTo(31.0f, 19.89543f, 30.10457f, 19.0f, 29.0f, 19.0f);
                instancePath3.cubicTo(27.89543f, 19.0f, 27.0f, 19.89543f, 27.0f, 21.0f);
                instancePath3.cubicTo(27.0f, 22.10457f, 27.89543f, 23.0f, 29.0f, 23.0f);
                instancePath3.lineTo(29.0f, 23.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
