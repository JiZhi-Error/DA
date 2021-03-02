package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_jd_index extends c {
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
                instancePath.moveTo(69.0f, 73.0f);
                instancePath.cubicTo(69.0f, 75.18871f, 67.16411f, 77.0f, 65.0f, 77.0f);
                instancePath.lineTo(57.0f, 77.0f);
                instancePath.lineTo(57.0f, 57.0f);
                instancePath.lineTo(40.0f, 57.0f);
                instancePath.lineTo(40.0f, 77.0f);
                instancePath.lineTo(32.0f, 77.0f);
                instancePath.cubicTo(29.835434f, 77.0f, 28.0f, 75.18871f, 28.0f, 73.0f);
                instancePath.lineTo(28.0f, 38.0f);
                instancePath.lineTo(49.0f, 18.0f);
                instancePath.lineTo(69.0f, 38.0f);
                instancePath.lineTo(69.0f, 73.0f);
                instancePath.close();
                instancePath.moveTo(52.0f, 9.0f);
                instancePath.lineTo(52.0f, 9.0f);
                instancePath.cubicTo(50.78988f, 8.532246f, 49.708397f, 8.0f, 49.0f, 8.0f);
                instancePath.cubicTo(47.291603f, 8.0f, 46.21012f, 8.532246f, 45.0f, 9.0f);
                instancePath.lineTo(45.0f, 9.0f);
                instancePath.lineTo(8.0f, 47.0f);
                instancePath.lineTo(14.0f, 53.0f);
                instancePath.lineTo(20.0f, 46.0f);
                instancePath.lineTo(20.0f, 73.0f);
                instancePath.cubicTo(20.146534f, 79.55686f, 25.5868f, 85.0f, 32.0f, 85.0f);
                instancePath.lineTo(40.0f, 85.0f);
                instancePath.lineTo(57.0f, 85.0f);
                instancePath.lineTo(65.0f, 85.0f);
                instancePath.cubicTo(71.4132f, 85.0f, 76.85346f, 79.55686f, 77.0f, 73.0f);
                instancePath.lineTo(77.0f, 46.0f);
                instancePath.lineTo(83.0f, 53.0f);
                instancePath.lineTo(89.0f, 47.0f);
                instancePath.lineTo(52.0f, 9.0f);
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
