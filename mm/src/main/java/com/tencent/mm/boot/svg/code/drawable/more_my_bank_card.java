package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class more_my_bank_card extends c {
    private final int height = 108;
    private final int width = 108;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                instancePaint3.setColor(-15683841);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(87.115f, 33.87689f);
                instancePath.cubicTo(87.115f, 30.632847f, 84.48362f, 28.0f, 81.23811f, 28.0f);
                instancePath.lineTo(26.876888f, 28.0f);
                instancePath.cubicTo(23.631376f, 28.0f, 21.0f, 30.632847f, 21.0f, 33.87689f);
                instancePath.lineTo(21.0f, 75.01658f);
                instancePath.cubicTo(21.0f, 78.26209f, 23.631376f, 80.892f, 26.876888f, 80.892f);
                instancePath.lineTo(81.23811f, 80.892f);
                instancePath.cubicTo(84.48362f, 80.892f, 87.115f, 78.26209f, 87.115f, 75.01658f);
                instancePath.lineTo(87.115f, 66.199776f);
                instancePath.lineTo(72.422775f, 66.199776f);
                instancePath.cubicTo(65.931755f, 66.199776f, 60.669f, 60.937023f, 60.669f, 54.446f);
                instancePath.cubicTo(60.669f, 47.954975f, 65.931755f, 42.692223f, 72.422775f, 42.692223f);
                instancePath.lineTo(87.115f, 42.692223f);
                instancePath.lineTo(87.115f, 33.87689f);
                instancePath.lineTo(87.115f, 33.87689f);
                instancePath.close();
                instancePath.moveTo(66.54589f, 54.446f);
                instancePath.cubicTo(66.54589f, 57.69298f, 69.17727f, 60.322887f, 72.422775f, 60.322887f);
                instancePath.cubicTo(75.66829f, 60.322887f, 78.29967f, 57.69298f, 78.29967f, 54.446f);
                instancePath.cubicTo(78.29967f, 51.20049f, 75.66829f, 48.56911f, 72.422775f, 48.56911f);
                instancePath.cubicTo(69.17727f, 48.56911f, 66.54589f, 51.20049f, 66.54589f, 54.446f);
                instancePath.lineTo(66.54589f, 54.446f);
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
