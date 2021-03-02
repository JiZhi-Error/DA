package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class biz_video_play_icon extends c {
    private final int height = 7;
    private final int width = 6;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 6;
            case 1:
                return 7;
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
                canvas.saveLayerAlpha(null, 230, 31);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -275.0f, 0.0f, 1.0f, -432.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, -1.0f, 0.0f, 314.0f, 0.0f, 1.0f, 381.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, -1.0f, 0.0f, 41.999996f, 0.0f, 1.0f, 48.666668f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                c.instancePaint(instancePaint3, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(4.6827316f, 2.458604f);
                instancePath.lineTo(8.70237f, 4.9322276f);
                instancePath.cubicTo(9.015942f, 5.125195f, 9.113711f, 5.535826f, 8.920744f, 5.849398f);
                instancePath.cubicTo(8.866049f, 5.9382787f, 8.79125f, 6.013077f, 8.70237f, 6.0677724f);
                instancePath.lineTo(4.6827316f, 8.541396f);
                instancePath.cubicTo(4.3691597f, 8.734364f, 3.9585285f, 8.636594f, 3.765561f, 8.323022f);
                instancePath.cubicTo(3.7009015f, 8.21795f, 3.6666667f, 8.096997f, 3.6666667f, 7.9736238f);
                instancePath.lineTo(3.6666667f, 3.0263762f);
                instancePath.cubicTo(3.6666667f, 2.6581864f, 3.9651434f, 2.3597095f, 4.3333335f, 2.3597095f);
                instancePath.cubicTo(4.4567065f, 2.3597095f, 4.5776596f, 2.3939445f, 4.6827316f, 2.458604f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
