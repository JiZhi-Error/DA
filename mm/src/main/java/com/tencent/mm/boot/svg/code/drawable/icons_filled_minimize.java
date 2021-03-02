package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_minimize extends c {
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
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(9.9339485f, 12.944684f);
                instancePath.cubicTo(10.4173155f, 12.944684f, 10.809162f, 13.336531f, 10.809162f, 13.819898f);
                instancePath.lineTo(10.809162f, 18.195967f);
                instancePath.lineTo(9.058735f, 18.195967f);
                instancePath.lineTo(9.058735f, 15.932349f);
                instancePath.lineTo(5.237739f, 19.752249f);
                instancePath.lineTo(4.0f, 18.51451f);
                instancePath.lineTo(7.8193984f, 14.695111f);
                instancePath.lineTo(5.55788f, 14.695111f);
                instancePath.lineTo(5.55788f, 12.944684f);
                instancePath.lineTo(9.9339485f, 12.944684f);
                instancePath.close();
                instancePath.moveTo(18.516108f, 4.0f);
                instancePath.lineTo(19.753847f, 5.237739f);
                instancePath.lineTo(15.934448f, 9.0571375f);
                instancePath.lineTo(18.195967f, 9.0571375f);
                instancePath.lineTo(18.195967f, 10.807565f);
                instancePath.lineTo(13.819898f, 10.807565f);
                instancePath.cubicTo(13.336531f, 10.807565f, 12.944684f, 10.415718f, 12.944684f, 9.932351f);
                instancePath.lineTo(12.944684f, 5.5562825f);
                instancePath.lineTo(14.695111f, 5.5562825f);
                instancePath.lineTo(14.695111f, 7.8198996f);
                instancePath.lineTo(18.516108f, 4.0f);
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
