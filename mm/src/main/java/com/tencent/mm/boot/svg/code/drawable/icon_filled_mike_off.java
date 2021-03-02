package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_filled_mike_off extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                instancePath.moveTo(16.803045f, 14.681725f);
                instancePath.cubicTo(17.246958f, 13.888364f, 17.5f, 12.973733f, 17.5f, 12.0f);
                instancePath.lineTo(17.5f, 10.0f);
                instancePath.lineTo(19.0f, 10.0f);
                instancePath.lineTo(19.0f, 12.0f);
                instancePath.cubicTo(19.0f, 13.390109f, 18.594795f, 14.685577f, 17.896053f, 15.774734f);
                instancePath.lineTo(22.091883f, 19.970562f);
                instancePath.lineTo(21.031223f, 21.031223f);
                instancePath.lineTo(4.0606604f, 4.0606604f);
                instancePath.lineTo(5.1213202f, 3.0f);
                instancePath.lineTo(8.001753f, 5.8804326f);
                instancePath.cubicTo(8.064982f, 3.7266023f, 9.830856f, 2.0f, 12.0f, 2.0f);
                instancePath.cubicTo(14.209139f, 2.0f, 16.0f, 3.790861f, 16.0f, 6.0f);
                instancePath.lineTo(16.0f, 12.0f);
                instancePath.cubicTo(16.0f, 12.554274f, 15.887263f, 13.082216f, 15.68347f, 13.562149f);
                instancePath.lineTo(16.803045f, 14.681725f);
                instancePath.lineTo(16.803045f, 14.681725f);
                instancePath.close();
                instancePath.moveTo(14.681725f, 16.803045f);
                instancePath.lineTo(15.774734f, 17.896053f);
                instancePath.cubicTo(14.884093f, 18.467438f, 13.8554945f, 18.842539f, 12.75f, 18.960293f);
                instancePath.lineTo(12.75f, 22.0f);
                instancePath.lineTo(11.25f, 22.0f);
                instancePath.lineTo(11.25f, 18.960293f);
                instancePath.cubicTo(7.736675f, 18.586063f, 5.0f, 15.612624f, 5.0f, 12.0f);
                instancePath.lineTo(5.0f, 10.0f);
                instancePath.lineTo(6.5f, 10.0f);
                instancePath.lineTo(6.5f, 12.0f);
                instancePath.cubicTo(6.5f, 15.037566f, 8.962434f, 17.5f, 12.0f, 17.5f);
                instancePath.cubicTo(12.973733f, 17.5f, 13.888364f, 17.246958f, 14.681725f, 16.803045f);
                instancePath.lineTo(14.681725f, 16.803045f);
                instancePath.close();
                instancePath.moveTo(13.562149f, 15.68347f);
                instancePath.cubicTo(13.082216f, 15.887263f, 12.554274f, 16.0f, 12.0f, 16.0f);
                instancePath.cubicTo(9.790861f, 16.0f, 8.0f, 14.209139f, 8.0f, 12.0f);
                instancePath.lineTo(8.0f, 10.121321f);
                instancePath.lineTo(13.562149f, 15.68347f);
                instancePath.lineTo(13.562149f, 15.68347f);
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
