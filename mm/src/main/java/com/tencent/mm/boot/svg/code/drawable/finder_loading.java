package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_loading extends c {
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(72.0f, 0.0f);
                instancePath.lineTo(72.0f, 72.0f);
                instancePath.lineTo(0.0f, 72.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(34.27604f, 5.9987555f);
                instancePath2.cubicTo(34.279778f, 4.5620184f, 35.85778f, 3.7455175f, 37.016792f, 4.467326f);
                instancePath2.lineTo(37.24242f, 4.6324706f);
                instancePath2.lineTo(55.01442f, 19.75247f);
                instancePath2.cubicTo(55.787556f, 20.410236f, 55.85233f, 21.557028f, 55.213284f, 22.2972f);
                instancePath2.lineTo(55.000458f, 22.506159f);
                instancePath2.lineTo(40.944f, 34.221f);
                instancePath2.lineTo(65.9993f, 34.289543f);
                instancePath2.cubicTo(67.43602f, 34.293423f, 68.252365f, 35.871483f, 67.530464f, 37.030426f);
                instancePath2.lineTo(67.3653f, 37.256035f);
                instancePath2.lineTo(52.245304f, 55.025036f);
                instancePath2.cubicTo(51.58751f, 55.798077f, 50.44079f, 55.862797f, 49.700657f, 55.223774f);
                instancePath2.lineTo(49.491714f, 55.01096f);
                instancePath2.lineTo(37.785f, 40.962f);
                instancePath2.lineTo(37.718826f, 66.009796f);
                instancePath2.cubicTo(37.71495f, 67.44652f, 36.13689f, 68.26286f, 34.977947f, 67.54096f);
                instancePath2.lineTo(34.752335f, 67.3758f);
                instancePath2.lineTo(16.983335f, 52.255802f);
                instancePath2.cubicTo(16.210297f, 51.598007f, 16.145576f, 50.45129f, 16.784597f, 49.71116f);
                instancePath2.lineTo(16.997412f, 49.502213f);
                instancePath2.lineTo(31.053f, 37.785f);
                instancePath2.lineTo(5.9985743f, 37.71883f);
                instancePath2.cubicTo(4.561851f, 37.71495f, 3.7455044f, 36.13689f, 4.467405f, 34.977947f);
                instancePath2.lineTo(4.6325665f, 34.752335f);
                instancePath2.lineTo(19.752567f, 16.983337f);
                instancePath2.cubicTo(20.410362f, 16.210297f, 21.557081f, 16.145576f, 22.29721f, 16.784597f);
                instancePath2.lineTo(22.506157f, 16.997412f);
                instancePath2.lineTo(34.209f, 31.038f);
                instancePath2.lineTo(34.27604f, 5.9987555f);
                instancePath2.close();
                instancePath2.moveTo(34.188736f, 39.859035f);
                instancePath2.lineTo(20.943735f, 50.899036f);
                instancePath2.lineTo(34.125736f, 62.116035f);
                instancePath2.lineTo(34.188736f, 39.859035f);
                instancePath2.close();
                instancePath2.moveTo(39.846733f, 37.816036f);
                instancePath2.lineTo(50.886734f, 51.061035f);
                instancePath2.lineTo(62.103733f, 37.879036f);
                instancePath2.lineTo(39.846733f, 37.816036f);
                instancePath2.close();
                instancePath2.moveTo(21.105734f, 20.944036f);
                instancePath2.lineTo(9.888735f, 34.126038f);
                instancePath2.lineTo(32.145737f, 34.189037f);
                instancePath2.lineTo(21.105734f, 20.944036f);
                instancePath2.close();
                instancePath2.moveTo(37.866734f, 9.889036f);
                instancePath2.lineTo(37.806736f, 32.143036f);
                instancePath2.lineTo(51.051735f, 21.106035f);
                instancePath2.lineTo(37.866734f, 9.889036f);
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
