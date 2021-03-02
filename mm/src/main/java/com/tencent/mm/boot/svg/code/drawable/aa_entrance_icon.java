package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class aa_entrance_icon extends c {
    private final int height = 192;
    private final int width = 192;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 39.0f, 0.0f, 1.0f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.restore();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-16268960);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(142.4f, 92.48429f);
                instancePath.lineTo(142.4f, 33.6f);
                instancePath.lineTo(49.6f, 33.6f);
                instancePath.lineTo(49.6f, 158.4f);
                instancePath.lineTo(142.4f, 158.4f);
                instancePath.lineTo(142.4f, 102.69538f);
                instancePath.lineTo(105.799934f, 141.4712f);
                instancePath.cubicTo(105.63241f, 141.6487f, 105.457054f, 141.81863f, 105.2744f, 141.9805f);
                instancePath.cubicTo(101.87888f, 144.98962f, 96.6869f, 144.67639f, 93.67777f, 141.28088f);
                instancePath.lineTo(72.0f, 116.81955f);
                instancePath.lineTo(76.605804f, 112.29486f);
                instancePath.lineTo(99.63481f, 130.88316f);
                instancePath.lineTo(142.4f, 92.48429f);
                instancePath.close();
                instancePath.moveTo(48.0f, 24.0f);
                instancePath.lineTo(144.0f, 24.0f);
                instancePath.cubicTo(148.41827f, 24.0f, 152.0f, 27.581722f, 152.0f, 32.0f);
                instancePath.lineTo(152.0f, 160.0f);
                instancePath.cubicTo(152.0f, 164.41827f, 148.41827f, 168.0f, 144.0f, 168.0f);
                instancePath.lineTo(48.0f, 168.0f);
                instancePath.cubicTo(43.581722f, 168.0f, 40.0f, 164.41827f, 40.0f, 160.0f);
                instancePath.lineTo(40.0f, 32.0f);
                instancePath.cubicTo(40.0f, 27.581722f, 43.581722f, 24.0f, 48.0f, 24.0f);
                instancePath.close();
                instancePath.moveTo(60.0f, 48.0f);
                instancePath.lineTo(108.0f, 48.0f);
                instancePath.lineTo(108.0f, 57.600002f);
                instancePath.lineTo(60.0f, 57.600002f);
                instancePath.lineTo(60.0f, 48.0f);
                instancePath.close();
                instancePath.moveTo(60.0f, 72.0f);
                instancePath.lineTo(108.0f, 72.0f);
                instancePath.lineTo(108.0f, 81.6f);
                instancePath.lineTo(60.0f, 81.6f);
                instancePath.lineTo(60.0f, 72.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
