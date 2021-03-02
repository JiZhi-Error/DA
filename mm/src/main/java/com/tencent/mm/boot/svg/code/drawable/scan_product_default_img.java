package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class scan_product_default_img extends c {
    private final int height = 260;
    private final int width = 260;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 260;
            case 1:
                return 260;
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
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(260.0f, 0.0f);
                instancePath.lineTo(260.0f, 260.0f);
                instancePath.lineTo(0.0f, 260.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(59.16f, 77.16f);
                instancePath.cubicTo(57.65f, 77.86f, 58.16f, 79.66f, 57.99f, 80.98f);
                instancePath.cubicTo(58.01f, 114.71f, 58.0f, 148.43f, 57.99f, 182.16f);
                instancePath.cubicTo(60.86f, 183.35f, 64.02f, 182.9f, 67.04f, 182.95f);
                instancePath.cubicTo(108.35f, 182.93f, 149.67f, 182.95f, 190.98f, 182.94f);
                instancePath.cubicTo(194.25f, 182.9f, 197.55f, 183.16f, 200.8f, 182.74f);
                instancePath.cubicTo(202.32f, 182.12f, 201.85f, 180.36f, 202.01f, 179.08f);
                instancePath.cubicTo(201.99f, 148.7f, 202.01f, 118.33f, 202.0f, 87.95f);
                instancePath.cubicTo(201.97f, 84.68f, 202.2f, 81.39f, 201.81f, 78.14f);
                instancePath.cubicTo(201.13f, 76.62f, 199.33f, 77.12f, 198.02f, 76.95f);
                instancePath.cubicTo(155.01f, 76.98f, 112.0f, 76.96f, 68.99f, 76.96f);
                instancePath.cubicTo(65.71f, 77.0f, 62.42f, 76.76f, 59.16f, 77.16f);
                instancePath.lineTo(59.16f, 77.16f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(64.02f, 82.96f);
                instancePath2.cubicTo(108.01f, 82.93f, 152.0f, 82.93f, 195.99f, 82.96f);
                instancePath2.cubicTo(196.01f, 105.99f, 196.01f, 129.02f, 195.98f, 152.05f);
                instancePath2.cubicTo(185.97f, 142.73f, 176.02f, 133.34f, 165.99f, 124.03f);
                instancePath2.cubicTo(159.32f, 129.34f, 152.66f, 134.66f, 146.03f, 140.01f);
                instancePath2.cubicTo(148.31f, 145.33f, 150.69f, 150.6f, 152.95f, 155.93f);
                instancePath2.cubicTo(136.6f, 140.01f, 120.34f, 124.0f, 104.03f, 108.04f);
                instancePath2.cubicTo(90.62f, 121.57f, 77.42f, 135.3f, 64.02f, 148.84f);
                instancePath2.cubicTo(63.98f, 126.88f, 63.99f, 104.92f, 64.02f, 82.96f);
                instancePath2.lineTo(64.02f, 82.96f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-3552823);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 57.0f, 0.0f, 1.0f, 76.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint6, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(2.1695907f, 1.2352467f);
                instancePath3.cubicTo(5.42845f, 0.8355052f, 8.7172985f, 1.07535f, 11.996151f, 1.035376f);
                instancePath3.cubicTo(54.991104f, 1.035376f, 97.98605f, 1.0553629f, 140.981f, 1.0253824f);
                instancePath3.cubicTo(142.29054f, 1.1952724f, 144.08992f, 0.6955957f, 144.76968f, 2.2146132f);
                instancePath3.cubicTo(145.15955f, 5.4625125f, 144.92963f, 8.750386f, 144.95961f, 12.018272f);
                instancePath3.cubicTo(144.9696f, 42.378635f, 144.94962f, 72.729004f, 144.9696f, 103.08937f);
                instancePath3.cubicTo(144.80966f, 104.368546f, 145.27951f, 106.1274f, 143.76004f, 106.747f);
                instancePath3.cubicTo(140.51117f, 107.16673f, 137.21233f, 106.9069f, 133.94347f, 106.94688f);
                instancePath3.cubicTo(92.64793f, 106.95687f, 51.34238f, 106.93688f, 10.046834f, 106.95687f);
                instancePath3.cubicTo(7.02789f, 106.9069f, 3.868996f, 107.35661f, 1.0f, 106.16738f);
                instancePath3.cubicTo(1.0099965f, 72.45918f, 1.019993f, 38.760975f, 1.0f, 5.052778f);
                instancePath3.cubicTo(1.1699405f, 3.7336307f, 0.66011894f, 1.9347942f, 2.1695907f, 1.2352467f);
                instancePath3.lineTo(2.1695907f, 1.2352467f);
                instancePath3.close();
                instancePath3.moveTo(7.0263805f, 7.0225024f);
                instancePath3.cubicTo(6.9963827f, 28.984758f, 6.9863834f, 50.947014f, 7.0263805f, 72.90927f);
                instancePath3.cubicTo(20.425333f, 59.36788f, 33.624302f, 45.63647f, 47.033253f, 32.10508f);
                instancePath3.cubicTo(63.341976f, 48.06672f, 79.60071f, 64.07836f, 95.949425f, 80.0f);
                instancePath3.cubicTo(93.689606f, 74.66945f, 91.30979f, 69.39891f, 89.02997f, 64.07836f);
                instancePath3.cubicTo(95.65945f, 58.727814f, 102.31893f, 53.40727f, 108.98841f, 48.09672f);
                instancePath3.cubicTo(119.017624f, 57.40768f, 128.96684f, 66.798645f, 138.97606f, 76.1196f);
                instancePath3.cubicTo(139.00606f, 53.087234f, 139.00606f, 30.054869f, 138.98607f, 7.0225024f);
                instancePath3.cubicTo(94.999504f, 6.9924994f, 51.01294f, 6.9924994f, 7.0263805f, 7.0225024f);
                instancePath3.lineTo(7.0263805f, 7.0225024f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
