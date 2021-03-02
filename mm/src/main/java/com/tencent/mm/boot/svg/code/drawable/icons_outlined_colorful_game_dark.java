package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_colorful_game_dark extends c {
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
                instancePaint3.setColor(-15624449);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(62.108814f, 34.19998f);
                instancePath.lineTo(37.8f, 9.891169f);
                instancePath.lineTo(37.8f, 23.5276f);
                instancePath.cubicTo(43.318237f, 24.316921f, 47.683064f, 28.681744f, 48.472397f, 34.19998f);
                instancePath.lineTo(44.819965f, 34.19998f);
                instancePath.cubicTo(43.98607f, 30.091959f, 40.35412f, 27.0f, 36.0f, 27.0f);
                instancePath.cubicTo(35.38356f, 27.0f, 34.781597f, 27.061974f, 34.2f, 27.180033f);
                instancePath.lineTo(34.2f, 5.7663255f);
                instancePath.cubicTo(36.269375f, 5.1218004f, 38.62053f, 5.620529f, 40.246616f, 7.2466154f);
                instancePath.lineTo(64.75339f, 31.753386f);
                instancePath.cubicTo(65.46176f, 32.461758f, 65.95476f, 33.304485f, 66.23367f, 34.19998f);
                instancePath.lineTo(62.108814f, 34.19998f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-16339370);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(37.80002f, 62.108814f);
                instancePath2.lineTo(62.10883f, 37.8f);
                instancePath2.lineTo(48.4724f, 37.8f);
                instancePath2.cubicTo(47.68308f, 43.318237f, 43.318256f, 47.683064f, 37.80002f, 48.472397f);
                instancePath2.lineTo(37.80002f, 44.819965f);
                instancePath2.cubicTo(41.908043f, 43.98607f, 45.0f, 40.35412f, 45.0f, 36.0f);
                instancePath2.cubicTo(45.0f, 35.38356f, 44.938026f, 34.781597f, 44.819965f, 34.2f);
                instancePath2.lineTo(66.23367f, 34.2f);
                instancePath2.cubicTo(66.8782f, 36.269375f, 66.37947f, 38.62053f, 64.75339f, 40.246616f);
                instancePath2.lineTo(40.246616f, 64.75339f);
                instancePath2.cubicTo(39.538242f, 65.46176f, 38.695515f, 65.95476f, 37.80002f, 66.23367f);
                instancePath2.lineTo(37.80002f, 62.108814f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-2012855);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(9.891187f, 37.80002f);
                instancePath3.lineTo(34.2f, 62.10883f);
                instancePath3.lineTo(34.2f, 48.4724f);
                instancePath3.cubicTo(28.681765f, 47.68308f, 24.316935f, 43.318256f, 23.527603f, 37.80002f);
                instancePath3.lineTo(27.180037f, 37.80002f);
                instancePath3.cubicTo(28.01393f, 41.908043f, 31.645882f, 45.0f, 36.0f, 45.0f);
                instancePath3.cubicTo(36.61644f, 45.0f, 37.218403f, 44.938026f, 37.8f, 44.819965f);
                instancePath3.lineTo(37.8f, 66.23367f);
                instancePath3.cubicTo(35.730625f, 66.8782f, 33.37947f, 66.37947f, 31.753386f, 64.75339f);
                instancePath3.lineTo(7.2466154f, 40.246616f);
                instancePath3.cubicTo(6.5382414f, 39.538242f, 6.045243f, 38.695515f, 5.7663307f, 37.80002f);
                instancePath3.lineTo(9.891187f, 37.80002f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-3367936);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(34.19998f, 9.891187f);
                instancePath4.lineTo(9.891169f, 34.2f);
                instancePath4.lineTo(23.5276f, 34.2f);
                instancePath4.cubicTo(24.316921f, 28.681765f, 28.681744f, 24.316935f, 34.19998f, 23.527603f);
                instancePath4.lineTo(34.19998f, 27.180037f);
                instancePath4.cubicTo(30.091959f, 28.01393f, 27.0f, 31.645882f, 27.0f, 36.0f);
                instancePath4.cubicTo(27.0f, 36.61644f, 27.061974f, 37.218403f, 27.180033f, 37.8f);
                instancePath4.lineTo(5.7663255f, 37.8f);
                instancePath4.cubicTo(5.1218004f, 35.730625f, 5.620529f, 33.37947f, 7.2466154f, 31.753386f);
                instancePath4.lineTo(31.753386f, 7.2466154f);
                instancePath4.cubicTo(32.461758f, 6.5382414f, 33.304485f, 6.045243f, 34.19998f, 5.7663307f);
                instancePath4.lineTo(34.19998f, 9.891187f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
