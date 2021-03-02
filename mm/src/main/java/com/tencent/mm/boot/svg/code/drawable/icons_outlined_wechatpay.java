package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_wechatpay extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 9.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(30.0f, 0.0f);
                instancePath.cubicTo(46.568542f, 0.0f, 60.0f, 11.404438f, 60.0f, 25.472527f);
                instancePath.cubicTo(60.0f, 39.540615f, 46.568542f, 50.945053f, 30.0f, 50.945053f);
                instancePath.cubicTo(26.61305f, 50.945053f, 23.357191f, 50.468487f, 20.320362f, 49.59002f);
                instancePath.lineTo(11.421126f, 53.8527f);
                instancePath.cubicTo(11.1579275f, 53.97877f, 10.863624f, 54.025394f, 10.574291f, 53.98685f);
                instancePath.cubicTo(9.753134f, 53.877464f, 9.176225f, 53.123825f, 9.285729f, 52.303555f);
                instancePath.lineTo(10.302671f, 44.68589f);
                instancePath.cubicTo(3.989763f, 40.01606f, 0.0f, 33.139908f, 0.0f, 25.472527f);
                instancePath.cubicTo(0.0f, 11.404438f, 13.4314575f, 0.0f, 30.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(30.0f, 3.6f);
                instancePath.cubicTo(15.301022f, 3.6f, 3.6f, 13.535152f, 3.6f, 25.472527f);
                instancePath.cubicTo(3.6f, 31.746346f, 6.8269978f, 37.636932f, 12.443596f, 41.791683f);
                instancePath.lineTo(14.152247f, 43.05562f);
                instancePath.lineTo(13.368248f, 48.928364f);
                instancePath.lineTo(20.002657f, 45.750523f);
                instancePath.lineTo(21.320723f, 46.1318f);
                instancePath.cubicTo(24.084929f, 46.931404f, 27.006273f, 47.34505f, 30.0f, 47.34505f);
                instancePath.cubicTo(44.69898f, 47.34505f, 56.4f, 37.4099f, 56.4f, 25.472527f);
                instancePath.cubicTo(56.4f, 21.823044f, 55.306374f, 18.360697f, 53.3678f, 15.31216f);
                instancePath.lineTo(22.040222f, 34.05198f);
                instancePath.lineTo(21.820826f, 34.18168f);
                instancePath.cubicTo(21.549904f, 34.319855f, 21.24491f, 34.401234f, 20.921633f, 34.401234f);
                instancePath.cubicTo(20.171196f, 34.401234f, 19.518824f, 33.979923f, 19.176432f, 33.357704f);
                instancePath.lineTo(19.045958f, 33.06609f);
                instancePath.lineTo(13.583479f, 20.840412f);
                instancePath.cubicTo(13.524474f, 20.707321f, 13.487908f, 20.556429f, 13.487908f, 20.409775f);
                instancePath.cubicTo(13.487908f, 19.846895f, 13.935843f, 19.390827f, 14.4876585f, 19.390827f);
                instancePath.cubicTo(14.713704f, 19.390827f, 14.918973f, 19.466274f, 15.086844f, 19.59343f);
                instancePath.lineTo(21.531622f, 24.27364f);
                instancePath.cubicTo(22.001163f, 24.587292f, 22.565445f, 24.772093f, 23.170448f, 24.772093f);
                instancePath.cubicTo(23.530293f, 24.772093f, 23.875177f, 24.704277f, 24.19513f, 24.58475f);
                instancePath.lineTo(51.22305f, 12.4838505f);
                instancePath.cubicTo(46.433304f, 7.118606f, 38.747524f, 3.6f, 30.0f, 3.6f);
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
