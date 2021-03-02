package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class webview_bag_default_icon extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                instancePath.moveTo(16.966213f, 24.12567f);
                instancePath.lineTo(18.380426f, 25.539883f);
                instancePath.lineTo(15.993941f, 27.926369f);
                instancePath.cubicTo(14.794056f, 29.126255f, 14.782134f, 31.04559f, 15.949747f, 32.213203f);
                instancePath.cubicTo(17.117361f, 33.380817f, 19.036695f, 33.368896f, 20.236582f, 32.16901f);
                instancePath.lineTo(25.009554f, 27.396038f);
                instancePath.cubicTo(26.20944f, 26.196152f, 26.221361f, 24.276817f, 25.053747f, 23.109203f);
                instancePath.lineTo(26.46796f, 21.69499f);
                instancePath.cubicTo(28.420582f, 23.647612f, 28.400795f, 26.833223f, 26.423767f, 28.810251f);
                instancePath.lineTo(21.650795f, 33.58322f);
                instancePath.cubicTo(19.673767f, 35.560253f, 16.488155f, 35.58004f, 14.535534f, 33.62742f);
                instancePath.cubicTo(12.582912f, 31.674795f, 12.602699f, 28.489183f, 14.579728f, 26.512156f);
                instancePath.lineTo(16.966213f, 24.12567f);
                instancePath.close();
                instancePath.moveTo(33.58322f, 21.650795f);
                instancePath.lineTo(31.196737f, 24.037281f);
                instancePath.lineTo(29.782524f, 22.623068f);
                instancePath.lineTo(32.16901f, 20.236582f);
                instancePath.cubicTo(33.368896f, 19.036695f, 33.380817f, 17.117361f, 32.213203f, 15.949747f);
                instancePath.cubicTo(31.04559f, 14.782134f, 29.126255f, 14.794056f, 27.926369f, 15.993941f);
                instancePath.lineTo(23.153399f, 20.766912f);
                instancePath.cubicTo(21.953512f, 21.966799f, 21.94159f, 23.886133f, 23.109203f, 25.053747f);
                instancePath.lineTo(21.69499f, 26.46796f);
                instancePath.cubicTo(19.742369f, 24.515339f, 19.762156f, 21.329727f, 21.739183f, 19.3527f);
                instancePath.lineTo(26.512156f, 14.579728f);
                instancePath.cubicTo(28.489183f, 12.602699f, 31.674795f, 12.582912f, 33.62742f, 14.535534f);
                instancePath.cubicTo(35.58004f, 16.488155f, 35.560253f, 19.673767f, 33.58322f, 21.650795f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
