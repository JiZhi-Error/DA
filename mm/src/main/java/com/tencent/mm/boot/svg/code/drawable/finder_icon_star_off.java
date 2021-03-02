package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_icon_star_off extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -64.0f, 0.0f, 1.0f, -95.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 64.0f, 0.0f, 1.0f, 95.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(-1);
                instancePaint6.setColor(419430400);
                instancePaint6.setStrokeWidth(0.5f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.25f, 0.25f);
                instancePath.lineTo(23.75f, 0.25f);
                instancePath.lineTo(23.75f, 23.75f);
                instancePath.lineTo(0.25f, 23.75f);
                instancePath.lineTo(0.25f, 0.25f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Paint instancePaint8 = c.instancePaint(instancePaint6, looper);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.drawPath(instancePath, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(12.442566f, 3.3628154f);
                instancePath2.cubicTo(12.639778f, 3.4601457f, 12.799406f, 3.6197731f, 12.896736f, 3.8169858f);
                instancePath2.lineTo(15.232819f, 8.550406f);
                instancePath2.lineTo(20.456459f, 9.309445f);
                instancePath2.cubicTo(21.003004f, 9.388864f, 21.381685f, 9.896306f, 21.302267f, 10.442851f);
                instancePath2.cubicTo(21.270643f, 10.660488f, 21.168156f, 10.86163f, 21.010672f, 11.01514f);
                instancePath2.lineTo(17.23081f, 14.699594f);
                instancePath2.lineTo(17.71234f, 17.513329f);
                instancePath2.lineTo(21.42645f, 21.227922f);
                instancePath2.lineTo(20.577923f, 22.07645f);
                instancePath2.lineTo(18.064339f, 19.563328f);
                instancePath2.lineTo(18.064339f, 19.565329f);
                instancePath2.lineTo(16.595339f, 18.096329f);
                instancePath2.lineTo(16.595339f, 18.094328f);
                instancePath2.lineTo(8.327339f, 9.826328f);
                instancePath2.lineTo(8.325339f, 9.826328f);
                instancePath2.lineTo(7.2673388f, 8.768329f);
                instancePath2.lineTo(7.269339f, 8.768329f);
                instancePath2.lineTo(3.85f, 5.3485284f);
                instancePath2.lineTo(4.6985283f, 4.5f);
                instancePath2.lineTo(8.751339f, 8.552328f);
                instancePath2.lineTo(8.767181f, 8.550406f);
                instancePath2.lineTo(11.103264f, 3.8169858f);
                instancePath2.cubicTo(11.347686f, 3.321732f, 11.947312f, 3.1183932f, 12.442566f, 3.3628154f);
                instancePath2.close();
                instancePath2.moveTo(5.784339f, 8.983329f);
                instancePath2.lineTo(6.843339f, 10.042329f);
                instancePath2.lineTo(4.1171317f, 10.438701f);
                instancePath2.lineTo(8.058566f, 14.280649f);
                instancePath2.lineTo(7.1281195f, 19.705568f);
                instancePath2.lineTo(12.0f, 17.14427f);
                instancePath2.lineTo(16.10134f, 19.30033f);
                instancePath2.lineTo(17.699617f, 20.89853f);
                instancePath2.cubicTo(17.584959f, 20.97653f, 17.45215f, 21.031807f, 17.306551f, 21.05678f);
                instancePath2.cubicTo(17.089794f, 21.093956f, 16.866827f, 21.058641f, 16.672165f, 20.956303f);
                instancePath2.lineTo(12.0f, 18.5f);
                instancePath2.lineTo(7.3278346f, 20.956303f);
                instancePath2.cubicTo(6.8389897f, 21.213305f, 6.2343626f, 21.025356f, 5.9773617f, 20.536512f);
                instancePath2.cubicTo(5.875023f, 20.341852f, 5.839708f, 20.118883f, 5.876885f, 19.902126f);
                instancePath2.lineTo(6.7691894f, 14.699594f);
                instancePath2.lineTo(2.9893277f, 11.01514f);
                instancePath2.cubicTo(2.5938442f, 10.629638f, 2.5857518f, 9.996525f, 2.9712532f, 9.601041f);
                instancePath2.cubicTo(3.1247616f, 9.443558f, 3.3259041f, 9.34107f, 3.5435412f, 9.309445f);
                instancePath2.lineTo(5.784339f, 8.983329f);
                instancePath2.close();
                instancePath2.moveTo(12.0f, 4.7114615f);
                instancePath2.lineTo(9.656339f, 9.457329f);
                instancePath2.lineTo(16.24334f, 16.044329f);
                instancePath2.lineTo(15.941434f, 14.280649f);
                instancePath2.lineTo(19.882868f, 10.438701f);
                instancePath2.lineTo(14.435941f, 9.647216f);
                instancePath2.lineTo(12.0f, 4.7114615f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint9);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
