package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class voiceinput_icon_button extends c {
    private final int height = 189;
    private final int width = 189;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 189;
            case 1:
                return 189;
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
                instancePaint3.setColor(-16268960);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(94.5f, 0.0f);
                instancePath.cubicTo(146.69092f, 0.0f, 189.0f, 42.30909f, 189.0f, 94.5f);
                instancePath.cubicTo(189.0f, 146.69092f, 146.69092f, 189.0f, 94.5f, 189.0f);
                instancePath.cubicTo(42.30909f, 189.0f, 0.0f, 146.69092f, 0.0f, 94.5f);
                instancePath.cubicTo(0.0f, 42.30909f, 42.30909f, 0.0f, 94.5f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 44.5f, 0.0f, 1.0f, 39.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 0.8660254f, -0.5f, 46.36397f, 0.5f, 0.8660254f, 0.12389612f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(14.281093f, 17.051855f);
                instancePath2.cubicTo(14.281093f, 7.8682823f, 21.725847f, 0.4235266f, 30.90942f, 0.4235266f);
                instancePath2.lineTo(30.909422f, 0.4235266f);
                instancePath2.cubicTo(40.092995f, 0.4235266f, 47.53775f, 7.8682823f, 47.53775f, 17.051855f);
                instancePath2.lineTo(47.53775f, 43.997627f);
                instancePath2.cubicTo(47.53775f, 53.1812f, 40.092995f, 60.625954f, 30.909422f, 60.625954f);
                instancePath2.lineTo(30.90942f, 60.625954f);
                instancePath2.cubicTo(21.725847f, 60.625954f, 14.281093f, 53.1812f, 14.281093f, 43.997627f);
                instancePath2.lineTo(14.281093f, 17.051855f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(7.629761f, 33.86932f);
                instancePath3.lineTo(7.629761f, 44.035454f);
                instancePath3.cubicTo(7.629761f, 56.892452f, 18.05242f, 67.31511f, 30.90942f, 67.31511f);
                instancePath3.cubicTo(43.76642f, 67.31511f, 54.18908f, 56.892452f, 54.18908f, 44.035454f);
                instancePath3.lineTo(54.18908f, 33.86932f);
                instancePath3.lineTo(60.84041f, 33.86932f);
                instancePath3.lineTo(60.84041f, 44.07328f);
                instancePath3.cubicTo(60.84041f, 60.60371f, 47.43985f, 74.00427f, 30.90942f, 74.00427f);
                instancePath3.cubicTo(14.378991f, 74.00427f, 0.97843033f, 60.60371f, 0.97843033f, 44.07328f);
                instancePath3.lineTo(0.97843033f, 33.86932f);
                instancePath3.lineTo(7.629761f, 33.86932f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint5, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(27.583754f, 70.65969f);
                instancePath4.lineTo(34.235085f, 70.65969f);
                instancePath4.lineTo(34.235085f, 80.69343f);
                instancePath4.lineTo(27.583754f, 80.69343f);
                instancePath4.lineTo(27.583754f, 70.65969f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint5, looper);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(27.583754f, 84.03801f);
                instancePath5.lineTo(34.235085f, 84.03801f);
                instancePath5.lineTo(31.560646f, 90.28269f);
                instancePath5.cubicTo(31.406612f, 90.64236f, 30.99018f, 90.80905f, 30.630516f, 90.655014f);
                instancePath5.cubicTo(30.463182f, 90.58335f, 30.329857f, 90.45002f, 30.258192f, 90.28269f);
                instancePath5.lineTo(27.583754f, 84.03801f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 2);
                canvas.drawPath(instancePath5, instancePaint9);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
