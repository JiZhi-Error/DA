package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class connectkeyboad_banner_icon_pclock extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-9473160);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 17.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(45.0513f, 58.846f);
                instancePath.lineTo(48.5133f, 60.0f);
                instancePath.lineTo(32.4863f, 60.0f);
                instancePath.lineTo(35.9483f, 58.846f);
                instancePath.lineTo(38.0003f, 58.162f);
                instancePath.lineTo(38.0003f, 56.0f);
                instancePath.lineTo(38.0003f, 52.0f);
                instancePath.lineTo(43.0003f, 52.0f);
                instancePath.lineTo(43.0003f, 56.0f);
                instancePath.lineTo(43.0003f, 58.162f);
                instancePath.lineTo(45.0513f, 58.846f);
                instancePath.close();
                instancePath.moveTo(35.0003f, 49.0f);
                instancePath.lineTo(3.0003f, 49.0f);
                instancePath.lineTo(3.0003f, 3.0f);
                instancePath.lineTo(77.0003f, 3.0f);
                instancePath.lineTo(77.0003f, 29.0f);
                instancePath.lineTo(80.0003f, 29.0f);
                instancePath.lineTo(80.0003f, 2.87f);
                instancePath.cubicTo(80.0003f, 1.285f, 78.7143f, 0.0f, 77.1293f, 0.0f);
                instancePath.lineTo(2.8713f, 0.0f);
                instancePath.cubicTo(1.2893f, 0.0f, 3.0E-4f, 1.285f, 3.0E-4f, 2.87f);
                instancePath.lineTo(3.0E-4f, 49.13f);
                instancePath.cubicTo(3.0E-4f, 50.715f, 1.2853f, 52.0f, 2.8713f, 52.0f);
                instancePath.lineTo(35.0003f, 52.0f);
                instancePath.lineTo(35.0003f, 56.0f);
                instancePath.lineTo(23.0003f, 60.0f);
                instancePath.lineTo(23.0003f, 63.0f);
                instancePath.lineTo(58.0003f, 63.0f);
                instancePath.lineTo(58.0003f, 60.0f);
                instancePath.lineTo(46.0003f, 56.0f);
                instancePath.lineTo(46.0003f, 52.0f);
                instancePath.lineTo(59.0003f, 52.0f);
                instancePath.lineTo(59.0003f, 49.0f);
                instancePath.lineTo(46.0003f, 49.0f);
                instancePath.lineTo(35.0003f, 49.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 60.0f, 0.0f, 1.0f, 30.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(25.5f, 28.6132f);
                instancePath2.cubicTo(25.5f, 29.3782f, 24.881f, 30.0002f, 24.132f, 30.0002f);
                instancePath2.lineTo(4.868f, 30.0002f);
                instancePath2.cubicTo(4.11f, 30.0002f, 3.5f, 29.3872f, 3.5f, 28.6132f);
                instancePath2.lineTo(3.5f, 14.3872f);
                instancePath2.cubicTo(3.5f, 13.6222f, 4.119f, 13.0002f, 4.868f, 13.0002f);
                instancePath2.lineTo(24.132f, 13.0002f);
                instancePath2.cubicTo(24.89f, 13.0002f, 25.5f, 13.6122f, 25.5f, 14.3872f);
                instancePath2.lineTo(25.5f, 28.6132f);
                instancePath2.close();
                instancePath2.moveTo(9.0f, 5.4992f);
                instancePath2.cubicTo(9.0f, 4.3952f, 9.9f, 3.5002f, 10.992f, 3.5002f);
                instancePath2.lineTo(18.008f, 3.5002f);
                instancePath2.cubicTo(19.108f, 3.5002f, 20.0f, 4.3872f, 20.0f, 5.4992f);
                instancePath2.lineTo(20.0f, 10.0002f);
                instancePath2.lineTo(9.0f, 10.0002f);
                instancePath2.lineTo(9.0f, 5.4992f);
                instancePath2.close();
                instancePath2.moveTo(24.132f, 10.0002f);
                instancePath2.lineTo(23.0f, 10.0002f);
                instancePath2.lineTo(23.0f, 6.2542f);
                instancePath2.cubicTo(23.0f, 3.0742f, 20.423f, 0.5002f, 17.245f, 0.5002f);
                instancePath2.lineTo(11.755f, 0.5002f);
                instancePath2.cubicTo(8.582f, 0.5002f, 6.0f, 3.0762f, 6.0f, 6.2542f);
                instancePath2.lineTo(6.0f, 10.0002f);
                instancePath2.lineTo(4.868f, 10.0002f);
                instancePath2.cubicTo(2.459f, 10.0002f, 0.5f, 11.9682f, 0.5f, 14.3872f);
                instancePath2.lineTo(0.5f, 28.6132f);
                instancePath2.cubicTo(0.5f, 31.0422f, 2.45f, 33.0002f, 4.868f, 33.0002f);
                instancePath2.lineTo(24.132f, 33.0002f);
                instancePath2.cubicTo(26.541f, 33.0002f, 28.5f, 31.0322f, 28.5f, 28.6132f);
                instancePath2.lineTo(28.5f, 14.3872f);
                instancePath2.cubicTo(28.5f, 11.9582f, 26.55f, 10.0002f, 24.132f, 10.0002f);
                instancePath2.lineTo(24.132f, 10.0002f);
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
