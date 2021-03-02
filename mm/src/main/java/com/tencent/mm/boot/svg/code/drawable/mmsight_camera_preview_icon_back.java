package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class mmsight_camera_preview_icon_back extends c {
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
                canvas.saveLayerAlpha(null, 204, 31);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 83.0f, 0.0f, 1.0f, 91.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(32.8514f, 18.0f);
                instancePath.lineTo(15.0f, 18.0f);
                instancePath.lineTo(15.0f, 30.0f);
                instancePath.lineTo(0.0f, 15.0f);
                instancePath.lineTo(15.0f, 0.0f);
                instancePath.lineTo(15.0f, 12.0f);
                instancePath.lineTo(52.5f, 12.0f);
                instancePath.cubicTo(64.92641f, 12.0f, 75.0f, 22.073593f, 75.0f, 34.5f);
                instancePath.cubicTo(75.0f, 46.926407f, 64.92641f, 57.0f, 52.5f, 57.0f);
                instancePath.lineTo(28.0f, 57.0f);
                instancePath.lineTo(28.0f, 51.0f);
                instancePath.lineTo(28.5f, 51.0f);
                instancePath.lineTo(32.8514f, 51.0f);
                instancePath.lineTo(37.202793f, 51.0f);
                instancePath.lineTo(52.5f, 51.0f);
                instancePath.cubicTo(61.612698f, 51.0f, 69.0f, 43.612698f, 69.0f, 34.5f);
                instancePath.cubicTo(69.0f, 25.387302f, 61.612698f, 18.0f, 52.5f, 18.0f);
                instancePath.lineTo(32.8514f, 18.0f);
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
