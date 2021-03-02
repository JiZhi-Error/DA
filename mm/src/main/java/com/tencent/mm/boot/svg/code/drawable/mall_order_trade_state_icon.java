package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class mall_order_trade_state_icon extends c {
    private final int height = 160;
    private final int width = 160;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 160;
            case 1:
                return 160;
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
                instancePaint3.setColor(-1250068);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(79.01384f, 0.0f);
                instancePath.lineTo(82.41509f, 0.0f);
                instancePath.cubicTo(101.12201f, 0.5937107f, 119.53711f, 7.889308f, 133.41383f, 20.467924f);
                instancePath.cubicTo(149.52452f, 34.767296f, 159.2956f, 55.79874f, 160.0f, 77.31321f);
                instancePath.lineTo(160.0f, 82.485535f);
                instancePath.cubicTo(159.38617f, 101.41383f, 151.89937f, 120.04025f, 139.039f, 133.9673f);
                instancePath.cubicTo(124.890564f, 149.62515f, 104.3522f, 159.07422f, 83.290565f, 160.0f);
                instancePath.lineTo(79.0239f, 160.0f);
                instancePath.cubicTo(60.286793f, 159.8088f, 41.730816f, 152.78491f, 27.62264f, 140.4478f);
                instancePath.cubicTo(10.898113f, 126.11824f, 0.7044025f, 104.64403f, 0.0f, 82.64654f);
                instancePath.lineTo(0.0f, 77.58491f);
                instancePath.cubicTo(0.6238994f, 55.74843f, 10.616352f, 34.415092f, 27.069183f, 20.03522f);
                instancePath.cubicTo(41.237736f, 7.4163523f, 60.03522f, 0.20125785f, 79.01384f, 0.0f);
                instancePath.lineTo(79.01384f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-3355444);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 41.0f, 0.0f, 1.0f, 44.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(8.019949f, 1.1661674f);
                instancePath2.cubicTo(28.676641f, 0.93631184f, 49.343307f, 0.95629925f, 70.0f, 1.1561736f);
                instancePath2.lineTo(70.0f, 6.8525925f);
                instancePath2.cubicTo(49.333332f, 7.052467f, 28.666666f, 7.0424733f, 8.0f, 6.8625865f);
                instancePath2.cubicTo(8.0f, 4.96378f, 8.0f, 3.0649736f, 8.019949f, 1.1661674f);
                instancePath2.lineTo(8.019949f, 1.1661674f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(5.850852f, 10.178336f);
                instancePath3.cubicTo(27.607054f, 9.930755f, 49.383244f, 9.950561f, 71.12945f, 10.178336f);
                instancePath3.cubicTo(72.83836f, 17.189867f, 74.42736f, 24.221203f, 76.156265f, 31.232735f);
                instancePath3.cubicTo(76.64595f, 33.668945f, 77.45544f, 36.233894f, 76.675934f, 38.709717f);
                instancePath3.cubicTo(75.586624f, 42.463066f, 71.249374f, 44.74082f, 67.481766f, 43.74059f);
                instancePath3.cubicTo(64.83344f, 43.29494f, 63.334393f, 40.87854f, 61.705425f, 39.026623f);
                instancePath3.cubicTo(59.616753f, 41.512352f, 57.09835f, 44.42392f, 53.44067f, 43.94856f);
                instancePath3.cubicTo(50.132767f, 43.94856f, 47.99412f, 41.29448f, 46.195263f, 38.917686f);
                instancePath3.cubicTo(44.346436f, 41.45293f, 41.937965f, 44.186237f, 38.450176f, 43.988174f);
                instancePath3.cubicTo(35.02235f, 44.146626f, 32.69383f, 41.45293f, 30.864986f, 38.977108f);
                instancePath3.cubicTo(28.976185f, 41.264767f, 26.857529f, 43.968365f, 23.55962f, 43.94856f);
                instancePath3.cubicTo(19.90194f, 44.414013f, 17.383537f, 41.512352f, 15.284868f, 39.036526f);
                instancePath3.cubicTo(13.785819f, 40.70028f, 12.506631f, 42.849293f, 10.228076f, 43.55243f);
                instancePath3.cubicTo(6.370522f, 44.94879f, 1.5235963f, 42.760166f, 0.3543379f, 38.798847f);
                instancePath3.cubicTo(-0.48512965f, 36.27351f, 0.36433157f, 33.639233f, 0.8740083f, 31.143604f);
                instancePath3.cubicTo(2.6029117f, 24.171686f, 4.1819105f, 17.170061f, 5.850852f, 10.178336f);
                instancePath3.lineTo(5.850852f, 10.178336f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint5, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(8.077558f, 48.74243f);
                instancePath4.cubicTo(10.055874f, 48.158264f, 12.044182f, 47.574097f, 14.022499f, 47.0f);
                instancePath4.cubicTo(14.082448f, 52.15679f, 13.9525585f, 57.30351f, 14.062465f, 62.4603f);
                instancePath4.cubicTo(16.550348f, 59.37831f, 18.798435f, 56.11503f, 21.276327f, 53.02297f);
                instancePath4.cubicTo(33.096268f, 52.932323f, 44.91621f, 52.912178f, 56.736153f, 53.033043f);
                instancePath4.cubicTo(59.204056f, 56.125103f, 61.45214f, 59.388382f, 63.940025f, 62.4603f);
                instancePath4.cubicTo(64.049934f, 57.31358f, 63.93003f, 52.15679f, 63.979992f, 47.0f);
                instancePath4.cubicTo(65.958305f, 47.574097f, 67.94662f, 48.158264f, 69.924934f, 48.74243f);
                instancePath4.cubicTo(69.99487f, 56.11503f, 70.07481f, 63.4977f, 69.86498f, 70.8703f);
                instancePath4.cubicTo(49.29249f, 71.03145f, 28.710001f, 71.06167f, 8.147498f, 70.85016f);
                instancePath4.cubicTo(7.9176936f, 63.48763f, 8.007617f, 56.11503f, 8.077558f, 48.74243f);
                instancePath4.lineTo(8.077558f, 48.74243f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint8);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
