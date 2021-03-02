package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_home extends c {
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
                instancePath.moveTo(39.0f, 59.4f);
                instancePath.lineTo(50.4f, 59.4f);
                instancePath.lineTo(50.4f, 38.4f);
                instancePath.lineTo(60.30883f, 38.4f);
                instancePath.lineTo(36.0f, 14.091168f);
                instancePath.lineTo(11.691169f, 38.4f);
                instancePath.lineTo(21.6f, 38.4f);
                instancePath.lineTo(21.6f, 59.4f);
                instancePath.lineTo(33.0f, 59.4f);
                instancePath.lineTo(33.0f, 51.0f);
                instancePath.lineTo(39.0f, 51.0f);
                instancePath.lineTo(39.0f, 59.4f);
                instancePath.close();
                instancePath.moveTo(54.0f, 60.0f);
                instancePath.cubicTo(54.0f, 61.656853f, 52.656853f, 63.0f, 51.0f, 63.0f);
                instancePath.lineTo(21.0f, 63.0f);
                instancePath.cubicTo(19.343145f, 63.0f, 18.0f, 61.656853f, 18.0f, 60.0f);
                instancePath.lineTo(18.0f, 42.0f);
                instancePath.lineTo(10.2426405f, 42.0f);
                instancePath.cubicTo(9.446991f, 42.0f, 8.683929f, 41.68393f, 8.121321f, 41.12132f);
                instancePath.cubicTo(6.9497476f, 39.94975f, 6.9497476f, 38.05025f, 8.121321f, 36.87868f);
                instancePath.lineTo(33.87868f, 11.121321f);
                instancePath.cubicTo(35.05025f, 9.949747f, 36.94975f, 9.949747f, 38.12132f, 11.121321f);
                instancePath.lineTo(63.87868f, 36.87868f);
                instancePath.cubicTo(64.44129f, 37.441288f, 64.75736f, 38.20435f, 64.75736f, 39.0f);
                instancePath.cubicTo(64.75736f, 40.656853f, 63.414215f, 42.0f, 61.75736f, 42.0f);
                instancePath.lineTo(54.0f, 42.0f);
                instancePath.lineTo(54.0f, 60.0f);
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
