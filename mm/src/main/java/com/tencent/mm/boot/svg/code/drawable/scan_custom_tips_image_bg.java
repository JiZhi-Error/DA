package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class scan_custom_tips_image_bg extends c {
    private final int height = 279;
    private final int width = 264;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 264;
            case 1:
                return 279;
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
                instancePaint3.setColor(-421667363);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(24.0f, 264.0f);
                instancePath.cubicTo(10.745166f, 264.0f, 0.0f, 253.25484f, 0.0f, 240.0f);
                instancePath.lineTo(0.0f, 24.0f);
                instancePath.cubicTo(0.0f, 10.745166f, 10.745166f, -2.1316282E-13f, 24.0f, -2.1316282E-13f);
                instancePath.lineTo(240.0f, -2.1316282E-13f);
                instancePath.cubicTo(253.25484f, -2.1316282E-13f, 264.0f, 10.745166f, 264.0f, 24.0f);
                instancePath.lineTo(264.0f, 240.0f);
                instancePath.cubicTo(264.0f, 253.25484f, 253.25484f, 264.0f, 240.0f, 264.0f);
                instancePath.lineTo(148.97057f, 264.0f);
                instancePath.lineTo(136.24265f, 276.72794f);
                instancePath.cubicTo(133.89949f, 279.07108f, 130.10051f, 279.07108f, 127.75736f, 276.72794f);
                instancePath.lineTo(115.029434f, 264.0f);
                instancePath.lineTo(24.0f, 264.0f);
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