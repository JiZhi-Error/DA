package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_article extends c {
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
                instancePath.moveTo(35.991314f, 65.99143f);
                instancePath.cubicTo(19.422773f, 65.99143f, 5.9913154f, 52.559975f, 5.9913154f, 35.991432f);
                instancePath.cubicTo(5.9913154f, 19.422892f, 19.422773f, 5.991433f, 35.991314f, 5.991433f);
                instancePath.cubicTo(52.559856f, 5.991433f, 65.99132f, 19.422892f, 65.99132f, 35.991432f);
                instancePath.cubicTo(65.99132f, 52.559975f, 52.559856f, 65.99143f, 35.991314f, 65.99143f);
                instancePath.close();
                instancePath.moveTo(35.991314f, 62.391434f);
                instancePath.cubicTo(50.571632f, 62.391434f, 62.391315f, 50.57175f, 62.391315f, 35.991432f);
                instancePath.cubicTo(62.391315f, 21.411116f, 50.571632f, 9.591434f, 35.991314f, 9.591434f);
                instancePath.cubicTo(21.410997f, 9.591434f, 9.591315f, 21.411116f, 9.591315f, 35.991432f);
                instancePath.cubicTo(9.591315f, 50.57175f, 21.410997f, 62.391434f, 35.991314f, 62.391434f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(20.84846f, 23.342865f);
                instancePath2.lineTo(25.84846f, 23.342865f);
                instancePath2.lineTo(25.84846f, 28.342865f);
                instancePath2.lineTo(20.84846f, 28.342865f);
                instancePath2.lineTo(20.84846f, 23.342865f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(20.84846f, 33.342865f);
                instancePath3.lineTo(25.84846f, 33.342865f);
                instancePath3.lineTo(25.84846f, 38.342865f);
                instancePath3.lineTo(20.84846f, 38.342865f);
                instancePath3.lineTo(20.84846f, 33.342865f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(20.84846f, 43.342865f);
                instancePath4.lineTo(25.84846f, 43.342865f);
                instancePath4.lineTo(25.84846f, 48.342865f);
                instancePath4.lineTo(20.84846f, 48.342865f);
                instancePath4.lineTo(20.84846f, 43.342865f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(29.0f, 24.0f);
                instancePath5.lineTo(51.0f, 24.0f);
                instancePath5.lineTo(51.0f, 27.6f);
                instancePath5.lineTo(29.0f, 27.6f);
                instancePath5.lineTo(29.0f, 24.0f);
                instancePath5.close();
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint3, looper);
                Path instancePath6 = c.instancePath(looper);
                instancePath6.moveTo(29.0f, 34.0f);
                instancePath6.lineTo(51.0f, 34.0f);
                instancePath6.lineTo(51.0f, 37.6f);
                instancePath6.lineTo(29.0f, 37.6f);
                instancePath6.lineTo(29.0f, 34.0f);
                instancePath6.close();
                canvas.drawPath(instancePath6, instancePaint9);
                canvas.restore();
                canvas.save();
                Paint instancePaint10 = c.instancePaint(instancePaint3, looper);
                Path instancePath7 = c.instancePath(looper);
                instancePath7.moveTo(29.0f, 44.0f);
                instancePath7.lineTo(51.0f, 44.0f);
                instancePath7.lineTo(51.0f, 47.6f);
                instancePath7.lineTo(29.0f, 47.6f);
                instancePath7.lineTo(29.0f, 44.0f);
                instancePath7.close();
                canvas.drawPath(instancePath7, instancePaint10);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
