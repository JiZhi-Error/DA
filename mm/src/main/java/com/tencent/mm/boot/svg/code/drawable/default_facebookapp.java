package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class default_facebookapp extends c {
    private final int height = 192;
    private final int width = 192;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                instancePaint3.setColor(-12953699);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(192.0f, 0.0f);
                instancePath.lineTo(192.0f, 192.0f);
                instancePath.lineTo(0.0f, 192.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(104.72727f, 192.0f);
                instancePath2.lineTo(104.72727f, 117.818184f);
                instancePath2.lineTo(80.0f, 117.818184f);
                instancePath2.lineTo(80.0f, 87.27273f);
                instancePath2.lineTo(104.72727f, 87.27273f);
                instancePath2.lineTo(104.72727f, 61.090908f);
                instancePath2.cubicTo(104.62603f, 44.320255f, 121.209656f, 29.09091f, 138.18182f, 29.09091f);
                instancePath2.lineTo(164.36363f, 29.09091f);
                instancePath2.lineTo(164.36363f, 58.18182f);
                instancePath2.lineTo(148.36363f, 58.18182f);
                instancePath2.cubicTo(137.98802f, 58.097572f, 133.74586f, 62.3439f, 133.81818f, 72.72727f);
                instancePath2.lineTo(133.81818f, 87.27273f);
                instancePath2.lineTo(164.36363f, 87.27273f);
                instancePath2.lineTo(158.54546f, 117.818184f);
                instancePath2.lineTo(133.81818f, 117.818184f);
                instancePath2.lineTo(133.81818f, 192.0f);
                instancePath2.lineTo(104.72727f, 192.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
