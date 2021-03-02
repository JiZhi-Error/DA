package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class webview_bag_indicator_icon_normal extends c {
    private final int height = 144;
    private final int width = 144;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                instancePath.moveTo(72.0f, 124.8f);
                instancePath.cubicTo(101.16064f, 124.8f, 124.8f, 101.16064f, 124.8f, 72.0f);
                instancePath.cubicTo(124.8f, 42.839367f, 101.16064f, 19.2f, 72.0f, 19.2f);
                instancePath.cubicTo(42.839367f, 19.2f, 19.2f, 42.839367f, 19.2f, 72.0f);
                instancePath.cubicTo(19.2f, 101.16064f, 42.839367f, 124.8f, 72.0f, 124.8f);
                instancePath.close();
                instancePath.moveTo(72.0f, 132.0f);
                instancePath.cubicTo(38.862915f, 132.0f, 12.0f, 105.137085f, 12.0f, 72.0f);
                instancePath.cubicTo(12.0f, 38.862915f, 38.862915f, 12.0f, 72.0f, 12.0f);
                instancePath.cubicTo(105.137085f, 12.0f, 132.0f, 38.862915f, 132.0f, 72.0f);
                instancePath.cubicTo(132.0f, 105.137085f, 105.137085f, 132.0f, 72.0f, 132.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(72.0f, 106.8f);
                instancePath2.cubicTo(91.21951f, 106.8f, 106.8f, 91.21951f, 106.8f, 72.0f);
                instancePath2.cubicTo(106.8f, 52.78049f, 91.21951f, 37.2f, 72.0f, 37.2f);
                instancePath2.cubicTo(52.78049f, 37.2f, 37.2f, 52.78049f, 37.2f, 72.0f);
                instancePath2.cubicTo(37.2f, 91.21951f, 52.78049f, 106.8f, 72.0f, 106.8f);
                instancePath2.close();
                instancePath2.moveTo(72.0f, 114.0f);
                instancePath2.cubicTo(48.80404f, 114.0f, 30.0f, 95.19596f, 30.0f, 72.0f);
                instancePath2.cubicTo(30.0f, 48.80404f, 48.80404f, 30.0f, 72.0f, 30.0f);
                instancePath2.cubicTo(95.19596f, 30.0f, 114.0f, 48.80404f, 114.0f, 72.0f);
                instancePath2.cubicTo(114.0f, 95.19596f, 95.19596f, 114.0f, 72.0f, 114.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
