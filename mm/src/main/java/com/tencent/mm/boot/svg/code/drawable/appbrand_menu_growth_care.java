package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class appbrand_menu_growth_care extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(14211288);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(72.0f, 0.0f);
                instancePath.lineTo(72.0f, 72.0f);
                instancePath.lineTo(0.0f, 72.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-15132391);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(36.0f, 6.75f);
                instancePath2.cubicTo(52.154213f, 6.75f, 65.25f, 19.8465f, 65.25f, 36.0f);
                instancePath2.cubicTo(65.25f, 43.38663f, 62.49921f, 50.34643f, 57.631737f, 55.68632f);
                instancePath2.cubicTo(53.015167f, 60.83664f, 46.63318f, 64.18186f, 39.621735f, 65.02711f);
                instancePath2.lineTo(39.131557f, 65.082016f);
                instancePath2.lineTo(39.057266f, 65.09049f);
                instancePath2.cubicTo(39.013657f, 65.09563f, 39.004932f, 65.09665f, 38.93995f, 65.102936f);
                instancePath2.lineTo(38.87924f, 65.10879f);
                instancePath2.lineTo(38.924732f, 65.105095f);
                instancePath2.cubicTo(38.655144f, 65.13087f, 38.43797f, 65.146805f, 38.001488f, 65.17538f);
                instancePath2.cubicTo(37.81352f, 65.18984f, 37.64148f, 65.201225f, 37.507706f, 65.20776f);
                instancePath2.lineTo(37.4149f, 65.21173f);
                instancePath2.lineTo(37.348106f, 65.21685f);
                instancePath2.cubicTo(37.30823f, 65.2192f, 37.29494f, 65.219986f, 37.278824f, 65.220436f);
                instancePath2.lineTo(37.24886f, 65.22102f);
                instancePath2.lineTo(36.142067f, 65.25f);
                instancePath2.lineTo(17.27158f, 65.25f);
                instancePath2.lineTo(17.27158f, 58.459328f);
                instancePath2.cubicTo(10.661769f, 52.944294f, 6.75f, 44.793507f, 6.75f, 36.0f);
                instancePath2.cubicTo(6.75f, 19.8465f, 19.845785f, 6.75f, 36.0f, 6.75f);
                instancePath2.close();
                instancePath2.moveTo(36.0f, 9.927557f);
                instancePath2.cubicTo(21.60074f, 9.927557f, 9.927557f, 21.601377f, 9.927557f, 36.0f);
                instancePath2.cubicTo(9.927557f, 43.925705f, 13.489544f, 51.260807f, 19.502907f, 56.181133f);
                instancePath2.lineTo(19.845898f, 56.45705f);
                instancePath2.lineTo(20.449137f, 56.934128f);
                instancePath2.lineTo(20.449137f, 62.072445f);
                instancePath2.lineTo(34.411f, 62.073f);
                instancePath2.lineTo(34.411f, 46.129f);
                instancePath2.lineTo(34.32948f, 46.12351f);
                instancePath2.cubicTo(27.053284f, 45.631683f, 22.384453f, 42.16125f, 19.990437f, 36.760548f);
                instancePath2.cubicTo(19.189978f, 34.95478f, 18.696262f, 33.03974f, 18.446674f, 31.102865f);
                instancePath2.cubicTo(18.278881f, 29.800728f, 18.240044f, 28.658918f, 18.27469f, 27.763266f);
                instancePath2.cubicTo(18.281588f, 27.612185f, 18.282738f, 27.587004f, 18.285284f, 27.549316f);
                instancePath2.lineTo(18.287037f, 27.524096f);
                instancePath2.lineTo(18.381292f, 26.225666f);
                instancePath2.lineTo(19.672913f, 26.062824f);
                instancePath2.cubicTo(28.51845f, 24.947618f, 33.635395f, 28.759094f, 35.47907f, 35.585552f);
                instancePath2.cubicTo(35.71062f, 36.4429f, 35.882046f, 37.311783f, 36.0014f, 38.1805f);
                instancePath2.cubicTo(36.117935f, 37.311886f, 36.289436f, 36.44291f, 36.521072f, 35.58546f);
                instancePath2.cubicTo(38.365185f, 28.75907f, 43.481907f, 24.947607f, 52.326454f, 26.062828f);
                instancePath2.lineTo(53.617874f, 26.225664f);
                instancePath2.lineTo(53.71229f, 27.523878f);
                instancePath2.cubicTo(53.716377f, 27.581894f, 53.716377f, 27.581894f, 53.724697f, 27.7637f);
                instancePath2.cubicTo(53.759422f, 28.659683f, 53.72066f, 29.801622f, 53.552948f, 31.103745f);
                instancePath2.cubicTo(53.30352f, 33.04031f, 52.809998f, 34.955013f, 52.00979f, 36.760475f);
                instancePath2.cubicTo(49.616077f, 42.161243f, 44.94698f, 45.63169f, 37.669853f, 46.12351f);
                instancePath2.lineTo(37.588f, 46.128f);
                instancePath2.lineTo(37.58798f, 62.019608f);
                instancePath2.cubicTo(37.647118f, 62.015526f, 37.70932f, 62.01098f, 37.775486f, 62.00592f);
                instancePath2.cubicTo(38.13829f, 61.982086f, 38.33367f, 61.968147f, 38.554462f, 61.948586f);
                instancePath2.lineTo(38.66787f, 61.938267f);
                instancePath2.lineTo(38.615463f, 61.942635f);
                instancePath2.lineTo(38.685997f, 61.934704f);
                instancePath2.lineTo(38.804523f, 61.921333f);
                instancePath2.cubicTo(45.219128f, 61.257477f, 51.066013f, 58.250538f, 55.27449f, 53.555576f);
                instancePath2.cubicTo(59.622482f, 48.78551f, 62.072445f, 42.586838f, 62.072445f, 36.0f);
                instancePath2.cubicTo(62.072445f, 21.601377f, 50.39926f, 9.927557f, 36.0f, 9.927557f);
                instancePath2.close();
                instancePath2.moveTo(39.58867f, 36.41415f);
                instancePath2.cubicTo(39.025726f, 38.498005f, 38.878445f, 40.728836f, 38.994663f, 42.79274f);
                instancePath2.cubicTo(44.146805f, 42.054527f, 47.344593f, 39.444317f, 49.10478f, 35.472923f);
                instancePath2.cubicTo(49.770763f, 33.970303f, 50.188847f, 32.348278f, 50.401424f, 30.697828f);
                instancePath2.cubicTo(50.476486f, 30.115044f, 50.521275f, 29.572277f, 50.54288f, 29.082779f);
                instancePath2.cubicTo(44.24828f, 28.683489f, 40.939747f, 31.412825f, 39.58867f, 36.41415f);
                instancePath2.close();
                instancePath2.moveTo(21.456656f, 29.082777f);
                instancePath2.cubicTo(21.478312f, 29.571947f, 21.523125f, 30.114351f, 21.598175f, 30.69676f);
                instancePath2.cubicTo(21.810894f, 32.34753f, 22.229158f, 33.96991f, 22.89538f, 35.47285f);
                instancePath2.cubicTo(24.655832f, 39.444283f, 27.853477f, 42.05451f, 33.004856f, 42.792732f);
                instancePath2.cubicTo(33.1213f, 40.72873f, 32.974216f, 38.49788f, 32.411423f, 36.41406f);
                instancePath2.cubicTo(31.060696f, 31.412804f, 27.752077f, 28.683483f, 21.456656f, 29.082777f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
