package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class msg_tip_light_bg extends c {
    private final int height = 36;
    private final int width = 70;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 70;
            case 1:
                return 36;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(66.0f, 0.0f);
                instancePath.cubicTo(68.20914f, -4.3300316E-15f, 70.0f, 1.790861f, 70.0f, 4.0f);
                instancePath.lineTo(70.0f, 32.0f);
                instancePath.cubicTo(70.0f, 34.20914f, 68.20914f, 36.0f, 66.0f, 36.0f);
                instancePath.lineTo(9.997025f, 36.0f);
                instancePath.cubicTo(7.7878857f, 36.0f, 5.9970245f, 34.20914f, 5.9970245f, 32.0f);
                instancePath.lineTo(5.997f, 23.449f);
                instancePath.lineTo(0.3233518f, 18.237267f);
                instancePath.cubicTo(0.312943f, 18.227705f, 0.30273932f, 18.217924f, 0.29274738f, 18.207933f);
                instancePath.lineTo(0.26341373f, 18.177328f);
                instancePath.cubicTo(-0.11020822f, 17.770603f, -0.08337304f, 17.138008f, 0.3233518f, 16.764385f);
                instancePath.lineTo(0.3233518f, 16.764385f);
                instancePath.lineTo(5.997f, 11.551f);
                instancePath.lineTo(5.9970245f, 4.0f);
                instancePath.cubicTo(5.9970245f, 1.790861f, 7.7878857f, 4.0581224E-16f, 9.997025f, 0.0f);
                instancePath.lineTo(66.0f, 0.0f);
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
