package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_lock extends c {
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
                instancePath.moveTo(22.5f, 27.0f);
                instancePath.lineTo(22.5f, 19.5f);
                instancePath.cubicTo(22.5f, 12.044156f, 28.544155f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(43.455845f, 6.0f, 49.5f, 12.044156f, 49.5f, 19.5f);
                instancePath.lineTo(49.5f, 27.0f);
                instancePath.lineTo(56.997383f, 27.0f);
                instancePath.cubicTo(58.65568f, 27.0f, 60.0f, 28.342468f, 60.0f, 29.995506f);
                instancePath.lineTo(60.0f, 63.004494f);
                instancePath.cubicTo(60.0f, 64.65887f, 58.666107f, 66.0f, 56.997383f, 66.0f);
                instancePath.lineTo(15.002615f, 66.0f);
                instancePath.cubicTo(13.3443165f, 66.0f, 12.0f, 64.65753f, 12.0f, 63.004494f);
                instancePath.lineTo(12.0f, 29.995506f);
                instancePath.cubicTo(12.0f, 28.341135f, 13.333893f, 27.0f, 15.002615f, 27.0f);
                instancePath.lineTo(22.5f, 27.0f);
                instancePath.close();
                instancePath.moveTo(27.0f, 27.0f);
                instancePath.lineTo(45.0f, 27.0f);
                instancePath.lineTo(45.0f, 19.5f);
                instancePath.cubicTo(45.0f, 14.529437f, 40.970562f, 10.5f, 36.0f, 10.5f);
                instancePath.cubicTo(31.029438f, 10.5f, 27.0f, 14.529437f, 27.0f, 19.5f);
                instancePath.lineTo(27.0f, 27.0f);
                instancePath.close();
                instancePath.moveTo(34.2f, 47.62556f);
                instancePath.lineTo(34.2f, 54.0f);
                instancePath.lineTo(37.8f, 54.0f);
                instancePath.lineTo(37.8f, 47.62556f);
                instancePath.cubicTo(39.389313f, 46.93116f, 40.5f, 45.345287f, 40.5f, 43.5f);
                instancePath.cubicTo(40.5f, 41.014717f, 38.485283f, 39.0f, 36.0f, 39.0f);
                instancePath.cubicTo(33.514717f, 39.0f, 31.5f, 41.014717f, 31.5f, 43.5f);
                instancePath.cubicTo(31.5f, 45.345287f, 32.610683f, 46.93116f, 34.2f, 47.62556f);
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
