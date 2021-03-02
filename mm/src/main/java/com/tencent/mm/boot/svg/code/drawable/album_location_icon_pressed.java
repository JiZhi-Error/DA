package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class album_location_icon_pressed extends c {
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
                instancePaint3.setColor(-15028967);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(11.261719f, 22.134476f);
                instancePath.cubicTo(11.261719f, 22.134476f, 4.0f, 16.018278f, 4.0f, 10.0f);
                instancePath.cubicTo(4.0f, 5.581722f, 7.581722f, 2.0f, 12.0f, 2.0f);
                instancePath.cubicTo(16.418278f, 2.0f, 20.0f, 5.581722f, 20.0f, 10.0f);
                instancePath.cubicTo(20.0f, 16.018278f, 12.738281f, 22.134476f, 12.738281f, 22.134476f);
                instancePath.cubicTo(12.333565f, 22.50602f, 11.66946f, 22.502035f, 11.261719f, 22.134476f);
                instancePath.close();
                instancePath.moveTo(12.0f, 13.2f);
                instancePath.cubicTo(13.767311f, 13.2f, 15.2f, 11.767311f, 15.2f, 10.0f);
                instancePath.cubicTo(15.2f, 8.232689f, 13.767311f, 6.8f, 12.0f, 6.8f);
                instancePath.cubicTo(10.232689f, 6.8f, 8.8f, 8.232689f, 8.8f, 10.0f);
                instancePath.cubicTo(8.8f, 11.767311f, 10.232689f, 13.2f, 12.0f, 13.2f);
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
