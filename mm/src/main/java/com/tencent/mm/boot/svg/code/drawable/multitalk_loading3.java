package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class multitalk_loading3 extends c {
    private final int height = 24;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 24;
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
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(60.0f, 24.0f);
                instancePath.cubicTo(66.62742f, 24.0f, 72.0f, 18.627417f, 72.0f, 12.0f);
                instancePath.cubicTo(72.0f, 5.372583f, 66.62742f, 0.0f, 60.0f, 0.0f);
                instancePath.cubicTo(53.37258f, 0.0f, 48.0f, 5.372583f, 48.0f, 12.0f);
                instancePath.cubicTo(48.0f, 18.627417f, 53.37258f, 24.0f, 60.0f, 24.0f);
                instancePath.close();
                instancePath.moveTo(12.0f, 24.0f);
                instancePath.cubicTo(18.627417f, 24.0f, 24.0f, 18.627417f, 24.0f, 12.0f);
                instancePath.cubicTo(24.0f, 5.372583f, 18.627417f, 0.0f, 12.0f, 0.0f);
                instancePath.cubicTo(5.372583f, 0.0f, 0.0f, 5.372583f, 0.0f, 12.0f);
                instancePath.cubicTo(0.0f, 18.627417f, 5.372583f, 24.0f, 12.0f, 24.0f);
                instancePath.close();
                instancePath.moveTo(108.0f, 24.0f);
                instancePath.cubicTo(114.62742f, 24.0f, 120.0f, 18.627417f, 120.0f, 12.0f);
                instancePath.cubicTo(120.0f, 5.372583f, 114.62742f, 0.0f, 108.0f, 0.0f);
                instancePath.cubicTo(101.37258f, 0.0f, 96.0f, 5.372583f, 96.0f, 12.0f);
                instancePath.cubicTo(96.0f, 18.627417f, 101.37258f, 24.0f, 108.0f, 24.0f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 76, 31);
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(108.0f, 0.0f);
                instancePath2.cubicTo(114.62742f, 0.0f, 120.0f, 5.3725824f, 120.0f, 12.0f);
                instancePath2.cubicTo(120.0f, 18.627419f, 114.62742f, 24.0f, 108.0f, 24.0f);
                instancePath2.cubicTo(101.37258f, 24.0f, 96.0f, 18.627419f, 96.0f, 12.0f);
                instancePath2.cubicTo(96.0f, 5.3725824f, 101.37258f, 0.0f, 108.0f, 0.0f);
                instancePath2.close();
                canvas.saveLayerAlpha(null, 153, 31);
                canvas.drawPath(instancePath2, c.instancePaint(instancePaint6, looper));
                canvas.restore();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                instancePaint7.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(60.0f, 0.0f);
                instancePath3.cubicTo(66.62742f, 0.0f, 72.0f, 5.3725824f, 72.0f, 12.0f);
                instancePath3.cubicTo(72.0f, 18.627419f, 66.62742f, 24.0f, 60.0f, 24.0f);
                instancePath3.cubicTo(53.37258f, 24.0f, 48.0f, 18.627419f, 48.0f, 12.0f);
                instancePath3.cubicTo(48.0f, 5.3725824f, 53.37258f, 0.0f, 60.0f, 0.0f);
                instancePath3.close();
                canvas.saveLayerAlpha(null, 76, 31);
                canvas.drawPath(instancePath3, c.instancePaint(instancePaint7, looper));
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
