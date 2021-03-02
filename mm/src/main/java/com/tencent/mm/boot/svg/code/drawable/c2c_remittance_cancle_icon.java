package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class c2c_remittance_cancle_icon extends c {
    private final int height = 30;
    private final int width = 30;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 30;
            case 1:
                return 30;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -2.0f, 0.0f, 1.0f, -2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(17.0f, 2.8333333f);
                instancePath.cubicTo(24.824034f, 2.8333333f, 31.166666f, 9.175966f, 31.166666f, 17.0f);
                instancePath.cubicTo(31.166666f, 24.824034f, 24.824034f, 31.166666f, 17.0f, 31.166666f);
                instancePath.cubicTo(9.175966f, 31.166666f, 2.8333333f, 24.824034f, 2.8333333f, 17.0f);
                instancePath.cubicTo(2.8333333f, 9.175966f, 9.175966f, 2.8333333f, 17.0f, 2.8333333f);
                instancePath.close();
                instancePath.moveTo(17.0f, 4.5333333f);
                instancePath.cubicTo(10.11485f, 4.5333333f, 4.5333333f, 10.11485f, 4.5333333f, 17.0f);
                instancePath.cubicTo(4.5333333f, 23.885149f, 10.11485f, 29.466667f, 17.0f, 29.466667f);
                instancePath.cubicTo(23.885149f, 29.466667f, 29.466667f, 23.885149f, 29.466667f, 17.0f);
                instancePath.cubicTo(29.466667f, 10.11485f, 23.885149f, 4.5333333f, 17.0f, 4.5333333f);
                instancePath.close();
                instancePath.moveTo(13.923605f, 11.05f);
                instancePath.lineTo(15.125687f, 12.252082f);
                instancePath.lineTo(13.210333f, 14.166333f);
                instancePath.lineTo(19.833334f, 14.166667f);
                instancePath.cubicTo(22.180544f, 14.166667f, 24.083334f, 16.069456f, 24.083334f, 18.416666f);
                instancePath.cubicTo(24.083334f, 20.763876f, 22.180544f, 22.666666f, 19.833334f, 22.666666f);
                instancePath.lineTo(17.0f, 22.666668f);
                instancePath.lineTo(17.0f, 20.966667f);
                instancePath.lineTo(19.833334f, 20.966667f);
                instancePath.cubicTo(21.24166f, 20.966667f, 22.383333f, 19.824993f, 22.383333f, 18.416666f);
                instancePath.cubicTo(22.383333f, 17.00834f, 21.24166f, 15.866667f, 19.833334f, 15.866667f);
                instancePath.lineTo(13.130333f, 15.866333f);
                instancePath.lineTo(15.125687f, 17.861795f);
                instancePath.lineTo(13.923605f, 19.063877f);
                instancePath.lineTo(10.417534f, 15.557806f);
                instancePath.cubicTo(10.140913f, 15.281184f, 10.140913f, 14.832693f, 10.417534f, 14.556071f);
                instancePath.lineTo(13.923605f, 11.05f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 9.916667f, 0.0f, 1.0f, 9.916667f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
