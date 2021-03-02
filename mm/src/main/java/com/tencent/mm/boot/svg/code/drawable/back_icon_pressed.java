package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class back_icon_pressed extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-8355712);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.saveLayerAlpha(null, 128, 31);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(-3.5527137E-15f, 24.0f);
                instancePath.cubicTo(8.006664f, 16.0f, 16.013329f, 8.0f, 24.0f, 3.5527137E-15f);
                instancePath.cubicTo(25.549355f, 1.3682896f, 26.918783f, 2.8764045f, 28.0f, 4.0f);
                instancePath.cubicTo(22.620575f, 9.877653f, 17.152853f, 15.440699f, 12.0f, 21.0f);
                instancePath.cubicTo(23.7601f, 20.973783f, 35.875053f, 20.94382f, 48.0f, 21.0f);
                instancePath.lineTo(48.0f, 27.0f);
                instancePath.cubicTo(35.85506f, 27.026217f, 23.710121f, 26.996254f, 12.0f, 27.0f);
                instancePath.cubicTo(17.11287f, 32.5593f, 22.610579f, 38.142323f, 28.0f, 44.0f);
                instancePath.cubicTo(26.878801f, 45.133583f, 25.519367f, 46.651684f, 24.0f, 48.0f);
                instancePath.cubicTo(15.993336f, 40.019974f, 7.9866724f, 32.019974f, -3.5527137E-15f, 24.0f);
                instancePath.lineTo(-3.5527137E-15f, 24.0f);
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
