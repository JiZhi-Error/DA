package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class emoji_add_capture extends c {
    private final int height = 168;
    private final int width = 168;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -2.0f, 0.0f, 1.0f, -2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(5.0f, 152.0f);
                instancePath.cubicTo(5.0f, 160.26085f, 11.677815f, 166.96202f, 19.929785f, 166.99983f);
                instancePath.lineTo(19.940516f, 167.01065f);
                instancePath.lineTo(19.940516f, 169.99687f);
                instancePath.lineTo(19.893726f, 169.99687f);
                instancePath.cubicTo(10.011294f, 169.99687f, 2.0f, 161.98558f, 2.0f, 152.10315f);
                instancePath.cubicTo(2.0f, 152.06876f, 2.0000992f, 152.03438f, 2.0002973f, 152.0f);
                instancePath.lineTo(5.0f, 152.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, -1.0f, 0.0f, 321.94052f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(155.0f, 152.0f);
                instancePath2.cubicTo(155.0f, 160.26085f, 161.67781f, 166.96202f, 169.92978f, 166.99983f);
                instancePath2.lineTo(169.94052f, 167.01065f);
                instancePath2.lineTo(169.94052f, 169.99687f);
                instancePath2.lineTo(169.89372f, 169.99687f);
                instancePath2.cubicTo(160.01129f, 169.99687f, 152.0f, 161.98558f, 152.0f, 152.10315f);
                instancePath2.cubicTo(152.0f, 152.06876f, 152.00009f, 152.03438f, 152.00029f, 152.0f);
                instancePath2.lineTo(155.0f, 152.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, -1.0f, 0.0f, 321.94052f, 0.0f, -1.0f, 21.99687f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(155.0f, 2.0f);
                instancePath3.cubicTo(155.0f, 10.260854f, 161.67781f, 16.96202f, 169.92978f, 16.99984f);
                instancePath3.lineTo(169.94052f, 17.01065f);
                instancePath3.lineTo(169.94052f, 19.99687f);
                instancePath3.lineTo(169.89372f, 19.99687f);
                instancePath3.cubicTo(160.01129f, 19.99687f, 152.0f, 11.985575f, 152.0f, 2.1031427f);
                instancePath3.cubicTo(152.0f, 2.0687616f, 152.00009f, 2.0343807f, 152.00029f, 2.0f);
                instancePath3.lineTo(155.0f, 2.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 21.99687f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(5.0f, 2.0f);
                instancePath4.cubicTo(5.0f, 10.260854f, 11.677815f, 16.96202f, 19.929785f, 16.99984f);
                instancePath4.lineTo(19.940516f, 17.01065f);
                instancePath4.lineTo(19.940516f, 19.99687f);
                instancePath4.lineTo(19.893726f, 19.99687f);
                instancePath4.cubicTo(10.011294f, 19.99687f, 2.0f, 11.985575f, 2.0f, 2.1031427f);
                instancePath4.cubicTo(2.0f, 2.0687616f, 2.0000992f, 2.0343807f, 2.0002973f, 2.0f);
                instancePath4.lineTo(5.0f, 2.0f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                instancePaint8.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint8.setStrokeWidth(3.0f);
                instancePaint8.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(33.5f, 3.5f);
                instancePath5.lineTo(48.5f, 3.5f);
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint3, looper);
                instancePaint9.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint9.setStrokeWidth(3.0f);
                instancePaint9.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath6 = c.instancePath(looper);
                instancePath6.moveTo(33.5f, 168.5f);
                instancePath6.lineTo(48.5f, 168.5f);
                canvas.drawPath(instancePath6, instancePaint9);
                canvas.restore();
                canvas.save();
                Paint instancePaint10 = c.instancePaint(instancePaint3, looper);
                instancePaint10.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint10.setStrokeWidth(3.0f);
                instancePaint10.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath7 = c.instancePath(looper);
                instancePath7.moveTo(63.5f, 168.5f);
                instancePath7.lineTo(78.5f, 168.5f);
                canvas.drawPath(instancePath7, instancePaint10);
                canvas.restore();
                canvas.save();
                Paint instancePaint11 = c.instancePaint(instancePaint3, looper);
                instancePaint11.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint11.setStrokeWidth(3.0f);
                instancePaint11.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath8 = c.instancePath(looper);
                instancePath8.moveTo(93.5f, 3.5f);
                instancePath8.lineTo(108.5f, 3.5f);
                canvas.drawPath(instancePath8, instancePaint11);
                canvas.restore();
                canvas.save();
                Paint instancePaint12 = c.instancePaint(instancePaint3, looper);
                instancePaint12.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint12.setStrokeWidth(3.0f);
                instancePaint12.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath9 = c.instancePath(looper);
                instancePath9.moveTo(123.5f, 3.5f);
                instancePath9.lineTo(138.5f, 3.5f);
                canvas.drawPath(instancePath9, instancePaint12);
                canvas.restore();
                canvas.save();
                Paint instancePaint13 = c.instancePaint(instancePaint3, looper);
                instancePaint13.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint13.setStrokeWidth(3.0f);
                instancePaint13.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath10 = c.instancePath(looper);
                instancePath10.moveTo(123.5f, 168.5f);
                instancePath10.lineTo(138.5f, 168.5f);
                canvas.drawPath(instancePath10, instancePaint13);
                canvas.restore();
                canvas.save();
                Paint instancePaint14 = c.instancePaint(instancePaint3, looper);
                instancePaint14.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint14.setStrokeWidth(3.0f);
                instancePaint14.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath11 = c.instancePath(looper);
                instancePath11.moveTo(168.5f, 33.5f);
                instancePath11.lineTo(168.5f, 48.5f);
                canvas.drawPath(instancePath11, instancePaint14);
                canvas.restore();
                canvas.save();
                Paint instancePaint15 = c.instancePaint(instancePaint3, looper);
                instancePaint15.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint15.setStrokeWidth(3.0f);
                instancePaint15.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath12 = c.instancePath(looper);
                instancePath12.moveTo(3.5f, 63.5f);
                instancePath12.lineTo(3.5f, 78.5f);
                canvas.drawPath(instancePath12, instancePaint15);
                canvas.restore();
                canvas.save();
                Paint instancePaint16 = c.instancePaint(instancePaint3, looper);
                instancePaint16.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint16.setStrokeWidth(3.0f);
                instancePaint16.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath13 = c.instancePath(looper);
                instancePath13.moveTo(3.5f, 33.5f);
                instancePath13.lineTo(3.5f, 48.5f);
                canvas.drawPath(instancePath13, instancePaint16);
                canvas.restore();
                canvas.save();
                Paint instancePaint17 = c.instancePaint(instancePaint3, looper);
                instancePaint17.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint17.setStrokeWidth(3.0f);
                instancePaint17.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath14 = c.instancePath(looper);
                instancePath14.moveTo(93.5f, 168.5f);
                instancePath14.lineTo(108.5f, 168.5f);
                canvas.drawPath(instancePath14, instancePaint17);
                canvas.restore();
                canvas.save();
                Paint instancePaint18 = c.instancePaint(instancePaint3, looper);
                instancePaint18.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint18.setStrokeWidth(3.0f);
                instancePaint18.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath15 = c.instancePath(looper);
                instancePath15.moveTo(168.5f, 78.5f);
                instancePath15.lineTo(168.5f, 63.5f);
                canvas.drawPath(instancePath15, instancePaint18);
                canvas.restore();
                canvas.save();
                Paint instancePaint19 = c.instancePaint(instancePaint3, looper);
                instancePaint19.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint19.setStrokeWidth(3.0f);
                instancePaint19.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath16 = c.instancePath(looper);
                instancePath16.moveTo(3.5f, 108.5f);
                instancePath16.lineTo(3.5f, 93.5f);
                canvas.drawPath(instancePath16, instancePaint19);
                canvas.restore();
                canvas.save();
                Paint instancePaint20 = c.instancePaint(instancePaint3, looper);
                instancePaint20.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint20.setStrokeWidth(3.0f);
                instancePaint20.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath17 = c.instancePath(looper);
                instancePath17.moveTo(168.5f, 108.5f);
                instancePath17.lineTo(168.5f, 93.5f);
                canvas.drawPath(instancePath17, instancePaint20);
                canvas.restore();
                canvas.save();
                Paint instancePaint21 = c.instancePaint(instancePaint3, looper);
                instancePaint21.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint21.setStrokeWidth(3.0f);
                instancePaint21.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath18 = c.instancePath(looper);
                instancePath18.moveTo(3.5f, 138.5f);
                instancePath18.lineTo(3.5f, 123.5f);
                canvas.drawPath(instancePath18, instancePaint21);
                canvas.restore();
                canvas.save();
                Paint instancePaint22 = c.instancePaint(instancePaint3, looper);
                instancePaint22.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint22.setStrokeWidth(3.0f);
                instancePaint22.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath19 = c.instancePath(looper);
                instancePath19.moveTo(63.5f, 3.5f);
                instancePath19.lineTo(78.5f, 3.5f);
                canvas.drawPath(instancePath19, instancePaint22);
                canvas.restore();
                canvas.save();
                Paint instancePaint23 = c.instancePaint(instancePaint3, looper);
                instancePaint23.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint23.setStrokeWidth(3.0f);
                instancePaint23.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath20 = c.instancePath(looper);
                instancePath20.moveTo(168.5f, 138.5f);
                instancePath20.lineTo(168.5f, 123.5f);
                canvas.drawPath(instancePath20, instancePaint23);
                canvas.restore();
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray5 = c.setMatrixFloatArray(matrixFloatArray4, 1.0f, 0.0f, 46.0f, 0.0f, 1.0f, 52.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray5);
                canvas.concat(instanceMatrix);
                Paint instancePaint24 = c.instancePaint(instancePaint, looper);
                instancePaint24.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint25 = c.instancePaint(instancePaint24, looper);
                Path instancePath21 = c.instancePath(looper);
                instancePath21.moveTo(46.64519f, 7.0666666f);
                instancePath21.lineTo(29.354809f, 7.0666666f);
                instancePath21.lineTo(22.021475f, 18.066668f);
                instancePath21.lineTo(5.733333f, 18.066668f);
                instancePath21.lineTo(5.733333f, 56.933334f);
                instancePath21.lineTo(70.26667f, 56.933334f);
                instancePath21.lineTo(70.26667f, 18.066668f);
                instancePath21.lineTo(53.978523f, 18.066668f);
                instancePath21.lineTo(46.64519f, 7.0666666f);
                instancePath21.close();
                instancePath21.moveTo(48.01883f, 2.6666667f);
                instancePath21.cubicTo(48.63181f, 2.6666667f, 49.204235f, 2.9730186f, 49.544254f, 3.4830496f);
                instancePath21.lineTo(56.333332f, 13.666667f);
                instancePath21.lineTo(71.0f, 13.666667f);
                instancePath21.cubicTo(73.02505f, 13.666667f, 74.666664f, 15.30829f, 74.666664f, 17.333334f);
                instancePath21.lineTo(74.666664f, 57.666668f);
                instancePath21.cubicTo(74.666664f, 59.69171f, 73.02505f, 61.333332f, 71.0f, 61.333332f);
                instancePath21.lineTo(5.0f, 61.333332f);
                instancePath21.cubicTo(2.974956f, 61.333332f, 1.3333334f, 59.69171f, 1.3333334f, 57.666668f);
                instancePath21.lineTo(1.3333334f, 17.333334f);
                instancePath21.cubicTo(1.3333334f, 15.30829f, 2.974956f, 13.666667f, 5.0f, 13.666667f);
                instancePath21.lineTo(19.666666f, 13.666667f);
                instancePath21.lineTo(26.455744f, 3.4830496f);
                instancePath21.cubicTo(26.795765f, 2.9730186f, 27.368189f, 2.6666667f, 27.98117f, 2.6666667f);
                instancePath21.lineTo(48.01883f, 2.6666667f);
                instancePath21.close();
                instancePath21.moveTo(38.0f, 45.933334f);
                instancePath21.cubicTo(43.670124f, 45.933334f, 48.266666f, 41.336792f, 48.266666f, 35.666668f);
                instancePath21.cubicTo(48.266666f, 29.996544f, 43.670124f, 25.4f, 38.0f, 25.4f);
                instancePath21.cubicTo(32.329876f, 25.4f, 27.733334f, 29.996544f, 27.733334f, 35.666668f);
                instancePath21.cubicTo(27.733334f, 41.336792f, 32.329876f, 45.933334f, 38.0f, 45.933334f);
                instancePath21.close();
                instancePath21.moveTo(38.0f, 50.333332f);
                instancePath21.cubicTo(29.899824f, 50.333332f, 23.333334f, 43.76684f, 23.333334f, 35.666668f);
                instancePath21.cubicTo(23.333334f, 27.56649f, 29.899824f, 21.0f, 38.0f, 21.0f);
                instancePath21.cubicTo(46.100178f, 21.0f, 52.666668f, 27.56649f, 52.666668f, 35.666668f);
                instancePath21.cubicTo(52.666668f, 43.76684f, 46.100178f, 50.333332f, 38.0f, 50.333332f);
                instancePath21.close();
                WeChatSVGRenderC2Java.setFillType(instancePath21, 1);
                canvas.drawPath(instancePath21, instancePaint25);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}