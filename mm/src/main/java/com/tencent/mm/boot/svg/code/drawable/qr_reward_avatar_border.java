package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.audio.g;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class qr_reward_avatar_border extends c {
    private final int height = g.CTRL_INDEX;
    private final int width = g.CTRL_INDEX;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return g.CTRL_INDEX;
            case 1:
                return g.CTRL_INDEX;
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
                instancePaint3.setColor(-3833595);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(274.5553f, 275.0f);
                instancePath.cubicTo(245.1193f, 272.369f, 198.0823f, 270.665f, 145.0633f, 270.665f);
                instancePath.cubicTo(92.0443f, 270.665f, 45.0103f, 272.369f, 15.5753f, 275.0f);
                instancePath.lineTo(15.0003f, 275.0f);
                instancePath.cubicTo(17.6523f, 245.596f, 19.3733f, 198.364f, 19.3733f, 145.1f);
                instancePath.cubicTo(19.3733f, 91.835f, 17.6523f, 44.606f, 15.0003f, 15.202f);
                instancePath.lineTo(15.0003f, 15.0f);
                instancePath.cubicTo(44.3963f, 17.66f, 91.7033f, 19.386f, 145.0633f, 19.386f);
                instancePath.cubicTo(198.3403f, 19.386f, 245.5833f, 17.665f, 274.9893f, 15.013f);
                instancePath.cubicTo(272.3353f, 44.414f, 270.6143f, 91.664f, 270.6143f, 144.951f);
                instancePath.cubicTo(270.6143f, 198.306f, 272.3403f, 245.607f, 275.0003f, 275.0f);
                instancePath.lineTo(274.5553f, 275.0f);
                instancePath.close();
                instancePath.moveTo(285.1083f, 144.945f);
                instancePath.cubicTo(285.1083f, 85.51f, 287.0283f, 32.808f, 289.9883f, 0.014f);
                instancePath.cubicTo(257.1893f, 2.973f, 204.4943f, 4.892f, 145.0703f, 4.892f);
                instancePath.cubicTo(85.5533f, 4.892f, 32.7883f, 2.966f, 3.0E-4f, 0.0f);
                instancePath.lineTo(3.0E-4f, 0.225f);
                instancePath.cubicTo(2.9583f, 33.022f, 4.8773f, 85.7f, 4.8773f, 145.112f);
                instancePath.cubicTo(4.8773f, 204.522f, 2.9583f, 257.203f, 3.0E-4f, 290.0f);
                instancePath.lineTo(0.6413f, 290.0f);
                instancePath.cubicTo(33.4733f, 287.066f, 85.9343f, 285.165f, 145.0703f, 285.165f);
                instancePath.cubicTo(204.2073f, 285.165f, 256.6723f, 287.066f, 289.5043f, 290.0f);
                instancePath.lineTo(290.0003f, 290.0f);
                instancePath.cubicTo(287.0333f, 257.215f, 285.1083f, 204.456f, 285.1083f, 144.945f);
                instancePath.lineTo(285.1083f, 144.945f);
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
