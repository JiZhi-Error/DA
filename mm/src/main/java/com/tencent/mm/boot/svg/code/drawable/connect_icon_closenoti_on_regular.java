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

public class connect_icon_closenoti_on_regular extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 80.0f);
                instancePath.cubicTo(0.0f, 35.887928f, 35.887665f, 0.0f, 80.0f, 0.0f);
                instancePath.cubicTo(124.112335f, 0.0f, 160.0f, 35.887928f, 160.0f, 80.0f);
                instancePath.cubicTo(160.0f, 124.112076f, 124.112335f, 160.0f, 80.0f, 160.0f);
                instancePath.cubicTo(35.887665f, 160.0f, 0.0f, 124.112076f, 0.0f, 80.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-16139513);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(62.284435f, 76.0f);
                instancePath2.lineTo(88.0f, 103.0f);
                instancePath2.lineTo(57.0f, 103.0f);
                instancePath2.cubicTo(59.590897f, 99.16911f, 62.478912f, 92.10176f, 61.938694f, 79.91711f);
                instancePath2.cubicTo(62.001358f, 78.552414f, 62.116966f, 77.244446f, 62.284435f, 76.0f);
                instancePath2.moveTo(59.032513f, 80.31762f);
                instancePath2.cubicTo(59.91131f, 98.65149f, 52.0f, 103.66564f, 52.0f, 103.66564f);
                instancePath2.lineTo(52.0f, 106.0f);
                instancePath2.lineTo(96.0f, 106.0f);
                instancePath2.lineTo(60.79871f, 70.0f);
                instancePath2.cubicTo(59.848923f, 72.81619f, 59.213223f, 76.21763f, 59.032513f, 80.31762f);
                instancePath2.close();
                instancePath2.moveTo(83.02051f, 57.95267f);
                instancePath2.lineTo(83.02051f, 56.067513f);
                instancePath2.cubicTo(83.02051f, 53.063652f, 80.875374f, 51.031452f, 77.88457f, 51.031452f);
                instancePath2.cubicTo(74.90136f, 51.031452f, 73.00952f, 53.103878f, 73.00952f, 56.096867f);
                instancePath2.lineTo(73.00952f, 57.95267f);
                instancePath2.cubicTo(70.48619f, 58.716953f, 67.18386f, 60.1031f, 64.88232f, 62.578594f);
                instancePath2.lineTo(52.30372f, 50.0f);
                instancePath2.lineTo(50.0f, 52.30372f);
                instancePath2.lineTo(107.69628f, 110.0f);
                instancePath2.lineTo(110.0f, 107.69628f);
                instancePath2.lineTo(99.0663f, 96.76258f);
                instancePath2.cubicTo(97.537735f, 93.18687f, 96.3201f, 87.87494f, 96.69735f, 80.20276f);
                instancePath2.cubicTo(96.02982f, 65.39329f, 89.03693f, 59.812824f, 83.02051f, 57.95267f);
                instancePath2.close();
                instancePath2.moveTo(67.19256f, 65.0466f);
                instancePath2.lineTo(67.270584f, 64.963394f);
                instancePath2.cubicTo(68.93996f, 63.198772f, 70.999466f, 61.94311f, 73.38978f, 61.230995f);
                instancePath2.lineTo(75.99048f, 60.549137f);
                instancePath2.lineTo(75.99048f, 58.14372f);
                instancePath2.lineTo(75.99048f, 56.299133f);
                instancePath2.cubicTo(75.99048f, 55.115875f, 76.7955f, 53.989075f, 77.99451f, 53.989075f);
                instancePath2.cubicTo(79.19461f, 53.989075f, 80.000916f, 55.115875f, 80.000916f, 56.299133f);
                instancePath2.lineTo(80.000916f, 58.15777f);
                instancePath2.lineTo(80.000916f, 60.549137f);
                instancePath2.lineTo(82.40482f, 61.25477f);
                instancePath2.cubicTo(85.330345f, 62.144104f, 87.738235f, 63.84173f, 89.56147f, 66.300095f);
                instancePath2.cubicTo(92.02761f, 69.62295f, 93.42553f, 74.32356f, 93.71676f, 80.27227f);
                instancePath2.cubicTo(93.51565f, 84.521194f, 93.77281f, 88.40163f, 94.48276f, 91.88008f);
                instancePath2.lineTo(67.19256f, 65.0466f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
