package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_float_window_off extends c {
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
                instancePath.moveTo(17.484753f, 12.393583f);
                instancePath.cubicTo(22.583975f, 8.388523f, 29.013054f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                instancePath.cubicTo(66.0f, 42.986946f, 63.611477f, 49.416023f, 59.60642f, 54.515247f);
                instancePath.lineTo(64.27494f, 59.183765f);
                instancePath.lineTo(61.72935f, 61.72935f);
                instancePath.lineTo(11.545586f, 11.545585f);
                instancePath.lineTo(14.09117f, 9.0f);
                instancePath.lineTo(17.484753f, 12.393583f);
                instancePath.close();
                instancePath.moveTo(57.039856f, 51.94869f);
                instancePath.cubicTo(60.403683f, 47.51793f, 62.4f, 41.992096f, 62.4f, 36.0f);
                instancePath.cubicTo(62.4f, 21.419683f, 50.58032f, 9.6f, 36.0f, 9.6f);
                instancePath.cubicTo(30.007904f, 9.6f, 24.482073f, 11.596316f, 20.051313f, 14.960142f);
                instancePath.lineTo(26.073397f, 20.982227f);
                instancePath.cubicTo(28.918957f, 19.097555f, 32.331303f, 18.0f, 36.0f, 18.0f);
                instancePath.cubicTo(45.941124f, 18.0f, 54.0f, 26.058874f, 54.0f, 36.0f);
                instancePath.cubicTo(54.0f, 39.668697f, 52.902443f, 43.081043f, 51.017773f, 45.9266f);
                instancePath.lineTo(57.039856f, 51.94869f);
                instancePath.close();
                instancePath.moveTo(48.40625f, 43.315083f);
                instancePath.cubicTo(49.673054f, 41.171234f, 50.4f, 38.67051f, 50.4f, 36.0f);
                instancePath.cubicTo(50.4f, 28.0471f, 43.9529f, 21.6f, 36.0f, 21.6f);
                instancePath.cubicTo(33.32949f, 21.6f, 30.828766f, 22.326946f, 28.68492f, 23.593748f);
                instancePath.lineTo(48.40625f, 43.315083f);
                instancePath.close();
                instancePath.moveTo(12.393583f, 17.484753f);
                instancePath.lineTo(14.960142f, 20.051313f);
                instancePath.cubicTo(11.596316f, 24.482073f, 9.6f, 30.007904f, 9.6f, 36.0f);
                instancePath.cubicTo(9.6f, 50.58032f, 21.419683f, 62.4f, 36.0f, 62.4f);
                instancePath.cubicTo(41.992096f, 62.4f, 47.51793f, 60.403683f, 51.94869f, 57.039856f);
                instancePath.lineTo(54.515247f, 59.60642f);
                instancePath.cubicTo(49.416023f, 63.611477f, 42.986946f, 66.0f, 36.0f, 66.0f);
                instancePath.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 29.013054f, 8.388523f, 22.583975f, 12.393583f, 17.484753f);
                instancePath.close();
                instancePath.moveTo(20.982227f, 26.073397f);
                instancePath.lineTo(23.593748f, 28.68492f);
                instancePath.cubicTo(22.326946f, 30.828766f, 21.6f, 33.32949f, 21.6f, 36.0f);
                instancePath.cubicTo(21.6f, 43.9529f, 28.0471f, 50.4f, 36.0f, 50.4f);
                instancePath.cubicTo(38.67051f, 50.4f, 41.171234f, 49.673054f, 43.315083f, 48.40625f);
                instancePath.lineTo(45.9266f, 51.017773f);
                instancePath.cubicTo(43.081043f, 52.902443f, 39.668697f, 54.0f, 36.0f, 54.0f);
                instancePath.cubicTo(26.058874f, 54.0f, 18.0f, 45.941124f, 18.0f, 36.0f);
                instancePath.cubicTo(18.0f, 32.331303f, 19.097555f, 28.918957f, 20.982227f, 26.073397f);
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
