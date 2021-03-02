package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ofm_enterprise_icon extends c {
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
                c.instanceMatrix(looper);
                c.instanceMatrixArray(looper);
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
                instancePath.moveTo(21.402294f, 63.573418f);
                instancePath.cubicTo(17.990284f, 59.120686f, 16.0f, 53.763718f, 16.0f, 48.0f);
                instancePath.cubicTo(16.0f, 32.536026f, 30.326887f, 20.0f, 48.0f, 20.0f);
                instancePath.cubicTo(65.67311f, 20.0f, 80.0f, 32.536026f, 80.0f, 48.0f);
                instancePath.cubicTo(80.0f, 63.463974f, 65.67311f, 76.0f, 48.0f, 76.0f);
                instancePath.cubicTo(42.61109f, 76.0f, 37.533306f, 74.834435f, 33.07795f, 72.77571f);
                instancePath.cubicTo(32.064f, 72.3056f, 30.848f, 72.243385f, 29.76946f, 72.52445f);
                instancePath.cubicTo(27.008947f, 73.24599f, 21.487925f, 74.68904f, 21.487925f, 74.68904f);
                instancePath.cubicTo(20.804852f, 74.867584f, 20.400309f, 74.47402f, 20.583893f, 73.81013f);
                instancePath.cubicTo(20.583893f, 73.81013f, 21.752691f, 69.583374f, 22.337091f, 67.46999f);
                instancePath.cubicTo(22.752f, 65.86561f, 22.208f, 64.62116f, 21.402294f, 63.573418f);
                instancePath.close();
                instancePath.moveTo(73.6f, 54.36469f);
                instancePath.lineTo(73.6f, 54.363297f);
                instancePath.cubicTo(71.25174f, 54.338768f, 68.70376f, 52.984592f, 66.20907f, 50.662968f);
                instancePath.cubicTo(65.316666f, 49.832478f, 63.70909f, 47.997643f, 63.70909f, 47.997643f);
                instancePath.cubicTo(63.70909f, 47.997643f, 65.31605f, 46.168102f, 66.20907f, 45.337032f);
                instancePath.cubicTo(68.70376f, 43.015408f, 71.25174f, 41.661232f, 73.6f, 41.636703f);
                instancePath.lineTo(73.6f, 41.63531f);
                instancePath.lineTo(73.6f, 41.63531f);
                instancePath.cubicTo(73.62415f, 41.636013f, 73.6484f, 41.636364f, 73.67273f, 41.636364f);
                instancePath.cubicTo(74.99821f, 41.636364f, 76.07273f, 40.591694f, 76.07273f, 39.303032f);
                instancePath.cubicTo(76.07273f, 38.014366f, 74.99821f, 36.969696f, 73.67273f, 36.969696f);
                instancePath.cubicTo(73.6484f, 36.969696f, 73.62415f, 36.970047f, 73.6f, 36.97075f);
                instancePath.lineTo(73.6f, 36.969696f);
                instancePath.cubicTo(71.49838f, 36.969696f, 69.437965f, 37.555458f, 67.43935f, 38.615448f);
                instancePath.cubicTo(65.82565f, 39.471287f, 64.29372f, 40.613247f, 62.843204f, 41.969494f);
                instancePath.cubicTo(62.114014f, 42.6513f, 61.431923f, 43.36207f, 60.8f, 44.082947f);
                instancePath.lineTo(60.8f, 44.082947f);
                instancePath.cubicTo(60.16808f, 43.36207f, 59.485985f, 42.6513f, 58.756798f, 41.969494f);
                instancePath.cubicTo(57.306286f, 40.613247f, 55.774345f, 39.471287f, 54.160656f, 38.615448f);
                instancePath.cubicTo(52.162037f, 37.555458f, 50.10162f, 36.969696f, 48.0f, 36.969696f);
                instancePath.cubicTo(45.89838f, 36.969696f, 43.837963f, 37.555458f, 41.839344f, 38.615448f);
                instancePath.cubicTo(40.225655f, 39.471287f, 38.693714f, 40.613247f, 37.243202f, 41.969494f);
                instancePath.cubicTo(36.514015f, 42.6513f, 35.83192f, 43.36207f, 35.2f, 44.082947f);
                instancePath.lineTo(35.2f, 44.082947f);
                instancePath.cubicTo(34.568077f, 43.36207f, 33.885986f, 42.6513f, 33.156796f, 41.969494f);
                instancePath.cubicTo(31.706285f, 40.613247f, 30.174345f, 39.471287f, 28.560658f, 38.615448f);
                instancePath.cubicTo(26.60569f, 37.57861f, 24.591595f, 36.99551f, 22.537647f, 36.970535f);
                instancePath.cubicTo(22.516077f, 36.96998f, 22.494436f, 36.969696f, 22.472727f, 36.969696f);
                instancePath.cubicTo(22.464945f, 36.969696f, 22.45717f, 36.969734f, 22.449406f, 36.969807f);
                instancePath.cubicTo(22.43294f, 36.969734f, 22.416471f, 36.969696f, 22.4f, 36.969696f);
                instancePath.lineTo(22.4f, 36.97075f);
                instancePath.cubicTo(21.108162f, 37.00813f, 20.072727f, 38.038017f, 20.072727f, 39.303032f);
                instancePath.cubicTo(20.072727f, 40.568043f, 21.108162f, 41.59793f, 22.4f, 41.63531f);
                instancePath.lineTo(22.4f, 41.636703f);
                instancePath.cubicTo(22.42163f, 41.63648f, 22.443247f, 41.636364f, 22.464844f, 41.636364f);
                instancePath.cubicTo(24.831001f, 41.636364f, 27.402946f, 42.994022f, 29.920622f, 45.337032f);
                instancePath.cubicTo(30.806889f, 46.161816f, 32.29091f, 47.997643f, 32.29091f, 47.997643f);
                instancePath.cubicTo(32.29091f, 47.997643f, 30.8091f, 49.83613f, 29.920622f, 50.662968f);
                instancePath.cubicTo(27.402946f, 53.005978f, 24.831001f, 54.363636f, 22.464844f, 54.363636f);
                instancePath.cubicTo(22.443247f, 54.363636f, 22.42163f, 54.36352f, 22.4f, 54.363297f);
                instancePath.lineTo(22.4f, 54.36469f);
                instancePath.cubicTo(21.108162f, 54.40207f, 20.072727f, 55.431957f, 20.072727f, 56.696968f);
                instancePath.cubicTo(20.072727f, 57.961983f, 21.108162f, 58.99187f, 22.4f, 59.02925f);
                instancePath.lineTo(22.4f, 59.030304f);
                instancePath.cubicTo(22.416471f, 59.030304f, 22.43294f, 59.030266f, 22.449406f, 59.030193f);
                instancePath.cubicTo(22.45717f, 59.030266f, 22.464945f, 59.030304f, 22.472727f, 59.030304f);
                instancePath.cubicTo(22.494436f, 59.030304f, 22.516077f, 59.03002f, 22.537647f, 59.029465f);
                instancePath.lineTo(22.537647f, 59.029465f);
                instancePath.cubicTo(24.591595f, 59.00449f, 26.60569f, 58.42139f, 28.560658f, 57.384552f);
                instancePath.cubicTo(30.174345f, 56.528713f, 31.706285f, 55.386753f, 33.156796f, 54.030506f);
                instancePath.cubicTo(33.885986f, 53.3487f, 34.568077f, 52.63793f, 35.2f, 51.917053f);
                instancePath.cubicTo(35.83192f, 52.63793f, 36.514015f, 53.3487f, 37.243202f, 54.030506f);
                instancePath.cubicTo(38.693714f, 55.386753f, 40.225655f, 56.528713f, 41.839344f, 57.384552f);
                instancePath.cubicTo(43.837963f, 58.444542f, 45.89838f, 59.030304f, 48.0f, 59.030304f);
                instancePath.cubicTo(50.10162f, 59.030304f, 52.162037f, 58.444542f, 54.160656f, 57.384552f);
                instancePath.cubicTo(55.774345f, 56.528713f, 57.306286f, 55.386753f, 58.756798f, 54.030506f);
                instancePath.cubicTo(59.485985f, 53.3487f, 60.16808f, 52.63793f, 60.8f, 51.917053f);
                instancePath.cubicTo(61.431923f, 52.63793f, 62.114014f, 53.3487f, 62.843204f, 54.030506f);
                instancePath.cubicTo(64.29372f, 55.386753f, 65.82565f, 56.528713f, 67.43935f, 57.384552f);
                instancePath.cubicTo(69.437965f, 58.444542f, 71.49838f, 59.030304f, 73.6f, 59.030304f);
                instancePath.lineTo(73.6f, 59.02925f);
                instancePath.cubicTo(73.62415f, 59.029953f, 73.6484f, 59.030304f, 73.67273f, 59.030304f);
                instancePath.cubicTo(74.99821f, 59.030304f, 76.07273f, 57.985634f, 76.07273f, 56.696968f);
                instancePath.cubicTo(76.07273f, 55.408306f, 74.99821f, 54.363636f, 73.67273f, 54.363636f);
                instancePath.cubicTo(73.6484f, 54.363636f, 73.62415f, 54.363987f, 73.6f, 54.36469f);
                instancePath.lineTo(73.6f, 54.36469f);
                instancePath.close();
                instancePath.moveTo(40.609066f, 50.662968f);
                instancePath.cubicTo(39.716667f, 49.832478f, 38.109093f, 47.997643f, 38.109093f, 47.997643f);
                instancePath.cubicTo(38.109093f, 47.997643f, 39.716045f, 46.168102f, 40.609066f, 45.337032f);
                instancePath.cubicTo(43.12674f, 42.994022f, 45.69869f, 41.636364f, 48.064846f, 41.636364f);
                instancePath.cubicTo(50.431f, 41.636364f, 53.00295f, 42.994022f, 55.520622f, 45.337032f);
                instancePath.cubicTo(56.40689f, 46.161816f, 57.890907f, 47.997643f, 57.890907f, 47.997643f);
                instancePath.cubicTo(57.890907f, 47.997643f, 56.4091f, 49.83613f, 55.520622f, 50.662968f);
                instancePath.cubicTo(53.00295f, 53.005978f, 50.431f, 54.363636f, 48.064846f, 54.363636f);
                instancePath.cubicTo(45.69869f, 54.363636f, 43.12674f, 53.005978f, 40.609066f, 50.662968f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
