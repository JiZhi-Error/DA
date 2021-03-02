package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_search extends c {
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
                instancePath.moveTo(41.0f, 65.0f);
                instancePath.cubicTo(28.297495f, 65.0f, 18.0f, 54.702503f, 18.0f, 42.0f);
                instancePath.cubicTo(18.0f, 29.297495f, 28.297495f, 19.0f, 41.0f, 19.0f);
                instancePath.cubicTo(53.702503f, 19.0f, 64.0f, 29.297495f, 64.0f, 42.0f);
                instancePath.cubicTo(64.0f, 54.702503f, 53.702503f, 65.0f, 41.0f, 65.0f);
                instancePath.lineTo(41.0f, 65.0f);
                instancePath.close();
                instancePath.moveTo(85.0f, 78.0f);
                instancePath.lineTo(66.0f, 61.0f);
                instancePath.cubicTo(70.123146f, 55.956898f, 72.5f, 49.400074f, 73.0f, 42.0f);
                instancePath.cubicTo(72.5f, 25.006767f, 58.508797f, 11.0f, 41.0f, 11.0f);
                instancePath.cubicTo(23.991203f, 11.0f, 10.0f, 25.006767f, 10.0f, 42.0f);
                instancePath.cubicTo(10.0f, 59.562756f, 23.991203f, 73.56952f, 41.0f, 74.0f);
                instancePath.cubicTo(48.358334f, 73.56952f, 54.908794f, 71.18956f, 60.0f, 67.0f);
                instancePath.lineTo(77.0f, 86.0f);
                instancePath.lineTo(85.0f, 78.0f);
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
