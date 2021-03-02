package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ofm_wallet_icon extends c {
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
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(57.0f, 48.0f);
                instancePath.cubicTo(57.0f, 50.762f, 59.238f, 53.0f, 62.0f, 53.0f);
                instancePath.cubicTo(64.762f, 53.0f, 67.0f, 50.762f, 67.0f, 48.0f);
                instancePath.cubicTo(67.0f, 45.239f, 64.762f, 43.0f, 62.0f, 43.0f);
                instancePath.cubicTo(59.238f, 43.0f, 57.0f, 45.239f, 57.0f, 48.0f);
                instancePath.close();
                instancePath.moveTo(77.0f, 25.0f);
                instancePath.lineTo(19.0f, 25.0f);
                instancePath.cubicTo(17.344f, 25.0f, 16.0f, 26.343f, 16.0f, 28.0f);
                instancePath.lineTo(16.0f, 68.0f);
                instancePath.cubicTo(16.0f, 69.657f, 17.344f, 71.0f, 19.0f, 71.0f);
                instancePath.lineTo(77.0f, 71.0f);
                instancePath.cubicTo(78.656f, 71.0f, 80.0f, 69.657f, 80.0f, 68.0f);
                instancePath.lineTo(80.0f, 58.0f);
                instancePath.lineTo(62.0f, 58.0f);
                instancePath.cubicTo(56.477f, 58.0f, 52.0f, 53.523f, 52.0f, 48.0f);
                instancePath.cubicTo(52.0f, 42.478f, 56.477f, 38.0f, 62.0f, 38.0f);
                instancePath.lineTo(80.0f, 38.0f);
                instancePath.lineTo(80.0f, 28.0f);
                instancePath.cubicTo(80.0f, 26.344f, 78.656f, 25.0f, 77.0f, 25.0f);
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
