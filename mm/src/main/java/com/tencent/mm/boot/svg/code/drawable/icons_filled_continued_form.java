package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_continued_form extends c {
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
                instancePaint3.setColor(-436207616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(56.7125f, 42.025f);
                instancePath.cubicTo(64.82418f, 42.025f, 71.4f, 48.60082f, 71.4f, 56.7125f);
                instancePath.cubicTo(71.4f, 64.82418f, 64.82418f, 71.4f, 56.7125f, 71.4f);
                instancePath.cubicTo(48.60082f, 71.4f, 42.025f, 64.82418f, 42.025f, 56.7125f);
                instancePath.cubicTo(42.025f, 48.60082f, 48.60082f, 42.025f, 56.7125f, 42.025f);
                instancePath.close();
                instancePath.moveTo(56.798977f, 50.03636f);
                instancePath.cubicTo(54.374115f, 50.03636f, 52.75483f, 51.530823f, 52.640907f, 53.834778f);
                instancePath.lineTo(54.59382f, 53.834778f);
                instancePath.cubicTo(54.67519f, 52.633873f, 55.4889f, 51.85996f, 56.701332f, 51.85996f);
                instancePath.cubicTo(58.019543f, 51.85996f, 58.73561f, 52.60719f, 58.73561f, 53.72803f);
                instancePath.cubicTo(58.73561f, 54.87556f, 57.91376f, 55.68506f, 56.70947f, 55.68506f);
                instancePath.lineTo(55.29361f, 55.68506f);
                instancePath.lineTo(55.29361f, 57.410805f);
                instancePath.lineTo(56.742016f, 57.410805f);
                instancePath.cubicTo(58.198563f, 57.410805f, 59.093643f, 58.20251f, 59.093643f, 59.501266f);
                instancePath.cubicTo(59.093643f, 60.68438f, 58.1416f, 61.51167f, 56.79084f, 61.51167f);
                instancePath.cubicTo(55.391254f, 61.51167f, 54.512447f, 60.72886f, 54.4148f, 59.55464f);
                instancePath.lineTo(52.41307f, 59.55464f);
                instancePath.cubicTo(52.518852f, 61.840805f, 54.1951f, 63.388638f, 56.774567f, 63.388638f);
                instancePath.cubicTo(59.337757f, 63.388638f, 61.22557f, 61.858597f, 61.22557f, 59.59022f);
                instancePath.cubicTo(61.22557f, 57.80221f, 60.086372f, 56.62799f, 58.328754f, 56.485664f);
                instancePath.lineTo(58.328754f, 56.43229f);
                instancePath.cubicTo(59.77716f, 56.15653f, 60.753616f, 55.008995f, 60.753616f, 53.416687f);
                instancePath.cubicTo(60.753616f, 51.41518f, 59.109917f, 50.03636f, 56.798977f, 50.03636f);
                instancePath.close();
                instancePath.moveTo(36.15f, 21.4625f);
                instancePath.cubicTo(44.26168f, 21.4625f, 50.8375f, 28.038319f, 50.8375f, 36.15f);
                instancePath.cubicTo(50.8375f, 37.289238f, 50.707794f, 38.398182f, 50.46235f, 39.462868f);
                instancePath.cubicTo(45.010643f, 40.719414f, 40.719414f, 45.010643f, 39.462654f, 50.46213f);
                instancePath.cubicTo(38.398182f, 50.707794f, 37.289238f, 50.8375f, 36.15f, 50.8375f);
                instancePath.cubicTo(28.038319f, 50.8375f, 21.4625f, 44.26168f, 21.4625f, 36.15f);
                instancePath.cubicTo(21.4625f, 28.038319f, 28.038319f, 21.4625f, 36.15f, 21.4625f);
                instancePath.close();
                instancePath.moveTo(36.15f, 29.1f);
                instancePath.cubicTo(33.57682f, 29.1f, 31.74375f, 30.743738f, 31.74375f, 33.03292f);
                instancePath.lineTo(31.74375f, 33.05874f);
                instancePath.lineTo(33.826393f, 33.05874f);
                instancePath.lineTo(33.826393f, 33.024315f);
                instancePath.cubicTo(33.826393f, 31.793665f, 34.79026f, 30.881433f, 36.081154f, 30.881433f);
                instancePath.cubicTo(37.311806f, 30.881433f, 38.232643f, 31.699f, 38.232643f, 32.723106f);
                instancePath.cubicTo(38.232643f, 33.65255f, 37.845375f, 34.28939f, 36.434f, 35.726585f);
                instancePath.lineTo(31.864233f, 40.27053f);
                instancePath.lineTo(31.864233f, 41.767967f);
                instancePath.lineTo(40.590675f, 41.767967f);
                instancePath.lineTo(40.590675f, 39.95211f);
                instancePath.lineTo(34.824684f, 39.95211f);
                instancePath.lineTo(34.824684f, 39.90908f);
                instancePath.lineTo(37.89701f, 36.871178f);
                instancePath.cubicTo(39.523537f, 35.22744f, 40.401344f, 34.108665f, 40.401344f, 32.62844f);
                instancePath.cubicTo(40.401344f, 30.614649f, 38.628517f, 29.1f, 36.15f, 29.1f);
                instancePath.close();
                instancePath.moveTo(15.5875f, 0.9f);
                instancePath.cubicTo(23.699183f, 0.9f, 30.275f, 7.4758177f, 30.275f, 15.5875f);
                instancePath.cubicTo(30.275f, 16.726738f, 30.145294f, 17.83568f, 29.899847f, 18.900368f);
                instancePath.cubicTo(24.448141f, 20.156914f, 20.156914f, 24.448141f, 18.900152f, 29.899633f);
                instancePath.cubicTo(17.83568f, 30.145294f, 16.726738f, 30.275f, 15.5875f, 30.275f);
                instancePath.cubicTo(7.4758177f, 30.275f, 0.9f, 23.699183f, 0.9f, 15.5875f);
                instancePath.cubicTo(0.9f, 7.4758177f, 7.4758177f, 0.9f, 15.5875f, 0.9f);
                instancePath.close();
                instancePath.moveTo(17.501465f, 8.83125f);
                instancePath.lineTo(15.306946f, 8.83125f);
                instancePath.lineTo(12.0625f, 11.111829f);
                instancePath.lineTo(12.0625f, 13.203076f);
                instancePath.lineTo(15.272522f, 10.948316f);
                instancePath.lineTo(15.324158f, 10.948316f);
                instancePath.lineTo(15.324158f, 21.249645f);
                instancePath.lineTo(17.501465f, 21.249645f);
                instancePath.lineTo(17.501465f, 8.83125f);
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
