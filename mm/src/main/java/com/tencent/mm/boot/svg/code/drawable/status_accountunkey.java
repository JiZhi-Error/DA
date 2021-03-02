package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class status_accountunkey extends c {
    private final int height = 46;
    private final int width = 46;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 46;
            case 1:
                return 46;
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
                instancePaint3.setColor(-6710887);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(23.0f, 0.0f);
                instancePath.cubicTo(35.70255f, 0.0f, 46.0f, 10.29745f, 46.0f, 23.0f);
                instancePath.cubicTo(46.0f, 35.70255f, 35.70255f, 46.0f, 23.0f, 46.0f);
                instancePath.cubicTo(10.29745f, 46.0f, 0.0f, 35.70255f, 0.0f, 23.0f);
                instancePath.cubicTo(0.0f, 10.29745f, 10.29745f, 0.0f, 23.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(29.837742f, 16.978155f);
                instancePath2.cubicTo(29.663364f, 15.734242f, 29.332104f, 14.538659f, 28.424576f, 13.573514f);
                instancePath2.cubicTo(25.837162f, 10.148845f, 20.172827f, 10.138831f, 17.585415f, 13.5635f);
                instancePath2.cubicTo(15.967033f, 15.315889f, 16.176823f, 17.799276f, 15.827173f, 19.982252f);
                instancePath2.lineTo(13.0f, 19.982252f);
                instancePath2.cubicTo(13.00999f, 24.328176f, 13.00999f, 28.66409f, 13.00999f, 33.0f);
                instancePath2.lineTo(32.99001f, 33.0f);
                instancePath2.cubicTo(32.99001f, 28.66409f, 32.99001f, 24.328176f, 33.0f, 19.982252f);
                instancePath2.lineTo(31.586414f, 19.982252f);
                instancePath2.lineTo(26.086912f, 19.982252f);
                instancePath2.lineTo(18.824175f, 19.982252f);
                instancePath2.cubicTo(18.804195f, 17.358675f, 19.713287f, 13.873924f, 22.99001f, 13.97406f);
                instancePath2.cubicTo(25.067957f, 13.891255f, 26.212177f, 15.279206f, 26.759495f, 16.978155f);
                instancePath2.lineTo(29.837742f, 16.978155f);
                instancePath2.lineTo(29.837742f, 16.978155f);
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
