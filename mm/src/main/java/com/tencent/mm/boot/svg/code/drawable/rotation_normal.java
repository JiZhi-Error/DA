package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class rotation_normal extends c {
    private final int height = 63;
    private final int width = 63;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 18.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(5.0f, 5.0f);
                instancePath.lineTo(5.0f, 34.0f);
                instancePath.lineTo(34.0f, 34.0f);
                instancePath.lineTo(34.0f, 5.0f);
                instancePath.lineTo(5.0f, 5.0f);
                instancePath.close();
                instancePath.moveTo(0.0f, 1.5049495f);
                instancePath.cubicTo(0.0f, 0.67378885f, 0.676918f, 0.0f, 1.5049495f, 0.0f);
                instancePath.lineTo(37.495052f, 0.0f);
                instancePath.cubicTo(38.32621f, 0.0f, 39.0f, 0.676918f, 39.0f, 1.5049495f);
                instancePath.lineTo(39.0f, 37.495052f);
                instancePath.cubicTo(39.0f, 38.32621f, 38.323082f, 39.0f, 37.495052f, 39.0f);
                instancePath.lineTo(1.5049495f, 39.0f);
                instancePath.cubicTo(0.67378885f, 39.0f, 0.0f, 38.323082f, 0.0f, 37.495052f);
                instancePath.lineTo(0.0f, 1.5049495f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(52.925938f, 23.0f);
                instancePath2.cubicTo(52.974922f, 22.49169f, 53.0f, 21.976135f, 53.0f, 21.454546f);
                instancePath2.cubicTo(53.0f, 12.919235f, 46.28427f, 6.0f, 38.0f, 6.0f);
                instancePath2.cubicTo(35.866688f, 6.0f, 33.837387f, 6.4588375f, 32.0f, 7.285953f);
                instancePath2.lineTo(32.0f, 10.252686f);
                instancePath2.cubicTo(33.60105f, 9.50638f, 35.378433f, 9.090909f, 37.25f, 9.090909f);
                instancePath2.cubicTo(44.29163f, 9.090909f, 50.0f, 14.9722595f, 50.0f, 22.227272f);
                instancePath2.cubicTo(50.0f, 22.486673f, 49.992702f, 22.744318f, 49.978306f, 23.0f);
                instancePath2.lineTo(52.925938f, 23.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(35.0f, 0.0f);
                instancePath3.lineTo(26.0f, 7.4431515f);
                instancePath3.lineTo(34.865273f, 15.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
