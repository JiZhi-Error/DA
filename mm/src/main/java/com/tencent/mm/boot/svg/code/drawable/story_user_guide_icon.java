package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class story_user_guide_icon extends c {
    private final int height = 144;
    private final int width = 168;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 168;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(84.0f, 24.0f);
                instancePath.cubicTo(84.0f, 43.88225f, 100.11775f, 60.0f, 120.0f, 60.0f);
                instancePath.lineTo(120.0f, 128.61668f);
                instancePath.cubicTo(120.0f, 133.9658f, 119.44305f, 135.90552f, 118.3972f, 137.86107f);
                instancePath.cubicTo(117.351364f, 139.81664f, 115.81663f, 141.35136f, 113.86108f, 142.3972f);
                instancePath.cubicTo(111.90552f, 143.44304f, 109.9658f, 144.0f, 104.61669f, 144.0f);
                instancePath.lineTo(15.383311f, 144.0f);
                instancePath.cubicTo(10.034199f, 144.0f, 8.094481f, 143.44304f, 6.1389256f, 142.3972f);
                instancePath.cubicTo(4.18337f, 141.35136f, 2.6486387f, 139.81664f, 1.6027962f, 137.86107f);
                instancePath.cubicTo(0.55695367f, 135.90552f, 2.4074122E-16f, 133.9658f, -4.1433612E-16f, 128.61668f);
                instancePath.lineTo(4.1433612E-16f, 39.383312f);
                instancePath.cubicTo(-2.4074122E-16f, 34.0342f, 0.55695367f, 32.094482f, 1.6027962f, 30.138926f);
                instancePath.cubicTo(2.6486387f, 28.18337f, 4.18337f, 26.64864f, 6.1389256f, 25.602797f);
                instancePath.cubicTo(8.094481f, 24.556953f, 10.034199f, 24.0f, 15.383311f, 24.0f);
                instancePath.lineTo(84.0f, 24.0f);
                instancePath.close();
                instancePath.moveTo(31.5f, 108.0f);
                instancePath.cubicTo(31.5f, 109.65685f, 32.843147f, 111.0f, 34.5f, 111.0f);
                instancePath.lineTo(85.5f, 111.0f);
                instancePath.cubicTo(87.15685f, 111.0f, 88.5f, 109.65685f, 88.5f, 108.0f);
                instancePath.lineTo(88.5f, 105.94639f);
                instancePath.cubicTo(88.5f, 103.87551f, 87.0036f, 101.49508f, 85.15771f, 100.59467f);
                instancePath.lineTo(68.17664f, 92.31153f);
                instancePath.cubicTo(65.70356f, 91.105194f, 65.1511f, 88.43685f, 66.91966f, 86.3404f);
                instancePath.lineTo(68.004265f, 85.05472f);
                instancePath.cubicTo(70.2028f, 82.44858f, 72.0f, 77.54789f, 72.0f, 74.130554f);
                instancePath.lineTo(72.0f, 69.000626f);
                instancePath.cubicTo(72.0f, 62.37894f, 66.62742f, 57.0f, 60.0f, 57.0f);
                instancePath.cubicTo(53.38607f, 57.0f, 48.0f, 62.37202f, 48.0f, 68.99874f);
                instancePath.lineTo(48.0f, 74.12787f);
                instancePath.cubicTo(48.0f, 77.54849f, 49.78895f, 82.43485f, 51.99574f, 85.050415f);
                instancePath.lineTo(53.080338f, 86.335915f);
                instancePath.cubicTo(54.858776f, 88.44379f, 54.286133f, 91.10562f, 51.823353f, 92.30743f);
                instancePath.lineTo(34.842293f, 100.594f);
                instancePath.cubicTo(32.994453f, 101.49573f, 31.5f, 103.89112f, 31.5f, 105.94639f);
                instancePath.lineTo(31.5f, 108.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 48.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-15819547);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 96.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(38.306896f, 19.482126f);
                instancePath2.cubicTo(37.560726f, 17.111504f, 38.877605f, 14.584843f, 41.24823f, 13.838673f);
                instancePath2.cubicTo(43.61885f, 13.092503f, 46.14551f, 14.409382f, 46.89168f, 16.780005f);
                instancePath2.cubicTo(49.557262f, 25.248697f, 47.36401f, 34.579548f, 40.970562f, 40.972996f);
                instancePath2.cubicTo(31.59798f, 50.345577f, 16.40202f, 50.345577f, 7.029437f, 40.972996f);
                instancePath2.cubicTo(-2.3431458f, 31.600412f, -2.3431458f, 16.404453f, 7.029437f, 7.0318704f);
                instancePath2.cubicTo(13.422884f, 0.6384233f, 22.753736f, -1.5548298f, 31.22243f, 1.1107507f);
                instancePath2.cubicTo(33.593052f, 1.856921f, 34.90993f, 4.383581f, 34.16376f, 6.7542043f);
                instancePath2.cubicTo(33.41759f, 9.124827f, 30.89093f, 10.441707f, 28.520308f, 9.695536f);
                instancePath2.cubicTo(23.220871f, 8.027501f, 17.391516f, 9.397714f, 13.393398f, 13.395831f);
                instancePath2.cubicTo(7.535534f, 19.253696f, 7.535534f, 28.751171f, 13.393398f, 34.609035f);
                instancePath2.cubicTo(19.251263f, 40.4669f, 28.748737f, 40.4669f, 34.6066f, 34.609035f);
                instancePath2.cubicTo(38.60472f, 30.610918f, 39.974934f, 24.781563f, 38.306896f, 19.482126f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
