package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class mass_send_icon extends c {
    private final int height = 480;
    private final int width = 480;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 480;
            case 1:
                return 480;
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
                instancePaint3.setColor(-12206054);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(172.1131f, 158.48434f);
                instancePath.cubicTo(170.05316f, 158.1662f, 167.92174f, 158.0f, 165.72351f, 158.0f);
                instancePath.cubicTo(140.01566f, 158.0f, 123.447014f, 180.72963f, 123.447014f, 203.41473f);
                instancePath.cubicTo(123.447014f, 225.27332f, 130.86368f, 230.84035f, 139.55563f, 243.80075f);
                instancePath.cubicTo(151.07164f, 260.9691f, 133.30182f, 268.42276f, 124.72742f, 273.15573f);
                instancePath.cubicTo(93.9516f, 290.1507f, 80.0f, 296.73767f, 80.0f, 305.5781f);
                instancePath.lineTo(80.0f, 316.63174f);
                instancePath.cubicTo(80.0f, 320.7442f, 82.90328f, 324.0f, 87.454994f, 324.0f);
                instancePath.lineTo(106.0f, 324.0f);
                instancePath.lineTo(106.0f, 313.84015f);
                instancePath.cubicTo(106.0f, 303.6577f, 139.99591f, 281.85004f, 175.02455f, 261.5621f);
                instancePath.cubicTo(180.41614f, 258.4394f, 185.67838f, 257.80884f, 188.21204f, 255.71149f);
                instancePath.cubicTo(187.972f, 253.70976f, 188.22223f, 251.50589f, 189.12248f, 249.07043f);
                instancePath.cubicTo(188.03903f, 245.9484f, 185.5458f, 241.54929f, 181.16434f, 235.14435f);
                instancePath.cubicTo(168.40218f, 216.4851f, 167.3978f, 205.0813f, 167.39778f, 191.28004f);
                instancePath.cubicTo(167.39778f, 184.88632f, 167.8619f, 171.26468f, 172.1131f, 158.48434f);
                instancePath.lineTo(172.1131f, 158.48434f);
                instancePath.close();
                instancePath.moveTo(307.8869f, 158.48434f);
                instancePath.cubicTo(309.94684f, 158.1662f, 312.07825f, 158.0f, 314.2765f, 158.0f);
                instancePath.cubicTo(339.98434f, 158.0f, 356.55298f, 180.72963f, 356.55298f, 203.41473f);
                instancePath.cubicTo(356.55298f, 225.27332f, 349.13632f, 230.84035f, 340.44437f, 243.80075f);
                instancePath.cubicTo(328.92834f, 260.9691f, 346.69818f, 268.42276f, 355.27258f, 273.15573f);
                instancePath.cubicTo(386.0484f, 290.1507f, 400.0f, 296.73767f, 400.0f, 305.5781f);
                instancePath.lineTo(400.0f, 316.63174f);
                instancePath.cubicTo(400.0f, 320.7442f, 397.0967f, 324.0f, 392.545f, 324.0f);
                instancePath.lineTo(374.0f, 324.0f);
                instancePath.lineTo(374.0f, 313.84015f);
                instancePath.cubicTo(374.0f, 303.6577f, 340.0041f, 281.85004f, 304.97543f, 261.5621f);
                instancePath.cubicTo(299.58386f, 258.4394f, 294.32162f, 257.80884f, 291.78796f, 255.71149f);
                instancePath.cubicTo(292.028f, 253.70976f, 291.77777f, 251.50589f, 290.8775f, 249.07043f);
                instancePath.cubicTo(291.96097f, 245.9484f, 294.4542f, 241.54929f, 298.83566f, 235.14435f);
                instancePath.cubicTo(311.59784f, 216.4851f, 312.6022f, 205.0813f, 312.6022f, 191.28004f);
                instancePath.cubicTo(312.6022f, 184.88632f, 312.13812f, 171.26468f, 307.8869f, 158.48434f);
                instancePath.lineTo(307.8869f, 158.48434f);
                instancePath.close();
                instancePath.moveTo(281.31888f, 388.0f);
                instancePath.lineTo(444.008f, 388.0f);
                instancePath.cubicTo(455.05103f, 388.0f, 464.0f, 379.04703f, 464.0f, 368.00302f);
                instancePath.lineTo(464.0f, 97.996994f);
                instancePath.cubicTo(464.0f, 86.9641f, 455.04926f, 78.0f, 444.008f, 78.0f);
                instancePath.lineTo(35.992016f, 78.0f);
                instancePath.cubicTo(24.948969f, 78.0f, 16.0f, 86.95296f, 16.0f, 97.996994f);
                instancePath.lineTo(16.0f, 368.00302f);
                instancePath.cubicTo(16.0f, 379.0359f, 24.950731f, 388.0f, 35.992016f, 388.0f);
                instancePath.lineTo(196.66887f, 388.0f);
                instancePath.cubicTo(199.28546f, 390.60144f, 232.7567f, 422.68564f, 234.85847f, 424.65842f);
                instancePath.cubicTo(236.74309f, 426.43124f, 241.24739f, 426.46307f, 243.132f, 424.65842f);
                instancePath.cubicTo(246.00592f, 421.9054f, 279.603f, 389.66174f, 281.26654f, 388.0517f);
                instancePath.cubicTo(281.28433f, 388.03445f, 281.30176f, 388.01724f, 281.31885f, 388.0f);
                instancePath.lineTo(281.31888f, 388.0f);
                instancePath.close();
                instancePath.moveTo(185.27148f, 181.28253f);
                instancePath.cubicTo(185.27148f, 210.77846f, 195.04807f, 218.29059f, 206.50572f, 235.77933f);
                instancePath.cubicTo(221.68604f, 258.94623f, 198.26201f, 269.00418f, 186.9593f, 275.39087f);
                instancePath.cubicTo(146.39088f, 298.32385f, 128.0f, 307.21228f, 128.0f, 319.1415f);
                instancePath.lineTo(128.0f, 334.05728f);
                instancePath.cubicTo(128.0f, 339.60663f, 131.82709f, 344.0f, 137.82712f, 344.0f);
                instancePath.lineTo(344.17288f, 344.0f);
                instancePath.cubicTo(350.1729f, 344.0f, 354.0f, 339.60663f, 354.0f, 334.05728f);
                instancePath.lineTo(354.0f, 319.1415f);
                instancePath.cubicTo(354.0f, 307.21228f, 335.60913f, 298.32385f, 295.04068f, 275.39087f);
                instancePath.cubicTo(283.738f, 269.00418f, 260.31396f, 258.94623f, 275.49426f, 235.77933f);
                instancePath.cubicTo(286.95193f, 218.29059f, 296.72852f, 210.77846f, 296.72852f, 181.28253f);
                instancePath.cubicTo(296.72852f, 150.67131f, 274.88788f, 120.0f, 241.0f, 120.0f);
                instancePath.cubicTo(207.11212f, 120.0f, 185.27148f, 150.67131f, 185.27148f, 181.28253f);
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
