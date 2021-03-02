package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sight_list_checkbox_selected_red extends c {
    private final int height = 90;
    private final int width = 90;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                instancePaint3.setColor(-27648);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 11.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(26.41996f, 1.7123995f);
                instancePath.cubicTo(42.029785f, -1.784037f, 59.069595f, 7.9460464f, 64.08954f, 23.090612f);
                instancePath.cubicTo(69.899475f, 38.474934f, 61.969563f, 57.26578f, 46.91973f, 63.879044f);
                instancePath.cubicTo(32.549892f, 71.01177f, 13.600102f, 65.46742f, 5.210196f, 51.84131f);
                instancePath.cubicTo(-2.9097135f, 39.703682f, -1.3797306f, 22.281437f, 8.690157f, 11.712208f);
                instancePath.cubicTo(13.340105f, 6.6174006f, 19.670034f, 3.110974f, 26.41996f, 1.7123995f);
                instancePath.lineTo(26.41996f, 1.7123995f);
                instancePath.close();
                instancePath.moveTo(12.0f, 32.0f);
                instancePath.lineTo(12.0f, 36.0f);
                instancePath.lineTo(54.0f, 36.0f);
                instancePath.lineTo(54.0f, 32.0f);
                instancePath.lineTo(12.0f, 32.0f);
                instancePath.lineTo(12.0f, 32.0f);
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
