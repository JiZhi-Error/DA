package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class actionbar_icon_dark_voice extends c {
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
                canvas.saveLayerAlpha(null, 76, 31);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-13421773);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -9.0f, 0.0f, 1.0f, -3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 0.8660254f, -0.5f, 35.39353f, 0.5f, 0.8660254f, 1.0432687f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(29.976608f, 53.99089f);
                instancePath.lineTo(28.02372f, 58.706367f);
                instancePath.lineTo(26.070831f, 53.99089f);
                instancePath.lineTo(26.051668f, 53.99089f);
                instancePath.lineTo(26.051668f, 47.683502f);
                instancePath.cubicTo(17.177538f, 46.702515f, 10.275263f, 39.178997f, 10.275263f, 30.043367f);
                instancePath.lineTo(10.275263f, 23.18063f);
                instancePath.lineTo(14.219365f, 23.18063f);
                instancePath.lineTo(14.219365f, 29.885603f);
                instancePath.cubicTo(14.219365f, 37.509537f, 20.399784f, 43.689957f, 28.02372f, 43.689957f);
                instancePath.cubicTo(35.647655f, 43.689957f, 41.828075f, 37.509537f, 41.828075f, 29.885603f);
                instancePath.lineTo(41.828075f, 23.18063f);
                instancePath.lineTo(45.772175f, 23.18063f);
                instancePath.lineTo(45.772175f, 30.043367f);
                instancePath.cubicTo(45.772175f, 39.178997f, 38.8699f, 46.702515f, 29.99577f, 47.683502f);
                instancePath.lineTo(29.99577f, 53.99089f);
                instancePath.lineTo(29.976608f, 53.99089f);
                instancePath.close();
                instancePath.moveTo(28.02372f, 2.6713028f);
                instancePath.cubicTo(33.469387f, 2.6713028f, 37.883972f, 7.085889f, 37.883972f, 12.531556f);
                instancePath.lineTo(37.883972f, 29.727839f);
                instancePath.cubicTo(37.883972f, 35.173508f, 33.469387f, 39.588093f, 28.02372f, 39.588093f);
                instancePath.cubicTo(22.578053f, 39.588093f, 18.163465f, 35.173508f, 18.163465f, 29.727839f);
                instancePath.lineTo(18.163465f, 12.531556f);
                instancePath.cubicTo(18.163465f, 7.085889f, 22.578053f, 2.6713028f, 28.02372f, 2.6713028f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
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
