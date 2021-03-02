package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_open_material_filled_more_night extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 16.0f);
                instancePath.cubicTo(0.0f, 7.1634436f, 7.1634436f, 0.0f, 16.0f, 0.0f);
                instancePath.lineTo(16.0f, 0.0f);
                instancePath.cubicTo(24.836555f, 0.0f, 32.0f, 7.1634436f, 32.0f, 16.0f);
                instancePath.lineTo(32.0f, 16.0f);
                instancePath.cubicTo(32.0f, 24.836555f, 24.836555f, 32.0f, 16.0f, 32.0f);
                instancePath.lineTo(16.0f, 32.0f);
                instancePath.cubicTo(7.1634436f, 32.0f, 0.0f, 24.836555f, 0.0f, 16.0f);
                instancePath.lineTo(0.0f, 16.0f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 12, 31);
                canvas.drawPath(instancePath, c.instancePaint(instancePaint4, looper));
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(1291845631);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(4.5833335f, 9.166667f);
                instancePath2.cubicTo(5.5957f, 9.166667f, 6.4166665f, 9.987267f, 6.4166665f, 11.0f);
                instancePath2.cubicTo(6.4166665f, 12.012366f, 5.5957f, 12.833333f, 4.5833335f, 12.833333f);
                instancePath2.cubicTo(3.5709667f, 12.833333f, 2.75f, 12.012366f, 2.75f, 11.0f);
                instancePath2.cubicTo(2.75f, 9.987267f, 3.5709667f, 9.166667f, 4.5833335f, 9.166667f);
                instancePath2.close();
                instancePath2.moveTo(11.0f, 9.166667f);
                instancePath2.cubicTo(12.012366f, 9.166667f, 12.833333f, 9.987267f, 12.833333f, 11.0f);
                instancePath2.cubicTo(12.833333f, 12.012366f, 12.012366f, 12.833333f, 11.0f, 12.833333f);
                instancePath2.cubicTo(9.987634f, 12.833333f, 9.166667f, 12.012366f, 9.166667f, 11.0f);
                instancePath2.cubicTo(9.166667f, 9.987267f, 9.987634f, 9.166667f, 11.0f, 9.166667f);
                instancePath2.close();
                instancePath2.moveTo(17.416666f, 9.166667f);
                instancePath2.cubicTo(18.429033f, 9.166667f, 19.25f, 9.987267f, 19.25f, 11.0f);
                instancePath2.cubicTo(19.25f, 12.012366f, 18.429033f, 12.833333f, 17.416666f, 12.833333f);
                instancePath2.cubicTo(16.4043f, 12.833333f, 15.583333f, 12.012366f, 15.583333f, 11.0f);
                instancePath2.cubicTo(15.583333f, 9.987267f, 16.4043f, 9.166667f, 17.416666f, 9.166667f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
