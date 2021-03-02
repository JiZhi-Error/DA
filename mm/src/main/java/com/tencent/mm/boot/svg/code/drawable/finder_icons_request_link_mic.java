package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_icons_request_link_mic extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                instancePaint4.setStrokeWidth(1.2f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 4.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(4.0510254f, 0.0f);
                instancePath.cubicTo(4.6679325f, 0.020565553f, 5.182022f, 0.37017995f, 5.4082212f, 0.90488434f);
                instancePath.lineTo(5.4082212f, 0.90488434f);
                instancePath.lineTo(7.1561255f, 5.552699f);
                instancePath.cubicTo(7.23838f, 5.77892f, 7.1972528f, 5.9023137f, 7.0738716f, 6.128535f);
                instancePath.cubicTo(6.6625996f, 6.848329f, 5.675548f, 8.658097f, 5.1203313f, 9.748072f);
                instancePath.cubicTo(4.976386f, 10.015424f, 4.894132f, 10.323908f, 4.894132f, 10.632391f);
                instancePath.cubicTo(4.894132f, 10.961439f, 4.9969497f, 11.290488f, 5.1614585f, 11.55784f);
                instancePath.cubicTo(6.0456924f, 13.059126f, 7.0738716f, 14.478149f, 8.287123f, 15.691517f);
                instancePath.cubicTo(9.500374f, 16.92545f, 10.919261f, 17.953728f, 12.420403f, 18.838047f);
                instancePath.cubicTo(12.687729f, 19.002571f, 12.996182f, 19.105398f, 13.345763f, 19.105398f);
                instancePath.cubicTo(13.674781f, 19.105398f, 13.96267f, 19.023136f, 14.229997f, 18.879177f);
                instancePath.cubicTo(15.299303f, 18.323908f, 17.108898f, 17.336761f, 17.849188f, 16.92545f);
                instancePath.cubicTo(18.075386f, 16.802057f, 18.178204f, 16.760925f, 18.424967f, 16.843187f);
                instancePath.lineTo(18.424967f, 16.843187f);
                instancePath.lineTo(23.072336f, 18.591259f);
                instancePath.cubicTo(23.606989f, 18.81748f, 23.95657f, 19.33162f, 23.997698f, 19.948586f);
                instancePath.cubicTo(24.018261f, 20.195374f, 23.89488f, 20.48329f, 23.874315f, 20.544987f);
                instancePath.cubicTo(23.134027f, 22.560411f, 21.221615f, 24.0f, 18.95962f, 24.0f);
                instancePath.cubicTo(18.32215f, 24.0f, 17.725805f, 23.856041f, 17.581861f, 23.81491f);
                instancePath.cubicTo(13.263509f, 22.827763f, 9.418119f, 20.627249f, 6.395273f, 17.604113f);
                instancePath.cubicTo(3.372427f, 14.5809765f, 1.172124f, 10.735218f, 0.18507221f, 6.4164524f);
                instancePath.cubicTo(0.16450864f, 6.2724934f, 0.0f, 5.6760926f, 0.0f, 5.0385604f);
                instancePath.cubicTo(0.0f, 2.7763495f, 1.4394506f, 0.8637532f, 3.4546814f, 0.12339332f);
                instancePath.cubicTo(3.5163722f, 0.102827765f, 3.8042622f, 0.0f, 4.0510254f, 0.0f);
                instancePath.close();
                instancePath.moveTo(20.88889f, 2.0f);
                instancePath.cubicTo(21.239546f, 2.0f, 21.52381f, 2.275517f, 21.52381f, 2.6153846f);
                instancePath.lineTo(21.52381f, 9.384615f);
                instancePath.cubicTo(21.52381f, 9.724483f, 21.239546f, 10.0f, 20.88889f, 10.0f);
                instancePath.lineTo(12.634921f, 10.0f);
                instancePath.cubicTo(12.284264f, 10.0f, 12.0f, 9.724483f, 12.0f, 9.384615f);
                instancePath.lineTo(12.0f, 2.6153846f);
                instancePath.cubicTo(12.0f, 2.275517f, 12.284264f, 2.0f, 12.634921f, 2.0f);
                instancePath.lineTo(20.88889f, 2.0f);
                instancePath.close();
                instancePath.moveTo(25.194202f, 3.203649f);
                instancePath.cubicTo(25.284266f, 3.312765f, 25.333334f, 3.4483404f, 25.333334f, 3.5880768f);
                instancePath.lineTo(25.333334f, 8.411923f);
                instancePath.cubicTo(25.333334f, 8.751791f, 25.04907f, 9.0273075f, 24.698412f, 9.0273075f);
                instancePath.cubicTo(24.554241f, 9.0273075f, 24.41436f, 8.979751f, 24.30178f, 8.892458f);
                instancePath.lineTo(22.15873f, 7.230769f);
                instancePath.lineTo(22.15873f, 4.769231f);
                instancePath.lineTo(24.30178f, 3.1075423f);
                instancePath.cubicTo(24.575598f, 2.8952286f, 24.97515f, 2.9382572f, 25.194202f, 3.203649f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
