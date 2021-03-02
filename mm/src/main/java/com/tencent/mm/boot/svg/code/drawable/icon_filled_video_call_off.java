package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_filled_video_call_off extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, -1.0f, 0.0f, 24.0f, 0.0f, -1.0f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(24.0f, 0.0f);
                instancePath.lineTo(24.0f, 24.0f);
                instancePath.lineTo(0.0f, 24.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.restore();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(2.575379f, 2.4540584f);
                instancePath2.lineTo(19.545942f, 19.424622f);
                instancePath2.lineTo(18.485281f, 20.485281f);
                instancePath2.lineTo(1.5147187f, 3.5147185f);
                instancePath2.lineTo(2.575379f, 2.4540584f);
                instancePath2.close();
                instancePath2.moveTo(2.053839f, 6.1754637f);
                instancePath2.lineTo(14.378f, 18.499058f);
                instancePath2.lineTo(3.0f, 18.5f);
                instancePath2.cubicTo(2.4477153f, 18.5f, 2.0f, 18.052284f, 2.0f, 17.5f);
                instancePath2.lineTo(2.0f, 6.5f);
                instancePath2.cubicTo(2.0f, 6.3864017f, 2.0189416f, 6.2772274f, 2.053839f, 6.1754637f);
                instancePath2.close();
                instancePath2.moveTo(22.780869f, 7.4559298f);
                instancePath2.cubicTo(22.92272f, 7.633243f, 23.0f, 7.8535533f, 23.0f, 8.080625f);
                instancePath2.lineTo(23.0f, 15.919375f);
                instancePath2.cubicTo(23.0f, 16.47166f, 22.552284f, 16.919374f, 22.0f, 16.919374f);
                instancePath2.cubicTo(21.772928f, 16.919374f, 21.552618f, 16.842094f, 21.375305f, 16.700245f);
                instancePath2.lineTo(18.0f, 14.0f);
                instancePath2.lineTo(18.0f, 10.0f);
                instancePath2.lineTo(21.375305f, 7.299756f);
                instancePath2.cubicTo(21.806566f, 6.9547467f, 22.43586f, 7.0246677f, 22.780869f, 7.4559298f);
                instancePath2.close();
                instancePath2.moveTo(5.619f, 5.4990582f);
                instancePath2.lineTo(16.0f, 5.5f);
                instancePath2.cubicTo(16.552284f, 5.5f, 17.0f, 5.9477153f, 17.0f, 6.5f);
                instancePath2.lineTo(17.0f, 16.879059f);
                instancePath2.lineTo(5.619f, 5.4990582f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
