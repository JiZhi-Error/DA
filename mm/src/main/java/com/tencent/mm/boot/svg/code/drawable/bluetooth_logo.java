package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bluetooth_logo extends c {
    private final int height = 242;
    private final int width = 245;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 245;
            case 1:
                return 242;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-3552823);
                instancePaint4.setStrokeWidth(4.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(123.0f, 7.0f);
                instancePath.cubicTo(185.96046f, 7.0f, 237.0f, 58.039536f, 237.0f, 121.0f);
                instancePath.cubicTo(237.0f, 183.96046f, 185.96046f, 235.0f, 123.0f, 235.0f);
                instancePath.cubicTo(60.039536f, 235.0f, 9.0f, 183.96046f, 9.0f, 121.0f);
                instancePath.cubicTo(9.0f, 58.039536f, 60.039536f, 7.0f, 123.0f, 7.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-3552823);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(117.133484f, 111.829056f);
                instancePath2.lineTo(94.750854f, 89.44642f);
                instancePath2.lineTo(94.750854f, 100.31056f);
                instancePath2.lineTo(116.18076f, 121.74048f);
                instancePath2.lineTo(94.750854f, 143.17038f);
                instancePath2.lineTo(94.750854f, 154.18599f);
                instancePath2.lineTo(117.133484f, 131.80336f);
                instancePath2.lineTo(117.133484f, 165.4863f);
                instancePath2.lineTo(116.812836f, 165.80695f);
                instancePath2.lineTo(117.133484f, 165.80695f);
                instancePath2.lineTo(117.133484f, 176.5019f);
                instancePath2.lineTo(149.46358f, 144.17183f);
                instancePath2.lineTo(148.58734f, 143.2956f);
                instancePath2.lineTo(148.59369f, 143.28926f);
                instancePath2.lineTo(127.12064f, 121.81621f);
                instancePath2.lineTo(148.28012f, 100.65672f);
                instancePath2.lineTo(148.23923f, 100.61583f);
                instancePath2.lineTo(150.24332f, 98.61174f);
                instancePath2.lineTo(117.133484f, 65.501915f);
                instancePath2.lineTo(117.133484f, 75.7257f);
                instancePath2.lineTo(117.133484f, 111.829056f);
                instancePath2.close();
                instancePath2.moveTo(124.9227f, 112.99854f);
                instancePath2.lineTo(139.2686f, 98.65264f);
                instancePath2.lineTo(124.9227f, 84.30673f);
                instancePath2.lineTo(124.9227f, 112.99854f);
                instancePath2.close();
                instancePath2.moveTo(124.9227f, 157.6971f);
                instancePath2.lineTo(138.53004f, 144.08975f);
                instancePath2.lineTo(124.9227f, 130.4824f);
                instancePath2.lineTo(124.9227f, 157.6971f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
