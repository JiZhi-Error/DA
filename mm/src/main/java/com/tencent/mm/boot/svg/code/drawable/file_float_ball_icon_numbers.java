package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class file_float_ball_icon_numbers extends c {
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
                instancePaint3.setColor(-14824411);
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 16.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.0f, 12.5f);
                instancePath2.cubicTo(0.0f, 12.223858f, 0.22385761f, 12.0f, 0.5f, 12.0f);
                instancePath2.lineTo(3.5f, 12.0f);
                instancePath2.cubicTo(3.7761424f, 12.0f, 4.0f, 12.223858f, 4.0f, 12.5f);
                instancePath2.lineTo(4.0f, 14.5f);
                instancePath2.cubicTo(4.0f, 14.776142f, 3.7761424f, 15.0f, 3.5f, 15.0f);
                instancePath2.lineTo(0.5f, 15.0f);
                instancePath2.cubicTo(0.22385761f, 15.0f, 0.0f, 14.776142f, 0.0f, 14.5f);
                instancePath2.lineTo(0.0f, 12.5f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(5.5f, 8.0f);
                instancePath3.cubicTo(5.5f, 7.7238574f, 5.7238574f, 7.5f, 6.0f, 7.5f);
                instancePath3.lineTo(9.0f, 7.5f);
                instancePath3.cubicTo(9.276142f, 7.5f, 9.5f, 7.7238574f, 9.5f, 8.0f);
                instancePath3.lineTo(9.5f, 14.5f);
                instancePath3.cubicTo(9.5f, 14.776142f, 9.276142f, 15.0f, 9.0f, 15.0f);
                instancePath3.lineTo(6.0f, 15.0f);
                instancePath3.cubicTo(5.7238574f, 15.0f, 5.5f, 14.776142f, 5.5f, 14.5f);
                instancePath3.lineTo(5.5f, 8.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint4, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(11.5f, 0.0f);
                instancePath4.lineTo(14.5f, 0.0f);
                instancePath4.cubicTo(14.776142f, -5.072653E-17f, 15.0f, 0.22385763f, 15.0f, 0.5f);
                instancePath4.lineTo(15.0f, 14.5f);
                instancePath4.cubicTo(15.0f, 14.776142f, 14.776142f, 15.0f, 14.5f, 15.0f);
                instancePath4.lineTo(11.5f, 15.0f);
                instancePath4.cubicTo(11.223858f, 15.0f, 11.0f, 14.776142f, 11.0f, 14.5f);
                instancePath4.lineTo(11.0f, 0.5f);
                instancePath4.cubicTo(11.0f, 0.22385763f, 11.223858f, 5.072653E-17f, 11.5f, 0.0f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint4, looper);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(0.0f, 16.5f);
                instancePath5.cubicTo(0.0f, 16.223858f, 0.22385761f, 16.0f, 0.5f, 16.0f);
                instancePath5.lineTo(20.5f, 16.0f);
                instancePath5.cubicTo(20.776142f, 16.0f, 21.0f, 16.223858f, 21.0f, 16.5f);
                instancePath5.lineTo(21.0f, 16.5f);
                instancePath5.cubicTo(21.0f, 16.776142f, 20.776142f, 17.0f, 20.5f, 17.0f);
                instancePath5.lineTo(0.5f, 17.0f);
                instancePath5.cubicTo(0.22385761f, 17.0f, 0.0f, 16.776142f, 0.0f, 16.5f);
                instancePath5.lineTo(0.0f, 16.5f);
                instancePath5.close();
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint4, looper);
                Path instancePath6 = c.instancePath(looper);
                instancePath6.moveTo(16.5f, 5.0f);
                instancePath6.cubicTo(16.5f, 4.7238574f, 16.723858f, 4.5f, 17.0f, 4.5f);
                instancePath6.lineTo(20.0f, 4.5f);
                instancePath6.cubicTo(20.276142f, 4.5f, 20.5f, 4.7238574f, 20.5f, 5.0f);
                instancePath6.lineTo(20.5f, 14.5f);
                instancePath6.cubicTo(20.5f, 14.776142f, 20.276142f, 15.0f, 20.0f, 15.0f);
                instancePath6.lineTo(17.0f, 15.0f);
                instancePath6.cubicTo(16.723858f, 15.0f, 16.5f, 14.776142f, 16.5f, 14.5f);
                instancePath6.lineTo(16.5f, 5.0f);
                instancePath6.close();
                canvas.drawPath(instancePath6, instancePaint9);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
