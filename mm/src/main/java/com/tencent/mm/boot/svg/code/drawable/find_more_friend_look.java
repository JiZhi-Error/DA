package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class find_more_friend_look extends c {
    private final int height = 108;
    private final int width = 108;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                instancePaint3.setColor(-16384);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 17.0f, 0.0f, 1.0f, 17.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(24.38938f, 14.313926f);
                instancePath.lineTo(24.378096f, 14.307363f);
                instancePath.lineTo(34.425114f, 4.2603464f);
                instancePath.cubicTo(36.105576f, 2.5798845f, 38.822918f, 2.5798845f, 40.50338f, 4.2603464f);
                instancePath.lineTo(50.550396f, 14.307363f);
                instancePath.lineTo(39.609516f, 20.671665f);
                instancePath.cubicTo(38.322353f, 21.458263f, 36.677647f, 21.458263f, 35.318974f, 20.671665f);
                instancePath.lineTo(24.41391f, 14.328196f);
                instancePath.lineTo(24.449606f, 26.964458f);
                instancePath.cubicTo(24.449606f, 28.501902f, 23.627253f, 29.932081f, 22.268581f, 30.718681f);
                instancePath.lineTo(11.291947f, 37.011475f);
                instancePath.lineTo(7.6449876f, 23.245989f);
                instancePath.cubicTo(7.037161f, 20.9577f, 8.395832f, 18.597902f, 10.68412f, 17.990076f);
                instancePath.lineTo(24.38938f, 14.313926f);
                instancePath.close();
                instancePath.moveTo(24.41391f, 59.658997f);
                instancePath.lineTo(35.318974f, 53.31553f);
                instancePath.cubicTo(36.677647f, 52.52893f, 38.322353f, 52.52893f, 39.64527f, 53.31553f);
                instancePath.lineTo(50.586147f, 59.67983f);
                instancePath.lineTo(40.50338f, 69.726845f);
                instancePath.cubicTo(38.822918f, 71.40731f, 36.105576f, 71.40731f, 34.425114f, 69.726845f);
                instancePath.lineTo(24.378096f, 59.67983f);
                instancePath.lineTo(24.38938f, 59.673267f);
                instancePath.lineTo(10.68412f, 55.997116f);
                instancePath.cubicTo(8.395832f, 55.38929f, 7.037161f, 53.02949f, 7.6449876f, 50.741203f);
                instancePath.lineTo(11.327702f, 37.011475f);
                instancePath.lineTo(22.304335f, 43.304268f);
                instancePath.cubicTo(23.627253f, 44.05511f, 24.449606f, 45.48529f, 24.449606f, 47.022736f);
                instancePath.lineTo(24.41391f, 59.658997f);
                instancePath.close();
                instancePath.moveTo(52.695663f, 43.268513f);
                instancePath.lineTo(63.6723f, 36.97572f);
                instancePath.lineTo(67.35501f, 50.70545f);
                instancePath.cubicTo(67.96284f, 52.993736f, 66.604164f, 55.353535f, 64.31588f, 55.96136f);
                instancePath.lineTo(50.586147f, 59.644077f);
                instancePath.lineTo(50.550396f, 46.98698f);
                instancePath.cubicTo(50.51464f, 45.48529f, 51.336994f, 44.05511f, 52.695663f, 43.268513f);
                instancePath.close();
                instancePath.moveTo(50.550396f, 26.964458f);
                instancePath.lineTo(50.586147f, 14.307363f);
                instancePath.lineTo(64.31588f, 17.990076f);
                instancePath.cubicTo(66.604164f, 18.597902f, 67.96284f, 20.9577f, 67.35501f, 23.245989f);
                instancePath.lineTo(63.6723f, 36.97572f);
                instancePath.lineTo(52.695663f, 30.682926f);
                instancePath.cubicTo(51.336994f, 29.932081f, 50.51464f, 28.501902f, 50.550396f, 26.964458f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
