package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class list_deletetext_icon extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(1073741824);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 8.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 0.70710677f, 0.70710677f, -16.568542f, -0.70710677f, 0.70710677f, 40.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(37.0f, 37.0f);
                instancePath.lineTo(37.0f, 12.995752f);
                instancePath.cubicTo(37.0f, 12.450768f, 37.44359f, 12.0f, 37.99078f, 12.0f);
                instancePath.lineTo(42.00922f, 12.0f);
                instancePath.cubicTo(42.549026f, 12.0f, 43.0f, 12.445813f, 43.0f, 12.995752f);
                instancePath.lineTo(43.0f, 37.0f);
                instancePath.lineTo(67.00425f, 37.0f);
                instancePath.cubicTo(67.54923f, 37.0f, 68.0f, 37.44359f, 68.0f, 37.99078f);
                instancePath.lineTo(68.0f, 42.00922f);
                instancePath.cubicTo(68.0f, 42.549026f, 67.554184f, 43.0f, 67.00425f, 43.0f);
                instancePath.lineTo(43.0f, 43.0f);
                instancePath.lineTo(43.0f, 67.00425f);
                instancePath.cubicTo(43.0f, 67.54923f, 42.55641f, 68.0f, 42.00922f, 68.0f);
                instancePath.lineTo(37.99078f, 68.0f);
                instancePath.cubicTo(37.450974f, 68.0f, 37.0f, 67.554184f, 37.0f, 67.00425f);
                instancePath.lineTo(37.0f, 43.0f);
                instancePath.lineTo(12.995752f, 43.0f);
                instancePath.cubicTo(12.450768f, 43.0f, 12.0f, 42.55641f, 12.0f, 42.00922f);
                instancePath.lineTo(12.0f, 37.99078f);
                instancePath.cubicTo(12.0f, 37.450974f, 12.445813f, 37.0f, 12.995752f, 37.0f);
                instancePath.lineTo(37.0f, 37.0f);
                instancePath.lineTo(37.0f, 37.0f);
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
