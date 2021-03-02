package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_allow_comment extends c {
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
                instancePaint3.setColor(-436207616);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.666667f, 0.0f, 1.0f, 4.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(8.889937f, 20.357117f);
                instancePath.lineTo(9.476319f, 20.526922f);
                instancePath.cubicTo(10.704722f, 20.882647f, 12.002946f, 21.066668f, 13.333333f, 21.066668f);
                instancePath.cubicTo(19.865908f, 21.066668f, 25.066668f, 16.64602f, 25.066668f, 11.333333f);
                instancePath.cubicTo(25.066668f, 6.0206456f, 19.865908f, 1.6f, 13.333333f, 1.6f);
                instancePath.cubicTo(6.80076f, 1.6f, 1.6f, 6.0206456f, 1.6f, 11.333333f);
                instancePath.cubicTo(1.6f, 14.101232f, 3.0092406f, 16.701462f, 5.4674597f, 18.548485f);
                instancePath.lineTo(6.2016797f, 19.100151f);
                instancePath.lineTo(5.888258f, 21.796453f);
                instancePath.lineTo(8.889937f, 20.357117f);
                instancePath.close();
                instancePath.moveTo(13.333333f, 22.666666f);
                instancePath.cubicTo(11.828022f, 22.666666f, 10.380974f, 22.454632f, 9.031272f, 22.063782f);
                instancePath.lineTo(5.0540013f, 23.970924f);
                instancePath.cubicTo(4.94047f, 24.025364f, 4.8138437f, 24.04654f, 4.6887774f, 24.032001f);
                instancePath.cubicTo(4.32305f, 23.989489f, 4.061033f, 23.658546f, 4.103545f, 23.292818f);
                instancePath.lineTo(4.5063415f, 19.827644f);
                instancePath.cubicTo(1.7426641f, 17.75111f, 0.0f, 14.715206f, 0.0f, 11.333333f);
                instancePath.cubicTo(0.0f, 5.074106f, 5.969537f, 0.0f, 13.333333f, 0.0f);
                instancePath.cubicTo(20.69713f, 0.0f, 26.666666f, 5.074106f, 26.666666f, 11.333333f);
                instancePath.cubicTo(26.666666f, 17.59256f, 20.69713f, 22.666666f, 13.333333f, 22.666666f);
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
