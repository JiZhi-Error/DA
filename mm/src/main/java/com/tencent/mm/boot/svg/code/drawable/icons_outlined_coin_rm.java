package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_coin_rm extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(30.0f, 0.0f);
                instancePath.cubicTo(46.568542f, 0.0f, 60.0f, 13.4314575f, 60.0f, 30.0f);
                instancePath.cubicTo(60.0f, 46.568542f, 46.568542f, 60.0f, 30.0f, 60.0f);
                instancePath.cubicTo(13.4314575f, 60.0f, 0.0f, 46.568542f, 0.0f, 30.0f);
                instancePath.cubicTo(0.0f, 13.4314575f, 13.4314575f, 0.0f, 30.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(30.0f, 3.6f);
                instancePath.cubicTo(15.4196825f, 3.6f, 3.6f, 15.4196825f, 3.6f, 30.0f);
                instancePath.cubicTo(3.6f, 44.58032f, 15.4196825f, 56.4f, 30.0f, 56.4f);
                instancePath.cubicTo(44.58032f, 56.4f, 56.4f, 44.58032f, 56.4f, 30.0f);
                instancePath.cubicTo(56.4f, 15.4196825f, 44.58032f, 3.6f, 30.0f, 3.6f);
                instancePath.close();
                instancePath.moveTo(19.203f, 18.0f);
                instancePath.cubicTo(23.345135f, 18.0f, 26.703f, 21.357864f, 26.703f, 25.5f);
                instancePath.cubicTo(26.703f, 28.71414f, 24.681171f, 31.456059f, 21.839949f, 32.523315f);
                instancePath.lineTo(27.687f, 42.0f);
                instancePath.lineTo(23.457f, 42.0f);
                instancePath.lineTo(17.904f, 33.0f);
                instancePath.lineTo(15.003f, 33.0f);
                instancePath.lineTo(15.003f, 42.0f);
                instancePath.lineTo(11.403f, 42.0f);
                instancePath.lineTo(11.403f, 18.0f);
                instancePath.lineTo(19.203f, 18.0f);
                instancePath.close();
                instancePath.moveTo(33.38f, 18.0f);
                instancePath.lineTo(39.01078f, 31.430536f);
                instancePath.lineTo(44.633f, 18.0f);
                instancePath.lineTo(48.306f, 18.0f);
                instancePath.lineTo(48.306f, 42.0f);
                instancePath.lineTo(44.706f, 42.0f);
                instancePath.lineTo(44.706f, 26.774715f);
                instancePath.lineTo(40.898f, 36.0f);
                instancePath.lineTo(37.124f, 36.0f);
                instancePath.lineTo(33.306f, 26.76422f);
                instancePath.lineTo(33.306f, 42.0f);
                instancePath.lineTo(29.706f, 42.0f);
                instancePath.lineTo(29.706f, 18.0f);
                instancePath.lineTo(33.38f, 18.0f);
                instancePath.close();
                instancePath.moveTo(15.003f, 20.999f);
                instancePath.lineTo(15.003f, 29.999f);
                instancePath.lineTo(19.203f, 30.0f);
                instancePath.cubicTo(21.688282f, 30.0f, 23.703f, 27.985281f, 23.703f, 25.5f);
                instancePath.cubicTo(23.703f, 23.014719f, 21.688282f, 21.0f, 19.203f, 21.0f);
                instancePath.lineTo(15.003f, 20.999f);
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
