package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class more_more_icon_pressed extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-14046139);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(96.0f, 0.0f);
                instancePath.lineTo(96.0f, 96.0f);
                instancePath.lineTo(0.0f, 96.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.drawPath(instancePath, c.instancePaint(instancePaint3, looper));
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(20.25f, 36.0f);
                instancePath2.cubicTo(20.25f, 38.89905f, 17.89905f, 41.25f, 15.0f, 41.25f);
                instancePath2.cubicTo(12.10095f, 41.25f, 9.75f, 38.89905f, 9.75f, 36.0f);
                instancePath2.cubicTo(9.75f, 33.0999f, 12.10095f, 30.75f, 15.0f, 30.75f);
                instancePath2.cubicTo(17.89905f, 30.75f, 20.25f, 33.0999f, 20.25f, 36.0f);
                instancePath2.close();
                instancePath2.moveTo(36.0f, 30.75f);
                instancePath2.cubicTo(38.89905f, 30.75f, 41.25f, 33.0999f, 41.25f, 36.0f);
                instancePath2.cubicTo(41.25f, 38.89905f, 38.89905f, 41.25f, 36.0f, 41.25f);
                instancePath2.cubicTo(33.10095f, 41.25f, 30.75f, 38.89905f, 30.75f, 36.0f);
                instancePath2.cubicTo(30.75f, 33.0999f, 33.10095f, 30.75f, 36.0f, 30.75f);
                instancePath2.close();
                instancePath2.moveTo(57.0f, 30.75f);
                instancePath2.cubicTo(59.89905f, 30.75f, 62.25f, 33.0999f, 62.25f, 36.0f);
                instancePath2.cubicTo(62.25f, 38.89905f, 59.89905f, 41.25f, 57.0f, 41.25f);
                instancePath2.cubicTo(54.10095f, 41.25f, 51.75f, 38.89905f, 51.75f, 36.0f);
                instancePath2.cubicTo(51.75f, 33.0999f, 54.10095f, 30.75f, 57.0f, 30.75f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
