package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class media_preview_btn_close extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(Integer.MIN_VALUE);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 9.6f);
                instancePath.cubicTo(0.0f, 4.298066f, 4.298066f, 0.0f, 9.6f, 0.0f);
                instancePath.lineTo(86.4f, 0.0f);
                instancePath.cubicTo(91.701935f, 0.0f, 96.0f, 4.298066f, 96.0f, 9.6f);
                instancePath.lineTo(96.0f, 86.4f);
                instancePath.cubicTo(96.0f, 91.701935f, 91.701935f, 96.0f, 86.4f, 96.0f);
                instancePath.lineTo(9.6f, 96.0f);
                instancePath.cubicTo(4.298066f, 96.0f, 0.0f, 91.701935f, 0.0f, 86.4f);
                instancePath.lineTo(0.0f, 9.6f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(48.0f, 45.001343f);
                instancePath2.lineTo(30.427227f, 27.428572f);
                instancePath2.lineTo(27.428572f, 30.427227f);
                instancePath2.lineTo(45.001343f, 48.0f);
                instancePath2.lineTo(27.428572f, 65.57277f);
                instancePath2.lineTo(30.427227f, 68.57143f);
                instancePath2.lineTo(48.0f, 50.998657f);
                instancePath2.lineTo(65.57277f, 68.57143f);
                instancePath2.lineTo(68.57143f, 65.57277f);
                instancePath2.lineTo(50.998657f, 48.0f);
                instancePath2.lineTo(68.57143f, 30.427227f);
                instancePath2.lineTo(65.57277f, 27.428572f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
