package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sns_sight_icon_mark extends c {
    private final int height = 30;
    private final int width = 42;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 42;
            case 1:
                return 30;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(3.0f, 21.0f);
                instancePath.lineTo(25.0f, 21.0f);
                instancePath.lineTo(25.0f, 3.0f);
                instancePath.lineTo(3.0f, 3.0f);
                instancePath.lineTo(3.0f, 21.0f);
                instancePath.close();
                instancePath.moveTo(0.0f, 2.0049467f);
                instancePath.cubicTo(0.0f, 0.8976452f, 0.8998975f, 0.0f, 1.9912443f, 0.0f);
                instancePath.lineTo(26.008757f, 0.0f);
                instancePath.cubicTo(27.10849f, 0.0f, 28.0f, 0.89702624f, 28.0f, 2.0049467f);
                instancePath.lineTo(28.0f, 21.995054f);
                instancePath.cubicTo(28.0f, 23.102354f, 27.100103f, 24.0f, 26.008757f, 24.0f);
                instancePath.lineTo(1.9912443f, 24.0f);
                instancePath.cubicTo(0.8915104f, 24.0f, 0.0f, 23.102974f, 0.0f, 21.995054f);
                instancePath.lineTo(0.0f, 2.0049467f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(34.0f, 14.914493f);
                instancePath2.lineTo(39.0f, 18.323584f);
                instancePath2.lineTo(39.0f, 5.6764164f);
                instancePath2.lineTo(34.0f, 9.085507f);
                instancePath2.lineTo(34.0f, 14.914493f);
                instancePath2.close();
                instancePath2.moveTo(31.0f, 7.5f);
                instancePath2.lineTo(39.51767f, 1.692498f);
                instancePath2.cubicTo(40.888622f, 0.7577572f, 42.0f, 1.3417706f, 42.0f, 2.9910905f);
                instancePath2.lineTo(42.0f, 21.00891f);
                instancePath2.cubicTo(42.0f, 22.660843f, 40.884727f, 23.239586f, 39.51767f, 22.307503f);
                instancePath2.lineTo(31.0f, 16.5f);
                instancePath2.lineTo(31.0f, 7.5f);
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
