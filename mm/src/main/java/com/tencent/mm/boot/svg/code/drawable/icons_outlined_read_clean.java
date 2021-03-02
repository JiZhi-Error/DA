package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_read_clean extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(34.2f, 15.0f);
                instancePath.lineTo(37.8f, 15.0f);
                instancePath.lineTo(37.8f, 59.001263f);
                instancePath.lineTo(36.0f, 60.0f);
                instancePath.lineTo(34.2f, 59.001263f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint5.setStrokeWidth(3.6f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(36.0f, 14.785034f);
                instancePath2.lineTo(59.572838f, 11.394009f);
                instancePath2.cubicTo(61.21281f, 11.158093f, 62.733517f, 12.296308f, 62.969433f, 13.936279f);
                instancePath2.cubicTo(62.989784f, 14.077757f, 63.0f, 14.220509f, 63.0f, 14.363441f);
                instancePath2.lineTo(63.0f, 50.394005f);
                instancePath2.cubicTo(63.0f, 53.377686f, 60.807602f, 55.908035f, 57.854324f, 56.332874f);
                instancePath2.lineTo(36.0f, 59.476685f);
                instancePath2.lineTo(14.145676f, 56.332874f);
                instancePath2.cubicTo(11.192398f, 55.908035f, 9.0f, 53.377686f, 9.0f, 50.394005f);
                instancePath2.lineTo(9.0f, 14.363441f);
                instancePath2.cubicTo(9.0f, 14.220509f, 9.010215f, 14.077757f, 9.030567f, 13.936279f);
                instancePath2.cubicTo(9.266482f, 12.296308f, 10.7871895f, 11.158093f, 12.427162f, 11.394009f);
                instancePath2.lineTo(36.0f, 14.785034f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
