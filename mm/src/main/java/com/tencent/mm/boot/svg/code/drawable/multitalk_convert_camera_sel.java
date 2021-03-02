package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.WebView;

public class multitalk_convert_camera_sel extends c {
    private final int height = TXLiveConstants.RENDER_ROTATION_180;
    private final int width = TXLiveConstants.RENDER_ROTATION_180;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return TXLiveConstants.RENDER_ROTATION_180;
            case 1:
                return TXLiveConstants.RENDER_ROTATION_180;
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
                canvas.saveLayerAlpha(null, 126, 31);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 30.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 30.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-855310);
                instancePaint4.setStrokeWidth(4.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(6.0097566f, 12.0f);
                instancePath.cubicTo(3.7951674f, 12.0f, 2.0f, 13.792681f, 2.0f, 16.000319f);
                instancePath.lineTo(2.0f, 54.999683f);
                instancePath.cubicTo(2.0f, 57.20863f, 3.789142f, 59.0f, 5.991014f, 59.0f);
                instancePath.lineTo(72.00899f, 59.0f);
                instancePath.cubicTo(74.21183f, 59.0f, 76.0f, 57.208717f, 76.0f, 54.999683f);
                instancePath.lineTo(76.0f, 16.000319f);
                instancePath.cubicTo(76.0f, 13.79181f, 74.205315f, 12.0f, 71.99024f, 12.0f);
                instancePath.lineTo(57.5f, 12.0f);
                instancePath.lineTo(51.196438f, 3.5952492f);
                instancePath.cubicTo(50.5825f, 2.7766662f, 49.029545f, 2.0f, 48.00891f, 2.0f);
                instancePath.lineTo(29.99109f, 2.0f);
                instancePath.cubicTo(28.967781f, 2.0f, 27.419127f, 2.7744992f, 26.803562f, 3.5952492f);
                instancePath.lineTo(20.5f, 12.0f);
                instancePath.lineTo(6.0097566f, 12.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-855310);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(6.0f, 2.0f);
                instancePath2.lineTo(16.0f, 2.0f);
                instancePath2.lineTo(16.0f, 6.0f);
                instancePath2.lineTo(6.0f, 6.0f);
                instancePath2.lineTo(6.0f, 2.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-855310);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(21.0f, 33.0f);
                instancePath3.lineTo(15.0f, 33.0f);
                instancePath3.lineTo(23.25f, 24.75f);
                instancePath3.lineTo(31.5f, 33.0f);
                instancePath3.lineTo(25.0f, 33.0f);
                instancePath3.cubicTo(25.0f, 40.731987f, 31.268013f, 47.0f, 39.0f, 47.0f);
                instancePath3.cubicTo(42.931446f, 47.0f, 46.484406f, 45.379486f, 49.027344f, 42.769985f);
                instancePath3.lineTo(51.855957f, 45.598595f);
                instancePath3.cubicTo(48.588997f, 48.93187f, 44.03602f, 51.0f, 39.0f, 51.0f);
                instancePath3.cubicTo(29.058874f, 51.0f, 21.0f, 42.941124f, 21.0f, 33.0f);
                instancePath3.close();
                instancePath3.moveTo(57.0f, 33.0f);
                instancePath3.lineTo(63.0f, 33.0f);
                instancePath3.lineTo(54.75f, 41.25f);
                instancePath3.lineTo(46.5f, 33.0f);
                instancePath3.lineTo(53.0f, 33.0f);
                instancePath3.cubicTo(53.0f, 25.268013f, 46.731987f, 19.0f, 39.0f, 19.0f);
                instancePath3.cubicTo(35.068554f, 19.0f, 31.515596f, 20.620514f, 28.972656f, 23.230017f);
                instancePath3.lineTo(26.144045f, 20.401403f);
                instancePath3.cubicTo(29.411005f, 17.068129f, 33.96398f, 15.0f, 39.0f, 15.0f);
                instancePath3.cubicTo(48.941124f, 15.0f, 57.0f, 23.058874f, 57.0f, 33.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
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
