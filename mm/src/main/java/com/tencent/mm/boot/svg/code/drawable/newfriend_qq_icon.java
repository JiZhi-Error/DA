package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class newfriend_qq_icon extends c {
    private final int height = 144;
    private final int width = 144;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                instancePaint3.setColor(-12864012);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(61.0f, 28.0f);
                instancePath.cubicTo(69.75619f, 24.513273f, 80.44056f, 25.540365f, 88.0f, 31.0f);
                instancePath.cubicTo(99.49052f, 38.12475f, 105.527336f, 51.995487f, 104.0f, 65.0f);
                instancePath.cubicTo(110.17489f, 71.84929f, 114.192764f, 81.232735f, 114.0f, 91.0f);
                instancePath.cubicTo(113.86294f, 93.936775f, 113.43317f, 97.58644f, 111.0f, 100.0f);
                instancePath.cubicTo(107.31639f, 98.0252f, 105.30745f, 95.013725f, 103.0f, 92.0f);
                instancePath.cubicTo(102.95869f, 95.35277f, 101.62939f, 98.33433f, 100.0f, 101.0f);
                instancePath.cubicTo(103.068634f, 102.62219f, 106.66673f, 105.61372f, 106.0f, 110.0f);
                instancePath.cubicTo(105.547325f, 114.269226f, 101.06969f, 116.8918f, 97.0f, 118.0f);
                instancePath.cubicTo(89.645706f, 120.112686f, 80.430565f, 118.98587f, 75.0f, 113.0f);
                instancePath.cubicTo(73.86403f, 112.59396f, 72.29485f, 112.59396f, 71.0f, 113.0f);
                instancePath.cubicTo(65.968185f, 118.73658f, 57.23279f, 119.93319f, 50.0f, 118.0f);
                instancePath.cubicTo(45.678883f, 117.26076f, 40.611553f, 114.58832f, 40.0f, 110.0f);
                instancePath.cubicTo(39.50214f, 106.132256f, 42.310658f, 103.459816f, 45.0f, 102.0f);
                instancePath.cubicTo(42.580517f, 98.952576f, 41.071312f, 95.65192f, 41.0f, 92.0f);
                instancePath.cubicTo(38.672577f, 95.00375f, 36.67363f, 98.055115f, 33.0f, 100.0f);
                instancePath.cubicTo(30.556854f, 97.556526f, 30.12708f, 93.91683f, 30.0f, 91.0f);
                instancePath.cubicTo(29.80725f, 81.22276f, 33.815136f, 71.84929f, 40.0f, 65.0f);
                instancePath.cubicTo(37.763058f, 50.021076f, 46.53843f, 33.687305f, 61.0f, 28.0f);
                instancePath.lineTo(61.0f, 28.0f);
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
