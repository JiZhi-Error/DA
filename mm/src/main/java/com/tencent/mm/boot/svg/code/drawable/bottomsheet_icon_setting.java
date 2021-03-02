package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_setting extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-8617851);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(48.0f, 72.0f);
                instancePath.cubicTo(34.745335f, 72.0f, 24.0f, 61.254665f, 24.0f, 48.0f);
                instancePath.cubicTo(24.0f, 34.745335f, 34.745335f, 24.0f, 48.0f, 24.0f);
                instancePath.cubicTo(61.254665f, 24.0f, 72.0f, 34.745335f, 72.0f, 48.0f);
                instancePath.cubicTo(72.0f, 61.254665f, 61.254665f, 72.0f, 48.0f, 72.0f);
                instancePath.moveTo(84.0f, 55.0f);
                instancePath.cubicTo(81.99446f, 53.280666f, 80.68781f, 51.20543f, 80.0f, 49.0f);
                instancePath.cubicTo(80.16416f, 45.77458f, 81.55951f, 43.011635f, 84.0f, 41.0f);
                instancePath.cubicTo(83.86168f, 41.38516f, 83.86033f, 41.374397f, 84.0f, 41.0f);
                instancePath.lineTo(84.0f, 41.0f);
                instancePath.cubicTo(84.53887f, 40.971813f, 84.63342f, 40.913532f, 85.0f, 41.0f);
                instancePath.lineTo(88.0f, 39.0f);
                instancePath.lineTo(76.0f, 18.0f);
                instancePath.lineTo(72.0f, 20.0f);
                instancePath.cubicTo(71.67275f, 20.391605f, 71.65744f, 20.37726f, 72.0f, 20.0f);
                instancePath.cubicTo(69.576805f, 21.307058f, 67.130554f, 21.391342f, 65.0f, 20.0f);
                instancePath.cubicTo(62.163757f, 19.135885f, 60.461334f, 16.563023f, 60.0f, 14.0f);
                instancePath.cubicTo(60.185326f, 13.773625f, 60.170918f, 13.76959f, 60.0f, 14.0f);
                instancePath.lineTo(60.0f, 9.0f);
                instancePath.lineTo(36.0f, 9.0f);
                instancePath.lineTo(36.0f, 14.0f);
                instancePath.cubicTo(35.82548f, 13.770487f, 35.80837f, 13.77766f, 36.0f, 14.0f);
                instancePath.cubicTo(35.57739f, 16.033117f, 34.42788f, 18.18098f, 32.0f, 20.0f);
                instancePath.cubicTo(29.993292f, 21.329027f, 26.91668f, 21.51418f, 24.0f, 20.0f);
                instancePath.cubicTo(24.35021f, 20.375916f, 24.330849f, 20.390709f, 24.0f, 20.0f);
                instancePath.lineTo(20.0f, 18.0f);
                instancePath.lineTo(8.0f, 39.0f);
                instancePath.lineTo(11.0f, 41.0f);
                instancePath.cubicTo(11.374231f, 40.91219f, 11.548482f, 41.0153f, 12.0f, 41.0f);
                instancePath.lineTo(12.0f, 41.0f);
                instancePath.cubicTo(12.142371f, 41.375294f, 12.141021f, 41.385605f, 12.0f, 41.0f);
                instancePath.cubicTo(13.99113f, 42.70454f, 15.286522f, 44.77081f, 16.0f, 47.0f);
                instancePath.cubicTo(15.808371f, 50.181038f, 14.4215765f, 52.935467f, 12.0f, 55.0f);
                instancePath.cubicTo(12.135167f, 54.580772f, 12.138319f, 54.608566f, 12.0f, 55.0f);
                instancePath.lineTo(8.0f, 57.0f);
                instancePath.lineTo(20.0f, 78.0f);
                instancePath.lineTo(23.0f, 76.0f);
                instancePath.cubicTo(23.531641f, 76.013664f, 23.863031f, 75.81821f, 24.0f, 76.0f);
                instancePath.lineTo(24.0f, 76.0f);
                instancePath.cubicTo(24.31194f, 75.59943f, 24.31599f, 75.60256f, 24.0f, 76.0f);
                instancePath.cubicTo(26.386726f, 74.657074f, 28.83838f, 74.571f, 31.0f, 76.0f);
                instancePath.cubicTo(33.82003f, 76.83273f, 35.52606f, 79.42039f, 36.0f, 82.0f);
                instancePath.cubicTo(35.799816f, 82.22503f, 35.820976f, 82.23399f, 36.0f, 82.0f);
                instancePath.lineTo(36.0f, 87.0f);
                instancePath.lineTo(60.0f, 87.0f);
                instancePath.lineTo(60.0f, 83.0f);
                instancePath.cubicTo(60.14255f, 83.06158f, 60.14075f, 82.77466f, 60.0f, 82.0f);
                instancePath.lineTo(60.0f, 82.0f);
                instancePath.cubicTo(60.163715f, 82.23399f, 60.170017f, 82.23131f, 60.0f, 82.0f);
                instancePath.cubicTo(60.378036f, 79.9624f, 61.531147f, 77.793465f, 64.0f, 76.0f);
                instancePath.cubicTo(65.9968f, 74.62345f, 69.09953f, 74.44592f, 72.0f, 76.0f);
                instancePath.cubicTo(71.6696f, 75.61646f, 71.682205f, 75.6075f, 72.0f, 76.0f);
                instancePath.lineTo(76.0f, 78.0f);
                instancePath.lineTo(88.0f, 57.0f);
                instancePath.lineTo(84.0f, 55.0f);
                instancePath.cubicTo(83.85628f, 54.618427f, 83.85808f, 54.603188f, 84.0f, 55.0f);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
