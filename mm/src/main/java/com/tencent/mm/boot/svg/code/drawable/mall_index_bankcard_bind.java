package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class mall_index_bankcard_bind extends c {
    private final int height = 70;
    private final int width = 90;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 90;
            case 1:
                return 70;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 4.4922566f);
                instancePath.cubicTo(0.46f, 1.6837293f, 3.04f, -0.3052276f, 5.88f, 0.044588927f);
                instancePath.cubicTo(31.95f, 0.02459941f, 58.02f, 0.03459417f, 84.09f, 0.044588927f);
                instancePath.cubicTo(86.85f, -0.31522238f, 89.24f, 1.5438027f, 90.0f, 4.1324453f);
                instancePath.lineTo(90.0f, 61.532345f);
                instancePath.cubicTo(89.6f, 63.73119f, 88.0f, 65.33035f, 85.92f, 66.0f);
                instancePath.lineTo(4.35f, 66.0f);
                instancePath.cubicTo(2.2f, 65.55024f, 0.66f, 63.94108f, 0.0f, 61.892155f);
                instancePath.lineTo(0.0f, 4.4922566f);
                instancePath.close();
                instancePath.moveTo(7.0f, 14.0f);
                instancePath.lineTo(83.0f, 14.0f);
                instancePath.lineTo(83.0f, 26.0f);
                instancePath.lineTo(7.0f, 26.0f);
                instancePath.lineTo(7.0f, 14.0f);
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
