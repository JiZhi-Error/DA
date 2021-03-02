package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class album_mention_icon_normal extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(11.269531f, 8.1875f);
                instancePath.cubicTo(9.5703125f, 8.1875f, 8.46875f, 9.628906f, 8.46875f, 11.84375f);
                instancePath.cubicTo(8.46875f, 14.046875f, 9.558594f, 15.4765625f, 11.2578125f, 15.4765625f);
                instancePath.cubicTo(12.9921875f, 15.4765625f, 14.105469f, 14.0234375f, 14.105469f, 11.785156f);
                instancePath.cubicTo(14.105469f, 9.582031f, 13.015625f, 8.1875f, 11.269531f, 8.1875f);
                instancePath.close();
                instancePath.moveTo(11.644531f, 2.0f);
                instancePath.cubicTo(16.779823f, 2.0f, 21.019531f, 5.5273438f, 21.019531f, 10.71875f);
                instancePath.cubicTo(21.019531f, 14.4453125f, 19.472656f, 16.835938f, 16.894531f, 16.835938f);
                instancePath.cubicTo(15.5f, 16.835938f, 14.3984375f, 15.9921875f, 14.222656f, 14.6796875f);
                instancePath.lineTo(14.140625f, 14.6796875f);
                instancePath.cubicTo(13.613281f, 16.015625f, 12.5234375f, 16.753906f, 11.0703125f, 16.753906f);
                instancePath.cubicTo(8.65625f, 16.753906f, 7.015625f, 14.761719f, 7.015625f, 11.808594f);
                instancePath.cubicTo(7.015625f, 8.925781f, 8.6796875f, 6.9335938f, 11.0703125f, 6.9335938f);
                instancePath.cubicTo(12.4296875f, 6.9335938f, 13.613281f, 7.671875f, 14.046875f, 8.8203125f);
                instancePath.lineTo(14.128906f, 8.8203125f);
                instancePath.lineTo(14.128906f, 7.1679688f);
                instancePath.lineTo(15.488281f, 7.1679688f);
                instancePath.lineTo(15.488281f, 13.871094f);
                instancePath.cubicTo(15.488281f, 14.9375f, 16.050781f, 15.640625f, 17.117188f, 15.640625f);
                instancePath.cubicTo(18.675781f, 15.640625f, 19.742188f, 13.847656f, 19.742188f, 10.6953125f);
                instancePath.cubicTo(19.742188f, 6.21875f, 16.238195f, 3.1757047f, 11.644531f, 3.1757047f);
                instancePath.cubicTo(7.0508666f, 3.1757047f, 3.2890625f, 6.5256376f, 3.2890625f, 11.7734375f);
                instancePath.cubicTo(3.2890625f, 16.648184f, 7.303185f, 20.363281f, 11.7734375f, 20.363281f);
                instancePath.cubicTo(13.355469f, 20.363281f, 14.8671875f, 20.164062f, 15.6640625f, 19.847656f);
                instancePath.lineTo(15.6640625f, 21.007812f);
                instancePath.cubicTo(14.714844f, 21.335938f, 13.332031f, 21.523438f, 11.761719f, 21.523438f);
                instancePath.cubicTo(6.1979494f, 21.523438f, 2.0f, 17.325605f, 2.0f, 11.7265625f);
                instancePath.cubicTo(2.0f, 6.127519f, 6.5092382f, 2.0f, 11.644531f, 2.0f);
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
