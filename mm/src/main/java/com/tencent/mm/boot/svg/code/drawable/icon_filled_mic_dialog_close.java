package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_filled_mic_dialog_close extends c {
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
                canvas.saveLayerAlpha(null, 204, 31);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 6.123234E-17f, -1.0f, 32.0f, -1.0f, -6.123234E-17f, 32.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 2.666667f, 0.0f, 1.0f, 2.666667f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.333333f, 0.0f);
                instancePath.cubicTo(20.69713f, 0.0f, 26.666666f, 5.969537f, 26.666666f, 13.333333f);
                instancePath.cubicTo(26.666666f, 20.69713f, 20.69713f, 26.666666f, 13.333333f, 26.666666f);
                instancePath.cubicTo(5.969537f, 26.666666f, 0.0f, 20.69713f, 0.0f, 13.333333f);
                instancePath.cubicTo(0.0f, 5.969537f, 5.969537f, 0.0f, 13.333333f, 0.0f);
                instancePath.close();
                instancePath.moveTo(14.604089f, 7.3333335f);
                instancePath.lineTo(9.476052f, 12.621493f);
                instancePath.cubicTo(9.098584f, 13.010747f, 9.094818f, 13.652035f, 9.476052f, 14.045174f);
                instancePath.lineTo(9.476052f, 14.045174f);
                instancePath.lineTo(14.604089f, 19.333334f);
                instancePath.lineTo(15.998045f, 17.916666f);
                instancePath.lineTo(11.57368f, 13.333333f);
                instancePath.lineTo(15.998045f, 8.75f);
                instancePath.lineTo(14.604089f, 7.3333335f);
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
