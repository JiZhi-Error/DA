package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class websearch_icon_search extends c {
    private final int height = 14;
    private final int width = 14;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 14;
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
                instancePaint3.setColor(-5066062);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -140.0f, 0.0f, 1.0f, -747.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 66.0f, 0.0f, 1.0f, 602.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 72.0f, 0.0f, 1.0f, 143.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.429453f, 11.795271f);
                instancePath.lineTo(15.915277f, 15.281094f);
                instancePath.lineTo(15.19637f, 16.0f);
                instancePath.lineTo(11.703301f, 12.506931f);
                instancePath.cubicTo(10.678107f, 13.353059f, 9.3637495f, 13.861345f, 7.9306726f, 13.861345f);
                instancePath.cubicTo(4.6552467f, 13.861345f, 2.0f, 11.206099f, 2.0f, 7.9306726f);
                instancePath.cubicTo(2.0f, 4.6552467f, 4.6552467f, 2.0f, 7.9306726f, 2.0f);
                instancePath.cubicTo(11.206099f, 2.0f, 13.861345f, 4.6552467f, 13.861345f, 7.9306726f);
                instancePath.cubicTo(13.861345f, 9.406973f, 13.321936f, 10.757285f, 12.429453f, 11.795271f);
                instancePath.close();
                instancePath.moveTo(12.844656f, 7.930683f);
                instancePath.cubicTo(12.844656f, 5.2167587f, 10.644594f, 3.0166972f, 7.9306703f, 3.0166972f);
                instancePath.cubicTo(5.216746f, 3.0166972f, 3.016684f, 5.2167587f, 3.016684f, 7.930683f);
                instancePath.cubicTo(3.016684f, 10.644608f, 5.216746f, 12.844669f, 7.9306703f, 12.844669f);
                instancePath.cubicTo(10.644594f, 12.844669f, 12.844656f, 10.644608f, 12.844656f, 7.930683f);
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
