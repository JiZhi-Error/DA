package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class collect_sound_off extends c {
    private final int height = 62;
    private final int width = 62;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 62;
            case 1:
                return 62;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setStrokeWidth(3.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 9.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                instancePaint5.setColor(-11711155);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(11.007507f, 11.458933f);
                instancePath.cubicTo(12.887484f, 9.4437065f, 15.622662f, 7.9247327f, 18.017488f, 7.3999724f);
                instancePath.lineTo(20.244202f, 6.9120493f);
                instancePath.lineTo(18.915043f, 5.060115f);
                instancePath.cubicTo(18.642044f, 4.679744f, 18.492981f, 4.2231226f, 18.492981f, 3.7391305f);
                instancePath.cubicTo(18.492981f, 2.4983008f, 19.479156f, 1.5f, 20.686369f, 1.5f);
                instancePath.cubicTo(21.893581f, 1.5f, 22.879757f, 2.4983008f, 22.879757f, 3.7391305f);
                instancePath.cubicTo(22.879757f, 4.2231226f, 22.730694f, 4.679744f, 22.457695f, 5.060115f);
                instancePath.lineTo(21.128536f, 6.9120493f);
                instancePath.lineTo(23.355251f, 7.3999724f);
                instancePath.cubicTo(29.377106f, 8.719497f, 33.48841f, 13.843313f, 33.95838f, 24.302568f);
                instancePath.cubicTo(33.769905f, 28.412003f, 34.089592f, 31.934727f, 34.821133f, 34.91406f);
                instancePath.lineTo(28.334389f, 28.619492f);
                instancePath.cubicTo(28.294184f, 28.580555f, 28.294184f, 28.580555f, 28.10701f, 28.399086f);
                instancePath.cubicTo(27.850748f, 28.150501f, 27.707758f, 28.011713f, 27.466179f, 27.777033f);
                instancePath.cubicTo(26.775806f, 27.106375f, 26.006472f, 26.357574f, 25.177935f, 25.549345f);
                instancePath.cubicTo(22.810862f, 23.240292f, 20.44387f, 20.917908f, 18.235228f, 18.732124f);
                instancePath.cubicTo(18.06544f, 18.564066f, 18.06544f, 18.564066f, 17.895714f, 18.39596f);
                instancePath.cubicTo(15.029206f, 15.556324f, 12.680043f, 13.193508f, 11.007507f, 11.458933f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                instancePaint6.setColor(-11711155);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(1.5f, 42.5f);
                instancePath2.lineTo(1.5f, 41.82444f);
                instancePath2.cubicTo(1.6038995f, 41.74702f, 1.7123853f, 41.662033f, 1.8249147f, 41.56911f);
                instancePath2.cubicTo(2.5979338f, 40.930805f, 3.3558638f, 40.07715f, 4.0502887f, 38.98194f);
                instancePath2.cubicTo(6.195145f, 35.59919f, 7.3330913f, 30.618256f, 7.0150514f, 23.757542f);
                instancePath2.cubicTo(7.107518f, 21.681265f, 7.2452464f, 20.08475f, 7.466496f, 18.886692f);
                instancePath2.cubicTo(14.1708975f, 26.23253f, 20.274372f, 32.6139f, 25.684317f, 38.023556f);
                instancePath2.cubicTo(27.371628f, 39.710777f, 28.891684f, 41.203136f, 30.23632f, 42.5f);
                instancePath2.lineTo(1.5f, 42.5f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint4, looper);
                instancePaint7.setColor(-11776948);
                instancePaint7.setStrokeCap(Paint.Cap.ROUND);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(5.3454547f, 6.3454547f);
                instancePath3.lineTo(42.115005f, 43.115005f);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
