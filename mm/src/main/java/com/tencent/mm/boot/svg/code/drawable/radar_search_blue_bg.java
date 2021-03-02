package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;

public class radar_search_blue_bg extends c {
    private final int height = 74;
    private final int width = TbsListener.ErrorCode.STARTDOWNLOAD_6;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return TbsListener.ErrorCode.STARTDOWNLOAD_6;
            case 1:
                return 74;
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
                instancePaint3.setColor(-14442031);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 4.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(87.71f, 1.02f);
                instancePath.cubicTo(97.18f, 0.98f, 106.65f, 1.01f, 116.11f, 1.0f);
                instancePath.cubicTo(122.86f, 0.94f, 129.37f, 4.23f, 133.81f, 9.23f);
                instancePath.cubicTo(138.87f, 14.77f, 141.51f, 22.18f, 142.0f, 29.61f);
                instancePath.lineTo(142.0f, 36.95f);
                instancePath.cubicTo(141.63f, 45.0f, 138.59f, 53.09f, 132.81f, 58.82f);
                instancePath.cubicTo(128.22f, 63.52f, 121.67f, 66.29f, 115.07f, 66.0f);
                instancePath.cubicTo(76.95f, 65.86f, 38.82f, 66.27f, 0.7f, 65.79f);
                instancePath.cubicTo(14.4f, 65.13f, 27.91f, 61.47f, 40.08f, 55.19f);
                instancePath.cubicTo(62.05f, 44.0f, 79.39f, 24.21f, 87.71f, 1.02f);
                instancePath.lineTo(87.71f, 1.02f);
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
