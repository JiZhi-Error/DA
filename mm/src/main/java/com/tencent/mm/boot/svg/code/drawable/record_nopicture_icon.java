package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.WebView;

public class record_nopicture_icon extends c {
    private final int height = TXLiveConstants.RENDER_ROTATION_180;
    private final int width = TXLiveConstants.RENDER_ROTATION_180;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return TXLiveConstants.RENDER_ROTATION_180;
            case 1:
                return TXLiveConstants.RENDER_ROTATION_180;
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
                instancePaint3.setColor(-1315861);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 20.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(171.0f, 90.18926f);
                instancePath.lineTo(171.0f, 9.032258f);
                instancePath.lineTo(9.0f, 9.032258f);
                instancePath.lineTo(9.0f, 89.96034f);
                instancePath.lineTo(60.553738f, 41.65066f);
                instancePath.lineTo(121.92021f, 98.15694f);
                instancePath.lineTo(113.13358f, 80.02691f);
                instancePath.lineTo(138.16164f, 60.600388f);
                instancePath.lineTo(171.0f, 90.18926f);
                instancePath.lineTo(171.0f, 90.18926f);
                instancePath.lineTo(171.0f, 90.18926f);
                instancePath.close();
                instancePath.moveTo(4.494371f, 0.0f);
                instancePath.cubicTo(2.0121984f, 0.0f, 0.0f, 2.0194945f, 0.0f, 4.5191708f);
                instancePath.lineTo(0.0f, 135.48083f);
                instancePath.cubicTo(0.0f, 137.9767f, 2.0214844f, 140.0f, 4.494371f, 140.0f);
                instancePath.lineTo(175.50563f, 140.0f);
                instancePath.cubicTo(177.98781f, 140.0f, 180.0f, 137.9805f, 180.0f, 135.48083f);
                instancePath.lineTo(180.0f, 4.5191708f);
                instancePath.cubicTo(180.0f, 2.0233016f, 177.97852f, 0.0f, 175.50563f, 0.0f);
                instancePath.lineTo(4.494371f, 0.0f);
                instancePath.lineTo(4.494371f, 0.0f);
                instancePath.lineTo(4.494371f, 0.0f);
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
