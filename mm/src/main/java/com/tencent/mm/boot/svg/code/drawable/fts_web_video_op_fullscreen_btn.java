package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fts_web_video_op_fullscreen_btn extends c {
    private final int height = 50;
    private final int width = 50;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 50;
            case 1:
                return 50;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -367.0f, 0.0f, 1.0f, -369.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 367.0f, 0.0f, 1.0f, 369.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(45.0f, 43.282814f);
                instancePath.lineTo(29.594316f, 27.877132f);
                instancePath.cubicTo(28.999725f, 27.28254f, 28.054962f, 27.287527f, 27.469177f, 27.873312f);
                instancePath.cubicTo(26.879307f, 28.463182f, 26.8851f, 29.410557f, 27.472996f, 29.998453f);
                instancePath.lineTo(43.474545f, 46.0f);
                instancePath.lineTo(29.50325f, 46.0f);
                instancePath.cubicTo(28.665436f, 46.0f, 28.0f, 46.671574f, 28.0f, 47.5f);
                instancePath.cubicTo(28.0f, 48.3342f, 28.673029f, 49.0f, 29.50325f, 49.0f);
                instancePath.lineTo(46.49675f, 49.0f);
                instancePath.cubicTo(46.49729f, 49.0f, 46.497833f, 49.0f, 46.498375f, 49.0f);
                instancePath.cubicTo(46.498917f, 49.0f, 46.49946f, 49.0f, 46.5f, 49.0f);
                instancePath.cubicTo(46.916557f, 49.0f, 47.291122f, 48.83218f, 47.561768f, 48.560772f);
                instancePath.cubicTo(47.834072f, 48.288242f, 48.0f, 47.913677f, 48.0f, 47.5f);
                instancePath.cubicTo(48.0f, 47.49946f, 48.0f, 47.498917f, 48.0f, 47.498375f);
                instancePath.cubicTo(48.0f, 47.497833f, 48.0f, 47.49729f, 48.0f, 47.49675f);
                instancePath.lineTo(48.0f, 30.50325f);
                instancePath.cubicTo(48.0f, 29.665436f, 47.328426f, 29.0f, 46.5f, 29.0f);
                instancePath.cubicTo(45.6658f, 29.0f, 45.0f, 29.673029f, 45.0f, 30.50325f);
                instancePath.lineTo(45.0f, 43.282814f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(3.0f, 5.3031335f);
                instancePath2.lineTo(18.595417f, 20.89855f);
                instancePath2.cubicTo(19.190008f, 21.493141f, 20.13477f, 21.488155f, 20.720556f, 20.902369f);
                instancePath2.cubicTo(21.310427f, 20.312498f, 21.304632f, 19.365126f, 20.716738f, 18.77723f);
                instancePath2.lineTo(4.939507f, 3.0f);
                instancePath2.lineTo(18.49675f, 3.0f);
                instancePath2.cubicTo(19.334564f, 3.0f, 20.0f, 2.328427f, 20.0f, 1.5f);
                instancePath2.cubicTo(20.0f, 0.66579723f, 19.326971f, 0.0f, 18.49675f, 0.0f);
                instancePath2.lineTo(1.5032506f, 0.0f);
                instancePath2.cubicTo(1.5027087f, 0.0f, 1.5021669f, 2.809642E-7f, 1.5016251f, 8.427533E-7f);
                instancePath2.cubicTo(1.5010837f, 2.840145E-7f, 1.5005419f, 0.0f, 1.5f, 0.0f);
                instancePath2.cubicTo(1.0863218f, 0.0f, 0.7117559f, 0.16592918f, 0.44039288f, 0.43639413f);
                instancePath2.cubicTo(0.16592893f, 0.71175647f, 0.0f, 1.0863222f, 0.0f, 1.5f);
                instancePath2.cubicTo(0.0f, 1.5005419f, 2.840145E-7f, 1.5010837f, 8.519021E-7f, 1.5016255f);
                instancePath2.cubicTo(2.809642E-7f, 1.5021669f, 0.0f, 1.5027087f, 0.0f, 1.5032506f);
                instancePath2.lineTo(0.0f, 18.49675f);
                instancePath2.cubicTo(0.0f, 19.326971f, 0.66579723f, 20.0f, 1.5f, 20.0f);
                instancePath2.cubicTo(2.328427f, 20.0f, 3.0f, 19.334564f, 3.0f, 18.49675f);
                instancePath2.lineTo(3.0f, 5.3031335f);
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
