package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_icons_link extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.70710677f, 0.70710677f, 0.2911098f, -0.70710677f, 0.70710677f, 45.54594f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(26.0f, 0.5f);
                instancePath.cubicTo(28.485281f, 0.5f, 30.5f, 2.5147185f, 30.5f, 5.0f);
                instancePath.cubicTo(30.5f, 7.3390884f, 28.715336f, 9.261346f, 26.43338f, 9.479401f);
                instancePath.lineTo(26.0f, 9.5f);
                instancePath.lineTo(18.112997f, 9.5f);
                instancePath.cubicTo(13.385933f, 9.5f, 9.5f, 13.500617f, 9.5f, 18.5f);
                instancePath.cubicTo(9.5f, 23.320833f, 13.113322f, 27.212967f, 17.609884f, 27.484829f);
                instancePath.lineTo(18.112997f, 27.5f);
                instancePath.lineTo(26.0f, 27.5f);
                instancePath.cubicTo(28.485281f, 27.5f, 30.5f, 29.514719f, 30.5f, 32.0f);
                instancePath.cubicTo(30.5f, 34.33909f, 28.715336f, 36.261345f, 26.43338f, 36.4794f);
                instancePath.lineTo(26.0f, 36.5f);
                instancePath.lineTo(18.112997f, 36.5f);
                instancePath.cubicTo(8.355845f, 36.5f, 0.5f, 28.412306f, 0.5f, 18.5f);
                instancePath.cubicTo(0.5f, 8.812974f, 8.002819f, 0.8685649f, 17.450754f, 0.51245904f);
                instancePath.lineTo(18.112997f, 0.5f);
                instancePath.lineTo(26.0f, 0.5f);
                instancePath.close();
                instancePath.moveTo(45.887f, 0.5f);
                instancePath.cubicTo(55.644154f, 0.5f, 63.5f, 8.587694f, 63.5f, 18.5f);
                instancePath.cubicTo(63.5f, 28.187027f, 55.99718f, 36.131435f, 46.549248f, 36.48754f);
                instancePath.lineTo(45.887f, 36.5f);
                instancePath.lineTo(38.0f, 36.5f);
                instancePath.cubicTo(35.514717f, 36.5f, 33.5f, 34.485283f, 33.5f, 32.0f);
                instancePath.cubicTo(33.5f, 29.660912f, 35.284664f, 27.738653f, 37.56662f, 27.5206f);
                instancePath.lineTo(38.0f, 27.5f);
                instancePath.lineTo(45.887f, 27.5f);
                instancePath.cubicTo(50.614067f, 27.5f, 54.5f, 23.499382f, 54.5f, 18.5f);
                instancePath.cubicTo(54.5f, 13.679167f, 50.886677f, 9.787032f, 46.390118f, 9.515172f);
                instancePath.lineTo(45.887f, 9.5f);
                instancePath.lineTo(38.0f, 9.5f);
                instancePath.cubicTo(35.514717f, 9.5f, 33.5f, 7.4852815f, 33.5f, 5.0f);
                instancePath.cubicTo(33.5f, 2.6609116f, 35.284664f, 0.73865396f, 37.56662f, 0.5205997f);
                instancePath.lineTo(38.0f, 0.5f);
                instancePath.lineTo(45.887f, 0.5f);
                instancePath.close();
                instancePath.moveTo(45.5f, 14.0f);
                instancePath.cubicTo(47.985283f, 14.0f, 50.0f, 16.014719f, 50.0f, 18.5f);
                instancePath.cubicTo(50.0f, 20.839088f, 48.215336f, 22.761347f, 45.93338f, 22.9794f);
                instancePath.lineTo(45.5f, 23.0f);
                instancePath.lineTo(18.5f, 23.0f);
                instancePath.cubicTo(16.014719f, 23.0f, 14.0f, 20.985281f, 14.0f, 18.5f);
                instancePath.cubicTo(14.0f, 16.160912f, 15.784664f, 14.238654f, 18.06662f, 14.020599f);
                instancePath.lineTo(18.5f, 14.0f);
                instancePath.lineTo(45.5f, 14.0f);
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
