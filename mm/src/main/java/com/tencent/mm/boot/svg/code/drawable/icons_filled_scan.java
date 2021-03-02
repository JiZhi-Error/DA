package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_scan extends c {
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
                instancePath.moveTo(35.78873f, 51.0f);
                instancePath.lineTo(24.0f, 51.0f);
                instancePath.cubicTo(22.343145f, 51.0f, 21.0f, 49.656853f, 21.0f, 48.0f);
                instancePath.cubicTo(21.0f, 46.343147f, 22.343145f, 45.0f, 24.0f, 45.0f);
                instancePath.lineTo(52.90141f, 45.0f);
                instancePath.cubicTo(54.59155f, 45.0f, 56.070423f, 43.94366f, 56.28169f, 42.25352f);
                instancePath.lineTo(56.28169f, 41.619717f);
                instancePath.lineTo(56.28169f, 36.338028f);
                instancePath.cubicTo(56.28169f, 34.64789f, 56.915493f, 32.957745f, 58.183098f, 31.690142f);
                instancePath.cubicTo(58.816902f, 30.84507f, 60.084507f, 30.0f, 61.140846f, 30.0f);
                instancePath.cubicTo(62.619717f, 30.0f, 63.676056f, 31.267605f, 63.46479f, 32.74648f);
                instancePath.cubicTo(63.46479f, 32.74648f, 63.25352f, 34.859154f, 63.25352f, 35.915493f);
                instancePath.cubicTo(63.25352f, 38.239437f, 63.46479f, 40.774647f, 64.098595f, 43.09859f);
                instancePath.cubicTo(64.30986f, 43.94366f, 64.521126f, 44.577465f, 64.73239f, 45.21127f);
                instancePath.cubicTo(65.57746f, 47.957745f, 66.0f, 50.704224f, 66.0f, 53.661972f);
                instancePath.lineTo(66.0f, 55.985916f);
                instancePath.cubicTo(65.788734f, 57.887325f, 64.943665f, 59.78873f, 63.887325f, 61.267605f);
                instancePath.cubicTo(61.985916f, 64.014084f, 58.816902f, 65.70422f, 55.225353f, 66.0f);
                instancePath.lineTo(49.732395f, 66.0f);
                instancePath.cubicTo(46.56338f, 65.91549f, 43.605633f, 64.43662f, 41.492958f, 62.323944f);
                instancePath.cubicTo(41.070423f, 61.90141f, 40.64789f, 61.267605f, 40.225353f, 60.633804f);
                instancePath.cubicTo(38.112675f, 58.09859f, 36.633804f, 54.929577f, 35.78873f, 51.0f);
                instancePath.close();
                instancePath.moveTo(36.21127f, 21.0f);
                instancePath.lineTo(48.0f, 21.0f);
                instancePath.cubicTo(49.656853f, 21.0f, 51.0f, 22.343145f, 51.0f, 24.0f);
                instancePath.cubicTo(51.0f, 25.656855f, 49.656853f, 27.0f, 48.0f, 27.0f);
                instancePath.lineTo(19.09859f, 27.0f);
                instancePath.cubicTo(17.408451f, 27.0f, 15.929578f, 28.056337f, 15.71831f, 29.746479f);
                instancePath.lineTo(15.71831f, 30.380281f);
                instancePath.lineTo(15.71831f, 35.661972f);
                instancePath.cubicTo(15.71831f, 37.35211f, 15.084507f, 39.042255f, 13.816901f, 40.30986f);
                instancePath.cubicTo(13.183099f, 41.15493f, 11.915493f, 42.0f, 10.859155f, 42.0f);
                instancePath.cubicTo(9.380281f, 42.0f, 8.323944f, 40.732395f, 8.535212f, 39.25352f);
                instancePath.cubicTo(8.535212f, 39.25352f, 8.746479f, 37.140846f, 8.746479f, 36.084507f);
                instancePath.cubicTo(8.746479f, 33.760563f, 8.535212f, 31.225351f, 7.9014087f, 28.90141f);
                instancePath.cubicTo(7.6901407f, 28.056337f, 7.4788733f, 27.422535f, 7.267606f, 26.788733f);
                instancePath.cubicTo(6.4225354f, 24.042253f, 6.0f, 21.295774f, 6.0f, 18.338028f);
                instancePath.lineTo(6.0f, 16.014084f);
                instancePath.cubicTo(6.2112675f, 14.112676f, 7.056338f, 12.211267f, 8.112676f, 10.732394f);
                instancePath.cubicTo(10.014085f, 7.9859157f, 13.183099f, 6.2957745f, 16.774649f, 6.0f);
                instancePath.lineTo(22.267605f, 6.0f);
                instancePath.cubicTo(25.436619f, 6.084507f, 28.394365f, 7.5633802f, 30.507042f, 9.676056f);
                instancePath.cubicTo(30.929577f, 10.098592f, 31.352112f, 10.732394f, 31.774649f, 11.366198f);
                instancePath.cubicTo(33.887325f, 13.901408f, 35.366196f, 17.070423f, 36.21127f, 21.0f);
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
