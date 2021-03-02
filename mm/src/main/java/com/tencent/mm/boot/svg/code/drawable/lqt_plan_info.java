package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class lqt_plan_info extends c {
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
                instancePaint3.setColor(-8421505);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.0f, 61.0f);
                instancePath.cubicTo(22.19288f, 61.0f, 11.0f, 49.807117f, 11.0f, 36.0f);
                instancePath.cubicTo(11.0f, 22.19288f, 22.19288f, 11.0f, 36.0f, 11.0f);
                instancePath.cubicTo(49.807117f, 11.0f, 61.0f, 22.19288f, 61.0f, 36.0f);
                instancePath.cubicTo(61.0f, 49.807117f, 49.807117f, 61.0f, 36.0f, 61.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 58.0f);
                instancePath.cubicTo(48.150265f, 58.0f, 58.0f, 48.150265f, 58.0f, 36.0f);
                instancePath.cubicTo(58.0f, 23.849735f, 48.150265f, 14.0f, 36.0f, 14.0f);
                instancePath.cubicTo(23.849735f, 14.0f, 14.0f, 23.849735f, 14.0f, 36.0f);
                instancePath.cubicTo(14.0f, 48.150265f, 23.849735f, 58.0f, 36.0f, 58.0f);
                instancePath.close();
                instancePath.moveTo(34.5f, 31.0f);
                instancePath.lineTo(37.5f, 31.0f);
                instancePath.lineTo(37.5f, 48.5f);
                instancePath.lineTo(34.5f, 48.5f);
                instancePath.lineTo(34.5f, 31.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 28.5f);
                instancePath.cubicTo(34.61929f, 28.5f, 33.5f, 27.380713f, 33.5f, 26.0f);
                instancePath.cubicTo(33.5f, 24.619287f, 34.61929f, 23.5f, 36.0f, 23.5f);
                instancePath.cubicTo(37.38071f, 23.5f, 38.5f, 24.619287f, 38.5f, 26.0f);
                instancePath.cubicTo(38.5f, 27.380713f, 37.38071f, 28.5f, 36.0f, 28.5f);
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
