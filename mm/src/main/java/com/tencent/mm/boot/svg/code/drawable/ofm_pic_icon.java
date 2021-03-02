package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ofm_pic_icon extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(78.0f, 23.0f);
                instancePath.lineTo(18.0f, 23.0f);
                instancePath.cubicTo(16.344f, 23.0f, 15.0f, 24.343f, 15.0f, 26.0f);
                instancePath.lineTo(15.0f, 70.0f);
                instancePath.cubicTo(15.0f, 71.657f, 16.344f, 73.0f, 18.0f, 73.0f);
                instancePath.lineTo(78.0f, 73.0f);
                instancePath.cubicTo(79.656f, 73.0f, 81.0f, 71.657f, 81.0f, 70.0f);
                instancePath.lineTo(81.0f, 26.0f);
                instancePath.cubicTo(81.0f, 24.343f, 79.656f, 23.0f, 78.0f, 23.0f);
                instancePath.close();
                instancePath.moveTo(76.0f, 59.0f);
                instancePath.cubicTo(73.152f, 54.088184f, 68.083f, 47.354908f, 63.744f, 47.354908f);
                instancePath.cubicTo(62.005f, 47.354908f, 58.828f, 49.3773f, 55.663f, 52.12908f);
                instancePath.cubicTo(56.991f, 55.097874f, 58.811f, 58.14101f, 58.8f, 58.14101f);
                instancePath.cubicTo(57.888f, 58.14101f, 55.199f, 53.835007f, 55.199f, 53.835007f);
                instancePath.cubicTo(55.026f, 53.55973f, 54.844f, 53.290478f, 54.659f, 53.026253f);
                instancePath.cubicTo(54.605f, 53.07548f, 54.552f, 53.123703f, 54.498f, 53.17293f);
                instancePath.cubicTo(51.521f, 49.35821f, 45.061f, 40.19967f, 39.359f, 40.19967f);
                instancePath.cubicTo(35.016f, 40.19967f, 24.034f, 50.0655f, 20.0f, 57.164474f);
                instancePath.lineTo(20.0f, 28.0f);
                instancePath.lineTo(76.0f, 28.0f);
                instancePath.lineTo(76.0f, 59.0f);
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
