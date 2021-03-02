package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class circle_notvisible extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-4144960);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(16.0f, 2.032928f);
                instancePath.cubicTo(21.182825f, -0.5018033f, 27.471985f, -0.5018033f, 32.973755f, 1.1269398f);
                instancePath.cubicTo(32.993687f, 7.4179597f, 33.033554f, 13.70898f, 32.94385f, 20.0f);
                instancePath.cubicTo(27.452051f, 14.116166f, 21.721043f, 8.446104f, 16.089703f, 2.6946049f);
                instancePath.lineTo(16.0f, 2.032928f);
                instancePath.lineTo(16.0f, 2.032928f);
                instancePath.lineTo(16.0f, 2.032928f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-4144960);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(35.044933f, 2.0f);
                instancePath2.cubicTo(40.505497f, 4.291358f, 45.505173f, 8.37037f, 48.0f, 13.723456f);
                instancePath2.cubicTo(44.0724f, 17.575308f, 40.054626f, 21.358025f, 36.297356f, 25.377777f);
                instancePath2.cubicTo(36.01681f, 25.535803f, 35.44571f, 25.851852f, 35.165165f, 26.0f);
                instancePath2.cubicTo(34.854565f, 18.019753f, 35.08501f, 10.0f, 35.044933f, 2.0f);
                instancePath2.lineTo(35.044933f, 2.0f);
                instancePath2.lineTo(35.044933f, 2.0f);
                instancePath2.lineTo(35.044933f, 2.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-4144960);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(2.0f, 15.985457f);
                instancePath3.cubicTo(4.3267527f, 10.500481f, 8.496777f, 5.326352f, 14.046737f, 3.0f);
                instancePath3.cubicTo(18.307413f, 7.3619103f, 22.638597f, 11.643602f, 27.0f, 15.905239f);
                instancePath3.cubicTo(18.670025f, 16.085732f, 10.329976f, 15.945349f, 2.0f, 15.985457f);
                instancePath3.lineTo(2.0f, 15.985457f);
                instancePath3.lineTo(2.0f, 15.985457f);
                instancePath3.lineTo(2.0f, 15.985457f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-4144960);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(49.04785f, 16.0f);
                instancePath4.cubicTo(50.593304f, 19.07393f, 50.989834f, 22.605059f, 51.0f, 26.0f);
                instancePath4.cubicTo(47.83793f, 24.025291f, 42.700947f, 24.778288f, 39.0f, 24.846382f);
                instancePath4.cubicTo(41.999393f, 22.443659f, 45.76377f, 17.663424f, 49.04785f, 16.0f);
                instancePath4.lineTo(49.04785f, 16.0f);
                instancePath4.lineTo(49.04785f, 16.0f);
                instancePath4.lineTo(49.04785f, 16.0f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-4144960);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(1.1269572f, 18.018436f);
                instancePath5.cubicTo(7.4145637f, 17.989225f, 13.712394f, 17.998962f, 20.0f, 18.018436f);
                instancePath5.cubicTo(13.988435f, 23.636763f, 8.05866f, 29.547205f, 2.036871f, 35.0f);
                instancePath5.cubicTo(-0.22257785f, 29.634838f, -0.7133179f, 23.558867f, 1.1269572f, 18.018436f);
                instancePath5.lineTo(1.1269572f, 18.018436f);
                instancePath5.lineTo(1.1269572f, 18.018436f);
                instancePath5.lineTo(1.1269572f, 18.018436f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 2);
                canvas.drawPath(instancePath5, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-4144960);
                Path instancePath6 = c.instancePath(looper);
                instancePath6.moveTo(3.0f, 36.980186f);
                instancePath6.cubicTo(7.3834877f, 32.72422f, 11.636574f, 28.336838f, 15.939815f, 24.0f);
                instancePath6.cubicTo(16.020061f, 32.329964f, 16.020061f, 40.670036f, 15.939815f, 49.0f);
                instancePath6.cubicTo(10.493055f, 46.67489f, 5.357253f, 42.520016f, 3.0f, 36.980186f);
                instancePath6.lineTo(3.0f, 36.980186f);
                instancePath6.lineTo(3.0f, 36.980186f);
                instancePath6.lineTo(3.0f, 36.980186f);
                instancePath6.close();
                WeChatSVGRenderC2Java.setFillType(instancePath6, 2);
                canvas.drawPath(instancePath6, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(-4144960);
                Path instancePath7 = c.instancePath(looper);
                instancePath7.moveTo(18.0f, 31.0f);
                instancePath7.cubicTo(21.24862f, 34.507523f, 24.574585f, 37.93347f, 27.832872f, 41.430798f);
                instancePath7.cubicTo(28.335636f, 44.612038f, 29.979282f, 47.487392f, 32.0f, 49.87332f);
                instancePath7.cubicTo(27.53315f, 51.514923f, 22.53453f, 51.229427f, 18.029005f, 49.87332f);
                instancePath7.cubicTo(17.990332f, 43.582214f, 18.05801f, 37.291107f, 18.0f, 31.0f);
                instancePath7.lineTo(18.0f, 31.0f);
                instancePath7.lineTo(18.0f, 31.0f);
                instancePath7.lineTo(18.0f, 31.0f);
                instancePath7.close();
                WeChatSVGRenderC2Java.setFillType(instancePath7, 2);
                canvas.drawPath(instancePath7, instancePaint9);
                canvas.restore();
                canvas.save();
                Paint instancePaint10 = c.instancePaint(instancePaint, looper);
                instancePaint10.setColor(-4802890);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 35.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint11 = c.instancePaint(instancePaint10, looper);
                Path instancePath8 = c.instancePath(looper);
                instancePath8.moveTo(4.0f, 0.0f);
                instancePath8.cubicTo(3.8556423f, 0.70270455f, 3.6088626f, 2.7718356f, 3.464505f, 3.47454f);
                instancePath8.lineTo(3.464505f, 4.0f);
                instancePath8.cubicTo(2.6973581f, 3.2509282f, 1.2236129f, 2.1375713f, 0.0f, 0.8100131f);
                instancePath8.cubicTo(1.2236129f, 0.5459965f, 2.3443978f, 0.22751628f, 4.0f, 0.0f);
                instancePath8.lineTo(4.0f, 0.0f);
                instancePath8.lineTo(4.0f, 0.0f);
                instancePath8.lineTo(4.0f, 0.0f);
                instancePath8.close();
                WeChatSVGRenderC2Java.setFillType(instancePath8, 2);
                canvas.drawPath(instancePath8, instancePaint11);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint12 = c.instancePaint(instancePaint, looper);
                instancePaint12.setColor(-1150121);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 28.0f, 0.0f, 1.0f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint13 = c.instancePaint(instancePaint12, looper);
                Path instancePath9 = c.instancePath(looper);
                instancePath9.moveTo(15.0f, 30.0f);
                instancePath9.cubicTo(23.284271f, 30.0f, 30.0f, 23.284271f, 30.0f, 15.0f);
                instancePath9.cubicTo(30.0f, 6.7157288f, 23.284271f, 0.0f, 15.0f, 0.0f);
                instancePath9.cubicTo(6.7157288f, 0.0f, 0.0f, 6.7157288f, 0.0f, 15.0f);
                instancePath9.cubicTo(0.0f, 23.284271f, 6.7157288f, 30.0f, 15.0f, 30.0f);
                instancePath9.lineTo(15.0f, 30.0f);
                instancePath9.lineTo(15.0f, 30.0f);
                instancePath9.lineTo(15.0f, 30.0f);
                instancePath9.close();
                instancePath9.moveTo(6.0f, 12.0f);
                instancePath9.lineTo(24.0f, 12.0f);
                instancePath9.lineTo(24.0f, 18.0f);
                instancePath9.lineTo(6.0f, 18.0f);
                instancePath9.lineTo(6.0f, 12.0f);
                instancePath9.lineTo(6.0f, 12.0f);
                instancePath9.lineTo(6.0f, 12.0f);
                instancePath9.close();
                WeChatSVGRenderC2Java.setFillType(instancePath9, 2);
                canvas.drawPath(instancePath9, instancePaint13);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}