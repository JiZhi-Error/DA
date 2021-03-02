package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_play extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(22.488417f, 14.56481f);
                instancePath.lineTo(55.441723f, 33.39527f);
                instancePath.cubicTo(56.880276f, 34.2173f, 57.380066f, 36.049866f, 56.558037f, 37.48842f);
                instancePath.cubicTo(56.292267f, 37.95351f, 55.90682f, 38.338963f, 55.441723f, 38.60473f);
                instancePath.lineTo(22.488417f, 57.435192f);
                instancePath.cubicTo(21.049864f, 58.25722f, 19.2173f, 57.75743f, 18.395271f, 56.31888f);
                instancePath.cubicTo(18.136246f, 55.865585f, 18.0f, 55.352543f, 18.0f, 54.83046f);
                instancePath.lineTo(18.0f, 17.169538f);
                instancePath.cubicTo(18.0f, 15.512685f, 19.343145f, 14.169539f, 21.0f, 14.169539f);
                instancePath.cubicTo(21.522081f, 14.169539f, 22.035124f, 14.305785f, 22.488417f, 14.56481f);
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
