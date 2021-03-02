package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class find_more_friend_near_icon extends c {
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
                instancePath.moveTo(39.5f, 40.0f);
                instancePath.cubicTo(44.194f, 40.0f, 48.0f, 36.194f, 48.0f, 31.5f);
                instancePath.cubicTo(48.0f, 26.806f, 44.194f, 23.0f, 39.5f, 23.0f);
                instancePath.cubicTo(34.805f, 23.0f, 31.0f, 26.806f, 31.0f, 31.5f);
                instancePath.cubicTo(31.0f, 36.194f, 34.805f, 40.0f, 39.5f, 40.0f);
                instancePath.lineTo(39.5f, 40.0f);
                instancePath.close();
                instancePath.moveTo(69.5f, 40.0f);
                instancePath.cubicTo(74.194f, 40.0f, 78.0f, 36.194f, 78.0f, 31.5f);
                instancePath.cubicTo(78.0f, 26.806f, 74.194f, 23.0f, 69.5f, 23.0f);
                instancePath.cubicTo(64.805f, 23.0f, 61.0f, 26.806f, 61.0f, 31.5f);
                instancePath.cubicTo(61.0f, 36.194f, 64.804f, 40.0f, 69.5f, 40.0f);
                instancePath.lineTo(69.5f, 40.0f);
                instancePath.close();
                instancePath.moveTo(85.0f, 52.0f);
                instancePath.cubicTo(85.553f, 52.0f, 86.023f, 51.805f, 86.414f, 51.414f);
                instancePath.cubicTo(86.805f, 51.023f, 87.0f, 50.553f, 87.0f, 50.0f);
                instancePath.lineTo(87.0f, 46.0f);
                instancePath.cubicTo(87.0f, 44.896f, 86.104f, 44.0f, 85.0f, 44.0f);
                instancePath.lineTo(24.0f, 44.0f);
                instancePath.cubicTo(23.448f, 44.0f, 22.977f, 44.195f, 22.586f, 44.586f);
                instancePath.cubicTo(22.195f, 44.977f, 22.0f, 45.448f, 22.0f, 46.0f);
                instancePath.lineTo(22.0f, 50.0f);
                instancePath.cubicTo(22.0f, 51.105f, 22.896f, 52.0f, 24.0f, 52.0f);
                instancePath.lineTo(36.0f, 52.0f);
                instancePath.lineTo(36.0f, 56.44f);
                instancePath.lineTo(22.527f, 81.087f);
                instancePath.cubicTo(22.0f, 82.052f, 22.338f, 83.251f, 23.292f, 83.805f);
                instancePath.lineTo(26.459f, 85.644f);
                instancePath.cubicTo(26.956f, 85.931f, 27.486f, 85.999f, 28.042f, 85.845f);
                instancePath.cubicTo(28.597f, 85.692f, 29.015f, 85.363f, 29.289f, 84.859f);
                instancePath.lineTo(40.101f, 65.079f);
                instancePath.lineTo(49.644f, 80.687f);
                instancePath.lineTo(49.583f, 80.786f);
                instancePath.lineTo(50.122f, 81.469f);
                instancePath.lineTo(52.028f, 84.587f);
                instancePath.cubicTo(52.35f, 85.114f, 52.948f, 85.607f, 53.578f, 85.848f);
                instancePath.lineTo(53.583f, 85.854f);
                instancePath.cubicTo(54.538f, 86.416f, 55.979f, 85.542f, 56.553f, 84.59f);
                instancePath.lineTo(58.269f, 81.745f);
                instancePath.lineTo(58.999f, 80.832f);
                instancePath.lineTo(58.908f, 80.686f);
                instancePath.lineTo(68.624f, 64.578f);
                instancePath.lineTo(79.709f, 84.858f);
                instancePath.cubicTo(79.983f, 85.362f, 80.401f, 85.691f, 80.957f, 85.844f);
                instancePath.cubicTo(81.512f, 85.998f, 82.042f, 85.93f, 82.539f, 85.643f);
                instancePath.lineTo(85.707f, 83.804f);
                instancePath.cubicTo(86.661f, 83.25f, 86.999f, 82.051f, 86.472f, 81.086f);
                instancePath.lineTo(72.999f, 56.438f);
                instancePath.lineTo(72.999f, 51.999f);
                instancePath.lineTo(85.0f, 51.999f);
                instancePath.lineTo(85.0f, 52.0f);
                instancePath.close();
                instancePath.moveTo(65.0f, 55.679f);
                instancePath.lineTo(54.246f, 73.195f);
                instancePath.lineTo(44.0f, 56.734f);
                instancePath.lineTo(44.0f, 52.0f);
                instancePath.lineTo(65.0f, 52.0f);
                instancePath.lineTo(65.0f, 55.679f);
                instancePath.lineTo(65.0f, 55.679f);
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
