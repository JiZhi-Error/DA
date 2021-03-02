package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_shop extends c {
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
                instancePath.moveTo(24.0f, 21.0f);
                instancePath.lineTo(24.0f, 18.0f);
                instancePath.cubicTo(24.0f, 11.372583f, 29.372583f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(42.62742f, 6.0f, 48.0f, 11.372583f, 48.0f, 18.0f);
                instancePath.lineTo(48.0f, 21.0f);
                instancePath.lineTo(56.997383f, 21.0f);
                instancePath.cubicTo(58.65568f, 21.0f, 60.0f, 22.34676f, 60.0f, 24.022451f);
                instancePath.lineTo(60.0f, 60.02435f);
                instancePath.cubicTo(60.0f, 63.324608f, 57.31646f, 66.0f, 54.01782f, 66.0f);
                instancePath.lineTo(17.982182f, 66.0f);
                instancePath.cubicTo(14.678313f, 66.0f, 12.0f, 63.31981f, 12.0f, 60.02435f);
                instancePath.lineTo(12.0f, 24.022451f);
                instancePath.cubicTo(12.0f, 22.353197f, 13.333893f, 21.0f, 15.002615f, 21.0f);
                instancePath.lineTo(24.0f, 21.0f);
                instancePath.close();
                instancePath.moveTo(27.599993f, 21.0f);
                instancePath.lineTo(44.399998f, 21.0f);
                instancePath.lineTo(44.399998f, 18.0f);
                instancePath.cubicTo(44.39999f, 13.360799f, 40.639183f, 9.599991f, 35.999992f, 9.599991f);
                instancePath.cubicTo(31.3608f, 9.599991f, 27.59999f, 13.360799f, 27.59999f, 17.99999f);
                instancePath.lineTo(27.599993f, 21.0f);
                instancePath.close();
                instancePath.moveTo(24.0f, 24.6f);
                instancePath.lineTo(15.6f, 24.6f);
                instancePath.lineTo(15.6f, 60.02435f);
                instancePath.cubicTo(15.6f, 61.33281f, 16.667765f, 62.4f, 17.982182f, 62.4f);
                instancePath.lineTo(54.01782f, 62.4f);
                instancePath.cubicTo(55.331406f, 62.4f, 56.4f, 61.333214f, 56.4f, 60.02435f);
                instancePath.lineTo(56.4f, 24.6f);
                instancePath.lineTo(48.0f, 24.6f);
                instancePath.lineTo(48.0f, 33.0f);
                instancePath.lineTo(44.399998f, 33.0f);
                instancePath.lineTo(44.399998f, 24.6f);
                instancePath.lineTo(27.599995f, 24.6f);
                instancePath.lineTo(27.6f, 33.0f);
                instancePath.lineTo(24.0f, 33.0f);
                instancePath.lineTo(24.0f, 24.6f);
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
