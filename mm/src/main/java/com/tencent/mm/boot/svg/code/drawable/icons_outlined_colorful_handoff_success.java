package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_colorful_handoff_success extends c {
    private final int height = 33;
    private final int width = 34;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 34;
            case 1:
                return 33;
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
                instancePaint3.setColor(-1184275);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(17.406498f, 20.448332f);
                instancePath.lineTo(18.969162f, 24.743322f);
                instancePath.cubicTo(19.119043f, 25.155495f, 18.906414f, 25.611132f, 18.49424f, 25.761013f);
                instancePath.cubicTo(18.407257f, 25.792643f, 18.315413f, 25.808823f, 18.222857f, 25.808823f);
                instancePath.lineTo(8.578614f, 25.808823f);
                instancePath.cubicTo(8.140036f, 25.808823f, 7.7844973f, 25.453285f, 7.7844973f, 25.014706f);
                instancePath.cubicTo(7.7844973f, 24.92215f, 7.800678f, 24.830305f, 7.8323083f, 24.743322f);
                instancePath.lineTo(9.393497f, 20.448332f);
                instancePath.lineTo(17.406498f, 20.448332f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(1.3897059f, 0.0f);
                instancePath2.lineTo(25.411764f, 0.0f);
                instancePath2.cubicTo(26.179277f, 2.126121E-15f, 26.80147f, 0.6221925f, 26.80147f, 1.3897059f);
                instancePath2.lineTo(26.80147f, 17.470589f);
                instancePath2.cubicTo(26.80147f, 18.238102f, 26.179277f, 18.860294f, 25.411764f, 18.860294f);
                instancePath2.lineTo(1.3897059f, 18.860294f);
                instancePath2.cubicTo(0.6221925f, 18.860294f, 9.821717E-16f, 18.238102f, 0.0f, 17.470589f);
                instancePath2.lineTo(0.0f, 1.3897059f);
                instancePath2.cubicTo(-9.399328E-17f, 0.6221925f, 0.6221925f, 8.071237E-16f, 1.3897059f, 0.0f);
                instancePath2.close();
                instancePath2.moveTo(17.56418f, 5.9558825f);
                instancePath2.lineTo(18.36397f, 6.8270392f);
                instancePath2.lineTo(13.229698f, 12.093872f);
                instancePath2.cubicTo(12.84595f, 12.487528f, 12.250469f, 12.510681f, 11.841828f, 12.166817f);
                instancePath2.lineTo(11.751024f, 12.080949f);
                instancePath2.lineTo(9.430147f, 9.620091f);
                instancePath2.lineTo(10.243455f, 8.763032f);
                instancePath2.lineTo(12.497311f, 11.1521225f);
                instancePath2.lineTo(17.56418f, 5.9558825f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
