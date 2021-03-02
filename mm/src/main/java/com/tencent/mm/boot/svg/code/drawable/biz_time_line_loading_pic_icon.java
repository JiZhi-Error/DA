package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class biz_time_line_loading_pic_icon extends c {
    private final int height = 13;
    private final int width = 17;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 17;
            case 1:
                return 13;
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
                instancePaint3.setColor(-5066062);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(15.8f, 8.795279f);
                instancePath.lineTo(15.8f, 1.2f);
                instancePath.lineTo(1.2f, 1.2f);
                instancePath.lineTo(1.2f, 8.248441f);
                instancePath.lineTo(5.166038f, 5.041049f);
                instancePath.cubicTo(5.5514994f, 4.729321f, 6.1705213f, 4.744439f, 6.5420794f, 5.0709033f);
                instancePath.lineTo(10.272436f, 8.348522f);
                instancePath.lineTo(12.1742525f, 6.731248f);
                instancePath.cubicTo(12.559431f, 6.403698f, 13.172269f, 6.410352f, 13.546193f, 6.745903f);
                instancePath.lineTo(15.8f, 8.795279f);
                instancePath.close();
                instancePath.moveTo(15.8f, 10.108209f);
                instancePath.lineTo(12.855153f, 7.4979076f);
                instancePath.lineTo(11.1226425f, 9.095543f);
                instancePath.lineTo(12.152032f, 10.0f);
                instancePath.lineTo(10.595221f, 10.0f);
                instancePath.lineTo(5.8383803f, 5.9897f);
                instancePath.lineTo(1.2f, 9.74638f);
                instancePath.lineTo(1.2f, 11.8f);
                instancePath.lineTo(15.8f, 11.8f);
                instancePath.lineTo(15.8f, 10.108209f);
                instancePath.close();
                instancePath.moveTo(0.84303266f, -1.5010215E-13f);
                instancePath.lineTo(16.156967f, -1.5010215E-13f);
                instancePath.cubicTo(16.61299f, -1.5010215E-13f, 17.0f, 0.39092383f, 17.0f, 0.8731528f);
                instancePath.lineTo(17.0f, 12.126847f);
                instancePath.cubicTo(17.0f, 12.610936f, 16.62256f, 13.0f, 16.156967f, 13.0f);
                instancePath.lineTo(0.84303266f, 13.0f);
                instancePath.cubicTo(0.38700974f, 13.0f, 1.5454305E-13f, 12.6090765f, 1.5454305E-13f, 12.126847f);
                instancePath.lineTo(1.5454305E-13f, 0.8731528f);
                instancePath.cubicTo(1.5454305E-13f, 0.3890642f, 0.37743858f, -1.5010215E-13f, 0.84303266f, -1.5010215E-13f);
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
