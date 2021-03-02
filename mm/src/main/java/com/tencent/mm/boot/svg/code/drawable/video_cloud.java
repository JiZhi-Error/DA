package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class video_cloud extends c {
    private final int height = 12;
    private final int width = 12;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 12;
            case 1:
                return 12;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -159.0f, 0.0f, 1.0f, -226.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 80.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 32.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 1.0f, 0.0f, 159.0f, 0.0f, 1.0f, 114.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(12.0f, 0.0f);
                instancePath.lineTo(12.0f, 12.0f);
                instancePath.lineTo(0.0f, 12.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-2130706433);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(6.339408f, 10.0f);
                instancePath2.lineTo(6.339408f, 6.0954685f);
                instancePath2.lineTo(7.52f, 7.30973f);
                instancePath2.lineTo(8.0f, 6.816041f);
                instancePath2.lineTo(6.4f, 5.1704106f);
                instancePath2.cubicTo(6.179086f, 4.9431963f, 5.820914f, 4.9431963f, 5.6f, 5.1704106f);
                instancePath2.lineTo(4.0f, 6.816041f);
                instancePath2.lineTo(4.48f, 7.30973f);
                instancePath2.lineTo(5.6605854f, 6.0954757f);
                instancePath2.lineTo(5.6605854f, 10.0f);
                instancePath2.lineTo(2.6666667f, 10.0f);
                instancePath2.cubicTo(1.1939074f, 10.0f, 0.0f, 8.806092f, 0.0f, 7.3333335f);
                instancePath2.cubicTo(0.0f, 5.860574f, 1.1939074f, 4.6666665f, 2.6666667f, 4.6666665f);
                instancePath2.cubicTo(2.6889026f, 4.6666665f, 2.7110748f, 4.666939f, 2.7331805f, 4.66748f);
                instancePath2.cubicTo(3.041713f, 3.1455812f, 4.387074f, 2.0f, 6.0f, 2.0f);
                instancePath2.cubicTo(7.840949f, 2.0f, 9.333333f, 3.4923842f, 9.333333f, 5.3333335f);
                instancePath2.cubicTo(9.333333f, 5.3412204f, 9.333306f, 5.3491006f, 9.333251f, 5.3569746f);
                instancePath2.cubicTo(9.442145f, 5.341395f, 9.553465f, 5.3333335f, 9.666667f, 5.3333335f);
                instancePath2.cubicTo(10.955331f, 5.3333335f, 12.0f, 6.378002f, 12.0f, 7.6666665f);
                instancePath2.cubicTo(12.0f, 8.955331f, 10.955331f, 10.0f, 9.666667f, 10.0f);
                instancePath2.lineTo(6.339408f, 10.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
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
