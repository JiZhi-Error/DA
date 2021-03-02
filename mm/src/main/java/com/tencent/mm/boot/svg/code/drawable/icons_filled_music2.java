package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_music2 extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
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
                instancePaint3.setColor(-436207616);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(11.5f, 4.276247f);
                instancePath.cubicTo(11.5f, 4.1579003f, 11.582233f, 4.05876f, 11.6926775f, 4.03285f);
                instancePath.lineTo(11.762453f, 4.0265574f);
                instancePath.lineTo(11.762453f, 4.0265574f);
                instancePath.lineTo(16.274876f, 4.4774876f);
                instancePath.cubicTo(16.402676f, 4.4902678f, 16.5f, 4.597809f, 16.5f, 4.726247f);
                instancePath.lineTo(16.5f, 7.223753f);
                instancePath.cubicTo(16.5f, 7.3420997f, 16.417767f, 7.44124f, 16.307323f, 7.46715f);
                instancePath.lineTo(16.237547f, 7.4734426f);
                instancePath.lineTo(16.237547f, 7.4734426f);
                instancePath.lineTo(13.5f, 7.199247f);
                instancePath.lineTo(13.5f, 17.0f);
                instancePath.cubicTo(13.5f, 18.597681f, 12.25108f, 19.903662f, 10.676272f, 19.994907f);
                instancePath.lineTo(10.5f, 20.0f);
                instancePath.cubicTo(8.843145f, 20.0f, 7.5f, 18.656855f, 7.5f, 17.0f);
                instancePath.cubicTo(7.5f, 15.343145f, 8.843145f, 14.0f, 10.5f, 14.0f);
                instancePath.cubicTo(10.850972f, 14.0f, 11.187867f, 14.060269f, 11.5009f, 14.171024f);
                instancePath.lineTo(11.5f, 4.276247f);
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
