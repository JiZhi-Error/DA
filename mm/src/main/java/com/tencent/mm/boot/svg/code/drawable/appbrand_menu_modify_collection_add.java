package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class appbrand_menu_modify_collection_add extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                instancePaint3.setColor(16777215);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(32.0f, 0.0f);
                instancePath.lineTo(32.0f, 32.0f);
                instancePath.lineTo(0.0f, 32.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-15616);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.70710677f, 0.70710677f, -9.42503f, -0.70710677f, 0.70710677f, 22.775038f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(21.846054f, 17.431202f);
                instancePath2.lineTo(23.71272f, 17.431202f);
                instancePath2.lineTo(23.71272f, 28.09787f);
                instancePath2.lineTo(21.846054f, 28.09787f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-15616);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(18.333334f, 18.333334f);
                instancePath3.lineTo(25.333334f, 18.333334f);
                instancePath3.lineTo(25.333334f, 20.2f);
                instancePath3.lineTo(18.333334f, 20.2f);
                instancePath3.lineTo(18.333334f, 18.333334f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-15616);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(18.333334f, 18.333334f);
                instancePath4.lineTo(20.2f, 18.333334f);
                instancePath4.lineTo(20.2f, 25.333334f);
                instancePath4.lineTo(18.333334f, 25.333334f);
                instancePath4.lineTo(18.333334f, 18.333334f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-15616);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(17.333334f, 9.666666f);
                instancePath5.cubicTo(17.333334f, 6.905242f, 19.57191f, 4.6666665f, 22.333334f, 4.6666665f);
                instancePath5.lineTo(22.333334f, 4.6666665f);
                instancePath5.cubicTo(25.094757f, 4.6666665f, 27.333334f, 6.905242f, 27.333334f, 9.666666f);
                instancePath5.lineTo(27.333334f, 9.666666f);
                instancePath5.cubicTo(27.333334f, 12.42809f, 25.094757f, 14.666666f, 22.333334f, 14.666666f);
                instancePath5.lineTo(22.333334f, 14.666666f);
                instancePath5.cubicTo(19.57191f, 14.666666f, 17.333334f, 12.42809f, 17.333334f, 9.666666f);
                instancePath5.lineTo(17.333334f, 9.666666f);
                instancePath5.close();
                canvas.drawPath(instancePath5, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-15616);
                Path instancePath6 = c.instancePath(looper);
                instancePath6.moveTo(4.6666665f, 9.666666f);
                instancePath6.cubicTo(4.6666665f, 6.905242f, 6.905242f, 4.6666665f, 9.666666f, 4.6666665f);
                instancePath6.lineTo(9.666666f, 4.6666665f);
                instancePath6.cubicTo(12.42809f, 4.6666665f, 14.666666f, 6.905242f, 14.666666f, 9.666666f);
                instancePath6.lineTo(14.666666f, 9.666666f);
                instancePath6.cubicTo(14.666666f, 12.42809f, 12.42809f, 14.666666f, 9.666666f, 14.666666f);
                instancePath6.lineTo(9.666666f, 14.666666f);
                instancePath6.cubicTo(6.905242f, 14.666666f, 4.6666665f, 12.42809f, 4.6666665f, 9.666666f);
                instancePath6.lineTo(4.6666665f, 9.666666f);
                instancePath6.close();
                canvas.drawPath(instancePath6, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(-15616);
                Path instancePath7 = c.instancePath(looper);
                instancePath7.moveTo(4.6666665f, 22.333334f);
                instancePath7.cubicTo(4.6666665f, 19.57191f, 6.905242f, 17.333334f, 9.666666f, 17.333334f);
                instancePath7.lineTo(9.666666f, 17.333334f);
                instancePath7.cubicTo(12.42809f, 17.333334f, 14.666666f, 19.57191f, 14.666666f, 22.333334f);
                instancePath7.lineTo(14.666666f, 22.333334f);
                instancePath7.cubicTo(14.666666f, 25.094757f, 12.42809f, 27.333334f, 9.666666f, 27.333334f);
                instancePath7.lineTo(9.666666f, 27.333334f);
                instancePath7.cubicTo(6.905242f, 27.333334f, 4.6666665f, 25.094757f, 4.6666665f, 22.333334f);
                instancePath7.lineTo(4.6666665f, 22.333334f);
                instancePath7.close();
                canvas.drawPath(instancePath7, instancePaint9);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
