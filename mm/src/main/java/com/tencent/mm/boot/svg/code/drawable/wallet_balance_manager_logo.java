package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wallet_balance_manager_logo extends c {
    private final int height = 240;
    private final int width = 240;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 240;
            case 1:
                return 240;
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
                instancePaint3.setColor(-407039);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(120.0f, 0.0f);
                instancePath.cubicTo(186.27417f, 0.0f, 240.0f, 53.72583f, 240.0f, 120.0f);
                instancePath.cubicTo(240.0f, 186.27417f, 186.27417f, 240.0f, 120.0f, 240.0f);
                instancePath.cubicTo(53.72583f, 240.0f, 0.0f, 186.27417f, 0.0f, 120.0f);
                instancePath.cubicTo(0.0f, 53.72583f, 53.72583f, 0.0f, 120.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(120.0f, 21.0f);
                instancePath2.cubicTo(174.6762f, 21.0f, 219.0f, 65.32381f, 219.0f, 120.0f);
                instancePath2.cubicTo(219.0f, 174.6762f, 174.6762f, 219.0f, 120.0f, 219.0f);
                instancePath2.cubicTo(65.32381f, 219.0f, 21.0f, 174.6762f, 21.0f, 120.0f);
                instancePath2.cubicTo(21.0f, 65.32381f, 65.32381f, 21.0f, 120.0f, 21.0f);
                instancePath2.close();
                canvas.saveLayerAlpha(null, 102, 31);
                canvas.drawPath(instancePath2, c.instancePaint(instancePaint4, looper));
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-407039);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(125.57143f, 108.0f);
                instancePath3.lineTo(142.28572f, 72.0f);
                instancePath3.lineTo(159.0f, 72.0f);
                instancePath3.lineTo(142.28572f, 108.0f);
                instancePath3.lineTo(159.0f, 108.0f);
                instancePath3.lineTo(159.0f, 123.0f);
                instancePath3.lineTo(126.0f, 123.0f);
                instancePath3.lineTo(126.0f, 135.0f);
                instancePath3.lineTo(159.0f, 135.0f);
                instancePath3.lineTo(159.0f, 150.0f);
                instancePath3.lineTo(126.0f, 150.0f);
                instancePath3.lineTo(126.0f, 171.0f);
                instancePath3.lineTo(114.0f, 171.0f);
                instancePath3.lineTo(114.0f, 150.0f);
                instancePath3.lineTo(81.0f, 150.0f);
                instancePath3.lineTo(81.0f, 135.0f);
                instancePath3.lineTo(114.0f, 135.0f);
                instancePath3.lineTo(114.0f, 123.0f);
                instancePath3.lineTo(81.0f, 123.0f);
                instancePath3.lineTo(81.0f, 108.0f);
                instancePath3.lineTo(97.71429f, 108.0f);
                instancePath3.lineTo(81.0f, 72.0f);
                instancePath3.lineTo(97.71429f, 72.0f);
                instancePath3.lineTo(114.42857f, 108.0f);
                instancePath3.lineTo(125.57143f, 108.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
