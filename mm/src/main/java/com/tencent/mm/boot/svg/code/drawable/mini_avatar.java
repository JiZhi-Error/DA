package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class mini_avatar extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                instancePaint3.setColor(-921103);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(120.0f, 0.0f);
                instancePath.lineTo(120.0f, 120.0f);
                instancePath.lineTo(0.0f, 120.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-3552823);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(50.865784f, 61.30489f);
                instancePath2.cubicTo(54.72159f, 67.43002f, 48.319912f, 70.20336f, 45.64623f, 71.743996f);
                instancePath2.cubicTo(34.143787f, 78.28783f, 29.117647f, 80.738686f, 29.117647f, 83.92295f);
                instancePath2.lineTo(29.117647f, 88.272575f);
                instancePath2.cubicTo(29.117647f, 89.670944f, 30.16357f, 90.882355f, 31.727423f, 90.882355f);
                instancePath2.lineTo(88.272575f, 90.882355f);
                instancePath2.cubicTo(89.83643f, 90.882355f, 90.882355f, 89.670944f, 90.882355f, 88.272575f);
                instancePath2.lineTo(90.882355f, 83.92295f);
                instancePath2.cubicTo(90.882355f, 80.738686f, 85.85622f, 78.28783f, 74.35377f, 71.743996f);
                instancePath2.cubicTo(71.680084f, 70.20336f, 65.27841f, 67.43002f, 69.13422f, 61.30489f);
                instancePath2.cubicTo(72.55844f, 56.21983f, 75.23033f, 54.14847f, 75.223694f, 45.64623f);
                instancePath2.cubicTo(75.23033f, 37.574806f, 69.26139f, 29.117647f, 60.434963f, 29.117647f);
                instancePath2.cubicTo(50.73861f, 29.117647f, 44.769665f, 37.574806f, 44.776306f, 45.64623f);
                instancePath2.cubicTo(44.769665f, 54.14847f, 47.44156f, 56.21983f, 50.865784f, 61.30489f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
