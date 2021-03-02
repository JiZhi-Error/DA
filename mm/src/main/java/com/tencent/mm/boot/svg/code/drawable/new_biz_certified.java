package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class new_biz_certified extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -120.0f, 0.0f, 1.0f, -426.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 120.0f, 0.0f, 1.0f, 426.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-70474);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(44.0f, 22.271605f);
                instancePath.cubicTo(44.0f, 9.849482f, 34.15052f, 0.0f, 21.728395f, 0.0f);
                instancePath.cubicTo(9.849482f, 0.0f, 0.0f, 9.849482f, 0.0f, 22.271605f);
                instancePath.cubicTo(0.0f, 34.15052f, 9.849482f, 44.0f, 21.728395f, 44.0f);
                instancePath.cubicTo(34.15052f, 44.0f, 44.0f, 34.15052f, 44.0f, 22.271605f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(-36352);
                instancePaint6.setStrokeWidth(3.0f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(42.5f, 22.271605f);
                instancePath2.cubicTo(42.5f, 10.677909f, 33.32209f, 1.5f, 21.728395f, 1.5f);
                instancePath2.cubicTo(10.600406f, 1.5f, 1.5f, 10.756952f, 1.5f, 22.271605f);
                instancePath2.cubicTo(1.5f, 33.32209f, 10.677909f, 42.5f, 21.728395f, 42.5f);
                instancePath2.cubicTo(33.243046f, 42.5f, 42.5f, 33.399593f, 42.5f, 22.271605f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-36352);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(8.37882f, 23.270937f);
                instancePath3.cubicTo(8.197487f, 23.075033f, 8.176818f, 22.736786f, 8.330922f, 22.517902f);
                instancePath3.lineTo(9.380023f, 21.027798f);
                instancePath3.cubicTo(9.534904f, 20.80781f, 9.826069f, 20.761974f, 10.042893f, 20.935448f);
                instancePath3.lineTo(17.207075f, 26.667225f);
                instancePath3.cubicTo(17.418287f, 26.836208f, 17.750328f, 26.833344f, 17.961102f, 26.650051f);
                instancePath3.lineTo(35.820465f, 11.119163f);
                instancePath3.cubicTo(36.02569f, 10.940694f, 36.340633f, 10.949186f, 36.53349f, 11.148006f);
                instancePath3.lineTo(37.460594f, 12.103773f);
                instancePath3.cubicTo(37.649166f, 12.298171f, 37.65095f, 12.610968f, 37.46806f, 12.798857f);
                instancePath3.lineTo(17.922888f, 32.87793f);
                instancePath3.cubicTo(17.738441f, 33.067417f, 17.43909f, 33.059162f, 17.260582f, 32.86631f);
                instancePath3.lineTo(8.37882f, 23.270937f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint7);
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
