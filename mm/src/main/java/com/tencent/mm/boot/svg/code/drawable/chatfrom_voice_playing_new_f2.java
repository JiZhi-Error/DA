package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatfrom_voice_playing_new_f2 extends c {
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
                instancePaint3.setColor(-15028967);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(31.8912f, 55.674f);
                instancePath.lineTo(26.0892f, 49.959f);
                instancePath.cubicTo(30.0582f, 46.524f, 32.5602f, 41.505f, 32.5602f, 35.919f);
                instancePath.cubicTo(32.5602f, 30.417f, 30.1332f, 25.467f, 26.2692f, 22.035f);
                instancePath.lineTo(32.0712f, 16.323f);
                instancePath.cubicTo(37.4382f, 21.213f, 40.7922f, 28.185f, 40.7922f, 35.919f);
                instancePath.cubicTo(40.7922f, 43.737f, 37.3632f, 50.775f, 31.8912f, 55.674f);
                instancePath.moveTo(19.3032f, 43.278f);
                instancePath.lineTo(12.0012f, 36.087f);
                instancePath.lineTo(19.4952f, 28.707f);
                instancePath.cubicTo(21.6102f, 30.429f, 22.9572f, 33.018f, 22.9572f, 35.919f);
                instancePath.cubicTo(22.9572f, 38.904f, 21.5292f, 41.562f, 19.3032f, 43.278f);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
