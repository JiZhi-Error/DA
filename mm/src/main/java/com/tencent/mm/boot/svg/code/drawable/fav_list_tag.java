package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fav_list_tag extends c {
    private final int height = 15;
    private final int width = 15;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 15;
            case 1:
                return 15;
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
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-4868683);
                instancePaint4.setStrokeWidth(0.95454544f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.193269f, 0.4773343f);
                instancePath.lineTo(13.193239f, 0.4773343f);
                instancePath.lineTo(8.75f, 0.4773343f);
                instancePath.cubicTo(8.665613f, 0.4773343f, 8.584682f, 0.5108569f, 8.525011f, 0.57052755f);
                instancePath.lineTo(0.57046604f, 8.525073f);
                instancePath.cubicTo(0.4462083f, 8.649331f, 0.4462083f, 8.850792f, 0.57046705f, 8.975051f);
                instancePath.lineTo(5.0136914f, 13.4183035f);
                instancePath.cubicTo(5.13795f, 13.542562f, 5.3394117f, 13.54256f, 5.4636736f, 13.418298f);
                instancePath.lineTo(13.417828f, 5.463724f);
                instancePath.cubicTo(13.477489f, 5.40406f, 13.511009f, 5.3231416f, 13.511016f, 5.2387595f);
                instancePath.lineTo(13.511421f, 0.7954792f);
                instancePath.cubicTo(13.511435f, 0.61975574f, 13.369009f, 0.47732326f, 13.193269f, 0.4773343f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-4868683);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(10.181818f, 2.8181818f);
                instancePath2.cubicTo(10.734103f, 2.8181818f, 11.181818f, 3.265897f, 11.181818f, 3.8181818f);
                instancePath2.cubicTo(11.181818f, 4.3704667f, 10.734103f, 4.818182f, 10.181818f, 4.818182f);
                instancePath2.cubicTo(9.629533f, 4.818182f, 9.181818f, 4.3704667f, 9.181818f, 3.8181818f);
                instancePath2.cubicTo(9.181818f, 3.265897f, 9.629533f, 2.8181818f, 10.181818f, 2.8181818f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
