package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.WebView;

public class multitalk_handsfree_action_on extends c {
    private final int height = 240;
    private final int width = TXLiveConstants.RENDER_ROTATION_180;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return TXLiveConstants.RENDER_ROTATION_180;
            case 1:
                return 240;
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
                instancePaint3.setColor(-1);
                canvas.saveLayerAlpha(null, 230, 31);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(90.0f, 180.0f);
                instancePath.cubicTo(139.70563f, 180.0f, 180.0f, 139.70563f, 180.0f, 90.0f);
                instancePath.cubicTo(180.0f, 40.294373f, 139.70563f, 0.0f, 90.0f, 0.0f);
                instancePath.cubicTo(40.294373f, 0.0f, 0.0f, 40.294373f, 0.0f, 90.0f);
                instancePath.cubicTo(0.0f, 139.70563f, 40.294373f, 180.0f, 90.0f, 180.0f);
                instancePath.close();
                instancePath.moveTo(62.0f, 100.0f);
                instancePath.lineTo(84.0f, 115.0f);
                instancePath.lineTo(84.0f, 65.0f);
                instancePath.lineTo(62.0f, 80.0f);
                instancePath.lineTo(48.0f, 80.0f);
                instancePath.lineTo(48.0f, 100.0f);
                instancePath.lineTo(62.0f, 100.0f);
                instancePath.close();
                instancePath.moveTo(123.00751f, 126.117966f);
                instancePath.cubicTo(128.96204f, 115.445175f, 132.35507f, 103.14832f, 132.35507f, 90.05898f);
                instancePath.cubicTo(132.35507f, 76.96964f, 128.96204f, 64.67279f, 123.00751f, 54.0f);
                instancePath.lineTo(123.00751f, 54.0f);
                instancePath.lineTo(119.0f, 56.9666f);
                instancePath.cubicTo(124.36485f, 66.79643f, 127.413895f, 78.07163f, 127.413895f, 90.05898f);
                instancePath.cubicTo(127.413895f, 102.04633f, 124.36485f, 113.32154f, 119.0f, 123.15137f);
                instancePath.lineTo(123.00751f, 126.117966f);
                instancePath.close();
                instancePath.moveTo(110.93931f, 117.29133f);
                instancePath.cubicTo(115.135056f, 109.15772f, 117.50414f, 99.92836f, 117.50414f, 90.14567f);
                instancePath.cubicTo(117.50414f, 80.36297f, 115.135056f, 71.133606f, 110.93931f, 63.0f);
                instancePath.lineTo(110.93931f, 63.0f);
                instancePath.lineTo(107.0f, 65.916115f);
                instancePath.cubicTo(110.71647f, 73.27225f, 112.81003f, 81.588f, 112.81003f, 90.39272f);
                instancePath.cubicTo(112.81003f, 99.05392f, 110.78417f, 107.24194f, 107.180466f, 114.508804f);
                instancePath.lineTo(110.93931f, 117.29133f);
                instancePath.lineTo(110.93931f, 117.29133f);
                instancePath.close();
                instancePath.moveTo(99.07929f, 108.3367f);
                instancePath.cubicTo(101.56525f, 102.78967f, 102.947845f, 96.64047f, 102.947845f, 90.16835f);
                instancePath.cubicTo(102.947845f, 83.69623f, 101.56525f, 77.54703f, 99.07929f, 72.0f);
                instancePath.lineTo(99.07929f, 72.0f);
                instancePath.lineTo(95.0f, 75.01974f);
                instancePath.cubicTo(96.93729f, 79.68519f, 98.00667f, 84.80189f, 98.00667f, 90.16835f);
                instancePath.cubicTo(98.00667f, 95.53481f, 96.93729f, 100.65151f, 95.0f, 105.31697f);
                instancePath.lineTo(99.07929f, 108.3367f);
                instancePath.lineTo(99.07929f, 108.3367f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
