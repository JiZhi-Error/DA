package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_scissor extends c {
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
                instancePaint3.setColor(-436207616);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 9.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.176471f, 28.852942f);
                instancePath.cubicTo(18.90135f, 28.852942f, 24.352942f, 34.30453f, 24.352942f, 41.02941f);
                instancePath.cubicTo(24.352942f, 47.75429f, 18.90135f, 53.205883f, 12.176471f, 53.205883f);
                instancePath.cubicTo(5.4515915f, 53.205883f, 0.0f, 47.75429f, 0.0f, 41.02941f);
                instancePath.cubicTo(0.0f, 34.30453f, 5.4515915f, 28.852942f, 12.176471f, 28.852942f);
                instancePath.close();
                instancePath.moveTo(41.82353f, 28.852942f);
                instancePath.cubicTo(48.54841f, 28.852942f, 54.0f, 34.30453f, 54.0f, 41.02941f);
                instancePath.cubicTo(54.0f, 47.75429f, 48.54841f, 53.205883f, 41.82353f, 53.205883f);
                instancePath.cubicTo(35.09865f, 53.205883f, 29.647058f, 47.75429f, 29.647058f, 41.02941f);
                instancePath.cubicTo(29.647058f, 34.30453f, 35.09865f, 28.852942f, 41.82353f, 28.852942f);
                instancePath.close();
                instancePath.moveTo(12.176471f, 34.67647f);
                instancePath.cubicTo(8.667838f, 34.67647f, 5.8235292f, 37.52078f, 5.8235292f, 41.02941f);
                instancePath.cubicTo(5.8235292f, 44.538044f, 8.667838f, 47.382355f, 12.176471f, 47.382355f);
                instancePath.cubicTo(15.685103f, 47.382355f, 18.529411f, 44.538044f, 18.529411f, 41.02941f);
                instancePath.cubicTo(18.529411f, 37.52078f, 15.685103f, 34.67647f, 12.176471f, 34.67647f);
                instancePath.close();
                instancePath.moveTo(41.82353f, 34.67647f);
                instancePath.cubicTo(38.314896f, 34.67647f, 35.47059f, 37.52078f, 35.47059f, 41.02941f);
                instancePath.cubicTo(35.47059f, 44.538044f, 38.314896f, 47.382355f, 41.82353f, 47.382355f);
                instancePath.cubicTo(45.33216f, 47.382355f, 48.17647f, 44.538044f, 48.17647f, 41.02941f);
                instancePath.cubicTo(48.17647f, 37.52078f, 45.33216f, 34.67647f, 41.82353f, 34.67647f);
                instancePath.close();
                instancePath.moveTo(46.466427f, 0.13723381f);
                instancePath.lineTo(46.873055f, 0.5711756f);
                instancePath.cubicTo(49.730167f, 3.8268163f, 49.84112f, 8.65159f, 47.205925f, 12.029105f);
                instancePath.lineTo(46.829556f, 12.480422f);
                instancePath.lineTo(46.466427f, 12.865156f);
                instancePath.lineTo(26.99898f, 32.330177f);
                instancePath.lineTo(7.533961f, 12.865156f);
                instancePath.lineTo(7.170833f, 12.480422f);
                instancePath.cubicTo(4.154855f, 9.093448f, 4.140355f, 3.9748f, 7.1273336f, 0.5711756f);
                instancePath.lineTo(7.533961f, 0.13723381f);
                instancePath.lineTo(26.998922f, 19.604235f);
                instancePath.lineTo(46.466427f, 0.13723381f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
