package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wechat_wallet_authenticate extends c {
    private final int height = 40;
    private final int width = 40;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -107.0f, 0.0f, 1.0f, -102.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 107.0f, 0.0f, 1.0f, 102.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 3.333333f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.122681f, 18.976938f);
                instancePath.cubicTo(11.972169f, 19.053703f, 11.802728f, 19.098915f, 11.623129f, 19.098915f);
                instancePath.cubicTo(11.20622f, 19.098915f, 10.843791f, 18.864853f, 10.653573f, 18.519175f);
                instancePath.lineTo(10.581087f, 18.357168f);
                instancePath.lineTo(7.546377f, 11.5651245f);
                instancePath.cubicTo(7.513597f, 11.491185f, 7.4932823f, 11.407356f, 7.4932823f, 11.325882f);
                instancePath.cubicTo(7.4932823f, 11.013171f, 7.742135f, 10.7598f, 8.048699f, 10.7598f);
                instancePath.cubicTo(8.17428f, 10.7598f, 8.288319f, 10.801714f, 8.38158f, 10.872356f);
                instancePath.lineTo(11.962012f, 13.472473f);
                instancePath.cubicTo(12.222869f, 13.646725f, 12.536358f, 13.749392f, 12.872471f, 13.749392f);
                instancePath.cubicTo(13.072384f, 13.749392f, 13.263987f, 13.711716f, 13.441739f, 13.645311f);
                instancePath.lineTo(30.280155f, 6.0013185f);
                instancePath.cubicTo(27.262066f, 2.3721762f, 22.291014f, 0.0f, 16.666204f, 0.0f);
                instancePath.cubicTo(7.4609637f, 0.0f, 0.0f, 6.3432283f, 0.0f, 14.168066f);
                instancePath.cubicTo(0.0f, 18.43676f, 2.244291f, 22.280184f, 5.758239f, 24.877474f);
                instancePath.cubicTo(6.0403337f, 25.082338f, 6.2245493f, 25.419067f, 6.2245493f, 25.800537f);
                instancePath.cubicTo(6.2245493f, 25.926752f, 6.199156f, 26.040722f, 6.165914f, 26.161285f);
                instancePath.cubicTo(5.8856664f, 27.2294f, 5.4364386f, 28.93895f, 5.4156623f, 29.019482f);
                instancePath.cubicTo(5.3805737f, 29.152761f, 5.325632f, 29.293104f, 5.325632f, 29.433918f);
                instancePath.cubicTo(5.325632f, 29.746159f, 5.5740232f, 30.0f, 5.881973f, 30.0f);
                instancePath.cubicTo(6.002013f, 30.0f, 6.1003537f, 29.954317f, 6.202388f, 29.894978f);
                instancePath.lineTo(9.8511505f, 27.745562f);
                instancePath.cubicTo(10.125396f, 27.584026f, 10.415801f, 27.484184f, 10.736217f, 27.484184f);
                instancePath.cubicTo(10.906581f, 27.484184f, 11.071405f, 27.511028f, 11.226072f, 27.559536f);
                instancePath.cubicTo(12.928336f, 28.058743f, 14.764952f, 28.336132f, 16.666204f, 28.336132f);
                instancePath.cubicTo(25.870985f, 28.336132f, 33.333332f, 21.992905f, 33.333332f, 14.168066f);
                instancePath.cubicTo(33.333332f, 11.798716f, 32.644947f, 9.566412f, 31.43439f, 7.6034913f);
                instancePath.lineTo(12.244568f, 18.904884f);
                instancePath.lineTo(12.122681f, 18.976938f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-2565928);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.0f, 0.0f);
                instancePath2.lineTo(40.0f, 0.0f);
                instancePath2.lineTo(40.0f, 40.0f);
                instancePath2.lineTo(0.0f, 40.0f);
                instancePath2.lineTo(0.0f, 0.0f);
                instancePath2.close();
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.drawPath(instancePath2, c.instancePaint(instancePaint5, looper));
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
