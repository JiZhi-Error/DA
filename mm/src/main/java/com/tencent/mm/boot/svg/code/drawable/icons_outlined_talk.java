package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_talk extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(17.149248f, 8.000936f);
                instancePath.cubicTo(17.12806f, 7.950083f, 17.105125f, 7.8999743f, 17.080488f, 7.8507f);
                instancePath.cubicTo(16.487715f, 6.6651516f, 15.0461f, 6.184613f, 13.860551f, 6.777387f);
                instancePath.lineTo(3.6f, 11.907662f);
                instancePath.lineTo(3.6f, 46.308914f);
                instancePath.lineTo(15.392785f, 51.362965f);
                instancePath.cubicTo(15.5692835f, 51.438606f, 15.754222f, 51.492794f, 15.943634f, 51.52436f);
                instancePath.cubicTo(17.251083f, 51.74227f, 18.487629f, 50.859024f, 18.705536f, 49.551575f);
                instancePath.lineTo(20.805315f, 36.952904f);
                instancePath.lineTo(28.187292f, 34.49224f);
                instancePath.lineTo(17.149248f, 8.000936f);
                instancePath.close();
                instancePath.moveTo(29.938093f, 37.703377f);
                instancePath.lineTo(24.0f, 39.68274f);
                instancePath.lineTo(22.256556f, 50.14341f);
                instancePath.cubicTo(21.711784f, 53.412033f, 18.620419f, 55.62015f, 15.351797f, 55.07538f);
                instancePath.cubicTo(14.878268f, 54.99646f, 14.415921f, 54.860992f, 13.974675f, 54.671886f);
                instancePath.lineTo(1.8182421f, 49.461987f);
                instancePath.cubicTo(0.7151906f, 48.98925f, -2.1822544E-11f, 47.904636f, -2.1822544E-11f, 46.70455f);
                instancePath.lineTo(-2.1827873E-11f, 11.536842f);
                instancePath.cubicTo(-2.1827873E-11f, 10.400526f, 0.6420071f, 9.361736f, 1.6583592f, 8.85356f);
                instancePath.lineTo(12.250582f, 3.5574493f);
                instancePath.cubicTo(15.214453f, 2.0755138f, 18.818491f, 3.27686f, 20.300426f, 6.240731f);
                instancePath.cubicTo(20.36202f, 6.3639174f, 20.419353f, 6.4891877f, 20.472324f, 6.61632f);
                instancePath.lineTo(31.758642f, 33.70348f);
                instancePath.cubicTo(32.395893f, 35.232883f, 31.67266f, 36.989304f, 30.143257f, 37.626556f);
                instancePath.cubicTo(30.075827f, 37.65465f, 30.007395f, 37.680275f, 29.938093f, 37.703377f);
                instancePath.close();
                instancePath.moveTo(41.42498f, 47.42498f);
                instancePath.cubicTo(45.228367f, 43.62159f, 47.4f, 38.48727f, 47.4f, 33.0f);
                instancePath.cubicTo(47.4f, 27.51273f, 45.228367f, 22.378408f, 41.42498f, 18.575022f);
                instancePath.lineTo(43.970562f, 16.029438f);
                instancePath.cubicTo(48.31371f, 20.372583f, 51.0f, 26.372583f, 51.0f, 33.0f);
                instancePath.cubicTo(51.0f, 39.62742f, 48.31371f, 45.62742f, 43.970562f, 49.970562f);
                instancePath.lineTo(41.42498f, 47.42498f);
                instancePath.close();
                instancePath.moveTo(35.485283f, 41.485283f);
                instancePath.cubicTo(37.72353f, 39.247032f, 39.0f, 36.22912f, 39.0f, 33.0f);
                instancePath.cubicTo(39.0f, 29.770882f, 37.72353f, 26.752968f, 35.485283f, 24.514719f);
                instancePath.lineTo(38.030865f, 21.969133f);
                instancePath.cubicTo(40.853912f, 24.79218f, 42.6f, 28.692179f, 42.6f, 33.0f);
                instancePath.cubicTo(42.6f, 37.30782f, 40.853912f, 41.20782f, 38.030865f, 44.030865f);
                instancePath.lineTo(35.485283f, 41.485283f);
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
