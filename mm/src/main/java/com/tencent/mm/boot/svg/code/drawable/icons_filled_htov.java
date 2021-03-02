package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_htov extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                instancePaint5.setColor(-1);
                instancePaint5.setStrokeWidth(0.675f);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, -1.8369701E-16f, -1.0f, 16.16056f, 1.0f, -1.8369701E-16f, -10.6084385f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.3845f, 4.2142153f);
                instancePath.lineTo(15.369f, 1.3379067f);
                instancePath.lineTo(11.4f, 1.3379067f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(-1);
                instancePaint6.setStrokeWidth(1.575f);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 0.9702957f, 0.2419219f, -0.87977695f, -0.2419219f, 0.9702957f, 4.3332386f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(19.719938f, 9.55595f);
                instancePath2.cubicTo(19.827131f, 9.099741f, 19.883839f, 8.624069f, 19.883839f, 8.135153f);
                instancePath2.cubicTo(19.883839f, 5.2303686f, 17.882187f, 2.7930944f, 15.182953f, 2.127401f);
                instancePath2.cubicTo(14.70674f, 2.0099561f, 14.538718f, 1.9110398f, 14.527783f, 1.9518491f);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                instancePaint7.setColor(-1);
                instancePaint7.setStrokeWidth(1.575f);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(6.75f, 8.764431f);
                instancePath3.cubicTo(6.75f, 8.14311f, 7.2536798f, 7.639431f, 7.875f, 7.639431f);
                instancePath3.lineTo(14.85f, 7.639431f);
                instancePath3.cubicTo(15.471321f, 7.639431f, 15.975f, 8.14311f, 15.975f, 8.764431f);
                instancePath3.lineTo(15.975f, 20.68943f);
                instancePath3.cubicTo(15.975f, 21.310751f, 15.471321f, 21.81443f, 14.85f, 21.81443f);
                instancePath3.lineTo(7.875f, 21.81443f);
                instancePath3.cubicTo(7.2536798f, 21.81443f, 6.75f, 21.310751f, 6.75f, 20.68943f);
                instancePath3.lineTo(6.75f, 8.764431f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-1);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(11.3625f, 17.78f);
                instancePath4.cubicTo(11.914785f, 17.78f, 12.3625f, 18.227716f, 12.3625f, 18.78f);
                instancePath4.cubicTo(12.3625f, 19.332285f, 11.914785f, 19.78f, 11.3625f, 19.78f);
                instancePath4.cubicTo(10.810215f, 19.78f, 10.3625f, 19.332285f, 10.3625f, 18.78f);
                instancePath4.cubicTo(10.3625f, 18.227716f, 10.810215f, 17.78f, 11.3625f, 17.78f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint8);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
