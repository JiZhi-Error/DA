package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class honey_pay_add_friend extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                canvas.save();
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -175.0f, 0.0f, 1.0f, -368.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-11048043);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 339.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(179.0f, 40.0f);
                instancePath.lineTo(179.0f, 30.0f);
                instancePath.cubicTo(179.0f, 29.447716f, 179.44771f, 29.0f, 180.0f, 29.0f);
                instancePath.cubicTo(180.55229f, 29.0f, 181.0f, 29.447716f, 181.0f, 30.0f);
                instancePath.lineTo(181.0f, 40.0f);
                instancePath.lineTo(191.0f, 40.0f);
                instancePath.cubicTo(191.55229f, 40.0f, 192.0f, 40.447716f, 192.0f, 41.0f);
                instancePath.cubicTo(192.0f, 41.552284f, 191.55229f, 42.0f, 191.0f, 42.0f);
                instancePath.lineTo(181.0f, 42.0f);
                instancePath.lineTo(181.0f, 52.0f);
                instancePath.cubicTo(181.0f, 52.552284f, 180.55229f, 53.0f, 180.0f, 53.0f);
                instancePath.cubicTo(179.44771f, 53.0f, 179.0f, 52.552284f, 179.0f, 52.0f);
                instancePath.lineTo(179.0f, 42.0f);
                instancePath.lineTo(169.0f, 42.0f);
                instancePath.cubicTo(168.44771f, 42.0f, 168.0f, 41.552284f, 168.0f, 41.0f);
                instancePath.cubicTo(168.0f, 40.447716f, 168.44771f, 40.0f, 169.0f, 40.0f);
                instancePath.lineTo(179.0f, 40.0f);
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
