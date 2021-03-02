package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class get_location_icon extends c {
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
                instancePaint3.setColor(-12206054);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(25.094501f, 1.2469155f);
                instancePath.cubicTo(32.743237f, 3.0203025f, 39.219376f, 8.896839f, 41.072548f, 16.177034f);
                instancePath.cubicTo(43.13704f, 22.67836f, 41.587963f, 29.62878f, 38.076664f, 35.088516f);
                instancePath.cubicTo(34.412243f, 42.962852f, 28.066027f, 49.068085f, 21.099989f, 54.0f);
                instancePath.cubicTo(12.755159f, 48.05386f, 5.0597496f, 40.37757f, 1.127431f, 30.11181f);
                instancePath.cubicTo(-0.9466681f, 23.652811f, -0.27706745f, 15.399808f, 4.123315f, 9.209645f);
                instancePath.cubicTo(9.027383f, 3.1793966f, 17.492334f, 0.06711942f, 25.094501f, 1.2469155f);
                instancePath.close();
                instancePath.moveTo(16.216259f, 28.788422f);
                instancePath.cubicTo(21.350666f, 32.136604f, 29.266953f, 28.065493f, 28.989613f, 22.434635f);
                instancePath.cubicTo(29.309687f, 16.169382f, 22.162594f, 11.960802f, 17.280704f, 15.021884f);
                instancePath.cubicTo(11.992141f, 17.4383f, 11.564811f, 25.432486f, 16.216259f, 28.788422f);
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
