package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_actionbar_capsule_lbs_dark extends c {
    private final int height = 96;
    private final int width = 130;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 130;
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -238.0f, 0.0f, 1.0f, -166.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 238.0f, 0.0f, 1.0f, 166.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 0.70710677f, -0.70710677f, 50.78103f, 0.70710677f, 0.70710677f, -41.066437f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(75.89903f, 17.651163f);
                instancePath.lineTo(92.860985f, 63.1806f);
                instancePath.lineTo(92.860985f, 63.1806f);
                instancePath.cubicTo(93.05379f, 63.698135f, 92.79054f, 64.27399f, 92.27301f, 64.46679f);
                instancePath.cubicTo(91.96835f, 64.58029f, 91.62753f, 64.538605f, 91.359215f, 64.35502f);
                instancePath.lineTo(74.96195f, 53.135838f);
                instancePath.lineTo(58.56469f, 64.35502f);
                instancePath.lineTo(58.56469f, 64.35502f);
                instancePath.cubicTo(58.108883f, 64.666885f, 57.486565f, 64.5502f, 57.174698f, 64.09439f);
                instancePath.cubicTo(56.99111f, 63.826077f, 56.949425f, 63.48526f, 57.062923f, 63.1806f);
                instancePath.lineTo(74.02487f, 17.651163f);
                instancePath.lineTo(74.02487f, 17.651163f);
                instancePath.cubicTo(74.21768f, 17.133627f, 74.793526f, 16.870382f, 75.311066f, 17.063189f);
                instancePath.cubicTo(75.58311f, 17.164541f, 75.79768f, 17.379114f, 75.89903f, 17.651163f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
