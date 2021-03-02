package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class face_loading extends c {
    private final int height = 168;
    private final int width = 168;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                canvas.saveLayerAlpha(null, 230, 31);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(84.0f, 0.0f);
                instancePath.cubicTo(130.39192f, 0.0f, 168.0f, 37.60808f, 168.0f, 84.0f);
                instancePath.cubicTo(168.0f, 130.39192f, 130.39192f, 168.0f, 84.0f, 168.0f);
                instancePath.lineTo(84.0f, 153.3f);
                instancePath.cubicTo(122.27333f, 153.3f, 153.3f, 122.27333f, 153.3f, 84.0f);
                instancePath.cubicTo(153.3f, 45.726665f, 122.27333f, 14.7f, 84.0f, 14.7f);
                instancePath.lineTo(84.0f, 0.0f);
                instancePath.close();
                Paint instancePaint4 = c.instancePaint(looper);
                instancePaint4.setFlags(385);
                instancePaint4.setStyle(Paint.Style.FILL);
                Paint instancePaint5 = c.instancePaint(looper);
                instancePaint5.setFlags(385);
                instancePaint5.setStyle(Paint.Style.STROKE);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint5.setStrokeWidth(1.0f);
                instancePaint5.setStrokeCap(Paint.Cap.BUTT);
                instancePaint5.setStrokeJoin(Paint.Join.MITER);
                instancePaint5.setStrokeMiter(4.0f);
                instancePaint5.setPathEffect(null);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 168.0f, 0.0f, 84.0f, 0.0f, 168.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint3, 0.94086915f, 0.0f, 0.94086915f, 0.90559083f, new int[]{15592941, 1290661357}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(84.0f, 0.0f);
                instancePath2.lineTo(84.0f, 14.7f);
                instancePath2.cubicTo(45.726665f, 14.7f, 14.7f, 45.726665f, 14.7f, 84.0f);
                instancePath2.cubicTo(14.7f, 122.27333f, 45.726665f, 153.3f, 84.0f, 153.3f);
                instancePath2.lineTo(84.0f, 168.0f);
                instancePath2.cubicTo(37.60808f, 168.0f, 0.0f, 130.39192f, 0.0f, 84.0f);
                instancePath2.cubicTo(0.0f, 37.60808f, 37.60808f, 0.0f, 84.0f, 0.0f);
                instancePath2.close();
                Paint instancePaint7 = c.instancePaint(looper);
                instancePaint7.setFlags(385);
                instancePaint7.setStyle(Paint.Style.FILL);
                Paint instancePaint8 = c.instancePaint(looper);
                instancePaint8.setFlags(385);
                instancePaint8.setStyle(Paint.Style.STROKE);
                instancePaint7.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint8.setStrokeWidth(1.0f);
                instancePaint8.setStrokeCap(Paint.Cap.BUTT);
                instancePaint8.setStrokeJoin(Paint.Join.MITER);
                instancePaint8.setStrokeMiter(4.0f);
                instancePaint8.setPathEffect(null);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 84.0f, 0.0f, 0.0f, 0.0f, 168.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint6, 1.0f, 0.08673706f, 1.0f, 0.9062866f, new int[]{-1184275, 1290661357}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(-1184275);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(85.05f, 0.0f);
                instancePath3.cubicTo(89.1093f, 0.0f, 92.4f, 3.2907066f, 92.4f, 7.35f);
                instancePath3.cubicTo(92.4f, 11.409293f, 89.1093f, 14.7f, 85.05f, 14.7f);
                instancePath3.cubicTo(80.99071f, 14.7f, 77.700005f, 11.409293f, 77.700005f, 7.35f);
                instancePath3.cubicTo(77.700005f, 3.2907066f, 80.99071f, 0.0f, 85.05f, 0.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint9);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
