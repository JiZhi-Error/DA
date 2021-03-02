package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_destop_view_third_party_running_flag extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(436207615);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(10.0f, 0.0f);
                instancePath.cubicTo(15.522848f, 0.0f, 20.0f, 4.4771523f, 20.0f, 10.0f);
                instancePath.cubicTo(20.0f, 15.522848f, 15.522848f, 20.0f, 10.0f, 20.0f);
                instancePath.cubicTo(4.4771523f, 20.0f, 0.0f, 15.522848f, 0.0f, 10.0f);
                instancePath.cubicTo(0.0f, 4.4771523f, 4.4771523f, 0.0f, 10.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(6.8161955f, 0.05092412f);
                instancePath2.lineTo(3.1868265f, 0.05092412f);
                instancePath2.cubicTo(2.4464633f, 0.055895973f, 2.0786471f, 0.092503406f, 1.6605703f, 0.22468384f);
                instancePath2.cubicTo(0.98632014f, 0.4696597f, 0.4696597f, 0.98632014f, 0.23089007f, 1.6423111f);
                instancePath2.cubicTo(0.09250536f, 2.0786412f, 0.055896156f, 2.4464912f, 0.05092412f, 3.1838257f);
                instancePath2.lineTo(0.05092412f, 6.8131676f);
                instancePath2.cubicTo(0.05589582f, 7.5534883f, 0.09250185f, 7.9212832f, 0.22467782f, 8.339411f);
                instancePath2.cubicTo(0.46967f, 9.013708f, 0.9863586f, 9.530372f, 1.6423639f, 9.769054f);
                instancePath2.lineTo(1.7805345f, 9.81067f);
                instancePath2.lineTo(1.9534277f, 9.854168f);
                instancePath2.cubicTo(2.3213022f, 9.937167f, 2.6770875f, 9.95f, 3.637775f, 9.95f);
                instancePath2.lineTo(6.938094f, 9.9472475f);
                instancePath2.cubicTo(7.4874487f, 9.94035f, 7.7632103f, 9.918043f, 8.046123f, 9.854258f);
                instancePath2.lineTo(8.218974f, 9.810801f);
                instancePath2.cubicTo(8.279243f, 9.793855f, 8.279243f, 9.793855f, 8.339471f, 9.7752285f);
                instancePath2.cubicTo(9.013641f, 9.530372f, 9.53033f, 9.013708f, 9.76911f, 8.357689f);
                instancePath2.lineTo(9.810876f, 8.21892f);
                instancePath2.lineTo(9.854309f, 8.046077f);
                instancePath2.cubicTo(9.937185f, 7.678309f, 9.95f, 7.3226175f, 9.95f, 6.362225f);
                instancePath2.lineTo(9.947246f, 3.061707f);
                instancePath2.cubicTo(9.9396515f, 2.4572089f, 9.913398f, 2.1838722f, 9.833758f, 1.8678991f);
                instancePath2.lineTo(9.775316f, 1.6605703f);
                instancePath2.cubicTo(9.550755f, 1.0425076f, 9.097903f, 0.55686414f, 8.518707f, 0.29630223f);
                instancePath2.lineTo(8.339411f, 0.22467782f);
                instancePath2.cubicTo(7.9212832f, 0.09250185f, 7.5534883f, 0.05589582f, 6.8161955f, 0.05092412f);
                instancePath2.close();
                instancePath2.moveTo(3.1898544f, 0.9509139f);
                instancePath2.lineTo(6.8131676f, 0.9509139f);
                instancePath2.lineTo(7.0174212f, 0.95336545f);
                instancePath2.cubicTo(7.4654655f, 0.96148545f, 7.7221165f, 0.98756665f, 7.9645786f, 1.0525361f);
                instancePath2.lineTo(8.049861f, 1.07661f);
                instancePath2.cubicTo(8.45587f, 1.2243903f, 8.77561f, 1.5441298f, 8.92339f, 1.9501388f);
                instancePath2.lineTo(8.94274f, 2.0184321f);
                instancePath2.cubicTo(9.022876f, 2.3106167f, 9.044674f, 2.5467925f, 9.049063f, 3.2683253f);
                instancePath2.lineTo(9.049063f, 6.7315574f);
                instancePath2.cubicTo(9.045355f, 7.3418927f, 9.029196f, 7.6048403f, 8.975822f, 7.8482695f);
                instancePath2.lineTo(8.917178f, 8.068139f);
                instancePath2.cubicTo(8.775608f, 8.4558735f, 8.455877f, 8.77559f, 8.049914f, 8.923296f);
                instancePath2.lineTo(7.98103f, 8.942824f);
                instancePath2.cubicTo(7.68894f, 9.022897f, 7.45284f, 9.044678f, 6.7315497f, 9.049063f);
                instancePath2.lineTo(3.2683575f, 9.049063f);
                instancePath2.cubicTo(2.6578858f, 9.045349f, 2.394903f, 9.02917f, 2.1514568f, 8.97573f);
                instancePath2.lineTo(1.93194f, 8.917128f);
                instancePath2.cubicTo(1.544123f, 8.77559f, 1.2243915f, 8.4558735f, 1.07661f, 8.049861f);
                instancePath2.cubicTo(0.9844553f, 7.756964f, 0.95531523f, 7.464182f, 0.9509139f, 6.810139f);
                instancePath2.lineTo(0.9509139f, 3.186854f);
                instancePath2.lineTo(0.9580066f, 2.8017626f);
                instancePath2.cubicTo(0.9716862f, 2.4047616f, 1.0063163f, 2.1738431f, 1.0828161f, 1.9318798f);
                instancePath2.cubicTo(1.2243903f, 1.5441298f, 1.5441298f, 1.2243903f, 1.9501388f, 1.07661f);
                instancePath2.cubicTo(2.2429836f, 0.9844567f, 2.5357845f, 0.9553153f, 3.1898544f, 0.9509139f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
