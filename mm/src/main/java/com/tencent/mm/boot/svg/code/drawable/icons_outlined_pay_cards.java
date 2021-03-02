package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_pay_cards extends c {
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
                instancePath.moveTo(63.02459f, 12.0f);
                instancePath.cubicTo(64.66786f, 12.0f, 66.0f, 13.333893f, 66.0f, 15.002615f);
                instancePath.lineTo(66.0f, 56.997383f);
                instancePath.cubicTo(66.0f, 58.65568f, 64.63409f, 60.0f, 63.02459f, 60.0f);
                instancePath.lineTo(8.9754095f, 60.0f);
                instancePath.cubicTo(7.332136f, 60.0f, 6.0f, 58.666107f, 6.0f, 56.997383f);
                instancePath.lineTo(6.0f, 15.002615f);
                instancePath.cubicTo(6.0f, 13.3443165f, 7.3659167f, 12.0f, 8.9754095f, 12.0f);
                instancePath.lineTo(63.02459f, 12.0f);
                instancePath.close();
                instancePath.moveTo(62.4f, 15.6f);
                instancePath.lineTo(9.6f, 15.6f);
                instancePath.lineTo(9.6f, 56.4f);
                instancePath.lineTo(62.4f, 56.4f);
                instancePath.lineTo(62.4f, 15.6f);
                instancePath.close();
                instancePath.moveTo(57.0f, 24.0f);
                instancePath.lineTo(57.0f, 27.6f);
                instancePath.lineTo(15.0f, 27.6f);
                instancePath.lineTo(15.0f, 24.0f);
                instancePath.lineTo(57.0f, 24.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
