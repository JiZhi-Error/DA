package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class state_icon_main extends c {
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
                instancePaint3.setColor(-436207616);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(3.339746f, 7.0f);
                instancePath2.cubicTo(6.1011696f, 2.2170737f, 12.217073f, 0.57832223f, 17.0f, 3.339746f);
                instancePath2.lineTo(17.0f, 3.339746f);
                instancePath2.lineTo(17.097633f, 3.403883f);
                instancePath2.cubicTo(17.499458f, 3.7025783f, 17.622444f, 4.2616425f, 17.366026f, 4.7057714f);
                instancePath2.cubicTo(17.109608f, 5.1499004f, 16.563951f, 5.322924f, 16.10436f, 5.124281f);
                instancePath2.lineTo(16.10436f, 5.124281f);
                instancePath2.lineTo(16.0f, 5.071797f);
                instancePath2.cubicTo(12.173659f, 2.8626578f, 7.280936f, 4.173659f, 5.071797f, 8.0f);
                instancePath2.cubicTo(3.5914671f, 10.564006f, 3.6917694f, 13.606845f, 5.07037f, 16.000193f);
                instancePath2.lineTo(5.071797f, 16.0f);
                instancePath2.cubicTo(5.2769623f, 16.355358f, 5.505274f, 16.68902f, 5.753728f, 17.000181f);
                instancePath2.cubicTo(5.774791f, 17.028175f, 5.7974195f, 17.056076f, 5.820252f, 17.083838f);
                instancePath2.lineTo(5.753728f, 17.000181f);
                instancePath2.cubicTo(5.866292f, 17.141157f, 5.9829907f, 17.277514f, 6.103544f, 17.409176f);
                instancePath2.cubicTo(6.1263537f, 17.434662f, 6.149538f, 17.459597f, 6.1728997f, 17.484398f);
                instancePath2.lineTo(6.103544f, 17.409176f);
                instancePath2.cubicTo(6.13994f, 17.448925f, 6.176687f, 17.488247f, 6.2137775f, 17.52714f);
                instancePath2.lineTo(6.1728997f, 17.484398f);
                instancePath2.cubicTo(6.6952653f, 18.038975f, 7.306295f, 18.527693f, 8.0f, 18.928204f);
                instancePath2.lineTo(8.0f, 18.928204f);
                instancePath2.lineTo(8.108397f, 18.991055f);
                instancePath2.cubicTo(10.484714f, 20.310894f, 13.474615f, 20.386234f, 16.0f, 18.928204f);
                instancePath2.cubicTo(19.826342f, 16.719065f, 21.137342f, 11.826341f, 18.928204f, 8.0f);
                instancePath2.lineTo(18.87572f, 7.8956394f);
                instancePath2.cubicTo(18.677076f, 7.436049f, 18.8501f, 6.8903923f, 19.29423f, 6.6339746f);
                instancePath2.cubicTo(19.738358f, 6.377557f, 20.297422f, 6.5005417f, 20.596117f, 6.902367f);
                instancePath2.lineTo(20.660254f, 7.0f);
                instancePath2.cubicTo(23.421679f, 11.782927f, 21.782927f, 17.89883f, 17.0f, 20.660254f);
                instancePath2.cubicTo(13.0282135f, 22.953365f, 8.137232f, 22.212206f, 5.011252f, 19.156004f);
                instancePath2.cubicTo(4.98872f, 19.13382f, 4.9665284f, 19.11197f, 4.9444532f, 19.090033f);
                instancePath2.cubicTo(4.904726f, 19.050493f, 4.865265f, 19.010504f, 4.8261023f, 18.970137f);
                instancePath2.cubicTo(1.7848381f, 15.843189f, 1.0512244f, 10.963836f, 3.339746f, 7.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
