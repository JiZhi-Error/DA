package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_brand_profile extends c {
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
                instancePaint3.setColor(-8617851);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(48.0f, 80.0f);
                instancePath.lineTo(44.0f, 76.0f);
                instancePath.lineTo(48.0f, 64.0f);
                instancePath.lineTo(52.0f, 76.0f);
                instancePath.lineTo(48.0f, 80.0f);
                instancePath.close();
                instancePath.moveTo(78.666664f, 72.46489f);
                instancePath.lineTo(78.666664f, 72.44444f);
                instancePath.lineTo(58.234665f, 65.333336f);
                instancePath.lineTo(58.666668f, 65.333336f);
                instancePath.cubicTo(58.666668f, 65.333336f, 56.0f, 64.88355f, 56.0f, 62.666668f);
                instancePath.lineTo(56.0f, 64.55556f);
                instancePath.lineTo(56.0f, 64.55556f);
                instancePath.lineTo(56.0f, 61.333332f);
                instancePath.cubicTo(56.0f, 59.977333f, 57.333332f, 58.666668f, 57.333332f, 58.666668f);
                instancePath.lineTo(57.319557f, 58.666668f);
                instancePath.cubicTo(63.177776f, 54.190224f, 67.138664f, 45.516445f, 67.13022f, 35.05378f);
                instancePath.cubicTo(67.11867f, 21.260445f, 58.55467f, 12.0f, 48.0f, 12.0f);
                instancePath.cubicTo(37.44533f, 12.0f, 28.896444f, 21.260445f, 28.908f, 35.05378f);
                instancePath.cubicTo(28.916445f, 45.514668f, 32.88978f, 54.189335f, 38.753777f, 58.666668f);
                instancePath.lineTo(38.666668f, 58.666668f);
                instancePath.cubicTo(38.666668f, 58.666668f, 40.0f, 59.977333f, 40.0f, 61.333332f);
                instancePath.lineTo(40.0f, 62.666668f);
                instancePath.cubicTo(40.0f, 64.88355f, 37.333332f, 65.333336f, 37.333332f, 65.333336f);
                instancePath.lineTo(37.765335f, 65.333336f);
                instancePath.lineTo(17.333334f, 72.44444f);
                instancePath.lineTo(17.333334f, 72.46489f);
                instancePath.cubicTo(14.228f, 73.564445f, 12.0f, 76.51822f, 12.0f, 80.0f);
                instancePath.lineTo(12.0f, 84.0f);
                instancePath.lineTo(84.0f, 84.0f);
                instancePath.lineTo(84.0f, 80.0f);
                instancePath.cubicTo(84.0f, 76.51822f, 81.77155f, 73.564445f, 78.666664f, 72.46489f);
                instancePath.lineTo(78.666664f, 72.46489f);
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
