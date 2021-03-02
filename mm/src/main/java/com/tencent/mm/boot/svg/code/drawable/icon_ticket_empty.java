package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_ticket_empty extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                instancePath.moveTo(28.666666f, 6.0f);
                instancePath.cubicTo(29.403046f, 6.0f, 30.0f, 6.596954f, 30.0f, 7.3333335f);
                instancePath.lineTo(30.0f, 24.666666f);
                instancePath.cubicTo(30.0f, 25.403046f, 29.403046f, 26.0f, 28.666666f, 26.0f);
                instancePath.lineTo(3.3333333f, 26.0f);
                instancePath.cubicTo(2.5969536f, 26.0f, 2.0f, 25.403046f, 2.0f, 24.666666f);
                instancePath.lineTo(2.0f, 7.3333335f);
                instancePath.cubicTo(2.0f, 6.596954f, 2.5969536f, 6.0f, 3.3333333f, 6.0f);
                instancePath.lineTo(28.666666f, 6.0f);
                instancePath.close();
                instancePath.moveTo(28.4f, 7.6f);
                instancePath.lineTo(3.6f, 7.6f);
                instancePath.lineTo(3.6f, 24.4f);
                instancePath.lineTo(28.4f, 24.4f);
                instancePath.lineTo(28.4f, 7.6f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(12.0f, 11.333333f);
                instancePath2.cubicTo(12.73638f, 11.333333f, 13.333333f, 11.930287f, 13.333333f, 12.666667f);
                instancePath2.lineTo(13.333333f, 16.666666f);
                instancePath2.cubicTo(13.333333f, 17.403046f, 12.73638f, 18.0f, 12.0f, 18.0f);
                instancePath2.lineTo(8.0f, 18.0f);
                instancePath2.cubicTo(7.2636204f, 18.0f, 6.6666665f, 17.403046f, 6.6666665f, 16.666666f);
                instancePath2.lineTo(6.6666665f, 12.666667f);
                instancePath2.cubicTo(6.6666665f, 11.930287f, 7.2636204f, 11.333333f, 8.0f, 11.333333f);
                instancePath2.lineTo(12.0f, 11.333333f);
                instancePath2.close();
                instancePath2.moveTo(11.733f, 12.933f);
                instancePath2.lineTo(8.266f, 12.933f);
                instancePath2.lineTo(8.266f, 16.399f);
                instancePath2.lineTo(11.733f, 16.399f);
                instancePath2.lineTo(11.733f, 12.933f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(16.0f, 12.133333f);
                instancePath3.cubicTo(16.0f, 11.691505f, 16.358171f, 11.333333f, 16.8f, 11.333333f);
                instancePath3.lineTo(24.533333f, 11.333333f);
                instancePath3.cubicTo(24.97516f, 11.333333f, 25.333332f, 11.691505f, 25.333332f, 12.133333f);
                instancePath3.lineTo(25.333332f, 12.133333f);
                instancePath3.cubicTo(25.333332f, 12.575161f, 24.97516f, 12.933333f, 24.533333f, 12.933333f);
                instancePath3.lineTo(16.8f, 12.933333f);
                instancePath3.cubicTo(16.358171f, 12.933333f, 16.0f, 12.575161f, 16.0f, 12.133333f);
                instancePath3.lineTo(16.0f, 12.133333f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(16.0f, 15.466667f);
                instancePath4.cubicTo(16.0f, 15.024839f, 16.358171f, 14.666667f, 16.8f, 14.666667f);
                instancePath4.lineTo(21.866667f, 14.666667f);
                instancePath4.cubicTo(22.308495f, 14.666667f, 22.666666f, 15.024839f, 22.666666f, 15.466667f);
                instancePath4.lineTo(22.666666f, 15.466666f);
                instancePath4.cubicTo(22.666666f, 15.908494f, 22.308495f, 16.266666f, 21.866667f, 16.266666f);
                instancePath4.lineTo(16.8f, 16.266666f);
                instancePath4.cubicTo(16.358171f, 16.266666f, 16.0f, 15.908494f, 16.0f, 15.466666f);
                instancePath4.lineTo(16.0f, 15.466667f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(16.0f, 18.8f);
                instancePath5.cubicTo(16.0f, 18.358171f, 16.358171f, 18.0f, 16.8f, 18.0f);
                instancePath5.lineTo(21.866667f, 18.0f);
                instancePath5.cubicTo(22.308495f, 18.0f, 22.666666f, 18.358171f, 22.666666f, 18.8f);
                instancePath5.lineTo(22.666666f, 18.800001f);
                instancePath5.cubicTo(22.666666f, 19.241829f, 22.308495f, 19.6f, 21.866667f, 19.6f);
                instancePath5.lineTo(16.8f, 19.6f);
                instancePath5.cubicTo(16.358171f, 19.6f, 16.0f, 19.241829f, 16.0f, 18.800001f);
                instancePath5.lineTo(16.0f, 18.8f);
                instancePath5.close();
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
