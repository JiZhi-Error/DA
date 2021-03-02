package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_outlined_stoptalking extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(24.0f, 0.0f);
                instancePath.lineTo(24.0f, 24.0f);
                instancePath.lineTo(0.0f, 24.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(18.614927f, 15.123624f);
                instancePath2.lineTo(20.214273f, 15.240622f);
                instancePath2.cubicTo(21.01962f, 15.299536f, 21.63066f, 16.005518f, 21.579065f, 16.817478f);
                instancePath2.cubicTo(21.577036f, 16.846445f, 21.577036f, 16.846445f, 21.574251f, 16.875341f);
                instancePath2.lineTo(21.469913f, 17.888712f);
                instancePath2.cubicTo(21.37248f, 18.83505f, 21.175951f, 19.767483f, 20.883614f, 20.670433f);
                instancePath2.cubicTo(20.786757f, 20.969595f, 20.46716f, 21.130854f, 20.169775f, 21.030613f);
                instancePath2.cubicTo(19.87239f, 20.93037f, 19.709831f, 20.60659f, 19.806688f, 20.307426f);
                instancePath2.cubicTo(20.07428f, 19.480911f, 20.254171f, 18.627409f, 20.343359f, 17.761177f);
                instancePath2.lineTo(20.447695f, 16.747807f);
                instancePath2.cubicTo(20.44832f, 16.741308f, 20.44832f, 16.741308f, 20.448778f, 16.734795f);
                instancePath2.cubicTo(20.46038f, 16.5522f, 20.32297f, 16.393438f, 20.141863f, 16.38019f);
                instancePath2.lineTo(18.092813f, 16.230295f);
                instancePath2.cubicTo(18.090668f, 16.230375f, 18.088518f, 16.230444f, 18.086365f, 16.230501f);
                instancePath2.cubicTo(17.77379f, 16.238733f, 17.511642f, 15.98972f, 17.50084f, 15.674318f);
                instancePath2.lineTo(17.362795f, 11.643932f);
                instancePath2.cubicTo(17.351978f, 11.409254f, 17.158884f, 11.230181f, 16.931305f, 11.238947f);
                instancePath2.cubicTo(16.681208f, 11.24858f, 16.484747f, 11.455428f, 16.48581f, 11.707996f);
                instancePath2.lineTo(16.506796f, 17.041836f);
                instancePath2.lineTo(16.611076f, 18.421513f);
                instancePath2.cubicTo(16.642904f, 18.842606f, 16.572372f, 19.253849f, 16.7625f, 19.631416f);
                instancePath2.lineTo(17.242859f, 20.218315f);
                instancePath2.cubicTo(17.384989f, 20.500566f, 17.274359f, 20.84368f, 16.995758f, 20.984678f);
                instancePath2.cubicTo(16.71716f, 21.125677f, 16.37609f, 21.01117f, 16.23396f, 20.728918f);
                instancePath2.lineTo(15.75f, 20.14202f);
                instancePath2.cubicTo(15.491778f, 19.629227f, 15.524981f, 19.070702f, 15.481753f, 18.498796f);
                instancePath2.lineTo(15.375836f, 17.078072f);
                instancePath2.lineTo(15.353214f, 11.703188f);
                instancePath2.cubicTo(15.349575f, 10.838422f, 16.022236f, 10.130196f, 16.87854f, 10.097214f);
                instancePath2.cubicTo(17.73096f, 10.064382f, 18.454212f, 10.735116f, 18.493967f, 11.595341f);
                instancePath2.cubicTo(18.494383f, 11.604731f, 18.494383f, 11.604731f, 18.494722f, 11.614122f);
                instancePath2.lineTo(18.614927f, 15.123624f);
                instancePath2.close();
                instancePath2.moveTo(9.074367f, 5.0620327f);
                instancePath2.cubicTo(9.06696f, 5.0446253f, 9.058975f, 5.027485f, 9.050424f, 5.010642f);
                instancePath2.cubicTo(8.844675f, 4.6053987f, 8.358756f, 4.448167f, 7.965094f, 4.659456f);
                instancePath2.lineTo(4.5580697f, 6.488095f);
                instancePath2.lineTo(4.76508f, 18.34771f);
                instancePath2.lineTo(8.7467785f, 20.021093f);
                instancePath2.cubicTo(8.806372f, 20.046137f, 8.868663f, 20.063736f, 8.932317f, 20.073511f);
                instancePath2.cubicTo(9.371701f, 20.140987f, 9.780704f, 19.829262f, 9.845848f, 19.377253f);
                instancePath2.lineTo(10.473586f, 15.021659f);
                instancePath2.lineTo(12.932181f, 14.130189f);
                instancePath2.lineTo(9.074367f, 5.0620327f);
                instancePath2.close();
                instancePath2.moveTo(13.538127f, 15.226967f);
                instancePath2.lineTo(11.560422f, 15.944069f);
                instancePath2.lineTo(11.039212f, 19.560516f);
                instancePath2.cubicTo(10.87635f, 20.690538f, 9.853847f, 21.469854f, 8.755384f, 21.301165f);
                instancePath2.cubicTo(8.59625f, 21.276726f, 8.44052f, 21.232729f, 8.291539f, 21.170116f);
                instancePath2.lineTo(4.1870584f, 19.445133f);
                instancePath2.cubicTo(3.814626f, 19.28861f, 3.5684679f, 18.91888f, 3.5612464f, 18.505157f);
                instancePath2.lineTo(3.3496237f, 6.3813114f);
                instancePath2.cubicTo(3.3427858f, 5.9895735f, 3.5516458f, 5.6277027f, 3.8891263f, 5.446568f);
                instancePath2.lineTo(7.4062824f, 3.5588183f);
                instancePath2.cubicTo(8.390438f, 3.0305963f, 9.605235f, 3.4236746f, 10.119607f, 4.4367833f);
                instancePath2.cubicTo(10.1409855f, 4.478891f, 10.16095f, 4.521742f, 10.179463f, 4.5652604f);
                instancePath2.lineTo(14.124049f, 13.83738f);
                instancePath2.cubicTo(14.346769f, 14.360906f, 14.115013f, 14.970651f, 13.606406f, 15.199285f);
                instancePath2.cubicTo(13.583982f, 15.209364f, 13.561208f, 15.218598f, 13.538127f, 15.226967f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
