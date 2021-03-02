package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_icons_filled_share extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-2565928);
                instancePaint5.setColor(-6842473);
                instancePaint5.setStrokeWidth(3.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.5f, 1.5f);
                instancePath.lineTo(70.5f, 1.5f);
                instancePath.lineTo(70.5f, 70.5f);
                instancePath.lineTo(1.5f, 70.5f);
                instancePath.lineTo(1.5f, 1.5f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                Paint instancePaint9 = c.instancePaint(instancePaint3, looper);
                instancePaint8.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint9.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint9.setStrokeWidth(3.6f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(43.5f, 12.006086f);
                instancePath2.cubicTo(43.897823f, 12.006086f, 44.279354f, 12.164122f, 44.56066f, 12.445426f);
                instancePath2.lineTo(60.87868f, 28.763445f);
                instancePath2.cubicTo(62.05025f, 29.935019f, 62.05025f, 31.834513f, 60.87868f, 33.006084f);
                instancePath2.lineTo(44.56066f, 49.324104f);
                instancePath2.cubicTo(43.974873f, 49.909893f, 43.025127f, 49.909893f, 42.43934f, 49.324104f);
                instancePath2.cubicTo(42.158035f, 49.0428f, 42.0f, 48.66127f, 42.0f, 48.263447f);
                instancePath2.lineTo(41.999756f, 36.6111f);
                instancePath2.cubicTo(18.210701f, 36.019882f, 13.14624f, 63.715797f, 13.14624f, 60.714478f);
                instancePath2.cubicTo(11.452737f, 41.605106f, 20.863182f, 24.122755f, 41.999332f, 22.901964f);
                instancePath2.lineTo(42.0f, 13.506086f);
                instancePath2.cubicTo(42.0f, 12.677659f, 42.671574f, 12.006086f, 43.5f, 12.006086f);
                instancePath2.close();
                canvas.saveLayerAlpha(null, 230, 31);
                Paint instancePaint10 = c.instancePaint(instancePaint8, looper);
                Paint instancePaint11 = c.instancePaint(instancePaint9, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint10);
                canvas.drawPath(instancePath2, instancePaint11);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
