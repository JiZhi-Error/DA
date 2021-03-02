package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class actionbar_icon_light_clear extends c {
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
                canvas.saveLayerAlpha(null, 230, 31);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(1291845631);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.0f, 60.0f);
                instancePath.cubicTo(22.745167f, 60.0f, 12.0f, 49.254833f, 12.0f, 36.0f);
                instancePath.cubicTo(12.0f, 22.745167f, 22.745167f, 12.0f, 36.0f, 12.0f);
                instancePath.cubicTo(49.254833f, 12.0f, 60.0f, 22.745167f, 60.0f, 36.0f);
                instancePath.cubicTo(60.0f, 49.254833f, 49.254833f, 60.0f, 36.0f, 60.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 32.938873f);
                instancePath.lineTo(27.061129f, 24.0f);
                instancePath.lineTo(24.0f, 27.061129f);
                instancePath.lineTo(32.938873f, 36.0f);
                instancePath.lineTo(24.0f, 44.938873f);
                instancePath.lineTo(27.061129f, 48.0f);
                instancePath.lineTo(36.0f, 39.061127f);
                instancePath.lineTo(44.938873f, 48.0f);
                instancePath.lineTo(48.0f, 44.938873f);
                instancePath.lineTo(39.061127f, 36.0f);
                instancePath.lineTo(48.0f, 27.061129f);
                instancePath.lineTo(44.938873f, 24.0f);
                instancePath.lineTo(36.0f, 32.938873f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
