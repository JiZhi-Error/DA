package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class delete_icon_sel extends c {
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
                instancePaint3.setColor(-1686720);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 10.5f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.207434f, 22.39999f);
                instancePath.lineTo(16.05067f, 70.166374f);
                instancePath.cubicTo(16.138716f, 71.64553f, 17.363943f, 72.8f, 18.845724f, 72.8f);
                instancePath.lineTo(44.154278f, 72.8f);
                instancePath.cubicTo(45.636055f, 72.8f, 46.861286f, 71.64553f, 46.94933f, 70.166374f);
                instancePath.lineTo(49.792564f, 22.39999f);
                instancePath.lineTo(13.207434f, 22.39999f);
                instancePath.close();
                instancePath.moveTo(8.75f, 18.19999f);
                instancePath.lineTo(54.25f, 18.19999f);
                instancePath.lineTo(51.14191f, 70.41593f);
                instancePath.cubicTo(50.921795f, 74.11384f, 47.858727f, 77.0f, 44.154278f, 77.0f);
                instancePath.lineTo(18.845724f, 77.0f);
                instancePath.cubicTo(15.141274f, 77.0f, 12.078204f, 74.11384f, 11.858091f, 70.41593f);
                instancePath.lineTo(8.75f, 18.19999f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 0.98162717f, -0.190809f, 3.6336305f, 0.190809f, 0.98162717f, 0.028710395f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(3.5f, 7.6999893f);
                instancePath2.lineTo(59.5f, 7.6999893f);
                instancePath2.cubicTo(60.4665f, 7.6999893f, 61.25f, 8.483491f, 61.25f, 9.449989f);
                instancePath2.lineTo(61.25f, 11.899989f);
                instancePath2.lineTo(1.75f, 11.899989f);
                instancePath2.lineTo(1.75f, 9.449989f);
                instancePath2.cubicTo(1.75f, 8.483491f, 2.5335016f, 7.6999893f, 3.5f, 7.6999893f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(38.5f, 9.549949E-5f);
                instancePath3.cubicTo(39.4665f, 9.549949E-5f, 40.25f, 0.7835972f, 40.25f, 1.7500955f);
                instancePath3.lineTo(40.25f, 4.2000847f);
                instancePath3.lineTo(22.75f, 4.2000847f);
                instancePath3.lineTo(22.75f, 1.7500955f);
                instancePath3.cubicTo(22.75f, 0.7835972f, 23.533503f, 9.549949E-5f, 24.5f, 9.549949E-5f);
                instancePath3.lineTo(38.5f, 9.549949E-5f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(22.75f, 31.5f);
                instancePath4.lineTo(26.950043f, 31.5f);
                instancePath4.lineTo(28.700043f, 63.0f);
                instancePath4.lineTo(24.5f, 63.0f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(36.049957f, 31.5f);
                instancePath5.lineTo(40.25f, 31.5f);
                instancePath5.lineTo(38.5f, 63.0f);
                instancePath5.lineTo(34.299957f, 63.0f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath5, 2);
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
