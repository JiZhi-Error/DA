package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class payinfoicon extends c {
    private final int height = 42;
    private final int width = 42;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                instancePaint3.setColor(-6710887);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(19.74f, 0.0f);
                instancePath.lineTo(22.04f, 0.0f);
                instancePath.cubicTo(32.38f, 0.39f, 41.32f, 9.17f, 42.0f, 19.47f);
                instancePath.lineTo(42.0f, 22.2f);
                instancePath.cubicTo(41.54f, 32.57f, 32.61f, 41.47f, 22.26f, 42.0f);
                instancePath.lineTo(19.95f, 42.0f);
                instancePath.cubicTo(9.62f, 41.6f, 0.68f, 32.83f, 0.0f, 22.53f);
                instancePath.lineTo(0.0f, 19.8f);
                instancePath.cubicTo(0.47f, 9.43f, 9.4f, 0.53f, 19.74f, 0.0f);
                instancePath.lineTo(19.74f, 0.0f);
                instancePath.close();
                instancePath.moveTo(20.87298f, 6.5409007f);
                instancePath.cubicTo(18.624437f, 7.68438f, 18.225163f, 11.434167f, 20.64182f, 12.587948f);
                instancePath.cubicTo(23.153044f, 14.081682f, 26.683468f, 11.238437f, 25.884918f, 8.477604f);
                instancePath.cubicTo(25.58021f, 6.2627573f, 22.638191f, 5.3150086f, 20.87298f, 6.5409007f);
                instancePath.lineTo(20.87298f, 6.5409007f);
                instancePath.close();
                instancePath.moveTo(19.27931f, 14.632621f);
                instancePath.cubicTo(15.97931f, 16.242502f, 13.227586f, 19.38227f, 13.0f, 23.052f);
                instancePath.cubicTo(14.52069f, 20.922155f, 16.051723f, 18.732317f, 18.327587f, 17.262426f);
                instancePath.cubicTo(17.903448f, 22.822016f, 15.637931f, 28.161621f, 15.875862f, 33.761208f);
                instancePath.cubicTo(15.875862f, 35.551075f, 17.955172f, 36.421013f, 19.51724f, 35.80106f);
                instancePath.cubicTo(23.8f, 34.391163f, 27.048275f, 30.541447f, 28.0f, 26.30176f);
                instancePath.cubicTo(26.272413f, 28.121624f, 24.451725f, 29.891495f, 23.044828f, 31.97134f);
                instancePath.cubicTo(22.082758f, 26.471746f, 25.268965f, 21.192137f, 24.524137f, 15.702541f);
                instancePath.cubicTo(23.8f, 13.502704f, 20.975863f, 13.772684f, 19.27931f, 14.632621f);
                instancePath.lineTo(19.27931f, 14.632621f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(8.87298f, 1.5409008f);
                instancePath2.cubicTo(10.638191f, 0.3150088f, 13.58021f, 1.2627572f, 13.884919f, 3.4776042f);
                instancePath2.cubicTo(14.683467f, 6.2384367f, 11.153045f, 9.081682f, 8.641821f, 7.587948f);
                instancePath2.cubicTo(6.225163f, 6.4341674f, 6.624437f, 2.6843798f, 8.87298f, 1.5409008f);
                instancePath2.lineTo(8.87298f, 1.5409008f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(7.27931f, 9.632621f);
                instancePath3.cubicTo(8.9758625f, 8.772684f, 11.8f, 8.502704f, 12.5241375f, 10.702541f);
                instancePath3.cubicTo(13.268966f, 16.192137f, 10.082759f, 21.471746f, 11.044827f, 26.97134f);
                instancePath3.cubicTo(12.451724f, 24.891495f, 14.272414f, 23.121624f, 16.0f, 21.30176f);
                instancePath3.cubicTo(15.048276f, 25.541447f, 11.8f, 29.391163f, 7.5172415f, 30.801058f);
                instancePath3.cubicTo(5.9551725f, 31.421013f, 3.8758621f, 30.551077f, 3.8758621f, 28.76121f);
                instancePath3.cubicTo(3.637931f, 23.161621f, 5.903448f, 17.822016f, 6.327586f, 12.262426f);
                instancePath3.cubicTo(4.051724f, 13.732318f, 2.5206897f, 15.922156f, 1.0f, 18.052f);
                instancePath3.cubicTo(1.2275863f, 14.38227f, 3.9793103f, 11.242501f, 7.27931f, 9.632621f);
                instancePath3.lineTo(7.27931f, 9.632621f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
