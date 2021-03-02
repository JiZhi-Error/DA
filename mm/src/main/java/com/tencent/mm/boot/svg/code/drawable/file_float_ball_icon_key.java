package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class file_float_ball_icon_key extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                instancePaint3.setColor(-14776843);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(48.0f, 0.0f);
                instancePath.lineTo(48.0f, 48.0f);
                instancePath.lineTo(0.0f, 48.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 15.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(5.4545455f, 18.595238f);
                instancePath2.cubicTo(5.4545455f, 18.319096f, 5.678403f, 18.095238f, 5.9545455f, 18.095238f);
                instancePath2.lineTo(14.045454f, 18.095238f);
                instancePath2.cubicTo(14.321596f, 18.095238f, 14.545454f, 18.319096f, 14.545454f, 18.595238f);
                instancePath2.lineTo(14.545454f, 18.595238f);
                instancePath2.cubicTo(14.545454f, 18.87138f, 14.321596f, 19.095238f, 14.045454f, 19.095238f);
                instancePath2.lineTo(5.9545455f, 19.095238f);
                instancePath2.cubicTo(5.678403f, 19.095238f, 5.4545455f, 18.87138f, 5.4545455f, 18.595238f);
                instancePath2.lineTo(5.4545455f, 18.595238f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(0.0f, 9.047619f);
                instancePath3.lineTo(20.0f, 9.047619f);
                instancePath3.lineTo(20.0f, 9.047619f);
                instancePath3.cubicTo(20.0f, 10.046991f, 19.189848f, 10.857142f, 18.190475f, 10.857142f);
                instancePath3.lineTo(1.8095238f, 10.857142f);
                instancePath3.cubicTo(0.8101514f, 10.857142f, 1.2238782E-16f, 10.046991f, 0.0f, 9.047619f);
                instancePath3.lineTo(0.0f, 9.047619f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint4, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(9.545455f, 10.0f);
                instancePath4.cubicTo(9.545455f, 9.723858f, 9.769313f, 9.5f, 10.045455f, 9.5f);
                instancePath4.lineTo(10.045455f, 9.5f);
                instancePath4.cubicTo(10.321597f, 9.5f, 10.545455f, 9.723858f, 10.545455f, 10.0f);
                instancePath4.lineTo(10.545455f, 18.047619f);
                instancePath4.cubicTo(10.545455f, 18.323761f, 10.321597f, 18.547619f, 10.045455f, 18.547619f);
                instancePath4.lineTo(10.045455f, 18.547619f);
                instancePath4.cubicTo(9.769313f, 18.547619f, 9.545455f, 18.323761f, 9.545455f, 18.047619f);
                instancePath4.lineTo(9.545455f, 10.0f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint4, looper);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(3.2852273f, 0.0f);
                instancePath5.lineTo(16.449621f, 4.440892E-16f);
                instancePath5.cubicTo(16.883898f, -4.071179E-16f, 17.257532f, 0.3071576f, 17.341541f, 0.733232f);
                instancePath5.lineTo(18.825758f, 8.26087f);
                instancePath5.lineTo(0.90909094f, 8.26087f);
                instancePath5.lineTo(2.3933082f, 0.733232f);
                instancePath5.cubicTo(2.4773169f, 0.3071576f, 2.85095f, -5.8635835E-16f, 3.2852273f, -6.661338E-16f);
                instancePath5.close();
                instancePath5.moveTo(6.2489114f, 6.2734194f);
                instancePath5.lineTo(8.430138f, 4.238125f);
                instancePath5.lineTo(10.4210825f, 5.569347f);
                instancePath5.cubicTo(10.5746155f, 5.6686063f, 10.7769165f, 5.6490107f, 10.903219f, 5.5225234f);
                instancePath5.lineTo(13.67641f, 2.520652f);
                instancePath5.lineTo(13.129231f, 1.9894394f);
                instancePath5.lineTo(10.571503f, 4.773793f);
                instancePath5.lineTo(8.613288f, 3.4425108f);
                instancePath5.cubicTo(8.47233f, 3.3432245f, 8.279788f, 3.3628607f, 8.151994f, 3.4894264f);
                instancePath5.lineTo(5.749195f, 5.7423906f);
                instancePath5.lineTo(6.2489114f, 6.2734194f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 2);
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
