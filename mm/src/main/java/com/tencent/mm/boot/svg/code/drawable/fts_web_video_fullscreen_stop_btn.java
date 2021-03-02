package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fts_web_video_fullscreen_stop_btn extends c {
    private final int height = 75;
    private final int width = 63;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 63;
            case 1:
                return 75;
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -366.0f, 0.0f, 1.0f, -536.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 377.0f, 0.0f, 1.0f, 537.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 3.0846448f);
                instancePath.cubicTo(0.0f, 1.8420041f, 1.0073593f, 0.83464485f, 2.25f, 0.83464485f);
                instancePath.lineTo(4.6465516f, 0.83464485f);
                instancePath.cubicTo(5.8891926f, 0.83464485f, 6.8965516f, 1.8420041f, 6.8965516f, 3.0846448f);
                instancePath.lineTo(6.8965516f, 69.939705f);
                instancePath.cubicTo(6.8965516f, 71.18234f, 5.8891926f, 72.189705f, 4.6465516f, 72.189705f);
                instancePath.lineTo(2.25f, 72.189705f);
                instancePath.cubicTo(1.0073593f, 72.189705f, 0.0f, 71.18234f, 0.0f, 69.939705f);
                instancePath.lineTo(0.0f, 3.0846448f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(33.103447f, 3.0880115f);
                instancePath2.cubicTo(33.103447f, 1.8435115f, 34.106266f, 0.83464485f, 35.361637f, 0.83464485f);
                instancePath2.lineTo(37.74181f, 0.83464485f);
                instancePath2.cubicTo(38.988976f, 0.83464485f, 40.0f, 1.8433424f, 40.0f, 3.0880115f);
                instancePath2.lineTo(40.0f, 69.93634f);
                instancePath2.cubicTo(40.0f, 71.18084f, 38.99718f, 72.189705f, 37.74181f, 72.189705f);
                instancePath2.lineTo(35.361637f, 72.189705f);
                instancePath2.cubicTo(34.114475f, 72.189705f, 33.103447f, 71.18101f, 33.103447f, 69.93634f);
                instancePath2.lineTo(33.103447f, 3.0880115f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
