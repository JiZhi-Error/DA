package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_line_thumb extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                instancePath.moveTo(30.978317f, 6.924232f);
                instancePath.cubicTo(32.202652f, 8.727818f, 32.531406f, 10.6306305f, 32.531406f, 14.630878f);
                instancePath.cubicTo(32.531406f, 15.722366f, 32.239555f, 15.994292f, 32.62976f, 16.68274f);
                instancePath.cubicTo(33.4496f, 16.696165f, 37.600334f, 16.97483f, 38.73455f, 17.384256f);
                instancePath.cubicTo(40.143074f, 17.892702f, 41.223366f, 18.710272f, 41.77255f, 19.934034f);
                instancePath.cubicTo(43.73279f, 24.30208f, 41.271797f, 36.09096f, 36.667828f, 39.880844f);
                instancePath.cubicTo(35.286457f, 41.018406f, 32.486027f, 40.87847f, 30.341778f, 41.054058f);
                instancePath.cubicTo(29.00628f, 41.163147f, 22.168457f, 41.14863f, 9.950839f, 41.070717f);
                instancePath.cubicTo(8.248931f, 41.060577f, 6.8705883f, 39.693882f, 6.8705883f, 38.00158f);
                instancePath.lineTo(6.8705883f, 23.440556f);
                instancePath.cubicTo(6.8705883f, 21.740942f, 8.264331f, 20.371399f, 9.974019f, 20.371399f);
                instancePath.lineTo(13.723339f, 20.371399f);
                instancePath.cubicTo(14.657195f, 20.371399f, 15.530533f, 20.28378f, 16.57245f, 20.054485f);
                instancePath.cubicTo(17.307594f, 19.892618f, 17.918371f, 19.601696f, 19.040604f, 18.943678f);
                instancePath.cubicTo(20.298344f, 18.206264f, 21.039513f, 17.369343f, 21.595888f, 15.898155f);
                instancePath.cubicTo(21.91047f, 15.065036f, 22.017292f, 14.247739f, 22.13168f, 11.8294525f);
                instancePath.cubicTo(22.14685f, 11.50924f, 22.150642f, 11.4084835f, 22.176422f, 10.681596f);
                instancePath.cubicTo(22.293335f, 7.385011f, 22.642885f, 6.2104573f, 24.468605f, 5.3626237f);
                instancePath.cubicTo(26.908642f, 4.229363f, 29.823425f, 5.2225847f, 30.978317f, 6.924232f);
                instancePath.close();
                instancePath.moveTo(25.479446f, 7.5393643f);
                instancePath.cubicTo(24.764402f, 7.8714185f, 24.669304f, 8.105178f, 24.574915f, 10.766658f);
                instancePath.cubicTo(24.548168f, 11.5208025f, 24.544392f, 11.617986f, 24.528997f, 11.942848f);
                instancePath.cubicTo(24.402916f, 14.608395f, 24.271769f, 15.605546f, 23.840721f, 16.747108f);
                instancePath.cubicTo(23.10174f, 18.701153f, 22.013653f, 19.98266f, 20.254547f, 21.014025f);
                instancePath.cubicTo(19.283278f, 21.583527f, 18.603758f, 21.929937f, 17.931679f, 22.162333f);
                instancePath.lineTo(17.932915f, 38.71525f);
                instancePath.cubicTo(25.591442f, 38.749672f, 29.2768f, 38.733055f, 30.145905f, 38.662064f);
                instancePath.cubicTo(31.817118f, 38.52521f, 34.153946f, 38.841984f, 35.142517f, 38.027893f);
                instancePath.cubicTo(38.45871f, 35.298077f, 41.378918f, 24.918703f, 39.58293f, 20.916666f);
                instancePath.cubicTo(39.34846f, 20.394192f, 38.830044f, 19.970306f, 37.91967f, 19.641684f);
                instancePath.cubicTo(37.159386f, 19.367237f, 33.340054f, 19.226685f, 32.713535f, 19.21514f);
                instancePath.cubicTo(32.05374f, 19.225937f, 31.297766f, 19.054031f, 30.665209f, 18.664547f);
                instancePath.cubicTo(29.452698f, 17.917969f, 30.131407f, 16.44661f, 30.131407f, 14.630878f);
                instancePath.cubicTo(30.131407f, 10.9569235f, 29.854202f, 9.541406f, 28.992617f, 8.272192f);
                instancePath.cubicTo(28.416805f, 7.4237766f, 26.719181f, 6.9635773f, 25.479446f, 7.5393643f);
                instancePath.close();
                instancePath.moveTo(13.723339f, 22.771399f);
                instancePath.lineTo(9.974019f, 22.771399f);
                instancePath.cubicTo(9.579756f, 22.771399f, 9.270588f, 23.076546f, 9.270588f, 23.440556f);
                instancePath.lineTo(9.270588f, 38.00158f);
                instancePath.cubicTo(9.270588f, 38.3657f, 9.574876f, 38.668434f, 9.966143f, 38.670765f);
                instancePath.cubicTo(11.990643f, 38.683678f, 13.842908f, 38.69459f, 15.532152f, 38.703484f);
                instancePath.lineTo(15.5321f, 22.665977f);
                instancePath.cubicTo(14.932917f, 22.73797f, 14.342154f, 22.771399f, 13.723339f, 22.771399f);
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
