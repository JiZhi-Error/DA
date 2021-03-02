package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_font extends c {
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
                instancePaint3.setColor(-8683387);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(79.0f, 66.0f);
                instancePath.cubicTo(79.0f, 69.816f, 77.14933f, 73.0f, 73.0f, 73.0f);
                instancePath.lineTo(71.0f, 73.0f);
                instancePath.cubicTo(68.790665f, 73.0f, 67.0f, 71.209335f, 67.0f, 69.0f);
                instancePath.cubicTo(67.0f, 66.790665f, 68.790665f, 65.0f, 71.0f, 65.0f);
                instancePath.lineTo(79.0f, 65.0f);
                instancePath.lineTo(79.0f, 66.0f);
                instancePath.close();
                instancePath.moveTo(88.0f, 63.0f);
                instancePath.lineTo(88.0f, 56.0f);
                instancePath.lineTo(88.0f, 56.0f);
                instancePath.lineTo(88.0f, 56.0f);
                instancePath.lineTo(88.0f, 53.0f);
                instancePath.cubicTo(87.62795f, 46.030872f, 82.82739f, 40.0f, 74.0f, 40.0f);
                instancePath.cubicTo(65.76251f, 40.0f, 60.369316f, 44.77833f, 60.0f, 52.0f);
                instancePath.lineTo(60.0f, 52.0f);
                instancePath.lineTo(69.0f, 52.0f);
                instancePath.cubicTo(69.03787f, 49.75115f, 70.876205f, 48.206196f, 74.0f, 48.0f);
                instancePath.cubicTo(77.81914f, 48.206196f, 79.44887f, 50.382885f, 79.0f, 53.0f);
                instancePath.lineTo(79.0f, 56.0f);
                instancePath.lineTo(79.0f, 56.0f);
                instancePath.lineTo(79.0f, 56.0f);
                instancePath.lineTo(71.0f, 56.0f);
                instancePath.cubicTo(64.02007f, 56.401913f, 59.0f, 61.49816f, 59.0f, 69.0f);
                instancePath.lineTo(59.0f, 69.0f);
                instancePath.cubicTo(59.0f, 75.9452f, 64.09324f, 80.99727f, 71.0f, 81.0f);
                instancePath.lineTo(72.0f, 81.0f);
                instancePath.cubicTo(75.0855f, 80.99727f, 77.94593f, 80.10591f, 80.0f, 79.0f);
                instancePath.cubicTo(80.66957f, 80.370995f, 80.938614f, 81.0f, 81.0f, 81.0f);
                instancePath.lineTo(89.0f, 81.0f);
                instancePath.cubicTo(89.0f, 81.0f, 87.63159f, 77.32937f, 88.0f, 63.0f);
                instancePath.lineTo(88.0f, 63.0f);
                instancePath.close();
                instancePath.moveTo(22.0f, 56.0f);
                instancePath.lineTo(28.0f, 32.0f);
                instancePath.lineTo(34.0f, 56.0f);
                instancePath.lineTo(22.0f, 56.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 16.0f);
                instancePath.lineTo(32.0f, 16.0f);
                instancePath.lineTo(24.0f, 16.0f);
                instancePath.lineTo(24.0f, 16.0f);
                instancePath.lineTo(10.0f, 73.0f);
                instancePath.lineTo(6.0f, 73.0f);
                instancePath.lineTo(6.0f, 81.0f);
                instancePath.lineTo(22.0f, 81.0f);
                instancePath.lineTo(22.0f, 73.0f);
                instancePath.lineTo(18.0f, 73.0f);
                instancePath.lineTo(20.0f, 65.0f);
                instancePath.lineTo(37.0f, 65.0f);
                instancePath.lineTo(39.0f, 73.0f);
                instancePath.lineTo(35.0f, 73.0f);
                instancePath.lineTo(35.0f, 81.0f);
                instancePath.lineTo(55.0f, 81.0f);
                instancePath.lineTo(55.0f, 73.0f);
                instancePath.lineTo(51.0f, 73.0f);
                instancePath.lineTo(36.0f, 16.0f);
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
