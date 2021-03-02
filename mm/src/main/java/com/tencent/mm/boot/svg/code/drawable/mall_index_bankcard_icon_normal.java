package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class mall_index_bankcard_icon_normal extends c {
    private final int height = 93;
    private final int width = 93;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 93;
            case 1:
                return 93;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 13.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(3.7996218f, 0.0f);
                instancePath.cubicTo(2.1727934f, 0.0f, 0.0f, 2.2915592f, 0.0f, 5.020509f);
                instancePath.lineTo(0.0f, 61.501232f);
                instancePath.cubicTo(0.0f, 64.23018f, 2.1727934f, 66.521736f, 3.7996218f, 66.521736f);
                instancePath.lineTo(83.59168f, 66.521736f);
                instancePath.cubicTo(85.217415f, 66.521736f, 87.391304f, 64.23018f, 87.391304f, 61.501232f);
                instancePath.lineTo(87.391304f, 5.020509f);
                instancePath.cubicTo(87.391304f, 2.2915592f, 85.217415f, 0.0f, 83.59168f, 0.0f);
                instancePath.lineTo(3.7996218f, 0.0f);
                instancePath.close();
                instancePath.moveTo(10.302137f, 6.521739f);
                instancePath.cubicTo(8.370235f, 6.521739f, 6.521739f, 8.363973f, 6.521739f, 10.252781f);
                instancePath.lineTo(6.521739f, 56.26896f);
                instancePath.cubicTo(6.521739f, 58.157764f, 8.370235f, 60.0f, 10.302137f, 60.0f);
                instancePath.lineTo(77.089165f, 60.0f);
                instancePath.cubicTo(79.02014f, 60.0f, 80.86957f, 58.157764f, 80.86957f, 56.26896f);
                instancePath.lineTo(80.86957f, 10.252781f);
                instancePath.cubicTo(80.86957f, 8.363973f, 79.02014f, 6.521739f, 77.089165f, 6.521739f);
                instancePath.lineTo(10.302137f, 6.521739f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(13.0f, 18.0f);
                instancePath2.lineTo(74.30435f, 18.0f);
                instancePath2.lineTo(74.30435f, 25.826088f);
                instancePath2.lineTo(13.0f, 25.826088f);
                instancePath2.lineTo(13.0f, 18.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
