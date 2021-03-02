package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class newfriend_contacts_icon extends c {
    private final int height = 144;
    private final int width = 144;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                instancePaint3.setColor(-11286451);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 44.0f, 0.0f, 1.0f, 22.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(11.594659f, 0.83899826f);
                instancePath.cubicTo(22.046501f, -0.22110067f, 32.598267f, -0.24110253f, 43.07009f, 0.578974f);
                instancePath.cubicTo(46.867126f, 0.95900947f, 50.724117f, 1.3390449f, 54.311317f, 2.6891708f);
                instancePath.cubicTo(56.08993f, 3.2692251f, 55.980015f, 5.4394274f, 56.0f, 6.9395676f);
                instancePath.cubicTo(55.94005f, 36.00228f, 56.019985f, 65.05499f, 55.96003f, 94.107704f);
                instancePath.cubicTo(56.23981f, 97.137985f, 52.752533f, 97.84805f, 50.504288f, 98.3581f);
                instancePath.cubicTo(39.79265f, 100.29828f, 28.821213f, 100.17827f, 17.979675f, 99.70822f);
                instancePath.cubicTo(12.933614f, 99.27818f, 7.6977005f, 99.14817f, 2.9414127f, 97.24799f);
                instancePath.cubicTo(1.1827854f, 96.67794f, 0.9329804f, 94.67776f, 1.012918f, 93.09761f);
                instancePath.cubicTo(1.0229102f, 64.40493f, 1.0428946f, 35.70225f, 1.0029258f, 7.009574f);
                instancePath.cubicTo(1.1028478f, 5.649447f, 0.813074f, 3.9392877f, 2.0720913f, 2.9991999f);
                instancePath.cubicTo(5.049767f, 1.5990692f, 8.377171f, 1.2690384f, 11.594659f, 0.83899826f);
                instancePath.lineTo(11.594659f, 0.83899826f);
                instancePath.close();
                instancePath.moveTo(4.0f, 10.0f);
                instancePath.lineTo(4.0f, 87.0f);
                instancePath.lineTo(53.0f, 87.0f);
                instancePath.lineTo(53.0f, 10.0f);
                instancePath.lineTo(4.0f, 10.0f);
                instancePath.lineTo(4.0f, 10.0f);
                instancePath.close();
                instancePath.moveTo(27.34189f, 91.35242f);
                instancePath.cubicTo(24.280243f, 92.668205f, 27.048307f, 97.45562f, 29.763947f, 95.56292f);
                instancePath.cubicTo(32.605408f, 94.19653f, 30.015589f, 89.72288f, 27.34189f, 91.35242f);
                instancePath.lineTo(27.34189f, 91.35242f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
