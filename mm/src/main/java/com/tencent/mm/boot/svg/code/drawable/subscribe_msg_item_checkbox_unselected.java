package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class subscribe_msg_item_checkbox_unselected extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.96f, 0.0f, 0.0f, 0.0f, 0.96f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint3.setStrokeWidth(1.2f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(23.4f, 12.148149f);
                instancePath.cubicTo(23.4f, 5.703816f, 18.296185f, 0.6000004f, 11.851851f, 0.6000004f);
                instancePath.cubicTo(5.6606994f, 0.6000004f, 0.5999994f, 5.7477555f, 0.5999994f, 12.148149f);
                instancePath.cubicTo(0.5999994f, 18.296185f, 5.7038145f, 23.400002f, 11.851851f, 23.400002f);
                instancePath.cubicTo(18.252245f, 23.400002f, 23.4f, 18.339302f, 23.4f, 12.1481495f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 76, 31);
                canvas.drawPath(instancePath, c.instancePaint(instancePaint3, looper));
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
