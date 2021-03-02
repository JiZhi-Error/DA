package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_icon_live_onlive extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 9.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.5f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(25.65f, 0.0f);
                instancePath.cubicTo(27.647215f, 0.0f, 29.279764f, 1.3271298f, 29.393654f, 3.0004983f);
                instancePath.lineTo(29.4f, 3.0f);
                instancePath.lineTo(29.4f, 42.0f);
                instancePath.cubicTo(29.397865f, 42.062374f, 29.4f, 42.124725f, 29.4f, 42.1875f);
                instancePath.cubicTo(29.4f, 43.947906f, 27.721067f, 45.375f, 25.65f, 45.375f);
                instancePath.cubicTo(23.578932f, 45.375f, 21.9f, 43.947906f, 21.9f, 42.1875f);
                instancePath.cubicTo(21.9f, 42.124725f, 21.902136f, 42.062374f, 21.906345f, 42.0005f);
                instancePath.lineTo(21.9f, 42.0f);
                instancePath.lineTo(21.9f, 3.0f);
                instancePath.cubicTo(22.020237f, 1.3271298f, 23.652784f, 0.0f, 25.65f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(45.75f, 6.0f);
                instancePath2.cubicTo(47.747215f, 6.0f, 49.379765f, 7.32713f, 49.493652f, 9.000499f);
                instancePath2.lineTo(49.5f, 9.0f);
                instancePath2.lineTo(49.5f, 36.0f);
                instancePath2.cubicTo(49.497864f, 36.062374f, 49.5f, 36.124725f, 49.5f, 36.1875f);
                instancePath2.cubicTo(49.5f, 37.947906f, 47.821068f, 39.375f, 45.75f, 39.375f);
                instancePath2.cubicTo(43.678932f, 39.375f, 42.0f, 37.947906f, 42.0f, 36.1875f);
                instancePath2.cubicTo(42.0f, 36.124725f, 42.002136f, 36.062374f, 42.006348f, 36.0005f);
                instancePath2.lineTo(42.0f, 36.0f);
                instancePath2.lineTo(42.0f, 9.0f);
                instancePath2.cubicTo(42.120235f, 7.32713f, 43.752785f, 6.0f, 45.75f, 6.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(5.25f, 6.0f);
                instancePath3.cubicTo(7.2472157f, 6.0f, 8.879764f, 7.32713f, 8.993653f, 9.000499f);
                instancePath3.lineTo(9.0f, 9.0f);
                instancePath3.lineTo(9.0f, 36.0f);
                instancePath3.cubicTo(8.997865f, 36.062374f, 9.0f, 36.124725f, 9.0f, 36.1875f);
                instancePath3.cubicTo(9.0f, 37.947906f, 7.321068f, 39.375f, 5.25f, 39.375f);
                instancePath3.cubicTo(3.1789322f, 39.375f, 1.5f, 37.947906f, 1.5f, 36.1875f);
                instancePath3.cubicTo(1.5f, 36.124725f, 1.5021349f, 36.062374f, 1.5063462f, 36.0005f);
                instancePath3.lineTo(1.5f, 36.0f);
                instancePath3.lineTo(1.5f, 9.0f);
                instancePath3.cubicTo(1.6202364f, 7.32713f, 3.2527843f, 6.0f, 5.25f, 6.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(5.25f, 48.0f);
                instancePath4.cubicTo(8.149495f, 48.0f, 10.5f, 49.997932f, 10.5f, 52.4625f);
                instancePath4.cubicTo(10.5f, 54.92707f, 8.149495f, 56.925003f, 5.25f, 56.925003f);
                instancePath4.cubicTo(2.3505049f, 56.925003f, 0.0f, 54.92707f, 0.0f, 52.4625f);
                instancePath4.cubicTo(0.0f, 49.997932f, 2.3505049f, 48.0f, 5.25f, 48.0f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
