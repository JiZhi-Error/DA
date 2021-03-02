package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class voicesearch_btnbg_pressed extends c {
    private final int height = 268;
    private final int width = 268;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 268;
            case 1:
                return 268;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 9.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-2763307);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(18.457394f, 1.6814522f);
                instancePath.cubicTo(20.597382f, 1.1715016f, 22.80737f, 1.0515132f, 24.997356f, 1.0215161f);
                instancePath.lineTo(217.01625f, 1.0215161f);
                instancePath.cubicTo(222.21622f, 1.0515132f, 227.63618f, 0.6115558f, 232.57616f, 2.6113622f);
                instancePath.cubicTo(241.65611f, 5.9810357f, 248.11607f, 15.270136f, 247.98607f, 24.979197f);
                instancePath.cubicTo(247.99606f, 91.65274f, 248.01607f, 158.32628f, 247.97607f, 224.99982f);
                instancePath.cubicTo(248.32607f, 237.78859f, 236.85614f, 249.29747f, 224.05621f, 248.97751f);
                instancePath.cubicTo(157.3666f, 249.00749f, 90.68697f, 249.00749f, 23.997362f, 248.97751f);
                instancePath.cubicTo(11.187435f, 249.32747f, -0.29249832f, 237.84859f, 0.007499957f, 225.04982f);
                instancePath.cubicTo(-0.0024999855f, 158.36627f, -0.0024999855f, 91.67274f, 0.007499957f, 24.989195f);
                instancePath.cubicTo(-0.18249895f, 14.170242f, 7.9174542f, 4.0112267f, 18.457394f, 1.6814522f);
                instancePath.lineTo(18.457394f, 1.6814522f);
                instancePath.close();
                instancePath.moveTo(19.43778f, 4.5597763f);
                instancePath.cubicTo(10.841597f, 6.329068f, 3.8147154f, 14.165934f, 3.2149816f, 22.95242f);
                instancePath.cubicTo(2.83515f, 27.65054f, 3.0850391f, 32.368652f, 3.0550525f, 37.066772f);
                instancePath.cubicTo(3.0550525f, 96.02319f, 3.0550525f, 154.96962f, 3.0450568f, 213.91603f);
                instancePath.cubicTo(3.0850391f, 218.58417f, 2.7951677f, 223.28229f, 3.314937f, 227.94043f);
                instancePath.cubicTo(4.0745997f, 234.84767f, 8.882466f, 240.93523f, 15.039733f, 243.95403f);
                instancePath.cubicTo(20.627253f, 246.66293f, 27.014418f, 245.86327f, 33.02175f, 245.96323f);
                instancePath.cubicTo(93.67483f, 245.93323f, 154.3379f, 245.93323f, 214.99098f, 245.96323f);
                instancePath.cubicTo(220.98833f, 245.86327f, 227.37549f, 246.64294f, 232.96301f, 243.95403f);
                instancePath.cubicTo(240.10983f, 240.52539f, 245.09763f, 232.94843f, 244.9277f, 224.94164f);
                instancePath.cubicTo(244.99767f, 160.97722f, 244.8977f, 97.012794f, 244.97768f, 33.04838f);
                instancePath.cubicTo(244.9077f, 27.570572f, 245.50745f, 21.792883f, 243.22845f, 16.634947f);
                instancePath.cubicTo(239.9599f, 9.177929f, 232.16336f, 3.890044f, 223.947f, 4.059976f);
                instancePath.cubicTo(157.98628f, 3.980008f, 92.025566f, 4.09996f, 26.06484f, 4.0f);
                instancePath.cubicTo(23.845825f, 4.039984f, 21.616814f, 4.129948f, 19.43778f, 4.5597763f);
                instancePath.lineTo(19.43778f, 4.5597763f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1842205);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(17.43778f, 1.5597761f);
                instancePath2.cubicTo(19.616814f, 1.129948f, 21.845825f, 1.039984f, 24.06484f, 1.0f);
                instancePath2.cubicTo(90.025566f, 1.09996f, 155.98628f, 0.980008f, 221.947f, 1.059976f);
                instancePath2.cubicTo(230.16336f, 0.890044f, 237.9599f, 6.177929f, 241.22845f, 13.634946f);
                instancePath2.cubicTo(243.50745f, 18.792883f, 242.9077f, 24.570572f, 242.97768f, 30.048382f);
                instancePath2.cubicTo(242.8977f, 94.012794f, 242.99767f, 157.97722f, 242.9277f, 221.94164f);
                instancePath2.cubicTo(243.09763f, 229.94843f, 238.10983f, 237.52539f, 230.96301f, 240.95403f);
                instancePath2.cubicTo(225.37549f, 243.64294f, 218.98833f, 242.86327f, 212.99098f, 242.96323f);
                instancePath2.cubicTo(152.3379f, 242.93323f, 91.67483f, 242.93323f, 31.021751f, 242.96323f);
                instancePath2.cubicTo(25.014418f, 242.86327f, 18.627253f, 243.66293f, 13.039733f, 240.95403f);
                instancePath2.cubicTo(6.882466f, 237.93523f, 2.0746f, 231.84767f, 1.3149371f, 224.94043f);
                instancePath2.cubicTo(0.7951678f, 220.28229f, 1.0850391f, 215.58417f, 1.0450569f, 210.91603f);
                instancePath2.cubicTo(1.0550524f, 151.96962f, 1.0550524f, 93.02319f, 1.0550524f, 34.066772f);
                instancePath2.cubicTo(1.0850391f, 29.368652f, 0.83515006f, 24.65054f, 1.2149814f, 19.95242f);
                instancePath2.cubicTo(1.8147153f, 11.165934f, 8.841597f, 3.3290684f, 17.43778f, 1.5597761f);
                instancePath2.lineTo(17.43778f, 1.5597761f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
