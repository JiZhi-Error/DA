package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class photo_edit_navbar_icon_mark extends c {
    private final int height = 240;
    private final int width = 240;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 240;
            case 1:
                return 240;
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
                canvas.saveLayerAlpha(null, 192, 31);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 92.0f, 0.0f, 1.0f, 95.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(44.0f, 4.0f);
                instancePath.lineTo(57.0f, 4.0f);
                instancePath.lineTo(57.0f, 9.0f);
                instancePath.lineTo(44.0f, 9.0f);
                instancePath.lineTo(44.0f, 14.0f);
                instancePath.lineTo(39.0f, 14.0f);
                instancePath.lineTo(39.0f, 0.0f);
                instancePath.lineTo(44.0f, 0.0f);
                instancePath.lineTo(44.0f, 4.0f);
                instancePath.close();
                instancePath.moveTo(0.0f, 4.0f);
                instancePath.lineTo(36.0f, 4.0f);
                instancePath.lineTo(36.0f, 9.0f);
                instancePath.lineTo(0.0f, 9.0f);
                instancePath.lineTo(0.0f, 4.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(22.0f, 24.0f);
                instancePath2.lineTo(57.0f, 24.0f);
                instancePath2.lineTo(57.0f, 29.0f);
                instancePath2.lineTo(22.0f, 29.0f);
                instancePath2.lineTo(22.0f, 32.0f);
                instancePath2.lineTo(17.0f, 32.0f);
                instancePath2.lineTo(17.0f, 21.0f);
                instancePath2.lineTo(22.0f, 21.0f);
                instancePath2.lineTo(22.0f, 24.0f);
                instancePath2.close();
                instancePath2.moveTo(0.0f, 24.0f);
                instancePath2.lineTo(14.0f, 24.0f);
                instancePath2.lineTo(14.0f, 29.0f);
                instancePath2.lineTo(0.0f, 29.0f);
                instancePath2.lineTo(0.0f, 24.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(44.0f, 43.0f);
                instancePath3.lineTo(57.0f, 43.0f);
                instancePath3.lineTo(57.0f, 48.0f);
                instancePath3.lineTo(44.0f, 48.0f);
                instancePath3.lineTo(44.0f, 51.0f);
                instancePath3.lineTo(40.0f, 51.0f);
                instancePath3.lineTo(40.0f, 40.0f);
                instancePath3.lineTo(44.0f, 40.0f);
                instancePath3.lineTo(44.0f, 43.0f);
                instancePath3.close();
                instancePath3.moveTo(0.0f, 43.0f);
                instancePath3.lineTo(36.0f, 43.0f);
                instancePath3.lineTo(36.0f, 48.0f);
                instancePath3.lineTo(0.0f, 48.0f);
                instancePath3.lineTo(0.0f, 43.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
