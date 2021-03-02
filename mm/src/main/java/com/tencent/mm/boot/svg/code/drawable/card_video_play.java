package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class card_video_play extends c {
    private final int height = 69;
    private final int width = 69;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 69;
            case 1:
                return 69;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -66.0f, 0.0f, 1.0f, -459.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 72.0f, 0.0f, 1.0f, 465.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                instancePaint4.setStrokeWidth(3.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(28.5f, 1.5f);
                instancePath.cubicTo(43.41169f, 1.5f, 55.5f, 13.588311f, 55.5f, 28.5f);
                instancePath.cubicTo(55.5f, 43.41169f, 43.41169f, 55.5f, 28.5f, 55.5f);
                instancePath.cubicTo(13.588311f, 55.5f, 1.5f, 43.41169f, 1.5f, 28.5f);
                instancePath.cubicTo(1.5f, 13.588311f, 13.588311f, 1.5f, 28.5f, 1.5f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(39.81111f, 30.250793f);
                instancePath2.lineTo(23.24421f, 39.717594f);
                instancePath2.lineTo(23.24421f, 39.717594f);
                instancePath2.cubicTo(22.524933f, 40.12861f, 21.60865f, 39.878716f, 21.197636f, 39.15944f);
                instancePath2.cubicTo(21.068123f, 38.932793f, 21.0f, 38.67627f, 21.0f, 38.41523f);
                instancePath2.lineTo(21.0f, 18.692726f);
                instancePath2.lineTo(21.0f, 18.692726f);
                instancePath2.cubicTo(21.0f, 17.8643f, 21.671574f, 17.192726f, 22.5f, 17.192726f);
                instancePath2.cubicTo(22.778942f, 17.192726f, 23.052357f, 17.270508f, 23.289532f, 17.41733f);
                instancePath2.lineTo(39.856434f, 27.67303f);
                instancePath2.lineTo(39.856434f, 27.67303f);
                instancePath2.cubicTo(40.560818f, 28.109077f, 40.778347f, 29.033579f, 40.3423f, 29.73796f);
                instancePath2.cubicTo(40.21073f, 29.950493f, 40.028137f, 30.126778f, 39.81111f, 30.250793f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
