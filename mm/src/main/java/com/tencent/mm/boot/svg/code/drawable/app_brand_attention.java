package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_attention extends c {
    private final int height = 279;
    private final int width = 279;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 279;
            case 1:
                return 279;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -144.0f, 0.0f, 1.0f, -69.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 144.0f, 0.0f, 1.0f, 69.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-3552823);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(279.0f, 141.1269f);
                instancePath.cubicTo(279.0f, 62.751225f, 216.54533f, 0.60727614f, 137.77777f, 0.60727614f);
                instancePath.cubicTo(62.454666f, 0.60727614f, 0.0f, 62.751225f, 0.0f, 141.1269f);
                instancePath.cubicTo(0.0f, 216.07527f, 62.454666f, 278.2192f, 137.77777f, 278.2192f);
                instancePath.cubicTo(216.54533f, 278.2192f, 279.0f, 216.07527f, 279.0f, 141.1269f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(131.70822f, 71.3711f);
                instancePath2.cubicTo(128.45819f, 71.3711f, 125.94605f, 74.00451f, 126.09674f, 77.24315f);
                instancePath2.lineTo(130.2428f, 166.35248f);
                instancePath2.cubicTo(130.31987f, 168.00896f, 131.72324f, 169.35179f, 133.37312f, 169.35179f);
                instancePath2.lineTo(145.62688f, 169.35179f);
                instancePath2.cubicTo(147.27864f, 169.35179f, 148.68036f, 168.004f, 148.7572f, 166.35248f);
                instancePath2.lineTo(152.90326f, 77.24315f);
                instancePath2.cubicTo(153.05415f, 74.00011f, 150.54134f, 71.3711f, 147.29178f, 71.3711f);
                instancePath2.lineTo(131.70822f, 71.3711f);
                instancePath2.close();
                instancePath2.moveTo(139.5f, 212.89876f);
                instancePath2.cubicTo(147.0533f, 212.89876f, 153.17647f, 206.80606f, 153.17647f, 199.29033f);
                instancePath2.cubicTo(153.17647f, 191.7746f, 147.0533f, 185.6819f, 139.5f, 185.6819f);
                instancePath2.cubicTo(131.9467f, 185.6819f, 125.82353f, 191.7746f, 125.82353f, 199.29033f);
                instancePath2.cubicTo(125.82353f, 206.80606f, 131.9467f, 212.89876f, 139.5f, 212.89876f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
