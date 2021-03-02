package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class video extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-352965);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(18.34758f, 4.1598577f);
                instancePath.cubicTo(19.372652f, 3.7451997f, 20.249046f, 4.1429806f, 20.705755f, 5.2862372f);
                instancePath.cubicTo(21.934772f, 8.362055f, 19.057901f, 20.0f, 16.800821f, 20.0f);
                instancePath.cubicTo(16.070543f, 20.0f, 15.338678f, 19.392347f, 14.486037f, 18.300108f);
                instancePath.cubicTo(14.101753f, 17.807835f, 13.700608f, 17.221043f, 13.288172f, 16.558764f);
                instancePath.cubicTo(12.958235f, 16.028961f, 12.633918f, 15.471924f, 12.322351f, 14.908183f);
                instancePath.lineTo(12.000244f, 14.31476f);
                instancePath.lineTo(12.000244f, 14.31476f);
                instancePath.lineTo(11.984712f, 14.342968f);
                instancePath.cubicTo(11.581678f, 15.097541f, 11.151753f, 15.85236f, 10.711838f, 16.558764f);
                instancePath.cubicTo(10.299402f, 17.221043f, 9.898257f, 17.807835f, 9.513972f, 18.300108f);
                instancePath.cubicTo(8.661331f, 19.392347f, 7.929466f, 20.0f, 7.199188f, 20.0f);
                instancePath.cubicTo(4.9421086f, 20.0f, 2.065237f, 8.362055f, 3.2942386f, 5.286279f);
                instancePath.cubicTo(3.7509627f, 4.1429806f, 4.627358f, 3.7451997f, 5.65243f, 4.1598577f);
                instancePath.cubicTo(6.3956456f, 4.4605007f, 7.215896f, 5.179352f, 8.132514f, 6.2562065f);
                instancePath.cubicTo(8.677987f, 6.8970356f, 9.248601f, 7.65591f, 9.83592f, 8.509013f);
                instancePath.cubicTo(10.486207f, 9.453581f, 11.1233015f, 10.463639f, 11.721407f, 11.47347f);
                instancePath.lineTo(12.000347f, 11.948709f);
                instancePath.lineTo(12.278603f, 11.47347f);
                instancePath.cubicTo(12.757088f, 10.665606f, 13.260525f, 9.857595f, 13.775707f, 9.083087f);
                instancePath.lineTo(14.16409f, 8.509013f);
                instancePath.cubicTo(14.751409f, 7.65591f, 15.322022f, 6.8970356f, 15.867496f, 6.2562065f);
                instancePath.cubicTo(16.784115f, 5.179352f, 17.604364f, 4.4605007f, 18.34758f, 4.1598577f);
                instancePath.close();
                instancePath.moveTo(5.227365f, 5.193452f);
                instancePath.cubicTo(4.7944946f, 5.0183487f, 4.5714617f, 5.1195793f, 4.3406005f, 5.697485f);
                instancePath.cubicTo(3.9371855f, 6.7070966f, 4.1065893f, 9.251233f, 4.7046323f, 12.106244f);
                instancePath.lineTo(4.8445277f, 12.745311f);
                instancePath.lineTo(4.9981833f, 13.391628f);
                instancePath.cubicTo(5.7530503f, 16.445328f, 6.8390894f, 18.88374f, 7.199188f, 18.88374f);
                instancePath.cubicTo(7.4456573f, 18.88374f, 7.983661f, 18.437046f, 8.624014f, 17.616749f);
                instancePath.cubicTo(8.981315f, 17.159042f, 9.361088f, 16.603512f, 9.754249f, 15.972185f);
                instancePath.cubicTo(10.0733795f, 15.459734f, 10.388362f, 14.918681f, 10.691383f, 14.370374f);
                instancePath.lineTo(11.057707f, 13.693418f);
                instancePath.lineTo(11.057707f, 13.693418f);
                instancePath.lineTo(11.365028f, 13.101507f);
                instancePath.lineTo(11.043724f, 12.538866f);
                instancePath.lineTo(10.750942f, 12.03885f);
                instancePath.cubicTo(10.164847f, 11.049299f, 9.5408325f, 10.059978f, 8.906412f, 9.138456f);
                instancePath.cubicTo(8.339149f, 8.314485f, 7.79065f, 7.5850215f, 7.2724867f, 6.9762764f);
                instancePath.cubicTo(6.46444f, 6.026973f, 5.7585073f, 5.4083076f, 5.227365f, 5.193452f);
                instancePath.close();
                instancePath.moveTo(19.659393f, 5.6974425f);
                instancePath.cubicTo(19.428549f, 5.1195793f, 19.205515f, 5.0183487f, 18.772644f, 5.193452f);
                instancePath.cubicTo(18.241503f, 5.4083076f, 17.53557f, 6.026973f, 16.727524f, 6.9762764f);
                instancePath.cubicTo(16.20936f, 7.5850215f, 15.660861f, 8.314485f, 15.093598f, 9.138456f);
                instancePath.cubicTo(14.5860615f, 9.875673f, 14.085185f, 10.656282f, 13.605055f, 11.445687f);
                instancePath.lineTo(13.098865f, 12.293914f);
                instancePath.lineTo(12.634044f, 13.101507f);
                instancePath.lineTo(12.793481f, 13.409993f);
                instancePath.lineTo(13.009882f, 13.820438f);
                instancePath.cubicTo(13.40212f, 14.554801f, 13.820253f, 15.288918f, 14.245761f, 15.972185f);
                instancePath.cubicTo(14.638922f, 16.603512f, 15.018695f, 17.159042f, 15.375996f, 17.616749f);
                instancePath.cubicTo(16.016348f, 18.437046f, 16.554352f, 18.88374f, 16.800821f, 18.88374f);
                instancePath.cubicTo(17.160921f, 18.88374f, 18.24696f, 16.445328f, 19.001827f, 13.391628f);
                instancePath.lineTo(19.155481f, 12.745311f);
                instancePath.cubicTo(19.865181f, 9.636561f, 20.092707f, 6.78188f, 19.659393f, 5.6974425f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
