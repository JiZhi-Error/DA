package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class download_delete_disable extends c {
    private final int height = 25;
    private final int width = 25;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 25;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -278.0f, 0.0f, 1.0f, -695.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 682.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 16.2f, 0.0f, 1.0f, 12.2f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 1.0f, 0.0f, 261.8f, 0.0f, 1.0f, 0.8f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(24.0f, 0.0f);
                instancePath.lineTo(24.0f, 24.0f);
                instancePath.lineTo(0.0f, 24.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(637534208);
                canvas.save();
                float[] matrixFloatArray5 = c.setMatrixFloatArray(matrixFloatArray4, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray5);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(3.7735524f, 3.399997f);
                instancePath2.lineTo(4.585906f, 17.047535f);
                instancePath2.cubicTo(4.6110616f, 17.470152f, 4.961127f, 17.8f, 5.3844924f, 17.8f);
                instancePath2.lineTo(12.615507f, 17.8f);
                instancePath2.cubicTo(13.038874f, 17.8f, 13.388938f, 17.470152f, 13.414094f, 17.047535f);
                instancePath2.lineTo(14.226447f, 3.399997f);
                instancePath2.lineTo(3.7735524f, 3.399997f);
                instancePath2.close();
                instancePath2.moveTo(15.428572f, 3.399997f);
                instancePath2.lineTo(14.611974f, 17.118837f);
                instancePath2.cubicTo(14.549085f, 18.17538f, 13.673922f, 19.0f, 12.615507f, 19.0f);
                instancePath2.lineTo(5.3844924f, 19.0f);
                instancePath2.cubicTo(4.3260784f, 19.0f, 3.4509156f, 18.17538f, 3.388026f, 17.118837f);
                instancePath2.lineTo(2.5714285f, 3.399997f);
                instancePath2.lineTo(0.5f, 3.399997f);
                instancePath2.lineTo(0.5f, 2.699997f);
                instancePath2.cubicTo(0.5f, 2.4238546f, 0.72385764f, 2.199997f, 1.0f, 2.199997f);
                instancePath2.lineTo(17.0f, 2.199997f);
                instancePath2.cubicTo(17.276142f, 2.199997f, 17.5f, 2.4238546f, 17.5f, 2.699997f);
                instancePath2.lineTo(17.5f, 3.399997f);
                instancePath2.lineTo(15.428572f, 3.399997f);
                instancePath2.close();
                instancePath2.moveTo(7.700012f, 6.0f);
                instancePath2.lineTo(8.200012f, 15.0f);
                instancePath2.lineTo(7.0f, 15.0f);
                instancePath2.lineTo(6.5f, 6.0f);
                instancePath2.lineTo(7.700012f, 6.0f);
                instancePath2.close();
                instancePath2.moveTo(11.5f, 6.0f);
                instancePath2.lineTo(11.0f, 15.0f);
                instancePath2.lineTo(9.799988f, 15.0f);
                instancePath2.lineTo(10.299988f, 6.0f);
                instancePath2.lineTo(11.5f, 6.0f);
                instancePath2.close();
                instancePath2.moveTo(11.0f, 2.7285569E-5f);
                instancePath2.cubicTo(11.276142f, 2.7285569E-5f, 11.5f, 0.22388491f, 11.5f, 0.5000273f);
                instancePath2.lineTo(11.5f, 1.2000242f);
                instancePath2.lineTo(6.5f, 1.2000242f);
                instancePath2.lineTo(6.5f, 0.5000273f);
                instancePath2.cubicTo(6.5f, 0.22388491f, 6.7238574f, 2.7285569E-5f, 7.0f, 2.7285569E-5f);
                instancePath2.lineTo(11.0f, 2.7285569E-5f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
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
