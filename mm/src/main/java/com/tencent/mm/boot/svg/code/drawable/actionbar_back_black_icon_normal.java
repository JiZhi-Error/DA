package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class actionbar_back_black_icon_normal extends c {
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 24.019958f);
                instancePath.cubicTo(8.014991f, 16.016632f, 16.029982f, 8.003326f, 24.054966f, 0.0f);
                instancePath.cubicTo(25.47408f, 1.4370062f, 26.893192f, 2.8740125f, 28.292316f, 4.3209977f);
                instancePath.cubicTo(22.73579f, 9.869439f, 17.179262f, 15.4079f, 11.63273f, 20.95634f);
                instancePath.cubicTo(23.755154f, 20.96632f, 35.877575f, 20.95634f, 48.0f, 20.96632f);
                instancePath.lineTo(48.0f, 27.013721f);
                instancePath.lineTo(11.582761f, 27.013721f);
                instancePath.cubicTo(17.129293f, 32.612057f, 22.725796f, 38.15052f, 28.292316f, 43.728897f);
                instancePath.cubicTo(26.873203f, 45.155926f, 25.444098f, 46.57297f, 24.01499f, 48.0f);
                instancePath.cubicTo(16.009995f, 40.006653f, 8.004997f, 32.013306f, 0.0f, 24.019958f);
                instancePath.lineTo(0.0f, 24.019958f);
                instancePath.lineTo(0.0f, 24.019958f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
