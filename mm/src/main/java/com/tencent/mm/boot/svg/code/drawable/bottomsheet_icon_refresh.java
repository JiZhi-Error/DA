package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_refresh extends c {
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
                instancePath.moveTo(47.0f, 87.98775f);
                instancePath.cubicTo(25.370693f, 87.45702f, 8.0f, 69.75708f, 8.0f, 48.0f);
                instancePath.cubicTo(8.0f, 34.31184f, 14.875527f, 22.229542f, 25.36142f, 15.018275f);
                instancePath.lineTo(31.139889f, 20.796743f);
                instancePath.cubicTo(22.05139f, 26.441599f, 16.0f, 36.51411f, 16.0f, 48.0f);
                instancePath.cubicTo(16.0f, 65.338554f, 29.789598f, 79.456375f, 47.0f, 79.98467f);
                instancePath.lineTo(47.0f, 70.0f);
                instancePath.lineTo(65.0f, 88.0f);
                instancePath.lineTo(47.0f, 88.0f);
                instancePath.lineTo(47.0f, 87.98775f);
                instancePath.close();
                instancePath.moveTo(47.0f, 8.012256f);
                instancePath.cubicTo(47.332344f, 8.004101f, 47.66569f, 8.0f, 48.0f, 8.0f);
                instancePath.cubicTo(70.09139f, 8.0f, 88.0f, 25.90861f, 88.0f, 48.0f);
                instancePath.cubicTo(88.0f, 62.075714f, 80.72963f, 74.45335f, 69.73931f, 81.58246f);
                instancePath.lineTo(63.921238f, 75.76438f);
                instancePath.cubicTo(73.52948f, 70.24273f, 80.0f, 59.877f, 80.0f, 48.0f);
                instancePath.cubicTo(80.0f, 30.326887f, 65.67311f, 16.0f, 48.0f, 16.0f);
                instancePath.cubicTo(47.665443f, 16.0f, 47.332085f, 16.005135f, 47.0f, 16.015327f);
                instancePath.lineTo(47.0f, 26.0f);
                instancePath.lineTo(29.0f, 8.0f);
                instancePath.lineTo(47.0f, 8.0f);
                instancePath.lineTo(47.0f, 8.012256f);
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
