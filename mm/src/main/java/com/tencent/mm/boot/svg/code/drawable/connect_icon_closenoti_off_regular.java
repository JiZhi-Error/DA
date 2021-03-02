package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;

public class connect_icon_closenoti_off_regular extends c {
    private final int height = TbsListener.ErrorCode.STARTDOWNLOAD_3;
    private final int width = TbsListener.ErrorCode.STARTDOWNLOAD_3;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return TbsListener.ErrorCode.STARTDOWNLOAD_3;
            case 1:
                return TbsListener.ErrorCode.STARTDOWNLOAD_3;
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
                canvas.saveLayerAlpha(null, 128, 31);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 80.0f);
                instancePath.cubicTo(0.0f, 35.887928f, 35.887665f, 0.0f, 80.0f, 0.0f);
                instancePath.cubicTo(124.112335f, 0.0f, 160.0f, 35.887928f, 160.0f, 80.0f);
                instancePath.cubicTo(160.0f, 124.112076f, 124.112335f, 160.0f, 80.0f, 160.0f);
                instancePath.cubicTo(35.887665f, 160.0f, 0.0f, 124.112076f, 0.0f, 80.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-11711155);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(63.284435f, 77.0f);
                instancePath2.lineTo(89.0f, 104.0f);
                instancePath2.lineTo(58.0f, 104.0f);
                instancePath2.cubicTo(60.590897f, 100.16911f, 63.478912f, 93.10176f, 62.938694f, 80.91711f);
                instancePath2.cubicTo(63.001358f, 79.552414f, 63.116966f, 78.244446f, 63.284435f, 77.0f);
                instancePath2.moveTo(60.032513f, 81.31762f);
                instancePath2.cubicTo(60.91131f, 99.65149f, 53.0f, 104.66564f, 53.0f, 104.66564f);
                instancePath2.lineTo(53.0f, 107.0f);
                instancePath2.lineTo(97.0f, 107.0f);
                instancePath2.lineTo(61.79871f, 71.0f);
                instancePath2.cubicTo(60.848923f, 73.81619f, 60.213223f, 77.21763f, 60.032513f, 81.31762f);
                instancePath2.close();
                instancePath2.moveTo(84.02051f, 58.95267f);
                instancePath2.lineTo(84.02051f, 57.067513f);
                instancePath2.cubicTo(84.02051f, 54.063652f, 81.875374f, 52.031452f, 78.88457f, 52.031452f);
                instancePath2.cubicTo(75.90136f, 52.031452f, 74.00952f, 54.103878f, 74.00952f, 57.096867f);
                instancePath2.lineTo(74.00952f, 58.95267f);
                instancePath2.cubicTo(71.48619f, 59.716953f, 68.18386f, 61.1031f, 65.88232f, 63.578594f);
                instancePath2.lineTo(53.30372f, 51.0f);
                instancePath2.lineTo(51.0f, 53.30372f);
                instancePath2.lineTo(108.69628f, 111.0f);
                instancePath2.lineTo(111.0f, 108.69628f);
                instancePath2.lineTo(100.0663f, 97.76258f);
                instancePath2.cubicTo(98.537735f, 94.18687f, 97.3201f, 88.87494f, 97.69735f, 81.20276f);
                instancePath2.cubicTo(97.02982f, 66.39329f, 90.03693f, 60.812824f, 84.02051f, 58.95267f);
                instancePath2.close();
                instancePath2.moveTo(68.19256f, 66.0466f);
                instancePath2.lineTo(68.270584f, 65.963394f);
                instancePath2.cubicTo(69.93996f, 64.19877f, 71.999466f, 62.94311f, 74.38978f, 62.230995f);
                instancePath2.lineTo(76.99048f, 61.549137f);
                instancePath2.lineTo(76.99048f, 59.14372f);
                instancePath2.lineTo(76.99048f, 57.299133f);
                instancePath2.cubicTo(76.99048f, 56.115875f, 77.7955f, 54.989075f, 78.99451f, 54.989075f);
                instancePath2.cubicTo(80.19461f, 54.989075f, 81.000916f, 56.115875f, 81.000916f, 57.299133f);
                instancePath2.lineTo(81.000916f, 59.15777f);
                instancePath2.lineTo(81.000916f, 61.549137f);
                instancePath2.lineTo(83.40482f, 62.25477f);
                instancePath2.cubicTo(86.330345f, 63.144104f, 88.738235f, 64.84173f, 90.56147f, 67.300095f);
                instancePath2.cubicTo(93.02761f, 70.62295f, 94.42553f, 75.32356f, 94.71676f, 81.27227f);
                instancePath2.cubicTo(94.51565f, 85.521194f, 94.77281f, 89.40163f, 95.48276f, 92.88008f);
                instancePath2.lineTo(68.19256f, 66.0466f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
