package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sos_emoji_icon extends c {
    private final int height = 42;
    private final int width = 42;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-4737097);
                instancePaint5.setColor(-4737097);
                instancePaint5.setStrokeWidth(0.5f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(19.597933f, 30.307812f);
                instancePath.cubicTo(16.679598f, 30.307812f, 13.962932f, 28.918991f, 12.334599f, 26.680159f);
                instancePath.lineTo(26.861265f, 26.680159f);
                instancePath.cubicTo(25.232931f, 28.918991f, 22.5171f, 30.307812f, 19.597933f, 30.307812f);
                instancePath.moveTo(28.349598f, 25.0f);
                instancePath.lineTo(10.845432f, 25.0f);
                instancePath.cubicTo(10.553765f, 25.0f, 10.282932f, 25.149807f, 10.128765f, 25.393969f);
                instancePath.cubicTo(9.973765f, 25.640612f, 9.9579315f, 25.948503f, 10.085432f, 26.20839f);
                instancePath.cubicTo(11.809599f, 29.719343f, 15.543765f, 31.98797f, 19.597933f, 31.98797f);
                instancePath.cubicTo(23.652931f, 31.98797f, 27.386265f, 29.719343f, 29.109598f, 26.20839f);
                instancePath.cubicTo(29.237932f, 25.947676f, 29.221266f, 25.640612f, 29.066265f, 25.393969f);
                instancePath.cubicTo(28.912098f, 25.149807f, 28.641266f, 25.0f, 28.349598f, 25.0f);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(-4210753);
                instancePaint7.setColor(-4210753);
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint6, looper);
                Paint instancePaint9 = c.instancePaint(instancePaint7, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(19.975f, 38.047897f);
                instancePath2.cubicTo(9.894167f, 38.047897f, 1.6916667f, 29.901197f, 1.6916667f, 19.887285f);
                instancePath2.cubicTo(1.6916667f, 9.87503f, 9.894167f, 1.7291565f, 19.975f, 1.7291565f);
                instancePath2.cubicTo(30.056667f, 1.7291565f, 38.258335f, 9.87503f, 38.258335f, 19.887285f);
                instancePath2.cubicTo(38.258335f, 29.901197f, 30.056667f, 38.047897f, 19.975f, 38.047897f);
                instancePath2.moveTo(19.975f, 0.048997734f);
                instancePath2.cubicTo(8.96f, 0.048997734f, 0.0f, 8.948046f, 0.0f, 19.887285f);
                instancePath2.cubicTo(0.0f, 30.827354f, 8.96f, 39.728058f, 19.975f, 39.728058f);
                instancePath2.cubicTo(30.99f, 39.728058f, 39.95f, 30.827354f, 39.95f, 19.887285f);
                instancePath2.cubicTo(39.95f, 8.948046f, 30.99f, 0.048997734f, 19.975f, 0.048997734f);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint8);
                canvas.drawPath(instancePath2, instancePaint9);
                canvas.restore();
                canvas.save();
                Paint instancePaint10 = c.instancePaint(instancePaint, looper);
                instancePaint10.setColor(-4737097);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(12.383333f, 14.045125f);
                instancePath3.cubicTo(12.845833f, 13.585771f, 13.46f, 13.333333f, 14.113334f, 13.333333f);
                instancePath3.cubicTo(14.766666f, 13.333333f, 15.381667f, 13.585771f, 15.843333f, 14.045125f);
                instancePath3.cubicTo(16.7975f, 14.992801f, 16.7975f, 16.534739f, 15.843333f, 17.482414f);
                instancePath3.cubicTo(14.92f, 18.399467f, 13.308333f, 18.399467f, 12.383333f, 17.482414f);
                instancePath3.cubicTo(11.920834f, 17.022234f, 11.666667f, 16.412245f, 11.666667f, 15.763356f);
                instancePath3.cubicTo(11.666667f, 15.114467f, 11.920834f, 14.504478f, 12.383333f, 14.045125f);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint10);
                canvas.restore();
                canvas.save();
                Paint instancePaint11 = c.instancePaint(instancePaint, looper);
                instancePaint11.setColor(-4737097);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(27.565332f, 17.653965f);
                instancePath4.cubicTo(26.642f, 18.571016f, 25.030333f, 18.571016f, 24.105333f, 17.653965f);
                instancePath4.cubicTo(23.642834f, 17.193783f, 23.388666f, 16.584623f, 23.388666f, 15.934906f);
                instancePath4.cubicTo(23.388666f, 15.286017f, 23.642834f, 14.676028f, 24.105333f, 14.216675f);
                instancePath4.cubicTo(24.568666f, 13.757321f, 25.182833f, 13.504884f, 25.836166f, 13.504884f);
                instancePath4.cubicTo(26.488667f, 13.504884f, 27.103666f, 13.757321f, 27.565332f, 14.216675f);
                instancePath4.cubicTo(28.5195f, 15.1643505f, 28.5195f, 16.70629f, 27.565332f, 17.653965f);
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint11);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
