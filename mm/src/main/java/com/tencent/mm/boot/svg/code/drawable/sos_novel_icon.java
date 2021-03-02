package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sos_novel_icon extends c {
    private final int height = 42;
    private final int width = 42;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-4210753);
                instancePaint5.setColor(-4210753);
                instancePaint5.setStrokeWidth(0.5f);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(39.26192f, 36.23582f);
                instancePath.cubicTo(35.93297f, 35.993877f, 25.853132f, 35.550735f, 21.830994f, 38.503082f);
                instancePath.lineTo(21.830994f, 36.134388f);
                instancePath.cubicTo(22.104116f, 34.477383f, 25.907093f, 33.48717f, 32.026222f, 33.48717f);
                instancePath.cubicTo(34.581463f, 33.48717f, 36.614532f, 33.66426f, 36.634457f, 33.665924f);
                instancePath.cubicTo(36.8669f, 33.694195f, 37.096027f, 33.60939f, 37.26787f, 33.447266f);
                instancePath.cubicTo(37.439713f, 33.287632f, 37.537674f, 33.06149f, 37.537674f, 32.825367f);
                instancePath.lineTo(37.537674f, 5.576668f);
                instancePath.cubicTo(38.23418f, 5.498515f, 38.821934f, 5.441148f, 39.26192f, 5.402903f);
                instancePath.lineTo(39.26192f, 36.23582f);
                instancePath.close();
                instancePath.moveTo(2.7380788f, 36.23582f);
                instancePath.lineTo(2.7380788f, 5.40706f);
                instancePath.cubicTo(3.1747444f, 5.447799f, 3.758349f, 5.5068293f, 4.463157f, 5.5874763f);
                instancePath.lineTo(4.463157f, 32.825367f);
                instancePath.cubicTo(4.463157f, 33.06149f, 4.560286f, 33.287632f, 4.73213f, 33.447266f);
                instancePath.cubicTo(4.9048038f, 33.607727f, 5.13891f, 33.6917f, 5.366374f, 33.665924f);
                instancePath.cubicTo(5.386298f, 33.66426f, 7.4185367f, 33.48717f, 9.973778f, 33.48717f);
                instancePath.cubicTo(16.093739f, 33.48717f, 19.895884f, 34.477383f, 20.169838f, 36.134388f);
                instancePath.lineTo(20.169838f, 38.493935f);
                instancePath.cubicTo(16.143547f, 35.54824f, 6.0662017f, 35.993877f, 2.7380788f, 36.23582f);
                instancePath.lineTo(2.7380788f, 36.23582f);
                instancePath.close();
                instancePath.moveTo(6.124313f, 3.9030354f);
                instancePath.cubicTo(12.020959f, 4.377772f, 19.808716f, 6.0497413f, 20.169838f, 8.465825f);
                instancePath.lineTo(20.169838f, 33.5911f);
                instancePath.cubicTo(18.30363f, 32.400517f, 14.894153f, 31.799406f, 9.973778f, 31.799406f);
                instancePath.cubicTo(8.364092f, 31.799406f, 6.9785504f, 31.866749f, 6.124313f, 31.91996f);
                instancePath.lineTo(6.124313f, 3.9030354f);
                instancePath.close();
                instancePath.moveTo(35.87652f, 3.903867f);
                instancePath.lineTo(35.87652f, 31.91996f);
                instancePath.cubicTo(35.02228f, 31.866749f, 33.63508f, 31.799406f, 32.026222f, 31.799406f);
                instancePath.cubicTo(27.105017f, 31.799406f, 23.69554f, 32.40135f, 21.830162f, 33.5911f);
                instancePath.lineTo(21.821861f, 8.588874f);
                instancePath.cubicTo(22.191284f, 6.0572243f, 29.979872f, 4.3794346f, 35.87652f, 3.903867f);
                instancePath.lineTo(35.87652f, 3.903867f);
                instancePath.close();
                instancePath.moveTo(40.660744f, 3.8739362f);
                instancePath.cubicTo(40.49222f, 3.7159677f, 40.263096f, 3.637815f, 40.039783f, 3.6469605f);
                instancePath.cubicTo(40.039783f, 3.6469605f, 39.062683f, 3.7118106f, 37.537674f, 3.879756f);
                instancePath.lineTo(37.537674f, 2.9976277f);
                instancePath.cubicTo(37.537674f, 2.7656639f, 37.442204f, 2.5436766f, 37.276173f, 2.3832142f);
                instancePath.cubicTo(37.10931f, 2.223583f, 36.882675f, 2.1412733f, 36.65687f, 2.1554072f);
                instancePath.cubicTo(34.371433f, 2.2975788f, 24.132204f, 3.1223395f, 21.034037f, 6.6890974f);
                instancePath.cubicTo(18.032999f, 3.1348107f, 7.6468315f, 2.2984102f, 5.34396f, 2.1554072f);
                instancePath.cubicTo(5.1140046f, 2.1421046f, 4.891521f, 2.223583f, 4.7238283f, 2.3832142f);
                instancePath.cubicTo(4.5577955f, 2.5436766f, 4.463157f, 2.7656639f, 4.463157f, 2.9976277f);
                instancePath.lineTo(4.463157f, 3.8897328f);
                instancePath.cubicTo(2.907432f, 3.7151363f, 1.9651973f, 3.6469605f, 1.9651973f, 3.6469605f);
                instancePath.cubicTo(1.734412f, 3.637815f, 1.5094379f, 3.7134736f, 1.3409148f, 3.8722732f);
                instancePath.cubicTo(1.173222f, 4.031904f, 1.0769231f, 4.255554f, 1.0769231f, 4.489181f);
                instancePath.lineTo(1.0769231f, 37.148712f);
                instancePath.cubicTo(1.0769231f, 37.38483f, 1.1757125f, 37.61181f, 1.3475561f, 37.77144f);
                instancePath.cubicTo(1.5185697f, 37.9319f, 1.7559962f, 38.01338f, 1.9818006f, 37.98927f);
                instancePath.cubicTo(8.751778f, 37.37735f, 19.67506f, 37.72571f, 20.177309f, 41.276672f);
                instancePath.cubicTo(20.1798f, 41.294132f, 20.190592f, 41.308266f, 20.193913f, 41.325726f);
                instancePath.cubicTo(20.203043f, 41.371452f, 20.220476f, 41.413025f, 20.23708f, 41.456257f);
                instancePath.cubicTo(20.258665f, 41.511963f, 20.280249f, 41.56517f, 20.312626f, 41.615055f);
                instancePath.cubicTo(20.3367f, 41.651638f, 20.364096f, 41.68323f, 20.393982f, 41.715656f);
                instancePath.cubicTo(20.433828f, 41.76055f, 20.474506f, 41.798798f, 20.522655f, 41.83455f);
                instancePath.cubicTo(20.558353f, 41.86032f, 20.59405f, 41.88194f, 20.634727f, 41.901894f);
                instancePath.cubicTo(20.688688f, 41.93016f, 20.74514f, 41.949284f, 20.804913f, 41.96425f);
                instancePath.cubicTo(20.832308f, 41.97007f, 20.853891f, 41.98753f, 20.882116f, 41.991688f);
                instancePath.cubicTo(20.921135f, 41.997505f, 20.960152f, 42.0f, 20.99834f, 42.0f);
                instancePath.lineTo(20.99917f, 42.0f);
                instancePath.lineTo(21.0f, 42.0f);
                instancePath.lineTo(21.00083f, 42.0f);
                instancePath.lineTo(21.00166f, 42.0f);
                instancePath.cubicTo(21.020754f, 42.0f, 21.039848f, 41.99917f, 21.05894f, 41.997505f);
                instancePath.cubicTo(21.09381f, 41.99501f, 21.123693f, 41.97755f, 21.1569f, 41.9709f);
                instancePath.cubicTo(21.215843f, 41.95926f, 21.273123f, 41.948452f, 21.327915f, 41.925175f);
                instancePath.cubicTo(21.369423f, 41.90605f, 21.405119f, 41.880276f, 21.442476f, 41.855335f);
                instancePath.cubicTo(21.488966f, 41.826237f, 21.532965f, 41.796303f, 21.571981f, 41.75806f);
                instancePath.cubicTo(21.605188f, 41.725636f, 21.630095f, 41.689884f, 21.65749f, 41.651638f);
                instancePath.cubicTo(21.689865f, 41.607574f, 21.719751f, 41.56517f, 21.743826f, 41.514454f);
                instancePath.cubicTo(21.76375f, 41.47039f, 21.775372f, 41.426327f, 21.788654f, 41.378937f);
                instancePath.cubicTo(21.798616f, 41.344017f, 21.81771f, 41.313255f, 21.822691f, 41.276672f);
                instancePath.cubicTo(22.32411f, 37.72488f, 33.24905f, 37.375687f, 40.0182f, 37.98927f);
                instancePath.cubicTo(40.257286f, 38.01504f, 40.48226f, 37.9319f, 40.653275f, 37.77144f);
                instancePath.cubicTo(40.82512f, 37.61181f, 40.923077f, 37.38483f, 40.923077f, 37.148712f);
                instancePath.lineTo(40.923077f, 4.489181f);
                instancePath.cubicTo(40.923077f, 4.256386f, 40.82761f, 4.033567f, 40.660744f, 3.8739362f);
                instancePath.lineTo(40.660744f, 3.8739362f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
