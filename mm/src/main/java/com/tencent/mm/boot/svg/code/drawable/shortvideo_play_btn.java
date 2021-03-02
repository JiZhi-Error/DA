package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class shortvideo_play_btn extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                instancePaint3.setColor(637534208);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(60.0f, 0.0f);
                instancePath.cubicTo(93.137085f, 0.0f, 120.0f, 26.862915f, 120.0f, 60.0f);
                instancePath.cubicTo(120.0f, 93.137085f, 93.137085f, 120.0f, 60.0f, 120.0f);
                instancePath.cubicTo(26.862915f, 120.0f, 0.0f, 93.137085f, 0.0f, 60.0f);
                instancePath.cubicTo(0.0f, 26.862915f, 26.862915f, 0.0f, 60.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(60.0f, 0.0f);
                instancePath2.cubicTo(93.137085f, 0.0f, 120.0f, 26.862915f, 120.0f, 60.0f);
                instancePath2.cubicTo(120.0f, 93.137085f, 93.137085f, 120.0f, 60.0f, 120.0f);
                instancePath2.cubicTo(26.862915f, 120.0f, 0.0f, 93.137085f, 0.0f, 60.0f);
                instancePath2.cubicTo(0.0f, 26.862915f, 26.862915f, 0.0f, 60.0f, 0.0f);
                instancePath2.close();
                instancePath2.moveTo(60.0f, 3.6f);
                instancePath2.cubicTo(28.851141f, 3.6f, 3.6f, 28.851141f, 3.6f, 60.0f);
                instancePath2.cubicTo(3.6f, 91.14886f, 28.851141f, 116.4f, 60.0f, 116.4f);
                instancePath2.cubicTo(91.14886f, 116.4f, 116.4f, 91.14886f, 116.4f, 60.0f);
                instancePath2.cubicTo(116.4f, 28.851141f, 91.14886f, 3.6f, 60.0f, 3.6f);
                instancePath2.close();
                instancePath2.moveTo(48.0f, 38.16954f);
                instancePath2.cubicTo(48.52208f, 38.16954f, 49.035122f, 38.305786f, 49.48842f, 38.564808f);
                instancePath2.lineTo(82.44173f, 57.39527f);
                instancePath2.cubicTo(83.88028f, 58.2173f, 84.380066f, 60.049866f, 83.55804f, 61.48842f);
                instancePath2.cubicTo(83.29227f, 61.95351f, 82.906815f, 62.338963f, 82.44173f, 62.60473f);
                instancePath2.lineTo(49.48842f, 81.43519f);
                instancePath2.cubicTo(48.049866f, 82.25722f, 46.2173f, 81.75743f, 45.39527f, 80.31888f);
                instancePath2.cubicTo(45.136246f, 79.865585f, 45.0f, 79.35254f, 45.0f, 78.83046f);
                instancePath2.lineTo(45.0f, 41.16954f);
                instancePath2.cubicTo(45.0f, 39.512684f, 46.343147f, 38.16954f, 48.0f, 38.16954f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
