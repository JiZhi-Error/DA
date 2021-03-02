package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class multi_selected_item extends c {
    private final int height = 14;
    private final int width = 18;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 18;
            case 1:
                return 14;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -363.0f, 0.0f, 1.0f, -511.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 356.0f, 0.0f, 1.0f, 502.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(5.0f, 5.4166665f);
                instancePath.lineTo(5.0f, 4.1666665f);
                instancePath.cubicTo(5.0f, 3.7064295f, 5.373096f, 3.3333333f, 5.8333335f, 3.3333333f);
                instancePath.lineTo(17.5f, 3.3333333f);
                instancePath.cubicTo(17.960238f, 3.3333333f, 18.333334f, 3.7064295f, 18.333334f, 4.1666665f);
                instancePath.lineTo(18.333334f, 12.5f);
                instancePath.cubicTo(18.333334f, 12.9602375f, 17.960238f, 13.333333f, 17.5f, 13.333333f);
                instancePath.lineTo(16.25f, 13.333333f);
                instancePath.lineTo(16.25f, 6.6666665f);
                instancePath.cubicTo(16.25f, 5.9763107f, 15.690356f, 5.4166665f, 15.0f, 5.4166665f);
                instancePath.lineTo(5.0f, 5.4166665f);
                instancePath.close();
                instancePath.moveTo(2.5f, 6.6666665f);
                instancePath.lineTo(14.166667f, 6.6666665f);
                instancePath.cubicTo(14.626904f, 6.6666665f, 15.0f, 7.0397625f, 15.0f, 7.5f);
                instancePath.lineTo(15.0f, 15.833333f);
                instancePath.cubicTo(15.0f, 16.293571f, 14.626904f, 16.666666f, 14.166667f, 16.666666f);
                instancePath.lineTo(2.5f, 16.666666f);
                instancePath.cubicTo(2.0397627f, 16.666666f, 1.6666666f, 16.293571f, 1.6666666f, 15.833333f);
                instancePath.lineTo(1.6666666f, 7.5f);
                instancePath.cubicTo(1.6666666f, 7.0397625f, 2.0397627f, 6.6666665f, 2.5f, 6.6666665f);
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
