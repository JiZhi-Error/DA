package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class voip_voice_mini_window_icon extends c {
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
                instancePaint3.setColor(-16139513);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(25.802883f, 46.304134f);
                instancePath.cubicTo(32.66371f, 53.164963f, 39.164425f, 56.38293f, 41.568413f, 56.19449f);
                instancePath.cubicTo(43.972404f, 56.006046f, 49.959015f, 51.88904f, 52.785183f, 51.94384f);
                instancePath.cubicTo(54.143463f, 51.970177f, 63.019405f, 57.972977f, 64.09384f, 58.667f);
                instancePath.cubicTo(65.168274f, 59.361023f, 66.16451f, 60.171726f, 65.97718f, 61.197594f);
                instancePath.cubicTo(65.789856f, 62.22346f, 61.88898f, 73.52336f, 51.930058f, 71.95859f);
                instancePath.cubicTo(41.97113f, 70.39381f, 28.086994f, 59.657917f, 20.175474f, 51.931545f);
                instancePath.lineTo(25.802883f, 46.304134f);
                instancePath.lineTo(25.802883f, 46.304134f);
                instancePath.close();
                instancePath.moveTo(25.802883f, 46.304134f);
                instancePath.cubicTo(18.942055f, 39.443306f, 15.724086f, 32.942593f, 15.91253f, 30.538603f);
                instancePath.cubicTo(16.100973f, 28.134613f, 20.217976f, 22.148005f, 20.163176f, 19.321836f);
                instancePath.cubicTo(20.13684f, 17.963554f, 14.13404f, 9.087612f, 13.440018f, 8.01318f);
                instancePath.cubicTo(12.7459955f, 6.938746f, 11.935291f, 5.9425087f, 10.909425f, 6.129835f);
                instancePath.cubicTo(9.883557f, 6.317161f, -1.4163445f, 10.218036f, 0.14843264f, 20.176962f);
                instancePath.cubicTo(1.7132099f, 30.13589f, 12.449101f, 44.020023f, 20.175474f, 51.931545f);
                instancePath.lineTo(25.802883f, 46.304134f);
                instancePath.close();
                instancePath.moveTo(71.95439f, 37.577858f);
                instancePath.cubicTo(72.06316f, 27.928717f, 68.43634f, 18.245283f, 61.07391f, 10.8828535f);
                instancePath.cubicTo(53.78275f, 3.591691f, 44.215294f, -0.035837848f, 34.659115f, 2.668559E-4f);
                instancePath.lineTo(34.659115f, 2.668559E-4f);
                instancePath.lineTo(34.659115f, 6.1705666f);
                instancePath.cubicTo(42.622982f, 6.140183f, 50.596336f, 9.163122f, 56.672596f, 15.239385f);
                instancePath.cubicTo(62.831516f, 21.398304f, 65.85348f, 29.506277f, 65.73848f, 37.577858f);
                instancePath.lineTo(71.95439f, 37.577858f);
                instancePath.close();
                instancePath.moveTo(56.445175f, 37.661373f);
                instancePath.cubicTo(56.561077f, 31.967367f, 54.446472f, 26.236395f, 50.10136f, 21.891281f);
                instancePath.cubicTo(45.83891f, 17.628828f, 40.24282f, 15.512826f, 34.65626f, 15.543274f);
                instancePath.lineTo(34.65626f, 15.543274f);
                instancePath.lineTo(34.65626f, 21.736135f);
                instancePath.cubicTo(38.657936f, 21.7056f, 42.669193f, 23.216957f, 45.72244f, 26.270203f);
                instancePath.cubicTo(48.858353f, 29.406116f, 50.367752f, 33.552616f, 50.250637f, 37.661373f);
                instancePath.lineTo(56.445175f, 37.661373f);
                instancePath.lineTo(56.445175f, 37.661373f);
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
