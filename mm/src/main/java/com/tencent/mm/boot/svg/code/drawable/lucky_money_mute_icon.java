package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class lucky_money_mute_icon extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -189.0f, 0.0f, 1.0f, -177.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 189.0f, 0.0f, 1.0f, 177.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(Integer.MIN_VALUE);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 36.0f);
                instancePath.cubicTo(0.0f, 16.117748f, 16.117748f, 0.0f, 36.0f, 0.0f);
                instancePath.lineTo(36.0f, 0.0f);
                instancePath.cubicTo(55.88225f, 0.0f, 72.0f, 16.117748f, 72.0f, 36.0f);
                instancePath.lineTo(72.0f, 36.0f);
                instancePath.cubicTo(72.0f, 55.88225f, 55.88225f, 72.0f, 36.0f, 72.0f);
                instancePath.lineTo(36.0f, 72.0f);
                instancePath.cubicTo(16.117748f, 72.0f, 0.0f, 55.88225f, 0.0f, 36.0f);
                instancePath.lineTo(0.0f, 36.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 15.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(8.962311f, 5.25f);
                instancePath2.lineTo(15.855f, 12.143f);
                instancePath2.lineTo(19.775f, 8.225f);
                instancePath2.cubicTo(20.475f, 7.525f, 21.525f, 7.525f, 22.225f, 8.225f);
                instancePath2.cubicTo(22.536112f, 8.536111f, 22.70895f, 8.847222f, 22.743519f, 9.281241f);
                instancePath2.lineTo(22.75f, 9.45f);
                instancePath2.lineTo(22.749f, 19.037f);
                instancePath2.lineTo(27.7877f, 24.074669f);
                instancePath2.cubicTo(28.266113f, 23.128498f, 28.525f, 22.064249f, 28.525f, 21.0f);
                instancePath2.cubicTo(28.525f, 19.25f, 27.825f, 17.5f, 26.6f, 16.275f);
                instancePath2.lineTo(26.425f, 16.1f);
                instancePath2.lineTo(28.35f, 14.175f);
                instancePath2.lineTo(28.525f, 14.35f);
                instancePath2.cubicTo(30.275f, 16.1f, 31.325f, 18.55f, 31.325f, 21.0f);
                instancePath2.cubicTo(31.325f, 22.783064f, 30.76885f, 24.566128f, 29.791471f, 26.079357f);
                instancePath2.lineTo(31.39971f, 27.685888f);
                instancePath2.cubicTo(32.77811f, 25.729305f, 33.425f, 23.472467f, 33.425f, 21.0f);
                instancePath2.cubicTo(33.425f, 17.85f, 32.2f, 15.05f, 30.1f, 12.775f);
                instancePath2.lineTo(29.925f, 12.6f);
                instancePath2.lineTo(31.85f, 10.675f);
                instancePath2.lineTo(32.025f, 10.85f);
                instancePath2.cubicTo(34.65f, 13.475f, 36.225f, 17.15f, 36.225f, 21.0f);
                instancePath2.cubicTo(36.225f, 24.184946f, 35.2669f, 27.130367f, 33.3507f, 29.638115f);
                instancePath2.lineTo(38.660797f, 34.948486f);
                instancePath2.lineTo(36.80464f, 36.80464f);
                instancePath2.lineTo(7.1061554f, 7.1061554f);
                instancePath2.lineTo(8.962311f, 5.25f);
                instancePath2.close();
                instancePath2.moveTo(11.162f, 14.875f);
                instancePath2.lineTo(22.749f, 26.461f);
                instancePath2.lineTo(22.75f, 32.55f);
                instancePath2.cubicTo(22.75f, 33.6f, 22.05f, 34.3f, 21.0f, 34.3f);
                instancePath2.cubicTo(20.533333f, 34.3f, 20.204939f, 34.161728f, 19.891907f, 33.885185f);
                instancePath2.lineTo(19.775f, 33.775f);
                instancePath2.lineTo(13.125f, 27.125f);
                instancePath2.lineTo(5.25f, 27.125f);
                instancePath2.cubicTo(4.2525f, 27.125f, 3.570875f, 26.49325f, 3.5052063f, 25.52983f);
                instancePath2.lineTo(3.5f, 25.375f);
                instancePath2.lineTo(3.5f, 16.625f);
                instancePath2.cubicTo(3.5f, 15.6275f, 4.13175f, 14.945875f, 5.0951686f, 14.880206f);
                instancePath2.lineTo(5.25f, 14.875f);
                instancePath2.lineTo(11.162f, 14.875f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
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
