package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class checkbox_selected_game extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-15616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 6.4f);
                instancePath.cubicTo(0.0f, 2.8653774f, 2.8653774f, 0.0f, 6.4f, 0.0f);
                instancePath.lineTo(41.6f, 0.0f);
                instancePath.cubicTo(45.13462f, 0.0f, 48.0f, 2.8653774f, 48.0f, 6.4f);
                instancePath.lineTo(48.0f, 41.6f);
                instancePath.cubicTo(48.0f, 45.13462f, 45.13462f, 48.0f, 41.6f, 48.0f);
                instancePath.lineTo(6.4f, 48.0f);
                instancePath.cubicTo(2.8653774f, 48.0f, 0.0f, 45.13462f, 0.0f, 41.6f);
                instancePath.lineTo(0.0f, 6.4f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(37.20189f, 9.6f);
                instancePath2.lineTo(41.72737f, 14.1254835f);
                instancePath2.lineTo(23.89f, 31.962f);
                instancePath2.lineTo(23.91362f, 31.98589f);
                instancePath2.lineTo(19.388138f, 36.51137f);
                instancePath2.lineTo(6.4f, 23.523235f);
                instancePath2.lineTo(10.925484f, 18.997753f);
                instancePath2.lineTo(19.365f, 27.437f);
                instancePath2.lineTo(37.20189f, 9.6f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
