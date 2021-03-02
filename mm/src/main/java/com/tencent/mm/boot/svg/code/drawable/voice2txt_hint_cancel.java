package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class voice2txt_hint_cancel extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                canvas.saveLayerAlpha(null, 128, 31);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(6.5857863f, 6.0f);
                instancePath.lineTo(8.414213f, 7.8284273f);
                instancePath.lineTo(7.0f, 9.2426405f);
                instancePath.lineTo(3.464466f, 5.7071066f);
                instancePath.cubicTo(3.0739417f, 5.3165827f, 3.0739417f, 4.6834173f, 3.464466f, 4.2928934f);
                instancePath.lineTo(7.0f, 0.7573593f);
                instancePath.lineTo(8.414213f, 2.171573f);
                instancePath.lineTo(6.5857863f, 4.0f);
                instancePath.lineTo(11.0f, 4.0f);
                instancePath.cubicTo(14.313708f, 4.0f, 17.0f, 6.6862917f, 17.0f, 10.0f);
                instancePath.cubicTo(17.0f, 13.313708f, 14.313708f, 16.0f, 11.0f, 16.0f);
                instancePath.lineTo(0.0f, 16.0f);
                instancePath.lineTo(0.0f, 14.0f);
                instancePath.lineTo(11.0f, 14.0f);
                instancePath.cubicTo(13.209139f, 14.0f, 15.0f, 12.209139f, 15.0f, 10.0f);
                instancePath.cubicTo(15.0f, 7.790861f, 13.209139f, 6.0f, 11.0f, 6.0f);
                instancePath.lineTo(6.5857863f, 6.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
