package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_desktop_ban_icon extends c {
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
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.0f, 0.0f);
                instancePath.cubicTo(55.88225f, 0.0f, 72.0f, 16.117748f, 72.0f, 36.0f);
                instancePath.cubicTo(72.0f, 55.88225f, 55.88225f, 72.0f, 36.0f, 72.0f);
                instancePath.cubicTo(16.117748f, 72.0f, 0.0f, 55.88225f, 0.0f, 36.0f);
                instancePath.cubicTo(0.0f, 16.117748f, 16.117748f, 0.0f, 36.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-372399);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(23.48519f, 27.72783f);
                instancePath2.cubicTo(21.91463f, 30.099129f, 21.0f, 32.942753f, 21.0f, 36.0f);
                instancePath2.cubicTo(21.0f, 44.28427f, 27.715729f, 51.0f, 36.0f, 51.0f);
                instancePath2.cubicTo(39.057247f, 51.0f, 41.90087f, 50.08537f, 44.27217f, 48.51481f);
                instancePath2.lineTo(23.48519f, 27.72783f);
                instancePath2.close();
                instancePath2.moveTo(27.72783f, 23.48519f);
                instancePath2.lineTo(48.51481f, 44.27217f);
                instancePath2.cubicTo(50.08537f, 41.90087f, 51.0f, 39.057247f, 51.0f, 36.0f);
                instancePath2.cubicTo(51.0f, 27.715729f, 44.28427f, 21.0f, 36.0f, 21.0f);
                instancePath2.cubicTo(32.942753f, 21.0f, 30.099129f, 21.91463f, 27.72783f, 23.48519f);
                instancePath2.close();
                instancePath2.moveTo(36.0f, 57.0f);
                instancePath2.cubicTo(24.40202f, 57.0f, 15.0f, 47.59798f, 15.0f, 36.0f);
                instancePath2.cubicTo(15.0f, 24.40202f, 24.40202f, 15.0f, 36.0f, 15.0f);
                instancePath2.cubicTo(47.59798f, 15.0f, 57.0f, 24.40202f, 57.0f, 36.0f);
                instancePath2.cubicTo(57.0f, 47.59798f, 47.59798f, 57.0f, 36.0f, 57.0f);
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
