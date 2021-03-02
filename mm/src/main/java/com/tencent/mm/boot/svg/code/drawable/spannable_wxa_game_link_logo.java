package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class spannable_wxa_game_link_logo extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                instancePaint3.setColor(-723724);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 30.0f);
                instancePath.cubicTo(0.0f, 13.4314575f, 13.4314575f, 0.0f, 30.0f, 0.0f);
                instancePath.lineTo(30.0f, 0.0f);
                instancePath.cubicTo(46.568542f, 0.0f, 60.0f, 13.4314575f, 60.0f, 30.0f);
                instancePath.lineTo(60.0f, 30.0f);
                instancePath.cubicTo(60.0f, 46.568542f, 46.568542f, 60.0f, 30.0f, 60.0f);
                instancePath.lineTo(30.0f, 60.0f);
                instancePath.cubicTo(13.4314575f, 60.0f, 0.0f, 46.568542f, 0.0f, 30.0f);
                instancePath.lineTo(0.0f, 30.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-363518);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 13.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(24.475742f, 18.70696f);
                instancePath2.cubicTo(23.12304f, 21.028156f, 19.575186f, 21.698137f, 16.551128f, 20.203268f);
                instancePath2.cubicTo(13.527069f, 18.70792f, 12.171762f, 15.61459f, 13.523946f, 13.292914f);
                instancePath2.cubicTo(14.876649f, 10.971719f, 18.425022f, 10.301737f, 21.449081f, 11.797086f);
                instancePath2.cubicTo(24.473139f, 13.291956f, 25.828445f, 16.385765f, 24.475742f, 18.70696f);
                instancePath2.moveTo(25.103931f, 10.635292f);
                instancePath2.cubicTo(18.385532f, 4.646929f, 8.63892f, 4.4326096f, 3.3347385f, 10.156823f);
                instancePath2.cubicTo(-1.969443f, 15.880552f, -0.82257956f, 25.375916f, 5.89582f, 31.364279f);
                instancePath2.cubicTo(12.614714f, 37.353127f, 22.360832f, 37.567448f, 27.665506f, 31.843233f);
                instancePath2.cubicTo(32.969196f, 26.119503f, 31.822824f, 16.62414f, 25.103931f, 10.635292f);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(30.503237f, 0.13884006f);
                instancePath3.cubicTo(33.136944f, -0.56668025f, 35.94263f, 1.4859271f, 36.76932f, 4.722692f);
                instancePath3.cubicTo(37.59601f, 7.959457f, 36.13047f, 11.156124f, 33.49676f, 11.861136f);
                instancePath3.cubicTo(30.86256f, 12.566657f, 28.05737f, 10.514557f, 27.230679f, 7.2772846f);
                instancePath3.cubicTo(26.40399f, 4.0405197f, 27.86953f, 0.84486794f, 30.503237f, 0.13884006f);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
