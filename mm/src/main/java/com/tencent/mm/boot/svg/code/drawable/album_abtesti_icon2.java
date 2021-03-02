package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class album_abtesti_icon2 extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-9342607);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(22.7f, 0.0f);
                instancePath.lineTo(25.07f, 0.0f);
                instancePath.cubicTo(37.02f, 0.35f, 47.45f, 10.65f, 48.0f, 22.58f);
                instancePath.lineTo(48.0f, 25.35f);
                instancePath.cubicTo(47.49f, 37.13f, 37.36f, 47.34f, 25.6f, 48.0f);
                instancePath.lineTo(22.6f, 48.0f);
                instancePath.cubicTo(10.77f, 47.46f, 0.55f, 37.22f, 0.0f, 25.4f);
                instancePath.lineTo(0.0f, 22.73f);
                instancePath.cubicTo(0.46f, 10.81f, 10.8f, 0.49f, 22.7f, 0.0f);
                instancePath.lineTo(22.7f, 0.0f);
                instancePath.close();
                instancePath.moveTo(22.0f, 12.0f);
                instancePath.cubicTo(22.171429f, 17.652987f, 22.37143f, 23.305975f, 22.571428f, 28.958961f);
                instancePath.cubicTo(23.514286f, 28.97948f, 24.457144f, 28.98974f, 25.409523f, 29.0f);
                instancePath.cubicTo(25.52381f, 23.326494f, 25.77143f, 17.663246f, 26.0f, 12.0f);
                instancePath.cubicTo(24.666666f, 12.01026f, 23.333334f, 12.01026f, 22.0f, 12.0f);
                instancePath.lineTo(22.0f, 12.0f);
                instancePath.close();
                instancePath.moveTo(23.251102f, 31.157341f);
                instancePath.cubicTo(22.210506f, 31.45582f, 21.597021f, 33.081738f, 22.303694f, 33.977173f);
                instancePath.cubicTo(22.948242f, 35.658073f, 25.883654f, 35.14752f, 25.953545f, 33.31738f);
                instancePath.cubicTo(26.302998f, 31.817135f, 24.610088f, 30.544678f, 23.251102f, 31.157341f);
                instancePath.lineTo(23.251102f, 31.157341f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.0f, 0.0f);
                instancePath2.cubicTo(1.3333334f, 0.010259505f, 2.6666667f, 0.010259505f, 4.0f, 0.0f);
                instancePath2.cubicTo(3.7714286f, 5.6632466f, 3.5238094f, 11.326493f, 3.4095237f, 17.0f);
                instancePath2.cubicTo(2.4571428f, 16.98974f, 1.5142857f, 16.97948f, 0.5714286f, 16.958961f);
                instancePath2.cubicTo(0.37142858f, 11.305975f, 0.17142858f, 5.6529875f, 0.0f, 0.0f);
                instancePath2.lineTo(0.0f, 0.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
