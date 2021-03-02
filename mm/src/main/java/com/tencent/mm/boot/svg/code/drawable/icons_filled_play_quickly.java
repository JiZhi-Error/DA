package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_play_quickly extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(28.0f, 0.0f);
                instancePath.lineTo(28.0f, 28.0f);
                instancePath.lineTo(0.0f, 28.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 1.866667f, 0.0f, 1.0f, 4.2f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(23.299828f, 10.403306f);
                instancePath2.lineTo(10.333587f, 19.424025f);
                instancePath2.cubicTo(10.104387f, 19.58348f, 9.789319f, 19.526941f, 9.629864f, 19.297743f);
                instancePath2.cubicTo(9.57091f, 19.213003f, 9.53931f, 19.11225f, 9.53931f, 19.009022f);
                instancePath2.lineTo(9.53931f, 0.96758646f);
                instancePath2.cubicTo(9.53931f, 0.68837583f, 9.7656555f, 0.4620309f, 10.044866f, 0.4620309f);
                instancePath2.cubicTo(10.148094f, 0.4620309f, 10.248848f, 0.49363106f, 10.333587f, 0.5525841f);
                instancePath2.lineTo(23.299828f, 9.573301f);
                instancePath2.cubicTo(23.529028f, 9.732758f, 23.585566f, 10.047825f, 23.42611f, 10.277024f);
                instancePath2.cubicTo(23.391844f, 10.326279f, 23.349083f, 10.36904f, 23.299828f, 10.403306f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(10.894444f, 12.605559f);
                instancePath3.lineTo(0.78885674f, 19.442877f);
                instancePath3.cubicTo(0.55760384f, 19.59934f, 0.24329802f, 19.538712f, 0.08683508f, 19.307459f);
                instancePath3.cubicTo(0.030244356f, 19.223816f, 4.564566E-16f, 19.125143f, 4.440892E-16f, 19.024157f);
                instancePath3.lineTo(0.0f, 0.9634772f);
                instancePath3.cubicTo(-3.419344E-17f, 0.68426657f, 0.22634493f, 0.45792165f, 0.50555557f, 0.45792165f);
                instancePath3.cubicTo(0.6081804f, 0.45792165f, 0.70837504f, 0.48915398f, 0.7928226f, 0.5474675f);
                instancePath3.lineTo(10.894444f, 7.522937f);
                instancePath3.lineTo(10.894444f, 12.605559f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
