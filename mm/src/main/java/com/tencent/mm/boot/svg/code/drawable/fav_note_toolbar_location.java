package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fav_note_toolbar_location extends c {
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
                instancePath.moveTo(36.19557f, 63.7295f);
                instancePath.cubicTo(36.18903f, 63.723602f, 36.182568f, 63.717976f, 36.176186f, 63.712605f);
                instancePath.lineTo(36.19557f, 63.7295f);
                instancePath.close();
                instancePath.moveTo(36.74051f, 62.90582f);
                instancePath.cubicTo(37.4488f, 62.267334f, 38.24197f, 61.523434f, 39.098534f, 60.683678f);
                instancePath.cubicTo(41.551903f, 58.278442f, 44.006676f, 55.60057f, 46.290497f, 52.73064f);
                instancePath.cubicTo(52.408028f, 45.04313f, 56.13418f, 37.461308f, 56.38646f, 30.719046f);
                instancePath.cubicTo(56.39548f, 30.477993f, 56.4f, 30.23831f, 56.4f, 30.0f);
                instancePath.cubicTo(56.4f, 18.73339f, 47.26661f, 9.6f, 36.0f, 9.6f);
                instancePath.cubicTo(24.73339f, 9.6f, 15.6f, 18.73339f, 15.6f, 30.0f);
                instancePath.cubicTo(15.6f, 30.23831f, 15.604521f, 30.477993f, 15.61354f, 30.719046f);
                instancePath.cubicTo(15.865823f, 37.461308f, 19.59197f, 45.04313f, 25.709501f, 52.73064f);
                instancePath.cubicTo(27.993324f, 55.60057f, 30.4481f, 58.278442f, 32.901466f, 60.683678f);
                instancePath.cubicTo(33.75803f, 61.523434f, 34.5512f, 62.267334f, 35.25949f, 62.90582f);
                instancePath.cubicTo(35.590477f, 63.20419f, 35.840916f, 63.424175f, 36.0f, 63.561043f);
                instancePath.cubicTo(36.159084f, 63.424175f, 36.409523f, 63.20419f, 36.74051f, 62.90582f);
                instancePath.close();
                instancePath.moveTo(33.785156f, 66.40343f);
                instancePath.cubicTo(33.785156f, 66.40343f, 12.0f, 48.054832f, 12.0f, 30.0f);
                instancePath.cubicTo(12.0f, 16.745167f, 22.745167f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(49.254833f, 6.0f, 60.0f, 16.745167f, 60.0f, 30.0f);
                instancePath.cubicTo(60.0f, 48.054832f, 38.214844f, 66.40343f, 38.214844f, 66.40343f);
                instancePath.cubicTo(37.000694f, 67.51806f, 35.00838f, 67.5061f, 33.785156f, 66.40343f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(36.0f, 38.4f);
                instancePath2.cubicTo(40.63919f, 38.4f, 44.4f, 34.63919f, 44.4f, 30.0f);
                instancePath2.cubicTo(44.4f, 25.360807f, 40.63919f, 21.6f, 36.0f, 21.6f);
                instancePath2.cubicTo(31.360807f, 21.6f, 27.6f, 25.360807f, 27.6f, 30.0f);
                instancePath2.cubicTo(27.6f, 34.63919f, 31.360807f, 38.4f, 36.0f, 38.4f);
                instancePath2.close();
                instancePath2.moveTo(36.0f, 42.0f);
                instancePath2.cubicTo(29.372583f, 42.0f, 24.0f, 36.62742f, 24.0f, 30.0f);
                instancePath2.cubicTo(24.0f, 23.372583f, 29.372583f, 18.0f, 36.0f, 18.0f);
                instancePath2.cubicTo(42.62742f, 18.0f, 48.0f, 23.372583f, 48.0f, 30.0f);
                instancePath2.cubicTo(48.0f, 36.62742f, 42.62742f, 42.0f, 36.0f, 42.0f);
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
