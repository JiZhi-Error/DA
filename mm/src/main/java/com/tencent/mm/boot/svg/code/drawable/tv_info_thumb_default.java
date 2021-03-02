package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class tv_info_thumb_default extends c {
    private final int height = 708;
    private final int width = 1080;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 1080;
            case 1:
                return 708;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix instanceMatrix = c.instanceMatrix(looper);
                float[] instanceMatrixArray = c.instanceMatrixArray(looper);
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
                instancePaint3.setColor(-14605789);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(1080.0f, 0.0f);
                instancePath.lineTo(1080.0f, 708.0f);
                instancePath.lineTo(0.0f, 708.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(410.18f, 230.15f);
                instancePath2.cubicTo(483.76f, 229.8f, 557.36f, 230.09f, 630.96f, 230.0f);
                instancePath2.cubicTo(644.24f, 230.16f, 657.54f, 229.7f, 670.82f, 230.18f);
                instancePath2.cubicTo(671.31f, 246.78f, 670.84f, 263.41f, 671.0f, 280.02f);
                instancePath2.cubicTo(670.91f, 315.05f, 671.17f, 350.09f, 670.87f, 385.11f);
                instancePath2.cubicTo(660.31f, 369.45f, 649.44f, 353.21f, 633.51f, 342.49f);
                instancePath2.cubicTo(626.91f, 338.22f, 618.8f, 334.49f, 610.82f, 336.71f);
                instancePath2.cubicTo(603.4f, 338.93f, 596.76f, 343.09f, 590.39f, 347.37f);
                instancePath2.cubicTo(587.12f, 349.67f, 583.59f, 351.71f, 581.01f, 354.83f);
                instancePath2.cubicTo(586.59f, 369.83f, 595.3f, 383.45f, 604.4f, 396.54f);
                instancePath2.cubicTo(605.84f, 398.61f, 607.12f, 400.79f, 608.3f, 403.03f);
                instancePath2.cubicTo(601.1f, 399.05f, 595.97f, 392.43f, 590.32f, 386.64f);
                instancePath2.cubicTo(584.73f, 379.94f, 578.85f, 373.49f, 573.34f, 366.74f);
                instancePath2.cubicTo(562.19f, 351.1f, 551.18f, 335.14f, 537.27f, 321.76f);
                instancePath2.cubicTo(528.85f, 313.74f, 519.15f, 306.5f, 507.83f, 303.25f);
                instancePath2.cubicTo(497.41f, 300.29f, 486.3f, 303.05f, 476.95f, 308.0f);
                instancePath2.cubicTo(463.78f, 314.86f, 452.48f, 324.71f, 441.81f, 334.93f);
                instancePath2.cubicTo(433.55f, 343.68f, 425.38f, 352.55f, 418.1f, 362.16f);
                instancePath2.cubicTo(415.51f, 365.54f, 413.06f, 369.06f, 410.2f, 372.23f);
                instancePath2.cubicTo(409.72f, 350.15f, 410.15f, 328.04f, 410.0f, 305.95f);
                instancePath2.cubicTo(410.13f, 280.68f, 409.74f, 255.4f, 410.18f, 230.15f);
                instancePath2.lineTo(410.18f, 230.15f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-13947602);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 379.0f, 0.0f, 1.0f, 199.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint6, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(8.33f, 1.44f);
                instancePath3.cubicTo(9.51f, 1.18f, 10.71f, 1.03f, 11.93f, 1.0f);
                instancePath3.cubicTo(108.28f, 0.99f, 204.63f, 1.01f, 300.98f, 0.99f);
                instancePath3.cubicTo(305.77f, 1.08f, 310.67f, 0.48f, 315.36f, 1.66f);
                instancePath3.cubicTo(319.74f, 2.95f, 322.2f, 7.57f, 322.0f, 11.95f);
                instancePath3.cubicTo(322.02f, 90.97f, 321.96f, 170.01f, 322.03f, 249.03f);
                instancePath3.cubicTo(321.98f, 252.01f, 321.71f, 255.3f, 319.55f, 257.58f);
                instancePath3.cubicTo(317.47f, 260.09f, 314.14f, 260.99f, 311.0f, 260.99f);
                instancePath3.cubicTo(213.68f, 261.03f, 116.35f, 260.95f, 19.03f, 261.03f);
                instancePath3.cubicTo(14.16f, 260.82f, 8.46f, 261.99f, 4.42f, 258.56f);
                instancePath3.cubicTo(1.57f, 256.28f, 0.96f, 252.44f, 0.98f, 249.0f);
                instancePath3.cubicTo(1.01f, 169.99f, 1.0f, 90.98f, 1.0f, 11.98f);
                instancePath3.cubicTo(0.74f, 7.33f, 3.6f, 2.48f, 8.33f, 1.44f);
                instancePath3.lineTo(8.33f, 1.44f);
                instancePath3.close();
                instancePath3.moveTo(31.18f, 31.15f);
                instancePath3.cubicTo(30.74f, 56.4f, 31.13f, 81.68f, 31.0f, 106.95f);
                instancePath3.cubicTo(31.15f, 129.04f, 30.72f, 151.15f, 31.2f, 173.23f);
                instancePath3.cubicTo(34.06f, 170.06f, 36.51f, 166.54f, 39.1f, 163.16f);
                instancePath3.cubicTo(46.38f, 153.55f, 54.55f, 144.68f, 62.81f, 135.93f);
                instancePath3.cubicTo(73.48f, 125.71f, 84.78f, 115.86f, 97.95f, 109.0f);
                instancePath3.cubicTo(107.3f, 104.05f, 118.41f, 101.29f, 128.83f, 104.25f);
                instancePath3.cubicTo(140.15f, 107.5f, 149.85f, 114.74f, 158.27f, 122.76f);
                instancePath3.cubicTo(172.18f, 136.14f, 183.19f, 152.1f, 194.34f, 167.74f);
                instancePath3.cubicTo(199.85f, 174.49f, 205.73f, 180.94f, 211.32f, 187.64f);
                instancePath3.cubicTo(216.97f, 193.43f, 222.1f, 200.05f, 229.3f, 204.03f);
                instancePath3.cubicTo(228.12f, 201.79f, 226.84f, 199.61f, 225.4f, 197.54f);
                instancePath3.cubicTo(216.3f, 184.45f, 207.59f, 170.83f, 202.01f, 155.83f);
                instancePath3.cubicTo(204.59f, 152.71f, 208.12f, 150.67f, 211.39f, 148.37f);
                instancePath3.cubicTo(217.76f, 144.09f, 224.4f, 139.93f, 231.82f, 137.71f);
                instancePath3.cubicTo(239.8f, 135.49f, 247.91f, 139.22f, 254.51f, 143.49f);
                instancePath3.cubicTo(270.44f, 154.21f, 281.31f, 170.45f, 291.87f, 186.11f);
                instancePath3.cubicTo(292.17f, 151.09f, 291.91f, 116.05f, 292.0f, 81.02f);
                instancePath3.cubicTo(291.84f, 64.41f, 292.31f, 47.78f, 291.82f, 31.18f);
                instancePath3.cubicTo(278.54f, 30.7f, 265.24f, 31.16f, 251.96f, 31.0f);
                instancePath3.cubicTo(178.36f, 31.09f, 104.76f, 30.8f, 31.18f, 31.15f);
                instancePath3.lineTo(31.18f, 31.15f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
