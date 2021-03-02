package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_wechat extends c {
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
                Matrix instanceMatrix = c.instanceMatrix(looper);
                float[] instanceMatrixArray = c.instanceMatrixArray(looper);
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 72.0f);
                instancePath.cubicTo(0.0f, 32.235497f, 32.235497f, 0.0f, 72.0f, 0.0f);
                instancePath.lineTo(72.0f, 0.0f);
                instancePath.cubicTo(111.7645f, 0.0f, 144.0f, 32.235497f, 144.0f, 72.0f);
                instancePath.lineTo(144.0f, 72.0f);
                instancePath.cubicTo(144.0f, 111.7645f, 111.7645f, 144.0f, 72.0f, 144.0f);
                instancePath.lineTo(72.0f, 144.0f);
                instancePath.cubicTo(32.235497f, 144.0f, 0.0f, 111.7645f, 0.0f, 72.0f);
                instancePath.lineTo(0.0f, 72.0f);
                instancePath.close();
                Paint instancePaint4 = c.instancePaint(looper);
                instancePaint4.setFlags(385);
                instancePaint4.setStyle(Paint.Style.FILL);
                Paint instancePaint5 = c.instancePaint(looper);
                instancePaint5.setFlags(385);
                instancePaint5.setStyle(Paint.Style.STROKE);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint5.setStrokeWidth(1.0f);
                instancePaint5.setStrokeCap(Paint.Cap.BUTT);
                instancePaint5.setStrokeJoin(Paint.Join.MITER);
                instancePaint5.setStrokeMiter(4.0f);
                instancePaint5.setPathEffect(null);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 144.0f, 0.0f, 0.0f, 0.0f, 144.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint3, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-16587921, -16268960}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(107.654305f, 100.37557f);
                instancePath2.cubicTo(113.40971f, 96.21119f, 117.088524f, 90.05f, 117.088524f, 83.205666f);
                instancePath2.cubicTo(117.088524f, 70.65889f, 104.86362f, 60.4892f, 89.78438f, 60.4892f);
                instancePath2.cubicTo(74.70514f, 60.4892f, 62.48123f, 70.65889f, 62.48123f, 83.205666f);
                instancePath2.cubicTo(62.48123f, 95.75146f, 74.70514f, 105.92114f, 89.78438f, 105.92114f);
                instancePath2.cubicTo(92.900276f, 105.92114f, 95.907776f, 105.4773f, 98.696465f, 104.675995f);
                instancePath2.cubicTo(98.95007f, 104.59855f, 99.2196f, 104.55685f, 99.50006f, 104.55685f);
                instancePath2.cubicTo(100.023186f, 104.55685f, 100.500565f, 104.71571f, 100.949104f, 104.97587f);
                instancePath2.lineTo(106.9263f, 108.42037f);
                instancePath2.cubicTo(107.09338f, 108.516685f, 107.2545f, 108.590164f, 107.452415f, 108.590164f);
                instancePath2.cubicTo(107.95565f, 108.590164f, 108.36242f, 108.18306f, 108.36242f, 107.68063f);
                instancePath2.cubicTo(108.36242f, 107.45722f, 108.27291f, 107.23183f, 108.21622f, 107.01735f);
                instancePath2.cubicTo(108.18141f, 106.88926f, 107.44446f, 104.14676f, 106.98597f, 102.43494f);
                instancePath2.cubicTo(106.93326f, 102.24329f, 106.890495f, 102.05762f, 106.890495f, 101.85605f);
                instancePath2.cubicTo(106.890495f, 101.24539f, 107.19184f, 100.70523f, 107.654305f, 100.37557f);
                instancePath2.moveTo(80.682335f, 79.57151f);
                instancePath2.cubicTo(78.67336f, 79.57151f, 77.04331f, 77.944084f, 77.04331f, 75.936356f);
                instancePath2.cubicTo(77.04331f, 73.928635f, 78.67336f, 72.30121f, 80.682335f, 72.30121f);
                instancePath2.cubicTo(82.6943f, 72.30121f, 84.32336f, 73.928635f, 84.32336f, 75.936356f);
                instancePath2.cubicTo(84.32336f, 77.944084f, 82.6943f, 79.57151f, 80.682335f, 79.57151f);
                instancePath2.moveTo(59.20352f, 35.409836f);
                instancePath2.cubicTo(75.549805f, 35.409836f, 89.09646f, 45.36902f, 91.56391f, 58.39142f);
                instancePath2.cubicTo(90.97415f, 58.36262f, 90.3824f, 58.343758f, 89.784676f, 58.343758f);
                instancePath2.cubicTo(73.28126f, 58.343758f, 59.902683f, 69.4756f, 59.902683f, 83.20497f);
                instancePath2.cubicTo(59.902683f, 85.52051f, 60.29155f, 87.76058f, 61.003643f, 89.88646f);
                instancePath2.cubicTo(60.406918f, 89.91327f, 59.8082f, 89.92916f, 59.20352f, 89.92916f);
                instancePath2.cubicTo(55.46504f, 89.92916f, 51.855846f, 89.39496f, 48.509216f, 88.434784f);
                instancePath2.cubicTo(48.20389f, 88.341446f, 47.880665f, 88.29081f, 47.545506f, 88.29081f);
                instancePath2.cubicTo(46.916954f, 88.29081f, 46.34609f, 88.482445f, 45.806053f, 88.793236f);
                instancePath2.lineTo(45.806053f, 88.793236f);
                instancePath2.lineTo(38.63342f, 92.92783f);
                instancePath2.cubicTo(38.433514f, 93.043015f, 38.238586f, 93.131386f, 38.001884f, 93.131386f);
                instancePath2.cubicTo(37.398197f, 93.131386f, 36.909878f, 92.64385f, 36.909878f, 92.04114f);
                instancePath2.cubicTo(36.909878f, 91.771065f, 37.01729f, 91.501976f, 37.08591f, 91.24381f);
                instancePath2.cubicTo(37.12768f, 91.08891f, 38.010834f, 87.7993f, 38.56181f, 85.7459f);
                instancePath2.cubicTo(38.624466f, 85.51455f, 38.677177f, 85.29213f, 38.677177f, 85.05085f);
                instancePath2.cubicTo(38.677177f, 84.31706f, 38.315166f, 83.66967f, 37.760212f, 83.27348f);
                instancePath2.cubicTo(30.852125f, 78.277016f, 26.439344f, 70.88359f, 26.439344f, 62.669994f);
                instancePath2.cubicTo(26.439344f, 47.615047f, 41.107838f, 35.409836f, 59.20352f, 35.409836f);
                instancePath2.close();
                instancePath2.moveTo(98.88543f, 72.30121f);
                instancePath2.cubicTo(100.89639f, 72.30121f, 102.52545f, 73.928635f, 102.52545f, 75.936356f);
                instancePath2.cubicTo(102.52545f, 77.944084f, 100.89639f, 79.57151f, 98.88543f, 79.57151f);
                instancePath2.cubicTo(96.875465f, 79.57151f, 95.24541f, 77.944084f, 95.24541f, 75.936356f);
                instancePath2.cubicTo(95.24541f, 73.928635f, 96.875465f, 72.30121f, 98.88543f, 72.30121f);
                instancePath2.close();
                instancePath2.moveTo(48.281467f, 49.585037f);
                instancePath2.cubicTo(45.8697f, 49.585037f, 43.91344f, 51.53716f, 43.91344f, 53.94603f);
                instancePath2.cubicTo(43.91344f, 56.355892f, 45.8697f, 58.30801f, 48.281467f, 58.30801f);
                instancePath2.cubicTo(50.695217f, 58.30801f, 52.650486f, 56.355892f, 52.650486f, 53.94603f);
                instancePath2.cubicTo(52.650486f, 51.53716f, 50.695217f, 49.585037f, 48.281467f, 49.585037f);
                instancePath2.close();
                instancePath2.moveTo(70.12558f, 49.585037f);
                instancePath2.cubicTo(67.71182f, 49.585037f, 65.75655f, 51.53716f, 65.75655f, 53.94603f);
                instancePath2.cubicTo(65.75655f, 56.355892f, 67.71182f, 58.30801f, 70.12558f, 58.30801f);
                instancePath2.cubicTo(72.53834f, 58.30801f, 74.4946f, 56.355892f, 74.4946f, 53.94603f);
                instancePath2.cubicTo(74.4946f, 51.53716f, 72.53834f, 49.585037f, 70.12558f, 49.585037f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
