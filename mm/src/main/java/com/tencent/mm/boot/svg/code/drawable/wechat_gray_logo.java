package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wechat_gray_logo extends c {
    private final int height = 98;
    private final int width = 123;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 123;
            case 1:
                return 98;
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
                canvas.saveLayerAlpha(null, 64, 31);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-5592406);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -479.0f, 0.0f, 1.0f, -378.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 479.0f, 0.0f, 1.0f, 378.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(97.83983f, 58.755054f);
                instancePath.cubicTo(95.062546f, 58.755054f, 92.84071f, 56.56591f, 92.84071f, 53.82948f);
                instancePath.cubicTo(92.84071f, 51.09305f, 95.062546f, 48.903908f, 97.83983f, 48.903908f);
                instancePath.cubicTo(100.61712f, 48.903908f, 102.83894f, 51.09305f, 102.83894f, 53.82948f);
                instancePath.cubicTo(102.83894f, 56.42909f, 100.61712f, 58.755054f, 97.83983f, 58.755054f);
                instancePath.moveTo(73.20133f, 58.755054f);
                instancePath.cubicTo(70.42405f, 58.755054f, 68.20222f, 56.56591f, 68.20222f, 53.82948f);
                instancePath.cubicTo(68.20222f, 51.09305f, 70.42405f, 48.903908f, 73.20133f, 48.903908f);
                instancePath.cubicTo(75.97862f, 48.903908f, 78.20045f, 51.09305f, 78.20045f, 53.82948f);
                instancePath.cubicTo(78.20045f, 56.42909f, 75.97862f, 58.755054f, 73.20133f, 58.755054f);
                instancePath.moveTo(109.76284f, 86.40196f);
                instancePath.cubicTo(117.556206f, 80.87495f, 122.478325f, 72.65183f, 122.478325f, 63.61989f);
                instancePath.cubicTo(122.478325f, 46.90405f, 106.07124f, 33.423534f, 85.69912f, 33.423534f);
                instancePath.cubicTo(65.326996f, 33.423534f, 48.919914f, 46.90405f, 48.919914f, 63.61989f);
                instancePath.cubicTo(48.919914f, 80.33573f, 65.326996f, 93.816246f, 85.69912f, 93.816246f);
                instancePath.cubicTo(89.937614f, 93.816246f, 93.902664f, 93.27702f, 97.73098f, 92.198586f);
                instancePath.cubicTo(98.00443f, 92.06378f, 98.41461f, 92.06378f, 98.82478f, 92.06378f);
                instancePath.cubicTo(99.508415f, 92.06378f, 100.19204f, 92.33339f, 100.738945f, 92.603f);
                instancePath.lineTo(108.80576f, 97.18638f);
                instancePath.cubicTo(109.07921f, 97.32118f, 109.215935f, 97.455986f, 109.48939f, 97.455986f);
                instancePath.cubicTo(110.17302f, 97.455986f, 110.71992f, 96.91676f, 110.71992f, 96.24274f);
                instancePath.cubicTo(110.71992f, 95.97313f, 110.58319f, 95.70352f, 110.58319f, 95.2991f);
                instancePath.cubicTo(110.58319f, 95.1643f, 109.48939f, 91.52456f, 108.94249f, 89.23287f);
                instancePath.cubicTo(108.80576f, 88.96326f, 108.80576f, 88.69365f, 108.80576f, 88.42404f);
                instancePath.cubicTo(108.66904f, 87.4804f, 109.07921f, 86.80638f, 109.76284f, 86.40196f);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(58.561066f, 30.257093f);
                instancePath2.cubicTo(55.37226f, 30.257093f, 52.847794f, 27.76976f, 52.847794f, 24.627867f);
                instancePath2.cubicTo(52.847794f, 21.485971f, 55.37226f, 18.99864f, 58.561066f, 18.99864f);
                instancePath2.cubicTo(61.74987f, 18.99864f, 64.27434f, 21.485971f, 64.27434f, 24.627867f);
                instancePath2.cubicTo(64.27434f, 27.638847f, 61.74987f, 30.257093f, 58.561066f, 30.257093f);
                instancePath2.moveTo(29.280533f, 30.257093f);
                instancePath2.cubicTo(26.091728f, 30.257093f, 23.567259f, 27.76976f, 23.567259f, 24.627867f);
                instancePath2.cubicTo(23.567259f, 21.485971f, 26.091728f, 18.99864f, 29.280533f, 18.99864f);
                instancePath2.cubicTo(32.469337f, 18.99864f, 34.99381f, 21.485971f, 34.99381f, 24.627867f);
                instancePath2.cubicTo(34.99381f, 27.638847f, 32.469337f, 30.257093f, 29.280533f, 30.257093f);
                instancePath2.moveTo(44.263397f, 0.0f);
                instancePath2.cubicTo(19.870565f, 0.0f, 0.0f, 16.146992f, 0.0f, 36.196175f);
                instancePath2.cubicTo(0.0f, 47.095394f, 5.89265f, 56.918148f, 15.348298f, 63.5115f);
                instancePath2.cubicTo(16.03349f, 64.049736f, 16.581644f, 64.857086f, 16.581644f, 65.93355f);
                instancePath2.cubicTo(16.581644f, 66.20267f, 16.444605f, 66.60634f, 16.444605f, 66.87546f);
                instancePath2.cubicTo(15.759414f, 69.56663f, 14.526068f, 74.00705f, 14.3890295f, 74.1416f);
                instancePath2.cubicTo(14.251991f, 74.54528f, 14.114953f, 74.8144f, 14.114953f, 75.21807f);
                instancePath2.cubicTo(14.114953f, 76.02542f, 14.800145f, 76.69821f, 15.622375f, 76.69821f);
                instancePath2.cubicTo(15.896452f, 76.69821f, 16.170528f, 76.56365f, 16.444605f, 76.42909f);
                instancePath2.lineTo(26.17433f, 70.91221f);
                instancePath2.cubicTo(26.859522f, 70.50853f, 27.681751f, 70.23942f, 28.503983f, 70.23942f);
                instancePath2.cubicTo(28.915098f, 70.23942f, 29.326212f, 70.23942f, 29.737328f, 70.37397f);
                instancePath2.cubicTo(34.259594f, 71.585f, 39.192974f, 72.39235f, 44.126358f, 72.39235f);
                instancePath2.lineTo(46.59305f, 72.39235f);
                instancePath2.cubicTo(45.633778f, 69.56663f, 45.085625f, 66.60634f, 45.085625f, 63.5115f);
                instancePath2.cubicTo(45.085625f, 45.346138f, 63.17469f, 30.544727f, 85.37491f, 30.544727f);
                instancePath2.lineTo(87.8416f, 30.544727f);
                instancePath2.cubicTo(84.68972f, 13.18671f, 66.32658f, 0.0f, 44.263397f, 0.0f);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
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
