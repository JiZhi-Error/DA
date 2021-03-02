package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sos_question_icon extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-4210753);
                instancePaint4.setStrokeWidth(2.375f);
                instancePaint4.setStrokeCap(Paint.Cap.ROUND);
                instancePaint4.setStrokeJoin(Paint.Join.MITER);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, -1.0f, 0.0f, 32.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(26.966852f, 0.0f);
                instancePath.lineTo(4.337496f, 0.0f);
                instancePath.cubicTo(2.0019212f, 0.0f, 0.0f, 2.0290322f, 0.0f, 4.6548386f);
                instancePath.lineTo(0.0f, 24.467741f);
                instancePath.cubicTo(0.0f, 26.974194f, 1.8907033f, 29.122581f, 4.337496f, 29.122581f);
                instancePath.lineTo(8.230121f, 29.122581f);
                instancePath.lineTo(8.230121f, 36.403225f);
                instancePath.lineTo(16.793894f, 29.122581f);
                instancePath.lineTo(26.966852f, 29.122581f);
                instancePath.cubicTo(29.302427f, 29.122581f, 31.304348f, 27.093548f, 31.304348f, 24.467741f);
                instancePath.lineTo(31.304348f, 4.6548386f);
                instancePath.cubicTo(31.19313f, 2.1483872f, 29.302427f, 0.0f, 26.966852f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-4210753);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(14.599606f, 19.08865f);
                instancePath2.lineTo(17.538462f, 19.08865f);
                instancePath2.lineTo(17.538462f, 22.0f);
                instancePath2.lineTo(14.599606f, 22.0f);
                instancePath2.lineTo(14.599606f, 19.08865f);
                instancePath2.close();
                instancePath2.moveTo(12.962524f, 7.7656145f);
                instancePath2.cubicTo(13.738334f, 7.2552023f, 14.691645f, 7.0f, 15.822485f, 7.0f);
                instancePath2.cubicTo(17.308357f, 7.0f, 18.54273f, 7.362656f, 19.52564f, 8.087978f);
                instancePath2.cubicTo(20.508553f, 8.813301f, 21.0f, 9.887837f, 21.0f, 11.311619f);
                instancePath2.cubicTo(21.0f, 12.184692f, 20.786327f, 12.920077f, 20.358974f, 13.517797f);
                instancePath2.cubicTo(20.109137f, 13.880459f, 19.629194f, 14.343852f, 18.919132f, 14.907992f);
                instancePath2.lineTo(18.218935f, 15.462055f);
                instancePath2.cubicTo(17.837605f, 15.764273f, 17.584484f, 16.116856f, 17.459566f, 16.519812f);
                instancePath2.cubicTo(17.38067f, 16.775019f, 17.337936f, 17.171253f, 17.331362f, 17.708529f);
                instancePath2.lineTo(14.668639f, 17.708529f);
                instancePath2.cubicTo(14.708087f, 16.573534f, 14.81328f, 15.789458f, 14.9842205f, 15.356279f);
                instancePath2.cubicTo(15.155162f, 14.9231f, 15.595657f, 14.424449f, 16.30572f, 13.860309f);
                instancePath2.lineTo(17.02564f, 13.2860985f);
                instancePath2.cubicTo(17.26233f, 13.104768f, 17.452991f, 12.90665f, 17.597633f, 12.691739f);
                instancePath2.cubicTo(17.860619f, 12.322362f, 17.992111f, 11.916054f, 17.992111f, 11.4728f);
                instancePath2.cubicTo(17.992111f, 10.962388f, 17.845827f, 10.497315f, 17.553255f, 10.077569f);
                instancePath2.cubicTo(17.260683f, 9.657822f, 16.7265f, 9.447951f, 15.95069f, 9.447951f);
                instancePath2.cubicTo(15.18803f, 9.447951f, 14.647273f, 9.7065115f, 14.3284025f, 10.22364f);
                instancePath2.cubicTo(14.009532f, 10.740768f, 13.850099f, 11.278036f, 13.850099f, 11.83546f);
                instancePath2.lineTo(11.0f, 11.83546f);
                instancePath2.cubicTo(11.078896f, 9.921414f, 11.733065f, 8.564813f, 12.962524f, 7.7656145f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
