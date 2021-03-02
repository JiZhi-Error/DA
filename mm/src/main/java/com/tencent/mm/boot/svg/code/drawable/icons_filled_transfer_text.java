package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_transfer_text extends c {
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
                instancePath.moveTo(12.0f, 9.0f);
                instancePath.lineTo(60.0f, 9.0f);
                instancePath.cubicTo(61.656853f, 9.0f, 63.0f, 10.343145f, 63.0f, 12.0f);
                instancePath.lineTo(63.0f, 60.0f);
                instancePath.cubicTo(63.0f, 61.656853f, 61.656853f, 63.0f, 60.0f, 63.0f);
                instancePath.lineTo(12.0f, 63.0f);
                instancePath.cubicTo(10.343145f, 63.0f, 9.0f, 61.656853f, 9.0f, 60.0f);
                instancePath.lineTo(9.0f, 12.0f);
                instancePath.cubicTo(9.0f, 10.343145f, 10.343145f, 9.0f, 12.0f, 9.0f);
                instancePath.close();
                instancePath.moveTo(21.594f, 26.544f);
                instancePath.lineTo(21.594f, 29.976f);
                instancePath.lineTo(26.61f, 29.976f);
                instancePath.cubicTo(27.996f, 34.761f, 30.471f, 38.952f, 34.035f, 42.582f);
                instancePath.cubicTo(30.603f, 45.486f, 26.247f, 47.598f, 21.0f, 48.951f);
                instancePath.lineTo(22.848f, 51.987f);
                instancePath.cubicTo(28.227f, 50.469f, 32.781f, 48.06f, 36.477f, 44.793f);
                instancePath.cubicTo(39.975f, 47.697f, 44.364f, 50.139f, 49.644f, 52.119f);
                instancePath.lineTo(51.558f, 49.182f);
                instancePath.cubicTo(46.542f, 47.334f, 42.318f, 45.09f, 38.919f, 42.384f);
                instancePath.cubicTo(41.955f, 39.051f, 44.265f, 34.926f, 45.849f, 29.976f);
                instancePath.lineTo(50.832f, 29.976f);
                instancePath.lineTo(50.832f, 26.544f);
                instancePath.lineTo(38.358f, 26.544f);
                instancePath.cubicTo(37.368f, 24.399f, 36.279f, 22.551f, 35.091f, 21.0f);
                instancePath.lineTo(31.626f, 22.254f);
                instancePath.cubicTo(32.814f, 23.607f, 33.837f, 25.026f, 34.662f, 26.544f);
                instancePath.lineTo(21.594f, 26.544f);
                instancePath.close();
                instancePath.moveTo(29.91f, 29.976f);
                instancePath.lineTo(42.285f, 29.976f);
                instancePath.cubicTo(40.998f, 33.969f, 39.051f, 37.401f, 36.477f, 40.239f);
                instancePath.cubicTo(33.441f, 37.269f, 31.263f, 33.87f, 29.91f, 29.976f);
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
