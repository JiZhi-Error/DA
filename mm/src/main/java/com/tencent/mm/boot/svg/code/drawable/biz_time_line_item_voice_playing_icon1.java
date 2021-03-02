package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class biz_time_line_item_voice_playing_icon1 extends c {
    private final int height = 44;
    private final int width = 44;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 44;
            case 1:
                return 44;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix instanceMatrix = c.instanceMatrix(looper);
                float[] instanceMatrixArray = c.instanceMatrixArray(looper);
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
                instancePaint4.setColor(-16339370);
                instancePaint4.setStrokeWidth(1.2f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(22.594595f, 43.4f);
                instancePath.cubicTo(33.818893f, 43.4f, 43.4f, 33.818893f, 43.4f, 22.594595f);
                instancePath.cubicTo(43.4f, 10.363577f, 33.99429f, 0.6f, 22.594595f, 0.6f);
                instancePath.cubicTo(10.181107f, 0.6f, 0.6f, 10.181107f, 0.6f, 22.594595f);
                instancePath.cubicTo(0.6f, 33.99429f, 10.363577f, 43.4f, 22.594595f, 43.4f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 19.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-16268960);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(3.11127f, 6.482169f);
                instancePath2.cubicTo(3.9075131f, 5.685926f, 4.4f, 4.585926f, 4.4f, 3.3708994f);
                instancePath2.cubicTo(4.4f, 2.155873f, 3.9075131f, 1.055873f, 3.11127f, 0.2596296f);
                instancePath2.lineTo(-4.5474735E-13f, 3.3708994f);
                instancePath2.lineTo(3.11127f, 6.482169f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(419430400);
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint7, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(3.11127f, 6.482169f);
                instancePath3.cubicTo(3.9075131f, 5.685926f, 4.4f, 4.585926f, 4.4f, 3.3708994f);
                instancePath3.cubicTo(4.4f, 2.155873f, 3.9075131f, 1.055873f, 3.11127f, 0.2596296f);
                instancePath3.lineTo(-4.5474735E-13f, 3.3708994f);
                instancePath3.lineTo(3.11127f, 6.482169f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint8);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
