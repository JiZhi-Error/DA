package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sns_unread_done extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -43.0f, 0.0f, 1.0f, -78.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 43.0f, 0.0f, 1.0f, 78.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(14211288);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(48.0f, 0.0f);
                instancePath.lineTo(48.0f, 48.0f);
                instancePath.lineTo(0.0f, 48.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(14211288);
                instancePaint6.setColor(1275068416);
                instancePaint6.setStrokeWidth(3.0f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(24.0f, 4.5f);
                instancePath2.cubicTo(34.769554f, 4.5f, 43.5f, 13.230447f, 43.5f, 24.0f);
                instancePath2.cubicTo(43.5f, 34.769554f, 34.769554f, 43.5f, 24.0f, 43.5f);
                instancePath2.cubicTo(13.230447f, 43.5f, 4.5f, 34.769554f, 4.5f, 24.0f);
                instancePath2.cubicTo(4.5f, 13.230447f, 13.230447f, 4.5f, 24.0f, 4.5f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                instancePaint7.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint8.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint8.setStrokeWidth(1.5f);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 16.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.saveLayerAlpha(null, 76, 31);
                canvas.save();
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 1.0f, 0.0f, 0.92f, 0.0f, 1.0f, 0.8f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint7, looper);
                Paint instancePaint10 = c.instancePaint(instancePaint8, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(7.6120753f, 13.324579f);
                instancePath3.lineTo(1.6686792f, 7.215168f);
                instancePath3.lineTo(0.48f, 8.43705f);
                instancePath3.lineTo(6.751941f, 14.884184f);
                instancePath3.cubicTo(7.2140718f, 15.359222f, 7.973798f, 15.369687f, 8.448836f, 14.907557f);
                instancePath3.cubicTo(8.456735f, 14.899873f, 8.464526f, 14.892081f, 8.47221f, 14.884184f);
                instancePath3.lineTo(21.48f, 1.513051f);
                instancePath3.lineTo(21.48f, 1.513051f);
                instancePath3.lineTo(20.29132f, 0.29116884f);
                instancePath3.lineTo(7.6120753f, 13.324579f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint9);
                canvas.drawPath(instancePath3, instancePaint10);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
