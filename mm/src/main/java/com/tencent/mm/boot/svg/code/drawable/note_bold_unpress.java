package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class note_bold_unpress extends c {
    private final int height = 144;
    private final int width = 144;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                instancePaint3.setColor(-855638017);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 28.8f);
                instancePath.cubicTo(0.0f, 12.894198f, 12.894198f, 0.0f, 28.8f, 0.0f);
                instancePath.lineTo(115.2f, 0.0f);
                instancePath.cubicTo(131.1058f, 0.0f, 144.0f, 12.894198f, 144.0f, 28.8f);
                instancePath.lineTo(144.0f, 115.2f);
                instancePath.cubicTo(144.0f, 131.1058f, 131.1058f, 144.0f, 115.2f, 144.0f);
                instancePath.lineTo(28.8f, 144.0f);
                instancePath.cubicTo(12.894198f, 144.0f, 0.0f, 131.1058f, 0.0f, 115.2f);
                instancePath.lineTo(0.0f, 28.8f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(55.95f, 100.0f);
                instancePath2.lineTo(55.95f, 45.325f);
                instancePath2.lineTo(71.025f, 45.325f);
                instancePath2.cubicTo(82.05f, 45.325f, 89.25f, 49.375f, 89.25f, 58.6f);
                instancePath2.cubicTo(89.25f, 64.225f, 86.325f, 68.875f, 80.85f, 70.525f);
                instancePath2.lineTo(80.85f, 70.9f);
                instancePath2.cubicTo(87.9f, 72.1f, 92.55f, 76.525f, 92.55f, 84.025f);
                instancePath2.cubicTo(92.55f, 94.6f, 84.45f, 100.0f, 72.15f, 100.0f);
                instancePath2.lineTo(55.95f, 100.0f);
                instancePath2.close();
                instancePath2.moveTo(60.45f, 69.175f);
                instancePath2.lineTo(69.6f, 69.175f);
                instancePath2.cubicTo(80.4f, 69.175f, 84.75f, 65.35f, 84.75f, 59.125f);
                instancePath2.cubicTo(84.75f, 51.7f, 79.725f, 49.0f, 70.05f, 49.0f);
                instancePath2.lineTo(60.45f, 49.0f);
                instancePath2.lineTo(60.45f, 69.175f);
                instancePath2.close();
                instancePath2.moveTo(60.45f, 96.25f);
                instancePath2.lineTo(71.1f, 96.25f);
                instancePath2.cubicTo(81.675f, 96.25f, 88.125f, 92.5f, 88.125f, 84.025f);
                instancePath2.cubicTo(88.125f, 76.375f, 81.975f, 72.775f, 71.1f, 72.775f);
                instancePath2.lineTo(60.45f, 72.775f);
                instancePath2.lineTo(60.45f, 96.25f);
                instancePath2.close();
                canvas.saveLayerAlpha(null, 230, 31);
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
