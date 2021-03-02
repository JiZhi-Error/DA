package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_mic_disable extends c {
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 7.5f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(5.5064316f, 6.8608255f);
                instancePath.cubicTo(5.636235f, 6.7901616f, 5.676828f, 6.7294984f, 5.7120147f, 6.612761f);
                instancePath.lineTo(5.991965f, 5.516953f);
                instancePath.cubicTo(6.1409225f, 4.939528f, 6.313309f, 4.2839255f, 6.441841f, 3.8222697f);
                instancePath.cubicTo(6.494363f, 3.6220267f, 6.587211f, 3.4402182f, 6.740204f, 3.2761538f);
                instancePath.cubicTo(6.9027586f, 3.101835f, 7.097464f, 2.9958394f, 7.303811f, 2.9390407f);
                instancePath.cubicTo(8.442805f, 2.6017034f, 9.615337f, 2.372323f, 10.794799f, 2.3411126f);
                instancePath.cubicTo(11.964005f, 2.300339f, 13.149704f, 2.4474816f, 14.309488f, 2.704654f);
                instancePath.cubicTo(14.5192995f, 2.7469404f, 14.73119f, 2.8486774f, 14.89527f, 3.001685f);
                instancePath.cubicTo(15.049095f, 3.1451292f, 15.164673f, 3.3295896f, 15.231053f, 3.5256865f);
                instancePath.lineTo(15.553032f, 4.4429507f);
                instancePath.cubicTo(15.781395f, 5.1103215f, 16.015753f, 5.8230443f, 16.127542f, 6.1829004f);
                instancePath.cubicTo(16.182976f, 6.349617f, 16.225382f, 6.427503f, 16.376434f, 6.491679f);
                instancePath.lineTo(19.506844f, 7.7813153f);
                instancePath.cubicTo(19.878656f, 7.9171576f, 20.292042f, 7.823377f, 20.589159f, 7.525319f);
                instancePath.cubicTo(20.703903f, 7.402271f, 20.786497f, 7.2108994f, 20.804928f, 7.1705747f);
                instancePath.cubicTo(21.372828f, 5.8214126f, 21.088453f, 4.214275f, 19.960402f, 3.1623495f);
                instancePath.cubicTo(19.642496f, 2.865898f, 19.268604f, 2.6706042f, 19.187256f, 2.6139176f);
                instancePath.cubicTo(16.574724f, 1.0978898f, 13.633898f, 0.40679815f, 10.72079f, 0.5083862f);
                instancePath.cubicTo(7.9533377f, 0.6048948f, 5.2109017f, 1.4167969f, 2.7999084f, 2.9504178f);
                instancePath.lineTo(2.3284156f, 3.2590144f);
                instancePath.cubicTo(2.1820319f, 3.3579495f, 1.9196236f, 3.5522847f, 1.6890723f, 3.7995207f);
                instancePath.cubicTo(0.68733454f, 4.873753f, 0.484151f, 6.397045f, 1.0378596f, 7.6681285f);
                instancePath.lineTo(1.1265873f, 7.856812f);
                instancePath.cubicTo(1.1477903f, 7.895755f, 1.2339883f, 8.091161f, 1.3666105f, 8.1956625f);
                instancePath.cubicTo(1.6933852f, 8.462043f, 2.1123154f, 8.526798f, 2.4737337f, 8.365386f);
                instancePath.lineTo(5.5064316f, 6.8608255f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
