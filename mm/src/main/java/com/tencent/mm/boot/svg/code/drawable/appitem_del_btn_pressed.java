package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class appitem_del_btn_pressed extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-3194563);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(28.0f, 0.0f);
                instancePath.lineTo(31.91f, 0.0f);
                instancePath.cubicTo(46.53f, 0.77f, 59.15f, 13.36f, 60.0f, 27.97f);
                instancePath.lineTo(60.0f, 31.8f);
                instancePath.cubicTo(59.3f, 46.69f, 46.27f, 59.57f, 31.35f, 60.0f);
                instancePath.lineTo(28.48f, 60.0f);
                instancePath.cubicTo(13.76f, 59.47f, 0.96f, 46.87f, 0.0f, 32.2f);
                instancePath.lineTo(0.0f, 28.26f);
                instancePath.cubicTo(0.67f, 13.56f, 13.33f, 0.84f, 28.0f, 0.0f);
                instancePath.moveTo(13.35f, 25.51f);
                instancePath.cubicTo(11.47f, 26.71f, 12.06f, 29.22f, 11.97f, 31.09f);
                instancePath.cubicTo(11.7f, 32.88f, 12.89f, 35.05f, 14.89f, 34.94f);
                instancePath.cubicTo(24.63f, 35.08f, 34.38f, 34.97f, 44.13f, 34.99f);
                instancePath.cubicTo(45.92f, 35.31f, 47.97f, 34.09f, 47.96f, 32.14f);
                instancePath.cubicTo(47.98f, 29.78f, 48.76f, 26.29f, 45.99f, 25.15f);
                instancePath.cubicTo(36.69f, 24.77f, 27.35f, 25.14f, 18.04f, 24.98f);
                instancePath.cubicTo(16.5f, 25.15f, 14.73f, 24.65f, 13.35f, 25.51f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-665128);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(13.35f, 25.51f);
                instancePath2.cubicTo(14.73f, 24.65f, 16.5f, 25.15f, 18.04f, 24.98f);
                instancePath2.cubicTo(27.35f, 25.14f, 36.69f, 24.77f, 45.99f, 25.15f);
                instancePath2.cubicTo(48.76f, 26.29f, 47.98f, 29.78f, 47.96f, 32.14f);
                instancePath2.cubicTo(47.97f, 34.09f, 45.92f, 35.31f, 44.13f, 34.99f);
                instancePath2.cubicTo(34.38f, 34.97f, 24.63f, 35.08f, 14.89f, 34.94f);
                instancePath2.cubicTo(12.89f, 35.05f, 11.7f, 32.88f, 11.97f, 31.09f);
                instancePath2.cubicTo(12.06f, 29.22f, 11.47f, 26.71f, 13.35f, 25.51f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
