package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_wifi_error extends c {
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
                instancePath.moveTo(48.0f, 37.500957f);
                instancePath.cubicTo(44.632545f, 35.047546f, 40.48532f, 33.6f, 36.0f, 33.6f);
                instancePath.cubicTo(30.366695f, 33.6f, 25.266695f, 35.883347f, 21.575022f, 39.57502f);
                instancePath.lineTo(19.029438f, 37.029438f);
                instancePath.cubicTo(23.372583f, 32.68629f, 29.372583f, 30.0f, 36.0f, 30.0f);
                instancePath.cubicTo(40.371445f, 30.0f, 44.46992f, 31.168732f, 48.0f, 33.210773f);
                instancePath.lineTo(48.0f, 37.500957f);
                instancePath.close();
                instancePath.moveTo(48.0f, 27.152483f);
                instancePath.cubicTo(44.335747f, 25.512175f, 40.2744f, 24.6f, 36.0f, 24.6f);
                instancePath.cubicTo(27.881414f, 24.6f, 20.531414f, 27.890707f, 15.211061f, 33.21106f);
                instancePath.lineTo(12.665476f, 30.665476f);
                instancePath.cubicTo(18.637302f, 24.693651f, 26.887302f, 21.0f, 36.0f, 21.0f);
                instancePath.cubicTo(40.2335f, 21.0f, 44.28081f, 21.79719f, 48.0f, 23.249641f);
                instancePath.lineTo(48.0f, 27.152483f);
                instancePath.close();
                instancePath.moveTo(31.757359f, 49.75736f);
                instancePath.cubicTo(32.843147f, 48.671574f, 34.343147f, 48.0f, 36.0f, 48.0f);
                instancePath.cubicTo(37.656853f, 48.0f, 39.156853f, 48.671574f, 40.24264f, 49.75736f);
                instancePath.lineTo(36.0f, 54.0f);
                instancePath.lineTo(31.757359f, 49.75736f);
                instancePath.close();
                instancePath.moveTo(44.061016f, 45.938984f);
                instancePath.cubicTo(41.998024f, 43.875988f, 39.14802f, 42.6f, 36.0f, 42.6f);
                instancePath.cubicTo(32.85198f, 42.6f, 30.001976f, 43.875988f, 27.938982f, 45.938984f);
                instancePath.lineTo(25.393398f, 43.3934f);
                instancePath.cubicTo(28.107864f, 40.678932f, 31.857864f, 39.0f, 36.0f, 39.0f);
                instancePath.cubicTo(40.142136f, 39.0f, 43.892136f, 40.678932f, 46.6066f, 43.3934f);
                instancePath.lineTo(44.061016f, 45.938984f);
                instancePath.close();
                instancePath.moveTo(51.473682f, 25.5f);
                instancePath.lineTo(55.026318f, 25.5f);
                instancePath.lineTo(54.789474f, 44.526318f);
                instancePath.lineTo(51.710526f, 44.526318f);
                instancePath.lineTo(51.473682f, 25.5f);
                instancePath.close();
                instancePath.moveTo(53.25f, 54.17763f);
                instancePath.cubicTo(51.986843f, 54.17763f, 51.0f, 53.19079f, 51.0f, 51.92763f);
                instancePath.cubicTo(51.0f, 50.644737f, 51.986843f, 49.67763f, 53.25f, 49.67763f);
                instancePath.cubicTo(54.532894f, 49.67763f, 55.5f, 50.644737f, 55.5f, 51.92763f);
                instancePath.cubicTo(55.5f, 53.19079f, 54.532894f, 54.17763f, 53.25f, 54.17763f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
