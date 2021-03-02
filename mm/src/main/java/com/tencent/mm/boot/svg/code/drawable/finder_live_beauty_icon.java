package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_live_beauty_icon extends c {
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
                canvas.saveLayerAlpha(null, 230, 31);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.666667f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.333333f, 0.6666667f);
                instancePath.cubicTo(16.130625f, 0.6666667f, 18.726723f, 1.5280821f, 20.870827f, 3.0001142f);
                instancePath.cubicTo(20.67294f, 3.2583961f, 20.48108f, 3.4801023f, 20.294516f, 3.6666667f);
                instancePath.cubicTo(19.927374f, 4.033808f, 19.424139f, 4.421456f, 18.784813f, 4.82961f);
                instancePath.cubicTo(17.189112f, 3.879174f, 15.324966f, 3.3333333f, 13.333333f, 3.3333333f);
                instancePath.cubicTo(7.442296f, 3.3333333f, 2.6666667f, 8.108963f, 2.6666667f, 14.0f);
                instancePath.cubicTo(2.6666667f, 19.891037f, 7.442296f, 24.666666f, 13.333333f, 24.666666f);
                instancePath.cubicTo(19.224371f, 24.666666f, 24.0f, 19.891037f, 24.0f, 14.0f);
                instancePath.cubicTo(24.0f, 13.76653f, 23.992498f, 13.534813f, 23.977726f, 13.305075f);
                instancePath.cubicTo(24.534388f, 12.008838f, 25.34915f, 11.1179085f, 26.199657f, 10.488136f);
                instancePath.cubicTo(26.504166f, 11.608049f, 26.666666f, 12.785048f, 26.666666f, 14.0f);
                instancePath.cubicTo(26.666666f, 21.363796f, 20.69713f, 27.333334f, 13.333333f, 27.333334f);
                instancePath.cubicTo(5.969537f, 27.333334f, 0.0f, 21.363796f, 0.0f, 14.0f);
                instancePath.cubicTo(0.0f, 6.6362033f, 5.969537f, 0.6666667f, 13.333333f, 0.6666667f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 6.666667f, 0.0f, 1.0f, 9.733333f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(11.333333f, 0.0f);
                instancePath2.cubicTo(12.437902f, 0.0f, 13.333333f, 0.8954305f, 13.333333f, 2.0f);
                instancePath2.cubicTo(13.333333f, 3.1045694f, 12.437902f, 4.0f, 11.333333f, 4.0f);
                instancePath2.cubicTo(10.228764f, 4.0f, 9.333333f, 3.1045694f, 9.333333f, 2.0f);
                instancePath2.cubicTo(9.333333f, 0.8954305f, 10.228764f, 0.0f, 11.333333f, 0.0f);
                instancePath2.lineTo(11.333333f, 0.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(2.0f, 0.0f);
                instancePath3.cubicTo(3.1045694f, 0.0f, 4.0f, 0.8954305f, 4.0f, 2.0f);
                instancePath3.cubicTo(4.0f, 3.1045694f, 3.1045694f, 4.0f, 2.0f, 4.0f);
                instancePath3.cubicTo(0.8954305f, 4.0f, 0.0f, 3.1045694f, 0.0f, 2.0f);
                instancePath3.cubicTo(0.0f, 0.8954305f, 0.8954305f, 0.0f, 2.0f, 0.0f);
                instancePath3.lineTo(2.0f, 0.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(6.6666665f, 10.755723f);
                instancePath4.cubicTo(8.665655f, 10.755723f, 10.32216f, 9.249073f, 10.61923f, 7.3333335f);
                instancePath4.cubicTo(10.3932295f, 7.3333335f, 2.9099934f, 7.3333335f, 2.7080638f, 7.3333335f);
                instancePath4.cubicTo(2.9879942f, 9.268772f, 4.653682f, 10.755723f, 6.6666665f, 10.755723f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(23.333334f, 2.0f);
                instancePath5.cubicTo(23.951733f, 3.396177f, 24.535067f, 4.368399f, 25.083334f, 4.9166665f);
                instancePath5.cubicTo(25.631601f, 5.4649343f, 26.603823f, 6.0482674f, 28.0f, 6.6666665f);
                instancePath5.cubicTo(26.569643f, 7.3192453f, 25.597422f, 7.902579f, 25.083334f, 8.416667f);
                instancePath5.cubicTo(24.569246f, 8.930755f, 23.985912f, 9.902977f, 23.333334f, 11.333333f);
                instancePath5.cubicTo(22.672304f, 9.8945265f, 22.088972f, 8.922304f, 21.583334f, 8.416667f);
                instancePath5.cubicTo(21.077696f, 7.911029f, 20.105473f, 7.3276954f, 18.666666f, 6.6666665f);
                instancePath5.cubicTo(20.09677f, 6.014341f, 21.068993f, 5.431008f, 21.583334f, 4.9166665f);
                instancePath5.cubicTo(22.097673f, 4.4023256f, 22.681007f, 3.4301035f, 23.333334f, 2.0f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 2);
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
