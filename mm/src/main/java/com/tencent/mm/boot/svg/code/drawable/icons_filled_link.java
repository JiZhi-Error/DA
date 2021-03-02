package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_link extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(52.970562f, 36.0f);
                instancePath.lineTo(48.72792f, 31.757359f);
                instancePath.lineTo(55.091885f, 25.393398f);
                instancePath.cubicTo(57.435028f, 23.050253f, 57.435028f, 19.251263f, 55.091885f, 16.908117f);
                instancePath.cubicTo(52.748737f, 14.564971f, 48.94975f, 14.564971f, 46.6066f, 16.908117f);
                instancePath.lineTo(33.87868f, 29.63604f);
                instancePath.cubicTo(31.535534f, 31.979185f, 31.535534f, 35.778175f, 33.87868f, 38.12132f);
                instancePath.lineTo(29.63604f, 42.36396f);
                instancePath.cubicTo(24.949747f, 37.67767f, 24.949747f, 30.079689f, 29.63604f, 25.393398f);
                instancePath.lineTo(42.36396f, 12.665476f);
                instancePath.cubicTo(47.05025f, 7.9791846f, 54.64823f, 7.9791846f, 59.334522f, 12.665476f);
                instancePath.cubicTo(64.02081f, 17.351768f, 64.02081f, 24.949747f, 59.334522f, 29.63604f);
                instancePath.lineTo(52.970562f, 36.0f);
                instancePath.close();
                instancePath.moveTo(19.029438f, 36.0f);
                instancePath.lineTo(23.272078f, 40.24264f);
                instancePath.lineTo(16.908117f, 46.6066f);
                instancePath.cubicTo(14.564971f, 48.94975f, 14.564971f, 52.748737f, 16.908117f, 55.091885f);
                instancePath.cubicTo(19.251263f, 57.435028f, 23.050253f, 57.435028f, 25.393398f, 55.091885f);
                instancePath.lineTo(38.12132f, 42.36396f);
                instancePath.cubicTo(40.464466f, 40.020817f, 40.464466f, 36.221825f, 38.12132f, 33.87868f);
                instancePath.lineTo(42.36396f, 29.63604f);
                instancePath.cubicTo(47.05025f, 34.32233f, 47.05025f, 41.92031f, 42.36396f, 46.6066f);
                instancePath.lineTo(29.63604f, 59.334522f);
                instancePath.cubicTo(24.949747f, 64.02081f, 17.351768f, 64.02081f, 12.665476f, 59.334522f);
                instancePath.cubicTo(7.9791846f, 54.64823f, 7.9791846f, 47.05025f, 12.665476f, 42.36396f);
                instancePath.lineTo(19.029438f, 36.0f);
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
