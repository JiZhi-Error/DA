package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class websearch_icon_wegame extends c {
    private final int height = 16;
    private final int width = 16;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 16;
            case 1:
                return 16;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -394.0f, 0.0f, 1.0f, -603.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 66.0f, 0.0f, 1.0f, 602.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 327.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-5066062);
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 1.0f, 0.0f, 1.5f, 0.0f, 1.0f, 2.25f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(10.003614f, 7.676534f);
                instancePath.cubicTo(9.463942f, 8.64106f, 8.048503f, 8.919226f, 6.8421645f, 8.298307f);
                instancePath.cubicTo(5.6358266f, 7.677047f, 5.0950847f, 6.3916397f, 5.6345797f, 5.427114f);
                instancePath.cubicTo(6.1742525f, 4.462589f, 7.5896916f, 4.1844225f, 8.79603f, 4.805512f);
                instancePath.cubicTo(10.002546f, 5.4267726f, 10.543287f, 6.712009f, 10.003614f, 7.676534f);
                instancePath.moveTo(10.079537f, 4.06439f);
                instancePath.cubicTo(7.3818364f, 1.7038151f, 3.4686835f, 1.6194388f, 1.3390536f, 3.875688f);
                instancePath.cubicTo(-0.7907462f, 6.1319375f, -0.33034536f, 9.874747f, 2.3671858f, 12.235322f);
                instancePath.cubicTo(5.064887f, 14.595734f, 8.9782095f, 14.680437f, 11.10784f, 12.424025f);
                instancePath.cubicTo(13.23747f, 10.167775f, 12.777239f, 6.4249654f, 10.079537f, 4.06439f);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(12.304614f, 0.051767882f);
                instancePath2.cubicTo(13.397458f, -0.21129034f, 14.561358f, 0.554029f, 14.904305f, 1.7609161f);
                instancePath2.cubicTo(15.2472515f, 2.9679656f, 14.639293f, 4.1595984f, 13.54645f, 4.4226565f);
                instancePath2.cubicTo(12.453607f, 4.6857147f, 11.289882f, 3.9205577f, 10.946759f, 2.7135081f);
                instancePath2.cubicTo(10.603812f, 1.5064588f, 11.211771f, 0.3149884f, 12.304614f, 0.051767882f);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(0.0f, 0.0f);
                instancePath3.lineTo(18.0f, 0.0f);
                instancePath3.lineTo(18.0f, 18.0f);
                instancePath3.lineTo(0.0f, 18.0f);
                instancePath3.lineTo(0.0f, 0.0f);
                instancePath3.close();
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.drawPath(instancePath3, c.instancePaint(instancePaint7, looper));
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
