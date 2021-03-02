package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class find_more_friend_scan extends c {
    private final int height = 108;
    private final int width = 108;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                instancePaint3.setColor(-15683841);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(83.536f, 51.622f);
                instancePath.cubicTo(83.706f, 50.222f, 82.506f, 49.728f, 81.518f, 49.842f);
                instancePath.cubicTo(77.568f, 50.3f, 75.446f, 56.019f, 76.0f, 57.999f);
                instancePath.cubicTo(76.771f, 60.757f, 74.209f, 64.999f, 72.0f, 64.999f);
                instancePath.lineTo(43.992f, 64.999f);
                instancePath.cubicTo(42.34f, 64.999f, 41.0f, 66.339f, 41.0f, 67.992f);
                instancePath.lineTo(41.0f, 68.992f);
                instancePath.cubicTo(41.0f, 70.653f, 42.346f, 71.999f, 44.007f, 71.999f);
                instancePath.lineTo(55.412f, 71.999f);
                instancePath.cubicTo(59.928f, 82.978f, 64.233f, 85.999f, 68.0f, 85.999f);
                instancePath.lineTo(75.0f, 85.999f);
                instancePath.cubicTo(82.11f, 85.999f, 86.0f, 80.155f, 86.0f, 74.999f);
                instancePath.cubicTo(86.0f, 63.905f, 82.28f, 61.959f, 83.536f, 51.622f);
                instancePath.lineTo(83.536f, 51.622f);
                instancePath.close();
                instancePath.moveTo(68.0f, 39.006f);
                instancePath.cubicTo(68.0f, 37.345f, 66.654f, 35.999f, 64.993f, 35.999f);
                instancePath.lineTo(52.962f, 35.999f);
                instancePath.cubicTo(51.374f, 31.975f, 49.0f, 26.999f, 49.0f, 26.999f);
                instancePath.cubicTo(47.568f, 23.262f, 43.749f, 22.312f, 40.952f, 22.077f);
                instancePath.cubicTo(40.83f, 22.067f, 40.734f, 22.058f, 40.64f, 22.052f);
                instancePath.cubicTo(40.429f, 22.029f, 40.219f, 22.0f, 40.0f, 22.0f);
                instancePath.lineTo(34.0f, 22.0f);
                instancePath.cubicTo(25.557f, 22.0f, 22.0f, 27.843f, 22.0f, 33.0f);
                instancePath.cubicTo(22.0f, 44.094f, 25.721f, 46.039f, 24.465f, 56.377f);
                instancePath.cubicTo(24.295f, 57.776f, 25.495f, 58.271f, 26.483f, 58.156f);
                instancePath.cubicTo(30.433f, 57.698f, 32.555f, 51.98f, 32.001f, 49.999f);
                instancePath.cubicTo(31.23f, 47.241f, 32.200043f, 45.572628f, 32.54726f, 44.979992f);
                instancePath.cubicTo(33.241585f, 43.794914f, 34.52841f, 42.999f, 36.001f, 42.999f);
                instancePath.lineTo(65.008f, 42.999f);
                instancePath.cubicTo(66.661f, 42.998f, 68.0f, 41.659f, 68.0f, 40.006f);
                instancePath.lineTo(68.0f, 39.006f);
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
