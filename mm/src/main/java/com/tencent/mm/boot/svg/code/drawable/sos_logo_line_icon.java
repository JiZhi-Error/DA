package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sos_logo_line_icon extends c {
    private final int height = 16;
    private final int width = 16;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 16;
            case 1:
                return 16;
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
                canvas.saveLayerAlpha(null, 76, 31);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(8.053039f, 8.424382f);
                instancePath.lineTo(13.386331f, 14.30468f);
                instancePath.cubicTo(13.572036f, 14.509431f, 13.556595f, 14.825957f, 13.351844f, 15.0116625f);
                instancePath.cubicTo(13.346663f, 15.01636f, 13.341386f, 15.02095f, 13.336013f, 15.025427f);
                instancePath.lineTo(12.780119f, 15.488671f);
                instancePath.cubicTo(12.567766f, 15.665633f, 12.252165f, 15.636942f, 12.075203f, 15.424588f);
                instancePath.cubicTo(12.067352f, 15.415168f, 12.059852f, 15.405462f, 12.052713f, 15.395491f);
                instancePath.lineTo(7.4096556f, 8.908865f);
                instancePath.cubicTo(7.286471f, 8.736769f, 7.323329f, 8.497787f, 7.4926414f, 8.370804f);
                instancePath.cubicTo(7.665267f, 8.241335f, 7.908073f, 8.264549f, 8.053039f, 8.424382f);
                instancePath.close();
                instancePath.moveTo(5.2081285f, 8.56118f);
                instancePath.cubicTo(5.421062f, 8.62506f, 5.5459476f, 8.845272f, 5.4914722f, 9.060803f);
                instancePath.lineTo(3.9712515f, 15.07559f);
                instancePath.cubicTo(3.9035165f, 15.343584f, 3.631354f, 15.505927f, 3.3633592f, 15.438192f);
                instancePath.cubicTo(3.3492568f, 15.434628f, 3.3353162f, 15.43045f, 3.3215775f, 15.425672f);
                instancePath.lineTo(2.588795f, 15.170791f);
                instancePath.cubicTo(2.3277152f, 15.07998f, 2.1896846f, 14.794717f, 2.280495f, 14.533637f);
                instancePath.cubicTo(2.2838771f, 14.523913f, 2.2875586f, 14.514297f, 2.291534f, 14.504799f);
                instancePath.lineTo(4.6738796f, 8.81364f);
                instancePath.cubicTo(4.761138f, 8.605189f, 4.9916816f, 8.496245f, 5.2081285f, 8.56118f);
                instancePath.close();
                instancePath.moveTo(15.964497f, 5.446093f);
                instancePath.cubicTo(15.96625f, 5.459984f, 15.96742f, 5.473942f, 15.968002f, 5.4879303f);
                instancePath.lineTo(15.9995575f, 6.2452593f);
                instancePath.cubicTo(16.011066f, 6.5214415f, 15.796504f, 6.7546606f, 15.520322f, 6.766168f);
                instancePath.lineTo(15.494673f, 6.7665787f);
                instancePath.lineTo(15.494673f, 6.7665787f);
                instancePath.lineTo(8.482579f, 6.699155f);
                instancePath.cubicTo(8.271716f, 6.6971273f, 8.101845f, 6.525615f, 8.101845f, 6.3147416f);
                instancePath.cubicTo(8.101845f, 6.097157f, 8.263728f, 5.9135575f, 8.4796f, 5.8863115f);
                instancePath.lineTo(15.405256f, 5.0122f);
                instancePath.cubicTo(15.6795025f, 4.9775863f, 15.929883f, 5.171847f, 15.964497f, 5.446093f);
                instancePath.close();
                instancePath.moveTo(0.5989167f, 5.1297517f);
                instancePath.cubicTo(0.6195922f, 5.1315494f, 0.6401358f, 5.1346316f, 0.6604287f, 5.13898f);
                instancePath.lineTo(3.9963162f, 5.853813f);
                instancePath.cubicTo(4.2093663f, 5.8994665f, 4.354079f, 6.097936f, 4.3323984f, 6.3147416f);
                instancePath.cubicTo(4.3106856f, 6.5318675f, 4.129906f, 6.6983786f, 3.9117308f, 6.702206f);
                instancePath.lineTo(0.509286f, 6.761898f);
                instancePath.cubicTo(0.2329064f, 6.766747f, 0.004925772f, 6.5466275f, 7.7007084E-5f, 6.270248f);
                instancePath.cubicTo(-2.2823783E-4f, 6.252849f, 3.7411475E-4f, 6.235446f, 0.0018816104f, 6.21811f);
                instancePath.lineTo(0.056933105f, 5.5850177f);
                instancePath.cubicTo(0.08087944f, 5.3096347f, 0.32353377f, 5.1058054f, 0.5989167f, 5.1297517f);
                instancePath.close();
                instancePath.moveTo(7.5873938f, 0.011324541f);
                instancePath.cubicTo(7.6073947f, 0.015632367f, 7.6271124f, 0.021162493f, 7.6464357f, 0.02788379f);
                instancePath.lineTo(8.350196f, 0.27266988f);
                instancePath.cubicTo(8.611276f, 0.36348024f, 8.749307f, 0.64874357f, 8.658496f, 0.90982336f);
                instancePath.cubicTo(8.654003f, 0.92274094f, 8.648982f, 0.9354689f, 8.643447f, 0.9479752f);
                instancePath.lineTo(6.9732676f, 4.7213435f);
                instancePath.cubicTo(6.8806434f, 4.930605f, 6.639012f, 5.0290246f, 6.4265356f, 4.944034f);
                instancePath.cubicTo(6.2066507f, 4.85608f, 6.082264f, 4.6223574f, 6.1321287f, 4.390844f);
                instancePath.lineTo(6.992723f, 0.3952259f);
                instancePath.cubicTo(7.0509257f, 0.12500067f, 7.3171687f, -0.046877816f, 7.5873938f, 0.011324541f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
