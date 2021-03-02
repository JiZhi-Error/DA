package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_barrage extends c {
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
                instancePath.moveTo(60.0f, 9.0f);
                instancePath.cubicTo(61.656853f, 9.0f, 63.0f, 10.343145f, 63.0f, 12.0f);
                instancePath.lineTo(63.0f, 60.0f);
                instancePath.cubicTo(63.0f, 61.656853f, 61.656853f, 63.0f, 60.0f, 63.0f);
                instancePath.lineTo(12.0f, 63.0f);
                instancePath.cubicTo(10.343145f, 63.0f, 9.0f, 61.656853f, 9.0f, 60.0f);
                instancePath.lineTo(9.0f, 12.0f);
                instancePath.cubicTo(9.0f, 10.343145f, 10.343145f, 9.0f, 12.0f, 9.0f);
                instancePath.lineTo(60.0f, 9.0f);
                instancePath.close();
                instancePath.moveTo(59.397f, 12.597f);
                instancePath.lineTo(12.597f, 12.597f);
                instancePath.lineTo(12.597f, 59.397f);
                instancePath.lineTo(59.397f, 59.397f);
                instancePath.lineTo(59.397f, 12.597f);
                instancePath.close();
                instancePath.moveTo(45.972f, 18.75f);
                instancePath.lineTo(49.536f, 20.01f);
                instancePath.cubicTo(48.816f, 21.738f, 47.988f, 23.286f, 47.088f, 24.654f);
                instancePath.lineTo(47.088f, 24.654f);
                instancePath.lineTo(51.264f, 24.654f);
                instancePath.lineTo(51.264f, 39.81f);
                instancePath.lineTo(43.848f, 39.81f);
                instancePath.lineTo(43.848f, 42.582f);
                instancePath.lineTo(52.668f, 42.582f);
                instancePath.lineTo(52.668f, 46.11f);
                instancePath.lineTo(43.848f, 46.11f);
                instancePath.lineTo(43.848f, 52.554f);
                instancePath.lineTo(40.176f, 52.554f);
                instancePath.lineTo(40.176f, 46.11f);
                instancePath.lineTo(31.608f, 46.11f);
                instancePath.lineTo(31.608f, 42.582f);
                instancePath.lineTo(40.176f, 42.582f);
                instancePath.lineTo(40.176f, 39.81f);
                instancePath.lineTo(32.904f, 39.81f);
                instancePath.lineTo(32.904f, 24.654f);
                instancePath.lineTo(37.224f, 24.654f);
                instancePath.cubicTo(36.396f, 22.962f, 35.496f, 21.486f, 34.524f, 20.19f);
                instancePath.lineTo(34.524f, 20.19f);
                instancePath.lineTo(37.944f, 19.038f);
                instancePath.cubicTo(38.952f, 20.478f, 39.852f, 21.99f, 40.608f, 23.646f);
                instancePath.lineTo(40.608f, 23.646f);
                instancePath.lineTo(38.34f, 24.654f);
                instancePath.lineTo(43.308f, 24.654f);
                instancePath.cubicTo(44.316f, 22.818f, 45.18f, 20.838f, 45.972f, 18.75f);
                instancePath.lineTo(45.972f, 18.75f);
                instancePath.close();
                instancePath.moveTo(30.528f, 20.37f);
                instancePath.lineTo(30.528f, 31.458f);
                instancePath.lineTo(24.048f, 31.458f);
                instancePath.lineTo(23.544f, 36.318f);
                instancePath.lineTo(30.744f, 36.318f);
                instancePath.cubicTo(30.744f, 42.51f, 30.528f, 46.65f, 30.168f, 48.738f);
                instancePath.cubicTo(29.736f, 50.826f, 27.9f, 51.978f, 24.624f, 52.194f);
                instancePath.cubicTo(23.688f, 52.194f, 22.752f, 52.122f, 21.744f, 52.05f);
                instancePath.lineTo(21.744f, 52.05f);
                instancePath.lineTo(20.772f, 48.558f);
                instancePath.cubicTo(21.708f, 48.666f, 22.716f, 48.738f, 23.724f, 48.738f);
                instancePath.cubicTo(25.524f, 48.738f, 26.532f, 48.162f, 26.784f, 47.01f);
                instancePath.cubicTo(27.036f, 45.858f, 27.18f, 43.374f, 27.18f, 39.558f);
                instancePath.lineTo(27.18f, 39.558f);
                instancePath.lineTo(19.728f, 39.558f);
                instancePath.lineTo(20.736f, 28.254f);
                instancePath.lineTo(26.82f, 28.254f);
                instancePath.lineTo(26.82f, 23.574f);
                instancePath.lineTo(20.052f, 23.574f);
                instancePath.lineTo(20.052f, 20.37f);
                instancePath.lineTo(30.528f, 20.37f);
                instancePath.close();
                instancePath.moveTo(47.952f, 33.87f);
                instancePath.lineTo(43.848f, 33.87f);
                instancePath.lineTo(43.848f, 36.678f);
                instancePath.lineTo(47.952f, 36.678f);
                instancePath.lineTo(47.952f, 33.87f);
                instancePath.close();
                instancePath.moveTo(40.176f, 33.87f);
                instancePath.lineTo(36.252f, 33.87f);
                instancePath.lineTo(36.252f, 36.678f);
                instancePath.lineTo(40.176f, 36.678f);
                instancePath.lineTo(40.176f, 33.87f);
                instancePath.close();
                instancePath.moveTo(40.176f, 27.822f);
                instancePath.lineTo(36.252f, 27.822f);
                instancePath.lineTo(36.252f, 30.774f);
                instancePath.lineTo(40.176f, 30.774f);
                instancePath.lineTo(40.176f, 27.822f);
                instancePath.close();
                instancePath.moveTo(47.952f, 27.822f);
                instancePath.lineTo(43.848f, 27.822f);
                instancePath.lineTo(43.848f, 30.774f);
                instancePath.lineTo(47.952f, 30.774f);
                instancePath.lineTo(47.952f, 27.822f);
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
