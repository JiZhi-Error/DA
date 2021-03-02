package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ofm_camera_icon extends c {
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 21.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(51.362026f, 6.0f);
                instancePath.lineTo(61.99543f, 6.0f);
                instancePath.cubicTo(64.20043f, 6.0f, 66.0f, 7.7952905f, 66.0f, 10.009893f);
                instancePath.lineTo(66.0f, 49.99011f);
                instancePath.cubicTo(66.0f, 52.205948f, 64.20709f, 54.0f, 61.99543f, 54.0f);
                instancePath.lineTo(4.0045705f, 54.0f);
                instancePath.cubicTo(1.7995698f, 54.0f, 0.0f, 52.20471f, 0.0f, 49.99011f);
                instancePath.lineTo(0.0f, 10.009893f);
                instancePath.cubicTo(0.0f, 7.7940526f, 1.7929074f, 6.0f, 4.0045705f, 6.0f);
                instancePath.lineTo(14.637975f, 6.0f);
                instancePath.lineTo(21.0f, 0.0f);
                instancePath.lineTo(45.0f, 0.0f);
                instancePath.lineTo(51.362026f, 6.0f);
                instancePath.lineTo(51.362026f, 6.0f);
                instancePath.close();
                instancePath.moveTo(33.0f, 48.0f);
                instancePath.cubicTo(44.045696f, 48.0f, 53.0f, 39.045696f, 53.0f, 28.0f);
                instancePath.cubicTo(53.0f, 16.954306f, 44.045696f, 8.0f, 33.0f, 8.0f);
                instancePath.cubicTo(21.954306f, 8.0f, 13.0f, 16.954306f, 13.0f, 28.0f);
                instancePath.cubicTo(13.0f, 39.045696f, 21.954306f, 48.0f, 33.0f, 48.0f);
                instancePath.lineTo(33.0f, 48.0f);
                instancePath.close();
                instancePath.moveTo(33.0f, 41.0f);
                instancePath.cubicTo(40.179703f, 41.0f, 46.0f, 35.179703f, 46.0f, 28.0f);
                instancePath.cubicTo(46.0f, 20.8203f, 40.179703f, 15.0f, 33.0f, 15.0f);
                instancePath.cubicTo(25.8203f, 15.0f, 20.0f, 20.8203f, 20.0f, 28.0f);
                instancePath.cubicTo(20.0f, 35.179703f, 25.8203f, 41.0f, 33.0f, 41.0f);
                instancePath.lineTo(33.0f, 41.0f);
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
