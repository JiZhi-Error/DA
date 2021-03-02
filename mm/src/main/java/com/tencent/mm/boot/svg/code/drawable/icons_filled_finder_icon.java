package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_finder_icon extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -784.0f, 0.0f, 1.0f, -1557.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 784.0f, 0.0f, 1.0f, 1557.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(24.0f, 0.0f);
                instancePath.lineTo(24.0f, 24.0f);
                instancePath.lineTo(0.0f, 24.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.drawPath(instancePath, c.instancePaint(instancePaint3, looper));
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(8.787208f, 10.822733f);
                instancePath2.cubicTo(8.502257f, 11.365307f, 8.007208f, 12.257782f, 7.409386f, 13.127485f);
                instancePath2.cubicTo(6.4553266f, 14.51501f, 5.795129f, 15.046297f, 5.415525f, 15.248871f);
                instancePath2.cubicTo(5.2430496f, 15.340753f, 5.0313663f, 15.284713f, 4.9234457f, 15.121742f);
                instancePath2.cubicTo(4.4931483f, 14.47303f, 3.6685941f, 12.764515f, 2.9070098f, 9.737386f);
                instancePath2.cubicTo(2.0947328f, 6.508871f, 1.8232476f, 3.5391684f, 2.2468119f, 2.515406f);
                instancePath2.cubicTo(2.3135445f, 2.3540199f, 2.5062177f, 2.2878811f, 2.656515f, 2.376396f);
                instancePath2.cubicTo(3.2303762f, 2.7140198f, 4.656119f, 3.9439209f, 7.3521585f, 8.419564f);
                instancePath2.cubicTo(7.9590893f, 9.427287f, 8.481861f, 10.307089f, 8.787208f, 10.822733f);
                instancePath2.moveTo(17.019089f, 9.737386f);
                instancePath2.cubicTo(16.272753f, 12.704911f, 15.4654255f, 14.405108f, 15.031366f, 15.080555f);
                instancePath2.cubicTo(14.900079f, 15.284713f, 14.62899f, 15.341148f, 14.422852f, 15.21303f);
                instancePath2.cubicTo(13.615921f, 14.711446f, 12.289188f, 13.07501f, 11.135921f, 10.827683f);
                instancePath2.cubicTo(11.440673f, 10.312832f, 11.96503f, 9.430654f, 12.57394f, 8.419564f);
                instancePath2.cubicTo(15.278495f, 3.9298613f, 16.705425f, 2.706495f, 17.27414f, 2.3732278f);
                instancePath2.cubicTo(17.428f, 2.2833266f, 17.609386f, 2.3464952f, 17.6779f, 2.5108514f);
                instancePath2.lineTo(17.679684f, 2.515604f);
                instancePath2.cubicTo(18.102852f, 3.5391684f, 17.831366f, 6.508871f, 17.019089f, 9.737386f);
                instancePath2.moveTo(19.576515f, 1.7310495f);
                instancePath2.cubicTo(19.060278f, 0.48233664f, 18.19711f, 0.23679207f, 17.727802f, 0.20154455f);
                instancePath2.cubicTo(15.977307f, 0.07144555f, 13.915327f, 2.214218f, 10.815327f, 7.3605547f);
                instancePath2.cubicTo(10.503446f, 7.878178f, 10.213742f, 8.3625345f, 9.96305f, 8.782733f);
                instancePath2.cubicTo(9.713742f, 8.364713f, 9.424436f, 7.8811483f, 9.110772f, 7.3605547f);
                instancePath2.cubicTo(6.010178f, 2.2128317f, 3.9392872f, 0.072237626f, 2.198099f, 0.20154455f);
                instancePath2.cubicTo(1.7291881f, 0.23679207f, 0.8660198f, 0.48233664f, 0.34958416f, 1.7310495f);
                instancePath2.cubicTo(-0.36269307f, 3.4530296f, 0.17255445f, 6.8219404f, 0.5551287f, 8.676792f);
                instancePath2.cubicTo(1.1327525f, 11.477782f, 2.0628514f, 14.267287f, 2.9248316f, 15.783921f);
                instancePath2.cubicTo(3.498099f, 16.792435f, 4.0711684f, 17.30689f, 4.728198f, 17.402733f);
                instancePath2.cubicTo(4.8335447f, 17.418179f, 4.9408712f, 17.425901f, 5.047208f, 17.425901f);
                instancePath2.cubicTo(6.988f, 17.425901f, 8.836119f, 14.891445f, 9.962852f, 12.960158f);
                instancePath2.cubicTo(11.089584f, 14.891445f, 12.937505f, 17.425901f, 14.878891f, 17.425901f);
                instancePath2.cubicTo(14.985228f, 17.425901f, 15.092752f, 17.418179f, 15.198297f, 17.402733f);
                instancePath2.cubicTo(15.854931f, 17.30689f, 16.428f, 16.792435f, 17.001266f, 15.783921f);
                instancePath2.cubicTo(17.863247f, 14.267485f, 18.793346f, 11.477782f, 19.37097f, 8.676792f);
                instancePath2.cubicTo(19.753544f, 6.8219404f, 20.288792f, 3.4532278f, 19.576515f, 1.7310495f);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
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
