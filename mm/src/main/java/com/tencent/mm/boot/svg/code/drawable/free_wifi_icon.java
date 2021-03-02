package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class free_wifi_icon extends c {
    private final int height = 70;
    private final int width = 80;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 80;
            case 1:
                return 70;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.instanceMatrix(looper);
                c.instanceMatrixArray(looper);
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-983041);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(39.999f, 66.129f);
                instancePath.cubicTo(35.436f, 66.129f, 31.029f, 65.48f, 26.945f, 64.315f);
                instancePath.cubicTo(26.573f, 64.203f, 26.178f, 64.142f, 25.769f, 64.142f);
                instancePath.cubicTo(25.001f, 64.142f, 24.304f, 64.373f, 23.645f, 64.751f);
                instancePath.lineTo(14.89f, 69.766f);
                instancePath.cubicTo(14.646f, 69.905f, 14.409f, 70.012f, 14.12f, 70.012f);
                instancePath.cubicTo(13.384f, 70.012f, 12.787f, 69.42f, 12.787f, 68.69f);
                instancePath.cubicTo(12.787f, 68.362f, 12.918f, 68.036f, 13.002f, 67.722f);
                instancePath.cubicTo(13.052f, 67.536f, 14.13f, 63.545f, 14.804f, 61.054f);
                instancePath.cubicTo(14.88f, 60.774f, 14.944f, 60.503f, 14.944f, 60.211f);
                instancePath.cubicTo(14.944f, 59.322f, 14.502f, 58.536f, 13.824f, 58.056f);
                instancePath.cubicTo(5.393f, 51.995f, 0.006f, 43.027f, 0.006f, 33.065f);
                instancePath.cubicTo(0.006f, 30.372f, 0.398f, 27.756f, 1.133f, 25.25f);
                instancePath.cubicTo(7.438f, 18.998f, 16.145f, 15.132f, 25.763f, 15.132f);
                instancePath.cubicTo(37.198f, 15.132f, 47.347f, 20.597f, 53.699f, 29.038f);
                instancePath.lineTo(60.783f, 22.011f);
                instancePath.cubicTo(52.578f, 11.811f, 39.94f, 5.274f, 25.763f, 5.274f);
                instancePath.cubicTo(22.662f, 5.274f, 19.635f, 5.586f, 16.712f, 6.182f);
                instancePath.cubicTo(23.271f, 2.291f, 31.311f, -0.0f, 39.999f, -0.0f);
                instancePath.cubicTo(62.086f, -0.0f, 79.992f, 14.804f, 79.992f, 33.065f);
                instancePath.cubicTo(79.992f, 51.325f, 62.086f, 66.129f, 39.999f, 66.129f);
                instancePath.close();
                instancePath.moveTo(25.763f, 54.693f);
                instancePath.cubicTo(28.542f, 54.693f, 30.795f, 52.458f, 30.795f, 49.7f);
                instancePath.cubicTo(30.795f, 46.943f, 28.542f, 44.708f, 25.763f, 44.708f);
                instancePath.cubicTo(22.984f, 44.708f, 20.73f, 46.943f, 20.73f, 49.7f);
                instancePath.cubicTo(20.73f, 52.458f, 22.984f, 54.693f, 25.763f, 54.693f);
                instancePath.close();
                instancePath.moveTo(25.763f, 24.991f);
                instancePath.cubicTo(17.069f, 24.991f, 9.416f, 29.41f, 4.961f, 36.108f);
                instancePath.lineTo(12.238f, 43.327f);
                instancePath.cubicTo(14.642f, 38.314f, 19.795f, 34.849f, 25.763f, 34.849f);
                instancePath.cubicTo(31.733f, 34.849f, 36.888f, 38.317f, 39.29f, 43.334f);
                instancePath.lineTo(46.569f, 36.113f);
                instancePath.cubicTo(42.114f, 29.412f, 34.459f, 24.991f, 25.763f, 24.991f);
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
