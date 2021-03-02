package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class userguide_qq_icon extends c {
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
                instancePaint3.setColor(-12799249);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(48.11264f, 11.0f);
                instancePath.cubicTo(29.075232f, 11.190086f, 20.986343f, 26.826294f, 20.986343f, 40.877155f);
                instancePath.cubicTo(9.261343f, 52.839657f, 12.905231f, 69.57371f, 16.54523f, 69.57371f);
                instancePath.cubicTo(18.859121f, 69.951294f, 22.617083f, 63.59698f, 22.617083f, 63.59698f);
                instancePath.cubicTo(22.617083f, 63.59698f, 22.73375f, 67.556465f, 25.812454f, 71.13836f);
                instancePath.cubicTo(22.417454f, 72.655174f, 20.195602f, 75.13793f, 20.195602f, 77.949135f);
                instancePath.cubicTo(20.195602f, 82.57069f, 26.175417f, 86.31681f, 33.553936f, 86.31681f);
                instancePath.cubicTo(39.042454f, 86.31681f, 43.753193f, 84.242676f, 45.80912f, 81.27888f);
                instancePath.lineTo(50.492638f, 81.27888f);
                instancePath.cubicTo(52.547268f, 84.242676f, 57.25801f, 86.31681f, 62.74653f, 86.31681f);
                instancePath.cubicTo(70.12375f, 86.31681f, 76.106155f, 82.57198f, 76.106155f, 77.949135f);
                instancePath.cubicTo(76.106155f, 75.13793f, 73.88431f, 72.65646f, 70.4893f, 71.13836f);
                instancePath.cubicTo(73.56801f, 67.556465f, 73.68468f, 63.59698f, 73.68468f, 63.59698f);
                instancePath.cubicTo(73.68468f, 63.59698f, 77.441345f, 69.951294f, 79.75653f, 69.57371f);
                instancePath.cubicTo(83.39653f, 69.57241f, 87.03912f, 52.838364f, 75.31412f, 40.875862f);
                instancePath.cubicTo(75.31412f, 26.826294f, 67.14875f, 11.181034f, 48.11264f, 11.0f);
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
