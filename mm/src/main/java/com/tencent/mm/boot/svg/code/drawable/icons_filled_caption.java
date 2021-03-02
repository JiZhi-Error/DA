package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_caption extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 72.17484f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(62.768333f, 12.588635f);
                instancePath.cubicTo(64.15884f, 12.588635f, 65.286064f, 13.71586f, 65.286064f, 15.106362f);
                instancePath.lineTo(65.286064f, 57.06848f);
                instancePath.cubicTo(65.286064f, 58.45898f, 64.15884f, 59.58621f, 62.768333f, 59.58621f);
                instancePath.lineTo(9.056824f, 59.58621f);
                instancePath.cubicTo(7.6663213f, 59.58621f, 6.539097f, 58.45898f, 6.539097f, 57.06848f);
                instancePath.lineTo(6.539097f, 15.106362f);
                instancePath.cubicTo(6.539097f, 13.71586f, 7.6663213f, 12.588635f, 9.056824f, 12.588635f);
                instancePath.lineTo(62.768333f, 12.588635f);
                instancePath.close();
                instancePath.moveTo(43.990288f, 26.908209f);
                instancePath.lineTo(21.960175f, 26.908209f);
                instancePath.lineTo(21.960175f, 32.782906f);
                instancePath.lineTo(43.990288f, 32.782906f);
                instancePath.lineTo(43.990288f, 26.908209f);
                instancePath.close();
                instancePath.moveTo(16.827158f, 26.908209f);
                instancePath.lineTo(10.945119f, 26.908209f);
                instancePath.lineTo(10.945119f, 32.782906f);
                instancePath.lineTo(16.827158f, 32.782906f);
                instancePath.lineTo(16.827158f, 26.908209f);
                instancePath.close();
                instancePath.moveTo(61.614376f, 16.994658f);
                instancePath.lineTo(10.945119f, 16.994658f);
                instancePath.lineTo(10.945119f, 22.869354f);
                instancePath.lineTo(61.614376f, 22.869354f);
                instancePath.lineTo(61.614376f, 16.994658f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
