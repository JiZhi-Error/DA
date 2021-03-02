package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class search_add_icon_green extends c {
    private final int height = 138;
    private final int width = 138;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 138;
            case 1:
                return 138;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -283.0f, 0.0f, 1.0f, -245.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 283.0f, 0.0f, 1.0f, 245.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-13917627);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 6.0f);
                instancePath.cubicTo(0.0f, 2.6862912f, 2.6862912f, 0.0f, 6.0f, 0.0f);
                instancePath.lineTo(132.0f, 0.0f);
                instancePath.cubicTo(135.3137f, 0.0f, 138.0f, 2.6862912f, 138.0f, 6.0f);
                instancePath.lineTo(138.0f, 132.0f);
                instancePath.cubicTo(138.0f, 135.3137f, 135.3137f, 138.0f, 132.0f, 138.0f);
                instancePath.lineTo(6.0f, 138.0f);
                instancePath.cubicTo(2.6862912f, 138.0f, 0.0f, 135.3137f, 0.0f, 132.0f);
                instancePath.lineTo(0.0f, 6.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 36.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(-1);
                instancePaint6.setStrokeWidth(6.0f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(23.239437f, 34.394367f);
                instancePath2.cubicTo(27.35964f, 40.93951f, 20.518991f, 43.903023f, 17.661972f, 45.549297f);
                instancePath2.cubicTo(5.370789f, 52.541847f, 0.0f, 55.160763f, 0.0f, 58.56338f);
                instancePath2.lineTo(0.0f, 63.21127f);
                instancePath2.cubicTo(0.0f, 64.70552f, 1.1176436f, 66.0f, 2.7887323f, 66.0f);
                instancePath2.lineTo(63.21127f, 66.0f);
                instancePath2.cubicTo(64.882355f, 66.0f, 66.0f, 64.70552f, 66.0f, 63.21127f);
                instancePath2.lineTo(66.0f, 58.56338f);
                instancePath2.cubicTo(66.0f, 55.160763f, 60.62921f, 52.541847f, 48.338028f, 45.549297f);
                instancePath2.cubicTo(45.481007f, 43.903023f, 38.64036f, 40.93951f, 42.760563f, 34.394367f);
                instancePath2.cubicTo(46.419594f, 28.960619f, 49.2747f, 26.747225f, 49.267605f, 17.661972f);
                instancePath2.cubicTo(49.2747f, 9.037081f, 42.896458f, 0.0f, 33.46479f, 0.0f);
                instancePath2.cubicTo(23.103542f, 0.0f, 16.7253f, 9.037081f, 16.732395f, 17.661972f);
                instancePath2.cubicTo(16.7253f, 26.747225f, 19.580408f, 28.960619f, 23.239437f, 34.394367f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(69.0f, 30.0f);
                instancePath3.lineTo(61.5f, 30.0f);
                instancePath3.lineTo(61.5f, 34.5f);
                instancePath3.lineTo(69.0f, 34.5f);
                instancePath3.lineTo(69.0f, 42.0f);
                instancePath3.lineTo(73.5f, 42.0f);
                instancePath3.lineTo(73.5f, 34.5f);
                instancePath3.lineTo(81.0f, 34.5f);
                instancePath3.lineTo(81.0f, 30.0f);
                instancePath3.lineTo(73.5f, 30.0f);
                instancePath3.lineTo(73.5f, 22.5f);
                instancePath3.lineTo(69.0f, 22.5f);
                instancePath3.lineTo(69.0f, 30.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint7);
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
