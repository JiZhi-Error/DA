package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_wechat_out extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 9.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(41.456177f, 37.89717f);
                instancePath.lineTo(51.912758f, 41.830334f);
                instancePath.cubicTo(53.115726f, 42.339333f, 53.902283f, 43.496143f, 53.99482f, 44.88432f);
                instancePath.cubicTo(54.04109f, 45.43959f, 53.763477f, 46.087402f, 53.717213f, 46.226223f);
                instancePath.cubicTo(52.05156f, 50.760925f, 47.74863f, 54.0f, 42.659145f, 54.0f);
                instancePath.cubicTo(41.224834f, 54.0f, 39.883064f, 53.676094f, 39.559185f, 53.58355f);
                instancePath.cubicTo(29.842896f, 51.36247f, 21.19077f, 46.411312f, 14.389365f, 39.609253f);
                instancePath.cubicTo(7.5879607f, 32.807198f, 2.637279f, 24.154242f, 0.41641247f, 14.437018f);
                instancePath.cubicTo(0.37014443f, 14.113111f, 0.0f, 12.771208f, 0.0f, 11.3367605f);
                instancePath.cubicTo(0.0f, 6.2467866f, 3.2387638f, 1.9434447f, 7.773033f, 0.27763495f);
                instancePath.cubicTo(7.911837f, 0.23136246f, 8.55959f, 0.0f, 9.114807f, 0.0f);
                instancePath.cubicTo(10.502849f, 0.046272494f, 11.65955f, 0.8329049f, 12.168498f, 2.0359898f);
                instancePath.lineTo(16.101282f, 12.493573f);
                instancePath.cubicTo(16.286354f, 13.002571f, 16.193819f, 13.280206f, 15.91621f, 13.789203f);
                instancePath.cubicTo(14.9908495f, 15.40874f, 12.769983f, 19.48072f, 11.520745f, 21.933163f);
                instancePath.cubicTo(11.196869f, 22.534704f, 11.011797f, 23.228792f, 11.011797f, 23.922878f);
                instancePath.cubicTo(11.011797f, 24.663239f, 11.243137f, 25.403599f, 11.613281f, 26.005142f);
                instancePath.cubicTo(13.602808f, 29.383034f, 15.91621f, 32.575836f, 18.646027f, 35.305912f);
                instancePath.cubicTo(21.375841f, 38.082264f, 24.568336f, 40.395885f, 27.945904f, 42.385605f);
                instancePath.cubicTo(28.54739f, 42.755783f, 29.24141f, 42.98715f, 30.027967f, 42.98715f);
                instancePath.cubicTo(30.768255f, 42.98715f, 31.416008f, 42.802055f, 32.017494f, 42.47815f);
                instancePath.cubicTo(34.42343f, 41.22879f, 38.49502f, 39.007713f, 40.16067f, 38.082264f);
                instancePath.cubicTo(40.66962f, 37.804626f, 40.90096f, 37.712082f, 41.456177f, 37.89717f);
                instancePath.close();
                instancePath.moveTo(38.21518f, 15.738394f);
                instancePath.cubicTo(35.5689f, 13.138541f, 31.94768f, 12.442152f, 29.115696f, 13.6028f);
                instancePath.cubicTo(28.37288f, 9.888725f, 29.208548f, 6.081798f, 31.854826f, 3.3890936f);
                instancePath.cubicTo(36.311718f, -1.1606485f, 44.1577f, -0.6963891f, 49.40383f, 4.45689f);
                instancePath.cubicTo(54.60354f, 9.610169f, 55.207073f, 17.456154f, 50.750183f, 22.005896f);
                instancePath.cubicTo(48.103905f, 24.745026f, 44.20413f, 25.673544f, 40.3972f, 24.884304f);
                instancePath.cubicTo(41.6507f, 22.05232f, 40.861458f, 18.338245f, 38.21518f, 15.738394f);
                instancePath.close();
                instancePath.moveTo(39.050846f, 26.88062f);
                instancePath.cubicTo(36.218864f, 29.759027f, 31.204865f, 29.48047f, 27.908623f, 26.18423f);
                instancePath.cubicTo(24.565954f, 22.934414f, 24.194548f, 17.920412f, 27.02653f, 15.042005f);
                instancePath.cubicTo(27.630066f, 14.438467f, 28.326456f, 13.974208f, 29.115696f, 13.649226f);
                instancePath.cubicTo(29.672808f, 16.295506f, 31.065586f, 18.848932f, 33.20118f, 20.984524f);
                instancePath.cubicTo(35.290348f, 23.027266f, 37.843773f, 24.37362f, 40.3972f, 24.884304f);
                instancePath.cubicTo(40.07222f, 25.62712f, 39.654385f, 26.277082f, 39.050846f, 26.88062f);
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
