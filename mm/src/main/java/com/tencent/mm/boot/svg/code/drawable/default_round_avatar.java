package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class default_round_avatar extends c {
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -24.0f, 0.0f, 1.0f, -91.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 91.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1184275);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(16.0f, 0.0f);
                instancePath.cubicTo(24.836555f, -1.623249E-15f, 32.0f, 7.163444f, 32.0f, 16.0f);
                instancePath.cubicTo(32.0f, 24.836555f, 24.836555f, 32.0f, 16.0f, 32.0f);
                instancePath.cubicTo(7.163444f, 32.0f, 1.082166E-15f, 24.836555f, 0.0f, 16.0f);
                instancePath.cubicTo(-1.082166E-15f, 7.163444f, 7.163444f, 1.623249E-15f, 16.0f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(637534208);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 5.6f, 0.0f, 1.0f, 5.6f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(2.1666667f, 17.933332f);
                instancePath2.lineTo(2.1666667f, 16.740068f);
                instancePath2.lineTo(2.1666667f, 16.740068f);
                instancePath2.cubicTo(2.1666667f, 16.146324f, 2.5983975f, 15.45432f, 3.132218f, 15.193822f);
                instancePath2.lineTo(8.037857f, 12.799924f);
                instancePath2.cubicTo(8.749327f, 12.452735f, 8.914758f, 11.683761f, 8.400986f, 11.0748205f);
                instancePath2.lineTo(8.087658f, 10.703453f);
                instancePath2.cubicTo(7.450142f, 9.947847f, 6.9333334f, 8.53623f, 6.9333334f, 7.548052f);
                instancePath2.lineTo(6.9333334f, 6.066303f);
                instancePath2.cubicTo(6.9333334f, 4.1519165f, 8.489308f, 2.6f, 10.4f, 2.6f);
                instancePath2.cubicTo(12.314587f, 2.6f, 13.866667f, 4.1539164f, 13.866667f, 6.0668464f);
                instancePath2.lineTo(13.866667f, 7.5488276f);
                instancePath2.cubicTo(13.866667f, 8.5360565f, 13.347475f, 9.951813f, 12.712342f, 10.704697f);
                instancePath2.lineTo(12.399014f, 11.076115f);
                instancePath2.cubicTo(11.888095f, 11.681757f, 12.047696f, 12.452611f, 12.762142f, 12.801109f);
                instancePath2.lineTo(17.667782f, 15.194016f);
                instancePath2.cubicTo(18.201042f, 15.454133f, 18.633333f, 16.141813f, 18.633333f, 16.740068f);
                instancePath2.lineTo(18.633333f, 17.933332f);
                instancePath2.cubicTo(18.633333f, 18.080608f, 18.513943f, 18.2f, 18.366667f, 18.2f);
                instancePath2.lineTo(2.4333334f, 18.2f);
                instancePath2.cubicTo(2.2860575f, 18.2f, 2.1666667f, 18.080608f, 2.1666667f, 17.933332f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
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
