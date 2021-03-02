package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_game extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(9.891169f, 34.2f);
                instancePath.lineTo(23.5276f, 34.2f);
                instancePath.cubicTo(24.316923f, 28.681755f, 28.681755f, 24.316923f, 34.2f, 23.5276f);
                instancePath.lineTo(34.2f, 9.891169f);
                instancePath.lineTo(9.891169f, 34.2f);
                instancePath.close();
                instancePath.moveTo(37.8f, 9.891169f);
                instancePath.lineTo(37.8f, 23.5276f);
                instancePath.cubicTo(43.318245f, 24.316923f, 47.68308f, 28.681755f, 48.4724f, 34.2f);
                instancePath.lineTo(62.10883f, 34.2f);
                instancePath.lineTo(37.8f, 9.891169f);
                instancePath.close();
                instancePath.moveTo(62.10883f, 37.8f);
                instancePath.lineTo(48.4724f, 37.8f);
                instancePath.cubicTo(47.68308f, 43.318245f, 43.318245f, 47.68308f, 37.8f, 48.4724f);
                instancePath.lineTo(37.8f, 62.10883f);
                instancePath.lineTo(62.10883f, 37.8f);
                instancePath.close();
                instancePath.moveTo(34.2f, 62.10883f);
                instancePath.lineTo(34.2f, 48.4724f);
                instancePath.cubicTo(28.681755f, 47.68308f, 24.316923f, 43.318245f, 23.5276f, 37.8f);
                instancePath.lineTo(9.891169f, 37.8f);
                instancePath.lineTo(34.2f, 62.10883f);
                instancePath.close();
                instancePath.moveTo(31.753386f, 7.2466154f);
                instancePath.cubicTo(34.098724f, 4.901274f, 37.91686f, 4.9168572f, 40.246616f, 7.2466154f);
                instancePath.lineTo(64.75339f, 31.753386f);
                instancePath.cubicTo(67.098724f, 34.098724f, 67.083145f, 37.91686f, 64.75339f, 40.246616f);
                instancePath.lineTo(40.246616f, 64.75339f);
                instancePath.cubicTo(37.901276f, 67.098724f, 34.08314f, 67.083145f, 31.753386f, 64.75339f);
                instancePath.lineTo(7.2466154f, 40.246616f);
                instancePath.cubicTo(4.901274f, 37.901276f, 4.9168572f, 34.08314f, 7.2466154f, 31.753386f);
                instancePath.lineTo(31.753386f, 7.2466154f);
                instancePath.close();
                instancePath.moveTo(36.0f, 45.0f);
                instancePath.cubicTo(40.970562f, 45.0f, 45.0f, 40.970562f, 45.0f, 36.0f);
                instancePath.cubicTo(45.0f, 31.029438f, 40.970562f, 27.0f, 36.0f, 27.0f);
                instancePath.cubicTo(31.029438f, 27.0f, 27.0f, 31.029438f, 27.0f, 36.0f);
                instancePath.cubicTo(27.0f, 40.970562f, 31.029438f, 45.0f, 36.0f, 45.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
