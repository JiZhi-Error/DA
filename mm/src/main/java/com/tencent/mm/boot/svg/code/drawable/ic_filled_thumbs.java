package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ic_filled_thumbs extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -16.0f, 0.0f, 1.0f, -100.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 88.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 9.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-526345);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 4.0f);
                instancePath.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                instancePath.lineTo(44.0f, 0.0f);
                instancePath.cubicTo(46.20914f, 0.0f, 48.0f, 1.7908609f, 48.0f, 4.0f);
                instancePath.lineTo(48.0f, 44.0f);
                instancePath.cubicTo(48.0f, 46.20914f, 46.20914f, 48.0f, 44.0f, 48.0f);
                instancePath.lineTo(4.0f, 48.0f);
                instancePath.cubicTo(1.7908609f, 48.0f, 0.0f, 46.20914f, 0.0f, 44.0f);
                instancePath.lineTo(0.0f, 4.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-15616);
                float[] matrixFloatArray5 = c.setMatrixFloatArray(matrixFloatArray4, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 8.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray5);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(20.361448f, 5.9526453f);
                instancePath2.cubicTo(21.126657f, 7.079886f, 21.332129f, 8.269144f, 21.332129f, 10.7692995f);
                instancePath2.cubicTo(21.332129f, 11.451479f, 21.149721f, 11.621433f, 21.3936f, 12.051712f);
                instancePath2.cubicTo(21.906f, 12.060102f, 24.500208f, 12.234269f, 25.209095f, 12.490161f);
                instancePath2.cubicTo(26.089422f, 12.807939f, 26.764603f, 13.31892f, 27.107843f, 14.083771f);
                instancePath2.cubicTo(28.332994f, 16.8138f, 26.794872f, 24.18185f, 23.91739f, 26.550528f);
                instancePath2.cubicTo(23.054035f, 27.261503f, 21.303766f, 27.174044f, 19.963612f, 27.283785f);
                instancePath2.cubicTo(19.332603f, 27.33533f, 16.736202f, 27.342722f, 12.207496f, 27.322222f);
                instancePath2.lineTo(12.207098f, 13.847586f);
                instancePath2.cubicTo(12.405709f, 13.748565f, 12.629142f, 13.6238365f, 12.900377f, 13.464798f);
                instancePath2.cubicTo(13.686465f, 13.003915f, 14.149695f, 12.480839f, 14.49743f, 11.561347f);
                instancePath2.cubicTo(14.694043f, 11.0406475f, 14.760807f, 10.529837f, 14.832299f, 9.018408f);
                instancePath2.cubicTo(14.841782f, 8.818275f, 14.8441515f, 8.755302f, 14.860264f, 8.300997f);
                instancePath2.cubicTo(14.933334f, 6.240632f, 15.151803f, 5.5065355f, 16.292877f, 4.9766397f);
                instancePath2.cubicTo(17.817902f, 4.268352f, 19.63964f, 4.8891153f, 20.361448f, 5.9526453f);
                instancePath2.close();
                instancePath2.moveTo(10.7071085f, 14.278362f);
                instancePath2.lineTo(10.707365f, 27.314808f);
                instancePath2.cubicTo(9.635487f, 27.309116f, 8.472677f, 27.30219f, 7.219274f, 27.294199f);
                instancePath2.cubicTo(6.1555815f, 27.287859f, 5.2941175f, 26.433678f, 5.2941175f, 25.375988f);
                instancePath2.lineTo(5.2941175f, 16.275349f);
                instancePath2.cubicTo(5.2941175f, 15.213089f, 6.1652064f, 14.357124f, 7.233762f, 14.357124f);
                instancePath2.lineTo(9.577086f, 14.357124f);
                instancePath2.cubicTo(9.956631f, 14.357124f, 10.32018f, 14.333967f, 10.7071085f, 14.278362f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
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
