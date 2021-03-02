package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sos_edittext_mike extends c {
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
                instancePaint3.setColor(-436207616);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 8.333333f, 0.0f, 1.0f, 4.166667f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(9.791667f, 9.375f);
                instancePath.lineTo(9.791667f, 21.875f);
                instancePath.cubicTo(9.791667f, 25.671957f, 12.869709f, 28.75f, 16.666666f, 28.75f);
                instancePath.cubicTo(20.463625f, 28.75f, 23.541666f, 25.671957f, 23.541666f, 21.875f);
                instancePath.lineTo(23.541666f, 9.375f);
                instancePath.cubicTo(23.541666f, 5.5780425f, 20.463625f, 2.5f, 16.666666f, 2.5f);
                instancePath.cubicTo(12.869709f, 2.5f, 9.791667f, 5.5780425f, 9.791667f, 9.375f);
                instancePath.close();
                instancePath.moveTo(3.5416667f, 18.75f);
                instancePath.lineTo(3.5416667f, 21.875f);
                instancePath.cubicTo(3.5416667f, 29.123737f, 9.41793f, 35.0f, 16.666666f, 35.0f);
                instancePath.cubicTo(23.915403f, 35.0f, 29.791666f, 29.123737f, 29.791666f, 21.875f);
                instancePath.lineTo(29.791666f, 18.75f);
                instancePath.lineTo(32.291668f, 18.75f);
                instancePath.lineTo(32.291668f, 21.875f);
                instancePath.cubicTo(32.291668f, 30.08384f, 25.96144f, 36.814175f, 17.91623f, 37.450764f);
                instancePath.lineTo(17.916666f, 43.75f);
                instancePath.lineTo(15.416666f, 43.75f);
                instancePath.lineTo(15.416106f, 37.450684f);
                instancePath.cubicTo(7.371371f, 36.813618f, 1.0416666f, 30.0835f, 1.0416666f, 21.875f);
                instancePath.lineTo(1.0416666f, 18.75f);
                instancePath.lineTo(3.5416667f, 18.75f);
                instancePath.close();
                instancePath.moveTo(16.666666f, 0.0f);
                instancePath.cubicTo(21.844336f, 0.0f, 26.041666f, 4.1973305f, 26.041666f, 9.375f);
                instancePath.lineTo(26.041666f, 21.875f);
                instancePath.cubicTo(26.041666f, 27.05267f, 21.844336f, 31.25f, 16.666666f, 31.25f);
                instancePath.cubicTo(11.488997f, 31.25f, 7.2916665f, 27.05267f, 7.2916665f, 21.875f);
                instancePath.lineTo(7.2916665f, 9.375f);
                instancePath.cubicTo(7.2916665f, 4.1973305f, 11.488997f, 0.0f, 16.666666f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
