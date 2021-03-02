package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sns_lucky_time_icon extends c {
    private final int height = 45;
    private final int width = 45;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 45;
            case 1:
                return 45;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-9312);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 1.0f);
                instancePath.lineTo(3.0f, 1.0f);
                instancePath.lineTo(3.0f, 34.0f);
                instancePath.lineTo(0.0f, 34.0f);
                instancePath.lineTo(0.0f, 1.0f);
                instancePath.close();
                instancePath.moveTo(0.0f, 12.0f);
                instancePath.lineTo(3.0f, 12.0f);
                instancePath.lineTo(3.0f, 16.0f);
                instancePath.lineTo(0.0f, 16.0f);
                instancePath.lineTo(0.0f, 12.0f);
                instancePath.close();
                instancePath.moveTo(0.0f, 20.0f);
                instancePath.lineTo(3.0f, 20.0f);
                instancePath.lineTo(3.0f, 24.0f);
                instancePath.lineTo(0.0f, 24.0f);
                instancePath.lineTo(0.0f, 20.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 1.0f);
                instancePath.lineTo(39.0f, 1.0f);
                instancePath.lineTo(39.0f, 34.0f);
                instancePath.lineTo(36.0f, 34.0f);
                instancePath.lineTo(36.0f, 1.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 20.0f);
                instancePath.lineTo(39.0f, 20.0f);
                instancePath.lineTo(39.0f, 24.0f);
                instancePath.lineTo(36.0f, 24.0f);
                instancePath.lineTo(36.0f, 20.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 12.0f);
                instancePath.lineTo(39.0f, 12.0f);
                instancePath.lineTo(39.0f, 16.0f);
                instancePath.lineTo(36.0f, 16.0f);
                instancePath.lineTo(36.0f, 12.0f);
                instancePath.close();
                instancePath.moveTo(18.0f, 29.5f);
                instancePath.cubicTo(16.461456f, 29.5f, 13.0798645f, 34.0f, 10.5f, 34.0f);
                instancePath.cubicTo(10.5f, 34.0f, 23.911882f, 34.0f, 25.5f, 34.0f);
                instancePath.cubicTo(25.5f, 34.0f, 20.59497f, 29.5f, 18.0f, 29.5f);
                instancePath.close();
                instancePath.moveTo(12.400916f, 5.933368f);
                instancePath.cubicTo(13.413912f, 8.198693f, 15.042143f, 9.521335f, 16.935621f, 11.160607f);
                instancePath.cubicTo(18.481054f, 12.498559f, 18.704428f, 13.840594f, 18.704428f, 13.840594f);
                instancePath.cubicTo(18.704428f, 13.840594f, 22.41539f, 9.37187f, 24.088566f, 8.198693f);
                instancePath.cubicTo(25.761744f, 7.0255156f, 26.796274f, 2.6699219f, 26.796274f, 2.6699219f);
                instancePath.cubicTo(26.796274f, 2.6699219f, 23.044596f, 5.933368f, 19.713867f, 5.933368f);
                instancePath.cubicTo(16.383139f, 5.933368f, 16.935621f, 6.7753158f, 12.400916f, 5.933368f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(-9312);
                instancePaint5.setStrokeWidth(3.0f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(7.531052f, 0.8899055f);
                instancePath2.cubicTo(7.5f, 10.796076f, 9.671387f, 9.194105f, 15.0f, 15.2649f);
                instancePath2.cubicTo(17.19315f, 17.659187f, 16.830078f, 19.011608f, 15.0f, 21.053797f);
                instancePath2.cubicTo(12.047792f, 24.348173f, 7.5f, 24.034626f, 7.5f, 34.089428f);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(-9312);
                instancePaint6.setStrokeWidth(3.0f);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(29.968988f, 1.0f);
                instancePath3.cubicTo(30.0f, 10.90617f, 27.83145f, 9.304199f, 22.509796f, 15.374994f);
                instancePath3.cubicTo(20.31951f, 17.769281f, 20.682108f, 19.121702f, 22.509796f, 21.16389f);
                instancePath3.cubicTo(25.458147f, 24.458267f, 30.0f, 24.14472f, 30.0f, 34.199524f);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
