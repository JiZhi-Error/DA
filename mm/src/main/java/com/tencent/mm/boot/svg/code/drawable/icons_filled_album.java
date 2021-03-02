package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_album extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(61.5f, 42.408176f);
                instancePath.lineTo(61.5f, 16.5f);
                instancePath.lineTo(10.5f, 16.5f);
                instancePath.lineTo(10.5f, 41.548817f);
                instancePath.lineTo(24.597736f, 30.147776f);
                instancePath.cubicTo(25.985397f, 29.025555f, 28.213877f, 29.07998f, 29.551487f, 30.25525f);
                instancePath.lineTo(42.98077f, 42.05468f);
                instancePath.lineTo(49.82731f, 36.232494f);
                instancePath.cubicTo(51.21395f, 35.053314f, 53.42017f, 35.077267f, 54.766293f, 36.28525f);
                instancePath.lineTo(61.5f, 42.408176f);
                instancePath.close();
                instancePath.moveTo(8.9754095f, 12.0f);
                instancePath.lineTo(63.02459f, 12.0f);
                instancePath.cubicTo(64.63409f, 12.0f, 66.0f, 13.443411f, 66.0f, 15.2239485f);
                instancePath.lineTo(66.0f, 56.77605f);
                instancePath.cubicTo(66.0f, 58.563454f, 64.66786f, 60.0f, 63.02459f, 60.0f);
                instancePath.lineTo(8.9754095f, 60.0f);
                instancePath.cubicTo(7.3659167f, 60.0f, 6.0f, 58.556587f, 6.0f, 56.77605f);
                instancePath.lineTo(6.0f, 15.2239485f);
                instancePath.cubicTo(6.0f, 13.436544f, 7.332136f, 12.0f, 8.9754095f, 12.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
