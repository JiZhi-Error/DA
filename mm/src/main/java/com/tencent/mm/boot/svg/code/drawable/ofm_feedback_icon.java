package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ofm_feedback_icon extends c {
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
                instancePaint3.setColor(-65794);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(77.0f, 25.0f);
                instancePath.lineTo(19.0f, 25.0f);
                instancePath.cubicTo(17.343f, 25.0f, 16.0f, 26.34297f, 16.0f, 27.999935f);
                instancePath.lineTo(16.0f, 68.00007f);
                instancePath.cubicTo(16.0f, 69.65703f, 17.343f, 71.0f, 19.0f, 71.0f);
                instancePath.lineTo(77.0f, 71.0f);
                instancePath.cubicTo(78.656f, 71.0f, 80.0f, 69.65703f, 80.0f, 68.00007f);
                instancePath.lineTo(80.0f, 27.999935f);
                instancePath.cubicTo(80.0f, 26.34297f, 78.657f, 25.0f, 77.0f, 25.0f);
                instancePath.close();
                instancePath.moveTo(72.77142f, 39.42813f);
                instancePath.lineTo(49.779076f, 52.676395f);
                instancePath.cubicTo(49.218597f, 52.999264f, 48.584373f, 53.06992f, 48.000298f, 52.935474f);
                instancePath.cubicTo(47.414253f, 53.06992f, 46.781013f, 52.99828f, 46.22152f, 52.676395f);
                instancePath.lineTo(23.229168f, 39.42813f);
                instancePath.cubicTo(22.054132f, 38.750996f, 21.650982f, 37.250507f, 22.329454f, 36.07681f);
                instancePath.lineTo(22.821102f, 35.226955f);
                instancePath.cubicTo(23.499575f, 34.053257f, 25.004013f, 33.651886f, 26.179049f, 34.329018f);
                instancePath.lineTo(48.000298f, 46.902115f);
                instancePath.lineTo(69.820564f, 34.329018f);
                instancePath.cubicTo(70.9956f, 33.651886f, 72.50004f, 34.053257f, 73.17753f, 35.226955f);
                instancePath.lineTo(73.669174f, 36.07681f);
                instancePath.cubicTo(74.34961f, 37.250507f, 73.94646f, 38.750996f, 72.77142f, 39.42813f);
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
