package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class remittance_wait extends c {
    private final int height = 186;
    private final int width = 186;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 186;
            case 1:
                return 186;
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
                instancePaint3.setColor(-15683841);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(186.0f, 94.14815f);
                instancePath.cubicTo(186.0f, 41.636444f, 144.36356f, 0.0f, 91.85185f, 0.0f);
                instancePath.cubicTo(41.636444f, 0.0f, 0.0f, 41.636444f, 0.0f, 94.14815f);
                instancePath.cubicTo(0.0f, 144.36356f, 41.636444f, 186.0f, 91.85185f, 186.0f);
                instancePath.cubicTo(144.36356f, 186.0f, 186.0f, 144.36356f, 186.0f, 94.14815f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(96.53957f, 101.59992f);
                instancePath2.lineTo(93.96079f, 37.990128f);
                instancePath2.cubicTo(93.93903f, 37.45337f, 93.475f, 37.0f, 92.925255f, 37.0f);
                instancePath2.lineTo(84.91605f, 37.0f);
                instancePath2.cubicTo(84.37632f, 37.0f, 83.90268f, 37.443295f, 83.880516f, 37.990128f);
                instancePath2.lineTo(81.00167f, 109.00153f);
                instancePath2.cubicTo(80.974144f, 109.68064f, 81.28838f, 110.28124f, 81.79111f, 110.64247f);
                instancePath2.cubicTo(81.98214f, 110.944756f, 82.25776f, 111.19843f, 82.60479f, 111.36398f);
                instancePath2.lineTo(129.58261f, 133.77519f);
                instancePath2.cubicTo(130.08742f, 134.016f, 130.7105f, 133.8202f, 130.98582f, 133.34332f);
                instancePath2.lineTo(133.9888f, 128.14203f);
                instancePath2.cubicTo(134.26079f, 127.67092f, 134.11714f, 127.02809f, 133.66052f, 126.71911f);
                instancePath2.lineTo(96.53957f, 101.59992f);
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
