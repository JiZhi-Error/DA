package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.WebView;

public class multitalk_video_action extends c {
    private final int height = 240;
    private final int width = TXLiveConstants.RENDER_ROTATION_180;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return TXLiveConstants.RENDER_ROTATION_180;
            case 1:
                return 240;
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
                instancePaint4.setColor(-1);
                instancePaint4.setStrokeWidth(4.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 44.0f, 0.0f, 1.0f, 63.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 4.9965324f);
                instancePath.cubicTo(0.0f, 3.3415933f, 1.3449905f, 2.0f, 2.9962382f, 2.0f);
                instancePath.lineTo(60.00376f, 2.0f);
                instancePath.cubicTo(61.65854f, 2.0f, 63.0f, 3.3373792f, 63.0f, 4.9965324f);
                instancePath.lineTo(63.0f, 49.003468f);
                instancePath.cubicTo(63.0f, 50.658405f, 61.65501f, 52.0f, 60.00376f, 52.0f);
                instancePath.lineTo(2.9962382f, 52.0f);
                instancePath.cubicTo(1.3414615f, 52.0f, 0.0f, 50.66262f, 0.0f, 49.003468f);
                instancePath.lineTo(0.0f, 4.9965324f);
                instancePath.close();
                instancePath.moveTo(87.5f, 53.797123f);
                instancePath.cubicTo(89.91545f, 54.568535f, 92.0f, 53.05244f, 92.0f, 50.732754f);
                instancePath.lineTo(92.0f, 3.235053f);
                instancePath.cubicTo(92.0f, 0.6385606f, 89.694824f, -0.4511346f, 87.5f, 0.17068519f);
                instancePath.cubicTo(86.19809f, 1.3064651f, 75.559074f, 11.176803f, 68.0f, 18.05712f);
                instancePath.lineTo(68.0f, 35.728115f);
                instancePath.cubicTo(75.74342f, 42.702545f, 86.61983f, 52.864586f, 87.5f, 53.797123f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
