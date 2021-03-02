package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_beautybox extends c {
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                canvas.saveLayerAlpha(null, 230, 31);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, -1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, -3.0f, 0.0f, 1.0f, -7.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 3.176129f, 0.0f, 1.0f, 3.770538f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 0.70710677f, -0.70710677f, 16.63875f, 0.70710677f, 0.70710677f, 1.9102435f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(5.113539f, 18.737814f);
                instancePath.lineTo(5.9902315f, 18.26233f);
                instancePath.lineTo(6.913476f, 18.752909f);
                instancePath.lineTo(6.913476f, 23.417412f);
                instancePath.cubicTo(6.913476f, 23.638325f, 6.73439f, 23.817411f, 6.513476f, 23.817411f);
                instancePath.cubicTo(6.5123577f, 23.817411f, 6.5112395f, 23.817406f, 6.5101213f, 23.817396f);
                instancePath.lineTo(5.510185f, 23.809011f);
                instancePath.cubicTo(5.2905874f, 23.807169f, 5.113539f, 23.62863f, 5.113539f, 23.409025f);
                instancePath.lineTo(5.113539f, 18.737814f);
                instancePath.lineTo(5.113539f, 18.737814f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray5 = c.setMatrixFloatArray(matrixFloatArray4, 0.70710677f, -0.70710677f, 13.542466f, 0.70710677f, 0.70710677f, -5.5649147f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray5);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(13.488614f, 19.899393f);
                instancePath2.lineTo(8.816449f, 22.355698f);
                instancePath2.cubicTo(8.327604f, 22.612698f, 7.722977f, 22.424751f, 7.465976f, 21.935907f);
                instancePath2.cubicTo(7.363637f, 21.741245f, 7.3283224f, 21.518278f, 7.3654995f, 21.301521f);
                instancePath2.lineTo(8.257804f, 16.098988f);
                instancePath2.lineTo(4.477942f, 12.414534f);
                instancePath2.cubicTo(4.0824585f, 12.029032f, 4.074366f, 11.395919f, 4.4598675f, 11.000435f);
                instancePath2.cubicTo(4.613376f, 10.842952f, 4.8145185f, 10.740464f, 5.0321555f, 10.70884f);
                instancePath2.lineTo(10.2557955f, 9.9498005f);
                instancePath2.lineTo(12.591878f, 5.2163796f);
                instancePath2.cubicTo(12.836301f, 4.721126f, 13.435926f, 4.517787f, 13.93118f, 4.7622094f);
                instancePath2.cubicTo(14.128392f, 4.8595395f, 14.28802f, 5.019167f, 14.38535f, 5.2163796f);
                instancePath2.lineTo(16.721434f, 9.9498005f);
                instancePath2.lineTo(21.945074f, 10.70884f);
                instancePath2.cubicTo(22.491617f, 10.788258f, 22.8703f, 11.2957f, 22.790882f, 11.842245f);
                instancePath2.cubicTo(22.759258f, 12.059882f, 22.65677f, 12.261024f, 22.499287f, 12.414534f);
                instancePath2.lineTo(18.719425f, 16.098988f);
                instancePath2.lineTo(19.611729f, 21.301521f);
                instancePath2.cubicTo(19.70509f, 21.845858f, 19.339502f, 22.362812f, 18.795166f, 22.456173f);
                instancePath2.cubicTo(18.57841f, 22.493351f, 18.35544f, 22.458036f, 18.16078f, 22.355698f);
                instancePath2.lineTo(13.488614f, 19.899393f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray6 = c.setMatrixFloatArray(matrixFloatArray5, 0.70710677f, -0.70710677f, 17.0f, 0.70710677f, 0.70710677f, 0.029438019f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray6);
                canvas.concat(instanceMatrix);
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
