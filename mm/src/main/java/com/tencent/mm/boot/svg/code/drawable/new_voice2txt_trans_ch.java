package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class new_voice2txt_trans_ch extends c {
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
                instancePaint3.setColor(-436207616);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.9945219f, -0.104528464f, 1.2969381f, 0.104528464f, 0.9945219f, -1.205674f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(4.805897f, 6.7609773f);
                instancePath.lineTo(4.805897f, 8.477652f);
                instancePath.lineTo(7.3148823f, 8.477652f);
                instancePath.cubicTo(8.008155f, 10.871091f, 9.2461405f, 12.967414f, 11.02884f, 14.783126f);
                instancePath.cubicTo(9.312166f, 16.235697f, 7.1333113f, 17.29211f, 4.508781f, 17.968876f);
                instancePath.lineTo(5.4331436f, 19.487473f);
                instancePath.cubicTo(8.1237f, 18.728174f, 10.401594f, 17.523201f, 12.2503195f, 15.88906f);
                instancePath.cubicTo(14.000007f, 17.34163f, 16.195368f, 18.56311f, 18.836405f, 19.5535f);
                instancePath.lineTo(19.793781f, 18.084423f);
                instancePath.cubicTo(17.284796f, 17.160059f, 15.171967f, 16.037619f, 13.471799f, 14.684088f);
                instancePath.cubicTo(14.990396f, 13.016933f, 16.14585f, 10.953623f, 16.93816f, 8.477652f);
                instancePath.lineTo(19.430637f, 8.477652f);
                instancePath.lineTo(19.430637f, 6.7609773f);
                instancePath.lineTo(13.191189f, 6.7609773f);
                instancePath.cubicTo(12.695994f, 5.688056f, 12.15128f, 4.7636933f, 11.557048f, 3.9878888f);
                instancePath.lineTo(9.823867f, 4.6151347f);
                instancePath.cubicTo(10.4181f, 5.2919006f, 10.929801f, 6.0016794f, 11.3424635f, 6.7609773f);
                instancePath.lineTo(4.805897f, 6.7609773f);
                instancePath.close();
                instancePath.moveTo(8.96553f, 8.477652f);
                instancePath.lineTo(15.15546f, 8.477652f);
                instancePath.cubicTo(14.511707f, 10.474936f, 13.537825f, 12.191609f, 12.2503195f, 13.611166f);
                instancePath.cubicTo(10.731724f, 12.125583f, 9.642296f, 10.425416f, 8.96553f, 8.477652f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
