package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.WebView;

public class multitalk_mute_action_on extends c {
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
                instancePath.moveTo(103.76728f, 117.98263f);
                instancePath.cubicTo(100.49875f, 119.62946f, 96.85723f, 120.66371f, 93.0f, 120.93096f);
                instancePath.lineTo(93.0f, 129.0f);
                instancePath.lineTo(93.0f, 129.0f);
                instancePath.lineTo(107.000854f, 129.0f);
                instancePath.cubicTo(107.552666f, 129.0f, 108.0f, 129.44336f, 108.0f, 130.00937f);
                instancePath.lineTo(108.0f, 131.99063f);
                instancePath.cubicTo(108.0f, 132.5481f, 107.545074f, 133.0f, 107.000854f, 133.0f);
                instancePath.lineTo(74.999146f, 133.0f);
                instancePath.cubicTo(74.447334f, 133.0f, 74.0f, 132.55664f, 74.0f, 131.99063f);
                instancePath.lineTo(74.0f, 130.00937f);
                instancePath.cubicTo(74.0f, 129.4519f, 74.454926f, 129.0f, 74.999146f, 129.0f);
                instancePath.lineTo(89.0f, 129.0f);
                instancePath.lineTo(89.0f, 120.93096f);
                instancePath.lineTo(89.0f, 120.93096f);
                instancePath.cubicTo(74.46945f, 119.92421f, 63.0f, 108.032974f, 63.0f, 93.51188f);
                instancePath.lineTo(63.0f, 88.99816f);
                instancePath.cubicTo(63.0f, 88.45106f, 63.451874f, 88.0f, 64.009285f, 88.0f);
                instancePath.lineTo(65.99039f, 88.0f);
                instancePath.cubicTo(66.55636f, 88.0f, 66.99967f, 88.45177f, 66.99967f, 89.009056f);
                instancePath.lineTo(66.99967f, 93.36467f);
                instancePath.cubicTo(66.99967f, 106.95095f, 78.00566f, 117.0f, 91.0f, 117.0f);
                instancePath.cubicTo(94.46276f, 117.0f, 97.784004f, 116.298294f, 100.79325f, 115.0086f);
                instancePath.lineTo(103.76728f, 117.98263f);
                instancePath.lineTo(103.76728f, 117.98263f);
                instancePath.close();
                instancePath.moveTo(112.10175f, 111.58026f);
                instancePath.cubicTo(116.397675f, 106.74892f, 119.0f, 100.42874f, 119.0f, 93.51188f);
                instancePath.lineTo(119.0f, 88.99816f);
                instancePath.cubicTo(119.0f, 88.44689f, 118.556175f, 88.0f, 117.99989f, 88.0f);
                instancePath.lineTo(115.99589f, 88.0f);
                instancePath.cubicTo(115.44354f, 88.0f, 114.99578f, 88.45739f, 114.99578f, 89.009056f);
                instancePath.lineTo(114.99578f, 93.36467f);
                instancePath.cubicTo(114.99578f, 99.441376f, 112.848305f, 104.76214f, 109.33026f, 108.80877f);
                instancePath.lineTo(112.10175f, 111.58026f);
                instancePath.lineTo(112.10175f, 111.58026f);
                instancePath.close();
                instancePath.moveTo(103.92377f, 103.40227f);
                instancePath.cubicTo(105.85821f, 100.75579f, 107.0f, 97.49277f, 107.0f, 93.96288f);
                instancePath.lineTo(107.0f, 63.976562f);
                instancePath.cubicTo(107.0f, 55.14248f, 99.836555f, 47.969723f, 91.0f, 47.969723f);
                instancePath.cubicTo(82.1615f, 47.969723f, 75.0f, 55.13623f, 75.0f, 63.976562f);
                instancePath.lineTo(75.0f, 74.47851f);
                instancePath.lineTo(103.92377f, 103.40227f);
                instancePath.lineTo(103.92377f, 103.40227f);
                instancePath.close();
                instancePath.moveTo(95.19794f, 109.413284f);
                instancePath.cubicTo(93.86017f, 109.776115f, 92.452736f, 109.96972f, 91.0f, 109.96972f);
                instancePath.cubicTo(82.163445f, 109.96972f, 75.0f, 102.79697f, 75.0f, 93.96288f);
                instancePath.lineTo(75.0f, 89.21535f);
                instancePath.lineTo(95.19794f, 109.413284f);
                instancePath.lineTo(95.19794f, 109.413284f);
                instancePath.close();
                instancePath.moveTo(117.006836f, 126.44923f);
                instancePath.lineTo(60.164734f, 69.60712f);
                instancePath.lineTo(62.99316f, 66.778694f);
                instancePath.lineTo(119.835266f, 123.6208f);
                instancePath.lineTo(117.006836f, 126.44923f);
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
