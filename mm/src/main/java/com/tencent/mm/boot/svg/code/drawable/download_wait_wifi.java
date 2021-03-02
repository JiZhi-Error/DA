package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class download_wait_wifi extends c {
    private final int height = 25;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 25;
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
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -300.0f, 0.0f, 1.0f, -360.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 80.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 256.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, -1.0f, -1.2246469E-16f, 336.0f, 1.2246469E-16f, -1.0f, 61.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(48.0f, 0.0f);
                instancePath.lineTo(48.0f, 48.0f);
                instancePath.lineTo(0.0f, 48.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(Integer.MIN_VALUE);
                float[] matrixFloatArray5 = c.setMatrixFloatArray(matrixFloatArray4, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 49.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray5);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(24.0f, 26.631578f);
                instancePath2.cubicTo(24.616123f, 26.631578f, 25.173965f, 26.896248f, 25.577976f, 27.324244f);
                instancePath2.lineTo(23.996475f, 29.0f);
                instancePath2.lineTo(22.420134f, 27.326248f);
                instancePath2.lineTo(22.420134f, 27.326248f);
                instancePath2.lineTo(22.52523f, 27.221588f);
                instancePath2.cubicTo(22.918587f, 26.854332f, 23.434767f, 26.631578f, 24.0f, 26.631578f);
                instancePath2.close();
                instancePath2.moveTo(24.0f, 23.31579f);
                instancePath2.cubicTo(25.479393f, 23.31579f, 26.818777f, 23.951595f, 27.788511f, 24.979635f);
                instancePath2.lineTo(26.524904f, 26.318941f);
                instancePath2.cubicTo(25.878475f, 25.63406f, 24.98587f, 25.210526f, 24.0f, 25.210526f);
                instancePath2.cubicTo(23.012695f, 25.210526f, 22.118925f, 25.635296f, 21.472273f, 26.321936f);
                instancePath2.lineTo(20.209602f, 24.981636f);
                instancePath2.cubicTo(21.179487f, 23.952421f, 22.51965f, 23.31579f, 24.0f, 23.31579f);
                instancePath2.close();
                instancePath2.moveTo(24.0f, 20.0f);
                instancePath2.cubicTo(26.343145f, 20.0f, 28.464466f, 21.007359f, 30.0f, 22.63604f);
                instancePath2.lineTo(28.736841f, 23.97582f);
                instancePath2.cubicTo(27.524578f, 22.69002f, 25.849852f, 21.894737f, 24.0f, 21.894737f);
                instancePath2.cubicTo(22.149677f, 21.894737f, 20.474571f, 22.690424f, 19.262234f, 23.9768f);
                instancePath2.lineTo(18.0f, 22.63604f);
                instancePath2.cubicTo(19.535534f, 21.007359f, 21.656855f, 20.0f, 24.0f, 20.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
